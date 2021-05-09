package com.maigangle.gyl.facade.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.ConContractDetail;
import com.maigangle.gyl.facade.entity.ConDepositDetail;
import com.maigangle.gyl.facade.entity.ConFeeRates;
import com.maigangle.gyl.facade.entity.ConPaymentDetail;
import com.maigangle.gyl.facade.entity.SysApprovalModule;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.ConContractDetailDto;
import com.maigangle.gyl.facade.entity.dto.ConContractDto;
import com.maigangle.gyl.facade.entity.dto.ConDepositDetailDto;
import com.maigangle.gyl.facade.entity.dto.ConPaymentDetailDto;
import com.maigangle.gyl.facade.entity.vo.ConContractDetailVo;
import com.maigangle.gyl.facade.entity.vo.ConContractSelectVo;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**
 * 审批service
 * @author 杨思静
 * @since  2018年2月4日 - 下午4:14:07
 * @version 1.0
 */
public interface ApproveService {
	
	/**
	 * 
	 * @author shmily
	 * @Title: selectModelName 
	 * @Description: ( 查询出数据库中所有的模块的审批模块 ) 
	 * @return List<String>
	 * @throws
	 */
	List<String> selectModelName();
	/**
	 * 
	 * @author shmily
	 * @Title: delectApproveModel 
	 * @Description: ( 删除 ) 
	 * @return int
	 * @throws
	 */
	int delectApproveModel(String modelName);
	
	List<SysApprovalModule> selectAllModelName();
}
