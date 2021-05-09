<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>赎货结算信息审核</title>
<style type="text/css">
	.component-table .el-input-number label.error {
		display: none!important;
	}
</style>
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
							<label>结算赎货申请审核</label>
						</div>
					</div>
					<!-- title end -->

					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
									<label class="ui-col-10 tip-label">货物来源：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
											 <component-select v-model="searchParam.dto.goodsSource" type="GoodsSource"  @change="fetchData()" >
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
								<div class="ui-col-90">
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">赎货客户</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.buyer" type="crmClients" :search="true" :remoteseach="true" >
                                         	</component-select> 
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">合同编号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.contractId" type="contractNum" :search="true"  >
                                         	</component-select> 
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">合同自编号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.contractId" type="contractCode" :search="true" :remoteseach="true" >
                                         	</component-select> 
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
										<label  class="ui-label-control pull-left">创建时间</label>
										<div class="ui-col col-160 ui-mr12 ui-ml4">
											<input type="text" v-model="searchParam.dto.startCreateDate"
												class="ui-input-control daterange-start" placeholder="起始时间">
										</div>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" v-model="searchParam.dto.endCreateDate"
												class="ui-input-control daterange-end" placeholder="结束时间">
										</div>
									</div>
								</div>
								<div class="ui-col-10 ui-txt-right">
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
										id="redRedeemBillIndex" 
										@fetch-data="fetchData"
										:data="tableData"
										@detail="detail"
										row-key="redeemBillId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										show-overflow-tooltip
										prop="contractCode"
										sortable="custom"
										label="合同自编号"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.contractCode}}
										</template>
										</el-table-column>
									<el-table-column
										prop="redeemBillCode"
										sortable="custom"
										label="赎货单号"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.redeemBillCode}}
										</template>
										</el-table-column>
										<el-table-column
										prop="dictMallDepot.dptName"
										sortable="custom"
										label="仓库名"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.dictMallDepot.dptName}}
										</template>
										</el-table-column>
									<el-table-column
										prop="auditStatus"
										sortable="custom"
										label="审核状态"
										min-width="120">
										<template slot-scope="scope">
											{{approvalStateMap[scope.row.auditStatus]}}
										</template>
										</el-table-column>
										<el-table-column 
										prop="redeemStatus"
										sortable="custom"
										label="赎货状态"
										min-width="120">
										<template slot-scope="scope">
											{{redeemBillState[scope.row.redeemStatus]}}
										</template>
										</el-table-column> 
									<el-table-column
										prop="buyerId"
										sortable="custom"
										label="赎货客户"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.buyerName}}
										</template>
										</el-table-column>
									<el-table-column
										prop="goodsSource"
										label="货物来源"
										min-width="80">
										<template slot-scope="scope">
											{{goodsSourceMap[scope.row.goodsSource]}}
										</template>
									</el-table-column>
								    <el-table-column
										prop="totalWeight"
										sortable="custom"
										label="货物总重量"
										min-width="140">
										<template slot-scope="scope">
											{{scope.row.totalWeight ==null ? 0 :scope.row.totalWeight + '吨'}}
										</template>
									</el-table-column>
									<el-table-column
										prop="consignee"
										sortable="custom"
										label="提货人"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.consignee}}
										</template>
									</el-table-column>
									<el-table-column
										prop="consigneeTel"
										sortable="custom"
										label="提货人电话"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.consigneeTel}}
										</template>
									</el-table-column>
									<el-table-column
										show-overflow-tooltip
										prop="consigneeIdNo"
										sortable="custom"
										label="提货人身份证号"
										min-width="150">
										<template slot-scope="scope">
											{{scope.row.consigneeIdNo}}
										</template>
									</el-table-column>
									<el-table-column
										prop="createUser"
										label="创建人"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.createUser}}
										</template>
									</el-table-column>
									<el-table-column
										show-overflow-tooltip
										prop="createDate"
										sortable="custom"
										label="创建时间"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.createDate}}
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
<script src="${ctx}/js/redRedeem/redRedeemBillBalanceIndex.js"></script>

<!-- 模块部分公用js -->

</html>