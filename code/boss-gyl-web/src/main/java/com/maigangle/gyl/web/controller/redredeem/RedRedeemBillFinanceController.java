package com.maigangle.gyl.web.controller.redredeem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.dto.RedRedeemBillDto;
import com.maigangle.gyl.facade.entity.dto.RedRedeemDetailDto;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.FinanceFlwoTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceTypeEnum;
import com.maigangle.gyl.facade.enums.GoodsSourceEnum;
import com.maigangle.gyl.facade.enums.RedeemBillStateEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;


/**  
 * ????????????controller
 * @author zlh
 * @since 2017???11???28??? ??????3:07:20 
 * @version 1.0 
 */
@Controller
@RequestMapping("/redRedeemBillFinance")
public class RedRedeemBillFinanceController extends GylBaseWeb {
	@Autowired
	RedRedeemBillService redRedeemBillService;
	@Autowired
	InvInventoryService invInventoryService;
	@Autowired
	FinanceService financeService;
	@Autowired
	ContractService contractService;
	@Autowired
	BaseService baseService;
	
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/redRedeem/redRedeemBillFinanceDetail");
		return modelAndView;
	}
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/redRedeem/redRedeemBillFinanceIndex");
		return modelAndView;
	}
	/**
	 * ??????????????????????????????
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,@RequestBody PageUtils<RedRedeemBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			RedRedeemBillDto dtopage = page.getDto();
			List<String> goodsSource = new ArrayList<>();
			goodsSource.add(GoodsSourceEnum.GANG_CHANG_ZI_TI.toString());
			goodsSource.add(GoodsSourceEnum.KU_CUN_HUO_WU.toString());
			List<String> aduits = new ArrayList<>();
			aduits.add(ApprovalStateEnum.APPROVAL_COMPLETE.toString());
			aduits.add(ApprovalStateEnum.APPROVAL_UNDERWAY.toString());
			aduits.add(ApprovalStateEnum.APPROVAL_SUSPEND.toString());
			dtopage.setAuditStatusSearch(aduits);
			dtopage.setGoodsSourceSearch(goodsSource);
			PageInfo<RedRedeemBill> pages = redRedeemBillService.getAllRedRedeemBill(page, true);
			PageInfo<RedRedeemBillDto> pageDto = new PageInfo<RedRedeemBillDto>();
			List<RedRedeemBill> list = pages.getList();
			List<RedRedeemBillDto> listDto = new ArrayList<RedRedeemBillDto>();
			for (RedRedeemBill redRedeemBill : list) {
				RedRedeemBillDto dto = new RedRedeemBillDto();
				BeanUtils.copyProperties(redRedeemBill, dto);
				// ??????
				if(!StringUtils.isEmpty(redRedeemBill.getBuyerId())) {
					Map<String, Object> result = getCrmClient(request, redRedeemBill.getBuyerId());
					if (!(boolean)result.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result.get("msg"));
					}
					CrmClient crmClient = (CrmClient) result.get("data");
					dto.setBuyerName(crmClient.getClientName());
				}
				//??????
				if(!StringUtils.isEmpty(redRedeemBill.getStorageId())) {
					Map<String, Object> result1 = getDictMallDepot(request, redRedeemBill.getStorageId());
					if (!(boolean)result1.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result1.get("msg"));
					}
					DictMallDepot dictMallDepot = (DictMallDepot) result1.get("data");
					dto.setDictMallDepot(dictMallDepot);
				}
				ConContractVo  conContractVo = contractService.getConContractById(redRedeemBill.getContractId());
				dto.setContractNo(conContractVo.getContractNo());
				dto.setContractCode(conContractVo.getContractCode());
				
				listDto.add(dto);
			}
			BeanUtils.copyProperties(pages, pageDto);
			pageDto.setList(listDto);
			
			
			return AjaxResult.createSuccessResult(pageDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	/**
	 * ???????????????
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_REDREDEEM_FINANCE_EDIT")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request,@RequestBody RedRedeemBill redRedeemBill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (redRedeemBill != null && !StringUtils.isEmpty(redRedeemBill.getRedeemBillId())) {
				int rows = redRedeemBillService.updateRedRedeemBill(redRedeemBill);
				return rows == 0 ? AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED) : AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "?????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	/**
	 * ??????ID???????????????
	 * @param request
	 * @param buyerId
	 * @return List
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????ID?????????????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????ID???????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<RedRedeemDetail> list = redRedeemBillService.getRedRedeemDetailByBillId(id);
			List<RedRedeemDetailDto> listDto = new ArrayList<RedRedeemDetailDto>();
			for (RedRedeemDetail redRedeemDetail : list) {
				RedRedeemDetailDto dto = new RedRedeemDetailDto();
				BeanUtils.copyProperties(redRedeemDetail, dto);
				
				//??????
				if(!StringUtils.isEmpty(redRedeemDetail.getStorageId())) {
					Map<String, Object> result1 = getDictMallDepot(request, redRedeemDetail.getStorageId());
					if (!(boolean)result1.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result1.get("msg"));
					}
					DictMallDepot dictMallDepot = (DictMallDepot) result1.get("data");
					dto.setDictMallDepot(dictMallDepot);
				}
				//?????????
				if(!StringUtils.isEmpty(redRedeemDetail.getMnfctId())) {
					Map<String, Object> result1 = getDictMallMnfct(request, redRedeemDetail.getMnfctId());
					if (!(boolean)result1.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result1.get("msg"));
					}
					DictMallMnfct dictMallMnfct = (DictMallMnfct) result1.get("data");
					dto.setDictMallMnfct(dictMallMnfct);
				}
				// ??????
				if(!StringUtils.isEmpty(redRedeemDetail.getProductId())) {
					BaseProduct baseProduct =  baseService.getBaseProductById(redRedeemDetail.getProductId());
					dto.setBaseProduct(baseProduct);
				}
				
				listDto.add(dto);
				
			}
			
			return AjaxResult.createSuccessResult(listDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????ID?????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * ??????????????????
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_REDREDEEM_FINANCE_APPROVAL")
	@RequestMapping("/updateState")
	@ResponseBody
	public AjaxResult updateState(HttpServletRequest request, @RequestBody RedRedeemBillDto bill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			
			if (bill != null && !StringUtils.isEmpty(bill.getRedeemBillId()) && !StringUtils.isEmpty(bill.getAuditType())) {
				boolean result = redRedeemBillService.doAudit(bill.getRedeemBillId(), bill.getAuditType());
				if (result && bill.getAuditType().equals(ApprovalStateEnum.APPROVAL_COMPLETE.toString())) {
					FeeFinanceBill financeBill = new FeeFinanceBill();
					financeBill.setCreateDate(new Date());
					financeBill.setBusinessType(FinanceTypeEnum.SHU_HUO_KUAN.toString());
					financeBill.setRealMoney(bill.getRealMoney());
					financeBill.setContractId(bill.getContractId());
					financeBill.setContractCode(bill.getContractCode());
					financeBill.setRelationCode(bill.getRedeemBillCode());
					financeBill.setRelationId(bill.getRedeemBillId());
					financeBill.setTotalGoodsPayment(bill.getTotalGoodsPayment());
					financeBill.setTotalMoney(bill.getTotalMoney());
					financeBill.setCommissionFee(bill.getCommissionFee());
					financeBill.setChargingDays(bill.getChargingDays());
					financeBill.setDepositFee(bill.getDepositFee());
					financeBill.setInvoiceFee(bill.getInvoiceFee());
					financeBill.setOtherFee(bill.getOtherFee());
					financeBill.setActualAmount(BigDecimal.ZERO);
					financeBill.setFlwoType(FinanceFlwoTypeEnum.JIN_ZHANG.toString());
					financeService.addFinanceBill(financeBill);
					// ????????????????????????????????????
					RedRedeemBill bills = new RedRedeemBill();
					bills.setRedeemBillId(bill.getRedeemBillId());
					bills.setRedeemStatus(RedeemBillStateEnum.DAI_SHOU_KUN.getType());
					update(request, bills);
				}
				if (result && bill.getAuditType().equals(ApprovalStateEnum.APPROVAL_SUSPEND.toString())) {
					redRedeemBillService.billWasAudited(bill.getRedeemBillId(), bill.getAuditType());
				}
				return AjaxResult.createSuccessResultWithCode(MessageCode.OPERATE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
}