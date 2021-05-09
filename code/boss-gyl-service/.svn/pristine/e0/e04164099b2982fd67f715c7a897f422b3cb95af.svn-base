package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeBalance;
import com.maigangle.gyl.facade.entity.FeeBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeBalanceMapper {
    int countByExample(FeeBalanceExample example);

    int deleteByPrimaryKey(String balanceId);

    int insert(FeeBalance record);

    int insertSelective(FeeBalance record);

    List<FeeBalance> selectByExample(FeeBalanceExample example);

    FeeBalance selectByPrimaryKey(String balanceId);

    int updateByExampleSelective(@Param("record") FeeBalance record, @Param("example") FeeBalanceExample example);

    int updateByExample(@Param("record") FeeBalance record, @Param("example") FeeBalanceExample example);

    int updateByPrimaryKeySelective(FeeBalance record);

    int updateByPrimaryKey(FeeBalance record);
}