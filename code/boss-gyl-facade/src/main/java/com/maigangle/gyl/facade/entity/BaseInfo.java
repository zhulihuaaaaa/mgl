package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class BaseInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6538353034266685151L;

	/**
     * id
     */
    private String infoId;

    /**
     * 0-60天通用手续费率
     */
    private BigDecimal feeRate1;

    /**
     * 通用开票费
     */
    private BigDecimal invoiceFee;

    /**
     * 逾期提醒天数；
格式 7,5,2
说明：分别在7天，5天，2天时提醒
     */
    private String overdueReminder;

    /**
     * N:未删 Y:已删
     */
    private String isDel;

    /**
     * null
     */
    private String virtualMallDepot;

    /**
     * 61-90天通用手续费率
     */
    private BigDecimal feeRate2;

    /**
     * 公司信息名称
     */
    private String companyName;

    /**
     * id
     * @return INFO_ID id
     */
    public String getInfoId() {
        return infoId;
    }

    /**
     * id
     * @param infoId id
     */
    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    /**
     * 0-60天通用手续费率
     * @return FEE_RATE1 0-60天通用手续费率
     */
    public BigDecimal getFeeRate1() {
        return feeRate1;
    }

    /**
     * 0-60天通用手续费率
     * @param feeRate1 0-60天通用手续费率
     */
    public void setFeeRate1(BigDecimal feeRate1) {
        this.feeRate1 = feeRate1;
    }

    /**
     * 通用开票费
     * @return INVOICE_FEE 通用开票费
     */
    public BigDecimal getInvoiceFee() {
        return invoiceFee;
    }

    /**
     * 通用开票费
     * @param invoiceFee 通用开票费
     */
    public void setInvoiceFee(BigDecimal invoiceFee) {
        this.invoiceFee = invoiceFee;
    }

    /**
     * 逾期提醒天数；
格式 7,5,2
说明：分别在7天，5天，2天时提醒
     * @return OVERDUE_REMINDER 逾期提醒天数；
格式 7,5,2
说明：分别在7天，5天，2天时提醒
     */
    public String getOverdueReminder() {
        return overdueReminder;
    }

    /**
     * 逾期提醒天数；
格式 7,5,2
说明：分别在7天，5天，2天时提醒
     * @param overdueReminder 逾期提醒天数；
格式 7,5,2
说明：分别在7天，5天，2天时提醒
     */
    public void setOverdueReminder(String overdueReminder) {
        this.overdueReminder = overdueReminder == null ? null : overdueReminder.trim();
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
     * null
     * @return VIRTUAL_MALL_DEPOT null
     */
    public String getVirtualMallDepot() {
        return virtualMallDepot;
    }

    /**
     * null
     * @param virtualMallDepot null
     */
    public void setVirtualMallDepot(String virtualMallDepot) {
        this.virtualMallDepot = virtualMallDepot == null ? null : virtualMallDepot.trim();
    }

    /**
     * 61-90天通用手续费率
     * @return FEE_RATE2 61-90天通用手续费率
     */
    public BigDecimal getFeeRate2() {
        return feeRate2;
    }

    /**
     * 61-90天通用手续费率
     * @param feeRate2 61-90天通用手续费率
     */
    public void setFeeRate2(BigDecimal feeRate2) {
        this.feeRate2 = feeRate2;
    }

    /**
     * 公司信息名称
     * @return COMPANY_NAME 公司信息名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 公司信息名称
     * @param companyName 公司信息名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }
}