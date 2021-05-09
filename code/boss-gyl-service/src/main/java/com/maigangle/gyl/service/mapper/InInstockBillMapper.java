package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.InInstockBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InInstockBillMapper {
    int deleteByPrimaryKey(String instockBillId);

    int insert(InInstockBill record);

    int insertSelective(InInstockBill record);

    List<InInstockBill> selectByExample(InInstockBillExample example);

    InInstockBill selectByPrimaryKey(String instockBillId);

    int updateByExampleSelective(@Param("record") InInstockBill record, @Param("example") InInstockBillExample example);

    int updateByExample(@Param("record") InInstockBill record, @Param("example") InInstockBillExample example);

    int updateByPrimaryKeySelective(InInstockBill record);

    int updateByPrimaryKey(InInstockBill record);
}