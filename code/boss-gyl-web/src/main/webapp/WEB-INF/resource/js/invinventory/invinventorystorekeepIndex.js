/**
 * 库存管理
 * @author 杨思静
 * @since 2017.12.08
 */
require(['ajax', 'component-table', 'util'], function (ajax, componentTable, util) {
	var detail = null;
	// VUE初始化页面
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					//业务类型
					businessType: '',
					// 业务类型
					// typeList:['H','C'],
					// 库存状态
					stats:'',
					// 入库时间
					instockStartDate:'',
					instockEndDate:'',
				     // 卖方id
					sellerId:'',
				     // 买方id
				    buyerId:'',
				     // 存放仓库id
				    storageId:'',
				     // 表面名称
				    surfaceId:'',
				    // 品名名称
				    productId:'',
				     // 厂家名称
				    mnfctId:'',
			    	// 卷号
			    	volume:'',
			    	contractId:''
				},
				// 页码
				pageNum: 0,
				// 分页大小
				pageSize: 20,
				// 排序
				orderByClause: ''
			},
			// 选择项
			options: {
				BusinessType: [],
				InOrNotStock:[]
			},
			// 表格数据
			tableData: {},
			tableConfig: {
				loading: false,
				columns: ['index', 'custom']
			},
			util:util
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
				ajax.findPage('/stockStorekeeper', vm.searchParam).then(function (res) {
					// 成功的回调
					vm.tableData = res.data
					vm.tableConfig.loading = false
				}, function () {
					//失败的回调
					vm.tableConfig.loading = false
				})
			},
			detail (row) {
				showSlide(row)
			},
			reset() {
				let one ={
						dto: {
							//业务类型
							businessType: '',
							// 库存状态
							stats:'',
							// 入库时间
							instockStartDate:'',
							instockEndDate:'',
						     // 卖方id
							sellerId:'',
						     // 买方id
						    buyerId:'',
						     // 存放仓库id
						    storageId:'',
						     // 表面名称
						    surfaceId:'',
						    // 品名名称
						    productId:'',
						     // 厂家名称
						    mnfctId:''
						},
						// 页码
						pageNum: 0,
						// 分页大小
						pageSize: 20,
						// 排序
						orderByClause: ''	
				}
				this.searchParam = one
				this.fetchData()
			}
		},
		mounted () {
			util.datePicker({
		    	/* 日期区间dateRange为true，selector传递array类型参数 */
		        dateRange: true,
		        selector: ['.daterange-start', '.daterange-end'],  //绑定Input选择器
		    })
		    let vm = this
	     	ajax.getOptions(['InOrNotStock', 'BusinessType']).then((result) => {
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
	
	$(".btn-add").click(function () {
		addOrEdit(0)
	})
	
	/**
	 * 新增或编辑品名
	 * @param type 操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			width: 600,
			height: 250,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建品名' : '编辑品名',
			content: `
				<form id="baseProductDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-col">
						<div class="ui-col">
							<div class="ui-form-group ui-col-60">
								<label class="ui-label-control ui-col-30 required-txt">产品名称</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" v-model="productName" placeholder="请输入产品名称">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">数量单位</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" name="quantityUnit" placeholder="请输入数量单位">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">重量单位</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" name="weightUnit" placeholder="请输入重量单位">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">精确度</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" type="number" name="precision" placeholder="请输入精确度">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">单位进率</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" type="number" name="unitRate" placeholder="相对于千克进率">
								</div>
							</div>
						</div>
					</div>
				</form>
				`,
				okValue: '确定',
				ok: function () {
					if ($('#baseProductDialog').valid()) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						if (type === 0) {
							ajax.save('/baseProduct', $('#baseProductDialog').serialize()).then((result) => {
								util.promptMsg({
									content: data.message
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
						} else {
							ajax.update('/baseProduct', $('#baseProductDialog').serialize()).then((result) => {
								util.promptMsg({
									content: data.message
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
					}
				},
				cancelValue: '取消',
				onshow: function () {
					// 添加表单验证
					baseProductValid()
				}
		})
	}
	//---------------
	// 品名 - 表单验证
	//---------------
	function baseProductValid () {
		util.formValid({
			selector: '#baseProductDialog',
			onkeyup: false,
			rules: {
				'productName': {
					required: true
				},
				'quantityUnit': {
					required: true,
					maxlength: 5
				},
				'weightUnit': {
					required: true,
					maxlength: 5
				},
				'precision': {
					required: true,
					// 整数
					digits: true,
					min: 0,
					max: 4
				},
				'unitRate': {
					required: true,
					digits: true,
					min: 1
				}
			},
			messages: {
				'productName': {
					required: '请输入产品名称'
				},
				'quantityUnit': {
					required: '请输入数量单位',
					maxlength: '数量单位不能超过5个字'
				},
				'weightUnit': {
					required: '请输入重量单位',
					maxlength: '重量单位不能超过5个字'
				},
				'precision': {
					required: '请输入精确度',
					// 整数
					digits: '精确度须为整数',
					min: '精确度为0-4位',
					max: '精确度为0-4位'
				},
				'unitRate': {
					required: '请输入单位进率',
					digits: '单位进率须为整数',
					min: '单位进率最小值为1'
				}
			}
		})
	}
	/**********************侧边栏*******************/
	
	
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
				ajax.detail('/stockStorekeeper', {
					productId: data.productId
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
							util:util,
							checkInv:[]
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
											this.fetchDataBycheckInv()
											break
										case 2:
											// TODO 根据Tab索引查询数据
											setTimeout(function () {
												vm.tabData[index] = {
														test: '测试TAB2'
												}
												vm.loading = false
											}, 3000)
											break
											
									}
								}
							},
							/**
							 * 编辑
							 */
							edit () {
								addOrEdit(1, this.model)
							},
							fetchDataBycheckInv(){
								var vm = this
								let id = this.model.invInventory.inventoryId
								 ajax.get("/stockStorekeeper/selectCheckInv",{id:id}).then(function (res) {
									 vm.checkInv = res.data
									 vm.loading = false
							 	 }, function () {

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




