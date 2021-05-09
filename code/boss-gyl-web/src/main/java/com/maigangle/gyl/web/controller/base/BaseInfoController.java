package com.maigangle.gyl.web.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.BaseInfo;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

/**
 * 基础设置Controller
 * @author 汪玮琦
 * @since 2017年11月27日 下午2:27:31
 * @version 1.0
 */
@Controller
@RequestMapping("/baseInfo")
public class BaseInfoController extends GylBaseWeb {
	@Autowired
	BaseService baseService;

	/**
	 * 页面
	 * @author 倪凯
	 * @return
	 */
	@RequestMapping("/main")
	public ModelAndView main(Model model) {
		//  进行相关逻辑编写
        model.addAttribute("infoList", baseService.getGlobalBaseInfo());
		ModelAndView modelAndView = new ModelAndView("/baseInfo/baseInfoIndex");
		return modelAndView;
	}
	/**
	 * 更新通用设置
	 * @author 倪凯
	 * @param request
	 * @param baseInfo 通用设置
	 * @return
	 */
	@Privilege(key = "GYL_BASEINFO_EDIT")
	@PostMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request, @RequestBody BaseInfo baseInfo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新通用设置", "操作人ID为：" + getLoginName(request) + "更新通用设置",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (baseInfo != null && !StringUtils.isEmpty(baseInfo.getInfoId())) {
				if (baseService.updateBaseInfo(baseInfo) != null)
					return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "数据ID不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新通用设置",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	/**
	 * 获取通用设置
	 * @param request
	 * @return
	 */
	@RequestMapping("/getGlobalBaseInfo")
	@ResponseBody
	public AjaxResult getGlobalBaseInfo(HttpServletRequest request) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		// 方法必须try catch包住
		try {
			// info日志标准写法 
			super.logInfo(request, logBatch, "获取通用设置", "操作人ID为：" + getLoginName(request) + "获取通用设置",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			return AjaxResult.createSuccessResult(baseService.getGlobalBaseInfo());
		} catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(request, logBatch, "获取通用设置",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 获取通用手续费率
	 * @param request
	 * @return
	 */
	@RequestMapping("/getGlobalFeeRate")
	@ResponseBody
	public AjaxResult getGlobalFeeRate(HttpServletRequest request) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取通用手续费率", "操作人ID为：" + getLoginName(request) + "获取通用手续费率",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getGlobalFeeRate());
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取通用手续费率",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 获取开票费基数
	 * @param request
	 * @return
	 */
	@RequestMapping("/getGlobalInvoiceFee")
	@ResponseBody
	public AjaxResult getGlobalInvoiceFee(HttpServletRequest request) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取通用开票费", "操作人ID为：" + getLoginName(request) + "获取通用开票费",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getGlobalInvoiceFee());
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取通用开票费",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 获取逾期提醒周期
	 * @param request
	 * @return
	 */
	@RequestMapping("/getGlobalOverdueReminder")
	@ResponseBody
	public AjaxResult getGlobalOverdueReminder(HttpServletRequest request) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取逾期提醒设置", "操作人ID为：" + getLoginName(request) + "获取逾期提醒设置",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getGlobalOverdueReminder());
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取逾期提醒设置",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 更新通用设置
	 * @param request
	 * @param baseInfo 通用设置
	 * @return
	 */
	@PostMapping("/updateGlobalBaseInfo")
	@ResponseBody
	public AjaxResult updateGlobalBaseInfo(HttpServletRequest request, @RequestBody BaseInfo baseInfo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新通用设置", "操作人ID为：" + getLoginName(request) + "更新通用设置",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (baseInfo != null && !StringUtils.isEmpty(baseInfo.getInfoId())) {
				if (baseService.updateBaseInfo(baseInfo) != null)
					return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "数据ID不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新通用设置",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
}
