package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeeFinanceBill implements Serializable{
	
	private static final long serialVersionUID = 8520861317131669760L;

	/**
     * id
     */
    private String financeBillId;

    /**
     * 财务单号
     */
    private String financeCode;

    /**
     * 关联单号
     */
    private String relationCode;

    /**
     * 资金流向 进账/出账
     */
    private String flwoType;

    /**
     * 关联合同
     */
    private String contractId;

    /**
     * 业务类型 履约保证金/追加保证金/购货款/赎货款
     */
    private String businessType;

    /**
     * 创建日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;

    /**
     * 款项说明
     */
    private String description;

    /**
     * 总货款
     */
    private BigDecimal totalGoodsPayment;

    /**
     * 手续费
     */
    private BigDecimal commissionFee;

    /**
     * 开票费
     */
    private BigDecimal invoiceFee;

    /**
     * 计费天数
     */
    private BigDecimal chargingDays;

    /**
     * 其他费用
     */
    private BigDecimal otherFee;

    /**
     * 总金额
     */
    private BigDecimal totalMoney;

    /**
     * 实际到账金额
     */
    private BigDecimal actualAmount;

    /**
     * 待付总金额
     */
    private BigDecimal realMoney;

    /**
     * 保证金抵扣金额
     */
    private BigDecimal depositFee;

    /**
     * 关联保证金消费记录
     */
    private String depositDetailId;

    /**
     * 操作员
     */
    private String operator;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date operatorDate;

    /**
     * 备注
     */
    private String notes;

    /**
     * N:未完成 Y:完成
     */
    private String status;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 关联单Id
     */
    private String relationId;

    /**
     * 合同Code
     */
    private String contractCode;

    /**
     * id
     * @return FINANCE_BILL_ID id
     */
    public String getFinanceBillId() {
        return financeBillId;
    }

    /**
     * id
     * @param financeBillId id
     */
    public void setFinanceBillId(String financeBillId) {
        this.financeBillId = financeBillId == null ? null : financeBillId.trim();
    }

    /**
     * 财务单号
     * @return FINANCE_CODE 财务单号
     */
    public String getFinanceCode() {
        return financeCode;
    }

    /**
     * 财务单号
     * @param financeCode 财务单号
     */
    public void setFinanceCode(String financeCode) {
        this.financeCode = financeCode == null ? null : financeCode.trim();
    }

    /**
     * 关联单号
     * @return RELATION_CODE 关联单号
     */
    public String getRelationCode() {
        return relationCode;
    }

    /**
     * 关联单号
     * @param relationCode 关联单号
     */
    public void setRelationCode(String relationCode) {
        this.relationCode = relationCode == null ? null : relationCode.trim();
    }

    /**
     * 资金流向 进账/出账
     * @return FLWO_TYPE 资金流向 进账/出账
     */
    public String getFlwoType() {
        return flwoType;
    }

    /**
     * 资金流向 进账/出账
     * @param flwoType 资金流向 进账/出账
     */
    public void setFlwoType(String flwoType) {
        this.flwoType = flwoType == null ? null : flwoType.trim();
    }

    /**
     * 关联合同
     * @return CONTRACT_ID 关联合同
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 关联合同
     * @param contractId 关联合同
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 业务类型 履约保证金/追加保证金/购货款/赎货款
     * @return BUSINESS_TYPE 业务类型 履约保证金/追加保证金/购货款/赎货款
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型 履约保证金/追加保证金/购货款/赎货款
     * @param businessType 业务类型 履约保证金/追加保证金/购货款/赎货款
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
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
     * 款项说明
     * @return DESCRIPTION 款项说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 款项说明
     * @param description 款项说明
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 总货款
     * @return TOTAL_GOODS_PAYMENT 总货款
     */
    public BigDecimal getTotalGoodsPayment() {
        return totalGoodsPayment;
    }

    /**
     * 总货款
     * @param totalGoodsPayment 总货款
     */
    public void setTotalGoodsPayment(BigDecimal totalGoodsPayment) {
        this.totalGoodsPayment = totalGoodsPayment;
    }

    /**
     * 手续费
     * @return COMMISSION_FEE 手续费
     */
    public BigDecimal getCommissionFee() {
        return commissionFee;
    }

    /**
     * 手续费
     * @param commissionFee 手续费
     */
    public void setCommissionFee(BigDecimal commissionFee) {
        this.commissionFee = commissionFee;
    }

    /**
     * 开票费
     * @return INVOICE_FEE 开票费
     */
    public BigDecimal getInvoiceFee() {
        return invoiceFee;
    }

    /**
     * 开票费
     * @param invoiceFee 开票费
     */
    public void setInvoiceFee(BigDecimal invoiceFee) {
        this.invoiceFee = invoiceFee;
    }

    /**
     * 计费天数
     * @return CHARGING_DAYS 计费天数
     */
    public BigDecimal getChargingDays() {
        return chargingDays;
    }

    /**
     * 计费天数
     * @param chargingDays 计费天数
     */
    public void setChargingDays(BigDecimal chargingDays) {
        this.chargingDays = chargingDays;
    }

    /**
     * 其他费用
     * @return OTHER_FEE 其他费用
     */
    public BigDecimal getOtherFee() {
        return otherFee;
    }

    /**
     * 其他费用
     * @param otherFee 其他费用
     */
    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    /**
     * 总金额
     * @return TOTAL_MONEY 总金额
     */
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    /**
     * 总金额
     * @param totalMoney 总金额
     */
    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * 实际到账金额
     * @return ACTUAL_AMOUNT 实际到账金额
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * 实际到账金额
     * @param actualAmount 实际到账金额
     */
    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * 待付总金额
     * @return REAL_MONEY 待付总金额
     */
    public BigDecimal getRealMoney() {
        return realMoney;
    }

    /**
     * 待付总金额
     * @param realMoney 待付总金额
     */
    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    /**
     * 保证金抵扣金额
     * @return DEPOSIT_FEE 保证金抵扣金额
     */
    public BigDecimal getDepositFee() {
        return depositFee;
    }

    /**
     * 保证金抵扣金额
     * @param depositFee 保证金抵扣金额
     */
    public void setDepositFee(BigDecimal depositFee) {
        this.depositFee = depositFee;
    }

    /**
     * 关联保证金消费记录
     * @return DEPOSIT_DETAIL_ID 关联保证金消费记录
     */
    public String getDepositDetailId() {
        return depositDetailId;
    }

    /**
     * 关联保证金消费记录
     * @param depositDetailId 关联保证金消费记录
     */
    public void setDepositDetailId(String depositDetailId) {
        this.depositDetailId = depositDetailId == null ? null : depositDetailId.trim();
    }

    /**
     * 操作员
     * @return OPERATOR 操作员
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 操作员
     * @param operator 操作员
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 操作时间
     * @return OPERATOR_DATE 操作时间
     */
    public Date getOperatorDate() {
        return operatorDate;
    }

    /**
     * 操作时间
     * @param operatorDate 操作时间
     */
    public void setOperatorDate(Date operatorDate) {
        this.operatorDate = operatorDate;
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
     * N:未完成 Y:完成
     * @return STATUS N:未完成 Y:完成
     */
    public String getStatus() {
        return status;
    }

    /**
     * N:未完成 Y:完成
     * @param status N:未完成 Y:完成
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * null
     * @return RELATION_ID null
     */
    public String getRelationId() {
        return relationId;
    }

    /**
     * null
     * @param relationId null
     */
    public void setRelationId(String relationId) {
        this.relationId = relationId == null ? null : relationId.trim();
    }

    /**
     * null
     * @return CONTRACT_CODE null
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * null
     * @param contractCode null
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }
}