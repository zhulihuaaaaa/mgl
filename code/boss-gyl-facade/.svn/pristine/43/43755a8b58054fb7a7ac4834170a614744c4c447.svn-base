package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 甲方设置
 * @author 倪凯
 * @since 2018年1月25日
 * @version 1.0
 */
public class BaseCompany implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1738142618655747302L;

	/**
     * id
     */
    private String companyId;

    /**
     * 甲方公司名称
     */
    private String companyName;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;

    /**
     * N:未删 Y:已删
     */
    private String isDel;

    /**
     * id
     * @return COMPANY_ID id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * id
     * @param companyId id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * 甲方公司名称
     * @return COMPANY_NAME 甲方公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 甲方公司名称
     * @param companyName 甲方公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
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
     * 创建时间
     * @return CREATE_DATE 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * N:未删 Y:已删
     * @return IS_DEL N:未删 Y:已删
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * N:未删 Y:已删
     * @param isDel N:未删 Y:已删
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
}