package com.maigangle.gyl.facade.enums;
/**
 * 是/否枚举类
 * @author 张渊
 * @since 2017年12月5日 上午10:40:55
 * @version 1.0
 */
public enum YesOrNoEnum {
	YES("Y"),
	NO("N");
	
	private String code;
	
	private YesOrNoEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code;
	}
}
