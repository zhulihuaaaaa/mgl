package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.OverdueDefer;

/**  
 * 延期dto
 * @author zlh
 * @since 2017年1月30日 下午3:55:26 
 * @version 1.0 
 */
public class OverdueDeferDto extends OverdueDefer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -999589940052921489L;
	
	/**
	 * 创建开始日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date createStartDate;
	
	/**
	 * 创建结束日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private Date createEndDate;

	public Date getCreateStartDate() {
		return createStartDate;
	}

	public void setCreateStartDate(Date createStartDate) {
		this.createStartDate = createStartDate;
	}

	public Date getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(Date createEndDate) {
		this.createEndDate = createEndDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
