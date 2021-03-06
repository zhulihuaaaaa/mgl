package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 用于接收余额查询的参数
 * @author 倪凯
 *
 */
public class FeeBalanceVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5452262035300815449L;

	/**
     * id
     */
    private String balanceId;

    /**
     * 钢厂信息
     */
    private String makerId;

    /**
     * 钢厂名称
     */
    private String makerName;

    /**
     * 客户信息
     */
    private String customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 剩余金额
     */
    private BigDecimal residualAmount;

    /**
     * 创建人
     */
    private String createUser;
	
	  /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
    private Date startCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
    private Date endCreateDate;

	public String getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(String balanceId) {
		this.balanceId = balanceId;
	}

	public String getMakerId() {
		return makerId;
	}

	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getResidualAmount() {
		return residualAmount;
	}

	public void setResidualAmount(BigDecimal residualAmount) {
		this.residualAmount = residualAmount;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
