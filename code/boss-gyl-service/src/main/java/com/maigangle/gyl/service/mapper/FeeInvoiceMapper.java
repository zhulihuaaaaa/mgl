package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeInvoice;
import com.maigangle.gyl.facade.entity.FeeInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeInvoiceMapper {
    int deleteByPrimaryKey(String invoiceId);

    int insert(FeeInvoice record);

    int insertSelective(FeeInvoice record);

    List<FeeInvoice> selectByExample(FeeInvoiceExample example);

    FeeInvoice selectByPrimaryKey(String invoiceId);

    int updateByExampleSelective(@Param("record") FeeInvoice record, @Param("example") FeeInvoiceExample example);

    int updateByExample(@Param("record") FeeInvoice record, @Param("example") FeeInvoiceExample example);

    int updateByPrimaryKeySelective(FeeInvoice record);

    int updateByPrimaryKey(FeeInvoice record);
}