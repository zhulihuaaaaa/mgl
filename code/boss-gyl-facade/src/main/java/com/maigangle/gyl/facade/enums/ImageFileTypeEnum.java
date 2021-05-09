package com.maigangle.gyl.facade.enums;
/**
 * 
 * @author 杨思静
 * @since  2017年12月11日 - 上午10:39:31
 * @version 1.0
 */
public enum ImageFileTypeEnum {
	HE_TONG_YUAN_JIAN("A","合同原件"),
	ZHI_BAO_SHU("B","质保书"),
	CUN_HUO_PING_ZHENG("C","存货凭证"),
	HUO_WU_ZHAO_PIAN("D","货物照片");
	private String type;
	private String name;
	private ImageFileTypeEnum(String type, String name) {
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
		// TODO Auto-generated method stub
		return this.type;
	}

}
