package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.InInstockBill;

/**  
 * 入库单dto
 * 是否精确查询
 * @author zlh
 * @since 2017年12月1日 下午3:55:26 
 * @version 1.0 
 */
public class InStockBillDto extends InInstockBill implements Serializable{
	
	private static final long serialVersionUID = -2978381255531236399L;
	
	private InInstockBill bill;
	
	/**
	 * 合同编号
	 */
	private String contractNo;
	
	/**
	 * 合同code
	 */
	private String contractCode;
	
	/**
     * 创建日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date startCreateDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date endCreateDate;
    
    /**
     * 总重量（吨）
     */
    private BigDecimal minTotalWeight;
    private BigDecimal totalWeight;
    private BigDecimal maxTotalWeight;
    
    /**
     * 货物总价
     */
    private BigDecimal minTotalMoney;
    private BigDecimal totalMoney;
    private BigDecimal maxTotalMoney;
    
    /**
     * 保证金金额
     */
    private BigDecimal minDepositFee;
    private BigDecimal depositFee;
    private BigDecimal maxDepositFee;
    
    /**
     * 合同期限（日）
     */
    private BigDecimal startContractPeriod;
    private BigDecimal contractPeriod;
    private BigDecimal endContractPeriod;

    
    
	public BigDecimal getMinTotalWeight() {
		return minTotalWeight;
	}
	public void setMinTotalWeight(BigDecimal minTotalWeight) {
		this.minTotalWeight = minTotalWeight;
	}
	public BigDecimal getMaxTotalWeight() {
		return maxTotalWeight;
	}
	public void setMaxTotalWeight(BigDecimal maxTotalWeight) {
		this.maxTotalWeight = maxTotalWeight;
	}
	public BigDecimal getMinTotalMoney() {
		return minTotalMoney;
	}
	public void setMinTotalMoney(BigDecimal minTotalMoney) {
		this.minTotalMoney = minTotalMoney;
	}
	public BigDecimal getMaxTotalMoney() {
		return maxTotalMoney;
	}
	public void setMaxTotalMoney(BigDecimal maxTotalMoney) {
		this.maxTotalMoney = maxTotalMoney;
	}
	public BigDecimal getMinDepositFee() {
		return minDepositFee;
	}
	public void setMinDepositFee(BigDecimal minDepositFee) {
		this.minDepositFee = minDepositFee;
	}
	public BigDecimal getMaxDepositFee() {
		return maxDepositFee;
	}
	public void setMaxDepositFee(BigDecimal maxDepositFee) {
		this.maxDepositFee = maxDepositFee;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public InInstockBill getBill() {
		return bill;
	}
	public void setBill(InInstockBill bill) {
		this.bill = bill;
	}
	public BigDecimal getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}
	public BigDecimal getDepositFee() {
		return depositFee;
	}
	public void setDepositFee(BigDecimal depositFee) {
		this.depositFee = depositFee;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public BigDecimal getStartContractPeriod() {
		return startContractPeriod;
	}
	public void setStartContractPeriod(BigDecimal startContractPeriod) {
		this.startContractPeriod = startContractPeriod;
	}
	public BigDecimal getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(BigDecimal contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public BigDecimal getEndContractPeriod() {
		return endContractPeriod;
	}
	public void setEndContractPeriod(BigDecimal endContractPeriod) {
		this.endContractPeriod = endContractPeriod;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	

  
}