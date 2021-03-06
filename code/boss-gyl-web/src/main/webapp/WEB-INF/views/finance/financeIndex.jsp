<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>财务单查询</title>
</head>
<body>
	<div id='slideEidt'></div>
	<section id="container">
		<!--header start-->
		<%@include file="../include/navgation.jsp"%>
		<!--header end-->

		<!--sidebar start-->
		<%@include file="../include/left_menu.jsp"%>
		<!--sidebar end-->

		<section class="main-content" v-cloak>
			<footer class="warp-footer"></footer>
			<section class="wrapper">
				<div class="ui-row">
					<!-- title start -->
					<div class="panel-tit clearfix">
						<div class="ui-col-50 ui-pt6">
							<label>财务单查询</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_FINANCE_EXCEL">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-export">导出Excel</button>
							</erp:privilege>
						</div>
					</div>
					<!-- title end -->
					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
									<label class="ui-col-10 tip-label">业务类型：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
		                                    <component-select v-model="searchParam.dto.businessType" type="FinanceType" @change="fetchData()">
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
										<label class="ui-label-control pull-left">财务单号:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control" v-model="searchParam.dto.financeCode">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">合同自编号:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control" v-model="searchParam.dto.contractCode">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">关联单号:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control" v-model="searchParam.dto.relationCode">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">财务单状态:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.status" type="FinanceState">
                                         	</component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">资金流向:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.flwoType" type="FinanceFlwoType">
                                         	</component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">操作人:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control" v-model="searchParam.dto.operator">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">操作时间</label>
										<div class="ui-col col-160 ui-mr12 ui-ml4">
											<input type="text" v-model="searchParam.dto.startOperatorDate"
												class="ui-input-control daterange-start" placeholder="起始时间">
										</div>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" v-model="searchParam.dto.endOperatorDate"
												class="ui-input-control daterange-end" placeholder="结束时间">
										</div>
									</div>
									<div class="ui-form-group">
										<label class="ui-label-control pull-left">创建时间</label>
										<div class="ui-col col-160 ui-mr12 ui-ml4">
											<input type="text" v-model="searchParam.dto.startCreateDate"
												class="ui-input-control daterange-start1" placeholder="起始时间">
										</div>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" v-model="searchParam.dto.endCreateDate"
												class="ui-input-control daterange-end1" placeholder="结束时间">
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
<%-- 						<div class="ui-col ui-mb16">
								<label class="ui-col-10 tip-label">操作：</label>
								<div class="ui-col ui-col-90">
									<button type="button"
										class="ui-btn btn-opt-link btn-opt-dis ui-mr12 btn-client-back"
										disabled>退回</button>
									<erp:privilege key="CRM_CLIENT_CHANGEPRINCIPAL">
										<button type="button"
											class="ui-btn btn-opt-link btn-opt-dis ui-mr12 btn-client-principal"
											disabled>更换负责人</button>
									</erp:privilege>
									<erp:privilege key="CRM_CLIENT_ADDFOLLOW">
										<button type="button"
											class="ui-btn btn-opt-link btn-opt-dis ui-mr12 btn-client-follower"
											disabled>添加联合跟进人</button>
									</erp:privilege>
								</div>
							</div> --%>
						</div>

						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
										id="financeIndex" 
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="financeCode"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										prop="contractId"
										sortable="custom"
										label="合同自编号"
										min-width="120"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ scope.row.contract.contractCode }}
											</template>
										</el-table-column>
										<el-table-column
										label="合同编号"
										min-width="120"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ scope.row.contract.contractNo }}
											</template>
										</el-table-column>
									<el-table-column
										prop="financeCode"
										sortable="custom"
										label="财务单号"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="relationCode"
										sortable="custom"
										label="关联单号"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="flwoType"
										sortable="custom"
										label="资金流向"
										min-width="120"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
											{{ scope.row.flwoType == "A" ? "进账" : "出账" }}
										</template>
									</el-table-column>
									<el-table-column
										prop="businessType"
										sortable="custom"
										label="业务类型"
										min-width="130"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
											{{ scope.row.businessTypeName }}
										</template>
									</el-table-column>
									<el-table-column
										prop="actualAmount"
										sortable="custom"
										label="实际金额(元)"
										min-width="180"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="realMoney"
										sortable="custom"
										label="待付总金额(元)"
										min-width="180"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="status"
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
										sortable="custom"
										label="操作员"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="operatorDate"
										sortable="custom"
										label="操作时间"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="createDate"
										sortable="custom"
										label="创建时间"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
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
<script src="${ctx}/js/finance/financeIndex.js"></script>

<!-- 模块部分公用js -->

</html>