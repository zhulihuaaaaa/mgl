/**
 * 余额查询
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
					makerId: '',
					customerId: '',
					createUser: '',
					startCreateDate: '',
					endCreateDate: ''
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
				GoodsSource: {},
				InOrNotStock:{},
				crmClients:{},
				BusinessType: {}
			},
			// 表格数据
			tableData: {},
			tableConfig: {
				loading: false,
				columns: ['index', 'custom']
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
				ajax.findPage('/balance', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
			},
			getBusinessType (options) {
				if (options) {
					for (option of options) {
						this.options.BusinessType[option.value] = option.label
					}
				}
			},
			detail (row) {
				showSlide(row)
			}
		},
		mounted () {
			var vm = this
			util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start', '.daterange-end'],  // 绑定Input选择器
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
				ajax.detail('/balance', {
					
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
							tabData: [],
							tableConfig: {
								loading: false,
								columns: ['index','operation']
							},
							operation:[
								
							]
						},
						methods: {
							fetchData (index) {
								let vm = this
								if (index > 0) {
									switch (index) {
										case 1:
											vm.loading = true
											ajax.findOne('/balance',vm.model.balanceId).then(function (res) {
												if (res.data) {
													vm.$set(vm.tabData, index, res.data)
												}
												vm.loading = false
											}, function () {
												vm.loading = false
											})
											break;
									}
								}
							},
							// 退款申请提交按钮
							showsumbitBtn(row){
								//console.log(row)
								let vm = this
								ajax.get('/balance/update',{"id":row.balanceDetailId}).then((result) => {
									// TODO 处理提交之后的事件
									vm.fetchData(1)
								})
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




