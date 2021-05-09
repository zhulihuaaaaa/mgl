package com.maigangle.gyl.service.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maigangle.gyl.facade.entity.ConContractDetailExample;
import com.maigangle.gyl.facade.entity.vo.ConContractDetailVo;

public interface ConContractDetaiExtlMapper {

    List<ConContractDetailVo> selectByExample(ConContractDetailExample example);

    ConContractDetailVo selectByPrimaryKey(@Param("contractDetailId") String contractDetailId);
    
    ConContractDetailVo selectByContractId(@Param("contractId") String contractId);

}