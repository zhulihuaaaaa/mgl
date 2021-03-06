package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConContract implements Serializable{
	
	private static final long serialVersionUID = 7283210505692652718L;

	/**
     * id
     */
    private String contractId;

    /**
     * 合同类型
     */
    private String contractType;

    /**
     * 关联合同
     */
    private String relativeContractId;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 回购协议编号 货押融资使用字段
     */
    private String repurchaseAgreementNo;

    /**
     * 签订日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date signDate;

    /**
     * 签订地点
     */
    private String sigingPlace;

    /**
     * 卖方信息
     */
    private String sellerId;

    /**
     * 买方信息
     */
    private String buyerId;

    /**
     * 供应方开票情况 定向销售使用字段
     */
    private String supplierInvoiceStatus;

    /**
     * 交（提）货地点
     */
    private String deliveryAddress;

    /**
     * 交（提）货时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date deliveryDate;

    /**
     * 交（提）货方式
     */
    private String deliveryType;

    /**
     * 总重量（吨）
     */
    private BigDecimal totalWeight;

    /**
     * 货物总价
     */
    private BigDecimal totalMoney;

    /**
     * 保证金比例
     */
    private BigDecimal depositRate;

    /**
     * 保证金金额
     */
    private BigDecimal depositFee;

    /**
     * 手续费率
     */
    private BigDecimal commissionRate;

    /**
     * 开票费基数
     */
    private BigDecimal invoiceBaseFee;

    /**
     * 合同期限（日）
     */
    private BigDecimal contractPeriod;

    /**
     * 合约状态 1:审核中 2:履约中 3:已完成 4:结束合同
     */
    private String contractState;

    /**
     * 综合办存档 N:未给  Y:已给
     */
    private String archived;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;

    /**
     * 备注
     */
    private String notes;

    /**
     * N:未删 Y:已删
     */
    private String isDel;

    /**
     * 合同单号
     */
    private String contractCode;

    /**
     * 生产厂家,供应商
     */
    private String mallMnfct;

    /**
     * id
     * @return CONTRACT_ID id
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * id
     * @param contractId id
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 合同类型
     * @return CONTRACT_TYPE 合同类型
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * 合同类型
     * @param contractType 合同类型
     */
    public void setContractType(String contractType) {
        this.contractType = contractType == null ? null : contractType.trim();
    }

    /**
     * 关联合同
     * @return RELATIVE_CONTRACT_ID 关联合同
     */
    public String getRelativeContractId() {
        return relativeContractId;
    }

    /**
     * 关联合同
     * @param relativeContractId 关联合同
     */
    public void setRelativeContractId(String relativeContractId) {
        this.relativeContractId = relativeContractId == null ? null : relativeContractId.trim();
    }

    /**
     * 合同编号
     * @return CONTRACT_NO 合同编号
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * 合同编号
     * @param contractNo 合同编号
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * 回购协议编号 货押融资使用字段
     * @return REPURCHASE_AGREEMENT_NO 回购协议编号 货押融资使用字段
     */
    public String getRepurchaseAgreementNo() {
        return repurchaseAgreementNo;
    }

    /**
     * 回购协议编号 货押融资使用字段
     * @param repurchaseAgreementNo 回购协议编号 货押融资使用字段
     */
    public void setRepurchaseAgreementNo(String repurchaseAgreementNo) {
        this.repurchaseAgreementNo = repurchaseAgreementNo == null ? null : repurchaseAgreementNo.trim();
    }

    /**
     * 签订日期
     * @return SIGN_DATE 签订日期
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * 签订日期
     * @param signDate 签订日期
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * 签订地点
     * @return SIGING_PLACE 签订地点
     */
    public String getSigingPlace() {
        return sigingPlace;
    }

    /**
     * 签订地点
     * @param sigingPlace 签订地点
     */
    public void setSigingPlace(String sigingPlace) {
        this.sigingPlace = sigingPlace == null ? null : sigingPlace.trim();
    }

    /**
     * 卖方信息
     * @return SELLER_ID 卖方信息
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 卖方信息
     * @param sellerId 卖方信息
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    /**
     * 买方信息
     * @return BUYER_ID 买方信息
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * 买方信息
     * @param buyerId 买方信息
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    /**
     * 供应方开票情况 定向销售使用字段
     * @return SUPPLIER_INVOICE_STATUS 供应方开票情况 定向销售使用字段
     */
    public String getSupplierInvoiceStatus() {
        return supplierInvoiceStatus;
    }

    /**
     * 供应方开票情况 定向销售使用字段
     * @param supplierInvoiceStatus 供应方开票情况 定向销售使用字段
     */
    public void setSupplierInvoiceStatus(String supplierInvoiceStatus) {
        this.supplierInvoiceStatus = supplierInvoiceStatus == null ? null : supplierInvoiceStatus.trim();
    }

    /**
     * 交（提）货地点
     * @return DELIVERY_ADDRESS 交（提）货地点
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * 交（提）货地点
     * @param deliveryAddress 交（提）货地点
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    /**
     * 交（提）货时间
     * @return DELIVERY_DATE 交（提）货时间
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * 交（提）货时间
     * @param deliveryDate 交（提）货时间
     */
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * 交（提）货方式
     * @return DELIVERY_TYPE 交（提）货方式
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * 交（提）货方式
     * @param deliveryType 交（提）货方式
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType == null ? null : deliveryType.trim();
    }

    /**
     * 总重量（吨）
     * @return TOTAL_WEIGHT 总重量（吨）
     */
    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    /**
     * 总重量（吨）
     * @param totalWeight 总重量（吨）
     */
    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    /**
     * 货物总价
     * @return TOTAL_MONEY 货物总价
     */
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    /**
     * 货物总价
     * @param totalMoney 货物总价
     */
    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * 保证金比例
     * @return DEPOSIT_RATE 保证金比例
     */
    public BigDecimal getDepositRate() {
        return depositRate;
    }

    /**
     * 保证金比例
     * @param depositRate 保证金比例
     */
    public void setDepositRate(BigDecimal depositRate) {
        this.depositRate = depositRate;
    }

    /**
     * 保证金金额
     * @return DEPOSIT_FEE 保证金金额
     */
    public BigDecimal getDepositFee() {
        return depositFee;
    }

    /**
     * 保证金金额
     * @param depositFee 保证金金额
     */
    public void setDepositFee(BigDecimal depositFee) {
        this.depositFee = depositFee;
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
     * 开票费基数
     * @return INVOICE_BASE_FEE 开票费基数
     */
    public BigDecimal getInvoiceBaseFee() {
        return invoiceBaseFee;
    }

    /**
     * 开票费基数
     * @param invoiceBaseFee 开票费基数
     */
    public void setInvoiceBaseFee(BigDecimal invoiceBaseFee) {
        this.invoiceBaseFee = invoiceBaseFee;
    }

    /**
     * 合同期限（日）
     * @return CONTRACT_PERIOD 合同期限（日）
     */
    public BigDecimal getContractPeriod() {
        return contractPeriod;
    }

    /**
     * 合同期限（日）
     * @param contractPeriod 合同期限（日）
     */
    public void setContractPeriod(BigDecimal contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    /**
     * 合约状态 1:审核中 2:履约中 3:已完成
     * @return CONTRACT_STATE 合约状态 1:审核中 2:履约中 3:已完成
     */
    public String getContractState() {
        return contractState;
    }

    /**
     * 合约状态 1:审核中 2:履约中 3:已完成
     * @param contractState 合约状态 1:审核中 2:履约中 3:已完成
     */
    public void setContractState(String contractState) {
        this.contractState = contractState == null ? null : contractState.trim();
    }

    /**
     * 综合办存档 N:未给  Y:已给
     * @return ARCHIVED 综合办存档 N:未给  Y:已给
     */
    public String getArchived() {
        return archived;
    }

    /**
     * 综合办存档 N:未给  Y:已给
     * @param archived 综合办存档 N:未给  Y:已给
     */
    public void setArchived(String archived) {
        this.archived = archived == null ? null : archived.trim();
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

    /**
     * 合同单号
     * @return CONTRACT_CODE 合同单号
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * 合同单号
     * @param contractCode 合同单号
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    /**
     * 生产厂家,供应商
     * @return MALL_MNFCT 生产厂家,供应商
     */
    public String getMallMnfct() {
        return mallMnfct;
    }

    /**
     * 生产厂家,供应商
     * @param mallMnfct 生产厂家,供应商
     */
    public void setMallMnfct(String mallMnfct) {
        this.mallMnfct = mallMnfct == null ? null : mallMnfct.trim();
    }
}