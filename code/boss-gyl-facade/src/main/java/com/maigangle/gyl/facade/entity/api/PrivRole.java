package com.maigangle.gyl.facade.entity.api;

import java.io.Serializable;

/**
 * 角色表
 * 
 * @author 朱晗
 * @since 2016年11月24日 下午2:43:58
 * @version 1.0
 *
 */
public class PrivRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3170771998444752139L;
	
	/**
	 * 角色id
	 */
	private String roleId;
	
	/**
	 * 角色英文简写
	 */
	private String roleCode;
	
	/**
	 * 角色名
	 */
	private String roleName;
	
	/**
	 * 备注
	 */
	private String notes;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode == null ? null : roleCode.trim();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes == null ? null : notes.trim();
	}
}