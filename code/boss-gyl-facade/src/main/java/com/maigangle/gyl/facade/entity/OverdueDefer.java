package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OverdueDefer implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8884030604159551580L;

	/**
     * 逾期延期id
     */
    private String overdueDeferId;

    /**
     * 逾期天数
     */
    private BigDecimal overdueDays;

    /**
     * 延期天数
     */
    private BigDecimal deferDays;

    /**
     * 手续费率
     */
    private BigDecimal commissionRate;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 备注
     */
    private String notes;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 存日期时使用
    private Date createDate;

    /**
     * 合同id
     */
    private String contractId;

    /**
     * 逾期延期id
     * @return OVERDUE_DEFER_ID 逾期延期id
     */
    public String getOverdueDeferId() {
        return overdueDeferId;
    }

    /**
     * 逾期延期id
     * @param overdueDeferId 逾期延期id
     */
    public void setOverdueDeferId(String overdueDeferId) {
        this.overdueDeferId = overdueDeferId == null ? null : overdueDeferId.trim();
    }

    /**
     * 逾期天数
     * @return OVERDUE_DAYS 逾期天数
     */
    public BigDecimal getOverdueDays() {
        return overdueDays;
    }

    /**
     * 逾期天数
     * @param overdueDays 逾期天数
     */
    public void setOverdueDays(BigDecimal overdueDays) {
        this.overdueDays = overdueDays;
    }

    /**
     * 延期天数
     * @return DEFER_DAYS 延期天数
     */
    public BigDecimal getDeferDays() {
        return deferDays;
    }

    /**
     * 延期天数
     * @param deferDays 延期天数
     */
    public void setDeferDays(BigDecimal deferDays) {
        this.deferDays = deferDays;
    }

    /**
     * 手续费率
     * @return COMMISSION_RATE 手续费率
     */
    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    /**
     * 手续费率
     * @param commissionRate 手续费率
     */
    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
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
     * 创建时间
     * @return CREATE_DATE 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 合同id
     * @return CONTRACT_ID 合同id
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 合同id
     * @param contractId 合同id
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }
}