package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;

public class ConContractSelectVo implements Serializable{

	private static final long serialVersionUID = 8917940230353628151L;
	
	/**
     * id
     */
    private String contractId;
    
    /**
     * 合同编号
     */
    private String contractNo;
    
    /**
     * 合同单号
     */
    private String contractCode;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
    
}
