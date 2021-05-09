package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeeDepositAccount implements Serializable{
	private static final long serialVersionUID = 7388356379405852174L;

	/**
     * id
     */
    private String depositAccountId;

    /**
     * 客户信息
     */
    private String buyerId;

    /**
     * 关联合同信息
     */
    private String contractId;

    /**
     * 关联保证金财务单
     */
    private String financeId;

    /**
     * 保证金金额
     */
    private BigDecimal depositFee;

    /**
     * 剩余金额
     */
    private BigDecimal balance;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * id
     * @return DEPOSIT_ACCOUNT_ID id
     */
    public String getDepositAccountId() {
        return depositAccountId;
    }

    /**
     * id
     * @param depositAccountId id
     */
    public void setDepositAccountId(String depositAccountId) {
        this.depositAccountId = depositAccountId == null ? null : depositAccountId.trim();
    }

    /**
     * 客户信息
     * @return BUYER_ID 客户信息
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * 客户信息
     * @param buyerId 客户信息
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    /**
     * 关联合同信息
     * @return CONTRACT_ID 关联合同信息
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 关联合同信息
     * @param contractId 关联合同信息
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 关联保证金财务单
     * @return FINANCE_ID 关联保证金财务单
     */
    public String getFinanceId() {
        return financeId;
    }

    /**
     * 关联保证金财务单
     * @param financeId 关联保证金财务单
     */
    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }

    /**
     * 保证金金额
     * @return DEPOSIT_FEE 保证金金额
     */
    public BigDecimal getDepositFee() {
        return depositFee;
    }

    /**
     * 保证金金额
     * @param depositFee 保证金金额
     */
    public void setDepositFee(BigDecimal depositFee) {
        this.depositFee = depositFee;
    }

    /**
     * 剩余金额
     * @return BALANCE 剩余金额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 剩余金额
     * @param balance 剩余金额
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
     * 业务类型
     * @return BUSINESS_TYPE 业务类型
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型
     * @param businessType 业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }
}