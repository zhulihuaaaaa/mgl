package com.maigangle.gyl.facade.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.FeeDepositDetail;

public class FeeDepositDetailDto extends FeeDepositDetail{
	
	private static final long serialVersionUID = 3547354229845176053L;
	
	/**
     * 创建日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startCreateDate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endCreateDate;
    
    /**
     * 消费金额
     */
    private BigDecimal minUsedFee;
    private BigDecimal maxUsedFee;

    /**
     * 剩余保证金
     */
    private BigDecimal minBalance;
    private BigDecimal maxBalance;
    
    
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
	public BigDecimal getMinUsedFee() {
		return minUsedFee;
	}
	public void setMinUsedFee(BigDecimal minUsedFee) {
		this.minUsedFee = minUsedFee;
	}
	public BigDecimal getMaxUsedFee() {
		return maxUsedFee;
	}
	public void setMaxUsedFee(BigDecimal maxUsedFee) {
		this.maxUsedFee = maxUsedFee;
	}
	public BigDecimal getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(BigDecimal minBalance) {
		this.minBalance = minBalance;
	}
	public BigDecimal getMaxBalance() {
		return maxBalance;
	}
	public void setMaxBalance(BigDecimal maxBalance) {
		this.maxBalance = maxBalance;
	}
    
}
