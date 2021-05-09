<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>发票详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
				<component-slide @fetch-data="fetchData" :id="model.invoiceId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
					<span class="slide-close" title="关闭">×</span>
					<div class="scroll-wrapper ui-pw15">
						<div class="ui-row ui-pw15">
							<div class="scroll-tit ui-col">
								<h1 class="ui-mb8">
									<span>{{model.invoiceNo}}</span>
								</h1>
								<div class="ui-col ui-col-60 scroll-info">
									<p class="pull-left ui-mr32">
										<label>创建人</label> <span>{{model.createUser}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>发票类型</label> <span>{{model.invoiceType == "A" ? "进项":"销项"}}</span>
									</p>
								</div>
								<div class="ui-col ui-col-40 ui-txt-right ui-pb6">
									<erp:privilege key="GYL_CONTRACT_EDIT">
										<a href="javascript:void(0);" class="a-edit ui-ft13 ui-blue" @click="edit" >
											<i class="icon-coupon ui-blue"></i>编辑
										</a>
									</erp:privilege>
								</div>
							</div>
						</div>
						
						<div class="swiper-navgation">
							<ul class="scroll-tab">
								<li class="active"><p>概要</p></li>
								<li><p>货物信息</p></li>
							</ul>
						</div>
						<div class="swiper-container tab-container" v-loading="loading">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 0">
											<h5 class="bg-tit">
												<span>基本信息</span>
											</h5>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">发票类型</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.invoiceType == "A" ? "进项":"销项"}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">发票金额(元)</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{model.invoiceMoney}}</span>
													</div>
												</div>
											</div>
											
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">开票日期</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.billingDate}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">验票日期</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{model.checkingDate}}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-100">
													<label class="ui-label-control ui-col-10">合同信息</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{model.contractCodes}}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-100">
													<label class="ui-label-control ui-col-10">备注</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{model.notes}}</span>
													</div>
												</div>
											</div>
											<!-- <div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">发票照片</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<component-images :data="model.attactList" title="合同原件"></component-images>
													</div>
												</div>
											</div> -->
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 1 && tabData[activeIndex]">
											<h5 class="bg-tit">
												<span>货物信息</span>
												<!-- <erp:privilege key="GYL_CONTRACT_ADD">
													<button type="button" class="ui-btn pull-right btn_new_line" @click="addOrEdit(0, null)" v-if="null != flow && flow.canSubmit">编辑</button>
												</erp:privilege>-->
											</h5>
											<div class="ui-col">
												<div class="main-cnt-scroll">
													<component-table
															:max-height="500"
															:data="tabData[1]"
															row-key="invoiceDetailId">
														<el-table-column
															prop="product.productName"
															label="品名"
															min-width="120"
															:show-overflow-tooltip="true">
															</el-table-column>
														<el-table-column
															prop="materialId"
															sortable="custom"
															label="材质"
															min-width="120"
															:show-overflow-tooltip="true">
															</el-table-column>
														<el-table-column
															prop="surfaceId"
															sortable="custom"
															label="表面"
															min-width="120"
															:show-overflow-tooltip="true">
															</el-table-column>
														<el-table-column
															label="规格(mm)"
															min-width="120"
															:show-overflow-tooltip="true">
																<template slot-scope="scope">
																	{{ scope.row.labelThick + " * " + scope.row.labelWidth + " * " + scope.row.goodsLength }}
																</template>
															</el-table-column>
														<el-table-column
															prop="edge"
															sortable="custom"
															label="边部"
															min-width="120"
															:show-overflow-tooltip="true">
															</el-table-column>
														<el-table-column
															sortable="custom"
															label="数量"
															min-width="120"
															:show-overflow-tooltip="true">
																<template slot-scope="scope">
																	{{ scope.row.amount == null? 0 : scope.row.amount + scope.row.product.quantityUnit }}
																</template>
															</el-table-column>
														<el-table-column
															prop="netWeight"
															sortable="custom"
															label="重量"
															min-width="120"
															:show-overflow-tooltip="true">
															</el-table-column>
														<el-table-column
															prop="notes"
															sortable="custom"
															label="备注"
															min-width="120"
															:show-overflow-tooltip="true">
															</el-table-column>
													</component-table>
												</div>
											</div>
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