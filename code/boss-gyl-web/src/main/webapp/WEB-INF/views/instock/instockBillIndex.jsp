<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>入库管理</title>
</head>
<body>
<!-- 绑定侧边栏vue -->
<div id='slideEidt'></div>
	<section id="container">
		<!--header start-->
		<%@include file="../include/navgation.jsp"%>
		<!--header end-->

		<!--sidebar start-->
		<%@include file="../include/left_menu.jsp"%>
		<!--sidebar end-->

		<section class="main-content">
			<footer class="warp-footer"></footer>
			<section class="wrapper">
				<div class="ui-row">
					<!-- title start -->
					<div class="panel-tit clearfix">
						<div class="ui-col-50 ui-pt6">
							<label>入库管理</label>
						</div>
						<%-- <div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_INSTOCKBILL_ADD">
								<button type="button" @click="add"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
						</div> --%>
					</div>
					<!-- title end -->
					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">	
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
									<label class="ui-col-10 tip-label">业务类型：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
                                             <component-select v-model="searchParam.dto.businessType" type="BusinessType"  @change="fetchData()" >
                                         	 </component-select>
										</div>
									</div>
								</div>
								<div class="ui-col col-240 ui-ml28">
									<button type="button"
										class="ui-btn btn-opt-link btn-opt-screen">
										<i class="icon-paixujiang"></i>筛选
									</button>
								</div>
							</div>
							<div class="ui-col search-criter ui-hidden">
								<div class="ui-col-70">
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">合同自编号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										<!-- 	<input type="text" class="ui-input-control"
												placeholder="请输入合同编号" v-model="searchParam.dto.contractNo"> -->
												 <component-select v-model="searchParam.dto.contractId" type="contractCode"  :search="true" :remoteseach="true">
                                       			 </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">合同编号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.contractId" type="contractNum"  :search="true" >
                                       			 </component-select>
                                       			 
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">入库单号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入入库单号" v-model="searchParam.dto.instockCode">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">创建人</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入创建人姓名" v-model="searchParam.dto.createUser">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">入库单状态</label>
									</div>
									<div class="ui-form-group pull-left">
									<div class="ui-col col-160 ui-mr24 ui-ml4">
                                        <component-select v-model="searchParam.dto.instockStatus" type="InstockState" :search="true"  @change="fetchData()" >
                                        </component-select>
                                     </div>
                                     </div>
								</div>
								<div class="ui-col-30 ui-txt-right">
									<button type="button"
										class="ui-btn ui-btn-primary btn-search-data" @click="fetchData()">
										<i class="icon-sousuo"></i>搜索
									</button>
								</div>
							</div>
						</div>

						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
										id="instockBillIndex" 
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="instockBillId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										show-overflow-tooltip
										prop="contractId"
										sortable="custom"
										label="合同自编号"
										min-width="120">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.contractCode)}}
										</template>
									</el-table-column>
									<el-table-column
										prop="instockCode"
										sortable="custom"
										label="入库单号"
										min-width="140"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.bill.instockCode)}}
										</template>
									</el-table-column>
									<el-table-column
										prop="depositStatus"
										label="保证金状态 "
										min-width="120">	
										<template slot-scope="scope">
										<span v-if="scope.row.bill.businessType != 'X' && scope.row.bill.businessType != 'D'">{{DepositStateMap[scope.row.bill.depositStatus]}}</span>
										<span v-else>--</span>
										</template>
									</el-table-column>
									<el-table-column
										prop="inspectionStatus"
										label="验货入库状态   "
										min-width="120">
										<template slot-scope="scope">
										{{util.replaceSpace(InspectionStateMap[scope.row.bill.inspectionStatus])}}
										</template>
									</el-table-column>
									<el-table-column
										prop="financingLoanStatus"
										label="融资货款状态   "
										min-width="120">
										<template slot-scope="scope">
											<span v-if="scope.row.bill.businessType == 'H'">{{GoodsPaymentStateMap[scope.row.bill.financingLoanStatus]}}</span>
											<span v-else>--</span>
										</template>
									</el-table-column>
									<el-table-column
										prop="paymentStatus"
										label="钢厂货款状态   "
										min-width="120">
										<template slot-scope="scope">
										<span v-if="scope.row.bill.businessType == 'C'  ||scope.row.bill.businessType == 'X'">{{util.replaceSpace(GoodsPaymentStateMap[scope.row.bill.paymentStatus])}}</span>
										<span v-else>--</span>
										</template>
									</el-table-column>
									<el-table-column
										prop="businessType"
										sortable="custom"
										label="业务类型"
										min-width="120">
										<template slot-scope="scope">
											{{util.replaceSpace(businessTypeMap[scope.row.bill.businessType])}}
										</template>
									</el-table-column>	
									<el-table-column
										prop="instockStatus"
										label="入库单状态"
										min-width="120">
										<template slot-scope="scope">
										{{util.replaceSpace(InstockStateMap[scope.row.bill.instockStatus])}}
										</template>
									</el-table-column>
									<el-table-column
										prop="totalWeight"
										label="货物总重量（吨）"
										min-width="150">
										<template slot-scope="scope">
										{{util.replaceSpace(scope.row.totalWeight/1000)}}
										</template>
									</el-table-column>
									<el-table-column
										prop="totalMoney"
										label="货物总价（元）"
										min-width="160">
										<template slot-scope="scope">
										{{util.replaceSpace(scope.row.totalMoney)}}
										</template>
									</el-table-column>
									<el-table-column
										prop="depositFee"
										label="保证金（万元）"
										min-width="150">
										<template slot-scope="scope">
										{{util.replaceSpace(util.formatNumber((scope.row.depositFee / 10000), 2))}}
										</template>
									</el-table-column>
									<el-table-column
										prop="contractPeriod"
										label="合同期限（天）"
										min-width="120">
									</el-table-column>
									<el-table-column
										prop="createUser"
										label="创建人"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.bill.createUser}}
										</template>
									</el-table-column>
									<el-table-column
										prop="createDate"
										sortable="custom"
										label="创建时间"
										min-width="170">
										<template slot-scope="scope">
											{{scope.row.bill.createDate}}
										</template>
									</el-table-column>
								</component-table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>
	</section>
</body>
<%@include file="../include/footer.jsp"%>

<!-- 私有JS -->
<script src="${ctx}/js/instock/instockBillIndex.js"></script>

<!-- 模块部分公用js -->

</html>