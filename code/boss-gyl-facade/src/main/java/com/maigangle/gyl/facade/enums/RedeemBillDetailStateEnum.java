package com.maigangle.gyl.facade.enums;
/**
 * 赎货明细状态枚举
 * @author zlh
 * @since 2018年1月2日 上午9:21:30
 * @version 1.0
 */
public enum RedeemBillDetailStateEnum {
	WEI_CHU_KU("A", "未出库"),
	
	YI_CHU_KU("B", "已出库");
	
	private String type;
	
	private String name;
	
	private RedeemBillDetailStateEnum(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
