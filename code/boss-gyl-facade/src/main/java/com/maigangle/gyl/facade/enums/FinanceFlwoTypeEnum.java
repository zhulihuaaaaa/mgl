package com.maigangle.gyl.facade.enums;

public enum FinanceFlwoTypeEnum {
	
	JIN_ZHANG("A", "进账"),
	CHU_ZHANG("B", "出账");

	private String type;
	private String name;
	
	private FinanceFlwoTypeEnum(String type, String name) {
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
		FinanceFlwoTypeEnum[] enums = FinanceFlwoTypeEnum.values();  
        for (int i = 0; i < enums.length; i++) {  
            if (enums[i].getType().equals(key)) {  
                return enums[i].getName();  
            }  
        }  
        return "";  
    }
}
