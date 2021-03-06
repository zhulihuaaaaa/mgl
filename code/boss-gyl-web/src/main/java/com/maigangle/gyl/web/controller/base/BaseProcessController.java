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
import com.maigangle.gyl.facade.entity.BaseProcess;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

@Controller
@RequestMapping("/baseProcess")
public class BaseProcessController extends GylBaseWeb {
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/baseProcess/baseProcessIndex");
		return modelAndView;
	}

	@Privilege(key = "GYL_BASEPROCESS_ADD")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request, @RequestBody BaseProcess baseProcess) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			baseProcess.setIsDel("N");
			super.logInfo(request, logBatch, "添加表面信息", "操作人ID为：" + getLoginName(request) + "添加表面信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseProcess);
			if (StringUtils.isEmpty(checkMsg)) {
				
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				baseProcess.setCreateUser(privUser.getUserName());
				
				baseProcess = baseService.addBaseProcess(baseProcess);
				if (!StringUtils.isEmpty(baseProcess.getProcessId())) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, baseProcess);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "添加表面信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}

	@Privilege(key = "GYL_BASEPROCESS_EDIT")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request, @RequestBody BaseProcess baseProcess) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新表面信息", "操作人ID为：" + getLoginName(request) + "更新表面信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseProcess);
			if (StringUtils.isEmpty(checkMsg)) {
				baseProcess = baseService.updateBaseProcess(baseProcess);
				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else if (StringUtils.isEmpty(baseProcess.getProcessId())){
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "表面id不能为空");
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新表面信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}

	@Privilege(key = "GYL_BASEPROCESS_DELETE")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除表面信息", "操作人ID为：" + getLoginName(request) + "删除表面信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "表面id不能为空");
			} else {
				int row = baseService.deleteBaseProcess(id);
				if (row > 0) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.DELETE_SUCCESS);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除表面信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
	}
	
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request, PageUtils<BaseProcess> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询表面信息并分页", "操作人ID为：" + getLoginName(request) + "查询表面信息并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getBaseProcesses(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询表面信息并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request,String materialName,String orderCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询表面信息", "操作人ID为：" + getLoginName(request) + "查询表面信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getBaseProcess(request, materialName,orderCode);
			if (!(boolean)result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取表表面异常," + result.get("msg"));
			}
			return AjaxResult.createSuccessResult(result.get("data"));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询表面信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String processId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询表面信息", "操作人ID为：" + getLoginName(request) + "查询表面信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getBaseProcess(processId));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询表面信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findProcessName")
	@ResponseBody
	public AjaxResult findProcessName(HttpServletRequest request, String processId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询表面名称", "操作人ID为：" + getLoginName(request) + "查询表面名称",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getProcessName(processId));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询表面名称",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 必填检查
	 * @param baseProcess
	 * @return
	 */
	private String checkObject(BaseProcess baseProcess) {
		if (baseProcess == null) {
			return "表面信息对象不能为空";
		}
		if (StringUtils.isEmpty(baseProcess.getProcessName())) {
			return "表面名称不能为空";
		}
		return "";
	}
}
