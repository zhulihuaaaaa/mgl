package com.maigangle.gyl.facade.entity.vo;

import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.FeeBalanceDetail;
import com.maigangle.gyl.facade.entity.FeeDepositDetail;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.OutOutstockDetail;

public class FeeBalanceDetailVo extends FeeBalanceDetail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8492436832526559930L;
	
	private FeeBalanceDetail feeBalanceDetail;

	public FeeBalanceDetail getFeeBalanceDetail() {
		return feeBalanceDetail;
	}

	public void setFeeBalanceDetail(FeeBalanceDetail feeBalanceDetail) {
		this.feeBalanceDetail = feeBalanceDetail;
	}
	
	
	
}
