package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeFinalReport;
import com.maigangle.gyl.facade.entity.FeeFinalReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeFinalReportMapper {
    int deleteByPrimaryKey(String feeFinalReportId);

    int insert(FeeFinalReport record);

    int insertSelective(FeeFinalReport record);

    List<FeeFinalReport> selectByExample(FeeFinalReportExample example);

    FeeFinalReport selectByPrimaryKey(String feeFinalReportId);

    int updateByExampleSelective(@Param("record") FeeFinalReport record, @Param("example") FeeFinalReportExample example);

    int updateByExample(@Param("record") FeeFinalReport record, @Param("example") FeeFinalReportExample example);

    int updateByPrimaryKeySelective(FeeFinalReport record);

    int updateByPrimaryKey(FeeFinalReport record);
}