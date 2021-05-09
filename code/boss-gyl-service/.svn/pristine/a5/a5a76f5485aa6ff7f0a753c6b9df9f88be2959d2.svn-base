package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.ConFeeRates;
import com.maigangle.gyl.facade.entity.ConFeeRatesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConFeeRatesMapper {
    int deleteByPrimaryKey(String feeRatesId);

    int insert(ConFeeRates record);

    int insertSelective(ConFeeRates record);

    List<ConFeeRates> selectByExample(ConFeeRatesExample example);

    ConFeeRates selectByPrimaryKey(String feeRatesId);

    int updateByExampleSelective(@Param("record") ConFeeRates record, @Param("example") ConFeeRatesExample example);

    int updateByExample(@Param("record") ConFeeRates record, @Param("example") ConFeeRatesExample example);

    int updateByPrimaryKeySelective(ConFeeRates record);

    int updateByPrimaryKey(ConFeeRates record);
}