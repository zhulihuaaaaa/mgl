/**
 * 发票管理
 */
require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	// VUE初始化页面
	var detail = null;
	// 新建弹窗组件
	var invoiceVue
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					invoiceType: null,
					invoiceNo:null,
					createUser:null,
					startBillingDate:null,
					endBillingDate:null,
					startCheckingDate:null,
					endCheckingDate:null,
					startCreateDate:null,
					endCreateDate:null
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
				columns: ['index','custom']
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
				ajax.findPage('/invoice', vm.searchParam).then(function (res) {
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
		    util.datePicker({
				 dateRange: true,
				  selector: ['.daterange-start2', '.daterange-end2'] //绑定Input选择器
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
	
	$(".btn-in-add").click(function () {
		addInInvoioce(0)
	})
	
	$(".btn-out-add").click(function () {
		addOutInvoice(0)
	})
	
	/**
	 * 新增|编辑进项发票
	 * @param type 操作类型（0:新增|1:编辑）
	 */
	function addInInvoioce (type, data) {
		var tableContent
		util.dialog({
			id: 'invoiceDialog',
			width: 1230,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建进项发票' : '编辑进项发票',
			content: `
				<form id="dialog-content">
					<template>
						<div>
							<h5 class="bg-tit">基本信息</h5>
							<div class="ui-row">
								<div class="ui-col">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30 required-txt">发票号</label>
										<div class="ui-col-60">
											<input type="text" class="ui-input-control" v-model="invoice.entity.invoiceNo" name="invoiceNo">
										</div>
									</div>
								</div>
								<div class="ui-col">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30 required-txt">开票日期</label>
										<div class="ui-col-60">
											<input type="text" v-model="invoice.entity.billingDate" class="ui-input-control billing-date-dialog" name="billingDate">
										</div>
									</div>
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30 required-txt">验票日期</label>
										<div class="ui-col-60">
											<input type="text" v-model="invoice.entity.checkingDate" class="ui-input-control checking-date-dialog" name="checkingDate">
										</div>
									</div>
								</div>
								<div class="ui-col">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30">合同编号</label>
										<div class="ui-col-60">
											<input type="text" v-model="invoice.entity.contractCodes" class="ui-input-control" name="contractIds" disabled>
										</div>
									</div>
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30">备注</label>
										<div class="ui-col-60">
											<input type="text" v-model="invoice.entity.notes" class="ui-input-control" name="notes">
										</div>
									</div>
								</div>
								<!--<div class="ui-col">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30">发票照片</label>
										<div class="ui-col-60">
											<component-upload @success="handleSuccess" ref="attach" :auto-upload="true" :accept="accept" :multiple="true" @change="change" :uploading.sync="uploading"></component-upload>
										</div>
									</div>
								</div>-->
							</div>
							<h5 class="bg-tit">
								<span>货物信息</span>
								<input type="button" @click="selectGoods" style="background-color:#5CB85C;color:#fff" class="ui-btn pull-right btn_new_line"
                value="选择货物" />
                			</h5>
                			<div class="ui-col">
				                <component-table :max-height="300" 
				                	:data="invoice.detail">
									${detailHTMLView}
									${detailHTMLViews}
				                </component-table>
				            </div>
							<div class="ui-row  pull-right" style="margin-top: 10px">
								<div class="ui-form-group ui-col-100" style="width:450px">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-40">发票总额(元)</label>
									</div>
									<div class="ui-form-group ui-col-50">
										<input type="text" class="ui-input-control" v-model="invoice.entity.invoiceMoney" disabled>
									</div>
								</div>
							</div>
						</div>
					</template>
				</form>
				`,
				okValue: '确定',
				ok: function () {
					let entity = invoiceVue.invoice.entity
					let detail1 = invoiceVue.invoice.detail
					// 禁用提交按钮
					util.setLoading({
						selector: '[i-id="ok"]'
					})
					var vo = {
						entity: entity,
						detail: detail1
					}
					if(type === 0){
						ajax.save('/invoice', vo).then(function (result) {
							util.promptMsg({
								content: result.message
							})
							util.dialog({getIdClose: 'invoiceDialog'})
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
					}else{
						ajax.update('/invoice', vo).then(function (result) {
							util.promptMsg({
								content: "更新成功"
							})
							detail.model = result.data
							if (result.state === 1) {
								page.fetchData()
								util.dialog({getIdClose: 'invoiceDialog'})
							}
						}, function () {
							// 使提交按钮可用
							util.setLoading({
								selector: '[i-id="ok"]',
								isClick: false
							})
						})
					}
				},
				cancelValue: '取消',
				onshow: function () {
					invoiceVue = new Vue({
						el: '#dialog-content',
						data () {
							return {
								type: type,
								// 允许上传文件的类型
								accept: 'image/jpeg,image/jpg,image/png,image/gif',
								invoiceMoney: 0,
								uploadImgCount: 0,
								uploadImgTotal:0,
								uploading: false,
								invoice: {
									entity: {
										invoiceType: 'A',
										invoiceNo: '',
										billingDate:'',
										checkingDate:'',
										invoiceMoney:'',
										contractIds:'',
										contractCodes:'',
										notes:''
									},
									detail: [],
									attach: []
								}
							}
						},
						watch: {
						},
						methods: {
							/**
							 * 上传
							 */
							handleSuccess (result) {
								if (result.data.attach) {
									this.invoice.attach.push(result.data.attach)
									this.uploadImgCount++
								}
							},
							change (data) {
								this.uploadImgTotal = data
							},
							delLine (index, row) {
								if (row.invoiceId) {
									this.invoice.detail.push(row.contractDetailId)
								}
								this.invoice.detail.splice(index, 1)
							},
							selectGoods(){
								var vm = this
								selectGoods()
							},
							handleInvoicePriceChange (row, index) {
								this.$nextTick(function () {
									var totalMoney = 0;
									for(var item of this.invoice.detail){
										var total = parseFloat((parseFloat(item.netWeight == null ? 0 : (item.netWeight/item.product.unitRate)) * parseFloat(item.invoicePrice == null ? 0 : item.invoicePrice)))
										total = util.formatNumber(total,2);
										this.$set(item, 'invoiceMoney', total)
										totalMoney += parseFloat(total == null ? 0 : total)
										totalMoney = util.formatNumber(totalMoney,2);
									}
									this.$set(this.invoice.entity, 'invoiceMoney', totalMoney)
								})
							}
						},
						mounted () {
							// 添加表单验证
							this.$nextTick(function() {
								util.datePicker({
									selector: '.billing-date-dialog'  //绑定Input选择器
								})
								util.datePicker({
									selector: '.checking-date-dialog'  //绑定Input选择器
								})
							})
							if (type === 1) {
								this.invoice.entity = $.extend(true, {}, data.model)
								this.invoice.detail = $.extend(true, [], data.detail)
							}
						},
						components: {
							componentTable: componentTable
						}
					})
				}
		})
	}
	
	/**
	 * 选择货物
	 */
	function selectGoods () {
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
				      <div class="ui-form-group ui-col-25">
				        <label class="ui-label-control ui-col ui-col-20">仓库</label>
				        <div class="ui-col ui-col-80 ui-label-txt">
				          <component-select v-model="searchParam.dto.storageId" @change="fetchData()" type="DictMallDepot" 
				            name="dictMallDepotId">
				          </component-select>
				        </div>
				      </div>
				       <div class="ui-form-group ui-col-25">
				        <label class="ui-label-control ui-col ui-col-20">厂家</label>
				        <div class="ui-col ui-col-80 ui-label-txt">
				          <component-select v-model="searchParam.dto.mnfctId" @change="fetchData()" type="mallMnfcts" 
				            name="dictMallDepotId">
				          </component-select>
				        </div>
				      </div>
				      <div class="ui-form-group ui-col-25">
				        <label class="ui-label-control ui-col ui-col-20">卷号</label>
				        <div class="ui-col ui-col-80 ui-label-txt">
				          <div class="ui-col col-160">
							<input type="text" class="ui-input-control" placeholder="请输入卷号" v-model="searchParam.dto.goodsVolume" @change="fetchData()">
						  </div>
				        </div>
				      </div>
				      <div class="ui-form-group ui-col-25">
				        <label class="ui-label-control ui-col ui-col-20">品类</label>
				         <div class="ui-col ui-col-80 ui-label-txt">
							<component-select v-model="searchParam.dto.productId" type="baseProduct" @change="fetchData()">
							</component-select>
				        </div>
				      </div>
				      
				    </div>
				  </div>
				  <div class="ui-col">
				    <div class="main-cnt-scroll">
				      <component-table :data="tableData" :height="300" row-key="id" :select-data="selectData" :columns="tableConfig.columns"
				        :loading="tableConfig.loading" :pagination="true"
				        @select="handleSelect"
				        @select-all="handleSelectAll"
				        @fetch-data="fetchData">
				       ${detailHTMLView}
				      </component-table>
				    </div>
				  </div>
				</div>
				`,
				okValue: '确定',
				ok: function () {
					let all = invoiceVue.invoice
					// TODO 循环获取合同Id，合同Code,放置relatedId,以及其他不对应的字段,增加发票单价、发票金额、备注字段
					var selectData = selectGoodsVue.selectData
					var detail = []
					var contractIds = []
					var contractCodes = []
					for(var item of selectData){
						var exist = false
						if (all.detail != null && all.detail.length > 0) {
							for (var old of all.detail) {
								if (item.id === old.relatedId) {
									exist = true
									detail.push(old);
									if (contractIds.indexOf(old.contractId) === -1) {
										contractIds.push(old.contractId)
									}
									if (contractCodes.indexOf(old.contractCode) === -1) {
										contractCodes.push(old.contractCode)
									}
									break
								}
							}
						}
						if (!exist) {
							Vue.set(item, 'relatedId', item.id)
							Vue.set(item, 'invoicePrice', 0)
							Vue.set(item, 'invoiceMoney', 0)
							Vue.set(item, 'notes', '')
							detail.push(item);
							if (contractIds.indexOf(item.contractId) === -1) {
								contractIds.push(item.contractId)
							}
							if (contractCodes.indexOf(item.contractCode) === -1) {
								contractCodes.push(item.contractCode)
							}
						}
					}
					//货物明细
					all.detail = detail
					all.entity.contractIds = contractIds.join(',')
					all.entity.contractCodes = contractCodes.join(',')
				},
				cancelValue: '取消',
				onshow: function () {
					var detail = invoiceVue.invoice.detail
					var selectData = {}
					if (detail != null && detail.length > 0) {
						for (var item of detail) {
							selectData[item.relatedId] = {id: item.relatedId}
						}
					}
					selectGoodsVue = new Vue({
						el:"#selectgoods",
						data: {
							util: util,
							searchParam: {
								dto: {
									storageId:null,
									mnfctId:null,
									goodsVolume:null,
									productId:null
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
								columns: ['index','selection']
							},
							// 已选择数据
							selectDataMap: selectData
						},
						computed: {
							selectData () {
								var selectData = []
								if (this.selectDataMap != null) {
									var keys = Object.keys(this.selectDataMap)
									if (keys.length > 0) {
										for (var key of keys) {
											selectData.push(this.selectDataMap[key])
										}
									}
								}
								return selectData
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
								// 查合同
								ajax.post('/invoice/findInInvoices', vm.searchParam).then(function (res) {
									vm.tableData = res.data;
									vm.tableConfig.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
							},
							/**
							 * 复选框变化回调事件
							 * @param selectData 当前页所有选中数据
							 * @param row 当前选中或取消选中数据
							 */
							handleSelect (selectData, row) {
								if (this.selectDataMap.hasOwnProperty(row.id)) {
//									this.$delete(this.selectDataMap, row.id)
								} else {
									this.$set(this.selectDataMap, row.id, row)
								}
							},
							handleSelectAll (selection) {
								var select = selection != null && selection.length > 0 ? selection : this.tableData.list
								for (var row of select) {
									this.handleSelect(null, row)
								}
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
		})
		
	}
	
	/**
	 * 新增|编辑销项发票
	 * @param type 操作类型（0:新增|1:编辑）
	 */
	function addOutInvoice (type, data) {
		var tableContent
		util.dialog({
			id: 'invoiceDialog',
			width: 1230,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建销项发票' : '编辑销项发票',
			content: `
				<form id="dialog-content">
					<template>
						<div>
							<h5 class="bg-tit">基本信息</h5>
							<div class="ui-row">
								<div class="ui-col">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30 required-txt">发票号</label>
										<div class="ui-col-60">
											<input type="text" class="ui-input-control" v-model="invoice.entity.invoiceNo" name="invoiceNo">
										</div>
									</div>
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30 required-txt">客户</label>
										<div class="ui-col-60">
											<component-select v-model="invoice.entity.customerId" type="crmClients" name="customerId">
                                         	</component-select>
										</div>
									</div>
								</div>
								<div class="ui-col">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30 required-txt">开票日期</label>
										<div class="ui-col-60">
											<input type="text" v-model="invoice.entity.billingDate" class="ui-input-control billing-date-dialog" name="billingDate">
										</div>
									</div>
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30 required-txt">验票日期</label>
										<div class="ui-col-60">
											<input type="text" v-model="invoice.entity.checkingDate" class="ui-input-control checking-date-dialog" name="checkingDate">
										</div>
									</div>
								</div>
								<div class="ui-col">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30">合同编号</label>
										<div class="ui-col-60">
											<input type="text" v-model="invoice.entity.contractCodes" class="ui-input-control" name="contractIds" disabled>
										</div>
									</div>
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30">备注</label>
										<div class="ui-col-60">
											<input type="text" v-model="invoice.entity.notes" class="ui-input-control" name="notes">
										</div>
									</div>
								</div>
								<!--<div class="ui-col">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-30">发票照片</label>
										<div class="ui-col-60">
											<component-upload @success="handleSuccess" ref="attach" :auto-upload="true" :accept="accept" :multiple="true" @change="change" :uploading.sync="uploading"></component-upload>
										</div>
									</div>
								</div>-->
							</div>
							<h5 class="bg-tit">
								<span>货物信息</span>
								<input type="button" @click="selectOutGoods" style="background-color:#5CB85C;color:#fff" class="ui-btn pull-right btn_new_line"
                value="选择货物" />
                			</h5>
                			<div class="ui-col">
				                <component-table :max-height="300" 
				                	:data="invoice.detail">
									${detailHTMLView}
									${detailHTMLViews}
				                </component-table>
				            </div>
							<div class="ui-row  pull-right" style="margin-top: 10px">
								<div class="ui-form-group ui-col-100" style="width:450px">
									<div class="ui-form-group ui-col-50">
										<label class="ui-label-control ui-col-40">发票总额(元)</label>
									</div>
									<div class="ui-form-group ui-col-50">
										<input type="text" class="ui-input-control" v-model="invoice.entity.invoiceMoney" disabled>
									</div>
								</div>
							</div>
						</div>
					</template>
				</form>
				`,
				okValue: '确定',
				ok: function () {
					let entity = invoiceVue.invoice.entity
					let detail = invoiceVue.invoice.detail
					// 禁用提交按钮
					util.setLoading({
						selector: '[i-id="ok"]'
					})
					var vo = {
						entity: entity,
						detail: detail
					}
					if(type === 0){
						ajax.save('/invoice', vo).then(function (result) {
							util.promptMsg({
								content: result.message
							})
							util.dialog({getIdClose: 'invoiceDialog'})
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
					}else{
						ajax.update('/invoice', vo).then(function (result) {
							util.promptMsg({
								content: result.message
							})
							if (result.state === 1) {
								page.fetchData()
								util.dialog({getIdClose: 'invoiceDialog'})
							}
						}, function () {
							// 使提交按钮可用
							util.setLoading({
								selector: '[i-id="ok"]',
								isClick: false
							})
						})
					}
				},
				cancelValue: '取消',
				onshow: function () {
					invoiceVue = new Vue({
						el: '#dialog-content',
						data () {
							return {
								type: type,
								// 允许上传文件的类型
								accept: 'image/jpeg,image/jpg,image/png,image/gif',
								invoiceMoney: 0,
								uploadImgCount: 0,
								uploadImgTotal:0,
								uploading: false,
								invoice: {
									entity: {
										invoiceType: 'B',
										invoiceNo: '',
										billingDate:'',
										checkingDate:'',
										invoiceMoney:'',
										contractIds:'',
										contractCodes:'',
										customerId:'',
										notes:''
									},
									detail: [],
									attach: []
								}
							}
						},
						watch: {
						},
						methods: {
							/**
							 * 上传
							 */
							handleSuccess (result) {
								if (result.data.attach) {
									this.invoice.attach.push(result.data.attach)
									this.uploadImgCount++
								}
							},
							change (data) {
								this.uploadImgTotal = data
							},
							selectOutGoods(){
								var vm = this
								selectOutGoods()
							},
							delLine (index, row) {
								if (row.invoiceId) {
									this.invoice.detail.push(row.contractDetailId)
								}
								this.invoice.detail.splice(index, 1)
							},
							handleInvoicePriceChange (row, index) {
								this.$nextTick(function () {
									var totalMoney = 0;
									for(var item of this.invoice.detail){
										var total = parseFloat((parseFloat(item.netWeight == null ? 0 : (item.netWeight/item.product.unitRate)) * parseFloat(item.invoicePrice == null ? 0 : item.invoicePrice)))
										total = util.formatNumber(total,2);
										this.$set(item, 'invoiceMoney', total)
										totalMoney += parseFloat(total == null ? 0 : total)
										totalMoney = util.formatNumber(totalMoney,2);
									}
									this.$set(this.invoice.entity, 'invoiceMoney', totalMoney)
								})
							}
						},
						mounted () {
							// 添加表单验证
							this.$nextTick(function() {
								util.datePicker({
									selector: '.billing-date-dialog'  //绑定Input选择器
								})
								util.datePicker({
									selector: '.checking-date-dialog'  //绑定Input选择器
								})
							})
							if (type === 1) {
								this.invoice.entity = $.extend(true, {}, data.model)
								this.invoice.detail = $.extend(true, {}, data.detail)
							}
						},
						components: {
							componentTable: componentTable
						}
					})
				}
		})
	}
	
	/**
	 * 选择货物
	 */
	function selectOutGoods () {
		util.dialog({
			width: 1000,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '选择货物',
			content: `
				<div id="selectOutGoods">
				  <div class="ui-row">
				  <div class="ui-col">
				      <div class="ui-form-group ui-col-25">
				        <label class="ui-label-control ui-col ui-col-20">仓库</label>
				        <div class="ui-col ui-col-80 ui-label-txt">
				          <component-select v-model="searchParam.dto.storageId" @change="fetchData()" type="DictMallDepot" 
				            name="dictMallDepotId">
				          </component-select>
				        </div>
				      </div>
				       <div class="ui-form-group ui-col-25">
				        <label class="ui-label-control ui-col ui-col-20">厂家</label>
				        <div class="ui-col ui-col-80 ui-label-txt">
				          <component-select v-model="searchParam.dto.mnfctId" @change="fetchData()" type="mallMnfcts" 
				            name="dictMallDepotId">
				          </component-select>
				        </div>
				      </div>
				      <div class="ui-form-group ui-col-25">
				        <label class="ui-label-control ui-col ui-col-20">卷号</label>
				        <div class="ui-col ui-col-80 ui-label-txt">
				          <div class="ui-col col-160">
							<input type="text" class="ui-input-control" placeholder="请输入卷号" v-model="searchParam.dto.goodsVolume" @change="fetchData()">
						  </div>
				        </div>
				      </div>
				      <div class="ui-form-group ui-col-25">
				        <label class="ui-label-control ui-col ui-col-20">品类</label>
				         <div class="ui-col ui-col-80 ui-label-txt">
							<component-select v-model="searchParam.dto.productId" type="baseProduct" @change="fetchData()">
							</component-select>
				        </div>
				      </div>
				    </div>
				  </div>
				  <div class="ui-col">
				    <div class="main-cnt-scroll">
				      <component-table :data="tableData" :height="300" row-key="id" :select-data="selectData" :columns="tableConfig.columns"
				        :loading="tableConfig.loading" :pagination="true"
				        @select="handleSelect"
				        @select-all="handleSelectAll"
				        @fetch-data="fetchData">
				       ${detailHTMLView}
				      </component-table>
				    </div>
				  </div>
				</div>
				`,
				okValue: '确定',
				ok: function () {
					let all = invoiceVue.invoice
					// TODO 循环获取合同Id，合同Code,放置relatedId,以及其他不对应的字段,增加发票单价、发票金额、备注字段
					var selectData = selectOutGoodsVue.selectData
					var detail = []
					var contractIds = []
					var contractCodes = []
					for(var item of selectData){
						var exist = false
						if (all.detail != null && all.detail.length > 0) {
							for (var old of all.detail) {
								if (item.id === old.relatedId) {
									exist = true
									detail.push(old);
									if (contractIds.indexOf(old.contractId) === -1) {
										contractIds.push(old.contractId)
									}
									if (contractCodes.indexOf(old.contractCode) === -1) {
										contractCodes.push(old.contractCode)
									}
									break
								}
							}
						}
						if (!exist) {
							Vue.set(item, 'relatedId', item.id)
							Vue.set(item, 'invoicePrice', 0)
							Vue.set(item, 'invoiceMoney', 0)
							Vue.set(item, 'notes', '')
							detail.push(item);
							if (contractIds.indexOf(item.contractId) === -1) {
								contractIds.push(item.contractId)
							}
							if (contractCodes.indexOf(item.contractCode) === -1) {
								contractCodes.push(item.contractCode)
							}
						}
					}
					//货物明细
					all.detail = detail
					all.entity.contractIds = contractIds.join(',')
					all.entity.contractCodes = contractCodes.join(',')
				},
				cancelValue: '取消',
				onshow: function () {
					var detail = invoiceVue.invoice.detail
					var selectData = {}
					if (detail != null && detail.length > 0) {
						for (var item of detail) {
							selectData[item.relatedId] = {id: item.relatedId}
						}
					}
					selectOutGoodsVue = new Vue({
						el:"#selectOutGoods",
						data: {
							util: util,
							searchParam: {
								dto: {
									storageId:null,
									mnfctId:null,
									goodsVolume:null,
									productId:null
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
								columns: ['index','selection']
							},
							// 已选择数据
							selectDataMap: selectData
						},
						computed: {
							selectData () {
								var selectData = []
								if (this.selectDataMap != null) {
									var keys = Object.keys(this.selectDataMap)
									if (keys.length > 0) {
										for (var key of keys) {
											selectData.push(this.selectDataMap[key])
										}
									}
								}
								return selectData
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
								// 查合同
								ajax.post('/invoice/findOutInvoices', vm.searchParam).then(function (res) {
									vm.tableData = res.data;
									vm.tableConfig.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
							},
							/**
							 * 复选框变化回调事件
							 * @param selectData 当前页所有选中数据
							 * @param row 当前选中或取消选中数据
							 */
							handleSelect (selectData, row) {
								if (this.selectDataMap.hasOwnProperty(row.id)) {
//									this.$delete(this.selectDataMap, row.id)
								} else {
									this.$set(this.selectDataMap, row.id, row)
								}
							},
							handleSelectAll (selection) {
								var select = selection != null && selection.length > 0 ? selection : this.tableData.list
								for (var row of select) {
									this.handleSelect(null, row)
								}
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
		})
		
	}
	
	
	/*********************************定义变量 展示-----html************************/
	var detailHTMLView=`
		<el-table-column label="仓库" width="120">
			<template slot-scope="scope">
				<span>{{scope.row.storage.dptName}}</span>
       		</template>
		</el-table-column>
		<el-table-column label="品名" width="120">
			<template slot-scope="scope">
				<span>{{scope.row.product.productName}}</span>
       		</template>
		</el-table-column>
		<el-table-column label="数量" width="160">
			<template slot-scope="scope">
				{{scope.row.amount}}&nbsp;<span v-if="scope.row.product !=null">{{scope.row.product.quantityUnit}}</span>
			</template>
		</el-table-column>
		<el-table-column label="重量" width="100">
			<template slot-scope="scope">
				<template v-if="scope.row.product != null && scope.row.netWeight != null">
					{{scope.row.netWeight / scope.row.product.unitRate, scope.row.product.precision}} {{scope.row.product.weightUnit}}
				</template>
				<template v-else>
	                {{util.formatNumber(scope.row.netWeight / scope.row.product.unitRate, scope.row.product.precision)}}
	                  {{scope.row.product.weightUnit}}
	            </template>
			</template>
		</el-table-column>
		<el-table-column label="材质（钢种）" width="150" prop="materialId">
		</el-table-column>
		<el-table-column label="表面" width="120" prop="surfaceId">
		</el-table-column>
		<el-table-column label="规格(mm)" width="180">
			<template slot-scope="scope">
				<template v-if="scope.row.labelThick !=null">
					{{scope.row.labelThick}}
					&nbsp;*
					{{scope.row.labelWidth}}
					&nbsp;*
					{{scope.row.goodsLength}}
				</template>
			</template>
		</el-table-column>
		<el-table-column label="边部" width="120" prop="edge">
		</el-table-column> 
		<el-table-column label="参厚" width="180" prop="referThick">
		</el-table-column>
		<el-table-column label="牌号" width="180" prop="trademark">
		</el-table-column>
		<el-table-column label="卷号" width="180" prop="volume">
		</el-table-column>
		<el-table-column label="厂家" width="180" show-overflow-tooltip>
		<template slot-scope="scope" v-if="scope.row.mnfct !=null">
				<span>{{scope.row.mnfct.mnfctName}}</span>
       		</template>
		</el-table-column>
		<el-table-column label="等级" width="100" prop="grade">
		</el-table-column>
		`
		/*********************************定义变量 展示-----html************************/
		var detailHTMLViews=`
			<el-table-column label="发票单价(元)" width="200">
				<template slot-scope="scope">
					<el-input-number size="small" v-model="scope.row.invoicePrice" controls-position="right" :min="0" @change="handleInvoicePriceChange(scope.row, scope.$index)"></el-input-number>
				</template>
		    </el-table-column>
		    <el-table-column label="发票金额(元)" width="200" prop="invoiceMoney">
		    </el-table-column>
		    <el-table-column label="备注" width="200">
				<template slot-scope="scope">
					<input type="text" class="ui-input-control ui-col-100" name="notes" v-model="scope.row.notes">
				</template>
		    </el-table-column>
		    <el-table-column label="操作" width="180">
				<template slot-scope="scope">
					<span class="ui-btn ui-red" @click="delLine(scope.$index, scope.row)">删除</span>
				</template>
			</el-table-column>
			`
			
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
				ajax.detail('/invoice', {
					
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
											ajax.findOne('/invoice',vm.model.invoiceId).then(function (res) {
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
							edit () {
								let vm = this
								let a = []
								vm.loading = true
								ajax.findOne('/invoice',vm.model.invoiceId).then(function (res) {
									if (res.data) {
										a = res.data
										var data = {
												model: detail.model,
												detail: a
											}
											if(vm.model.invoiceType == "A"){
												addInInvoioce(1, data)
											}else{
												addOutInvoice(1, data)
											}
									}
									vm.loading = false
								}, function () {
									vm.loading = false
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




