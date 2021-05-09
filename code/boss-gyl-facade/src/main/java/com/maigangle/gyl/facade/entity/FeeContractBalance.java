package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeeContractBalance implements Serializable{
   

	/**
	 * 
	 */
	private static final long serialVersionUID = -9018865716266663472L;

	/**
     * id
     */
    private String contractBalanceId;

    /**
     * 合同总价
     */
    private BigDecimal contractAmount;

    /**
     * 赎货总价
     */
    private BigDecimal redeemAmount;

    /**
     * 保证金
     */
    private BigDecimal marginFee;

    /**
     * 销项开票金额
     */
    private BigDecimal ransomFee;

    /**
     * 差额
     */
    private BigDecimal balance;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 合同信息
     */
    private String contractId;
    
	private ConContract contract;

    /**
     * id
     * @return CONTRACT_BALANCE_ID id
     */
    public String getContractBalanceId() {
        return contractBalanceId;
    }

    /**
     * id
     * @param contractBalanceId id
     */
    public void setContractBalanceId(String contractBalanceId) {
        this.contractBalanceId = contractBalanceId == null ? null : contractBalanceId.trim();
    }

    /**
     * 合同总价
     * @return CONTRACT_AMOUNT 合同总价
     */
    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    /**
     * 合同总价
     * @param contractAmount 合同总价
     */
    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    /**
     * 赎货总价
     * @return REDEEM_AMOUNT 赎货总价
     */
    public BigDecimal getRedeemAmount() {
        return redeemAmount;
    }

    /**
     * 赎货总价
     * @param redeemAmount 赎货总价
     */
    public void setRedeemAmount(BigDecimal redeemAmount) {
        this.redeemAmount = redeemAmount;
    }

    /**
     * 保证金
     * @return MARGIN_FEE 保证金
     */
    public BigDecimal getMarginFee() {
        return marginFee;
    }

    /**
     * 保证金
     * @param marginFee 保证金
     */
    public void setMarginFee(BigDecimal marginFee) {
        this.marginFee = marginFee;
    }

    /**
     * 赎货总价
     * @return RANSOM_FEE 赎货总价
     */
    public BigDecimal getRansomFee() {
        return ransomFee;
    }

    /**
     * 赎货总价
     * @param ransomFee 赎货总价
     */
    public void setRansomFee(BigDecimal ransomFee) {
        this.ransomFee = ransomFee;
    }

    /**
     * 差额
     * @return BALANCE 差额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 差额
     * @param balance 差额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 创建人
     * @return CREATE_USER 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 创建日期
     * @return CREATE_DATE 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * N:false, Y:true
     * @return IS_DEL N:false, Y:true
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * N:false, Y:true
     * @param isDel N:false, Y:true
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    /**
     * 合同信息
     * @return CONTRACT_ID 合同信息
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 合同信息
     * @param contractId 合同信息
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

	public ConContract getContract() {
		return contract;
	}

	public void setContract(ConContract contract) {
		this.contract = contract;
	}
    
    
    
}