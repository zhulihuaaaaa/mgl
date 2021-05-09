package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseMargin implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5295078888736021370L;

	/**
     * id
     */
    private String marginId;

    /**
     * 保证金比例
     */
    private BigDecimal proportion;

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
     * @return MARGIN_ID id
     */
    public String getMarginId() {
        return marginId;
    }

    /**
     * id
     * @param marginId id
     */
    public void setMarginId(String marginId) {
        this.marginId = marginId == null ? null : marginId.trim();
    }

    /**
     * 保证金比例
     * @return PROPORTION 保证金比例
     */
    public BigDecimal getProportion() {
        return proportion;
    }

    /**
     * 保证金比例
     * @param proportion 保证金比例
     */
    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
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