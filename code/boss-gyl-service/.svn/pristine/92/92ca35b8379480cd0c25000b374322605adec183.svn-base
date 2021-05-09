package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.RedRedeemDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedRedeemDetailMapper {
    int deleteByPrimaryKey(String redeemDetailId);

    int insert(RedRedeemDetail record);

    int insertSelective(RedRedeemDetail record);

    List<RedRedeemDetail> selectByExample(RedRedeemDetailExample example);

    RedRedeemDetail selectByPrimaryKey(String redeemDetailId);

    int updateByExampleSelective(@Param("record") RedRedeemDetail record, @Param("example") RedRedeemDetailExample example);

    int updateByExample(@Param("record") RedRedeemDetail record, @Param("example") RedRedeemDetailExample example);

    int updateByPrimaryKeySelective(RedRedeemDetail record);

    int updateByPrimaryKey(RedRedeemDetail record);
}