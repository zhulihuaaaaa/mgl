/**
 * 开票费设置
 * 
 * @author 倪凯
 * @since 2017.12.15
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	// VUE初始化页面
	// 侧边详情Vue组件
	var detail = null;
	var dialog = null
	// 主页面Vue组件
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					//手续费
					costType: 'B',
					// 客户
					customerId: ''
				},
				// 页码
				pageNum: 0,
				// 分页大小
				pageSize: 20,
				// 排序
				orderByClause: ''
			},
			// 下拉选项列表
			options: {
				BusinessType: []
			},
			// 表格数据
			tableData: {},
			tableConfig: {
				loading: false,
				columns: ['operation', 'custom']
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
				ajax.findPage('/baseCosts', vm.searchParam).then(function (res) {
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
			detail (row) {
				showSlide(row)
			},
			del (row) {
				var vm = this
				ajax.delete('/baseCosts', row.costId).then(function (result) {
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
	 * 新增或编辑品类
	 * 
	 * @param type
	 *            操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			id: 'baseCostDialog',
			width: 600,
			height: 250,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建开票费' : '编辑开票费',
			content: `
				<form id="baseCostDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">客户</label>
								<div class="ui-col-60">
								    <component-select
								    v-model="data.customerId"
								    name="customerId"
								    type="crmClients"
								    :search="true"
								    ${type === 0 ? ':remoteseach="true"' : ':isdisabled="true"'}>
                                	</component-select>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">开票费</label>
								<div class="ui-col-60">
									<input type="text" v-model="data.amount" class="ui-input-control" name="amount" placeholder="请输入开票费" style="width:80%;display:inline" value="${type === 0 ? '' : data.amount}"><span>元/吨</span>
								</div>
							</div>
						</div>
					</div>
				</form>
				`,
				okValue: type === 0 ? '保存': '更新',
				ok: function () {
					if ($('#baseCostDialog').valid()) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						if (type === 0) {
							ajax.save('/baseCosts', dialog.data).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'baseCostDialog'})
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
							var newValue = $.extend({costId: data.costId}, dialog.data)
							ajax.update('/baseCosts', newValue).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'baseCostDialog'})
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
					baseCostValid()
					dialog = new Vue({
						el: '#baseCostDialog',
						data: {
							data: type === 1 ? data : {
								customerId: '',
								amount: '',
							}
						},
					   components: {
						   componentTable: componentTable
					   }
					})
				}
		})
	}
	// ---------------
	// 品类 - 表单验证
	// ---------------
	function baseCostValid () {
		util.formValid({
			selector: '#baseCostDialog',
			onkeyup: false,
			rules: {
				'customerId': {
					required: true
				},
				'amount': {
					required: true,
					// 整数
					min: 0,
					maxlength: 8,
					// 整数
					digits: true
				}
			},
			messages: {
				'customerId': {
					required: '请输入客户信息'
				},
				'amount': {
					required: '请输入开票费数值',
					min: '精确度最小为0',
					maxlength: '最多8位数字',
					// 整数
					digits: '精确度须为整数'
				}
			}
		})
	}
	/**
	 * 显示侧边栏
	 */
	function showSlide(data) {
		// 初始化detail组件
		if (detail == null) {
			require(['component-slide'], function (componentSlide) {
				/*
				 * 通过ajax加载页面 首次载入加载静态前端，后续不再加载加载静态前端
				 */
				var slide = "#slideEidt"
				$(slide).html("<div class='rota-load'><i class='icon-jiazai icon-pulse'></i></div>")
				ajax.detail('/baseCosts', {
					costId: data.costId
				}).then(function (result) {
					var result = $(result).find(".slide-cnt")
					$(slide).html(result)
					detail = new Vue({
						el: slide,
						data: {
							// 选中行数据
							model: data,
							show: true,
							loading: false,
							activeIndex: 0,
							// 选项卡页面数据
							tabData: []
						},
						methods: {
							/**
							 * 获取对应索引的tab数据
							 */
							fetchData (index) {
								let vm = this
								if (index > 0) {
									vm.loading = true
									switch (index) {
										case 1:
											// TODO 根据Tab索引查询数据
											setTimeout(function () {
												vm.tabData[index] = {
														test: '测试TAB'
												}
												vm.loading = false
											}, 3000)
											break
										case 2:
											// TODO 根据Tab索引查询数据
											setTimeout(function () {
												vm.tabData[index] = {
														test: '测试TAB2'
												}
												vm.loading = false
											}, 3000)
											break
											
									}
								}
							},
							/**
							 * 编辑
							 */
							edit () {
								addOrEdit(1, this.model)
							}
						},
						components: {
							componentSlide: componentSlide
						}
					})
				})
			})
		} else {
			detail.model = data
			detail.show = true
		}
	}
})




