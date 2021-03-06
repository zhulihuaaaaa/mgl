<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../include/head.jsp"%>
<title>金融库存管理</title>
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
							<label>金融库存管理</label>
						</div>
					</div>
					<!-- title end -->
						<erp:privilege key="GYL_INVENTORY_FINANCIAL_VIEW">
							<span data-privilege="view"></span>
						</erp:privilege>
					<div class="panel-control clearfix">
						<div class="search-opt ui-pw20 ui-col">
							<div class="ui-col ui-mb16">
								<div class="ui-col col-240 ui-border-r">
									<label class="ui-col-10 tip-label">业务类型：</label>
									<div class="ui-col-70">
										<!-- <select data-placeholder="客户来源"
                                                 class="chosen-select"
                                                 v-model="searchParam.dto.businessType" @change="fetchData">
                                                 <option value="">全部</option>
                                                 <option v-for="item of options.BusinessType" :key="item[0]" :value='item[0]'>{{item[1]}}</option>
                                         </select> -->
                                         <component-select v-model="searchParam.dto.businessType" type="BusinessType"  @change="fetchData()">
                                         </component-select>
									</div>
								</div>
								<div class="ui-col col-240 ui-border-r">
									<label class="ui-col-10 tip-label">库存状态：</label>
									<div class="ui-col-70">
                                         <component-select v-model="searchParam.dto.stats" type="InOrNotStock"  @change="fetchData()">
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
										<label class="ui-label-control pull-left">买方客户:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										 <component-select v-model="searchParam.dto.buyerId" type="crmClients" :search="true" :remoteseach="true" >
                                         </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">卖方客户:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										 <component-select v-model="searchParam.dto.sellerId" type="crmClients" :search="true" :remoteseach="true" >
                                         </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">存放仓库:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										  <component-select v-model="searchParam.dto.storageId" type="DictMallDepot">
                                         </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">入库日期</label>
										<div class="ui-col col-160 ui-mr12 ui-ml4">
											<input type="text" v-model="searchParam.dto.instockStartDate"
												class="ui-input-control daterange-start" placeholder="起始时间">
										</div>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" v-model="searchParam.dto.instockEndDate"
												class="ui-input-control daterange-end" placeholder="结束时间">
										</div>
									</div>
								</div>
								<div class="ui-col-90">
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">表面:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										 <component-select v-model="searchParam.dto.surfaceId" type="baseProcess" :search="true" :remoteseach="true" >
                                         </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">品类:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										 <component-select v-model="searchParam.dto.productId" type="baseProduct" :search="true" :remoteseach="true" >
                                         </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">材质:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										  <component-select v-model="searchParam.dto.materialId" type="DictMallSpec"  >
                                         </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">厂商:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
										  <component-select v-model="searchParam.dto.mnfctId" type="mallMnfcts"  >
                                         </component-select>
										</div>
									</div>
									
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">卷号:</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<input type="text" class="ui-input-control"
												placeholder="请输入卷号" v-model="searchParam.dto.volume">
										</div>
										
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">合同自编号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
												 <component-select v-model="searchParam.dto.contractId" type="contractCode" :search="true" :remoteseach="true">
                                       			 </component-select>
										</div>
									</div>
									<div class="ui-form-group pull-left">
										<label class="ui-label-control pull-left">合同编号</label>
										<div class="ui-col col-160 ui-mr24 ui-ml4">
											<component-select v-model="searchParam.dto.contractId" type="contractNum" :search="true">
                                       			 </component-select>
                                       			 
										</div>
									</div>
								</div>
								<div class="ui-col-10 ui-txt-right">
									<button type="button"
										class="ui-btn ui-btn-primary btn-search-data" @click="fetchData()">
										<i class="icon-sousuo"></i>搜索
									</button>
								</div>
								<!-- <div class="ui-col-10 ui-txt-right">
									<button type="button"
										class="ui-btn ui-btn-primary btn-search-data" @click="reset()">
										<i class="icon-sousuo"></i>重置
									</button>
								</div> -->
							</div>
						</div>
						<div class="ui-col slide-overflow">
							<div class="main-cnt-scroll">
									<component-table
										id="invinventoryFinancialIndex"
										@fetch-data="fetchData"
										@detail="detail"
										:data="tableData"
										row-key="invInventory.inventoryId"
										:loading="tableConfig.loading"
										:columns="tableConfig.columns"
										:pagination="true">
										<el-table-column
										prop="contractId"
										sortable="custom"
										label="合同自编号"
										min-width="150"
										:show-overflow-tooltip="true">
										 <template slot-scope="scope">
										 	<span v-if="scope.row.conContract!=null">
										 		{{scope.row.conContract.contractCode}}
										 	 </span>
										 </template>
										</el-table-column>
										<el-table-column
										label="合同编号"
										min-width="150"
										:show-overflow-tooltip="true">
										 <template slot-scope="scope">
										 	<span v-if="scope.row.conContract!=null">
										 		{{scope.row.conContract.contractNo}}
										 	 </span>
										 </template>
										</el-table-column>
									<el-table-column
										prop="sellerId"
										sortable="custom"
										label="卖方客户"
										min-width="110"
										:show-overflow-tooltip="true">
										 <template slot-scope="scope">
										 {{scope.row.sellerName}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="buyerId"
										sortable="custom"
										label="买方客户"
										min-width="110">
										 <template slot-scope="scope">
										 {{scope.row.buyerName}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="businessType"
										label="业务类型"
										min-width="110">
										<template slot-scope="scope">
										 <span  v-if="scope.row.invInventory.businessType === 'H'">货押融资</span>
							             <span  v-if="scope.row.invInventory.businessType === 'C'">定向销售</span>
							             <span  v-if="scope.row.invInventory.businessType === 'X'">采购自销</span>
							             <span  v-if="scope.row.invInventory.businessType === 'D'">仓单质押</span>
							             <span  v-if="scope.row.invInventory.businessType === 'E'">商城融资</span>
							             <span  v-if="scope.row.invInventory.businessType === 'F'">订单交收</span>
										</template>
										</el-table-column>
									<el-table-column
										prop="instockDate"
										sortable="custom"
										label="入库日期"
										width="200">
										 <template slot-scope="scope">
										 	{{scope.row.invInventory.instockDate}}
										 </template>
										</el-table-column>
										<el-table-column
										prop="createDate"
										label="创建时间"
										sortable="custom"
										width="200">
										 <template slot-scope="scope">
										 	{{scope.row.invInventory.createDate}}
										 </template>
										</el-table-column>
										<el-table-column
										prop="ownCargo"
										label="是否是自有货物"
										min-width="150"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
										 {{scope.row.invInventory.ownCargo =='Y'?"是":"否"}}
										 </template>
										</el-table-column>
									<el-table-column
									
										label="库存状态"
										min-width="110">
										<template slot-scope="scope">
										 <div v-if="scope.row.invInventory.quantity == 0 || scope.row.invInventory.quantity == null ">
										  	已出库
										 </div>
										 <div v-if="scope.row.invInventory.quantity != 0 && scope.row.invInventory.quantity != null">
										 	仓库中
										 </div>
										</template>
										</el-table-column>
										<el-table-column
										prop="quantity"
										sortable="custom"
										label="数量"
										min-width="140">
										<template slot-scope="scope">
											<span v-if="scope.row.invInventory.quantity !=null">
										 		{{scope.row.invInventory.quantity}} {{scope.row.baseProduct.quantityUnit}} 
										 	 </span>
										 </template>
										</el-table-column>
									<el-table-column
										prop="nextUnlockQuantity"
										sortable="custom"
										label="待解锁数量"
										min-width="150">
										 <template slot-scope="scope"> 
										 	{{(scope.row.invInventory.nextUnlockQuantity==null? 0 :scope.row.invInventory.nextUnlockQuantity) +"  "+ scope.row.baseProduct.quantityUnit}} 
										 <span>
										 	
										 </span>
										 </template>
									</el-table-column>
										<el-table-column
										prop="nextOutstockQuantity"
										sortable="custom"
										label="待出库数量"
										min-width="150">
										 <template slot-scope="scope">
										 {{(scope.row.invInventory.nextOutstockQuantity==null? 0 :scope.row.invInventory.nextOutstockQuantity)  +"  "+ scope.row.baseProduct.quantityUnit}} 
										 </template>
									</el-table-column>
										</el-table-column>
										<el-table-column
										prop="enableNum"
										label="可供数量"
										min-width="180">
										 <template slot-scope="scope">
										 <span v-if="scope.row.enableNum !=null">
										 	{{scope.row.enableNum}} {{scope.row.baseProduct.quantityUnit}}
										 </span>
										 </template> 
									</el-table-column>
									<el-table-column
										prop="storageId"
										sortable="custom"
										label="存放仓库"
										min-width="170">
										 <template slot-scope="scope">
										 {{scope.row.storageName}}
										 </template>
									</el-table-column>
									<el-table-column
										prop="productId"
										sortable="custom"
										label="品类"
										min-width="120">
										<template slot-scope="scope">
										 {{scope.row.productName}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="materialId"
										sortable="custom"
										label="材质"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.materialId}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="surfaceId"
										sortable="custom"
										label="表面"
										min-width="150"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
										 {{scope.row.invInventory.surfaceId}}
										 </template>
										</el-table-column>
									<el-table-column
										v-if="false"
										prop="labelThick"
										sortable="custom"
										label="标准厚度"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.labelThick}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="labelWidth"
										sortable="custom"
										label="规格(mm)"
										min-width="210">
										<template slot-scope="scope">
										 	{{scope.row.invInventory.labelThick}} * {{scope.row.invInventory.labelWidth}} * {{scope.row.invInventory.goodsLength}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="edge"
										label="边部(mm)"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.edge}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="referThick"
										label="参厚(mm)"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.referThick}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="realWidth"
										label="实宽(mm)"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.realWidth}}
										 </template>
									</el-table-column>
									<el-table-column
										prop="trademark"
										label="牌号"
										min-width="120">
										<template slot-scope="scope">
										 {{scope.row.invInventory.trademark}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="volume"
										label="卷号"
										min-width="120">
										<template slot-scope="scope">
										 {{scope.row.invInventory.volume}}
										 </template>
										</el-table-column>
										<!--  -->
									<el-table-column
									prop="mnfctId"
									label="厂家"
									min-width="200"
									:show-overflow-tooltip="true">
									<template slot-scope="scope">
										<span v-if="scope.row.dictMallMnfct !=null">
										 {{scope.row.dictMallMnfct.mnfctName}}
										 </span>
									 </template>
									</el-table-column>
									<el-table-column
										prop="netWeight"
										sortable="custom"
										label="净重"
										min-width="120">
										<template slot-scope="scope">
										  {{scope.row.invInventory.netWeight != null ? util.formatNumber((scope.row.invInventory.netWeight / scope.row.baseProduct.unitRate), scope.row.baseProduct.precision) : 0}}  {{scope.row.baseProduct.weightUnit}}
										 </template>
										</el-table-column>
									
									<el-table-column
										prop="calcMethod"
										label="计算方式"
										min-width="110">
										<template slot-scope="scope">
										 {{scope.row.invInventory.calcMethod}}
										 </template>
										</el-table-column>
									<el-table-column
										prop="grade"
										label="等级"
										min-width="120">
										<template slot-scope="scope">
										 {{scope.row.invInventory.grade}}
										 </template>
										</el-table-column>
									
									<el-table-column
										prop="contractUnitPrice"
										label="合同单价"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.contractUnitPrice==null?util.replaceSpace(scope.row.invInventory.contractUnitPrice,'0'):scope.row.invInventory.contractUnitPrice + '元/'+scope.row.baseProduct.weightUnit}} 
										 </template>
									</el-table-column>
									<el-table-column
										prop="realUnitPrice"
										label="实际单价"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.contractUnitPrice==null?util.replaceSpace(scope.row.invInventory.contractUnitPrice,'0'):scope.row.invInventory.contractUnitPrice + '元/'+scope.row.baseProduct.weightUnit}} 
										 </template>
										
										
									
										</el-table-column>
									<el-table-column
										prop="contractMoney"
										sortable="custom"
										label="合同金额(元)"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.contractMoney==null?util.replaceSpace(scope.row.invInventory.contractMoney,'0'):scope.row.invInventory.contractMoney }} 
										 </template>
										
										</el-table-column>
									<el-table-column
										prop="realMoney"
										label="实际金额(元)"
										min-width="150">
										<template slot-scope="scope">
										 {{scope.row.invInventory.realMoney==null?util.replaceSpace(scope.row.invInventory.realMoney,'0'):scope.row.invInventory.realMoney }} 
										 </template>
									
										</el-table-column>
									<el-table-column
										prop="storePrice"
										label="商城价(元)"
										min-width="150">
										
										<template slot-scope="scope">
										 {{scope.row.invInventory.storePrice==null?util.replaceSpace(scope.row.invInventory.storePrice,'0'):scope.row.invInventory.storePrice }} 
										 </template>
										
										</el-table-column>
									<el-table-column
										prop="basicPrice"
										label="基价(元)"
										min-width="150"
										:show-overflow-tooltip="true">
										<template slot-scope="scope">
										 {{scope.row.invInventory.basicPrice==null?util.replaceSpace(scope.row.invInventory.basicPrice,'0'):scope.row.invInventory.basicPrice }} 
										 </template>
										
										</el-table-column>
									<el-table-column
										prop="floatPrice"
										label="升贴水(元)"
										min-width="150">
										
										<template slot-scope="scope">
										 {{scope.row.invInventory.floatPrice==null?util.replaceSpace(scope.row.invInventory.floatPrice,'0'):scope.row.invInventory.floatPrice }} 
										 </template>
									
										</el-table-column>
									
									
									<el-table-column
										prop="implStd"
										label="执行标准"
										min-width="110">
										<template slot-scope="scope">
										 {{scope.row.invInventory.implStd}}
										 </template>
										</el-table-column>
									<el-table-column
										:show-overflow-tooltip="true"
										prop="notes"
										label="备注"
										min-width="80">
										<template slot-scope="scope">
										 {{scope.row.invInventory.notes}}
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
<script src="${ctx}/js/invinventory/invinventoryFinancialIndex.js"></script>

<!-- 模块部分公用js -->

</html>