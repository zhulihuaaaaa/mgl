package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.FeeInvoice;
import com.maigangle.gyl.facade.entity.FeeInvoiceDetail;
public class InvoiceVo implements Serializable{
	private static final long serialVersionUID = -91912947838911748L;

	/**
	 * 发票类型
	 */
    private String invoiceType;
    
    /**
     * 备注
     */
    private String notes;
    
    /**
     * 发票号
     */
    private String invoiceNo;

    private List<FeeInvoiceDetail> detail;
    
	private FeeInvoice entity;
	
	/**
	 * 创建人
	 */
	private String createUser;
	
	/**
     * 开票日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
    private Date startBillingDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
    private Date endBillingDate;
	
	/**
     * 验票日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
    private Date startCheckingDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
    private Date endCheckingDate;
	
	/**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
    private Date startCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
    private Date endCreateDate;
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<FeeInvoiceDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<FeeInvoiceDetail> detail) {
		this.detail = detail;
	}

	public FeeInvoice getEntity() {
		return entity;
	}

	public void setEntity(FeeInvoice entity) {
		this.entity = entity;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getStartBillingDate() {
		return startBillingDate;
	}

	public void setStartBillingDate(Date startBillingDate) {
		this.startBillingDate = startBillingDate;
	}

	public Date getEndBillingDate() {
		return endBillingDate;
	}

	public void setEndBillingDate(Date endBillingDate) {
		this.endBillingDate = endBillingDate;
	}

	public Date getStartCheckingDate() {
		return startCheckingDate;
	}

	public void setStartCheckingDate(Date startCheckingDate) {
		this.startCheckingDate = startCheckingDate;
	}

	public Date getEndCheckingDate() {
		return endCheckingDate;
	}

	public void setEndCheckingDate(Date endCheckingDate) {
		this.endCheckingDate = endCheckingDate;
	}

	public Date getStartCreateDate() {
		return startCreateDate;
	}

	public void setStartCreateDate(Date startCreateDate) {
		this.startCreateDate = startCreateDate;
	}

	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

}
