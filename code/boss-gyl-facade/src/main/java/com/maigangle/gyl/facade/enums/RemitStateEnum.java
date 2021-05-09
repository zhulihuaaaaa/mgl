package com.maigangle.gyl.facade.enums;

public enum RemitStateEnum {
	YI_BAO_CUN("A","已保存"),
	YI_SHEN_PI("B","已审批"),
	YI_DAO_ZHANG("C","已到账");
	
	private String type;
	
	private String name;
	
	private RemitStateEnum(String type, String name) {
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
