package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FeeBalanceDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2456803986340015166L;

	/**
     * id
     */
    private String balanceDetailId;

    /**
     * 对应余额信息
     */
    private String balanceId;

    /**
     * 关联合同信息
     */
    private String contractId;
	private ConContract contract;

    /**
     * 消费金额
     */
    private BigDecimal purchaseAmount;

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
     * 关联财务单
     */
    private String financeId;
	private FeeFinanceBill finance;

    /**
     * 余额状态 1:未退款 2:退款中 3:已退款
     */
    private String balanceState;
    private String balanceStateName;

    /**
     * id
     * @return BALANCE_DETAIL_ID id
     */
    public String getBalanceDetailId() {
        return balanceDetailId;
    }

    /**
     * id
     * @param balanceDetailId id
     */
    public void setBalanceDetailId(String balanceDetailId) {
        this.balanceDetailId = balanceDetailId == null ? null : balanceDetailId.trim();
    }

    /**
     * 对应余额信息
     * @return BALANCE_ID 对应余额信息
     */
    public String getBalanceId() {
        return balanceId;
    }

    /**
     * 对应余额信息
     * @param balanceId 对应余额信息
     */
    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId == null ? null : balanceId.trim();
    }

    /**
     * 关联合同信息
     * @return CONTRACT_ID 关联合同信息
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 关联合同信息
     * @param contractId 关联合同信息
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 消费金额
     * @return PURCHASE_AMOUNT 消费金额
     */
    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * 消费金额
     * @param purchaseAmount 消费金额
     */
    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
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

    /**
     * 关联财务单
     * @return FINANCE_ID 关联财务单
     */
    public String getFinanceId() {
        return financeId;
    }

    /**
     * 关联财务单
     * @param financeId 关联财务单
     */
    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }

    /**
     * 余额状态 1:未退款 2:退款中 3:已退款
     * @return BALANCE_STATE 余额状态 1:未退款 2:退款中 3:已退款
     */
    public String getBalanceState() {
        return balanceState;
    }

    /**
     * 余额状态 1:未退款 2:退款中 3:已退款
     * @param balanceState 余额状态 1:未退款 2:退款中 3:已退款
     */
    public void setBalanceState(String balanceState) {
        this.balanceState = balanceState == null ? null : balanceState.trim();
    }

	public ConContract getContract() {
		return contract;
	}

	public void setContract(ConContract contract) {
		this.contract = contract;
	}

	public FeeFinanceBill getFinance() {
		return finance;
	}

	public void setFinance(FeeFinanceBill finance) {
		this.finance = finance;
	}

	public String getBalanceStateName() {
		return balanceStateName;
	}

	public void setBalanceStateName(String balanceStateName) {
		this.balanceStateName = balanceStateName;
	}
}