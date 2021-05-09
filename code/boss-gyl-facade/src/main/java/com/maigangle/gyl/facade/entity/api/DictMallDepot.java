package com.maigangle.gyl.facade.entity.api;

import java.io.Serializable;

/**
 * 临时仓库标准数据
 * 
 * @author 朱晗
 * @since 2017年3月23日 下午3:21:59
 * @version 1.0
 *
 */
public class DictMallDepot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 904144760594683499L;

	/**
	 * 仓库id
	 */
	private String dptId;

	/**
	 * 仓库全称
	 */
	private String dptName;

	/**
	 * 仓库简称
	 */
	private String dptShortName;

	/**
	 * 仓库联系人
	 */
	private String contact;
	
	/**
	 * 座机
	 */
	private String fixedPhone;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 传值
	 */
	private String fax;
	
	/**
	 * 仓库地址
	 */
	private String address;

	
	/**
	 * 仓库是否有效
	 */
	private String isValid;
	
	/**
	 * 备注
	 */
	private String notes;

	public String getDptId() {
		return dptId;
	}

	public void setDptId(String dptId) {
		this.dptId = dptId;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public String getDptShortName() {
		return dptShortName;
	}

	public void setDptShortName(String dptShortName) {
		this.dptShortName = dptShortName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFixedPhone() {
		return fixedPhone;
	}

	public void setFixedPhone(String fixedPhone) {
		this.fixedPhone = fixedPhone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}