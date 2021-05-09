package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.BaseMarker;
import com.maigangle.gyl.facade.entity.BaseMarkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMarkerMapper {
    int deleteByPrimaryKey(String markerId);

    int insert(BaseMarker record);

    int insertSelective(BaseMarker record);

    List<BaseMarker> selectByExample(BaseMarkerExample example);

    BaseMarker selectByPrimaryKey(String markerId);

    int updateByExampleSelective(@Param("record") BaseMarker record, @Param("example") BaseMarkerExample example);

    int updateByExample(@Param("record") BaseMarker record, @Param("example") BaseMarkerExample example);

    int updateByPrimaryKeySelective(BaseMarker record);

    int updateByPrimaryKey(BaseMarker record);
}