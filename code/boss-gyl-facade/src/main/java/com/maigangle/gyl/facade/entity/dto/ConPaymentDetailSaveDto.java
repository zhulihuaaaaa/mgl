package com.maigangle.gyl.facade.entity.dto;

import com.maigangle.gyl.facade.entity.ConPaymentDetail;

public class ConPaymentDetailSaveDto extends ConPaymentDetail{
	
	private static final long serialVersionUID = 7155315507178755126L;
	
	private String contractCode;

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	
}
