package com.maigangle.gyl.facade.enums;
/**
 * 发票类型
 * @author 杨思静
 * @since  2018年2月26日 - 上午9:45:41
 * @version 1.1
 */
public enum InvoiceTypeEnum {
	/**
	 * 进项
	 */
	IN_INVOICE("A", "进项"),
	/**
	 * 销项
	 */
	OUT_INVOICE("B", "销项");
	
	private String state;
	
	private String name;
	
	private InvoiceTypeEnum(String state, String name) {
		this.state = state;
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.state;
	}
}
