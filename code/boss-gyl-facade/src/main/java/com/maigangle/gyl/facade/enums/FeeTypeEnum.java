package com.maigangle.gyl.facade.enums;

/**
 * 费用类型
 * @author 汪玮琦
 * @since 2017年11月30日 下午5:56:07
 * @varsion 1.0
 */
public enum FeeTypeEnum {
	
	SHOU_XU_FEI("A", "手续费"),
	KAI_PIAO_FEI("B", "开票费");
	
	private String type;
	private String name;
	
	private FeeTypeEnum(String type, String name) {
		this.type = type;
		this.name= name;
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
