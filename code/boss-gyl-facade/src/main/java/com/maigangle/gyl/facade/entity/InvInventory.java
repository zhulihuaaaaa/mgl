package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InvInventory implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3299827273696154403L;

	/**
     * id
     */
    private String inventoryId;

    /**
     * 卖方信息
     */
    private String sellerId;

    /**
     * 买方信息
     */
    private String buyerId;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 存放仓库
     */
    private String storageId;

    /**
     * 入库日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 存日期时使用
    private Date instockDate;

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
    private BigDecimal quantity;

    /**
     * 待解锁数量
     */
    private BigDecimal nextUnlockQuantity;

    /**
     * 待出库数量
     */
    private BigDecimal nextOutstockQuantity;

    /**
     * 计算方式
     */
    private String calcMethod;

    /**
     * 等级
     */
    private String grade;

    /**
     * 合同单价（元/kg）
     */
    private BigDecimal contractUnitPrice;

    /**
     * 实际单价（元/kg）
     */
    private BigDecimal realUnitPrice;

    /**
     * 升贴水
     */
    private BigDecimal floatPrice;

    /**
     * 基价
     */
    private BigDecimal basicPrice;

    /**
     * 商城价
     */
    private BigDecimal storePrice;

    /**
     * 合同金额
     */
    private BigDecimal contractMoney;

    /**
     * 实际金额
     */
    private BigDecimal realMoney;

    /**
     * 执行标准
     */
    private String implStd;

    /**
     * 备注
     */
    private String notes;

    /**
     * N:否 Y:是
     */
    private String isDel;

    /**
     * 内径
     */
    private BigDecimal bore;

    /**
     * 关联合同id
     */
    private String contractId;
    /**
     * 验货单明细ID
     */
    private String sourceId;

    /**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;

    /**
     * 是否为自由货物
     */
    private String ownCargo;

    /**
     * id
     * @return INVENTORY_ID id
     */
    public String getInventoryId() {
        return inventoryId;
    }

    /**
     * id
     * @param inventoryId id
     */
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId == null ? null : inventoryId.trim();
    }

    /**
     * 卖方信息
     * @return SELLER_ID 卖方信息
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 卖方信息
     * @param sellerId 卖方信息
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    /**
     * 买方信息
     * @return BUYER_ID 买方信息
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * 买方信息
     * @param buyerId 买方信息
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    /**
     * 业务类型
     * @return BUSINESS_TYPE 业务类型
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 业务类型
     * @param businessType 业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * 存放仓库
     * @return STORAGE_ID 存放仓库
     */
    public String getStorageId() {
        return storageId;
    }

    /**
     * 存放仓库
     * @param storageId 存放仓库
     */
    public void setStorageId(String storageId) {
        this.storageId = storageId == null ? null : storageId.trim();
    }

    /**
     * 入库日期
     * @return INSTOCK_DATE 入库日期
     */
    public Date getInstockDate() {
        return instockDate;
    }

    /**
     * 入库日期
     * @param instockDate 入库日期
     */
    public void setInstockDate(Date instockDate) {
        this.instockDate = instockDate;
    }

    /**
     * 品名
     * @return PRODUCT_ID 品名
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 品名
     * @param productId 品名
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * 材质
     * @return MATERIAL_ID 材质
     */
    public String getMaterialId() {
        return materialId;
    }

    /**
     * 材质
     * @param materialId 材质
     */
    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    /**
     * 表面
     * @return SURFACE_ID 表面
     */
    public String getSurfaceId() {
        return surfaceId;
    }

    /**
     * 表面
     * @param surfaceId 表面
     */
    public void setSurfaceId(String surfaceId) {
        this.surfaceId = surfaceId == null ? null : surfaceId.trim();
    }

    /**
     * 标签厚度
     * @return LABEL_THICK 标签厚度
     */
    public String getLabelThick() {
        return labelThick;
    }

    /**
     * 标签厚度
     * @param labelThick 标签厚度
     */
    public void setLabelThick(String labelThick) {
        this.labelThick = labelThick == null ? null : labelThick.trim();
    }

    /**
     * 标签宽度
     * @return LABEL_WIDTH 标签宽度
     */
    public String getLabelWidth() {
        return labelWidth;
    }

    /**
     * 标签宽度
     * @param labelWidth 标签宽度
     */
    public void setLabelWidth(String labelWidth) {
        this.labelWidth = labelWidth == null ? null : labelWidth.trim();
    }

    /**
     * 长度
     * @return GOODS_LENGTH 长度
     */
    public String getGoodsLength() {
        return goodsLength;
    }

    /**
     * 长度
     * @param goodsLength 长度
     */
    public void setGoodsLength(String goodsLength) {
        this.goodsLength = goodsLength == null ? null : goodsLength.trim();
    }

    /**
     * 边部
     * @return EDGE 边部
     */
    public String getEdge() {
        return edge;
    }

    /**
     * 边部
     * @param edge 边部
     */
    public void setEdge(String edge) {
        this.edge = edge == null ? null : edge.trim();
    }

    /**
     * 参厚
     * @return REFER_THICK 参厚
     */
    public BigDecimal getReferThick() {
        return referThick;
    }

    /**
     * 参厚
     * @param referThick 参厚
     */
    public void setReferThick(BigDecimal referThick) {
        this.referThick = referThick;
    }

    /**
     * 实宽
     * @return REAL_WIDTH 实宽
     */
    public BigDecimal getRealWidth() {
        return realWidth;
    }

    /**
     * 实宽
     * @param realWidth 实宽
     */
    public void setRealWidth(BigDecimal realWidth) {
        this.realWidth = realWidth;
    }

    /**
     * 牌号
     * @return TRADEMARK 牌号
     */
    public String getTrademark() {
        return trademark;
    }

    /**
     * 牌号
     * @param trademark 牌号
     */
    public void setTrademark(String trademark) {
        this.trademark = trademark == null ? null : trademark.trim();
    }

    /**
     * 卷号
     * @return VOLUME 卷号
     */
    public String getVolume() {
        return volume;
    }

    /**
     * 卷号
     * @param volume 卷号
     */
    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    /**
     * 厂家
     * @return MNFCT_ID 厂家
     */
    public String getMnfctId() {
        return mnfctId;
    }

    /**
     * 厂家
     * @param mnfctId 厂家
     */
    public void setMnfctId(String mnfctId) {
        this.mnfctId = mnfctId == null ? null : mnfctId.trim();
    }

    /**
     * 净重
     * @return NET_WEIGHT 净重
     */
    public BigDecimal getNetWeight() {
        return netWeight;
    }

    /**
     * 净重
     * @param netWeight 净重
     */
    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    /**
     * 数量（张/卷）
     * @return QUANTITY 数量（张/卷）
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * 数量（张/卷）
     * @param quantity 数量（张/卷）
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * 待解锁数量
     * @return NEXT_UNLOCK_QUANTITY 待解锁数量
     */
    public BigDecimal getNextUnlockQuantity() {
        return nextUnlockQuantity;
    }

    /**
     * 待解锁数量
     * @param nextUnlockQuantity 待解锁数量
     */
    public void setNextUnlockQuantity(BigDecimal nextUnlockQuantity) {
        this.nextUnlockQuantity = nextUnlockQuantity;
    }

    /**
     * 待出库数量
     * @return NEXT_OUTSTOCK_QUANTITY 待出库数量
     */
    public BigDecimal getNextOutstockQuantity() {
        return nextOutstockQuantity;
    }

    /**
     * 待出库数量
     * @param nextOutstockQuantity 待出库数量
     */
    public void setNextOutstockQuantity(BigDecimal nextOutstockQuantity) {
        this.nextOutstockQuantity = nextOutstockQuantity;
    }

    /**
     * 计算方式
     * @return CALC_METHOD 计算方式
     */
    public String getCalcMethod() {
        return calcMethod;
    }

    /**
     * 计算方式
     * @param calcMethod 计算方式
     */
    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod == null ? null : calcMethod.trim();
    }

    /**
     * 等级
     * @return GRADE 等级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 等级
     * @param grade 等级
     */
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    /**
     * 合同单价（元/kg）
     * @return CONTRACT_UNIT_PRICE 合同单价（元/kg）
     */
    public BigDecimal getContractUnitPrice() {
        return contractUnitPrice;
    }

    /**
     * 合同单价（元/kg）
     * @param contractUnitPrice 合同单价（元/kg）
     */
    public void setContractUnitPrice(BigDecimal contractUnitPrice) {
        this.contractUnitPrice = contractUnitPrice;
    }

    /**
     * 实际单价（元/kg）
     * @return REAL_UNIT_PRICE 实际单价（元/kg）
     */
    public BigDecimal getRealUnitPrice() {
        return realUnitPrice;
    }

    /**
     * 实际单价（元/kg）
     * @param realUnitPrice 实际单价（元/kg）
     */
    public void setRealUnitPrice(BigDecimal realUnitPrice) {
        this.realUnitPrice = realUnitPrice;
    }

    /**
     * 升贴水
     * @return FLOAT_PRICE 升贴水
     */
    public BigDecimal getFloatPrice() {
        return floatPrice;
    }

    /**
     * 升贴水
     * @param floatPrice 升贴水
     */
    public void setFloatPrice(BigDecimal floatPrice) {
        this.floatPrice = floatPrice;
    }

    /**
     * 基价
     * @return BASIC_PRICE 基价
     */
    public BigDecimal getBasicPrice() {
        return basicPrice;
    }

    /**
     * 基价
     * @param basicPrice 基价
     */
    public void setBasicPrice(BigDecimal basicPrice) {
        this.basicPrice = basicPrice;
    }

    /**
     * 商城价
     * @return STORE_PRICE 商城价
     */
    public BigDecimal getStorePrice() {
        return storePrice;
    }

    /**
     * 商城价
     * @param storePrice 商城价
     */
    public void setStorePrice(BigDecimal storePrice) {
        this.storePrice = storePrice;
    }

    /**
     * 合同金额
     * @return CONTRACT_MONEY 合同金额
     */
    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    /**
     * 合同金额
     * @param contractMoney 合同金额
     */
    public void setContractMoney(BigDecimal contractMoney) {
        this.contractMoney = contractMoney;
    }

    /**
     * 实际金额
     * @return REAL_MONEY 实际金额
     */
    public BigDecimal getRealMoney() {
        return realMoney;
    }

    /**
     * 实际金额
     * @param realMoney 实际金额
     */
    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    /**
     * 执行标准
     * @return IMPL_STD 执行标准
     */
    public String getImplStd() {
        return implStd;
    }

    /**
     * 执行标准
     * @param implStd 执行标准
     */
    public void setImplStd(String implStd) {
        this.implStd = implStd == null ? null : implStd.trim();
    }

    /**
     * 备注
     * @return NOTES 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 备注
     * @param notes 备注
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * N:否 Y:是
     * @return IS_DEL N:否 Y:是
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * N:否 Y:是
     * @param isDel N:否 Y:是
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    /**
     * 内径
     * @return BORE 内径
     */
    public BigDecimal getBore() {
        return bore;
    }

    /**
     * 内径
     * @param bore 内径
     */
    public void setBore(BigDecimal bore) {
        this.bore = bore;
    }

    /**
     * 关联合同id
     * @return CONTRACT_ID 关联合同id
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 关联合同id
     * @param contractId 关联合同id
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 验货单明细ID
     * @return SOURCE_ID 验货单明细ID
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 验货单明细ID
     * @param sourceId 验货单明细ID
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * 创建时间
     * @return CREATE_DATE 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 是否为自由货物
     * @return OWN_CARGO 是否为自由货物
     */
    public String getOwnCargo() {
        return ownCargo;
    }

    /**
     * 是否为自由货物
     * @param ownCargo 是否为自由货物
     */
    public void setOwnCargo(String ownCargo) {
        this.ownCargo = ownCargo == null ? null : ownCargo.trim();
    }
}