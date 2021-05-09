package com.maigangle.gyl.facade.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.FeeBalance;
import com.maigangle.gyl.facade.entity.FeeBalanceDetail;
import com.maigangle.gyl.facade.entity.FeeDepositAccount;
import com.maigangle.gyl.facade.entity.FeeDepositDetail;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.FeeInvoice;
import com.maigangle.gyl.facade.entity.FeeInvoiceDetail;
import com.maigangle.gyl.facade.entity.OutOutstockDetail;
import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.dto.FeeBalanceDto;
import com.maigangle.gyl.facade.entity.dto.FeeDepositAccountDto;
import com.maigangle.gyl.facade.entity.dto.FeeDepositDetailDto;
import com.maigangle.gyl.facade.entity.dto.FeeFinanceBillDto;
import com.maigangle.gyl.facade.entity.vo.FeeDepositAccountVo;
import com.maigangle.gyl.facade.entity.vo.FeeDepositDetailVo;
import com.maigangle.gyl.facade.entity.vo.FeeFinanceBillVo;
import com.maigangle.gyl.facade.entity.vo.InvoiceVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**
 * 财务Service
 * @author 汪玮琦
 * @since 2017年12月4日 下午10:32:30
 * @version 1.0
 *
 */
public interface FinanceService {

	/**
	 * 新增财务单
	 * @param feeFinanceBill
	 * @return
	 */
	public FeeFinanceBill addFinanceBill(FeeFinanceBill feeFinanceBill);
	
	/**
	 * 更新财务单
	 * @param feeFinanceBill
	 * @return
	 */
	public FeeFinanceBill updateFinaceBill(FeeFinanceBill feeFinanceBill);
	
	/**
	 * 删除财务单
	 * @param financeBillId
	 * @return
	 */
	public int deleteFinaceBill(String financeBillId);
	
	/**
	 * 按条件查询财务单并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<FeeFinanceBillVo> getFinaceBills(PageUtils<FeeFinanceBillDto> page, boolean isAccuracy);
	
	/**
	 * 按条件查询财务单
	 * @param dto
	 * @param orderByClause
	 * @param isAccuracy
	 * @return
	 */
	public List<FeeFinanceBillVo> getFinaceBills(FeeFinanceBillDto dto, String orderByClause, boolean isAccuracy);
	
	/**
	 * 根据合同ID查询财务单
	 * @param contractId
	 * @return
	 */
	public List<FeeFinanceBillVo> getFinaceBillByContractId(String contractId);
	
	/**
	 * 按条件查询财务单
	 * @param financeBillId
	 * @return
	 */
	public FeeFinanceBillVo getFinaceBill(String financeBillId);
	
	/**
	 * 新增余额账户
	 * @param balance
	 * @return
	 */
	public FeeBalance addBalance(FeeBalance balance);
	
	/**
	 * 更新余额账户
	 * @param balance
	 * @return
	 */
	public FeeBalance updateBalance(FeeBalance balance);
	
	/**
	 * 删除余额账户
	 * @param balanceId
	 * @return
	 */
	public int deleteBalance(String balanceId);
	
	/**
	 * 按条件查询余额账户并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<FeeBalance> getBalances(PageUtils<FeeBalanceDto> page, boolean isAccuracy);
	
	/**
	 * 按条件查询余额账户
	 * @param dto
	 * @param orderByClause
	 * @param isAccuracy
	 * @return
	 */
	public List<FeeBalance> getBalances(FeeBalanceDto dto, String orderByClause, boolean isAccuracy);
	
	/**
	 * 按条件查询余额账户
	 * @param dto
	 * @return
	 */
	public FeeBalance getBalance(String balanceId);
	
	/**
	 * 新增保证金账户
	 * @param account
	 * @return
	 */
	public FeeDepositAccount addDepositAccount(FeeDepositAccount account);
	
	/**
	 * 更新保证金账户
	 * @param account
	 * @return
	 */
	public FeeDepositAccount updateDepositAccount(FeeDepositAccount account);
	
	/**
	 * 删除保证金账户
	 * @param accountId
	 * @return
	 */
	public int deleteDepositAccount(String accountId);
	
	/**
	 * 按条件查询保证金账户并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<FeeDepositAccountVo> getDepositAccounts(PageUtils<FeeDepositAccountDto> page, boolean isAccuracy);
	
	/**
	 * 按条件查询保证金账户
	 * @param list
	 * @param isAccuracy
	 * @return
	 */
	public List<FeeDepositAccountVo> getDepositAccounts(FeeDepositAccountDto dto, String orderByClause, boolean isAccuracy);
	
	/**
	 * 根据ID查询保证金账户
	 * @param accountId
	 * @return
	 */
	public FeeDepositAccountVo getDepositAccount(String accountId);
	
	/**
	 * 根据合同id查询保证金
	 * @param contractId
	 * @return
	 */
	public FeeDepositAccountVo getDepositAccountByContractId(String contractId);
	
	/**
	 * 新增保证消费明细
	 * @param detail
	 * @return
	 */
	public FeeDepositDetail addDepositDetail(FeeDepositDetail detail);
	
	/**
	 * 批量新增保证消费明细
	 * @param details
	 * @return
	 */
	public List<FeeDepositDetail> addDepositDetailBatch(List<FeeDepositDetail> details);
	
	/**
	 * 更新保证消费明细
	 * @param detail
	 * @return
	 */
	public FeeDepositDetail updateDepositDetail(FeeDepositDetail detail);
	
	/**
	 * 批量更新保证消费明细
	 * @param details
	 * @return
	 */
	public List<FeeDepositDetail> updateDepositDetailBatch(List<FeeDepositDetail> details);	
	
	/**
	 * 删除保证消费明细
	 * @param detailId
	 * @return
	 */
	public int deleteDepositDetail(String detailId);
	
	/**
	 * 批量删除保证消费明细
	 * @param detailId
	 * @return
	 */
	public int deleteDepositDetailBatch(List<String> detailIds);
	
	/**
	 * 按条件查询保证消费明细并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<FeeDepositDetailVo> getDepositDetails(PageUtils<FeeDepositDetailDto> page, boolean isAccuracy);
	
	/**
	 * 按条件查询保证消费明细
	 * @param page
	 * @param orderByClause
	 * @param isAccuracy
	 * @return
	 */
	public List<FeeDepositDetailVo> getDepositDetails(FeeDepositDetailDto dto, String orderByClause, boolean isAccuracy);
	
	/**
	 * 查询保证金消费明细
	 * @param detailId
	 * @return
	 */
	public FeeDepositDetailVo getDepositDetail(String detailId);
	
	/**
	 * 添加保证金
	 * @param depositDetailId 保证金消费明细Id
	 * @param number 金额
	 * @return
	 */
	public int addDepositFee(String depositDetailId, BigDecimal number);
	
	/**
	 * 减去保证金
	 * @param depositDetailId 保证金消费明细Id
	 * @param number 金额
	 * @return
	 */
	public int delDepositFee(String depositDetailId, BigDecimal number);
	
	/**
	 * 新增发票
	 * @param feeInvoice
	 * @return
	 */
	public FeeInvoice addInvoice(FeeInvoice feeInvoice);
	
	/**
	 * 添加发票明细
	 * @param list
	 * @param id
	 * @return
	 */
	public List<FeeInvoiceDetail> addInvoiceDetail(List<FeeInvoiceDetail> list,String id);
	
	/**
	 * 查询所有发票
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	PageInfo<FeeInvoice> getInvoice(PageUtils<InvoiceVo> page,Boolean isAccuracy);
	
	/**
	 * 根据ID查询发票明细
	 * @param id
	 * @return
	 */
	public List<FeeInvoiceDetail> getInvoiceDetailById(String id);
	
	/**
	 * 新增合同对账信息
	 * @param contractId
	 */
	public void addContractBalance(String contractId,String createUser);
	
	/**
	 * 修改发票
	 * @param feeInvoice
	 * @return
	 */
	public int updateFeeInvoice(FeeInvoice feeInvoice);
	
	/**
	 * 删除发票明细
	 * @param invoiceDetailId
	 * @return
	 */
	public int deleteInvoiceDetail(String invoiceDetailId);
	
	/**
	 * 添加发票明细
	 * @param feeInvoiceDetail
	 * @return
	 */
	public FeeInvoiceDetail addFeeInvoiceDetail(FeeInvoiceDetail feeInvoiceDetail);
	
	public List<FeeInvoice> getInvoiceById(String id);
}
