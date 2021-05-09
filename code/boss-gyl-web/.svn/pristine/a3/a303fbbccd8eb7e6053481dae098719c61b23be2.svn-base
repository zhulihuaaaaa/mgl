package com.maigangle.gyl.web.controller.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.SysApprovalFlow;
import com.maigangle.gyl.facade.entity.SysApprovalProcess;
import com.maigangle.gyl.facade.entity.api.PrivRole;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.SysApprovalInfo;
import com.maigangle.gyl.facade.entity.vo.SysApprovalProcessVo;
import com.maigangle.gyl.facade.enums.ApprovalSpeciesEnum;
import com.maigangle.gyl.facade.service.ApproveService;
import com.maigangle.gyl.facade.service.SysService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;
/**
 * 
 * @author 杨思静
 * @since  2018年2月7日 - 下午5:41:36
 * @version 1.1
 */
@Controller
@RequestMapping("/baseApproval")
public class BaseApprovalController extends GylBaseWeb{
	@Autowired 
	private SysService sysService;
	@Autowired
	private  ApproveService approveService;
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/baseApprove/baseApproveIndex");
		return modelAndView;
	}
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request, @RequestBody List<SysApprovalProcess> sysList) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "添加流程信息", "操作人ID为：" + getLoginName(request) + "添加流程信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			for (SysApprovalProcess sysApprovalProcess : sysList) {
				sysService.addApprovalProcess(sysApprovalProcess);
			}
			return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, sysList);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "添加流程信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request, @RequestBody JSONObject jsonObject) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新流程信息", "操作人ID为：" + getLoginName(request) + "更新流程信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());	
			List<SysApprovalProcess> sysList = JSON.parseArray(JSON.toJSONString(jsonObject.get("sysList")), SysApprovalProcess.class);
			List<SysApprovalProcess> addList = JSON.parseArray(JSON.toJSONString(jsonObject.get("addList")), SysApprovalProcess.class);
			List<SysApprovalProcess> deleteList = JSON.parseArray(JSON.toJSONString(jsonObject.get("deleteList")), SysApprovalProcess.class);
			for (SysApprovalProcess sysApprovalProcess : sysList) {
				if(StringUtils.isEmpty(sysApprovalProcess.getApprovalProcessId())) {
					sysService.addApprovalProcess(sysApprovalProcess);
				}else {
					sysService.updateApprovalProcess(sysApprovalProcess);					
				}
			}
			for (SysApprovalProcess sysApprovalProcess : deleteList) {
				sysService.deleteApprovalProcess(sysApprovalProcess.getApprovalProcessId());
			}
			return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS, null);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新流程信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除流程信息", "操作人ID为：" + getLoginName(request) + "删除流程信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			
			return AjaxResult.createSuccessResultWithCode(MessageCode.DELETE_SUCCESS, approveService.delectApproveModel(id));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除流程信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
	}
	
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request, PageUtils<SysApprovalProcess> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询流程信息并分页", "操作人ID为：" + getLoginName(request) + "查询流程信息并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if(page.getDto() ==null) {
				page.setDto(new SysApprovalProcess());
			}
			List<SysApprovalProcess> list = sysService.getApprovalProcesss(page.getDto());
			Map<String,Set<SysApprovalProcessVo>> map = new HashMap<>();
			for (SysApprovalProcess sysApprovalProcess : list) {
				String name = ApprovalSpeciesEnum.getEnum(sysApprovalProcess.getModule()).getName();
				if(!map.containsKey(name)) {
					Set<SysApprovalProcessVo> set =new TreeSet<SysApprovalProcessVo>(new Comparator<SysApprovalProcessVo>() {
						@Override
						public int compare(SysApprovalProcessVo o1, SysApprovalProcessVo o2) {
							BigDecimal i = o1.getProcess().getProcessIndex();
							BigDecimal i2 = o2.getProcess().getProcessIndex();
							return i.compareTo(i2);
						}
					});
					SysApprovalProcessVo vo = new SysApprovalProcessVo();
					vo.setModelName(sysApprovalProcess.getModule());
					vo.setProcess(sysApprovalProcess);
					Map<String, Object> result =getPrivRole(request,sysApprovalProcess.getRoleId());
					if (!(boolean) result.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前角色信息异常，" + result.get("msg"));
					}
					PrivRole role = (PrivRole)result.get("data");
					vo.setPrivRole(role);
					set.add(vo);
					map.put(name,set);
				}else {
					Set<SysApprovalProcessVo> set = map.get(name);
					SysApprovalProcessVo vo = new SysApprovalProcessVo();
					vo.setModelName(sysApprovalProcess.getModule());
					vo.setProcess(sysApprovalProcess);
					Map<String, Object> result =getPrivRole(request,sysApprovalProcess.getRoleId());
					if (!(boolean) result.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前角色信息异常，" + result.get("msg"));
					}
					PrivRole role = (PrivRole)result.get("data");
					vo.setPrivRole(role);
					set.add(vo);
				}
			}
			return AjaxResult.createSuccessResult(map);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询流程信息并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: findbymodule
	 * @Description: ( 查询出 module的流程 ) 
	 * @param request
	 * @param module
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/findbymodule")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request,String module) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询流程信息", "操作人ID为：" + getLoginName(request) + "查询流程信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			SysApprovalProcess processSearch = new SysApprovalProcess();
			processSearch.setModule(module);
			List<SysApprovalProcess> processList = sysService.getApprovalProcesss(processSearch);
			return AjaxResult.createSuccessResult(processList);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询流程信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询流程进程信息", "操作人ID为：" + getLoginName(request) + "查询流程进程信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if(StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
			SysApprovalFlow flow = new SysApprovalFlow();
			flow.setApprovalItemId(id);
			List<SysApprovalFlow>	list = sysService.getApprovalFlows(flow);
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询流程进程信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	

	
}
