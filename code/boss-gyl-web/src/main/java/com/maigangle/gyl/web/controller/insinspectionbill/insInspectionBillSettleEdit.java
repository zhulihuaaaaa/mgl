package com.maigangle.gyl.web.controller.insinspectionbill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.BaseProcess;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InsInspectionSub;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.dto.InStockBillDto;
import com.maigangle.gyl.facade.entity.dto.InsInspectionBillDto;
import com.maigangle.gyl.facade.entity.vo.InsInspectionBillVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.BusinessTypeEnum;
import com.maigangle.gyl.facade.enums.ImageFileTypeEnum;
import com.maigangle.gyl.facade.enums.InspectionTypeEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.GylBaseService;
import com.maigangle.gyl.facade.service.InsInspectionBillService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;
/**
 * ????????????????????????????????????
 * @author ?????????
 * @since  2017???12???1??? - ??????2:17:09
 * @version 1.0
 */
@Controller
@RequestMapping("/settleAudit")
public class insInspectionBillSettleEdit extends GylBaseWeb {
	@Autowired
	InsInspectionBillService insInspectionBillService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private InstockBillService instockBillService;
	@Autowired
	private GylBaseService gylBaseService;
	@Autowired
	private  BaseService baseService;
	/*************************??????*************/
	/**
	 * 
	 * @author shmily
	 * @Title: main 
	 * @Description: ( ???????????????????????????????????? ) 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/financial/main")
	public ModelAndView financialMain() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillFinancialEditIndex");
		return modelAndView;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: main 
	 * @Description: ( ???????????????????????????????????? ) 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/main")
	public ModelAndView settleMain() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillSettleEditIndex");
		return modelAndView;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: main 
	 * @Description: ( ??????????????????????????? ) 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/warranty/main")
	public ModelAndView warrantyMain() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillWarrantyIndex");
		return modelAndView;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: detail 
	 * @Description: ( ?????????????????????????????? ) 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/warranty/detail")
	public ModelAndView warrantyDetail() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillWarrantyDetail");
		// ????????????????????????
		return modelAndView;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: detail
	 * @Description: (??????????????????????????????????????? )
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/financial/detail")
	public ModelAndView financialDetail() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillFinancialEditDetail");
		// ????????????????????????
		return modelAndView;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: detail 
	 * @Description: ( ??????????????????????????????????????? ) 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/settle/detail")
	public ModelAndView settleDetail() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillSettleEditDetail");
		// ????????????????????????
		return modelAndView;
	}
	
	
	
	
	/**
	 * ??????????????????
	 * ??????????????????
	 * @param request
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,@RequestBody PageUtils<InsInspectionBillVo> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageUtils<InsInspectionBillDto> page1 = format(page);			
			return AjaxResult.createSuccessResult(getPageInfoToPageInfoBySub(request,logBatch,insInspectionBillService.getInsInspectionSub(page1,true)));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "?????????????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	
	/**
	 * ???????????????????????????
	 * ???????????????
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSubDetail")
	@ResponseBody
	public AjaxResult getSubDetail(HttpServletRequest request, String insInspectionSubId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		
		try {
			super.logInfo(request, logBatch, "??????id?????????????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ??????
			//  ????????????????????????
			if (StringUtils.isEmpty(insInspectionSubId)){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"id????????????");
			}
			return AjaxResult.createSuccessResult(insInspectionBillService.getgetInsInspectionSubById(insInspectionSubId));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????id?????????????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * ???????????????????????????
	 * ??????
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_INSLNSPECTIONBILLSETTLE_AUDIT")
	@RequestMapping("/price/update")
	@ResponseBody  
	public AjaxResult priceUpdate(HttpServletRequest request,@RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ???????????????????????? 
			if(insInspectionBillVo == null || insInspectionBillVo.getInsInspectionDetail() == null ) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
			String inspectionDetailId =insInspectionBillVo.getInsInspectionDetail().getInspectionDetailId();
			BigDecimal realUnitPrice= insInspectionBillVo.getInsInspectionDetail().getRealUnitPrice();
			BigDecimal realMoney = insInspectionBillVo.getInsInspectionDetail().getRealMoney();
			if (StringUtils.isEmpty(inspectionDetailId)){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"????????????");
			}
			//  ????????????????????????
			InsInspectionDetail insInspectionDetail = new InsInspectionDetail();
			insInspectionDetail.setInspectionDetailId(inspectionDetailId);
			insInspectionDetail.setRealUnitPrice(realUnitPrice);
			insInspectionDetail.setRealMoney(realMoney);
			InsInspectionBillDto dto = new InsInspectionBillDto();
			dto.setInsInspectionDetail(insInspectionDetail);
			return AjaxResult.createSuccessResult(insInspectionBillService.updateInsInspectionDetail(dto));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "?????????????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * ???????????????????????????
	 * ??????
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_INSLNSPECTIONBILLSETTLE_EDIT")
	@RequestMapping("/bathprice/update")
	@ResponseBody  
	public AjaxResult bathpriceUpdate(HttpServletRequest request,@RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			int i = insInspectionBillService.bathUpdateInspectionDetailPrice(insInspectionBillVo);
			if(i==0) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
			return AjaxResult.createSuccessResultWithCode(MessageCode.OPERATE_SUCCESS, fomatbyDtoBySub(request,logBatch,insInspectionBillService.getInsInspectionSubById(insInspectionBillVo.getId())));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	/**
	 * ???????????????????????????
	 * ??????
	 * 
	 * @param request
	 * @return  
	 */
	@Privilege(key = "GYL_INSLNSPECTIONBILLSETTLE_DELETE")
	@RequestMapping("/detail/delete")
	@ResponseBody
	public AjaxResult deleteDetail(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());	
		try {
			super.logInfo(request, logBatch, "???????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ????????????????????????
			String inspectionDetailId = id;
			//  ??????
			if (StringUtils.isEmpty(inspectionDetailId)){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID????????????");
			}
			Integer num = insInspectionBillService.deleteInsInspectionDetail(inspectionDetailId);
			return AjaxResult.createSuccessResult(num);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * ???????????????????????????
	 * ??????????????????
	 * settlementDto.setBusinessType("A");
	 *settlementDto.setId("1");
	 *settlementDto.setAuditStatus("??????");
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/updatePassOrNoPass")
	@ResponseBody
	public AjaxResult updatePassOrNoPass(HttpServletRequest request,@RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		Integer i = -1;
		
		try {
			super.logInfo(request, logBatch, "???????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// 
			if(insInspectionBillVo == null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"id????????????????????????");
			}
			InsInspectionBillDto settlementDto = new InsInspectionBillDto();
			settlementDto.setBusinessType(insInspectionBillVo.getBusinessType());
			settlementDto.setContractId(insInspectionBillVo.getContractId());
			settlementDto.setId(insInspectionBillVo.getId());
			settlementDto.setAuditStatus(insInspectionBillVo.getAuditStatus());
			settlementDto.setInsInspectionBillId(insInspectionBillVo.getInsInspectionBillId());
			settlementDto.setInstockId(insInspectionBillVo.getInstockId());
			//  ????????????????????????
			// ?????? id ????????? ??? ?????? 
			if (settlementDto==null){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"??????????????????");
			}
			if(StringUtils.isEmpty(settlementDto.getAuditStatus()) || StringUtils.isEmpty(settlementDto.getId())){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"id????????????????????????");
			}
			String type = settlementDto.getBusinessType();
			String stats = settlementDto.getAuditStatus();
//			???????????????????????????
			if (BusinessTypeEnum.HUO_YA_RONG_ZI.getType().equals(type)||BusinessTypeEnum.DING_XIANG_XIAO_SHOU.getType().equals(type)){
				i = insInspectionBillService.updateFinancialPassOrNotpass(settlementDto);
				if(BusinessTypeEnum.HUO_YA_RONG_ZI.getType().equals(type)&&ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(stats)) {
					// ???????????????????????? updateStats
					if(i==1) {
						insInspectionBillService.updateStats(settlementDto.getInsInspectionBillId(),InspectionTypeEnum.YI_YAN_HUO.toString(), 0);
						InInstockBill dto = instockBillService.getInstockBillById(settlementDto.getInstockId()).getBill();
						dto.setInspectionStatus(InspectionTypeEnum.YI_YAN_HUO.toString());
						instockBillService.updateInstockBill(dto);
					}
				}
			}
//			???????????????????????????
			if (BusinessTypeEnum.CAI_GOU_ZI_XIAO.getType().equals(type) || BusinessTypeEnum.CANG_DAN_ZHI_YA.getType().equals(type)){
				i = insInspectionBillService.updateFinancialPassOrNotpass(settlementDto);
				if(BusinessTypeEnum.CANG_DAN_ZHI_YA.getType().equals(type)&&ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(stats)) {
					// ???????????????????????? updateStats
					if(i==1) {
						insInspectionBillService.updateStats(settlementDto.getInsInspectionBillId(),InspectionTypeEnum.YI_YAN_HUO.toString(), 0);
						InInstockBill dto = instockBillService.getInstockBillById(settlementDto.getInstockId()).getBill();
						dto.setInspectionStatus(InspectionTypeEnum.YI_YAN_HUO.toString());
						instockBillService.updateInstockBill(dto);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
		}
		if(1 == i) {
			return AjaxResult.createSuccessResultWithCode(MessageCode.OPERATE_SUCCESS, i);
		}else {
			return  AjaxResult.createSuccessResultWithCode(MessageCode.OPERATE_FAILED, i);
		}
	}
	
	/**
	 * ?????????????????????
	 * @param request
	 * @return
	 */
	@RequestMapping("/sub/findAll")
	@ResponseBody   
	public AjaxResult findAllBySub(HttpServletRequest request,String subCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " ???????????????????????????", "?????????ID??????" + getLoginName(request) + " ????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ??????????????????
			return  AjaxResult.createSuccessResult(fomatbyListDtoBySub(request,logBatch,insInspectionBillService.getInsInspectionSubAllBySubCode(subCode)));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	
	/**
	 * 
	 * @author shmily
	 * @Title: format 
	 * @Description: ( VO -- DTO ) 
	 * @param page
	 * @return PageUtils<InsInspectionBillDto>
	 * @throws
	 */
	private PageUtils<InsInspectionBillDto> format(PageUtils<InsInspectionBillVo> page){
		PageUtils<InsInspectionBillDto> page1 =new PageUtils<InsInspectionBillDto>();
		page1.setDto(new InsInspectionBillDto());
		if (!StringUtils.isEmpty(page.getOrderByClause())) {
			page1.setOrderByClause(page.getOrderByClause());
		}
		if(!StringUtils.isEmpty(page.getPageSize())) {
			page1.setPageSize(page.getPageSize());
		}
		if(!StringUtils.isEmpty(page.getPageNum())) {
			page1.setPageNum(page.getPageNum());
		}
		InsInspectionBillVo vo = page.getDto();
		if (vo == null) {
			return page1;
		}
		InsInspectionBillDto dto = page1.getDto();
		if (StringUtils.isEmpty(vo.getAuditStatus())) {
			dto.setAuditStatus("");
		}else {
			dto.setAuditStatus(vo.getAuditStatus());
		}
		if (StringUtils.isEmpty(vo.getContractNo())) {
			dto.setContractNo("");
		}else {
			dto.setContractNo(vo.getContractNo());
		}
		if (vo.getMaxDate() == null) {
			dto.setMaxDate(null);
		}else {
			dto.setMaxDate(vo.getMaxDate());
		}
		if (vo.getMinDate() == null) {
			dto.setMinDate(null);
		}else {
			dto.setMinDate(vo.getMinDate());
		}
		if (StringUtils.isEmpty(vo.getSubCode())){
			dto.setSubCode("");
		}else {
			dto.setSubCode(vo.getSubCode());
		}
		if (StringUtils.isEmpty(vo.getCreateUser())) {
			dto.setCreateUser("");
		}else {
			dto.setCreateUser(vo.getCreateUser());
		}
		if(vo.getTypeList() == null || vo.getTypeList().isEmpty()) {
			dto.setTypeList(null);
		}else {
			dto.setTypeList(vo.getTypeList());
		}
		if(vo.getAuditStatusList() == null || vo.getAuditStatusList().isEmpty()) {
			dto.setAuditStatusList(null);
		}else {
			dto.setAuditStatusList(vo.getAuditStatusList());
		}
		if(vo.getBusinessType()== null) {
			dto.setBusinessType(null);
		}else {
			dto.setBusinessType(vo.getBusinessType());
		}
		dto.setContractId(vo.getContractId());
		return page1;
	}
	/***************************************????????????start**********************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getPageInfoToPageInfoByBill 
	 * @Description: ( ???????????? PageInfo ---> PageInfo ????????????????????????????????????  ) 
	 * @param request
	 * @param logBatch
	 * @param pageInfo
	 * @return PageInfo<InsInspectionBillDto>
	 * @throws
	 */
	@SuppressWarnings("unused")
	private PageInfo<InsInspectionBillDto> getPageInfoToPageInfoByBill(HttpServletRequest request, String logBatch,PageInfo<InsInspectionBill> pageInfo){
		
        PageInfo<InsInspectionBillDto> pageDto = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageDto);
        pageDto.setList(fomatbyListDtoByBill(request,logBatch,pageInfo.getList()));
		return pageDto;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyListDto 
	 * @Description: ( ????????????  ??????????????????Dto ) 
	 * @param request
	 * @param logBatch
	 * @param list
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	private  List<InsInspectionBillDto> fomatbyListDtoByBill(HttpServletRequest request, String logBatch,List<InsInspectionBill> list) {
		List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		if(list==null||list.isEmpty()) {
			return dtoList;
		}
		for (InsInspectionBill InsInspectionBill : list) {
			InsInspectionBillDto dto =fomatbyDtoByBill(request,logBatch,InsInspectionBill);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyDto 
	 * @Description: ( ???????????? ????????????Dto ) 
	 * @param inventory
	 * @return InvInventoryDto
	 * @throws
	 */
	@SuppressWarnings("unused")
	private  InsInspectionBillDto fomatbyDtoByBill(HttpServletRequest request, String logBatch,InsInspectionBill ins) {
		 if (ins == null) {
			 return null;
		 }
		InsInspectionBillDto dto = new InsInspectionBillDto();
		dto.setInsInspectionBill(ins);
		//  ????????? 
		
		
		
		//  ????????????
		if (!StringUtils.isEmpty(ins.getInstockId())) {
			InStockBillDto ininstock = instockBillService.getInstockBillById(ins.getInstockId());
			if (ininstock !=null&&ininstock.getBill()!=null ) {
				String instockNo = ininstock.getInstockCode();
				dto.setInstockNo(ininstock.getBill().getInstockCode());
			}
		}
		//  ????????????
		if (!StringUtils.isEmpty(ins.getContractId())) {
			ConContract con = contractService.getConContractById(ins.getContractId());
			if (con !=null) {
				String contractNo =con.getContractNo();
				dto.setConContract(con);
				dto.setContractNo(contractNo);
			}
		}
		return  dto;
	}
	/***************************************????????????end**********************************/
	
	
	/**************************************????????????Start**********************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getPageInfoToPageInfoBySub 
	 * @Description: ( ???????????? PageInfo ---> PageInfo ????????????????????????????????????  ) 
	 * @param request
	 * @param logBatch
	 * @param pageInfo
	 * @return PageInfo<InsInspectionBillDto>
	 * @throws
	 */
	private PageInfo<InsInspectionBillDto> getPageInfoToPageInfoBySub(HttpServletRequest request, String logBatch,PageInfo<InsInspectionSub> pageInfo){
		
        PageInfo<InsInspectionBillDto> pageDto = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageDto);
        pageDto.setList(fomatbyListDtoBySub(request,logBatch,pageInfo.getList()));
		return pageDto;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyListDto 
	 * @Description: ( ????????????  ??????????????????Dto ) 
	 * @param request
	 * @param logBatch
	 * @param list
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	private  List<InsInspectionBillDto> fomatbyListDtoBySub(HttpServletRequest request, String logBatch,List<InsInspectionSub> list) {
		List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		if(list==null||list.isEmpty()) {
			return dtoList;
		}
		for (InsInspectionSub insInspectionSub : list) {
			InsInspectionBillDto dto =fomatbyDtoBySub(request,logBatch,insInspectionSub);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyDto 
	 * @Description: ( ???????????? ????????????Dto ) 
	 * @param inventory
	 * @return InvInventoryDto
	 * @throws
	 */
	private  InsInspectionBillDto fomatbyDtoBySub(HttpServletRequest request, String logBatch,InsInspectionSub insInspectionSub) {
		InsInspectionBillDto insInspectionBillDto = new InsInspectionBillDto();
		insInspectionBillDto.setInsInspectionSub(insInspectionSub);
		// ???????????????
		List<Attach> attach = gylBaseService.getAttachByIdAndType(insInspectionSub.getInspectionSubId(), ImageFileTypeEnum.ZHI_BAO_SHU.toString());
		if (attach !=null) {
			insInspectionBillDto.setWarrantyList(attach);
		}
		// ??????????????????
		List<Attach>  inventoryVoucher = gylBaseService.getAttachByIdAndType(insInspectionSub.getInspectionSubId(), ImageFileTypeEnum.CUN_HUO_PING_ZHENG.toString());
		if (inventoryVoucher !=null) {
			insInspectionBillDto.setInventoryVoucherList(inventoryVoucher);
		}
		// ????????????
		InsInspectionBill insInspectionBill = insInspectionBillService.getInsInspectionBillById(insInspectionSub.getInspectionId());
		if (insInspectionBill !=null) {
			ConContract con = contractService.getConContractById(insInspectionBill.getContractId());
			if (con !=null) {
				insInspectionBillDto.setContractNo(con.getContractNo());
				insInspectionBillDto.setConContract(con);
			}
			// ?????????
			insInspectionBillDto.setInsInspectionBill(insInspectionBill);
		}
		// ??????
		DictMallDepot dictMallDepot = null;
		if(!StringUtils.isEmpty(insInspectionSub.getStorageId())) {
			Map<String, Object> result = getDictMallDepot(request,insInspectionSub.getStorageId());
			if ((boolean) result.get("isSuccess")) {
				dictMallDepot = (DictMallDepot)result.get("data");				
			}
			if(dictMallDepot!=null) {
				insInspectionBillDto.setDictMallDepot(dictMallDepot);
			}
		}
		return insInspectionBillDto;
	}
	/**************************************????????????end**********************************/
	/**************************************????????????Start********************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getPageInfoToPageInfoByDetail
	 * @Description: ( ???????????? PageInfo ---> PageInfo ????????????????????????????????????  ) 
	 * @param request
	 * @param logBatch
	 * @param pageInfo
	 * @return PageInfo<InsInspectionBillDto>
	 * @throws
	 */
	@SuppressWarnings("unused")
	private PageInfo<InsInspectionBillDto> getPageInfoToPageInfoByDetail(HttpServletRequest request, String logBatch,PageInfo<InsInspectionDetail> pageInfo){
        PageInfo<InsInspectionBillDto> pageDto = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageDto);
        pageDto.setList(fomatbyListDtoByDetail(request,logBatch,pageInfo.getList()));
		return pageDto;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyListDto 
	 * @Description: ( ????????????  ??????????????????Dto ) 
	 * @param request
	 * @param logBatch
	 * @param list
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	private  List<InsInspectionBillDto> fomatbyListDtoByDetail(HttpServletRequest request, String logBatch,List<InsInspectionDetail> list) {
		List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		if(list==null||list.isEmpty()) {
			return dtoList;
		}
		for (InsInspectionDetail insInspectionDetail : list) {
			InsInspectionBillDto dto =fomatbyDtoByDetail(request,logBatch,insInspectionDetail);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyDto 
	 * @Description: ( ???????????? ????????????Dto ) 
	 * @param inventory
	 * @return InvInventoryDto
	 * @throws
	 */
	private  InsInspectionBillDto fomatbyDtoByDetail(HttpServletRequest request, String logBatch,InsInspectionDetail insInspectionDetail) {
		InsInspectionBillDto dto = new InsInspectionBillDto();
		dto.setInsInspectionDetail(insInspectionDetail);
		//?????????DTO
		 //????????????
		List<Attach> attach = gylBaseService.getAttachByIdAndType(insInspectionDetail.getInspectionDetailId(), ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
		if (attach !=null) {
			dto.setSphotosGoodsList(attach);
		}
		// ??????
		BaseProduct baseProduct = baseService.getBaseProductById(insInspectionDetail.getProductId());
		if (baseProduct != null) {
			String productName = baseProduct.getProductName();
			dto.setProductName(productName);
			dto.setBaseProduct(baseProduct);
		}
		//??????
		//  ??????
		BaseProcess baseProcess = baseService.getBaseProcess(insInspectionDetail.getSurfaceId());
		if (baseProcess !=null) {
			dto.setSurfaceName(baseProcess.getProcessName());
		}
		// ??????
		DictMallDepot dictMallDepot =null;
		if(!StringUtils.isEmpty(insInspectionDetail.getStorageId())) {
			Map<String, Object> result = getDictMallDepot(request,insInspectionDetail.getStorageId());
			if ((boolean) result.get("isSuccess")) {
				dictMallDepot = (DictMallDepot)result.get("data");				
			}
		}
		if (dictMallDepot != null) {
			dto.setDictMallDepot(dictMallDepot);
		}
		// ????????? ??????
		DictMallMnfct dictMallMnfct = null;
		if(!StringUtils.isEmpty(insInspectionDetail.getMnfctId())) {
			Map<String, Object> result = getDictMallMnfct(request,insInspectionDetail.getMnfctId());
			if ((boolean) result.get("isSuccess")) {
				dictMallMnfct = (DictMallMnfct)result.get("data");				
			}
			if(dictMallMnfct!=null) {
				dto.setDictMallMnfct(dictMallMnfct);
			}
		}
		return dto;
	}
	/**************************************????????????end***************************************************/
	
}
