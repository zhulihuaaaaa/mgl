<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>库存盘点</title>
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
							<label>库存盘点</label>
						</div>
						<div class="ui-col-50 ui-txt-right">
							<erp:privilege key="GYL_CHECKINV_ADD">
								<button type="button"
									class="ui-btn ui-btn-primary ui-pw28 btn-add">新建</button>
							</erp:privilege>
							<erp:privilege key="GYL_CHECKINV_EDIT">
								<span data-privilege="edit"></span>
							</erp:privilege>
							<erp:privilege key="GYL_CHECKINV_DELETE">
								<span data-privilege="delete"></span>
							</erp:privilege>
						</div>
						<erp:privilege key="GYL_CHECKINV_VIEW">
							<span data-privilege="view"></span>
						</erp:privilege>
					</div>
					<!-- title end -->

					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">存放仓库</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										  	<component-select v-model="searchParam.dto.storageId" type="DictMallDepot" depot="real" @change="fetchData()">
                                         	</component-select>
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
						</div>
						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<component-table
										id="checkInvIndex"
										@fetch-data="fetchData"
										:data="tableData"
										row-key="checkInvId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
									<el-table-column 
										prop="contractId"
										label="盘点仓库"
										min-width="150"
										:show-overflow-tooltip="true">
										 <template slot-scope="scope">
									 		{{scope.row.storageName}}
										 </template>
										</el-table-column>
										<el-table-column
											label="创建人"
											min-width="150"
											prop="createUser"
											:show-overflow-tooltip="true">
										</el-table-column>
										<el-table-column
											label="创建时间"
											prop="createDate"
											width="200"
											:show-overflow-tooltip="true">
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
<script src="${ctx}/js/invinventory/invCheckInvIndex.js"></script>

<!-- 模块部分公用js -->

</html>