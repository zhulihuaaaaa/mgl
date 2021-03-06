/**
 * 结算赎货信息审核
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
			// 搜索条件
			searchParam: {
				dto: {
					goodsSource:'',
					createUser: '',
					startCreateDate: '',
					endCreateDate: '',
					buyer:'',
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
				InOrNotStock:[],
				ApprovalState:[],
				RedeemBillState: []
			},
			// 表格数据
			tableData: [],
			tableConfig: {
				loading: false,
				columns: ['index', 'custom']
			},
			util:util
		},
		computed: {
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
				ajax.findPage('/redRedeemBillBalance', vm.searchParam).then(function (res) {
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
			}
		},
		mounted () {
			var vm = this
			util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start', '.daterange-end'],  // 绑定Input选择器
		    })
		    ajax.getOptions(['GoodsSource','InOrNotStock','ApprovalState', 'RedeemBillState']).then((result) => {
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
			ajax.detail('/redRedeemBillBalance', {
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
							RedeemBillState: []
						}
					},
					methods: {
						// 通过 D 或者 拒绝 C
						isPassOrNotPass(status){
							let vm = this
							ajax.get("/redRedeemBillBalance/update",{id:vm.model.redeemBillId,status:status}).then(function (result) {
								if(result.state == 1){
									vm.model.auditStatus = status									
								}
							})
						},
						/**
						 * 获取对应索引的tab数据
						 */
						fetchData (index) {
							let vm = this
							if(index == 1){
								vm.loading = true
								ajax.findOne('/redRedeemBillBalance',vm.model.redeemBillId).then(function (res) {
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
						}
					},
					computed: {
						auditStatus () {
							if (this.model != null && this.model.auditStatus) {
								switch (this.model.auditStatus) {
								case 'A':
									return '未提交'
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
						},
						redeemBillState () {
							var map = {}
							this.options.RedeemBillState.forEach(function (item) {
								map[item[0]] = item[1]
							})
							return map
						}
					},
					mounted () {
						var vm = this
						 ajax.getOptions(['GoodsSource','InOrNotStock','ApprovalState','RedeemBillState']).then((result) => {
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
			detailVue.model = data
			detailVue.show = true
		}
}
	
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
     <el-table-column label="仓库名" width="150" show-overflow-tooltip>
            <template slot-scope="scope">
                {{scope.row.dictMallDepot.dptName}}
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
    </el-table-column>`
})
