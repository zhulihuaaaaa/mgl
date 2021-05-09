package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseProductDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7287498742675224442L;

	/**
     * id
     */
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 数量单位
     */
    private String quantityUnit;

    /**
     * 重量单位
     */
    private String weightUnit;

    /**
     * 精确度
     */
    private BigDecimal precision;

    /**
     * 单位进率
     */
    private BigDecimal unitRate;

    /**
     * 状态
     */
    private String status;

    /**
     *  创建人
     */
    private String createUser;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
    private Date startCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
    private Date endCreateDate;

    /**
     * 是否删除(Y:是，N:否)
     */
    private String isDel;

    /**
     * id
     * @return PRODUCT_ID id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * id
     * @param productId id
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * 产品名称
     * @return PRODUCT_NAME 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 数量单位
     * @return QUANTITY_UNIT 数量单位
     */
    public String getQuantityUnit() {
        return quantityUnit;
    }

    /**
     * 数量单位
     * @param quantityUnit 数量单位
     */
    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit == null ? null : quantityUnit.trim();
    }

    /**
     * 重量单位
     * @return WEIGHT_UNIT 重量单位
     */
    public String getWeightUnit() {
        return weightUnit;
    }

    /**
     * 重量单位
     * @param weightUnit 重量单位
     */
    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit == null ? null : weightUnit.trim();
    }

    /**
     * 精确度
     * @return PRECISION 精确度
     */
    public BigDecimal getPrecision() {
        return precision;
    }

    /**
     * 精确度
     * @param precision 精确度
     */
    public void setPrecision(BigDecimal precision) {
        this.precision = precision;
    }

    /**
     * 单位进率
     * @return UNIT_RATE 单位进率
     */
    public BigDecimal getUnitRate() {
        return unitRate;
    }

    /**
     * 单位进率
     * @param unitRate 单位进率
     */
    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
    }

    /**
     * 状态
     * @return STATUS 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     *  创建人
     * @return CREATE_USER  创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     *  创建人
     * @param createUser  创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 创建日期
     * @return CREATE_DATE 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

	/**
     * 是否删除(Y:是，N:否)
     * @return IS_DEL 是否删除(Y:是，N:否)
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 是否删除(Y:是，N:否)
     * @param isDel 是否删除(Y:是，N:否)
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
}