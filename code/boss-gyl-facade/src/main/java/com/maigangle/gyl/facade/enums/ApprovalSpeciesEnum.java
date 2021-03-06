package com.maigangle.gyl.facade.enums;
/**
 * 审批模块名
 * @author 杨思静
 * @since  2018年2月4日 - 下午4:40:23
 * @version 1.1
 */
public enum ApprovalSpeciesEnum {
	CONTRACT("contract","合同"),
	OUTSTOCK("outstock","提货");
	
	private String model;
	
	private String name;
	
	private ApprovalSpeciesEnum(String model, String name) {
		this.model = model;
		this.name = name;
	}

	
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.model;
	}
	/**
	 * 根据状态获取对应枚举类
	 * @param state
	 * @return
	 */
	public static ApprovalSpeciesEnum getEnum (String model) {
		for (ApprovalSpeciesEnum speciesEnum: ApprovalSpeciesEnum.values()) {
			if (speciesEnum.getModel().equals(model)) {
				return speciesEnum;
			}
		}
		return null;
	}
}
