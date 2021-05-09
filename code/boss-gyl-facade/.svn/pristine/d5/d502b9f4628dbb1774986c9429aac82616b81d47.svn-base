package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeeDepositDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1737062210264427464L;

	/**
     * id
     */
    private String depositDetailId;

    /**
     * 消费金额
     */
    private BigDecimal usedFee;

    /**
     * 剩余保证金
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
     * 关联合同id
     */
    private String contractId;

    /**
     * 关联保证金账户id
     */
    private String depositAccountId;

    /**
     * id
     * @return DEPOSIT_DETAIL_ID id
     */
    public String getDepositDetailId() {
        return depositDetailId;
    }

    /**
     * id
     * @param depositDetailId id
     */
    public void setDepositDetailId(String depositDetailId) {
        this.depositDetailId = depositDetailId == null ? null : depositDetailId.trim();
    }

    /**
     * 消费金额
     * @return USED_FEE 消费金额
     */
    public BigDecimal getUsedFee() {
        return usedFee;
    }

    /**
     * 消费金额
     * @param usedFee 消费金额
     */
    public void setUsedFee(BigDecimal usedFee) {
        this.usedFee = usedFee;
    }

    /**
     * 剩余保证金
     * @return BALANCE 剩余保证金
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 剩余保证金
     * @param balance 剩余保证金
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
     * 关联合同id
     * @return CONTRACT_ID 关联合同id
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 关联合同id
     * @param contractId 关联合同id
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 关联保证金账户id
     * @return DEPOSIT_ACCOUNT_ID 关联保证金账户id
     */
    public String getDepositAccountId() {
        return depositAccountId;
    }

    /**
     * 关联保证金账户id
     * @param depositAccountId 关联保证金账户id
     */
    public void setDepositAccountId(String depositAccountId) {
        this.depositAccountId = depositAccountId == null ? null : depositAccountId.trim();
    }
}