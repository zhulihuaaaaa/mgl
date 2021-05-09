package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InsInspectionSub;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.vo.InsInspectionBillVo;

/**
 * 交收管理的DTO
 * @author 杨思静
 * @since  2017年11月29日 - 下午3:01:36
 * @version 1.0
 */
public class InsInspectionBillDto implements Serializable{
	/** 
	* @Fields serialVersionUID :
	*/ 
	private static final long serialVersionUID = -1355845813665300102L;
	 /**
     * 业务类型
     */
    private String businessType;
    /**
     * 业务类型列表查询
     */
    private List<String> typeList;
    /**
     * 状态列表
     */
    private List<String> auditStatusList;
    /**
     * 子验货单的单号
     */
    private String subCode;
    /**
     * 卷号
     */
    private String 	volume;
	/**
	 * 合同编号
	 */
	private String contractNo;
	/**
	 * 合同编号
	 */
	private String contractId;
	/**
	 * 合同
	 */
	private ConContract conContract;
	/**
     * 存放仓库Id
     */
    private String storageId;
    /**
     * 仓库名
     */
    private String storageName;
	
    /**
     * 入库单单号
     */
    private String instockNo;
    /**
     * 主验货单
     */
    private InsInspectionBill insInspectionBill;
     /**
      * 包含子验货单
      */
    private List<InsInspectionSub> insInspectionSubList;
    /**
     * 一张子验货单
     */
    private InsInspectionSub insInspectionSub;
    /**
     * 货品信息明细的集合
     */
    private List<InsInspectionDetail> insInspectionDetailList;
    /**
     * 货品信息明细vo集合
     */
    private List<InsInspectionBillVo> insInspectionBillVoList;
    
    /**
     * 一个货品信息
     */
    private InsInspectionDetail insInspectionDetail;
    /**
     * 一个验货单中包含的所有信息
     */
    private Map<InsInspectionSub, List<InsInspectionDetail>> InsInspectionMap;
    
    /**
     * 状态 枚举 (适用各处)
     */
    private String auditStatus;
    /**
     * id(适用各处)
     */
    private String id;
    /**
     * 时间
     */
    private Date minDate;
    private Date maxDate;
    /**
     * 主验货单号
     */
    private String inspectionBillCode;
    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 货物商品附件
     */
    private Attach SphotosGoods;
    /**
     * 货物商品附件列表
     */
    private List<Attach> sphotosGoodsList;
    /**
     * 存货凭证附件
     */
    private Attach inventoryVoucher;
    /**
     * 存货凭证附件的列表
     */
    private List<Attach> inventoryVoucherList;
    /**
     * 质保书附件
     */
    private Attach warranty;
    /**
     * 质保书附件列表
     */
    private List<Attach> warrantyList;
    
    /**
     * 品名名称
     */
    private String productName;

    /**
     * 材质名称
     */
    private String materialName;

    /**
     * 表面名称
     */
    private String surfaceName;
    

    /**
     * 厂家名称
     */
    private String mnfctName;
    /**
     * 仓库对象
     */
    private DictMallDepot dictMallDepot;
    /**
     * 厂家对象
     */
    private DictMallMnfct dictMallMnfct;
    /**
     * 品名对象
     */
    private BaseProduct baseProduct;
    /**
     * 主单id
     */
   private String  insInspectionBillId;
 	
   private String  instockId;
   
	

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



	public BaseProduct getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public DictMallMnfct getDictMallMnfct() {
		return dictMallMnfct;
	}

	public void setDictMallMnfct(DictMallMnfct dictMallMnfct) {
		this.dictMallMnfct = dictMallMnfct;
	}

	public List<String> getAuditStatusList() {
		return auditStatusList;
	}

	public void setAuditStatusList(List<String> auditStatusList) {
		this.auditStatusList = auditStatusList;
	}

	public List<InsInspectionBillVo> getInsInspectionBillVoList() {
		return insInspectionBillVoList;
	}

	public void setInsInspectionBillVoList(List<InsInspectionBillVo> insInspectionBillVoList) {
		this.insInspectionBillVoList = insInspectionBillVoList;
	}

	
	public List<Attach> getSphotosGoodsList() {
		return sphotosGoodsList;
	}

	public void setSphotosGoodsList(List<Attach> sphotosGoodsList) {
		this.sphotosGoodsList = sphotosGoodsList;
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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}

	public ConContract getConContract() {
		return conContract;
	}

	public void setConContract(ConContract conContract) {
		this.conContract = conContract;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getSurfaceName() {
		return surfaceName;
	}

	public void setSurfaceName(String surfaceName) {
		this.surfaceName = surfaceName;
	}

	public String getMnfctName() {
		return mnfctName;
	}

	public void setMnfctName(String mnfctName) {
		this.mnfctName = mnfctName;
	}

	public DictMallDepot getDictMallDepot() {
		return dictMallDepot;
	}

	public void setDictMallDepot(DictMallDepot dictMallDepot) {
		this.dictMallDepot = dictMallDepot;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<InsInspectionSub, List<InsInspectionDetail>> getInsInspectionMap() {
		return InsInspectionMap;
	}

	public void setInsInspectionMap(Map<InsInspectionSub, List<InsInspectionDetail>> insInspectionMap) {
		InsInspectionMap = insInspectionMap;
	}

	public String getInstockNo() {
		return instockNo;
	}

	public void setInstockNo(String instockNo) {
		this.instockNo = instockNo;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public List<InsInspectionSub> getInsInspectionSubList() {
		return insInspectionSubList;
	}

	public void setInsInspectionSubList(List<InsInspectionSub> insInspectionSubList) {
		this.insInspectionSubList = insInspectionSubList;
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

	public InsInspectionDetail getInsInspectionDetail() {
		return insInspectionDetail;
	}

	public void setInsInspectionDetail(InsInspectionDetail insInspectionDetail) {
		this.insInspectionDetail = insInspectionDetail;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public InsInspectionBill getInsInspectionBill() {
		return insInspectionBill;
	}

	public void setInsInspectionBill(InsInspectionBill insInspectionBill) {
		this.insInspectionBill = insInspectionBill;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public String getInspectionBillCode() {
		return inspectionBillCode;
	}

	public void setInspectionBillCode(String inspectionBillCode) {
		this.inspectionBillCode = inspectionBillCode;
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

	public Attach getSphotosGoods() {
		return SphotosGoods;
	}

	public void setSphotosGoods(Attach sphotosGoods) {
		SphotosGoods = sphotosGoods;
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


	

	
	
	
}
