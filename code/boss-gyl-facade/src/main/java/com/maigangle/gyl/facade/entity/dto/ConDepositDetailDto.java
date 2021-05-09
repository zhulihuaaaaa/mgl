package com.maigangle.gyl.facade.entity.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.maigangle.gyl.facade.entity.ConDepositDetail;

public class ConDepositDetailDto extends ConDepositDetail {

	private static final long serialVersionUID = 4695334705260469239L;
	
    /**
     * 金额
     */
    private BigDecimal minMoney;
    private BigDecimal maxMoney;
	
    /**
     * 创建日期
     */
    private Date startCreateDate;
    private Date endCreateDate;
	public BigDecimal getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(BigDecimal minMoney) {
		this.minMoney = minMoney;
	}
	public BigDecimal getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(BigDecimal maxMoney) {
		this.maxMoney = maxMoney;
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
