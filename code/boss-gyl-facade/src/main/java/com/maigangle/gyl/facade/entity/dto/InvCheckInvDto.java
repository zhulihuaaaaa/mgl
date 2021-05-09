package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.util.Date;

import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.InvInventory;

/**  
 * 盘点Dto
 * 是否精确查询
 * @version 1.0 
 */
public class InvCheckInvDto extends InvInventory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3610560686756951536L;
	/**
     * 创建日期
     */
    private Date startCreateDate;
    private Date endCreateDate;
    
    /**
     * 仓库名字
     */
    private String storageName;
    
    private BaseProduct baseProduct;
    
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
	public String getStorageName() {
		return storageName;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	public BaseProduct getBaseProduct() {
		return baseProduct;
	}
	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}
  
}