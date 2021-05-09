package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RedRedeemBill implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1521260385034763421L;

	/**
     * id
     */
    private String redeemBillId;

    /**
     * 赎货客户
     */
    private String buyerId;

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
     * 存放仓库
     */
    private String storageId;

    /**
     * 对应合同
     */
    private String contractId;

    /**
     * 货物来源 钢厂自提/库存货物/仓单质押
     */
    private String goodsSource;

    /**
     * 总重量
     */
    private BigDecimal totalWeight;

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
     * 其他费用
     */
    private BigDecimal otherFee;

    /**
     * 计费天数
     */
    private BigDecimal chargingDays;

    /**
     * 保证金抵消金额
     */
    private BigDecimal depositFee;

    /**
     * 关联保证金消费记录
     */
    private String depositDetailId;

    /**
     * 总金额
     */
    private BigDecimal totalMoney;

    /**
     * 待付总金额
     */
    private BigDecimal realMoney;

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
     * 审核状态  0:已提交、1:审核中、2:未通过、3:已通过
     */
    private String auditStatus;

    /**
     * 赎货状态  N:未出库、Y:已出库
     */
    private String redeemStatus;

    /**
     * 对应提货单ID
     */
    private String outstockId;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 赎货单号
     */
    private String redeemBillCode;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 赎货款状态
     */
    private String redeemMoneyState;

    /**
     * id
     * @return REDEEM_BILL_ID id
     */
    public String getRedeemBillId() {
        return redeemBillId;
    }

    /**
     * id
     * @param redeemBillId id
     */
    public void setRedeemBillId(String redeemBillId) {
        this.redeemBillId = redeemBillId == null ? null : redeemBillId.trim();
    }

    /**
     * 赎货客户
     * @return BUYER_ID 赎货客户
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * 赎货客户
     * @param buyerId 赎货客户
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
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
     * 对应合同
     * @return CONTRACT_ID 对应合同
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 对应合同
     * @param contractId 对应合同
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 货物来源 钢厂自提/库存货物/仓单质押
     * @return GOODS_SOURCE 货物来源 钢厂自提/库存货物/仓单质押
     */
    public String getGoodsSource() {
        return goodsSource;
    }

    /**
     * 货物来源 钢厂自提/库存货物/仓单质押
     * @param goodsSource 货物来源 钢厂自提/库存货物/仓单质押
     */
    public void setGoodsSource(String goodsSource) {
        this.goodsSource = goodsSource == null ? null : goodsSource.trim();
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
     * 保证金抵消金额
     * @return DEPOSIT_FEE 保证金抵消金额
     */
    public BigDecimal getDepositFee() {
        return depositFee;
    }

    /**
     * 保证金抵消金额
     * @param depositFee 保证金抵消金额
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
     * 审核状态  0:已提交、1:审核中、2:未通过、3:已通过
     * @return AUDIT_STATUS 审核状态  0:已提交、1:审核中、2:未通过、3:已通过
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审核状态  0:已提交、1:审核中、2:未通过、3:已通过
     * @param auditStatus 审核状态  0:已提交、1:审核中、2:未通过、3:已通过
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * 赎货状态  N:未出库、Y:已出库
     * @return REDEEM_STATUS 赎货状态  N:未出库、Y:已出库
     */
    public String getRedeemStatus() {
        return redeemStatus;
    }

    /**
     * 赎货状态  N:未出库、Y:已出库
     * @param redeemStatus 赎货状态  N:未出库、Y:已出库
     */
    public void setRedeemStatus(String redeemStatus) {
        this.redeemStatus = redeemStatus == null ? null : redeemStatus.trim();
    }

    /**
     * 对应提货单ID
     * @return OUTSTOCK_ID 对应提货单ID
     */
    public String getOutstockId() {
        return outstockId;
    }

    /**
     * 对应提货单ID
     * @param outstockId 对应提货单ID
     */
    public void setOutstockId(String outstockId) {
        this.outstockId = outstockId == null ? null : outstockId.trim();
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
     * 赎货单号
     * @return REDEEM_BILL_CODE 赎货单号
     */
    public String getRedeemBillCode() {
        return redeemBillCode;
    }

    /**
     * 赎货单号
     * @param redeemBillCode 赎货单号
     */
    public void setRedeemBillCode(String redeemBillCode) {
        this.redeemBillCode = redeemBillCode == null ? null : redeemBillCode.trim();
    }

    /**
     * null
     * @return CAR_NUMBER null
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * null
     * @param carNumber null
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    /**
     * 赎货款状态
     * @return REDEEM_MONEY_STATE 赎货款状态
     */
    public String getRedeemMoneyState() {
        return redeemMoneyState;
    }

    /**
     * 赎货款状态
     * @param redeemMoneyState 赎货款状态
     */
    public void setRedeemMoneyState(String redeemMoneyState) {
        this.redeemMoneyState = redeemMoneyState == null ? null : redeemMoneyState.trim();
    }
}