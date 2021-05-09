package com.maigangle.gyl.service.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maigangle.gyl.facade.entity.BaseCostExample;
import com.maigangle.gyl.facade.entity.vo.BaseCostVo;

public interface BaseCostExtMapper {

    List<BaseCostVo> selectByExample(BaseCostExample example);

    BaseCostVo selectByPrimaryKey(@Param("costId") String costId);
    
}