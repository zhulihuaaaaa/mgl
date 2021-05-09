package com.maigangle.gyl.facade.enums;
/**
 * 入库单状态
 * @author 张渊
 * @since 2017年11月30日 上午10:56:51
 * @version 1.0
 */
public enum InStockBillStateEnum {
	/**
	 * 进行中
	 */
	UNDERWAY("A", "进行中"),
	/**
	 * 已完成
	 */
	COMPLETE("B", "已完成"),
	/**
	 * 已作废
	 */
	SUSPEND("C", "已作废");
	
	private String state;
	
	private String name;
	
	private InStockBillStateEnum(String state, String name) {
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
