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

@ExcelTarget("RedRedeemBillExcel")
public class RedRedeemBillExcel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8578551220193767598L;

	/**
     * id
     */
    private String redeemBillId;
	
	 /**
	  * 合同单号
	  */
    @Excel(name = "合同自编号", needMerge = true)
    private String contractCode;
  
    /**
     * 合同编号
     */
    @Excel(name = "合同编号", width = 20, needMerge = true)
    private String contractNo;

    /**
     * 赎货客户id
     */
    private String buyerId;

    /**
     * 赎货客户
     */
    @Excel(name = "赎货客户")
    private String buyerName;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String createUser;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 存日期时使用
    @Excel(name = "创建日期" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date createDate;

    /**
     * 存放仓库id
     */
    private String storageId;

    /**
     * 存放仓库
     */
    @Excel(name = "存放仓库")
    private String storageName;

    /**
     * 对应合同
     */
    private String contractId;

    /**
     * 货物来源 钢厂自提/库存货物/仓单质押
     */
    @Excel(name = "货物来源", replace={"钢厂自提_A","库存货物_B","仓单质押_C"}, needMerge = true)
    private String goodsSource;

    /**
     * 总重量
     */
    @Excel(name = "总重量")
    private String totalWeight;

    /**
     * 总货款
     */
    @Excel(name = "总货款(元)")
    private BigDecimal totalGoodsPayment;

    /**
     * 手续费
     */
    @Excel(name = "手续费(元)")
    private BigDecimal commissionFee;

    /**
     * 开票费
     */
    @Excel(name = "开票费(元)")
    private BigDecimal invoiceFee;

    /**
     * 其他费用
     */
    @Excel(name = "其他费用(元)")
    private BigDecimal otherFee;

    /**
     * 计费天数
     */
    @Excel(name = "计费天数")
    private BigDecimal chargingDays;

    /**
     * 保证金抵消金额
     */
    @Excel(name = "保证金抵消金额(元)")
    private BigDecimal depositFee;

    /**
     * 关联保证金消费记录
     */
    private String depositDetailId;

    /**
     * 总金额
     */
    @Excel(name = "总金额(元)")
    private BigDecimal totalMoney;

    /**
     * 待付总金额
     */
    @Excel(name = "待付总金额(元)")
    private BigDecimal realMoney;

    /**
     * 提货人
     */
    @Excel(name = "提货人")
    private String consignee;

    /**
     * 提货人电话
     */
    @Excel(name = "提货人电话", width = 20, needMerge = true)
    private String consigneeTel;

    /**
     * 提货人身份证号
     */
    @Excel(name = "提货人身份证号", width = 30, needMerge = true)
    private String consigneeIdNo;

    /**
     * 审核状态  0:已提交、1:审核中、2:未通过、3:已通过
     */
    @Excel(name = "审核状态", replace={"未提交_null","未审批_A","审批中_B","已拒绝_C","已通过_D","已作废_E"}, needMerge = true)
    private String auditStatus;

    /**
     * 赎货状态  N:未出库、Y:已出库
     */
    @Excel(name = "赎货状态", replace={"已保存_A","待审核_B","待收款_C","待出库_D","已出库_E","已作废_F"}, needMerge = true)
    private String redeemStatus;

    /**
     * 对应提货单ID
     */
    private String outstockId;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 赎货单号
     */
    @Excel(name = "赎货单号")
    private String redeemBillCode;

    /**
     * 车牌号
     */
    @Excel(name = "车牌号")
    private String carNumber;

    /**
     * 赎货款状态
     */
    private String redeemMoneyState;

	public String getRedeemBillId() {
		return redeemBillId;
	}

	public void setRedeemBillId(String redeemBillId) {
		this.redeemBillId = redeemBillId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
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

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getGoodsSource() {
		return goodsSource;
	}

	public void setGoodsSource(String goodsSource) {
		this.goodsSource = goodsSource;
	}

	public String getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
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

	public BigDecimal getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(BigDecimal otherFee) {
		this.otherFee = otherFee;
	}

	public BigDecimal getChargingDays() {
		return chargingDays;
	}

	public void setChargingDays(BigDecimal chargingDays) {
		this.chargingDays = chargingDays;
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

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(BigDecimal realMoney) {
		this.realMoney = realMoney;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeTel() {
		return consigneeTel;
	}

	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}

	public String getConsigneeIdNo() {
		return consigneeIdNo;
	}

	public void setConsigneeIdNo(String consigneeIdNo) {
		this.consigneeIdNo = consigneeIdNo;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getRedeemStatus() {
		return redeemStatus;
	}

	public void setRedeemStatus(String redeemStatus) {
		this.redeemStatus = redeemStatus;
	}

	public String getOutstockId() {
		return outstockId;
	}

	public void setOutstockId(String outstockId) {
		this.outstockId = outstockId;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getRedeemBillCode() {
		return redeemBillCode;
	}

	public void setRedeemBillCode(String redeemBillCode) {
		this.redeemBillCode = redeemBillCode;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getRedeemMoneyState() {
		return redeemMoneyState;
	}

	public void setRedeemMoneyState(String redeemMoneyState) {
		this.redeemMoneyState = redeemMoneyState;
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

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
    
	

}