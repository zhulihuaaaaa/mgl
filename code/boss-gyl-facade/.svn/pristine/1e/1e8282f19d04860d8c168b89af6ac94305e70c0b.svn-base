package com.maigangle.gyl.facade.enums;

/**
 * 合同类型枚举类
 * @author 汪玮琦
 * @since 2017年12月15日 下午9:30:47
 * @varsion 1.0
 */
public enum ContractBillTypeEnum {
	
	DING_XIANG_XIAO_SHOU("C", "定向销售"),
	HUO_YA_RONG_ZI("H", "货押融资"),
	CAI_GOU_ZI_XIAO("X", "采购自销"),
	CANG_DAN_ZHI_YA("D", "仓单质押");
	
	private String type;
	
	private String name;
	
	private ContractBillTypeEnum(String type, String name) {
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

	/**
	 * 根据Key找value
	 * @param key
	 * @return
	 */
	public static String getValueByKey(String key) {  
		ContractBillTypeEnum[] enums = ContractBillTypeEnum.values();  
        for (int i = 0; i < enums.length; i++) {  
            if (enums[i].getType().equals(key)) {  
                return enums[i].getName();  
            }  
        }  
        return "";  
    }  
}
