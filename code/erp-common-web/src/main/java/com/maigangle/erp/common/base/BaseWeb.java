package com.maigangle.erp.common.base;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础的BaseWeb工具类,web项目必须继承
 * 
 * @author 朱晗
 * @since 2017年7月14日 下午10:12:56
 * @version 1.0
 **/
public class BaseWeb extends BaseController {
	/**
	 * 
	 * @author 朱晗
	 * @since 2017年7月14日 下午10:12
	 * @param request
	 * @param logBatch
	 *            日志批次
	 * @param operationContent
	 *            操作内容概要
	 * @param operationDetailContent
	 *            操作详细内容
	 * @param subSystem
	 *            操作系统
	 */
	protected void logInfo(HttpServletRequest request, String logBatch, String operationContent, String operationDetailContent, String subSystem) {}

	/**
	 * 
	 * @author 朱晗
	 * @since 2017年7月14日 下午10:12
	 * @param request
	 * @param logBatch
	 *            日志批次
	 * @param operationContent
	 *            操作内容概要
	 * @param operationDetailContent
	 *            操作详细内容
	 * @param notify
	 *            是否通知异常
	 * @param subSystem
	 *            操作系统
	 */
	protected void logError(HttpServletRequest request,
							String logBatch,
							String operationContent,
							String operationDetailContent,
							boolean notify,
							String subSystem) {}


}
