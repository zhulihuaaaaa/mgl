/**
 * 保证金
 * @param ajax
 * @param componentTable
 * @param util
 * @returns
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	// VUE初始化页面
	// 侧边详情Vue组件
	var detail = null;
	// 主页面Vue组件
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					// 业务类型
					businessType: null,
					// 客户信息
					buyerId: null,
					// 关联合同信息
					contractId: null,
					// 关联财务单
					financeId: null
				},
				// 页码
				pageNum: 0,
				// 分页大小
				pageSize: 20,
				// 排序
				orderByClause: ''
			},
			// 表格数据
			tableData: {},
			tableConfig: {
				loading: false,
				columns: ['custom']
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
				ajax.findPage('/deposit', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
			},
			detail (row) {
				showSlide(row)
			}
		},
		mounted () {},
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
	 * 显示侧边栏
	 */
	function showSlide(data) {
		// 初始化detail组件
			require(['component-slide'], function (componentSlide) {
				/*
				 * 通过ajax加载页面 首次载入加载静态前端，后续不再加载加载静态前端
				 */
				var slide = "#slideEidt"
				$(slide).html("<div class='rota-load'><i class='icon-jiazai icon-pulse'></i></div>")
				ajax.detail('/deposit', {
					depositAccountId: data.depositAccountId
				}).then(function (result) {
					var result = $(result).find(".slide-cnt")
					$(slide).html(result)
					detail = new Vue({
						el: slide,
						data: {
							hiddenFee: true,
							util: util,
							// 选中行数据
							model: data,
							show: true,
							loading: false,
							activeIndex: 0,
							// 选项卡页面数据
							tabData: []
						},
						methods: {
							fetchData (index) {
								let vm = this
								if (index > 0) {
									switch (index) {
										case 1:
											vm.loading = true
											let page = {
												dto: {
													depositAccountId: vm.model.depositAccountId
												},
												// 页码
												pageNum: 0,
												// 分页大小
												pageSize: 0
											}
											ajax.post('/deposit/findAllDepositDetails', page).then(function (res) {
												if (res.data) {
													vm.$set(vm.tabData, index, res.data)
												}
												vm.loading = false
											}, function () {
												vm.loading = false
											})
											break
										case 2: 
											vm.loading = true
											ajax.findOne('/contract', this.model.contract.contractId).then(function (res) {
												if (res.data) {
													vm.$set(vm.tabData, index, res.data)
													if ( res.contractType === 'X' || res.contractType === 'D') {
														vm.hiddenFee = false
													} else {
														vm.hiddenFee = true
													}
												}
												vm.loading = false
											}, function () {
												vm.loading = false
											})
											break;
									}
								}
							}
						},
						components: {
							componentSlide: componentSlide,
							componentTable: componentTable
						}
					})
				})
			})
	}
	
})