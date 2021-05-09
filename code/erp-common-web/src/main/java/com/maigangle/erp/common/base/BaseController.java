package com.maigangle.erp.common.base;

import javax.servlet.http.HttpServletRequest;
public class BaseController {
	/**
	 * 
	 * @author 朱晗
	 * @since 2017年7月14日 上午10:33:12
	 * @param request
	 * @return
	 */
	protected String getLoginName(HttpServletRequest request) {
		return null;
	}
	
	/**
	 * 得到系统url
	 * 
	 * @author 朱晗
	 * @since 2017年4月28日 下午1:52:31
	 * @param urlName
	 *            系统名
	 * @return
	 */
	protected String getUrl(String urlName) {
		return null;
	}
//	
	protected SessionInfo getSessionInfo(HttpServletRequest request) {
		 return new SessionInfo();
	}



}
