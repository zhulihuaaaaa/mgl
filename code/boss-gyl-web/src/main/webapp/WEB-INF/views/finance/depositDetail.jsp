<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>财务单详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
				<component-slide @fetch-data="fetchData" :id="model.depositAccountId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
					<span class="slide-close" title="关闭">×</span>
					<div class="scroll-wrapper ui-pw15">
						<div class="ui-row ui-pw15">
							<div class="scroll-tit ui-col">
								<h1 class="ui-mb8">
									<span>{{model.crmClient.clientName}}</span>
								</h1>
								<div class="ui-col ui-col-70 scroll-info">
									<p class="pull-left ui-mr32">
										<label>关联合同信息</label> <span>{{model.contract.contractCode}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>关联保证金财务单</label> <span>{{model.finance.financeCode}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>保证金金额</label> <span>{{model.depositFee}}元</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>剩余金额</label> <span>{{model.balance}}元</span>
									</p>
								</div>
							</div>
						</div>
						
						<div class="swiper-navgation">
							<ul class="scroll-tab">
								<li class="active"><p>概要</p></li>
								<li><p>消费记录</p></li>
								<li><p>合同信息</p></li>
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
														<label class="ui-label-control ui-col ui-col-30">保证金账户信息</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.crmClient.clientName}}</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">关联合同信息</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.contract.contractCode}}</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">关联财务单</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.finance.financeCode}}</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">创建日期</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.createDate}}</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">消费金额</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.depositFee}}元</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">剩余保证金</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.balance}}元</span>
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
												<span>消费记录</span>
											</h5>
											<div class="ui-col">
												<div class="main-cnt-scroll">
													<component-table
														:max-height="500"
														:data="tabData[1]"
														row-key="depositAccountId">
													<el-table-column
														prop="financeCode"
														label="财务单号"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.finance != null ? scope.row.finance.financeCode : "" }}
														</template>
														</el-table-column>
													<el-table-column
														prop="relationCode"
														label="关联单号"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.finance != null ? scope.row.finance.relationCode : "" }}
														</template>
														</el-table-column>
													<el-table-column
														prop="contractId"
														label="关联合同"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.contract != null ? scope.row.contract.contractCode : "" }}
														</template>
														</el-table-column>
													<el-table-column
														sortable="custom"
														label="资金流向"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.flwoType == "A" ? "进账" : "出账" }}
														</template>
													</el-table-column>
													<el-table-column
														prop="createDate"
														sortable="custom"
														label="创建日期"
														min-width="120"
														:show-overflow-tooltip="true">
													</el-table-column>
													<el-table-column
														prop="businessType"
														label="业务类型"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.finance != null ? scope.row.finance.businessType : "" }}
														</template>
													</el-table-column>
													<el-table-column
														prop="actualAmount"
														label="实际到账金额"
														min-width="140"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.finance != null ? scope.row.finance.actualAmount : "" }}
														</template>
													</el-table-column>
													<el-table-column
														prop="realMoney"
														label="待付总金额"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.finance != null ? scope.row.finance.realMoney : "" }}
														</template>
														</el-table-column>
													<el-table-column
														sortable="custom"
														label="财务单状态"
														min-width="120"
														:show-overflow-tooltip="true">
															<template slot-scope="scope">
																{{ scope.row.status == "N" ? "未完成" : "已完成" }}
															</template>
													</el-table-column>
													<el-table-column
														prop="operator"
														label="操作员"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.finance != null ? scope.row.finance.operator : "" }}
														</template>
														</el-table-column>
													<el-table-column
														prop="operatorDate"
														label="操作时间"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ scope.row.finance != null ? scope.row.finance.operatorDate : "" }}
														</template>
														</el-table-column>
												</component-table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 2 && tabData[activeIndex]">
											<h5 class="bg-tit">
												<span>合同信息</span>
											</h5>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">业务类型</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{ tabData[2].contractTypeName }}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">合同单号</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{ tabData[2].contractCode }}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">甲方</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{ tabData[2].seller.companyName}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">乙方</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{ tabData[2].buyer.clientName}}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">签订日期</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{ tabData[2].signDate}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">合同期限</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{ tabData[2].contractPeriod}}天</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">供应方</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{ tabData[2].mnfct != null ?  tabData[2].mnfct.mnfctShortName : ''}}</span>
													</div>
												</div>
											</div>
											
											<span v-if="hiddenFee">
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">保证金比例</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{ tabData[2].depositRate != null ? util.formatNumber(( tabData[2].depositRate * 100), 0) : 0}}%</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-40">保证金金额</label>
														<div class="ui-col ui-col-50 ui-label-txt">
															<span>{{ tabData[2].depositFee != null ? util.formatNumber(( tabData[2].depositFee / 10000), 2) : 0}}万元</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">开票费(元/吨)</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{ tabData[2].invoiceBaseFee}}元</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">手续费率(0~60天)</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{ tabData[2].feeRates[0].feeValue != null ? util.formatNumber(( tabData[2].feeRates[0].feeValue * 10000), 2) : 0}}‱</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-40">手续费率(61~90天)</label>
														<div class="ui-col ui-col-50 ui-label-txt">
															<span>{{ tabData[2].feeRates[1].feeValue != null ? util.formatNumber(( tabData[2].feeRates[1].feeValue * 10000), 2) : 0}}‱</span>
														</div>
													</div>
												</div>
											</span>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">货物总重</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{ tabData[2].totalWeight != null ? util.formatNumber(( tabData[2].totalWeight / 1000), 3) : 0}}吨</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">货物总价</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{ tabData[2].totalMoney != null ? util.formatNumber(( tabData[2].totalMoney / 10000), 2) : 0}}万元</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-100">
													<label class="ui-label-control ui-col-10">备注</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{ tabData[2].notes }}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">合同原件</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<component-images :data=" tabData[2].attactList" title="合同原件"></component-images>
													</div>
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