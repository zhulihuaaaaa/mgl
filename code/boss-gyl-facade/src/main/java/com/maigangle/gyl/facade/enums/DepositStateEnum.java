package com.maigangle.gyl.facade.enums;
/**
 * 保证金状态枚举
 * @author zlh
 * @since 2017年11月30日 上午10:26:01
 * @version 1.0
 */
public enum DepositStateEnum {
	/**
	 * 未到账
	 */
	WEI_DAO_ZHANG("A", "未到账"),
	/**
	 * 已到账
	 */
	YI_DAO_ZHANG("B", "已到账");
	
	private String state;
	
	private String name;
	
	private DepositStateEnum(String state, String name) {
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
