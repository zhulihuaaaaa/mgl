<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>结算赎货详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
			<component-slide @fetch-data="fetchData" :id="model.redeemBillId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
				<span class="slide-close" title="关闭">×</span>
				<div class="scroll-wrapper ui-pw15">
					<div class="ui-row ui-pw15">
						<div class="scroll-tit ui-col">
							<h1 class="ui-mb8">
								<span>{{model.redeemBillCode}}</span>
								<el-tag slot="reference"
						            size="small">{{auditStatus}}
						        </el-tag>
								</component-approval-btn>
							</h1>
							<div class="ui-col ui-col-70 scroll-info">
								<p class="pull-left ui-mr32">
									<label>创建人</label> <span>{{model.createUser}}</span>
								</p>
								 <p class="pull-left ui-mr32">
									<label>创建时间</label> <span>{{model.createDate}}</span>
								</p>
								 <p class="pull-left ui-mr32">
									<label>对应合同</label> <span>{{model.contractNo}}</span>
								</p>
								<p class="pull-left ui-mr32">
									<label>货物来源</label> <span>{{goodsSourceMap[model.goodsSource]}}</span>
								</p> 
							</div>
							<div class="ui-col ui-col-30 ui-txt-right ui-pb6">
								<erp:privilege key="GYL_REDREDEEM_BALANCE_APPROVAL">
									<div>
										<el-button
											v-if="model.auditStatus == 'B'"
									        size="small"
									        type="primary"
									        @click="isPassOrNotPass('D')">通过
									    </el-button>
									    <el-button
											v-if="model.auditStatus == 'B'"
									        size="small"
									        type="primary"
									        @click="isPassOrNotPass('C')">拒绝
									    </el-button>
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
										<div class="ui-row">
											<div class="ui-col">
												 <div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">赎货客户</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.buyerName}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">创建人</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.createUser}}</span>
													</div>
												</div> 
											</div>
											<div class="ui-col">
												 <div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">创建时间</label>
													<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.createDate}}</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">对应合同</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.contractNo}}</span>
													</div>
												</div> 
											</div>
											<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">货物来源</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{goodsSourceMap[model.goodsSource]}}</span>
													</div>
												</div>
											 	<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">总重量（吨）</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{util.replaceSpace(model.totalWeight)}}</span>
													</div>
												</div> 
											</div>
											<div class="ui-col">
												 <div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">审核状态</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{approvalStateMap[model.auditStatus]}}</span>
													</div>
												</div> 
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">仓库名</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.dictMallDepot.dptName}}</span>
													</div>
												</div> 
											</div>
											<div class="ui-col">
												 <div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">赎货状态</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{redeemBillState[model.redeemStatus]}}</span>
													</div>
												</div> 
											</div>
		<!-- 提货人信息	 -->				</div>
										<h5 class="bg-tit">
											<span>提货人信息</span>
										</h5>
										<div class="ui-row">		
											<div class="ui-col">
												 <div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">提货人</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.consignee}}</span>
													</div>
												</div> 
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">提货人电话</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.consigneeTel}}</span>
													</div>
												</div>
											</div>
											<div class="ui-col">
												 <div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">提货人身份证号</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.consigneeIdNo}}</span>
													</div>
												</div> 
												 <div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">车牌号</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{model.carNumber}}</span>
													</div>
												</div> 
											</div>
		<!-- 费用信息	 -->				</div>				 
										</div>
									</div>
								</div>
							</div>
		<!-- 基础信息结束 -->
							<div class="swiper-slide">
								<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 1 && tabData[activeIndex]">
		<!-- 货物信息 -->
										<h5 class="bg-tit">
											<span>货物信息</span>
											<erp:privilege key="GYL_REDREDEEMDETAIL_EDIT">
<!-- 										<input @click="add" type="button" style="background-color:#5CB85C;color:#fff;margin-right:5px" class="ui-btn pull-right btn_new_line" value="新增" />-->
 											<!-- <input @click="edit" type="button" style="background-color:#5CB85C;color:#fff" class="ui-btn pull-right btn_new_line" value="编辑" /> -->
											</erp:privilege>
										</h5>
										<div class="ui-row">
											<div class="ui-col">
												<component-table
												:max-height="500"
												:data="tabData[1]">
												 <div class="detail-table"></div>
												</component-table>
											</div>
										</div>
		<!-- 货物信息结束 -->					
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