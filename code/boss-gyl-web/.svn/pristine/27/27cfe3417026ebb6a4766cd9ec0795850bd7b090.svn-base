<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>表面设置</title>
</head>
<body>
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
							<label>表面设置</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_BASEPROCESS_ADD">
								<button type="button" @click="add"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
							<erp:privilege key="GYL_BASEPROCESS_EDIT">
								<span data-privilege="edit"></span>
							</erp:privilege>
							<erp:privilege key="GYL_BASEPROCESS_DELETE">
								<span data-privilege="delete"></span>
							</erp:privilege>
						</div>
					</div>
					<!-- title end -->

					<div class="panel-control clearfix">

						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
										id="baseProcessIndex" 
										@fetch-data="fetchData()"
										@edit="edit"
										@delete="del"
										:data="tableData"
										row-key="processId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns">
									<el-table-column
										prop="processName"
										label="表面名称"
										min-width="120"
										:show-overflow-tooltip="true"></el-table-column>
									<el-table-column
										prop="status"
										label="状态"
										min-width="80">
										<template slot-scope="scope">
											{{scope.row.status === 'Y' ? '启用' : '禁用'}}
										</template>
									</el-table-column>
									<el-table-column
										prop="createUser"
										label="创建人"
										min-width="120"></el-table-column>
									<el-table-column
										prop="createDate"
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
<script src="${ctx}/js/baseProcess/baseProcessIndex.js"></script>

<!-- 模块部分公用js -->

</html>