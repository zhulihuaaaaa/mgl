<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>合同详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
				<component-slide @fetch-data="fetchData" :id="model.contractId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
					<span class="slide-close" title="关闭">×</span>
					<div class="scroll-wrapper ui-pw15">
						<div class="ui-row ui-pw15">
							<div class="scroll-tit ui-col">
								<h1 class="ui-mb8">
									<span>{{model.contractNo}}</span>
									<component-approval-btn
										v-model="flow"
										:item-id="model.contractId"
										module="contract"
										:show-tag="true"
										:show-info="true"></component-approval-btn>
								</h1>
								<div class="ui-col ui-col-60 scroll-info">
									<p class="pull-left ui-mr32">
										<label>创建人</label> <span>{{model.createUser}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>合同状态</label> <span>{{model.contractStateName}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>合同期限</label> <span>{{model.contractPeriod}}天</span>
									</p>
								</div>
								<div class="ui-col ui-col-40 ui-txt-right ui-pb6">
										<erp:privilege key="GYL_CONTRACT_APPROVAL">
											<div>
												<component-approval-btn
													v-model="flow"
													:item-id="model.contractId"
													module="contract"
													:show-approval-btn="true"></component-approval-btn>
											</div>
										</erp:privilege>
								</div>
							</div>
						</div>
						
						<div class="swiper-navgation">
							<ul class="scroll-tab">
								<li class="active"><p>概要</p></li>
								<li><p>货物信息</p></li>
								<li><p>追加货款信息</p></li>
								<li><p>追加保证金信息</p></li>
							</ul>
							<input type="hidden" id="detailTabType" value="A">
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
													<label class="ui-label-control ui-col ui-col-30">业务类型</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.contractTypeName}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">合同单号</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{model.contractCode}}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">甲方</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.buyer.clientName}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">乙方</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{model.seller.clientName}}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">签订日期</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.signDate}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">合同期限</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{model.contractPeriod}}天</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">供应方</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.mnfct != null ? model.mnfct.mnfctShortName : ''}}</span>
													</div>
												</div>
											</div>
											
											<span v-if="hiddenFee">
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">保证金比例</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.depositRate != null ? util.formatNumber((model.depositRate * 100), 0) : 0}}%</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-40">保证金金额</label>
														<div class="ui-col ui-col-50 ui-label-txt">
															<span>{{model.depositFee != null ? util.formatNumber((model.depositFee / 10000), 2) : 0}}万元</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">开票费(元/吨)</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.invoiceBaseFee}}元</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">手续费率(0~60天)</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.feeRates[0].feeValue != null ? util.formatNumber((model.feeRates[0].feeValue * 10000), 2) : 0}}‱</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-40">手续费率(61~90天)</label>
														<div class="ui-col ui-col-50 ui-label-txt">
															<span>{{model.feeRates[1].feeValue != null ? util.formatNumber((model.feeRates[1].feeValue * 10000), 2) : 0}}‱</span>
														</div>
													</div>
												</div>
											</span>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">货物总重</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.totalWeight != null ? util.formatNumber((model.totalWeight / 1000), 3) : 0}}吨</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">货物总价</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{model.totalMoney != null ? model.totalMoney : 0}}元</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-100">
													<label class="ui-label-control ui-col-10">备注</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{ model.notes }}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">合同原件</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<component-images :data="model.attactList" title="合同原件"></component-images>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 1 && tabData[activeIndex]">
											<h5 class="bg-tit">
												<span>货物信息</span>
											</h5>
											<div class="ui-col">
												<div class="main-cnt-scroll">
													<component-table
															:max-height="500"
															:data="tabData[1]"
															row-key="contractDetailId">
														<el-table-column
															prop="product.productName"
															label="品类"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
															<el-table-column
															prop="orderCode"
															label="系列"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
														<el-table-column
															prop="materialId"
															sortable="custom"
															label="材质"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
														<el-table-column
															prop="surfaceId"
															sortable="custom"
															label="表面"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
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
															:show-overflow-tooltip="true"></el-table-column>
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
															sortable="custom"
															label="重量"
															min-width="120"
															:show-overflow-tooltip="true">
																<template slot-scope="scope">
																	{{ scope.row.netWeightDisplay + scope.row.product.weightUnit }}
																</template>
															</el-table-column>
														<el-table-column
															sortable="custom"
															label="含税单价"
															min-width="180"
															:show-overflow-tooltip="true">
																<template slot-scope="scope">
																	{{ scope.row.unitContractPrice ==null? 0 : scope.row.unitContractPrice + "元/" +  scope.row.product.weightUnit}}
																</template>
															</el-table-column>
														<el-table-column
															prop="contractMoney"
															sortable="custom"
															label="含税金额(元)"
															min-width="170"
															:show-overflow-tooltip="true"></el-table-column>
													</component-table>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<!-- 追加货款 -->
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 2 && tabData[activeIndex]">
											<h5 class="bg-tit">
												<span>追加货款信息</span>
											</h5>
											<div class="ui-col">
												<div class="main-cnt-scroll">
													<component-table
															:max-height="500"
															:data="tabData[2]"
															row-key="paymentDetailId">
														<el-table-column
															prop="money"
															label="金额(元)"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
														<el-table-column
															prop="state"
															label="状态"
															min-width="100"
															:show-overflow-tooltip="true">
																<template slot-scope="scope">
																	{{ scope.row.state === 'Y' ? '已到账' : '未到帐' }}
																</template>
															</el-table-column>
														<el-table-column
															prop="createUser"
															label="创建人"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
														<el-table-column
															prop="createDate"
															label="创建时间"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
													</component-table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- 追加保证金 -->
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 3 && tabData[activeIndex]">
											<h5 class="bg-tit">
												<span>追加保证金信息</span>
											</h5>
											<div class="ui-col">
												<div class="main-cnt-scroll">
													<component-table
															:max-height="500"
															:data="tabData[3]"
															row-key="depositDetailId">
														<el-table-column
															prop="money"
															label="金额(元)"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
														<el-table-column
															prop="state"
															label="状态"
															min-width="100"
															:show-overflow-tooltip="true">
																<template slot-scope="scope">
																	{{ scope.row.state === 'Y' ? '已到账' : '未到帐' }}
																</template>
															</el-table-column>
														<el-table-column
															prop="createUser"
															label="创建人"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
														<el-table-column
															prop="createDate"
															label="创建时间"
															min-width="120"
															:show-overflow-tooltip="true"></el-table-column>
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