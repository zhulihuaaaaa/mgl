<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>货物交收审核</title>
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
							<label>货物交收审核</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="CRM_CLIENT_ADD">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
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
											<select data-placeholder="业务类型"
                                                 class="chosen-select"
                                                 v-model="searchParam.dto.businessType" @change="fetchData">
                                                 <option value="">全部</option>
                                                 <option v-for="item of options.BusinessType" :key="item[0]" :value='item[0]'>{{item[1]}}</option>
                                             </select>
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
										<label class="ui-label-control pull-left">验收子单号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入验收子单号" v-model="searchParam.dto.subCode">
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">创建人</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入创建人" v-model="searchParam.dto.createUser">
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
										class="ui-btn ui-btn-primary btn-search-data"  @click="fetchData">
										<i class="icon-sousuo"></i>搜索
									</button>
								</div>
							</div>
						</div>
						<div class="ui-col">
							<div class="main-cnt-scroll">
								<component-table
										id="insInspectionBillEditIndex" 
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="productId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										prop="contractNo"
										sortable="custom"
										label="合同自编号"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="insInspectionSub.subCode"
										sortable="custom"
										label="子单单号"
										min-width="120"></el-table-column>
									<el-table-column
										prop="insInspectionSub.createUser"
										sortable="custom"
										label="创建人"
										min-width="120"></el-table-column>
									<el-table-column
										prop="insInspectionSub.instockDate"
										label="入库日期"
										min-width="100"></el-table-column>
									<el-table-column
										prop="insInspectionSub.auditStatus"
										label="审核状态"
										min-width="120">
										<template slot-scope="scope">
										 <span  v-if="scope.row.insInspectionSub.auditStatus === 'A'">未审批</span>
							             <span  v-if="scope.row.insInspectionSub.auditStatus === 'B'">审批中</span>
							             <span  v-if="scope.row.insInspectionSub.auditStatus === 'C'">已拒绝</span>
							             <span  v-if="scope.row.insInspectionSub.auditStatus === 'D'">已通过</span>
							             <span  v-if="scope.row.insInspectionSub.auditStatus === 'E'">已作废</span>
										</template>
										</el-table-column>
									<el-table-column
										prop="status"
										sortable="custom"
										label="保质书"
										min-width="80">
										<template slot-scope="scope">
											<div v-if="scope.row.warranty != null">
											<img :src="scope.row.warranty['filePath']">
											</div>
										</template>
									</el-table-column>
									<el-table-column
										sortable="custom"
										label="存货凭证"
										min-width="120">
										<template slot-scope="scope">
											<div v-if="scope.row.inventoryVoucher != null">
											<img :src="scope.row.inventoryVoucher['filePath']">
											</div>
										</template>
										</el-table-column>
									<el-table-column
										prop="insInspectionSub.voucherNo"
										sortable="custom"
										label="存货凭证编号"
										min-width="120"></el-table-column>
									<el-table-column
										prop="insInspectionSub.createDate"
										sortable="custom"
										label="创建时间"
										min-width="120"></el-table-column>
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
<script src="${ctx}/js/insinspectionbill/insInspectionBillEditIndex.js"></script>

<!-- 模块部分公用js -->

</html>