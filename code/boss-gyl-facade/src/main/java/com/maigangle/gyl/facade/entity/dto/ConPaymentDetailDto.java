package com.maigangle.gyl.facade.entity.dto;

import java.util.Date;

import com.maigangle.gyl.facade.entity.ConPaymentDetail;

public class ConPaymentDetailDto extends ConPaymentDetail {

	private static final long serialVersionUID = -1555749167698273867L;
	
	/**
     * 创建日期
     */
    private Date startCreateDate;
    private Date endCreateDate;
	public Date getStartCreateDate() {
		return startCreateDate;
	}
	public void setStartCreateDate(Date startCreateDate) {
		this.startCreateDate = startCreateDate;
	}
	public Date getEndCreateDate() {
		return endCreateDate;
	}
	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

}
