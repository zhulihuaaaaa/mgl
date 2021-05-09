package com.maigangle.erp.common.util;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.maigangle.erp.common.api.ApiResult;

/**
 * 调用接口相关信息处理
 * 
 * @author 朱晗
 * @since 2017年5月26日 上午11:28:36
 * @version 1.0
 */
public class CallApiMsgUtil {
	public static boolean operaIsSuccess(String apiResult) {
		if (StringUtils.isBlank(apiResult)) {
			return false;
		}
		String errorCode = JSON.parseObject(apiResult).getString("errorCode");
		if (!StringUtils.equals(ApiResult.STATE_CODE_SUCCESS, errorCode)) {
			return false;
		}
		return true;
	}

	public static String getErrorMsg(String apiResult) {
		if (StringUtils.isBlank(apiResult)) {
			return "调用接口异常";
		}
		String msg = JSON.parseObject(apiResult).getString("msg");
		return msg;
	}
}
