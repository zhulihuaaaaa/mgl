/**
 * 基础信息设置
 * 
 * @author 倪凯
 * @since 2017.12.08
 */
require(['ajax', 'component-table', 'util', 'jquery-serialize'], function (ajax, componentTable, util) {
	
	//保存提交 倪凯 2017.12.16
	$(".bctj").click(function() {
		var newValue = $('#baseInfoDialog').serializeObject()
		ajax.update('/baseInfo', newValue).then(function (result) {
			util.promptMsg({
				content: result.message
			})
//			util.dialog({getIdClose: 'baseInfoDialog'})
//			if (result.state === 1) {
//				page.fetchData()
//			}
		})
		return false
	});
	
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
			id: 'baseInfoDialog',
			width: 600,
			height: 250,
			fixed: true,
			skin: 'crm-form crm-form-over',
			title: type === 0 ? '新建品类' : '编辑品类',
			content: `
				<form id="baseInfoDialog">
					<h5 class="bg-tit">基本信息</h5>
					<div class="ui-row">
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">品类名称</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" name="productName" placeholder="请输入品类名称" value="${type === 0 ? '' : data.productName}">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">数量单位</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" name="quantityUnit" placeholder="请输入数量单位" value="${type === 0 ? '' : data.quantityUnit}">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">重量单位</label>
								<div class="ui-col-60">
									<input type="text" class="ui-input-control" name="weightUnit" placeholder="请输入重量单位" value="${type === 0 ? '' : data.weightUnit}">
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">精确度</label>
								<div class="ui-col-60">
									<input type="number" class="ui-input-control" name="precision" placeholder="请输入精确度" value="${type === 0 ? '' : data.precision}">
								</div>
							</div>
							<div class="ui-form-group ui-col-50">
								<label class="ui-label-control ui-col-30 required-txt">单位进率</label>
								<div class="ui-col-60">
									<input type="number" class="ui-input-control" name="unitRate" placeholder="相对于千克进率" value="${type === 0 ? '' : data.unitRate}">
								</div>
							</div>
						</div>
					</div>
				</form>
				`,
				okValue: type === 0 ? '保存': '更新',
				ok: function () {
					if ($('#baseInfoDialog').valid()) {
						var newValue = $.extend({InfoId: data.InfoId}, $('#baseInfoDialog').serializeObject())
						// 禁用提交按钮
						util.setLoading({
							selector: '[i-id="ok"]'
						})
						ajax.update('/baseInfo', newValue).then(function (result) {
							util.promptMsg({
								content: data.message
							})
							util.dialog({getIdClose: 'baseInfoDialog'})
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
					return false
				},
				cancelValue: '取消',
				onshow: function () {
					// 添加表单验证
					baseInfoValid()
				}
		})
	}
	// ---------------
	// 品类 - 表单验证
	// ---------------
	function baseInfoValid () {
		util.formValid({
			selector: '#baseInfoDialog',
			onkeyup: false,
			rules: {
				'feeRate': {
					required: true
				},
				'invoiceFee': {
					required: true
				},
				'overdueReminder': {
					required: true
				}
			},
			messages: {
				'productName': {
					required: '通用手续费率'
				},
				'quantityUnit': {
					required: '通用开票费'
				},
				'weightUnit': {
					required: '逾期提醒天数'
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
				ajax.detail('/baseProduct', {
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
							tabData: []
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
											}, 3000)
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
							}
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
})




