package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class BaseCost implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3434736427244120871L;

	/**
     * id
     */
    private String costId;

    /**
     * 手续费(A)/开票费(B)
     */
    private String costType;

    /**
     * 客户信息
     */
    private String customerId;

    /**
     * 开票费数值
     */
    private BigDecimal amount;

    /**
     * N:未删 Y:已删
     */
    private String isDel;

    /**
     * 0-60天费率
     */
    private BigDecimal feeRate1;

    /**
     * 61-90天费率
     */
    private BigDecimal feeRate2;

    /**
     * id
     * @return COST_ID id
     */
    public String getCostId() {
        return costId;
    }

    /**
     * id
     * @param costId id
     */
    public void setCostId(String costId) {
        this.costId = costId == null ? null : costId.trim();
    }

    /**
     * 手续费(A)/开票费(B)
     * @return COST_TYPE 手续费(A)/开票费(B)
     */
    public String getCostType() {
        return costType;
    }

    /**
     * 手续费(A)/开票费(B)
     * @param costType 手续费(A)/开票费(B)
     */
    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
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
     * 开票费数值
     * @return AMOUNT 开票费数值
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 开票费数值
     * @param amount 开票费数值
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * 0-60天费率
     * @return FEE_RATE1 0-60天费率
     */
    public BigDecimal getFeeRate1() {
        return feeRate1;
    }

    /**
     * 0-60天费率
     * @param feeRate1 0-60天费率
     */
    public void setFeeRate1(BigDecimal feeRate1) {
        this.feeRate1 = feeRate1;
    }

    /**
     * 61-90天费率
     * @return FEE_RATE2 61-90天费率
     */
    public BigDecimal getFeeRate2() {
        return feeRate2;
    }

    /**
     * 61-90天费率
     * @param feeRate2 61-90天费率
     */
    public void setFeeRate2(BigDecimal feeRate2) {
        this.feeRate2 = feeRate2;
    }
}