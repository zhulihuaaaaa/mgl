/**
 * 赎货单设置
 * @author zlh
 * @since 2017.12.08
 */
/** ********************************************主页列表********************************************* */
require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	// Vue初始化页面
	var detailVue = null;
	var addOrEditVue = null;
	var selectGoodsVue = null;
	var editRedInfoVue = null;
	// 赎货单主页
	var page = new Vue({
		el: '.main-content',
		data: {
			util: util,
			// 搜索条件
			searchParam: {
				dto: {
					goodsSource:'',
					createUser: '',
					startCreateDate: '',
					endCreateDate: '',
					buyerId:'',
					contractId:''
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
				GoodsSource: [],
				ApprovalState:[],
				RedeemBillState: []
			},
			// 表格数据
			tableData: [],
			tableConfig: {
				loading: false,
				columns: ['index', 'custom']
			}
		},
		computed: {
			goodsSourceMap () {
				var map = {}
				this.options.GoodsSource.forEach(function (item) {
					map[item[0]] = item[1]
				})
				return map
			},
			approvalStateMap () {
				var map = {}
				this.options.ApprovalState.forEach(function (item) {
					map[item[0]] = item[1]
				})
				return map
			},
			redeemBillState () {
				var map = {}
				this.options.RedeemBillState.forEach(function (item) {
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
				ajax.findPage('/redRedeemBill', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					if (detailVue && detailVue.show) {
						for (var item of vm.tableData.list) {
							if (item.redeemBillId === detailVue.model.redeemBillId) {
								showSlide(item)
								break
							}
						}
					}
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
		    ajax.getOptions(['GoodsSource','ApprovalState', 'RedeemBillState']).then((result) => {
		    	vm.options = result.data
		    })
		},
		components: {
			componentTable: componentTable
		}
})
	
/** ***************************************点击************************************* */
	
	// 筛选条件显示切换
	$(".btn-opt-screen").click(function() {
	    $(".search-criter").slideToggle(300);
	    $(this).toggleClass("active");
	});
	
	$(".btn-export").click(function () {
		ajax.exportExcel('/redRedeemBill', page.searchParam)
	})
	
/** ***************************************新建/货物明细编辑----赎货单************************************* */
 
/**
 * 新建/货物明细编辑
 * 
 * @param type
 * 操作类型（0:新增|1:编辑主单|2:编辑货物）
 */
	function addOrEdit (type, data) {
		var content
		if (type === 0) {
			content = `
				<div id="addOrEditDialog">
					<template>
						${mainHTML}
						${detailHTML}
						${financeHTML}
					</template>
				</div>
			`
		} else if (type === 1) {
			content = `
				<div id="addOrEditDialog">
					<template>
						${mainHTML}
					</template>
				</div>
			`
		} else if (type === 2) {
			content = `
				<div id="addOrEditDialog">
					<template>
						${detailHTML}
						${financeHTML}
					</template>
				</div>
			`
		}
		require(['computed-fee'], function (computedFee) {
			util.dialog({
				id: 'redRedeemBillDialog',
				width: 1230,
				height: type === 1 ? 300 : 500,
				fixed: true,
				skin: 'crm-form crm-form-over',
				title: type === 0 ? '新建赎货单' : '编辑赎货单',
				content: content,
					okValue: '确定',
					ok: function () {
						var valid = true
						if ($('#RedInfoEdit').length > 0) {
							 $('#RedInfoEdit').valid() ? valid = true : valid = false
						}
						if (valid) {
							let entity = addOrEditVue.entity
							let detail = $.extend(true, [], addOrEditVue.tableData)
							if (entity != null && detail != null) {
								if ((type === 0 || type === 2) && detail.length === 0) {
									util.promptMsg({
										type: 'tip',
										modal: false,
										content: '请选择货物'
									})
									return false
								}
								// 禁用提交按钮
								util.setLoading({
									selector: '[i-id="ok"]'
								})
								ajax[type === 0 ? 'save' : 'update']('/redRedeemBill', {'entity': entity, 'detail': type !== 1 ? detail : null}).then(function (result) {
									util.dialog({getIdClose: 'redRedeemBillDialog'})
									if (detailVue && detailVue.show) {
										detailVue.fetchData(1)
									}
									page.fetchData()
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
						addOrEditVue = new Vue({
							el:"#addOrEditDialog",
							data: {
								type: type,
								util: util,
								// 是否显示费用计算
								showFinance:true,
								// 货物明细识别属性
								showForSlide:true,
								// 选择货物识别属性
								showForSelectGoods:false,
								// 保证金-是否为最后一批货
								lastGoods:false,
								//是否使用保证金
								useDepositFee: false,
								// 是否显示可选数量
								showAmount:true,
								// 最大保证金变量
								maxDepositFee: 0,
								canEdit:true,
								tableConfig: {
									loading: false,
									columns: ['operation'],
									operation: ['delete']
								},
								// 表格数据
								tableData: [],
								entity:{
									contractId:'',
									storageId:'',
									buyerId:'',
									goodsSource:'',
									consignee:'',
									consigneeTel:'',
									consigneeIdNo:'',
									carNumber:'',
									// 总重量
									totalWeight:'',
									chargingDays:0,
									// 其他费用
									otherFee:0,
									// 手续费
									commissionFee:0,
									// 开票费
									invoiceFee:0,
									// 总货款
									totalGoodsPayment:0,
									// 保证金抵消金额
									depositFee:0,
									// 总金额
									totalMoney:'',
									// 代付总金额
									realMoney:''
								},
								model: null
							},
							computed: {
								// 禁用选择货物中合同和仓库
								disabled () {
									return this.tableData && this.tableData.length > 0
								}
							},
							watch: {
								'entity.buyerId': function (val, old) {
									if ((old != null && old !== '') || (val == null || val === '')) {
										this.entity.contractId = ''
										this.entity.storageId = ''
									}
								},
								'entity.goodsSource': function (val, old){
									if (this.entity.goodsSource === 'C') {
										this.showFinance = false
									} else {
										this.showFinance = true
									}
								},
								'useDepositFee': function (val, old){
									if(!this.useDepositFee){
										this.entity.depositFee = 0
									} else if (this.entity.depositFee === 0 && this.entity.depositFee > this.maxDepositFee) {
										this.entity.depositFee = this.maxDepositFee
									}
									this.reComputed()
								},
								'entity.depositFee': function (val, old) {
									if (this.useDepositFee)
										this.reComputed()
								},
								'tableData': {
									handler: function (newVal, oldVal) {
										var vm = this
										vm.$nextTick(function () {
											for(var one of vm.tableData){
												if (Math.floor(one.amount) !== one.amount) {
													vm.$set(one, 'amount', Math.floor(one.amount))
												}
											}
										})
									},
									deep: true
								}
							},
							methods: {
								selectGoods(){
									var vm = this
									if(type == 0&&(vm.entity.buyerId==='' || vm.entity.goodsSource==='')){
										util.promptMsg({
											content:"请选择赎货客户和货物来源"
										})
									} else {
										if (type == 2) {
											selectGoods(this.entity.buyerId,this.entity.goodsSource)																					
										} else {
											selectGoods(this.entity.buyerId ? this.entity.buyerId : this.entity.redRedeemBill.buyerId,
											this.entity.goodsSource ? this.entity.goodsSource : this.entity.redRedeemBill.goodsSource)																						
										}
									}
								},
								handleSelectGoods (goodsList) {
									goodsList = $.extend(true, [], goodsList)
									// 添加实际数量
									for(var item of goodsList){
										var alreadyExist = false
										if (this.tableData && this.tableData.length > 0) {
											for (var goods of this.tableData) {
												if (item.inventoryId === goods.inventoryId) {
													this.$set(item, 'amount', goods.amount)
													alreadyExist = true
													break
												}
											}
										}
										if (!alreadyExist) {
											this.$set(item, 'amount', 1)
										}
										this.$set(item, 'storageDate', item.instockDate)
									}
									this.reComputed(goodsList)
								},
								/**
								 * 重新计算
								 */
								reComputed (goodsList) {
									var vm = this
									vm.$nextTick(function () {
										
										goodsList = goodsList ? goodsList : vm.tableData
										if (!goodsList || goodsList == 0) {
											return
										}
										// 判断是否为最后一批货
										var amounts = true;
										if (goodsList && goodsList.length > 0) {
											for(var item of goodsList){
												if(item.enableNum !== item.amount){
													amounts = false
												}
											}
											if(amounts){
												// 排除全部删除货物情况
												if(goodsList.length > 0){
													ajax.post('/redRedeemBill/isLastGoods', {entity: vm.entity, detail: goodsList}).then(function (res) {
														if(res.data !== -1){
															vm.lastGoods = true
															vm.useDepositFee = true
															vm.maxDepositFee = res.data
															vm.entity.depositFee = res.data
														} else {
															vm.lastGoods = false
														}
														vm.computedFee(goodsList)
													}, function () {
														vm.lastGoods = false
														vm.computedFee(goodsList)
													})
												}
											} else {
												vm.lastGoods = false
												vm.computedFee(goodsList)
											}
										}
										
									})
								},
								computedFee (goodsList) {
									var vm = this
									// 服务费值创建
									for(var item of goodsList){
										vm.$set(item,"commissionFee",0)
									}
									var needFee = this.entity.goodsSource !== 'C'
									// 计算费用
									var res = computedFee.computedFee(goodsList, 
											vm.entity.contractId,
											vm.entity.depositFee,
											needFee,
											vm.lastGoods)
									res.then(function (result) {
										vm.tableData = result.list
										vm.entity.totalWeight = result.totalWeight
										vm.entity.invoiceFee = result.totalInvoiceFee
										// 手续费
										vm.entity.commissionFee = result.totalServiceFee
										// 最大保证金变量
										vm.maxDepositFee = result.depositFee
										// 当保证金勾选，刷新值
										if(vm.useDepositFee){
											!vm.lastGoods && vm.entity.depositFee > result.depositFee ? vm.entity.depositFee = result.depositFee : null
										}
										vm.entity.totalGoodsPayment = result.totalGoodsPayment
										vm.entity.totalMoney = result.totalMoney
										// 待付总金额
										vm.entity.realMoney = result.realMoney
									})
								},
								handleDelete (row) {
									for (var i = 0; i < this.tableData.length; i++) {
										if (this.tableData[i] === row) {
											this.tableData.splice(i, 1)
											this.reComputed()
										}
									}
								}
						   },
						   mounted () {
							   	// 添加表单验证
							   var vm = this
							   this.$nextTick(function() {
								   instockaddValid()
							   })
							   if (type === 1) {
								   // 编辑主单信息
								   this.entity = $.extend(true, {}, data.model)
							   } else if (type === 2) {
								   if (data.detail != null && data.detail.length > 0) {
									   var detail = $.extend(true, [], data.detail)
									   this.entity = $.extend(true, {}, data.model)
									   vm.tableConfig.loading = true
									   var promises = []
									   for (let item of detail) {
										   promises.push(new Promise(function (resolve, reject) {
											   ajax.findOne('/stock', item.inventoryId).then(function (res) {
												   $.extend(item, res.data)
												   item.enableNum += item.amount
												   resolve()
											   }, function () {
												   reject()
											   })
										   }))
									   }
									   Promise.all(promises).then(function () {
										   vm.entity = $.extend(true, {}, data.model)
										   vm.tableData = detail
										   vm.$nextTick(function () {
											   if (data.model.depositFee && data.model.depositFee > 0) {
												   vm.maxDepositFee = data.model.depositFee
												   // 编辑货物信息
												   vm.entity.depositFee = data.model.depositFee
												   vm.useDepositFee = true
											   }
										   })
										   vm.tableConfig.loading = false
									   }, function () {
										   vm.tableConfig.loading = false
									   })
								   }
							   }
						   },
						   components: {
							   componentTable: componentTable
						   }
						})
					}
			})
		})
	}

	
	/** ********************************新建-----选择货物**************************************** */
	
	/**
	 * 选择货物
	 */
	function selectGoods (buyerId, goodsSource) {
		util.dialog({
			width: 1000,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '选择货物',
			content: `
				<div id="selectgoods">
				  <div class="ui-row">
				    <div class="ui-col">
				      <div class="ui-form-group ui-col-30">
				        <label class="ui-label-control ui-col ui-col-30">合同自编号</label>
				        <div class="ui-col ui-col-70 ui-label-txt">
				          <component-select v-model="contractId" type="contractCode" @change="fetchData" :search="true" :param="{buyerId: buyerId, goodsSource: goodsSource}"
				            :remoteseach="true" name="contractCode" :isdisabled="disabled">
				          </component-select>
				        </div>
				      </div>
				      <div class="ui-form-group ui-col-30">
				        <label class="ui-label-control ui-col ui-col-25">仓库</label>
				        <div class="ui-col ui-col-70 ui-label-txt">
				          <component-select v-model="storageId" @change="fetchData" type="DictMallDepot" depot="${goodsSource === 'A' ? 'virtual' : 'real'}"
				            name="dictMallDepotId" :isdisabled="disabled">
				          </component-select>
				        </div>
				      </div>
				    </div>
				  </div>
				  <div class="ui-col">
				    <div class="main-cnt-scroll">
				      <component-table :data="tableData" :height="400" row-key="inventoryId" :select-data="selectData" :columns="tableConfig.columns"
				        :loading="tableConfig.loading" @selection-change="handleSelectionChange" :selectable="selectable">
				        ${goodsHTML}
				      </component-table>
				    </div>
				  </div>
				</div>
				`,
				okValue: '确定',
				ok: function () {
					// list返回上一个对话框
					// 合同信息
					let all = addOrEditVue
					let entity = addOrEditVue.entity
					entity.contractId = selectGoodsVue.contractId
					entity.storageId = selectGoodsVue.storageId
					// 设置可供重量 redWeight
					/*
					 * for(item of newVueEdit.selectData){
					 * this.$set(item.invInventory,"redWeight",0) }
					 */
					addOrEditVue.handleSelectGoods(selectGoodsVue.selectData)
				},
				cancelValue: '取消',
				onshow: function () {
					var tableData = addOrEditVue.tableData
					var selectData = []
					if (tableData != null && tableData.length > 0) {
						tableData.forEach(function (item) {
							selectData.push({inventoryId: item.inventoryId})
						})
					}
					selectGoodsVue = new Vue({
						el:"#selectgoods",
						data: {
							util: util,
							buyerId: buyerId,
							goodsSource:goodsSource,
							// 货物明细识别属性
							showForSlide:true,
							// 选择货物识别属性
							showForSelectGoods:true,
							// 是否显示可选数量
							showAmount:false,
							// 数量是否可输入
							canEdit:false,
							contractId: addOrEditVue.entity.contractId,
							storageId: addOrEditVue.entity.storageId,
							// 表格数据
							tableData: [],
							contract:{},
							tableConfig: {
								loading: false,
								columns: ['selection']
							},
							// 禁用选择合同和仓库
							disabled: tableData != null && tableData.length > 0,
							selectData: $.extend([], selectData)
						},
						methods: {
							/**
							 * 后台检索数据
							 */
							fetchData () {
								let vm = this
								if(vm.contractId != null && vm.contractId != ''){
									// 查询是否逾期
									vm.tableConfig.loading = true
									let searchParam = {
											dto: {
												contractId: vm.contractId
											},
											// 页码
											pageNum: 0,	
											// 分页大小
											pageSize: 20,
											// 排序
											orderByClause: ''
										}
									ajax.findPage('/overdue', searchParam).then(function (res) {
										if(res.data&&res.data.list&&res.data.list[0]){
											util.promptMsg({
												type: 'tip',
												modal: false,
												content: '您选择的合同已逾期,请申请延期后再进行操作'
											})
											vm.contractId = null
										}else{
											if(vm.contractId != null && vm.contractId != ''
												&& vm.storageId != null && vm.storageId != ''){
												vm.tableConfig.loading = true
												// 查合同
												ajax.findOne('/contract',vm.contractId).then(function (res) {
													vm.contract = res.data
													// 查库存
													ajax.get('/redRedeemBill/getStorageList',{"contractId":vm.contractId,"storageId":vm.storageId,"goodsSource":vm.goodsSource}).then(function (res2) {
														var list = res2.data
														var tableData = []
														for (var row of list) {
															var item = $.extend(true, row, row.invInventory)
															delete item.invInventory
															item['goodsVolume'] = item.volume
															tableData.push(item)
														}
														vm.$set(vm, 'tableData', tableData)
														vm.tableConfig.loading = false
													}, function () {
														vm.tableConfig.loading = false
													})
												}, function () {
													vm.tableConfig.loading = false
												})
											} else {
												vm.$set(vm, 'tableData', [])
											}
										}
										vm.tableConfig.loading = false
									}, function () {
										vm.tableConfig.loading = false
									})
								}
								
								
								
							},
							handleSelectionChange (selectData) {
								this.selectData = selectData
							},
							selectable (row, index) {
								for (var item of selectData) {
									if (item.inventoryId === row.inventoryId) {
										return false
									}
								}
								return true
							}
					   },
					   mounted(){
							this.fetchData()
					   },
					   components: {
						   componentTable: componentTable
					   }
					})
				}
// }
		})
		
	}

/** ************************侧滑栏**************************************** */
	/**
	 * 显示侧边栏
	 */
	function showSlide(data) {
		// 初始化detail组件
		if (detailVue == null) {
			require(['component-slide'], function (componentSlide) {
			/*
			 * 通过ajax加载页面 首次载入加载静态前端，后续不再加载加载静态前端
			 */
			var slide = "#slideEidt"
			$(slide).html("<div class='rota-load'><i class='icon-jiazai icon-pulse'></i></div>")
			ajax.detail('/redRedeemBill', {
				/* productId: data.productId */
			}).then(function (result) {
				var result = $(result).find(".slide-cnt")
				$(result).find('.detail-table').html(goodsHTML)
				$(slide).html(result)
				detailVue = new Vue({
					el: slide,
					data: {
						util:util,
						lastGoods:false,
						// 选择货物识别属性
						showForSelectGoods:false,
						showForSlide:false,
						useDepositFee: false,
						// 是否显示可选数量
						showAmount:true,
						// 最大保证金变量
						maxDepositFee: 0,
						canEdit:false,
						// 选中行数据
						model: data,
						show: true,
						loading: false,
						activeIndex: 0,
						// 选项卡页面数据
						tabData: [],
						// 下拉选项列表
						options: {
							GoodsSource: [],
							InOrNotStock:[],
							ApprovalState:[],
							RedeemBillState:[]
						}
					},
					methods: {
						/**
						 * 编辑基本信息
						 */
						editInfo () {
							var data = {
								model: detailVue.model,
								detail: this.tabData[1]
							}
							addOrEdit(1, data)
						},
						delInfo() {
							let vm = this
							ajax.delete('/redRedeemBill', this.model.redeemBillId).then(function (result) {
								if (result.state === 1) {
									page.fetchData()
								}
							})
							return false
						},
						/**
						 * 新增或编辑货物明细
						 */
						add () {
							addOrEditRedDetailNew(0)
						},
						edit () {
							var data = {
								model: detailVue.model,
								detail: this.tabData[1]
							}
							addOrEdit(2, data)
						},
						/**
						 * 获取对应索引的tab数据
						 */
						fetchData (index) {
							let vm = this
							if(index == 1){
								vm.loading = true
								ajax.findOne('/redRedeemBill',vm.model.redeemBillId).then(function (res) {
									if (res.data) {
										vm.$set(vm.tabData, index, res.data)
									}
									else{
										vm.tabData[index]=[]
									}
									vm.loading = false
								}, function () {
									vm.loading = false
								})
							}
						},
						/**
						 * 提交
						 */
						handleSubmit () {
							var vm = this
							// 禁用提交按钮
							util.setLoading({
								selector: '.el-button, a-edit'
							})
							ajax.get('/redRedeemBill/submit', {id: this.model.redeemBillId}).then(function (res) {
								vm.model.auditStatus = 'B'
								page.fetchData()
								// 禁用提交按钮
								util.setLoading({
									selector: '.el-button, a-edit',
									isClick: false
								})
							}, function () {
								// 禁用提交按钮
								util.setLoading({
									selector: '.el-button, a-edit',
									isClick: false
								})
							})
						}
					},
					computed: {
						auditStatus () {
							if (this.model != null && this.model.auditStatus) {
								switch (this.model.auditStatus) {
									case 'A':
										return '未审批'
									case 'B':
										return '审批中'
									case 'C':
										return '已拒绝'
									case 'D':
										return '已通过'
									}
							} else {
								return '未提交'
							}
						},
						redeemBillState () {
							var map = {}
							this.options.RedeemBillState.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						goodsSourceMap () {
							var map = {}
							this.options.GoodsSource.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						inOrNotStockMap () {
							var map = {}
							this.options.InOrNotStock.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						approvalStateMap () {
							var map = {}
							this.options.ApprovalState.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						redeemBillId () {
							return this.model.redeemBillId
						},
						contractId(){
							return this.model.contractId
						}
					},
					mounted () {
						var vm = this
						 ajax.getOptions(['GoodsSource','InOrNotStock','ApprovalState', 'RedeemBillState']).then((result) => {
						    	vm.options = result.data
					    })
						/*
						 * util.swiperTab({ change: function (index) { if
						 * (!vm.tabData[index]) { vm.fetchData(index) }
						 * vm.activeIndex = index } })
						 */
					},
					components: {
						componentSlide: componentSlide,
						componentTable: componentTable
					}
				})
			})
			})
		} else {
			detailVue.model = data
			detailVue.show = true
		}
}
	
/** ************************表单验证*************************************** */	
	
	// ---------------
	// 新建---保存赎货单表单验证
	// ---------------
	function instockaddValid () {
		util.formValid({
			selector: '#RedInfoEdit',
			onkeyup: false,
			rules: {
				'consignee': {
					required: true
				},
				'consigneeTel': {
					required: true,
					minlength: 11,
					maxlength: 11
				},
				'consigneeIdNo':{
					required: true,
					idcard: true
				},
				'carNumber':{
					required: true,
					minlength: 7,
					maxlength: 7
				}
			},
			messages: {
				'consignee': {
					required: '请输入提货人姓名'
				},
				'consigneeTel': {
					required: '请输入提货人电话',
					minlength:'请输入有效电话',
					maxlength:'请输入有效电话'
				},
				'consigneeIdNo':{
					required: '请输入提货人身份证号码'
				},
				'carNumber':{
					required: '请输入车牌号',
					minlength:'请输入正确的车牌号',
					maxlength:'请输入正确的车牌号'
				},
				'goods':{
					required: '请选择货物'
				}
				/*
				 * 'buyerName': { required: '请选择赎货客户' }, 'goodsSource':{
				 * required: '请选择货物来源' }, 'goods':{ required: '请选择货物' },
				 * 'consignee':{ required: '请填写提货人' }, 'totalWeight':{ required:
				 * '请选择总重量' }, 'chargingDays':{ required:'请填写计费天数' },
				 * 'commissionFee':{ required:'请填写手续费' }, 'invoiceFee':{
				 * required:'请填写开票费' }, 'totalGoodsPayment':{ required:'请填写货款' },
				 * 'otherFee':{ required:'请填写其他费用' }, 'depositFee':{
				 * required:'请填写保证金抵消金额' }, 'totalMoney':{ required:'请填写总金额' }
				 */
			}
		})
	}
	
	/** 编辑弹出主表HTML* */
	var mainHTML = `<h5 class="bg-tit">基本信息</h5>
	    <form id="RedInfoEdit">
	    <div class="ui-row">
	        <div class="ui-col">
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-30 required-txt">赎货客户</label>
	                <div class="ui-col-60">
	                    <component-select v-model="entity.buyerId" type="crmClients" :isdisabled="type !== 0 || (tableData != null && tableData.length > 0)">
	                    </component-select>
	                </div>
	            </div>
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-30 required-txt">货物来源</label>
	                <div class="ui-col-60">
	                    <component-select v-model="entity.goodsSource" type="GoodsSource" :isdisabled="type !== 0 || (tableData != null && tableData.length > 0)">
	                    </component-select>
	                </div>
	            </div>
	        </div>
	        <div class="ui-col">
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-30 required-txt">提货人</label>
	                <div class="ui-col-60">
	                    <input type="text" class="ui-input-control" v-model="entity.consignee" placeholder="请输入提货人姓名" name="consignee">
	                </div>
	            </div>
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-30 required-txt">提货人电话</label>
	                <div class="ui-col-60">
	                    <input type="text" class="ui-input-control" v-model="entity.consigneeTel" placeholder="请输入提货人电话" name="consigneeTel">
	                </div>
	            </div>
	        </div>
	        <div class="ui-col">
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-30 required-txt">提货人身份证号</label>
	                <div class="ui-col-60">
	                    <input type="text" class="ui-input-control" v-model="entity.consigneeIdNo" placeholder="请输入提货人身份证号" name="consigneeIdNo">
	                </div>
	            </div>
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-30 required-txt">车牌号</label>
	                <div class="ui-col-60">
	                    <input type="text" class="ui-input-control" v-model="entity.carNumber" placeholder="请输入车牌号" name="carNumber">
	                </div>
	            </div>
	        </div>
	    </div>
	</form>`
	
/**************************货物*******************************/
		
		var goodsHTML = `<el-table-column label="品类" width="120" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.baseProduct.productName}}
            </template>
        </el-table-column>
         <el-table-column label="材质" width="150" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.materialId}}
            </template>
        </el-table-column>
        <el-table-column label="表面" width="120" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.surfaceId}}
            </template>
        </el-table-column>
        <el-table-column v-if="showForSlide" label="可供数量" width="160" show-overflow-tooltip>
            <template slot-scope="scope">
                <template v-if="scope.row.baseProduct != null">
                    {{scope.row.enableNum == null? 0 : scope.row.enableNum+ scope.row.baseProduct.quantityUnit}}
                </template>
                <template v-else>
                    {{scope.row.enableNum == null? 0 : scope.row.enableNum}}
                </template>
            </template>
        </el-table-column>
        <el-table-column v-if="showForSlide" label="可供重量" width="130" show-overflow-tooltip>
            <template slot-scope="scope">
                <template v-if="scope.row.baseProduct != null">
                    {{util.formatNumber(scope.row.counterpoise * scope.row.enableNum / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}}
                    {{scope.row.baseProduct.weightUnit}}
                </template>
                <template v-else>
                    {{scope.row.counterpoise * scope.row.enableNum}}
                </template>
            </template>
        </el-table-column>
        <el-table-column v-if="showAmount" label="数量" width="160" show-overflow-tooltip>
            <template slot-scope="scope">
                <template v-if="canEdit">
                    <el-input-number size="small" v-model="scope.row.amount" controls-position="right" :max="scope.row.enableNum"
                        :min="1" @change="reComputed()"></el-input-number>
                </template>
                <template v-else>
                    {{scope.row.amount == null? 0:scope.row.amount }} {{scope.row.baseProduct.quantityUnit}}
                </template>
            </template>
        </el-table-column>
        <el-table-column v-if="!showForSelectGoods" label="重量" width="100" show-overflow-tooltip>
            <template slot-scope="scope">
                <template v-if="scope.row.baseProduct != null && scope.row.redWeight != null">
                    {{util.formatNumber(scope.row.redWeight / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}}
                    {{scope.row.baseProduct.weightUnit}}
                </template>
                <template v-else>
                    {{util.formatNumber(scope.row.redWeight / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}}
                      {{scope.row.baseProduct.weightUnit}}
                </template>
            </template>
        </el-table-column>
        <el-table-column label="合同单价" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                <template v-if="scope.row.baseProduct != null">
                    {{scope.row.contractUnitPrice == null? 0: scope.row.contractUnitPrice + '元/'+scope.row.baseProduct.weightUnit}}
                </template>
                <template v-else>
                    {{scope.row.contractUnitPrice == null? 0: scope.row.contractUnitPrice}}
                </template>
            </template>
        </el-table-column>
        <el-table-column v-if="showForSelectGoods" label="合同金额（元）" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.contractMoney}}
            </template>
        </el-table-column>
       
        <el-table-column v-if="showAmount" label="手续费(元)" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.serviceFee == null?0:scope.row.serviceFee }}
            </template>
        </el-table-column>
        <el-table-column v-if="showAmount" label="开票费(元)" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.invoiceFee==null?0:scope.row.invoiceFee}}
            </template>
        </el-table-column>
        <el-table-column v-if="showAmount" label="赎货金额(元)" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.redeemMoney !== null ? scope.row.redeemMoney : 0}}
            </template>
        </el-table-column>
        <el-table-column label="规格(mm)" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.labelThick}} * {{scope.row.labelWidth}} * {{scope.row.goodsLength}}
            </template>
        </el-table-column>
        <el-table-column label="边部" width="120" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.edge}}
                </component-select>
            </template>
        </el-table-column>
        <el-table-column label="参厚" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.referThick}}
            </template>
        </el-table-column>
        <el-table-column label="牌号" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.trademark}}
            </template>
        </el-table-column>
        <el-table-column label="卷号" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.goodsVolume}}
            </template>
        </el-table-column>
        <el-table-column label="厂家" width="180" show-overflow-tooltip>
            <template slot-scope="scope">
               {{scope.row.dictMallMnfct ? scope.row.dictMallMnfct.mnfctName : '--'}}
            </template>
        </el-table-column>`
		
/** *******************************货物明细-----html*********************** */
		
	var detailHTML=`<h5 class="bg-tit">
            <span>货物明细</span>
            <input type="button" @click="selectGoods" style="background-color:#5CB85C;color:#fff" class="ui-btn pull-right btn_new_line"
                value="选择货物" />
            <input type="text" style="width:0;height:0;visibility:hidden" v-model="entity.storageName" name="goods">
        </h5>
        <div class="ui-row">
        	<div class="ui-col">
	            <div class="ui-form-group ui-col-50 ">
	                <label class="ui-label-control ui-col-20">合同自编号</label>
	                <div class="ui-col-30">
	                    <component-select v-model="entity.contractId" type="contractCode" :isdisabled="true">
			          	</component-select>
	                </div>
	                <label class="ui-label-control ui-col-10">仓库</label>
	                <div class="ui-col-30">
	                    <component-select v-model="entity.storageId" type="DictMallDepot" :isdisabled="true">
			          </component-select>
	                </div>
	            </div>
	        </div>
            <div class="ui-col">
                <component-table :max-height="300" :data="tableData"
                	:columns="tableConfig.columns"
                	:operation="tableConfig.operation"
                	:loading="tableConfig.loading"
                    @delete="handleDelete">
                    ${goodsHTML}
                </component-table>
            </div>
        </div>`
		
/** *******************************费用计算-----html*********************** */		
		
	var financeHTML = `<div>
	    <div class="ui-row" style="margin-top: 10px">
	        <div class="ui-form-group ui-col pull-right" style="width:500px">
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-30">总重量：</label>
	                <div class="ui-label-control ui-col-70">
	                	<span class="money">{{util.replaceSpace(entity.totalWeight)}}</span> 吨
	                </div>
	            </div>
	            <template v-if="showFinance">
		            <div class="ui-form-group ui-col-50">
		                <label class="ui-label-control ui-col-30">总货款：</label>
		                <div class="ui-label-control ui-col-70">
		                	<span class="money">{{util.replaceSpace(entity.totalGoodsPayment)}}</span> 元
		                </div>
		            </div>
	            </template>
	        </div>
	    </div>
	    <div class="ui-row" v-if="showFinance">
	        <div class="ui-form-group ui-col pull-right" style="width:500px">
	            <div class="ui-form-group ui-col">
	                <div class="ui-col-30">
	                    <el-checkbox v-model="useDepositFee" :disabled="lastGoods" class="ui-checkbox">保证金抵消金额：</el-checkbox>
	                </div>
	                <div class="ui-col-40">
	                    <el-input-number :controls="false" v-model="entity.depositFee" :max="maxDepositFee" :min="0" :disabled="!useDepositFee || lastGoods"></el-input-number>
	                </div>
	                <label class="ui-label-control ui-col-30">元
	                    <span v-if="useDepositFee" style="font-size: 12px;">(最大可用: {{util.replaceSpace(maxDepositFee)}})</span>
	                </label>
	            </div>
	        </div>
	    </div>
	    <div class="ui-row" v-if="showFinance">
	        <div class="ui-form-group ui-col pull-right" style="width:600px">
	            <div class="ui-form-group ui-col-33">
	                <label class="ui-label-control ui-col-40">手续费：</label>
	                <div class="ui-label-control ui-col-60">
	                	<span class="money">{{util.replaceSpace(entity.commissionFee)}}</span> 元
	                </div>
	            </div>
	            <div class="ui-form-group ui-col-33">
	                <label class="ui-label-control ui-col-40">开票费：</label>
	                <div class="ui-label-control ui-col-60">
	                	<span class="money">{{util.replaceSpace(entity.invoiceFee)}}</span> 元
	                </div>
	            </div>
	            <div class="ui-form-group ui-col-33">
	                <label class="ui-label-control ui-col-40">其他费用：</label>
	                <div class="ui-label-control ui-col-60">
	                	<span class="money">{{util.replaceSpace(entity.otherFee)}}</span> 元
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="ui-row" v-if="showFinance">
	        <div class="ui-form-group ui-col pull-right" style="width:500px">
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-30">总金额：</label>
	                <div class="ui-label-control ui-col-60">
	                	<span class="money" style="color: red">{{util.replaceSpace(entity.totalMoney)}}</span> 元
	                </div>
	            </div>
	            <div class="ui-form-group ui-col-50">
	                <label class="ui-label-control ui-col-40">代付总金额：</label>
	                <div class="ui-label-control ui-col-60">
	                	<span class="money" style="color: red">{{util.replaceSpace(entity.realMoney)}}</span> 元
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	`
})
