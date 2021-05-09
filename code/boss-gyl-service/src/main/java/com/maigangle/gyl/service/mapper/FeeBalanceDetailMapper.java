package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeBalanceDetail;
import com.maigangle.gyl.facade.entity.FeeBalanceDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeBalanceDetailMapper {
    int deleteByPrimaryKey(String balanceDetailId);

    int insert(FeeBalanceDetail record);

    int insertSelective(FeeBalanceDetail record);

    List<FeeBalanceDetail> selectByExample(FeeBalanceDetailExample example);

    FeeBalanceDetail selectByPrimaryKey(String balanceDetailId);

    int updateByExampleSelective(@Param("record") FeeBalanceDetail record, @Param("example") FeeBalanceDetailExample example);

    int updateByExample(@Param("record") FeeBalanceDetail record, @Param("example") FeeBalanceDetailExample example);

    int updateByPrimaryKeySelective(FeeBalanceDetail record);

    int updateByPrimaryKey(FeeBalanceDetail record);
}