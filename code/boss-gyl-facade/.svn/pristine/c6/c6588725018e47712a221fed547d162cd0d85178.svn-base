package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InApplyRemitDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1919271091258458181L;

	/**
     * id
     */
    private String applyRemitDetailId;

    /**
     * 打款额
     */
    private BigDecimal money;

    /**
     * 打款状态
     */
    private String remitStatus;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd") // 存日期时使用
    private Date createDate;

    /**
     * N:未删 Y:已删
     */
    private String isDel;

    /**
     * 入库单ID
     */
    private String instockId;

    /**
     * null
     */
    private String notes;

    /**
     * 财务单ID
     */
    private String financeId;

    /**
     * id
     * @return APPLY_REMIT_DETAIL_ID id
     */
    public String getApplyRemitDetailId() {
        return applyRemitDetailId;
    }

    /**
     * id
     * @param applyRemitDetailId id
     */
    public void setApplyRemitDetailId(String applyRemitDetailId) {
        this.applyRemitDetailId = applyRemitDetailId == null ? null : applyRemitDetailId.trim();
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
     * 打款状态
     * @return REMIT_STATUS 打款状态
     */
    public String getRemitStatus() {
        return remitStatus;
    }

    /**
     * 打款状态
     * @param remitStatus 打款状态
     */
    public void setRemitStatus(String remitStatus) {
        this.remitStatus = remitStatus == null ? null : remitStatus.trim();
    }

    /**
     * 审核状态
     * @return AUDIT_STATUS 审核状态
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审核状态
     * @param auditStatus 审核状态
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
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
     * 入库单ID
     * @return INSTOCK_ID 入库单ID
     */
    public String getInstockId() {
        return instockId;
    }

    /**
     * 入库单ID
     * @param instockId 入库单ID
     */
    public void setInstockId(String instockId) {
        this.instockId = instockId == null ? null : instockId.trim();
    }

    /**
     * null
     * @return NOTES null
     */
    public String getNotes() {
        return notes;
    }

    /**
     * null
     * @param notes null
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * 财务单ID
     * @return FINANCE_ID 财务单ID
     */
    public String getFinanceId() {
        return financeId;
    }

    /**
     * 财务单ID
     * @param financeId 财务单ID
     */
    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }
}