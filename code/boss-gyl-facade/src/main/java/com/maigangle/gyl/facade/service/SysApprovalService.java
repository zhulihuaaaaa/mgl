package com.maigangle.gyl.facade.service;

import com.maigangle.gyl.facade.entity.SysApprovalFlow;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.SysApprovalInfo;

/**
 * 审批流程处理Service
 * @author 张渊
 * @since 2017年12月15日 下午5:08:18
 * @version 1.0
 */
public interface SysApprovalService {
	/**
	 * 提交审批项
	 * @param approvalItemId 审批项ID
	 * @param module 模块
	 */
	public boolean submit(String approvalItemId, String module, PrivUser user);
	/**
	 * 放弃提交
	 * @param approvalItemId 审批项ID
	 * @return boolean
	 */
	public boolean abandonSubmit(String approvalItemId, PrivUser user);
	/**
	 * 审核（同意）
	 * @param approvalItemId 审批项ID
	 * @param remark 备注
	 */
	public boolean approval(SysApprovalFlow  sysFlow, String remark, PrivUser user);
	/**
	 * 拒绝
	 * @param approvalItemId 审批项ID
	 * @param remark 备注
	 */
	public boolean reject(SysApprovalInfo flow, String remark, PrivUser user);
	/**
	 * 撤销审批或拒绝
	 * @param approvalItemId
	 */
	public boolean abandon(String approvalItemId, PrivUser user);
	/**
	 * 作废
	 * @param approvalItemId
	 */
	public boolean cancel(String approvalItemId, PrivUser user);
}
