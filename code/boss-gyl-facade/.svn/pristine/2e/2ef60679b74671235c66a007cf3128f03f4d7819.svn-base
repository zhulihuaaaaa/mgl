package com.maigangle.gyl.facade.enums;
/**
 * 
 * 
 * @author zlh
 * @since 2018年2月27日 下午1:34:48 
 * @version 1.0
 */
public enum BalanceTypeEnum {
	/**
	 * 未退款
	 */
	NOT_REFUND("A", "未退款"),
	/**
	 * 退款中
	 */
	IN_REFUND("B", "退款中"),
	/**
	 * 已退款
	 */
	END_REFUND("C", "已退款");
	
	private String state;
	
	private String name;
	
	private BalanceTypeEnum(String state, String name) {
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

	public static String getValueByKey(String key) {
		BalanceTypeEnum[] enums = BalanceTypeEnum.values();  
        for (int i = 0; i < enums.length; i++) {  
            if (enums[i].getState().equals(key)) {  
                return enums[i].getName();  
            }  
        }  
        return "";  
	}
}
