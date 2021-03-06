package com.maigangle.gyl.service.mapper.ext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maigangle.gyl.facade.entity.ConContractExample;
import com.maigangle.gyl.facade.entity.dto.OverdueDto;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;

public interface ConContractExtMapper {
	
	/**
	 * 按照合同
	 * @param contractNo
	 * @return
	 */
    int selectByNo(@Param("contractNo") String contractNo);
    
    List<ConContractVo> selectByExample(ConContractExample example);
    
    ConContractVo selectByPrimaryKey(@Param("contractId") String contractId);
    
    List<OverdueDto> selectOverdue(@Param("CONTRACT_ID") String contractId,@Param("CONTRACT_PERIOD") BigDecimal contractPeriod,@Param("OVERDUE") BigDecimal overdue,@Param("SIGNSTARTDATE") Date signStartDate
    		,@Param("SIGNENDDATE") Date signEndDate);
    
    int BathUpadate(@Param("contractId") String contractId);
}