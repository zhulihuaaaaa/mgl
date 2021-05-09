package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.ConContractDetail;

public class ConContractDetailDto extends ConContractDetail implements Serializable {

	private static final long serialVersionUID = -5307116126148404815L;
	
	/**
	 * 入库日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
	private Date startStorageDate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
	private Date endStorageDate;
	
	 /**
     * 长度
     */
    private BigDecimal minGoodsLength;
    private BigDecimal maxGoodsLength;
    
    /**
     * 参厚
     */
    private BigDecimal minReferThick;
    private BigDecimal maxReferThick;
    
    /**
     * 实宽
     */
    private BigDecimal minRealWidth;
    private BigDecimal maxRealWidth;
    
    /**
     * 净重
     */
    private BigDecimal minNetWeight;
    private BigDecimal maxNetWeight;
	
    /**
     * 数量（张/卷）
     */
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    
    /**
     * 合同单价（元/kg）
     */
    private BigDecimal minUnitContractPrice;
    private BigDecimal maxUnitContractPrice;

    /**
     * 实际单价（元/kg）
     */
    private BigDecimal minRealUnitPrice;
    private BigDecimal maxRealUnitPrice;
    
    /**
     * 升贴水
     */
    private BigDecimal minFloatPrice;
    private BigDecimal maxFloatPrice;

    /**
     * 基价
     */
    private BigDecimal minBasicPrice;
    private BigDecimal maxBasicPrice;

    /**
     * 商城价
     */
    private BigDecimal minStorePrice;
    private BigDecimal maxStorePrice;

    /**
     * 待解锁数量
     */
    private BigDecimal minNextUnlockQuantity;
    private BigDecimal maxNextUnlockQuantity;

    /**
     * 待出库数量
     */
    private BigDecimal minNextOutstockQuantity;
    private BigDecimal maxNextOutstockQuantity;

    /**
     * 合同金额
     */
    private BigDecimal minContractMoney;
    private BigDecimal maxContractMoney;

    /**
     * 实际金额
     */
    private BigDecimal minRealMoney;
    private BigDecimal maxRealMoney;
    
    /**
     * 内径
     */
    private BigDecimal minBore;
    private BigDecimal maxBore;
	public Date getStartStorageDate() {
		return startStorageDate;
	}
	public Date getEndStorageDate() {
		return endStorageDate;
	}
	public BigDecimal getMinGoodsLength() {
		return minGoodsLength;
	}
	public BigDecimal getMaxGoodsLength() {
		return maxGoodsLength;
	}
	public BigDecimal getMinReferThick() {
		return minReferThick;
	}
	public BigDecimal getMaxReferThick() {
		return maxReferThick;
	}
	public BigDecimal getMinRealWidth() {
		return minRealWidth;
	}
	public BigDecimal getMaxRealWidth() {
		return maxRealWidth;
	}
	public BigDecimal getMinNetWeight() {
		return minNetWeight;
	}
	public BigDecimal getMaxNetWeight() {
		return maxNetWeight;
	}
	public BigDecimal getMinAmount() {
		return minAmount;
	}
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}
	public BigDecimal getMinUnitContractPrice() {
		return minUnitContractPrice;
	}
	public BigDecimal getMaxUnitContractPrice() {
		return maxUnitContractPrice;
	}
	public BigDecimal getMinRealUnitPrice() {
		return minRealUnitPrice;
	}
	public BigDecimal getMaxRealUnitPrice() {
		return maxRealUnitPrice;
	}
	public BigDecimal getMinFloatPrice() {
		return minFloatPrice;
	}
	public BigDecimal getMaxFloatPrice() {
		return maxFloatPrice;
	}
	public BigDecimal getMinBasicPrice() {
		return minBasicPrice;
	}
	public BigDecimal getMaxBasicPrice() {
		return maxBasicPrice;
	}
	public BigDecimal getMinStorePrice() {
		return minStorePrice;
	}
	public BigDecimal getMaxStorePrice() {
		return maxStorePrice;
	}
	public BigDecimal getMinNextUnlockQuantity() {
		return minNextUnlockQuantity;
	}
	public BigDecimal getMaxNextUnlockQuantity() {
		return maxNextUnlockQuantity;
	}
	public BigDecimal getMinNextOutstockQuantity() {
		return minNextOutstockQuantity;
	}
	public BigDecimal getMaxNextOutstockQuantity() {
		return maxNextOutstockQuantity;
	}
	public BigDecimal getMinContractMoney() {
		return minContractMoney;
	}
	public BigDecimal getMaxContractMoney() {
		return maxContractMoney;
	}
	public BigDecimal getMinRealMoney() {
		return minRealMoney;
	}
	public BigDecimal getMaxRealMoney() {
		return maxRealMoney;
	}
	public BigDecimal getMinBore() {
		return minBore;
	}
	public BigDecimal getMaxBore() {
		return maxBore;
	}
	public void setStartStorageDate(Date startStorageDate) {
		this.startStorageDate = startStorageDate;
	}
	public void setEndStorageDate(Date endStorageDate) {
		this.endStorageDate = endStorageDate;
	}
	public void setMinGoodsLength(BigDecimal minGoodsLength) {
		this.minGoodsLength = minGoodsLength;
	}
	public void setMaxGoodsLength(BigDecimal maxGoodsLength) {
		this.maxGoodsLength = maxGoodsLength;
	}
	public void setMinReferThick(BigDecimal minReferThick) {
		this.minReferThick = minReferThick;
	}
	public void setMaxReferThick(BigDecimal maxReferThick) {
		this.maxReferThick = maxReferThick;
	}
	public void setMinRealWidth(BigDecimal minRealWidth) {
		this.minRealWidth = minRealWidth;
	}
	public void setMaxRealWidth(BigDecimal maxRealWidth) {
		this.maxRealWidth = maxRealWidth;
	}
	public void setMinNetWeight(BigDecimal minNetWeight) {
		this.minNetWeight = minNetWeight;
	}
	public void setMaxNetWeight(BigDecimal maxNetWeight) {
		this.maxNetWeight = maxNetWeight;
	}
	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}
	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}
	public void setMinUnitContractPrice(BigDecimal minUnitContractPrice) {
		this.minUnitContractPrice = minUnitContractPrice;
	}
	public void setMaxUnitContractPrice(BigDecimal maxUnitContractPrice) {
		this.maxUnitContractPrice = maxUnitContractPrice;
	}
	public void setMinRealUnitPrice(BigDecimal minRealUnitPrice) {
		this.minRealUnitPrice = minRealUnitPrice;
	}
	public void setMaxRealUnitPrice(BigDecimal maxRealUnitPrice) {
		this.maxRealUnitPrice = maxRealUnitPrice;
	}
	public void setMinFloatPrice(BigDecimal minFloatPrice) {
		this.minFloatPrice = minFloatPrice;
	}
	public void setMaxFloatPrice(BigDecimal maxFloatPrice) {
		this.maxFloatPrice = maxFloatPrice;
	}
	public void setMinBasicPrice(BigDecimal minBasicPrice) {
		this.minBasicPrice = minBasicPrice;
	}
	public void setMaxBasicPrice(BigDecimal maxBasicPrice) {
		this.maxBasicPrice = maxBasicPrice;
	}
	public void setMinStorePrice(BigDecimal minStorePrice) {
		this.minStorePrice = minStorePrice;
	}
	public void setMaxStorePrice(BigDecimal maxStorePrice) {
		this.maxStorePrice = maxStorePrice;
	}
	public void setMinNextUnlockQuantity(BigDecimal minNextUnlockQuantity) {
		this.minNextUnlockQuantity = minNextUnlockQuantity;
	}
	public void setMaxNextUnlockQuantity(BigDecimal maxNextUnlockQuantity) {
		this.maxNextUnlockQuantity = maxNextUnlockQuantity;
	}
	public void setMinNextOutstockQuantity(BigDecimal minNextOutstockQuantity) {
		this.minNextOutstockQuantity = minNextOutstockQuantity;
	}
	public void setMaxNextOutstockQuantity(BigDecimal maxNextOutstockQuantity) {
		this.maxNextOutstockQuantity = maxNextOutstockQuantity;
	}
	public void setMinContractMoney(BigDecimal minContractMoney) {
		this.minContractMoney = minContractMoney;
	}
	public void setMaxContractMoney(BigDecimal maxContractMoney) {
		this.maxContractMoney = maxContractMoney;
	}
	public void setMinRealMoney(BigDecimal minRealMoney) {
		this.minRealMoney = minRealMoney;
	}
	public void setMaxRealMoney(BigDecimal maxRealMoney) {
		this.maxRealMoney = maxRealMoney;
	}
	public void setMinBore(BigDecimal minBore) {
		this.minBore = minBore;
	}
	public void setMaxBore(BigDecimal maxBore) {
		this.maxBore = maxBore;
	}
    
}