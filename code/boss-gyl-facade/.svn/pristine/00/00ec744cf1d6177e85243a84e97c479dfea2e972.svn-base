package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OutOutstockBill implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8810351940020006461L;

	/**
     * id
     */
    private String outstockBillId;

    /**
     * 提货单单号
     */
    private String outstockCode;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 客户信息
     */
    private String customerId;

    /**
     * 供应方信息
     */
    private String supplierId;

    /**
     * 合同信息
     */
    private String contractId;

    /**
     * 存放仓库
     */
    private String storageId;

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
    private String consignee;

    /**
     * 提货人电话
     */
    private String consigneeTel;

    /**
     * 提货人身份证号
     */
    private String consigneeIdNo;

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
     * 计费天数
     */
    private BigDecimal chargingDays;

    /**
     * 车牌号
     */
    private String consigneeCar;

    /**
     * 提货状态 1:审核中 2:履约中 3:已完成 4:结束
     */
    private String outstockState;

    /**
     * id
     * @return OUTSTOCK_BILL_ID id
     */
    public String getOutstockBillId() {
        return outstockBillId;
    }

    /**
     * id
     * @param outstockBillId id
     */
    public void setOutstockBillId(String outstockBillId) {
        this.outstockBillId = outstockBillId == null ? null : outstockBillId.trim();
    }

    /**
     * 提货单单号
     * @return OUTSTOCK_CODE 提货单单号
     */
    public String getOutstockCode() {
        return outstockCode;
    }

    /**
     * 提货单单号
     * @param outstockCode 提货单单号
     */
    public void setOutstockCode(String outstockCode) {
        this.outstockCode = outstockCode == null ? null : outstockCode.trim();
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
     * 供应方信息
     * @return SUPPLIER_ID 供应方信息
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * 供应方信息
     * @param supplierId 供应方信息
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    /**
     * 合同信息
     * @return CONTRACT_ID 合同信息
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 合同信息
     * @param contractId 合同信息
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 存放仓库
     * @return STORAGE_ID 存放仓库
     */
    public String getStorageId() {
        return storageId;
    }

    /**
     * 存放仓库
     * @param storageId 存放仓库
     */
    public void setStorageId(String storageId) {
        this.storageId = storageId == null ? null : storageId.trim();
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

    /**
     * 总货款
     * @return GOODS_PAYMENT 总货款
     */
    public BigDecimal getGoodsPayment() {
        return goodsPayment;
    }

    /**
     * 总货款
     * @param goodsPayment 总货款
     */
    public void setGoodsPayment(BigDecimal goodsPayment) {
        this.goodsPayment = goodsPayment;
    }

    /**
     * 手续费
     * @return SERVICE_FEE 手续费
     */
    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    /**
     * 手续费
     * @param serviceFee 手续费
     */
    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
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
     * 提货人
     * @return CONSIGNEE 提货人
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 提货人
     * @param consignee 提货人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * 提货人电话
     * @return CONSIGNEE_TEL 提货人电话
     */
    public String getConsigneeTel() {
        return consigneeTel;
    }

    /**
     * 提货人电话
     * @param consigneeTel 提货人电话
     */
    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel == null ? null : consigneeTel.trim();
    }

    /**
     * 提货人身份证号
     * @return CONSIGNEE_ID_NO 提货人身份证号
     */
    public String getConsigneeIdNo() {
        return consigneeIdNo;
    }

    /**
     * 提货人身份证号
     * @param consigneeIdNo 提货人身份证号
     */
    public void setConsigneeIdNo(String consigneeIdNo) {
        this.consigneeIdNo = consigneeIdNo == null ? null : consigneeIdNo.trim();
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
     * 车牌号
     * @return CONSIGNEE_CAR 车牌号
     */
    public String getConsigneeCar() {
        return consigneeCar;
    }

    /**
     * 车牌号
     * @param consigneeCar 车牌号
     */
    public void setConsigneeCar(String consigneeCar) {
        this.consigneeCar = consigneeCar == null ? null : consigneeCar.trim();
    }

    /**
     * 提货状态 1:审核中 2:履约中 3:已完成 4:结束
     * @return OUTSTOCK_STATE 提货状态 1:审核中 2:履约中 3:已完成 4:结束
     */
    public String getOutstockState() {
        return outstockState;
    }

    /**
     * 提货状态 1:审核中 2:履约中 3:已完成 4:结束
     * @param outstockState 提货状态 1:审核中 2:履约中 3:已完成 4:结束
     */
    public void setOutstockState(String outstockState) {
        this.outstockState = outstockState == null ? null : outstockState.trim();
    }
}