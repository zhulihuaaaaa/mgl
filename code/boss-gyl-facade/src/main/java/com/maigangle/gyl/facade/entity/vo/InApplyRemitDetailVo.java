package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.maigangle.gyl.facade.entity.InApplyRemitDetail;
import com.maigangle.gyl.facade.entity.InInstockBill;

/**  
 * 打款申请Vo
 * @author zlh
 * @since 2017年12月26日 下午2:26:15 
 * @version 1.0 
 */
public class InApplyRemitDetailVo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1919271091258458181L;

	/**
	 * 入库单
	 */
	private InInstockBill bill;
	/**
	 * 确认人
	 */
	private String checkMan;
	
	/**
	 * InApplyRemitDetail
	 */
	private InApplyRemitDetail detail;

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public InApplyRemitDetail getDetail() {
		return detail;
	}

	public void setDetail(InApplyRemitDetail detail) {
		this.detail = detail;
	}

	public InInstockBill getBill() {
		return bill;
	}

	public void setBill(InInstockBill bill) {
		this.bill = bill;
	}
}