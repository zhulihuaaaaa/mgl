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
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;
import com.maigangle.gyl.facade.entity.BaseCompany;

/**
 * 
 * @author 倪凯
 * @since 2018年1月24日 
 * @varsion 1.0
 */
@Controller
@RequestMapping("/baseCompany")
public class BaseCompanyController extends GylBaseWeb{
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/baseCompany/baseCompanyIndex");
		return modelAndView;
	}
	
	@Privilege(key = "GYL_BASECOMPANY_ADD")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request, @RequestBody BaseCompany baseCompany) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			baseCompany.setIsDel("N");
			super.logInfo(request, logBatch, "添加甲方信息", "操作人ID为：" + getLoginName(request) + "添加甲方信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseCompany);
			if (StringUtils.isEmpty(checkMsg)) {
				
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				baseCompany.setCreateUser(privUser.getUserName());
				
				baseCompany = baseService.addBaseCompany(baseCompany);
				if (!StringUtils.isEmpty(baseCompany.getCompanyId())) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, baseCompany);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "添加甲方信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@Privilege(key = "GYL_BASECOMPANY_EDIT")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request, @RequestBody BaseCompany baseCompany) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新甲方信息", "操作人ID为：" + getLoginName(request) + "更新甲方信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseCompany);
			if (StringUtils.isEmpty(checkMsg)) {
				baseCompany = baseService.updateBaseCompany(baseCompany);
				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else if(StringUtils.isEmpty(baseCompany.getCompanyId())){
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "甲方id不能为空");
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新甲方信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	@Privilege(key = "GYL_BASECOMPANY_DELETE")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除甲方信息", "操作人ID为：" + getLoginName(request) + "删除甲方信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(id)) {
				return AjaxResult.createSuccessResult(baseService.deleteBaseCompany(id));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "甲方id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除甲方信息",
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
			super.logInfo(request, logBatch, "获取所有甲方信息", "操作人ID为：" + getLoginName(request) + "获取所有甲方信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getBaseCompany());
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取所有甲方信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/getBaseCompanyById")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String marginId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据id获取甲方信息", "操作人ID为：" + getLoginName(request) + "根据id获取甲方信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(marginId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "甲方id不能为空");
			} else {
				return AjaxResult.createSuccessResult(baseService.getBaseCompany());
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据id获取甲方信息",
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
			super.logInfo(request, logBatch, "根据id获取甲方", "操作人ID为：" + getLoginName(request) + "根据id获取甲方",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(marginId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "甲方id不能为空");
			} else {
				return AjaxResult.createSuccessResult(baseService.getProportion(marginId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据id获取甲方",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 非空校验
	 * @param baseCompany
	 * @return
	 */
	private String checkObject(BaseCompany baseCompany) {
		if (baseCompany == null) {
			return "甲方实体不能为空";
		}
		String baseStr = "不能为空";
		if (baseCompany.getCompanyName() == null) {
			return "甲方名称" + baseStr;
		}
		return "";
	}
}
