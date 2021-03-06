package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 库存盘点明细
 * @author 张鹏亚
 *
 */
public class InvCheckInvDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1615066621931664571L;

	/**
     * id
     */
    private String checkInvDetailId;

    /**
     * 对应盘点记录
     */
    private String checkInvId;

    /**
     * 对应库存id
     */
    private String inventoryId;

    /**
     * 盘点记录
     */
    private String checkRecord;

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
     * @return CHECK_INV_DETAIL_ID id
     */
    public String getCheckInvDetailId() {
        return checkInvDetailId;
    }

    /**
     * id
     * @param checkInvDetailId id
     */
    public void setCheckInvDetailId(String checkInvDetailId) {
        this.checkInvDetailId = checkInvDetailId == null ? null : checkInvDetailId.trim();
    }

    /**
     * 对应盘点记录
     * @return CHECK_INV_ID 对应盘点记录
     */
    public String getCheckInvId() {
        return checkInvId;
    }

    /**
     * 对应盘点记录
     * @param checkInvId 对应盘点记录
     */
    public void setCheckInvId(String checkInvId) {
        this.checkInvId = checkInvId == null ? null : checkInvId.trim();
    }

    /**
     * 对应库存id
     * @return INVENTORY_ID 对应库存id
     */
    public String getInventoryId() {
        return inventoryId;
    }

    /**
     * 对应库存id
     * @param inventoryId 对应库存id
     */
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId == null ? null : inventoryId.trim();
    }

    /**
     * 盘点记录
     * @return CHECK_RECORD 盘点记录
     */
    public String getCheckRecord() {
        return checkRecord;
    }

    /**
     * 盘点记录
     * @param checkRecord 盘点记录
     */
    public void setCheckRecord(String checkRecord) {
        this.checkRecord = checkRecord == null ? null : checkRecord.trim();
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