package com.maigangle.gyl.service.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maigangle.gyl.facade.entity.FeeInvoiceDetail;

public interface FeeInvoiceExtMapper {
	
    List<FeeInvoiceDetail> selectInvoice(@Param("contractId") String contractId,@Param("invoiceType") String invoiceType);
    
}