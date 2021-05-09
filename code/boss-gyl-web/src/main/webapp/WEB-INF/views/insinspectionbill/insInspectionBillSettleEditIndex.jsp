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
							<label>结算货物交收审核</label>
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
											<!-- <select data-placeholder="业务类型"
                                                 class="chosen-select"
                                                 v-model="searchParam.dto.businessType" @change="fetchData">
                                                 <option value="">全部</option>
                                                 <option v-for="item of options.BusinessType" :key="item[0]" :value='item[0]'>{{item[1]}}</option>
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
										<label class="ui-label-control pull-left">验收子单号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											 <component-select v-model="searchParam.dto.subCode" type="subCode"  :search="true" :remoteseach="true"  >
                                         	</component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">创建人</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<!-- <component-select v-model="searchParam.dto.createUser" type="crmClients" :search="true" :remoteseach="true" >
                                        	</component-select> -->
                                        	<input type="text" class="ui-input-control"
												placeholder="请输入创建人姓名" v-model="searchParam.dto.createUser">
										</div>
									</div>
									
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
										class="ui-btn ui-btn-primary btn-search-data"  @click="fetchData()">
										<i class="icon-sousuo"></i>搜索
									</button>
								</div>
							</div>
						</div>
						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
										id="insInspectionBillSettleEditIndex"
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="productId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										prop="contractNo"
										label="合同自编号"
										min-width="120"
										:show-overflow-tooltip="true">
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
										<el-table-column
											prop="businessType"
											label="业务类型"
											min-width="110">
											<template slot-scope="scope">
											 <span  v-if="scope.row.insInspectionSub.businessType === 'H'">货押融资</span>
								             <span  v-if="scope.row.insInspectionSub.businessType === 'C'">定向销售</span>
								             <span  v-if="scope.row.insInspectionSub.businessType === 'X'">采购自销</span>
								             <span  v-if="scope.row.insInspectionSub.businessType === 'D'">仓单质押</span>
								             <span  v-if="scope.row.insInspectionSub.businessType === 'E'">商城融资</span>
								             <span  v-if="scope.row.insInspectionSub.businessType === 'F'">订单交收</span>
											</template>
										</el-table-column>
									<el-table-column
										prop="subCode"
										sortable="custom"
										label="子单单号"
										min-width="120">
										<template slot-scope="scope">
										 {{scope.row.insInspectionSub.subCode}}
										</template>
										</el-table-column>
									<el-table-column
										prop="createUser"
										sortable="custom"
										label="创建人"
										min-width="120">
										<template slot-scope="scope">
										 {{scope.row.insInspectionSub.createUser}}
										</template>
										</el-table-column>
									<el-table-column
										prop="instockDate"
										label="入库日期"
										min-width="100">
										<template slot-scope="scope">
										 {{scope.row.insInspectionSub.instockDate}}
										</template>
										
										</el-table-column>
									<el-table-column
										prop="auditStatus"
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
										v-if="false"
										prop="warranty"
										label="质保书"
										min-width="80">
										<template slot-scope="scope">
												<div v-if="scope.row.warrantyList != null">
													<span v-for="item in scope.row.warrantyList">
														<img v-if="item != null && item != ''" :src="item.filePath" style="width: 100%"/>
													</span>
												</div>
										</template>
									</el-table-column>
									<el-table-column
										v-if="false"
										prop="inventoryVoucher"
										label="存货凭证"
										min-width="120">
										<template slot-scope="scope">
												<div v-if="scope.row.inventoryVoucherList != null">
													<span v-for="item in scope.row.inventoryVoucherList">
														<img v-if="item != null && item != ''" :src="item.filePath" style="width: 100%"/>
													</span>
												</div>
										</template>
										</el-table-column>
									<el-table-column
										prop="voucherNo"
										sortable="custom"
										label="存货凭证编号"
										min-width="120">
										<template slot-scope="scope">
											{{scope.row.insInspectionSub.voucherNo}}
										</template>
										</el-table-column>
									<el-table-column
										prop="createDate"
										sortable="custom"
										label="创建时间"
										min-width="140">
										<template slot-scope="scope">
											{{scope.row.insInspectionSub.createDate}}
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
<script src="${ctx}/js/insinspectionbill/insInspectionBillSettleEditIndex.js"></script>

<!-- 模块部分公用js -->

</html>