package com.maigangle.gyl.facade.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.ConContractDetail;
import com.maigangle.gyl.facade.entity.ConDepositDetail;
import com.maigangle.gyl.facade.entity.ConFeeRates;
import com.maigangle.gyl.facade.entity.ConPaymentDetail;
import com.maigangle.gyl.facade.entity.FeeBalance;
import com.maigangle.gyl.facade.entity.FeeContractBalance;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.ConContractDetailDto;
import com.maigangle.gyl.facade.entity.dto.ConContractDto;
import com.maigangle.gyl.facade.entity.dto.ConDepositDetailDto;
import com.maigangle.gyl.facade.entity.dto.ConPaymentDetailDto;
import com.maigangle.gyl.facade.entity.dto.FeeContractBalanceDto;
import com.maigangle.gyl.facade.entity.vo.ConContractDetailVo;
import com.maigangle.gyl.facade.entity.vo.ConContractSelectVo;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.ContractBalanceVo;
import com.maigangle.gyl.facade.entity.vo.FeeBalanceVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**
 * 合同
 * @author 汪玮琦
 * @since 2017年11月28日 下午4:33:34
 * @varsion 1.0
 */
public interface ContractService {
	
	/**
	 * 新增合同
	 * @param conContract
	 * @return
	 */
	public ConContract addConContract(ConContract conContract);
	
	/**
	 * 查询所有合同有分页
	 * @param page 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public PageInfo<ConContractVo> getConContracts(PageUtils<ConContractDto> page, boolean isAccuracy);
	
	/**
	 * 查询所有合同有分页为下拉
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public List<ConContractSelectVo> getConContractForSelect(ConContractDto conContractDto, boolean isAccuracy);
	
	/**
	 * 查询所有合同
	 * @param conContractDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<ConContractVo> getConContracts(ConContractDto conContractDto, String orderByClause, boolean isAccuracy);
	
	/**
	 * 查询所有合同对账信息
	 * @param FeeContractBalanceDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<ContractBalanceVo> getContractBalances(FeeContractBalanceDto feeContractBalanceDto, String orderByClause, boolean isAccuracy);
	
	
	/**
	 * 根据Id查询合同
	 * @param contractId
	 * @return
	 */
	public ConContractVo getConContractById(String contractId);
	
	/**
	 * 根据Code合同单号查询合同
	 * @param contractCode
	 * @return
	 */
	public ConContract getConContractByCode(String contractCode);
	
	/**
	 * 根据No合同编号查询合同 
	 * @param contractCode
	 * @return
	 */
	public ConContract getConContractByNo(String contractNo);
	
	/**
	 * 更新合同
	 * @param conContract
	 * @return
	 */
	public ConContract updateConContract(ConContract conContract);
	
	/**
	 * 更新合同状态
	 * @param contractId
	 * @return
	 */
	public ConContract updateConContractState(String contractId);
	
	/**
	 * 删除合同
	 * @param contractId
	 * @return
	 */
	public int deleteConContract(String contractId);
	
	/**
	 * 新增合同明细
	 * @param detail
	 * @return
	 */
	public ConContractDetail addConContractDetail(ConContractDetail detail);
	
	/**
	 * 批量新增合同明细
	 * @param detailList
	 * @return
	 */
	public List<ConContractDetail> addConContractDetailBatch(List<ConContractDetail> detailList);
	
	/**
	 * 更新合同明细
	 * @param detail
	 * @return
	 */
	public ConContractDetail updateConContractDetail(ConContractDetail detail);
	
	/**
	 * 批量更新合同明细
	 * @param detailList
	 * @return
	 */
	public List<ConContractDetail> updateConContractDetailBatch(List<ConContractDetail> detailList);
	
	/**
	 * 删除合同明细
	 * @param detailId
	 * @return
	 */
	public int deteleConContractDetail(String detailId);
	
	/**
	 * 批量删除合同明细
	 * @param ids
	 * @return
	 */
	public int deteleConContractDetailBatch(List<String> ids);
	
	/**
	 * 按条件查询合同明细并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<ConContractDetailVo> getConContractDetails(PageUtils<ConContractDetailDto> page, boolean isAccuracy);
	
	/**
	 * 按条件查询所有合同明细
	 * @param detail
	 * @param isAccuracy
	 * @return
	 */
	public List<ConContractDetailVo> getConContractDetails(ConContractDetailDto detail,String orderByClause, boolean isAccuracy);
	
	/**
	 * 按条件查询合同明细
	 * @param detail
	 * @return
	 */
	public ConContractDetailVo getConContractDetail(String detailId);
	
	/**
	 * 
	 * @param contractId
	 * @return
	 */
	public List<ConContractDetailVo> getConContractDetailsByContractId(String contractId);
	
	/**
	 * 新增追加保证金明细
	 * @param detail
	 * @return
	 */
	public ConDepositDetail addConDepositDetail(ConDepositDetail detail);
	
	/**
	 * 批量新增追加保证金明细
	 * @param detailList
	 * @return
	 */
	public List<ConDepositDetail> addConDepositDetailBatch(List<ConDepositDetail> detailList);
	
	/**
	 * 更新追加保证金明细
	 * @param detail
	 * @return
	 */
	public ConDepositDetail updateConDepositDetail(ConDepositDetail detail);
	
	/**
	 * 更新追加保证金状态
	 * @param detail
	 * @return
	 */
	public ConDepositDetail updateConDepositDetailState(String contractId, String finaceId);
	
	/**
	 * 批量更新追加保证金明细
	 * @param detail
	 * @return
	 */
	public List<ConDepositDetail> updateConDepositDetailBatch(List<ConDepositDetail> detailList);
	
	/**
	 * 删除追加保证金明细
	 * @param deltailId
	 * @return
	 */
	public int deleteConDepositDetail(String deltailId);
	
	/**
	 * 批量删除追加保证金明细
	 * @param deltailIds
	 * @return
	 */
	public int deleteConDepositDetailBatch(List<String> deltailIds);
	
	/**
	 * 按条件查询追加保证金并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<ConDepositDetail> getConDepositDetails(PageUtils<ConDepositDetailDto> page, boolean isAccuracy);
	
	/**
	 * 按条件查询追加保证金
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	public List<ConDepositDetail> getConDepositDetails(ConDepositDetailDto dto, String orderByClause, boolean isAccuracy);

	/**
	 * 按条件查询追加保证金
	 * @param detailId
	 * @return
	 */
	public ConDepositDetail getConDepositDetail(String detailId);
	
	/**
	 * 新增追加货款明细
	 * @param conPaymentDetail
	 * @return
	 */
	public ConPaymentDetail addConPaymentDetail(ConPaymentDetail conPaymentDetail);
	
	/**
	 * 批量新增追加货款明细
	 * @param detailList
	 * @return
	 */
	public List<ConPaymentDetail> addConPaymentDetailBatch(List<ConPaymentDetail> detailList);
	
	/**
	 * 更新追加货款明细
	 * @param conPaymentDetail
	 * @return
	 */
	public ConPaymentDetail updateConPaymentDetail(ConPaymentDetail conPaymentDetail);
	
	/**
	 * 更新追加货款状态
	 * @param conPaymentDetail
	 * @return
	 */
	public ConPaymentDetail updateConPaymentDetailState(String contractId, String financeId, String id);
	
	/**
	 * 批量更新追加货款明细
	 * @param detailList
	 * @return
	 */
	public List<ConPaymentDetail> updateConPaymentDetailBatch(List<ConPaymentDetail> detailList);
	
	/**
	 * 删除追加货款明细
	 * @param detailId
	 * @return
	 */
	public int deleteConPaymentDetail(String detailId);
	
	/**
	 * 批量删除追加货款明细
	 * @param detailIds
	 * @return
	 */
	public int deleteConPaymentDetailBatch(List<String> detailIds);
	
	/**
	 * 获取追加货款明细并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<ConPaymentDetail> getConPaymentDetails(PageUtils<ConPaymentDetailDto> page, boolean isAccuracy);
	
	/**
	 * 获取追加货款明细
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	public List<ConPaymentDetail> getConPaymentDetails(ConPaymentDetailDto dto, String orderByClause, boolean isAccuracy);
	
	/**
	 * 获取追加货款明细
	 * @param detailId
	 * @return
	 */
	public ConPaymentDetail getConPaymentDetail(String detailId);
	
	/**
	 * 查询合同号是否存在
	 * @param contractNo
	 * @return
	 */
	public boolean isContractNoExist(String contractNo);
	
	/**
	 * 保存合同费率信息
	 * @return
	 */
	public ConFeeRates addConFeeRates(ConFeeRates conFeeRates);
	
	/**
	 * 批量保存合同费率信息
	 * @param conFeeRateses
	 * @return
	 */
	public List<ConFeeRates> addConFeeRatesBatch(List<ConFeeRates> conFeeRateses);
	
	/**
	 * 删除合同费率信息
	 * @param feeRatesId
	 * @return
	 */
	public int deleteConFeeRates(String feeRatesId);
	
	/**
	 * 批量删除合同费率信息
	 * @param feeRatesIds
	 * @return
	 */
	public int deleteConFeeRatesBatch(List<String> feeRatesIds);
	
	/**
	 * 更新合同费率信息
	 * @param conFeeRates
	 * @return
	 */
	public ConFeeRates updateConFeeRates(ConFeeRates conFeeRates);
	
	/**
	 * 批量更新合同费率信息
	 * @param conFeeRateses
	 * @return
	 */
	public List<ConFeeRates> updateConFeeRatesBatch(List<ConFeeRates> conFeeRateses);
	
	/**
	 * 按条件查询合同费率信息并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<ConFeeRates> getConFeeRates(PageUtils<ConFeeRates> page, boolean isAccuracy);
	
	/**
	 * 按条件查询合同费率信息
	 * @param conFeeRates
	 * @param orderByClause
	 * @param isAccuracy
	 * @return
	 */
	public List<ConFeeRates> getConFeeRates(ConFeeRates conFeeRates, String orderByClause, boolean isAccuracy);
	
	/**
	 * 按Id查询合同费率信息
	 * @param feeRatesId
	 * @return
	 */
	public ConFeeRates getConFeeRates(String feeRatesId);
	
	/**
	 * 按合同ID查询合同费率信息
	 * @param contractId
	 * @return
	 */
	public List<ConFeeRates> getConFeeRatesByContractId(String contractId);
	/**
	 * 合同审批通过回调函数
	 * @return
	 */
	public boolean onContractApprovalComplete(String id, PrivUser user);
	/**
	 * 合同提交回调函数
	 * @return
	 */
	public boolean onContractSumit (String id,PrivUser user);
	/**
	 * onContractApproval
	 */
	public boolean onContractApproval(String id,PrivUser user);
	/**
	 * 合同撤销回调函数
	*/
	public boolean  onContractAbandonApproval(String id,PrivUser user);
	/**
	 * 
	 * 合同回调函数
	 * @throws
	 */
	public boolean onContractApprovalSuspend(String id,PrivUser user);
	/*******************************买刚乐1.1***********************************************/
	/**
	 * 结束合同
	 * @return
	 */
	public int overContract(String contractId);
	/**
	 * 
	 * @author shmily
	 * @Title: getApproveConContracts 
	 * @Description: ( 查询出所有审批的合同 )
	 * @param page
	 * @param isAccuracy
	 * @return PageInfo<ConContractVo>
	 * @throws
	 */
	public PageInfo<ConContractVo> getApproveConContracts(PageUtils<ConContractDto> page, boolean isAccuracy);
	
	/**
	 * 余额查询列表查询和条件查询
	 */
	PageInfo<FeeContractBalance> getContractBalanceAll(PageUtils<ContractBalanceVo> page, Boolean isAccuracy);

	PageInfo<ContractBalanceVo> getContractBalances(PageUtils<FeeContractBalanceDto> page, boolean isAccuracy);
	
	public int deleteContractBalance(String contractId);
	
}
