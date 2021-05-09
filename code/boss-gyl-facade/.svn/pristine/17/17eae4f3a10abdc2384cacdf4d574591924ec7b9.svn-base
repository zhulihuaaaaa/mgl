package com.maigangle.gyl.facade.enums;

public enum FinanceStateEnum {
	WEI_WAN_CHENG("N", "未完成"),
	YI_WAN_CHENG("Y", "已完成");
	
	private String state;
	
	private String name;
	
	private FinanceStateEnum(String state, String name) {
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
	
	/**
	 * 根据Key找value
	 * @param key
	 * @return
	 */
	public static String getValueByKey(String key) {  
		FinanceStateEnum[] enums = FinanceStateEnum.values();  
        for (int i = 0; i < enums.length; i++) {  
            if (enums[i].getState().equals(key)) {  
                return enums[i].getName();  
            }  
        }  
        return "";  
    }
}
