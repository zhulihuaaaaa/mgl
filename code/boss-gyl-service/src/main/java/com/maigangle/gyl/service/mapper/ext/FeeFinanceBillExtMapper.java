package com.maigangle.gyl.service.mapper.ext;

import java.util.List;

import com.maigangle.gyl.facade.entity.FeeFinanceBillExample;
import com.maigangle.gyl.facade.entity.vo.FeeFinanceBillVo;

public interface FeeFinanceBillExtMapper {

    List<FeeFinanceBillVo> selectByExample(FeeFinanceBillExample example);

    FeeFinanceBillVo selectByPrimaryKey(String financeBillId);

}