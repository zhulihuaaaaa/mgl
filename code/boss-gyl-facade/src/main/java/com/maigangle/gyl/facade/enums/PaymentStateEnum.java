package com.maigangle.gyl.facade.enums;

public enum PaymentStateEnum {
	
	WEI_DA_KUAN("A", "未打款"),
	QUANBU_DA_KUAN("B", "全部打款"),
	BUFEN_DA_KUAN("C", "部分打款");
	
	
	private String type;
	
	private String name;
	
	private PaymentStateEnum(String type, String name) {
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
