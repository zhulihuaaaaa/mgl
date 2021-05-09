package com.maigangle.gyl.facade.enums;

public enum FinanceTypeEnum {

	LV_YUE_BAO_ZHENG_JIN("A", "履约保证金"),
	ZHUI_JIA_BAO_ZHENG_JIN("B", "追加保证金"),
	ZHUI_JIA_HUO_KUAN("C", "追加货款"),
	GOU_HUO_KUAN("D", "购货款"),
	SHU_HUO_KUAN("E", "赎货款"),
	TUI_KUAN("F", "退款");
	
	
	
	
	private String type;
	private String name;
	
	private FinanceTypeEnum(String type, String name) {
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
	
	/**
	 * 根据Key找value
	 * @param key
	 * @return
	 */
	public static String getValueByKey(String key) {  
		FinanceTypeEnum[] enums = FinanceTypeEnum.values();  
        for (int i = 0; i < enums.length; i++) {  
            if (enums[i].getType().equals(key)) {  
                return enums[i].getName();  
            }  
        }  
        return "";  
    }
}
