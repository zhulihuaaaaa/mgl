package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConDepositDetail implements Serializable {
	
	private static final long serialVersionUID = 8765678903609584136L;

	/**
     * id
     */
    private String depositDetailId;

    /**
     * 合同ID
     */
    private String contractId;

    /**
     * 关联财务单
     */
    private String financeId;

    /**
     * 金额
     */
    private BigDecimal money;

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
     * 备注
     */
    private String notes;

    /**
     * N:未删 Y:已删
     */
    private String isDel;

    /**
     * 状态
     */
    private String state;

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
     * 关联财务单
     * @return FINANCE_ID 关联财务单
     */
    public String getFinanceId() {
        return financeId;
    }

    /**
     * 关联财务单
     * @param financeId 关联财务单
     */
    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }

    /**
     * 金额
     * @return MONEY 金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 金额
     * @param money 金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
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
     * 备注
     * @return NOTES 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 备注
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
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
     * 状态
     * @return STATE 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 状态
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}