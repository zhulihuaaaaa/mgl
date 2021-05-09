<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>审批流程管理</title>
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
							<label>审批流程管理</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<button type="button"
								class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
						</div>
					</div>
					<!-- title end -->
					<div class="panel-control clearfix">
						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
									@fetch-data="fetchData"
									:data="tableData.list"
									:columns="tableConfig.columns"
									@edit="edit"
									@delete="del"
								>
									<el-table-column
										prop="name"
										label="流程模块"
										min-width="50">
										<template slot-scope="scope">
										<span>{{scope.row.name}}</span>
										</template>
										</el-table-column>
									<el-table-column
										prop="step"
										label="流程步骤"
										min-width="120">
										<template slot-scope="scope">
										 	<el-steps  finish-status="wait" :space="150">								
										 	 	<el-step v-for="step of scope.row.step" :key="step.process.approvalProcessId" >
										 	 		<span slot="title" style="font-size: 14px;color: #606266">{{step.privRole.roleName}}</span>
										 	 	</el-step>
											</el-step>
										</el-steps>
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
<script src="${ctx}/js/baseApprove/baseApproveIndex.js"></script>

<!-- 模块部分公用js -->

</html>