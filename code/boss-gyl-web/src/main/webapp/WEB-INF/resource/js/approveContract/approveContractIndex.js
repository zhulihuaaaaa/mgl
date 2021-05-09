/**
 * 审批合同管理
 */
require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	// VUE初始化页面
	var detail = null;
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					contractType: null,
					sellerId: null,
					contractState: null,
					startSignDate:null,
					endSignDate:null,
					startCreateDate:null,
					endCreateDate:null,
					contractId:null
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
			},
			contractBillType: [],
			contractBillState: [],
			util: util
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
				ajax.findPage('/approveContract', vm.searchParam).then(function (res) {
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
		mounted () {
			let vm = this
			util.datePicker({
				 dateRange: true,
				  selector: ['.daterange-start', '.daterange-end'] //绑定Input选择器
		    })
		    util.datePicker({
				 dateRange: true,
				  selector: ['.daterange-start1', '.daterange-end1'] //绑定Input选择器
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
	
	$(".btn-add").click(function () {
		addOrEdit(0)
	})
	
	$(".btn-export").click(function () {
		ajax.exportExcel('/contract', page.searchParam)
	})
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
				ajax.detail('/approveContract', {
					contractId: data.contractId
				}).then(function (result) {
					var result = $(result).find(".slide-cnt")
					$(slide).html(result)
					detail = new Vue({
						el: slide,
						data: {
							util: util,
							// 选中行数据
							model: data,
							show: true,
							loading: false,
							activeIndex: 0,
							// 审批进程
							flow: null,
							// 选项卡页面数据
							tabData: []
						},
						watch:{
							flow:{  
				                handler:function(val,oldval){
				                	if(val.state&&val.state=='D'){
				                		// page.fetchData()
				                	}
				                },
				                deep:true
				            },
						},
						computed: {
							'hiddenFee': function () {
								if (this.model.contractType === 'X' || this.model.contractType === 'D') {
									return false
								} else {
									return true
								}
							}
						},
						methods: {
							/**
							 * 结束合同
							 */
							overContract(){
								console.log(this.model)
								// 结束
								let vm = this
								ajax.get('/contract/overContract', {'contractId': vm.model.contractId}).then(function (res) {
									page.fetchData()
									detail.fetchData()
								}, function () {
								})
							},
							/**
							 * 获取对应索引的tab数据
							 */
							fetchData (index) {
								let vm = this
								if (index > 0) {
									vm.loading = true
									switch (index) {
										case 1:
										var detailParam = {
											dto: {
												contractId: this.model.contractId
											},
											pageNum: 0,
											pageSize: 0
										}
										ajax.post('/contract/findAllContractDetails', detailParam).then(function (res) {
											if (res.data) {
												vm.$set(vm.tabData, index, res.data)
											}
											vm.loading = false
										}, function () {
											vm.loading = false
										})
										break
										case 2:
											var detailParam = {
												dto: {
													contractId: this.model.contractId
												},
												pageNum: 0,
												pageSize: 0
											}
											ajax.post('/contract/findAllPaymentDetails', detailParam).then(function(res) {
												if (res.data) {
													vm.$set(vm.tabData, index, res.data)
												}
												vm.loading = false
											}, function () {
												vm.loading = false
											})
											break
										case 3:
											var detailParam = {
												dto: {
													contractId: this.model.contractId
												},
												pageNum: 0,
												pageSize: 0
											}
											ajax.post('/contract/findAllDepositDetails', detailParam).then(function(res) {
												if (res.data) {
													vm.$set(vm.tabData, index, res.data)
												}
												vm.loading = false
											}, function () {
												vm.loading = false
											})
											break
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
		} else {
			detail.model = data
			detail.show = true
		}
	}
})




