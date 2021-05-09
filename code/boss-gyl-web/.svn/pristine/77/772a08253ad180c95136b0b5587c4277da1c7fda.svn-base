/**
 * 品类设置
 * @author 张渊
 * @since 2017.12.08
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	// VUE初始化页面
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					// 品类名称
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
				columns: ['index', 'operation', 'custom']
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
				ajax.findAll('/baseMargin', vm.searchParam).then(function (res) {
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
				ajax.delete('/baseMargin', row.marginId).then(function (result) {
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
	 * 新增或编辑保证金
	 * @param type 操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			id: 'baseMarginDialog',
			width: 600,
			height: 250,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建保证金' : '编辑保证金',
			content: `
				<form id="baseMarginDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">保证金比例</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" name="proportion" placeholder="请输入保证金比例" style="width:80%;display:inline" value="${type === 0 ? '' : data.proportion*100}"><span>%</span>
								</div>
							</div>
						</div>
					</div>
				</form>
				`,
				okValue: type === 0 ? '保存': '更新',
				ok: function () {
					if ($('#baseMarginDialog').valid()) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						if (type === 0) {
							ajax.save('/baseMargin', $('#baseMarginDialog').serializeObject()).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'baseMarginDialog'})
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
							var newValue = $.extend({marginId: data.marginId}, $('#baseMarginDialog').serializeObject())
							ajax.update('/baseMargin', newValue).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'baseMarginDialog'})
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
					baseMarginValid()
				}
		})
	}
	//---------------
	// 保证金 - 表单验证
	//---------------
	function baseMarginValid () {
		util.formValid({
			selector: '#baseMarginDialog',
			onkeyup: false,
			rules: {
				'proportion': {
					required: true,
					// 整数
					digits: true,
					min: 1,
					max: 100,
					maxlength: 3
				}
			},
			messages: {
				'proportion': {
					required: '请输入保证金比例',
					// 整数
					digits: '精确度须为整数',
					min: '精确度为1-100',
					max: '精确度为1-100',
					maxlength: '最多3位数字'
				}
			}
		})
	}
})




