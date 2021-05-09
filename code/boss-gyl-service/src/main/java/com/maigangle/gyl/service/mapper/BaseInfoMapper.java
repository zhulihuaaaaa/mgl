package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.BaseInfo;
import com.maigangle.gyl.facade.entity.BaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseInfoMapper {
    int deleteByPrimaryKey(String infoId);

    int insert(BaseInfo record);

    int insertSelective(BaseInfo record);

    List<BaseInfo> selectByExample(BaseInfoExample example);

    BaseInfo selectByPrimaryKey(String infoId);

    int updateByExampleSelective(@Param("record") BaseInfo record, @Param("example") BaseInfoExample example);

    int updateByExample(@Param("record") BaseInfo record, @Param("example") BaseInfoExample example);

    int updateByPrimaryKeySelective(BaseInfo record);

    int updateByPrimaryKey(BaseInfo record);
}