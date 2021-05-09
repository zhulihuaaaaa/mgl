package com.maigangle.gyl.web.controller.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.service.GylService;
import com.maigangle.gyl.web.controller.GylBaseWeb;

/**
 * 测试controller标准案例 --表明此Controller作用
 * 
 * @author zhuh
 * @since 2017年11月9日 上午10:06:48
 * @version 1.0
 */
@Controller
@RequestMapping("/testFunction")
public class TestFunctionController extends GylBaseWeb {
	@Autowired
	GylService gylService;
	/**
	 * 测试方法返回视图 ---说明方法作用
	 * @param rq ---说明参数作用
	 * @return 
	 */
	@RequestMapping("/testView")
	public ModelAndView test(HttpServletRequest rq) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		ModelAndView mav = new ModelAndView();
		// 方法必须try catch包住
		try {
			// info日志标准写法 
			super.logInfo(rq, logBatch, "进入用户认证详情页面", "操作人ID为：" + getLoginName(rq) + "进入用户认证详情页面",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			mav.addObject("acntUserBasics", null);
		} catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(rq, logBatch, "进入用户认证详情页面失败",
					"操作人ID为：" + getLoginName(rq) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 返回错误页面
		}
		mav.setViewName("/testFunction/specific");
		return mav;
	}
	
	/**
	 * 测试方法返回json ---说明方法作用
	 * @param rq
	 * @return
	 */
	@RequestMapping(value = "/testAjax")
	@ResponseBody
	public Map<String,Object> testAjax(HttpServletRequest rq) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		Map<String,Object> resultMap = new HashMap<String,Object>();
		// 方法必须try catch包住
		try {
			// info日志标准写法  开始获取
			super.logInfo(rq, logBatch, "获取客户详细信息", "操作人ID为：" + getLoginName(rq)+"开始获取xx记录", EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 业务代码
			Object obj =  new Object();
			resultMap.put("obj", obj);
			// info日志标准写法  获取结束
			super.logInfo(	rq,
							logBatch,
							"获取客户详细信息成功",
							"操作人ID为：" + getLoginName(rq) + "结果为" + JSONObject.toJSONString(resultMap),
							EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(	rq,
							logBatch,
							"获取客户详细信息失败",
							"操作人ID为：" + getLoginName(rq) + "错误信息为：" + ExceptionUtils.getStackTrace(e),
							false,
							EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			resultMap.put("msg", e.getMessage());
			//返回成功字符串false 前端使用===比较
			resultMap.put("isSuccess", "false");
			return resultMap;
		}
		//返回成功字符串true 前端使用===比较
		resultMap.put("isSuccess", "true");
		return resultMap;
	}
}
