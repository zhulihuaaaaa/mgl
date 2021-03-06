/**
 * 甲方设置
 * @author 倪凯
 * @since 2018.1.25
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	// VUE初始化页面
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					// 产品名称
					productName: '',
					createUser: '',
					startCreateDate: '',
					endCreateDate: '',
					businessType: ''
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
				columns: ['operation', 'custom']
			}
		},
		methods: {
			/**
			 * 后台检索数据
			 */
			fetchData (pageConfig) {
				let vm = this
				if (pageConfig) {
					vm.searchParam.orderByClause = pageConfig.orderByClause
				}
				vm.tableConfig.loading = true
				ajax.findAll('/baseCompany', vm.searchParam).then(function (res) {
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
				ajax.delete('/baseCompany', row.companyId).then(function (result) {
					vm.fetchData()
				}, function () {
					vm.fetchData()
				})
			}
		},
		mounted () {
			var vm = this
			util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start', '.daterange-end'],  //绑定Input选择器
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
	 * 新增或编辑品类
	 * @param type 操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			id: 'baseCompanyDialog',
			width: 600,
			height: 250,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建甲方' : '编辑甲方',
			content: `
				<form id="baseCompanyDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">甲方名称</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" name="companyName" placeholder="请输入甲方名称" style="width:80%;display:inline" v-model="data.companyName" value="${type === 0 ? '' : data.companyName}">
								</div>
							</div>
						</div>
					</div>
				</form>
				`,
				okValue: type === 0 ? '保存': '更新',
				ok: function () {
					if ($('#baseCompanyDialog').valid()) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						if (type === 0) {
							ajax.save('/baseCompany', $('#baseCompanyDialog').serializeObject()).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'baseCompanyDialog'})
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
							var newValue = $.extend({companyId: data.companyId}, $('#baseCompanyDialog').serializeObject())
							ajax.update('/baseCompany', newValue).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'baseCompanyDialog'})
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
					// 添加表单验证
					baseCompanyValid()
				}
		})
	}
	//---------------
	// 品类 - 表单验证
	//---------------
	function baseCompanyValid () {
		util.formValid({
			selector: '#baseCompanyDialog',
			onkeyup: false,
			rules: {
				'companyName': {
					required: true,
					maxlength: 30
				}
			},
			messages: {
				'companyName': {
					required: '请输入甲方名称',
					maxlength: '甲方名称最多10个字'
				}
			}
		})
	}
})




