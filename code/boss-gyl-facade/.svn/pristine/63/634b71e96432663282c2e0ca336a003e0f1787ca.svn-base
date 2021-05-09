package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.InvCheckInvDetail;
/**
 * 用于接收保存记录的参数
 * @author 张鹏亚
 *
 */
public class InvCheckInvVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3701042800974568832L;
	
	/**
	 * 明细记录
	 */
	private Map<String, String> detail;
	
	private String storageId;
	
	private String createUser;
	
	  /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
    private Date startCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
    private Date endCreateDate;
	
	/**
	 * 总备注
	 */
	private String note;
	
	public Map<String, String> getDetail() {
		return detail;
	}

	public void setDetail(Map<String, String> detail) {
		this.detail = detail;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartCreateDate() {
		return startCreateDate;
	}

	public void setStartCreateDate(Date startCreateDate) {
		this.startCreateDate = startCreateDate;
	}

	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
	
	
}
