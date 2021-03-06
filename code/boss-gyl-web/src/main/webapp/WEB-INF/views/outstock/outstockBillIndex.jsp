<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>提货单管理</title>
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
							<label>提货单管理</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_OUTSTOCKBILL_ADD">
								<button type="button" @click="add"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
							<erp:privilege key="GYL_OUTSTOCKBILL_EXCEL">
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
									<label class="ui-label-control pull-left">客户信息</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
											 <component-select v-model="searchParam.dto.customerId" type="crmClients" :search="true" :remoteseach="true" @change="fetchData()">
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
										<label class="ui-label-control pull-left">提货单号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入提货单号" v-model="searchParam.dto.outstockCode">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">仓库</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										  	<component-select v-model="searchParam.dto.storageId" type="DictMallDepot" depot="real">
                                         	</component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">提货人</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入提货人" v-model="searchParam.dto.consignee">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">提货单状态</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										  	<component-select v-model="searchParam.dto.outstockState" type="OutstockState" depot="real">
                                         	</component-select>
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
										id="outstockBillIndex" 
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="outstockBillId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										prop="outstockCode"
										sortable="custom"
										label="提货单号"
										min-width="120"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
											{{scope.row.outOutstockBill.outstockCode}}
										</template>
										</el-table-column>
									<el-table-column
										prop="customerId"
										label="客户信息"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.clientName}}
										</template>
									</el-table-column>
									<el-table-column
										prop="storageId"
										label="存放仓库"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.storageName}}
										</template>
									</el-table-column>
									<el-table-column
										prop="consignee"
										label="提货人"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.outOutstockBill.consignee}}
										</template>
									</el-table-column>
									<el-table-column
										prop="consigneeTel"
										label="提货人电话"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.outOutstockBill.consigneeTel}}
										</template>
									</el-table-column>
									<el-table-column
										prop="consigneeIdNo"
										label="提货人身份证号"
										min-width="120"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
											{{scope.row.outOutstockBill.consigneeIdNo}}
										</template>
									</el-table-column>
									<el-table-column
										prop="createUser"
										label="创建人"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.outOutstockBill.createUser}}
										</template>
									</el-table-column>
									<el-table-column
										prop="createDate"
										sortable="custom"
										label="创建时间"
										min-width="170">
										<template slot-scope="scope">
											{{scope.row.outOutstockBill.createDate}}
										</template>
									</el-table-column>
									<el-table-column
										prop="outstockStateName"
										sortable="custom"
										label="提货状态"
										min-width="170">
										<template slot-scope="scope">
											{{scope.row.outstockStateName}}
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
<script src="${ctx}/js/outstock/outstockBillIndex.js"></script>

<!-- 模块部分公用js -->

</html>