package com.maigangle.gyl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maigangle.gyl.facade.entity.SysApprovalModule;
import com.maigangle.gyl.facade.entity.SysApprovalModuleExample;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.ApproveService;
import com.maigangle.gyl.service.mapper.SysApprovalModuleMapper;
import com.maigangle.gyl.service.mapper.ext.SysApprovalFlowExtMapper;

public class ApproveServiceImpl implements  ApproveService{
	@Autowired
	private SysApprovalFlowExtMapper sysApprovalFlowExtMapper;
	@Autowired
	private SysApprovalModuleMapper sysApprovalModuleMapper;
	
	@Override
	public List<String> selectModelName() {
		return sysApprovalFlowExtMapper.selectModuleName();
	}

	@Override
	public int delectApproveModel(String modelName) {
		return sysApprovalFlowExtMapper.delectModel(modelName);
	}

	@Override
	public List<SysApprovalModule> selectAllModelName() {
		SysApprovalModuleExample example = new SysApprovalModuleExample();
		SysApprovalModuleExample.Criteria  c = example.createCriteria();
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		return sysApprovalModuleMapper.selectByExample(example);
	}
	
}
