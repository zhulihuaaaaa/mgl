package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OutOutstockDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3800773739284170764L;

	/**
     * id
     */
    private String outstockDetailId;

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
     * 入库日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date storageDate;

    /**
     * 存放仓库
     */
    private String storageId;

    /**
     * 品名
     */
    private String productId;

    /**
     * 材质（钢种）
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
     * 内径
     */
    private BigDecimal bore;

    /**
     * 待解锁数量
     */
    private BigDecimal nextUnlockQuantity;

    /**
     * 待出库数量
     */
    private BigDecimal nextOutstockQuantity;

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
    private String goodsVolume;

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
     * 服务费用
     */
    private BigDecimal serviceFee;

    /**
     * 发票费用
     */
    private BigDecimal invoiceFee;

    /**
     * 其他费用
     */
    private BigDecimal otherFee;

    /**
     * 赎货金额
     */
    private BigDecimal redeemMoney;

    /**
     * 备注
     */
    private String notes;

    /**
     * N:否 Y:是
     */
    private String isDel;

    /**
     * 提货单主单id
     */
    private String outstockBillId;

    /**
     * 库存id
     */
    private String inventoryId;

    /**
     * 合同id
     */
    private String contractId;

    /**
     * 赎货详情单id
     */
    private String redeemDetailId;

    /**
     * id
     * @return OUTSTOCK_DETAIL_ID id
     */
    public String getOutstockDetailId() {
        return outstockDetailId;
    }

    /**
     * id
     * @param outstockDetailId id
     */
    public void setOutstockDetailId(String outstockDetailId) {
        this.outstockDetailId = outstockDetailId == null ? null : outstockDetailId.trim();
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
     * 入库日期
     * @return STORAGE_DATE 入库日期
     */
    public Date getStorageDate() {
        return storageDate;
    }

    /**
     * 入库日期
     * @param storageDate 入库日期
     */
    public void setStorageDate(Date storageDate) {
        this.storageDate = storageDate;
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
     * 材质（钢种）
     * @return MATERIAL_ID 材质（钢种）
     */
    public String getMaterialId() {
        return materialId;
    }

    /**
     * 材质（钢种）
     * @param materialId 材质（钢种）
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
     * @return GOODS_VOLUME 卷号
     */
    public String getGoodsVolume() {
        return goodsVolume;
    }

    /**
     * 卷号
     * @param goodsVolume 卷号
     */
    public void setGoodsVolume(String goodsVolume) {
        this.goodsVolume = goodsVolume == null ? null : goodsVolume.trim();
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
     * @return AMOUNT 数量（张/卷）
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 数量（张/卷）
     * @param amount 数量（张/卷）
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * 服务费用
     * @return SERVICE_FEE 服务费用
     */
    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    /**
     * 服务费用
     * @param serviceFee 服务费用
     */
    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    /**
     * 发票费用
     * @return INVOICE_FEE 发票费用
     */
    public BigDecimal getInvoiceFee() {
        return invoiceFee;
    }

    /**
     * 发票费用
     * @param invoiceFee 发票费用
     */
    public void setInvoiceFee(BigDecimal invoiceFee) {
        this.invoiceFee = invoiceFee;
    }

    /**
     * 其他费用
     * @return OTHER_FEE 其他费用
     */
    public BigDecimal getOtherFee() {
        return otherFee;
    }

    /**
     * 其他费用
     * @param otherFee 其他费用
     */
    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    /**
     * 赎货金额
     * @return REDEEM_MONEY 赎货金额
     */
    public BigDecimal getRedeemMoney() {
        return redeemMoney;
    }

    /**
     * 赎货金额
     * @param redeemMoney 赎货金额
     */
    public void setRedeemMoney(BigDecimal redeemMoney) {
        this.redeemMoney = redeemMoney;
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
     * 提货单主单id
     * @return OUTSTOCK_BILL_ID 提货单主单id
     */
    public String getOutstockBillId() {
        return outstockBillId;
    }

    /**
     * 提货单主单id
     * @param outstockBillId 提货单主单id
     */
    public void setOutstockBillId(String outstockBillId) {
        this.outstockBillId = outstockBillId == null ? null : outstockBillId.trim();
    }

    /**
     * 库存id
     * @return INVENTORY_ID 库存id
     */
    public String getInventoryId() {
        return inventoryId;
    }

    /**
     * 库存id
     * @param inventoryId 库存id
     */
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId == null ? null : inventoryId.trim();
    }

    /**
     * 合同id
     * @return CONTRACT_ID 合同id
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 合同id
     * @param contractId 合同id
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    /**
     * 赎货详情单id
     * @return REDEEM_DETAIL_ID 赎货详情单id
     */
    public String getRedeemDetailId() {
        return redeemDetailId;
    }

    /**
     * 赎货详情单id
     * @param redeemDetailId 赎货详情单id
     */
    public void setRedeemDetailId(String redeemDetailId) {
        this.redeemDetailId = redeemDetailId == null ? null : redeemDetailId.trim();
    }
}