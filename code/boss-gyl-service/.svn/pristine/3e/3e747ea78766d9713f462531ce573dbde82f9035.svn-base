package com.maigangle.gyl.service.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.dto.InvoiceGoodsConditionDto;
import com.maigangle.gyl.facade.entity.vo.InvoiceGoodsConditionVo;

public interface InsInspectionDetailExtMapper {
	int BathList( @Param("list") List<InsInspectionDetail> list);
	int BathUpdate(@Param(value="list") List<InsInspectionDetail> list);
	List<InvoiceGoodsConditionVo> getInvoiceGoodsIn(@Param("dto") InvoiceGoodsConditionDto dto);
}