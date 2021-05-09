/**
 * 期末期初报表
 * @author zlh
 * @since 2017.12.08
 */

require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	//Vue初始化
	//首页vue
	var page = new Vue({
		el: '.main-content',
		data: {
			util:util,
			searchParam: {
				dto: {
					createStartDate:'',
					createEndDate:'',
					createUser:''
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
				ajax.findPage('/feeFinalReport',vm.searchParam).then(function (res) {
					vm.tableData = res.data
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
			},
			add () {
				addOrEdit()
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
	
	/*
	 * 新建期末初期报表
	 */
	function addOrEdit(){
		var tableContent
		util.dialog({
			id: 'addOrEdit',
			width: 800,
			height: 120,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title:'新建期末初期报表',
			content: `<form id="dialog-content">
					${reportHTML}
					</form>`,
					okValue: '保存',
					ok: function () {
									ajax.post('/feeFinalReport/saveFinalReport', tableContent.dto).then((result) => {
										util.promptMsg({
											content: result.message
										})
										page.fetchData();
									})
					
					},
					cancelValue: '取消',
					onshow: function () {
						if (tableContent == null) {
							tableContent = new Vue({
								el: '#dialog-content',
								data () {
									return {
										dto: {
										}
									}
								},
								methods: {
									fetchData () { 
										let vm = this
										ajax.post('/feeFinalReport/findFinalReport',vm.dto).then(function (res) {
											vm.$set(vm,"dto",res.data)
											vm.loading = false
										}, function () {
											vm.loading = false
										})
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
					}
			})
		}
	
var reportHTML =	 `<div class="ui-row">		
						<div class="ui-col">
							 <div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-40">财务未入库总重量</label>
								<div class="ui-col ui-col-50 ui-label-txt">
									<span>{{dto.feeUninstockTotalweight}}千克</span>
								</div>
							</div> 
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-40">财务未入库总金额</label>
								<div class="ui-col ui-col-50 ui-label-txt">
									<span>{{dto.feeUninstockTotalmoney}}元</span>
								</div>
							</div>
						</div>
				  </div>
				  <div class="ui-row">		
						<div class="ui-col">
							 <div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-40">财务未出库总重量</label>
								<div class="ui-col ui-col-50 ui-label-txt">
									<span>{{dto.feeUnoutstockTotalweight}}千克</span>
								</div>
							</div> 
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col ui-col-40">财务未出库总金额</label>
								<div class="ui-col ui-col-50 ui-label-txt">
									<span>{{dto.feeUnoutstockTotalmoney}}元</span>
								</div>
							</div>
						</div>
				  </div> `
})

		        
