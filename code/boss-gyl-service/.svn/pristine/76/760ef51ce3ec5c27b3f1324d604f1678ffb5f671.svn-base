package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeDepositDetail;
import com.maigangle.gyl.facade.entity.FeeDepositDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeDepositDetailMapper {
    int deleteByPrimaryKey(String depositDetailId);

    int insert(FeeDepositDetail record);

    int insertSelective(FeeDepositDetail record);

    List<FeeDepositDetail> selectByExample(FeeDepositDetailExample example);

    FeeDepositDetail selectByPrimaryKey(String depositDetailId);

    int updateByExampleSelective(@Param("record") FeeDepositDetail record, @Param("example") FeeDepositDetailExample example);

    int updateByExample(@Param("record") FeeDepositDetail record, @Param("example") FeeDepositDetailExample example);

    int updateByPrimaryKeySelective(FeeDepositDetail record);

    int updateByPrimaryKey(FeeDepositDetail record);
}