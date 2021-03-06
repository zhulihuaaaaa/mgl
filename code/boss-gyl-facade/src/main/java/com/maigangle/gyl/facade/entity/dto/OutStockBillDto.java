package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.util.Date;

import com.maigangle.gyl.facade.entity.OutOutstockBill;

/**  
 * 出库单dto
 * 是否精确查询
 * @author zlh
 * @since 2017年12月1日 下午3:55:26 
 * @version 1.0 
 */
public class OutStockBillDto extends OutOutstockBill implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1911373283500502219L;
	/**
	 * 出库对象
	 */
	private OutOutstockBill outOutstockBill;
	/**
     * 创建日期
     */
    private Date startCreateDate;
    private Date endCreateDate;
    
    /**
     * 仓库名字
     */
    private String storageName;
    
    /**
     * 客户名称
     */
    private String clientName;
    
    /**
     * 提货人名称
     */
    private String consigneeName;
    
    /**
     * 合同编号
     */
    private String contractNo;
    
    /**
     * 提货状态名称
     */
    private String outstockStateName;
    
    /**
     * 提货状态
     */
    private String outstockStateForApprove;
    
	
	public String getOutstockStateForApprove() {
		return outstockStateForApprove;
	}
	public void setOutstockStateForApprove(String outstockStateForApprove) {
		this.outstockStateForApprove = outstockStateForApprove;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	public String getStorageName() {
		return storageName;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	public OutOutstockBill getOutOutstockBill() {
		return outOutstockBill;
	}
	public void setOutOutstockBill(OutOutstockBill outOutstockBill) {
		this.outOutstockBill = outOutstockBill;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getOutstockStateName() {
		return outstockStateName;
	}
	public void setOutstockStateName(String outstockStateName) {
		this.outstockStateName = outstockStateName;
	}


  
}