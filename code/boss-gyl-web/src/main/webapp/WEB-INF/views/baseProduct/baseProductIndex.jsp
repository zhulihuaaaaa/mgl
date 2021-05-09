<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>品类设置</title>
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
							<label>品类设置</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_BASEPRODUCT_ADD">
								<button type="button" @click="add"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
							<erp:privilege key="GYL_BASEPRODUCT_EDIT">
								<span data-privilege="edit"></span>
							</erp:privilege>
							<erp:privilege key="GYL_BASEPRODUCT_DELETE">
								<span data-privilege="delete"></span>
							</erp:privilege>
						</div>
					</div>
					<!-- title end -->

					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
									<label class="ui-col-10 tip-label">品类：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
											<input type="text" class="ui-input-control"
												placeholder="请输入品类" v-model="searchParam.dto.productName">
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
										<label class="ui-label-control pull-left">创建人</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入创建人姓名" v-model="searchParam.dto.createUser">
										</div>
									</div>
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
<!-- 							<div class="ui-col ui-mb16"> -->
<!-- 								<label class="ui-col-10 tip-label">操作：</label> -->
<!-- 								<div class="ui-col ui-col-90"> -->
<!-- 									<button type="button" -->
<!-- 										class="ui-btn btn-opt-link btn-opt-dis ui-mr12 btn-client-back" -->
<!-- 										disabled>退回</button> -->
<%-- 									<erp:privilege key="CRM_CLIENT_CHANGEPRINCIPAL"> --%>
<!-- 										<button type="button" -->
<!-- 											class="ui-btn btn-opt-link btn-opt-dis ui-mr12 btn-client-principal" -->
<!-- 											disabled>更换负责人</button> -->
<%-- 									</erp:privilege> --%>
<%-- 									<erp:privilege key="CRM_CLIENT_ADDFOLLOW"> --%>
<!-- 										<button type="button" -->
<!-- 											class="ui-btn btn-opt-link btn-opt-dis ui-mr12 btn-client-follower" -->
<!-- 											disabled>添加联合跟进人</button> -->
<%-- 									</erp:privilege> --%>
<!-- 								</div> -->
<!-- 							</div> -->
						</div>

						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
										id="baseProductIndex" 
										@fetch-data="fetchData"
										@edit="edit"
										@delete="del"
										:data="tableData"
										row-key="productId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										prop="productName"
										sortable="custom"
										label="品类名称"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="quantityUnit"
										sortable="custom"
										label="数量单位"
										min-width="120"></el-table-column>
									<el-table-column
										prop="weightUnit"
										sortable="custom"
										label="重量单位"
										min-width="120"></el-table-column>
									<el-table-column
										prop="precision"
										label="精确度"
										min-width="100"></el-table-column>
									<el-table-column
										prop="unitRate"
										label="单位进率"
										min-width="120"></el-table-column>
									<el-table-column
										prop="status"
										sortable="custom"
										label="状态"
										min-width="80">
										<template slot-scope="scope">
											{{scope.row.status === 'Y' ? '启用' : '禁用'}}
										</template>
									</el-table-column>
									<el-table-column
										prop="createUser"
										sortable="custom"
										label="创建人"
										min-width="120"></el-table-column>
									<el-table-column
										prop="createDate"
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
<script src="${ctx}/js/baseProduct/baseProductIndex.js"></script>

<!-- 模块部分公用js -->

</html>