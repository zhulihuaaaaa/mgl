package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.OutOutstockBill;
import com.maigangle.gyl.facade.entity.OutOutstockBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutOutstockBillMapper {
    int deleteByPrimaryKey(String outstockBillId);

    int insert(OutOutstockBill record);

    int insertSelective(OutOutstockBill record);

    List<OutOutstockBill> selectByExample(OutOutstockBillExample example);

    OutOutstockBill selectByPrimaryKey(String outstockBillId);

    int updateByExampleSelective(@Param("record") OutOutstockBill record, @Param("example") OutOutstockBillExample example);

    int updateByExample(@Param("record") OutOutstockBill record, @Param("example") OutOutstockBillExample example);

    int updateByPrimaryKeySelective(OutOutstockBill record);

    int updateByPrimaryKey(OutOutstockBill record);
}