package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 审批进程
 * @author 张渊
 * @since 2017年12月21日 上午11:46:59
 * @version 1.0
 */
public class SysApprovalFlow implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7690511968171718984L;

	private String approvalFlowId;
	/**
	 * 待审批项ID
	 */
    private String approvalItemId;
    /**
     * 对应审批流程ID
     */
    private String approvalProcessId;
    /**
     * 审批模块名
     */
    private String module;
    /**
     * 下一个审批角色ID
     */
    private String nextRoleId;
    /**
     * 审批人ID
     */
    private String userId;
    /**
     * 审批状态
     */
    private String state;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间/审批时间
     */
    private Date createDate;

    private String isDel;

    public String getApprovalFlowId() {
        return approvalFlowId;
    }

    public void setApprovalFlowId(String approvalFlowId) {
        this.approvalFlowId = approvalFlowId == null ? null : approvalFlowId.trim();
    }

    public String getApprovalItemId() {
        return approvalItemId;
    }

    public void setApprovalItemId(String approvalItemId) {
        this.approvalItemId = approvalItemId == null ? null : approvalItemId.trim();
    }

    public String getApprovalProcessId() {
        return approvalProcessId;
    }

    public void setApprovalProcessId(String approvalProcessId) {
        this.approvalProcessId = approvalProcessId == null ? null : approvalProcessId.trim();
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getNextRoleId() {
        return nextRoleId;
    }

    public void setNextRoleId(String nextRoleId) {
        this.nextRoleId = nextRoleId == null ? null : nextRoleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
    
}