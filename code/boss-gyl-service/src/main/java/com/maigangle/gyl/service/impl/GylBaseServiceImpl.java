package com.maigangle.gyl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.AttachExample;
import com.maigangle.gyl.facade.entity.GridConfig;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.GylBaseService;
import com.maigangle.gyl.service.mapper.AttachMapper;
import com.maigangle.gyl.service.mapper.GridConfigMapper;

/**
 * 系统基本配置Service实现类
 * @author 张渊
 * @since 2017年12月5日 下午1:50:56
 * @version 1.0
 */
@Service
@Transactional
public class GylBaseServiceImpl implements GylBaseService {
	@Autowired
	GridConfigMapper gridConfigMapper;
	@Autowired
	AttachMapper attachMapper;
	@Override
	public int addGridConfig(GridConfig gridConfig, PrivUser user) throws Exception {
		if (gridConfig != null
				&& !StringUtils.isEmpty(gridConfig.getGridCode())
				&& user != null) {
			gridConfig.setUserId(user.getUserId());
			return gridConfigMapper.insertSelective(gridConfig);
		} else {
			throw new Exception("部分非空数据为空");
		}
	}

	@Override
	public int updateGridConfig(GridConfig gridConfig) throws Exception {
		if (StringUtils.isEmpty(gridConfig.getGridId())){
			throw new Exception("ID不能为空");
		}
		return gridConfigMapper.updateByPrimaryKeySelective(gridConfig);
	}

	@Override
	public GridConfig getGridConfigById(String gridConfigId) {
		if (StringUtils.isEmpty(gridConfigId)){
			return null;
		}
		return gridConfigMapper.selectByPrimaryKey(gridConfigId);
	}

	@Override
	public GridConfig getGridConfigByCode(String code, PrivUser user) {
		if (StringUtils.isEmpty(code)){
			return null;
		}
		return gridConfigMapper.selectByCode(code, user.getUserId());
	}

	@Override
	public Attach addAttach(Attach attach) {
		if (attach == null){
			return null;
		}
		Boolean flag = StringUtils.isEmpty(attach.getFileCategory()) || StringUtils.isEmpty(attach.getRelationId());
		if(flag){
			return null;
		}
		int a = attachMapper.insertSelective(attach);
		if (a != 1){
			return null;
		}
		return attach;
	}

	@Override
	public Attach updateAttach(Attach attach) {
		if (attach == null){
			return null;
		}
		if (StringUtils.isEmpty(attach.getAttachId())){
			return null;
		}
		int a = attachMapper.updateByPrimaryKeySelective(attach);
		if (a !=1){
			return null;
		}
		return attach;
	}

	@Override
	public List<Attach> getAttach(String id) {
		if (StringUtils.isEmpty(id)){
			return null;
		}
		AttachExample example = new AttachExample();
		AttachExample.Criteria c = example.createCriteria();
		c.andRelationIdEqualTo(id);
		List<Attach> list = attachMapper.selectByExample(example);
		return list;
	}

	@Override
	public Attach getAttachById(String id) {
		if (StringUtils.isEmpty(id)){
			return null;
		}
		return attachMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteAttach(String id) {
		if (StringUtils.isEmpty(id)){
			return -1;
		}
		Attach attach = new Attach();
		attach.setAttachId(id);
		attach.setIsDel(YesOrNoEnum.YES.toString());
		attach = updateAttach(attach);
		if (attach == null){
			return -1;
		}
		return 1;
	}

	@Override
	public List<Attach> getAttachByIdAndType(String id, String type) {
		if (StringUtils.isEmpty(type)|| StringUtils.isEmpty(id)){
			return null;
		}
		List<Attach> list = getAttach(id);
		List<Attach> typeList = new ArrayList<Attach>();
		for (Attach attach : list) {
			if (type.equals(attach.getFileCategory())){
				typeList.add(attach);
			}
		}
		return typeList;
	}

}
