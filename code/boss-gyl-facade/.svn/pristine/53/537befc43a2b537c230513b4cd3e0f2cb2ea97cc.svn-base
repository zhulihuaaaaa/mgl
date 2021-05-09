package com.maigangle.gyl.facade.entity.excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ConContractDetailExcel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4450865451117751627L;

    /**
     * 合同ID
     */
    private String contractId;

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
     * 品类
     */
    @Excel(name = "品类", needMerge = true)
    private String productName;

    /**
     * 材质
     */
    @Excel(name = "材质", needMerge = true)
    private String materialId;

    /**
     * 表面
     */
    @Excel(name = "表面", needMerge = true)
    private String surfaceId;

    /**
     * 标签厚度*标签宽度*长度
     */
    @Excel(name = "规格(mm)", needMerge = true, width = 20)
    private String specification;

    /**
     * 边部
     */
    @Excel(name = "边部", needMerge = true)
    private String edge;

    /**
     * 数量（张/卷）
     */
    @Excel(name = "数量", needMerge = true)
    private String amount;
    
    /**
     * 重量
     */
    @Excel(name = "重量", needMerge = true)
    private String netWeight;

    /**
     * 含税单价
     */
    @Excel(name = "含税单价", needMerge = true)
    private String unitContractPrice;

    /**
     * 含税金额
     */
    @Excel(name = "含税金额(元)", needMerge = true)
    private BigDecimal contractMoney;

    /**
     * 合同ID
     * @return CONTRACT_ID 合同ID
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 合同ID
     * @param contractId 合同ID
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
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

	/**
     * 边部
     * @return EDGE 边部
     */
    public String getEdge() {
        return edge;
    }

    /**
     * 边部
     * @param edge 边部
     */
    public void setEdge(String edge) {
        this.edge = edge == null ? null : edge.trim();
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

    public String getUnitContractPrice() {
		return unitContractPrice;
	}

	public void setUnitContractPrice(String unitContractPrice) {
		this.unitContractPrice = unitContractPrice;
	}

	/**
     * 合同金额
     * @return CONTRACT_MONEY 合同金额
     */
    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    /**
     * 合同金额
     * @param contractMoney 合同金额
     */
    public void setContractMoney(BigDecimal contractMoney) {
        this.contractMoney = contractMoney;
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

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
    
    
}