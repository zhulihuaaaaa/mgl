package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 发票筛选条件Dto
 * @author zlh
 * @since  2018年2月6日 - 上午9:07:03
 * @version 1.0
 */
public class InvoiceGoodsConditionDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8728999477233930759L;
	
	/**
	 * 客户
	 */
	private String buyerId;
	
	/**
     * 开始结束日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date endDate;
	
	/**
     * 品名
     */
	private String productId;
	/**
     * 厂家
     */
	private String mnfctId;
	/**
     * 仓库
     */
	private String storageId;
	/**
	 * 材质
	 */
	private String meterialId;
	/**
	 * 卷号
	 */
	private String goodsVolume;
	/**
	 * 表面
	 */
	private String surfaceId;
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getMeterialId() {
		return meterialId;
	}
	public void setMeterialId(String meterialId) {
		this.meterialId = meterialId;
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
	public String getStorageId() {
		return storageId;
	}
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public String getGoodsVolume() {
		return goodsVolume;
	}
	public void setGoodsVolume(String goodsVolume) {
		this.goodsVolume = goodsVolume;
	}
	
}
