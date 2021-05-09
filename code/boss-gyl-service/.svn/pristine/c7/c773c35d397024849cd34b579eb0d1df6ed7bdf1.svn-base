package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.BaseMargin;
import com.maigangle.gyl.facade.entity.BaseMarginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMarginMapper {
    int deleteByPrimaryKey(String marginId);

    int insert(BaseMargin record);

    int insertSelective(BaseMargin record);

    List<BaseMargin> selectByExample(BaseMarginExample example);

    BaseMargin selectByPrimaryKey(String marginId);

    int updateByExampleSelective(@Param("record") BaseMargin record, @Param("example") BaseMarginExample example);

    int updateByExample(@Param("record") BaseMargin record, @Param("example") BaseMarginExample example);

    int updateByPrimaryKeySelective(BaseMargin record);

    int updateByPrimaryKey(BaseMargin record);
}