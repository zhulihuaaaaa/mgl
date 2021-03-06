/**
 * 审批管理
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
					
				},
				// 页码
				pageNum: 0,
				// 分页大小
				pageSize: 20,
				// 排序
				orderByClause: ''
			},
			// 表格数据
			tableData: {
				list:[]
			},
			tableConfig: {
				loading: false,
				columns: ['operation', 'custom']
			},
			operation:[
				'delete','edit'
			],
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
				ajax.findPage('/baseApproval', vm.searchParam).then(function (res) {
					// vm.tableData.list = res.data
					vm.fomat(res.data)
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
			},
			fomat(one){
				let three =[]
				for(var i  in one){
					let two ={
						name: "",
						module:"",
						step:[]
					}
					two.name = i
					two.module =  one[i][one[i].length-1].modelName
					two.step = $.extend(true,[], one[i])
					three.push(two)
				}
				this.tableData.list= three
			},
			edit(row){
				
				addOrEdit(1,row)
			},
			del(row){
				let vm =this
				ajax.delete('/baseApproval', row.module).then(function (res) {
					// vm.tableData.list = res.data
					vm.fetchData()
				}, function () {
					
				})
				console.log("row",row)
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
	 * 新增或编辑审批
	 * @param type 操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		var tableContent
		var dialog = util.dialog({
			id: 'dialogContent',
			width: 800,
			height: 200,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建审批流程' : '编辑审批流程',
			content: `
				<form id="dialog-content">
					<template>
						 <div v-if="isShow">选择模块:<component-select v-model="moduleName" type="flow" v-if="isShow" style="width: 600px;">
                         			</component-select>
             			</div>
                         <div v-if="moduleName" style="margin-top: 10px;">
						<el-steps :active="active" space="400" finish-status="wait">
						  	<el-step v-for="(process, index) of roleArr" :key="process.roleId">
						  		<i slot="icon">{{index+1}}</i>
						  		<el-tag 
						  		  :closable="true"
						  		  slot="title"
						  		  :disable-transitions="true"
			                      color="rgba(0, 0, 0, 0)"
			                      @close="deleteProcess(index)"
			                      style="border: 0;">
						  		 <component-select v-model="process.roleId" style="width:60%" type="role" @change="selectOperation(process, index)">
		                         </component-select>
								</el-tag>
							</el-step>
							<el-step>
			                  <el-tooltip content="添加流程" placement="top" slot="icon">
			                    <el-button icon="el-icon-plus" type="text" size="mini" @click="addProcess"></el-button>
			                  </el-tooltip>
			                </el-step>
						</el-steps>
						</div>
					</template>
				</form>
				`,
				okValue: '确定',
				ok: function () {
					if(type ===0){
						tableContent.saveProcess()						
					}else if(type ===1){
						tableContent.updateProcess()
					}
					return false
				},
				cancelValue: '取消',
				onshow: function () {
					if (tableContent == null) {
						tableContent = new Vue({
							el: '#dialog-content',
							data () {
								return {
									 model:data,
									 active:0,
									 isShow: type === 0,
									 roleArr:[],
									 addArr:[],
									 deleteArr:[],
									 upadate:[],
									 moduleName:"",
									 process:{
										 approvalProcessId:"",
										 module:"",
										 roleId:"",
										 processIndex:""
									 }
								}
							},
							watch: {
								
							},
							methods: {
								addProcess(){
									let one = $.extend(true,{}, this.process)
									this.roleArr.push(one)
									this.addArr.push(one)
								},
								deleteProcess(index){
									this.deleteArr.push(this.roleArr[index])
									this.roleArr.splice(index,1)
								},
								selectOperation(obj,index){
									obj.processIndex = index+1
								},
								//保存流程之前的操作
								beforeSave(){
									for(var i of this.roleArr){
										i.module = this.moduleName
									}
								},
								//保存流程
								saveProcess(){
									let vm =this
									this.beforeSave()
									let sysList =  $.extend(true,[], this.roleArr)
									ajax.save('/baseApproval',sysList).then(function (res) {
										page.fetchData()
										util.dialog({getIdClose: 'dialogContent'})
									}, function () {
										
									})
								
								},
								updateProcess(){
									let vm =this
									this.beforeSave()
									let sysList =  $.extend(true,[], this.roleArr)
									let addList =  $.extend(true,[], this.addArr)
									let deleteList = $.extend(true,[], this.deleteArr)
									let jsonObject = {"sysList":sysList,"addList":addList,"deleteList":deleteList}
									ajax.update('/baseApproval',jsonObject).then(function (res) {
										page.fetchData()
										util.dialog({getIdClose: 'dialogContent'})
									}, function () {
										
									})
								}
							},
							mounted () {
								let vm = this
								if(!this.isShow){
									vm.moduleName = vm.model.module
									
									let one = vm.model.step
									for(var i of one){
										let two = $.extend(true,{}, this.process)
										two.module = i.modelName
										two.roleId = i.process.roleId
										two.approvalProcessId = i.process.approvalProcessId
										two.processIndex = i.processIndex
										vm.roleArr.push(two)
									}
								}
							}
						})
					}
				}
		})
	}
	//---------------
	// 合同 - 表单验证
	//---------------
	function contractValid () {
		util.formValid({
			selector: '#dialog-content',
			onkeyup: false,
			errorPlacement: function(error, element) { //错误信息位置设置方法
				if (element.parents('.cell').length > 0) {
					error.appendTo( element.parents('.cell').find('.err') ) //这里的element是录入数据的对象
				} else {
					 error.appendTo(element.parent())
				}
			},
			rules: {
				'contractType': {
					required: true
				},
				'contractCode': {
					required: true
				},
				'sellerId': {
					required: true,
					notEqualTo: 'input[name="buyerId"]'
				},
				'buyerId': {
					required: true,
					notEqualTo: 'input[name="sellerId"]'
				},
				'signDate': {
					required: true
				},
				'contractPeriod': {
					required: true,
					digits: true
				},
				'depositRate': {
					required: true
				},
				'depositFee': {
					required: true
				},
				'invoiceBaseFee': {
					required: true
				},
				'commissionRate': {
					required: true
				},
				'product[]': {
					required: true
				},
				'dictMallSpec[]': {
					required: true
				},
				'baseProcess[]': {
					required: true
				},
				'labelThick[]': {
					required: true
				},
				'labelWidth[]': {
					required: true
				},
				'goodsLength[]': {
					required: true
				},
				'edge[]': {
					required: true
				},
				'mallMnfcts[]': {
					required: true
				},
				'amount[]': {
					required: true,
					min: 1
				},
				'netWeight[]': {
					required: true,
					min: 1
				},
				'unitContractPrice[]': {
					required: true,
					min: 1
				}
				
			},
			messages: {
				'contractType': {
					required: '请选择合同类型'
				},
				'contractCode': {
					required: '请输入合同编号'
				},
				'sellerId': {
					required: '请选择乙方',
					notEqualTo: '不能与甲方相同'
				},
				'buyerId': {
					required: '请选择甲方',
					notEqualTo: '不能与乙方相同'
				},
				'signDate': {
					required: '请选择签订日期'
				},
				'contractPeriod': {
					required: '请输入合同期限',
					digits: '合同期限须为整数'
				},
				'depositRate': {
					required: '请选择保证金比例'
				},
				'depositFee': {
					required: '请输入保证金金额'
				},
				'invoiceBaseFee': {
					required: '请选择开票费'
				},
				'commissionRate': {
					required: '请输入手续费'
				},
				'product[]': {
					required: '请选择品名'
				},
				'dictMallSpec[]': {
					required: '请选择材质'
				},
				'baseProcess[]': {
					required: '请输入表面'
				},
				'labelThick[]': {
					required: '请输入厚度'
				},
				'labelWidth[]': {
					required: '请输入宽度'
				},
				'goodsLength[]': {
					required: '请输入长度'
				},
				'edge[]': {
					required: '请选择边部'
				},
				'mallMnfcts[]': {
					required: '请输入厂家'
				},
				'amount[]': {
					required: '请输入数量',
					min: '数量最小为1'
				},
				'netWeight[]': {
					required: '请输入重量',
					min: '重量最小为1'
				},
				'unitContractPrice[]': {
					required: '请输入含税单价',
					min: '含税单价最小为1'
				}
			}
		})
	}
	//---------------
	// 合同编辑 - 表单验证
	//---------------
	function contractValidDetail () {
		util.formValid({
			selector: '#contract-dialog-content',
			onkeyup: false,
			rules: {
				'contractType': {
					required: true
				},
				'contractCode': {
					required: true
				},
				'sellerId': {
					required: true,
					notEqualTo: 'input[name="buyerId"]'
				},
				'buyerId': {
					required: true,
					notEqualTo: 'input[name="sellerId"]'
				},
				'signDate': {
					required: true
				},
				'contractPeriod': {
					required: true,
					digits: true
				},
				'depositRate': {
					required: true
				},
				'depositFee': {
					required: true
				},
				'invoiceBaseFee': {
					required: true
				},
				'commissionRate': {
					required: true
				}
			},
			messages: {
				'contractType': {
					required: '请选择合同类型'
				},
				'contractCode': {
					required: '请输入合同编号'
				},
				'sellerId': {
					required: '请选择乙方',
					notEqualTo: '不能与甲方相同'
				},
				'buyerId': {
					required: '请选择甲方',
					notEqualTo: '不能与乙方相同'
				},
				'signDate': {
					required: '请选择签订日期'
				},
				'contractPeriod': {
					required: '请输入合同期限',
					digits: '合同期限须为整数'
				},
				'depositRate': {
					required: '请选择保证金比例'
				},
				'depositFee': {
					required: '请输入保证金金额'
				},
				'invoiceBaseFee': {
					required: '请选择开票费'
				},
				'commissionRate': {
					required: '请输入手续费'
				}
			}
		})
	}
	//---------------
	// 合同货物 - 表单验证
	//---------------
	function contractDetailValid () {
		util.formValid({
			selector: '#dialog-content',
			onkeyup: false,
			rules: {
				'product': {
					required: true
				},
				'dictMallSpec': {
					required: true
				},
				'baseProcess': {
					required: true
				},
				'labelThick': {
					required: true
				},
				'labelWidth': {
					required: true
				},
				'goodsLength': {
					required: true
				},
				'edge': {
					required: true
				},
				'mallMnfcts': {
					required: true
				},
				'amount': {
					required: true,
					min: 1
				},
				'netWeight': {
					required: true,
					min: 1
				},
				'unitContractPrice': {
					required: true,
					min: 1
				}
				
			},
			messages: {
				'product': {
					required: '请选择品名'
				},
				'dictMallSpec': {
					required: '请选择材质'
				},
				'baseProcess': {
					required: '请输入表面'
				},
				'labelThick': {
					required: '请输入厚度'
				},
				'labelWidth': {
					required: '请输入宽度'
				},
				'goodsLength': {
					required: '请输入长度'
				},
				'edge': {
					required: '请选择边部'
				},
				'mallMnfcts': {
					required: '请输入厂家'
				},
				'amount': {
					required: '请输入数量',
					min: '数量最小为1'
				},
				'netWeight': {
					required: '请输入重量',
					min: '重量最小为1'
				},
				'unitContractPrice': {
					required: '请输入含税单价',
					min: '含税单价最小为1'
				}
			}
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
				ajax.detail('/contract', {
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
							},
							del (rowData) {
								let vm = this
								ajax.get('/contract/deleteContractDetail', {'detailId': rowData.contractDetailId}).then(function (res) {
									if (res.state === 1) {
										detail.fetchData(1)
									}
								}, function () {
								})
							},
							// 明细添加编辑
							addOrEdit (type) {
								let contractId = this.model.contractId
								var detailDialog
								util.dialog({
									id: 'detailDialogContent',
									width: 1230,
									height: 500,
									fixed: true,
									skin: 'crm-form crm-form-over',
									title: type === 0 ? '新建货物明细' : '编辑货物明细',
									content: `
										<form id="detail-dialog-content">
											<template>
												<h5 class="bg-tit">
													<span>货物信息</span>
													<button type="button" class="ui-btn pull-right btn_new_line" @click="addLine()">新增</button>
												</h5>
												<div class="ui-row">
													<div class="ui-col">
														  <el-table 
														  	:data="contract.contractDetail"
														    border
														    style="width: 100%">
														    
														    <el-table-column label="品类" width="180">
														       <template slot-scope="scope">
														       		<div>
																		<component-select :id="'product'+scope.$index" v-model="scope.row.productId" type="baseProduct" :search="true" :remoteseach="true" name="product[]" @change="getProductDetail(scope.$index, scope.row.productId)">
						                                         		</component-select>
					                                         		</div>
					                                         		<div class="err"></div>
														       </template>
														    </el-table-column>
														    <el-table-column label="系列" width="180">
														       <template slot-scope="scope">
														       		<div>
																		<component-select :id="'orderCode'+scope.$index" v-model="scope.row.orderCode" type="orderCode" :search="true" :remoteseach="true" name="orderCode[]"  @change="doclear(scope.$index)">
						                                         		</component-select>
					                                         		</div>
					                                         		<div class="err"></div>
														       </template>
														    </el-table-column>
														     <el-table-column label="材质" width="180">
														       <template slot-scope="scope">
														       		<div>
															       		<component-select :id="'dictMallSpec'+scope.$index" v-model="scope.row.materialId" type="texture" name="dictMallSpec[]"  :param="scope.row.orderCode">
						                                         		</component-select>
					                                         		</div>
					                                         		<div class="err"></div>  
														       </template>
														    </el-table-column>
														    
															<el-table-column label="表面" width="180">
																<template slot-scope="scope">
																	<div>
																		<component-select :id="'baseProcess'+scope.$index" v-model="scope.row.surfaceId" type="surface" :search="true" :remoteseach="true" name="baseProcess[]"  :param="[scope.row.materialId,scope.row.orderCode]">
						                                         		</component-select>
						                                         	</div>
					                                         		<div class="err"></div>
																</template>
															</el-table-column>
															
															<el-table-column label="规格(mm)" width="280">
																<template slot-scope="scope">
																	<div class="ui-row">
																		<input type="text" :id="'labelThick'+scope.$index" class="ui-input-control ui-col-25" v-model="scope.row.labelThick" name="labelThick[]">
																		<label class="ui-label-control ui-col-10">&nbsp;*</label>
																		<input type="text" :id="'labelWidth'+scope.$index" class="ui-input-control ui-col-25" v-model="scope.row.labelWidth" name="labelWidth[]">
																		<label class="ui-label-control ui-col-10">&nbsp;*</label>
																		<input type="text" :id="'goodsLength'+scope.$index" class="ui-input-control ui-col-25" v-model="scope.row.goodsLength" name="goodsLength[]">
																	</div>
																	<div class="ui-row err">
																	</div>
																</template>
															</el-table-column>
														    
														    <el-table-column label="边部" width="180">
																<template slot-scope="scope">
																	<div>
																		<component-select :id="'edge'+scope.$index" v-model="scope.row.edge" type="EdgeType" name="edge[]">
						                                         		</component-select>
					                                         		</div>
					                                         		<div class="err"></div>
																</template>
															</el-table-column>
															
															<el-table-column label="数量" width="200">
																<template slot-scope="scope">
																	<div>
																		<el-input-number size="small" :class="'valid-amount'+scope.$index" v-model="scope.row.amount" controls-position="right" :min="1" name="amount[]"></el-input-number>
																		{{ scope.row.amountUnit }}
																	</div>
					                                         		<div class="err"></div>
																</template>
															</el-table-column>
															
															<el-table-column label="重量" width="200">
																<template slot-scope="scope">
																	<div>
																		<el-input-number size="small" :class="'valid-netWeight'+scope.$index" v-model="scope.row.netWeightDisplay" controls-position="right" :min="1" name="netWeight[]"></el-input-number>
																		{{ scope.row.netWeightUnit }}
																	</div>
																	<div class="err">
																	</div>
																</template>
															</el-table-column>
															
															<el-table-column label="含税单价" width="250">
																<template slot-scope="scope">
																	<div>
																		<el-input-number size="small" :class="'valid-unitContractPrice'+scope.$index" v-model="scope.row.unitContractPrice" controls-position="right" :min="0" name="unitContractPrice[]"></el-input-number>
																		<span v-if="scope.row.netWeightUnit != ''">元/{{scope.row.netWeightUnit}}</span>
																	</div>
					                                         		<div class="err"></div>
																</template>
															</el-table-column>
															
															<el-table-column label="含税金额(元)" width="180">
																<template slot-scope="scope">
																	{{ scope.row.contractMoney }}
																</template>
															</el-table-column>
															
															<el-table-column label="操作" width="180">
																<template slot-scope="scope">
																	<span class="ui-btn ui-blue" @click="copyLine(scope.$index, scope.row)">复制</span>
																	<span class="ui-btn ui-red" @click="delLine(scope.$index, scope.row)">删除</span>
																</template>
															</el-table-column>
															
														  </el-table>
													</div>
												</div>
												<div class="ui-row  pull-right" style="margin-top: 10px">
													<div class="ui-form-group ui-col" style="width:450px">
														<div class="ui-form-group ui-col-40">
															<label class="ui-label-control ui-col-40">货物总重</label>
															<label class="ui-label-control ui-col-60">{{totalWeight}} 吨</label>
														</div>
														<div class="ui-form-group ui-col-60">
															<label class="ui-label-control ui-col-30">货物总价</label>
															<div class="ui-col-50">
																<el-input-number size="small" v-model="contract.entity.totalMoney" controls-position="right" :min="0" :step="0.01"></el-input-number>
															</div>
															<label class="ui-label-control ui-col-15">元</label>
														</div>
													</div>
												</div>
											</template>
										</form>
									`,
									okValue: '确定',
									ok: function() {
										// 禁用提交按钮
										util.setLoading({
											selector: '[i-id="ok"]'
										})
										ajax.post('/contract/updateContractDetails', detailDialog.contract).then(function (result) {
											util.promptMsg({
												content: result.message
											})
											if (result.state === 1) {
												page.fetchData()
												detail.fetchData(1)
												util.dialog({getIdClose:"detailDialogContent"})
											}
										}, function () {
											// 使提交按钮可用
											util.setLoading({
												selector: '[i-id="ok"]',
												isClick: false
											})
										})
										return false
									},
									cancelValue: '取消',
									onshow: function () {
										if (detailDialog == null) {
											detailDialog = new Vue({
												el: '#detail-dialog-content',
												data() {
													return {
														contractId: contractId,
														totalWeight: 0,
														type: type,
														contract: {
															entity: {
																contractType: '',
																contractNo: '',
																sellerId: '',
																buyerId: '',
																signDate: '',
																contractPeriod: '90',
																mallMnfct: '',
																depositRate: '',
																depositFee: '',
																invoiceBaseFee: '',
																commissionRate: '',
																notes: '',
																totalWeight: 0,
																totalMoney: 0
															},
															contractDetail: [{
																productId: '',
																materialId: '',
																surfaceId: '',
																labelThick: '',
																labelWidth: '',
																goodsLength: '',
																edge: '',
																mnfctId: '',
																mnfctName: '',
																amount: 0,
																netWeight: 0,
																unitContractPrice: 0,
																contractMoney: 0,
																amountUnit: '',
																netWeightUnit: '',
																precision: 0,
																unitRate: 0,
																netWeightDisplay: 0,
															}],
															attach: [],
															feeRates: [
																{
																	feeDates: 60,
																	feeValue: 0
																},
																{
																	feeDates: 90,
																	feeValue: 0
																}
															],
															delDetialId:[]
														},
														newLineData: {
															productId: '',
															materialId: '',
															surfaceId: '',
															labelThick: '',
															labelWidth: '',
															goodsLength: '',
															edge: '',
															mnfctId: '',
															mnfctName: '',
															amount: 0,
															netWeight: 0,
															unitContractPrice: 0,
															contractMoney: 0,
															amountUnit: '',
															netWeightUnit: '',
															precision: 0,
															unitRate: 0,
															netWeightDisplay: 0,
														}
													}
												},
												watch: {
													'contract.contractDetail': {
														handler: function (newVal, oldVal) {
															var vm = this
															var totalWeight = 0
															var totalMoney = 0
															vm.$nextTick(function () {
																newVal.forEach(function (value, index) {
																	if (Math.floor(value.amount) !== value.amount) {
																		vm.$set(vm.contract.contractDetail[index], 'amount', Math.floor(value.amount))
																	}
																	value.mnfctId = vm.contract.entity.mallMnfct
																	// 将重量统一为千克
																	value.netWeight = parseInt(value.netWeightDisplay * value.unitRate)
																	// 总的kg数
																	totalWeight += value.netWeight
																	// 每行的价格
																	//value.contractMoney = parseFloat(value.netWeightDisplay == null ? 0 : value.netWeightDisplay) * parseFloat(value.unitContractPrice == null ? 0 : value.unitContractPrice)
																	//value.contractMoney = (parseFloat(value.netWeightDisplay == null ? 0 : value.netWeightDisplay) * parseFloat(value.unitContractPrice == null ? 0 : value.unitContractPrice)).toFixed(2)
																	value.contractMoney = parseFloat((parseFloat(value.netWeightDisplay == null ? 0 : value.netWeightDisplay) * parseFloat(value.unitContractPrice == null ? 0 : value.unitContractPrice)).toFixed(2))
																	// 根据精度保留小数
																	//value.contractMoney.toFixed(value.precision)
																	// 总金额
																	totalMoney += parseFloat(value.contractMoney == null ? 0 : value.contractMoney)
																	
																})
																vm.contract.entity.totalWeight = totalWeight
																vm.contract.entity.totalMoney = totalMoney
																
																vm.totalWeight = totalWeight / 1000
															})
														},
														deep: true,
														immediate: true
													}
												},
												methods: {
													// 修改系列时 删除其他相关联的值
													doclear(index){
														let row = this.contract.contractDetail[index]
														row.materialId =''
														row.surfaceId = ''
													},
													/**
													 * 添加一行
													 */
													addLine () {
														this.contract.contractDetail.push($.extend(true, {}, this.newLineData))
														contractValid()
													},
													/**
													 * 复制一行
													 */
													copyLine (index, row) {
														var temp = $.extend(true, {}, row)
														temp.contractDetailId = ''
														this.contract.contractDetail.push(temp)
														contractValid()
													},
													/**
													 * 删除一行
													 */
													delLine (index, row) {
														if (row.contractDetailId) {
															this.contract.delDetialId.push(row.contractDetailId)
														}
														this.contract.contractDetail.splice(index, 1)
													},
													/**
													 * 获取品类详情
													 */
													getProductDetail (index, id) {
														if (id) {
															var vm = this
															ajax.findOne('/baseProduct', id).then(function (result) {
																if (result.state === 1) {
																	var data = result.data
																	vm.$set(vm.contract.contractDetail[index], 'amountUnit', data.quantityUnit)
																	vm.$set(vm.contract.contractDetail[index], 'netWeightUnit', data.weightUnit)
																	vm.$set(vm.contract.contractDetail[index], 'precision', data.precision)
																	vm.$set(vm.contract.contractDetail[index], 'unitRate', data.unitRate)
																}
															})
														}
													}
												},
												mounted () {
													var vm = this
													ajax.findOne('/contract', this.contractId).then(function(res) {
														vm.contract.entity = res.data
														if (res.data.contractDetail) {
															vm.contract.contractDetail = res.data.contractDetail
															for (var i = 0; i < vm.contract.contractDetail.length; i++) {
																vm.$set(vm.contract.contractDetail[i], 'amountUnit', vm.contract.contractDetail[i].product.quantityUnit)
																vm.$set(vm.contract.contractDetail[i], 'netWeightUnit', vm.contract.contractDetail[i].product.weightUnit)
																vm.$set(vm.contract.contractDetail[i], 'precision', vm.contract.contractDetail[i].product.precision)
																vm.$set(vm.contract.contractDetail[i], 'unitRate', vm.contract.contractDetail[i].product.unitRate)
															}
														}
													})
													contractDetailValid ()
												}
											})
										}
									}
								})
							},
							addPayment () {
								let contractId = this.model.contractId
								let businessType = this.model.businessType
								let contractCode = this.model.contractCode
								var paymentDialog
								util.dialog({
									id: 'paymentDialogContent',
									width: 400,
									height: 120,
									fixed: true,
									skin: 'crm-form crm-form-over',
									title: '追加货款',
									content: `
										<form id="payment-dialog-content">
											<template>
												<div class="ui-row">
													<div class="ui-form-group ui-col">
														<label class="ui-label-control ui-col-30">确认金额(元)</label>
														<div class="ui-col-70">
															 <el-input-number size="small" v-model="conPaymentDetail.money" controls-position="right" :min="1"></el-input-number>
														</div>
													</div>
												</div>
												<div class="ui-row">
													<div class="ui-form-group ui-col">
														<label class="ui-label-control ui-col-30">备注</label>
														<div class="ui-col-70">
															<textarea class="ui-input-control ui-height-auto sele-info-txt"
																rows="2" v-model="conPaymentDetail.notes" name="notes">
															</textarea>
														</div>
													</div>
												</div>
											</template>
										</form>
									`,
									okValue: '确定',
									ok: function() {
										paymentDialog.conPaymentDetail.contractId = contractId
										paymentDialog.conPaymentDetail.contractCode = contractCode
										// 禁用提交按钮
										util.setLoading({
											selector: '[i-id="ok"]'
										})
										ajax.post('/contract/savePaymentDetail', paymentDialog.conPaymentDetail).then(function (result) {
											if (result.state === 1) {
												util.dialog({getIdClose: 'paymentDialogContent'})
												detail.fetchData(2)
											}
										}, function () {
											// 使提交按钮可用
											util.setLoading({
												selector: '[i-id="ok"]',
												isClick: false
											})
										})
										return false
									},
									cancelValue: '取消',
									onshow: function () {
										if (paymentDialog == null) {
											paymentDialog = new Vue({
												el: '#payment-dialog-content',
												data () {
													return {
														conPaymentDetail: {
															contractId: '',
															contractCode: '',
															money: null,
															notes: null
														}
													}
												}
											})
										}
									}
								})
								
							},
							addDeposit () {
								let contractId = this.model.contractId
								let businessType = this.model.businessType
								let contractCode = this.model.contractCode
								var depositDialog
								util.dialog({
									id: 'depositDialogContent',
									width: 400,
									height: 120,
									fixed: true,
									skin: 'crm-form crm-form-over',
									title: '追加保证金',
									content: `
										<form id="deposit-dialog-content">
											<template>
												<div class="ui-row">
													<div class="ui-form-group ui-col">
														<label class="ui-label-control ui-col-30">确认金额(元)</label>
														<div class="ui-col-70">
															 <el-input-number size="small" v-model="conDepositDetail.money" controls-position="right" :min="1"></el-input-number>
														</div>
													</div>
												</div>
												<div class="ui-row">
													<div class="ui-form-group ui-col">
														<label class="ui-label-control ui-col-30">备注</label>
														<div class="ui-col-70">
															<textarea class="ui-input-control ui-height-auto sele-info-txt"
																rows="2" v-model="conDepositDetail.notes" name="notes">
															</textarea>
														</div>
													</div>
												</div>
											</template>
										</form>
									`,
									okValue: '确定',
									ok: function() {
										depositDialog.conDepositDetail.contractId = contractId
										depositDialog.conDepositDetail.contractCode = contractCode
										// 禁用提交按钮
										util.setLoading({
											selector: '[i-id="ok"]'
										})
										ajax.post('/contract/saveDepositDetail', depositDialog.conDepositDetail).then(function (result) {
											if (result.state === 1) {
												util.dialog({getIdClose: 'depositDialogContent'})
												detail.fetchData(3)
											}
										}, function () {
											// 使提交按钮可用
											util.setLoading({
												selector: '[i-id="ok"]',
												isClick: false
											})
										})
										return false
									},
									cancelValue: '取消',
									onshow: function () {
										if (depositDialog == null) {
											depositDialog = new Vue({
												el: '#deposit-dialog-content',
												data () {
													return {
														conDepositDetail: {
															contractId: '',
															businessType: '',
															money: null,
															notes: null
														}
													}
												}
											})
										}
									}
								})
							},
							delContract () {
								ajax.delete('/contract', this.model.contractId).then(function (result) {
									if (result.state === 1) {
										page.fetchData()
									}
								})
								return false
							},
							editContract () {
								let contractId = this.model.contractId
								var contractDialog
								util.dialog({
									id: 'contractDialogContent',
									width: 1230,
									height: 500,
									fixed: true,
									skin: 'crm-form crm-form-over',
									title: '编辑合同',
									content: `
										<form id="contract-dialog-content">
											<template>
												<div class="ui-row">
													<div class="ui-col">
														<div class="ui-form-group ui-col-50">
															<label class="ui-label-control ui-col-30 required-txt">业务类型</label>
															<div class="ui-col-60">
																<component-select v-model="contract.entity.contractType" type="BusinessType" name="contractType">
					                                         	</component-select>
															</div>
														</div>
														<div class="ui-form-group ui-col-50">
															<label class="ui-label-control ui-col-30 required-txt">合同编号</label>
															<div class="ui-col-60">
																<input type="text" class="ui-input-control" v-model="contract.entity.contractNo" name="contractCode">
															</div>
														</div>
													</div>
													<div class="ui-col">
														<div class="ui-form-group ui-col-50">
															<label class="ui-label-control ui-col-30 required-txt">甲方</label>
															<div class="ui-col-60">
																<component-select :ignore-client-id="contract.entity.sellerId" v-model="contract.entity.sellerId" type="PartyA" :search="true" name="buyerId">
					                                         	</component-select>
															</div>
														</div>
														<div class="ui-form-group ui-col-50">
															<label class="ui-label-control ui-col-30 required-txt">乙方</label>
															<div class="ui-col-60">
																<component-select :ignore-client-id="contract.entity.buyerId" v-model="contract.entity.buyerId" type="crmClients" :search="true" :remoteseach="true" name="sellerId">
					                                         	</component-select>
															</div>
														</div>
													</div>
													<div class="ui-col">
														<div class="ui-form-group ui-col-50">
															<label class="ui-label-control ui-col-30 required-txt">签订日期</label>
															<div class="ui-col-60">
																<input type="text" v-model="contract.entity.signDate" class="ui-input-control sign-date-dialog" name="signDate">
															</div>
														</div>
														<div class="ui-form-group ui-col-50">
															<label class="ui-label-control ui-col-30 required-txt">合同期限(天)</label>
															<div class="ui-col-60">
																<input type="number" class="ui-input-control" v-model="contract.entity.contractPeriod" name="contractPeriod">
															</div>
														</div>
													</div>
													<div class="ui-col">
														<div class="ui-form-group ui-col-50">
															<label class="ui-label-control ui-col-30">供应方</label>
															<div class="ui-col-60">
																<component-select v-model="contract.entity.mallMnfct" type="mallMnfcts" :search="true" :remoteseach="true">
					                                         	</component-select>
															</div>
														</div>
														<div class="ui-form-group ui-col-50">
															<label class="ui-label-control ui-col-30">合同原件</label>
															<div class="ui-col-60">
																<component-upload @success="handleSuccess" ref="attach" :accept="accept" :file-list="attachArray" :multiple="true" @remove="onRemove" @change-file="change"></component-upload>
															</div>
														</div>
													</div>
													<span v-if="hiddenFee">
														<div class="ui-col">
															<div class="ui-form-group ui-col-50">
																<label class="ui-label-control ui-col-30 required-txt">保证金比例</label>
																<div class="ui-col-60">
																	<component-select v-model="contract.entity.depositRate" type="DepositRate" name="depositRate">
						                                         	</component-select>
																</div>
															</div>
															<div class="ui-form-group ui-col-50">
																<label class="ui-label-control ui-col-30 required-txt">保证金金额(万元)</label>
																<div class="ui-col-60">
																	<input type="number" class="ui-input-control" v-model="contract.entity.depositFee" name="depositFee">
																</div>
															</div>
														</div>
														<div class="ui-col">
															<div class="ui-form-group ui-col-50">
																	<label class="ui-label-control ui-col-30 required-txt">开票费(元/吨)</label>
																	<div class="ui-col-60">
																		<component-select v-model="contract.entity.invoiceBaseFee" type="invoice" name="invoiceBaseFee" :param="contract.entity.sellerId">
							                                         	</component-select>
																	</div>
															</div>
														</div>
														<div class="ui-col">
															<div class="ui-form-group ui-col-50">
																<label class="ui-label-control ui-col-30 required-txt">手续费率(0~60天)</label>
																<div class="ui-col-60">
																	<component-select v-model="contract.feeRates[0].feeValue" type="commission60" name="commission60" :param="contract.entity.sellerId">
						                                         	</component-select>
																</div>
															</div>
															<div class="ui-form-group ui-col-50">
																<label class="ui-label-control ui-col-30 required-txt">手续费率(61~90天)</label>
																<div class="ui-col-60">
																	<component-select v-model="contract.feeRates[1].feeValue" type="commission90" name="commission90" :param="contract.entity.sellerId">
						                                         	</component-select>
																</div>
															</div>
														</div>
													</span
													<div class="ui-col">
														<div class="ui-form-group ui-col-100">
															<label class="ui-label-control ui-col-10">备注</label>
															<div class="ui-col-90">
																<textarea class="ui-input-control ui-height-auto sele-info-txt"
																	rows="2" v-model="contract.entity.notes" name="notes"></textarea>
															</div>
														</div>
													</div>
												</div>
											</template>
										</form>
									`,
									okValue: '确定',
									ok: function() {
										if ($('#contract-dialog-content').valid()) {
											if (contractDialog.uploadImgTotal > 0) {
												contractDialog.$refs.attach.submitUpload()
											} else {
												contractDialog.contract.entity.depositFee = contractDialog.contract.entity.depositFee * 10000
												// 禁用提交按钮
												util.setLoading({
													selector: '[i-id="ok"]'
												})
												ajax.post('/contract/updateContract', contractDialog.contract).then(function (result) {
													if (result.state === 1) {
														util.dialog({getIdClose: 'contractDialogContent'})
														page.fetchData()
														detail.model = result.data
													}
												}, function () {
													// 使提交按钮可用
													util.setLoading({
														selector: '[i-id="ok"]',
														isClick: false
													})
												})
											}
										} else {
											return false
										}
									},
									cancelValue: '取消',
									onshow: function () {
										if (contractDialog == null) {
											contractDialog = new Vue({
												el: '#contract-dialog-content',
												data () {
													return {
														contractId: contractId,
														hiddenFee: false,
														page: page,
														detail: detail,
														attachArray: [],
														accept: 'image/jpeg,image/jpg,image/png,image/gif',
														uploadImgCount: 0,
														uploadImgTotal:0,
														contract: {
															entity: {
																contractId: '',
																contractType: '',
																contractNo: '',
																sellerId: '',
																buyerId: '',
																signDate: '',
																contractPeriod: '',
																mallMnfct: '',
																depositRate: '',
																depositFee: 0,
																invoiceBaseFee: 0,
																commissionRate: 0,
																notes: '',
																totalWeight: 0,
																totalMoney: 0
															},
															attach: [],
															feeRates: [
																{
																	feeDates: 60,
																	feeValue: 0
																},
																{
																	feeDates: 90,
																	feeValue: 0
																}
															],
															delDetialId: []
														}
													}
												},
												watch: {
													'contract.entity.contractType': function (val, old) {
														if (val === 'X' || val === 'D') {
															this.hiddenFee = false
														} else {
															this.hiddenFee = true
														}
													},
													'uploadImgCount': function (val, old) {
														if (val === this.uploadImgTotal) {
															var vm = this
															ajax.post('/contract/updateContract', this.contract).then(function (result) {
																if (result.state === 1) {
																	util.dialog({getIdClose: 'contractDialogContent'})
																	vm.page.fetchData()
																	vm.detail.model = result.data
																}
															})
														}
													}
												},
												methods: {
													handleSuccess (result) {
														this.contract.attach.push(result.data.attach)
														this.uploadImgCount++
													},
													/**
													 * 计算保证金金额
													 */
//													computedDepositFee() {
//														this.contract.entity.depositFee = util.formatNumber((this.contract.entity.depositRate * this.contract.entity.totalMoney), 0, 'cell')
//													},
													onRemove (file) {
														this.contract.delDetialId.push(file.attachId)
													},
													change (data) {
														var dataLength = 0
														if (data) {
															data.forEach(function (item, index) {
																if (!item.attachId) {
																	dataLength++
																}
															})
														}
														this.uploadImgTotal = dataLength
													}
												},
												mounted () {
													let vm = this
													// 添加表单验证
													this.$nextTick(function() {
														contractValidDetail()
														util.select2()
														util.datePicker({
															selector: '.sign-date-dialog'  //绑定Input选择器
														})
													})
													ajax.findOne('/contract', this.contractId).then(function(res) {
														vm.contract.entity = res.data
														vm.contract.feeRates = res.data.feeRates
														vm.contract.entity.depositFee = res.data.depositFee / 10000
														vm.contract.entity.depositRate = res.data.depositRate + ''
														if (res.data.attactList.length > 0) {
															for (var i = 0; i < res.data.attactList.length; i++) {
																var attach = {
																		attachId: res.data.attactList[i].attachId,
																		name: res.data.attactList[i].fileName,
																		url: res.data.attactList[i].filePath,
																		status: 'finished'	
																}
																vm.attachArray.push(attach)
															}
														}
													})
													
												}
											})
										}
									}
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
		} else {
			detail.model = data
			detail.show = true
		}
	}
})




