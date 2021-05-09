package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsInspectionBillMapper {
    int deleteByPrimaryKey(String inspectionBillId);

    int insert(InsInspectionBill record);

    int insertSelective(InsInspectionBill record);

    List<InsInspectionBill> selectByExample(InsInspectionBillExample example);

    InsInspectionBill selectByPrimaryKey(String inspectionBillId);

    int updateByExampleSelective(@Param("record") InsInspectionBill record, @Param("example") InsInspectionBillExample example);

    int updateByExample(@Param("record") InsInspectionBill record, @Param("example") InsInspectionBillExample example);

    int updateByPrimaryKeySelective(InsInspectionBill record);

    int updateByPrimaryKey(InsInspectionBill record);
}