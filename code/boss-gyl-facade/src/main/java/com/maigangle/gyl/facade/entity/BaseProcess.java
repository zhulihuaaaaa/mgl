package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseProcess implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2009191565414176990L;

	/**
     * id
     */
    private String processId;

    /**
     * 表面名称
     */
    private String processName;

    /**
     * N:停用 Y:正常
     */
    private String status;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;

    /**
     * N:否 Y:是
     */
    private String isDel;

    /**
     * id
     * @return PROCESS_ID id
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * id
     * @param processId id
     */
    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    /**
     * 表面名称
     * @return PROCESS_NAME 表面名称
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * 表面名称
     * @param processName 表面名称
     */
    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    /**
     * N:停用 Y:正常
     * @return STATUS N:停用 Y:正常
     */
    public String getStatus() {
        return status;
    }

    /**
     * N:停用 Y:正常
     * @param status N:停用 Y:正常
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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