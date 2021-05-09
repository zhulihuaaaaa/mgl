<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>赎货设置</title>
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
		<%@include file="../include/navgation.jsp"%>
		<%@include file="../include/left_menu.jsp"%>
		<section class="main-content">
			<footer class="warp-footer"></footer>
			<section class="wrapper">
				<div class="ui-row">
					<div class="panel-tit clearfix">
						<div class="ui-col-50 ui-pt6">
							<label>赎货单查询</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_REDREDEEM_ADD">
								<button type="button" @click="add"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
							<erp:privilege key="GYL_REDREDEEM_EXCEL">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-export">导出Excel</button>
							</erp:privilege>
						</div>
					</div>
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
											<component-select v-model="searchParam.dto.buyerId" type="crmClients" :search="true" :remoteseach="true" >
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
										show-overflow-tooltip
										prop="contractNo"
										sortable="custom"
										label="合同编号"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.contractNo}}
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
											{{scope.row.auditStatus === null ? '未提交' : approvalStateMap[scope.row.auditStatus]}}
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
											{{util.replaceSpace(scope.row.totalWeight,'0')}}吨
										</template>
									</el-table-column>
									<el-table-column
										prop="totalGoodsPayment"
										sortable="custom"
										label="货物总价（元）"
										min-width="180">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.totalGoodsPayment,'0')}}
										</template>
									</el-table-column>
									<el-table-column
										prop="commissionFee"
										sortable="custom"
										label="手续费（元）"
										min-width="180">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.commissionFee,'0')}}
										</template>
									</el-table-column>
									<el-table-column
										prop="invoiceFee"
										sortable="custom"
										label="开票费（元）"
										min-width="180">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.invoiceFee,'0')}}
										</template>
									</el-table-column>
									<el-table-column
										prop="otherFee"
										sortable="custom"
										label="其他费用（元）"
										min-width="180">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.otherFee,'0')}}
										</template>
									</el-table-column>
									<el-table-column
										prop="depositFee"
										sortable="custom"
										label="保证金抵消金额（元）"
										min-width="220">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.depositFee,'0')}}
										</template>
									</el-table-column>
									<el-table-column
										prop="totalMoney"
										sortable="custom"
										label="总金额（元）"
										min-width="160">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.totalMoney,'0')}}
										</template>
									</el-table-column>
									<el-table-column
										prop="realMoney"
										sortable="custom"
										label="待付总金额（元）"
										min-width="160">
										<template slot-scope="scope">
											{{util.replaceSpace(scope.row.realMoney,'0')}}
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
										show-overflow-tooltip
										prop="carNumber"
										sortable="custom"
										label="车牌号"
										min-width="150">
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
<script src="${ctx}/js/redRedeem/redRedeemBillIndex.js"></script>

<!-- 模块部分公用js -->

</html>