package com.maigangle.gyl.facade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 审批流程
 * @author 张渊
 * @since 2017年12月21日 上午11:50:17
 * @version 1.0
 */
public class SysApprovalProcess implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7501545687868944714L;
	/**
	 * 审批流程ID
	 */
	private String approvalProcessId;
	/**
	 * 待审批模块名
	 */
    private String module;
    /**
     * 可审批角色
     */
    private String roleId;
    /**
     * 流程索引
     */
    private BigDecimal processIndex;
    
    private Date updateTime;

    private String isDel;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public BigDecimal getProcessIndex() {
        return processIndex;
    }

    public void setProcessIndex(BigDecimal processIndex) {
        this.processIndex = processIndex;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
}