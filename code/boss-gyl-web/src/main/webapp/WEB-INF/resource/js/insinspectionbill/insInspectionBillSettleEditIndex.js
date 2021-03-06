/**
 * 审核设置
 * 
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
					// 金融货物类型
					typeList:['X','D','F'],
					// 查询状态
					auditStatusList:['B','C','D'],
					// 业务类型
					businessType:'',
					// 子单单号
					subCode:'',
					// 创建人
					createUser:'',
					// 创建时间
					maxDate:'',
					minDate:'',
					contractId: '',
				},
				// 页码
				pageNum: 0,
				// 分页大小
				pageSize: 20,
				// 排序
				orderByClause: ''
			},
			// 业务类型
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
				ajax.findPage('/settleAudit', vm.searchParam).then(function (res) {
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
	     	ajax.getOptions(['BusinessType']).then((result) => {
		    	let arr = result.data
		    	
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
				ajax.detail('/settleAudit/settle', {
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
							util: util,
							contract: {},
							tableConfig: {
								loading: false,
								columns: ['index','operation']
							},
							operation:[
								
							]
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
											// this.fetchDataByProduct()
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
								ajax.post('/settle/settleListdetail',{ id : vm.model.insInspectionSub.inspectionSubId}).then(function (res) {
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
							passBySub(){
								let vm = this
								let one ={
									businessType:vm.model.conContract.contractType,
									id: vm.model.insInspectionSub.inspectionSubId,
									auditStatus: "D",
									contractId:vm.model.conContract.contractId,
									insInspectionBillId:vm.model.insInspectionBill.inspectionBillId,
									instockId:vm.model.insInspectionBill.instockId
								}
								bathUpateByProduct($.extend(true, [], this.productData),one)
							},
							passOrNotPass(status){
								let vm = this
								let one ={
									businessType:data.conContract.contractType,
									id: data.insInspectionSub.inspectionSubId,
									auditStatus: status,
									contractId:vm.model.conContract.contractId,
									insInspectionBillId:vm.model.insInspectionBill.inspectionBillId,
									instockId:vm.model.insInspectionBill.instockId
								}
								ajax.post('/settleAudit/updatePassOrNoPass',one).then(function (res) {
										vm.tableConfig.loading = false
										vm.loading = false
										vm.model.insInspectionSub.auditStatus = status
								}, function () {
									vm.tableConfig.loading = false
								})
							},
							bathUpateByProduct(){
								// bathUpateByProduct($.extend(true, [], this.productData))
							},
							edit(row){
								addByProduct(row)
								// row.insInspectionDetail.realUnitPrice = ''
							}
						},
						watch:{  
							
				        },
				        mounted () {
							this.fetchDataByProduct()
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
// detail.fetchDataByEdit()
			detail.fetchDataByProduct()
		}
	}
	
	
	
	/**
	 * 批量修改 货物信息
	 */
	function bathUpateByProduct (data,passData){
		util.dialog({
			id: 'SubProductDialog',
			width: 800,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '批量修改货物信息',
			content: `
					${updateHtml}
				`,
				okValue: '确定',
				ok: function () {
					newVue.Bathupdate()
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
							tableData: [],
							model: data,
					        insInspectionBillVo:{
								insInspectionDetail:{},
								SphotosGoods:{},
								insInspectionDetailList:[]
							},
							insInspectionBillVoList:[],
							util:util,
							isUpload:true
						},
						components: {
							componentTable: componentTable
						},
						mounted () {
							this.tableData = this.model
							let oneData = this.insInspectionBillVo
							oneData.businessType = passData.businessType,
							oneData.id= passData.id,
							oneData.auditStatus= passData.auditStatus
							oneData.contractId= passData.contractId
							oneData.insInspectionBillId= passData.insInspectionBillId
							oneData.instockId= passData.instockId
						},
						watch:{  
							'tableData': {
								handler: function (newVal, oldVal) {
									for(var i  in newVal ){
										let one  = newVal[i]
									    let contractUnitPrice = one.insInspectionDetail.contractUnitPrice
									    let contractMoney = one.insInspectionDetail.contractMoney
									    //console.log("watch",this.isUpload)
									    if(contractUnitPrice<=0||contractMoney<=0){
										   this.isUpload = false
									    }else{
										    this.isUpload = true
									    }
										 one.insInspectionDetail.realMoney  = (one.insInspectionDetail.realUnitPrice * one.insInspectionDetail.netWeight)/one.baseProduct.unitRate
										  one.insInspectionDetail.contractMoney  = (one.insInspectionDetail.contractUnitPrice * one.insInspectionDetail.netWeight)/one.baseProduct.unitRate
									 }
								},
								deep: true
							}
				        },
						methods: {
						  chandge(row){
							 row.insInspectionDetail.realMoney  = row.insInspectionDetail.realUnitPrice * row.insInspectionDetail.netWeight
						  },
						  Bathupdate(){
							  let vm = this
							  // vm.insInspectionBillVo.insInspectionDetailList
								// = $.extend(true,[],vm.tableData);
							  this.format()
							   if(vm.isUpload){
								  ajax.update('/settleAudit/bathprice',vm.insInspectionBillVo).then(function (result) {
									  //detail.passOrNotPass('D')
									  detail.fetchDataByProduct()
									  page.fetchData()
									  detail.model = result.data
									  util.dialog({getIdClose: 'SubProductDialog'})
									}, function () {
										detail.fetchDataByProduct()
									})
							   }else{
								   util.promptMsg({
										type: 'tip',
										modal: false,
										content: "合同金额和合同单价为零"
								   })
							   }
							  
						  },
						  // 增加必要属性
						  format(){
							  let vm = this
							  for(var i  in vm.tableData ){
								  let one  = vm.tableData[i]
								  // one.instockDate =
									// vm.insInspectionBillVo.insInspectionSub.instockDate
								  vm.insInspectionBillVo.insInspectionDetailList.push(one.insInspectionDetail)
							  }
						  },
					      // 删除
						  del(row) {
					    	// this.tableData.splice(index,1);
						  },
						  // 单个转换
						  formatOne(two){
							let vm = this
					    	let one =vm.insInspectionBillVo.insInspectionBillDTO['conContract']
					    	return {
					    		sellerId: one['sellerId'],
					    		buyerId: one['buyerId'],
					    		businessType:one['contractType'],
					    		instockDate: vm.insInspectionBillVo.insInspectionSub.instockDate,
					    		// 以上必要
					    		productId: two.product.productId,
					    		materialId:two.materialId,
					    		surfaceId:two.surfaceId,
					    		labelThick:two.labelThick,
					    		labelWidth:two.labelWidth,
					    		goodsLength:two.goodsLength,
					    		edge:two.edges,
					    		referThick:two.referThick,
					    		realWidth:two.realWidth,
					    		trademark:two.trademark,
					    		goodsVolume:two.goodsVolume,
					    		mnfctId:two.mnfct.mnfctId,
					    		netWeight:two.netWeight,
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
					    		notes:two.notes
					    	}

						  },
						  // 创建新货物对象
					      object(){
					    	let vm = this
					    	let one =vm.model['conContract']
					    	return {
					    		sellerId: one['sellerId'],
					    		buyerId: one['buyerId'],
					    		businessType:one['contractType'],
					    		instockDate: vm.model.insInspectionSub.instockDate,
					    		inspectionSubId: vm.model.insInspectionSub.inspectionSubId,
					    		// 以上必要
					    		productId:'',
					    		materialId:'',
					    		surfaceId:'',
					    		labelThick:'0',
					    		labelWidth:'0',
					    		goodsLength:'0',
					    		edge:'0',
					    		referThick:'0',
					    		realWidth:'0',
					    		trademark:'0',
					    		goodsVolume:'0',
					    		mnfctId:'',
					    		netWeight:'0',
					    		amount:'0',
					    		calcMethod:'',
					    		grade:'0',
					    		contractUnitPrice:'0',
					    		realUnitPrice:'0',
					    		floatPrice:'0',
					    		basicPrice:'0',
					    		storePrice:'0',
					    		contractMoney:'0',
					    		realMoney:'0',
					    		implStd:'0',
					    		notes:''
					    	}  
					      }
					   }
					})
				}
		})
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** *作废******************修改单条货物价格*************************************** */
	/**
	 * 新增单条货物
	 * 
	 * @param
	 */
	function addByProduct (data) {
		util.dialog({
			width: 700,
			height: 550,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '修改单条货物价格',
			content: `
			<div class="dialog_open">
				<form id="addproductform">
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50" >
								<label class="ui-label-control ui-col-30 required-txt">品名</label>
								<div class="ui-col-60" >
									 <component-select v-model="insInspectionBillVo.insInspectionDetail.productId" type="baseProduct" :search="true" name="productId" isdisabled="disabled">
                                     </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">材质(钢种)</label>
								<div class="ui-col-60">
								<component-select v-model="insInspectionBillVo.insInspectionDetail.materialId"  type="DictMallSpec" :search="true" name="materialId" isdisabled="disabled">
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
									<component-select v-model="insInspectionBillVo.insInspectionDetail.surfaceId" type="baseProcess" :search="true"  name="surfaceId" isdisabled="disabled">
                                     </component-select>
									</div>
								</div>
								<div class="ui-form-group ui-col-50">
									<label class="ui-label-control ui-col-30 required-txt">标准厚度</label>
									<div class="ui-col-60">
										<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.labelThick" placeholder="标准厚度" name="labelThick" disabled>
									</div>
								</div>
							</div>
					</div>
					<div class="ui-row">
						<div class="ui-form-group ui-col-50">
							<label class="ui-label-control ui-col-30 required-txt">宽度</label>
							<div class="ui-col-60">
								<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.labelWidth" placeholder="宽度" name="labelWidth" disabled>
							</div>
						</div>
						<div class="ui-form-group ui-col-50">
							<label class="ui-label-control ui-col-30 required-txt">长度</label>
							<div class="ui-col-60">
								<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.goodsLength" placeholder="长度" name="goodsLength" disabled>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">边部</label>
								<div class="ui-col-60">
									<component-select v-model="insInspectionBillVo.insInspectionDetail.edge" type="EdgeType" :search="true" name="edge" isdisabled="disabled" >
                                     </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">参厚</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.referThick" placeholder="参厚" name="referThick" disabled>
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">牌号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.trademark" placeholder="牌号" name="trademark" disabled>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">卷号</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.goodsVolume" placeholder="卷号" name="goodsVolume" disabled>
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">制造商</label>
								<div class="ui-col-60">
									<component-select v-model="insInspectionBillVo.insInspectionDetail.mnfctId" type="mallMnfcts" :search="true" name="mnfctId"  isdisabled="disabled">
                                     </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">计算方式</label>
								<div class="ui-col-60">
									 <el-select v-model="insInspectionBillVo.insInspectionDetail.calcMethod" placeholder="请选择计算方式" name="calcMethod" disabled>
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
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.amount" placeholder="数量（张/卷）" name="amount" disabled>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">重量（kg）</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.netWeight" placeholder="重量（kg）" name="netWeight" disabled>
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">等级</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.grade" placeholder="等级" name="grade" disabled>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">合同单价（元/kg）</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.contractUnitPrice" placeholder="合同单价（元/kg）" name="contractUnitPrice" disabled>
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
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.floatPrice" placeholder="升贴水" name="floatPrice" disabled>
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">基价</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.basicPrice" placeholder="基价" name="basicPrice" disabled>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">合同金额</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.contractMoney" placeholder="合同金额" name="contractMoney" disabled>
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">实际金额</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.realMoney" placeholder="实际金额" name="realMoney" >
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">货物照片</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.SphotosGoods.filePath" placeholder="货物照片" name="filePath" disabled> 
								</div>
							</div>
						</div>
					</div>
					<div class="ui-row">
					<div class="ui-col">
							<div class="ui-form-group ui-col-100">
								<label class="ui-label-control ui-col-20 required-txt">备注</label>
								<div class="ui-col-80">
									<input type="text" class="ui-input-control" v-model="insInspectionBillVo.insInspectionDetail.notes" placeholder="备注" disabled>
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
						addVue.updatePrice()
					}else{
						return false
					}
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
					        },
					        realMoney:''
						},
						watch:{  
							insInspectionBillVo:{  
				                handler:function(val,oldval){  
				                },  
				                deep:true// 对象内部的属性监听，也叫深度监听
				            },  
				            // 键路径必须加上引号
				            // 实际单价（元/kg）
				            'insInspectionBillVo.insInspectionDetail.realUnitPrice':function(val,oldval){  
				               let one = this.insInspectionBillVo.insInspectionDetail
				               one.realMoney = one.netWeight * val
				            }
				        },
						methods: {
							// 新增
						  save() {
							 
						  },
						  /**
							 * 修改价格
							 */
						  updatePrice(){
							  let vm =this
							  ajax.update('/settleAudit/price',vm.insInspectionBillVo).then(function (res) {
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
						   this.insInspectionBillVo.insInspectionDetail = this.insInspectionBillDTO.insInspectionDetail
						   this.insInspectionBillVo.sphotosGoods =this.insInspectionBillDTO.sphotosGoods 
					   }
					})
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
					required: '请选择品名'
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
	var updateHtml=`
		<div class="dialog_open">
		<form id="ProductDialog">
			<h5 class="bg-tit">货物信息
			</h5>
			<div class="ui-row dialog_open">
					 <template>
					    <component-table
					      :data="tableData"
					      :max-height="500"
					      style="width: 100%">
					      <el-table-column
					        label="品名"
					        width="180">
					       <template slot-scope="scope">
								{{scope.row.productName}}
					       </template>
						</el-table-column>
					      <el-table-column
					        prop="name"
					        label="材质（钢种）"
					        width="180">  
					        <template slot-scope="scope">
								{{scope.row.insInspectionDetail.materialId}}
					       </template>
					      </el-table-column>
					      <el-table-column
					        label="表面"
					         width="180"
					        > 
					        <template slot-scope="scope">
								{{scope.row.insInspectionDetail.surfaceId}}
							</template>
					      </el-table-column>
					      <el-table-column
					       label="标准厚度">
					        <template slot-scope="scope"> 
					        {{scope.row.insInspectionDetail.labelThick}}
							</template>
					      </el-table-column>
					      <el-table-column
					       label="标签规格(厚度*宽度*长度)"
					        width="300"
					        >
					        <template slot-scope="scope">
					        	<el-row>
					        		<el-col :span="7">
					        			{{scope.row.insInspectionDetail.labelThick}}
									</el-col>
									<el-col :span="1">
									*
									</el-col>
									<el-col :span="7">
										{{scope.row.insInspectionDetail.labelWidth}}
									</el-col> 
									<el-col :span="1">
									*
									</el-col>
									<el-col :span="7">
										{{scope.row.insInspectionDetail.goodsLength}}
					        		</el-col>
					        	</el-row>
								</el-input>
							</template>
					      </el-table-column>
					      <el-table-column
					         width="120"  
					        label="边部">
					        <template slot-scope="scope"> 
					        {{scope.row.insInspectionDetail.edge}}
							</template>
					      </el-table-column>
					      <el-table-column
					        width="120"
					        label="参厚">
					        <template slot-scope="scope"> 
					        
							{{scope.row.insInspectionDetail.referThick}}
							</template>
					      </el-table-column>
					        <el-table-column
					          width="120"
					        label="卷号">
					        <template slot-scope="scope"> 
							  {{scope.row.insInspectionDetail.goodsVolume}}
							</el-input>
							</template>
					      </el-table-column>
					        <el-table-column
					        :show-overflow-tooltip="true"
					          width="120"
					         label="制造商"> 
					          <template slot-scope="scope">
					          <span v-if="scope.row.dictMallMnfct !=null">{{scope.row.dictMallMnfct.mnfctName}}</span>
					       </template>
					      </el-table-column>
					       
					       <el-table-column
					        width="180"
					        label="计算方式">
					        <template slot-scope="scope">
					        {{scope.row.insInspectionDetail.calcMethod}}
							</template>
					      </el-table-column>
					      <el-table-column
					         width="120"
					        label="等级">
					        <template slot-scope="scope"> 
							{{scope.row.insInspectionDetail.grade}}
							</template>
					      </el-table-column>
					      <el-table-column
					        width="120"
					        label="数量">
					        <template slot-scope="scope"> 
					        <span v-if="scope.row.insInspectionDetail.amount !=null">{{scope.row.insInspectionDetail.amount}}{{scope.row.baseProduct.quantityUnit}}</span>
							</template>
					      </el-table-column>
					      <el-table-column
					         width="120"
					       label="重量">
					        <template slot-scope="scope"> 
					        <span v-if="scope.row.insInspectionDetail.netWeight !=null">{{util.formatNumber((scope.row.insInspectionDetail.netWeight / scope.row.baseProduct.unitRate), scope.row.baseProduct.precision) }}{{scope.row.baseProduct.weightUnit}}</span>
							</template>
					      </el-table-column>
					      <el-table-column
					         width="200"
					        label="合同单价">
					        <template slot-scope="scope"> 
					        <el-input-number size="small" v-model="scope.row.insInspectionDetail.contractUnitPrice" controls-position="right" :min="0" ></el-input-number>
							元/{{scope.row.baseProduct.weightUnit}}
							</template>
					      </el-table-column>
					      <el-table-column
					          width="200"
					        label="合同金额">
					        <template slot-scope="scope"> 
					        <el-input-number size="small" v-model="scope.row.insInspectionDetail.contractMoney" controls-position="right" :min="0" ></el-input-number>
							元/{{scope.row.baseProduct.weightUnit}}
							</template>
					      </el-table-column>
					       <el-table-column
					          width="200"
					        label="实际单价">
					        <template slot-scope="scope"> 
					        <el-input-number size="small" v-model="scope.row.insInspectionDetail.realUnitPrice" controls-position="right" :min="0"  @blur="chandge(scope.row)"></el-input-number>
					       	元/{{scope.row.baseProduct.weightUnit}}
							</template>
					      </el-table-column>
					      <el-table-column
					          width="200"
					        label="实际金额">
					        <template slot-scope="scope"> 
					        <el-input-number size="small" v-model="scope.row.insInspectionDetail.realMoney" controls-position="right" :min="0" ></el-input-number>
							元/{{scope.row.baseProduct.weightUnit}}
							</template>
					      </el-table-column>
					      <el-table-column
					          width="150"
					        label="升贴水(元)">
					        <template slot-scope="scope"> 
					        <el-input-number size="small" v-model="scope.row.insInspectionDetail.floatPrice" controls-position="right" :min="0" ></el-input-number>
					         
							</template>
					      </el-table-column>
					      <el-table-column
					          width="150"
					        label="基价(元)">
					        <template slot-scope="scope"> 
					          <el-input-number size="small" v-model="scope.row.insInspectionDetail.basicPrice" controls-position="right" :min="0" ></el-input-number>
					        
							</template>
					      </el-table-column>
					     
					      <el-table-column
					        width="150"
					        label="商城价(元)">
					        <template slot-scope="scope"> 
					        <el-input-number size="small" v-model="scope.row.insInspectionDetail.storePrice" controls-position="right" :min="0" ></el-input-number>
					       
							</template>
					      </el-table-column>
					      <el-table-column
					      	v-if="false"
					        width="150"
					        label="手续费">
					        <template slot-scope="scope"> 
					        <el-input-number size="small" v-model="scope.row.insInspectionDetail.serviceFee" controls-position="right" :min="0" ></el-input-number>
							</template>
					      </el-table-column>
					       <el-table-column
					       	v-if="false"
					          width="150"
					        label="开票费">
					        <template slot-scope="scope"> 
					         <el-input-number size="small" v-model="scope.row.insInspectionDetail.invoiceFee" controls-position="right" :min="0" ></el-input-number>
							</template>
					      </el-table-column>
						  <el-table-column
					        width="180"
					      	label="货物照片">
							<template slot-scope="scope">
							</template>
					      </el-table-column>
					       <el-table-column
					          width="120"
					        label="备注">
					        <template slot-scope="scope"> 
					        {{scope.row.insInspectionDetail.notes}}
							</template>
					      </el-table-column>
					    </component-table>
					  </template>
			</div>
		</form>
		</div>`
})




