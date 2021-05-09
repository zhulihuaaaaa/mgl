package com.maigangle.gyl.facade.entity.excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.api.CrmClient;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("ConContractBalanceExcel")
public class ConContractBalanceExcel implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3084949795696342499L;

	/**
     * id
     */
    private String contractBalanceId;

    /**
     * 合同信息id
     */
    private String contractId;

    /**
     * 合同自编号
     */
    @Excel(name = "合同自编号", needMerge = true)
    private String contractCode;

    /**
     * 合同编号
     */
    @Excel(name = "合同编号", width = 20, needMerge = true)
    private String contractNo;

    /**
     * 合同总价
     */
    @Excel(name = "合同总价", needMerge = true)
    private BigDecimal contractAmount;

    /**
     * 赎货总价
     */
    @Excel(name = "赎货总价", needMerge = true)
    private BigDecimal redeemAmount;

    /**
     * 保证金
     */
    @Excel(name = "保证金", needMerge = true)
    private BigDecimal marginFee;

    /**
     * 销项开票金额
     */
    @Excel(name = "销项开票金额", needMerge = true)
    private BigDecimal ransomFee;

    /**
     * 差额
     */
    @Excel(name = "差额", needMerge = true)
    private BigDecimal balance;

    /**
     * 创建人
     */
    @Excel(name = "创建人", needMerge = true)
    private String createUser;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
	@Excel(name = "创建日期", width = 30,exportFormat="yyyy-MM-dd HH:mm:ss" , needMerge = true )
    private Date createDate;

    /**
     * N:false, Y:true
     */
    private String isDel;

	public String getContractBalanceId() {
		return contractBalanceId;
	}

	public void setContractBalanceId(String contractBalanceId) {
		this.contractBalanceId = contractBalanceId;
	}

	public BigDecimal getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}

	public BigDecimal getRedeemAmount() {
		return redeemAmount;
	}

	public void setRedeemAmount(BigDecimal redeemAmount) {
		this.redeemAmount = redeemAmount;
	}

	public BigDecimal getMarginFee() {
		return marginFee;
	}

	public void setMarginFee(BigDecimal marginFee) {
		this.marginFee = marginFee;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
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

	public BigDecimal getRansomFee() {
		return ransomFee;
	}

	public void setRansomFee(BigDecimal ransomFee) {
		this.ransomFee = ransomFee;
	}

    
    
}