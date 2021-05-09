package com.maigangle.gyl.facade.entity.excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.api.CrmClient;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("InvInventoryExcel")
public class InvInventoryExcel implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1749264587046935360L;

	/**
     * id
     */
    private String inventoryId;
	
    /**
     * 合同单号
     */
    @Excel(name = "合同自编号", needMerge = true)
    private String contractCode;
   
    /**
     * 合同编号
     */
    @Excel(name = "合同编号", width = 20, needMerge = true)
    private String contractNo;
	
    /**
     * 卖方信息
     */
    @Excel(name = "卖方信息", width = 30)
    private String sellerName;

    /**
     * 买方信息
     */
    @Excel(name = "买方信息", width = 30)
    private String buyerName;

    /**
     * 业务类型
     */
    @Excel(name = "业务类型", replace={"定向销售_C","货押融资_H","采购自销_X","仓单质押_D"}, needMerge = true)
    private String businessType;

    /**
     * 存放仓库
     */
    @Excel(name = "存放仓库")
    private String storageName;

    /**
     * 入库日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 存日期时使用
    @Excel(name = "入库日期" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date instockDate;

    /**
     * 品名
     */
    @Excel(name = "品名")
    private String productName;

    /**
     * 材质
     */
    @Excel(name = "材质")
    private String materialId;

    /**
     * 表面
     */
    @Excel(name = "表面")
    private String surfaceId;

    /**
     * 标签厚度
     */
    @Excel(name = "标签厚度")
    private String labelThick;

    /**
     * 标签宽度
     */
    @Excel(name = "标签宽度")
    private String labelWidth;

    /**
     * 长度
     */
    @Excel(name = "长度")
    private String goodsLength;

    /**
     * 边部
     */
    @Excel(name = "边部")
    private String edge;

    /**
     * 参厚
     */
    @Excel(name = "参厚")
    private BigDecimal referThick;

    /**
     * 实宽
     */
    @Excel(name = "实宽")
    private BigDecimal realWidth;

    /**
     * 牌号
     */
    @Excel(name = "牌号")
    private String trademark;

    /**
     * 卷号
     */
    @Excel(name = "卷号")
    private String volume;
    
    /**
     * 供应方
     */
    @Excel(name = "厂家", width = 30)
    private String mallMnfct;

    /**
     * 净重
     */
    @Excel(name = "净重")
    private String netWeight;

    /**
     * 数量（张/卷）
     */
    @Excel(name = "数量")
    private String quantity;

    /**
     * 待出库数量
     */
    private String nextOutstockQuantity;

    /**
     * 计算方式
     */
    @Excel(name = "计算方式")
    private String calcMethod;

    /**
     * 等级
     */
    @Excel(name = "等级")
    private String grade;

    /**
     * 合同单价（元/kg）
     */
    @Excel(name = "合同单价")
    private String contractUnitPrice;

    /**
     * 实际单价（元/kg）
     */
    @Excel(name = "实际单价")
    private String realUnitPrice;

    /**
     * 升贴水
     */
    @Excel(name = "升贴水")
    private BigDecimal floatPrice;

    /**
     * 基价
     */
    private BigDecimal basicPrice;

    /**
     * 商城价
     */
    @Excel(name = "商城价")
    private BigDecimal storePrice;

    /**
     * 合同金额
     */
    @Excel(name = "合同金额(元)", width = 15)
    private BigDecimal contractMoney;

    /**
     * 实际金额
     */
    @Excel(name = "实际金额(元)", width = 15)
    private BigDecimal realMoney;

    /**
     * 执行标准
     */
    @Excel(name = "执行标准")
    private String implStd;

    /**
     * 备注
     */
    @Excel(name = "备注", width = 50)
    private String notes;

    /**
     * 内径
     */
    private BigDecimal bore;

    /**
     * 关联合同id
     */
    private String contractId;

    /**
     * 验货单明细ID
     */
    private String sourceId;

    /**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public Date getInstockDate() {
		return instockDate;
	}

	public void setInstockDate(Date instockDate) {
		this.instockDate = instockDate;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getSurfaceId() {
		return surfaceId;
	}

	public void setSurfaceId(String surfaceId) {
		this.surfaceId = surfaceId;
	}

	public String getLabelThick() {
		return labelThick;
	}

	public void setLabelThick(String labelThick) {
		this.labelThick = labelThick;
	}

	public String getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(String labelWidth) {
		this.labelWidth = labelWidth;
	}

	public String getGoodsLength() {
		return goodsLength;
	}

	public void setGoodsLength(String goodsLength) {
		this.goodsLength = goodsLength;
	}

	public String getEdge() {
		return edge;
	}

	public void setEdge(String edge) {
		this.edge = edge;
	}

	public BigDecimal getReferThick() {
		return referThick;
	}

	public void setReferThick(BigDecimal referThick) {
		this.referThick = referThick;
	}

	public BigDecimal getRealWidth() {
		return realWidth;
	}

	public void setRealWidth(BigDecimal realWidth) {
		this.realWidth = realWidth;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getNextOutstockQuantity() {
		return nextOutstockQuantity;
	}

	public void setNextOutstockQuantity(String nextOutstockQuantity) {
		this.nextOutstockQuantity = nextOutstockQuantity;
	}

	public String getCalcMethod() {
		return calcMethod;
	}

	public void setCalcMethod(String calcMethod) {
		this.calcMethod = calcMethod;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getContractUnitPrice() {
		return contractUnitPrice;
	}

	public void setContractUnitPrice(String contractUnitPrice) {
		this.contractUnitPrice = contractUnitPrice;
	}

	public String getRealUnitPrice() {
		return realUnitPrice;
	}

	public void setRealUnitPrice(String realUnitPrice) {
		this.realUnitPrice = realUnitPrice;
	}

	public BigDecimal getFloatPrice() {
		return floatPrice;
	}

	public void setFloatPrice(BigDecimal floatPrice) {
		this.floatPrice = floatPrice;
	}

	public BigDecimal getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(BigDecimal basicPrice) {
		this.basicPrice = basicPrice;
	}

	public BigDecimal getStorePrice() {
		return storePrice;
	}

	public void setStorePrice(BigDecimal storePrice) {
		this.storePrice = storePrice;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}

	public BigDecimal getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(BigDecimal realMoney) {
		this.realMoney = realMoney;
	}

	public String getImplStd() {
		return implStd;
	}

	public void setImplStd(String implStd) {
		this.implStd = implStd;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigDecimal getBore() {
		return bore;
	}

	public void setBore(BigDecimal bore) {
		this.bore = bore;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMallMnfct() {
		return mallMnfct;
	}

	public void setMallMnfct(String mallMnfct) {
		this.mallMnfct = mallMnfct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
    
	

}