package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.ConContractDetail;
import com.maigangle.gyl.facade.entity.ConContractDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConContractDetailMapper {
    int deleteByPrimaryKey(String contractDetailId);

    int insert(ConContractDetail record);

    int insertSelective(ConContractDetail record);

    List<ConContractDetail> selectByExample(ConContractDetailExample example);

    ConContractDetail selectByPrimaryKey(String contractDetailId);

    int updateByExampleSelective(@Param("record") ConContractDetail record, @Param("example") ConContractDetailExample example);

    int updateByExample(@Param("record") ConContractDetail record, @Param("example") ConContractDetailExample example);

    int updateByPrimaryKeySelective(ConContractDetail record);

    int updateByPrimaryKey(ConContractDetail record);
}