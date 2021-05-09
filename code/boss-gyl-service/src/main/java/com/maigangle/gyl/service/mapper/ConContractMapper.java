package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.ConContractExample;
import com.maigangle.gyl.facade.entity.dto.OverdueDto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConContractMapper {
    int deleteByPrimaryKey(String contractId);

    int insert(ConContract record);

    int insertSelective(ConContract record);

    List<ConContract> selectByExample(ConContractExample example);

    ConContract selectByPrimaryKey(String contractId);

    int updateByExampleSelective(@Param("record") ConContract record, @Param("example") ConContractExample example);

    int updateByExample(@Param("record") ConContract record, @Param("example") ConContractExample example);

    int updateByPrimaryKeySelective(ConContract record);

    int updateByPrimaryKey(ConContract record);
    
}