package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.FeeFinalReport;

public class FeeFinalReportDto extends FeeFinalReport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4742165053094708243L;
	
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
   
}