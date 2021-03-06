<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>验货单详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
				<component-slide   @fetch-data="fetchData" :id="model.insInspectionBill.inspectionBillId"  :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
				<div class="slideEidt"></div>
				<span class="slide-close" title="关闭">×</span>
					<div class="scroll-wrapper ui-pw15">
						<div class="ui-row ui-pw15">
							<div class="ui-row ui-pw15">
							<div class="scroll-tit ui-col">
								<h1 class="ui-mb8">
									<span>{{model.insInspectionBill.inspectionBillCode}}
										<el-tag type="info" v-if="model.insInspectionBill.inspectionStatus == 'B'" style="display:inline;font-size: 14px;" >验货中</el-tag>
										<el-tag type="info" v-if="model.insInspectionBill.inspectionStatus == 'A'"  style="display:inline;font-size: 14px;">已验货</el-tag>										
										<el-tag type="info" v-if="model.insInspectionBill.inspectionStatus == 'C'"  style="display:inline;font-size: 14px;">未验货</el-tag>
									</span>
								</h1>
								<div class="ui-col ui-col-70 scroll-info">
									<p class="pull-left ui-mr32">
										<label>入库单号</label> <span>{{model.instockNo}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>创建时间</label> <span>{{model.insInspectionBill.createDate}}</span>
									</p>
									<!-- <p class="pull-left ui-mr32">
										<label>仓库</label><span v-if="model.dictMallDepot!=null">{{model.dictMallDepot.dptName}}</span>
									</p> -->
								</div>
								<!-- 删除 -->
								<erp:privilege key="GYL_INSINSPECTIONBILL_DELETE"></erp:privilege>
							</div>
						</div>
						</div>
						
						<div class="swiper-navgation">
							<ul class="scroll-tab">
								<li class="active"><p>子验货单</p></li>
								<li><p>货物信息</p></li>
							</ul>
							<input type="hidden" id="detailTabType" value="A">
						</div>
						<div class="swiper-container tab-container" v-loading="loading" >
							<div class="swiper-wrapper" >
								<div class="swiper-slide" >
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 0">
											<h5 class="bg-tit">
												<span>子验货单
													<erp:privilege key="GYL_INSINSPECTIONBILL_ADD">
														<input  v-if="isShowAdd"  type="button" class = "ui-btn pull-right btn_new_line" value="新增" @click="addProduct"/>
													</erp:privilege>
												</span>
											</h5>
										<component-table
											:max-height="500"
											@fetch-data="fetchDataByEdit"
											@detail="detail"
											@delete="del"
											:show-delete-btn="showDeleteBtn"
											:data="tableData"
											:operation="operation"
											:columns="tableConfig.columns"
											:loading="tableConfig.loading" 
											>
										<el-table-column
											prop="contractNo"
											label="合同编号"
											min-width="120"
											:show-overflow-tooltip="true"></el-table-column>
										<el-table-column
											prop="insInspectionSub.subCode"
											label="子单单号"
											min-width="120"></el-table-column>
										<el-table-column
											prop="insInspectionSub.createUser"
											
											label="创建人"
											min-width="120"></el-table-column>
										<el-table-column
											prop="dictMallDepot.dptName"
											
											label="仓库"
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
											 <span  v-if="scope.row.insInspectionSub.auditStatus === 'A'">未提交</span>
								             <span  v-if="scope.row.insInspectionSub.auditStatus === 'B'">审批中</span>
								             <span  v-if="scope.row.insInspectionSub.auditStatus === 'C'">已拒绝</span>
								             <span  v-if="scope.row.insInspectionSub.auditStatus === 'D'">已通过</span>
								             <span  v-if="scope.row.insInspectionSub.auditStatus === 'E'">已作废</span>
											</template>
											</el-table-column>
										<el-table-column
											v-if="false"
											prop="status"
											
											label="质保书"
											min-width="180">
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
											
											label="存货凭证"
											min-width="180">
											<template slot-scope="scope">
												<div v-if="scope.row.inventoryVoucherList != null">
													<span v-for="item in scope.row.inventoryVoucherList">
														<img v-if="item != null && item != ''" :src="item.filePath" style="width: 100%"/>
													</span>
												</div>
											</template>
											</el-table-column>
										<el-table-column
											prop="insInspectionSub.voucherNo"
											
											label="存货凭证编号"
											min-width="180">
											
											</el-table-column>
										<el-table-column
											prop="insInspectionSub.createDate"
											
											label="创建时间"
											min-width="180">
											</el-table-column>
											<el-table-column
											prop="insInspectionSub.totalNumber"
											
											label="总数量"
											min-width="180">
											</el-table-column>
											<el-table-column
											
											label="总重量(吨)"
											min-width="180">
											<template slot-scope="scope">
												<!-- 由于子单没有 关联的品名id 数据库上存的都是千克 -->
												{{scope.row.insInspectionSub.totalWeight / 1000}}
											<!-- {{scope.row.insInspectionSub.totalWeight != null ? util.formatNumber((scope.row.insInspectionSub.totalWeight / scope.row.baseProduct.unitRate), scope.row.baseProduct.precision) : 0}}{{scope.row.baseProduct.weightUnit}} -->
											</template>
											</el-table-column>
										<el-table-column
											prop="insInspectionSub.notes"
											label="备注"
											min-width="180">
											</el-table-column>
										<div v-if="scope.row.insInspectionSub.auditStatus ==  'A' || scope.row.insInspectionSub.auditStatus ==  'C' " slot="operation" slot-scope="scope">
										 	<span class="ui-btn ui-blue" style="padding: 0px 3px;" @click="showsumbitBtn(scope.row,scope.$index)">提交</span>
										</div>
									</component-table>
										</div>
									</div>
								</div>
								<div class="swiper-slide" >
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 1 && tabData[activeIndex]">
											<h5 class="bg-tit">
												<span>货物信息</span>
											</h5>
											<div>
											<component-table
											:max-height="500"
											@fetch-data="fetchDataByProduct"
											:data="productData"
											:loading="tableConfig.loading" 
											>
										<el-table-column
											prop="productName"
											label="品类"
											min-width="120"
											:show-overflow-tooltip="true"></el-table-column>
											<el-table-column
											prop="insInspectionDetail.orderCode"
											label="系列"
											min-width="120"
											:show-overflow-tooltip="true"></el-table-column>
										 <el-table-column
									        prop="insInspectionDetail.materialId"
									        label="材质"
									        width="180"></el-table-column>
										 <el-table-column
										  prop="insInspectionDetail.surfaceId"
				        				  label="表面"
				        				  width="180"
				        				  > </el-table-column>
								      <el-table-column  
								      v-if="false"
								      prop="insInspectionDetail.labelThick"
								      label="标准厚度"></el-table-column>
								      <el-table-column
								        label="规格(mm)"
								        width="300">
								        <template slot-scope="scope">
								   			{{scope.row.insInspectionDetail.labelThick}}*{{scope.row.insInspectionDetail.labelWidth}}*{{scope.row.insInspectionDetail.goodsLength}}
										
										</template>
								      </el-table-column>
								      <el-table-column
								      	 prop="insInspectionDetail.labelThick"
								         width="120"
								        label="边部(mm)"></el-table-column>
								      <el-table-column
								       prop="insInspectionDetail.referThick"
								        width="120"
								        label="参厚(mm)"></el-table-column>
								        <el-table-column
							        	  prop="insInspectionDetail.goodsVolume"
								          width="120"
								        label="卷号">
								        </el-table-column>
								         <el-table-column 
								      	prop ="insInspectionDetail.trademark"
								          width="120"
								        label="牌号"></el-table-column>
								         <el-table-column 
								      	prop ="insInspectionDetail.realWidth"
								          width="120"
								        label="实宽(mm)"></el-table-column>
								      </el-table-column>
								        <el-table-column
								        :show-overflow-tooltip="true"
								          prop="dictMallMnfct.mnfctName"
								          width="120"
								         label="制造商"> </el-table-column>
								       <el-table-column
								        prop="insInspectionDetail.netWeight"
								         width="120"
								       label="重量">
								       <template slot-scope="scope">
									      <span v-if="scope.row.insInspectionDetail.netWeight !=null">
								        	{{scope.row.insInspectionDetail.netWeight != null ? util.formatNumber((scope.row.insInspectionDetail.netWeight / scope.row.baseProduct.unitRate), scope.row.baseProduct.precision) : 0}}{{scope.row.baseProduct.weightUnit}}
								        	</span>
									       </template>
								       </el-table-column>
								      <el-table-column
								      	prop="insInspectionDetail.amount"
								        width="120"
								        label="数量">
								         <template slot-scope="scope">
								       {{scope.row.insInspectionDetail.amount}}{{scope.row.baseProduct.quantityUnit}}
								       </template>
								      </el-table-column>
								      <el-table-column
								      	prop="insInspectionDetail.grade"
								         width="120"
								        label="等级"></el-table-column>
								        <div v-if="false">
								      <el-table-column
								      	prop ="insInspectionDetail.contractUnitPrice"
								         width="150"
								        label="合同单价（元/kg)"></el-table-column>
								       <el-table-column
								       	prop ="insInspectionDetail.realUnitPrice"
								          width="150"
								        label="实际单价（元/kg）"> 
								      </el-table-column>
								      <el-table-column 
								      	prop ="insInspectionDetail.floatPrice"
								          width="120"
								        label="升贴水"></el-table-column>
								         <el-table-column 
								      	prop ="insInspectionDetail.storePrice"
								          width="120"
								        label="商城价"></el-table-column>
								      <el-table-column
								      prop ="insInspectionDetail.basicPrice"
								          width="120"
								        label="基价(元)"> </el-table-column>
								      <el-table-column
								      	prop ="insInspectionDetail.contractMoney"
								         width="120"
								        label="合同金额">
								      </el-table-column>
								      <el-table-column
								      	prop ="insInspectionDetail.realMoney"
								          width="120"
								        label="实际金额(元)"> </el-table-column>
								      <el-table-column
								     	prop ="insInspectionDetail.serviceFee"
								        width="120"
								        label="手续费(元)"> </el-table-column>
								       <el-table-column
								       prop ="insInspectionDetail.invoiceFee"
								          width="120"
								        label="开票费(元)"> </el-table-column>
								        </div>
								         <el-table-column
										  prop="dictMallDepot.dptName"
				        				  label="仓库"
				        				  width="180"
				        				  > </el-table-column>
								      <el-table-column
								       width="120"
								      label="货物照片">
								      <template slot-scope="scope">
											<!-- <div v-if="scope.row.sphotosGoodsList != null">
												<span v-for="item in scope.row.sphotosGoodsList">
													<img v-if="item != null && item != ''" :src="item.filePath" style="width: 100%"/>
												</span>
											</div> -->
											<component-images :data="scope.row.sphotosGoodsList" title="货物照片"></component-images>
										</template>
								      </el-table-column>
								       <el-table-column
								       :show-overflow-tooltip="true"
								       	prop ="insInspectionDetail.notes"
								          width="120"
								        label="备注1">
								      </el-table-column>
								      <el-table-column
								       :show-overflow-tooltip="true"
								       	prop ="insInspectionDetail.notes"
								          width="120"
								        label="备注1">
								      </el-table-column>
									</component-table>
											
											
											
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</component-slide>
			</div>
		</div>
	</section>
</body>
</html>