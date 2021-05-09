package com.maigangle.gyl.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * 审批API
 * @author 张渊
 * @since 2017年12月21日 下午2:37:50
 * @version 1.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.SysApprovalFlow;
import com.maigangle.gyl.facade.entity.SysApprovalProcess;
import com.maigangle.gyl.facade.entity.api.PrivRole;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.SysApprovalInfo;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.SysApprovalService;
import com.maigangle.gyl.facade.service.SysService;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

@RestController
@RequestMapping("/approval")
public class ApprovalController extends GylBaseWeb {
	@Autowired
	SysService sysService;
	@Autowired
	SysApprovalService sysApprovalService;
	@Autowired
	ContractService contractService;
	@RequestMapping("/findFlow")
	public AjaxResult findFlow(HttpServletRequest request, String approvalItemId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询审批进程", "操作人ID为：" + getLoginName(request),
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(approvalItemId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "审批项ID不能为空");
			} else {
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean) result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户信息异常，" + result.get("msg"));
				}
				PrivUser user = (PrivUser)result.get("data");
				SysApprovalInfo dto = sysService.getLastApprovalInfoByApprovalItemId(approvalItemId, user);
				return AjaxResult.createSuccessResult(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询审批进程",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取审批信息失败");
	}
	@PostMapping("/submit")
	public AjaxResult submit(HttpServletRequest request, @RequestBody SysApprovalFlow dto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "提交审批", "操作人ID为：" + getLoginName(request) + "提交审批",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String approvalItemId = dto.getApprovalItemId();
			String moduleAlias = dto.getModule();
			if (!StringUtils.isEmpty(approvalItemId) && !StringUtils.isEmpty(moduleAlias)) {
				Map<String, Object> userMap = getCurrentPrivUser(request);
				if (!(boolean) userMap.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.APPROVAL_SUBMIT_FAILED, "获取当前用户信息异常");
				}
				PrivUser user = (PrivUser) userMap.get("data");
				if (sysApprovalService.submit(approvalItemId, moduleAlias, user)) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.APPROVAL_SUBMIT_SUCCESS);						
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "提交审批",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.APPROVAL_SUBMIT_FAILED);
	}
	@PostMapping("/abandonSubmit")
	public AjaxResult abandonSubmit(HttpServletRequest request, @RequestBody SysApprovalFlow dto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "撤销提交", "操作人ID为：" + getLoginName(request) + "撤销提交",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String approvalItemId = dto.getApprovalItemId();
			if (!StringUtils.isEmpty(approvalItemId)) {
				Map<String, Object> userMap = getCurrentPrivUser(request);
				if (!(boolean) userMap.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.APPROVAL_ABANDON_FAILED, "获取当前用户信息异常");
				}
				PrivUser user = (PrivUser) userMap.get("data");
				if (sysApprovalService.abandonSubmit(approvalItemId, user)) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.APPROVAL_ABANDON_SUCCESS);
				} else {
					return AjaxResult.createErrorResult(MessageCode.APPROVAL_ABANDON_FAILED);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "撤销提交",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.APPROVAL_ABANDON_FAILED, "审批项ID不能为空");
	}
	@PostMapping("/approval")
	public AjaxResult approval(HttpServletRequest request, @RequestBody SysApprovalFlow flow) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "审批通过", "操作人ID为：" + getLoginName(request) + "审批通过",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String approvalItemId = flow.getApprovalItemId();
			String remark = flow.getRemark();
			if (!StringUtils.isEmpty(approvalItemId)) {
				boolean result;
				Map<String, Object> userMap = getCurrentPrivUser(request);
				if (!(boolean) userMap.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.APPROVAL_FAILED, "获取当前用户信息异常");
				}
				PrivUser user = (PrivUser) userMap.get("data");
				result = sysApprovalService.approval(flow, remark, user);
				if (result) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.APPROVAL_SUCCESS);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "审批通过",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.APPROVAL_FAILED);
	}
	@PostMapping("/reject")
	public AjaxResult reject(HttpServletRequest request, @RequestBody SysApprovalFlow flow) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "审批拒绝", "操作人ID为：" + getLoginName(request) + "审批拒绝",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String approvalItemId = flow.getApprovalItemId();
			String remark = flow.getRemark();
			if (!StringUtils.isEmpty(approvalItemId)) {
				try {
					Map<String, Object> userMap = getCurrentPrivUser(request);
					if (!(boolean) userMap.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.APPROVAL_REJECT_FAILED, "获取当前用户信息异常");
					}
					PrivUser user = (PrivUser) userMap.get("data");
//					boolean result = sysApprovalService.reject(approvalItemId, remark, user);
//					if (result) {
//						return AjaxResult.createSuccessResultWithCode(MessageCode.APPROVAL_REJECT_SUCCESS);
//					}
				} catch (Exception e) {
					return AjaxResult.createErrorResult(MessageCode.APPROVAL_REJECT_FAILED, e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "审批拒绝",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.APPROVAL_REJECT_FAILED);
	}
	@PostMapping("/abandon")
	public AjaxResult abandon(HttpServletRequest request, @RequestBody SysApprovalFlow flow) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "撤销审批", "操作人ID为：" + getLoginName(request) + "撤销审批",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String approvalItemId = flow.getApprovalItemId();
			String state = flow.getState();
			if (!StringUtils.isEmpty(approvalItemId)) {
				Map<String, Object> userMap = getCurrentPrivUser(request);
				if (!(boolean) userMap.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.APPROVAL_ABANDON_FAILED, "获取当前用户信息异常");
				}
				PrivUser user = (PrivUser) userMap.get("data");
				if (sysApprovalService.abandon(approvalItemId, user)) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.APPROVAL_ABANDON_SUCCESS);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "撤销审批",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.APPROVAL_ABANDON_FAILED);
	}
	@PostMapping("/cancel")
	public AjaxResult cancel(HttpServletRequest request, @RequestBody SysApprovalFlow flow) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "作废数据", "操作人ID为：" + getLoginName(request) + "作废数据",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String approvalItemId = flow.getApprovalItemId();
			if (!StringUtils.isEmpty(approvalItemId)) {
				Map<String, Object> userMap = getCurrentPrivUser(request);
				if (!(boolean) userMap.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.APPROVAL_CANCEL_FAILED, "获取当前用户信息异常");
				}
				PrivUser user = (PrivUser) userMap.get("data");
				if (sysApprovalService.cancel(approvalItemId, user)) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.APPROVAL_CANCEL_SUCCESS);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "作废数据",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.APPROVAL_CANCEL_FAILED);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: findNewProcess 
	 * @Description: ( 审批进度 ) 
	 * @param request
	 * @param flows
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/findAllProcess")
	@ResponseBody
	public AjaxResult findNewProcess(HttpServletRequest request, @RequestBody SysApprovalFlow flows) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询流程进程信息", "操作人ID为：" + getLoginName(request) + "查询流程进程信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String id = flows.getApprovalItemId();
			String module = flows.getModule();
			if(StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
			// 某订单下的进程
			SysApprovalFlow flow = new SysApprovalFlow();
			flow.setApprovalItemId(id);
			List<SysApprovalFlow>	list = sysService.getApprovalFlows(flow);
			// 某模块下的流程
			SysApprovalProcess process = new SysApprovalProcess();
			process.setModule(module);
			List<SysApprovalProcess> processList = sysService.getApprovalProcesss(process);
			// 设置返回的内容
			List<SysApprovalInfo> infoList = new ArrayList<>();
			for (SysApprovalProcess sysApprovalProcess : processList) {
				SysApprovalInfo info = new SysApprovalInfo();
				for (SysApprovalFlow sysApprovalFlow : list) {
					if(sysApprovalFlow.getApprovalProcessId()==null) {
						continue;
					}
					if(sysApprovalFlow.getApprovalProcessId().equals(sysApprovalProcess.getApprovalProcessId())) {
						info.setApprovalFlowId(sysApprovalFlow.getApprovalFlowId());
						info.setApprovalItemId(sysApprovalFlow.getApprovalItemId());
						// info.setApprovalModule(sysApprovalFlow.getModule());
						info.setCreateDate(sysApprovalFlow.getCreateDate());
						info.setNextRoleId(sysApprovalFlow.getNextRoleId());
						info.setProcessIndex(sysApprovalProcess.getProcessIndex());
						info.setRemark(sysApprovalFlow.getRemark());
						info.setState(sysApprovalFlow.getState());
						Map<String, Object> userMap = getPrivUser(request,sysApprovalFlow.getUserId());
						if (!(boolean) userMap.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.APPROVAL_CANCEL_FAILED, "获取当前用户信息异常");
						}
						PrivUser user = (PrivUser) userMap.get("data");
						info.setUser(user);
					}
				}
				Map<String, Object> userMap = getPrivRole(request,sysApprovalProcess.getRoleId());
				if (!(boolean) userMap.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.APPROVAL_CANCEL_FAILED, "获取当前用户信息异常");
				}
				PrivRole role = (PrivRole) userMap.get("data");
				info.setPrivRole(role);
				info.setApprovalProcessId(sysApprovalProcess.getApprovalProcessId());
				
				
				// info.set
				infoList.add(info);
			}
//			List<SysApprovalInfo> list = sysService.getApprovalInfoByApprovalItemId(id,module);
//			List<SysApprovalInfo> infoList = new ArrayList<>();
//			for (SysApprovalInfo sysApprovalInfo : list) {
//				
//				Map<String, Object> result =getPrivUser(request,sysApprovalInfo.getUserId());
//				if (!(boolean) result.get("isSuccess")) {
//					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取用户信息异常，" + result.get("msg"));
//				}
//				PrivUser user = (PrivUser)result.get("data");
//				sysApprovalInfo.setUser(user);
//				infoList.add(sysApprovalInfo);
//			}
			return AjaxResult.createSuccessResult(infoList);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询流程进程信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
}
