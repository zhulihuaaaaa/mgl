<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>余额详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
				<component-slide @fetch-data="fetchData" :id="model.balanceId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
					<span class="slide-close" title="关闭">×</span>
					<div class="scroll-wrapper ui-pw15">
						<div class="ui-row ui-pw15">
							<div class="scroll-tit ui-col">
								<h1 class="ui-mb8">
									<span>{{model.customerName}}</span>
								</h1>
								<div class="ui-col ui-col-70 scroll-info">
									<p class="pull-left ui-mr32">
										<label>供应商信息</label> <span>{{model.mnfct.mnfctName}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>客户信息</label> <span>{{model.customerName}}</span>
									</p>
								</div>
							</div>
						</div>
						
						<div class="swiper-navgation">
							<ul class="scroll-tab">
								<li class="active"><p>概要</p></li>
								<li><p>余款记录</p></li>
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
														<label class="ui-label-control ui-col ui-col-30">供应商信息</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.mnfct.mnfctName}}</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">客户信息</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.customerName}}</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">余额（元）</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.residualAmount}}</span>
														</div>
													</div>
													<!-- <div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">创建人</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.createUser}}</span>
														</div>
													</div> -->
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">创建时间</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.createDate}}</span>
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
												<span>余款记录</span>
											</h5>
											<div class="ui-col">
												<div class="main-cnt-scroll">
													<component-table
														:max-height="500"
														:data="tabData[1]"
														:operation="operation"
														:columns="tableConfig.columns"
														row-key="balanceDetailId">
													<el-table-column
														label="供应商信息"
														min-width="200"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ model.mnfct.mnfctName }}
														</template>
													</el-table-column>
													<el-table-column
														label="客户信息"
														min-width="120"
														:show-overflow-tooltip="true">
														<template slot-scope="scope">
															{{ model.customerName }}
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
														prop="purchaseAmount"
														label="差额（元）"
														min-width="120"
														:show-overflow-tooltip="true">
													</el-table-column>
													<!-- <el-table-column
														prop="residualAmount"
														label="剩余金额"
														min-width="120"
														:show-overflow-tooltip="true">
													</el-table-column> -->
													<el-table-column
														prop="createDate"
														sortable="custom"
														label="创建日期"
														min-width="120"
														:show-overflow-tooltip="true">
													</el-table-column>
													<!-- <el-table-column
														prop="createUser"
														label="创建人"
														min-width="120"
														:show-overflow-tooltip="true">
													</el-table-column> -->
													<el-table-column
														prop="balanceStateName"
														label="状态"
														min-width="120"
														:show-overflow-tooltip="true">
													</el-table-column>
													<div v-if="scope.row.balanceState ==  'A'" slot="operation" slot-scope="scope">
													 	<span class="ui-btn ui-blue" style="padding: 0px 3px;" @click="showsumbitBtn(scope.row)">申请退款</span>
													</div>
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