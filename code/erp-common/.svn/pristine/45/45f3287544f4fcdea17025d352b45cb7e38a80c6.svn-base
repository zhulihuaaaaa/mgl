package com.maigangle.erp.common.api;

/**
 * API调用结果
 * 
 * @author 曹祥昌
 * @since 2017年3月15日 下午4:29:24
 * @version 1.0
 **/
public class ApiResult {
	/**
	 * 成功标识码
	 */
	public static String STATE_CODE_SUCCESS = "1";
	/**
	 * 失败标识
	 */
	public static String STATE_CODE_FAIL = "0";
	public ApiResult() {}

	public ApiResult(String errorCode, String msg, Object jsonData) {
		super();
		this.errorCode = errorCode;
		this.msg = msg;
		this.jsonData = jsonData;
	}

	/**
	 * 错误码，1成功，其他失败
	 */
	private String errorCode;
	/**
	 * 错误信息
	 */
	private String msg;
	/**
	 * 其他JSON数据，根据具体业务而定
	 */
	private Object jsonData;

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

	public Object getJsonData() {
		return jsonData;
	}

	public void setJsonData(Object jsonData) {
		this.jsonData = jsonData;
	}

}
