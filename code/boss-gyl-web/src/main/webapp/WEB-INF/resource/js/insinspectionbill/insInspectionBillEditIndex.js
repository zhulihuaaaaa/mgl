/**
 * 审核设置
 * @author 杨思静
 * @since 2017.12.08
 */
require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	// 侧边详情Vue组件
	var detail = null;
	// VUE初始化页面
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					// 业务类型
					businessType:'',
					// 子单单号
					subCode:'',
					// 创建人
					createUser:'',
					// 创建时间
					maxDate:'',
					minDate:''
				},
				// 页码
				pageNum: 0,
				// 分页大小
				pageSize: 20,
				// 排序
				orderByClause: ''
			},
			// 业务类型
			//业务类型
			options: {
				BusinessType: []
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
				ajax.findPage('/settleEdit', vm.searchParam).then(function (res) {
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
			util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start', '.daterange-end'],  //绑定Input选择器
		    })
		    let vm = this
	     	ajax.getOptions(['BusinessType']).then((result) => {
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
	 * 显示侧边栏
	 */
	function showSlide(data) {
		// 初始化detail组件
		if (detail == null) {
			require(['component-slide','util'], function (componentSlide,util) {
				/*
				 * 通过ajax加载页面 首次载入加载静态前端，后续不再加载加载静态前端
				 */
				var slide = "#slideEidt"
				$(slide).html("<div class='rota-load'><i class='icon-jiazai icon-pulse'></i></div>")
				ajax.detail('/settleEdit', {
					productId: data.insInspectionSub.inspectionSubId
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
							tabData: [],
							// 表格数据
							tableData: [],
							productData: [],
							contract: {},
							util: util,
							tableConfig: {
								loading: false,
								columns: ['selection', 'index','operation']
							}
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
											this.fetchDataByProduct()
											break
										case 2:
											this.findOneCon()
											break
											
									}
								}
							},
							fetchDataByProduct () {
								let vm = this
								 vm.tableConfig.loading = true
								ajax.post('/settle/settleListdetail',{ id : data.insInspectionSub.inspectionSubId}).then(function (res) {
									vm.productData = res.data
									vm.tableConfig.loading = false
									vm.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
								
							},
							findOneCon(){
								let vm =this
								let contractId =data.conContract.contractId
								ajax.findOne('/contract', contractId).then(function (res) {
									vm.contract = res.data
									vm.loading = false
								}, function () {
								})
							},
							passOrNotPass(status){
								let vm = this
								let one ={
									businessType:data.conContract.contractType,
									id: data.insInspectionSub.inspectionSubId,
									auditStatus: status
								}
								ajax.post('/settleEdit/updatePassOrNoPass',one).then(function (res) {
//									vm.productData = res.data
									vm.tableConfig.loading = false
									vm.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
							},
							edit(row){
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
			// 切换之后  重新获取列表
//			detail.fetchDataByEdit()
			detail.fetchDataByProduct()
		}
	}
})




