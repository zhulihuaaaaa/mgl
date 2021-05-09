package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.util.List;

import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.OutOutstockBill;
import com.maigangle.gyl.facade.entity.OutOutstockDetail;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;

public class OutOutstockDetailVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7168899123360272920L;
	
	/**
	 * bill
	 */
	private OutOutstockBill bill;
	
	/**
	 * entity
	 */
	private OutOutstockBill entity;
	
	/**
	 * detail
	 */
	private List<InvInventoryDto> detail;
	
	/**
	 * 仓库名
	 */
	private String storageName;
	
	/**
	 * 品名
	 */
	private String productName;
	
    /**
     * 品名信息
     */
    private BaseProduct baseProduct;
	
	/**
	 * 材质钢种
	 */
	private String materialName;
	
	/**
	 * 表面
	 */
	private String surfaceName;
	
	/**
	 * 制造商
	 */
	private String mnfctName;
	
	private OutOutstockDetail outOutstockDetail;

	public OutOutstockBill getBill() {
		return bill;
	}

	public void setBill(OutOutstockBill bill) {
		this.bill = bill;
	}

	public OutOutstockBill getEntity() {
		return entity;
	}

	public void setEntity(OutOutstockBill entity) {
		this.entity = entity;
	}

	public List<InvInventoryDto> getDetail() {
		return detail;
	}

	public void setDetail(List<InvInventoryDto> detail) {
		this.detail = detail;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
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

	public String getMnfctName() {
		return mnfctName;
	}

	public void setMnfctName(String mnfctName) {
		this.mnfctName = mnfctName;
	}

	public OutOutstockDetail getOutOutstockDetail() {
		return outOutstockDetail;
	}

	public void setOutOutstockDetail(OutOutstockDetail outOutstockDetail) {
		this.outOutstockDetail = outOutstockDetail;
	}

	public BaseProduct getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}
	
	
}
