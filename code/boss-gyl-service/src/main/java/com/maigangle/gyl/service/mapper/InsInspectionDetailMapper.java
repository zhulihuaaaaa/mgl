package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InsInspectionDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsInspectionDetailMapper {
    int deleteByPrimaryKey(String inspectionDetailId);

    int insert(InsInspectionDetail record);

    int insertSelective(InsInspectionDetail record);

    List<InsInspectionDetail> selectByExample(InsInspectionDetailExample example);

    InsInspectionDetail selectByPrimaryKey(String inspectionDetailId);

    int updateByExampleSelective(@Param("record") InsInspectionDetail record, @Param("example") InsInspectionDetailExample example);

    int updateByExample(@Param("record") InsInspectionDetail record, @Param("example") InsInspectionDetailExample example);

    int updateByPrimaryKeySelective(InsInspectionDetail record);

    int updateByPrimaryKey(InsInspectionDetail record);
}