package com.maigangle.gyl.facade.enums;
/**
 * 业务类型枚举
 * @author 张渊
 * @since 2017年11月28日 上午11:58:07
 * @version 1.0
 */
public enum BusinessTypeEnum {
	
	HUO_YA_RONG_ZI("H", "货押融资"),
	DING_XIANG_XIAO_SHOU("C", "定向销售"),
	CAI_GOU_ZI_XIAO("X", "采购自销"),
	CANG_DAN_ZHI_YA("D", "仓单质押");
//	SHANG_CHENG_RONG_ZI("E", "商城融资"),
//	DING_DAN_JIAO_SHOU("F", "订单交收");
	
	private String type;
	
	private String name;
	
	private BusinessTypeEnum(String type, String name) {
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
		BusinessTypeEnum[] enums = BusinessTypeEnum.values();  
        for (int i = 0; i < enums.length; i++) {  
            if (enums[i].getType().equals(key)) {  
                return enums[i].getName();  
            }  
        }  
        return "";  
    }  
}
