package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**  
 * 逾期dto
 * @author zlh
 * @since 2017年1月30日 下午3:55:26 
 * @version 1.0 
 */
public class OverdueDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -999589940052921489L;
	/**
	 * 合同id
	 */
	private String contractId;
	/**
	 * 合同编号
	 */
	private String contractNo;
	/**
	 * 合同自编号
	 */
	private String contractCode;
	/**
	 * 签订日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date signDate;
	
	/**
	 * 签订开始日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date signStartDate;
	
	/**
	 * 签订结束日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date signEndDate;
	/**
	 * 合同期限
	 */
	private BigDecimal contractPeriod;
	/**
	 * 逾期天数
	 */
	private BigDecimal overdue;
	
	/**
	 * 申请延期的时间
	 */
	private BigDecimal section;
	
	
	public BigDecimal getSection() {
		return section;
	}
	public void setSection(BigDecimal section) {
		this.section = section;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public BigDecimal getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(BigDecimal contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public BigDecimal getOverdue() {
		return overdue;
	}
	public void setOverdue(BigDecimal overdue) {
		this.overdue = overdue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getSignStartDate() {
		return signStartDate;
	}
	public void setSignStartDate(Date signStartDate) {
		this.signStartDate = signStartDate;
	}
	public Date getSignEndDate() {
		return signEndDate;
	}
	public void setSignEndDate(Date signEndDate) {
		this.signEndDate = signEndDate;
	}
	
	
}
