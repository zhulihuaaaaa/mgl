<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>子验货单详情</title>
</head>
<body>
	<section id="container">
		<div id="slideEidt">
			<div class="slide-cnt">
				<component-slide selector=".slideEidt" :id="model.insInspectionSub.inspectionSubId"    @fetch-data="fetchData" :show.sync="show" :tab-data.sync="tabData" :active-index.sync="activeIndex">
					<span class="slide-close" title="关闭">×</span>
					<div class="scroll-wrapper ui-pw15">
						<div class="ui-row ui-pw15">
							<div class="scroll-tit ui-col">
								<div class="ui-col ui-col-70 scroll-info">
									<h4 class="ui-mb8">
										<span><el-button type="text" icon="el-icon-arrow-left" style="font-size: 25px;margin: -55px 0px -50px -5px;" @click="show=false"></el-button>
											{{model.insInspectionSub.subCode}}
											<el-tag  v-if="model.insInspectionSub.auditStatus == 'B'" style="display:inline;font-size: 14px; color: #409EFF;" >已提交</el-tag>
											<el-tag type="info" v-if="model.insInspectionSub.auditStatus == 'A'"  style="display:inline;font-size: 14px;">未提交</el-tag>
											<el-tag  v-if="model.insInspectionSub.auditStatus == 'D'"  style="display:inline;font-size: 14px;">已通过</el-tag>
											<el-tag type="info" v-if="model.insInspectionSub.auditStatus == 'C'"  style="display:inline;font-size: 14px;">已拒绝</el-tag>
										</span>
									</h4>
								</div>
								<erp:privilege key="GYL_INSINSPECTIONBILL_DETAIL_DELETE">
								</erp:privilege>
								<%-- <div class="ui-col ui-col-30 ui-txt-right ui-pb6">
									<div v-if="model.insInspectionSub.auditStatus != 'B'">
										<div class="pull-left ui-mr32">
											<erp:privilege key="GYL_INSINSPECTIONBILL_SUBMIT">
												<button type="button"
												class="ui-btn ui-btn-primary ui-pw28 btn-edit-Dialog" @click="submit()">提交</button>
											</erp:privilege>
										</div>
									</div>
								</div> --%>
								<div class="ui-col ui-col-70 scroll-info">
									<!-- <p class="pull-left ui-mr32">
										<label>子单单号</label> <span>{{model.insInspectionSub.subCode}}</span>
									</p> -->
									<p class="pull-left ui-mr32">
										<label>创建人</label> <span>{{model.insInspectionSub.createUser}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>创建时间</label> <span>{{model.insInspectionSub.createDate}}</span>
									</p>
									<p class="pull-left ui-mr32">
										<label>仓库</label> <span>{{model.dictMallDepot.dptName}}</span>
									</p>
								</div>
								<div class="ui-col ui-col-30 ui-txt-right ui-pb6">
									<div v-if="model.insInspectionSub.auditStatus == 'A'||model.insInspectionSub.auditStatus == 'C'">
											<div>
											<erp:privilege key="GYL_INSINSPECTIONBILL_SUBMIT">
												<button type="button"
												class="ui-btn ui-btn-primary ui-pw28" @click="submit()">提交</button>
											</erp:privilege>
										 </div>
										
									</div>	 
									 <erp:privilege key="GYL_INSINSPECTIONBILL_EDIT">
										<a href="javascript:void(0);" class="a-edit ui-ft13 ui-blue"  @click="edit">
											<i class="icon-coupon ui-blue"></i>编辑
										</a>
										</erp:privilege>
								</div>
								
							</div>
						</div>
	
						<div class="swiper-navgation">
							<ul class="scroll-tab">
								<li class="active"><p>概要</p></li>
								<li ><p>货物信息</p></li>
							</ul>
							<input type="hidden" id="detailTabType" value="A">
						</div>
						<div class="swiper-container tab-container" v-loading="loading">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 0">
											<h5 class="bg-tit">
												<span>基础信息</span>
											</h5>
											<div class="ui-form-group ui-col">
												<label class="ui-label-control ui-col ui-col-10">子单单号</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<span>{{model.insInspectionSub.subCode}}</span>
												</div>
												<label class="ui-label-control ui-col ui-col-10">创建人</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<span>{{model.insInspectionSub.createUser}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col">
												<label class="ui-label-control ui-col ui-col-10">创建时间</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<span>{{model.insInspectionSub.createDate}}</span>
												</div>
												<label class="ui-label-control ui-col ui-col-10">对应验货单</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<span> {{model.insInspectionBill.inspectionBillCode}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col">
												<label class="ui-label-control ui-col ui-col-10">入库日期</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<span>{{model.insInspectionSub.instockDate}}</span>
												</div>
												<label class="ui-label-control ui-col ui-col-10">质保书</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<!-- <div v-if="model.warrantyList != null">
														<span v-for="item in model.warrantyList">
															<img v-if="item != null && item != ''" :src="item.filePath" style="width: 50%"/>
														</span>
													</div> -->
													<component-images :data="model.warrantyList" title="存货凭证"></component-images>
												</div>
											</div>
											<div class="ui-form-group ui-col">
												<label class="ui-label-control ui-col ui-col-10">存货凭证</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<!-- <div v-if="model.inventoryVoucherList != null">
														<span v-for="item in model.inventoryVoucherList">
															<img v-if="item != null && item != ''" :src="item.filePath" style="width: 50%"/>
														</span>
													</div> -->
													<component-images :data="model.inventoryVoucherList" title="存货凭证"></component-images>
												</div>
												<label class="ui-label-control ui-col ui-col-10">存货凭证编号</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<span>{{model.insInspectionSub.voucherNo}}</span>
												</div>
											</div>
											<div class="ui-form-group ui-col">
												<label class="ui-label-control ui-col ui-col-10">总数量</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													
													{{model.insInspectionSub.totalNumber}}
												</div>
												<label class="ui-label-control ui-col ui-col-10">总重量(吨)</label>
												<div class="ui-col ui-col-40 ui-label-txt">
													<span>
														{{model.insInspectionSub.totalWeight != null ? util.formatNumber((model.insInspectionSub.totalWeight / 1000), 2) : 0}}
													</span>
												</div>
											</div>
											<div class="ui-form-group ui-col">
													<label class="ui-label-control ui-col ui-col-10">备注</label>
													<div class="ui-col ui-col-90 ui-label-txt">
														<span>{{model.insInspectionSub.notes}}</span>
													</div>
											</div>
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 1">
											<h5 class="bg-tit">
												<span>货物信息
													<erp:privilege key="GYL_INSINSPECTIONBILL_DETAIL_BATCH_EDIT_ADD">
													<input v-if="model.insInspectionSub.auditStatus == 'A'||model.insInspectionSub.auditStatus == 'C'" type="button" class = "ui-btn pull-right btn_new_line" value="编辑" @click="addOrEditProduct"/>
													</erp:privilege>
													<%-- <erp:privilege key="GYL_INSINSPECTIONBILL_DETAIL_BATCH_EDIT">
													<input v-if="model.insInspectionSub.auditStatus == 'A'||model.insInspectionSub.auditStatus == 'C'" type="button" class = "ui-btn pull-right btn_new_line" value="编辑" @click="editProduct"/>
													</erp:privilege> --%>
												</span>
											</h5>
											<component-table
												:max-height="500"
												@fetch-data="fetchDataByProduct"
												:operation="operation"
												:show-delete-btn="showDeleteBtn"
												:columns="tableConfig.columns"
												@delete="del"
												:data="tableData">
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
											  prop="dictMallDepot.dptName"
					        				  label="仓库"
					        				  width="180"
					        				  > </el-table-column>
									      <el-table-column
									       prop="insInspectionDetail.referThick"
									        width="120"
									        label="参厚(mm)"></el-table-column>
									        <el-table-column
								        	  prop="insInspectionDetail.goodsVolume"
									          width="120"
									        label="卷号(mm)">
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
									      		prop ="insInspectionDetail.storePrice"
									          	width="120"
									        	label="商城价"></el-table-column>
									       <el-table-column
									       	prop ="insInspectionDetail.realUnitPrice"
									          width="150"
									        label="实际单价（元/kg）"> 
									      </el-table-column>
									      <el-table-column 
									      	prop ="insInspectionDetail.floatPrice"
									          width="120"
									        label="升贴水(元)"></el-table-column>
									      <el-table-column
									      prop ="insInspectionDetail.basicPrice"
									          width="120"
									        label="基价(元)"> </el-table-column>
									      <el-table-column
									      	prop ="insInspectionDetail.contractMoney"
									         width="120"
									        label="合同金额(元)">
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
									        label="备注">
								          
								        
								      </el-table-column>
								       
									</component-table>
											
											
											
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="ui-panel">
										<div class="ui-panel-body scroll-body" v-if="activeIndex == 1 && tabData[activeIndex]">
											<h5 class="bg-tit">
												<span>测试</span>
											</h5>
											{{tabData[1].test}}
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