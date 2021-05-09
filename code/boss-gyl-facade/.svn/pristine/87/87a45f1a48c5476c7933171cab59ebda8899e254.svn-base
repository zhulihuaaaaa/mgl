package com.maigangle.gyl.facade.entity.vo;

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
public class InvInventoryVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8792238789004626810L;
	 /**
     * 净重
     */
    private BigDecimal netWeight;

    /**
     * 数量（张/卷）
     */
    private BigDecimal quantity;

	 /**
     * 均重
     */
    private BigDecimal counterpoise;
    /**
     * 可以允许操作的操作的数量
     */
    private BigDecimal enableNum;
    
    /**
     * id
     */
    private String inventoryId;
    /**
     * 合同金额
     */
    private BigDecimal contractMoney;
    
    /**
     * 合同单价（元/kg）
     */
    private BigDecimal contractUnitPrice;

    /**
     * 待解锁数量
     */
    private BigDecimal nextUnlockQuantity;

    /**
     * 待出库数量
     */
    private BigDecimal nextOutstockQuantity;
    
    
    
    
    public BigDecimal getNextUnlockQuantity() {
		return nextUnlockQuantity;
	}

	public void setNextUnlockQuantity(BigDecimal nextUnlockQuantity) {
		this.nextUnlockQuantity = nextUnlockQuantity;
	}

	public BigDecimal getNextOutstockQuantity() {
		return nextOutstockQuantity;
	}

	public void setNextOutstockQuantity(BigDecimal nextOutstockQuantity) {
		this.nextOutstockQuantity = nextOutstockQuantity;
	}

	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCounterpoise() {
		// 计算出均重
		BigDecimal quantity=getQuantity();
		BigDecimal netWeight=getNetWeight();
		if(quantity ==null ||netWeight ==null ||quantity.compareTo(BigDecimal.ZERO)==0||netWeight.compareTo(BigDecimal.ZERO)==0) {
			return BigDecimal.ZERO;
		}
		return netWeight.divide(quantity, 3, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setCounterpoise(BigDecimal counterpoise) {
		this.counterpoise = counterpoise;
	}



	public void setEnableNum(BigDecimal enableNum) {
		this.enableNum = enableNum;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}

	public BigDecimal getContractUnitPrice() {
		return contractUnitPrice;
	}

	public void setContractUnitPrice(BigDecimal contractUnitPrice) {
		this.contractUnitPrice = contractUnitPrice;
	}

	public BigDecimal getEnableNum() {
		BigDecimal nextOutstockQuantity = BigDecimal.ZERO;
		BigDecimal nextUnlockQuantity = BigDecimal.ZERO;
		BigDecimal quantity = BigDecimal.ZERO;
		if(getQuantity() !=null){
			quantity = getQuantity();
		}
		if(getNextOutstockQuantity() !=null){
			nextOutstockQuantity = getNextOutstockQuantity();
		}
		if(getNextUnlockQuantity() !=null){
			nextUnlockQuantity = getNextUnlockQuantity();
		}
		enableNum = quantity.subtract(nextUnlockQuantity).subtract(nextOutstockQuantity);
		return enableNum;
	}
}
