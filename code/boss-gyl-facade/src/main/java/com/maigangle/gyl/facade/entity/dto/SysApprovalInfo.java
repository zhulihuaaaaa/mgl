package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.SysApprovalModule;
import com.maigangle.gyl.facade.entity.api.PrivRole;
/**
 * 审批进程
 * @author 张渊
 * @since 2017年12月21日 上午11:46:59
 * @version 1.0
 */
import com.maigangle.gyl.facade.entity.api.PrivUser;
public class SysApprovalInfo implements Serializable {
	private static final long serialVersionUID = -5223029650875962L;
	/**
	 * ID
	 */
	private String approvalFlowId;
	/**
	 * 审批项ID
	 */
    private String approvalItemId;
    /**
     * 审批流程ID
     */
    private String approvalProcessId;
    /**
     * 审批流程信息
     */
    private BigDecimal processIndex;
    /**
     * 模块
     */
    private String module;
    /**
     * 审批模块信息
     */
    private SysApprovalModule approvalModule;
    /**
     * 下一审批角色ID
     */
    private String nextRoleId;
    /**
     * 审批人ID
     */
    private String userId;
    /**
     * 审批人信息
     */
    private PrivUser user;
    /**
     * 审批状态
     */
    private String state;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    private Date createDate;
    /**
     * 是否删除
     */
    private String isDel;
    /**
     * 当前用户是否可以提交
     */
    private boolean canSubmit;
    /**
     * 当前用户是否可以撤销审批
     */
    private boolean canRevoke;
    /**
     * 当前用户是否可以审批
     */
    private boolean canApproval;
    /**
     * 角色信息
     */
    private PrivRole privRole;
    
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

	public boolean isCanSubmit() {
		return canSubmit;
	}

	public void setCanSubmit(boolean canSubmit) {
		this.canSubmit = canSubmit;
	}

	public boolean isCanRevoke() {
		return canRevoke;
	}

	public void setCanRevoke(boolean canRevoke) {
		this.canRevoke = canRevoke;
	}

	public boolean isCanApproval() {
		return canApproval;
	}

	public void setCanApproval(boolean canApproval) {
		this.canApproval = canApproval;
	}

	public BigDecimal getProcessIndex() {
		return processIndex;
	}

	public void setProcessIndex(BigDecimal processIndex) {
		this.processIndex = processIndex;
	}

	public SysApprovalModule getApprovalModule() {
		return approvalModule;
	}

	public void setApprovalModule(SysApprovalModule approvalModule) {
		this.approvalModule = approvalModule;
	}

	public PrivUser getUser() {
		return user;
	}

	public void setUser(PrivUser user) {
		this.user = user;
	}

	public PrivRole getPrivRole() {
		return privRole;
	}

	public void setPrivRole(PrivRole privRole) {
		this.privRole = privRole;
	}
    
}