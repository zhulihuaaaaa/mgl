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
				<component-slide @fetch-data="fetchData" :id="model.financeBillId" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
					<span class="slide-close" title="关闭">×</span>
					<div class="scroll-wrapper ui-pw15">
						<div class="ui-row ui-pw15">
							<div class="scroll-tit ui-col">
								<h1 class="ui-mb8">
									<span>{{model.financeCode}}</span>
								</h1>
								<div class="ui-col ui-col-70 scroll-info">
									<p class="pull-left ui-mr32">
										<label>关联单号</label> <span>{{model.relationCode}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>关联合同</label> <span>{{model.contract.contractCode}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>资金流向</label> <span>{{model.flwoType == "A" ? "进账" : "出账"}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>财务单状态</label> <span>{{model.status == "N" ? "未完成" : "已完成"}}</span>
									</p>
								</div>
	
								<div class="ui-col ui-col-30 ui-txt-right ui-pb6" v-if="model.status == 'N'">
									<erp:privilege key="GYL_FINANCE_COMFIRM">
										<button type="button" class="ui-btn pull-right ui-btn-primary detail-comfirm-btn" @click="comfirmBill(model)">{{ model.flwoType === "A" ? "确认到账" : "确认付款" }}</button>
									</erp:privilege>
								</div>
							</div>
						</div>
						
						<div class="swiper-navgation">
							<ul class="scroll-tab">
								<li class="active"><p>概要</p></li>
								<li v-if="model.businessType == 'E'"><p>货物信息</p></li>
							</ul>
							<input type="hidden" id="detailTabType" value="A">
						</div>
						<div class="swiper-container tab-container" v-loading="loading">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 0">
										<h5 class="bg-tit">
												<span>费用信息</span>
											</h5>
											<div class="ui-row" v-if="model.businessType != 'E'">
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">{{model.flwoType == "A" ? "待收总金额" : "待付总金额"}}</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.realMoney}} 元</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">{{model.flwoType == "A" ? "实际到账金额" : "实际出账金额"}}</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.actualAmount}} 元</span>
														</div>
													</div>
												</div>
											</div>
											<div class="ui-row" v-if="model.businessType === 'E'">
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">总货款</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.totalGoodsPayment}} 元</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">手续费</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.commissionFee}} 元</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">开票费</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.invoiceFee}} 元</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">计费天数</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.chargingDays}} 天</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">其他费用</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.otherFee}} 元</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">总赎货款</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.totalMoney}} 元</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">保证金抵扣金额</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.depositFee}} 元</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">{{model.flwoType == "A" ? "待收总金额" : "待付总金额"}}</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.realMoney}} 元</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">{{model.flwoType == "A" ? "实际到账金额" : "实际出账金额"}}</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span class="ui-red">{{model.actualAmount}} 元</span>
														</div>
													</div>
												</div>
											</div>
											<h5 class="bg-tit">
												<span>概要</span>
											</h5>
											<div class="ui-row">
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">财务单号</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.financeCode}}</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">关联单号</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.relationCode}}</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">关联合同</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.contract.contractCode}}</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">业务类型</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.businessTypeName}}</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">资金流向</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.flwoType == "A" ? "进账" : "出账"}}</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">财务单状态</label>
														<div class="ui-col ui-col-60 ui-label-txt" v-if="model.status == 'N'">
															<span class="ui-red">未完成</span>
														</div>
														<div class="ui-col ui-col-60 ui-label-txt" v-if="model.status == 'Y'">
															<span class="ui-green">已完成</span>
														</div>
													</div>
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">操作员</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.operator}}</span>
														</div>
													</div>
													<div class="ui-form-group ui-col-50">
														<label class="ui-label-control ui-col ui-col-30">操作时间</label>
														<div class="ui-col ui-col-60 ui-label-txt">
															<span>{{model.operatorDate}}</span>
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
												</div>
												<div class="ui-col">
													<div class="ui-form-group ui-col-90">
														<label class="ui-label-control ui-col ui-col-20">备注</label>
														<div class="ui-col ui-col-70 ui-label-txt">
															<span>{{model.notes}}</span>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 1 && tabData[activeIndex]">
											<el-table
												:max-height="500"
											    :data="tabData[1]"
											    border
											    style="width: 100%">
											    <el-table-column
											      prop="product.productName"
											      label="品类"
											      width="100">
											    </el-table-column>
											    <el-table-column
											      prop="materialId"
											      label="材质"
											      width="100">
											    </el-table-column>
											    <el-table-column
											      prop="surfaceId"
											      label="表面"
											      width="100">
											    </el-table-column>
											    <el-table-column
											      label="规格(mm)"
											      width="150">
											      <template slot-scope="scope">
													{{ scope.row.labelThick + '*' + scope.row.labelWidth + '*' + scope.row.goodsLength }}
												  </template>
											    </el-table-column>
											    <el-table-column
											      prop="edge"
											      label="边部"
											      width="100">
											    </el-table-column>
											    <el-table-column
											      prop="mnfct.mnfctName"
											      label="厂商"
											      width="220">
											    </el-table-column>
											    <el-table-column
											      prop="amount"
											      label="数量（张/卷）"
											      width="180">
											       <template slot-scope="scope">
											       {{scope.row.amount ==null? 0 : scope.row.amount }}
											       </template>
											    </el-table-column>
											    <el-table-column
											      prop="netWeight"
											      label="重量（kg）"
											      width="180">
											       <template slot-scope="scope">
											       {{scope.row.netWeight ==null? 0 : scope.row.netWeight }}
											       </template>
											    </el-table-column>
												<el-table-column
													prop="unitContractPrice"
													label="含税单价(元/kg)"
													min-width="150">
													 <template slot-scope="scope">
											       {{scope.row.unitContractPrice ==null? 0 : scope.row.unitContractPrice }}
											       </template>
												</el-table-column>
												<el-table-column
													prop="contractMoney"
													label="含税金额(元)"
													min-width="120">
													 <template slot-scope="scope">
											       {{scope.row.contractMoney ==null? 0 : scope.row.contractMoney }}
											       </template>
												</el-table-column>
										 	</el-table>
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