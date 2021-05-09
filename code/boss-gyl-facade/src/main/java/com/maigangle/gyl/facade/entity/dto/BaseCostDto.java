package com.maigangle.gyl.facade.entity.dto;

import com.maigangle.gyl.facade.entity.BaseCost;

public class BaseCostDto extends BaseCost {

	private static final long serialVersionUID = -6348842136073343289L;
	
	private String clientId;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
}
