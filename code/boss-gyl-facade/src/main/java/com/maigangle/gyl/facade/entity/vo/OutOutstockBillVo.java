package com.maigangle.gyl.facade.entity.vo;

import com.maigangle.gyl.facade.entity.OutOutstockBill;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;

public class OutOutstockBillVo extends OutOutstockBill {

	private static final long serialVersionUID = -578409728485568646L;
	
	/**
	 * 客户信息
	 */
	private CrmClient customer;
	
	/**
	 * 存放仓库
	 */
	private DictMallDepot storage;
	
	/**
	 * 客户信息
	 */
	private CrmClient consigneeInfo;

	public CrmClient getCustomer() {
		return customer;
	}

	public void setCustomer(CrmClient customer) {
		this.customer = customer;
	}

	public DictMallDepot getStorage() {
		return storage;
	}

	public void setStorage(DictMallDepot storage) {
		this.storage = storage;
	}

	public CrmClient getConsigneeInfo() {
		return consigneeInfo;
	}

	public void setConsigneeInfo(CrmClient consigneeInfo) {
		this.consigneeInfo = consigneeInfo;
	}
	
}
