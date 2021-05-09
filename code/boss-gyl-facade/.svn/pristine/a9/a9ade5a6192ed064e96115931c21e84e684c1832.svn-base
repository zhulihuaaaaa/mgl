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

@ExcelTarget("ConContractExcel")
public class ConContractExcel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2269408578427086158L;

	/**
     * id
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
     * 签订日期
     */
    @Excel(name = "签订日期" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date signDate;

    /**
     * 业务类型
     */
    @Excel(name = "业务类型", replace={"定向销售_C","货押融资_H","采购自销_X","仓单质押_D"}, needMerge = true)
    private String contractType;

    /**
     * 卖方信息
     * 甲方
     */
    @Excel(name = "甲方", width = 30)
    private String sellerName;
    
    /**
     * 买方信息
     * 乙方
     */
    @Excel(name = "乙方", width = 30)
    private String buyerName;
    
    /**
     * 供应方
     */
    @Excel(name = "供应方", width = 30)
    private String mallMnfct;
    
    /**
     * 合约状态 1:审核中 2:履约中 3:已完成
     */
    @Excel(name = "合约状态", replace={"审核中_A","履约中_B","已完成_C","已作废_D","已结束_E"}, needMerge = true)
    private String contractState;
    
    /**
     * 合同期限（天）
     */
    @Excel(name = "合同期限（天）", needMerge = true)
    private BigDecimal contractPeriod;
    
    /**
     * 创建人
     */
    @Excel(name = "创建人", needMerge = true)
    private String createUser;

    /**
     * 创建日期
     */
	@Excel(name = "创建日期", width = 30,exportFormat="yyyy-MM-dd HH:mm:ss" , needMerge = true )
    private Date createDate;
    
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

	public String getContractState() {
		return contractState;
	}

	public void setContractState(String contractState) {
		this.contractState = contractState;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public BigDecimal getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(BigDecimal contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getMallMnfct() {
		return mallMnfct;
	}

	public void setMallMnfct(String mallMnfct) {
		this.mallMnfct = mallMnfct;
	}

}