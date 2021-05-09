<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>开票费设置</title>
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
							<label>开票费设置</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_BASECOSTS_ADD">
								<button type="button" @click="add"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
							<erp:privilege key="GYL_BASECOSTS_EDIT">
								<span data-privilege="edit"></span>
							</erp:privilege>
							<erp:privilege key="GYL_BASECOSTS_DELETE">
								<span data-privilege="delete"></span>
							</erp:privilege>
						</div>
					</div>
					<!-- title end -->

					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
									<label class="ui-col-10 tip-label">客户：</label>
									<div class="ui-col-70">
										<div class="ui-col col-160">
										    <component-select v-model="searchParam.dto.customerId" prop="customerId" type="crmClients" :search="true" :remoteseach="true" >
                                        	</component-select>
										</div>
									</div>
								</div>
								<div class="ui-col col-240 ui-ml28">
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
										id="baseCostsIndex" 
										@fetch-data="fetchData()"
										@edit="edit"
										@delete="del"
										:data="tableData"
										row-key="costId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column
										prop="crmClient.clientName"
										label="客户信息"
										min-width="120"></el-table-column>
									<el-table-column
										prop="amount"
										label="开票费（元/吨）"
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
<script src="${ctx}/js/baseCosts/baseCostsIndex.js"></script>

<!-- 模块部分公用js -->

</html>