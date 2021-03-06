/**
 * 表面设置
 * 
 * @author 倪凯
 * @since 2017.12.12
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	// VUE初始化页面
	var detail = null;
	var dialog = null
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					// 表面名称
					processName: '',
					createUser: '',
					createDate: ''
				}
			},
			// 下拉选项列表
			options: {
				BusinessType: []
			},
			// 表格数据
			tableData: [],
			tableConfig: {
				loading: false,
				columns: ['index', 'operation', 'custom']
			}
		},
		computed: {
			businessTypeMap () {
				var map = {}
				this.options.BusinessType.forEach(function (item) {
					map[item[0]] = item[1]
				})
				return map
			}
		},
		methods: {
			/**
			 * 后台检索数据
			 */
			fetchData (pageConfig) {
				let vm = this
				if (pageConfig) {
					vm.searchParam.pageNum = pageConfig.pageNum
					vm.searchParam.pageSize = pageConfig.pageSize
					vm.searchParam.orderByClause = pageConfig.orderByClause
				}
				vm.tableConfig.loading = true
				ajax.findAll('/baseProcess', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
			},
			add () {
				addOrEdit(0)
			},
			edit (row) {
				addOrEdit(1, row)
			},
			del (row) {
				var vm = this
				ajax.delete('/baseProcess', row.processId).then(function (result) {
					vm.fetchData()
				}, function () {
					vm.fetchData()
				})
			},
			detail (row) {
				// ajax侧滑加载编辑页面
				var slideDetailUrl = ctx + "/clientManage/clientDetailView";
				/*
				 * 通过ajax加载页面 首次载入加载静态前端，后续不再加载加载静态前端 clientDataliSwitch ： true
				 */
				if ($('#slide-eidt').length == 0) {
					$("body").append("<div id='slide-eidt'><div class='rota-load'><i class='icon-jiazai icon-pulse'></i></div></div>");
					$.ajax({
				          url: slideDetailUrl,
				          type: "POST",
				          data: {clientId: clientData.clientId},
				          success: function(data){
				              var result = $(data).find(".slide-cnt");
				              $("#slide-eidt").html(result);// 提前载入静态前端代码
//				              $("#clientName").text(clientData.clientName);
//				              $("#userName").text(clientData.userName);
//				              $("#clientSource").text(clientData.clientSource);
//				              $("#clientLevel").text(clientData.clientLevel);
//				              $("#clientId").val(clientData.clientId);
				              
				              $(".slideTxtBox").slide({
				                  trigger: "click",
				                  delayTime: 0,
				                  titOnClassName: "active"
				              });
				          }
				      });
				  }
				  
				  $("#slide-eidt").animate({
				      right: 0
				  }, 300);

				  // 点击停止冒泡，隐藏侧边页面
				  $(".main-content, .ui-header , .slide-close").one("click", function(event) {
				      if($(event.target).closest(".ui-table").length == 0){
				          slideClear();
				      }
				  });
			}
		},
		mounted () {
			var vm = this
			util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start', '.daterange-end'],  // 绑定Input选择器
		    })
		    ajax.getOptions(['FeeType', 'BusinessType']).then((result) => {
		    	vm.options = result.data
		    })
		},
		components: {
			componentTable: componentTable
		}
	})
	// 筛选条件显示切换
	$(".btn-opt-screen").click(function() {
	    $(".search-criter").slideToggle(300);
	    $(this).toggleClass("active");
	});
	
	/**
	 * 新增或编辑表面
	 * 
	 * @param type
	 *            操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			id: 'baseProcessDialog',
			width: 600,
			height: 250,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建表面' : '编辑表面',
			content: `
				<form id="baseProcessDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">表面名称</label>
								<div class="ui-col-60">
									<input type="text" v-model="data.processName" class="ui-input-control" name="processName" placeholder="请输入表面名称" value="${type === 0 ? '' : data.processName}">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">状态</label>
								<div class="ui-col-60">
									<el-checkbox v-model="data.status" class="ui-checkbox" true-label="Y" false-label="N">
								</div>
							</div>
						</div>
					</div>
				</form>
				`,
				okValue: type === 0 ? '保存': '更新',
				ok: function () {
					if ($('#baseProcessDialog').valid()) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						if (type === 0) {
							ajax.save('/baseProcess', dialog.data).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'baseProcessDialog'})
								if (result.state === 1) {
									page.fetchData()
								}
							}, function () {
								// 使提交按钮可用
								util.setLoading({
									selector: '[i-id="ok"]',
									isClick: false
								})
							})
						} else {
							var newValue = $.extend({processId: data.processId}, dialog.data)
							ajax.update('/baseProcess', newValue).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'baseProcessDialog'})
								if (result.state === 1) {
									page.fetchData()
								}
							}, function () {
								// 使提交按钮可用
								util.setLoading({
									selector: '[i-id="ok"]',
									isClick: false
								})
							})
						}
					}
					return false
				},
				cancelValue: '取消',
				onshow: function () {
					dialog = new Vue({
						el: '#baseProcessDialog',
						data: {
							data: type === 1 ? data : {
								processName: '',
								status: 'Y'
							}
						},
						mounted () {
							// 添加表单验证
							baseProcessValid()
						}
					})
				}
		})
	}
	// ---------------
	// 表面 - 表单验证
	// ---------------
	function baseProcessValid () {
		util.formValid({
			selector: '#baseProcessDialog',
			onkeyup: false,
			rules: {
				'processName': {
					required: true,
					maxlength: 10
				}
			},
			messages: {
				'processName': {
					required: '请输入表面名称',
					maxlength: '表面名称最多10个字'
				}
			}
		})
	}
	
	function slideClear() {
		// 关闭隐藏侧边页
		$("#slide-eidt").animate({
			right: -1010
		}, 300);
	}
})




