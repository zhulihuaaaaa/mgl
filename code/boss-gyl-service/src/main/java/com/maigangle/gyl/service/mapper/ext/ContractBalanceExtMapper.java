package com.maigangle.gyl.service.mapper.ext;

import java.util.List;

import com.maigangle.gyl.facade.entity.FeeContractBalanceExample;
import com.maigangle.gyl.facade.entity.vo.ContractBalanceVo;

public interface ContractBalanceExtMapper {

    List<ContractBalanceVo> selectByExample(FeeContractBalanceExample example);

}