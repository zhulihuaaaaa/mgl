package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InsInspectionSub implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7457126145324902351L;

	/**
     * id
     */
    private String inspectionSubId;

    /**
     * 子单单号
     */
    private String subCode;

    /**
     * 验货单主单ID
     */
    private String inspectionId;

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
     * 入库日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 存日期时使用
    private Date instockDate;

    /**
     * 审核状态 0:已提交、1:审核中、2:未通过、3:已通过
     */
    private String auditStatus;

    /**
     * 存货凭证编号
     */
    private String voucherNo;

    /**
     * null
     */
    private String isDel;

    /**
     * 备注
     */
    private String notes;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * null
     */
    private String storageId;

    /**
     * 总数量
     */
    private BigDecimal totalNumber;

    /**
     * 总重量
     */
    private BigDecimal totalWeight;

    /**
     * id
     * @return INSPECTION_SUB_ID id
     */
    public String getInspectionSubId() {
        return inspectionSubId;
    }

    /**
     * id
     * @param inspectionSubId id
     */
    public void setInspectionSubId(String inspectionSubId) {
        this.inspectionSubId = inspectionSubId == null ? null : inspectionSubId.trim();
    }

    /**
     * 子单单号
     * @return SUB_CODE 子单单号
     */
    public String getSubCode() {
        return subCode;
    }

    /**
     * 子单单号
     * @param subCode 子单单号
     */
    public void setSubCode(String subCode) {
        this.subCode = subCode == null ? null : subCode.trim();
    }

    /**
     * 验货单主单ID
     * @return INSPECTION_ID 验货单主单ID
     */
    public String getInspectionId() {
        return inspectionId;
    }

    /**
     * 验货单主单ID
     * @param inspectionId 验货单主单ID
     */
    public void setInspectionId(String inspectionId) {
        this.inspectionId = inspectionId == null ? null : inspectionId.trim();
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
     * 入库日期
     * @return INSTOCK_DATE 入库日期
     */
    public Date getInstockDate() {
        return instockDate;
    }

    /**
     * 入库日期
     * @param instockDate 入库日期
     */
    public void setInstockDate(Date instockDate) {
        this.instockDate = instockDate;
    }

    /**
     * 审核状态 0:已提交、1:审核中、2:未通过、3:已通过
     * @return AUDIT_STATUS 审核状态 0:已提交、1:审核中、2:未通过、3:已通过
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审核状态 0:已提交、1:审核中、2:未通过、3:已通过
     * @param auditStatus 审核状态 0:已提交、1:审核中、2:未通过、3:已通过
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * 存货凭证编号
     * @return VOUCHER_NO 存货凭证编号
     */
    public String getVoucherNo() {
        return voucherNo;
    }

    /**
     * 存货凭证编号
     * @param voucherNo 存货凭证编号
     */
    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo == null ? null : voucherNo.trim();
    }

    /**
     * null
     * @return IS_DEL null
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * null
     * @param isDel null
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
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

    /**
     * null
     * @return STORAGE_ID null
     */
    public String getStorageId() {
        return storageId;
    }

    /**
     * null
     * @param storageId null
     */
    public void setStorageId(String storageId) {
        this.storageId = storageId == null ? null : storageId.trim();
    }

    /**
     * 总数量
     * @return TOTAL_NUMBER 总数量
     */
    public BigDecimal getTotalNumber() {
        return totalNumber;
    }

    /**
     * 总数量
     * @param totalNumber 总数量
     */
    public void setTotalNumber(BigDecimal totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * 总重量
     * @return TOTAL_WEIGHT 总重量
     */
    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    /**
     * 总重量
     * @param totalWeight 总重量
     */
    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }
}