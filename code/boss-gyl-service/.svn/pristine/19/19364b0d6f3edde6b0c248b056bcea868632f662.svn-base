package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.BaseProcess;
import com.maigangle.gyl.facade.entity.BaseProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(BaseProcess record);

    int insertSelective(BaseProcess record);

    List<BaseProcess> selectByExample(BaseProcessExample example);

    BaseProcess selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") BaseProcess record, @Param("example") BaseProcessExample example);

    int updateByExample(@Param("record") BaseProcess record, @Param("example") BaseProcessExample example);

    int updateByPrimaryKeySelective(BaseProcess record);

    int updateByPrimaryKey(BaseProcess record);
}