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

@ExcelTarget("OutOutstockDetailExcel")
public class OutOutstockDetailExcel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9055039725031027115L;
	
	/**
     * id
     */
    private String outstockDetailId;

    /**
     * 提货单单号
     */
    @Excel(name = "提货单单号", needMerge = true)
    private String outstockCode;
	
	/**
     * 合同id
     */
    private String contractId;

    /**
     * 卖方信息
     */
    private String sellerId;

    /**
     * 买方信息
     */
    private String buyerId;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 入库日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date storageDate;

    /**
     * 存放仓库
     */
    private String storageId;
    
    /**
     * 品类
     */
    @Excel(name = "品类", needMerge = true)
    private String productName;

    /**
     * 材质（钢种）
     */
    @Excel(name = "材质", needMerge = true)
    private String materialId;

    /**
     * 表面
     */
    @Excel(name = "表面", needMerge = true)
    private String surfaceId;

    /**
     * 标签厚度
     */
    @Excel(name = "规格(mm)", needMerge = true, width = 20)
    private String labelThick;

    /**
     * 内径
     */
    private BigDecimal bore;

    /**
     * 待解锁数量
     */
    private BigDecimal nextUnlockQuantity;

    /**
     * 待出库数量
     */
    private BigDecimal nextOutstockQuantity;

    /**
     * 标签宽度
     */
    private String labelWidth;

    /**
     * 长度
     */
    private String goodsLength;

    /**
     * 边部
     */
    @Excel(name = "边部", needMerge = true)
    private String edge;

    /**
     * 参厚
     */
    @Excel(name = "参厚", needMerge = true)
    private BigDecimal referThick;

    /**
     * 实宽
     */
    @Excel(name = "实宽", needMerge = true)
    private BigDecimal realWidth;

    /**
     * 牌号
     */
    @Excel(name = "牌号", needMerge = true)
    private String trademark;

    /**
     * 卷号
     */
    @Excel(name = "卷号", needMerge = true)
    private String goodsVolume;

    /**
     * 厂家
     */
    private String mnfctId;

    /**
     * 净重
     */
    @Excel(name = "重量", needMerge = true)
    private String netWeight;

    /**
     * 数量（张/卷）
     */
    @Excel(name = "数量", needMerge = true)
    private String amount;

    /**
     * 计算方式
     */
    private String calcMethod;

    /**
     * 等级
     */
    @Excel(name = "等级", needMerge = true)
    private String grade;

    /**
     * 合同单价（元/kg）
     */
    private BigDecimal contractUnitPrice;

    /**
     * 实际单价（元/kg）
     */
    private BigDecimal realUnitPrice;

    /**
     * 升贴水
     */
    private BigDecimal floatPrice;

    /**
     * 基价
     */
    private BigDecimal basicPrice;

    /**
     * 商城价
     */
    private BigDecimal storePrice;

    /**
     * 合同金额
     */
    private BigDecimal contractMoney;

    /**
     * 实际金额
     */
    private BigDecimal realMoney;

    /**
     * 执行标准
     */
    private String implStd;

    /**
     * 服务费用
     */
    private BigDecimal serviceFee;

    /**
     * 发票费用
     */
    private BigDecimal invoiceFee;

    /**
     * 其他费用
     */
    private BigDecimal otherFee;

    /**
     * 赎货金额
     */
    private BigDecimal redeemMoney;

    /**
     * 备注
     */
    private String notes;

    /**
     * N:否 Y:是
     */
    private String isDel;

    /**
     * 提货单主单id
     */
    private String outstockBillId;

    /**
     * 库存id
     */
    private String inventoryId;

    /**
     * 赎货详情单id
     */
    private String redeemDetailId;

	public String getOutstockDetailId() {
		return outstockDetailId;
	}

	public void setOutstockDetailId(String outstockDetailId) {
		this.outstockDetailId = outstockDetailId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Date getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public BigDecimal getBore() {
		return bore;
	}

	public void setBore(BigDecimal bore) {
		this.bore = bore;
	}

	public BigDecimal getNextUnlockQuantity() {
		return nextUnlockQuantity;
	}

	public void setNextUnlockQuantity(BigDecimal nextUnlockQuantity) {
		this.nextUnlockQuantity = nextUnlockQuantity;
	}

	public BigDecimal getNextOutstockQuantity() {
		return nextOutstockQuantity;
	}

	public void setNextOutstockQuantity(BigDecimal nextOutstockQuantity) {
		this.nextOutstockQuantity = nextOutstockQuantity;
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

	public String getGoodsVolume() {
		return goodsVolume;
	}

	public void setGoodsVolume(String goodsVolume) {
		this.goodsVolume = goodsVolume;
	}

	public String getMnfctId() {
		return mnfctId;
	}

	public void setMnfctId(String mnfctId) {
		this.mnfctId = mnfctId;
	}

	public String getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public BigDecimal getContractUnitPrice() {
		return contractUnitPrice;
	}

	public void setContractUnitPrice(BigDecimal contractUnitPrice) {
		this.contractUnitPrice = contractUnitPrice;
	}

	public BigDecimal getRealUnitPrice() {
		return realUnitPrice;
	}

	public void setRealUnitPrice(BigDecimal realUnitPrice) {
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

	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public BigDecimal getInvoiceFee() {
		return invoiceFee;
	}

	public void setInvoiceFee(BigDecimal invoiceFee) {
		this.invoiceFee = invoiceFee;
	}

	public BigDecimal getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public BigDecimal getRedeemMoney() {
		return redeemMoney;
	}

	public void setRedeemMoney(BigDecimal redeemMoney) {
		this.redeemMoney = redeemMoney;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getOutstockBillId() {
		return outstockBillId;
	}

	public void setOutstockBillId(String outstockBillId) {
		this.outstockBillId = outstockBillId;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getRedeemDetailId() {
		return redeemDetailId;
	}

	public void setRedeemDetailId(String redeemDetailId) {
		this.redeemDetailId = redeemDetailId;
	}

	public String getOutstockCode() {
		return outstockCode;
	}

	public void setOutstockCode(String outstockCode) {
		this.outstockCode = outstockCode;
	}
    
	

}