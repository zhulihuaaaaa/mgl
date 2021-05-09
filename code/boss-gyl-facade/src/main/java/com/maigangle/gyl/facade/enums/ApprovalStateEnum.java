package com.maigangle.gyl.facade.enums;
/**
 * 审批状态枚举
 * @author 张渊
 * @since 2017年11月30日 上午10:26:01
 * @version 1.0
 */
public enum ApprovalStateEnum {
	/**
	 * 未审批
	 */
	APPROVAL_NOT("A", "未审批"),
	/**
	 * 审批中
	 */
	APPROVAL_UNDERWAY("B", "审批中"),
	/**
	 * 已拒绝
	 */
	APPROVAL_SUSPEND("C", "已拒绝"),
	/**
	 * 已通过
	 */
	APPROVAL_COMPLETE("D", "已通过"),
	/**
	 * 已作废
	 */
	APPROVAL_CANCEL("E", "已作废"),
	/**
	 * 撤销审批
	 */
	ABANDON_APPROVAL("F", "撤销审批");
//	/**
//	 * 撤销拒绝
//	 */
//	ABANDON_REJECT("G", "撤销拒绝");
	
	private String state;
	
	private String name;
	
	private ApprovalStateEnum(String state, String name) {
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
	 * 根据状态获取对应枚举类
	 * @param state
	 * @return
	 */
	public static ApprovalStateEnum getEnum (String state) {
		for (ApprovalStateEnum stateEnum: ApprovalStateEnum.values()) {
			if (stateEnum.getState().equals(state)) {
				return stateEnum;
			}
		}
		return null;
	}
}
