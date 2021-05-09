package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InsInspectionBill implements Serializable {
    /**
     * id
     */
    private String inspectionBillId;

    /**
     * 入库单ID
     */
    private String instockId;

    /**
     * 验货单号
     */
    private String inspectionBillCode;

    /**
     * 合同ID
     */
    private String contractId;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;

    /**
     * 验货信息
     */
    private String inspectionInfo;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 验货状态
     */
    private String inspectionStatus;

    /**
     * null
     */
    private String storageId;

    /**
     * null
     */
    private String businessType;

    /**
     * id
     * @return INSPECTION_BILL_ID id
     */
    public String getInspectionBillId() {
        return inspectionBillId;
    }

    /**
     * id
     * @param inspectionBillId id
     */
    public void setInspectionBillId(String inspectionBillId) {
        this.inspectionBillId = inspectionBillId == null ? null : inspectionBillId.trim();
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
     * 验货单号
     * @return INSPECTION_BILL_CODE 验货单号
     */
    public String getInspectionBillCode() {
        return inspectionBillCode;
    }

    /**
     * 验货单号
     * @param inspectionBillCode 验货单号
     */
    public void setInspectionBillCode(String inspectionBillCode) {
        this.inspectionBillCode = inspectionBillCode == null ? null : inspectionBillCode.trim();
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
     * 验货信息
     * @return INSPECTION_INFO 验货信息
     */
    public String getInspectionInfo() {
        return inspectionInfo;
    }

    /**
     * 验货信息
     * @param inspectionInfo 验货信息
     */
    public void setInspectionInfo(String inspectionInfo) {
        this.inspectionInfo = inspectionInfo == null ? null : inspectionInfo.trim();
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
     * 验货状态
     * @return INSPECTION_STATUS 验货状态
     */
    public String getInspectionStatus() {
        return inspectionStatus;
    }

    /**
     * 验货状态
     * @param inspectionStatus 验货状态
     */
    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus == null ? null : inspectionStatus.trim();
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
     * null
     * @return BUSINESS_TYPE null
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * null
     * @param businessType null
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }
}