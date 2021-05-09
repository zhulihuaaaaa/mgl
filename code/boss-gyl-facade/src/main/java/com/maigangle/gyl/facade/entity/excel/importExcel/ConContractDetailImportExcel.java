package com.maigangle.gyl.facade.entity.excel.importExcel;

import java.io.Serializable;
import java.math.BigDecimal;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ConContractDetailImportExcel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3259021185397244304L;

	/**
     * 品类
     */
    @Excel(name = "*品类", orderNum = "1" ,needMerge = true)
    private String productName;

    /**
     * 材质
     */
    @Excel(name = "*材质",orderNum = "2" , needMerge = true)
    private String materialId;

    /**
     * 表面
     */
    @Excel(name = "表面",orderNum = "3" , needMerge = true)
    private String surfaceId;
    @Excel(name = "*厚度", orderNum = "4" ,needMerge = true, width = 20)
    private String labelThick;
    
    @Excel(name = "*宽度", orderNum = "5" ,needMerge = true, width = 20)
    private String labelWidth;
    @Excel(name = "长度", orderNum = "6" ,needMerge = true, width = 20)
    private String goodsLength;
    @Excel(name = "参厚", orderNum = "7" ,needMerge = true, width = 20)
    private BigDecimal referThick;
    
    @Excel(name = "边部", orderNum = "8" ,needMerge = true, width = 20)
    private String edge;
    @Excel(name = "厂家", orderNum = "9" ,needMerge = true, width = 20)
    private String mnfctId;
    @Excel(name = "*数量", orderNum = "10" ,needMerge = true, width = 20)
    private BigDecimal amount;
    @Excel(name = "*重量", orderNum = "11" ,needMerge = true, width = 20)
    private BigDecimal netWeight;
    
    /**
     * 含税单价
     */
    @Excel(name = "*含税单价",orderNum = "12", needMerge = true)
    private BigDecimal unitContractPrice;

    /**
     * 含税金额
     */
    @Excel(name = "*金额(元)", orderNum = "13	",needMerge = true)
    private BigDecimal contractMoney;

    @Excel(name = "备注", orderNum = "11" ,needMerge = true, width = 20)
    private String notes;

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

	public BigDecimal getReferThick() {
		return referThick;
	}

	public void setReferThick(BigDecimal referThick) {
		this.referThick = referThick;
	}

	public String getEdge() {
		return edge;
	}

	public void setEdge(String edge) {
		this.edge = edge;
	}

	public String getMnfctId() {
		return mnfctId;
	}

	public void setMnfctId(String mnfctId) {
		this.mnfctId = mnfctId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public BigDecimal getUnitContractPrice() {
		return unitContractPrice;
	}

	public void setUnitContractPrice(BigDecimal unitContractPrice) {
		this.unitContractPrice = unitContractPrice;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "ConContractDetailImportExcel [productName=" + productName + ", materialId=" + materialId
				+ ", surfaceId=" + surfaceId + ", labelThick=" + labelThick + ", labelWidth=" + labelWidth
				+ ", goodsLength=" + goodsLength + ", referThick=" + referThick + ", edge=" + edge + ", mnfctId="
				+ mnfctId + ", amount=" + amount + ", netWeight=" + netWeight + ", unitContractPrice="
				+ unitContractPrice + ", contractMoney=" + contractMoney + ", notes=" + notes + "]";
	}

    
}