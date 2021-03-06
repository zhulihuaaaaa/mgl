/**
 * 品类设置
 * 
 * @author 张渊
 * @since 2017.12.08
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	// VUE初始化页面
	// 侧边详情Vue组件
	var detail = null;
	var dialog = null
	// 主页面Vue组件
	var page = new Vue({
		el: '.main-content',
		data: {
			// 搜索条件
			searchParam: {
				dto: {
					// 品类名称
					productName: '',
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
				numberNnit: {}
			},
			// 表格数据
			tableData: {},
			tableConfig: {
				loading: false,
				columns: ['operation', 'custom'],
				operation: ['edit', 'delete']
			}
		},
		watch: {
			'searchParam.dto.productName': function (val) {
				if (val != null && val.trim() != '') {
					this.fetchData()
				}
			}
		},
		methods: {
			/**
			 * 后台检索数据
			 */
			fetchData (pageConfig) {
				let vm = this
				if (pageConfig) {
					$.extend(vm.searchParam, pageConfig)
//					vm.searchParam.pageNum = pageConfig.pageNum
//					vm.searchParam.pageSize = pageConfig.pageSize
//					vm.searchParam.orderByClause = pageConfig.orderByClause
				}
				vm.tableConfig.loading = true
				ajax.findPage('/baseProduct', vm.searchParam).then(function (res) {
					vm.tableData = res.data
					vm.tableConfig.loading = false
				}, function () {
					vm.tableConfig.loading = false
				})
			},
			add () {
				addOrEdit(0)
			},
			edit (row) {
				addOrEdit(1, row)
			},
			del (row) {
				var vm = this
				ajax.delete('/baseProduct', row.productId).then(function (result) {
					vm.fetchData()
				}, function () {
					vm.fetchData()
				})
			},
			getNumberUnit (options) {
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
	
	/**
	 * 新增或编辑品类
	 * 
	 * @param type
	 *            操作类型（0:新增|1:编辑）
	 */
	function addOrEdit (type, data) {
		util.dialog({
			id: 'baseProductDialog',
			width: 600,
			height: 250,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建品类' : '编辑品类',
			content: `
				<form id="baseProductDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">品类名称</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" name="productName" placeholder="请输入品类名称" v-model="data.productName">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">数量单位</label>
								<div class="ui-col-60">
								 	<component-select v-model="data.quantityUnit" type="numberUnit" name="quantityUnit">
                                 	</component-select>
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">重量单位</label>
								<div class="ui-col-60">
								 	<component-select v-model="data.weightUnit" type="weightUnit" name="weightUnit">
                                 	</component-select>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">精确度</label>
								<div class="ui-col-60">
									<input type="number" class="ui-input-control" name="precision" placeholder="请输入精确度" v-model="data.precision">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">单位进率</label>
								<div class="ui-col-60">
									<input type="number" class="ui-input-control" name="unitRate" placeholder="相对于千克进率" v-model="data.unitRate">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">状态</label>
								<div class="ui-col-60">
									<el-checkbox v-model="data.status" class="ui-checkbox" true-label="Y" false-label="N">
								</div>
							</div>
						</div>
					</div>
				</form>
				`,
				okValue: type === 0 ? '保存': '更新',
				ok: function () {
					if ($('#baseProductDialog').valid()) {
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						if (type === 0) {
							ajax.save('/baseProduct', dialog.data).then(function (result) {
								util.dialog({getIdClose: 'baseProductDialog'})
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
							var newValue = $.extend({productId: data.productId}, dialog.data)
							ajax.update('/baseProduct', newValue).then(function (result) {
								util.dialog({getIdClose: 'baseProductDialog'})
								if (result.state === 1) {
									page.fetchData()
								}
							}, function () {
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
					dialog = new Vue({
						el: '#baseProductDialog',
						data: {
							data: type === 1 ? $.extend({}, data) : {
								productId: '',
								productName: '',
								quantityUnit: '',
								weightUnit: '',
								precision: '',
								unitRate: '',
								status: 'Y'
							}
						},
						mounted () {
							// 添加表单验证
							baseProductValid()
						}
					})
				}
		})
	}
	// ---------------
	// 品类 - 表单验证
	// ---------------
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
					required: '请输入品类名称',
					maxlength: '品类名称最多10个字'
				},
				'quantityUnit': {
					required: '请输入数量单位',
					maxlength: '数量单位最多5个字'
				},
				'weightUnit': {
					required: '请输入重量单位',
					maxlength: '重量单位最多5个字'
				},
				'precision': {
					required: '请输入精确度',
					// 整数
					digits: '精确度须为整数',
					min: '精确度为0-4',
					max: '精确度为0-4'
				},
				'unitRate': {
					required: '请输入单位进率',
					digits: '单位进率须为整数',
					min: '单位进率最小值为1'
				}
			}
		})
	}
})




