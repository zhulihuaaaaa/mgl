package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InContractRemitDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6193024551572448451L;

	/**
     * id
     */
    private String contractRemitDetiailId;

    /**
     * 打款额
     */
    private BigDecimal money;

    /**
     * 合同ID
     */
    private String contractId;

    /**
     * 打款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd") // 存日期时使用
    private Date remitDate;

    /**
     * N:未删 Y:已删
     */
    private String isDel;

    /**
     * 剩余打款额
     */
    private BigDecimal balance;

    /**
     * id
     * @return CONTRACT_REMIT_DETIAIL_ID id
     */
    public String getContractRemitDetiailId() {
        return contractRemitDetiailId;
    }

    /**
     * id
     * @param contractRemitDetiailId id
     */
    public void setContractRemitDetiailId(String contractRemitDetiailId) {
        this.contractRemitDetiailId = contractRemitDetiailId == null ? null : contractRemitDetiailId.trim();
    }

    /**
     * 打款额
     * @return MONEY 打款额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 打款额
     * @param money 打款额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

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

    /**
     * 打款时间
     * @return REMIT_DATE 打款时间
     */
    public Date getRemitDate() {
        return remitDate;
    }

    /**
     * 打款时间
     * @param remitDate 打款时间
     */
    public void setRemitDate(Date remitDate) {
        this.remitDate = remitDate;
    }

    /**
     * N:未删 Y:已删
     * @return IS_DEL N:未删 Y:已删
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * N:未删 Y:已删
     * @param isDel N:未删 Y:已删
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    /**
     * 剩余打款额
     * @return BALANCE 剩余打款额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 剩余打款额
     * @param balance 剩余打款额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}