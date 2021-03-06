/**
 * 交收设置
 * 
 * @author 杨思静
 * @since 2017.12.08
 */
require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	
	// 侧边详情Vue组件
	var detail = null;
	// 子侧边栏
	var detailbySub = null;
	// VUE初始化页面
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					// 业务类型
					businessType: '',
					// 合同编号
					contractId: '',
					// 验货状态
					auditStatus: '',
					// 创建时间
					maxDate: '',
					minDate: ''
				},
				// 页码
				pageNum: 0,
				// 分页大小
				pageSize: 20,
				// 排序
				orderByClause: ''
			},
			// 选择下拉列表
			// 选择项
			util:util,
			options: {
				BusinessType: [],
				InspectionType:[]
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
				ajax.findPage('/settle', vm.searchParam).then(function (res) {
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
		        selector: ['.daterange-start', '.daterange-end'],  // 绑定Input选择器
		    })
		    let vm = this
	     	ajax.getOptions(['InspectionType', 'BusinessType']).then((result) => {
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
	
	$(".btn-add-Dialog").click(function () {
		addBydialog()
	})
	$(".btn-edit-Dialog").click(function () {
		Edit()
	})
	$(".btn-add-product").click(function () {
		addByProduct()
	})
	
	$(".btn-export").click(function () {
		ajax.exportExcel('/settle', page.searchParam)
	})
/************************************************************** */
function addBydialog(id,selectData,detailData){
	util.dialog({
		width: 1000,
		height: 500,
		fixed: true,
		skin: 'crm-form crm-form-over',
		title: '选择货物',
		content: `
			<div id="selectgoods">
			  <div class="ui-col">
				<div class="main-cnt-scroll">
				  <component-table :data="tableData" :height="400" row-key="contractDetailId" :select-data="selectDatas" :columns="tableConfig.columns"
					:loading="tableConfig.loading" @selection-change="handleSelectionChange" :selectable="selectable">
					${conContractGoods}
				  </component-table>
				</div>
			  </div>
			</div>
			`,
			okValue: '确定',
			ok: function () {
				newVue.tableArr = selectGoodsVue.selectDatas
				newVue.detailArr = selectGoodsVue.tableData
				newVue.formatConToIns()
			},
			cancelValue: '取消',
			onshow: function () {
				var tableData = newVue.tableData
				var selectDatas = []
				if (tableData != null && tableData.length > 0) {
					tableData.forEach(function (item) {
						selectDatas.push({contractDetailId: item.insInspectionDetail.contractDetailId})
					})
				}
				selectGoodsVue = new Vue({
					el:"#selectgoods",
					data: {
						// 搜索条件
						searchParam: {
							dto: {
								contractId:''
							},
							// 页码
							pageNum: 0,
							// 分页大小
							pageSize: 0,
							// 排序
							orderByClause: ''
						},
						tableData: [],
						util:util,
						selectDatas: $.extend([], selectDatas),
						tableConfig: {
							loading: false,
							columns: ['selection']
						},
					},
					methods: {
						/**
						 * 后台检索数据
						 */
						fetchData () {
								let vm = this
								vm.searchParam.dto.contractId =  id 
								 ajax.post("/contract/findAllContractDetails",vm.searchParam).then(function (res) {
								   vm.tableData = res.data
							 	 }, function () {

							 	})
						},
						handleSelectionChange (selectDatas) {
							console.log(selectDatas)
							this.selectDatas = selectDatas
							
						},
						selectable (row, index) {
							for (var item of selectDatas) {
								if (item.contractDetailId === row.contractDetailId) {
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






	
	/********************************************************** */
	/**
	 * 编辑
	 * 
	 * @param
	 */
	function Edit (data) {
		util.dialog({
			id: 'SubProductDialog',
			width: 1230,
			height:400,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '编辑子单',
			content: `
			<div  class="dialog_open">
				<form id="SubProductDialogForm">
					<h5 class="bg-tit">子单信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">子单单号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionSub.subCode" placeholder="子单" disabled>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">验货单号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.inspectionBillCode" placeholder="验货单号" disabled>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">入库日期</label>
								<div class="ui-col-60">
									<input type="text"  :disabled="isdisabled" class="ui-input-control sign-date-dialog" v-model="insInspectionBillVo.insInspectionSub.instockDate" placeholder="入库日期" name="instockDate" >
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">存货凭证编号</label>
								<div class="ui-col-60">
									<input type="text"  :disabled="isdisabled"  class="ui-input-control" v-model="insInspectionBillVo.insInspectionSub.voucherNo" placeholder="存货凭证编号" name="voucherNo">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30">质保书</label>
								<div class="ui-col-60">
									 <component-upload @success="handleSuccess" ref="warranty" :accept="accept" :multiple="true" upload-data="1" @change="warrantychange"  :file-list="warrantys"  @remove="onRemove" ></component-upload>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 ">存货凭证</label>
								<div class="ui-col-60">
									<component-upload @success="handleSuccess1" ref="inventoryVoucher" :accept="accept" :multiple="true" upload-data="1"  :file-list="inventoryVouchers"   @change="inventoryVoucherchange"  @remove="onRemove1" ></component-upload>
								</div>
							</div>
						</div>    
						<div class="ui-col">
							<div class="ui-form-group ui-col-50" >
								<label class="ui-label-control ui-col-20 required-txt">仓库</label>
								<div class="ui-col-80" style="padding-left: 37px; " >
									<component-select  :isdisabled="isdisabled"  v-model="insInspectionBillVo.insInspectionSub.storageId" type="DictMallDepot"  name="storageId" style="margin: 0 22px;width: 370px;" name="storageId"   >
                                    </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-20">备注</label>
								<div class="ui-col-80" style="width:423px;padding-left: 62px;">
									<input type="text" class="ui-input-control" :disabled="isdisabled" type="number" v-model="insInspectionBillVo.insInspectionSub.notes" placeholder="备注" >
								</div>
							</div>
						</div>
					</div>
				</form>
				
				`,
				okValue: '确定',
				ok: function () {
					if ($('#SubProductDialogForm').valid()) {						
						newVue.circulation()
					}else{
						return false
					}
					return false
					
				},
				cancelValue: '取消',
				onshow: function () {
					// 添加表单验证
					newVue = new Vue({
						el:".dialog_open",
						data: {
							// 搜索条件
							searchParam: {
								dto: {
								},
								// 页码
								pageNum: 0,
								// 分页大小
								pageSize: 0,
								// 排序
								orderByClause: ''
							},
							selectData: {
								// 计算方式
								calcMethods:[
									"理算",
									"磅重"
								]
							},
							// 允许上传文件的类型
							accept: 'image/jpeg,image/jpg,image/png,image/gif',
							isShow: true,
							uploading:false,
							totalNumber:0,
							totalWeight:0,
							// 从合同货物中选出的数据
							tableArr:[],
							// 合同仓库数据
							detailArr:[],
							tableData: [],
					        insInspectionBillVo:{
					        	insInspectionBillDTO:{},
					        	insInspectionSub:{
					        		subCode:''
					        	},
					        	// 存货凭证附件
					        	inventoryVoucherList:[],
					        	// 质保书附件
					        	warrantyList:[],
					        	// 货物集合对象
								insInspectionBillVoList:[],
								// 图片意图删除
					        	deleteAttachList:[]
					        },
					        // 上传文件长度
					        inventoryVoucher: 0,
					        warranty:0,
							indexNum: -1,
							 // 质保书附件
							 warrantys:[],
							 // 存货凭证附件
							 inventoryVouchers:[],
							 isdisabled:false,
							 isExist:false,
							 isExist1:false
						},
						computed: {
							uploadDone () {
								return this.inventoryVoucher === this.insInspectionBillVo.inventoryVoucherList.length
									&& this.warranty === this.insInspectionBillVo.warrantyList.length
									&& (this.inventoryVoucher !== 0 || this.warranty !== 0 )
							}
						},
						watch:{  
							uploadDone:{  
				                handler:function(val,oldval){
									
				                	if(val){
										this.uploading = true
										
				                	}
				                },
				                deep:true
				            },
				            uploading:{
								handler:function(val,oldval){  
									if(val){
										this.save()
									}
								},
								deep:true
							}
				        },
						mounted () {
							let vm = this
						
							vm.insInspectionBillVo.insInspectionSub = $.extend(true,{},data.insInspectionSub)
							vm.insInspectionBillVo.inspectionBillCode = data.insInspectionBill.inspectionBillCode
							vm.warrantys = vm.manipulate(data.warrantyList)
							vm.inventoryVouchers =vm.manipulate(data.inventoryVoucherList)

							if(vm.insInspectionBillVo.insInspectionSub.auditStatus == 'B'||vm.insInspectionBillVo.insInspectionSub.auditStatus == 'D'){
								vm.isdisabled=true
							}
							if(vm.inventoryVouchers.length!=0){
								vm.insInspectionBillVo.inventoryVoucherList =  $.extend(true,[],data.inventoryVoucherList)	
							}
							if(vm.warrantys.length!=0){
								vm.insInspectionBillVo.warrantyList =  $.extend(true,[],data.warrantyList)
							}
							this.$nextTick(function() {
								addSubAndGoodsValid()
								util.datePicker({
									selector: '.sign-date-dialog'  // 绑定Input选择器
								})
							})
						},
						methods: {
							// 循环上传
						  circulation(){
							 
							  if(this.inventoryVoucher!=0||this.warranty!=0){
								  if(this.warranty===0){
									  this.warranty = this.insInspectionBillVo.warrantyList.length
								  }
								  if( this.inventoryVoucher ===0){
									  this.inventoryVoucher = this.insInspectionBillVo.inventoryVoucherList.length
								  }
								// 子单质保书和存货凭证
								if(this.isExist1){
									this.$refs.inventoryVoucher.submitUpload()
								}
								if(this.isExist){
									this.$refs.warranty.submitUpload()
								}
								//   // 上传货物信息
								//   let one = this.tableData
								//   for(var i in one){
								// 	  let two = 'attach' + i 
								// 	  this.$refs[two].submitUpload()
								//   }
								
							  }else{
								  this.uploading = true
								  
							  }
						    
							  
						  },
						  // 存货凭证长度
						  inventoryVoucherchange(length){
							  this.inventoryVoucher = length
							  this.isExist1 = true
						  },
						  warrantychange(length){
							  this.warranty = length
							  this.isExist = true
						  },
						  save() {
							 let vm = this
							 // 赋值主验货id
							ajax.update('/settle/settleSubDetail',vm.insInspectionBillVo).then((result) => {
								detailbySub.model.insInspectionSub=result.data.insInspectionSub
								detail.fetchDataByEdit()
							  	util.dialog({getIdClose: 'SubProductDialog'})
					  		})
						  },
					      // 上传质保书
					      handleSuccess (result) {
					    	  let vm = this.insInspectionBillVo
					    	  if(result.state == 1){
					    		  let one = result.data.data
					    		  let two = result.data.attach
								  vm.warrantyList.push(two)
								 //this.inventoryVoucher = vm.inventoryVoucherList.length
								  this.warranty = vm.warrantyList.length
					    	  }
					      },
					      // 存货凭证
					      handleSuccess1 (result) {
							 let vm = this.insInspectionBillVo
							if(result.state == 1){
				    		  let one = result.data.data
				    		  let two = result.data.attach
							  vm.inventoryVoucherList.push(two)
							 // this.warranty = vm.warrantyList.length
							  this.inventoryVoucher = vm.inventoryVoucherList.length
							}
						  },
						  //删除图片
							onRemove1(file){
								this.insInspectionBillVo.deleteAttachList.push(file.attachId)
								// 
								for(var i in this.insInspectionBillVo.inventoryVoucherList){
									if(file.attachId == this.insInspectionBillVo.inventoryVoucherList[i].attachId){
										this.insInspectionBillVo.inventoryVoucherList.splice(i,1)
									}
								}
							},
							// 质保书
							onRemove (file) {
								this.insInspectionBillVo.deleteAttachList.push(file.attachId)
								for(var i in this.insInspectionBillVo.warrantyList){
									if(file.attachId == this.insInspectionBillVo.warrantyList[i].attachId){
										this.insInspectionBillVo.warrantyList.splice(i,1)
									}
								}
							},
							//处理图片
							manipulate(pictures){
								let one = []
								if (pictures.length > 0) {
									for (var i = 0; i < pictures.length; i++) {
										var attach = {
											attachId: pictures[i].attachId,
											name: pictures[i].fileName,
											url: pictures[i].filePath,
											status: 'finished'	
										}
										one.push(attach)
									}
								}
								return one
							},
					   }
					})
				}
		})
	}
	/** ************************************************************************ */
	/**
	 * 批量修改和新增
	 */
	function bathUpdate (data,tableData){
		var tableContent
		var type = 0
		util.dialog({
			id: 'SubProductDialog',
			width: 1230,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '货物信息',
			content: `
					${goodsHtml}
				`,
				okValue: '确定',
				ok: function () {
					if ($('#dialog-content').valid()) {
						newVue.circulation()
					}
					return false
				},
				cancelValue: '取消',
				onshow: function () {
					if (tableContent == null) {
						newVue = new Vue({
							el: '#dialog-content',
							data () {
								return {
									// 搜索条件
								searchParam: {
									dto: {
									},
									// 页码
									pageNum: 0,
									// 分页大小
									pageSize: 0,
									// 排序
									orderByClause: ''
								},
								selectData: {
									// 计算方式
									calcMethods:[
										"理算",
										"磅重"
									]
								},
								// 允许上传文件的类型
								accept: 'image/jpeg,image/jpg,image/png,image/gif',
								isShow: true,
								// 是否上传
								uploading:false,
								// 
								totalNumber:0,
								totalWeight:0,
								// 从合同货物中选出的数据
								tableArr:[],
								// 从选出的数据中筛选出已选择的数据
								tableSelect:[],
								// 合同仓库数据
								detailArr:[],
								// 修改数据
								updatetableData: $.extend(true,[],tableData),
								tableData: [],
								// 删除的数据
								deltableData:[],
								insInspectionBillVo:{
									insInspectionBillDTO:{},
									insInspectionSub:{
										
									},
									// 存货凭证附件
									inventoryVoucherList:[],
									// 质保书附件
									warrantyList:[],
									// 货物集合对象
									insInspectionBillVoList:[],
									// 图片意图删除
									deleteAttachList:[]
								},
								// 上传文件长度
								model: data,
								inventoryVoucher: 0,
								warranty:0,
								tablelength: [],
								indexNum: -1
								}
							},
							computed: {
								uploadDone () {
									let one = 0
									for(var i in this.tablelength){
										one+=this.tablelength[i]
									}
									let two = 0
									for(var i in this.tableData){
										if(this.tableData[i].sphotosGoodsList instanceof Array){
											let three = this.tableData[i].sphotosGoodsList.length
											two += three
										}
									}
									return  one === two && one!= 0 && two != 0&&this.uploading
								}
							},
							watch: {
								uploadDone:{  
									handler:function(val,oldval){  
										if(val){
											this.uploading = true
										}
									},
									deep:true
								},
								uploading:{
									handler:function(val,oldval){  
										if(val){
											this.save()
										}
									},
									deep:true
								},
								'tableData': {
									handler: function (newVal, oldVal) {
										let number = 0
										let weight = 0
										let vm = this
										vm.$nextTick(function () {
											for(var one of vm.tableData){
												if (Math.floor(one.insInspectionDetail.amount) !== one.insInspectionDetail.amount) {
													vm.$set(one.insInspectionDetail, 'amount', Math.floor(one.insInspectionDetail.amount))
												}
												number += parseInt(one.insInspectionDetail.amount)
												// 统一kg单位
												if(one.insInspectionDetail.unitRate !=-1){
													weight +=(parseFloat(one.insInspectionDetail.netWeight) * (one.insInspectionDetail.unitRate==0?1:one.insInspectionDetail.unitRate))
												}
//												if(one.insInspectionDetail.netWeightUnit =="千克"||one.insInspectionDetail.netWeightUnit =="kg"||one.insInspectionDetail.netWeightUnit =="KG"){
//													//weight +=(parseFloat(one.insInspectionDetail.netWeight) /1000)* (parseInt(one.insInspectionDetail.amount))
//													weight +=(parseFloat(one.insInspectionDetail.netWeight) /1000)
//												}else if(one.insInspectionDetail.netWeightUnit =="吨"||one.insInspectionDetail.netWeightUnit =="t"||one.insInspectionDetail.netWeightUnit =="T"){
//													//weight += (parseFloat(one.insInspectionDetail.netWeight))*(parseInt(one.insInspectionDetail.amount))
//													weight += (parseFloat(one.insInspectionDetail.netWeight))
//												}
											}
											this.totalNumber = number
											this.totalWeight =(weight /1000).toFixed(3)
										})
									},
									deep: true
								}
							},
							components: {
								componentTable: componentTable
							},
							methods: {
								// 导入Excel 返回的值
								backtrack (res) {
									let vm =this
									for (var o of res.data) {
								 	  let one = data.conContract
									  this.$set(o,'amountUnit' , '')
									  this.$set(o,'netWeightUnit' , '')
								   	  this.$set(o,'precision' , '')
									  this.$set(o,'unitRate' , '')
									  o.sellerId = one['sellerId']
									  o.buyerId = one['buyerId']
									  o.businessType = one['contractType']
									  o.instockDate = vm.model.insInspectionSub.instockDate
									  o.inspectionSubId = vm.model.insInspectionSub.inspectionSubId
									  o.storageId = ''
									  o.contractDetailId =  ""
									  let two = {
										insInspectionDetail: o,
										sphotosGoodsList: [],
										//  修改: 1 删除:2 增加:3
								  	  	isUpdateOrAddOrDel: '3'
								 	  }
								 	  this.tableData.push(two)
									}
								},
								//更换品类时清楚相关联的数据
								doclear(index,type) {
									let row = this.tableData[index].insInspectionDetail
									if(type === 1){
										row.materialId = ''
									}
									row.surfaceId = ''
									row.trademark=''
									row.mnfctId = ''
									row.grade =''
									row.implStd =''
								},
								// 循环上传
								circulation(){
									// 子单质保书和存货凭证
									// this.$refs.inventoryVoucher.submitUpload()
									// this.$refs.warranty.submitUpload()
									// 上传货物信息
//									if(this.tablelength.length!=0){
//										let one = this.tableData
//										for(var i in one){
//											let two = 'attach' + i 
//											this.$refs[two].submitUpload()
//										}
//									}else{
//										this.uploading = true
//									}
									this.uploading = true
									
								},
								tableArrlength(length){
									this.addImageNum()
									this.tablelength[this.indexNum] = length
								},
								//增加图片数量
								addImageNum(){
									for(var i  in this.tableData){
										if(this.indexNum != i){
											this.tablelength[i] = this.tableData[i].sphotosGoodsList.length
										}
									}
								},
								// 行点击事件
								rowCilck(row, event, column){
									this.indexNum = this.tableData.indexOf(row)
								},
								save() {
								   let vm = this
								   // 赋值主验货id
								  this.format()
								  // 将删除的数据 放入this.tableData
								  this.inTable()
								  // 赋值货物详情
								  vm.insInspectionBillVo.insInspectionBillVoList = this.tableData
								  this.preserve()
								},
								// 保存
								preserve(){
								  let vm = this
								  vm.insInspectionBillVo.insInspectionSub.totalNumber = vm.totalNumber
								  vm.insInspectionBillVo.insInspectionSub.totalWeight = vm.totalWeight * 1000
								  
								  vm.insInspectionBillVo.insInspectionSub.inspectionSubId = vm.model.insInspectionSub.inspectionSubId
								  ajax.update('/settle/updatebathDetail', vm.insInspectionBillVo).then(function (res) {
									  detailbySub.fetchDataByProduct()
									  detail.fetchDataByEdit()
									  util.dialog({getIdClose: 'SubProductDialog'})
								  }, function () {
									  
								  })
								},
								// 增加必要属性
								format(){
									let vm = this
									for(var i  in vm.tableData ){
										let one  = vm.tableData[i].insInspectionDetail
										one.storageId = vm.model.insInspectionSub.storageId
										 if(one.netWeightUnit =="吨"||one.netWeightUnit =="t"|| one.netWeightUnit =="T"){
												one.netWeight = one.netWeight*1000
										  }
									}
								},
								// 将删除的数据放入 this.tableData
								inTable(){
									if(this.deltableData.length!=0){
										for (let one of this.deltableData) {
											this.tableData.push(one)											
										}
									}
								},
								 //删除图片
								onRemove(file){
									this.insInspectionBillVo.deleteAttachList.push(file.attachId)
								},
								// 把合同货物中选择出来的数据 转换成需要添加货物的数据
								formatConToIns(){
									let vm =this
									this.removeSelect()
									for(var i in vm.tableSelect){
										// 转换完成 添加到货物列表中
									   // vm.tableData.push(this.formatOne(vm.tableArr[i]))
									   var isExist = false
									   for(var j of vm.tableData){
										   if(vm.tableSelect[i].contractDetailId === j.insInspectionDetail.contractDetailId){
											   isExist = true
											   break
										   }
									   }
									   if(!isExist){
									   let two = this.formatOne(vm.tableSelect[i])
										this.getProductDetailByCon(two)
										this.addProduct(two)
									   }
									}
									
								// for(var i in vm.tableArr){
								// // 转换完成 添加到货物列表中
								// //
								// vm.tableData.push(this.formatOne(vm.tableArr[i]))
								// this.addProduct(this.formatOne(vm.tableArr[i]))
								// }
								},
								// 删除一些 已选择的数据
								removeSelect(){
									let vm = this
									let one = $.extend(true,[],vm.tableArr)
									for ( var i in one) {
										let num = vm.tableData.indexOf(one[i])
										if(num == 0){
											one.splice(i,1)
										}
										vm.tableSelect = one
									}
								},
								// 复制
								handleEdit(index, row) {
									var row1 = $.extend(true, {}, row);
									row1.isUpdateOrAddOrDel ='3'
									this.tableData.push(row1)
								},
								addObject(){
									this.addProduct(this.object())
								},
								addProduct(one){
								  let two = {
									  insInspectionDetail : one,
									  sphotosGoodsList:[],
									  //  修改: 1 删除:2 增加:3
								  	  isUpdateOrAddOrDel: '3'
								  }
								  this.tableData.push(two)
								},
								addBydialog(){
									
									let table = []
									if (this.tableArr.length != 0){
										table = this.tableArr
									}
									let detail = []
									if (this.detailArr.length != 0){
										detail = this.detailArr
									}
									let id = this.model.data.conContract.contractId
									addBydialog(id,table,detail)
								},
								// 上传质保书
								handleSuccess (result) {
									let vm = this.insInspectionBillVo
									if(result.state == 1){
										let one = result.data.data
										let two = result.data.attach
										vm.warrantyList.push(two)
									}
								},
								// 存货凭证
								handleSuccess1 (result) {
								   let vm = this.insInspectionBillVo
								  if(result.state == 1){
									let one = result.data.data
									let two = result.data.attach
									vm.inventoryVoucherList.push(two)
								  }
								},
								// 货物信息上传
								detailSuccess(result){
								   let vm = this
								  if(result.state == '1'){
									let one = parseInt(result.data.data)
									let two = result.data.attach
									let three = vm.tableData[one]
									if (three.sphotosGoodsList instanceof Array){
										three.sphotosGoodsList.push(two)
										//vm.tablelength[one] = three.sphotosGoodsList.length
									}else{
										three.sphotosGoodsList = []
									}
								  }
								},
								// 删除
								handleDelete(index, row) {
									//如果是原先有的数据 改成 删除
								  if(row.isUpdateOrAddOrDel == '1'){
									 row.isUpdateOrAddOrDel = '2'
									  // 放入删除数据数组
									 this.deltableData.push(row)
								  }
								  this.tableData.splice(index,1);
								},
								//处理图片
								manipulate(pictures){
									let one = []
									if (pictures.length > 0) {
										for (var i = 0; i < pictures.length; i++) {
											var attach = {
												attachId: pictures[i].attachId,
												name: pictures[i].fileName,
												url: pictures[i].filePath,
												status: 'finished'	
											}
											one.push(attach)
										}
									}else{
										one = $.extend(true,[],pictures)
									}
									return one
								},
								// 单个转换
								formatOne(two){
								  let vm = this
								  // let one
									// =vm.insInspectionBillVo.insInspectionBillDTO['conContract']
								  let one = data.conContract
								  let three = two['product']
								  return {
									  sellerId: one['sellerId'],
									  buyerId: one['buyerId'],
									  businessType:one['contractType'],
									  instockDate: vm.model.insInspectionSub.instockDate,
									  inspectionSubId: vm.model.insInspectionSub.inspectionSubId,
									  storageId:two.storageId,
									  contractDetailId: two.contractDetailId,
									  // 以上必要
									  productId: three['productId'],
									  materialId:two.materialId,
									  surfaceId:two.surfaceId,
									  labelThick:two.labelThick,
									  labelWidth:two.labelWidth,
									  goodsLength:two.goodsLength,
									  edge:two.edge,
									  referThick:two.referThick,
									  realWidth:two.realWidth,
									  trademark:two.trademark,
									  goodsVolume:two.goodsVolume,
									  mnfctId:two.mnfct ==null?"":two.mnfct.mnfctId,
									  netWeight:two.netWeight / two.product.unitRate,
									  amount:two.amount,
									  calcMethod:two.calcMethod,
									  grade:two.grade,
									  contractUnitPrice: two.unitContractPrice,
									  realUnitPrice:two.realUnitPrice,
									  floatPrice:two.floatPrice,
									  basicPrice:two.basicPrice,
									  storePrice:two.storePrice,
									  contractMoney:two.contractMoney,
									  realMoney:two.realMoney,
									  implStd:two.implStd,
									  notes:two.notes,
									  orderCode:two.orderCode,
									  amountUnit: '',
									  netWeightUnit: '',
									  precision: 0,
									  unitRate: 0
								  }
	  
								},
								// 创建新货物对象
								object(){
								  let vm = this
								  // let one
									// =vm.insInspectionBillVo.insInspectionBillDTO['conContract']
								  let one = data.conContract
								  return {
									  sellerId: one['sellerId'],
									  buyerId: one['buyerId'],
									  businessType:one['contractType'],
									  instockDate: vm.model.insInspectionSub.instockDate,
									  inspectionSubId: vm.model.insInspectionSub.inspectionSubId,
									  storageId:'', 
									  contractDetailId: "",
									  // 以上必要
									  productId:'',
									  materialId:'',
									  surfaceId:'',
									  labelThick:'0',
									  labelWidth:'0',
									  goodsLength:'0',
									  edge:'',
									  referThick:'',
									  realWidth:'',
									  trademark:'',
									  goodsVolume:'',
									  mnfctId:'',
									  netWeight:'',
									  amount:'',
									  calcMethod:'',
									  grade:'',
									  contractUnitPrice:'',
									  realUnitPrice:'',
									  floatPrice:'',
									  basicPrice:'',
									  storePrice:'',
									  contractMoney:'',
									  realMoney:'',
									  implStd:'',
									  notes:'',
									  amountUnit: '',
									  netWeightUnit: '',
									  precision: 0,
									  unitRate: -1
								  }  
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
												vm.tableData[index].insInspectionDetail.amountUnit = data.quantityUnit
												vm.tableData[index].insInspectionDetail.netWeightUnit = data.weightUnit
												vm.tableData[index].insInspectionDetail.precision = data.precision
												vm.tableData[index].insInspectionDetail.unitRate = data.unitRate
											}
										})
									}
								},
								getProductDetailByCon (row){
									if (row) {
										var vm = this
										ajax.findOne('/baseProduct', row.productId).then(function (result) {
											if (result.state === 1) {
												var data = result.data
												row.amountUnit = data.quantityUnit
												row.netWeightUnit = data.weightUnit
												row.precision = data.precision
												row.unitRate = data.unitRate
											}
										})
									}
								},
								//
								fomatByUpdate(arrys){
									let vm = this
									for (let one of arrys) {
										let two = {
											insInspectionDetail:one.insInspectionDetail,
											sphotosGoodsFileList:vm.manipulate(one.sphotosGoodsList),
											sphotosGoodsList:one.sphotosGoodsList,
											 //  修改: 1 删除:2 增加:3 
											isUpdateOrAddOrDel: '1'
										}
										// 设置属性
										vm.$set(two.insInspectionDetail,'amountUnit', '')
										vm.$set(two.insInspectionDetail,'netWeightUnit', '')
										vm.$set(two.insInspectionDetail,'precision', '')
										vm.$set(two.insInspectionDetail,'unitRate', '')
										two.insInspectionDetail.netWeight  =  two.insInspectionDetail.netWeight / one.baseProduct.unitRate
										//赋值单位
										vm.getProductDetailByCon(two.insInspectionDetail)
										vm.tableData.push(two)
										// vm.tablelength.push(one.sphotosGoodsList.length)
									}
									
								}
							},
							mounted () {
								let one = this.insInspectionBillVo
								one.insInspectionBillDTO = data
								if(this.updatetableData.length == 0){								
									this.addProduct(this.object())
								}else {
									this.fomatByUpdate(this.updatetableData)									
								}
								// 添加表单验证
								this.$nextTick(function() {
									contractValid()
									util.datePicker({
										selector: '.sign-date-dialog'  // 绑定Input选择器
									})
								})
							}
						})
					}
				}
		})
	}
	
	
	/***********************************************************************************/	
		// ---------------
	// 货物 - 表单验证
	// ---------------
	function contractValid () {
		util.formValid({
			selector: '#dialog-content',
			onkeyup: false,
			errorPlacement: function(error, element) { // 错误信息位置设置方法
				if (element.parents('.cell').length > 0) {
					error.appendTo( element.parents('.cell').find('.err') ) // 这里的element是录入数据的对象
				} else {
					 error.appendTo(element.parent())
				}
			},
			rules: {
//				'mnfctId[]':{
//					required: true
//				},
				'calcMethod[]':{
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
//				'mallMnfcts[]': {
//					required: true
//				},
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
				},
				'goodsVolume[]':{
					required: true
				},
				'orderCode[]':{
					required: true
				},
				'grade[]':{
					required: true,
				},
				'implStd[]':{
					required: true,
				}
				
			},
			messages: {
//				'mnfctId[]':{
//					required: '请选择制造商'
//				},
				'calcMethod[]':{
					required: '请选择计算方式'
				},
				'product[]': {
					required: '请选择品类'
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
//				'mallMnfcts[]': {
//					required: '请输入厂家'
//				},
				'orderCode[]':{
					required: '请选择系列'
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
				},
				'goodsVolume[]':{
					required: '请输入卷号',
				},
				'grade[]':{
					required: '请输入等级',
				},
				'implStd[]':{
					required: '请输入执行标准',
				}
			}
		})
	}


	/** **************************************************************************** */
	
	
	
	/** *******************新增单条货物*******作废******************************** */
	/**
	 * 新增单条货物
	 * 
	 * @param
	 */
	function addByProduct (data) {
		util.dialog({
			id: 'baseProductDialog',
			width: 700,
			height: 550,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '新增单条货物',
			content: `
			<div class="dialog_open">
				<form id="addproductform">
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">品类</label>
								<div class="ui-col-60">
									 <component-select v-model="insInspectionBillVo.insInspectionDetail.productId" type="baseProduct" :search="true" name="productId" >
                                     </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">材质</label>
								<div class="ui-col-60">
								<component-select v-model="insInspectionBillVo.insInspectionDetail.materialId"  type="DictMallSpec" :search="true" name="materialId" >
                                     </component-select>
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
							<div class="ui-col">
								<div class="ui-form-group ui-col-50">
									<label class="ui-label-control ui-col-30 required-txt">表面</label>
									<div class="ui-col-60">
									<component-select v-model="insInspectionBillVo.insInspectionDetail.surfaceId" type="baseProcess" :search="true"  name="surfaceId">
                                     </component-select>
									</div>
								</div>
								<div class="ui-form-group ui-col-50">
									<label class="ui-label-control ui-col-30 required-txt">标准厚度</label>
									<div class="ui-col-60">
										<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.labelThick" placeholder="标准厚度" name="labelThick">
									</div>
								</div>
							</div>
					</div>
					<div class="ui-row">
						<div class="ui-form-group ui-col-50">
							<label class="ui-label-control ui-col-30 required-txt">宽度</label>
							<div class="ui-col-60">
								<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.labelWidth" placeholder="宽度" name="labelWidth">
							</div>
						</div>
						<div class="ui-form-group ui-col-50">
							<label class="ui-label-control ui-col-30 required-txt">长度</label>
							<div class="ui-col-60">
								<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.goodsLength" placeholder="长度" name="goodsLength">
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">边部</label>
								<div class="ui-col-60">
									<component-select v-model="insInspectionBillVo.insInspectionDetail.edge" type="EdgeType" :search="true" name="edge" >
                                     </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">参厚</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.referThick" placeholder="参厚" name="referThick">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">牌号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.trademark" placeholder="牌号" name="trademark">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">卷号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.goodsVolume" placeholder="卷号" name="goodsVolume">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">制造商</label>
								<div class="ui-col-60">
									<component-select v-model="insInspectionBillVo.insInspectionDetail.mnfctId" type="mallMnfcts" :search="true" name="mnfctId" >
                                     </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">计算方式</label>
								<div class="ui-col-60">
									 <el-select v-model="insInspectionBillVo.insInspectionDetail.calcMethod" placeholder="请选择计算方式" name="calcMethod">
									    <el-option
									      v-for="item in selectData.calcMethods"
									      :key="item"
									      :label="item"
									      :value="item">
									    </el-option>
									  </el-select>
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">数量（张/卷）</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.amount" placeholder="数量（张/卷）" name="amount">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">重量（kg）</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.netWeight" placeholder="重量（kg）" name="netWeight">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">等级</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.grade" placeholder="等级" name="grade">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">合同单价（元/kg）</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.contractUnitPrice" placeholder="合同单价（元/kg）" name="contractUnitPrice">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">实际单价（元/kg）</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.realUnitPrice" placeholder="实际单价（元/kg）" name="realUnitPrice">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">升贴水</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.floatPrice" placeholder="升贴水" name="floatPrice">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">基价</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.basicPrice" placeholder="基价" name="basicPrice">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">合同金额</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.contractMoney" placeholder="合同金额" name="contractMoney">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">实际金额</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.realMoney" placeholder="实际金额" name="realMoney">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">货物照片</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.SphotosGoods.filePath" placeholder="货物照片" name="filePath">
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
					<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">仓库</label>
								<div class="ui-col-60">
									<component-select v-model="insInspectionBillVo.insInspectionDetail.edge" type="DictMallDepot" :search="true" name="edge" >
                                    </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">备注</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.notes" placeholder="备注">
								</div>
							</div>
						</div>
					</div>
				</form>
				</div>
				`,
				okValue: '确定',
				ok: function () {
					if ($('#addproductform').valid()) {
						addVue.save()
					}else{
						return false
					}
					return false
				},
				cancelValue: '取消',
				onshow: function () {
					// 添加表单验证
					addDetilsValid()
					addVue = new Vue({
						el:".dialog_open",
						data: {
							selectData: {
								// 计算方式
								calcMethods:[
									"理算",
									"磅重"
								]
							},
							tableData: [],
							insInspectionBillDTO: data,
					        insInspectionBillVo:{
					        	insInspectionDetail:{},
					        	SphotosGoods:{
					        		filePath:''
								}
					        }
						},
						methods: {
							// 新增
						  save() {
							  let vm =this
							  this.format()
							  ajax.save('/settle/addDetail', vm.insInspectionBillVo).then(function (res) {
								  util.dialog({getIdClose: 'baseProductDialog'})
								}, function () {
									
							})
						  },
						  /**
							 * 格式转换
							 */
						  format() {
							let vm = this
							let one = vm.insInspectionBillVo.insInspectionDetail
							let two = vm.insInspectionBillDTO
							one.sellerId = two.data.conContract.sellerId
							one.buyerId = two.data.conContract.buyerId
							one.businessType = two.data.conContract.contractType
							one.instockDate = two.insInspectionSub.instockDate
							one.inspectionSubId =two.insInspectionSub.inspectionSubId
						  },
					   },
					   mounted () {
					   }
					})
				}
		})
	}	
	
	
	
	
	
	
	
	
	
	
	
	/** ********************************************************** */
	/**
	 * 新增子单和货物明细
	 * 
	 * @param
	 */
	function addOrEdit (data) {
		util.dialog({
			id: 'SubProductDialog',
			width: 1230,
			height:500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '新增子单和货物明细',
			content: `
			<div  class="dialog_open">
				<form id="SubProductDialogForm">
					<h5 class="bg-tit">子单信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">子单单号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionSub.subCode" placeholder="子单单号后台自动生成" disabled>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">验货单号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.inspectionBillCode" placeholder="验货单号" disabled>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">入库日期</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control sign-date-dialog" v-model="insInspectionBillVo.insInspectionSub.instockDate" placeholder="入库日期" name="instockDate" >
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 ">存货凭证编号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionSub.voucherNo" placeholder="存货凭证编号" name="voucherNo">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30">质保书</label>
								<div class="ui-col-60">
									 <component-upload @success="handleSuccess" ref="warranty" :accept="accept" :multiple="true" upload-data="1" @change="warrantychange" :auto-upload = "true" ></component-upload>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 ">存货凭证</label>
								<div class="ui-col-60">
									<component-upload @success="handleSuccess1" ref="inventoryVoucher" :accept="accept" :multiple="true" upload-data="1"   @change="inventoryVoucherchange"  :auto-upload = "true"></component-upload>
								</div>
							</div>
						</div>    
						<div class="ui-col">
							<div class="ui-form-group ui-col-50" >
								<label class="ui-label-control ui-col-20 required-txt">仓库</label>
								<div class="ui-col-80" style="padding-left: 37px; " >
									<component-select v-model="insInspectionBillVo.insInspectionSub.storageId" type="DictMallDepot"  name="storageId" style="margin: 0 22px;width: 370px;" name="storageId"  :depot="businessType" >
                                    </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-20">备注</label>
								<div class="ui-col-80" style="width:423px;padding-left: 62px;">
									<input type="text" class="ui-input-control" type="number" v-model="insInspectionBillVo.insInspectionSub.notes" placeholder="备注" >
								</div>
							</div>
						</div>
					</div>
				</form>
				<div class="dialog_open">
				${goodsHtml}
				
				`,
				okValue: '确定',
				ok: function () {
					if ($('#SubProductDialogForm').valid()&&$('#dialog-content').valid()) {						
						newVue.circulation()
					}else{
						return false
					}
					return false
					
				},
				cancelValue: '取消',
				onshow: function () {
					// 添加表单验证
					newVue = new Vue({
						el:".dialog_open",
						data: {
							// 搜索条件
							searchParam: {
								dto: {
								},
								// 页码
								pageNum: 0,
								// 分页大小
								pageSize: 0,
								// 排序
								orderByClause: ''
							},
							selectData: {
								// 计算方式
								calcMethods:[
									"理算",
									"磅重"
								]
							},
							// 允许上传文件的类型
							accept: 'image/jpeg,image/jpg,image/png,image/gif',
							isShow: true,
							uploading:false,
							totalNumber:0,
							totalWeight:0,
							// 从合同货物中选出的数据
							tableArr:[],
							// 合同仓库数据
							detailArr:[],
							tableData: [],
					        insInspectionBillVo:{
					        	insInspectionBillDTO:{},
					        	insInspectionSub:{
					        		subCode:''
					        	},
					        	// 存货凭证附件
					        	inventoryVoucherList:[],
					        	// 质保书附件
					        	warrantyList:[],
					        	// 货物集合对象
					        	insInspectionBillVoList:[]
					        },
					        // 上传文件长度
					        inventoryVoucher: 0,
					        warranty:0,
					        tablelength: [],
					        indexNum: -1,
						},
						computed: {
							businessType(){
								let two = data.insInspectionBill.businessType
								if(two== 'H'||two== 'D'){
									return  "real"
								}else{
									return  "all"
								}
							},
							uploadDone () {
								let one = 0
								for(var i in this.tablelength){
									one+=this.tablelength[i]
								}
								let two = 0
								for(var i in this.tableData){
									if(this.tableData[i].sphotosGoodsList instanceof Array){
										let three = this.tableData[i].sphotosGoodsList.length
										two += three
									}
								}
								return this.inventoryVoucher === this.insInspectionBillVo.inventoryVoucherList.length
									&& this.warranty === this.insInspectionBillVo.warrantyList.length&&this.uploading
									&& one === two && (this.inventoryVoucher !== 0 || this.warranty !== 0 )
							}
						},
						watch:{  
							uploadDone:{  
				                handler:function(val,oldval){  
				                	if(val){
				                		this.uploading = true
				                	}
				                },
				                deep:true
				            },
				            uploading:{
								handler:function(val,oldval){  
									if(val){
										this.save()
									}
								},
								deep:true
							},
							'tableData': {
								handler: function (newVal, oldVal) {
									let number = 0
									let weight = 0
									let vm = this
									vm.$nextTick(function () {
										for(var one of vm.tableData){
											if (Math.floor(one.insInspectionDetail.amount) !== one.insInspectionDetail.amount) {
												vm.$set(one.insInspectionDetail, 'amount', Math.floor(one.insInspectionDetail.amount))
											}
											number += parseInt(one.insInspectionDetail.amount)
											//
											if(one.insInspectionDetail.unitRate !=-1){
												weight +=(parseFloat(one.insInspectionDetail.netWeight) * (one.insInspectionDetail.unitRate==0?1:one.insInspectionDetail.unitRate))
											}
										}
										this.totalNumber = number
										this.totalWeight =(weight /1000).toFixed(3)
										
									})
								},
								deep: true
							}
				        },
				        components: {
							componentTable: componentTable
						},
						mounted () {
				        	let vm = this
							let one = this.insInspectionBillVo
							one.insInspectionBillDTO = data
							one.inspectionBillCode = data.insInspectionBill.inspectionBillCode
							this.addProduct(this.object())
							// this.getSubCode()
							// 添加表单验证
							
//							data.insInspectionBill.businessType =='C'||data.insInspectionBill.businessType =='H'?'real':'all'
//							
//							let two = one.insInspectionBillDTO.insInspectionBill.businessType
//							if(two== 'D'||two== 'C'){
//								vm.businessType = "real"
//							}else{
//								vm.businessType = "all"
//							}
							this.$nextTick(function() {
								
								addSubAndGoodsValid()
								contractValid()
								util.datePicker({
									selector: '.sign-date-dialog'  // 绑定Input选择器
								})
							})
						},
						methods: {
							// 导入Excel 返回的值
							backtrack (res) {
								for (var o of res.data) {
									let one =this.insInspectionBillVo.insInspectionBillDTO['conContract']
									this.$set(o,'amountUnit' , '')
									this.$set(o,'netWeightUnit' , '')
									this.$set(o,'precision' , '')
									this.$set(o,'unitRate' , '')
									o.sellerId = one['sellerId']
						    		o.buyerId = one['buyerId']
						    		o.businessType = one['contractType']
						    		o.instockDate = ''
									o.storageId = ''
									contractDetailId = ''
									let two = {
										insInspectionDetail: o,
										sphotosGoodsList: []
									}
									this.tableData.push(two)
								}
							},
							//更换品类时清楚相关联的数据
							doclear(index,type) {
								let row = this.tableData[index].insInspectionDetail
								if(type ===1){
									row.materialId = ''
								}
								row.surfaceId = ''
								row.trademark=''
								row.mnfctId = ''
								row.grade =''
								row.implStd =''
							},
							 //删除图片
							onRemove(file){
							},
							// 循环上传
						  circulation(){
//							  if(this.inventoryVoucher!=0||this.warranty!=0||this.tablelength.length!=0){
//								// 子单质保书和存货凭证
//								  this.$refs.inventoryVoucher.submitUpload()
//								  this.$refs.warranty.submitUpload()
//								  // 上传货物信息
//								  let one = this.tableData
//								  for(var i in one){
//									  let two = 'attach' + i 
//									  this.$refs[two].submitUpload()
//								  }
//							  }else{
//								  this.uploading = true
//							  }
							  this.uploading = true
							  
						  },
						  // 存货凭证长度
						  inventoryVoucherchange(length){
							  this.inventoryVoucher = length
						  },
						  warrantychange(length){
							  this.warranty = length
						  },
						  tableArrlength(length){
							
							  this.tablelength[this.indexNum] = length
						  },
						  // 行点击事件
						  rowCilck(row, event, column){
							  this.indexNum = this.tableData.indexOf(row)
						  },
						  save() {
							 let vm = this
							 // 赋值主验货id
							this.format()
							// 增加 主验货单id
							vm.insInspectionBillVo.insInspectionSub.inspectionId = vm.insInspectionBillVo.insInspectionBillDTO.insInspectionBill.inspectionBillId
							// 增加业务类型
							vm.insInspectionBillVo.insInspectionSub.businessType = vm.insInspectionBillVo.insInspectionBillDTO['conContract'].contractType
							// 赋值货物详情
							// vm.insInspectionBillVo.insInspectionBillVoList = this.tableData
							this.preserve()
						  },
						  // 保存
						  preserve(){
						    let vm = this
						    vm.insInspectionBillVo.insInspectionSub.totalNumber = vm.totalNumber
						    //vm.insInspectionBillVo.insInspectionSub.totalWeight = vm.totalWeight
						    vm.insInspectionBillVo.contractId = vm.insInspectionBillVo.insInspectionBillDTO.conContract.contractId
						    ajax.save('/settle', vm.insInspectionBillVo).then(function (res) {
								detail.fetchDataByEdit()
								util.dialog({getIdClose: 'SubProductDialog'})
							}, function () {
								
							})
						  },
						  // 增加必要属性
						  format(){
							  let vm = this
							  let dataTable =$.extend(true, [], vm.tableData);
							  for(var i  in dataTable ){
								  let one  = dataTable[i].insInspectionDetail
								  one.instockDate = vm.insInspectionBillVo.insInspectionSub.instockDate
								  // 仓库id
								  one.storageId =  vm.insInspectionBillVo.insInspectionSub.storageId
								  
								  one.netWeight = one.netWeight*one.unitRate
//								  if(one.netWeightUnit =="吨"||one.netWeightUnit =="t"|| one.netWeightUnit =="T"){
//										
//								  }
							  }
							  // 赋值货物详情
							  vm.insInspectionBillVo.insInspectionBillVoList = dataTable
							  // 将重量转换单位
							  vm.insInspectionBillVo.insInspectionSub.totalWeight = vm.totalWeight * 1000
						  },
						  // 把合同货物中选择出来的数据 转换成需要添加货物的数据
						  formatConToIns(){
							  let vm =this
							  for(var i in vm.tableArr){
								 // 转换完成 添加到货物列表中
								 // vm.tableData.push(this.formatOne(vm.tableArr[i]))
								
									// 转换完成 添加到货物列表中
								   // vm.tableData.push(this.formatOne(vm.tableArr[i]))
									var isExist = false
									for(var j of vm.tableData){
										if(vm.tableArr[i].contractDetailId === j.insInspectionDetail.contractDetailId){
											isExist = true
											break
										}
									}
									if(!isExist){
										let two  = this.formatOne(vm.tableArr[i])
										this.getProductDetailByCon(two)
										this.addProduct(two)
									}
								
								
							  }
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
											vm.tableData[index].insInspectionDetail.amountUnit = data.quantityUnit
											vm.tableData[index].insInspectionDetail.netWeightUnit = data.weightUnit
											vm.tableData[index].insInspectionDetail.precision = data.precision
											vm.tableData[index].insInspectionDetail.unitRate = data.unitRate
										}
									})
								}
							},
							getProductDetailByCon (row) {
								if (row) {
									var vm = this
									ajax.findOne('/baseProduct', row.productId).then(function (result) {
										if (result.state === 1) {
											var data = result.data
											row.amountUnit = data.quantityUnit
											row.netWeightUnit = data.weightUnit
											row.precision = data.precision
											row.unitRate = data.unitRate
										}
									})
								}
							},
						  // 复制
					      handleEdit(index, row) {
							  var row1 = $.extend(true, {}, row);
							  this.tableData.push(row1)
					      },
					      addObject(){
					    	  this.addProduct(this.object())
					      },
					      addProduct(one){
							let two = {
								insInspectionDetail : one,
								sphotosGoodsList:[]
							}
							this.tableData.push(two)
					      },
					      /**
							 * 查询subCode
							 */
					      getSubCode(){
					    	  let vm = this
					    	  ajax.get('/settle/getSubCode').then(function (res) {
									vm.insInspectionBillVo.insInspectionSub.subCode = res.data
								}, function () {
									
								})
					      },
					      addBydialog(){
					    	  let table = []
				    		  if (this.tableArr.length != 0){
				    			  table = this.tableArr
				    		  }
					    	  let detail = []
					    	  if (this.detailArr.length != 0){
					    		  detail = this.detailArr
							  }
							   let id = data.insInspectionBill.contractId
					    	  addBydialog(id,table,detail)
					      },
					      // 上传质保书
					      handleSuccess (result) {
					    	  let vm = this.insInspectionBillVo
					    	  if(result.state == 1){
					    		  let one = result.data.data
					    		  let two = result.data.attach
					    		  vm.warrantyList.push(two)
					    		  
					    	  }
					      },
					      // 存货凭证
					      handleSuccess1 (result) {
							 let vm = this.insInspectionBillVo
							if(result.state == 1){
				    		  let one = result.data.data
				    		  let two = result.data.attach
			    			  vm.inventoryVoucherList.push(two)
				    		 
							}
					      },
					      // 货物信息上传
					      detailSuccess(result){
					    	 let vm = this
							if(result.state == '1'){
				    		  let one = parseInt(result.data.data)
				    		  let two = result.data.attach
				    		  let three = vm.tableData[one]
				    		  if (three.sphotosGoodsList instanceof Array){
				    			  three.sphotosGoodsList.push(two)
				    		  }else{
				    			  three.sphotosGoodsList = []
				    		  }
							}
					      },
					      // 删除
					      handleDelete(index, row) {
					    	this.tableData.splice(index,1);
						  },
						  // 单个转换
						  formatOne(two){
							let vm = this
							let one =vm.insInspectionBillVo.insInspectionBillDTO['conContract']
							let three = two['product']
					    	return {
					    		sellerId: one['sellerId'],
					    		buyerId: one['buyerId'],
					    		businessType:one['contractType'],
					    		instockDate: vm.insInspectionBillVo.insInspectionSub.instockDate,
					    		storageId:two.storageId,
					    		contractDetailId: two.contractDetailId,
					    		// 以上必要
					    		productId: three['productId'],
					    		materialId:two.materialId,
					    		surfaceId:two.surfaceId,
					    		labelThick:two.labelThick,
					    		labelWidth:two.labelWidth,
					    		goodsLength:two.goodsLength,
					    		edge:two.edge,
					    		referThick:two.referThick,
					    		realWidth:two.realWidth,
					    		trademark:two.trademark,
					    		goodsVolume:two.goodsVolume,
					    		mnfctId:two.mnfct ==null?"":two.mnfct.mnfctId,
					    		netWeight:two.netWeight /two.product.unitRate,
					    		amount:two.amount,
					    		calcMethod:two.calcMethod,
					    		grade:two.grade,
					    		contractUnitPrice: two.unitContractPrice,
					    		realUnitPrice:two.realUnitPrice,
					    		floatPrice:two.floatPrice,
					    		basicPrice:two.basicPrice,
					    		storePrice:two.storePrice,
					    		contractMoney:two.contractMoney,
					    		realMoney:two.realMoney,
					    		implStd:two.implStd,
					    		notes:two.notes,
					    		orderCode:two.orderCode,
					    		amountUnit: '',
								netWeightUnit: '',
								precision: 0,
								unitRate: 0
					    	}

						  },
						  // 创建新货物对象
					      object(){
					    	let vm = this
					    	let one =vm.insInspectionBillVo.insInspectionBillDTO['conContract']
					    	return {
					    		sellerId: one['sellerId'],
					    		buyerId: one['buyerId'],
					    		businessType:one['contractType'],
					    		instockDate: '',
								storageId:'',
								contractDetailId:'',
					    		// 以上必要
					    		productId:'',
					    		materialId:'',
					    		surfaceId:'',
					    		labelThick:'0',
					    		labelWidth:'0',
					    		goodsLength:'0',
					    		edge:'',
					    		referThick:'',
					    		realWidth:'',
					    		trademark:'',
					    		goodsVolume:'',
					    		mnfctId:'',
					    		netWeight:'',
					    		amount:'',
					    		calcMethod:'',
					    		grade:'',
					    		contractUnitPrice:'',
					    		realUnitPrice:'',
					    		floatPrice:'',
					    		basicPrice:'',
					    		storePrice:'',
					    		contractMoney:'',
					    		realMoney:'',
					    		implStd:'',
					    		notes:'',
					    		amountUnit: '',
								netWeightUnit: '',
								precision: 0,
								unitRate: -1
					    	}  
					      }
					   }
					})
				}
		})
	}
	/** *******************侧边栏********************************** */

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
				ajax.detail('/settle', {
					productId: data.insInspectionBill.inspectionBillId
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
							util:util,
							tableConfig: {
								loading: false,
								columns: ['index','operation']
							},
							operation:[
								'delete'
							]
						},
						computed: {
							isShowAdd () {
								let vm = this 
								let businessType = vm.model.insInspectionBill.businessType
								let one = vm.model.insInspectionBill.inspectionStatus !='A'
								let two = vm.tableData.length < 1
								if(businessType == 'H'){
//									1.货押融资	
									return one&&two	
								}else if(businessType =='C'){
//									2.定向销售
									return one
								}else if(businessType == 'X'){
//									3.采购自销
									return one
								}else if(businessType =='D'){
//									4.仓单质押
									return one&&two
								}
							},
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
											// TODO 根据Tab索引查询数据
											setTimeout(function () {
												vm.tabData[index] = {
														test: '测试TAB'
												}
												vm.loading = false
											}, 1)
											break
										case 2:
											// TODO 根据Tab索引查询数据
											setTimeout(function () {
												vm.tabData[index] = {
														test: '测试TAB2'
												}
												vm.loading = false
											}, 1)
											break
											
									}
								}
							},
							fetchDataByEdit () {
								let vm = this
								 vm.tableConfig.loading = true
								var id = vm.model.insInspectionBill.inspectionBillId
								ajax.post('/settle/settledetail',{ id : id}).then(function (res) {
									vm.tableData = res.data
									if (vm.tableData != null && detailbySub && detailbySub.show) {
										vm.tableData.forEach(function (item) {
											if (item['insInspectionSub']['inspectionSubId'] === detailbySub.model.insInspectionSub.inspectionSubId) {
												showSlidebySub(item)
											}
										})
									}
									vm.tableConfig.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
							},
							fetchDataByProduct () {
								let vm = this
								 vm.tableConfig.loading = true
								ajax.post('/settle/settledetailByPassAll',{ id : vm.model.insInspectionBill.inspectionBillId}).then(function (res) {
									vm.productData = res.data
									vm.tableConfig.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
								
							},
							// 新增
							addProduct() {
								let vm =this
								addOrEdit(vm.model)
							},
							detail (row) {
								row.data = data
								showSlidebySub(row)
							},
							showDeleteBtn(row) {
								let one = row.insInspectionSub.auditStatus
								if(one == 'B' || one=='D'){
									return false
								}else if(one == 'A'||one =='C'){
									return true
								}
							},
							// 提交按钮
							showsumbitBtn(row,index){
								let one = {
										id : row.insInspectionSub.inspectionSubId,
										auditStatus:'B'
								}
								let vm = this
								ajax.update('/settle/submit', one).then((result) => {
									// TODO 处理提交之后的事件
									vm.fetchDataByEdit()
									row.insInspectionSub.auditStatus = 'B'
								})
							},
							del (row) {
								var vm = this
								ajax.delete('/settle/sub', row.insInspectionSub.inspectionSubId).then(function (result) {
									 // vm.fetchData()
									vm.fetchDataByEdit()
								}, function () {
									vm.fetchDataByEdit()
								  // vm.fetchData()
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
			// 切换之后 重新获取列表
			detail.fetchDataByEdit()
			detail.fetchDataByProduct()
			if (detailbySub && detailbySub.show) {
				detailbySub.show = false
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/** **************************子侧边栏******************************************* */
	
	
	
	
	/**
	 * 显示子单侧边栏
	 */
	function showSlidebySub(data) {
		// 初始化detail组件
		if (detailbySub == null) {
			require(['component-slide','util'], function (componentSlide,util) {
				/*
				 * 通过ajax加载页面 首次载入加载静态前端，后续不再加载加载静态前端
				 */
				var slide = ".slideEidt"
				$(slide).html("<div class='rota-load'><i class='icon-jiazai icon-pulse'></i></div>")
				ajax.detail('/settle/sub', {
					id: data.insInspectionSub.inspectionSubId
				}).then(function (result) {
					var result = $(result).find(".slide-cnt")
					$(slide).html(result)
					detailbySub = new Vue({
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
							unit:{
								
							},
							productData: [],
							util:util,
							tableConfig: {
								loading: false,
								columns: ['index','operation']
							},
							operation:[
								'delete'
							]
						},
						methods: {
							/**
							 * 获取对应索引的tab数据
							 */
							fetchData (index) {
								let vm = this
								// if (index > 0) {
								// vm.loading = true
								//									
								// }
							},
							fetchDataByProduct () {
								let vm = this
								vm.tableConfig.loading = true
								ajax.post('/settle/settleListdetail',{ id : vm.model.insInspectionSub.inspectionSubId}).then(function (res) {
									vm.tableData = res.data
									
									vm.tableConfig.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
							},
							/**
							 * 编辑
							 */
							edit () {
								Edit(this.model)
							},
							/**
							 * 提交
							 */
							submit() {
								let one = {
									id : data.insInspectionSub.inspectionSubId,
									auditStatus:'B'
								}
								let vm =this
								ajax.update('/settle/submit', one).then((result) => {
										// TODO 处理提交之后的事件
										detail.fetchDataByEdit()
										vm.model.insInspectionSub.auditStatus = 'B'
								})
								
							},
							addOrEditProduct() {
								// newVue.insInspectionBillVo.insInspectionBill
								// = data
								// addByProduct(data)
								// bathAddByProduct(this.model,this.tableData)
								bathUpdate(this.model,this.tableData)
							},
							editProduct() {
								// newVue.insInspectionBillVo.insInspectionBill
								// = data
								// addByProduct(data)
								// bathAddByProduct(this.model)
								// bathUpateByProduct(this.tableData)
							},
							del (row){
								let vm = this
								ajax.delete('/settle/detail', row.insInspectionDetail.inspectionDetailId).then(function (result) {
									 // vm.fetchData()
									vm.fetchDataByProduct()
								}, function () {
									vm.fetchDataByProduct()
								  // vm.fetchData()
								})
							},
							/**
							 * 添加判断删除是否显示
							 */
							showDeleteBtn(row){
								let one = this.model.insInspectionSub.auditStatus
								if(one =='B'||one=='C'||one=='D'){
									return false;
								}else if(one =='A'){
									return true;
								}
							},
							 /**
								 * 获取品类详情 根据品类id one 对象
								 */
							getProductDetail (index, id,one) {
								if (id) {
									var vm = this
									ajax.findOne('/baseProduct', id).then(function (result) {
										if (result.state === 1) {
											var data = result.data
											vm.tableData[index].insInspectionDetail.amountUnit = data.quantityUnit
											vm.tableData[index].insInspectionDetail.netWeightUnit = data.weightUnit
											vm.tableData[index].insInspectionDetail.precision = data.precision
											vm.tableData[index].insInspectionDetail.unitRate = data.unitRate
										}
									})
								}
							},
							getProductDetailByCon (row) {
								if (row) {
									var vm = this
									ajax.findOne('/baseProduct', row.productId).then(function (result) {
										if (result.state === 1) {
											var data = result.data
											row.amountUnit = data.quantityUnit
											row.netWeightUnit = data.weightUnit
											row.precision = data.precision
											row.unitRate = data.unitRate
										}
									})
								}
							},
						},
						components: {
							componentSlide: componentSlide,
							componentTable: componentTable
						}
					})
				})
			})
		} else {
			detailbySub.model = data
			detailbySub.show = true
			detailbySub.fetchDataByProduct()
		}
	}
 // ////////////////////////验证////////////////////
	
	
	// ---------------
	// 合同 - 表单验证
	// ---------------
	function contractValid1 () {
		util.formValid({
			selector: '#ProductDialog',
			onkeyup: false,
			errorPlacement: function(error, element) { // 错误信息位置设置方法
				if (element.parents('.cell').length > 0) {
					error.appendTo( element.parents('.cell').find('.err') ) // 这里的element是录入数据的对象
				} else {
					 error.appendTo(element.parent())
				}
			},
			rules: {
				'instockDate': {
					required: true
				},
				'voucherNo': {
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
				'referThick[]':{
					require: true
				},
				'mnfctId[]':{
					require:true
				},
				'calcMethod[]':{
					require:true
				},
				'mallMnfcts[]': {
					required: true
				},
				'amount[]': {
					required: true,
					min: 1
				},
				'grade[]':{
					require:true
				},
				'netWeight[]': {
					required: true,
					min: 1
				},
				'contractUnitPrice[]': {
					required: true,
					min: 1
				},
				'realUnitPrice[]':{
					required: true,
					min: 1
				},
				'floatPrice[]':{
					required: true,
					min: 1
				},
				'basicPrice[]':{
					required: true,
					min: 1
				},
				'invoiceFee[]':{
					required: true,
					min: 1
				},
				'storePrice[]':{
					required: true,
					min: 1
				},
				'trademark[]':{
					required: true,
					min: 1
				},
				'realWidth[]':{
					required: true,
					min: 1
				}
				
			},
			messages: {
				'instockDate': {
					required: '请选择入库日期'
				},
				'voucherNo': {
					required: '请输入存货凭证编号'
				},
				'product[]': {
					required: '请选择品类'
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
				'referThick[]':{
					required: '请输入参厚'
				},
				'edge[]': {
					required: '请选择边部'
				},
				'mnfctId[]':{
					require:'请选择制造商'
				},
				'calcMethod[]':{
					require:'请选择计算方式'
				},
				'grade[]':{
					require:'请填写等级'
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
				'contractUnitPrice[]': {
					required: '请输入合同单价'
				},
				'realUnitPrice[]':{
					required: '请输入实际单价',
					min: 1
				},
				'floatPrice[]':{
					required: '请输入升贴水',
					min: 1
				},
				'basicPrice[]':{
					required: '请输入基价',
				},
				'realMoney[]':{
					require:'请输入实际金额'
				},
				'realMoney[]':{
					require:'请输入手续费'
				},
				'invoiceFee[]':{
					require:'请输入开票费'
				},
				'storePrice[]':{
					require:'请输入手续费'
				},
				'trademark[]':{
					require:'请输入牌号'
				},
				'realWidth[]':{
					require:'请输入实宽'
				},
				'trademark[]':{
					
				}
			}
		})
	}
	
	
	
	
	
	
	
	// /////////////////////end///////////////////////////////////
	// ---------------
	// 子单验证 - 表单验证
	// ---------------
	function addSubAndGoodsValid () {
		util.formValid({
			selector: '#SubProductDialogForm',
			onkeyup: false,
			rules: {
				'instockDate': {
					required: true
				},
//				'voucherNo':{
//					required: true
//				},
				'storageId':{
					required: true
				}
			},
			messages: {
				'instockDate': {
					required: '请选择入库日期'
				},
//				'voucherNo':{
//					required: '请填写存货编号'
//				},
				'storageId':{
					required: '请填写选择仓库'
				}

			}
		})
	}
	// ---------------
	// 子单验证 - 表单验证
	// ---------------
	function EditSubAValid () {
		util.formValid({
			selector: '#EditsubForm',
			onkeyup: false,
			rules: {
				'inspectionBillCode': {
					required: true
				},
				'instockDate':{
					required: true
				},
				'voucherNo':{
					required: true
				},
				'storageId':{
					required: true
				}
			},
			messages: {
				'inspectionBillCode': {
					required: '请输入验货单号'
				},
				'instockDate':{
					required: '请选择入库日期'
				},
				'voucherNo':{
					required: '请填写存货编号'
				},
				'storageId':{
					required: '请填写选择仓库'
				}
			}
		})
	}
	// ---------------
	// 增加货物验证 - 表单验证
	// ---------------
	function addDetilsValid () {
		util.formValid({
			selector: '#addproductform',
			onkeyup: false,
			rules: {
				'productId': {
					required: true
				},
				'materialId':{
					required: true
				},
				'surfaceId':{
					required: true
				},
				'labelThick':{
					required: true
				},
				'labelWidth':{
					required: true
				},
				'goodsLength':{
					required: true
				},
				'edge':{
					required: true
				},
				'referThick':{
					required:true
				},
				'trademark':{
					required:true
				},
				'goodsVolume':{
					required: true
				},
				'mnfctId':{
					required:true
				},
				'calcMethod':{
					required:true
				},
				'amount':{
					required:true
				},
				'netWeight':{
					required:true
				},
				'grade':{
					required:true
				},
				'contractUnitPrice':{
					required:true
				},
				'realUnitPrice':{
					required:true
				},
				'floatPrice':{
					required:true
				},
				'basicPrice':{
					required:true
				},
				'contractMoney':{
					required:true
				},
				'realMoney':{
					required:true
				},
				'filePath':{
					required:true
				}
			},
			messages: {
				'productId': {
					required: '请选择品类'
				},
				'materialId':{
					required: '请选择材质'
				},
				'surfaceId':{
					required: '请选择表面'
				},
				'labelThick':{ 
					required: '请填写标准厚度'
				},
				'labelWidth':{
					required: '请填写宽度'
				},
				'goodsLength':{
					required: '请填写长度'
				},
				'edge':{
					required: '请选择边部'
				},
				'referThick':{
					required:'请填写参厚'
				},
				'trademark':{
					required:'请填写牌号'
				},
				'goodsVolume':{
					required:'请填写卷号'
				},
				'mnfctId':{
					required:'请选择制造商'
				},
				'calcMethod':{
					required:'请选择计算方式'
				},
				'amount':{
					required:'请填写数量(张/卷)'
				},
				'netWeight':{
					required:'请填写重量'
				},
				'grade':{
					required:'请填写等级'
				},
				'contractUnitPrice':{
					required:'请填写合同单价'
				},
				'realUnitPrice':{
					required:'请填写实际单价'
				},
				'floatPrice':{
					required:'请填写升贴水'
				},
				'basicPrice':{
					required:'请填写基价'
				},
				'contractMoney':{
					required:'请填写合同金额'
				},
				'realMoney':{
					required:'请填写实际金额'
				},
				'filePath':{
					required:'请上传图片'
				}
			}
		})
	}
	/** ***************************************公用HTML代码****************************************** */
	// 货物信息列表
	var goodsHtml= `
		<form id="dialog-content">
					<template>
						<div>
							<h5 class="bg-tit">
								<span>货物信息</span>
								<input type="button" class="ui-btn pull-right btn_new_line" @click="addBydialog" value="合同货物" v-if="isShow">
								<span class="pull-right">&nbsp;&nbsp;</span> 
								<input type="button" class = "ui-btn pull-right btn_new_line" value="新增" @click="addObject"  v-if="isShow"/>
								<span class="pull-right">&nbsp;&nbsp;</span> 
								<component-import class="ui-btn pull-right btn_new_line" @success="backtrack" type="insInspection"></component-import>
							</h5>
							<div class="ui-row">
								<div class="ui-col">
									  <component-table 
									  border
									  :max-height="400"
									  @row-click="rowCilck"
									  :data="tableData"
									  style="width: 100%">
									  
									    <el-table-column label="品类" width="180">
									       <template slot-scope="scope">
									       		<div>
													<component-select :id="'product'+scope.$index" v-model="scope.row.insInspectionDetail.productId" type="baseProduct" :search="true" :remoteseach="true" name="product[]" @change="getProductDetail(scope.$index, scope.row.insInspectionDetail.productId)">
	                                         		</component-select>
                                         		</div>
                                         		<div class="err"></div>
									       </template>
									    </el-table-column>
									    <el-table-column label="系列" width="180">
									       <template slot-scope="scope">
									       		<div>
													<component-select :id="'orderCode'+scope.$index" v-model="scope.row.insInspectionDetail.orderCode" type="orderCode" :search="true" :remoteseach="true" name="orderCode[]" @change="doclear(scope.$index,1)">
	                                         		</component-select>
                                         		</div>
                                         		<div class="err"></div>
									       </template>
									    </el-table-column>
									    <el-table-column label="材质" width="180">
									       <template slot-scope="scope">
									       		<div>
										       		<component-select :id="'dictMallSpec'+scope.$index" v-model="scope.row.insInspectionDetail.materialId" type="texture" name="dictMallSpec[]" :param="scope.row.insInspectionDetail.orderCode"   @change="doclear(scope.$index,2)" >
	                                         		</component-select>
                                         		</div>
                                         		<div class="err"></div>
									       </template>
									    </el-table-column>
										<el-table-column label="表面" width="180">
											<template slot-scope="scope">
												<div>
													<component-select :id="'baseProcess'+scope.$index" v-model="scope.row.insInspectionDetail.surfaceId" type="surface" :search="true"  name="baseProcess[]"  :param="[scope.row.insInspectionDetail.materialId,scope.row.insInspectionDetail.orderCode]">
	                                         		</component-select>
	                                         	</div>
                                         		<div class="err"></div>
											</template>
										</el-table-column>
										<<el-table-column
										v-if="false"
										label="标准厚度"
										width="180"
										>
										<template slot-scope="scope">
												<div>
													<el-input-number size="small" :class="'labelThick'+scope.$index" v-model="scope.row.insInspectionDetail.labelThick" controls-position="right" :min="1" name="labelThick[]"></el-input-number>
												</div>
											 <div class="err"></div>
										</template>
									</el-table-column>
										<el-table-column label="规格(mm)" width="280">
											<template slot-scope="scope">
												<div class="ui-row">
													<input type="text" :id="'labelThick'+scope.$index" class="ui-input-control ui-col-25" v-model="scope.row.insInspectionDetail.labelThick" name="labelThick[]">
													<label class="ui-label-control ui-col-10">&nbsp;*</label>
													<input type="text" :id="'labelWidth'+scope.$index" class="ui-input-control ui-col-25" v-model="scope.row.insInspectionDetail.labelWidth" name="labelWidth[]">
													<label class="ui-label-control ui-col-10">&nbsp;*</label>
													<input type="text" :id="'goodsLength'+scope.$index" class="ui-input-control ui-col-25" v-model="scope.row.insInspectionDetail.goodsLength" name="goodsLength[]">
												</div>
												<div class="ui-row err">
												</div>
											</template>
										</el-table-column>
									    
									    <el-table-column label="边部" width="180">
											<template slot-scope="scope">
												<div>
													<component-select :id="'edge'+scope.$index" v-model="scope.row.insInspectionDetail.edge" type="EdgeType" name="edge[]">
	                                         		</component-select>
                                         		</div>
                                         		<div class="err"></div>
											</template>
										</el-table-column>
										<el-table-column label="参厚(mm)" width="200">
											<template slot-scope="scope">
												<div>
													<el-input-number size="small" :class="'referThick'+scope.$index" v-model="scope.row.insInspectionDetail.referThick" controls-position="right" :min="0" name="referThick[]"></el-input-number>
													
												</div>
                                         		<div class="err"></div>
											</template>
										</el-table-column>
										<el-table-column label="实宽(mm)" width="200">
											<template slot-scope="scope">
												<div>
													<el-input-number size="small" :class="'realWidth'+scope.$index" v-model="scope.row.insInspectionDetail.realWidth" controls-position="right" :min="0" name="realWidth[]"></el-input-number>
													
												</div>
                                         		<div class="err"></div>
											</template>
										</el-table-column>
										<el-table-column label="牌号" width="200">
											<template slot-scope="scope">
												<div>
												  <component-select :id="'trademark'+scope.$index" v-model="scope.row.insInspectionDetail.trademark" type="trademark" :search="true"  name="trademark[]"  :param="[scope.row.insInspectionDetail.materialId,scope.row.insInspectionDetail.orderCode]">
	                                         		</component-select>
												</div>
                                         		<div class="err"></div>
											</template>
										</el-table-column>
										<el-table-column label="卷号" width="200">
											<template slot-scope="scope">
												<div>
												 <el-input
														placeholder="卷号"
														v-model="scope.row.insInspectionDetail.goodsVolume"
													 	:id="'goodsVolume'+scope.$index"
														name="goodsVolume[]"
														clearable
														size="small" />
												</div>
												 <div class="err"></div>
											</template>
										</el-table-column>
										
										<el-table-column label="制造商" width="250">
											<template slot-scope="scope">
												<div>
												<component-select :id="'mallMnfcts'+scope.$index" v-model="scope.row.insInspectionDetail.mnfctId" type="manufacturer" :search="true"  name="mallMnfcts[]"  :param="scope.row.insInspectionDetail.orderCode">
												</component-select>
												</div>
                                         		<div class="err"></div>
											</template>
										</el-table-column>
										<el-table-column label="数量" width="200">
												<template slot-scope="scope">
													<div>
														<el-input-number size="small" :class="'amount'+scope.$index" v-model="scope.row.insInspectionDetail.amount" controls-position="right" :min="1" name="amount[]"></el-input-number>
														{{ scope.row.insInspectionDetail.amountUnit }}
													</div>
													<div class="err">
													</div>
												</template>
											</el-table-column>	
										<el-table-column label="重量" width="200">
											<template slot-scope="scope">
												<div>
												<el-input-number size="small" :class="'netWeight'+scope.$index" v-model="scope.row.insInspectionDetail.netWeight" controls-position="right" :min="1" name="netWeight[]"></el-input-number>
													{{ scope.row.insInspectionDetail.netWeightUnit }}
												</div>
												<div class="err">
												</div>
											</template>
										</el-table-column>
										<el-table-column label="计算方式" width="250">
										<template slot-scope="scope">
											<div>
											<el-select 
											:id="'calcMethod'+scope.$index" 
											name="calcMethod[]"
											v-model="scope.row.insInspectionDetail.calcMethod" placeholder="请选择计算方式" :id="'calcMethod'+ scope.$index" name="calcMethod[]">
											<el-option
											  v-for="item in selectData.calcMethods"
											  :key="item"
											  :label="item"
											  :value="item">
											</el-option>
										  </el-select>
											</div>
											 <div class="err"></div>
										</template>
									</el-table-column>

									
								<el-table-column label="等级" width="150">
									<template slot-scope="scope">  
										<component-select :id="'grade'+scope.$index" v-model="scope.row.insInspectionDetail.grade" type="DictGrade" :search="true"  name="grade[]"  :param="scope.row.insInspectionDetail.orderCode">
										</component-select>
										<div class="err">
										</div>
									</template>
								</el-table-column>	
								<div v-if="false">
								<el-table-column  label="合同单价（元）" width="200">
								<template slot-scope="scope">
									<div>
										<el-input-number size="small" :class="'contractUnitPrice'+scope.$index" v-model="scope.row.insInspectionDetail.contractUnitPrice" controls-position="right" :min="1" name="contractUnitPrice[]"></el-input-number>
									</div>
									<div class="err">
									</div>
								</template>
							</el-table-column>	
							<el-table-column  label="实际单价(元)" width="200">
							<template slot-scope="scope">
								<div>
									<el-input-number size="small" :class="'realUnitPrice'+scope.$index" v-model="scope.row.insInspectionDetail.realUnitPrice" controls-position="right" :min="1" name="realUnitPrice[]"></el-input-number>
								</div>
								<div class="err">
								</div>
							</template>
						</el-table-column>	
						<el-table-column  label="升贴水" width="200">
							<template slot-scope="scope">
								<div>
									<el-input-number size="small" :class="'floatPrice'+scope.$index" v-model="scope.row.insInspectionDetail.floatPrice" controls-position="right" :min="1" name="floatPrice[]"></el-input-number>
								</div>
								<div class="err">
								</div>
							</template>
						</el-table-column>	
						<el-table-column  label="基价" width="200">
						<template slot-scope="scope">
							<div>
								<el-input-number size="small" :class="'basicPrice'+scope.$index" v-model="scope.row.insInspectionDetail.basicPrice" controls-position="right" :min="1" name="basicPrice[]"></el-input-number>
							</div>
							<div class="err">
							</div>
						</template>
					</el-table-column>	
					<el-table-column  label="合同金额" width="200">
					<template slot-scope="scope">
						<div>
							<el-input-number size="small" :class="'contractMoney'+scope.$index" v-model="scope.row.insInspectionDetail.contractMoney" controls-position="right" :min="1" name="contractMoney[]"></el-input-number>
						</div>
						<div class="err">
						</div>
					</template>
					</el-table-column>	
					<el-table-column  label="商城价" width="200">
					<template slot-scope="scope">
						<div>
							<el-input-number size="small" :class="'storePrice'+scope.$index" v-model="scope.row.insInspectionDetail.storePrice" controls-position="right" :min="1" name="storePrice[]"></el-input-number>
						</div>
						<div class="err">
						</div>
					</template>
					</el-table-column>	
					<el-table-column  label="实际金额(元)" width="200">
					<template slot-scope="scope">
						<div>
							<el-input-number size="small" :class="'realMoney'+scope.$index" v-model="scope.row.insInspectionDetail.realMoney" controls-position="right" :min="1" name="realMoney[]"></el-input-number>
						</div>
						<div class="err">
						</div>
					</template>
					</el-table-column>	
					<el-table-column  label="手续费" width="200">
					<template slot-scope="scope">
						<div>
							<el-input-number size="small" :class="'serviceFee'+scope.$index" v-model="scope.row.insInspectionDetail.serviceFee" controls-position="right" :min="1" name="serviceFee[]"></el-input-number>
						</div>
						<div class="err">
						</div>
					</template>
					</el-table-column>	
					<el-table-column  label="开票费" width="200">
					<template slot-scope="scope">
						<div>
							<el-input-number size="small" :class="'invoiceFee'+scope.$index" v-model="scope.row.insInspectionDetail.invoiceFee" controls-position="right" :min="1" name="invoiceFee[]"></el-input-number>
						</div>
						<div class="err">
						</div>
					</template>
					</el-table-column>
					</div>
					<el-table-column
						width="180"
						label="货物照片">
					  <template slot-scope="scope"> 
					  <component-upload  v-model="scope.row.sphotosGoodsList" @success="detailSuccess" :ref="'attach' + scope.$index" :accept="accept" :multiple="true" :upload-data="scope.$index" @change="tableArrlength" :file-list="scope.row.sphotosGoodsFileList" @remove="onRemove" :auto-upload = "true" ></component-upload>	
					  </template>
					</el-table-column>
					<el-table-column
					width="120"
				  label="执行标准">
				  <template slot-scope="scope">  
				  
				  <component-select :id="'implStd'+scope.$index" v-model="scope.row.insInspectionDetail.implStd" type="DictStd" :search="true"  name="implStd[]"  :param="scope.row.insInspectionDetail.orderCode">
				</component-select>
				  <div class="err">
					</div>
				  </template>
				</el-table-column>
					<el-table-column
					width="120"
				  label="备注">
				  <template slot-scope="scope"> 
				  <el-input
					placeholder="备注"
					v-model="scope.row.insInspectionDetail.notes"
					clearable
					 size="small"
					>
				  </el-input>
				  </template>
				</el-table-column>
					<el-table-column label="操作" width="180"  v-if="isShow">
						<template slot-scope="scope">
						<span class="ui-btn ui-blue" @click="handleEdit(scope.$index, scope.row)">复制</span>
						<span class="ui-btn ui-red" @click="handleDelete(scope.$index, scope.row)">删除</span>
						</template>
					</el-table-column>
								</component-table>
								</div>
							</div>
						</div>
					</template>
					<div class="ui-row  pull-right" style="margin-top: 10px">
					<div class="ui-form-group ui-col" style="width:450px">
						<div class="ui-form-group ui-col-60">
							<label class="ui-label-control ui-col-40">货物总数量</label>
							<label class="ui-label-control ui-col-60">{{totalNumber}}</label>
						</div>
						<div class="ui-form-group ui-col-40">
							<label class="ui-label-control ui-col-40">货物总重</label>
							<label class="ui-label-control ui-col-60">{{totalWeight}} 吨</label>
						</div>
					</div>
				</div>
				</form>
				</div>				
				</div>	
				`
	var conContractGoods = ` <el-table-column
	v-if="false"
	label="存放仓库"
	width="120">
	<template slot-scope="scope">{{ scope.row.storageId }}</template>
  </el-table-column>
  <el-table-column
	  v-if="false"
	prop="name"
	label="提货人"
	width="120">
  </el-table-column>
  <el-table-column
	prop ="productId"
	label="品类"
	width="120"
	>
	<template slot-scope="scope">
	{{scope.row.product.productName}}
	</template>
  </el-table-column>
  <el-table-column
	  v-if="false"
	prop="storageDate"
	label="入库日期"
	width="120"
	>
  </el-table-column>
  <el-table-column
	  v-if="false"
	label="库存状态"
	width="120"
	>
	<template slot-scope="scope">
		
	</template>
  </el-table-column>
  <el-table-column
	prop="orderCode"
	label="系列"
	width="120"
	>
  </el-table-column>
  <el-table-column
	prop="materialId"
	label="材质"
	width="120"
	>
  </el-table-column>
  <el-table-column
	prop="surfaceId"
	label="表面"
	width="120"
	>
	<template slot-scope="scope">
		 {{scope.row.surfaceId}}
		</template>
  </el-table-column>
  <el-table-column
	  v-if="false"
	prop="labelThick"
	label="标准厚度"
	width="120"
	>
  </el-table-column>
  <el-table-column
	label="标签规格(厚度*宽度*长度)"
	 width="210"
	>
	 <template slot-scope="scope">
	  {{scope.row.labelThick}}* {{scope.row.labelWidth}}* {{scope.row.goodsLength}}
	 </template>
  </el-table-column>
  <el-table-column
	prop="edge"
	label="边部"
	width="120"
	>
	<template slot-scope="scope">
	{{scope.row.edge}}
		</template>
  </el-table-column>
  <el-table-column
	  v-if="false"
	prop="referThick"
	label="参厚"
	>
  </el-table-column>
  <el-table-column
	  v-if="false"
	prop="realWidth"
	label="实宽"
	width="120"
	>
  </el-table-column>
  <el-table-column
  v-if="false"
	prop="trademark"
	label="牌号"
	width="120"
	>
  </el-table-column>
  <el-table-column
  v-if="false"
	prop="goodsVolume"
	label="卷号"
	width="120"
	>
  </el-table-column>
  <el-table-column
  :show-overflow-tooltip="true"
	prop="mnfctId"
	label="厂家"
	 width="120"
	>
	<template slot-scope="scope">
	<span v-if="scope.row.mnfct !=null">{{scope.row.mnfct.mnfctName}}</span>
		</template>
  </el-table-column>
  <el-table-column
	prop="netWeight"
	label="重量"
	 width="120"
	>
	<template slot-scope="scope">
	{{util.formatNumber((scope.row.netWeight / scope.row.product.unitRate), scope.row.product.precision)}}{{scope.row.product.weightUnit}}
		</template>
  </el-table-column>
  <el-table-column
	prop="amount"
	label="数量"
	 width="120"
	>
	 <template slot-scope="scope">
		 {{scope.row.amount}}{{scope.row.product.quantityUnit}}
		</template>
  </el-table-column>
  <el-table-column
  v-if="false"
	prop="calcMethod"
	label="计算方式"
	 width="120"
	>
  </el-table-column>
   <el-table-column
   v-if="false"
	prop="goodsRank"
	label="等级"
	 width="120"
	>
  </el-table-column>
   <el-table-column
	  v-if="false"
	prop="unitContractPrice"
	label="合同单价"
	 width="150"
	>
  </el-table-column>
   <el-table-column
	   v-if="false"
	prop="realUnitPrice"
	label="实际单价"
	 width="150"
	>
	 <template slot-scope="scope">
		 {{scope.row.realUnitPrice}}	元/{{scope.row.product.weightUnit}}
	 </template>
  </el-table-column>
   <el-table-column
   v-if="false"
	prop="storePrice"
	label="商城价"
	 width="120"
	>
  </el-table-column>
   <el-table-column
   v-if="false"
	prop="basicPrice"
	label="基价"
	 width="120"
	>
  </el-table-column>
   <el-table-column
   v-if="false"
	prop="floatPrice"
	label="升贴水"
	 width="120"
	>
  </el-table-column>
   <el-table-column
  v-if="false"
	prop="contractMoney"
	label="合同金额"
	 width="120"
	>
  </el-table-column>
  <el-table-column
  v-if="false"
	prop="realMoney"
	label="实际金额"
	 width="120"
	>
  </el-table-column>
  <el-table-column
  v-if="false"
	prop="implStd"
	label="执行标准"
	 width="120"
	>
  </el-table-column>
   <el-table-column
   v-if="false"
	prop="notes"
	label="备注"
	 width="120"
	>
  </el-table-column>`
})



