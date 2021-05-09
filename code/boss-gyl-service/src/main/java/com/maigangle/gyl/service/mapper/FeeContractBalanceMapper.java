package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeContractBalance;
import com.maigangle.gyl.facade.entity.FeeContractBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeContractBalanceMapper {
    int deleteByPrimaryKey(String contractBalanceId);

    int insert(FeeContractBalance record);

    int insertSelective(FeeContractBalance record);

    List<FeeContractBalance> selectByExample(FeeContractBalanceExample example);

    FeeContractBalance selectByPrimaryKey(String contractBalanceId);

    int updateByExampleSelective(@Param("record") FeeContractBalance record, @Param("example") FeeContractBalanceExample example);

    int updateByExample(@Param("record") FeeContractBalance record, @Param("example") FeeContractBalanceExample example);

    int updateByPrimaryKeySelective(FeeContractBalance record);

    int updateByPrimaryKey(FeeContractBalance record);
}