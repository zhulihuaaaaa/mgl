package com.maigangle.gyl.web.controller.report;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.FeeFinalReportDto;
import com.maigangle.gyl.facade.service.FeeFinalReportService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;


/**  
 * 期末期初报表controller
 * @author zlh
 * @since 2017年11月28日 下午3:07:20 
 * @version 1.0 
 */
@Controller
@RequestMapping("feeFinalReport")
public class FeeFinalReportController extends GylBaseWeb {
	@Autowired
	FeeFinalReportService feeFinalReportService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/report/feeFinalReportIndex");
		return modelAndView;
	}
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/report/feeFinalReportDetail");
		return modelAndView;
	}
	
	/**
	 * 新建，查询期末初期报表
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findFinalReport")
	@ResponseBody
	public AjaxResult findFinalReport(HttpServletRequest request,@RequestBody FeeFinalReportDto dto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新建，查询期末初期报表并保存", "操作人ID为：" + getLoginName(request) + "新建，查询期末初期报表并保存",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
				return AjaxResult.createSuccessResult(feeFinalReportService.getFeeFinalReport(dto, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新建，查询期末初期报表并保存",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	/**
	 * 保存期末初期报表
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/saveFinalReport")
	@ResponseBody
	public AjaxResult saveFinalReport(HttpServletRequest request,@RequestBody FeeFinalReportDto dto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新建，查询期末初期报表并保存", "操作人ID为：" + getLoginName(request) + "新建，查询期末初期报表并保存",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				dto.setCreateUser(privUser.getUserName());
				return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS,feeFinalReportService.saveFeeFinalReport(dto, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新建，查询期末初期报表并保存",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	/**
	 * 查询所有期末期初报表带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findDeferPage(HttpServletRequest request,@RequestBody PageUtils<FeeFinalReportDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有期末期初报表带分页", "操作人ID为：" + getLoginName(request) + "查询所有期末期初报表带分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
				return AjaxResult.createSuccessResult(feeFinalReportService.getFeeFinalReport(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有期末期初报表带分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
}
