package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.ConDepositDetail;
import com.maigangle.gyl.facade.entity.ConDepositDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConDepositDetailMapper {
    int deleteByPrimaryKey(String depositDetailId);

    int insert(ConDepositDetail record);

    int insertSelective(ConDepositDetail record);

    List<ConDepositDetail> selectByExample(ConDepositDetailExample example);

    ConDepositDetail selectByPrimaryKey(String depositDetailId);

    int updateByExampleSelective(@Param("record") ConDepositDetail record, @Param("example") ConDepositDetailExample example);

    int updateByExample(@Param("record") ConDepositDetail record, @Param("example") ConDepositDetailExample example);

    int updateByPrimaryKeySelective(ConDepositDetail record);

    int updateByPrimaryKey(ConDepositDetail record);
}