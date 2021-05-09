package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;

import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;

/**  
 * 赎货货物明细dto
 * 是否精确查询
 * @author zlh
 * @since 2017年12月1日 下午3:53:43 
 * @version 1.0 
 */
public class RedRedeemDetailDto extends RedRedeemDetail implements Serializable{
	
	private static final long serialVersionUID = -3581749070402254066L;
	

	private BaseProduct baseProduct;
	private DictMallMnfct dictMallMnfct;
	private DictMallDepot dictMallDepot;
	public BaseProduct getBaseProduct() {
		return baseProduct;
	}
	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}
	public DictMallMnfct getDictMallMnfct() {
		return dictMallMnfct;
	}
	public void setDictMallMnfct(DictMallMnfct dictMallMnfct) {
		this.dictMallMnfct = dictMallMnfct;
	}
	public DictMallDepot getDictMallDepot() {
		return dictMallDepot;
	}
	public void setDictMallDepot(DictMallDepot dictMallDepot) {
		this.dictMallDepot = dictMallDepot;
	}

	
	
}