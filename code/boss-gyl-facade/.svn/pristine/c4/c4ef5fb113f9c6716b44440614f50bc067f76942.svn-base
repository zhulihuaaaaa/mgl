package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InInstockBill implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8638355990148716909L;

	/**
     * id
     */
    private String instockBillId;

    /**
     * 入库单号
     */
    private String instockCode;

    /**
     * 合同ID
     */
    private String contractId;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 存日期时使用
    private Date createDate;

    /**
     * 保证金状态 0:未到账 1:已到账
系统生成保证金收费记录，财务人员需确认到账后填入实际到账金额，然后保存，完成保证金流程
     */
    private String depositStatus;

    /**
     * 保证金财务单ID
     */
    private String depositFinanceId;

    /**
     * 验货入库状态 N:未入库 Y:已入库

详见交收管里
     */
    private String inspectionStatus;

    /**
     * 融资货款状态 0:未打款 1:部分货款 2:全部货款
     */
    private String financingLoanStatus;

    /**
     * 钢厂货款状态 0:未打款 1:部分货款 2:全部货款
		定向销售及采购自销使用字段
     */
    private String paymentStatus;

    /**
     * 入库单状态  0:进行中 1:已完成
     */
    private String instockStatus;

    /**
     * 备注
     */
    private String notes;

    /**
     * N:未删 Y:已删
     */
    private String isDel;

    /**
     * id
     * @return INSTOCK_BILL_ID id
     */
    public String getInstockBillId() {
        return instockBillId;
    }

    /**
     * id
     * @param instockBillId id
     */
    public void setInstockBillId(String instockBillId) {
        this.instockBillId = instockBillId == null ? null : instockBillId.trim();
    }

    /**
     * 入库单号
     * @return INSTOCK_CODE 入库单号
     */
    public String getInstockCode() {
        return instockCode;
    }

    /**
     * 入库单号
     * @param instockCode 入库单号
     */
    public void setInstockCode(String instockCode) {
        this.instockCode = instockCode == null ? null : instockCode.trim();
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
     * 保证金状态 0:未到账 1:已到账
系统生成保证金收费记录，财务人员需确认到账后填入实际到账金额，然后保存，完成保证金流程
     * @return DEPOSIT_STATUS 保证金状态 0:未到账 1:已到账
系统生成保证金收费记录，财务人员需确认到账后填入实际到账金额，然后保存，完成保证金流程
     */
    public String getDepositStatus() {
        return depositStatus;
    }

    /**
     * 保证金状态 0:未到账 1:已到账
	系统生成保证金收费记录，财务人员需确认到账后填入实际到账金额，然后保存，完成保证金流程
     * @param depositStatus 保证金状态 0:未到账 1:已到账
	系统生成保证金收费记录，财务人员需确认到账后填入实际到账金额，然后保存，完成保证金流程
     */
    public void setDepositStatus(String depositStatus) {
        this.depositStatus = depositStatus == null ? null : depositStatus.trim();
    }

    /**
     * 保证金财务
     * @return DEPOSIT_FINANCE_ID 保证金财务
     */
    public String getDepositFinanceId() {
        return depositFinanceId;
    }

    /**
     * 保证金财务
     * @param depositFinanceId 保证金财务
     */
    public void setDepositFinanceId(String depositFinanceId) {
        this.depositFinanceId = depositFinanceId == null ? null : depositFinanceId.trim();
    }

    /**
     * 验货入库状态 N:未入库 Y:已入库

详见交收管里
     * @return INSPECTION_STATUS 验货入库状态 N:未入库 Y:已入库

详见交收管里
     */
    public String getInspectionStatus() {
        return inspectionStatus;
    }

    /**
     * 验货入库状态 N:未入库 Y:已入库

详见交收管里
     * @param inspectionStatus 验货入库状态 N:未入库 Y:已入库

详见交收管里
     */
    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus == null ? null : inspectionStatus.trim();
    }

    /**
     * 融资货款状态 0:未打款 1:部分货款 2:全部货款
     * @return FINANCING_LOAN_STATUS 融资货款状态 0:未打款 1:部分货款 2:全部货款
     */
    public String getFinancingLoanStatus() {
        return financingLoanStatus;
    }

    /**
     * 融资货款状态 0:未打款 1:部分货款 2:全部货款
     * @param financingLoanStatus 融资货款状态 0:未打款 1:部分货款 2:全部货款
     */
    public void setFinancingLoanStatus(String financingLoanStatus) {
        this.financingLoanStatus = financingLoanStatus == null ? null : financingLoanStatus.trim();
    }

    /**
     * 钢厂货款状态 0:未打款 1:部分货款 2:全部货款

定向销售及采购自销使用字段
     * @return PAYMENT_STATUS 钢厂货款状态 0:未打款 1:部分货款 2:全部货款

定向销售及采购自销使用字段
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * 钢厂货款状态 0:未打款 1:部分货款 2:全部货款

定向销售及采购自销使用字段
     * @param paymentStatus 钢厂货款状态 0:未打款 1:部分货款 2:全部货款

定向销售及采购自销使用字段
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
    }

    /**
     * 入库单状态 0:进行中 1:已完成
     * @return INSTOCK_STATUS 入库单状态 0:进行中 1:已完成
     */
    public String getInstockStatus() {
        return instockStatus;
    }

    /**
     * 入库单状态 0:进行中 1:已完成
     * @param instockStatus 入库单状态 0:进行中 1:已完成
     */
    public void setInstockStatus(String instockStatus) {
        this.instockStatus = instockStatus == null ? null : instockStatus.trim();
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
}