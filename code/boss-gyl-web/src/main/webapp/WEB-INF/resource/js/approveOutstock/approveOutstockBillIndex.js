/**
 * 出库设置
 * @author 倪凯
 * @since 2017.12.13
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	// VUE初始化页面
	// 侧边详情Vue组件
	var detail = null;
	var outstockVue = null;
	var newVueEdit = null;
	var EditOutInfoVue = null;
	var tableContent = null;
	// 主页面Vue组件
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					outstockStateForApprove:'1',
					businessType: 'A',
					outstockCode: '',
					DictMallDepot: '',
					customerId: '',
					startCreateDate: '',
					endCreateDate: '',
					consignee : ''
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
				GoodsSource: {},
				InOrNotStock:{},
				crmClients:{},
				BusinessType: {}
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
				ajax.post('/outstockBill/findPage', vm.searchParam).then(function (res) {
					vm.tableData = res.data
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
			},
			getBusinessType (options) {
				if (options) {
					for (option of options) {
						this.options.BusinessType[option.value] = option.label
					}
				}
			}
		},
		mounted () {
			var vm = this
			util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start', '.daterange-end'],  // 绑定Input选择器
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
		ajax.exportExcel('/outstockBill', page.searchParam)
	})
	
	/**
	 * 新增或编辑品名
	 * 
	 * @param type
	 *            操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			id: 'outstockDialog',
			width: 1230,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建提货单' : '编辑提货单',
			content: `
				<form id="outstockDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">客户</label>
								<div class="ui-col-60">
								 	<component-select v-model="AddOrEdit.entity.customerId" type="crmClients" :search="true" :remoteseach="true" name="customerId">
                                 	</component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">存放仓库</label>
								<div class="ui-col-60">
									<component-select v-model="AddOrEdit.entity.storageId" type="DictMallDepot" :search="false" name="storageId" depot="real">
                                    </component-select>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">提货人</label>
								<div class="ui-col-60">
									<input type="text" v-model="AddOrEdit.entity.consignee" class="ui-input-control" name="consignee" placeholder="" disabled>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">提货人身份证号</label>
								<div class="ui-col-60">
									<input type="text" v-model="AddOrEdit.entity.consigneeIdNo" class="ui-input-control" name="consigneeIdNo" placeholder="" disabled>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">车牌号</label>
								<div class="ui-col-60">
									<input type="text" v-model="AddOrEdit.entity.carNumber" class="ui-input-control" name="carNumber" placeholder="" disabled>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">提货人电话</label>
								<div class="ui-col-60">
									<input type="text" v-model="AddOrEdit.entity.consigneeTel" class="ui-input-control" name="consigneeTel" placeholder="" disabled>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-100">
								<label class="ui-label-control ui-col-10">备注</label>
								<div class="ui-col-90">
									<textarea class="ui-input-control ui-height-auto sele-info-txt"
										rows="2" name="notes"></textarea>
								</div>
							</div>
						</div>
					</div>
					<h5 class="bg-tit">
						<span>货物明细</span>
						<input  type="button"
							@click="selectGoods"
							style="background-color:#5CB85C;color:#fff"
							class="ui-btn pull-right btn_new_line"
							value="选择货物"/>
						<input type="text" style="width:0;height:0;visibility:hidden" v-model="AddOrEdit.tableData" name="goods">
					</h5>
					<div class="ui-row">
						<div class="ui-col">
							  <component-table 
							  	:max-height="500"
							  	:data="AddOrEdit.tableData">
									${detailHTMLView}
							  </component-table>
						</div>
					</div>
					
					<div v-if="false" class="ui-row" style="margin-top: 10px">
						<div class="ui-col">
							 <div class="ui-form-group ui-col-50 pull-right">
								<label class="ui-label-control ui-col-15 pull-right" style="margin-left:-30px;">吨</label>
								<div class="ui-col-25 pull-right" style="margin-right:38px;">
									<input type="text" class="ui-input-control" v-model="AddOrEdit.entity.totalWeight" name="totalWeight" style="width:80%" disabled>
								</div>
								<label class="ui-label-control ui-col-20 pull-right">货物总重</label>
							</div>
						</div>
					</div>
				</form>
				`,
				okValue: type === 0 ? '保存': '更新',
				ok: function () {
					let entity = outstockVue.AddOrEdit.entity
					let detail = outstockVue.AddOrEdit.tableData
					for(var i=0;i<detail.length;i++){
						detail[i].netWeight = detail[i].redWeight
					}
					if ($('#outstockDialog').valid()) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						if (type === 0) {
							var vo = {
								entity: entity,
								detail: detail
							}
							ajax.save('/outstockBill', vo).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'outstockDialog'})
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
						} else {
							var newValue = $.extend({outstockBillId: data.outstockBillId}, $('#outstockDialog').serializeObject())
							ajax.update('/outstockBill', newValue).then(function (result) {
								util.promptMsg({
									content: result.message
								})
								util.dialog({getIdClose: 'outstockDialog'})
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
					}
					return false
				},
				cancelValue: '取消',
				onshow: function () {
					// 添加表单验证
					outstockaddValid()
					outstockVue = new Vue({
						el:"#outstockDialog",
						data: {
							util: util,
							AddOrEdit:{
								tableData: [],
								finance:{},
								entity:{
									outstockCode:'',
									businessType:'',
									customerId:'',
									storageId:'',
									totalWeight:'',
									consigneeIdNo:'',
									consignee:'',
									consigneeTel:'',
								}
					        }
						},
						mounted () {
							// 添加表单验证
							this.$nextTick(function() {
								outstockaddValid()
							})
						},
						methods: {
							selectGoods(){
								var vm = this
								//:disabled="AddOrEdit.entity.customerId === '' || AddOrEdit.entity.storageId === ''"
								if(vm.AddOrEdit.entity.customerId==='' || vm.AddOrEdit.entity.storageId===''){
									//alert("请选择客户和存放仓库")
									util.promptMsg({
										content: "请选择客户和存放仓库"
									})
								}else{
									selectGoods(vm.AddOrEdit.entity.customerId,vm.AddOrEdit.entity.storageId)
									//selectGoods('41ebc43438722f50d61713fcdf9a09b9','c44646d1cdbf7071228165bee69bdad8')
								}
							}
								
					   },
					   components: {
						   componentTable: componentTable
					   }
					})
				}
		})
	}

	
/**********************************新建-----选择货物*****************************************/
	
	/**
	 * 选择货物
	 */
	function selectGoods (customerId,storageId) {
		util.dialog({
			width: 1000,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '选择货物',
			content: `
			<div id="selectgoods">
				<div class="ui-row">	
					<div class="ui-col"> `
						+/*<div class="ui-form-group ui-col-25">
							<label class="ui-label-control ui-col ui-col-25">表面:</label>
							<div class="ui-col ui-col-70 ui-label-txt">
								 <component-select type="baseProcess" :search="true" :remoteseach="true" >
                                 </component-select>
							</div>
						</div>
						<div class="ui-form-group ui-col-25">
							<label class="ui-label-control ui-col ui-col-25">品类:</label>
							<div class="ui-col ui-col-70 ui-label-txt">
								 <component-select type="baseProduct" :search="true" :remoteseach="true" >
                                 </component-select>
							</div>
						</div> 
						<div class="ui-form-group ui-col-25">
							<label class="ui-label-control ui-col ui-col-25">材质:</label>
							<div class="ui-col ui-col-70 ui-label-txt">
								 <component-select type="DictMallSpec" :search="true" :remoteseach="true" >
                                 </component-select>
							</div>
						</div>
						<div class="ui-form-group ui-col-25">
							<label class="ui-label-control ui-col ui-col-25">厂商:</label>
							<div class="ui-col ui-col-70 ui-label-txt">
								 <component-select type="mallMnfcts" :search="true" :remoteseach="true" >
                                 </component-select>
							</div>
						</div>*/  `
					</div>
				</div>
				<div class="ui-col slide-overflow">
					<div class="main-cnt-scroll">
						<component-table :data="tableData"
							:max-height="500"
							row-key="redeemDetailId"
							:select-data="selectData"
							:columns="tableConfig.columns"
							:selectable="selectable"
							@selection-change="handleSelectionChange">
							${detailHTMLViews}
						</component-table>
					</div>
				</div>
			</div>
			`,
			okValue: '确定',
			ok: function () {
				// list返回上一个对话框
				let all = outstockVue.AddOrEdit
				let entity = outstockVue.AddOrEdit.entity
				entity.storageName = newVueEdit.tableData[0].storageName
				//货物明细
				all.tableData = newVueEdit.selectData
				//总重
				var newWeight = 0
				for(var i=0;i<newVueEdit.selectData.length;i++){
					newWeight += newVueEdit.selectData[i].redWeight
				}
				all.entity.totalWeight = util.formatNumber(newWeight / 1000, 3)
				all.entity.carNumber = newVueEdit.selectData[0].carNumber
				all.entity.consignee = newVueEdit.selectData[0].consignee
				all.entity.consigneeIdNo = newVueEdit.selectData[0].consigneeIdNo
				all.entity.consigneeTel = newVueEdit.selectData[0].consigneeTel
			},
			cancelValue: '取消',
			onshow: function () {
//					if(newVueEdit == null){
				var firstTel = null
				newVueEdit = new Vue({
					el:"#selectgoods",
					data: {
						util: util,
						contractId:'',
						storageId:'',
						// 表格数据
						tableData: [],
						contract:{},
						finance:{},
						tableConfig: {
							loading: false,
							columns: ['selection']
						},
						selectData: [],
						selectable: (row, index) => {
							if (firstTel != null) {
								return row.consigneeTel === firstTel
							}
							return true
						}
					},
					watch: {
						'selectData': {
							handler: function (val) {
								if (val != null && val.length > 0) {
									firstTel = val[0].consigneeTel
								} else {
									firstTel = null
								}
							},
							deep: true
						}
					},
					methods: {
						handleSelectionChange (selectData) {
							this.selectData = selectData
						}
					},
					mounted(){
						/**
						 * 后台检索数据
						 */
						let vm = this
						vm.tableConfig.loading = true
						if(customerId != null && customerId != "" && storageId != null && storageId != ""){
							ajax.get('/outstockBill/getStorageList',{"buyerId":customerId,"storageId":storageId}).then(function (res2) {
								for(var i=0;i<res2.data.length;i++){
									vm.$set(vm.tableData, i, res2.data[i])
									vm.$set(vm.tableData[i], 'outOutstockDetail',res2.data[i].invInventory)
								}
								vm.tableConfig.loading = false
							}, function () {
								vm.tableConfig.loading = false
							})
						}
					},
					components: {
						componentTable: componentTable
					}
				})
			}
		})
	}

	
	/***************************侧边栏选择货物************************************************
	/**
	 * 选择货物
	 */
	function selectGoodss (customerId,storageId,outstockBillId) {
		util.dialog({
			width: 1000,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '选择货物',
			content: `
				<div id="selectgoods">
					<div class="ui-row">	
						<div class="ui-col"> `
							+/*<div class="ui-form-group ui-col-25">
								<label class="ui-label-control ui-col ui-col-25">表面:</label>
								<div class="ui-col ui-col-70 ui-label-txt">
									 <component-select type="baseProcess" :search="true" :remoteseach="true" >
	                                 </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-25">
								<label class="ui-label-control ui-col ui-col-25">品类:</label>
								<div class="ui-col ui-col-70 ui-label-txt">
									 <component-select type="baseProduct" :search="true" :remoteseach="true" >
	                                 </component-select>
								</div>
							</div> 
							<div class="ui-form-group ui-col-25">
								<label class="ui-label-control ui-col ui-col-25">材质:</label>
								<div class="ui-col ui-col-70 ui-label-txt">
									 <component-select type="DictMallSpec" :search="true" :remoteseach="true" >
	                                 </component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-25">
								<label class="ui-label-control ui-col ui-col-25">厂商:</label>
								<div class="ui-col ui-col-70 ui-label-txt">
									 <component-select type="mallMnfcts" :search="true" :remoteseach="true" >
	                                 </component-select>
								</div>
							</div>*/  `
						</div>
					</div>
					<div class="ui-col slide-overflow">
						<div class="main-cnt-scroll">
							<component-table :data="tableData"
								:max-height="500"
								:row-key="tableData.stats"
								:select-data="selectData"
								:columns="tableConfig.columns"
								@selection-change="handleSelectionChange">
								${detailHTMLViews}
							</component-table>
						</div>
					</div>
				</div>
				`,
				okValue: '确定',
				ok: function () {
					// list返回上一个对话框
//					for(var i=0;i<newVueEdit.selectData.length;i++){
//						detail.$set(detail.tabData[1], detail.tabData[1].length, newVueEdit.selectData[i])
//						newVueEdit.selectData[i].outOutstockDetail['outstockBillId'] = outstockBillId
//					}
//					ajax.update('/outstockDetails',newVueEdit.selectData).then((result) => {
//						util.promptMsg({
//							content: result.message
//						})
//						if (result.state === 1) {
//							page.fetchData()
//							detail.fetchData(1)
//						}
//					})
					for(var item of newVueEdit.selectData){
						var newItem = {
								baseProduct: item.baseProduct,
								outOutstockDetail: item
						}
						tableContent.tableData.push(newItem)
					}
				},
				cancelValue: '取消',
				onshow: function () {
					// 添加表单验证
					//baseProductValid()
					newVueEdit = new Vue({
						el:"#selectgoods",
						data: {
							util:util,
							contractId:'',
							storageId:'',
							// 表格数据
							tableData: [
							],
							tableConfig: {
								loading: false,
								columns: ['selection']
							},
							selectData: []
						},
						computed: {
						},
						mounted () {
							/**
							 * 后台检索数据
							 */
							let vm = this
							vm.tableConfig.loading = true
							if(customerId != null && customerId != "" && storageId != null && storageId != ""){
								ajax.get('/outstockBill/getStorageList',{"buyerId":customerId,"storageId":storageId}).then(function (res2) {
									for(var i=0;i<res2.data.length;i++){
										vm.$set(vm.tableData, i, res2.data[i])
										vm.$set(vm.tableData[i], 'outOutstockDetail',res2.data[i].invInventory)
										let detail = vm.tableData[i].outOutstockDetail;
									}
									vm.tableConfig.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
							}
						},
						methods: {
							handleSelectionChange (selectData) {
								this.selectData = selectData
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
			ajax.detail('/approveOutstock', {
				/*productId: data.productId*/
			}).then(function (result) {
				var result = $(result).find(".slide-cnt")
				$(slide).html(result)
				detail = new Vue({
					el: slide,
					data: {
						flow: null,
						util: util,
						outstockId:data.outOutstockBill.outstockBillId,
						contractId:data.outOutstockBill.contractId,
						// 选中行数据
						model: data,
						show: true,
						loading: false,
						activeIndex: 0,
						// 选项卡页面数据
						tabData: [],
						// 下拉选项列表
						options: {
							BusinessType: [],
							OutstockState:[],
							GoodsPaymentState:[],
							DepositState:[],
							inspectionState:[],
							ApprovalState:[]
						},
					},
					methods: {
//						selectGoodss(){
//							selectGoodss(data.outOutstockBill.customerId,data.outOutstockBill.storageId,data.outOutstockBill.outstockBillId)
//						},
						/**
						 * 新增或编辑货物明细
						 */
						add () {
							addOrEditOutDetailNew(0)
						},
						edit () {
							let vm = this
							addOrEditOutDetailNew(1,this.tabData[1],vm.model)
						},
						/**
						 * 获取对应索引的tab数据
						 */
						fetchData (index) {
							let vm = this
							if(index == 1){
								vm.loading = true
								ajax.get('/outstockDetail/findOne',{id:vm.model.outOutstockBill.outstockBillId}).then(function (res) {
									vm.tabData[index] = res.data
									vm.loading = false
								}, function () {
									vm.loading = false
								})
							}
//							if(index == 2){
//								vm.loading = true
//								ajax.get('/outstockBill/findApplyRemit',{id:vm.outstockId}).then(function (res) {
//									vm.tabData[index] = res.data
//									vm.loading = false
//								}, function () {
//									vm.loading = false
//								})
//							}
						}
					},
					computed: {
						goodsSourceMap () {
							var map = {}
							this.options.GoodsSource != null ? this.options.GoodsSource.forEach(function (item) {
								map[item[0]] = item[1]
							}) : null
							return map
						},
						businessTypeMap () {
							var map = {}
							this.options.BusinessType != null ? this.options.BusinessType.forEach(function (item) {
								map[item[0]] = item[1]
							}) : null
							return map
						},
						OutstockStateMap () {
							var map = {}
							this.options.OutstockState != null ? this.options.OutstockState.forEach(function (item) {
								map[item[0]] = item[1]
							}) : null
							return map
						},
						GoodsPaymentStateMap () {
							var map = {}
							this.options.GoodsPaymentState != null ? this.options.GoodsPaymentState.forEach(function (item) {
								map[item[0]] = item[1]
							}) : null
							return map
						},
						DepositStateMap () {
							var map = {}
							this.options.DepositState != null ? this.options.DepositState.forEach(function (item) {
								map[item[0]] = item[1]
							}) : null
							return map
						},
						InspectionStateMap () {
							var map = {}
							this.options.InspectionState != null ? this.options.InspectionState.forEach(function (item) {
								map[item[0]] = item[1]
							}) : null
							return map
						},
						ApprovalStateMap () {
							var map = {}
							this.options.ApprovalState != null ? this.options.ApprovalState.forEach(function (item) {
								map[item[0]] = item[1]
							}) : null
							return map
						}
					},
					mounted () {
						var vm = this
						 ajax.getOptions(['ApprovalState','OutstockState', 'BusinessType','GoodsPaymentState','DepositState','inspectionState']).then((result) => {
					    	vm.options = result.data
					    })
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
	
	/** ************************ 新增或编辑货物明细**************************************** */
	/**
	 * 新增或编辑货物明细
	 * 
	 * @param type
	 *            操作类型（0:新增|1:编辑）
	 */
	function addOrEditOutDetailNew (type,data,find) {
		util.dialog({
			id: 'outstockBillSlideDialog',
			width: 1200,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新增货物明细' : '编辑货物明细',
			content: `
				<div class="dialog_open">
				<h5 class="bg-tit">
				<input type="button" @click="selectGoodss" style="background-color:#5CB85C;color:#fff" class="ui-btn pull-right btn_new_line" value="选择货物" />
				</h5>
				<el-table
				:height="280"
				:data="tableData">
					${detailHTMLViewss}
				</el-table>	
				`,
				okValue: '确定',
				ok: function () {
					if (type === 0) {
						detail.tabData[1].push(tableContent.tableData)
					} else {
						var outId
						if(tableContent.tableData){
							//outId = tableContent.tableData[0].outOutstockDetail.outstockBillId
							outId = find.outOutstockBill.outstockBillId
						}
						detail.tabData[1] = []
						for(item of tableContent.tableData){
							tableContent.$set(item.outOutstockDetail,'outstockBillId',outId)
							detail.tabData[1].push(item)
						}
						
						
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						ajax.update('/outstockDetail',tableContent.tableData).then(function (result) {
							util.dialog({getIdClose: 'outstockBillSlideDialog'})
							if (result.state === 1) {
								page.fetchData()
								detail.fetchData(1)
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
					if (true) {
				      tableContent =  new Vue({
				    	el:".dialog_open",
				    	data () {
							return {
								util: util,
								AddOrEdit:{
								},
								type: type,
								tableData: [],
								selectData: {
									// 计算方式
									calcMethods:[
										"理算",
										"磅重"
									]
								}
								
							}
				    	},
				    	methods: {
							selectGoodss(){
								selectGoodss(find.outOutstockBill.customerId,find.outOutstockBill.storageId,find.outOutstockBill.outstockBillId)
								//selectGoodss('41ebc43438722f50d61713fcdf9a09b9','c44646d1cdbf7071228165bee69bdad8',data[0].outOutstockDetail.outstockBillId)
							}
					    },
						mounted () {
							if (this.type === 1) {
								this.tableData = $.extend(true, [], data)
							}
						}
					})
				 }
				}
				
		})
	}
	
	/** ************************侧滑栏------编辑基本信息**************************************** */
	/**
	 * 编辑基本信息
	 */
	function EditOutInfo(data){
		util.dialog({
			id: 'outstockBillEdit',
			width: 800,
			height: 400,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: '编辑主单',
			content: `         				
				<form id="OutInfoEdit">
					<div class="ui-row">		
						<div class="ui-col">
					 		<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-30">提货单号</label>
								<div class="ui-col ui-col-60 ui-label-txt">
									<input class="ui-input-control" v-model="outstockBillSingle.outOutstockBill.outstockCode" disabled>
								</div>
							</div>
						</div>
						<div class="ui-col">
						 	<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-30">客户信息</label>
								<div class="ui-col ui-col-60 ui-label-txt">
									<input class="ui-input-control" v-model="outstockBillSingle.clientName" disabled>
								</div>
							</div>
						 	<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-30">存放仓库</label>
								<div class="ui-col ui-col-60 ui-label-txt">
									<input class="ui-input-control" v-model="outstockBillSingle.storageName" disabled>
								</div>
							</div> 
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-30">提货人</label>
								<div class="ui-col ui-col-60 ui-label-txt">
								 	<component-select v-model="outstockBillSingle.outOutstockBill.consignee" type="crmClients" :search="true" :remoteseach="true" >
                                 	</component-select>
								</div>
							</div>
							 <div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-30">提货人电话</label>
								<div class="ui-col ui-col-60 ui-label-txt">
									<input class="ui-input-control" v-model="outstockBillSingle.outOutstockBill.consigneeTel">
								</div>
							</div> 
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-30">提货人身份证号</label>
								<div class="ui-col ui-col-60 ui-label-txt">
									<input class="ui-input-control" v-model="outstockBillSingle.outOutstockBill.consigneeIdNo">
								</div>
							</div> 
						 	<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-30">创建人</label>
								<div class="ui-col ui-col-60 ui-label-txt">
									<input class="ui-input-control" v-model="outstockBillSingle.outOutstockBill.createUser" disabled>
								</div>
							</div> 
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-30">创建时间</label>
								<div class="ui-col ui-col-60 ui-label-txt">
									<input class="ui-input-control" v-model="outstockBillSingle.outOutstockBill.createDate" disabled>
								</div>
							</div>
						</div>
					</div>
				</form>`,
				okValue: '确定',
				ok: function () {
					EditOutInfoVue.update()
				},
				cancelValue: '取消',
				onshow: function () {
					// 添加表单验证
					// EditSubAValid()
					EditOutInfoVue = new Vue({
						el:"#OutInfoEdit",
						data: {
							util: util,
							outstockBillSingle: $.extend(true, {}, data),
					        options: {
					        	businessType: [],
								GoodsSource: [],
								InOrNotStock:[],
								ApprovalState:[]
							}	
						},
						computed: {
							businessTypeMap () {
								var map = {}
								this.options.businessType.forEach(function (item) {
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
						},
						mounted () {
							let vm = this
							ajax.getOptions(['BusinessType,GoodsSource','InOrNotStock','ApprovalState']).then((result) => {
						    	vm.options = result.data
						    })
							this.$nextTick(function() {
								// contractValid()
							})
						},
						methods: {
							 update () {
						 		let vm = this
								  ajax.update('/outstockBill',this.outstockBillSingle.outOutstockBill).then(function (result) {
									  util.promptMsg({
											content: result.message
									  })
									  page.fetchData()
									  detail.model.outOutstockBill = result.data
								  })
								  return false
							  }
					   }
					})
				}
		})
	}
	
	/*********************************定义变量 展示-----html************************/
	var detailHTMLViews=`

		<el-table-column label="品类" width="120">
			<template slot-scope="scope">
				<span v-if="scope.row.baseProduct !=null">{{scope.row.baseProduct.productName}}</span>
       		</template>
		</el-table-column>
		<el-table-column label="数量" width="160">
			<template slot-scope="scope">
				{{scope.row.amount}}&nbsp;<span v-if="scope.row.baseProduct !=null">{{scope.row.baseProduct.quantityUnit}}</span>
			</template>
		</el-table-column>
		<el-table-column label="重量" width="100">
			<template slot-scope="scope">
				<template v-if="scope.row.baseProduct != null && scope.row.netWeight != null">
					{{util.formatNumber(scope.row.redWeight / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}} {{scope.row.baseProduct.weightUnit}}
				</template>
			</template>
		</el-table-column>
		<el-table-column label="材质（钢种）" width="150">
				<template slot-scope="scope">
					{{scope.row.materialId}}
				</template>
		</el-table-column>
		<el-table-column label="表面" width="120">
				<template slot-scope="scope">
					{{scope.row.surfaceId}}
				</template>
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
		<el-table-column label="边部" width="120">
			<template slot-scope="scope">
				{{scope.row.edge}}
			</template>
		</el-table-column>
		<el-table-column label="参厚" width="180">
			<template slot-scope="scope">
				{{scope.row.referThick}}
			</template>
		</el-table-column>
		<el-table-column label="牌号" width="180">
			<template slot-scope="scope">
				{{scope.row.trademark}}
			</template>
		</el-table-column>
		<el-table-column label="卷号" width="180">
			<template slot-scope="scope">
				{{scope.row.goodsVolume}}
			</template>
		</el-table-column>
		<el-table-column label="厂家" width="180" show-overflow-tooltip>
			<template slot-scope="scope">
				{{scope.row.mnfctId}}
			</template>
		</el-table-column>
		<el-table-column label="等级" width="100">
			<template slot-scope="scope">
				{{scope.row.grade}}
			</template>
		</el-table-column>
		<el-table-column label="提货人" width="100" show-overflow-tooltip>
			<template slot-scope="scope">
				{{scope.row.consignee}}
			</template>
		</el-table-column>
		<el-table-column label="提货人身份证号" width="180" show-overflow-tooltip>
			<template slot-scope="scope">
				{{scope.row.consigneeIdNo}}
			</template>
		</el-table-column>
		<el-table-column label="车牌号" width="100" show-overflow-tooltip>
			<template slot-scope="scope">
				{{scope.row.carNumber}}
			</template>
		</el-table-column>
		<el-table-column label="提货人电话" width="180" show-overflow-tooltip>
			<template slot-scope="scope">
				{{scope.row.consigneeTel}}
			</template>
		</el-table-column>`
	
	/*********************************定义变量 展示-----html************************/
	var detailHTMLView=`	

		<el-table-column label="品类" width="120" show-overflow-tooltip>
				<template slot-scope="scope">
					<span v-if="scope.row.baseProduct !=null">{{scope.row.baseProduct.productName}}</span>
	       		</template>
		</el-table-column>
		<el-table-column label="数量" width="160">
			<template slot-scope="scope">
				{{scope.row.amount}}&nbsp;<span v-if="scope.row.baseProduct !=null">{{scope.row.baseProduct.quantityUnit}}</span>
			</template>
		</el-table-column>
		<el-table-column label="重量" width="100">
			<template slot-scope="scope">
				<template v-if="scope.row.baseProduct != null && scope.row.netWeight != null">
					{{util.formatNumber(scope.row.redWeight / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}}{{scope.row.baseProduct.weightUnit}}
				</template>
			</template>
		</el-table-column>
		<el-table-column label="材质（钢种）" width="150">
				<template slot-scope="scope">
					{{scope.row.materialId}}
				</template>
		</el-table-column>
		<el-table-column label="表面" width="120">
				<template slot-scope="scope">
					{{scope.row.surfaceId}}
				</template>
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
		<el-table-column label="边部" width="120">
			<template slot-scope="scope">
				{{scope.row.edge}}
         		</component-select>
			</template>
		</el-table-column>
		<el-table-column label="参厚" width="180">
			<template slot-scope="scope">
				{{scope.row.referThick}}
			</template>
		</el-table-column>
		<el-table-column label="牌号" width="180" >
			<template slot-scope="scope">
				{{scope.row.trademark}}
			</template>
		</el-table-column>
		<el-table-column label="卷号" width="180">
			<template slot-scope="scope">
				{{scope.row.goodsVolume}}
			</template>
		</el-table-column>
		<el-table-column label="厂家" width="180" show-overflow-tooltip>
			<template slot-scope="scope">
				{{scope.row.mnfctId}}
			</template>
		</el-table-column>
		<el-table-column label="等级" width="100">
			<template slot-scope="scope">
				{{scope.row.grade}}
			</template>
		</el-table-column>`
		
		/*********************************定义变量 展示-----html************************/
		var detailHTMLViewss=`

			<el-table-column label="品类" width="120">
					<template slot-scope="scope">
						<span v-if="scope.row.baseProduct !=null">{{scope.row.baseProduct.productName}}</span>
		       		</template>
			</el-table-column>
			<el-table-column label="数量" width="160">
				<template slot-scope="scope">
					{{scope.row.outOutstockDetail.amount}}&nbsp;<span v-if="scope.row.baseProduct !=null">{{scope.row.baseProduct.quantityUnit}}</span>
				</template>
			</el-table-column>
			<el-table-column label="重量" width="100">
				<template slot-scope="scope">
				<template v-if="scope.row.baseProduct != null && scope.row.outOutstockDetail.netWeight != null">
					{{util.formatNumber(scope.row.outOutstockDetail.netWeight / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}}{{scope.row.baseProduct.weightUnit}}
				</template>
				</template>
			</el-table-column>
			<el-table-column label="材质（钢种）" width="150">
					<template slot-scope="scope">
						{{scope.row.outOutstockDetail.materialId}}
					</template>
			</el-table-column>
			<el-table-column label="表面" width="120">
					<template slot-scope="scope">
						{{scope.row.outOutstockDetail.surfaceId}}
					</template>
			</el-table-column>
			<el-table-column label="规格(mm)" width="180">
				<template slot-scope="scope">
					<template v-if="scope.row.outOutstockDetail !=null">
						{{scope.row.outOutstockDetail.labelThick}}
						&nbsp;*
						{{scope.row.outOutstockDetail.labelWidth}}
						&nbsp;*
						{{scope.row.outOutstockDetail.goodsLength}}
					</template>
				</template>
			</el-table-column>
			<el-table-column label="边部" width="120">
				<template slot-scope="scope">
					{{scope.row.outOutstockDetail.edge}}
             		</component-select>
				</template>
			</el-table-column>
			<el-table-column label="参厚" width="180">
				<template slot-scope="scope">
					{{scope.row.outOutstockDetail.referThick}}
				</template>
			</el-table-column>
			<el-table-column label="牌号" width="180">
				<template slot-scope="scope">
					{{scope.row.outOutstockDetail.trademark}}
				</template>
			</el-table-column>
			<el-table-column label="卷号" width="180">
				<template slot-scope="scope">
					{{scope.row.outOutstockDetail.goodsVolume}}
				</template>
			</el-table-column>
			<el-table-column label="厂家" width="180" show-overflow-tooltip>
				<template slot-scope="scope">
					{{scope.row.outOutstockDetail.mnfctId}}
				</template>
			</el-table-column>
			<el-table-column label="等级" width="100">
				<template slot-scope="scope">
					{{scope.row.outOutstockDetail.grade}}
				</template>
			</el-table-column>`
		
	
	/**
	 * 侧边栏切换事件
	 * @param event
	 * @returns
	 
	function toggleSlideFun(event) {
		if($(event.target).closest(".component-table").length == 0){
			detail.show = false
			event.stopPropagation();
		}
	}*/
		
	// ---------------
	// 品类 - 表单验证
	// ---------------
	function outstockaddValid () {
		util.formValid({
			selector: '#outstockDialog',
			onkeyup: false,
			rules: {
				'customerId': {
					required: true
				},
				'storageId': {
					required: true
				},
				'consignee': {
					required: true
				},
				'consigneeIdNo': {
					required: true,
					minlength: 18,
					maxlength: 18
				},
				'carNumber': {
					required: true
				},
				'consigneeTel': {
					required: true,  
					minlength: 11,
					maxlength: 11
				},
				'goods': {
					required: true
				}
			},
			messages: {
				'customerId': {
					required: '请选择客户'
				},
				'storageId': {
					required: '请选择存放仓库'
				},
				'consignee': {
					required: '请输选择提货人'
				},
				'consigneeIdNo': {
					required: '请输入提货人身份证号',  
		            minlength : "确认身份证为18个字符",  
		            maxlength : "确认身份证为18个字符"
				},
				'carNumber': {
					required: '请输入车牌号'
				},
				'consigneeTel': {
					required: '请输入提货人电话',  
		            minlength : "确认手机为11个字符",  
		            maxlength : "确认手机为11个字符"
				},
				'goods': {
					required: '请选择货物'
				}
			}
		})
	}
})




