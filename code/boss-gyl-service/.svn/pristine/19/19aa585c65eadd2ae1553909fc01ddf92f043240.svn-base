package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedRedeemBillMapper {
    int deleteByPrimaryKey(String redeemBillId);

    int insert(RedRedeemBill record);

    int insertSelective(RedRedeemBill record);

    List<RedRedeemBill> selectByExample(RedRedeemBillExample example);

    RedRedeemBill selectByPrimaryKey(String redeemBillId);

    int updateByExampleSelective(@Param("record") RedRedeemBill record, @Param("example") RedRedeemBillExample example);

    int updateByExample(@Param("record") RedRedeemBill record, @Param("example") RedRedeemBillExample example);

    int updateByPrimaryKeySelective(RedRedeemBill record);

    int updateByPrimaryKey(RedRedeemBill record);
}