package com.maigangle.gyl.service.mapper;

import com.maigangle.gyl.facade.entity.FeeInvoiceDetail;
import com.maigangle.gyl.facade.entity.FeeInvoiceDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeInvoiceDetailMapper {
    int deleteByPrimaryKey(String invoiceDetailId);

    int insert(FeeInvoiceDetail record);

    int insertSelective(FeeInvoiceDetail record);

    List<FeeInvoiceDetail> selectByExample(FeeInvoiceDetailExample example);

    FeeInvoiceDetail selectByPrimaryKey(String invoiceDetailId);

    int updateByExampleSelective(@Param("record") FeeInvoiceDetail record, @Param("example") FeeInvoiceDetailExample example);

    int updateByExample(@Param("record") FeeInvoiceDetail record, @Param("example") FeeInvoiceDetailExample example);

    int updateByPrimaryKeySelective(FeeInvoiceDetail record);

    int updateByPrimaryKey(FeeInvoiceDetail record);
}