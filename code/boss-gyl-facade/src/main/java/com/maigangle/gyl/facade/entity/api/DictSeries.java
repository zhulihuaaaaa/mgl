package com.maigangle.gyl.facade.entity.api;

import java.io.Serializable;

/**
 * 系列（品种）
 * @author 张渊
 * @since 2018年2月2日 上午8:41:44
 * @version 1.0
 */
public class DictSeries implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4453951804084368157L;
	private String orderCode;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
}
