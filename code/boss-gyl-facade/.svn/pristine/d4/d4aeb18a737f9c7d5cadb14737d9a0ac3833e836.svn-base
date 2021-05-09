package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 盘点库存主表
 * @author 张鹏亚
 *
 */
public class InvCheckInv implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5527388170460451759L;

	/**
     * id
     */
    private String checkInvId;

    /**
     * 盘点仓库
     */
    private String storageId;
    
    private String storageName;

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
     * @return CHECK_INV_ID id
     */
    public String getCheckInvId() {
        return checkInvId;
    }

    /**
     * id
     * @param checkInvId id
     */
    public void setCheckInvId(String checkInvId) {
        this.checkInvId = checkInvId == null ? null : checkInvId.trim();
    }

    /**
     * 盘点仓库
     * @return STORAGE_ID 盘点仓库
     */
    public String getStorageId() {
        return storageId;
    }

    /**
     * 盘点仓库
     * @param storageId 盘点仓库
     */
    public void setStorageId(String storageId) {
        this.storageId = storageId == null ? null : storageId.trim();
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

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
    
    
}