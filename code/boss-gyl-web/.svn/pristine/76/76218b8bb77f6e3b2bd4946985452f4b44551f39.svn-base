<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>入库详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
			<component-slide @fetch-data="fetchData" :id="instockId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
				<span class="slide-close" title="关闭">×</span>
				<div class="scroll-wrapper ui-pw15">
					<div class="ui-row ui-pw15">
						<div class="scroll-tit ui-col">
							<h1 class="ui-mb8">
								<span>{{model.bill.instockCode}}
									<el-tag  v-if="model.bill.instockStatus == 'B'" style="display:inline;font-size: 14px; color: #409EFF;" >已完成</el-tag>
									<el-tag  v-if="model.bill.instockStatus == 'A'" style="display:inline;font-size: 14px; color: #409EFF;" >进行中</el-tag>
									<el-tag  v-if="model.bill.instockStatus == 'C'" style="display:inline;font-size: 14px; color: #409EFF;" >已作废</el-tag>
								</span>
							</h1>
							<div class="ui-col ui-col-70 scroll-info">
								<p class="pull-left ui-mr32">
									<label>创建人</label> <span>{{model.bill.createUser}}</span>
								</p>
								<p class="pull-left ui-mr32">
									<label>业务类型</label> <span>{{businessTypeMap[model.bill.businessType]}}</span>
								</p>
							</div>

							<div class="ui-col ui-col-30 ui-txt-right ui-pb6">
								<erp:privilege key="GYL_INSTOCKBILL_UPDATE">
								<button v-if="model.bill.instockStatus != 'B'"  type="button" @click="commit"
									class="ui-btn ui-btn-primary ui-pw28 btn-add" :disabled="completeCommit">完成入库</button>
								</erp:privilege>
								<erp:privilege key="GYL_INSTOCKBILL_ADD_APPLY">
								<button v-if="applyMoney" type="button" @click="applyRemit"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">申请打款</button>
								</erp:privilege>
							</div>
						</div>
					</div>

					<div class="swiper-navgation">
						<ul class="scroll-tab">
							<li class="active"><p>概要</p></li>
							<li><p>合同信息</p></li>
							<li><p>验收货物信息</p></li>
							<li><p>打款申请记录</p></li>
							<li><p>交易记录</p></li>
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
												<label class="ui-label-control ui-col ui-col-30">入库单号</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.bill.instockCode}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">合同编号</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.contractNo}}</span>
												</div>
											</div>
										</div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">业务类型</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{businessTypeMap[model.bill.businessType]}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">创建人</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.bill.createUser}}</span>
												</div>
											</div>
										</div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">创建日期</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{model.bill.createDate}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">入库状态</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{InstockStateMap[model.bill.instockStatus]}}</span>
												</div>
											</div>
										</div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">保证金状态</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{DepositStateMap[model.bill.depositStatus]}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">验货入库状态</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span>{{InspectionStateMap[model.bill.inspectionStatus]}}</span>
												</div>
											</div>
										</div>
										<div class="ui-col">
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">融资货款状态</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span v-if="model.bill.businessType == 'H'">{{GoodsPaymentStateMap[model.bill.financingLoanStatus]}}</span>
													<span v-else>--</span>
												</div>
											</div>
											<div class="ui-form-group ui-col-50">
												<label class="ui-label-control ui-col ui-col-30">钢厂货款状态</label>
												<div class="ui-col ui-col-60 ui-label-txt">
													<span v-if="model.bill.businessType == 'C' ||model.bill.businessType == 'X'">{{GoodsPaymentStateMap[model.bill.paymentStatus]}}</span>
													<span v-else>--</span>
												</div>
											</div>
										</div>									
									</div>
								</div>
							</div>
		<!--基础信息结束 -->
		<!-- 合同 -->
							<div class="swiper-slide">
								<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 1 && tabData[activeIndex]">
		<!-- 合同基础信息 -->								
										<h5 class="bg-tit">
											<span>合同基础信息</span>
										</h5>
										<div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">业务类型</label>
													<div class="ui-col ui-col-50 ui-label-txt">	
														<span>{{util.replaceSpace(businessTypeMap[tabData[1].info.contractType])}}</span>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">合同编号</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(tabData[1].info.contractNo)}}</span>
													</div>
											</div>
										</div>
									     <div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">甲方</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{tabData[1].info.seller !=null?util.replaceSpace(tabData[1].info.seller.companyName):""}}</span>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">乙方</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{tabData[1].info.buyer!=null? util.replaceSpace(tabData[1].info.buyer.clientName):""}}</span>
													</div>
											</div>
										</div>
										<div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">签订日期</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(tabData[1].info.signDate)}}</span>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">供应方</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span v-if="tabData[1].info.mnfct !=null ">{{util.replaceSpace(tabData[1].info.mnfct.mnfctShortName)}}</span>
													</div>
											</div> 
										</div>
										<div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">合同原件</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<component-images :data="util.replaceSpace(tabData[1].info.attactList)" title="合同原件"></component-images>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">保证金比例</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(util.formatNumber((tabData[1].info.depositRate*100),0))}}%</span>
													</div>
											</div>
										</div>
										<div class="ui-row">
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">保证金金额（万元）</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(util.formatNumber((tabData[1].info.depositFee / 10000), 2))}}</span>
													</div>
											</div>
											<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">开票费（元）</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<span>{{util.replaceSpace(tabData[1].info.invoiceBaseFee)}}</span>
													</div>
											</div>
										</div> 
										<div class="ui-col">
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-30">货物总重</label>
													<div class="ui-col ui-col-60 ui-label-txt">
														<span>{{util.replaceSpace(util.formatNumber((tabData[1].info.totalWeight / 1000), 3))}}吨</span>
													</div>
												</div>
												<div class="ui-form-group ui-col-50">
													<label class="ui-label-control ui-col ui-col-40">货物总价</label>
													<div class="ui-col ui-col-50 ui-label-txt">
														<!-- <span>{{util.replaceSpace(util.formatNumber((tabData[1].info.totalMoney / 10000), 2))}}万元</span> -->
														<span>{{util.replaceSpace(tabData[1].info.totalMoney)}}元 </span>
													</div>
												</div>
											</div>
		<!--合同货物信息-->
										<h5 class="bg-tit">
											<span>合同货物信息</span>
										</h5>
											<div class="ui-row">
												<div class="ui-col">
												    <component-table 
												    	:max-height="300"
													    :data="tabData[1].detail">
													    <el-table-column label="品类" width="150">
													    	<template slot-scope="scope">
																{{util.replaceSpace(scope.row.product.productName)}}
															</template>
													    </el-table-column>  
													   <el-table-column label="材质" width="150">
													   		<template slot-scope="scope">
																{{util.replaceSpace(scope.row.materialId)}}
															</template>
													    </el-table-column> 
														<el-table-column label="表面" width="150">
															<template slot-scope="scope">
																{{util.replaceSpace(scope.row.surfaceId)}}
															</template>
														</el-table-column>
														<el-table-column label="规格(mm)" width="150">
															<template slot-scope="scope">
																{{util.replaceSpace(scope.row.labelThick)}}*{{util.replaceSpace(scope.row.labelWidth)}}*{{util.replaceSpace(scope.row.goodsLength)}}
															</template>
														</el-table-column>
													    <el-table-column label="边部" width="150">
													    	<template slot-scope="scope">
																{{util.replaceSpace(scope.row.edge)}}
															</template>
														</el-table-column>
														<el-table-column label="厂家" width="200">
															<template slot-scope="scope">
																{{ scope.row.mnfct !=null?util.replaceSpace(scope.row.mnfct.mnfctName):""}}
															</template>
														</el-table-column>
														<el-table-column label="数量(张/卷)" width="150">
															<template slot-scope="scope">
																{{util.replaceSpace(scope.row.amount)}}
															</template>
														</el-table-column>
														<el-table-column label="重量(kg)" width="150">
															<template slot-scope="scope">
																{{util.replaceSpace(scope.row.netWeight)}}
															</template>
														</el-table-column>
														<el-table-column label="含税单价(元/kg)" width="150">
															<template slot-scope="scope">
																{{util.replaceSpace(scope.row.unitContractPrice)}}
															</template>
														</el-table-column>
														<el-table-column label="含税金额(元)" width="150">
															<template slot-scope="scope">
																{{util.replaceSpace(scope.row.contractMoney)}}
															</template>
														</el-table-column>
													   </component-table>
												</div>
											</div>
		<!--合同货物信息结束-->					
									</div>
								</div>
							</div>
		<!-- 验收货物信息 -->
							<div class="swiper-slide">	
								<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 2 && tabData[activeIndex]">
										<h5 class="bg-tit">
											<span>验收货物信息</span>
										</h5>
										<template> 
										<component-table
											:data="tabData[2]"
											:max-height="500">
											<el-table-column 
												label="入库日期" 
												width="100"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.instockDate)}}
												</template>
											</el-table-column>
										    <el-table-column
												label="品类" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.productName)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="材质" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.materialId)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="表面" 
												width="80"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.surfaceId)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="标准厚度(mm)" 
												width="120">
											<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.labelThick)}}
												</template>
											</el-table-column> 
											<el-table-column 
												label="仓库" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.dictMallDepot.dptName)}}
												</template>
											</el-table-column>
										    <el-table-column 
												label="边部(mm)" 
												width="120"> 
											<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.edge)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="参厚(mm)" 
												width="120"> 
											<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.referThick)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="实宽(mm)" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.realWidth)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="牌号" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.trademark)}}
												</template>
											</el-table-column>
											    <el-table-column 
												label="卷号" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.goodsVolume)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="净重" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.netWeight + scope.row.baseProduct.weightUnit)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="数量" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.amount,0)+scope.row.baseProduct.quantityUnit}}
												</template>
											</el-table-column>
											<el-table-column 
												label="计算方式" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.calcMethod)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="等级" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.grade)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="合同单价" 
												width="150"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.contractUnitPrice)}}元/{{scope.row.baseProduct.weightUnit}}
												</template>
											</el-table-column>
											<el-table-column 
												label="实际单价" 
												width="150"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.realUnitPrice,0)}}元/{{scope.row.baseProduct.weightUnit}}
												</template>
											</el-table-column>
											<el-table-column
												label="升贴水(元)" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.floatPrice,'0')}}
												</template>
											</el-table-column>
											<el-table-column 
												label="基价(元)" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.basicPrice,'0')}}
												</template>
											</el-table-column>
											<el-table-column 
												label="合同金额(元)" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.contractMoney,'0')}}
												</template>
											</el-table-column>
											<el-table-column 
												label="实际金额(元)" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.realMoney,'0')}}
												</template>
											</el-table-column>
											<el-table-column 
												label="执行标准" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.implStd)}}
												</template>
											</el-table-column>
											
											<el-table-column 
												label="备注" 
												width="120"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.insInspectionDetail.notes)}}
												</template>
											</el-table-column>
										</component-table> 
										</template>
									</div>
								</div>
							</div>
		<!-- 打款申请记录 -->
							<div class="swiper-slide">	
								<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 3 && tabData[activeIndex]">
										<h5 class="bg-tit">
											<span>打款申请记录</span>
										</h5>
										<template> 
										<component-table
											:data="tabData[3]"> 
											<el-table-column 
												label="打款额（元）" 
												width="150">
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.detail.money)}}
												</template>
											</el-table-column> 
											<el-table-column 
												label="打款状态" 
												width="150"> 
												<template slot-scope="scope">
													{{DepositStateMap[scope.row.detail.remitStatus]}}
												</template>
											</el-table-column>
											<el-table-column 
												label="审核状态" 
												width="150"> 
												<template slot-scope="scope">
													{{ApprovalStateMap[scope.row.detail.auditStatus]}}
												</template>
											</el-table-column>
											<el-table-column 
												label="申请人" 
												width="150"> 
												<template slot-scope="scope">
													{{scope.row.detail.createUser}}
												</template>
											</el-table-column>
											<el-table-column 
												label="申请日期" 
												width="150"> 
												<template slot-scope="scope">
													{{scope.row.detail.createDate}}
												</template>
											</el-table-column>
											<el-table-column 
												label="确认人" 
												width="150"> 
												<template slot-scope="scope">
													{{scope.row.checkMan}}
												</template>
											</el-table-column>
										</component-table> 
										</template>
									</div>
								</div>
							</div>
		<!-- 交易记录 -->
							<div class="swiper-slide">	
								<div class="ui-panel">
									<div class="ui-panel-body scroll-body" v-if="activeIndex == 4 && tabData[activeIndex]">
										<h5 class="bg-tit">
											<span>交易记录</span>
										</h5>
										<template> 
										<component-table
											:data="tabData[4]"
											row-key="ContractRecord"> 
											<el-table-column 
												label="打款类型">
												<template slot-scope="scope">
													{{scope.row.remitTypeName}}
												</template>
											</el-table-column>
											<el-table-column 
												label="金额（元）"> 
												<template slot-scope="scope">
													{{util.replaceSpace(scope.row.detail.money)}}
												</template>
											</el-table-column>
											<el-table-column 
												label="交易时间"> 
												<template slot-scope="scope">
													{{scope.row.detail.remitDate}}
												</template>
											</el-table-column>
											<el-table-column 
												label="交易状态"> 
												<template slot-scope="scope">
													{{scope.row.remitState}}
												</template>
											</el-table-column>
										</component-table> 
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