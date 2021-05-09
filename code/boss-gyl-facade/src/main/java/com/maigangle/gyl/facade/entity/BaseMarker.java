package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseMarker implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 734567503496641447L;

	/**
     * id
     */
    private String markerId;

    /**
     * 钢厂全称
     */
    private String fullName;

    /**
     * 钢厂简称
     */
    private String shortName;

    /**
     * N:停止 Y:正常 
     */
    private String status;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 传真
     */
    private String fax;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * N:否 Y:是
     */
    private String isDel;

    /**
     * id
     * @return MARKER_ID id
     */
    public String getMarkerId() {
        return markerId;
    }

    /**
     * id
     * @param markerId id
     */
    public void setMarkerId(String markerId) {
        this.markerId = markerId == null ? null : markerId.trim();
    }

    /**
     * 钢厂全称
     * @return FULL_NAME 钢厂全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 钢厂全称
     * @param fullName 钢厂全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 钢厂简称
     * @return SHORT_NAME 钢厂简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 钢厂简称
     * @param shortName 钢厂简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * N:停止 Y:正常 
     * @return STATUS N:停止 Y:正常 
     */
    public String getStatus() {
        return status;
    }

    /**
     * N:停止 Y:正常 
     * @param status N:停止 Y:正常 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 地址
     * @return ADDRESS 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 联系人
     * @return CONTACTS 联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 联系人
     * @param contacts 联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * 联系方式
     * @return CONTACT_INFO 联系方式
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * 联系方式
     * @param contactInfo 联系方式
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo == null ? null : contactInfo.trim();
    }

    /**
     * 传真
     * @return FAX 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 传真
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * 创建人
     * @return CREATE_USER 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 创建日期
     * @return CREATE_DATE 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * N:否 Y:是
     * @return IS_DEL N:否 Y:是
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * N:否 Y:是
     * @param isDel N:否 Y:是
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
}