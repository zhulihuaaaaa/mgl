package com.maigangle.gyl.service.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import com.maigangle.gyl.facade.entity.SysApprovalFlow;
import com.maigangle.gyl.facade.entity.SysApprovalModule;
import com.maigangle.gyl.facade.entity.SysApprovalProcess;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.SysApprovalInfo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.SysApprovalService;
import com.maigangle.gyl.facade.service.SysService;
import com.maigangle.gyl.service.mapper.ext.SysApprovalFlowExtMapper;
import com.maigangle.gyl.service.util.ApplicationContextUtils;
/**
 * 审批流程处理Service
 * @author 张渊
 * @since 2017年12月21日 上午8:53:17
 * @version 1.0
 */
@Service
public class SysApprovalServiceImpl implements SysApprovalService {
	@Autowired
	SysService sysService;
	@Autowired
	SysApprovalFlowExtMapper flowExtMapper;
	@Autowired
	ContractService contractService;
	@Override
	public boolean submit(String approvalItemId, String module, PrivUser user) {
		SysApprovalFlow flow = new SysApprovalFlow();
		flow.setUserId(user.getUserId());
		flow.setApprovalItemId(approvalItemId);
		flow.setModule(module);
		// 检索该模块对应审批流程
		SysApprovalProcess processSearch = new SysApprovalProcess();
		processSearch.setModule(module);
		List<SysApprovalProcess> processList = sysService.getApprovalProcesss(processSearch);
		// 如果检索到审批流程，则开始审批流程，否则直接审批完成
		if (processList != null && processList.size() > 0) {
			SysApprovalProcess firstProcess = processList.get(0);
			// 如果是流程第一个角色与当前角色相同时  直接审批通过
			if(processList.size()>=1&&firstProcess.getRoleId().equals(user.getPrivRole().getRoleId())) {
				flow.setApprovalProcessId(firstProcess.getApprovalProcessId());
				//flow.setState(ApprovalStateEnum.APPROVAL_COMPLETE.toString());
				flow.setState(ApprovalStateEnum.APPROVAL_UNDERWAY.toString());
				// 第二个流程的角色id
				flow.setNextRoleId(processList.get(1).getRoleId());
			}else {
				// 如果是流程第一个角色与当前角色不同时  直接提交
				flow.setNextRoleId(firstProcess.getRoleId());
				// 未审批
				flow.setState(ApprovalStateEnum.APPROVAL_NOT.toString());
				//flow.setState(ApprovalStateEnum.APPROVAL_UNDERWAY.toString());
			}
		} else {
			flow.setState(ApprovalStateEnum.APPROVAL_COMPLETE.toString());
		}
		flow = sysService.addApprovalFlow(flow);
		if (flow != null && !StringUtils.isEmpty(flow.getApprovalFlowId())) {
			if (ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(flow.getState())) {
				//  回调审批成功事件
				invokeHook(approvalItemId, module, ApprovalStateEnum.APPROVAL_COMPLETE, user);
			}
			// 无流程或者 最后一个流程 时  提交直接 调用 
			if(StringUtils.isEmpty(flow.getNextRoleId())) {
				//  回调直接提交事件 
				invokeHook(approvalItemId, module, ApprovalStateEnum.APPROVAL_NOT, user);
			}else {
				//  第一个流程 到到数第二个流程
				invokeHook(approvalItemId, module, ApprovalStateEnum.APPROVAL_UNDERWAY, user);
			}
			return true;
			
		}
		return false;
	}

	@Override
	public boolean abandonSubmit(String approvalItemId, PrivUser user) {
		if (!StringUtils.isEmpty(approvalItemId)) {
			SysApprovalInfo flow = sysService.getLastApprovalInfoByApprovalItemId(approvalItemId, user);
			if (flow != null && flow.isCanRevoke()
					&& ApprovalStateEnum.APPROVAL_NOT.getState().equals(flow.getState())) {
				boolean canAbandon = true;
				// TODO
				if (ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(flow.getState())) {
					//  调用回调函数，根据执行结果判定是否能撤销  
					
				}
				if (canAbandon) {
					int row = sysService.deleteApprovalFlow(flow.getApprovalFlowId());
					if (row > 0) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	@Override
	public boolean approval(SysApprovalFlow  sysFlow, String remark, PrivUser user) {
		/*
		 *  1.判断当前用户是否可以审批
		 *  2.获取下一个审批流程
		 *  3.获取下下个审批流程，如果有的话，保存审批进程，及下一个审批角色
		 *  4.如果没有的话，审批全部完成，保存审批进程，回调审批完成方法
		 */
		String approvalItemId = sysFlow.getApprovalItemId();
		// 获取最新一条审批进程 
		SysApprovalInfo  approvalInfo = flowExtMapper.selectLastByApprovalItemId(approvalItemId);
		String module = approvalInfo.getModule();
		// 当前 用户角色id
		String userRoleId = user.getPrivRole().getRoleId();
		// 当前 下一个角色id
		String nextRoleId = approvalInfo.getNextRoleId();
		// 1.判断当前用户是否可以审批
		if(!userRoleId.equals(approvalInfo.getNextRoleId())) {
			// 不可以审批
			return false;
		}
		// 判断之前的流程是审核通过的 
		if(!ApprovalStateEnum.APPROVAL_UNDERWAY.toString().equals(approvalInfo.getState())&&!StringUtils.isEmpty(approvalInfo.getApprovalProcessId())) {
			// 不可以审核通过
			return false;
		}
		
		//查询出该模块下的审批流程
		SysApprovalProcess processSearch = new SysApprovalProcess();
		processSearch.setModule(module);
		// 根据 processIndex 排完序
		List<SysApprovalProcess> processList = sysService.getApprovalProcesss(processSearch);
		if(processList==null||processList.isEmpty()) {
			// 没有审批流程
			return false;
		}
		// 获取当前审批流程
		 SysApprovalProcess process = null;
		for (SysApprovalProcess sysApprovalProcess : processList) {
			String processRoleId = sysApprovalProcess.getRoleId();
			if(userRoleId.equals(processRoleId)) {
				process = sysApprovalProcess;
				break;
			}
		}
		// 保存审批流程
		SysApprovalFlow flow = new SysApprovalFlow();
		flow.setApprovalItemId(approvalItemId);
		flow.setApprovalProcessId(process.getApprovalProcessId());
		flow.setModule(module);
		flow.setUserId(user.getUserId());
		if(processList.get(processList.size()-1)== process&&ApprovalStateEnum.APPROVAL_UNDERWAY.toString().equals(sysFlow.getState())) {
			flow.setState(ApprovalStateEnum.APPROVAL_COMPLETE.toString());
		}else {
			flow.setState(sysFlow.getState());
		}
		flow.setRemark(remark);
		// 如果检索到审批流程，则开始审批流程，否则直接审批完成
		if (processList != null && processList.size() > 0) {
			//flow.setState(ApprovalStateEnum.APPROVAL_NOT.toString());
			// 获取下个流程坐标
			int index = process == processList.get(processList.size()-1)? processList.size()-1:processList.indexOf(process)+1;
			SysApprovalProcess p = processList.get(index);
			flow.setNextRoleId(p.getRoleId());
//			// 
//			if(approvalInfo.getApprovalProcessId().equals(p.getApprovalProcessId())) {
//				return false;
//			}
		} else {
			flow.setState(ApprovalStateEnum.APPROVAL_UNDERWAY.toString());
		}
		flow = sysService.addApprovalFlow(flow);
		// // 如果是process 是最后一个审批 .如果没有的话，审批全部完成，保存审批进程，回调审批完成方法
		if(processList.get(processList.size()-1)== process&&flow!= null) {
			if (!StringUtils.isEmpty(flow.getApprovalFlowId())) {
				if (ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(flow.getState())) {
					// 最后一个审批成功时 回调审批成功事件
					invokeHook(approvalItemId, module, ApprovalStateEnum.APPROVAL_COMPLETE, user);
				}
				return true;
			}
		}else {
			// 其他流程除最后一个以外的流程
			if(ApprovalStateEnum.APPROVAL_SUSPEND.toString().equals(sysFlow.getState())) {
				return invokeHook(approvalItemId, module, ApprovalStateEnum.APPROVAL_SUSPEND, user);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean reject(SysApprovalInfo flow, String remark, PrivUser user) {
		return true;
	}

	@Override
	public boolean abandon(String approvalItemId, PrivUser user) {
		if (!StringUtils.isEmpty(approvalItemId)) {
			SysApprovalInfo flow = sysService.getLastApprovalInfoByApprovalItemId(approvalItemId, user);
			String module = flow.getModule();
			if (flow != null && flow.isCanRevoke()
					&& (ApprovalStateEnum.APPROVAL_UNDERWAY.getState().equals(flow.getState())||ApprovalStateEnum.APPROVAL_SUSPEND.getState().equals(flow.getState()))) {
				boolean canAbandon = true;
				////  调用回调函数，根据执行结果判定是否能撤销
				// 判断是否同一个人提交的 
				if(!flow.getUserId().equals(user.getUserId())) {
					canAbandon = false;
				}
				if (canAbandon) {
					int row = sysService.deleteApprovalFlow(flow.getApprovalFlowId());
					if (row > 0) {
						flow = sysService.getLastApprovalInfoByApprovalItemId(approvalItemId, user);
						if(flow==null) {
							invokeHook(approvalItemId,module, ApprovalStateEnum.ABANDON_APPROVAL, user);	
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean cancel(String approvalItemId, PrivUser user) {
		//  Auto-generated method stub
		return false;
	}
	/**
	 * 调用钩子函数
	 * @param approvalItemId 审批项ID
	 * @param module
	 * @param approvalState
	 * @return
	 */
	private boolean invokeHook(String approvalItemId, String moduleAlias, ApprovalStateEnum state, PrivUser user) {
		SysApprovalModule module = new SysApprovalModule();
		module.setModuleAlias(moduleAlias);
		List<SysApprovalModule> list = sysService.getApprovalModules(module);
		if (list != null && list.size() > 0) {
			module = list.get(0);
			// 如果没有对应Bean，则返回成功
			if (StringUtils.isEmpty(module.getModuleServiceBean())) {
				return true;
			}
			Object bean = ApplicationContextUtils.getBean(module.getModuleServiceBean());
			if (bean == null) {
				return true;
			}
			String methodName = null;
			switch (state) {
				case APPROVAL_COMPLETE:
					// 审批通过回调
					methodName = module.getApprovalCompleteMethod();
					break;
				case APPROVAL_SUSPEND:
					// 审批拒绝回调
					methodName = module.getApprovalSuspendMethod();
					break;
				case APPROVAL_NOT:
					// 不走流程 直接通过的状态回掉回调
					methodName = module.getSubmitMethod();
					break;
				case APPROVAL_UNDERWAY:
					// 
					methodName = module.getApprovalMethod();
					break;
				case ABANDON_APPROVAL:
					// 撤销审批 回调的方法
					methodName = module.getAbandonApprovalMethod();
					break;
				default:
					break;
			}
			if (methodName != null) {
				Method method = ReflectionUtils.findMethod(bean.getClass(), methodName, String.class, PrivUser.class);
				if (method != null) {
					return (boolean) ReflectionUtils.invokeMethod(method, bean, approvalItemId, user);
				}
			}
		}
		return true;
	}
}
