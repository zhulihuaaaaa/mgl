package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.FeeFinanceBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeFinanceBillMapper {
    int deleteByPrimaryKey(String financeBillId);

    int insert(FeeFinanceBill record);

    int insertSelective(FeeFinanceBill record);

    List<FeeFinanceBill> selectByExample(FeeFinanceBillExample example);

    FeeFinanceBill selectByPrimaryKey(String financeBillId);

    int updateByExampleSelective(@Param("record") FeeFinanceBill record, @Param("example") FeeFinanceBillExample example);

    int updateByExample(@Param("record") FeeFinanceBill record, @Param("example") FeeFinanceBillExample example);

    int updateByPrimaryKeySelective(FeeFinanceBill record);

    int updateByPrimaryKey(FeeFinanceBill record);
}