<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>逾期详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
			<component-slide @fetch-data="fetchData" :id="contractId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
				<span class="slide-close" title="关闭">×</span>
				<div class="scroll-wrapper ui-pw15">
					<div class="ui-row ui-pw15">
						<div class="scroll-tit ui-col">
							<h1 class="ui-mb8">
									<span>{{model.contractCode}}</span>
							</h1>
							<div class="ui-col ui-col-70 scroll-info">
									<p class="pull-left ui-mr32">
										<label>逾期天数</label><span>{{model.overdue}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>合同期限</label><span>{{model.contractPeriod}}</span>
									</p> 
							</div>

							<div class="ui-col ui-col-30 ui-txt-right ui-pb6">
								<!-- <erp:privilege key="GYL_INSTOCKBILL_UPDATE"> -->
								<button type="button" v-if="contractState == 'B'" @click="applyOverdue"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">申请延期</button>
								<!-- </erp:privilege>  -->
							</div>
						</div>
					</div>

					<div class="swiper-navgation">
						<ul class="scroll-tab">
							<li><p>合同信息</p></li>
						</ul>
						<input type="hidden" id="detailTabType" value="A">
					</div>
					<div class="swiper-container tab-container" v-loading="loading">
						<div class="swiper-wrapper">
		<!-- 合同 -->
							<div class="swiper-slide">
								<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 0 && tabData[activeIndex]">
		<!-- 合同基础信息 -->								
										<h5 class="bg-tit">
											<span>合同信息</span>
										</h5>
										<div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">业务类型</label>
													<div class="ui-col ui-col-50 ui-label-txt">	
														<span>{{util.replaceSpace(businessTypeMap[tabData[0].info.contractType])}}</span>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">合同编号</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(tabData[0].info.contractNo)}}</span>
													</div>
											</div>
										</div>
									     <div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">甲方</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{tabData[0].info.seller !=null?util.replaceSpace(tabData[0].info.seller.companyName):""}}</span>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">乙方</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{tabData[0].info.buyer!=null? util.replaceSpace(tabData[0].info.buyer.clientName):""}}</span>
													</div>
											</div>
										</div>
										<div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">签订日期</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(tabData[0].info.signDate)}}</span>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">供应方</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span v-if="tabData[0].info.mnfct !=null ">{{util.replaceSpace(tabData[0].info.mnfct.mnfctShortName)}}</span>
													</div>
											</div> 
										</div>
										<div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">合同原件</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<!-- <component-images :data="util.replaceSpace(tabData[0].info.attactList)" title="合同原件"></component-images> -->
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">保证金比例</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(util.formatNumber((tabData[0].info.depositRate*100),0))}}%</span>
													</div>
											</div>
										</div>
										<div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">保证金金额（万元）</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(util.formatNumber((tabData[0].info.depositFee / 10000), 2))}}</span>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">开票费（元）</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(tabData[0].info.invoiceBaseFee)}}</span>
													</div>
											</div>
										</div> 
										<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">货物总重</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{util.replaceSpace(util.formatNumber((tabData[0].info.totalWeight / 1000), 3))}}吨</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">货物总价</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<!-- <span>{{util.replaceSpace(util.formatNumber((tabData[0].info.totalMoney / 10000), 2))}}万元</span> -->
														<span>{{util.replaceSpace(tabData[0].info.totalMoney)}}元 </span>
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