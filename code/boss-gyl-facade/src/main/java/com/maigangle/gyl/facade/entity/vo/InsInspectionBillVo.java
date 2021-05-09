package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InsInspectionSub;

/**
 * 交收管理的DTO
 * @author 杨思静
 * @since  2017年11月29日 - 下午3:01:36
 * @version 1.0
 */
public class InsInspectionBillVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2225639738257887481L;
	/*********************页面查询************/
	/**
     * 合同ID
     */
    private String contractId;
    /*
	 * 状态
	 */
	private String auditStatus;
	/**
	 * 状态列表
	 */
	private List<String> auditStatusList;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
	private Date maxDate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
	private Date minDate;
	/**
	 * 卷号
	 */
	private String volume;
	/******************end******************/
	/**
	 * id
	 */
	private String id;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 业务类型
	 */
	private String businessType;
	/**
	 * 业务类型列表
	 */
	private List<String> typeList;
	/**
	 * 合同编号
	 */
	private String contractNo;
	/**
	 * 子验货单单号
	 */
	private String subCode;
	  /**
     * 创建人
     */
    private String createUser;
    
    /***********新增合同和货品明细******/
    /**
     * 一张子验货单
     */
    private InsInspectionSub insInspectionSub;
    
    /**
     * 验货单号
     */
    private String inspectionBillCode;
    /**
     * 存货凭证附件
     */
    private Attach inventoryVoucher;
    private List<Attach> inventoryVoucherList;
    /**
     * 质保书附件
     */
    private Attach warranty;
    private List<Attach> warrantyList;
    /**
     * 编辑子单图片的 意图删除的id
     */
    private List<String> deleteAttachList;
    /**
     * 备注
     */
    private String remark;
    /**
     * 货品信息明细的集合
     */
    private List<InsInspectionDetail> insInspectionDetailList;   
    /**
     *货物信息列表 里面含有附件
     */
    private List<InsInspectionBillVo> insInspectionBillVoList;
	/***********新增合同和货品明细END**************/
    /****************新增货物信息***********************/
    private InsInspectionDetail insInspectionDetail;
    
    /**
     * 货物商品附件
     */
    private Attach sphotosGoods;
    /**
     * 附件商品列表
     */
    private List<Attach> sphotosGoodsList;
    // 修改或删除或增加 
    //  修改: 1 删除:2 增加:3 
    private String isUpdateOrAddOrDel;
    /******************end***************************/
    /**
     * 主单id
     */
   private String  insInspectionBillId;
    
    /**
     * 入库单id
     */
   private String instockId;


	public List<String> getDeleteAttachList() {
		return deleteAttachList;
	}

	public void setDeleteAttachList(List<String> deleteAttachList) {
		this.deleteAttachList = deleteAttachList;
	}

	public String getInstockId() {
		return instockId;
	}

	public void setInstockId(String instockId) {
		this.instockId = instockId;
	}

	public String getInsInspectionBillId() {
		return insInspectionBillId;
	}

	public void setInsInspectionBillId(String insInspectionBillId) {
		this.insInspectionBillId = insInspectionBillId;
	}

	public String getInspectionBillCode() {
		return inspectionBillCode;
	}
	
	public String getIsUpdateOrAddOrDel() {
		return isUpdateOrAddOrDel;
	}

	public void setIsUpdateOrAddOrDel(String isUpdateOrAddOrDel) {
		this.isUpdateOrAddOrDel = isUpdateOrAddOrDel;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public List<String> getAuditStatusList() {
		return auditStatusList;
	}

	public void setAuditStatusList(List<String> auditStatusList) {
		this.auditStatusList = auditStatusList;
	}

	public List<Attach> getInventoryVoucherList() {
		return inventoryVoucherList;
	}

	public void setInventoryVoucherList(List<Attach> inventoryVoucherList) {
		this.inventoryVoucherList = inventoryVoucherList;
	}

	public List<Attach> getWarrantyList() {
		return warrantyList;
	}

	public void setWarrantyList(List<Attach> warrantyList) {
		this.warrantyList = warrantyList;
	}

	public List<InsInspectionBillVo> getInsInspectionBillVoList() {
		return insInspectionBillVoList;
	}

	public void setInsInspectionBillVoList(List<InsInspectionBillVo> insInspectionBillVoList) {
		this.insInspectionBillVoList = insInspectionBillVoList;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}


	public Attach getSphotosGoods() {
		return sphotosGoods;
	}

	public void setSphotosGoods(Attach sphotosGoods) {
		this.sphotosGoods = sphotosGoods;
	}

	

	
	public List<Attach> getSphotosGoodsList() {
		return sphotosGoodsList;
	}

	public void setSphotosGoodsList(List<Attach> sphotosGoodsList) {
		this.sphotosGoodsList = sphotosGoodsList;
	}

	public InsInspectionDetail getInsInspectionDetail() {
		return insInspectionDetail;
	}
	public void setInsInspectionDetail(InsInspectionDetail insInspectionDetail) {
		this.insInspectionDetail = insInspectionDetail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Attach getInventoryVoucher() {
		return inventoryVoucher;
	}
	public void setInventoryVoucher(Attach inventoryVoucher) {
		this.inventoryVoucher = inventoryVoucher;
	}
	public Attach getWarranty() {
		return warranty;
	}
	public void setWarranty(Attach warranty) {
		this.warranty = warranty;
	}
	public void setInspectionBillCode(String inspectionBillCode) {
		this.inspectionBillCode = inspectionBillCode;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Date getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}
	public Date getMinDate() {
		return minDate;
	}
	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public InsInspectionSub getInsInspectionSub() {
		return insInspectionSub;
	}
	public void setInsInspectionSub(InsInspectionSub insInspectionSub) {
		this.insInspectionSub = insInspectionSub;
	}
	public List<InsInspectionDetail> getInsInspectionDetailList() {
		return insInspectionDetailList;
	}
	public void setInsInspectionDetailList(List<InsInspectionDetail> insInspectionDetailList) {
		this.insInspectionDetailList = insInspectionDetailList;
	}

	@Override
	public String toString() {
		return "InsInspectionBillVo [contractId=" + contractId + ", auditStatus=" + auditStatus + ", maxDate=" + maxDate
				+ ", minDate=" + minDate + ", id=" + id + ", price=" + price + ", businessType=" + businessType
				+ ", typeList=" + typeList + ", contractNo=" + contractNo + ", subCode=" + subCode + ", createUser="
				+ createUser + ", insInspectionSub=" + insInspectionSub + ", inspectionBillCode=" + inspectionBillCode
				+ ", inventoryVoucher=" + inventoryVoucher + ", inventoryVoucherList=" + inventoryVoucherList
				+ ", warranty=" + warranty + ", warrantyList=" + warrantyList + ", remark=" + remark
				+ ", insInspectionDetailList=" + insInspectionDetailList + ", insInspectionBillVoList="
				+ insInspectionBillVoList + ", insInspectionDetail=" + insInspectionDetail + ", sphotosGoods="
				+ sphotosGoods + ", sphotosGoodsList=" + sphotosGoodsList + "]";
	}

	
	

	

	
	
	
}
