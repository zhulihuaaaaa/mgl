package com.maigangle.gyl.service.mapper.ext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.maigangle.gyl.facade.entity.FeeFinalReport;
import com.maigangle.gyl.facade.entity.FeeFinalReportExample;
import com.maigangle.gyl.facade.entity.dto.FeeFinalReportDto;
import com.maigangle.gyl.facade.entity.vo.FeeFinalReportVo;

public interface FeeFinalReportExtMapper {
    int deleteByPrimaryKey(String feeFinalReportId);

    int insert(FeeFinalReport record);

    int insertSelective(FeeFinalReport record);

    List<FeeFinalReportVo> selectByExample(FeeFinalReportExample example);

    FeeFinalReport selectByPrimaryKey(String feeFinalReportId);

    int updateByExampleSelective(@Param("record") FeeFinalReport record, @Param("example") FeeFinalReportExample example);

    int updateByExample(@Param("record") FeeFinalReport record, @Param("example") FeeFinalReportExample example);

    int updateByPrimaryKeySelective(FeeFinalReport record);

    int updateByPrimaryKey(FeeFinalReport record);
    
    Map<String, BigDecimal> getInvoiceGoodsInForReport(@Param("dto") FeeFinalReportDto dto);
    
    Map<String, BigDecimal> getInvoiceGoodsOutForReport(@Param("dto") FeeFinalReportDto dto);

}