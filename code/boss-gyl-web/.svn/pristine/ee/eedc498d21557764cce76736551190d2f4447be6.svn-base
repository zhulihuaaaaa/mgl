/**
 * 财务及报表
 * 
 * @author 汪玮琦
 * @since 2017.12.18
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
					// 财务单号
					financeCode: null,
					contractCode: null,
					relationCode: null,
					status: null,
					operator: null,
					startOperatorDate: null,
					endOperatorDate: null,
					// 资金流向
					flwoType: null,
					startCreateDate: null,
					endCreateDate: null
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
				ajax.findPage('/finance', vm.searchParam).then(function (res) {
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
			}
		},
		mounted () {
			var vm = this
			util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start', '.daterange-end'],  // 绑定Input选择器
		    })
		    util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start1', '.daterange-end1'],  // 绑定Input选择器
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
	
	$(".btn-export").click(function () {
		ajax.exportExcel('/finance', page.searchParam)
	})
	
	/**
	 * 显示侧边栏
	 */
	function showSlide(data) {
		// 初始化detail组件
		if (detail == null) {
			require(['component-slide', 'util'], function (componentSlide, util) {
				/*
				 * 通过ajax加载页面 首次载入加载静态前端，后续不再加载加载静态前端
				 */
				var slide = "#slideEidt"
				$(slide).html("<div class='rota-load'><i class='icon-jiazai icon-pulse'></i></div>")
				ajax.detail('/finance', {
					financeBillId: data.financeBillId
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
									let detailParam = {
										dto: {
											contractId: this.model.contract.contractId
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
								}
							},
							/**
							 * 编辑
							 */
							comfirmBill (financeBill) {
								let financeBillId = this.model.financeBillId
								let comfirmDialog
								util.dialog({
									width: 400,
									height: 120,
									fixed: true,
									skin: 'crm-form crm-form-over',
									title: financeBill.flwoType == 'A' ? '确认到账' : '确认出账',
									content: `
										<form id="dialog-content">
											<template>
												<div class="ui-row">
													<div class="ui-form-group ui-col">
														<label class="ui-label-control ui-col-30">确认金额(元)</label>
														<div class="ui-col-70">
															 <el-input-number size="small" v-model="data.actualAmount" controls-position="right" :min="1"></el-input-number>
														</div>
													</div>
												</div>
												<div class="ui-row">
													<div class="ui-form-group ui-col">
														<label class="ui-label-control ui-col-30">备注</label>
														<div class="ui-col-70">
															<textarea class="ui-input-control ui-height-auto sele-info-txt"
																rows="2" v-model="data.notes" name="notes">
															</textarea>
														</div>
													</div>
												</div>
											</template>
										</form>
									`,
									okValue: '确定',
									ok: function() {
										comfirmDialog.data.flwoType = detail.model.flwoType
										// 禁用提交按钮
										util.setLoading({
											selector: '[i-id="ok"]'
										})
										ajax.update('/finance', comfirmDialog.data).then(function (result) {
											page.fetchData()
											if (result.state === 1) {
												detail.model.status = result.data.status
												detail.model.actualAmount = result.data.actualAmount
												detail.model.notes = result.data.notes
												detail.model.operator = result.data['operator']
												detail.model.operatorDate = result.data['operatorDate']
											}
										}, function () {
											// 使提交按钮可用
											util.setLoading({
												selector: '[i-id="ok"]',
												isClick: false
											})
										})
									},
									cancelValue: '取消',
									onshow: function() {
										comfirmDialog = new Vue({
											el: '#dialog-content',
											data () {
												return {
													data: $.extend(true, {}, financeBill)
												}
											},
											mounted () {
												this.data.actualAmount = financeBill.realMoney
											}
										})
									}
								})
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