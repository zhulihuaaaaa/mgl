package com.maigangle.gyl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.maigangle.gyl.facade.entity.SysApprovalFlow;
import com.maigangle.gyl.facade.entity.SysApprovalFlowExample;
import com.maigangle.gyl.facade.entity.SysApprovalModule;
import com.maigangle.gyl.facade.entity.SysApprovalModuleExample;
import com.maigangle.gyl.facade.entity.SysApprovalProcess;
import com.maigangle.gyl.facade.entity.SysApprovalProcessExample;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.SysApprovalInfo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.SysService;
import com.maigangle.gyl.service.mapper.SysApprovalFlowMapper;
import com.maigangle.gyl.service.mapper.SysApprovalModuleMapper;
import com.maigangle.gyl.service.mapper.SysApprovalProcessMapper;
import com.maigangle.gyl.service.mapper.ext.SysApprovalFlowExtMapper;

/**
 * 系统设置
 * @author 张渊
 * @since 2017年12月20日 下午2:28:10
 * @version 1.0
 */
@Service
public class SysServiceImpl implements SysService {
	@Autowired
	SysApprovalProcessMapper processMapper;
	@Autowired
	SysApprovalFlowMapper flowMapper;
	@Autowired
	SysApprovalFlowExtMapper flowExtMapper;
	@Autowired
	SysApprovalModuleMapper moduleMapper;
	@Autowired
	SysService sysService;
	@Override
	public SysApprovalProcess addApprovalProcess(SysApprovalProcess approvalProcess) {
		approvalProcess.setUpdateTime(new Date());
		processMapper.insertSelective(approvalProcess);
		if (!StringUtils.isEmpty(approvalProcess.getApprovalProcessId())) {
			return approvalProcess;
		}
		return null;
	}

	@Override
	public SysApprovalProcess updateApprovalProcess(SysApprovalProcess approvalProcess) {
		approvalProcess.setUpdateTime(new Date());
		int row = processMapper.updateByPrimaryKeySelective(approvalProcess);
		if (row > 0) {
			return approvalProcess;
		}
		return null;
	}

	@Override
	public int deleteApprovalProcess(String approvalProcessId) {
		if (StringUtils.isEmpty(approvalProcessId)) {
			return 0;
		}
		SysApprovalProcess process = new SysApprovalProcess();
		process.setApprovalProcessId(approvalProcessId);
		process.setIsDel(YesOrNoEnum.YES.toString());
		return processMapper.updateByPrimaryKeySelective(process);
	}

	@Override
	public List<SysApprovalProcess> getApprovalProcesss(SysApprovalProcess approvalProcess) {
		
		SysApprovalProcessExample example = getProcessCriteria(approvalProcess);
		return processMapper.selectByExample(example);
	}

	@Override
	public SysApprovalProcess getApprovalProcessById(String approvalProcessId) {
		if (StringUtils.isEmpty(approvalProcessId))
			return null;
		return processMapper.selectByPrimaryKey(approvalProcessId);
	}

	@Override
	public SysApprovalFlow addApprovalFlow(SysApprovalFlow approvalFlow) {
		//创建时间
		approvalFlow.setCreateDate(new Date());
		int row = flowMapper.insertSelective(approvalFlow);
		if (row > 0 && !StringUtils.isEmpty(approvalFlow.getApprovalFlowId())) {
			return approvalFlow;
		}
		return null;
	}

	@Override
	public SysApprovalFlow updateApprovalFlow(SysApprovalFlow approvalFlow) {
		int row = flowMapper.updateByPrimaryKeySelective(approvalFlow);
		if (row > 0) {
			return approvalFlow;
		}
		return null;
	}

	@Override
	public int deleteApprovalFlow(String approvalFlowId) {
		if (StringUtils.isEmpty(approvalFlowId)) {
			return 0;
		}
		SysApprovalFlow flow = new SysApprovalFlow();
		flow.setApprovalFlowId(approvalFlowId);
		flow.setIsDel(YesOrNoEnum.YES.toString());
		return flowMapper.updateByPrimaryKeySelective(flow);
	}
	@Override
	public List<SysApprovalFlow> getApprovalFlows(SysApprovalFlow approvalFlow) {
		SysApprovalFlowExample example = getFlowCriteria(approvalFlow);
		return flowMapper.selectByExample(example);
	}

	@Override
	public SysApprovalFlow getApprovalFlowById(String approvalFlowId) {
		if (StringUtils.isEmpty(approvalFlowId))
			return null;
		return flowMapper.selectByPrimaryKey(approvalFlowId);
	}

	@Override
	public SysApprovalInfo getLastApprovalInfoByApprovalItemId(String approvalItemId, PrivUser user) {
		SysApprovalInfo approvalInfo = null;
		if (!StringUtils.isEmpty(approvalItemId)) {
			approvalInfo = flowExtMapper.selectLastByApprovalItemId(approvalItemId);
			if (approvalInfo != null && user != null) {
				// 查询出所有的流程
				SysApprovalProcess processSearch = new SysApprovalProcess();
				processSearch.setModule(approvalInfo.getModule());
				List<SysApprovalProcess> processList = sysService.getApprovalProcesss(processSearch);
				// 不是最后一个
				Boolean isLast = true;
				if(!processList.isEmpty()) {
					isLast = !(processList.get(processList.size()-1).getApprovalProcessId().equals(approvalInfo.getApprovalProcessId()));					
				}
				if (user.getUserId().equals(approvalInfo.getUserId())&&isLast) {
					approvalInfo.setCanRevoke(true);
				} else {
					// TODO 根据当前用户角色判断是否为nextRole，如果是，则canApproval=true
					//if(approvalInfo.getNextRoleId().equals(user.getPrivRole().getRoleId())&&(ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(approvalInfo.getState())||StringUtils.isEmpty(approvalInfo.getApprovalProcessId()))) {
					if(approvalInfo.getNextRoleId()!=null&&approvalInfo.getNextRoleId().equals(user.getPrivRole().getRoleId())&&(ApprovalStateEnum.APPROVAL_UNDERWAY.getState().equals(approvalInfo.getState())||StringUtils.isEmpty(approvalInfo.getApprovalProcessId()))) {
						approvalInfo.setCanApproval(true);
					}
				}
				// 判断最后一个 显示审批
				if(!isLast&&ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(approvalInfo.getState())) {
					approvalInfo.setCanApproval(false);
				}
				
			}
		}
		return approvalInfo;
	}
	public List<SysApprovalInfo> getApprovalInfoByApprovalItemId(String approvalItemId,String module) {
		if (!StringUtils.isEmpty(approvalItemId)) {
			return flowExtMapper.selectByApprovalItemId(approvalItemId,module);
		}
		return null;
	}
	@Override
	public SysApprovalModule addApprovalModule(SysApprovalModule approvalModule) {
		approvalModule = moduleMapper.insertSelective(approvalModule);
		if (!StringUtils.isEmpty(approvalModule.getApprovalModuleId())) {
			return approvalModule;
		}
		return null;
	}

	@Override
	public SysApprovalModule updateApprovalModule(SysApprovalModule approvalModule) {
		int row = moduleMapper.updateByPrimaryKeySelective(approvalModule);
		if (row > 0) {
			return approvalModule;
		}
		return null;
	}

	@Override
	public int deleteApprovalModule(String approvalModuleId) {
		if (StringUtils.isEmpty(approvalModuleId)) {
			return 0;
		}
		SysApprovalModule process = new SysApprovalModule();
		process.setApprovalModuleId(approvalModuleId);
		process.setIsDel(YesOrNoEnum.YES.toString());
		return moduleMapper.updateByPrimaryKeySelective(process);
	}

	@Override
	public List<SysApprovalModule> getApprovalModules(SysApprovalModule approvalModule) {
		SysApprovalModuleExample example = getModuleCriteria(approvalModule);
		return moduleMapper.selectByExample(example);
	}

	@Override
	public SysApprovalModule getApprovalModuleById(String approvalModuleId) {
		if (!StringUtils.isEmpty(approvalModuleId)) {
			return moduleMapper.selectByPrimaryKey(approvalModuleId);
		}
		return null;
	}
	
	/**
	 * 获取审批流程查询条件
	 * @param process
	 * @return
	 */
	private SysApprovalProcessExample getProcessCriteria(SysApprovalProcess process) {
		SysApprovalProcessExample example = new SysApprovalProcessExample();
		example.setOrderByClause("PROCESS_INDEX asc");
		if (process != null) {
			SysApprovalProcessExample.Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(process.getApprovalProcessId())) {
				criteria.andApprovalProcessIdEqualTo(process.getApprovalProcessId());
			}
			if (!StringUtils.isEmpty(process.getModule())) {
				criteria.andModuleEqualTo(process.getModule());
			}
			if (!StringUtils.isEmpty(process.getRoleId())) {
				criteria.andRoleIdEqualTo(process.getRoleId());
			}
			criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
			
		}
		return example;
	}
	/**
	 * 获取审批进程查询条件
	 * @param flow
	 * @return
	 */
	private SysApprovalFlowExample getFlowCriteria(SysApprovalFlow flow) {
		SysApprovalFlowExample example = new SysApprovalFlowExample();
		if (flow != null) {
			SysApprovalFlowExample.Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(flow.getApprovalFlowId())) {
				criteria.andApprovalFlowIdEqualTo(flow.getApprovalFlowId());
			}
			if (!StringUtils.isEmpty(flow.getApprovalItemId())) {
				criteria.andApprovalItemIdEqualTo(flow.getApprovalItemId());
			}
			if (!StringUtils.isEmpty(flow.getUserId())) {
				criteria.andUserIdEqualTo(flow.getUserId());
			}
			if (!StringUtils.isEmpty(flow.getState())) {
				criteria.andStateEqualTo(flow.getState());
			}
			if (!StringUtils.isEmpty(flow.getNextRoleId())) {
				criteria.andNextRoleIdEqualTo(flow.getNextRoleId());
			}
			if (!StringUtils.isEmpty(flow.getApprovalProcessId())) {
				criteria.andApprovalProcessIdEqualTo(flow.getApprovalProcessId());
			}
			if (!StringUtils.isEmpty(flow.getModule())) {
				criteria.andModuleEqualTo(flow.getModule());
			}
			criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		}
		return example;
	}
	/**
	 * 获取审批模块查询条件
	 * @param flow
	 * @return
	 */
	private SysApprovalModuleExample getModuleCriteria(SysApprovalModule module) {
		SysApprovalModuleExample example = new SysApprovalModuleExample();
		if (module != null) {
			SysApprovalModuleExample.Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(module.getApprovalModuleId())) {
				criteria.andApprovalModuleIdEqualTo(module.getApprovalModuleId());
			}
			if (!StringUtils.isEmpty(module.getModuleName())) {
				criteria.andModuleNameEqualTo(module.getModuleName());
			}
			if (!StringUtils.isEmpty(module.getModuleAlias())) {
				criteria.andModuleAliasEqualTo(module.getModuleAlias());
			}
			criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		}
		return example;
	}
	
}
