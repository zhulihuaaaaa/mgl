<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>验货单查询</title>
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
							<label>验货单查询</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_INSINSPECTIONBILL_EXCEL">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-export">导出Excel</button>
							</erp:privilege>
						</div>
						<%-- <div class="ui-col-50 ui-txt-right">
							<erp:privilege key="CRM_CLIENT_ADD">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-add-Dialog">合同货物</button>
									<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-edit-Dialog">编辑</button>
									<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-add-product">新增货物</button>
							</erp:privilege>
						</div> --%>
					</div>
					<!-- title end -->
					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
									<label class="ui-col-10 tip-label">业务类型：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
											<!-- <select data-placeholder="业务类型" class="chosen-select"
												v-model="searchParam.dto.businessType" @change="fetchData">
												<option value="">全部</option>
												<option v-for="item of options.BusinessType" :key="item[0]"
													:value='item[0]'>{{item[1]}}</option>
											</select> -->
											<component-select v-model="searchParam.dto.businessType" type="BusinessType"  @change="fetchData()" >
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
										 	<component-select v-model="searchParam.dto.contractId" type="contractCode" :search="true" :remoteseach="true" >
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
										<label class="ui-label-control pull-left">验货状态</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.auditStatus" type="InspectionType"   >
                                         	</component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">创建时间</label>
										<div class="ui-col col-160 ui-mr12 ui-ml4">
											<input type="text" v-model="searchParam.dto.minDate"
												class="ui-input-control daterange-start" placeholder="起始时间">
										</div>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" v-model="searchParam.dto.maxDate"
												class="ui-input-control daterange-end" placeholder="结束时间">
										</div>
									</div>
								</div>
								<div class="ui-col-10 ui-txt-right">
									<button type="button"
										class="ui-btn ui-btn-primary btn-search-data"
										@click="fetchData()">
										<i class="icon-sousuo"></i>搜索
									</button>
								</div>
							</div>
						</div>

						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table id="insInspectionBillIndex"
									@detail="detail"
									@fetch-data="fetchData" :data="tableData" row-key="insInspectionBill.inspectionBillId"
									:loading="tableConfig.loading" :columns="tableConfig.columns"
									:pagination="true"> 
									<el-table-column
									prop="contractId" sortable="custom" 	label="合同自编号"
									min-width="120" :show-overflow-tooltip="true">
									<template slot-scope="scope">
									<!-- {{scope.row.contractNo}} -->
									<!-- 暂时放 -->
									<div v-if="scope.row.conContract !=null">
									{{scope.row.conContract.contractCode}}
									</div>
									</template>
									</el-table-column>
									<el-table-column
									 sortable="custom" 	label="合同编号"
									min-width="120" :show-overflow-tooltip="true">
									<template slot-scope="scope">
									
									<div v-if="scope.row.conContract !=null">
									{{scope.row.conContract.contractNo}}
									</div>
									</template>
									</el-table-column>
								<el-table-column prop="instockId" sortable="custom" label="入库单号" min-width="120">
									<template slot-scope="scope">
									{{scope.row.instockNo}}
									</template>
								</el-table-column> 
								<el-table-column
									prop="businessType"
									label="业务类型"
									min-width="110">
									<template slot-scope="scope">
									 <span  v-if="scope.row.insInspectionBill.businessType === 'H'">货押融资</span>
						             <span  v-if="scope.row.insInspectionBill.businessType === 'C'">定向销售</span>
						             <span  v-if="scope.row.insInspectionBill.businessType === 'X'">采购自销</span>
						             <span  v-if="scope.row.insInspectionBill.businessType === 'D'">仓单质押</span>
						             <span  v-if="scope.row.insInspectionBill.businessType === 'E'">商城融资</span>
						             <span  v-if="scope.row.insInspectionBill.businessType === 'F'">订单交收</span>
									</template>
								</el-table-column>
								<el-table-column 
								prop="inspectionStatus"
							 	sortable="custom" label="验货状态" min-width="80">
									<template slot-scope="scope">
									<span v-if="scope.row.insInspectionBill.inspectionStatus === 'A'">已验货</span>
									<span v-if="scope.row.insInspectionBill.inspectionStatus === 'B'">验货中</span>
									<span v-if="scope.row.insInspectionBill.inspectionStatus === 'C'">未验货</span>
									</template>
								 </el-table-column> 
								 <el-table-column prop="storageId" label="仓库" min-width="100" v-if="false">
								 	<template slot-scope="scope">
								 	<div v-if="scope.row.dictMallDepot !=null">
									{{scope.row.dictMallDepot.dptName}}
									</div>
									</template>
								 </el-table-column>
								<el-table-column prop="createDate" label="创建时间" min-width="120" sortable="custom"  >
								<template slot-scope="scope">
									{{scope.row.insInspectionBill.createDate}}
								</template>
								</el-table-column>
								<el-table-column prop="inspectionInfo" label="验货信息" min-width="120" sortable="custom"  v-if="false">
								<template slot-scope="scope">
									{{scope.row.insInspectionBill.inspectionInfo}}
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
<script src="${ctx}/js/insinspectionbill/insInspectionBillIndex.js"></script>

<!-- 模块部分公用js -->
<style>
.ui-btn-red,.ui-btn-red:hover{
	float: right;
    margin-top: -8px;
    margin-left: 11px;
	background-color:red ;
	border-color:red
}

</style>
</html>