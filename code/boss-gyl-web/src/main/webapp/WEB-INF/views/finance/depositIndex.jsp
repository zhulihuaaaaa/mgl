<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>保证金查询</title>
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
							<label>保证金查询</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
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
										<label class="ui-label-control pull-left">客户信息:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.buyerId" type="crmClients" :search="true" :remoteseach="true">
                                         	</component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">关联合同信息:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.contractId" type="contractCode" :search="true" :remoteseach="true">
                                         	</component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">关联保证金财务单:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.financeId" type="financeCode" :search="true" :remoteseach="true">
                                         	</component-select>
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
										id="depositIndex" 
										@fetch-data="fetchData()"
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
												{{ scope.row.contract != null ? scope.row.contract.contractCode : '' }}
											</template>
										</el-table-column>
									<el-table-column
										prop="financeId"
										sortable="custom"
										label="关联保证金财务单"
										min-width="120"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ scope.row.finance != null ? scope.row.finance.financeCode : '' }}
											</template>
										</el-table-column>
									<el-table-column
										prop="buyerId"
										sortable="custom"
										label="客户信息"
										min-width="120"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ scope.row.crmClient != null ? scope.row.crmClient.clientName : '' }}
											</template>
										</el-table-column>
									<el-table-column
										prop="depositFee"
										sortable="custom"
										label="保证金金额"
										min-width="120"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ scope.row.depositFee != null ? scope.row.depositFee : 0 }}
											</template>
										</el-table-column>
									<el-table-column
										prop="balance"
										sortable="custom"
										label="剩余金额"
										min-width="120"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
												{{ scope.row.balance != null ? scope.row.balance : 0 }}
											</template>
										</el-table-column>
									<el-table-column
										prop="createDate"
										sortable="custom"
										label="创建日期"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="createUser"
										sortable="custom"
										label="创建人"
										min-width="100"
										:show-overflow-tooltip="true">
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
<script src="${ctx}/js/finance/depositIndex.js"></script>

<!-- 模块部分公用js -->

</html>