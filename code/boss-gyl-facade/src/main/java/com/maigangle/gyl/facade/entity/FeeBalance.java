package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;

public class FeeBalance implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4956040166287042530L;

	/**
     * id
     */
    private String balanceId;

    /**
     * 钢厂信息
     */
    private String makerId;
	
	/**
	 * 厂商
	 */
	private DictMallMnfct mnfct;

    /**
     * 客户信息
     */
    private String customerId;
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * id
     * @return BALANCE_ID id
     */
    public String getBalanceId() {
        return balanceId;
    }

    /**
     * id
     * @param balanceId id
     */
    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId == null ? null : balanceId.trim();
    }

    /**
     * 钢厂信息
     * @return MAKER_ID 钢厂信息
     */
    public String getMakerId() {
        return makerId;
    }

    /**
     * 钢厂信息
     * @param makerId 钢厂信息
     */
    public void setMakerId(String makerId) {
        this.makerId = makerId == null ? null : makerId.trim();
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
     * 剩余金额
     * @return RESIDUAL_AMOUNT 剩余金额
     */
    public BigDecimal getResidualAmount() {
        return residualAmount;
    }

    /**
     * 剩余金额
     * @param residualAmount 剩余金额
     */
    public void setResidualAmount(BigDecimal residualAmount) {
        this.residualAmount = residualAmount;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public DictMallMnfct getMnfct() {
		return mnfct;
	}

	public void setMnfct(DictMallMnfct mnfct) {
		this.mnfct = mnfct;
	}
    
    
    
}