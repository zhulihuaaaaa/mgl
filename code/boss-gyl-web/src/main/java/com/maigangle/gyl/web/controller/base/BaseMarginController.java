package com.maigangle.gyl.web.controller.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.BaseMargin;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

/**
 * 保证金设置
 * @author 汪玮琦
 * @since 2017年12月1日 下午1:33:42
 * @varsion 1.0
 */
@Controller
@RequestMapping("/baseMargin")
public class BaseMarginController extends GylBaseWeb{
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/baseMargin/baseMarginIndex");
		return modelAndView;
	}

	@Privilege(key = "GYL_BASEMARGIN_ADD")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request, @RequestBody BaseMargin baseMargin) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			baseMargin.setIsDel("N");
			super.logInfo(request, logBatch, "添加保证金信息", "操作人ID为：" + getLoginName(request) + "添加保证金信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseMargin);
			if (StringUtils.isEmpty(checkMsg)) {
				//baseMargin.setCreateUser(gylApiService.getCurrentPrivUser().getUserName());
				
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				baseMargin.setCreateUser(privUser.getUserName());
				
				baseMargin = baseService.addBaseMargin(baseMargin);
				if (!StringUtils.isEmpty(baseMargin.getMarginId())) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, baseMargin);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "添加保证金信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}

	@Privilege(key = "GYL_BASEMARGIN_EDIT")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request, @RequestBody BaseMargin baseMargin) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新保证金信息", "操作人ID为：" + getLoginName(request) + "更新保证金信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseMargin);
			if (StringUtils.isEmpty(checkMsg)) {
				baseMargin = baseService.updateBaseMargin(baseMargin);
				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else if(StringUtils.isEmpty(baseMargin.getMarginId())){
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "保证金id不能为空");
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新保证金信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}

	@Privilege(key = "GYL_BASEMARGIN_DELETE")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除保证金信息", "操作人ID为：" + getLoginName(request) + "删除保证金信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(id)) {
				return AjaxResult.createSuccessResult(baseService.deleteBaseMargin(id));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "保证金id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除保证金信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取所有保证金信息", "操作人ID为：" + getLoginName(request) + "获取所有保证金信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getBaseMargins());
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取所有保证金信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/getBaseMarginById")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String marginId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据id获取保证金信息", "操作人ID为：" + getLoginName(request) + "根据id获取保证金信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(marginId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "保证金id不能为空");
			} else {
				return AjaxResult.createSuccessResult(baseService.getBaseMargin(marginId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据id获取保证金信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/getProportion")
	@ResponseBody
	public AjaxResult getProportion(HttpServletRequest request, String marginId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据id获取保证金", "操作人ID为：" + getLoginName(request) + "根据id获取保证金",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(marginId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "保证金id不能为空");
			} else {
				return AjaxResult.createSuccessResult(baseService.getProportion(marginId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据id获取保证金",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 非空校验
	 * @param baseMargin
	 * @return
	 */
	private String checkObject(BaseMargin baseMargin) {
		if (baseMargin == null) {
			return "保证金实体不能为空";
		}
		String baseStr = "不能为空";
		if (baseMargin.getProportion() == null) {
			return "保证金比例" + baseStr;
		}
		return "";
	}
}
