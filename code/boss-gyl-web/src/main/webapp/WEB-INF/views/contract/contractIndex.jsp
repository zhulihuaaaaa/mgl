<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>合同管理</title>
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
							<label>合同管理</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_CONTRACT_ADD">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
							<erp:privilege key="GYL_CONTRACT_EXCEL">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-export">导出Excel</button>
							</erp:privilege>
							<erp:privilege key="GYL_CONTRACT_EDIT">
								<span data-privilege="edit"></span>
							</erp:privilege>
							<erp:privilege key="GYL_CONTRACT_DELETE">
								<span data-privilege="delete"></span>
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
		                                    <component-select v-model="searchParam.dto.contractType" type="BusinessType" @change="fetchData()">
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
										<label class="ui-label-control pull-left">合同自编号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
												 <component-select v-model="searchParam.dto.contractId" type="contractCode"  :search="true" :remoteseach="true">
                                       			 </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">合同编号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.contractId" type="contractNum"   :search="true">
                                       			 </component-select>
                                       			 
										</div>
									</div>
										<div class="ui-form-group pull-left">
											<label class="ui-label-control pull-left">甲方:</label>
											<div class="ui-col col-160 ui-mr24 ui-ml4">
												<component-select v-model="searchParam.dto.sellerId" type="PartyA" :search="true">
	                                         	</component-select>
											</div>
										</div>
										<div class="ui-form-group pull-left">
											<label class="ui-label-control pull-left">乙方:</label>
											<div class="ui-col col-160 ui-mr24 ui-ml4">
												<component-select v-model="searchParam.dto.buyerId" type="crmClients" :search="true" :remoteseach="true" >
	                                         	</component-select>
											</div>
										</div>
										<div class="ui-form-group pull-left">
											<label class="ui-label-control pull-left">供应方:</label>
											<div class="ui-col col-160 ui-mr12 ui-ml4">
												 <component-select v-model="searchParam.dto.mallMnfct" type="mallMnfcts"  >
	                                         	</component-select>
											</div>
										</div>
										<div class="ui-form-group pull-left">
											<label class="ui-label-control pull-left">合约状态:</label>
											<div class="ui-col col-160 ui-mr24 ui-ml4">
			                                     <component-select v-model="searchParam.dto.contractState" type="ContractBillState"  >
	                                         	</component-select>
											</div>
										</div>
										
											<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">签订日期:</label>
										<div class="ui-col col-160 ui-mr12 ui-ml4">
											<input type="text" v-model="searchParam.dto.startSignDate"
												class="ui-input-control daterange-start" placeholder="起始时间">
										</div>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" v-model="searchParam.dto.endSignDate"
												class="ui-input-control daterange-end" placeholder="结束时间">
										</div>
									</div>
										<div class="ui-form-group">
											<label class="ui-label-control pull-left">创建日期:</label>
											<div class="ui-col col-160 ui-mr12 ui-ml4">
												<input type="text" v-model="searchParam.dto.startCreateDate"
													class="ui-input-control daterange-start1" placeholder="起始时间">
											</div>
											<div class="ui-col col-160 ui-mr12 ui-ml4">
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
										id="contractIndex" 
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="contractId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:operation="tableConfig.operation"
										module="contract"
										:pagination="true">
									<el-table-column
										prop="contractCode"
										sortable="custom"
										label="合同自编号"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="contractNo"
										sortable="custom"
										label="合同编号"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="signDate"
										sortable="custom"
										label="签订日期"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="contractType"
										sortable="custom"
										label="业务类型"
										min-width="120"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ scope.row.contractTypeName }}
											</template>
										</el-table-column>
									<el-table-column
										prop="seller.companyName"
										label="甲方"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="buyer.clientName"
										label="乙方"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										label="供应方"
										min-width="120"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ scope.row.mnfct != null ? scope.row.mnfct.mnfctName : '' }}
											</template>
										</el-table-column>
									<el-table-column
										prop="contractState"
										sortable="custom"
										label="合约状态"
										min-width="120"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
												{{ scope.row.contractStateName }}
											</template>
									</el-table-column>
									<el-table-column
										sortable="custom"
										label="货物总重量(吨)"
										width="180"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ util.formatNumber((scope.row.totalWeight / 1000), 3) }}
											</template>
										</el-table-column>
									<el-table-column
										sortable="custom"
										label="货物总价(万)"
										min-width="160"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ util.formatNumber((scope.row.totalMoney / 10000), 2) }}
											</template>
										</el-table-column>
									<el-table-column
										sortable="custom"
										label="保证金(万)"
										min-width="120"
										:show-overflow-tooltip="true">
											<template slot-scope="scope">
												{{ util.formatNumber((scope.row.depositFee / 10000), 2) }}
											</template>
										</el-table-column>
									<el-table-column
										prop="contractPeriod"
										sortable="custom"
										label="合同期限(天)"
										min-width="140"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="createUser"
										sortable="custom"
										label="创建人"
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
<script src="${ctx}/js/contract/contractIndex.js"></script>

<!-- 模块部分公用js -->

</html>