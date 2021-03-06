<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>逾期申请审核</title>
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
							<label>逾期申请审核</label>
						</div>
					</div>
					<!-- title end -->

					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">	
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
								    <label class="ui-col-10 tip-label">合同编号：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
											<component-select v-model="searchParam.dto.contractId" type="contractNum"  :search="true" >
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
												 <component-select v-model="searchParam.dto.contractId" type="contractCode"  :search="true" :remoteseach="true">
                                       			 </component-select>
										</div>
									</div>
									 <div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">逾期天数</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入逾期天数" v-model="searchParam.dto.overdueDays">
										</div>
									</div> 
									<div class="ui-form-group pull-left">
											<label class="ui-label-control pull-left">延期天数</label>
											<div class="ui-col col-160 ui-mr24 ui-ml4">
												<input type="text" class="ui-input-control"
													placeholder="请输入延期天数" v-model="searchParam.dto.deferDays">
											</div>
										</div> 
										<div class="ui-form-group pull-left">
											<label class="ui-label-control pull-left">手续费率</label>
											<div class="ui-col col-160 ui-mr24 ui-ml4">
												<input type="text" class="ui-input-control"
													placeholder="请输入手续费率" v-model="searchParam.dto.commissionRate">
											</div>
										</div> 
										<!-- <div class="ui-form-group pull-left">
												<label class="ui-label-control pull-left">审核状态</label>
												<div class="ui-col col-160 ui-mr24 ui-ml4">
													<input type="text" class="ui-input-control"
														placeholder="请输入延期天数" v-model="searchParam.dto.auditStatus">
												</div>
											</div>  -->

									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">创建日期</label>
										<div class="ui-col col-160 ui-mr12 ui-ml4">
											<input type="text" v-model="searchParam.dto.createStartDate"
												class="ui-input-control daterange-start" placeholder="起始时间">
										</div>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" v-model="searchParam.dto.createEndDate"
												class="ui-input-control daterange-end" placeholder="结束时间">
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
										id="overdueDeferId" 
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="overdueDeferId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										show-overflow-tooltip
										prop="contract.contractCode"
										sortable="custom"
										label="合同自编号"
										min-width="120">
									</el-table-column>
									<el-table-column
										prop="contract.contractNo"
										sortable="custom"
										label="合同编号"
										min-width="140"
										:show-overflow-tooltip="true">
									</el-table-column>
									<el-table-column
										prop="overdueDays"
										label="逾期天数"
										min-width="120">
									</el-table-column>
									<el-table-column
										prop="deferDays"
										label="延期天数"
										min-width="120">
									</el-table-column>
									<el-table-column
										prop="commissionRate"
										label="手续费率"
										min-width="120">
									</el-table-column>
									<el-table-column
										label="审核状态"
										min-width="120">
										<template slot-scope="scope">
											{{approvalStateMap[scope.row.auditStatus]}}
										</template>
									</el-table-column>
									<el-table-column
										prop="notes"
										label="备注"
										min-width="120">
									</el-table-column>
									<el-table-column
									prop="createUser"
									label="创建人"
									min-width="120">
									</el-table-column>
									<el-table-column
										prop="createDate"
										label="创建时间"
										min-width="160">
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
<script src="${ctx}/js/overdue/overdueApply.js"></script>

</html>