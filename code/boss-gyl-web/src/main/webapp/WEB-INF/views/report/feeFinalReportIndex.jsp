<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>期末期初报表</title>
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
							<label>期末期初报表</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<button type="button" @click="add"
								class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
					</div>
					</div>
					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">	
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
								    <label class="ui-col-10 tip-label">创建人：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
											 <input type="text" class="ui-input-control"
												placeholder="请输入创建人名称" v-model="searchParam.dto.createUser">
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
										id="feeFinalReportId" 
										@fetch-data="fetchData"
										:data="tableData"
										row-key="feeFinalReportId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										show-overflow-tooltip
										prop="feeUninstockTotalweight"
										sortable="custom"
										label="财务未入库总重量"
										min-width="150">
									</el-table-column>
									<el-table-column
										prop="feeUninstockTotalmoney"
										sortable="custom"
										label="财务未入库总金额"
										min-width="150"
										:show-overflow-tooltip="true">
									</el-table-column>
									<el-table-column
										prop="feeUnoutstockTotalweight"
										sortable="custom"
										label="财务未出库总重量"
										min-width="150">
									</el-table-column>
									<el-table-column
										prop="feeUninstockTotalmoney"
										sortable="custom"
										label="财务未出库总金额"
										min-width="150">
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
<script src="${ctx}/js/report/feeFinalReport.js"></script>

</html>