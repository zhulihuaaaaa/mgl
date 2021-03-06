<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>余额查询</title>
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

		<section class="main-content">
			<footer class="warp-footer"></footer>
			<section class="wrapper">
				<div class="ui-row">
					<!-- title start -->
					<div class="panel-tit clearfix">
						<div class="ui-col-50 ui-pt6">
							<label>余额查询</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							
						</div>
						<erp:privilege key="GYL_CHECKINV_VIEW">
							<span data-privilege="view"></span>
						</erp:privilege>
					</div>
					<!-- title end -->

					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">供应商</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.makerId" type="mallMnfcts" :search="true" @change="fetchData()">
                                         	</component-select>
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
										<label class="ui-label-control pull-left">客户:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.customerId" type="crmClients" :search="true" :remoteseach="true" >
                                         	</component-select>
										</div>
									</div>
									<!-- <div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">创建人</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入创建人姓名" v-model="searchParam.dto.createUser">
										</div>
									</div> -->
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">创建时间</label>
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
										id="balanceIndex"
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="checkInvId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column 
										prop="makerId"
										label="供应商信息"
										min-width="150"
										:show-overflow-tooltip="true">
										 <template slot-scope="scope">
									 		{{scope.row.mnfct.mnfctName}}
										 </template>
										</el-table-column>
									<el-table-column 
										prop="customerId"
										label="客户信息"
										min-width="150"
										:show-overflow-tooltip="true">
										 <template slot-scope="scope">
									 		{{scope.row.customerName}}
										 </template>
										</el-table-column>
										<el-table-column
											label="余额（元）"
											min-width="150"
											prop="residualAmount"
											:show-overflow-tooltip="true">
										</el-table-column>
										<!-- <el-table-column
											label="创建人"
											min-width="150"
											prop="createUser"
											:show-overflow-tooltip="true">
										</el-table-column> -->
										<el-table-column
											label="创建时间"
											prop="createDate"
											width="200"
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
<script src="${ctx}/js/finance/balanceIndex.js"></script>

<!-- 模块部分公用js -->

</html>