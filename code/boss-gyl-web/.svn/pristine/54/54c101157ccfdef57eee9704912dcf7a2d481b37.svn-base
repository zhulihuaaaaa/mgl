package com.maigangle.gyl.web.exception;

import com.maigangle.erp.common.exception.CommonException;

/**
 * fund模块提供api 异常统一处理
 * 
 * @author 朱晗
 * @since 2017年4月27日 下午4:41:25
 * @version 1.0
 */
public class GylApiException extends CommonException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 386131650147545270L;
	
	public GylApiException(String errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
		this.msg = msg;
	}
	/**
	 * 错误代码
	 */
	private String errorCode;
	/**
	 * 错误信息
	 */
	private String msg;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
