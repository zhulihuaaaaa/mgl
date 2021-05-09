package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeDepositAccount;
import com.maigangle.gyl.facade.entity.FeeDepositAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeDepositAccountMapper {
    int deleteByPrimaryKey(String depositAccountId);

    int insert(FeeDepositAccount record);

    int insertSelective(FeeDepositAccount record);

    List<FeeDepositAccount> selectByExample(FeeDepositAccountExample example);

    FeeDepositAccount selectByPrimaryKey(String depositAccountId);

    int updateByExampleSelective(@Param("record") FeeDepositAccount record, @Param("example") FeeDepositAccountExample example);

    int updateByExample(@Param("record") FeeDepositAccount record, @Param("example") FeeDepositAccountExample example);

    int updateByPrimaryKeySelective(FeeDepositAccount record);

    int updateByPrimaryKey(FeeDepositAccount record);
}