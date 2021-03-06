package com.maigangle.gyl.service.impl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.ConContractDetail;
import com.maigangle.gyl.facade.entity.ConContractDetailExample;
import com.maigangle.gyl.facade.entity.ConContractExample;
import com.maigangle.gyl.facade.entity.ConDepositDetail;
import com.maigangle.gyl.facade.entity.ConDepositDetailExample;
import com.maigangle.gyl.facade.entity.ConFeeRates;
import com.maigangle.gyl.facade.entity.ConFeeRatesExample;
import com.maigangle.gyl.facade.entity.ConPaymentDetail;
import com.maigangle.gyl.facade.entity.ConPaymentDetailExample;
import com.maigangle.gyl.facade.entity.FeeContractBalance;
import com.maigangle.gyl.facade.entity.FeeContractBalanceExample;
import com.maigangle.gyl.facade.entity.FeeInvoiceDetail;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.SysApprovalFlow;
import com.maigangle.gyl.facade.entity.SysApprovalFlowExample;
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
import com.maigangle.gyl.facade.enums.ApprovalSpeciesEnum;
import com.maigangle.gyl.facade.enums.ContractBillStateEnum;
import com.maigangle.gyl.facade.enums.ContractBillTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceStateEnum;
import com.maigangle.gyl.facade.enums.GoodsSourceEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.utils.DateUtils;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.ConContractDetailMapper;
import com.maigangle.gyl.service.mapper.ConContractMapper;
import com.maigangle.gyl.service.mapper.ConDepositDetailMapper;
import com.maigangle.gyl.service.mapper.ConFeeRatesMapper;
import com.maigangle.gyl.service.mapper.ConPaymentDetailMapper;
import com.maigangle.gyl.service.mapper.FeeContractBalanceMapper;
import com.maigangle.gyl.service.mapper.SysApprovalFlowMapper;
import com.maigangle.gyl.service.mapper.ext.ConContractDetaiExtlMapper;
import com.maigangle.gyl.service.mapper.ext.ConContractExtMapper;
import com.maigangle.gyl.service.mapper.ext.ContractBalanceExtMapper;

@SuppressWarnings("rawtypes")
@Service
@Transactional
public class ContractServiceImpl extends GylServiceImpl implements ContractService {
	@Autowired
	private ConContractMapper conContractMapper;
	@Autowired
	private ConContractExtMapper conContractExtMapper;
	@Autowired
	private ConContractDetailMapper conContractDetailMapper;
	@Autowired
	private ConDepositDetailMapper conDepositDetailMapper;
	@Autowired
	private ConPaymentDetailMapper conPaymentDetailMapper;
	@Autowired
	private ConContractDetaiExtlMapper conContractDetaiExtlMapper;
	@Autowired
	private ConFeeRatesMapper conFeeRatesMapper;
	@Autowired
	private InstockBillService instockBillService;
	@Autowired
	private SysApprovalFlowMapper sysApprovalFlowMapper;
	@Autowired
	private FeeContractBalanceMapper feeContractBalanceMapper;
	@Autowired
	private ContractBalanceExtMapper contractBalanceExtMapper;
	@Autowired
	private FinanceService financeService;
	
	@Override
	public ConContract addConContract(ConContract conContract) {
		if (conContract == null) {
			return null;
		}
		int rows = conContractMapper.insertSelective(conContract);
		return rows == 0 ? null : conContract;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<ConContractVo> getConContracts(PageUtils<ConContractDto> page, boolean isAccuracy) {
		if (page != null) {
			// ????????????
			setPageAndOrderBy(page);
			// ????????????
			ConContractExample example = this.getConContractCriteria(page.getDto(), isAccuracy);
			List<ConContractVo> list = conContractExtMapper.selectByExample(example);
			return new PageInfo<ConContractVo>(list);
		}
		return null;
	}
	
	@Override
	public List<ConContractSelectVo> getConContractForSelect(ConContractDto conContractDto, boolean isAccuracy) {
		if (conContractDto == null) {
			return null;
		}
		// ????????????
//		PageHelper.startPage(0, 20);
//		PageHelper.orderBy("CONTRACT_ID");
		// ????????????
		ConContractExample example = this.getConContractCriteriaForSelect(conContractDto, isAccuracy);
		example.setOrderByClause("CONTRACT_CODE");
		List<ConContractVo> resultList = conContractExtMapper.selectByExample(example);
		List<ConContractSelectVo> list = new ArrayList<>();
		if (resultList != null && !resultList.isEmpty()) {
			for (ConContractVo conContract : resultList) {
				ConContractSelectVo vo = new ConContractSelectVo();
				vo.setContractId(conContract.getContractId());
				vo.setContractCode(conContract.getContractCode());
				vo.setContractNo(conContract.getContractNo());
				list.add(vo);
			}
		}
		return list;
	}
	
	@Override
	public List<ConContractVo> getConContracts(ConContractDto conContractDto, String orderByClause, boolean isAccuracy) {
		if (conContractDto == null) {
			return null;
		}
		PageUtils<ConContractDto> page = new PageUtils<ConContractDto>(1, 0, conContractDto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<ConContractVo> info = this.getConContracts(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public ConContractVo getConContractById(String contractId) {
		if (!StringUtils.isEmpty(contractId)) {
			return conContractExtMapper.selectByPrimaryKey(contractId);
		}
		return null;
	}
	
	@Override
	public ConContractVo getConContractByCode(String contractCode) {
		ConContractDto dto = new ConContractDto();
		dto.setContractCode(contractCode);
		List<ConContractVo> list = this.getConContracts(dto, "", false);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public ConContractVo getConContractByNo(String contractNo) {
		if (!StringUtils.isEmpty(contractNo)) {
			ConContractDto dto = new ConContractDto();
			dto.setContractNo(contractNo);
			List<ConContractVo> list = this.getConContracts(dto, "", true);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public ConContract updateConContract(ConContract conContract) {
		if (conContract != null && !StringUtils.isEmpty(conContract.getContractId())) {
			int rows = conContractMapper.updateByPrimaryKeySelective(conContract);
			return rows == 0 ? null : conContract;
		}
		return null;
	}

	@Override
	public int deleteConContract(String contractId) {
		if (!StringUtils.isEmpty(contractId)) {
			ConContract c = new ConContract();
			c.setContractId(contractId);
			c.setIsDel(YesOrNoEnum.YES.toString());
			return conContractMapper.updateByPrimaryKeySelective(c);
		}
		return 0;
	}


	
	@Override
	public ConContract updateConContractState(String contractId) {
		if (StringUtils.isEmpty(contractId)) {
			return null;
		}
		ConContract contract = new ConContract();
		contract.setContractId(contractId);
		contract.setContractState(ContractBillStateEnum.COMPLETE.toString());
		int row = conContractMapper.updateByPrimaryKeySelective(contract);
		financeService.addContractBalance(contract.getContractId(), contract.getCreateUser());
		return row == 0 ? null : contract;
	}

	/**
	 * ??????ConContract???????????????
	 * @param dto
	 * @return ConContractExample
	 */
	private ConContractExample getConContractCriteria(ConContractDto dto, boolean isAccuracy) {
		ConContractExample example = new ConContractExample();
		if (dto != null) {
			ConContractExample.Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(dto.getContractId())) {
				criteria.andContractIdEqualTo(dto.getContractId());
			}
			if (!StringUtils.isEmpty(dto.getContractType())) {
				criteria.andContractTypeEqualTo(dto.getContractType());
			}
			if (!StringUtils.isEmpty(dto.getRelativeContractId())) {
				criteria.andRelativeContractIdEqualTo(dto.getRelativeContractId());
			}
			if (!StringUtils.isEmpty(dto.getContractNo())) {
				if (isAccuracy) {
					criteria.andContractNoEqualTo(dto.getContractNo().toUpperCase());
				} else {
					criteria.andContractNoLike("%" + dto.getContractNo().toUpperCase() + "%");
				}
			}
			if (!StringUtils.isEmpty(dto.getRepurchaseAgreementNo())) {
				criteria.andRepurchaseAgreementNoEqualTo(dto.getRepurchaseAgreementNo());
			}
			if (dto.getSignDate() != null) {
				Calendar c = Calendar.getInstance();
				c.setTime(dto.getSignDate());
				c.add(Calendar.DATE, 1);
				criteria.andSignDateBetween(dto.getSignDate(), c.getTime());
			} else if (dto.getStartSignDate() != null && dto.getEndSignDate() != null) {
				criteria.andSignDateBetween(dto.getStartSignDate(), dto.getEndSignDate());
			} else if (dto.getStartSignDate() != null) {
				criteria.andSignDateGreaterThanOrEqualTo(dto.getStartSignDate());
			} else if (dto.getEndSignDate() != null) {
				criteria.andSignDateLessThanOrEqualTo(dto.getEndSignDate());
			}
			if (!StringUtils.isEmpty(dto.getSigingPlace())) {
				if (isAccuracy) {
					criteria.andSigingPlaceEqualTo(dto.getSigingPlace());
				} else {
					criteria.andSigingPlaceLike("%" + dto.getSigingPlace() + "%");
				}
			}
			if (!StringUtils.isEmpty(dto.getSellerId())) {
				criteria.andSellerIdEqualTo(dto.getSellerId());
			}
			if (!StringUtils.isEmpty(dto.getBuyerId())) {
				criteria.andBuyerIdEqualTo(dto.getBuyerId());
			}
			if (!StringUtils.isEmpty(dto.getSupplierInvoiceStatus())) {
				criteria.andSupplierInvoiceStatusEqualTo(dto.getSupplierInvoiceStatus());
			}
			if (!StringUtils.isEmpty(dto.getDeliveryAddress())) {
				if (isAccuracy) {
					criteria.andDeliveryAddressEqualTo(dto.getDeliveryAddress());
				} else {
					criteria.andDeliveryAddressLike("%" + dto.getDeliveryAddress() + "%");
				}
			}
			if (dto.getStartDeliveryDate() != null && dto.getEndDeliveryDate() != null) {
				criteria.andDeliveryDateBetween(dto.getStartDeliveryDate(), dto.getEndDeliveryDate());
			} else if (dto.getStartDeliveryDate() != null) {
				criteria.andDeliveryDateGreaterThanOrEqualTo(dto.getStartDeliveryDate());
			} else if (dto.getEndDeliveryDate() != null) {
				criteria.andDeliveryDateLessThanOrEqualTo(dto.getEndDeliveryDate());
			}
			if (dto.getTotalWeight() != null) {
				criteria.andTotalWeightEqualTo(dto.getTotalWeight());
			} else if (dto.getMinTotalWeight() != null && dto.getMaxTotalWeight() != null) {
				criteria.andTotalWeightBetween(dto.getMinTotalWeight(), dto.getMaxTotalWeight());
			} else if (dto.getMinTotalWeight() != null) {
				criteria.andTotalWeightGreaterThanOrEqualTo(dto.getMinTotalWeight());
			} else if (dto.getMaxTotalWeight() != null) {
				criteria.andTotalWeightLessThanOrEqualTo(dto.getMaxTotalWeight());
			}
			if (dto.getTotalMoney() != null) {
				criteria.andTotalMoneyEqualTo(dto.getTotalMoney());
			} else if (dto.getMinTotalMoney() != null && dto.getMaxTotalMoney() != null){
				criteria.andTotalMoneyBetween(dto.getMinTotalMoney(), dto.getMaxTotalMoney());
			} else if (dto.getMinTotalMoney() != null) {
				criteria.andTotalMoneyGreaterThanOrEqualTo(dto.getMinTotalMoney());
			} else if (dto.getMaxTotalMoney() != null) {
				criteria.andTotalMoneyLessThanOrEqualTo(dto.getMaxTotalMoney());
			}
			if (dto.getDepositRate() != null) {
				criteria.andDepositRateEqualTo(dto.getDepositRate());
			} else if (dto.getMinDepositRate() != null && dto.getMaxDepositRate() != null){
				criteria.andDepositRateBetween(dto.getMinDepositRate(), dto.getMaxDepositRate());
			} else if (dto.getMinDepositRate() != null) {
				criteria.andDepositRateGreaterThanOrEqualTo(dto.getMinDepositRate());
			} else if (dto.getMaxDepositRate() != null) {
				criteria.andDepositRateLessThanOrEqualTo(dto.getMaxDepositRate());
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
			if (dto.getCommissionRate() != null) {
				criteria.andCommissionRateEqualTo(dto.getCommissionRate());
			} else if (dto.getMinCommissionRate() != null && dto.getMaxCommissionRate() != null){
				criteria.andCommissionRateBetween(dto.getMinCommissionRate(), dto.getMaxCommissionRate());
			} else if (dto.getMinCommissionRate() != null) {
				criteria.andCommissionRateGreaterThanOrEqualTo(dto.getMinCommissionRate());
			} else if (dto.getMaxCommissionRate() != null) {
				criteria.andCommissionRateLessThanOrEqualTo(dto.getMaxCommissionRate());
			}
			if (dto.getInvoiceBaseFee() != null) {
				criteria.andInvoiceBaseFeeEqualTo(dto.getInvoiceBaseFee());
			} else if (dto.getMinInvoiceBaseFee() != null && dto.getMaxInvoiceBaseFee() != null){
				criteria.andInvoiceBaseFeeBetween(dto.getMinInvoiceBaseFee(), dto.getMaxInvoiceBaseFee());
			} else if (dto.getMinInvoiceBaseFee() != null) {
				criteria.andInvoiceBaseFeeGreaterThanOrEqualTo(dto.getMinInvoiceBaseFee());
			} else if (dto.getMaxInvoiceBaseFee() != null) {
				criteria.andInvoiceBaseFeeLessThanOrEqualTo(dto.getMaxInvoiceBaseFee());
			}
			if (dto.getStartContractPeriod() != null && dto.getEndContractPeriod() != null) {
				criteria.andContractPeriodBetween(dto.getStartContractPeriod(), dto.getEndContractPeriod());
			} else if (dto.getStartContractPeriod() != null) {
				criteria.andContractPeriodGreaterThanOrEqualTo(dto.getStartContractPeriod());
			} else if (dto.getEndContractPeriod() != null) {
				criteria.andContractPeriodLessThanOrEqualTo(dto.getEndContractPeriod());
			}
			if (!StringUtils.isEmpty(dto.getContractState())) {
				criteria.andContractStateEqualTo(dto.getContractState());
			}
			if (!StringUtils.isEmpty(dto.getArchived())) {
				criteria.andArchivedEqualTo(dto.getArchived());
			}
			if (!StringUtils.isEmpty(dto.getCreateUser())) {
				if (isAccuracy) {
					criteria.andCreateUserEqualTo(dto.getCreateUser());
				} else {
					criteria.andCreateUserLike("%" + dto.getCreateUser() + "%");
				}
			}
			if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
				criteria.andCreateDateBetween(DateUtils.getStartDate(dto.getStartCreateDate()), DateUtils.getEndDate(dto.getEndCreateDate()));
			} else if (dto.getStartCreateDate() != null) {
				criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
			} else if (dto.getEndCreateDate() != null) {
				criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
			}
			if (!StringUtils.isEmpty(dto.getIsDel())) {
				criteria.andIsDelEqualTo(dto.getIsDel());
			}
			if (!StringUtils.isEmpty(dto.getContractCode())) {
				if (isAccuracy) {
					criteria.andContractCodeEqualTo(dto.getContractCode().toUpperCase());
				} else {
					criteria.andContractCodeLike("%" + dto.getContractCode().toUpperCase() + "%");
				}
			}
			if (!StringUtils.isEmpty(dto.getMallMnfct())) {
				criteria.andMallMnfctEqualTo(dto.getMallMnfct());
			}
			/**
			 * ?????????????????????
			 */
			if(dto.getApprove()!=null&&dto.getApprove()) {
				SysApprovalFlowExample eFlowExample = new SysApprovalFlowExample();
				SysApprovalFlowExample.Criteria eCriteria = eFlowExample.createCriteria();
				eCriteria.andModuleEqualTo(ApprovalSpeciesEnum.CONTRACT.toString());
				eCriteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
				List<SysApprovalFlow> list = sysApprovalFlowMapper.selectByExample(eFlowExample);
				List<String> stringsList = new ArrayList<>();
				for (SysApprovalFlow sysApprovalFlow : list) {
					System.out.println(sysApprovalFlow.getApprovalItemId());
					stringsList.add(sysApprovalFlow.getApprovalItemId());
				}
				if(stringsList!=null&&!stringsList.isEmpty()) {
					criteria.andContractIdIn(stringsList);					
				}
			}
		}
		return example;
	}
	
	
	private ConContractExample getConContractCriteriaForSelect(ConContractDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		ConContractExample example = new ConContractExample();
		ConContractExample.Criteria critreia = example.createCriteria();
		if (!StringUtils.isEmpty(dto.getSellerId())) {
			critreia.andSellerIdEqualTo(dto.getSellerId());
		}
		if (!StringUtils.isEmpty(dto.getContractCode())) {
			critreia.andContractCodeLike("%" + dto.getContractCode().toUpperCase() + "%");
		}
		if (!StringUtils.isEmpty(dto.getContractId())) {
			critreia.andContractIdEqualTo(dto.getContractId());
		}
		// ???????????????????????????
		if (!StringUtils.isEmpty(dto.getGoodsSource())) {
			critreia.andContractTypeNotEqualTo(ContractBillTypeEnum.CAI_GOU_ZI_XIAO.toString());
			if (dto.getGoodsSource().equals(GoodsSourceEnum.CANG_DAN_ZHI_YA.toString())) {
				critreia.andContractTypeEqualTo(ContractBillTypeEnum.CANG_DAN_ZHI_YA.toString());
			} else if (dto.getGoodsSource().equals(GoodsSourceEnum.GANG_CHANG_ZI_TI.toString())){
				critreia.andContractTypeEqualTo(ContractBillTypeEnum.DING_XIANG_XIAO_SHOU.toString());
			} else if (dto.getGoodsSource().equals(GoodsSourceEnum.KU_CUN_HUO_WU.toString())) {
				critreia.andContractTypeNotEqualTo(ContractBillTypeEnum.CANG_DAN_ZHI_YA.toString());
			}
			critreia.andContractStateEqualTo(ContractBillStateEnum.UNDERWAY.toString());
		}
		return example;
	}
	
	@Override
	public ConContractDetail addConContractDetail(ConContractDetail detail) {
		if (detail == null) {
			return null;
		}
		int rows = conContractDetailMapper.insertSelective(detail);
		return rows == 0 ? null : detail;
	}

	@Override
	public List<ConContractDetail> addConContractDetailBatch(List<ConContractDetail> detailList) {
		List<ConContractDetail> resultList = new ArrayList<>();
		if (detailList != null && !detailList.isEmpty()) {
			for (int i = 0; i < detailList.size(); i++) {
				resultList.add(addConContractDetail(detailList.get(i)));
			}
		}
		return resultList;
	}

	@Override
	public ConContractDetail updateConContractDetail(ConContractDetail detail) {
		if (StringUtils.isEmpty(detail.getContractDetailId())) {
			return null;
		}
		int rows = conContractDetailMapper.updateByPrimaryKeySelective(detail);
		return rows == 0 ? null : detail;
	}

	@Override
	public List<ConContractDetail> updateConContractDetailBatch(List<ConContractDetail> detailList) {
		List<ConContractDetail> list = new ArrayList<>();
		if (detailList != null && !detailList.isEmpty()) {
			for (int i = 0; i < detailList.size(); i++) {
				list.add(updateConContractDetail(detailList.get(i)));
			}
		}
		return list;
	}

	@Override
	public int deteleConContractDetail(String detailId) {
		if (StringUtils.isEmpty(detailId)) {
			return 0;
		}
		ConContractDetail detail = new ConContractDetail();
		detail.setContractDetailId(detailId);
		detail.setIsDel(YesOrNoEnum.YES.toString());
		return conContractDetailMapper.updateByPrimaryKeySelective(detail);
	}

	@Override
	public int deteleConContractDetailBatch(List<String> ids) {
		int resultInt = 0;
		if (ids != null && !ids.isEmpty()) {
			for (int i = 0; i < ids.size(); i++) {
				resultInt += deteleConContractDetail(ids.get(i));
			}
		}
		return resultInt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<ConContractDetailVo> getConContractDetails(PageUtils<ConContractDetailDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		ConContractDetailExample example = this.getConContractDetailCriteria(page.getDto(), isAccuracy);
		List<ConContractDetailVo> list = conContractDetaiExtlMapper.selectByExample(example);
		return new PageInfo<ConContractDetailVo>(list);
	}

	@Override
	public List<ConContractDetailVo> getConContractDetails(ConContractDetailDto detail, String orderByClause, boolean isAccuracy) {
		if (detail == null) {
			return null;
		}
		PageUtils<ConContractDetailDto> page = new PageUtils<ConContractDetailDto>(1, 0, detail);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<ConContractDetailVo> info = this.getConContractDetails(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public ConContractDetailVo getConContractDetail(String detailId) {
		if (StringUtils.isEmpty(detailId)) {
			return null;
		}
		return conContractDetaiExtlMapper.selectByPrimaryKey(detailId);
	}
	
	
	@Override
	public List<ConContractDetailVo> getConContractDetailsByContractId(String contractId) {
		if (StringUtils.isEmpty(contractId)) {
			return null;
		}
		ConContractDetailDto detail = new ConContractDetailDto();
		detail.setContractId(contractId);
		return getConContractDetails(detail, null, true);
	}

	/**
	 * ????????????
	 * @param detail
	 * @param isAccuracy
	 * @return
	 */
	private ConContractDetailExample getConContractDetailCriteria(ConContractDetailDto detail, boolean isAccuracy) {
		if (detail == null) {
			return null;
		}
		ConContractDetailExample examlpe = new ConContractDetailExample();
		ConContractDetailExample.Criteria criteria = examlpe.createCriteria();
		if (!StringUtils.isEmpty(detail.getContractId())) {
			criteria.andContractIdEqualTo(detail.getContractId());
		}
		if (detail.getStartStorageDate() != null && detail.getEndStorageDate() != null) {
			criteria.andStorageDateBetween(detail.getStartStorageDate(), detail.getEndStorageDate());
		} else if (detail.getStartStorageDate() != null) {
			criteria.andStorageDateGreaterThanOrEqualTo(detail.getStartStorageDate());
		} else if (detail.getEndStorageDate() != null) {
			criteria.andStorageDateLessThanOrEqualTo(detail.getEndStorageDate());
		}
		if (!StringUtils.isEmpty(detail.getStorageId())) {
			criteria.andStorageIdEqualTo(detail.getStorageId());
		}
		if (!StringUtils.isEmpty(detail.getIsDel())) {
			criteria.andIsDelEqualTo(detail.getIsDel());
		}
		return examlpe;
	}
	@Override
	public ConDepositDetail addConDepositDetail(ConDepositDetail detail) {
		if (detail == null) {
			return null;
		}
		int rows = conDepositDetailMapper.insertSelective(detail);
		return rows == 0 ? null : detail;
	}

	@Override
	public List<ConDepositDetail> addConDepositDetailBatch(List<ConDepositDetail> detailList) {
		List<ConDepositDetail> resultList = new ArrayList<>();
		if (detailList != null && !detailList.isEmpty()) {
			for (int i = 0; i < detailList.size(); i++) {
				resultList.add(addConDepositDetail(detailList.get(i)));
			}
		}
		return resultList;
	}

	@Override
	public ConDepositDetail updateConDepositDetail(ConDepositDetail detail) {
		if (StringUtils.isEmpty(detail.getDepositDetailId())) {
			return null;
		}
		int rows = conDepositDetailMapper.updateByPrimaryKeySelective(detail);
		return rows == 0 ? null : detail;
	}
	
	@Override
	public ConDepositDetail updateConDepositDetailState(String contractId, String finaceId) {
		ConDepositDetail depositDetail = new ConDepositDetail();
		depositDetail.setContractId(contractId);
		depositDetail.setFinanceId(finaceId);
		depositDetail.setState(FinanceStateEnum.YI_WAN_CHENG.toString());
		return updateConDepositDetail(depositDetail);
	}

	@Override
	public List<ConDepositDetail> updateConDepositDetailBatch(List<ConDepositDetail> detailList) {
		List<ConDepositDetail> list = new ArrayList<>();
		if (detailList != null && !detailList.isEmpty()) {
			for (int i = 0; i < detailList.size(); i++) {
				list.add(updateConDepositDetail(detailList.get(i)));
			}
		}
		return list;
	}

	@Override
	public int deleteConDepositDetail(String deltailId) {
		if (StringUtils.isEmpty(deltailId)) {
			return 0;
		}
		ConDepositDetail detail = new ConDepositDetail();
		detail.setDepositDetailId(deltailId);
		detail.setIsDel(YesOrNoEnum.YES.toString());
		return conDepositDetailMapper.updateByPrimaryKeySelective(detail);
	}

	@Override
	public int deleteConDepositDetailBatch(List<String> deltailIds) {
		if (deltailIds == null || deltailIds.isEmpty()) {
			return 0;
		}
		int resultInt = 0;
		for (int i = 0; i < deltailIds.size(); i++) {
			resultInt += this.deleteConDepositDetail(deltailIds.get(i));
		}
		return resultInt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<ConDepositDetail> getConDepositDetails(PageUtils<ConDepositDetailDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		ConDepositDetailExample example = this.getConDepositDetailCriteria(page.getDto(), isAccuracy);
		List<ConDepositDetail> list = conDepositDetailMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<ConDepositDetail> getConDepositDetails(ConDepositDetailDto dto, String orderByClause, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<ConDepositDetailDto> page = new PageUtils<>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<ConDepositDetail> info = this.getConDepositDetails(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public ConDepositDetail getConDepositDetail(String detailId) {
		if (StringUtils.isEmpty(detailId)) {
			return null;
		}
		return conDepositDetailMapper.selectByPrimaryKey(detailId);
	}

	/**
	 * ????????????
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	private ConDepositDetailExample getConDepositDetailCriteria(ConDepositDetailDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		ConDepositDetailExample example = new ConDepositDetailExample();
		ConDepositDetailExample.Criteria criteria = example.createCriteria();
		if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
			criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
		} else if (dto.getStartCreateDate() != null) {
			criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
		} else if(dto.getEndCreateDate() != null) {
			criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
		}
		if (dto.getMoney() != null) {
			criteria.andMoneyEqualTo(dto.getMoney());
		} else if (dto.getMinMoney() != null && dto.getMaxMoney() != null) {
			criteria.andMoneyBetween(dto.getMinMoney(), dto.getMaxMoney());
		} else if(dto.getMinMoney() != null) {
			criteria.andMoneyGreaterThanOrEqualTo(dto.getMinMoney());
		} else if(dto.getMaxMoney() != null) {
			criteria.andMoneyLessThanOrEqualTo(dto.getMaxMoney());
		}
		if (!StringUtils.isEmpty(dto.getCreateUser())) {
			if (isAccuracy) {
				criteria.andCreateUserEqualTo(dto.getCreateUser());
			} else {
				criteria.andCreateUserLike("%" + dto.getCreateUser() + "%");
			}
		}
		if (!StringUtils.isEmpty(dto.getIsDel())) {
			criteria.andIsDelEqualTo(dto.getIsDel());
		}
		if (!StringUtils.isEmpty(dto.getContractId())) {
			criteria.andContractIdEqualTo(dto.getContractId());
		}
		return example;
	}

	@Override
	public ConPaymentDetail addConPaymentDetail(ConPaymentDetail conPaymentDetail) {
		if (conPaymentDetail == null) {
			return null;
		}
		int rows = conPaymentDetailMapper.insertSelective(conPaymentDetail);
		return rows == 0 ? null : conPaymentDetail;
	}

	@Override
	public List<ConPaymentDetail> addConPaymentDetailBatch(List<ConPaymentDetail> detailList) {
		List<ConPaymentDetail> resultList = new ArrayList<>();
		if (detailList != null && !detailList.isEmpty()) {
			for (int i = 0; i < detailList.size(); i++) {
				resultList.add(addConPaymentDetail(detailList.get(i)));
			}
		}
		return resultList;
	}

	@Override
	public ConPaymentDetail updateConPaymentDetail(ConPaymentDetail conPaymentDetail) {
		if (StringUtils.isEmpty(conPaymentDetail.getPaymentDetailId())) {
			return null;
		}
		int rows = conPaymentDetailMapper.updateByPrimaryKeySelective(conPaymentDetail);
		return rows == 0 ? null : conPaymentDetail;
	}
	
	@Override
	public ConPaymentDetail updateConPaymentDetailState(String contractId, String financeId, String id) {
		ConPaymentDetail paymentDetail = new ConPaymentDetail();
		paymentDetail.setPaymentDetailId(id);
		paymentDetail.setContractId(contractId);
		paymentDetail.setFinanceId(financeId);
		paymentDetail.setState(FinanceStateEnum.YI_WAN_CHENG.toString());
		return updateConPaymentDetail(paymentDetail);
	}

	@Override
	public List<ConPaymentDetail> updateConPaymentDetailBatch(List<ConPaymentDetail> detailList) {
		List<ConPaymentDetail> list = new ArrayList<>();
		if (detailList != null && !detailList.isEmpty()) {
			for (int i = 0; i < detailList.size(); i++) {
				list.add(updateConPaymentDetail(detailList.get(i)));
			}
		}
		return list;
	}

	@Override
	public int deleteConPaymentDetail(String detailId) {
		if (StringUtils.isEmpty(detailId)) {
			return 0;
		}
		ConPaymentDetail detail = new ConPaymentDetail();
		detail.setPaymentDetailId(detailId);
		detail.setIsDel(YesOrNoEnum.YES.toString());
		return conPaymentDetailMapper.updateByPrimaryKeySelective(detail);
	}

	@Override
	public int deleteConPaymentDetailBatch(List<String> detailIds) {
		if (detailIds == null || detailIds.isEmpty()) {
			return 0;
		}
		int resutlInt = 0;
		for (int i = 0; i < detailIds.size(); i++) {
			resutlInt += this.deleteConPaymentDetail(detailIds.get(i));
		}
		return resutlInt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<ConPaymentDetail> getConPaymentDetails(PageUtils<ConPaymentDetailDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		ConPaymentDetailExample example = this.getConPaymentDetailCriteria(page.getDto(), isAccuracy);
		List<ConPaymentDetail> list = conPaymentDetailMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<ConPaymentDetail> getConPaymentDetails(ConPaymentDetailDto dto, String orderByClause, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<ConPaymentDetailDto> page = new PageUtils<>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<ConPaymentDetail> info = this.getConPaymentDetails(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public ConPaymentDetail getConPaymentDetail(String detailId) {
		if (StringUtils.isEmpty(detailId)) {
			return null;
		}
		return conPaymentDetailMapper.selectByPrimaryKey(detailId);
	}
	
	/**
	 * ????????????
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	private ConPaymentDetailExample getConPaymentDetailCriteria(ConPaymentDetailDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		ConPaymentDetailExample example = new ConPaymentDetailExample();
		ConPaymentDetailExample.Criteria criteria = example.createCriteria();
		if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
			criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
		} else if (dto.getStartCreateDate() != null) {
			criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
		} else if (dto.getEndCreateDate() != null) {
			criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
		}
		if (!StringUtils.isEmpty(dto.getIsDel())) {
			criteria.andIsDelEqualTo(dto.getIsDel());
		}
		if (!StringUtils.isEmpty(dto.getContractId())) {
			criteria.andContractIdEqualTo(dto.getContractId());
		}
		return example;
	}

	public boolean isContractNoExist(String contractNo) {
		if (StringUtils.isEmpty(contractNo)) {
			return true;
		}
		int rows = conContractExtMapper.selectByNo(contractNo);
		return rows == 0 ? false : true;
	}

	@Override
	public ConFeeRates addConFeeRates(ConFeeRates conFeeRates) {
		if (conFeeRates == null) {
			return null;
		}
		int row = conFeeRatesMapper.insertSelective(conFeeRates);
		return row == 0 ? null : conFeeRates;
	}

	@Override
	public List<ConFeeRates> addConFeeRatesBatch(List<ConFeeRates> conFeeRateses) {
		if (conFeeRateses == null || conFeeRateses.isEmpty()) {
			return null;
		}
		List<ConFeeRates> list = new ArrayList<>();
		for(ConFeeRates feeRates : conFeeRateses) {
			list.add(addConFeeRates(feeRates));
		}
		return list;
	}

	@Override
	public int deleteConFeeRates(String feeRatesId) {
		if (StringUtils.isEmpty(feeRatesId)) {
			 return 0;
		}
		ConFeeRates feeRates = new ConFeeRates();
		feeRates.setFeeRatesId(feeRatesId);
		feeRates.setIsDel(YesOrNoEnum.YES.toString());
		return conFeeRatesMapper.updateByPrimaryKeySelective(feeRates);
	}

	@Override
	public int deleteConFeeRatesBatch(List<String> feeRatesIds) {
		if (feeRatesIds == null || feeRatesIds.isEmpty()) {
			return 0;
		}
		int result = 0;
		for (String id : feeRatesIds) {
			result += deleteConFeeRates(id);
		}
		return result;
	}

	@Override
	public ConFeeRates updateConFeeRates(ConFeeRates conFeeRates) {
		if (conFeeRates == null || StringUtils.isEmpty(conFeeRates.getFeeRatesId())) {
			return null;
		}
		int row = conFeeRatesMapper.updateByPrimaryKeySelective(conFeeRates);
		return row == 0 ? null : conFeeRates;
	}

	@Override
	public List<ConFeeRates> updateConFeeRatesBatch(List<ConFeeRates> conFeeRateses) {
		if (conFeeRateses == null || conFeeRateses.isEmpty()) {
			return null;
		}
		List<ConFeeRates> list = new ArrayList<>();
		for (ConFeeRates feeRates : conFeeRateses) {
			list.add(updateConFeeRates(feeRates));
		}
		return list == null ? null : list;
	}

	@Override
	public PageInfo<ConFeeRates> getConFeeRates(PageUtils<ConFeeRates> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		ConFeeRatesExample example = getConFeeRatesExample(page.getDto(), isAccuracy);
		List<ConFeeRates> list = conFeeRatesMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<ConFeeRates> getConFeeRates(ConFeeRates conFeeRates, String orderByClause, boolean isAccuracy) {
		if (conFeeRates == null) {
			return null;
		}
		PageUtils<ConFeeRates> page = new PageUtils<>(1, 0, conFeeRates);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<ConFeeRates> info = this.getConFeeRates(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public ConFeeRates getConFeeRates(String feeRatesId) {
		if (StringUtils.isEmpty(feeRatesId)) {
			return null;
		}
		return conFeeRatesMapper.selectByPrimaryKey(feeRatesId);
	}
	
	@Override
	public List<ConFeeRates> getConFeeRatesByContractId(String contractId) {
		if (StringUtils.isEmpty(contractId)) {
			return null;
		}
		ConFeeRates feeRates = new ConFeeRates();
		feeRates.setContractId(contractId);
		return getConFeeRates(feeRates, "FEE_DATES", true);
	}

	/**
	 * ???????????????????????????
	 * @param conFeeRates
	 * @param isAccuracy
	 * @return
	 */
	private ConFeeRatesExample getConFeeRatesExample(ConFeeRates conFeeRates, boolean isAccuracy) {
		if (conFeeRates == null) {
			return null;
		}
		ConFeeRatesExample example = new ConFeeRatesExample();
		ConFeeRatesExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(conFeeRates.getContractId())) {
			criteria.andContractIdEqualTo(conFeeRates.getContractId());
		}
		if (!StringUtils.isEmpty(conFeeRates.getIsOverdue())) {
			criteria.andIsOverdueEqualTo(conFeeRates.getIsOverdue());
		}
		if (!StringUtils.isEmpty(conFeeRates.getIsDel())) {
			criteria.andIsDelEqualTo(conFeeRates.getIsDel());
		}
		return example;
	}

	@Override
	public boolean onContractApprovalComplete(String id, PrivUser user) {
		ConContract contract = this.getConContractById(id);
		contract.setContractState(ContractBillStateEnum.UNDERWAY.toString());
		this.updateConContract(contract);
		InInstockBill bill = new InInstockBill();
		bill.setContractId(contract.getContractId());
		bill.setBusinessType(contract.getContractType());
		bill.setCreateUser(contract.getCreateUser());
		bill = instockBillService.addInstockBill(bill);
		if (bill != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onContractSumit (String id,PrivUser user) {
		ConContract contract = new ConContract();
		contract.setContractId(id);
		contract.setContractState(ContractBillStateEnum.UNDERWAY.toString());
		ConContract con = this.updateConContract(contract);
		return con!=null;
	}
	
	@Override
	public boolean onContractApproval(String id,PrivUser user) {
		ConContract contract = new ConContract();
		contract.setContractId(id);
		contract.setContractState(ContractBillStateEnum.APPROVAL.toString());
		ConContract con = this.updateConContract(contract);
		return con!=null;
	}
	@Override
	public boolean onContractApprovalSuspend(String id,PrivUser user){
		ConContract contract = new ConContract();
		contract.setContractId(id);
		contract.setContractState(ContractBillStateEnum.REJECT.toString());
		ConContract con = this.updateConContract(contract);
		return con!=null;
	}
	@Override
	public boolean  onContractAbandonApproval(String id,PrivUser user) {
		ConContract contract = new ConContract();
		contract.setContractId(id);
		contract.setContractState(ContractBillStateEnum.UNCOMMITE.toString());
		ConContract con = this.updateConContract(contract);
		return con!=null;
	}
	/***************************?????????1.1************************************************/
	@Override
	public int overContract(String contractId) {
		return conContractExtMapper.BathUpadate(contractId);
	}
	
	@Override
	public PageInfo<ConContractVo> getApproveConContracts(PageUtils<ConContractDto> page, boolean isAccuracy) {
		if (page != null) {
			// ????????????
			ConContractDto dto =  page.getDto();
			dto.setApprove(true);
			ConContractExample example = this.getConContractCriteria(dto, isAccuracy);
			 // example =  addQueryCondition(null);
			// ????????????
			setPageAndOrderBy(page);
			List<ConContractVo> list = conContractExtMapper.selectByExample(example);
			return new PageInfo<ConContractVo>(list);
		}
		return null;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: addQueryCondition 
	 * @Description: ( ??????????????????????????? )
	 * @param example
	 * @return ConContractExample
	 * @throws
	 */
	private ConContractExample addQueryCondition(ConContractExample example1) {
		ConContractExample example = new ConContractExample();
		ConContractExample.Criteria c = example.createCriteria();
		return example;
	}

	/**
	 * ???????????????????????????????????????
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<FeeContractBalance> getContractBalanceAll(PageUtils<ContractBalanceVo> page,Boolean isAccuracy) {
		if(page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		ContractBalanceVo dto = page.getDto();
		FeeContractBalanceExample example = getExample(dto,isAccuracy);
		List<FeeContractBalance> list= feeContractBalanceMapper.selectByExample(example);
		PageInfo<FeeContractBalance> pageFee = new PageInfo<>(list);
		return pageFee; 
	}
	
	/**
	 * ??????????????????
	 * @param 
	 * @return
	 */
	private FeeContractBalanceExample getExample(ContractBalanceVo fee,Boolean isAccuracy) {
		FeeContractBalanceExample example = new FeeContractBalanceExample();
		if (fee != null) {
			FeeContractBalanceExample.Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(fee.getContractId())) {
				criteria.andContractIdEqualTo(fee.getContractId());
			}
			if (!StringUtils.isEmpty(fee.getCreateUser())) {
				if (isAccuracy) {
					criteria.andCreateUserEqualTo(fee.getCreateUser());
				} else {
					criteria.andCreateUserLike("%" + fee.getCreateUser() + "%");
				}
			}
			if (fee.getStartCreateDate() != null && fee.getEndCreateDate() != null) {
				criteria.andCreateDateBetween(DateUtils.getStartDate(fee.getStartCreateDate()), DateUtils.getEndDate(fee.getEndCreateDate()));
			} else if (fee.getStartCreateDate() != null) {
				criteria.andCreateDateGreaterThanOrEqualTo(DateUtils.getStartDate(fee.getStartCreateDate()));
			} else if (fee.getEndCreateDate() != null) {
				criteria.andCreateDateLessThanOrEqualTo(DateUtils.getEndDate(fee.getEndCreateDate()));
			}
			criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		}
		// ????????????
		
		return example;

	}

	/**
	 * ??????????????????????????????
	 * @param 
	 * @return
	 */
	@Override
	public List<ContractBalanceVo> getContractBalances(FeeContractBalanceDto dto, String orderByClause, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<FeeContractBalanceDto> page = new PageUtils<FeeContractBalanceDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<ContractBalanceVo> info = this.getContractBalances(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public PageInfo<ContractBalanceVo> getContractBalances(PageUtils<FeeContractBalanceDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		FeeContractBalanceExample example = this.getContractBalanceCriteria(page.getDto(), isAccuracy);
		List<ContractBalanceVo> list = contractBalanceExtMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	/**
	 * ????????????
	 * @param dto
	 * @param isAccuracy
	 * @return
	 */
	private FeeContractBalanceExample getContractBalanceCriteria(FeeContractBalanceDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		FeeContractBalanceExample example = new FeeContractBalanceExample();
		FeeContractBalanceExample.Criteria criteria = example.createCriteria();
		return example;
	}
	
	@Override
	public int deleteContractBalance(String contractId) {
		if (StringUtils.isEmpty(contractId)) {
			return 0;
		}
		FeeContractBalance feeContractBalance = new FeeContractBalance();
		feeContractBalance.setContractId(contractId);
		feeContractBalance.setIsDel(YesOrNoEnum.YES.toString());
		return feeContractBalanceMapper.updateByPrimaryKeySelective(feeContractBalance);
	}
	
}
