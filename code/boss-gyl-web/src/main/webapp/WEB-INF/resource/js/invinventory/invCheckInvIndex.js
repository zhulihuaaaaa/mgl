/**
 * 库存盘点
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	// VUE初始化页面
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
					storageId: '',
					createUser: '',
					startCreateDate: '',
					endCreateDate: ''
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
				ajax.post('/checkInv/findPage', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					console.log(res.data);
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
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
	
	$(".btn-add").click(function () {
		addOrEdit(0)
	})
	
	/**
	 * 新增或编辑库存盘点
	 * @param type
	 * 操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			id: 'checkInvDialog',
			width: 1230,
			height: 500,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建库存盘点' : '编辑库存盘点',
			content: `
				<form id="outstockDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">存放仓库</label>
								<div class="ui-col-60">
									<component-select v-model="AddOrEdit.storageId" @change="checkInvs()" type="DictMallDepot" :search="false" name="storageId" depot="real">
                                    </component-select>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">备注</label>
								<div class="ui-col-70">
									<textarea class="ui-input-control ui-height-auto sele-info-txt"
										rows="2" name="note" v-model="AddOrEdit.note"></textarea>
								</div>
							</div>
						</div>
					</div>
					<h5 class="bg-tit">
						<span>货物明细</span>
						<input type="text" style="width:0;height:0;visibility:hidden" v-model="AddOrEdit.detail" name="goods">
					</h5>
					<div class="ui-row">
						<div class="ui-col">
							  <component-table 
							  	:max-height="300"
							  	row-key="inventoryId"
							  	:data="tableData"
							  	:pagination="true"
							  	:loading="tableConfig.loading"
							  	@fetch-data="checkInvs">
									${goodsHTML}
							  </component-table>
						</div>
					</div>
				</form>
				`,
				okValue: type === 0 ? '保存': '更新',
				ok: function () {
					if (outstockVue.AddOrEdit.storageId != null
							&& outstockVue.AddOrEdit.storageId !== ''
							&& (outstockVue.AddOrEdit.note != null && outstockVue.AddOrEdit.note !== '')) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						ajax.save('/checkInv', outstockVue.AddOrEdit).then(function (result) {
							util.dialog({getIdClose: 'checkInvDialog'})
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
					}else{
						util.promptMsg({
							content: "请填写备注"
						})
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
							// 搜索条件
							searchParam: {
								dto: {
									storageId: null
								},
								// 页码
								pageNum: 0,
								// 分页大小
								pageSize: 20,
								// 排序
								orderByClause: ''
							},
							util: util,
							tableData: {},
							tableConfig: {
								loading: false
							},
							AddOrEdit:{
								detail: {},
								storageId: '',
								note: null
					        }
						},
						watch: {
							'AddOrEdit.storageId': function (val, old) {
								this.AddOrEdit.detail = {}
							}
						},
						methods: {
							checkInvs(pageConfig){
								var vm = this
								if (pageConfig) {
									vm.searchParam.pageNum = pageConfig.pageNum
									vm.searchParam.pageSize = pageConfig.pageSize
									vm.searchParam.orderByClause = pageConfig.orderByClause
								}
								vm.tableConfig.loading = true
								vm.searchParam.dto.storageId = vm.AddOrEdit.storageId
								ajax.post('/checkInv/findInvByStorageId', vm.searchParam).then(function (res) {
									if (res.data != null) {
										res.data.list.forEach(function (row) {
											if (vm.AddOrEdit.detail.hasOwnProperty(row.inventoryId)) {
												row['checkRecord'] = vm.AddOrEdit.detail[row.inventoryId]
											}
										})
										vm.tableData = res.data
									} else {
										vm.tableData = {
										  "pageNum": vm.searchParam.pageNum,
										  "pageSize": vm.searchParam.pageSize,
										  "total": 0,
										  "list": []
										}
									}
									vm.tableConfig.loading = false
								}, function () {
									vm.tableConfig.loading = false
								})
							},
							handleRemarkChange (row, index) {
								this.AddOrEdit.detail[row.inventoryId] = row.checkRecord
							}
					   },
					   mounted () {
							// 添加表单验证
							this.$nextTick(function() {
								outstockaddValid()
							})
					   },
					   components: {
						   componentTable: componentTable
					   }
					})
				}
		})
	}
	
	function outstockaddValid () {
		util.formValid({
			selector: '#outstockDialog',
			onkeyup: false,
			rules: {
				'storageId': {
					required: true
				}
			},
			messages: {
				'storageId': {
					required: '请选择存放仓库'
				}
			}
		})
	}
	
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
     <el-table-column label="仓库名" prop="storageName" width="150" show-overflow-tooltip>
    </el-table-column>
    <el-table-column label="表面" width="120" show-overflow-tooltip>
        <template slot-scope="scope">
            {{scope.row.surfaceId}}
        </template>
    </el-table-column>
    <el-table-column label="数量" width="160" show-overflow-tooltip>
        <template slot-scope="scope">
            {{scope.row.quantity == null? 0:scope.row.quantity }} {{scope.row.baseProduct.quantityUnit}}
        </template>
    </el-table-column>
    <el-table-column label="重量" width="100" show-overflow-tooltip>
        <template slot-scope="scope">
            <template v-if="scope.row.baseProduct != null && scope.row.redWeight != null">
                {{util.formatNumber(scope.row.netWeight / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}}
                {{scope.row.baseProduct.weightUnit}}
            </template>
            <template v-else>
                {{util.formatNumber(scope.row.netWeight / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}}
                  {{scope.row.baseProduct.weightUnit}}
            </template>
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
            {{scope.row.volume}}
        </template>
    </el-table-column>
    <el-table-column label="厂家" width="180" show-overflow-tooltip>
        <template slot-scope="scope">
           {{scope.row.dictMallMnfct ? scope.row.dictMallMnfct.mnfctName : '--'}}
        </template>
    </el-table-column>
    
    <el-table-column label="备注" width="200">
		<template slot-scope="scope">
			<input type="text" class="ui-input-control ui-col-100" name="checkRecord" v-model="scope.row.checkRecord" @change="handleRemarkChange(scope.row, scope.$index)">
		</template>
    </el-table-column>
   `
	
})




