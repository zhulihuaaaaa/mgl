/**
 * 下拉列表组件
 * <el-input  v-else-if="type === 'crmClients'" v-model="selectData" placeholder="请输入客户"  @bulr="crmClients()"></el-input>
 * @returns
 */
define(['ajax'], function (ajax) {
	return {
		name: 'component-select',
		template: `
			<el-select  v-if="type != 'crmClients'" v-model="selectData" :value-key="prop" :filterable="search" :clearable="true" :name="name" :id="id"
			    :remote="remoteseach"
			    :placeholder=" remoteseach || search ? '请输入关键字':'请选择'"
			    :remote-method="remoteMethod"
			    :disabled = "isdisabled"
			    :loading="loading"
			    @clear="doClear"
			    @focus ="fetchData">
			  <el-option
			      v-for="item in options"
			      :key="item.value"
			      :label="item.label"
			      :value="item.value">
				</el-option>
			</el-select>
			<el-input v-else-if="type == 'crmClients' " v-model="temporary" placeholder="请输入客户" :name="name" :disabled = "isdisabled"  @blur="crmClients" @focus="inputBlur = false">
				<i v-if="showIcon && selectData != null && selectData.length === 32" slot="suffix" class="el-input__icon el-icon-success" style="color: #67c23a"></i>
				<i v-else-if="showIcon" slot="suffix" class="el-input__icon el-icon-error" style="color: #f56c6c"></i>
			</el-input>
			
		`,
		props: {
			/**
			 * all 全部仓库 real 真实 virtual 虚拟 是否需要查询虚拟仓库
			 */
			depot:{
				type: String,
        		default: 'all'
			},
			/**
			 * 是否禁用
			 */
			isdisabled:{
				type: Boolean,
    			default: false
			},
			/**
			 * 选中项
			 */
			value: {
				type: [Object, String, Number]
			},
			/**
			 * 选中项为Object时，prop为必填项
			 */
			prop: {
				type: String
			},
			/**
			 * 表单验证的需要
			 */
			name:{
				type: String
			},
			/**
			 * 是否需要远程搜索
			 */
			remoteseach:{
				type: Boolean,
	        	default: false
			},
			/**
			 * 需要根据某数据来查询出一些下拉数据
			 */
			param: {
				type: [String, Object,Array]
			},
			dictMallDepot:{
				type: String
			},
			id: {
				type: String
			},
			ignoreClientId: {
				type: String
			},
			type: {
				/**
				 * select类型 baseProduct:产品名称 baseProcess: 表面 mallMnfcts :制造商
				 * crmClients :客户 BusinessType:业务类型 ApprovalState:审批状态
				 * FeeType:费用类型 GoodsSource :货物来源 InOrNotStock: 是否在库
				 * InspectionType:验货状态 InstockState :入库单状态 GoodsPaymentState
				 * :货款状态 DepositState :保证金状态 ContractBillType :合同类型 DepositRate
				 * :保证金 DictMallSpec :材质 民资 inspectionState:验货入库状态 EdgeType: 边部
				 * 名字 DictMallDepot :仓库 invoice: 开票 commission :手续 financeCode:
				 * 财务单号 contractCode:合同自编号 subCode:验货子单号  contractNum 合同编号 
				 * PartyA: 甲方客户 RedeemBillState: 赎货单状态    orderCode 系列（品种）  (surface 根据品种和材质查询)
				 * InvoiceType 发票类型
				 * OutstockState 提货单状态
				 * manufacturer:(根据品种来查询出货物的生产厂家)   DictGrade 等级  DictStd 执行标准  role 角色列表 流程模块 flow
				 */
				type: String,
				required: true
			},
			/**
			 * 是否搜索
			 */
			search:{
				type: Boolean,
		        default: false
			},
			

		},
		data () {
			return {
				options: [
					{
						label: '',
						value: ''
					}
				],
				optionsCopy: [
					{
						label: '',
						value: ''
					}
				],
				searchParam: {
					dto: {},
					// 页码
					pageNum: 0,
					// 分页大小
					pageSize: 0,
					// 排序
					orderByClause: ''
				},
				loading:false,
				temporary:'',
				// 输入框失去焦点
				inputBlur: false
			}
		},
		computed: {
			selectData: {
				get () {
					return this.value
				},
				set (val) {
					this.$emit('input', val)
					this.$emit('change', val)
				}
			},
			filterable () {
				if (['base'].indexOf(this.type) > -1) {
					return true
				}
				return false
			},
			showIcon () {
				return this.temporary != null && this.temporary != '' && this.inputBlur
			}
		},
		watch: {
			selectData:{  
                handler:function(val, oldval){
                	if(this.type =='crmClients' && this.selectData){
                		if (this.temporary == '' && this.selectData && this.selectData.length == 32) {
                			this.crmClientsbyId()              			
                		}
                	}
                	if(this.type =='contractCode' && this.selectData){
                		if (this.temporary == '' && this.selectData && this.selectData.length == 32) {
                			this.contractCode()             			
                		}
                	}
                },
                immediate: true
            }, 
			param: {
				handler: function (val, old) {
					var same = true
					if (val != null && old != null) {
						if (val instanceof String) {
							if (val !== old) {
								same = false
							}
						} else if (val instanceof Object) {
							for (var key of Object.keys(val)) {
								if (val[key] !== old[key]) {
									same = false
									break
								}
							}
						}
					} else {
						same = false
					}
					if (!same) {
						// this.fetchData()
					}
				},
				immediate: true
			},
			dictMallDepot: function (val, old) {
				this.dictMallDepotMethod(val)
			},
			type: {
				handler: function (val, old) {
					if (val !== 'crmClients') {
						this.fetchData()
					}
				},
				immediate: true
			},
			ignoreClientId: function (val, old) {
				var vm = this
				this.options = $.extend(true, [], this.optionsCopy)
				if (val) {
					this.options.forEach(function (item, index) {
						if (item.value == val) {
							vm.options.splice(index, 1)
						}
					})
				}
			}
		},
		methods: {
			/**
			 * 获取下拉数据
			 */
			fetchData () {
				let vm = this
				let val = this.type
				this.loading =true
				if(val == 'baseProduct'){
					this.baseProduct()
				} else if (val =='baseProcess') {
					 vm.searchParam.dto.processName = ''
					this.baseProcess()
				}else if (val == 'mallMnfcts') {
					this.mallMnfcts("") 
				} else if (val == 'contractCode') {
					this.contractCode()
				} else if (val == 'contractNum') {
					this.contractNum()
				} else if (val == 'DictMallDepot'){
					this.dictMallSpec()
				} else if (val == 'financeCode') {
					this.financeCode()
				}  else if (val =='subCode') {
					let one = ""
					this.subCode(one)
				} else if (val === 'invoice') {
					this.invoiceMethod()
				} else if (val === 'commission60') {
					this.commissionMethod60()
				} else if (val === 'commission90') {
					this.commissionMethod90()
				} else if (val === 'numberUnit') {
					this.numberUnit()
				} else if (val === 'weightUnit') {
					this.weightUnit()
				}else if (val === 'texture') {
					this.texture()
				}else if (val === 'orderCode') {
					// 系列    
					this.orderCode() 
				}else if (val === 'surface') {
					this.surface()
				} else if (val === 'trademark') {
					this.trademark()
				} else if (val === 'manufacturer') {
					
					this.manufacturer()
				}  else if (val === 'DictGrade') {
					this.dictGrade()  
				} else if (val === 'DictStd') {
					this.dictStd() 
				} else if (val === 'role') {
					this.role()
				} else if (val === 'flow') {
					this.flow()
				}  else { 
					// 枚举类  
					this.general(val)
				}
				this.defaultSelected()
				this.remoteNeed(val)
			},
			// 远程搜索的特殊需求
			remoteNeed(val){
//				if(val =='crmClients'){
//					this.remoteseach = true
//				}
			},
			// 远程搜索
			remoteMethod (query){
				let val = this.type
				let vm = this
				if (val == 'baseProcess'){
				  vm.searchParam.dto.processName = query
				  this.baseProcess()
				} else if (val == 'crmClients') {
					this.crmClients(query)
				} else if (val == 'mallMnfcts'){
					this.mallMnfcts(query)
				} else if (val =='baseProduct'){
					vm.searchParam.dto.productName = query
					this.baseProduct()
				} else if (val =='contractCode'){
					this.contractCode(query)
				} else if (val == 'contractNum') {
					this.contractNum(query)
				} else if (val == 'financeCode') {
					this.financeCode(query)
				} else if (val =='subCode') {
					this.subCode(query)
				}
				this.defaultSelected()
			},
			// 默认选中
			defaultSelected(){
//				let vm = this
//				let j = 0
//				if (vm.selectData != null && vm.selectData !== '') {
//					for(var i in vm.options){
//						let one = vm.options[i]
//						if (one.value === vm.selectData){
//							j +=1
//						}
//					}
//					
//				}
			},
			// 品名
			baseProduct () {
			  let vm = this
			  ajax.post("/baseProduct/findAll",vm.searchParam).then(function (res) {
				  var options = []
				  let datas = res.data
				  for( var i  in datas){
					  let option = {
						  label: datas[i].productName,
						  value: datas[i].productId
					  }
					  if(datas[i].status =='Y'){
						  options.push(option)						  
					  }
				  }
				  vm.options = options
				  vm.loading = false
			  }, function () {
				  vm.loading = false
			  })
			},
			// 仓库
			dictMallSpec() {
				  let vm =this
				  ajax.get("/base/findAllDictMallDepot",{depot : vm.depot}).then(function (res) {
					  var vmodel = vm.selectData
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i][1]
						  option.value = datas[i][0]
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options 
					  vm.loading = false
					}, function () {
						vm.loading = false
					})
			  },
			  // 表面
			  baseProcess () {
				  let vm = this
				  ajax.get("/baseProcess/findAll",{materialName:this.param}).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].name
						  // option.value = datas[i].processId
						  option.value = datas[i].name
						  options.push(option)
					  }
					  vm.options = options 
					  vm.loading = false
					}, function () {
						vm.loading = false
					})
			  },
			  // 制造商
			  mallMnfcts (query) {
				  let vm = this
				  ajax.get("/base/getDictMallMnfcts",{"mnfctName":query}).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].mnfctName
						  option.value = datas[i].mnfctId
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options 
					  vm.loading = false
					}, function () {
						vm.loading = false
				 })
			  },
			  /**
				 * 客户
				 */
			  crmClients (query) {
				  let vm = this
				  vm.inputBlur = true
				  if(vm.temporary != null && vm.temporary != ''){					  
					  ajax.get("/base/getCrmClients",{"clientName":vm.temporary}).then(function (res) {
						  if(res.data[0]){
							  vm.selectData = res.data[0].clientId
						  }
					  }, function () {
						  vm.selectData = ''
					  })
				  } else {
					  vm.selectData = ''
				  }
			  },
		  	/**
			 * 客户Id
			 */
			  crmClientsbyId () {
				  let vm = this
				  ajax.get("/base/getCrmClientById",{"clientId":vm.selectData}).then(function (res) {
					if(res.data){
						vm.temporary = res.data.clientName
						vm.selectData =  res.data.clientId
						//vm.$emit('input', res.data.clientName)							
					}
				  }, function () {
				  })
			  },
			  /**
			   * 合同单号搜索ID
			   */
			  contractCode (query) {
				  let vm = this
				  var params = {
					  contractCode: query,
					  buyerId: null,
					  goodsSource: null,
					  contractId:null
				  }
				  if (vm.param) {
					  if (vm.param instanceof String) {
						  params.buyerId = vm.param
					  } else if (vm.param instanceof Object) {
						  params.buyerId = vm.param.buyerId//vm.param.sellerId
						  params.goodsSource = vm.param.goodsSource
					  }
				  }
				  if(vm.selectData!=null&&(""+vm.selectData).length==32){
					  params.contractId = vm.selectData
				  }
				  ajax.post("/contract/findSelectOptions", params).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].contractCode
						  option.value = datas[i].contractId
						  options.push(option)
					  }
					  vm.loading = false
//					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options 
					}, function () {
						vm.loading = false
					})
			  },
			  /**
			   * 合同编号搜索ID
			   */
			  contractNum(query) {
				  let vm = this
				  var params = {
					  contractCode: query,
					  sellerId: null,
					  goodsSource: null,
					  contractId:null
				  }
				  if (vm.param) {
					  if (vm.param instanceof String) {
						  params.sellerId = vm.param
					  } else if (vm.param instanceof Object) {
						  params.sellerId = vm.param.buyerId//vm.param.sellerId
						  params.goodsSource = vm.param.goodsSource
					  }
				  }
				  if(vm.selectData!=null&&(""+vm.selectData).length==32){
					  params.contractId = vm.selectData
				  }
				  ajax.post("/contract/findSelectOptions", params).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].contractNo
						  option.value = datas[i].contractId
						  options.push(option)
					  }
//					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options 
					  vm.loading = false
					}, function () {
						vm.loading = false
					})
			  },
			  
			  
			  /**
				 * 开票费用
				 */
			  invoiceMethod () {
				  let vm = this
				  ajax.get("/base/getInvoice",{"customerId":this.param}).then(function (res) {
					  vm.options = res.data
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  /**
				 * 手续费费用
				 */
			  commissionMethod60 () {
				  let vm = this
				  ajax.get("/base/getCommission60",{"customerId": this.param}).then(function (res) {
					  vm.options =  res.data
					  vm.loading = false
				  	}, function () {
				  		vm.loading = false
				  })
			  },
			  commissionMethod90 () {
				  let vm = this
				  ajax.get("/base/getCommission90",{"customerId": this.param}).then(function (res) {
					  vm.options =  res.data
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  /**
				 * 仓库
				 */
			  dictMallDepotMethod (query) {
				  let vm = this
				  if(query != ""){
					  ajax.get("/redRedeemBill/findInvIdsbyContractId",{"contractId":query}).then(function (res) {
						  var options = []
						  let datas = res.data
						  for( var i  in datas){
							  let option = {
								  label:'',
								  value:''
							  }
							  if(datas[i] != null){
								  ajax.get("/base/getDictMallDepot",{"storageId":datas[i]}).then(function (res2) {
									  option.label = res2.data.dptName
									  option.value = res2.data.dptId
									  options.push(option)
									  
								  })
								  vm.loading = false
							  }
						  }
						  vm.options = options
						})
				  }
				  else{
					  options=null
				  }
			  },
			  /**
				 * 根据验货子单号来搜索
				 */
			  subCode(query){
				  let vm = this
				  ajax.get("/warranty/sub/findAll",{"subCode":query}).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  let one = datas[i].insInspectionSub.subCode
						  if (one != null){
							  option.label = one
							  option.value = one
						  }
						  options.push(option)
					  }
					  vm.options = options
					  vm.loading = false
				  })
			  },
			  /**
				 * 财务单号搜索ID
				 */
			  financeCode (query) {
				  let vm = this
				  var params = {
					  dto : {
						  financeCode: query
					  }
				  }
				  ajax.post("/finance/findAll", params).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].financeCode
						  option.value = datas[i].financeBillId
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options 
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  /**
			   * 系列(品种)
			   */
			  orderCode(){
				  let vm = this
				  ajax.post("/base/findAllOrderCode").then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].orderCode
						  option.value = datas[i].orderCode
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  // 材质
			  texture(){
				  let vm = this
				  ajax.get("/base/findAllDictMallSpec",{"orderCode": this.param}).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].quality
						  option.value = datas[i].quality
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  // 表面 根据品种和材质查询
			  surface () {
				  let vm = this
				  let one = {"materialName": this.param[0],"orderCode":this.param[1]}
				  ajax.get("/base/findAllSurface",one).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].name
						  option.value = datas[i].name
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  // 牌号 根据品种和材质查询
			  trademark(){
				  let vm = this
				  let one = {"materialName": this.param[0],"orderCode":this.param[1]}
				  ajax.get("/base/findAllTrademark",one).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].trademark
						  option.value = datas[i].trademark
						  options.push(option)
					  }
					
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  // 生产厂家 根据品种和材质查询
			  manufacturer(){
				  let vm = this
				  ajax.get("/base/findAllManufacturer",{"orderCode": this.param}).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].mnfctName
						  option.value = datas[i].mnfctId
						  options.push(option)
					  }
					  vm.options = options
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  dictGrade(){
				  let vm = this
				  ajax.get("/base/findAllDictGrade",{"orderCode": this.param}).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].dictName
						  option.value = datas[i].dictName
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  // 根据品种来查询出执行标准  
			  dictStd(){
				  let vm = this
				  ajax.get("/base/findAllDictStd",{"orderCode": this.param}).then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].stdName
						  option.value = datas[i].stdName
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  // 角色列表
			  role(){
				  let vm = this
				  ajax.get("/base/getAllrole").then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  option.label = datas[i].roleName
						  option.value = datas[i].roleId
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  // 流程模块
			  flow(){
				  let vm = this
				  ajax.get("/base/getAllmodel").then(function (res) {
					  var options = []
					  let datas = res.data
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  
						  option.label = datas[i][1]
						  option.value = datas[i][0]
						  options.push(option)
					  }
					  vm.addBlankLabelToOption(options, vm.selectData)
					  vm.options = options
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  general (general) {
				  let vm =this
				  var common = []
				  common[0] = general
				  ajax.getOptions(common).then(function (res) {
					  var options = []
					  let datas = res.data[general]
					  for( var i  in datas){
						  let option = {
							  label:'',
							  value:''
						  }
						  let one = datas[i]
						  option.label = one[1]
						  option.value = one[0]
						  options.push(option)
					  }
					  vm.options = options 
					  vm.loading = false
				  }, function () {
					  vm.loading = false
				  })
			  },
			  // 数量单位
			  numberUnit () {
				  let option=[]
				  let vm =this
				  option.push({
					  label: '个',
					  value: '个'
				  }),
				  option.push({
					  label: '张',
					  value: '张'
				  })
				  this.options = option
				  vm.loading = false
			  },
			  // 重量单位
			  weightUnit () {
				  let option=[]
				  let vm =this
				  option.push({
					  label: '吨',
					  value: '吨'
				  }),
				  option.push({
					  label: '千克',
					  value: '千克'
				  }),
				  option.push({
					  label: '公斤',
					  value: '公斤'
				  })
				  this.options = option
				  vm.loading = false
			  },
			  isExist(){
				  for (let one of this.options) {
					 if(this.value == one.value){
						 return false
					 }
				  }
				  return true
			  },
			  /**
			   * 检测值是否在option中存在，
			   * 如果不存在的话添加一个label为空，value为value的选项
			   */
			  addBlankLabelToOption (options, value) {
				  if (options && value) {
					  var count = 0
					  options.forEach(function (item, index) {
						  if (item.value == value) {
							  count++
						  }
					  })
					  if (count == 0) {
//						  options.push({
//							  label: '',
//							  value: value
//						  })
						  this.selectData=''
					  }
				  }
			  },
			  doClear () {
				  this.selectData = ''
				 //  this.fetchData()
			  }
		}
	}
})