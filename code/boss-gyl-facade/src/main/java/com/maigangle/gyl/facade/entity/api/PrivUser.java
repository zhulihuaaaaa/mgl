package com.maigangle.gyl.facade.entity.api;

import java.io.Serializable;

/**
 * 用户信息表
 * 
 * @author 朱晗
 * @since 2016年11月24日 下午2:45:10
 * @version 1.0
 *
 */
public class PrivUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 是否有效
	 */
	private String userStatus;
	
	/**
	 * 备注
	 */
	private String notes;
	/**
	 * 角色信息
	 */
	private PrivRole privRole;
	
	public PrivRole getPrivRole() {
		return privRole;
	}

	public void setPrivRole(PrivRole privRole) {
		this.privRole = privRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}