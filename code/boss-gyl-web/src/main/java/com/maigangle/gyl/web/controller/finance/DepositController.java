package com.maigangle.gyl.web.controller.finance;

import java.util.ArrayList;
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
import com.maigangle.gyl.facade.entity.FeeDepositAccount;
import com.maigangle.gyl.facade.entity.FeeDepositDetail;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.FeeDepositAccountDto;
import com.maigangle.gyl.facade.entity.dto.FeeDepositDetailDto;
import com.maigangle.gyl.facade.entity.vo.FeeDepositAccountVo;
import com.maigangle.gyl.facade.entity.vo.FeeDepositDetailVo;
import com.maigangle.gyl.facade.enums.BusinessTypeEnum;
import com.maigangle.gyl.facade.enums.FeeTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceTypeEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

/**
 * 保证金
 * @author 汪玮琦
 * @since 2017年12月18日 下午3:51:43
 * @varsion 1.0
 */
@Controller
@RequestMapping("/deposit")
public class DepositController extends GylBaseWeb{
	@Autowired
	private FinanceService financeService;
	@Autowired
	private ContractService contractService;
	
	@Privilege(key = "GYL_DEPOSIT_VIEW")
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/finance/depositIndex");
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/finance/depositDetail");
		return modelAndView;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult saveDepositAccount(HttpServletRequest request, @RequestBody FeeDepositAccount account) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增保证金账号", "操作人ID为：" + getLoginName(request) + "新增保证金账号",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkDepositAccount(account, false);
			if (StringUtils.isEmpty(checkMsg)) {
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				account.setCreateDate(new Date());
				account.setCreateUser(privUser.getUserName());
				return AjaxResult.createSuccessResult(financeService.addDepositAccount(account));
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增保证金账号",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}	
	
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult updateDepositAccount(HttpServletRequest request, @RequestBody FeeDepositAccount account) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新保证金账号", "操作人ID为：" + getLoginName(request) + "更新保证金账号",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkDepositAccount(account, true);
			if (StringUtils.isEmpty(checkMsg)) {
				return AjaxResult.createSuccessResult(financeService.updateDepositAccount(account));
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新保证金账号",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult deleteDepositAccount(HttpServletRequest request, String accountId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除保证金账号", "操作人ID为：" + getLoginName(request) + "删除保证金账号",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(accountId)) {
				return AjaxResult.createSuccessResult(financeService.deleteDepositAccount(accountId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "保证金账号id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除保证金账号",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPageDepositAccounts(HttpServletRequest request, @RequestBody PageUtils<FeeDepositAccountDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取保证金账号并分页", "操作人ID为：" + getLoginName(request) + "根据条件获取保证金账号并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<FeeDepositAccountVo> info = financeService.getDepositAccounts(page, false);
			if (info != null && info.getList() != null && !info.getList().isEmpty()) {
				for (FeeDepositAccountVo vo : info.getList()) {
					if (!StringUtils.isEmpty(vo.getBuyerId())) {
						Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
						if (!(boolean)resultBuyer.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
						}
						CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
						vo.setCrmClient(crmClientBuyer);
					}
					if (!StringUtils.isEmpty(vo.getContractId())) {
						vo.setContract(contractService.getConContractById(vo.getContractId()));
					}
					if (!StringUtils.isEmpty(vo.getFinanceId())) {
						vo.setFinance(financeService.getFinaceBill(vo.getFinanceId()));
					}
				}
			}
			return AjaxResult.createSuccessResult(info);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取保证金账号并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAllDepositAccounts(HttpServletRequest request, @RequestBody PageUtils<FeeDepositAccountDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取保证金账号", "操作人ID为：" + getLoginName(request) + "根据条件获取保证金账号",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(financeService.getDepositAccounts(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取保证金账号",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOneDepositAccount(HttpServletRequest request, String accountId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取保证金账号", "操作人ID为：" + getLoginName(request) + "根据条件获保证金账号",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(accountId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "保证金账号id不能为空");
			} else {
				return AjaxResult.createSuccessResult(financeService.getDepositAccount(accountId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获保证金账号",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findOneByContractId")
	@ResponseBody
	public AjaxResult findOneByContractId(HttpServletRequest request, String contractId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取保证金账号", "操作人ID为：" + getLoginName(request) + "根据条件获保证金账号",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(contractId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "保证金账号id不能为空");
			} else {
				return AjaxResult.createSuccessResult(financeService.getDepositAccountByContractId(contractId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获保证金账号",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 检查必填项
	 * @param account
	 * @param isIgnoreId
	 * @return
	 */
	private String checkDepositAccount(FeeDepositAccount account, boolean isIgnoreId) {
		if (account == null) {
			return "保证金账号实体不能为空";
		}
		String baseStr = "不能为空";
		if (StringUtils.isEmpty(account.getBuyerId())) {
			return "客户信息" + baseStr;
		}
		if (StringUtils.isEmpty(account.getContractId())) {
			return "关联合同信息" + baseStr;
		}
		if (StringUtils.isEmpty(account.getFinanceId())) {
			return "关联保证金财务单" + baseStr;
		}
		if (account.getDepositFee() == null) {
			return "保证金金额" + baseStr;
		}
		if (account.getBalance() == null) {
			return "剩余金额" + baseStr;
		}
		return "";
	}
	
	
	@RequestMapping("/saveDepositDetail")
	@ResponseBody
	public AjaxResult saveDepositDetail(HttpServletRequest request, @RequestBody FeeDepositDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增保证金消费明细", "操作人ID为：" + getLoginName(request) + "新增保证金消费明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkDepositDetail(detail, true);
			if (StringUtils.isEmpty(checkMsg)) {
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				detail.setCreateDate(new Date());
				detail.setCreateUser(privUser.getUserName());
				
				FeeDepositAccount account = financeService.getDepositAccount(detail.getDepositAccountId());
				if (account != null) {
					account.setBalance(account.getBalance().subtract(detail.getBalance()));
					financeService.updateDepositAccount(account);
				}
				
				return AjaxResult.createSuccessResult(financeService.addDepositDetail(detail));
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@RequestMapping("/saveDepositDetails")
	@ResponseBody
	public AjaxResult saveDepositDetails(HttpServletRequest request, @RequestBody List<FeeDepositDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量新增保证金消费明细", "操作人ID为：" + getLoginName(request) + "批量新增保证金消费明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (details == null || details.isEmpty()) {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "需要保存的保证金消费明细实体为空");
			}
			List<String> msgs = new ArrayList<>();
			for (int i = 0; i < details.size(); i++) {
				msgs.add(this.checkDepositDetail(details.get(i), true));
			}
			if (msgs != null && !msgs.isEmpty()) {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
			} else {
				return AjaxResult.createSuccessResult(financeService.addDepositDetailBatch(details));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "批量新增保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@RequestMapping("/updateDepositDetail")
	@ResponseBody
	public AjaxResult updateDepositDetail(HttpServletRequest request, @RequestBody FeeDepositDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新保证金消费明细", "操作人ID为：" + getLoginName(request) + "更新保证金消费明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkDepositDetail(detail, true);
			if (StringUtils.isEmpty(detail.getDepositDetailId())) {
				return AjaxResult.createSuccessResult(financeService.updateDepositDetail(detail));
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	@RequestMapping("/updateDepositDetails")
	@ResponseBody
	public AjaxResult updateDepositDetails(HttpServletRequest request, @RequestBody List<FeeDepositDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量更新保证金消费明细", "操作人ID为：" + getLoginName(request) + "批量更新保证金消费明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (details == null || details.isEmpty()) {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "需要更新的保证金消费明细实体为空");
			}
			List<String> msgs = new ArrayList<>();
			for (int i = 0; i < details.size(); i++) {
				msgs.add(this.checkDepositDetail(details.get(i), true));
			}
			if (msgs != null && !msgs.isEmpty()) {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
			} else {
				return AjaxResult.createSuccessResult(financeService.updateDepositDetailBatch(details));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "批量更新保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	@RequestMapping("/deleteDepositDetail")
	@ResponseBody
	public AjaxResult deleteDepositDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除保证金消费明细", "操作人ID为：" + getLoginName(request) + "删除保证金消费明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(detailId)) {
				return AjaxResult.createSuccessResult(financeService.deleteDepositDetail(detailId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "追加保证金明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/deleteDepositDetails")
	@ResponseBody
	public AjaxResult deleteDepositDetails(HttpServletRequest request, @RequestBody List<String> detailIds) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量删除保证金消费明细", "操作人ID为：" + getLoginName(request) + "批量删除保证金消费明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String ids = "";
			if (detailIds != null && !detailIds.isEmpty()) {
				for (int i = 0; i < detailIds.size(); i++) {
					if (StringUtils.isEmpty(detailIds)) {
						ids += i + ",";
					}
				}
				if (StringUtils.isEmpty(ids)) {
					return AjaxResult.createSuccessResult(financeService.deleteDepositDetailBatch(detailIds));
				} else {
					ids = ids.substring(0, ids.length() - 1);
					return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "保证金消费明细细第"+ ids +"条id不能为空");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "保证金消费明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "批量删除保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPageDepositDetails")
	@ResponseBody
	public AjaxResult findPageDepositDetails(HttpServletRequest request, @RequestBody PageUtils<FeeDepositDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询保证金消费明细并分页", "操作人ID为：" + getLoginName(request) + "查询保证金消费明细并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<FeeDepositDetailVo> pageInfo = financeService.getDepositDetails(page, false);
			if (pageInfo != null && pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
				for (FeeDepositDetailVo vo : pageInfo.getList()) {
					if (!StringUtils.isEmpty(vo.getContractId())) {
						vo.setContract(contractService.getConContractById(vo.getContractId()));
					}
					if (!StringUtils.isEmpty(vo.getDepositAccountId())) {
						FeeDepositAccount account = financeService.getDepositAccount(vo.getDepositAccountId());
						if (!StringUtils.isEmpty(account.getFinanceId())) {
							FeeFinanceBill bill = financeService.getFinaceBill(account.getFinanceId());
							bill.setBusinessType(FinanceTypeEnum.getValueByKey(bill.getBusinessType()));
							vo.setFinance(bill);
						}
					}
				}
			}
			return AjaxResult.createSuccessResult(pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询保证金消费明细并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findAllDepositDetails")
	@ResponseBody
	public AjaxResult findAllDepositDetails(HttpServletRequest request, @RequestBody PageUtils<FeeDepositDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询保证金消费明细", "操作人ID为：" + getLoginName(request) + "查询保证金消费明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<FeeDepositDetailVo> list = financeService.getDepositDetails(page.getDto(), page.getOrderByClause(), false);
			if (list != null && !list.isEmpty()) {
				for (FeeDepositDetailVo vo : list) {
					if (!StringUtils.isEmpty(vo.getContractId())) {
						vo.setContract(contractService.getConContractById(vo.getContractId()));
					}
					if (!StringUtils.isEmpty(vo.getDepositAccountId())) {
						FeeDepositAccount account = financeService.getDepositAccount(vo.getDepositAccountId());
						if (!StringUtils.isEmpty(account.getFinanceId())) {
							FeeFinanceBill bill = financeService.getFinaceBill(account.getFinanceId());
							bill.setBusinessType(FinanceTypeEnum.getValueByKey(bill.getBusinessType()));
							vo.setFinance(bill);
						}
					}
				}
			}
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询批量保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findOneDepositDetail")
	@ResponseBody
	public AjaxResult findOneDepositDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据id获取保证金消费明细", "操作人ID为：" + getLoginName(request) + "根据id获保证金消费明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(detailId)) {
				FeeDepositDetailVo vo = financeService.getDepositDetail(detailId);
				if (!StringUtils.isEmpty(vo.getContractId())) {
					vo.setContract(contractService.getConContractById(vo.getContractId()));
				}
				if (!StringUtils.isEmpty(vo.getDepositAccountId())) {
					FeeDepositAccount account = financeService.getDepositAccount(vo.getDepositAccountId());
					if (!StringUtils.isEmpty(account.getFinanceId())) {
						FeeFinanceBill bill = financeService.getFinaceBill(account.getFinanceId());
						bill.setBusinessType(FinanceTypeEnum.getValueByKey(bill.getBusinessType()));
						vo.setFinance(bill);
					}
				}
				return AjaxResult.createSuccessResult(vo);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "保证金消费明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据id获取保证金消费明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 判断非空
	 * @param dto
	 * @param isIgnoreId
	 * @return
	 */
	private String checkDepositDetail(FeeDepositDetail detail, boolean isIgnoreId) {
		if (detail == null) {
			return "保证金消费明细实体不能为空";
		}
		String baseStr = "不能为空";
		if (detail.getUsedFee() == null) {
			return "消费金额" + baseStr;
		}
		if (detail.getBalance() == null) {
			return "剩余保证金" + baseStr;
		}
		if (StringUtils.isEmpty(detail.getContractId())) {
			return "合同" + baseStr;
		}
		if (StringUtils.isEmpty(detail.getDepositAccountId())) {
			return "保证金账户" + baseStr;
		}
		return "";
	}

}
