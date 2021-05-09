package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.OutOutstockBill;
import com.maigangle.gyl.facade.entity.OutOutstockDetail;
import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
/**
 * 提货-选择货物用货物VO
 * @author 张渊
 * @since 2018年1月5日 下午6:40:59
 * @version 1.0
 */
public class RedRedeemGoodsVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8712953070563233296L;
	/**
	 * ID
	 */
	private String outstockBillId;

	/**
	 * 库存ID
	 */
	private String inventoryId;
	/**
	 * 赎货单货物明细ID
	 */
	private String redeemDetailId;
	/**
	 * 赎货单主单ID
	 */
	private String redeemBillId;

    /**
     * 对应合同
     */
    private String contractId;
    /**
     * 提货人
     */
    private String consignee;

    /**
     * 提货人电话
     */
    private String consigneeTel;

    /**
     * 提货人身份证号
     */
    private String consigneeIdNo;
    /**
     * 车牌号
     */
    private String carNumber;
    /**
     * 卖方信息
     */
    private String sellerId;
	
    /**
     * 买方客户
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
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 存日期时使用
    private Date storageDate;

    /**
     * 存放仓库
     */
    private String storageId;

    /**
     * 存放仓库名称
     */
    private String storageName;

    /**
     * 品名
     */
    private String productId;
    /**
     * 品名信息
     */
    private BaseProduct baseProduct;

    /**
     * 材质（钢种）
     */
    private String materialId;

    /**
     * 表面
     */
    private String surfaceId;

    /**
     * 标签厚度
     */
    private String labelThick;

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
    private String edge;

    /**
     * 参厚
     */
    private BigDecimal referThick;

    /**
     * 实宽
     */
    private BigDecimal realWidth;

    /**
     * 牌号
     */
    private String trademark;

    /**
     * 卷号
     */
    private String goodsVolume;

    /**
     * 厂家
     */
    private String mnfctId;

    /**
     * 净重
     */
    private BigDecimal netWeight;

    /**
     * 数量（张/卷）
     */
    private BigDecimal amount;

    /**
     * 计算方式
     */
    private String calcMethod;

    /**
     * 等级
     */
    private String grade;

    /**
     * 执行标准
     */
    private String implStd;

    /**
     * 备注
     */
    private String notes;

    /**
     * 内径
     */
    private BigDecimal bore;
	/**
	 * 赎货重量
	 */
	private BigDecimal redWeight;
	
    private List<OutOutstockDetail> detail;
    
	private OutOutstockBill entity;

	


	
	public BigDecimal getRedWeight() {
		return redWeight;
	}

	public void setRedWeight(BigDecimal redWeight) {
		this.redWeight = redWeight;
	}

	public String getOutstockBillId() {
		return outstockBillId;
	}

	public void setOutstockBillId(String outstockBillId) {
		this.outstockBillId = outstockBillId;
	}
	
	public BaseProduct getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
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

	public String getRedeemBillId() {
		return redeemBillId;
	}

	public void setRedeemBillId(String redeemBillId) {
		this.redeemBillId = redeemBillId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeTel() {
		return consigneeTel;
	}

	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}

	public String getConsigneeIdNo() {
		return consigneeIdNo;
	}

	public void setConsigneeIdNo(String consigneeIdNo) {
		this.consigneeIdNo = consigneeIdNo;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
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


	public OutOutstockBill getEntity() {
		return entity;
	}

	public void setEntity(OutOutstockBill entity) {
		this.entity = entity;
	}

	public List<OutOutstockDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<OutOutstockDetail> detail) {
		this.detail = detail;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
    
}
