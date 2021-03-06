<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>库存详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
				<component-slide @fetch-data="fetchData"  :id="model.invInventory.inventoryId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
					<span class="slide-close" title="关闭">×</span>
					<div class="scroll-wrapper ui-pw15">
						<div class="ui-row ui-pw15">
							<div class="scroll-tit ui-col">
								<h1 class="ui-mb8">
									<span>{{model.sellerName}}
									</span>
								</h1>
								<div class="ui-col ui-col-70 scroll-info">
									<p class="pull-left ui-mr32">
										<label>买方客户</label> <span>{{model.buyerName}}</span>
									</p>
									<p class="pull-left ui-mr32">
										 <label>业务类型</label>
								  		 <span  v-if="model.invInventory.businessType === 'H'">货押融资</span>
							             <span  v-if="model.invInventory.businessType === 'C'">定向销售</span>
							             <span  v-if="model.invInventory.businessType === 'X'">采购自销</span>
							             <span  v-if="model.invInventory.businessType === 'D'">仓单质押</span>
							             <span  v-if="model.invInventory.businessType === 'E'">商城融资</span>
							             <span  v-if="model.invInventory.businessType === 'F'">订单交收</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>入库日期</label> 	<span>{{model.invInventory.instockDate}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>存放仓库</label><span>{{model.dictMallDepot['dptName']}}</span>
									</p>
								</div>
							</div>
						</div>
						<erp:privilege key="GYL_INVENTORY__FINANCIA_DETAIL_VIEW ">
							<span data-privilege="view"></span>
						</erp:privilege>
						<div class="swiper-navgation">
							<ul class="scroll-tab">
								<li class="active"><p>概要</p></li>
								<li ><p>货物盘点明细</p></li>
							</ul>
							<input type="hidden" id="detailTabType" value="A">
						</div>
						<div class="swiper-container tab-container" v-loading="loading">
							<div class="swiper-wrapper">
								<div class="swiper-slide" >
									<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 0">
												<h5 class="bg-tit">
													<span>基本信息</span>
												</h5>
												<div class="ui-row">
													<div class="ui-form-group ui-col">
														<label class="ui-label-control ui-col ui-col-10">卖方客户</label>
														<div class="ui-col ui-col-40 ui-label-txt">
															<span>{{model.sellerName}}</span>
														</div>
														<label class="ui-label-control ui-col ui-col-10">买方客户</label>
														<div class="ui-col ui-col-40 ui-label-txt">
															<span>{{model.buyerName}}</span>
														</div>
														<div class="ui-form-group ui-col">
															<label class="ui-label-control ui-col ui-col-10">业务类型</label>
															<div class="ui-col ui-col-40 ui-label-txt">
										               			 <span  v-if="model.invInventory.businessType === 'H'">货押融资</span>
													             <span  v-if="model.invInventory.businessType === 'C'">定向销售</span>
													             <span  v-if="model.invInventory.businessType === 'X'">采购自销</span>
													             <span  v-if="model.invInventory.businessType === 'D'">仓单质押</span>
													             <span  v-if="model.invInventory.businessType === 'E'">商城融资</span>
													             <span  v-if="model.invInventory.businessType === 'F'">订单交收</span>
															</div>
															<label class="ui-label-control ui-col ui-col-10">入库日期</label>
															<div class="ui-col ui-col-40 ui-label-txt">
																<span>{{model.invInventory.instockDate}}</span>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="ui-panel-body scroll-body">
												<h5 class="bg-tit">
													<span>货物信息</span>  
												</h5>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">存放仓库</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.storageName}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">品类</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.productName}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">材质</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.materialId}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">表面</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.surfaceId}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<!-- <label class="ui-label-control ui-col ui-col-10">标准厚度(mm)</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.labelThick}}</span>
													</div> -->
													<label class="ui-label-control ui-col ui-col-10">标准宽度(mm)</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.labelWidth}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">标签厚度(mm)</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.labelThick}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">标签长度(mm)</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.goodsLength}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">执行标准</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.implStd}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">边部</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.edge}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">参厚(mm)</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.referThick}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">实宽(mm)</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.realWidth}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">牌号</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.trademark}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">卷号</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.volume}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">厂家</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.mnfctName}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">净重</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{util.formatNumber((model.invInventory.netWeight/ model.baseProduct.unitRate), model.baseProduct.precision)}}{{model.baseProduct.weightUnit}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">数量</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.quantity}}{{model.baseProduct.quantityUnit}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">计算方式</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.calcMethod}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">等级</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.grade}}</span>
													</div>
												</div>
												<!--  采购自销等情况下不用出现 -->
												<div v-if="model.invInventory.businessType =='X' ||model.invInventory.businessType == 'D'">
													<div class="ui-form-group ui-col">
														<label class="ui-label-control ui-col ui-col-10">升贴水</label>
														<div class="ui-col ui-col-40 ui-label-txt">
															<span>{{model.invInventory.floatPrice}}元</span>
														</div>
														<label class="ui-label-control ui-col ui-col-10">基价</label>
														<div class="ui-col ui-col-40 ui-label-txt">
															<span>{{model.invInventory.basicPrice}}元</span>
														</div>
													</div>
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">备注</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.notes}}</span>
													</div>	
													<label class="ui-label-control ui-col ui-col-10">是否为自有货物</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.invInventory.ownCargo=='Y'?"是":"否"}}</span>
													</div>		
												</div>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">货物照片</label>
													<div class="ui-col ui-col-90 ui-label-txt">
														<component-images :data="model.sphotosGoodsList" title="货物照片"></component-images>
													</div>	
												</div>
										</div>
										<!-- 合同信息 -->
											<div class="ui-panel-body scroll-body">
												<h5 class="bg-tit">
													<span>合同信息</span>
												</h5>
												<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">合同编号</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.conContract.contractNo}}</span>
													</div>
													<label class="ui-label-control ui-col ui-col-10">合同自编号</label>
													<div class="ui-col ui-col-40 ui-label-txt">
														<span>{{model.conContract.contractCode}}</span>
													</div>
												</div>
											</div>
									</div>
								</div>
								<div class="swiper-slide" >
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 1">
											<h5 class="bg-tit">
												<span>货物盘点明细</span>
											</h5>
											<div>
												<component-table
												:data="checkInv"
												:max-height="500">
												<el-table-column
												prop="checkRecord"
												label="盘点记录"
												min-width="120"
												:show-overflow-tooltip="true"></el-table-column>
												<el-table-column
												prop="createUser"
												label="创建人"
												min-width="120"
												:show-overflow-tooltip="true"></el-table-column>
											 	<el-table-column
										        prop="createDate"
										        label="创建时间"
										        width="180"></el-table-column>
												</component-table>
											</div>
										</div>
									</div>
								</div>
							
						</div>
					</div>
				</component-slide>
			</div>
		</div>
	</section>
</body>
</html>