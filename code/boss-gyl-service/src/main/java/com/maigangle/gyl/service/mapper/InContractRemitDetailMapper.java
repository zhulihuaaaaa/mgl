package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InContractRemitDetail;
import com.maigangle.gyl.facade.entity.InContractRemitDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InContractRemitDetailMapper {
    int deleteByPrimaryKey(String contractRemitDetiailId);

    int insert(InContractRemitDetail record);

    int insertSelective(InContractRemitDetail record);

    List<InContractRemitDetail> selectByExample(InContractRemitDetailExample example);

    InContractRemitDetail selectByPrimaryKey(String contractRemitDetiailId);

    int updateByExampleSelective(@Param("record") InContractRemitDetail record, @Param("example") InContractRemitDetailExample example);

    int updateByExample(@Param("record") InContractRemitDetail record, @Param("example") InContractRemitDetailExample example);

    int updateByPrimaryKeySelective(InContractRemitDetail record);

    int updateByPrimaryKey(InContractRemitDetail record);
}