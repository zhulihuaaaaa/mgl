package com.maigangle.gyl.facade.entity.vo;

import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.RedRedeemBill;

public class FeeFinanceBillVo extends FeeFinanceBill {
	
	private static final long serialVersionUID = 2499598641839850140L;
	
	private ConContract contract;
	
	private RedRedeemBill redeem;
	
	private String businessTypeName;

	public ConContract getContract() {
		return contract;
	}

	public void setContract(ConContract contract) {
		this.contract = contract;
	}

	public RedRedeemBill getRedeem() {
		return redeem;
	}

	public void setRedeem(RedRedeemBill redeem) {
		this.redeem = redeem;
	}

	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}
	
	
}
