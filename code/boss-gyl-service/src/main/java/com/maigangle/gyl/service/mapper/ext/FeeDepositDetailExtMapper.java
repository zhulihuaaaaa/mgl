package com.maigangle.gyl.service.mapper.ext;

import java.util.List;

import com.maigangle.gyl.facade.entity.FeeDepositDetailExample;
import com.maigangle.gyl.facade.entity.vo.FeeDepositDetailVo;

public interface FeeDepositDetailExtMapper {

    List<FeeDepositDetailVo> selectByExample(FeeDepositDetailExample example);

    FeeDepositDetailVo selectByPrimaryKey(String depositDetailId);

}