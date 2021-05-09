package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InsInspectionSub;
import com.maigangle.gyl.facade.entity.InsInspectionSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsInspectionSubMapper {
    int deleteByPrimaryKey(String inspectionSubId);

    int insert(InsInspectionSub record);

    int insertSelective(InsInspectionSub record);

    List<InsInspectionSub> selectByExample(InsInspectionSubExample example);

    InsInspectionSub selectByPrimaryKey(String inspectionSubId);

    int updateByExampleSelective(@Param("record") InsInspectionSub record, @Param("example") InsInspectionSubExample example);

    int updateByExample(@Param("record") InsInspectionSub record, @Param("example") InsInspectionSubExample example);

    int updateByPrimaryKeySelective(InsInspectionSub record);

    int updateByPrimaryKey(InsInspectionSub record);
}