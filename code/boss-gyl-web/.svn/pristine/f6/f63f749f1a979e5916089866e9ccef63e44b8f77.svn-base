<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>合同对账信息</title>
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
							<label>合同对账信息</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_CONTRACTBALANCE_EXPORT">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-export">导出Excel</button>
							</erp:privilege>
							<erp:privilege key="GYL_CONTRACTBALANCE_EDIT">
								<span data-privilege="edit"></span>
							</erp:privilege>
							<erp:privilege key="GYL_CONTRACTBALANCE_DELETE">
								<span data-privilege="delete"></span>
							</erp:privilege>
						</div>
					</div>
					<!-- title end -->
					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-col col-300 ui-border-r">
									<label class="ui-col-20 tip-label" style="width: 72px;">合同自编号：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
		                                    <component-select v-model="searchParam.dto.contractId" type="contractCode"  :search="true" :remoteseach="true" @change="fetchData()">
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
											<label class="ui-label-control pull-left">合同编号</label>
											<div class="ui-col col-160 ui-mr24 ui-ml4">
												<component-select v-model="searchParam.dto.contractId" type="contractNum"   :search="true">
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
										<div class="ui-form-group">
											<label class="ui-label-control pull-left">创建日期:</label>
											<div class="ui-col col-160 ui-mr12 ui-ml4">
												<input type="text" v-model="searchParam.dto.startCreateDate"
													class="ui-input-control daterange-start" placeholder="起始时间">
											</div>
											<div class="ui-col col-160 ui-mr12 ui-ml4">
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
										id="contractBalanceIndex" 
										@fetch-data="fetchData"
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
										:show-overflow-tooltip="true">
										 <template slot-scope="scope">
									 		{{scope.row.contract.contractCode}}
										 </template>
									</el-table-column>
									<el-table-column
										prop="contractNo"
										sortable="custom"
										label="合同编号"
										min-width="120"
										:show-overflow-tooltip="true">
										 <template slot-scope="scope">
									 		{{scope.row.contract.contractNo}}
										 </template>
									</el-table-column>
									<el-table-column
										prop="balance"
										sortable="custom"
										label="差额（元）"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<!-- <el-table-column
										prop="createUser"
										sortable="custom"
										label="创建人"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column> -->
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
<script src="${ctx}/js/contract/contractBalanceIndex.js"></script>

<!-- 模块部分公用js -->

</html>