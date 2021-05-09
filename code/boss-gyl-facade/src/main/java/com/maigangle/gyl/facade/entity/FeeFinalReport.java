package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeeFinalReport implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8902446270995407933L;

	/**
     * ID
     */
    private String feeFinalReportId;

    /**
     * 财务未入库总重量
     */
    private BigDecimal feeUninstockTotalweight;

    /**
     * 财务未入库总金额
     */
    private BigDecimal feeUninstockTotalmoney;

    /**
     * 财务未出库总重量
     */
    private BigDecimal feeUnoutstockTotalweight;

    /**
     * 财务未出库总金额
     */
    private BigDecimal feeUnoutstockTotalmoney;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * ID
     * @return FEE_FINAL_REPORT_ID ID
     */
    public String getFeeFinalReportId() {
        return feeFinalReportId;
    }

    /**
     * ID
     * @param feeFinalReportId ID
     */
    public void setFeeFinalReportId(String feeFinalReportId) {
        this.feeFinalReportId = feeFinalReportId == null ? null : feeFinalReportId.trim();
    }

    /**
     * 财务未入库总重量
     * @return FEE_UNINSTOCK_TOTALWEIGHT 财务未入库总重量
     */
    public BigDecimal getFeeUninstockTotalweight() {
        return feeUninstockTotalweight;
    }

    /**
     * 财务未入库总重量
     * @param feeUninstockTotalweight 财务未入库总重量
     */
    public void setFeeUninstockTotalweight(BigDecimal feeUninstockTotalweight) {
        this.feeUninstockTotalweight = feeUninstockTotalweight;
    }

    /**
     * 财务未入库总金额
     * @return FEE_UNINSTOCK_TOTALMONEY 财务未入库总金额
     */
    public BigDecimal getFeeUninstockTotalmoney() {
        return feeUninstockTotalmoney;
    }

    /**
     * 财务未入库总金额
     * @param feeUninstockTotalmoney 财务未入库总金额
     */
    public void setFeeUninstockTotalmoney(BigDecimal feeUninstockTotalmoney) {
        this.feeUninstockTotalmoney = feeUninstockTotalmoney;
    }

    /**
     * 财务未出库总重量
     * @return FEE_UNOUTSTOCK_TOTALWEIGHT 财务未出库总重量
     */
    public BigDecimal getFeeUnoutstockTotalweight() {
        return feeUnoutstockTotalweight;
    }

    /**
     * 财务未出库总重量
     * @param feeUnoutstockTotalweight 财务未出库总重量
     */
    public void setFeeUnoutstockTotalweight(BigDecimal feeUnoutstockTotalweight) {
        this.feeUnoutstockTotalweight = feeUnoutstockTotalweight;
    }

    /**
     * 财务未出库总金额
     * @return FEE_UNOUTSTOCK_TOTALMONEY 财务未出库总金额
     */
    public BigDecimal getFeeUnoutstockTotalmoney() {
        return feeUnoutstockTotalmoney;
    }

    /**
     * 财务未出库总金额
     * @param feeUnoutstockTotalmoney 财务未出库总金额
     */
    public void setFeeUnoutstockTotalmoney(BigDecimal feeUnoutstockTotalmoney) {
        this.feeUnoutstockTotalmoney = feeUnoutstockTotalmoney;
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
}