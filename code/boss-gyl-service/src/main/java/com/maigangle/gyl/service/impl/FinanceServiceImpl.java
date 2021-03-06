package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.FeeBalance;
import com.maigangle.gyl.facade.entity.FeeBalanceExample;
import com.maigangle.gyl.facade.entity.FeeContractBalance;
import com.maigangle.gyl.facade.entity.FeeDepositAccount;
import com.maigangle.gyl.facade.entity.FeeDepositAccountExample;
import com.maigangle.gyl.facade.entity.FeeDepositDetail;
import com.maigangle.gyl.facade.entity.FeeDepositDetailExample;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.FeeFinanceBillExample;
import com.maigangle.gyl.facade.entity.FeeInvoice;
import com.maigangle.gyl.facade.entity.FeeInvoiceDetail;
import com.maigangle.gyl.facade.entity.FeeInvoiceDetailExample;
import com.maigangle.gyl.facade.entity.FeeInvoiceExample;
import com.maigangle.gyl.facade.entity.dto.FeeBalanceDto;
import com.maigangle.gyl.facade.entity.dto.FeeDepositAccountDto;
import com.maigangle.gyl.facade.entity.dto.FeeDepositDetailDto;
import com.maigangle.gyl.facade.entity.dto.FeeFinanceBillDto;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.FeeDepositAccountVo;
import com.maigangle.gyl.facade.entity.vo.FeeDepositDetailVo;
import com.maigangle.gyl.facade.entity.vo.FeeFinanceBillVo;
import com.maigangle.gyl.facade.entity.vo.InContractRemitDetailVo;
import com.maigangle.gyl.facade.entity.vo.InvoiceVo;
import com.maigangle.gyl.facade.enums.ContractBillStateEnum;
import com.maigangle.gyl.facade.enums.InvoiceTypeEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.GylService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.utils.DateUtils;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.FeeBalanceMapper;
import com.maigangle.gyl.service.mapper.FeeContractBalanceMapper;
import com.maigangle.gyl.service.mapper.FeeDepositAccountMapper;
import com.maigangle.gyl.service.mapper.FeeDepositDetailMapper;
import com.maigangle.gyl.service.mapper.FeeFinanceBillMapper;
import com.maigangle.gyl.service.mapper.FeeInvoiceDetailMapper;
import com.maigangle.gyl.service.mapper.FeeInvoiceMapper;
import com.maigangle.gyl.service.mapper.ext.FeeDepositAccountExtMapper;
import com.maigangle.gyl.service.mapper.ext.FeeDepositDetailExtMapper;
import com.maigangle.gyl.service.mapper.ext.FeeFinanceBillExtMapper;
import com.maigangle.gyl.service.mapper.ext.FeeInvoiceExtMapper;

@Service
@Transactional
public class FinanceServiceImpl extends GylServiceImpl implements FinanceService {
	@Autowired
	private FeeFinanceBillMapper feeFinanceBillMapper;
	@Autowired
	private FeeFinanceBillExtMapper feeFinanceBillExtMapper;
	@Autowired
	private FeeBalanceMapper feeBalanceMapper;
	@Autowired
	private FeeDepositAccountMapper feeDepositAccountMapper;
	@Autowired
	private FeeDepositAccountExtMapper feeDepositAccountExtMapper;
	@Autowired
	private FeeDepositDetailMapper feeDepositDetailMapper;
	@Autowired
	private FeeDepositDetailExtMapper feeDepositDetailExtMapper;
	@Autowired
	private GylService<?> gylService;
	@Autowired
	private FeeInvoiceMapper feeInvoiceMapper;
	@Autowired
	private FeeInvoiceDetailMapper feeInvoiceDetailMapper;
	@Autowired
	private InstockBillService instockBillService;
	@Autowired
	private FeeContractBalanceMapper feeContractBalanceMapper;
	@Autowired
	private InvInventoryService invInventoryService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private FeeInvoiceExtMapper feeInvoiceExtMapper;
	
	@Override
	public FeeFinanceBill addFinanceBill(FeeFinanceBill feeFinanceBill) {
		if (feeFinanceBill == null) {
			return null;
		}
		feeFinanceBill.setFinanceCode(gylService.generateCode("TB_FEE_FINANCE_BILL", "CW"));
		feeFinanceBill.setCreateDate(new Date());
		int rows = feeFinanceBillMapper.insertSelective(feeFinanceBill);
		return rows == 0 ? null : feeFinanceBill;
	}

	@Override
	public FeeFinanceBill updateFinaceBill(FeeFinanceBill feeFinanceBill) {
		if (StringUtils.isEmpty(feeFinanceBill.getFinanceBillId())) {
			return null;
		}
		int rows = feeFinanceBillMapper.updateByPrimaryKeySelective(feeFinanceBill);
		return rows == 0 ? null : feeFinanceBill;
	}

	@Override
	public int deleteFinaceBill(String financeBillId) {
		if (StringUtils.isEmpty(financeBillId)) {
			return 0;
		}
		FeeFinanceBill bill = new FeeFinanceBill();
		bill.setFinanceBillId(financeBillId);
		bill.setIsDel(YesOrNoEnum.YES.toString());
		return feeFinanceBillMapper.updateByPrimaryKeySelective(bill);
	}

	@Override
	public PageInfo<FeeFinanceBillVo> getFinaceBills(PageUtils<FeeFinanceBillDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		FeeFinanceBillExample example = this.getFinanceBillCriteria(page.getDto(), isAccuracy);
		List<FeeFinanceBillVo> list = feeFinanceBillExtMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<FeeFinanceBillVo> getFinaceBills(FeeFinanceBillDto dto, String orderByClause, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<FeeFinanceBillDto> page = new PageUtils<FeeFinanceBillDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<FeeFinanceBillVo> info = this.getFinaceBills(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public FeeFinanceBillVo getFinaceBill(String financeBillId) {
		if (StringUtils.isEmpty(financeBillId)) {
			return null;
		}
		return feeFinanceBillExtMapper.selectByPrimaryKey(financeBillId);
	}
	
	@Override
	public List<FeeFinanceBillVo> getFinaceBillByContractId(String contractId) {
		if (StringUtils.isEmpty(contractId)) {
			return null;
		}
		FeeFinanceBillDto dto = new FeeFinanceBillDto();
		dto.setContractId(contractId);
		List<FeeFinanceBillVo> list = getFinaceBills(dto, "", true);
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}

	/**
	 * ????????????
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	private FeeFinanceBillExample getFinanceBillCriteria(FeeFinanceBillDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		FeeFinanceBillExample example = new FeeFinanceBillExample();
		FeeFinanceBillExample.Criteria criteria = example.createCriteria();
		if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
			criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
		} else if (dto.getStartCreateDate() != null) {
			criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
		} else if (dto.getEndCreateDate() != null) {
			criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
		}
		
		if (dto.getTotalGoodsPayment() != null) {
			criteria.andTotalGoodsPaymentEqualTo(dto.getTotalGoodsPayment());
		} else if (dto.getMinActualAmount() != null && dto.getMaxActualAmount() != null) {
			criteria.andTotalGoodsPaymentBetween(dto.getMinActualAmount(), dto.getMaxActualAmount());
		} else if (dto.getMinActualAmount() != null) {
			criteria.andTotalGoodsPaymentGreaterThanOrEqualTo(dto.getMinActualAmount());
		} else if (dto.getMaxActualAmount() != null) {
			criteria.andTotalGoodsPaymentLessThanOrEqualTo(dto.getMaxActualAmount());
		}
		
		if (dto.getInvoiceFee() != null) {
			criteria.andInvoiceFeeEqualTo(dto.getInvoiceFee());
		} else if (dto.getMinInvoiceFee() != null && dto.getMaxInvoiceFee() != null) {
			criteria.andInvoiceFeeBetween(dto.getMinInvoiceFee(), dto.getMaxInvoiceFee());
		} else if (dto.getMinInvoiceFee() != null) {
			criteria.andInvoiceFeeGreaterThanOrEqualTo(dto.getMinInvoiceFee());
		} else if (dto.getMaxInvoiceFee() != null) {
			criteria.andInvoiceFeeLessThanOrEqualTo(dto.getMaxInvoiceFee());
		}
		
		if (dto.getCommissionFee() != null) {
			criteria.andCommissionFeeEqualTo(dto.getCommissionFee());
		} else if (dto.getMinCommissionFee() != null && dto.getMaxCommissionFee() != null) {
			criteria.andCommissionFeeBetween(dto.getMinCommissionFee(), dto.getMaxCommissionFee());
		} else if (dto.getMinCommissionFee() != null) {
			criteria.andCommissionFeeGreaterThan(dto.getMinCommissionFee());
		} else if (dto.getMaxCommissionFee() != null) {
			criteria.andCommissionFeeLessThanOrEqualTo(dto.getMaxCommissionFee());
		}
		
		if (dto.getChargingDays() != null) {
			criteria.andChargingDaysEqualTo(dto.getChargingDays());
		} else if (dto.getStartChargingDays() != null && dto.getEndChargingDays() != null) {
			criteria.andChargingDaysBetween(dto.getStartChargingDays(), dto.getEndChargingDays());
		} else if (dto.getStartChargingDays() != null) {
			criteria.andChargingDaysGreaterThanOrEqualTo(dto.getStartChargingDays());
		} else if (dto.getEndChargingDays() != null) {
			criteria.andChargingDaysLessThanOrEqualTo(dto.getEndChargingDays());
		}
		
		if (dto.getOtherFee() != null) {
			criteria.andOtherFeeEqualTo(dto.getOtherFee());
		} else if (dto.getMinOtherFee() != null && dto.getMaxOtherFee() != null) {
			criteria.andOtherFeeBetween(dto.getMinOtherFee(), dto.getMaxOtherFee());
		} else if (dto.getMinOtherFee() != null) {
			criteria.andOtherFeeGreaterThanOrEqualTo(dto.getMinOtherFee());
		} else if (dto.getMaxOtherFee() != null) {
			criteria.andOtherFeeLessThanOrEqualTo(dto.getMaxOtherFee());
		}
		
		if (dto.getTotalMoney() != null) {
			criteria.andTotalMoneyEqualTo(dto.getTotalMoney());
		} else if (dto.getMinTotalMoney() != null && dto.getMaxTotalMoney() != null) {
			criteria.andTotalMoneyBetween(dto.getMinTotalMoney(), dto.getMaxTotalMoney());
		} else if (dto.getMinTotalMoney() != null) {
			criteria.andTotalMoneyGreaterThanOrEqualTo(dto.getMinTotalMoney());
		} else if (dto.getMaxTotalMoney() != null) {
			criteria.andTotalMoneyLessThanOrEqualTo(dto.getMaxTotalMoney());
		}
		
		if (dto.getActualAmount() != null) {
			criteria.andActualAmountEqualTo(dto.getActualAmount());
		} else if (dto.getMinActualAmount() != null && dto.getMaxActualAmount() != null) {
			criteria.andActualAmountBetween(dto.getMinActualAmount(), dto.getMaxActualAmount());
		} else if (dto.getMinActualAmount() != null) {
			criteria.andActualAmountGreaterThanOrEqualTo(dto.getMinActualAmount());
		} else if (dto.getMaxActualAmount() != null) {
			criteria.andActualAmountLessThanOrEqualTo(dto.getMaxActualAmount());
		}
		
		if (dto.getRealMoney() != null) {
			criteria.andRealMoneyEqualTo(dto.getRealMoney());
		} else if (dto.getMinRealMoney() != null && dto.getMaxRealMoney() != null) {
			criteria.andRealMoneyBetween(dto.getMinRealMoney(), dto.getMaxRealMoney());
		} else if (dto.getMinRealMoney() != null) {
			criteria.andRealMoneyGreaterThanOrEqualTo(dto.getMinRealMoney());
		} else if (dto.getMaxRealMoney() != null) {
			criteria.andRealMoneyLessThanOrEqualTo(dto.getMaxRealMoney());
		}
		
		if (dto.getDepositFee() != null) {
			criteria.andDepositFeeEqualTo(dto.getDepositFee());
		} else if (dto.getMinDepositFee() != null && dto.getMaxDepositFee() != null) {
			criteria.andDepositFeeBetween(dto.getMinDepositFee(), dto.getMaxDepositFee());
		} else if (dto.getMinDepositFee() != null) {
			criteria.andDepositFeeGreaterThanOrEqualTo(dto.getMinDepositFee());
		} else if (dto.getMaxDepositFee() != null) {
			criteria.andDepositFeeLessThanOrEqualTo(dto.getMaxDepositFee());
		}
		
		if (dto.getStartOperatorDate() != null && dto.getEndOperatorDate() != null) {
			criteria.andOperatorDateBetween(dto.getStartOperatorDate(), dto.getEndOperatorDate());
		} else if (dto.getStartOperatorDate() != null) {
			criteria.andOperatorDateGreaterThanOrEqualTo(dto.getStartOperatorDate());
		} else if (dto.getEndOperatorDate() != null) {
			criteria.andOperatorDateLessThanOrEqualTo(dto.getEndOperatorDate());
		}
		if (!StringUtils.isEmpty(dto.getBusinessType())) {
			criteria.andBusinessTypeEqualTo(dto.getBusinessType());
		}
		
		if (!StringUtils.isEmpty(dto.getFinanceCode())) {
			if (isAccuracy) {
				criteria.andFinanceCodeEqualTo(dto.getFinanceCode().toUpperCase());
			} else {
				criteria.andFinanceCodeLike("%" + dto.getFinanceCode().toUpperCase() + "%");
			}
		}
		if (!StringUtils.isEmpty(dto.getContractId())) {
			criteria.andContractIdEqualTo(dto.getContractId());
		}
		
		if (!StringUtils.isEmpty(dto.getFlwoType())) {
			criteria.andFlwoTypeEqualTo(dto.getFlwoType());
		}
		if (!StringUtils.isEmpty(dto.getContractCode())) {
			if (isAccuracy) {
				criteria.andContractCodeEqualTo(dto.getContractCode().toUpperCase());
			} else {
				criteria.andContractCodeLike("%" + dto.getContractCode().toUpperCase() + "%");
			}
		}
		if (!StringUtils.isEmpty(dto.getRelationCode())) {
			if (isAccuracy) {
				criteria.andRelationCodeEqualTo(dto.getRelationCode().toUpperCase());
			} else {
				criteria.andRelationCodeLike("%" + dto.getRelationCode().toUpperCase() + "%");
			}
		}
		if (!StringUtils.isEmpty(dto.getStatus())) {
			criteria.andStatusEqualTo(dto.getStatus());
		}
		if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
			criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
		} else if (dto.getStartCreateDate() != null) {
			criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
		} else if (dto.getEndCreateDate() != null) {
			criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
		}
		if (!StringUtils.isEmpty(dto.getOperator())) {
			if (isAccuracy) {
				criteria.andOperatorEqualTo(dto.getOperator());
			} else {
				criteria.andOperatorLike("%" + dto.getOperator() + "%");
			}
		}
		return example;
	}

	@Override
	public FeeBalance addBalance(FeeBalance balance) {
		if (balance == null) {
			return null;
		}
		int rows = feeBalanceMapper.insertSelective(balance);
		return rows == 0 ? null : balance;
	}

	@Override
	public FeeBalance updateBalance(FeeBalance balance) {
		if (StringUtils.isEmpty(balance.getBalanceId())) {
			return null;
		}
		int rows = feeBalanceMapper.updateByPrimaryKeySelective(balance);
		return rows == 0 ? null : balance;
	}

	@Override
	public int deleteBalance(String balanceId) {
		if (StringUtils.isEmpty(balanceId)) {
			return 0;
		}
		FeeBalance balance = new FeeBalance();
		balance.setBalanceId(balanceId);
		balance.setIsDel(YesOrNoEnum.YES.toString());
		return feeBalanceMapper.updateByPrimaryKeySelective(balance);
	}

	@Override
	public PageInfo<FeeBalance> getBalances(PageUtils<FeeBalanceDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		FeeBalanceExample example = this.getBalanceCriteria(page.getDto(), isAccuracy);
		List<FeeBalance> list = feeBalanceMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<FeeBalance> getBalances(FeeBalanceDto dto, String orderByClause, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<FeeBalanceDto> page = new PageUtils<FeeBalanceDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<FeeBalance> info = this.getBalances(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public FeeBalance getBalance(String balanceId) {
		if (StringUtils.isEmpty(balanceId)) {
			return null;
		}
		return feeBalanceMapper.selectByPrimaryKey(balanceId);
	}
	
	/**
	 * ????????????
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	private FeeBalanceExample getBalanceCriteria(FeeBalanceDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		FeeBalanceExample example = new FeeBalanceExample();
		FeeBalanceExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(dto.getMakerId())) {
			criteria.andMakerIdEqualTo(dto.getMakerId());
		}
		
		if (!StringUtils.isEmpty(dto.getCustomerId())) {
			criteria.andCustomerIdEqualTo(dto.getCustomerId());
		}
		
//		if (dto.getAmount() != null) {
//			criteria.andAmountEqualTo(dto.getAmount());
//		} else if (dto.getMinAmount() != null && dto.getMaxAmount() != null) {
//			criteria.andAmountBetween(dto.getMinAmount(), dto.getMaxAmount());
//		} else if (dto.getMinAmount() != null) {
//			criteria.andAmountGreaterThanOrEqualTo(dto.getMinAmount());
//		} else if (dto.getMaxAmount() != null) {
//			criteria.andAmountLessThanOrEqualTo(dto.getMaxAmount());
//		}
		
		if (dto.getResidualAmount() != null) {
			criteria.andResidualAmountEqualTo(dto.getResidualAmount());
		} else if (dto.getMinResidualAmount() != null && dto.getMaxResidualAmount() != null) {
			criteria.andResidualAmountBetween(dto.getMinResidualAmount(), dto.getMaxResidualAmount());
		} else if (dto.getMinResidualAmount() != null) {
			criteria.andResidualAmountGreaterThanOrEqualTo(dto.getMinResidualAmount());
		} else if (dto.getMaxResidualAmount() != null) {
			criteria.andResidualAmountLessThanOrEqualTo(dto.getMaxResidualAmount());
		}
		
		if (!StringUtils.isEmpty(dto.getCreateUser())) {
			if (isAccuracy) {
				criteria.andCreateUserEqualTo(dto.getCreateUser());
			} else {
				criteria.andCreateUserLike("%" + dto.getCreateUser() + "%");
			}
		}
		
		if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
			criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
		} else if (dto.getStartCreateDate() != null) {
			criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
		} else if (dto.getEndCreateDate() != null) {
			criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
		}
		
		return example;
	}

	@Override
	public FeeDepositAccount addDepositAccount(FeeDepositAccount account) {
		if (account == null) {
			return null;
		}
		int rows = feeDepositAccountMapper.insertSelective(account);
		return rows == 0 ? null : account;
	}

	@Override
	public FeeDepositAccount updateDepositAccount(FeeDepositAccount account) {
		if (StringUtils.isEmpty(account.getDepositAccountId())) {
			return null;
		}
		int rows = feeDepositAccountMapper.updateByPrimaryKeySelective(account);
		return rows == 0 ? null : account;
	}

	@Override
	public int deleteDepositAccount(String accountId) {
		if (StringUtils.isEmpty(accountId)) {
			return 0;
		}
		FeeDepositAccount account = new FeeDepositAccount();
		account.setDepositAccountId(accountId);
		account.setIsDel(YesOrNoEnum.YES.toString());
		return feeDepositAccountMapper.updateByPrimaryKeySelective(account);
	}

	@Override
	public PageInfo<FeeDepositAccountVo> getDepositAccounts(PageUtils<FeeDepositAccountDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		FeeDepositAccountExample example = this.getDepositAccountCriteria(page.getDto(), false);
		List<FeeDepositAccountVo> list = feeDepositAccountExtMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<FeeDepositAccountVo> getDepositAccounts(FeeDepositAccountDto dto, String orderByClause, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<FeeDepositAccountDto> page = new PageUtils<FeeDepositAccountDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<FeeDepositAccountVo> info = this.getDepositAccounts(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public FeeDepositAccountVo getDepositAccount(String accountId) {
		if (StringUtils.isEmpty(accountId)) {
			return null;
		}
		return feeDepositAccountExtMapper.selectByPrimaryKey(accountId);
	}
	
	@Override
	public FeeDepositAccountVo getDepositAccountByContractId(String contractId) {
		if (StringUtils.isEmpty(contractId)) {
			return null;
		}
		FeeDepositAccountDto dto = new FeeDepositAccountDto();
		dto.setContractId(contractId);
		FeeDepositAccountExample example = this.getDepositAccountCriteria(dto, false);
		List<FeeDepositAccountVo> list = feeDepositAccountExtMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * ????????????
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	private FeeDepositAccountExample getDepositAccountCriteria(FeeDepositAccountDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		FeeDepositAccountExample example = new FeeDepositAccountExample();
		FeeDepositAccountExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(dto.getBuyerId())) {
			criteria.andBuyerIdEqualTo(dto.getBuyerId());
		}
		if (!StringUtils.isEmpty(dto.getContractId())) {
			criteria.andContractIdEqualTo(dto.getContractId());
		}
		if (!StringUtils.isEmpty(dto.getFinanceId())) {
			criteria.andFinanceIdEqualTo(dto.getFinanceId());
		}
		if (dto.getDepositFee() != null) {
			criteria.andDepositFeeEqualTo(dto.getDepositFee());
		} else if (dto.getMinDepositFee() != null && dto.getMaxDepositFee() != null) {
			criteria.andDepositFeeBetween(dto.getMinDepositFee(), dto.getMaxDepositFee());
		} else if (dto.getMinDepositFee() != null) {
			criteria.andDepositFeeGreaterThanOrEqualTo(dto.getMinDepositFee());
		} else if (dto.getMaxDepositFee() != null) {
			criteria.andDepositFeeLessThanOrEqualTo(dto.getMaxDepositFee());
		}
		
		if (dto.getBalance() != null) {
			criteria.andBalanceEqualTo(dto.getBalance());
		} else if (dto.getMinBalance() != null && dto.getMaxBalance() != null) {
			criteria.andBalanceBetween(dto.getMinBalance(), dto.getMaxBalance());
		} else if (dto.getMinBalance() != null) {
			criteria.andBalanceGreaterThanOrEqualTo(dto.getMinBalance());
		} else if (dto.getMaxBalance() != null) {
			criteria.andBalanceLessThanOrEqualTo(dto.getMaxBalance());
		}
		
		if (!StringUtils.isEmpty(dto.getCreateUser())) {
			if (isAccuracy) {
				criteria.andCreateUserEqualTo(dto.getCreateUser());
			} else {
				criteria.andCreateUserEqualTo(dto.getCreateUser());
			}
		}
		
		if (dto.getCreateDate() != null) {
			criteria.andCreateDateEqualTo(dto.getCreateDate());
		} else if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
			criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
		} else if (dto.getStartCreateDate() != null) {
			criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
		} else if (dto.getEndCreateDate() != null) {
			criteria.andCreateDateLessThanOrEqualTo(dto.getCreateDate());
		}
		if (!StringUtils.isEmpty(dto.getBusinessType())) {
			criteria.andBusinessTypeEqualTo(dto.getBusinessType());
		}
		return example;
	}

	@Override
	public FeeDepositDetail addDepositDetail(FeeDepositDetail detail) {
		if (detail == null) {
			return null;
		}
		int rows = feeDepositDetailMapper.insertSelective(detail);
		return rows == 0 ? null : detail;
	}

	@Override
	public List<FeeDepositDetail> addDepositDetailBatch(List<FeeDepositDetail> details) {
		List<FeeDepositDetail> resultList = new ArrayList<>();
		if (details != null && !details.isEmpty()) {
			for (int i = 0; i < details.size(); i++) {
				resultList.add(addDepositDetail(details.get(i)));
			}
		}
		return resultList;
	}

	@Override
	public FeeDepositDetail updateDepositDetail(FeeDepositDetail detail) {
		if (StringUtils.isEmpty(detail.getDepositDetailId())) {
			return null;
		}
		int rows = feeDepositDetailMapper.updateByPrimaryKeySelective(detail);
		return rows == 0 ? null : detail;
	}

	@Override
	public List<FeeDepositDetail> updateDepositDetailBatch(List<FeeDepositDetail> details) {
		List<FeeDepositDetail> resultList = new ArrayList<>();
		if (details != null && !details.isEmpty()) {
			for (int i = 0; i < details.size(); i++) {
				resultList.add(updateDepositDetail(details.get(i)));
			}
		}
		return resultList;
	}

	@Override
	public int deleteDepositDetail(String detailId) {
		if (StringUtils.isEmpty(detailId)) {
			return 0;
		}
		FeeDepositDetail detail = new FeeDepositDetail();
		detail.setDepositDetailId(detailId);
		detail.setIsDel(YesOrNoEnum.YES.toString());
		return feeDepositDetailMapper.deleteByPrimaryKey(detailId);
	}

	@Override
	public int deleteDepositDetailBatch(List<String> detailIds) {
		if (detailIds == null || detailIds.isEmpty()) {
			return 0;
		}
		int resutlInt = 0;
		for (int i = 0; i < detailIds.size(); i++) {
			resutlInt += this.deleteDepositDetail(detailIds.get(i));
		}
		return resutlInt;
	}

	@Override
	public PageInfo<FeeDepositDetailVo> getDepositDetails(PageUtils<FeeDepositDetailDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		FeeDepositDetailExample example = this.getDepositDetailCriteria(page.getDto(), isAccuracy);
		List<FeeDepositDetailVo> list = feeDepositDetailExtMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<FeeDepositDetailVo> getDepositDetails(FeeDepositDetailDto dto, String orderByClause,
			boolean isAccuracy) {
		if (dto == null) {
			return null;
		}		
		PageUtils<FeeDepositDetailDto> page = new PageUtils<FeeDepositDetailDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<FeeDepositDetailVo> info = this.getDepositDetails(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public FeeDepositDetailVo getDepositDetail(String detailId) {
		if (StringUtils.isEmpty(detailId)) {
			return null;
		}
		return feeDepositDetailExtMapper.selectByPrimaryKey(detailId);
	}
	
	/**
	 * ????????????
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	private FeeDepositDetailExample getDepositDetailCriteria(FeeDepositDetailDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		FeeDepositDetailExample example = new FeeDepositDetailExample();
		FeeDepositDetailExample.Criteria criteria = example.createCriteria();
		
		if (dto.getUsedFee() != null) {
			criteria.andUsedFeeEqualTo(dto.getUsedFee());
		} else if (dto.getMinUsedFee() != null && dto.getMaxUsedFee() != null) {
			criteria.andUsedFeeBetween(dto.getMinUsedFee(), dto.getMaxUsedFee());
		} else if (dto.getMinUsedFee() != null) {
			criteria.andUsedFeeGreaterThanOrEqualTo(dto.getMinBalance());
		} else if (dto.getMaxUsedFee() != null) {
			criteria.andUsedFeeLessThanOrEqualTo(dto.getMaxUsedFee());
		}
		
		if (dto.getBalance() != null) {
			criteria.andBalanceEqualTo(dto.getBalance());
		} else if (dto.getMinBalance() != null && dto.getMaxBalance() != null) {
			criteria.andBalanceBetween(dto.getMinBalance(), dto.getMaxBalance());
		} else if (dto.getMinBalance() != null) {
			criteria.andBalanceGreaterThanOrEqualTo(dto.getMinBalance());
		} else if (dto.getMaxBalance() != null) {
			criteria.andBalanceLessThanOrEqualTo(dto.getMaxBalance());
		}
		
		if (!StringUtils.isEmpty(dto.getContractId())) {
			criteria.andContractIdEqualTo(dto.getContractId());
		}
		if (!StringUtils.isEmpty(dto.getDepositAccountId())) {
			criteria.andDepositAccountIdEqualTo(dto.getDepositAccountId());
		}
		
		if (dto.getCreateDate() != null) {
			criteria.andCreateDateEqualTo(dto.getCreateDate());
		} else if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
			criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
		} else if (dto.getStartCreateDate() != null) {
			criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
		} else if (dto.getEndCreateDate() != null) {
			criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
		}
		
		if (!StringUtils.isEmpty(dto.getCreateUser())) {
			if (isAccuracy) {
				criteria.andCreateUserEqualTo(dto.getCreateUser());
			} else {
				criteria.andCreateUserLike("%" + dto.getCreateUser() + "%");
			}
		}
		return example;
	}

	@Override
	public int addDepositFee(String depositDetailId, BigDecimal number) {
		FeeDepositDetail deital = getDepositDetail(depositDetailId);
		FeeDepositAccount account = getDepositAccount(deital.getDepositAccountId());
		if (account == null) {
			return -1;
		}
		if (account.getBalance() == null) {
			account.setBalance(BigDecimal.ZERO);
		}
		if (account.getDepositFee() == null) {
			account.setDepositFee(BigDecimal.ZERO);
		}
		account.setDepositFee(account.getDepositFee().add(number));
		account.setBalance(account.getBalance().add(number));
		account = updateDepositAccount(account);
		return account == null ? -1 : 1;
	}

	@Override
	public int delDepositFee(String contractId, BigDecimal number) {
		FeeDepositAccount account = getDepositAccountByContractId(contractId);
		if (account == null) {
			return -1;
		}
		if (account.getBalance() == null) {
			account.setBalance(BigDecimal.ZERO);
		}
		if (account.getBalance().subtract(number).compareTo(BigDecimal.ZERO) == 0) {
			account.setBalance(BigDecimal.ZERO);
		} else {
			account.setBalance(account.getBalance().subtract(number));
		}
		account = updateDepositAccount(account);
		return account == null ? -1 : 1;
	}
	
	@Override
	public FeeInvoice addInvoice(FeeInvoice feeInvoice) {
		if(feeInvoice == null) {
			return null;
		}
		feeInvoice.setCreateDate(new Date());
		int rows = feeInvoiceMapper.insertSelective(feeInvoice);
		return feeInvoice;
	}
	
	@Override
	public List<FeeInvoiceDetail> addInvoiceDetail(List<FeeInvoiceDetail> list,String id) {
		if (!StringUtils.isEmpty(list.get(0))){
			for(int j=0;j<list.size();j++) {
				list.get(j).setInvoiceId(id);
				feeInvoiceDetailMapper.insertSelective(list.get(j));
			}
		}
		return list;
	}
	
	@Override
	public PageInfo<FeeInvoice> getInvoice(PageUtils<InvoiceVo> page,Boolean isAccuracy) {
		if(page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		InvoiceVo dto = page.getDto();
		FeeInvoiceExample example = getExample(dto,isAccuracy);
		List<FeeInvoice> list= feeInvoiceMapper.selectByExample(example);
		PageInfo<FeeInvoice> pageInv = new PageInfo<>(list);
		return pageInv; 
	}
	
	private FeeInvoiceExample getExample(InvoiceVo inv,Boolean isAccuracy) {
		FeeInvoiceExample example = new FeeInvoiceExample();
		if (inv != null) {
			FeeInvoiceExample.Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(inv.getInvoiceType())) {
				criteria.andInvoiceTypeEqualTo(inv.getInvoiceType());
			}
			if (!StringUtils.isEmpty(inv.getInvoiceNo())) {
				if (isAccuracy) {
					criteria.andInvoiceNoEqualTo(inv.getInvoiceNo().toUpperCase());
				} else {
					criteria.andInvoiceNoLike("%" + inv.getInvoiceNo().toUpperCase() + "%");
				}
			}
			if (!StringUtils.isEmpty(inv.getCreateUser())) {
				if (isAccuracy) {
					criteria.andCreateUserEqualTo(inv.getCreateUser().toUpperCase());
				} else {
					criteria.andCreateUserLike("%" + inv.getCreateUser().toUpperCase() + "%");
				}
			}
			if (inv.getStartBillingDate() != null && inv.getEndBillingDate() != null) {
				criteria.andBillingDateBetween(inv.getStartBillingDate(), inv.getEndBillingDate());
			} else if (inv.getStartBillingDate() != null) {
				criteria.andBillingDateGreaterThanOrEqualTo(inv.getStartBillingDate());
			} else if (inv.getEndBillingDate() != null) {
				criteria.andBillingDateLessThanOrEqualTo(inv.getEndBillingDate());
			}
			if (inv.getStartCheckingDate() != null && inv.getEndCheckingDate() != null) {
				criteria.andCheckingDateBetween(inv.getStartCheckingDate(), inv.getEndCheckingDate());
			} else if (inv.getStartCheckingDate() != null) {
				criteria.andCheckingDateGreaterThanOrEqualTo(inv.getStartCheckingDate());
			} else if (inv.getEndCheckingDate() != null) {
				criteria.andCheckingDateLessThanOrEqualTo(inv.getEndCheckingDate());
			}
			if (inv.getStartCreateDate() != null && inv.getEndCreateDate() != null) {
				criteria.andCreateDateBetween(DateUtils.getStartDate(inv.getStartCreateDate()), DateUtils.getEndDate(inv.getEndCreateDate()));
			} else if (inv.getStartCreateDate() != null) {
				criteria.andCreateDateGreaterThanOrEqualTo(DateUtils.getStartDate(inv.getStartCreateDate()));
			} else if (inv.getEndCreateDate() != null) {
				criteria.andCreateDateLessThanOrEqualTo(DateUtils.getEndDate(inv.getEndCreateDate()));
			}
			criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		}
		// ????????????
		return example;
	}
	
	@Override
	public List<FeeInvoiceDetail> getInvoiceDetailById(String id) {
		FeeInvoiceDetailExample example = new FeeInvoiceDetailExample();
		FeeInvoiceDetailExample.Criteria criteria = example.createCriteria();
		criteria.andInvoiceIdEqualTo(id);
		List<FeeInvoiceDetail> detailList = feeInvoiceDetailMapper.selectByExample(example);
		return detailList;
	}
	
	@Override
	public void addContractBalance(String contractId,String createUser) {
		ConContractVo contract = contractService.getConContractById(contractId);
		if(contract != null) {
			if(contract.getContractState().equals(ContractBillStateEnum.COMPLETE.toString())) {
				List<FeeInvoiceDetail> inInvoice = feeInvoiceExtMapper.selectInvoice(contractId, InvoiceTypeEnum.IN_INVOICE.toString());
				List<FeeInvoiceDetail> outInvoice = feeInvoiceExtMapper.selectInvoice(contractId, InvoiceTypeEnum.OUT_INVOICE.toString());
				if(!inInvoice.isEmpty() && !outInvoice.isEmpty() && inInvoice != null && outInvoice != null) {
					//????????????(????????????????????????)??????????????????
					List<InContractRemitDetailVo> inContractRemitDetail  = instockBillService.findContractRecord(contractId);
					BigDecimal total =  new BigDecimal(0);
					BigDecimal invoiceMoney =  new BigDecimal(0);
					if(inContractRemitDetail != null ) {
						for(int j=0;j<inContractRemitDetail.size();j++) {
							BigDecimal money = inContractRemitDetail.get(j).getDetail().getMoney();
							total = total.add(money);
						}
					}
					//??????????????????(???????????????????????????)
					FeeInvoiceDetailExample example = new FeeInvoiceDetailExample();
					FeeInvoiceDetailExample.Criteria criteria = example.createCriteria();
					criteria.andContractIdEqualTo(contractId);
					List<FeeInvoiceDetail> detailList = feeInvoiceDetailMapper.selectByExample(example);
					if(detailList != null ) {
						for(int i=0;i<detailList.size();i++) {
							String invoiceId = detailList.get(i).getInvoiceId();
							FeeInvoiceExample example1 = new FeeInvoiceExample();
							FeeInvoiceExample.Criteria criteria1 = example1.createCriteria();
							criteria1.andInvoiceIdEqualTo(invoiceId);
							List<FeeInvoice> invoice = feeInvoiceMapper.selectByExample(example1);
							if(invoice != null) {
								if(invoice.get(0).getInvoiceType().equals(InvoiceTypeEnum.IN_INVOICE.toString())) {
									BigDecimal fee = detailList.get(i).getInvoiceMoney();
									invoiceMoney = invoiceMoney.add(fee);
								}
							}
						}
					}
					//??????
					BigDecimal balance =  total.subtract(invoiceMoney);
					FeeContractBalance feeContractBalance = new FeeContractBalance();
					if(balance.compareTo(BigDecimal.ZERO) <= 0) {
						feeContractBalance.setBalance(BigDecimal.ZERO);
					}else {
						feeContractBalance.setBalance(balance);
					}
					feeContractBalance.setContractId(contractId);
					feeContractBalance.setContractAmount(total);
					feeContractBalance.setRansomFee(invoiceMoney);
					feeContractBalance.setCreateDate(new Date());
					feeContractBalance.setCreateUser(createUser);
					feeContractBalanceMapper.insertSelective(feeContractBalance);
					//??????????????????
					invInventoryService.saveOrUpdateFeeBalance(contractId,balance,createUser);
				}
			}
		}
	}
	
	@Override
	public int updateFeeInvoice(FeeInvoice feeInvoice) {
		if (StringUtils.isEmpty(feeInvoice.getInvoiceId())) {
			return 0;
		}
		return feeInvoiceMapper.updateByPrimaryKeySelective(feeInvoice);
	}
	
	@Override
	public int deleteInvoiceDetail(String invoiceDetailId) {
		if (StringUtils.isEmpty(invoiceDetailId)) {
			return 0;
		}
		FeeInvoiceDetail feeInvoiceDetail = new FeeInvoiceDetail();
		feeInvoiceDetail.setInvoiceDetailId(invoiceDetailId);
		feeInvoiceDetail.setIsDel(YesOrNoEnum.YES.toString());
		return feeInvoiceDetailMapper.updateByPrimaryKeySelective(feeInvoiceDetail);
	}
	
	@Override
	public FeeInvoiceDetail addFeeInvoiceDetail(FeeInvoiceDetail feeInvoiceDetail) {
		if (feeInvoiceDetail == null) {
			return null;
		}
		feeInvoiceDetail.setIsDel(YesOrNoEnum.NO.getCode());
		int rows = feeInvoiceDetailMapper.insertSelective(feeInvoiceDetail);
		return rows == 0 ? null : feeInvoiceDetail;
	}
	
	@Override
	public List<FeeInvoice> getInvoiceById(String id) {
		FeeInvoiceExample example = new FeeInvoiceExample();
		FeeInvoiceExample.Criteria criteria = example.createCriteria();
		criteria.andInvoiceIdEqualTo(id);
		return feeInvoiceMapper.selectByExample(example);
	}
}
