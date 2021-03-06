/**
 * 入库单设置
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
					businessType:'',
					contractNo: '',
					instockCode: '',
					createUser: '',
					instockStatus: '',
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
				BusinessType: [],
				InstockState:[],
				GoodsPaymentState:[],
				DepositState:[],
				InspectionType:[]
			},
			// 表格数据
			tableData: {},
			tableConfig: {
				loading: false,
				columns: ['index', 'custom']
			}
		},
		computed: {
			businessTypeMap () {
				var map = {}
				this.options.BusinessType.forEach(function (item) {
					map[item[0]] = item[1]
				})
				return map
			},
			InstockStateMap () {
				var map = {}
				this.options.InstockState.forEach(function (item) {
					map[item[0]] = item[1]
				})
				return map
			},
			GoodsPaymentStateMap () {
				var map = {}
				this.options.GoodsPaymentState.forEach(function (item) {
					map[item[0]] = item[1]
				})
				return map
			},
			DepositStateMap () {
				var map = {}
				this.options.DepositState.forEach(function (item) {
					map[item[0]] = item[1]
				})
				return map
			},
			InspectionStateMap () {
				var map = {}
				this.options.InspectionType.forEach(function (item) {
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
				ajax.findPage('/instockBill', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					if (detail && detail.show) {
						for (var item of vm.tableData.list) {
							if (item.instockBillId === detail.model.instockBillId) {
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
			edit (row) {
				addOrEdit(1, row)
			},
			detail (row) {
				showSlide(row)
			}
		},
		mounted () {
			var vm = this
		    ajax.getOptions(['InstockState', 'BusinessType','GoodsPaymentState','DepositState','InspectionType']).then((result) => {
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
	
	$("#closeApply").click(function() {
		
	});
	
	/**
	 * 新增或编辑入库单
	 * @param type 操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			width: 1000,
			height: 450,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新增入库' : '编辑入库',
			content: `
			<form id="addOrEditForm">
				<div id="addOrEditDialog">
					<template>
					<h5 class="bg-tit">新增信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-90">
								<label class="ui-label-control ui-col-20 required-txt">入库单号</label>
								<div class="ui-col-80">
									<input type="text" disabled class="ui-input-control" placeholder="请输入入库单号">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-90">
								<label class="ui-label-control ui-col-20 required-txt">业务类型</label>
								<div class="ui-col-80">
									<component-select v-model="entity.businessType" type="BusinessType" name="BusinessType">
                                    </component-select>
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-90">
								<label class="ui-label-control ui-col-20 required-txt">合同选择</label>
								<div class="ui-col-80">
								    <button type="button" :disabled="entity.businessType===''" @click="adds" class="ui-btn ui-pw28 btn-add ui-dialog-buttons">选择合同</button>
								    <input type="text" style="width:0;height:0;visibility:hidden" v-model="entity.contractId" name="contract">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-90">
								<label class="ui-label-control ui-col-20 required-txt">备注</label>
								<div class="ui-col-80">
									<input type="text" v-model="entity.notes" class="ui-input-control" name="weightUnit" placeholder="请输入备注">
								</div>
							</div>
						</div>
					</div>
					<template v-if="entity.contractId != null && entity.contractId !== ''">
						<h5 class="bg-tit">合同基本信息</h5>
						<div class="ui-row">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">合同编号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="quantityUnit" v-model="contract.contractNo">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">甲方</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="weightUnit" v-model="contract.buyer.clientName">
								</div>
							</div>
						</div>
						<div class="ui-row">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">乙方</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="quantityUnit" v-model="contract.seller.clientName">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">签订日期</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="weightUnit" v-model="contract.signDate">
								</div>
							</div>
						</div>
						<div class="ui-row">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">合同期限</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="quantityUnit" v-model="contract.contractPeriod">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">供应方</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="weightUnit" v-model="contract.mnfct.mnfctName">
								</div>
							</div>
						</div>
						<div class="ui-row">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">保证金金额</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="quantityUnit" v-model="contract.depositFee">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">保证金比例</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="weightUnit" v-model="contract.depositRate">
								</div>
							</div>
						</div>
						<div class="ui-row">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">开票费</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="quantityUnit"  v-model="contract.invoiceBaseFee">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">手续费</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="weightUnit"  v-model="contract.commissionRate">
								</div>
							</div>
						</div>
						<div class="ui-row">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">货物总重</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="quantityUnit"  v-model="contract.totalWeight">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">货物总价</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" disabled="disabled" name="weightUnit"  v-model="contract.totalMoney">
								</div>
							</div>
						</div>
						<h5 class="bg-tit">货物信息</h5>
						<el-table
						:data="detail"
						>
						  ${contractDetailHTML}
						</el-table>
					</template
					</div>
					</template>
				</div>
				</form>
				`,
				okValue: '确定',
				ok: function () {
					if ($('#addOrEditForm').valid()) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						ajax.save('/instockBill', addOrEditVue.entity).then((result) => {
							util.promptMsg({
								content: result.message
							})
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
					else{
						return false
					}
				},
				cancelValue: '取消',
				onshow: function () {
					addOrEditVue = new Vue({
						el:"#addOrEditDialog",
						data: {
							/*contractId:'',*/
							entity:{
								contractId:'',
								businessType:'',
								notes:''
							},
							contract:{},
							detail:[]
						},
						watch: {
							'entity.contractId': function (val) {
								if (val != null && val !== '') {
									let vm = this
									let detailParam = {
										dto: {
											contractId: vm.entity.contractId
										},
										pageNum: 0,
										pageSize: 20
									}
									ajax.post('/contract/findPageContractDetails',detailParam).then(function (res) {
										vm.detail = res.data.list
										vm.loading = false
									}, function () {
										vm.loading = false
									})
								}
							}
						},
						mounted(){
							//验证
							this.$nextTick(function() {
								instockEntityValid()
							})
						},
						methods: {
							contractDetail(){
							},	
						//选择合同
							adds(){
								selectContract(this.entity.businessType)
							}
					}
				})
			}
		})
	}
	//选择合同
	function selectContract(businessType){
		util.dialog({
			width: 1000,
			height: 270,
			fixed: true,
			skin: 'crm-form crm-form-over',
			content: `
				<div id="selectContractContent">
					<h5 class="bg-tit">合同列表</h5>
					 <component-table 
					 	:max-height="500"
					    :data="tableData"
					    :max-height="500"
					    @row-click="handleRowClick">	
						<el-table-column label="合同编号" width="150" prop="contractNo">
					    </el-table-column>  
					    
					   	<el-table-column label="签订日期" width="150" prop="signDate">
					    </el-table-column> 
					    
						<el-table-column label="合同类型" width="150" prop="contractType">
						</el-table-column>
						
					    <el-table-column label="客户" width="150" prop="buyer.clientName">
						</el-table-column>
						
						<el-table-column label="供应方" width="150" prop="seller.clientName">
						</el-table-column>
						
						 <el-table-column label="合约状态" width="150" prop="contractState">
						</el-table-column>
						
						<el-table-column label="货物总重量（吨）" width="150" prop="totalWeight">
						</el-table-column>
						
						<el-table-column label="货物总价（万）" width="150" prop="totalMoney">
						</el-table-column>
						
						<el-table-column label="保证金（万）" width="150" prop="depositFee">
						</el-table-column>
						
						<el-table-column label="合同到期日" width="150" prop="contractPeriod">
						</el-table-column>
						
						<el-table-column label="创建人" width="150" prop="createUser">
						</el-table-column>
						
						<el-table-column label="创建时间" width="150" prop="createDate">
						</el-table-column>
					</component-table>
				</div>
			`,
			okValue: '确定',
			ok: function () {
				        addOrEditVue.contract = selectContractVue.contract
				        addOrEditVue.entity.contractId = selectContractVue.contract.contractId
			
			},
			cancelValue: '取消',
			onshow: function () {
					selectContractVue = new Vue({
						el: '#selectContractContent',
						data :{
							tableData:[],
							detailParam:{
								dto: {
									contractType:businessType
								},
								pageNum: 0,
								pageSize: 20
							},
							contract: null
						},
						methods: {
							handleRowClick (row) {
								this.contract = row
							}
						},
						mounted () {
								let vm = this
								ajax.findAll('/contract', vm.detailParam).then(function (res) {
									vm.tableData = res.data
								}, function () {
								})
						},
						components: {
							componentTable: componentTable
						}
					})
			}
		})
	}
	/*
	 * 申请打款对话框
	 */
	function applyRemitDialog(data){
		var tableContent
		util.dialog({
			id: 'applyRemitDialog',
			width: 400,
			height: 180,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title:'申请打款',
			content: `<form id="remit-dialog-content">
					<template>
						<div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-100">
												<label class="ui-label-control ui-col ui-col-40">打款金额（元）</label>
												<div class="ui-col ui-col-40 ui-label-txt">
												<div class="ui-row">
													<el-input-number :controls="false" v-model="vo.detail.money" name="money">元</el-input-number>
												</div>
												</div>
											</div>
										</div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-100">
												<label class="ui-label-control ui-col ui-col-40">备注</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<el-input type="textarea"  name="">
												</div>
											</div>
										</div>
						</div>
					</template>
					</form>`,
					okValue: '确定',
					ok: function () {
								if ($('#remit-dialog-content').valid()) {
									ajax.post('/instockBill/addApply', tableContent.vo).then((result) => {
										detail.fetchData(3)
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
										vo:{
											detail: {
												money: '',
												instockId:data.bill.instockBillId
											},
											bill:data.bill
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
	
	/*
	 * 新建入库单对话框
	 */
	function contractDialog(type,data){
		util.dialog({
			width: 600,
			height: 300,
			fixed: true,
			skin: 'crm-form crm-form-over',
			content: `<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
										:max-height="500"
										id="contractIndex" 
										@fetch-data="fetchData"
										:data="tableData"
										row-key="contractCode"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										prop="contractCode"
										sortable="custom"
										label="合同编号"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="signDate"
										sortable="custom"
										label="签订日期"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="contractType"
										sortable="custom"
										label="合同类型"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="sellerId"
										sortable="custom"
										label="客户"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="buyerId"
										sortable="custom"
										label="供应方"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="contractState"
										sortable="custom"
										label="合约状态"
										min-width="80">
										<template slot-scope="scope">
											<span v-if="scope.row.contractState === 'A'">审核中</span>
											<span v-if="scope.row.contractState === 'B'">履约中</span>
											<span v-if="scope.row.contractState === 'C'">已完成</span>
											<!-- {{ scope.row.status === 'Y' ? '启用' : '禁用'}} -->
										</template>
									</el-table-column>
									<el-table-column
										prop="totalWeight"
										sortable="custom"
										label="货物总重量(吨)"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="totalMoney"
										sortable="custom"
										label="货物总价(万)"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="depositFee"
										sortable="custom"
										label="保证金(万)"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="contractPeriod"
										sortable="custom"
										label="合同期限"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="createUser"
										sortable="custom"
										label="创建人"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="createDate"
										sortable="custom"
										label="创建时间"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
								</component-table>
							</div>
						</div>`
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
			ajax.detail('/instockBill', {
			}).then(function (result) {
				var result = $(result).find(".slide-cnt")
				$(slide).html(result)
				detail = new Vue({
					el: slide,
					data: {
						completeCommit:false,
						applyMoney:false,
						util: util,
						// 选中行数据
						model: data,
						show: true,
						loading: false,
						activeIndex: 0,
						// 选项卡页面数据
						tabData: [{
							info:[],
							detail:[]
						}],
						ContractRecord:[],
						commitData:{instockBillId:data.bill.instockBillId},
						// 下拉选项列表
						options: {
							BusinessType: [],
							InstockState:[],
							GoodsPaymentState:[],
							DepositState:[],
							InspectionType:[],
							ApprovalState:[],
						},
					},
					computed: {
						instockId () {
							return this.model.bill.instockBillId
						},
						contractId(){
							return this.model.bill.contractId
						},
						businessTypeMap () {
							var map = {}
							this.options.BusinessType.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						InstockStateMap () {
							var map = {}
							this.options.InstockState.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						GoodsPaymentStateMap () {
							var map = {}
							this.options.GoodsPaymentState.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						DepositStateMap () {
							var map = {}
							this.options.DepositState.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						InspectionStateMap () {
							var map = {}
							this.options.InspectionType.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						},
						ApprovalStateMap () {
							var map = {}
							this.options.ApprovalState.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						}
					},
					watch: {
						model:{  
							handler:function(val,oldval){  
								let vm = this
								let businessType = vm.model.bill.businessType
								// 验货入库状态
								let inspectionStatus = vm.model.bill.inspectionStatus
								// 融资货款状态
								let financingLoanStatus = vm.model.bill.financingLoanStatus
								// 保证金状态
								let depositStatus = vm.model.bill.depositStatus
								//入库单状态 
								let instockStatus =  vm.model.bill.instockStatus
								//钢厂货款状态
								let paymentStatus =  vm.model.bill.paymentStatus
//								申请打款按钮只在业务类型为【定向销售、采购自销】时显示，并且在钢厂货款打款完成之后隐藏
								if(businessType == 'H'){
//								1.货押融资，验货状态、保证金状态、融资货款状态都完成后解禁
									this.completeCommit = !(inspectionStatus == 'A'&& depositStatus =='B' && financingLoanStatus=='C')
									// 暂时都显示
									this.applyMoney = depositStatus == 'B'
									if(financingLoanStatus == 'C'){
										this.applyMoney = false
									}
								}else if(businessType =='C'){
//									2.定向销售，验货状态为验货中、保证金状态、钢厂货款状态都完成后解禁
									this.completeCommit = !(inspectionStatus == 'B' && depositStatus =='B'&& paymentStatus =='C')
									//  申请打款按钮	1.定向销售：保证金已到账时显示
									this.applyMoney = depositStatus == 'B' 
									if(depositStatus == 'B' && paymentStatus =='C' ){
										this.applyMoney = false
									}
								}else if(businessType == 'X'){
//									3.采购自销，验货状态为验货中、钢厂货款状态完成后解禁
									this.completeCommit = !(inspectionStatus == 'B'&& financingLoanStatus =='C')
									//	申请打款按钮  2.采购自销：直接显示
									this.applyMoney =  financingLoanStatus !='C'
								}else if(businessType =='D'){
//									4.仓单质押，验货状态完成后解禁
									this.completeCommit = !(inspectionStatus == 'A')
								}
								// 入库单完成 不显示
								if(instockStatus =='B'){
									this.applyMoney = false
								}
							},
							immediate: true
						},
					},
					methods: {
						applyRemit(){
							applyRemitDialog(this.model)
						},
						commit(){
							let vm = this
							ajax.post('/instockBill/updateState',this.commitData).then(function (res) {
								// 返回成功后 更改入库单状态
								page.fetchData();
								detail.fetchData();
								ajax.get('/instockBill/findById',{"instockBillId":vm.model.bill.instockBillId}).then(function (res) {
									vm.model = res.data
								})
								this.loading = false
								util.promptMsg({
									content: res.message
								})
								
							}, function () {
								this.loading = false
							})
						},
						/**
						 * 编辑
						 */
						edit () {
							addOrEdit(1, this.model)
						},
						/**
						 * 获取对应索引的tab数据
						 */
						fetchData (index) { 
							let vm = this
							if(index > 0){
								vm.loading = true
								switch(index){
									case 1:
										let detailParam = {
												dto: {
													contractId: vm.contractId
												},
												pageNum: 0,
												pageSize: 20
										}
										vm.$set(vm.tabData, index, {info:{},detail:[]})
										ajax.post('/contract/findPageContractDetails',detailParam).then(function (res) {
											vm.tabData[index].detail = res.data.list
											vm.loading = false
										}, function () {
											vm.loading = false
										})
										ajax.findOne('/contract',vm.contractId).then(function (res) {
											vm.tabData[index].info = res.data
											vm.loading = false
										}, function () {
											vm.loading = false
										})
										break
									case 3:
										ajax.get('/instockBill/findApplyRemit',{id:vm.instockId}).then(function (res) {
											vm.tabData[index] = res.data
											vm.loading = false
										}, function () {
											vm.loading = false
										})
										break
									case 2:
										ajax.get('/instockBill/findInspectionById',{id:vm.instockId}).then(function (res) {
											vm.tabData[index] = res.data ? res.data:[]
											vm.loading = false
										}, function () {
											vm.loading = false
										})
										break
									case 4:
										ajax.get('/instockBill/findContractRecord',{contractId:vm.contractId}).then(function (res) {
											vm.tabData[index] = res.data ? res.data:[]
											vm.loading = false
										}, function () {
											vm.loading = false
										})
										break
								}
							}
						}
					},
					mounted () {
						var vm = this
						util.swiperTab({
							change: function (index) {
								if (!vm.tabData[index]) {
									vm.fetchData(index)
								}
								vm.activeIndex = index
							}
						}),
						 ajax.getOptions(['ApprovalState','InstockState', 'BusinessType','GoodsPaymentState','DepositState','InspectionType']).then((result) => {
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
	
	
	
	//---------------
	// 新建入库单 - 表单验证
	//---------------
	function instockEntityValid () {
		util.formValid({
			selector: '#addOrEditForm',
			onkeyup: false,
			rules: {
				'contract': {
					required: true,
				},
				'BusinessType': {
					required: true,
				}
			},
			messages: {
				'contract': {
					required: '请选择合同'
				},
				'BusinessType': {
					required: '请输入业务类型'
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
				'money': {
					required: true,
					maxlength: 1000
				},
				'instockId': {
					required: true,
					maxlength: 32
				}
			},
			messages: {
				'money': {
					required: '请输入打款金额',
					maxlength: '输入超出限制'
				},
				'instockId': {
					required: '系统异常'
				}
			}
		})
	}
})

var contractDetailHTML = ` <el-table-column label="品类" width="150" prop="product.productName">
												    </el-table-column>  
												    
												   <el-table-column label="材质" width="150" prop="materialId">
												    </el-table-column> 
												    
													<el-table-column label="表面" width="150" prop="process.processName">
													</el-table-column>
													
													<el-table-column label="规格(mm)" width="280">
														<el-table-column label="厚度" width="150" prop="labelThick">
														</el-table-column>
														<el-table-column label="宽度" width="150" prop="labelWidth">
														</el-table-column>
														<el-table-column label="长度" width="150" prop="goodsLength">
														</el-table-column>
													</el-table-column>
												    
												    <el-table-column label="边部" width="150" prop="edgeName">
													</el-table-column>
													
													<el-table-column label="厂家" width="150" prop="mnfct.mnfctName">
													</el-table-column>
													
													 <el-table-column label="数量(张/卷)" width="150" prop="amount">
													</el-table-column>
													
													<el-table-column label="重量(kg)" width="150" prop="netWeight">
													</el-table-column>
													
													<el-table-column label="含税单价(元/kg)" width="150" prop="unitContractPrice">
													</el-table-column>
													
													<el-table-column label="含税金额(元)" width="150" prop="contractMoney">
													</el-table-column>`


