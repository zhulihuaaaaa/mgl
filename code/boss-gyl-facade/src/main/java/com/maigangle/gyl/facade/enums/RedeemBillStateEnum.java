package com.maigangle.gyl.facade.enums;
/**
 * 赎货单状态枚举
 * @author 张渊
 * @since 2018年1月2日 上午9:21:30
 * @version 1.0
 */
public enum RedeemBillStateEnum {
	YI_BAO_CUN("A", "已保存"),
	
	DAI_SHEN_HE("B", "待审核"),
	
	DAI_SHOU_KUN("C", "待收款"),
	
	DAI_CHU_KU("D", "待出库"),
	
	YI_CHU_KU("E", "已出库"),
	
	YI_ZUO_FEI("F", "已作废");
	
	private String type;
	
	private String name;
	
	private RedeemBillStateEnum(String type, String name) {
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
