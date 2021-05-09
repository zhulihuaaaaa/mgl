package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.BaseCost;
import com.maigangle.gyl.facade.entity.BaseCostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCostMapper {
    int deleteByPrimaryKey(String costId);

    int insert(BaseCost record);

    int insertSelective(BaseCost record);

    List<BaseCost> selectByExample(BaseCostExample example);

    BaseCost selectByPrimaryKey(String costId);

    int updateByExampleSelective(@Param("record") BaseCost record, @Param("example") BaseCostExample example);

    int updateByExample(@Param("record") BaseCost record, @Param("example") BaseCostExample example);

    int updateByPrimaryKeySelective(BaseCost record);

    int updateByPrimaryKey(BaseCost record);
}