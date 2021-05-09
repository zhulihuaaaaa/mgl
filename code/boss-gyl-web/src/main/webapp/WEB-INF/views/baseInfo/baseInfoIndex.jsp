<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>基本信息设置</title>
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
							<label>基本信息设置</label>
						</div>
					</div>
					<!-- title end -->

					<erp:privilege key="GYL_BASEINFO_EDIT">
						<span data-privilege="edit"></span>
					</erp:privilege>
					<div class="panel-control clearfix">
						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
								<div class="component-table">
									<div class="el-table el-table--fit el-table--border el-table--enable-row-transition">
										<div class="el-table__header-wrapper">
											<table class="el-table__header">
												<thead class="has-gutter">
													<tr style="background: rgb(244, 246, 249);">
														<th class="el-table_1_column_13   first-col--text">
															<div class="cell" style="width:200px;">
																0-60天通用手续费率
															</div>
														</th>
														<th class="el-table_1_column_13   first-col--text">
															<div class="cell" style="width:200px;">
																61-90天通用手续费率
															</div>
														</th>
														<th class="el-table_1_column_13   first-col--text">
															<div class="cell" style="width:200px;">
																通用开票费（元/吨）
															</div>
														</th>
														<th class="el-table_1_column_13   first-col--text">
															<div class="cell" style="width:200px;">
																逾期提醒天数(格式 7,5,2)
															</div>
														</th>
														<th class="el-table_1_column_13   first-col--text" style="border-right: 1px solid #e6ebf5">
															<div class="cell" style="width:200px;">
																虚拟仓库名
															</div>
														</th>
														<th class="el-table_1_column_13   first-col--text">
															<div class="cell" style="width:200px;">
																操作
															</div>
														</th>
													</tr>
												</thead>
											</table>
										</div>
										<div class="el-table__body-wrapper is-scroll-left">
											<form id="baseInfoDialog">
												<table class="el-table__body">
													<tbody>
														<tr class="el-table__row">
															<input type="hidden" name="infoId" value="${infoList.infoId}">
															<td class="el-table_1_column_13  el-table-column--selection">
																<div class="cell" style="width:200px;">
																	<div class="cell el-tooltip">
																		<input class="ui-input-control" name="feeRate1" value="${infoList.feeRate1}">
																	</div>
																</div>
															</td>
															<td class="el-table_1_column_13  el-table-column--selection">
																<div class="cell" style="width:200px;">
																	<div class="cell el-tooltip">
																		<input class="ui-input-control" name="feeRate2" value="${infoList.feeRate2}">
																	</div>
																</div>
															</td>
															<td class="el-table_1_column_13  el-table-column--selection">
																<div class="cell" style="width:200px;">
																	<div class="cell el-tooltip">
																		<input class="ui-input-control" name="invoiceFee" value="${infoList.invoiceFee}">
																	</div>
																</div>
															</td>
															<td class="el-table_1_column_13  el-table-column--selection">
																<div class="cell" style="width:200px;">
																	<div class="cell el-tooltip">
																		<input class="ui-input-control" name="overdueReminder" value="${infoList.overdueReminder}">
																	</div>
																</div>
															</td>
															<td class="el-table_1_column_13  el-table-column--selection">
																<div class="cell" style="width:200px;">
																	<div class="cell el-tooltip">
																		<input class="ui-input-control" name="virtualMallDepot" value="${infoList.virtualMallDepot}">
																	</div>
																</div>
															</td>
															<td class="el-table_1_column_13  el-table-column--selection">
																<div class="cell" style="width:200px;">
																	<div class="cell el-tooltip">
																			<input class="ui-input-control" name="companyName" value="${infoList.companyName}">
																	</div>
																</div>
															</td>
															<td class="el-table_1_column_13  el-table-column--selection">
																<div class="cell" style="width:200px;">
																	<div class="cell el-tooltip">
																		<erp:privilege key="GYL_BASEINFO_EDIT">
																			<button class="el-button el-button--text el-button--small bctj" data-privilege="edit">
																				保存
																			</button>
																		</erp:privilege>
																	</div>
																</div>
															</td>
														</tr>
													</tbody>
												</table>
											</form>
										</div>
									</div>
								</div>
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
<script src="${ctx}/js/baseInfo/baseInfoIndex.js"></script>

<!-- 模块部分公用js -->

</html>