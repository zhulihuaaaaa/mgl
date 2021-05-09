<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>甲方设置</title>
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
							<label>甲方设置</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_BASECOMPANY_ADD">
								<button type="button" @click="add"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
							<erp:privilege key="GYL_BASECOMPANY_EDIT">
								<span data-privilege="edit"></span>
							</erp:privilege>
							<erp:privilege key="GYL_BASECOMPANY_DELETE">
								<span data-privilege="delete"></span>
							</erp:privilege>
						</div>
					</div>
					<!-- title end -->

					<div class="panel-control clearfix">

						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
										id="baseCompanyIndex" 
										@fetch-data="fetchData()"
										@edit="edit"
										@delete="del"
										:data="tableData"
										row-key="companyId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns">
									<el-table-column
										prop="companyName"
										label="甲方公司名称"
										min-width="120"></el-table-column>
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
<script src="${ctx}/js/baseCompany/baseCompanyIndex.js"></script>

<!-- 模块部分公用js -->

</html>