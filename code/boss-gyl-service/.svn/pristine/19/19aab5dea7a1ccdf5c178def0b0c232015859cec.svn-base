package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.OutOutstockDetail;
import com.maigangle.gyl.facade.entity.OutOutstockDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutOutstockDetailMapper {
    int deleteByPrimaryKey(String outstockDetailId);

    int insert(OutOutstockDetail record);

    int insertSelective(OutOutstockDetail record);

    List<OutOutstockDetail> selectByExample(OutOutstockDetailExample example);

    int updateByExampleSelective(@Param("record") OutOutstockDetail record, @Param("example") OutOutstockDetailExample example);

    int updateByExample(@Param("record") OutOutstockDetail record, @Param("example") OutOutstockDetailExample example);

    int updateByPrimaryKey(OutOutstockDetail record);
}