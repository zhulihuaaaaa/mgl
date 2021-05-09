package com.maigangle.gyl.facade.entity.excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.api.CrmClient;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("FeeFinanceBillExcel")
public class FeeFinanceBillExcel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3241841623023266630L;

	/**
     * id
     */
    private String financeBillId;

    /**
     * 合同Code
     */
    @Excel(name = "合同自编号", width = 20, needMerge = true)
    private String contractCode;
   
    /**
     * 合同编号
     */
    @Excel(name = "合同编号", width = 20, needMerge = true)
    private String contractNo;

    /**
     * 财务单号
     */
    @Excel(name = "财务单号", needMerge = true)
    private String financeCode;

    /**
     * 关联单号
     */
    @Excel(name = "关联单号", needMerge = true)
    private String relationCode;

    /**
     * 资金流向 进账/出账
     */
    @Excel(name = "资金流向 ", replace={"进账_A","出账_B"}, needMerge = true)
    private String flwoType;

    /**
     * 关联合同
     */
    private String contractId;

    /**
     * 业务类型 履约保证金/追加保证金/追加货款/购货款/赎货款
     */
    @Excel(name = "业务类型", replace={"履约保证金_A","追加保证金_B","追加货款_C","购货款_D","赎货款_E"}, needMerge = true)
    private String businessType;

    /**
     * 款项说明
     */
    private String description;

    /**
     * 总货款
     */
    private BigDecimal totalGoodsPayment;

    /**
     * 手续费
     */
    private BigDecimal commissionFee;

    /**
     * 开票费
     */
    private BigDecimal invoiceFee;

    /**
     * 计费天数
     */
    private BigDecimal chargingDays;

    /**
     * 其他费用
     */
    private BigDecimal otherFee;

    /**
     * 总金额
     */
    private BigDecimal totalMoney;

    /**
     * 实际到账金额
     */
    @Excel(name = "实际金额(元)", needMerge = true)
    private BigDecimal actualAmount;

    /**
     * 待付总金额
     */
    @Excel(name = "待付总金额(元)", needMerge = true)
    private BigDecimal realMoney;

    /**
     * 保证金抵扣金额
     */
    private BigDecimal depositFee;

    /**
     * 关联保证金消费记录
     */
    private String depositDetailId;

    /**
     * 操作员
     */
    @Excel(name = "操作员", needMerge = true)
    private String operator;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @Excel(name = "操作时间" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date operatorDate;

    /**
     * N:未完成 Y:完成
     */
    @Excel(name = "财务单状态 ", replace={"未完成_N","已完成_Y"}, needMerge = true)
    private String status;

    /**
     * 创建日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    @Excel(name = "创建日期" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date createDate;

    /**
     * 备注
     */
    private String notes;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 关联单Id
     */
    private String relationId;

	public String getFinanceBillId() {
		return financeBillId;
	}

	public void setFinanceBillId(String financeBillId) {
		this.financeBillId = financeBillId;
	}

	public String getFinanceCode() {
		return financeCode;
	}

	public void setFinanceCode(String financeCode) {
		this.financeCode = financeCode;
	}

	public String getRelationCode() {
		return relationCode;
	}

	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}

	public String getFlwoType() {
		return flwoType;
	}

	public void setFlwoType(String flwoType) {
		this.flwoType = flwoType;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getTotalGoodsPayment() {
		return totalGoodsPayment;
	}

	public void setTotalGoodsPayment(BigDecimal totalGoodsPayment) {
		this.totalGoodsPayment = totalGoodsPayment;
	}

	public BigDecimal getCommissionFee() {
		return commissionFee;
	}

	public void setCommissionFee(BigDecimal commissionFee) {
		this.commissionFee = commissionFee;
	}

	public BigDecimal getInvoiceFee() {
		return invoiceFee;
	}

	public void setInvoiceFee(BigDecimal invoiceFee) {
		this.invoiceFee = invoiceFee;
	}

	public BigDecimal getChargingDays() {
		return chargingDays;
	}

	public void setChargingDays(BigDecimal chargingDays) {
		this.chargingDays = chargingDays;
	}

	public BigDecimal getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	public BigDecimal getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(BigDecimal realMoney) {
		this.realMoney = realMoney;
	}

	public BigDecimal getDepositFee() {
		return depositFee;
	}

	public void setDepositFee(BigDecimal depositFee) {
		this.depositFee = depositFee;
	}

	public String getDepositDetailId() {
		return depositDetailId;
	}

	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperatorDate() {
		return operatorDate;
	}

	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

}