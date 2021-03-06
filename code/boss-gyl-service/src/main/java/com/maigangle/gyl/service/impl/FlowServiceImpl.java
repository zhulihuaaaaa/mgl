package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.InContractRemitDetail;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InsInspectionSub;
import com.maigangle.gyl.facade.entity.dto.InStockBillDto;
import com.maigangle.gyl.facade.entity.dto.InsInspectionBillDto;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.vo.FeeFinanceBillVo;
import com.maigangle.gyl.facade.entity.vo.InContractRemitDetailVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.BusinessTypeEnum;
import com.maigangle.gyl.facade.enums.DepositStateEnum;
import com.maigangle.gyl.facade.enums.FinanceFlwoTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceStateEnum;
import com.maigangle.gyl.facade.enums.FinanceTypeEnum;
import com.maigangle.gyl.facade.enums.GoodsPaymentStatusEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.FlowService;
import com.maigangle.gyl.facade.service.InsInspectionBillService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.service.mapper.InApplyRemitDetailMapper;
import com.maigangle.gyl.service.mapper.InContractRemitDetailMapper;
import com.maigangle.gyl.service.mapper.InInstockBillMapper;
import com.maigangle.gyl.service.mapper.InsInspectionDetailMapper;
import com.maigangle.gyl.service.mapper.InvInventoryMapper;

@Service
@Transactional
public class FlowServiceImpl  extends GylServiceImpl implements FlowService{
	
	
	@Autowired
	private InsInspectionBillService insInspectionBillService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private InstockBillService instockBillService;
	@Autowired
	private FinanceService financeService;
	@Autowired
	private InvInventoryMapper invInventoryMapper;
	@Autowired
	private InvInventoryService invInventoryService;
	@Autowired
	private InApplyRemitDetailMapper inApplyRemitDetailMapper;
	@Autowired
	private InInstockBillMapper inInstockBillMapper;
	@Autowired
	private InsInspectionDetailMapper insInspectionDetailMapper;
	@Autowired
	private InContractRemitDetailMapper inContractRemitDetailMapper;
	
	/**
	 * 	//?????????????????? ?????? ??????????????????????????????????????????????????????  
	 * 	// ?????????????????? ???????????????????????????
	 * @author shmily
	 * @Title: updateFlow
	 * @Description: (?????? )
	 * @param contractId ??????id
	 * @param financeId ??????id
	 * @return 
	 * @throws
	 */
	@Override
	public Integer updateFlow(String contractId,String financeId) {
		if(StringUtils.isEmpty(contractId)) {
			return null;
		}
		ConContract conContract = contractService.getConContractById(contractId);
		InStockBillDto inStockBillDto = instockBillService.getInstockBillByContractId(contractId);
		 FeeFinanceBillVo vo = financeService.getFinaceBill(financeId);
		if(conContract == null||inStockBillDto ==null) {
			return null;
		}
		InInstockBill inInstockBill = inStockBillDto.getBill();
		if(inInstockBill ==null) {
			return null;
		}
		String businessType = conContract.getContractType();
		if(StringUtils.isEmpty(businessType)) {
			return null;
		}
		if(businessType.equals(BusinessTypeEnum.HUO_YA_RONG_ZI.toString())) {
			// ????????????
			
			// ???????????????  --- ???????????????????????????????????????
			InsInspectionBill insInspectionBill = addInsInspectionBill(conContract);
			if(insInspectionBill!=null&&!StringUtils.isEmpty(insInspectionBill.getInspectionBillId())) {
				// ????????????????????????????????????	
				if(checkSubAll(insInspectionBill.getInspectionBillId())){
					// ????????????????????????	
					FeeFinanceBill  feeFinanceBill = addFeeFinanceBill(conContract,inStockBillDto);
					if(feeFinanceBill!=null&&FinanceStateEnum.YI_WAN_CHENG.toString().equals(feeFinanceBill.getStatus())){
						// ?????????????????? ?????????
						InInstockBill inInstockBill1 = changeStates(businessType,inInstockBill.getInstockBillId(),1,DepositStateEnum.YI_DAO_ZHANG.toString());
						
						if(inInstockBill1 !=null) {
							if(vo !=null&&FinanceTypeEnum.GOU_HUO_KUAN.toString().equals(vo.getBusinessType())&&FinanceStateEnum.YI_WAN_CHENG.toString().equals(vo.getStatus())) {
								// ????????????????????????
								Boolean flag = checkConMoneyRecord(conContract,businessType,inInstockBill.getInstockBillId(),vo);
								if(flag) {
									// ???????????????????????? ?????????
									 changeStates(businessType,inInstockBill.getInstockBillId(),2,GoodsPaymentStatusEnum.QUAN_BU_HUO_KUAN.toString());
								}
							}
							
							
							
							
							//???????????? ???????????????
//							// ?????? ????????????????????????
//							FeeFinanceBill  feeFinance =paymentClient(conContract,inStockBillDto);
//							// ??????????????????????????????
//							if(feeFinance!=null&&FinanceStateEnum.YI_WAN_CHENG.toString().equals(feeFinance.getStatus())) {
//								createContractRemitByType(conContract,vo);
//								if(feeFinance!=null&&FinanceStateEnum.YI_WAN_CHENG.toString().equals(feeFinance.getStatus())) {
//									changeStates(businessType,inInstockBill.getInstockBillId(),2,GoodsPaymentStatusEnum.QUAN_BU_HUO_KUAN.toString());
//								}
//							}
						}
					}
				}
			}
		}else if (businessType.equals(BusinessTypeEnum.CANG_DAN_ZHI_YA.toString())){
			//????????????
			
			// ???????????????  --- ???????????????????????????????????????
			InsInspectionBill insInspectionBill = addInsInspectionBill(conContract);
			//?????????????????? ?????? ??????????????????????????????????????????????????????  
			
			
		}else if(businessType.equals(BusinessTypeEnum.DING_XIANG_XIAO_SHOU.toString())){
			// ????????????
			// ???????????????????????????
			FeeFinanceBill  feeFinanceBill =  addFeeFinanceBill(conContract,inStockBillDto);
			if(feeFinanceBill !=null) {
				// ???????????????id
				inStockBillDto.setDepositFinanceId(feeFinanceBill.getFinanceBillId());
				//inInstockBill =instockBillService.updateInstockBill(inInstockBill);
				if(inInstockBill !=null&&FinanceStateEnum.YI_WAN_CHENG.toString().equals(feeFinanceBill.getStatus())) {
					// ????????????????????? ?????????
					InInstockBill inInstockBill1 = changeStates(businessType,inInstockBill.getInstockBillId(),1,DepositStateEnum.YI_DAO_ZHANG.toString());
					// ????????? ???????????????????????????
					// FeeFinanceBill  feeFinanceBill1 =paymentSteel(conContract,inStockBillDto);
					if(vo !=null&&FinanceTypeEnum.GOU_HUO_KUAN.toString().equals(vo.getBusinessType())&&FinanceStateEnum.YI_WAN_CHENG.toString().equals(vo.getStatus())) {
						// ????????????????????????
						Boolean flag = checkConMoneyRecord(conContract,businessType,inInstockBill.getInstockBillId(),vo);
//						if(feeFinanceBill1!=null&&"Y".equals(feeFinanceBill.getStatus())&&flag) {
						if(flag) {
							// ???????????????????????? ?????????
							 changeStates(businessType,inInstockBill.getInstockBillId(),2,GoodsPaymentStatusEnum.QUAN_BU_HUO_KUAN.toString());
							// ????????? ???????????????
							InsInspectionBill insInspectionBill = addInsInspectionBill(conContract);
							if(checkSubAll(insInspectionBill.getInspectionBillId())) {
								putStorage(insInspectionBill.getInspectionBillId());
								// ???????????????????????????
//								InStockBillDto dto =affirmInStock(conContract.getContractId());
//								if(dto!=null&&dto.getBill()!=null&&InStockBillStateEnum.COMPLETE.toString().equals(dto.getBill().getInstockStatus())) {
//									 // ???????????? ????????????
//									putStorage(insInspectionBill.getInspectionBillId());
//								}
							}
						}
					}
					
				}
			}
			
		}else if(businessType.equals(BusinessTypeEnum.CAI_GOU_ZI_XIAO.toString())) {
			//????????????
			
			// ?????? ????????? ???????????? ----??????????????? //????????????
			// FeeFinanceBill  feeFinanceBill = paymentClient(conContract,inStockBillDto);
			// ???????????????????????????
			Boolean flag = checkConMoneyRecord(conContract,businessType,inInstockBill.getInstockBillId(),vo);
			if(flag) {
				// ???????????????????????? ?????????
				 changeStates(businessType,inInstockBill.getInstockBillId(),2,GoodsPaymentStatusEnum.QUAN_BU_HUO_KUAN.toString());
				// ???????????????  --- ???????????????????????????????????????
				InsInspectionBill insInspectionBill = addInsInspectionBill(conContract);
				if(checkSubAll(insInspectionBill.getInspectionBillId())){
					putStorage(insInspectionBill.getInspectionBillId());
						// ???????????????????????????
//					InStockBillDto dto =affirmInStock(conContract.getContractId());
//					if(dto!=null&&dto.getBill()!=null&&InStockBillStateEnum.COMPLETE.toString().equals(dto.getBill().getInstockStatus())) {
//						// ????????????
//						putStorage(insInspectionBill.getInspectionBillId());
//					}
				}
			}
		}
		
		return 0;
	}
	/**
	 * ??????????????????????????????  ------ ???????????????id
	 */
	private InsInspectionBill addInsInspectionBill(ConContract conContract) {
		// ???????????????
		if(conContract ==null||StringUtils.isEmpty(conContract.getContractId())) {
			return null;
		}
		InsInspectionBill insInspectionBill= insInspectionBillService.getInsInspectionBillByConId(conContract.getContractId());
		// ??????????????????????????????
		if(insInspectionBill !=null) {
			return insInspectionBill;
		}
		InStockBillDto inStockBillDto = instockBillService.getInstockBillByContractId(conContract.getContractId());
		String instockId = "";
		if(inStockBillDto!=null && inStockBillDto.getBill()!=null) {
			instockId = inStockBillDto.getBill().getInstockBillId();
		}
		String contractId = "";
		contractId = conContract.getContractId();
		//  ???????????? ??????????????????
		String inspectionInfo="";
		String businessType =conContract.getContractType();
		insInspectionBill= insInspectionBillService.addInsInspection(instockId,contractId,inspectionInfo,businessType);
		if(insInspectionBill == null) {
			return null;
		}
		return insInspectionBill;
		
	}
	/**
	 * ?????????????????????????????????  ---- ???????????????
	 */
	private FeeFinanceBill addFeeFinanceBill(ConContract conContract,InStockBillDto inStockBillDto) {
		FeeFinanceBill bill = createFeeFinanceBill(conContract,FinanceFlwoTypeEnum.JIN_ZHANG.toString(),FinanceTypeEnum.LV_YUE_BAO_ZHENG_JIN.toString(),inStockBillDto);
		return bill;
	}
	
	/**
	 * ????????????
	 * ????????????????????????
	 */
	private FeeFinanceBill paymentClient(ConContract conContract,InStockBillDto inStockBillDto) {
		return createFeeFinanceBill(conContract,FinanceFlwoTypeEnum.CHU_ZHANG.toString(),FinanceTypeEnum.GOU_HUO_KUAN.toString(),inStockBillDto);
	}
	/**
	 * ????????????
	 */
	private InStockBillDto affirmInStock(String id) {
		InStockBillDto dto = instockBillService.getInstockBillByContractId(id);
		return dto;
	}
	/**
	 * ???????????????
	 */
	private FeeFinanceBill paymentSteel(ConContract conContract,InStockBillDto inStockBillDto) {
		return createFeeFinanceBill(conContract,FinanceFlwoTypeEnum.CHU_ZHANG.toString(),FinanceTypeEnum.GOU_HUO_KUAN.toString(),inStockBillDto);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: createFeeFinanceBill 
	 * @Description: (  ) 
	 * @param conContract  ?????????
	 * @param flwoType ????????????
	 * @param type 	????????????
	 * @return FeeFinanceBill
	 * @throws
	 */
	private FeeFinanceBill createFeeFinanceBill(ConContract conContract,String flwoType,String type,InStockBillDto inStockBillDto) {
		if(conContract == null) {
			return null;
		}
		List<FeeFinanceBillVo> list =  financeService.getFinaceBillByContractId(conContract.getContractId());
		if(list!=null&&!list.isEmpty()) {
			for (FeeFinanceBillVo feeFinanceBillVo : list) {
				String businessType = feeFinanceBillVo.getBusinessType();
				if(!StringUtils.isEmpty(businessType)&&businessType.equals(type)) {
					return feeFinanceBillVo;
				}
			}
		}
		// ?????? ?????????
		FeeFinanceBill feeFinanceBill = new FeeFinanceBill();
		feeFinanceBill.setRelationId(inStockBillDto.getInstockBillId());
		feeFinanceBill.setContractId(conContract.getContractId());
		feeFinanceBill.setBusinessType(type);
		feeFinanceBill.setFlwoType(flwoType);
		
		feeFinanceBill.setTotalGoodsPayment(conContract.getTotalMoney());
		feeFinanceBill.setDepositFee(conContract.getDepositFee());
		// ????????? ???????????????????????????
		// feeFinanceBill.setCommissionFee(conContract.getCommissionRate().multiply(conContract.getTotalMoney()));
		
		/// ????????????
		if(FinanceTypeEnum.LV_YUE_BAO_ZHENG_JIN.toString().equals(type)) {
			// ??????????????????
			feeFinanceBill.setRealMoney(conContract.getDepositFee());
			// ?????????????????????
			feeFinanceBill.setRelationCode(inStockBillDto.getBill().getInstockCode());
		}
		// 
		if(FinanceTypeEnum.GOU_HUO_KUAN.toString().equals(type)) {
			// ??????????????????
			feeFinanceBill.setRelationCode(conContract.getContractCode());
			// ???????????????  ??????????????? ??????????????????
			feeFinanceBill.setRealMoney(conContract.getTotalMoney());
			// ???????????? ????????? ??????????????????
			feeFinanceBill.setTotalMoney(conContract.getTotalMoney());
			// ????????????  ????????? ??????????????????
			feeFinanceBill.setTotalGoodsPayment(conContract.getTotalMoney());
		}
		feeFinanceBill.setContractCode(conContract.getContractCode());
		feeFinanceBill.setContractId(conContract.getContractId());
		feeFinanceBill.setDepositDetailId(inStockBillDto.getDepositFinanceId());
		feeFinanceBill.setIsDel(YesOrNoEnum.NO.toString());
		feeFinanceBill.setCreateDate(new Date());
		feeFinanceBill =  financeService.addFinanceBill(feeFinanceBill);
		if(feeFinanceBill == null) {
			return null;
		}
		return feeFinanceBill;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: createContractRemitByType 
	 * @Description: ( ???????????? ?????????????????????????????? ) 
	 * @param feeFinanceBillVo
	 * @param conContract
	 * @return int
	 * @throws
	 */
	private int createContractRemitByType(ConContract conContract,FeeFinanceBillVo feeFinanceBillVo) {
		if(conContract == null) {
			return -1;
		}
		
		List<InContractRemitDetailVo> list = instockBillService.findContractRecord(conContract.getContractId());
		if(list!=null &&list.size()==0) {
			//createContractRemit(feeFinanceBillVo,conContract);
			InContractRemitDetail inContractRemitDetail = new InContractRemitDetail();
			// ?????? 
			inContractRemitDetail.setContractId(conContract.getContractId());
			inContractRemitDetail.setIsDel(YesOrNoEnum.NO.toString());
			// ?????????
			inContractRemitDetail.setMoney(feeFinanceBillVo.getActualAmount());
			// ??????
			inContractRemitDetail.setBalance(feeFinanceBillVo.getActualAmount());
			
			inContractRemitDetail.setRemitDate(new Date());
			inContractRemitDetailMapper.insertSelective(inContractRemitDetail);
		}
		
		return 1;
	}
	
	
	/**
	 * 
	 * @author shmily
	 * @Title: create 
	 * @Description: ( ?????????????????????????????? ) 
	 * @return int
	 * @throws
	 */
	private int createContractRemit(FeeFinanceBillVo feeFinanceBillVo,ConContract conContract) {
		if(feeFinanceBillVo == null||conContract == null) {
			return -1;
		}
		InContractRemitDetail inContractRemitDetail = new InContractRemitDetail();
		// ?????? 
		inContractRemitDetail.setContractId(conContract.getContractId());
		inContractRemitDetail.setIsDel(YesOrNoEnum.NO.toString());
		inContractRemitDetail.setRemitDate(new Date());
		List<InContractRemitDetailVo> list = instockBillService.findContractRecord(conContract.getContractId());
		if(list!=null &&list.size()==0) {
			// ?????????
			inContractRemitDetail.setMoney(feeFinanceBillVo.getActualAmount());
			 // ??????
			inContractRemitDetail.setBalance(feeFinanceBillVo.getActualAmount());
		}else {
			InContractRemitDetailVo vo = list.get(list.size() -  1);
			// ?????????
			inContractRemitDetail.setMoney(vo.getDetail().getMoney().add(feeFinanceBillVo.getActualAmount()));
			 // ??????
			inContractRemitDetail.setBalance(vo.getDetail().getMoney().add(feeFinanceBillVo.getActualAmount()));
		}
		
		
		return inContractRemitDetailMapper.insertSelective(inContractRemitDetail);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: checkSubAll 
	 * @Description: (  ???????????????????????????????????? ???????????? ) 
	 * @param id
	 * @return Boolean
	 * @throws
	 */
	private Boolean checkSubAll(String id) {
		List<InsInspectionSub>  list =insInspectionBillService.getInsInspectionSubAllById(id);
		if(list ==null || list.isEmpty()) {
			return false;
		}
		for (InsInspectionSub insInspectionSub : list) {
			if(!(insInspectionSub!=null&&ApprovalStateEnum.APPROVAL_COMPLETE.toString().equals(insInspectionSub.getAuditStatus()))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: checkSubOne 
	 * @Description: ( ?????????????????????????????? ) 
	 * @param id
	 * @return Boolean
	 * @throws
	 */
	private Boolean checkSubOne(String id) {
		InsInspectionBillDto  billDto = insInspectionBillService.getgetInsInspectionSubById(id);
		if(billDto == null||billDto.getInsInspectionSub()==null) {
			return false;
		}
		String str = billDto.getInsInspectionSub().getAuditStatus();
		if(StringUtils.isEmpty(str)) {
			return false;
		}
		return ApprovalStateEnum.APPROVAL_COMPLETE.toString().equals(str);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: checkByDetail 
	 * @Description: ( ?????????????????? ) 
	 * @param id
	 * @return List<InsInspectionDetail>
	 * @throws
	 */
	private List<InvInventoryDto> checkByDetail(String id){
		if(StringUtils.isEmpty(id)) {
			return null;
		}
		List<InsInspectionDetail> list = insInspectionBillService.getInsInspectionDetailById(id);
		 return invInventoryService.addInInvInventoryList(list,null);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: putStorage 
	 * @Description: ( ??????  ???????????????id ??????????????????id ????????? ????????????????????????) 
	 * @param SubId
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	private List<InvInventoryDto> putStorage(String insInspectionId){
		List<InsInspectionSub> billList = insInspectionBillService.getInsInspectionSubAll(insInspectionId);
		List<InvInventoryDto> invListAll = new ArrayList<InvInventoryDto>();
		for (InsInspectionSub insInspectionSub : billList) {
			List<InsInspectionDetail> list =   insInspectionBillService.getInsInspectionDetailBySubId(insInspectionSub.getInspectionSubId());
			List<InvInventoryDto> invList =  null;//invInventoryService.addInInvInventoryList(list);
			invListAll.addAll(invList);
		}
		return invListAll;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: putStorageBySub 
	 * @Description: ( ????????????id ?????????????????? ??????????????? ) 
	 * @param insInspectionSubId
	 * @return List<InvInventoryDto>
	 * @throws
	 */
	private List<InvInventoryDto> putStorageBySub(String insInspectionSubId){
		 List<InsInspectionDetail> billList = insInspectionBillService.getInsInspectionDetailBySubId(insInspectionSubId);
		// List<InvInventoryDto> invList =  invInventoryService.addInInvInventoryList(billList,null);
		return null;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: checkConMoneyRecord 
	 * @Description: ( ?????????????????? )
	 * @return Boolean
	 * @throws
	 */
	private Boolean checkConMoneyRecord(ConContract conContract,String type,String instockBillId,FeeFinanceBillVo  vo) {
		if(conContract == null) {
			return null;
		}
		BigDecimal moneyRecord=BigDecimal.ZERO;
		// ????????????????????????????????????
		if(type.equals(BusinessTypeEnum.HUO_YA_RONG_ZI.toString())||type.equals(BusinessTypeEnum.CAI_GOU_ZI_XIAO.toString())||type.equals(BusinessTypeEnum.DING_XIANG_XIAO_SHOU.toString())){
			
			InContractRemitDetail  detail = instockBillService.findcontractRemit(conContract.getContractId(),new Date());
			
			if(detail!=null&&inSameDay(detail.getRemitDate(),new Date())) {
				detail.setMoney(detail.getMoney().add(vo.getActualAmount()));
				inContractRemitDetailMapper.updateByPrimaryKeySelective(detail);
			}else {
				// ??????????????????????????????
				createContractRemit(vo,conContract);
			}
			
		}
		//???????????????????????????
		List<InContractRemitDetailVo> list = instockBillService.findContractRecord(conContract.getContractId());
		for (InContractRemitDetailVo inContractRemitDetailVo : list) {
			InContractRemitDetail detail = inContractRemitDetailVo.getDetail();
			moneyRecord = moneyRecord.add(detail.getMoney());
		}
		Integer i = moneyRecord.compareTo(conContract.getTotalMoney());
		 // ????????????????????????
		if(BigDecimal.ZERO.compareTo(moneyRecord) !=0 && i!=1) {
			changeStates(type,instockBillId,2,GoodsPaymentStatusEnum.BU_FEN_HUO_KUAN.toString());
		}
		// ?????? 
		if(i==0 || i ==1){
			//  ??????????????????????????????
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: channgStates 
	 * @Description: ( ?????????????????????????????? ) 
	 * @return Integer
	 * @throws
	 */
	private InInstockBill changeStates(String businessType,String instockBillId,Integer steps,String state) {
		if(StringUtils.isEmpty(businessType)||StringUtils.isEmpty(instockBillId)) {
			return null;
		}
		InInstockBill inInstockBill = new InInstockBill();
		inInstockBill.setInstockBillId(instockBillId);
		if(businessType.equals(BusinessTypeEnum.HUO_YA_RONG_ZI.toString())) {
			// ????????????
			
			// ???????????????  
			if(steps == 1) {
				inInstockBill.setDepositStatus(state);
			}
			// 	???????????????  ???????????????????????????
			if(steps == 2) {
				inInstockBill.setFinancingLoanStatus(state);
			}
			
		}else if (businessType.equals(BusinessTypeEnum.CANG_DAN_ZHI_YA.toString())){
			//????????????
			

		}else if(businessType.equals(BusinessTypeEnum.DING_XIANG_XIAO_SHOU.toString())){
			// ????????????
			
			// ???????????????  
			if(steps == 1) {
				inInstockBill.setDepositStatus(state);
			}
			// ??????????????????  ???????????????????????????
			if(steps == 2) {
				inInstockBill.setPaymentStatus(state);
			}
		}else if(businessType.equals(BusinessTypeEnum.CAI_GOU_ZI_XIAO.toString())) {
			//????????????
			// ???????????????  ???????????????????????????
			if(steps == 2) {
				inInstockBill.setFinancingLoanStatus(state);
			}
		}
		
		return inInstockBillMapper.updateByPrimaryKeySelective(inInstockBill) == 0 ? null : inInstockBill;
	}
	private boolean inSameDay(Date date1, Date Date2) {  
	    Calendar calendar = Calendar.getInstance();  
	    calendar.setTime(date1);  
	    int year1 = calendar.get(Calendar.YEAR);  
	    int day1 = calendar.get(Calendar.DAY_OF_YEAR);  
	  
	    calendar.setTime(Date2);  
	    int year2 = calendar.get(Calendar.YEAR);  
	    int day2 = calendar.get(Calendar.DAY_OF_YEAR);  
	  
	    if ((year1 == year2) && (day1 == day2)) {  
	        return true;  
	    }  
	    return false;  
	}  
}
