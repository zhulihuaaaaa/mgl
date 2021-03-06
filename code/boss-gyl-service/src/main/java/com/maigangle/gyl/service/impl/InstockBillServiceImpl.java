package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.InApplyRemitDetail;
import com.maigangle.gyl.facade.entity.InApplyRemitDetailExample;
import com.maigangle.gyl.facade.entity.InContractRemitDetail;
import com.maigangle.gyl.facade.entity.InContractRemitDetailExample;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.InInstockBillExample;
import com.maigangle.gyl.facade.entity.dto.InStockBillDto;
import com.maigangle.gyl.facade.entity.dto.InvoiceGoodsConditionDto;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.FeeFinanceBillVo;
import com.maigangle.gyl.facade.entity.vo.InApplyRemitDetailVo;
import com.maigangle.gyl.facade.entity.vo.InContractRemitDetailVo;
import com.maigangle.gyl.facade.entity.vo.InvoiceGoodsConditionVo;
import com.maigangle.gyl.facade.enums.AccountStateEnum;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.BusinessTypeEnum;
import com.maigangle.gyl.facade.enums.DepositStateEnum;
import com.maigangle.gyl.facade.enums.FinanceFlwoTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceTypeEnum;
import com.maigangle.gyl.facade.enums.InStockBillStateEnum;
import com.maigangle.gyl.facade.enums.InspectionTypeEnum;
import com.maigangle.gyl.facade.enums.PaymentStateEnum;
import com.maigangle.gyl.facade.enums.RemitTypeEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.FlowService;
import com.maigangle.gyl.facade.service.GylService;
import com.maigangle.gyl.facade.service.InsInspectionBillService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.utils.DateUtils;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.InApplyRemitDetailMapper;
import com.maigangle.gyl.service.mapper.InContractRemitDetailMapper;
import com.maigangle.gyl.service.mapper.InInstockBillMapper;
import com.maigangle.gyl.service.mapper.InsInspectionBillMapper;
import com.maigangle.gyl.service.mapper.ext.FlowExtMapper;
import com.maigangle.gyl.service.mapper.ext.InsInspectionDetailExtMapper;


/**  
 * ????????????Service??????
 * @author zlh
 * @since 2017???11???28??? ??????1:27:00 
 * @version 1.0 
 */
@Service
@Transactional
public class InstockBillServiceImpl extends GylServiceImpl implements InstockBillService {
	@Autowired
	private InInstockBillMapper inInstockBillMapper;
	@Autowired
	private InApplyRemitDetailMapper inApplyRemitDetailMapper;
	@Autowired
	private InContractRemitDetailMapper inContractRemitDetailMapper;
	@SuppressWarnings("rawtypes")
	@Autowired
	private GylService gylService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private FinanceService financeService;
	/***************************************************/
	@Autowired
	private InsInspectionBillService insInspectionBillService;
	@Autowired
	private FlowExtMapper flowExtMapper;
	@Autowired
	private FlowService flowService;
	@Autowired
	private InsInspectionDetailExtMapper insInspectionDetailExtMapper;
	/***************************************************/
	/**
	 * ??????????????????
	 */
	@Override
	public PageInfo<InvoiceGoodsConditionVo> getInvoiceGoodsIn(PageUtils<InvoiceGoodsConditionDto> page) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		List<InvoiceGoodsConditionVo> list = insInspectionDetailExtMapper.getInvoiceGoodsIn(page.getDto());
		return new PageInfo<>(list);
	}

	/**
	 * ????????????id????????????????????????
	 */
	@Override
	public List<InContractRemitDetailVo> findContractRecord(String contractId) {
		InContractRemitDetailExample example = new InContractRemitDetailExample();
		InContractRemitDetailExample.Criteria criteria = example.createCriteria();
		criteria.andContractIdEqualTo(contractId);
		//??????????????????
		List<InContractRemitDetail> detail = inContractRemitDetailMapper.selectByExample(example);
		List<InContractRemitDetailVo> voList = new ArrayList<InContractRemitDetailVo>();
		for(int i=0;i<detail.size();i++) {
			voList.add(new InContractRemitDetailVo());
			voList.get(i).setDetail(detail.get(i));
			voList.get(i).setRemitState(AccountStateEnum.YI_DAO_ZHANG.getName());
			String type = contractService.getConContractById(detail.get(i).getContractId()).getContractType();
			if(type.equals(BusinessTypeEnum.HUO_YA_RONG_ZI.getType()) || type.equals(BusinessTypeEnum.DING_XIANG_XIAO_SHOU.getType())) {
				voList.get(i).setRemitType(RemitTypeEnum.RONG_ZI_DA_KUAN.getType());
				voList.get(i).setRemitTypeName(RemitTypeEnum.RONG_ZI_DA_KUAN.getName());
			}
			if(type.equals(BusinessTypeEnum.CANG_DAN_ZHI_YA.getType()) || type.equals(BusinessTypeEnum.CAI_GOU_ZI_XIAO.getType())) {
				voList.get(i).setRemitType(RemitTypeEnum.CAI_GOU_DA_KUAN.getType());
				voList.get(i).setRemitTypeName(RemitTypeEnum.CAI_GOU_DA_KUAN.getName());
			}
		}
		return voList;
	}
	
	/*
	 * ??????????????????
	 */
	@Override
	public InContractRemitDetail updateContractRemit(String financeId,String contractId) {
		FeeFinanceBillVo vo = financeService.getFinaceBill(financeId);
		//????????????
		if(vo.getOperatorDate() != null) {
			InContractRemitDetail detail = findcontractRemit(contractId,vo.getOperatorDate());
			if(detail != null) {
				BigDecimal balance = detail.getBalance();
				balance = balance.add(vo.getActualAmount());
				//????????????
				detail.setBalance(balance);
				//????????????????????????
				updateApplyRemitByfID(financeId);
				int rows = inContractRemitDetailMapper.updateByPrimaryKeySelective(detail);
				return rows == 0 ? null : detail;
			}
			else {
				detail  = new InContractRemitDetail();
				detail.setBalance(vo.getActualAmount());
				//????????????????????????
				updateApplyRemitByfID(financeId);
				int rows = inContractRemitDetailMapper.insertSelective(detail);
				return rows == 0 ? null : detail;
			}
		}
		return null;
	}
	
	/* 
	 * ????????????id????????????????????????
	 */
	@Override
	public void updateApplyRemitByfID(String financeId) {
		InApplyRemitDetailExample example = new InApplyRemitDetailExample();
		InApplyRemitDetailExample.Criteria criteria = example.createCriteria();
		criteria.andFinanceIdEqualTo(financeId);
		List<InApplyRemitDetail>  list = inApplyRemitDetailMapper.selectByExample(example);
		InApplyRemitDetail detail = new InApplyRemitDetail();
		if(list.size()!=0) {
			detail.setApplyRemitDetailId(list.get(0).getApplyRemitDetailId());
			detail.setRemitStatus(DepositStateEnum.YI_DAO_ZHANG.getState());
			detail.setAuditStatus(ApprovalStateEnum.APPROVAL_COMPLETE.getState());
			inApplyRemitDetailMapper.updateByPrimaryKeySelective(detail);
		}
		
	}
	
	/* 
	 * ??????????????????remit_date????????????????????????
	 */
	@Override
	public InContractRemitDetail findcontractRemit(String contractid,Date date) {
		InContractRemitDetailExample example = new InContractRemitDetailExample();
		InContractRemitDetailExample.Criteria criteria = example.createCriteria();
		criteria.andRemitDateGreaterThanOrEqualTo(DateUtils.getStartDate(date));
		criteria.andRemitDateLessThanOrEqualTo(DateUtils.getEndDate(date));
		criteria.andContractIdEqualTo(contractid);
		List<InContractRemitDetail> list = inContractRemitDetailMapper.selectByExample(example);
		if(list ==null||list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	

	/* 
	 * ??????
	 * ?????????contractId businessType
	 */
	@Override
	public InInstockBill addInstockBill(InInstockBill bill) {
		if(bill != null) {
			bill.setInstockCode(gylService.generateCode("TB_IN_INSTOCK_BILL","RK"));
			bill.setCreateDate(new Date());
			bill.setDepositStatus("A");
			bill.setInstockStatus("A");
			bill.setInspectionStatus(InspectionTypeEnum.WEI_YAN_HUO.getType());
			bill.setFinancingLoanStatus("A");
			bill.setPaymentStatus("A");
			bill.setIsDel(YesOrNoEnum.NO.getCode());
			int rows = inInstockBillMapper.insertSelective(bill);
			// ??????????????????????????? ?????????
			if(rows == 1) {
				flowService.updateFlow(bill.getContractId(),null);
			}
			return rows == 0 ? null : bill;
		}
		return null;
	}

	/* 
	 * ??????
	 */
	@Override
	public InInstockBill updateInstockBill(InInstockBill inInstockBill) {
		if (StringUtils.isEmpty(inInstockBill.getInstockBillId())) {
			return null;
		}
		if (StringUtils.isEmpty(inInstockBill.getContractId())) {
			return null;
		}
		return inInstockBillMapper.updateByPrimaryKey(inInstockBill) == 0 ? null : inInstockBill;
	}

	/* 
	 * ??????
	 */
	@Override
	public int deleteInstockBill(String instockBillId) {
		if(StringUtils.isEmpty(instockBillId)) {
			InInstockBill b = new InInstockBill();
			b.setInstockBillId(instockBillId);
			b.setIsDel("Y");
			return inInstockBillMapper.updateByPrimaryKeySelective(b);
		}
		else {
			return 0;
		}
	}

	/* 
	 * ?????????????????????
	 */
	@Override
	public List<InStockBillDto> getAllInstockBill(InStockBillDto dto,String orderByClause,boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<InStockBillDto> page = new PageUtils<InStockBillDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<InStockBillDto> info = this.getAllInstockBill(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	/* 
	 * ??????????????????????????????
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<InStockBillDto> getAllInstockBill(PageUtils<InStockBillDto> page, boolean isAccuracy) {
		if (page == null){
			return new PageInfo<InStockBillDto>(); 
		}
		setPageAndOrderBy(page);
		InStockBillDto dto = page.getDto();
		InInstockBillExample example = this.getInStockBillCriteria(dto, isAccuracy);
		List<InInstockBill> list = inInstockBillMapper.selectByExample(example);
		List<InStockBillDto> dtos = new ArrayList<InStockBillDto>();
		for(int i=0;i<list.size();i++) {
			ConContract conContract = contractService.getConContractById(list.get(i).getContractId());
			dtos.add(new InStockBillDto());
			dtos.get(i).setBill(list.get(i));
			BeanUtils.copyProperties(list.get(i), dtos.get(i));
			if(!StringUtils.isEmpty(conContract)) {
				dtos.get(i).setContractCode(conContract.getContractCode());
				dtos.get(i).setContractNo(conContract.getContractNo());
				dtos.get(i).setTotalWeight(conContract.getTotalWeight());
				dtos.get(i).setTotalMoney(conContract.getTotalMoney());
				dtos.get(i).setDepositFee(conContract.getDepositFee());
				dtos.get(i).setContractPeriod(conContract.getContractPeriod());
			}
			
		}
		//????????????????????????
		PageInfo<InInstockBill> info = new PageInfo<InInstockBill>(list);
		PageInfo<InStockBillDto> dtoForPage = new PageInfo<InStockBillDto>();
		BeanUtils.copyProperties(info,dtoForPage);
		dtoForPage.setList(dtos);
		return dtoForPage;
	}
	
	/* 
	 * ??????id???????????????
	 */
	@Override
	public InStockBillDto getInstockBillById(String instockBillId) {
		InStockBillDto dto = new InStockBillDto();
		dto.setInstockBillId(instockBillId);
		List<InStockBillDto> list = this.getAllInstockBill(dto,"",true);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	/* 
	 * ???????????????????????????
	 */
	@Override
	public InStockBillDto getInstockBillByContractId(String contractId) {
		InStockBillDto dto = new InStockBillDto();
		dto.setContractId(contractId);
		List<InStockBillDto> list = this.getAllInstockBill(dto,"",true);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * ?????????????????????????????????
	 * @param instockCode
	 * @return
	 */
	public List<InStockBillDto> getInstockBillByBusinessType(String businessType){
		InStockBillDto dto = new InStockBillDto();
		dto.setBusinessType(businessType);;
		List<InStockBillDto> list = this.getAllInstockBill(dto,"desc",true);
		if (list != null && !list.isEmpty()) {
			return list;
		}
		return null;
	}
	
	/* 
	 * ??????????????????????????????
	 */
	@Override
	public InApplyRemitDetailVo applyRemit(InApplyRemitDetailVo vo) {
		if (vo != null) {
			//???????????? ???????????? ???????????????
			FeeFinanceBill finance = new FeeFinanceBill();
			finance.setContractId(vo.getBill().getContractId());
			finance.setBusinessType(FinanceTypeEnum.GOU_HUO_KUAN.getType());
			finance.setRelationCode(vo.getBill().getInstockCode());
			finance.setFlwoType(FinanceFlwoTypeEnum.CHU_ZHANG.getType());
			finance.setRealMoney(vo.getDetail().getMoney());
			FeeFinanceBill bill = financeService.addFinanceBill(finance);
			//??????????????????
			vo.getDetail().setAuditStatus("B");
			vo.getDetail().setRemitStatus("A");
			vo.getDetail().setCreateDate(new Date());
			vo.getDetail().setFinanceId(bill.getFinanceBillId());
			return inApplyRemitDetailMapper.insertSelective(vo.getDetail()) == 0 ? null : vo;
		}
		return null;
	}
	
	/* 
	 * ????????????????????????
	 */
	@Override
	public List<InApplyRemitDetailVo> findApplyRemit(String instockId) {
		if (!StringUtils.isEmpty(instockId)) {
			InApplyRemitDetailExample example = new InApplyRemitDetailExample();
			InApplyRemitDetailExample.Criteria criteria = example.createCriteria();
			criteria.andInstockIdEqualTo(instockId);
			List<InApplyRemitDetail> list = inApplyRemitDetailMapper.selectByExample(example);
			List<InApplyRemitDetailVo> voList = new ArrayList<InApplyRemitDetailVo>();
			for(int i=0;i<list.size();i++) {
				voList.add(new InApplyRemitDetailVo());
				voList.get(i).setDetail(list.get(i));
				if(list.get(i).getFinanceId() != null) {
					String man = financeService.getFinaceBill(list.get(i).getFinanceId()).getOperator();
					voList.get(i).setCheckMan(man);
				}
			}
			return voList;
		}
		return null;
	}

	
	/* 
	 * ??????????????????????????????
	 */
	@Override
	public InContractRemitDetail contractRemit(InContractRemitDetail inContractRemitDetail) {
		if (inContractRemitDetail != null && !StringUtils.isEmpty(inContractRemitDetail.getContractRemitDetiailId())) {
			return inContractRemitDetailMapper.insertSelective(inContractRemitDetail) == 0 ? null : inContractRemitDetail;
		}
		return null;
	}
	

	/**
	 * ??????InStockBill???????????????
	 * ???????????????
	 * @param dto
	 * @return InStockBillExample
	 */
	private InInstockBillExample getInStockBillCriteria(InStockBillDto dto, boolean isAccuracy) {
		InInstockBillExample example = new InInstockBillExample();
		if (dto != null) {
			InInstockBillExample.Criteria criteria = example.createCriteria();
			if(dto.getInstockBillId() != null) {
				criteria.andInstockBillIdEqualTo(dto.getInstockBillId());
			}
			// ????????????id ?????????????????????
			if(!StringUtils.isEmpty(dto.getContractId())) {
				criteria.andContractIdEqualTo(dto.getContractId());
			}
			if (!StringUtils.isEmpty(dto.getInstockCode())) {
				if (isAccuracy) {
					criteria.andInstockCodeEqualTo(dto.getInstockCode());
				} else {
					criteria.andInstockCodeLike("%" + dto.getInstockCode() + "%");
				}
			}
			
			if (!StringUtils.isEmpty(dto.getCreateUser())) {
				criteria.andCreateUserLike("%" + dto.getCreateUser() + "%");
			}
			if (!StringUtils.isEmpty(dto.getInstockStatus())) {
				if (isAccuracy) {
					criteria.andInstockStatusEqualTo(dto.getInstockStatus());
				} else {
					criteria.andInstockStatusLike("%" + dto.getInstockStatus() + "%");
				}
			}
			if (!StringUtils.isEmpty(dto.getBusinessType())) {
				criteria.andBusinessTypeEqualTo(dto.getBusinessType());
			}
		}
		return example;
	}

	/* 
	 * ?????????????????????
	 */
	@Override
	public InInstockBill updateInstockBillState(InInstockBill inInstockBill) {
		if(inInstockBill != null) {
			inInstockBill.setInstockStatus(InStockBillStateEnum.COMPLETE.getState());
			inInstockBill.setInspectionStatus(InspectionTypeEnum.YI_YAN_HUO.getType());
			inInstockBill = inInstockBillMapper.updateByPrimaryKeySelective(inInstockBill) == 0 ? null : inInstockBill;
			//?????? ?????????
			insInspectionBillService.updateStats(inInstockBill.getInstockBillId(),InspectionTypeEnum.YI_YAN_HUO.getType(),1);
			if(inInstockBill !=null) {
				//updateAllSate(inInstockBill);
				// 	InInstockBill instockBill = inInstockBillMapper.selectByPrimaryKey(inInstockBill.getInstockBillId());
				// ????????????
				// flowService.updateFlow(instockBill.getContractId(), null);
			}
			
			return inInstockBill;
		}
		return null;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: updateSate 
	 * @Description: (?????????????????? ) 
	 * @return InInstockBill
	 * @throws
	 */
	private InInstockBill updateAllSate(InInstockBill inInstockBill) {
		if(inInstockBill ==null) {
			return null;
		}
		String businessType = inInstockBill.getBusinessType();
		String instockStatus = inInstockBill.getInstockStatus();
		if(StringUtils.isEmpty(businessType)||StringUtils.isEmpty(instockStatus)) {
			return null;
		}
		if(businessType.equals(BusinessTypeEnum.HUO_YA_RONG_ZI.toString())) {
			// ????????????
			// ??????????????????
			inInstockBill =  updatFinancingLoanStatus(inInstockBill);
			// ??????????????????  
			inInstockBill = updateInspectionStatus(inInstockBill);
		}else if (businessType.equals(BusinessTypeEnum.CANG_DAN_ZHI_YA.toString())){
			//????????????
			// ??????????????????
			inInstockBill = updateInspectionStatus(inInstockBill);
			// ??????????????????
			inInstockBill =  updatFinancingLoanStatus(inInstockBill);
		}else if(businessType.equals(BusinessTypeEnum.DING_XIANG_XIAO_SHOU.toString())){
			// ????????????
			
			
			// ??????????????????
			inInstockBill = updatPaymentStatus(inInstockBill);
		}else if(businessType.equals(BusinessTypeEnum.CAI_GOU_ZI_XIAO.toString())) {
			//????????????
			
			// ????????????????????????
			inInstockBill = updatPaymentStatus(inInstockBill);
		}
		
		// ??????????????????
		inInstockBillMapper.updateByPrimaryKeySelective(inInstockBill);
		return  inInstockBill;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: updateDepositStatus 
	 * @Description: ( ????????????????????? ????????????????????? ) 
	 * @return InInstockBill
	 * @throws
	 */
	private InInstockBill updateDepositStatus(InInstockBill inInstockBill) {
		FeeFinanceBill feeFinanceBill = new FeeFinanceBill();
		//  ????????????????????????
		
		
		FeeFinanceBill fee=  financeService.addFinanceBill(feeFinanceBill);
		if(fee!=null) {
			inInstockBill.setDepositStatus(AccountStateEnum.YI_DAO_ZHANG.toString());
		}
		return inInstockBill;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: updateInspectionStatus 
	 * @Description: ( ???????????????????????? )
	 * @param inInstockBill
	 * @return InInstockBill
	 * @throws
	 */
	private InInstockBill updateInspectionStatus(InInstockBill inInstockBill) {
		// InsInspectionBill InsInspectionBill = insInspectionBillService.getInsInspectionBillByInstockId(inInstockBill.getInstockBillId());
		String id = inInstockBill.getInstockBillId();
		String stats = inInstockBill.getInstockStatus();
		if(StringUtils.isEmpty(id)||StringUtils.isEmpty(stats)) {
			return null;
		}
		// ?????????????????????????????????  
		// ?????????????????? ????????? ?????????????????????
		if (stats.equals(InStockBillStateEnum.COMPLETE.toString())) {
			int i = insInspectionBillService.updateStats(id,InspectionTypeEnum.YI_YAN_HUO.toString(),1);
			if(i == 1) {
				inInstockBill.setInspectionStatus(InspectionTypeEnum.YI_YAN_HUO.toString());
			}
		}
		return inInstockBill;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: updatFinancingLoanStatus 
	 * @Description: ( ??????????????????) 
	 * @param inInstockBill
	 * @return InInstockBill
	 * @throws
	 */
	private InInstockBill updatFinancingLoanStatus(InInstockBill inInstockBill) {
		if(inInstockBill == null) {
			return null;
		}
		ConContractVo vo = contractService.getConContractById(inInstockBill.getContractId());
		if(vo == null) {
			return null;
		}
		BigDecimal sumMumber = flowExtMapper.getSumMoney(inInstockBill.getInstockBillId());
		if (sumMumber.compareTo(BigDecimal.ZERO)!=0) {
			if(sumMumber.compareTo(vo.getTotalMoney())>=0) {
				inInstockBill.setFinancingLoanStatus(PaymentStateEnum.QUANBU_DA_KUAN.toString());
			}else {
				inInstockBill.setFinancingLoanStatus(PaymentStateEnum.QUANBU_DA_KUAN.toString());
			}
		}else {
			inInstockBill.setFinancingLoanStatus(PaymentStateEnum.WEI_DA_KUAN.toString());
		}
		return inInstockBill;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: updatPaymentStatus 
	 * @Description: ( ???????????????????????? ) 
	 * @param inInstockBill
	 * @return InInstockBill
	 * @throws
	 */
	private InInstockBill updatPaymentStatus(InInstockBill inInstockBill) {
		if(inInstockBill == null) {
			return null;
		}
		ConContractVo vo = contractService.getConContractById(inInstockBill.getContractId());
		if(vo == null) {
			return null;
		}
		BigDecimal sumMumber = flowExtMapper.getSumMoney(inInstockBill.getInstockBillId());
		if (sumMumber.compareTo(BigDecimal.ZERO)!=0) {
			if(sumMumber.compareTo(vo.getTotalMoney())>=0) {
				inInstockBill.setPaymentStatus(PaymentStateEnum.QUANBU_DA_KUAN.toString());
			}else {
				inInstockBill.setPaymentStatus(PaymentStateEnum.QUANBU_DA_KUAN.toString());
			}
		}else {
			inInstockBill.setPaymentStatus(PaymentStateEnum.WEI_DA_KUAN.toString());
		}
		return inInstockBill;
	}

}
