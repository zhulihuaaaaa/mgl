package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.InvInventory;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
/**
 * InvInventoryDto
 * @author 杨思静
 * @since  2017年11月29日 - 上午9:07:03
 * @version 1.0
 */
public class InvInventoryDto implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -921557785689556384L;
	/**
	 * 库存类
	 */
	private InvInventory invInventory;
	/**
	 * 品名类
	 */
	private BaseProduct baseProduct;
	/**
	 * 合同
	 */
	private ConContract conContract;
	/**
	 * 厂家
	 */
	private DictMallMnfct dictMallMnfct;
	 /**
     * 货物商品附件列表
     */
    private List<Attach> sphotosGoodsList;
	/**************页面条件*******************/
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 业务类型列表查询
     */
    private List<String> typeList;
    /**
     * 状态 (适用各处) 
     */
    private String stats;
    /**
     * 通用id
     */
    private String id;
    /**
     * 卖方id
     */
    private String sellerId;

    /**
     * 买方id
     */
    private String buyerId;
    /**
     * 存放id
     */
    private String storageId;
    /**
     * 入库日期
     */
    private Date instockDate;
    private Date instockStartDate;
    private Date instockEndDate;
    /**
     * 表面名称
     */
    private String surfaceId;
    
    /**
     * 品名名称
     */
    private String productId;
    /**
     * 厂家名称
     */
    private String mnfctId; 
    /**
     * 材质id
     */
    private String materialId;
    /**
     * 卷号
     */
    private String volume;
    /**
     * 合同
     */
    private String contractId;
    /****************************************end*************/
	 /**
     * 卖方姓名
     */
    private String sellerName;

    /**
     * 买方姓名
     */
    private String buyerName;

    /**
     * 业务名称
     */
    private String businessName;
	
    /**
     * 存放仓库名
     */
    private String storageName;
    /**
     * 厂家名称
     */
    private String mnfctName;
    /**
     * 厂家对象
     */
    private DictMallDepot dictMallDepot;
    
    /**
     * 可以允许操作的操作的数量
     */
    private BigDecimal enableNum;

    
    /**
     * 品名名称
     */
    private String productName;
    /**
     * 合同编号
     */
    private String contractNo;
    /**
     * 材质名称
     */
    private String materialName;

    /**
     * 表面名称
     */
    private String surfaceName;
    /**
     * 均重
     */
    private BigDecimal counterpoise;
    
    
	
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public List<Attach> getSphotosGoodsList() {
		return sphotosGoodsList;
	}
	public void setSphotosGoodsList(List<Attach> sphotosGoodsList) {
		this.sphotosGoodsList = sphotosGoodsList;
	}
	public DictMallMnfct getDictMallMnfct() {
		return dictMallMnfct;
	}
	public void setDictMallMnfct(DictMallMnfct dictMallMnfct) {
		this.dictMallMnfct = dictMallMnfct;
	}
	public BigDecimal getCounterpoise() {
		// 计算出均重
		if(this.invInventory == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal quantity=this.invInventory.getQuantity();
		BigDecimal netWeight=this.invInventory.getNetWeight();
		if(quantity ==null ||netWeight ==null ||quantity.compareTo(BigDecimal.ZERO)==0||netWeight.compareTo(BigDecimal.ZERO)==0) {
			return BigDecimal.ZERO;
		}
		return netWeight.divide(quantity, 3, BigDecimal.ROUND_HALF_EVEN);
	}
	public void setCounterpoise(BigDecimal counterpoise) {
		this.counterpoise = counterpoise;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public BaseProduct getBaseProduct() {
		return baseProduct;
	}
	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}
	public ConContract getConContract() {
		return conContract;
	}
	public void setConContract(ConContract conContract) {
		this.conContract = conContract;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getStorageId() {
		return storageId;
	}
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public String getSurfaceId() {
		return surfaceId;
	}
	public void setSurfaceId(String surfaceId) {
		this.surfaceId = surfaceId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getMnfctId() {
		return mnfctId;
	}
	public void setMnfctId(String mnfctId) {
		this.mnfctId = mnfctId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getInstockDate() {
		return instockDate;
	}
	public void setInstockDate(Date instockDate) {
		this.instockDate = instockDate;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public DictMallDepot getDictMallDepot() {
		return dictMallDepot;
	}
	public void setDictMallDepot(DictMallDepot dictMallDepot) {
		this.dictMallDepot = dictMallDepot;
	}
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getStorageName() {
		return storageName;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	public String getMnfctName() {
		return mnfctName;
	}
	public void setMnfctName(String mnfctName) {
		this.mnfctName = mnfctName;
	}
	public InvInventory getInvInventory() {
		return invInventory;
	}
	public void setInvInventory(InvInventory invInventory) {
		this.invInventory = invInventory;
	}
	public BigDecimal getEnableNum() {
		BigDecimal nextOutstockQuantity = BigDecimal.ZERO;
		BigDecimal nextUnlockQuantity = BigDecimal.ZERO;
		BigDecimal quantity = BigDecimal.ZERO;
		if(this.invInventory.getQuantity() !=null){
			quantity = this.invInventory.getQuantity();
		}
		if(this.invInventory.getNextOutstockQuantity() !=null){
			nextOutstockQuantity = this.invInventory.getNextOutstockQuantity();
		}
		if(this.invInventory.getNextUnlockQuantity() !=null){
			nextUnlockQuantity = this.invInventory.getNextUnlockQuantity();
		}
		enableNum = quantity.subtract(nextUnlockQuantity).subtract(nextOutstockQuantity);
		return enableNum;
	}
	public void setEnableNum(BigDecimal enableNum) {
		this.enableNum = enableNum;
	}
	public Date getInstockStartDate() {
		return instockStartDate;
	}
	public void setInstockStartDate(Date instockStartDate) {
		this.instockStartDate = instockStartDate;
	}
	public Date getInstockEndDate() {
		return instockEndDate;
	}
	public void setInstockEndDate(Date instockEndDate) {
		this.instockEndDate = instockEndDate;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	
	@Override
	public String toString() {
		return "InvInventoryDto [invInventory=" + invInventory + ", businessType=" + businessType + ", stats=" + stats
				+ ", sellerId=" + sellerId + ", buyerId=" + buyerId + ", storageId=" + storageId + ", instockDate="
				+ instockDate + ", instockStartDate=" + instockStartDate + ", instockEndDate=" + instockEndDate
				+ ", surfaceId=" + surfaceId + ", productId=" + productId + ", mnfctId=" + mnfctId + ", sellerName="
				+ sellerName + ", buyerName=" + buyerName + ", businessName=" + businessName + ", storageName="
				+ storageName + ", mnfctName=" + mnfctName + ", dictMallDepot=" + dictMallDepot + ", enableNum="
				+ enableNum + ", productName=" + productName + ", contractNo=" + contractNo + ", materialName="
				+ materialName + ", surfaceName=" + surfaceName + "]";
	}
	
	
	
	/**
	 * 从sql查询出来的 转换城dto 传回前台  
	 */
//	public StockDto getStockDto(InvInventory inv){
//		StockDto s = new StockDto();
//		s.setBasicPrice(inv.getBasicPrice());
//		s.setBore(inv.getBore());
//		s.setBuyerId(inv.getBuyerId());
//		s.setBuyerName("");
//		s.setBusinessType("");
//		s.setBusinessName("");
////		s.set
//		return  null;
//	}
}
