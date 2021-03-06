/**
 * 逾期申请审核
 * @author zlh
 * @since 2017.12.08
 */

require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	//Vue初始化
	var detail = null;
	var addOrEditVue = null;
	var selectContractVue = null;
	//首页vue
	var page = new Vue({
		el: '.main-content',
		data: {
			util:util,
			// 搜索条件
			searchParam: {
				dto: {
					contractId:'',
					overdueDays:'',
					deferDays:'',
					commissionRate:'',
					auditStatus:'',
					createStartDate:'',
					createEndDate:''
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
				ApprovalState:[]
			},
			// 表格数据
			tableData: {},
			tableConfig: {
				loading: false,
				columns: ['index', 'custom']
			}
		},
		computed: {
			approvalStateMap () {
				var map = {}
				this.options.ApprovalState.forEach(function (item) {
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
				ajax.post('/overdueApply/findDeferPage', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					// if (detail && detail.show) {
					// 	for (var item of vm.tableData.list) {
					// 		if (item.instockBillId === detail.model.instockBillId) {
					// 			showSlide(item)
					// 			break
					// 		}
					// 	}
					// }
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
			},
			add () {
				addOrEdit(0)
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
		    ajax.getOptions(['ApprovalState']).then((result) => {
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
		console.log(data)
		// 初始化detail组件
		if (detail == null) {
			require(['component-slide'], function (componentSlide) {
			/*
			 * 通过ajax加载页面 首次载入加载静态前端，后续不再加载加载静态前端
			 */
			var slide = "#slideEidt"
			$(slide).html("<div class='rota-load'><i class='icon-jiazai icon-pulse'></i></div>")
			ajax.detail('/overdueApply', {
			}).then(function (result) {
				var result = $(result).find(".slide-cnt")
				$(slide).html(result)
				detail = new Vue({
					el: slide,
					data: {
						overdueDeferId:data.overdueDeferId,
						util: util,
						// 选中行数据
						model: data,
						show: true,
						loading: false,
						activeIndex: 0,
						// 选项卡页面数据
						tabData: [{
							info:[]
						}],
						// 下拉选项列表
						options: {
							BusinessType: []
						},
					},
					computed: {
						contractId(){
							return this.model.contractId
						},
						businessTypeMap () {
							var map = {}
							this.options.BusinessType.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
					},
					methods: {
//						// 通过 D 或者 拒绝 C
						isPassOrNotPass(status){
							let vm = this
							if(status != 'C'){
								applyOverdueDialog(vm.model,status)
							}
							else{
								vm.model.auditStatus = status		
							}
//							if(status == 'commissionRate'){
//								applyOverdueDialog(vm.model)
//							}
//							else{
//								ajax.post("/overdueApply/update",{overdueDeferId:vm.model.overdueDeferId,auditStatus:status}).then(function (result) {
//									if(result.state == 1){
//										vm.model.auditStatus = status		
//										if(status == 'D'){
//											applyOverdueDialog(vm.model)
//										}
//									}
//								})
//							}
						},
						/**
						 * 获取对应索引的tab数据
						 */
						fetchData (index) { 
							let vm = this
								vm.loading = true
								switch(index){
									case 0:
										let detailParam = {
												dto: {
													contractId: vm.contractId
												},
												pageNum: 0,
												pageSize: 20
										}
										vm.$set(vm.tabData, index, {info:{}})
										ajax.findOne('/contract',vm.contractId).then(function (res) {
											vm.tabData[index].info = res.data
											vm.contractState = res.data.contractState
											vm.loading = false
										}, function () {
											vm.loading = false
										})
										break
								}
						}
					},
					mounted () {
						this.fetchData (0)
						var vm = this
						util.swiperTab({
							change: function (index) {
								if (!vm.tabData[index]) {
									vm.fetchData(index)
								}
								vm.activeIndex = index
							}
						}),
						 ajax.getOptions(['BusinessType']).then((result) => {
					    	vm.options = result.data
					    })
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
	
	/*
	 * 审核，填写手续费对话框
	 */
	function applyOverdueDialog(data,status){
		var tableContent
		util.dialog({
			id: 'applyOverdueDialog',
			width: 400,
			height: 180,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title:'修改手续费率',
			content: `<form id="remit-dialog-content">
					<template>
						<div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-100">
												<label class="ui-label-control ui-col ui-col-40">手续费率</label>
												<div class="ui-col ui-col-40 ui-label-txt">
												<div class="ui-row">
													<el-input :min="0" :controls="false" v-model="applyData.commissionRate" name="deferDays"></el-input>
												</div>
												</div>
											</div>
										</div>
						</div>
					</template>
					</form>`,
					okValue: '确定',
					ok: function () {
								if ($('#remit-dialog-content').valid()) {
									ajax.update('/overdueApply', tableContent.applyData).then((result) => {
										//result.data.
										detail.fetchData(0)
										page.fetchData();
										if(result.state == 1){
											detail.model.auditStatus = status		
										}
										util.promptMsg({
											content: result.message
										})
									})
								} else {
									return false
								}
					
					},
					cancelValue: '取消',
					onshow: function () {
						if (tableContent == null) {
							tableContent = new Vue({
								el: '#remit-dialog-content',
								data () {
									return {
										isFirstedit:true,
										applyData:{
											commissionRate:'',
											overdueDeferId:data.overdueDeferId,
											contractId:data.contractId,
											deferDays:data.deferDays,
											auditStatus:status
										}
									}
								},
								methods: {
								},
								mounted () {
									// 添加表单验证
									this.$nextTick(function() {
										applyRemitValid()
									})
								}
							})
						}
					}
			})
		}
	
	//---------------
	// 打款申请 - 表单验证
	//---------------
	function applyRemitValid () {
		util.formValid({
			selector: '#remit-dialog-content',
			onkeyup: false,
			rules: {
				'deferDays': {
					number:true,
					required: true,
					maxlength: 1000
				}
			},
			messages: {
				'deferDays': {
					number: "请输入合法的数字",
					required: '请输入延期天数',
					maxlength: '输入超出限制'
				}
			}
		})
	}
})

