package com.maigangle.gyl.web.controller.finance;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.FeeBalanceDetail;
import com.maigangle.gyl.facade.entity.FeeDepositAccount;
import com.maigangle.gyl.facade.entity.FeeDepositDetail;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.FeeFinanceBillDto;
import com.maigangle.gyl.facade.entity.excel.FeeFinanceBillExcel;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.FeeFinanceBillVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.FinanceFlwoTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceStateEnum;
import com.maigangle.gyl.facade.enums.FinanceTypeEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.FlowService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

/**
 * ??????Controller
 * @author ?????????
 * @since 2017???12???5??? ??????1:34:01
 * @varsion 1.0
 */
@Controller
@RequestMapping("/finance")
public class FinanceController extends GylBaseWeb {
	@Autowired
	private FinanceService financeService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private RedRedeemBillService redeemBillService;
	@Autowired
	private FlowService flowService;
	@Autowired
	private RedRedeemBillService redRedeemBillService;
	@Autowired
	private InstockBillService instockBillService;
	@Autowired
	private InvInventoryService invInventoryService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/finance/financeIndex");
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/finance/financeDetail");
		return modelAndView;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult saveFinaceBill(HttpServletRequest request, @RequestBody FeeFinanceBill bill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????", "?????????ID??????" + getLoginName(request) + "???????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkFinaceBill(bill, false);
			if (StringUtils.isEmpty(checkMsg)) {
				return AjaxResult.createSuccessResult(financeService.addFinanceBill(bill));
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@Privilege(key = "GYL_FINANCE_COMFIRM")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult updateFinaceBill(HttpServletRequest request, @RequestBody FeeFinanceBill bill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????", "?????????ID??????" + getLoginName(request) + "???????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkFinaceBill(bill, true);
			if (StringUtils.isEmpty(checkMsg)) {
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				bill.setStatus(FinanceStateEnum.YI_WAN_CHENG.toString());
				bill.setOperator(privUser.getUserName());
				bill.setOperatorDate(new Date());
				bill = financeService.updateFinaceBill(bill);
				if (bill != null) {
					if (!StringUtils.isEmpty(bill.getBusinessType())) {
						// ?????? ??????????????? ??? ?????????
						if (bill.getBusinessType().equals(FinanceTypeEnum.LV_YUE_BAO_ZHENG_JIN.toString()) 
								|| bill.getBusinessType().equals(FinanceTypeEnum.GOU_HUO_KUAN.toString())) {
							flowService.updateFlow(bill.getContractId(), bill.getFinanceBillId());
							if (bill.getBusinessType().equals(FinanceTypeEnum.GOU_HUO_KUAN.toString())) {
								instockBillService.updateApplyRemitByfID(bill.getFinanceBillId());
							}
							if (bill.getBusinessType().equals(FinanceTypeEnum.LV_YUE_BAO_ZHENG_JIN.toString())) {
								saveOrUpdateDeposit(privUser, bill, FinanceTypeEnum.LV_YUE_BAO_ZHENG_JIN.toString());
							}
							
						}
						// ?????????????????????
						if (bill.getBusinessType().equals(FinanceTypeEnum.ZHUI_JIA_BAO_ZHENG_JIN.toString())) {
							contractService.updateConDepositDetailState(bill.getContractId(), bill.getFinanceBillId());
							saveOrUpdateDeposit(privUser, bill, FinanceTypeEnum.ZHUI_JIA_BAO_ZHENG_JIN.toString());
						}
						// ??????????????????
						if (bill.getBusinessType().equals(FinanceTypeEnum.ZHUI_JIA_HUO_KUAN.toString())) {
							contractService.updateConPaymentDetailState(bill.getContractId(),bill.getFinanceBillId(), bill.getRelationId());
						}
						// ???????????????
						if (bill.getBusinessType().equals(FinanceTypeEnum.SHU_HUO_KUAN.toString())) {
							redRedeemBillService.billWasAudited(bill.getRelationId(), ApprovalStateEnum.APPROVAL_COMPLETE.toString());
						}
						// ????????????
						if (bill.getBusinessType().equals(FinanceTypeEnum.TUI_KUAN.toString())) {
							//??????????????????????????????
							//FeeBalanceDetail detail = invInventoryService.getBalanceDetailByDetailId(bill.getRelationId());
							//????????????????????????
							//String state = detail.getBalanceState();
							invInventoryService.updateFeeBalanceDetailState(bill.getRelationId());
						}
					}
					return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS, bill,
							bill.getFlwoType().equals(FinanceFlwoTypeEnum.CHU_ZHANG.toString()) ? "????????????" : "???????????????");
				} else {
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
				}
				
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	
	private void saveOrUpdateDeposit(PrivUser privUser, FeeFinanceBill bill, String type) {
		
		// ???????????????
		String createUser = privUser.getUserName();
		// ?????????????????????
		FeeDepositAccount account = financeService.getDepositAccountByContractId(bill.getContractId());
		ConContract contract = contractService.getConContractById(bill.getContractId());
		// ??????????????????????????????????????????
		if (account == null) {
			account = new FeeDepositAccount();
			account.setBusinessType(bill.getBusinessType());
			account.setContractId(bill.getContractId());
			account.setCreateDate(new Date());
			account.setCreateUser(createUser);
			account.setBalance(new BigDecimal(0));
			account.setDepositFee(new BigDecimal(0));
			account.setFinanceId(bill.getFinanceBillId());
			account.setBuyerId(contract != null ? contract.getBuyerId() : "");
			account = financeService.addDepositAccount(account);
		} 
		
		// ???????????????????????????
		FeeDepositDetail feeDepositDetail = new FeeDepositDetail();
		feeDepositDetail.setDepositAccountId(account.getDepositAccountId());
		feeDepositDetail.setContractId(bill.getContractId());
		feeDepositDetail.setCreateDate(new Date());
		feeDepositDetail.setCreateUser(createUser);
		feeDepositDetail.setUsedFee(bill.getActualAmount());
		feeDepositDetail.setUsedFee(new BigDecimal(0).subtract(bill.getActualAmount()));
		feeDepositDetail.setBalance(account.getBalance());
		feeDepositDetail = financeService.addDepositDetail(feeDepositDetail);
		
		if (type.equals(FinanceTypeEnum.ZHUI_JIA_BAO_ZHENG_JIN.toString())) {
			account.setBalance(account.getBalance().add(bill.getActualAmount()));
			account.setDepositFee(account.getDepositFee().add(bill.getActualAmount()));
			financeService.updateDepositAccount(account);
		}
		if (type.equals(FinanceTypeEnum.LV_YUE_BAO_ZHENG_JIN.toString())) {
			account.setBalance(bill.getActualAmount());
			account.setDepositFee(bill.getActualAmount());
			financeService.updateDepositAccount(account);
		}
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult deleteFinaceBill(HttpServletRequest request, String billId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????", "?????????ID??????" + getLoginName(request) + "???????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(billId)) {
				return AjaxResult.createSuccessResult(financeService.deleteFinaceBill(billId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "?????????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPageFinaceBills(HttpServletRequest request, @RequestBody PageUtils<FeeFinanceBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<FeeFinanceBillVo> info = financeService.getFinaceBills(page, false);
			if (info != null && info.getList() != null && !info.getList().isEmpty()) {
				for (FeeFinanceBillVo vo : info.getList()) {
					if (!StringUtils.isEmpty(vo.getContractId())) {
						vo.setContract(contractService.getConContractById(vo.getContractId()));
					}
					if (!StringUtils.isEmpty(vo.getBusinessType())) {
						if(vo.getBusinessType().equals(FinanceTypeEnum.SHU_HUO_KUAN.toString())) {
							//vo.setRedeem(redeemBillService.getRedRedeemBillByCode(vo.getRelationCode()));
						}
					}
					if (!StringUtils.isEmpty(vo.getBusinessType())) {
						vo.setBusinessTypeName(FinanceTypeEnum.getValueByKey(vo.getBusinessType()));
					}
				}
			}
			return AjaxResult.createSuccessResult(info);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAllFinaceBills(HttpServletRequest request, @RequestBody PageUtils<FeeFinanceBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(financeService.getFinaceBills(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOneFinaceBill(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "?????????id????????????");
			} else {
				return AjaxResult.createSuccessResult(financeService.getFinaceBill(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * ????????????
	 * @param bill
	 * @return
	 */
	private String checkFinaceBill(FeeFinanceBill bill, boolean isIgnoreId) {
		if (bill == null) {
			return "???????????????????????????";
		}
		String baseStr = "????????????";
		if (!isIgnoreId) {
			if (StringUtils.isEmpty(bill.getFinanceBillId())) {
				return "?????????id" + baseStr;
			}
		}
		if (bill.getRealMoney() == null) {
			return "???????????????" + baseStr;
		}
		return "";
	}
	
	/**
	 * ????????????Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_FINANCE_EXCEL")
	@RequestMapping("/exportExcel")
	@ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ???????????????????????????????????????????????????
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// ???????????????????????????
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("???????????????","UTF-8") + ".xls");
		//??????
		response.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");
		String orderByClause = null;
		FeeFinanceBillDto dto = null;
		if (!StringUtils.isEmpty(param)) {
			JSONObject paramObj = JSONObject.parseObject(param);
			orderByClause = paramObj.getString("orderByClause");
			dto = paramObj.getObject("dto", FeeFinanceBillDto.class);
		} else {
			dto = new FeeFinanceBillDto();
		}
		
		List<FeeFinanceBillExcel> list1 = new ArrayList<FeeFinanceBillExcel>();
		
		//????????????
		List<FeeFinanceBillVo> list = financeService.getFinaceBills(dto, orderByClause, false);
		if (list != null && !list.isEmpty()) {
			for (FeeFinanceBillVo vo : list) {
				FeeFinanceBillExcel feeFinanceBillExcel = new FeeFinanceBillExcel();
				BeanUtils.copyProperties(vo, feeFinanceBillExcel);
				if (!StringUtils.isEmpty(vo.getContractId())) {
					// ?????????????????????
					ConContractVo vos  = contractService.getConContractById(vo.getContractId());
					feeFinanceBillExcel.setContractCode(vos.getContractCode());
					// ??????????????????
					feeFinanceBillExcel.setContractNo(vos.getContractNo());
				}
				// ??????????????????
				if (!StringUtils.isEmpty(vo.getFinanceCode())) {
					feeFinanceBillExcel.setFinanceCode(vo.getFinanceCode());
				}
				// ??????????????????
				if (!StringUtils.isEmpty(vo.getRelationCode())) {
					feeFinanceBillExcel.setRelationCode(vo.getRelationCode());
				}
				// ??????????????????
				if (!StringUtils.isEmpty(vo.getFlwoType())) {
					feeFinanceBillExcel.setFlwoType(vo.getFlwoType());
				}
				// ??????????????????
				if (!StringUtils.isEmpty(vo.getBusinessType())) {
					feeFinanceBillExcel.setBusinessType(vo.getBusinessType());
				}
				// ??????????????????
				if (!StringUtils.isEmpty(vo.getActualAmount())) {
					feeFinanceBillExcel.setActualAmount(vo.getActualAmount());
				}
				// ?????????????????????
				if (!StringUtils.isEmpty(vo.getRealMoney())) {
					feeFinanceBillExcel.setRealMoney(vo.getRealMoney());
				}
				// ???????????????
				if (!StringUtils.isEmpty(vo.getOperator())) {
					feeFinanceBillExcel.setOperator(vo.getOperator());
				}
				// ??????????????????
				if (!StringUtils.isEmpty(vo.getOperatorDate())) {
					feeFinanceBillExcel.setOperatorDate(vo.getOperatorDate());
				}
				// ?????????????????????
				if (!StringUtils.isEmpty(vo.getStatus())) {
					feeFinanceBillExcel.setStatus(vo.getStatus());
				}
				// ??????????????????
				if (!StringUtils.isEmpty(vo.getCreateDate())) {
					feeFinanceBillExcel.setCreateDate(vo.getCreateDate());
				}
				list1.add(feeFinanceBillExcel);
			}
			
		}
		
		ExportParams params1 = new ExportParams() ;  
        // ??????sheet?????????  
        params1.setSheetName("????????????"); 
        // ??????sheet1?????????map  
        Map dataMap1 = new HashMap<>();  
        // title????????????ExportParams????????????????????????ExportParams????????????sheetName  
        dataMap1.put("title",params1) ;  
        // ?????????????????????????????????  
        dataMap1.put("entity",FeeFinanceBillExcel.class) ;  
        // sheet?????????????????????  
        dataMap1.put("data",list1) ;
        
        // ???sheet1???sheet2?????????map????????????  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
	}
	
}
