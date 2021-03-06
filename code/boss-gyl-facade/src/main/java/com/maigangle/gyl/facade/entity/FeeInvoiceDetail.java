package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class FeeInvoiceDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3739775408953463708L;

	/**
     * id
     */
    private String invoiceDetailId;

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
    private BigDecimal quantity;

    /**
     * 计算方式
     */
    private String calcMethod;

    /**
     * 等级
     */
    private String grade;

    /**
     * 执行标准
     */
    private String implStd;

    /**
     * 合同单价（元/kg）
     */
    private BigDecimal contractUnitPrice;

    /**
     * 实际单价（元/kg）
     */
    private BigDecimal realUnitPrice;

    /**
     * 发票单价
     */
    private BigDecimal invoicePrice;

    /**
     * 合同金额
     */
    private BigDecimal contractMoney;

    /**
     * 实际金额
     */
    private BigDecimal realMoney;

    /**
     * 发票总额
     */
    private BigDecimal invoiceMoney;

    /**
     * 关联合同id
     */
    private String contractId;

    /**
     * 手续费
     */
    private BigDecimal commissionFee;

    /**
     * 开票费
     */
    private BigDecimal invoiceFee;

    /**
     * 赎货金额
     */
    private BigDecimal redeemMoney;

    /**
     * 备注
     */
    private String notes;

    /**
     * N:false, Y:true
     */
    private String isDel;

    /**
     * 关联主表ID
     */
    private String invoiceId;

    /**
     * 关联id
     */
    private String relatedId;

    /**
     * 数量（张/卷）
     */
    private BigDecimal amount;

    /**
     * id
     * @return INVOICE_DETAIL_ID id
     */
    public String getInvoiceDetailId() {
        return invoiceDetailId;
    }

    /**
     * id
     * @param invoiceDetailId id
     */
    public void setInvoiceDetailId(String invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId == null ? null : invoiceDetailId.trim();
    }

    /**
     * 存放仓库ID
     * @return STORAGE_ID 存放仓库ID
     */
    public String getStorageId() {
        return storageId;
    }

    /**
     * 存放仓库ID
     * @param storageId 存放仓库ID
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
     * 发票单价
     * @return INVOICE_PRICE 发票单价
     */
    public BigDecimal getInvoicePrice() {
        return invoicePrice;
    }

    /**
     * 发票单价
     * @param invoicePrice 发票单价
     */
    public void setInvoicePrice(BigDecimal invoicePrice) {
        this.invoicePrice = invoicePrice;
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
     * 发票总额
     * @return INVOICE_MONEY 发票总额
     */
    public BigDecimal getInvoiceMoney() {
        return invoiceMoney;
    }

    /**
     * 发票总额
     * @param invoiceMoney 发票总额
     */
    public void setInvoiceMoney(BigDecimal invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
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
     * 手续费
     * @return COMMISSION_FEE 手续费
     */
    public BigDecimal getCommissionFee() {
        return commissionFee;
    }

    /**
     * 手续费
     * @param commissionFee 手续费
     */
    public void setCommissionFee(BigDecimal commissionFee) {
        this.commissionFee = commissionFee;
    }

    /**
     * 开票费
     * @return INVOICE_FEE 开票费
     */
    public BigDecimal getInvoiceFee() {
        return invoiceFee;
    }

    /**
     * 开票费
     * @param invoiceFee 开票费
     */
    public void setInvoiceFee(BigDecimal invoiceFee) {
        this.invoiceFee = invoiceFee;
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
     * N:false, Y:true
     * @return IS_DEL N:false, Y:true
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * N:false, Y:true
     * @param isDel N:false, Y:true
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    /**
     * 关联主表ID
     * @return INVOICE_ID 关联主表ID
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * 关联主表ID
     * @param invoiceId 关联主表ID
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId == null ? null : invoiceId.trim();
    }

    /**
     * 关联id
     * @return RELATED_ID 关联id
     */
    public String getRelatedId() {
        return relatedId;
    }

    /**
     * 关联id
     * @param relatedId 关联id
     */
    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId == null ? null : relatedId.trim();
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
}