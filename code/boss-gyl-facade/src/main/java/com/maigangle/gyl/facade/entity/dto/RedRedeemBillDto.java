package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;

/**  
 * 赎货主单dto
 * 是否精确查询
 * @author zlh
 * @since 2017年12月1日 下午3:53:43 
 * @version 1.0 
 */
public class RedRedeemBillDto extends RedRedeemBill implements Serializable{
	
	private static final long serialVersionUID = -3581749070402254066L;

	/**
	 * 货物来源
	 */
	private String goodsSourceName;
	/**
	 * 赎货客户名称
	 */
	private String buyerName;
	
	/**
	 * 对应合同编号
	 */
	private String contractNo;
	
	/**
	 * 对应合同code
	 */
	private String contractCode;

    /**
     * 创建日期
     */
    private Date startCreateDate;
    private Date endCreateDate;
    /**
     * 仓库
     */
    private DictMallDepot dictMallDepot;
    
    /**
     * 审核状态
     */
    private List<String> auditStatusSearch;
    
    /**
     * 货物来源
     */
    private List<String> goodsSourceSearch;
    
    /**
     * 审批类型 通过，拒绝
     */
    private String auditType;
    
	public String getGoodsSourceName() {
		return goodsSourceName;
	}
	public void setGoodsSourceName(String goodsSourceName) {
		this.goodsSourceName = goodsSourceName;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
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
	public DictMallDepot getDictMallDepot() {
		return dictMallDepot;
	}
	public void setDictMallDepot(DictMallDepot dictMallDepot) {
		this.dictMallDepot = dictMallDepot;
	}
	public List<String> getAuditStatusSearch() {
		return auditStatusSearch;
	}
	public void setAuditStatusSearch(List<String> auditStatusSearch) {
		this.auditStatusSearch = auditStatusSearch;
	}
	public List<String> getGoodsSourceSearch() {
		return goodsSourceSearch;
	}
	public void setGoodsSourceSearch(List<String> goodsSourceSearch) {
		this.goodsSourceSearch = goodsSourceSearch;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	
}