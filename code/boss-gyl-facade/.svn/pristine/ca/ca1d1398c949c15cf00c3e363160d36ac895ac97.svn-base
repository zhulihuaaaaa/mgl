package com.maigangle.gyl.facade.enums;
/**
 * 货款打款状态枚举
 * @author zlh
 * @since 2017年11月30日 上午10:26:01
 * @version 1.0
 */
public enum GoodsPaymentStatusEnum {
	/**
	 * 未打款
	 */
	WEI_DA_KUAN("A", "未打款"),
	/**
	 * 部分货款
	 */
	BU_FEN_HUO_KUAN("B", "部分货款"),
	/**
	 * 全部货款
	 */
	QUAN_BU_HUO_KUAN("C", "全部货款");
	
	private String state;
	
	private String name;
	
	private GoodsPaymentStatusEnum(String state, String name) {
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
