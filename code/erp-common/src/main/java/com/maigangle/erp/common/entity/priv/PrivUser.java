package com.maigangle.erp.common.entity.priv;

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

	private String userId;

	//@NotBlank(message = "登录名不能为空")
	private String loginName;

	//@NotBlank(message = "密码不能为空")
	private String loginPasswd;

	private String userName;

	private String mobile;

	private String userStatus;

	private String notes;

	private String smsCheck;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getLoginPasswd() {
		return loginPasswd;
	}

	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd == null ? null : loginPasswd.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus == null ? null : userStatus.trim();
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes == null ? null : notes.trim();
	}

	public String getSmsCheck() {
		return smsCheck;
	}

	public void setSmsCheck(String smsCheck) {
		this.smsCheck = smsCheck == null ? null : smsCheck.trim();
	}

}