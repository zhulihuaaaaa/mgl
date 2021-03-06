package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeeInvoice implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5155090027530686220L;

	/**
     * id
     */
    private String invoiceId;

    /**
     * 发票类型，0进项，1销项
     */
    private String invoiceType;

    /**
     * 发票号
     */
    private String invoiceNo;

    /**
     * 发票金额
     */
    private BigDecimal invoiceMoney;

    /**
     * 合同信息
     */
    private String contractIds;

    /**
     * 开票日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date billingDate;

    /**
     * 验票日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date checkingDate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 合同编号
     */
    private String contractCodes;

    /**
     * 客户信息
     */
    private String customerId;

    /**
     * 备注
     */
    private String notes;

    /**
     * id
     * @return INVOICE_ID id
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * id
     * @param invoiceId id
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId == null ? null : invoiceId.trim();
    }

    /**
     * 发票类型，0进项，1销项
     * @return INVOICE_TYPE 发票类型，0进项，1销项
     */
    public String getInvoiceType() {
        return invoiceType;
    }

    /**
     * 发票类型，0进项，1销项
     * @param invoiceType 发票类型，0进项，1销项
     */
    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    /**
     * 发票号
     * @return INVOICE_NO 发票号
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * 发票号
     * @param invoiceNo 发票号
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    /**
     * 发票金额
     * @return INVOICE_MONEY 发票金额
     */
    public BigDecimal getInvoiceMoney() {
        return invoiceMoney;
    }

    /**
     * 发票金额
     * @param invoiceMoney 发票金额
     */
    public void setInvoiceMoney(BigDecimal invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    /**
     * 合同信息
     * @return CONTRACT_IDS 合同信息
     */
    public String getContractIds() {
        return contractIds;
    }

    /**
     * 合同信息
     * @param contractIds 合同信息
     */
    public void setContractIds(String contractIds) {
        this.contractIds = contractIds == null ? null : contractIds.trim();
    }

    /**
     * 开票日期
     * @return BILLING_DATE 开票日期
     */
    public Date getBillingDate() {
        return billingDate;
    }

    /**
     * 开票日期
     * @param billingDate 开票日期
     */
    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    /**
     * 验票日期
     * @return CHECKING_DATE 验票日期
     */
    public Date getCheckingDate() {
        return checkingDate;
    }

    /**
     * 验票日期
     * @param checkingDate 验票日期
     */
    public void setCheckingDate(Date checkingDate) {
        this.checkingDate = checkingDate;
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
     * 合同编号
     * @return CONTRACT_CODES 合同编号
     */
    public String getContractCodes() {
        return contractCodes;
    }

    /**
     * 合同编号
     * @param contractCodes 合同编号
     */
    public void setContractCodes(String contractCodes) {
        this.contractCodes = contractCodes == null ? null : contractCodes.trim();
    }

    /**
     * 客户信息
     * @return CUSTOMER_ID 客户信息
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 客户信息
     * @param customerId 客户信息
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
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
}