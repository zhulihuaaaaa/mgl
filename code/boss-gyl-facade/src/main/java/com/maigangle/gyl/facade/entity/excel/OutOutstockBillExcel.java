package com.maigangle.gyl.facade.entity.excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.api.CrmClient;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("OutOutstockBillExcel")
public class OutOutstockBillExcel implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8747464925742420347L;

	/**
     * id
     */
    private String outstockBillId;

    /**
     * 提货单单号
     */
    @Excel(name = "提货单单号", needMerge = true)
    private String outstockCode;

    /**
     * 业务类型  过户/库存提货/钢厂自提
     */
    private String businessType;

    /**
     * 客户信息id
     */
    private String customerId;

    /**
     * 客户信息
     */
    @Excel(name = "客户信息", needMerge = true)
    private String customerName;

    /**
     * 供应方信息
     */
    private String supplierId;

    /**
     * 合同信息
     */
    private String contractId;

    /**
     * 存放仓库id
     */
    private String storageId;

    /**
     * 存放仓库
     */
    @Excel(name = "存放仓库", needMerge = true)
    private String storageName;

    /**
     * 总重量
     */
    private BigDecimal totalWeight;

    /**
     * 总货款
     */
    private BigDecimal goodsPayment;

    /**
     * 手续费
     */
    private BigDecimal serviceFee;

    /**
     * 开票费
     */
    private BigDecimal invoiceFee;

    /**
     * 其他费用
     */
    private BigDecimal otherFee;

    /**
     * 总金额
     */
    private BigDecimal totalMoney;

    /**
     * 提货人
     */
    @Excel(name = "提货人", needMerge = true)
    private String consignee;

    /**
     * 提货人电话
     */
    @Excel(name = "提货人电话", needMerge = true)
    private String consigneeTel;

    /**
     * 提货人身份证号
     */
    @Excel(name = "提货人身份证号", needMerge = true)
    private String consigneeIdNo;

    /**
     * 创建人
     */
    @Excel(name = "创建人", needMerge = true)
    private String createUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    @Excel(name = "创建时间" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date createDate;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 计费天数
     */
    private BigDecimal chargingDays;

	public String getOutstockBillId() {
		return outstockBillId;
	}

	public void setOutstockBillId(String outstockBillId) {
		this.outstockBillId = outstockBillId;
	}

	public String getOutstockCode() {
		return outstockCode;
	}

	public void setOutstockCode(String outstockCode) {
		this.outstockCode = outstockCode;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	public BigDecimal getGoodsPayment() {
		return goodsPayment;
	}

	public void setGoodsPayment(BigDecimal goodsPayment) {
		this.goodsPayment = goodsPayment;
	}

	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public BigDecimal getInvoiceFee() {
		return invoiceFee;
	}

	public void setInvoiceFee(BigDecimal invoiceFee) {
		this.invoiceFee = invoiceFee;
	}

	public BigDecimal getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeTel() {
		return consigneeTel;
	}

	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}

	public String getConsigneeIdNo() {
		return consigneeIdNo;
	}

	public void setConsigneeIdNo(String consigneeIdNo) {
		this.consigneeIdNo = consigneeIdNo;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public BigDecimal getChargingDays() {
		return chargingDays;
	}

	public void setChargingDays(BigDecimal chargingDays) {
		this.chargingDays = chargingDays;
	}

}