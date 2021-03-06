<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>提货详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
			<component-slide @fetch-data="fetchData" :id="model.outOutstockBill.outstockBillId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
				<span class="slide-close" title="关闭">×</span>
				<div class="scroll-wrapper ui-pw15">
					<div class="ui-row ui-pw15">
						<div class="scroll-tit ui-col">
							<h1 class="ui-mb8">
								<span>{{model.outOutstockBill.outstockCode}}</span>
								<component-approval-btn
										v-model="flow"
										:item-id="model.outOutstockBill.outstockBillId"
										module="outstock"
										:show-tag="true"
										:show-info="true"></component-approval-btn>
							</h1>
							<div class="ui-col ui-col-70 scroll-info">
								<p class="pull-left ui-mr32">
									<label>客户信息</label> <span>{{model.clientName}}</span>
								</p>
								<p class="pull-left ui-mr32">
									<label>仓库</label> <span>{{model.storageName}}</span>
								</p>
							</div>

							<div class="ui-col ui-col-30 ui-txt-right ui-pb6">
								<erp:privilege key="GYL_OUTSTOCKBILL_APPROVAL">
									<div>
										<component-approval-btn
											v-model="flow"
											:item-id="model.outOutstockBill.outstockBillId"
											module="outstock"
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
						</ul>
						<input type="hidden" id="detailTabType" value="A">
					</div>
					<div class="swiper-container tab-container" v-loading="loading">
						<div class="swiper-wrapper">
	<!--基础信息  -->
							<div class="swiper-slide">
								<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 0">
										<h5 class="bg-tit">
											<span>基础信息</span>
										</h5>
										<div class="ui-col">
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">提货单号</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.outOutstockBill.outstockCode}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">仓库</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.storageName}}</span>
												</div>
											</div>
										</div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">客户信息</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.clientName}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">提货人</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.outOutstockBill.consignee}}</span>
												</div>
											</div>
										</div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">提货人电话</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.outOutstockBill.consigneeTel}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">提货人身份证号</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.outOutstockBill.consigneeIdNo}}</span>
												</div>
											</div>
										</div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">创建人</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.outOutstockBill.createUser}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">创建时间</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.outOutstockBill.createDate}}</span>
												</div>
											</div>
										</div>
										
									</div>
								</div>
							</div>
		<!--基础信息结束 -->
		
		<!-- 货物信息 -->
							<div class="swiper-slide">	
								<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 1 && tabData[activeIndex]">
										<h5 class="bg-tit">
											<span>货物信息</span>
											<erp:privilege key="GYL_OUTSTOCKBILLS_EDIT">
<!-- 											<input  type="button" @click="edit" style="background-color:#5CB85C;color:#fff" class="ui-btn pull-right btn_new_line" value="编辑" /> -->
											</erp:privilege>
										</h5>
										<template> 
										<el-table
											:max-height="500"
											:data="tabData[1]"
											 border
											row-key="applyRemitId"> 
											<el-table-column 
												label="品类" 
												width="180"
												prop="baseProduct.productName"
											> 
											</el-table-column> 
											<el-table-column 
												label="材质" 
												width="150"
												prop="outOutstockDetail.materialId"
											> 
											</el-table-column>
											<el-table-column 
												label="表面" 
												width="150"
												prop="outOutstockDetail.surfaceId"
											>
											</el-table-column>
											<el-table-column 
												label="数量" 
												width="180"
											> 
												<template slot-scope="scope">
													{{scope.row.outOutstockDetail.amount}}&nbsp;{{scope.row.baseProduct.quantityUnit}}
									       		</template>
											</el-table-column>
											<el-table-column 
												label="重量" 
												width="180"
											>
												<template slot-scope="scope" v-if="scope.row.baseProduct != null && scope.row.outOutstockDetail.netWeight != null">
													{{util.formatNumber(scope.row.outOutstockDetail.netWeight / scope.row.baseProduct.unitRate, scope.row.baseProduct.precision)}}{{scope.row.baseProduct.weightUnit}}
												</template>
											</el-table-column>
											
											<el-table-column 
												prop=""
												label="标签规格（厚度*宽度*长度）" 
												width="210"
											> 
												<template slot-scope="scope">
													{{scope.row.outOutstockDetail.labelThick}}&nbsp;*{{scope.row.outOutstockDetail.labelWidth}}&nbsp;*{{scope.row.outOutstockDetail.goodsLength}}
												</template>
											</el-table-column>
											<el-table-column 
												prop="outOutstockDetail.edge"
												label="边部" 
												width="180"
											> 
											</el-table-column>
											<el-table-column 
												prop="outOutstockDetail.referThick"
												label="参厚" 
												width="180"
											> 
											</el-table-column>
											<el-table-column 
												prop="outOutstockDetail.trademark"
												label="牌号" 
												width="180"
											> 
											</el-table-column>
											<el-table-column 
												prop="outOutstockDetail.goodsVolume"
												label="卷号" 
												width="180"
											> 
											</el-table-column>
											<el-table-column 
												prop="outOutstockDetail.mnfctId"
												label="制造商" 
												width="180"
											> 
											</el-table-column>
											<el-table-column 
												prop="outOutstockDetail.grade"
												label="等级" 
												width="180"
											> 
											</el-table-column> 
										</el-table> 
										</template>
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