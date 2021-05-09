package com.maigangle.gyl.facade.enums;
/**
 * 出库状态枚举
 * @author zlh
 * @since 2017年11月30日 上午10:41:41
 * @version 1.0
 */
public enum OutstockStateEnum {
	
	
	/**
	 * 审核中
	 */
	APPROVAL("A", "审核中"),
	/**
	 * 已完成
	 */
	COMPLETE("C", "已完成"),
	/**
	 * 已作废
	 */
	SUSPEND("D", "已作废"),
	/**
	 * 已结束
	 */
	CLOSE("E", "已结束"),
	/**
	 * 已拒绝
	 */
	REJECT("F", "已拒绝"),
	/**
	 *未提交
	 */
	UNCOMMITE("G", "未提交");
	
	
	private String state;
	
	private String name;
	
	private OutstockStateEnum(String state, String name) {
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
		OutstockStateEnum[] enums = OutstockStateEnum.values();  
        for (int i = 0; i < enums.length; i++) {  
            if (enums[i].getState().equals(key)) {  
                return enums[i].getName();  
            }  
        }  
        return "";  
    }
}
