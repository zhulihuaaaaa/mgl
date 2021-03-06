/**
 * 发票管理
 */
require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	// VUE初始化页面
	var detail = null;
	// 新建弹窗组件
	var addOrEdit
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					contractId:null,
					createUser:null,
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
				ajax.findPage('/contractBalance', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
			},
			detail (row) {
			}
		},
		mounted () {
			let vm = this
			util.datePicker({
				 dateRange: true,
				  selector: ['.daterange-start', '.daterange-end'] //绑定Input选择器
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
		addOrEdit(0)
	})
	
	$(".btn-out-add").click(function () {
		addOrEdit(1)
	})
	
	$(".btn-export").click(function () {
		ajax.exportExcel('/contractBalance', page.searchParam)
	})
	
	/**
	 * 新增|编辑进项发票
	 * @param type 操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
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
										<label class="ui-label-control ui-col-30">发票照片</label>
										<div class="ui-col-60">
											<component-upload @success="handleSuccess" ref="attach" :auto-upload="true" :accept="accept" :multiple="true" @change="change" :uploading.sync="uploading"></component-upload>
										</div>
									</div>
								</div>
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
				                </component-table>
				            </div>
							<div class="ui-row  pull-right" style="margin-top: 10px">
								<div class="ui-form-group ui-col" style="width:450px">
									<div class="ui-form-group ui-col-40">
										<label class="ui-label-control ui-col-40">发票金额</label>
										<label class="ui-label-control ui-col-60">0元</label>
									</div>
								</div>
							</div>
						</div>
					</template>
				</form>
				`,
				okValue: '确定',
				ok: function () {
					addOrEdit.invoice
				},
				cancelValue: '取消',
				onshow: function () {
					addOrEdit = new Vue({
						el: '#dialog-content',
						data () {
							return {
								page: page,
								type: type,
								// 允许上传文件的类型
								accept: 'image/jpeg,image/jpg,image/png,image/gif',
								invoiceMoney: 0,
								uploadImgCount: 0,
								uploadImgTotal:0,
								uploading: false,
								invoice: {
									entity: {
										invoiceType: '',
										invoiceNo: '',
										billingDate:'',
										checkingDate:''
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
					
							selectGoods(){
								var vm = this
									selectGoods()
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
				      <div class="ui-form-group ui-col-30">
				        <label class="ui-label-control ui-col ui-col-25">仓库</label>
				        <div class="ui-col ui-col-70 ui-label-txt">
				          <component-select v-model="searchParam.storageId" @change="fetchData" type="DictMallDepot" 
				            name="dictMallDepotId">
				          </component-select>
				        </div>
				      </div>
				       <div class="ui-form-group ui-col-30">
				        <label class="ui-label-control ui-col ui-col-25">厂家</label>
				        <div class="ui-col ui-col-70 ui-label-txt">
				          <component-select v-model="searchParam.mallMnfcts" @change="fetchData" type="mallMnfcts" 
				            name="dictMallDepotId">
				          </component-select>
				        </div>
				      </div>
				      <div class="ui-form-group ui-col-30">
				        <label class="ui-label-control ui-col ui-col-25">材质</label>
				        <div class="ui-col ui-col-70 ui-label-txt">
				          <component-select v-model="searchParam.DictMallSpec" @change="fetchData" type="DictMallSpec" 
				            name="dictMallDepotId">
				          </component-select>
				        </div>
				      </div>
				    </div>
				    <div class="ui-col">
				      <div class="ui-form-group ui-col-30">
				        <label class="ui-label-control ui-col ui-col-25">表面</label>
				        <div class="ui-col ui-col-70 ui-label-txt">
				          <component-select v-model="searchParam.baseProcess" @change="fetchData" type="baseProcess" 
				            name="dictMallDepotId">
				          </component-select>
				        </div>
				      </div>
				      <div class="ui-form-group ui-col-30">
				        <label class="ui-label-control ui-col ui-col-25">卷号</label>
				        <div class="ui-col ui-col-70 ui-label-txt">
				          <div class="ui-col col-160">
							<input type="text" class="ui-input-control" placeholder="请输入卷号">
						  </div>
				        </div>
				      </div>
				      <div class="ui-form-group ui-col-30">
				        <label class="ui-label-control ui-col ui-col-25">品名</label>
				         <div class="ui-col ui-col-70 ui-label-txt">
				          <div class="ui-col col-160">
							<input type="text" class="ui-input-control" placeholder="请输入品名">
						  </div>
				        </div>
				      </div>
				      
				    </div>
				  </div>
				  <div class="ui-col">
				    <div class="main-cnt-scroll">
				      <component-table :data="tableData" :height="400" row-key="id" :select-data="selectData" :columns="tableConfig.columns"
				        :loading="tableConfig.loading" :pagination="true" @selection-change="handleSelectionChange" :selectable="selectable">
				       ${detailHTMLView}
				      </component-table>
				    </div>
				  </div>
				</div>
				`,
				okValue: '确定',
				ok: function () {
					let all = addOrEdit.AddOrEdit
					console.log(all);
					//货物明细
					all.tableData = addOrEdit.selectData
				},
				cancelValue: '取消',
				onshow: function () {
					var tableData = addOrEdit._data
					var selectData = []
//					if (tableData != null && tableData.length > 0) {
//						tableData.forEach(function (item) {
//							selectData.push({inventoryId: item.inventoryId})
//						})
//					}
					selectGoodsVue = new Vue({
						el:"#selectgoods",
						data: {
							util: util,
							searchParam: {
								dto: {
									storageId:null,
									mallMnfcts:null
								},
								// 页码
								pageNum: 0,	
								// 分页大小
								pageSize: 20,
								// 排序
								orderByClause: ''
							},
							// 表格数据
							tableData: [],
							tableConfig: {
								loading: false,
								columns: ['index','selection']
							},
							selectData: $.extend([], selectData)
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
							handleSelectionChange (selectData) {
								this.selectData = selectData
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

	
	/*********************************定义变量 展示-----html************************/
	var detailHTMLView=`
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
					{{util.formatNumber(scope.row.netWeight / scope.row.product.unitRate, scope.row.product.precision)}} {{scope.row.product.weightUnit}}
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
		<template slot-scope="scope">
				<span>{{scope.row.mnfct.mnfctName}}</span>
       		</template>
		</el-table-column>
		<el-table-column label="等级" width="100" prop="grade">
		</el-table-column>
		`
})




