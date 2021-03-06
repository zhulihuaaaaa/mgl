package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;

/**
 * 发票筛选条件Vo
 * @author zlh
 * @since  2018年2月6日 - 上午9:07:03
 * @version 1.0
 */
public class InvoiceGoodsConditionVo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3160738606028809456L;
	
	/**
     * null
     */
    private String id;
    
    /**
   	 * 合同单号
   	 */
    private String contractCode;
    /**
   	 * 合同id
   	 */
    private String contractId;
    /**
	 * 厂商
	 */
	private DictMallMnfct mnfct;
	
	/**
	 * 存放仓库
	 */
	private DictMallDepot storage;
	
	/**
	 * 品名
	 */
	private BaseProduct product;
    
    /**
     * 存放仓库ID
     */
    private String storageId;

    /**
     * 品名
     */
    private String productId;

    /**
     * 材质
     */
    private String materialId;

    /**
     * 表面
     */
    private String surfaceId;

    /**
     * 标签厚度
     */
    private String labelThick;

    /**
     * 标签宽度
     */
    private String labelWidth;

    /**
     * 长度
     */
    private String goodsLength;

    /**
     * 边部
     */
    private String edge;

    /**
     * 参厚
     */
    private BigDecimal referThick;

    /**
     * 实宽
     */
    private BigDecimal realWidth;

    /**
     * 牌号
     */
    private String trademark;

    /**
     * 卷号
     */
    private String volume;

    /**
     * 厂家
     */
    private String mnfctId;

    /**
     * 净重
     */
    private BigDecimal netWeight;

    /**
     * 数量（张/卷）
     */
    private BigDecimal amount;

    /**
     * 计算方式
     */
    private String calcMethod;

    /**
     * 等级
     */
    private String grade;
    /**
     * 赎货金额
     */
    private BigDecimal redeemMoney;
    
    /**
     * 手续费
     */
    private BigDecimal serviceFee;

    /**
     * 开票费
     */
    private BigDecimal invoiceFee;
    
    /**
     * 发票金额
     */
    private BigDecimal invoiceMoney;
    
    /**
     * 合同单价
     */
    private BigDecimal contractUnitPrice;
    
	public BigDecimal getRedeemMoney() {
		return redeemMoney;
	}

	public void setRedeemMoney(BigDecimal redeemMoney) {
		this.redeemMoney = redeemMoney;
	}

	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public BigDecimal getInvoiceFee() {
		return invoiceFee;
	}

	public void setInvoiceFee(BigDecimal invoiceFee) {
		this.invoiceFee = invoiceFee;
	}

	public BigDecimal getInvoiceMoney() {
		return invoiceMoney;
	}

	public void setInvoiceMoney(BigDecimal invoiceMoney) {
		this.invoiceMoney = invoiceMoney;
	}

	public DictMallMnfct getMnfct() {
		return mnfct;
	}

	public void setMnfct(DictMallMnfct mnfct) {
		this.mnfct = mnfct;
	}

	public DictMallDepot getStorage() {
		return storage;
	}

	public void setStorage(DictMallDepot storage) {
		this.storage = storage;
	}

	public BaseProduct getProduct() {
		return product;
	}

	public void setProduct(BaseProduct product) {
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getSurfaceId() {
		return surfaceId;
	}

	public void setSurfaceId(String surfaceId) {
		this.surfaceId = surfaceId;
	}

	public String getLabelThick() {
		return labelThick;
	}

	public void setLabelThick(String labelThick) {
		this.labelThick = labelThick;
	}

	public String getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(String labelWidth) {
		this.labelWidth = labelWidth;
	}

	public String getGoodsLength() {
		return goodsLength;
	}

	public void setGoodsLength(String goodsLength) {
		this.goodsLength = goodsLength;
	}

	public String getEdge() {
		return edge;
	}

	public void setEdge(String edge) {
		this.edge = edge;
	}

	public BigDecimal getReferThick() {
		return referThick;
	}

	public void setReferThick(BigDecimal referThick) {
		this.referThick = referThick;
	}

	public BigDecimal getRealWidth() {
		return realWidth;
	}

	public void setRealWidth(BigDecimal realWidth) {
		this.realWidth = realWidth;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getMnfctId() {
		return mnfctId;
	}

	public void setMnfctId(String mnfctId) {
		this.mnfctId = mnfctId;
	}

	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCalcMethod() {
		return calcMethod;
	}

	public void setCalcMethod(String calcMethod) {
		this.calcMethod = calcMethod;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public BigDecimal getContractUnitPrice() {
		return contractUnitPrice;
	}

	public void setContractUnitPrice(BigDecimal contractUnitPrice) {
		this.contractUnitPrice = contractUnitPrice;
	}

}
