package com.maigangle.gyl.facade.service;

import java.util.List;

import com.maigangle.gyl.facade.entity.SysApprovalFlow;
import com.maigangle.gyl.facade.entity.SysApprovalModule;
import com.maigangle.gyl.facade.entity.SysApprovalProcess;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.SysApprovalInfo;

/**
 * 系统设置Service
 * @author 张渊
 * @since 2017年12月15日 下午5:15:04
 * @version 1.0
 */
public interface SysService {
	/*	审批流程设置	*/
	/**
	 * 添加审批流程
	 * @param approvalProcess 审批流程信息
	 * @return
	 */
	public SysApprovalProcess addApprovalProcess(SysApprovalProcess approvalProcess);
	/**
	 * 根据审批流程ID更新审批流程信息
	 * @param approvalProcess 审批流程信息
	 * @return
	 */
	public SysApprovalProcess updateApprovalProcess(SysApprovalProcess approvalProcess);
	/**
	 * 删除审批流程
	 * @param approvalProcessId
	 * @return
	 */
	public int deleteApprovalProcess(String approvalProcessId);
	/**
	 * 根据条件查询审批流程信息
	 * @param approvalProcess 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<SysApprovalProcess> getApprovalProcesss(SysApprovalProcess approvalProcess);
	/**
	 * 根据ID查询审批流程
	 * @param approvalProcessId
	 * @return
	 */
	public SysApprovalProcess getApprovalProcessById(String approvalProcessId);
	
	/*	审批进程设置	*/
	/**
	 * 添加审批进程
	 * @param approvalProcess 审批进程信息
	 * @return
	 */
	public SysApprovalFlow addApprovalFlow(SysApprovalFlow approvalFlow);
	/**
	 * 根据审批进程ID更新审批进程信息
	 * @param approvalFlow 审批进程信息
	 * @return
	 */
	public SysApprovalFlow updateApprovalFlow(SysApprovalFlow approvalFlow);
	/**
	 * 删除审批进程
	 * @param approvalFlowId
	 * @return
	 */
	public int deleteApprovalFlow(String approvalFlowId);
	/**
	 * 根据条件查询审批进程信息
	 * @param approvalFlow 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<SysApprovalFlow> getApprovalFlows(SysApprovalFlow approvalFlow);
	/**
	 * 根据ID查询审批进程
	 * @param approvalFlowId
	 * @return
	 */
	public SysApprovalFlow getApprovalFlowById(String approvalFlowId);
	/**
	 * 根据审批项ID查询最后一条审批进程
	 * @param approvalItemId
	 * @return
	 */
	public SysApprovalInfo getLastApprovalInfoByApprovalItemId(String approvalItemId, PrivUser user);
	/**
	 * 根据审批项目ID获取所有审批进程
	 * @param approvalItemId
	 * @return
	 */
	public List<SysApprovalInfo> getApprovalInfoByApprovalItemId(String approvalItemId,String module);
	
	/*	审批模块设置	*/
	/**
	 * 添加审批模块
	 * @param approvalModule 审批模块信息
	 * @return
	 */
	public SysApprovalModule addApprovalModule(SysApprovalModule approvalModule);
	/**
	 * 根据审批模块ID更新审批模块信息
	 * @param approvalModule 审批模块信息
	 * @return
	 */
	public SysApprovalModule updateApprovalModule(SysApprovalModule approvalModule);
	/**
	 * 删除审批模块
	 * @param approvalModuleId
	 * @return
	 */
	public int deleteApprovalModule(String approvalModuleId);
	/**
	 * 根据条件查询审批模块信息
	 * @param approvalModule 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<SysApprovalModule> getApprovalModules(SysApprovalModule approvalModule);
	/**
	 * 根据ID查询审批模块
	 * @param approvalModuleId
	 * @return
	 */
	public SysApprovalModule getApprovalModuleById(String approvalModuleId);
}
