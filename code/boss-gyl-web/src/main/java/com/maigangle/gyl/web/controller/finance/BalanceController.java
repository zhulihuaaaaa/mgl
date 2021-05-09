package com.maigangle.gyl.web.controller.finance;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
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
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.FeeBalance;
import com.maigangle.gyl.facade.entity.FeeBalanceDetail;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.vo.FeeBalanceVo;
import com.maigangle.gyl.facade.enums.BalanceTypeEnum;
import com.maigangle.gyl.facade.enums.ContractBillStateEnum;
import com.maigangle.gyl.facade.enums.FinanceFlwoTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceTypeEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

@Controller
@RequestMapping("/balance")
public class BalanceController extends GylBaseWeb{
	@Autowired
	private InvInventoryService invInventoryService;
	@Autowired
	private BaseService baseService;
	@Autowired
	private FinanceService financeService;
	@Autowired
	private ContractService contractService;

	@Privilege(key = "GYL_BALANCE_VIEW")
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/finance/balanceIndex");
		return modelAndView;
	}
	
	/**
	 * 获取余额列表详情
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/findPage")
	@ResponseBody
	public AjaxResult findPageByStock(HttpServletRequest request,@RequestBody PageUtils<FeeBalanceVo> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取库存管理列表", "操作人ID为：" + getLoginName(request) + "获取库存管理列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  查询分页库存页面
			// 正式的逻辑
			PageInfo<FeeBalance> pageinfo= invInventoryService.getBalanceAll(page,true);
			if (pageinfo != null && pageinfo.getList() != null && !pageinfo.getList().isEmpty()) {
				for(int i = 0;i < pageinfo.getList().size();i++) {
					// 设置供应商
					if (!StringUtils.isEmpty(pageinfo.getList().get(i).getMakerId())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, pageinfo.getList().get(i).getMakerId());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据生产厂家ID检索生产厂家数据," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						pageinfo.getList().get(i).setMnfct(dictMallMnfct);
					}
					// 设置客户
					Map<String, Object> resultBuyer = getCrmClient(request, pageinfo.getList().get(i).getCustomerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					pageinfo.getList().get(i).setCustomerName(crmClientBuyer.getClientName());
				}
			}
			return AjaxResult.createSuccessResult(pageinfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取库存管理列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/finance/balanceDetail");
		return modelAndView;
	}
	
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取库存管理列表", "操作人ID为：" + getLoginName(request) + "获取库存管理列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			if (!StringUtils.isEmpty(id)) {
				List<FeeBalanceDetail> detailList = invInventoryService.getBalanceDetailById(id);
				if(!detailList.isEmpty()) {
					for(int i=0;i<detailList.size();i++) {
						FeeBalanceDetail fee = detailList.get(i);
						if (fee != null) {
							if (!StringUtils.isEmpty(fee.getContractId())) {
								fee.setContract(contractService.getConContractById(fee.getContractId()));
							}
							if (!StringUtils.isEmpty(fee.getFinanceId())) {
								fee.setFinance(financeService.getFinaceBill(fee.getFinanceId()));
							}
							if (!StringUtils.isEmpty(fee.getBalanceState())) {
								fee.setBalanceStateName(BalanceTypeEnum.getValueByKey(fee.getBalanceState()));
							}
						}
					}
				}
				return AjaxResult.createSuccessResult(detailList);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据id查询出库货物明细-id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询批量保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/** 
	 * 退款申请提交
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_BALANCE_SUBMIT")
	@RequestMapping("/update") 
	@ResponseBody   
	public AjaxResult update(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "退款申请提交", "操作人ID为：" + getLoginName(request) + "获取退款申请提交列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//查询明细详情
			FeeBalanceDetail detail = invInventoryService.getBalanceDetailByDetailId(id);
			if (detail != null) {
				if (!StringUtils.isEmpty(detail.getContractId())) {
					detail.setContract(contractService.getConContractById(detail.getContractId()));
				}
				if (!StringUtils.isEmpty(detail.getFinanceId())) {
					detail.setFinance(financeService.getFinaceBill(detail.getFinanceId()));
				}
			}
			//生成退款财务单
			FeeFinanceBill financeBill = new FeeFinanceBill();
			financeBill.setBusinessType(FinanceTypeEnum.TUI_KUAN.toString());
			financeBill.setContractId(detail.getContractId());
			financeBill.setContractCode(detail.getContract().getContractCode());
			financeBill.setRelationId(detail.getBalanceDetailId());
			financeBill.setRelationCode(detail.getContract().getContractCode());
			financeBill.setTotalMoney(detail.getPurchaseAmount());
			financeBill.setRealMoney(detail.getPurchaseAmount());
			financeBill.setActualAmount(new BigDecimal(0));
			financeBill.setCreateDate(new Date());
			financeBill.setFlwoType(FinanceFlwoTypeEnum.CHU_ZHANG.toString());
			financeBill = financeService.addFinanceBill(financeBill);
			//修改余额详情状态
			String state = detail.getBalanceState();
			invInventoryService.updateFeeBalanceDetailState(id);
			return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS,"申请成功");
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "提交验货子单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
}	
