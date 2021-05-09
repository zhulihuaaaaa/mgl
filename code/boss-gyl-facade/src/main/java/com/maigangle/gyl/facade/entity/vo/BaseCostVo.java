package com.maigangle.gyl.facade.entity.vo;

import com.maigangle.gyl.facade.entity.BaseCost;
import com.maigangle.gyl.facade.entity.api.CrmClient;

public class BaseCostVo extends BaseCost {

	private static final long serialVersionUID = 902003562896739707L;
	
	private CrmClient crmClient;

	public CrmClient getCrmClient() {
		return crmClient;
	}

	public void setCrmClient(CrmClient crmClient) {
		this.crmClient = crmClient;
	}
	
}
