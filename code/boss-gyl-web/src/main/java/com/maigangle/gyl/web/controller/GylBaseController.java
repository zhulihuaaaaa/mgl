package com.maigangle.gyl.web.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.constant.GylGlobalConstant;
import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.BaseCost;
import com.maigangle.gyl.facade.entity.BaseInfo;
import com.maigangle.gyl.facade.entity.BaseMargin;
import com.maigangle.gyl.facade.entity.GridConfig;
import com.maigangle.gyl.facade.entity.SysApprovalModule;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictGrade;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.api.DictMallSpec;
import com.maigangle.gyl.facade.entity.api.DictSeries;
import com.maigangle.gyl.facade.entity.api.DictStd;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.enums.ApprovalSpeciesEnum;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.BusinessTypeEnum;
import com.maigangle.gyl.facade.enums.ContractBillStateEnum;
import com.maigangle.gyl.facade.enums.ContractBillTypeEnum;
import com.maigangle.gyl.facade.enums.DepositStateEnum;
import com.maigangle.gyl.facade.enums.EdgeTypeEnum;
import com.maigangle.gyl.facade.enums.FeeTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceFlwoTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceStateEnum;
import com.maigangle.gyl.facade.enums.FinanceTypeEnum;
import com.maigangle.gyl.facade.enums.GoodsPaymentStatusEnum;
import com.maigangle.gyl.facade.enums.GoodsSourceEnum;
import com.maigangle.gyl.facade.enums.InOrNotStockEnum;
import com.maigangle.gyl.facade.enums.InStockBillStateEnum;
import com.maigangle.gyl.facade.enums.InspectionTypeEnum;
import com.maigangle.gyl.facade.enums.InvoiceTypeEnum;
import com.maigangle.gyl.facade.enums.OutstockStateEnum;
import com.maigangle.gyl.facade.enums.RedeemBillStateEnum;
import com.maigangle.gyl.facade.service.ApproveService;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.GylBaseService;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

/**
 * 一些功能公共Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/base")
public class GylBaseController extends GylBaseWeb {
	//@Value("${gyl_upload_url}")
	public String gylUploadUrl = "地址";
	@Autowired
	GylBaseService gylBaseService;
	@Autowired
	BaseService baseService;
	@Autowired
	ApproveService approveService;
	/**
	 * 根据表格名称获取表格配置
	 * @param code
	 * @return
	 */
	@RequestMapping("/findGridConfig")
	@ResponseBody
	public AjaxResult findGridConfig(HttpServletRequest request, String code) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询表格配置", "操作人ID为：" + getLoginName(request) + "查询表格配置",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(code)) {
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean) result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户信息异常，" + result.get("msg"));
				}
				PrivUser user = (PrivUser)result.get("data");
				GridConfig gridConfig = gylBaseService.getGridConfigByCode(code, user);
				return AjaxResult.createSuccessResult(gridConfig);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "表格名称不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询表格配置",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 保存表格配置,如果已存在，则更新配置
	 * @param request
	 * @param gridConfig
	 * @return
	 */
	@PostMapping("/saveGridConfig")
	@ResponseBody
	public AjaxResult saveGridConfig(HttpServletRequest request, @RequestBody GridConfig gridConfig) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "保存表格配置", "操作人ID为：" + getLoginName(request) + "保存表格配置",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (gridConfig != null) {
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean) result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户信息异常，" + result.get("msg"));
				}
				PrivUser user = (PrivUser)result.get("data");
				int i = gylBaseService.addGridConfig(gridConfig, user);
				if (i > 0) {
					return AjaxResult.createSuccessResult(gylBaseService.getGridConfigByCode(gridConfig.getGridCode(), user));
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "表格名称不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "保存表格配置",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	/**
	 * 更新表格配置
	 * @param request
	 * @param gridConfig
	 * @return
	 */
	@PostMapping("/updateGridConfig")
	@ResponseBody
	public AjaxResult updateGridConfig(HttpServletRequest request, @RequestBody GridConfig gridConfig) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新表格配置", "操作人ID为：" + getLoginName(request) + "更新表格配置",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (gridConfig != null && !StringUtils.isEmpty(gridConfig.getGridId())) {
				int i = gylBaseService.updateGridConfig(gridConfig);
				if (i > 0) {
					return AjaxResult.createSuccessResult(MessageCode.UPDATE_SUCCESS);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "表格ID不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新表格配置",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/getOptions")
	@ResponseBody
	public AjaxResult getOptions(HttpServletRequest request, @RequestParam("params") List<String> params) {
		Map<String, List<String[]>> options = new HashMap<>();
		for (String param: params) {
			// 业务类型
			if ("BusinessType".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (BusinessTypeEnum enum1: BusinessTypeEnum.values()) {
					list.add(new String[] {enum1.getType(), enum1.getName()});
				}
				options.put(param, list);
			}
			// 审批状态
			if ("ApprovalState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (ApprovalStateEnum enum1: ApprovalStateEnum.values()) {
					if (enum1.getName().indexOf("撤销") == -1) {
						list.add(new String[] {enum1.getState(), enum1.getName()});
					}
				}
				options.put(param, list);
			}
			// 费用类型
			if ("FeeType".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (FeeTypeEnum enum1: FeeTypeEnum.values()) {
					list.add(new String[] {enum1.getType(), enum1.getName()});
				}
				options.put(param, list);
			}
			// 货物来源
			if ("GoodsSource".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (GoodsSourceEnum enum1: GoodsSourceEnum.values()) {
					list.add(new String[] {enum1.getType(), enum1.getName()});
				}
				options.put(param, list);
			}
			// 是否在库状态
			if ("InOrNotStock".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (InOrNotStockEnum enum1: InOrNotStockEnum.values()) {
					list.add(new String[] {enum1.getType(), enum1.getName()});
				}
				options.put(param, list);
			}
			// 验货状态
			if ("InspectionType".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (InspectionTypeEnum enum1: InspectionTypeEnum.values()) {
					list.add(new String[] {enum1.getType(), enum1.getName()});
				}
				options.put(param, list);
			}
			// 入库单状态
			if ("InstockState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (InStockBillStateEnum enum1: InStockBillStateEnum.values()) {
					list.add(new String[] {enum1.getState(),enum1.getName()});
				}
				options.put(param, list);
			}
			// 货款状态
			if ("GoodsPaymentState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (GoodsPaymentStatusEnum enum1 : GoodsPaymentStatusEnum.values()) {
					list.add(new String[] { enum1.getState(), enum1.getName() });
				}
				options.put(param, list);
			}
			// 保证金状态
			if ("DepositState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (DepositStateEnum enum1 : DepositStateEnum.values()) {
					list.add(new String[] { enum1.getState(), enum1.getName() });
				}
				options.put(param, list);
			}
			// 合同类型
			if ("ContractBillType".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (ContractBillTypeEnum enum1 : ContractBillTypeEnum.values()) {
					list.add(new String[] { enum1.getType(), enum1.getName() });
				}
				options.put(param, list);
			}
			// 合同状态
			if ("ContractBillState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (ContractBillStateEnum enum1 : ContractBillStateEnum.values()) {
					list.add(new String[] { enum1.getState(), enum1.getName() });
				}
				options.put(param, list);
			}
			
			//发票类型
			if ("InvoiceType".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (InvoiceTypeEnum enum1: InvoiceTypeEnum.values()) {
					list.add(new String[] {enum1.getState(), enum1.getName()});
				}
				options.put(param, list);
			}
			
			//提货单状态
			if ("OutstockState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (OutstockStateEnum enum1: OutstockStateEnum.values()) {
					list.add(new String[] {enum1.getState(), enum1.getName()});
				}
				options.put(param, list);
			}
			
			// 保证金
			if ("DepositRate".equals(param)) {
				String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
				try {
					super.logInfo(request, logBatch, "查询保证金", "操作人ID为：" + getLoginName(request) + "查询保证金",
							EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
					List<String[]> list = new ArrayList<>();
					List<BaseMargin> marginList = baseService.getBaseMargins();
					if (marginList != null && !marginList.isEmpty()) {
						for (BaseMargin margin : marginList) {
							list.add(new String[] { String.valueOf(margin.getProportion()), String.valueOf(margin.getProportion().multiply(new BigDecimal(100)).setScale(0)) + "%" });
						}
					}
					options.put(param, list);
				} catch (Exception e) {
					e.printStackTrace();
					super.logError(request, logBatch, "查询保证金",
							"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
							EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				}
			}
//			// 钢种
//			if ("DictMallSpec".equals(param)) {
//				String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
//				try {
//					super.logInfo(request, logBatch, "查询钢种", "操作人ID为：" + getLoginName(request) + "查询钢种",
//							EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
//					List<String[]> list = new ArrayList<>();
//					List<DictMallSpec> specList = null;
//					Map<String, Object> result = getAllDictMallSpec(request);
//					if (!(boolean) result.get("isSuccess")) {
//						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取生产厂家信息异常，" + result.get("msg"));
//					}
//					specList = (List<DictMallSpec>)result.get("data");
//					if (specList != null && !specList.isEmpty()) {
//						for (DictMallSpec spec : specList) {
//							list.add(new String[] { spec.getQuality(), spec.getQuality() });
//						}
//					}
//					options.put(param, list);
//				} catch (Exception e) {
//					e.printStackTrace();
//					super.logError(request, logBatch, "查询钢种",
//							"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
//							EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
//				}
//			}
			// 仓库
//			if ("DictMallDepot".equals(param)) {
//				String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
//				try {
//					super.logInfo(request, logBatch, "查询仓库", "操作人ID为：" + getLoginName(request) + "查询仓库",
//							EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
//					List<String[]> list = new ArrayList<>();
//					List<DictMallDepot> dictList = gylApiService.getAllDictMallDepot("real");
//					if (dictList != null && !dictList.isEmpty()) {
//						for (DictMallDepot dict : dictList) {
//							list.add(new String[] { dict.getDptId(), dict.getDptName() });
//						}
//					}
//					options.put(param, list);
//				} catch (Exception e) {
//					e.printStackTrace();
//					super.logError(request, logBatch, "查询仓库",
//							"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
//							EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
//				}
//			}
			// 验货入库状态
			if ("inspectionState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (InspectionTypeEnum enum1 : InspectionTypeEnum.values()) {
					list.add(new String[] { enum1.getType(), enum1.getName() });
				}
				options.put(param, list);
			}		
			// 边部
			if ("EdgeType".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (EdgeTypeEnum enum1 : EdgeTypeEnum.values()) {
//					list.add(new String[] { enum1.getType(), enum1.getName() });
					// 数据库存名字
					list.add(new String[] { enum1.getName(), enum1.getName() });
				}
				options.put(param, list);
			}
			// 财务单类型
			if ("FinanceType".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (FinanceTypeEnum enum1 : FinanceTypeEnum.values()) {
					list.add(new String[] { enum1.getType(), enum1.getName() });
				}
				options.put(param, list);
			}
			// 财务单资金流向
			if ("FinanceFlwoType".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (FinanceFlwoTypeEnum enum1 : FinanceFlwoTypeEnum.values()) {
					list.add(new String[] { enum1.getType(), enum1.getName() });
				}
				options.put(param, list);
			}
			// 财务单状态
			if ("FinanceState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (FinanceStateEnum enum1 : FinanceStateEnum.values()) {
					list.add(new String[] { enum1.getState(), enum1.getName() });
				}
				options.put(param, list);
			}
			// 获取甲方客户
			if ("PartyA".equals(param)) {
				List<BaseCompany> baseCompanies = baseService.getBaseCompany();
				List<String[]> list = new ArrayList<>();
				for (BaseCompany item : baseCompanies) {
					list.add(new String[] { item.getCompanyId(), item.getCompanyName()});
				}
				options.put(param, list);
			}
			// 赎货状态
			if ("RedeemBillState".equals(param)) {
				List<String[]> list = new ArrayList<>();
				for (RedeemBillStateEnum enum1 : RedeemBillStateEnum.values()) {
					list.add(new String[] { enum1.getType(), enum1.getName() });
				}
				options.put(param, list);
			}
		}
		return AjaxResult.createSuccessResult(options);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getDictMallMnfcts")
	@ResponseBody
	public AjaxResult getDictMallMnfcts(HttpServletRequest request, String mnfctName) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询厂商", "操作人ID为：" + getLoginName(request) + "查询厂商",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getAllDictMallMnfct(request, mnfctName);
			if (!(boolean) result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取生产厂家信息异常，" + result.get("msg"));
			}
			List<DictMallMnfct> list = (List<DictMallMnfct>) result.get("data");
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询厂商",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getCrmClients")
	@ResponseBody
	public AjaxResult getCrmClients(HttpServletRequest request,String clientName) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询客户", "操作人ID为：" + getLoginName(request) + "查询客户",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getALLCrmClient(request, clientName);
			if (!(boolean) result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取客户信息异常，" + result.get("msg"));
			}
			List<CrmClient> list = (List<CrmClient>)result.get("data");
			List<CrmClient> resultlist = new ArrayList<>();
			if (!StringUtils.isEmpty(clientName) && list != null && !list.isEmpty()) {
				for (CrmClient crm : list) {
					if (crm.getClientName().indexOf(clientName) > -1) {
						resultlist.add(crm);
					}
				}
				return AjaxResult.createSuccessResult(resultlist);
			} else {
				return AjaxResult.createSuccessResult(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询客户",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/getCrmClientById")
	@ResponseBody
	public AjaxResult getCrmClientsById(HttpServletRequest request,String clientId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询客户", "操作人ID为：" + getLoginName(request) + "查询客户",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getCrmClient(request, clientId);
			if (!(boolean) result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取客户信息异常，" + result.get("msg"));
			}
			CrmClient crm = (CrmClient)result.get("data");
			List<CrmClient> resultlist = new ArrayList<>();
			if(crm!=null) {
				return AjaxResult.createSuccessResult(crm);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询客户",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 根据仓库id查询仓库
	 * @param 
	 * @param 
	 * @return
	 */
	@GetMapping("/getDictMallDepot")
	@ResponseBody
	public AjaxResult getDictMallDepotbyId(HttpServletRequest request,String storageId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询仓库", "操作人ID为：" + getLoginName(request) + "查询仓库",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			
			Map<String, Object> result = getDictMallDepot(request, storageId);
			if (!(boolean) result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取仓库信息异常，" + result.get("msg"));
			}
			
			DictMallDepot dictMallDepot = (DictMallDepot) result.get("data");
			return AjaxResult.createSuccessResult(dictMallDepot);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询仓库",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 根据客户Id查询手续费
	 * @param request
	 * @param customerId
	 * @return
	 */
	@GetMapping("/getCommission60")
	@ResponseBody
	public AjaxResult getCommission60(HttpServletRequest request, String customerId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询手续费", "操作人ID为：" + getLoginName(request) + "查询手续费",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(getCommission(customerId, "60"));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询手续费",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 根据客户Id查询手续费
	 * @param request
	 * @param customerId
	 * @return
	 */
	@GetMapping("/getCommission90")
	@ResponseBody
	public AjaxResult getCommission90(HttpServletRequest request, String customerId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询手续费", "操作人ID为：" + getLoginName(request) + "查询手续费",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(getCommission(customerId, "90"));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询手续费",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 根据客户Id查询开票费
	 * @param request
	 * @param customerId
	 * @return
	 */
	@GetMapping("/getInvoice")
	@ResponseBody
	public AjaxResult getInvoice(HttpServletRequest request, String customerId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询开票费", "操作人ID为：" + getLoginName(request) + "查询开票费",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(getInvoice(customerId));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询开票费",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 按条件查询开票费用
	 * @param customerId
	 * @param type
	 * @return
	 */
	private List<Map<String, Object>> getInvoice(String customerId) {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		if (!StringUtils.isEmpty(customerId)) {
			BaseCost cost = new BaseCost();
			cost.setCustomerId(customerId);
			cost.setCostType(FeeTypeEnum.KAI_PIAO_FEI.toString());
			List<BaseCost> costs = baseService.getBaseCosts(cost, null, true);
			if (costs != null && !costs.isEmpty()) {
				for (BaseCost baseCost : costs) {
					map.put("value", baseCost.getAmount());
					map.put("label", baseCost.getAmount());
					list.add(map);
				}
			}
		}
		
		BaseInfo info = baseService.getGlobalBaseInfo();
		if (info != null) {
			map = new HashMap<>();
			map.put("label", info.getInvoiceFee());
			map.put("value", info.getInvoiceFee());
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 获取手续费
	 * @param customerId
	 * @param dates
	 * @return
	 */
	private List<Map<String, Object>> getCommission(String customerId, String dates) {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		if (!StringUtils.isEmpty(customerId)) {
			BaseCost cost = new BaseCost();
			cost.setCustomerId(customerId);
			cost.setCostType(FeeTypeEnum.SHOU_XU_FEI.toString());
			List<BaseCost> costs = baseService.getBaseCosts(cost, null, true);
			if (costs != null && !costs.isEmpty()) {
				for (BaseCost baseCost : costs) {
					if (dates.equals("60")) {
						map.put("value", baseCost.getFeeRate1());
						map.put("label", baseCost.getFeeRate1().multiply(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP) + "‱");
					}
					if (dates.equals("90")) {
						map.put("value", baseCost.getFeeRate2());
						map.put("label", baseCost.getFeeRate2().multiply(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP) + "‱");
					}
					list.add(map);
				}
			}
		}
		
		BaseInfo info = baseService.getGlobalBaseInfo();
		if (info != null) {
			map = new HashMap<>();
			if (dates.equals("60")) {
				map.put("value", info.getFeeRate1());
				map.put("label", info.getFeeRate1().multiply(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP) + "‱");
			}
			if (dates.equals("90")) {
				map.put("value", info.getFeeRate2());
				map.put("label", info.getFeeRate2().multiply(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP) + "‱");
			}
			list.add(map);
		}
		return list;
	}
	
	@RequestMapping("/findAllAttachs")
	@ResponseBody
	public AjaxResult findAllAttachs(HttpServletRequest request, @RequestBody Attach attach) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询附件", "操作人ID为：" + getLoginName(request) + "查询附件",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(attach.getRelationId()) && !StringUtils.isEmpty(attach.getFileCategory())) {
				return AjaxResult.createSuccessResult(gylBaseService.getAttachByIdAndType(attach.getRelationId(), attach.getFileCategory()));
			} else if (!StringUtils.isEmpty(attach.getRelationId())) {
				return AjaxResult.createSuccessResult(gylBaseService.getAttach(attach.getRelationId()));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询附件",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/findAllDictMallDepot")
	@ResponseBody
	public AjaxResult findAllDictMallDepot(HttpServletRequest request, String depot) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询仓库", "操作人ID为：" + getLoginName(request) + "查询仓库",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<String[]> list = new ArrayList<>();
			List<DictMallDepot> dictList = new ArrayList<>();
			// 获取真实仓库数据列表
			if("real".equals(depot)||"all".equals(depot)) {
				Map<String, Object> result = getAllDictMallDepot(request);
				if (!(boolean) result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取客户信息异常，" + result.get("msg"));
				}
				dictList = (List<DictMallDepot>) result.get("data");
			}
			// 拼接虚拟仓库数据
			if ("virtual".equals(depot)||"all".equals(depot)) {
				DictMallDepot dictMallDepot = new DictMallDepot();
				dictMallDepot = new DictMallDepot();
				BaseInfo info = baseService.getGlobalBaseInfo();
				dictMallDepot.setDptId(GylGlobalConstant.VIRTUAL_MALL_DEPOT);
				dictMallDepot.setDptName(info.getVirtualMallDepot());
				dictMallDepot.setDptShortName(info.getVirtualMallDepot());
				dictList.add(dictMallDepot);
			}
			if (dictList != null && !dictList.isEmpty()) {
				for (DictMallDepot dict : dictList) {
					list.add(new String[] { dict.getDptId(), dict.getDptName() });
				}
			}
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询仓库",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/*************************************************************************************/
	
	/**
	 * 
	 * @author shmily
	 * @Title: findAllDictMallDepot 
	 * @Description: ( 根据品种(系列)来查询出材质) 
	 * @param request
	 * @param orderCode
	 * @return AjaxResult
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findAllDictMallSpec")
	@ResponseBody
	public AjaxResult findAllDictMallSpec(HttpServletRequest request, String orderCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 根据品种(系列)来查询出材质", "操作人ID为：" + getLoginName(request) + " 根据品种(系列)来查询出材质",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				super.logInfo(request, logBatch, " 根据品种(系列)来查询出材质 ", "操作人ID为：" + getLoginName(request) + " 根据品种(系列)来查询出材质",
						EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				List<DictMallSpec> specList = null;
				Map<String, Object> result = getAllDictMallSpec(request,orderCode);
				if (!(boolean) result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取材质信息异常，" + result.get("msg"));
				}
				specList = (List<DictMallSpec>)result.get("data");
			return AjaxResult.createSuccessResult(specList);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询仓库",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: findAllOrderCode 
	 * @Description: (查询出所有品种系列  ) 
	 * @param request
	 * @return AjaxResult
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findAllOrderCode")
	@ResponseBody
	public AjaxResult findAllOrderCode(HttpServletRequest request) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 查询出所有系列", "操作人ID为：" + getLoginName(request) + " 查询出所有系列",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				super.logInfo(request, logBatch, " 查询出所有系列 ", "操作人ID为：" + getLoginName(request) + " 查询出所有系列",
						EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				List<DictSeries> dictSeries = null;
				Map<String, Object> result = getOrderCode(request);
				if (!(boolean) result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "查询出所有系列信息异常，" + result.get("msg"));
				}
				dictSeries = (List<DictSeries>)result.get("data");
			return AjaxResult.createSuccessResult(dictSeries);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询出所有系列",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}

	/**
	 * 
	 * @author shmily
	 * @Title: findAllDictMallDepot 
	 * @Description: ( 根据品种(系列)来查询出执行执行标准) 
	 * @param request
	 * @param orderCode
	 * @return AjaxResult
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findAllDictStd")
	@ResponseBody
	public AjaxResult findAllDictStd(HttpServletRequest request, String orderCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 根据品种(系列)来查询出执行标准", "操作人ID为：" + getLoginName(request) + " 根据品种(系列)来查询出执行标准",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				super.logInfo(request, logBatch, " 根据品种(系列)来查询出执行标准 ", "操作人ID为：" + getLoginName(request) + " 根据品种(系列)来查询出执行标准",
						EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				List<DictStd> dictStd = null;
				Map<String, Object> result = getDictStd(request,orderCode);
				if (!(boolean) result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取执行标准信息异常，" + result.get("msg"));
				}
				dictStd = (List<DictStd>)result.get("data");
			return AjaxResult.createSuccessResult(dictStd);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询执行标准",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	/**
	 * 
	 * @author shmily
	 * @Title: findAllDictGrade 
	 * @Description: (( 根据品种(系列)来查询出等级)) 
	 * @param request
	 * @param orderCode
	 * @return AjaxResult
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findAllDictGrade")
	@ResponseBody
	public AjaxResult findAllDictGrade(HttpServletRequest request,String orderCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 根据品种(系列)来查询出等级", "操作人ID为：" + getLoginName(request) + " 根据品种(系列)和材质来查询出等级",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				super.logInfo(request, logBatch, "  根据品种(系列)来查询出等级 ", "操作人ID为：" + getLoginName(request) + " 根据品种(系列)和材质来查询出等级",
						EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				List<DictGrade> dictGrade = null;
				Map<String, Object> result = getDictGrade(request,orderCode);
				if (!(boolean) result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取等级异常，" + result.get("msg"));
				}
				dictGrade = (List<DictGrade>)result.get("data");
			return AjaxResult.createSuccessResult(dictGrade);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询等级",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: findAllSurface 
	 * @Description: ( 根据品种和材质查询出表面)
	 * @param request
	 * @param materialName
	 * @param orderCode
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/findAllSurface")
	@ResponseBody
	public AjaxResult findAllSurface(HttpServletRequest request,String materialName,String orderCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据品种和材质查询出表面信息", "操作人ID为：" + getLoginName(request) + "根据品种和材质查询出表面信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getBaseProcess(request, materialName,orderCode);
			if (!(boolean)result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据品种和材质查询出表面信息异常," + result.get("msg"));
			}
			return AjaxResult.createSuccessResult(result.get("data"));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据品种和材质查询出表面信息信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: findAllTrademark 
	 * @Description: ( 根据品种和材质查询出牌号信息  ) 
	 * @param request
	 * @param materialName
	 * @param orderCode
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/findAllTrademark")
	@ResponseBody
	public AjaxResult findAllTrademark(HttpServletRequest request,String materialName,String orderCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据品种和材质查询出牌号信息 ", "操作人ID为：" + getLoginName(request) + "根据品种和材质查询出牌号信息 ",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getTrademark(request, materialName,orderCode);
			if (!(boolean)result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据品种和材质查询出牌号信息 异常," + result.get("msg"));
			}
			return AjaxResult.createSuccessResult(result.get("data"));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据品种和材质查询出牌号信息 ",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: findAllManufacturer 
	 * @Description: ( 根据品种来查询货物的生产厂家  而不是合同的供应方 ) 
	 * @param request
	 * @param materialName
	 * @param orderCode
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/findAllManufacturer")
	@ResponseBody
	public AjaxResult findAllManufacturer(HttpServletRequest request,String orderCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据品种来查询货物的生产厂家信息 ", "操作人ID为：" + getLoginName(request) + "根据品种来查询货物的生产厂家信息 ",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getAllDictMallMnfctByOrderCode(request,orderCode);
			if (!(boolean)result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据品种来查询货物的生产厂家信息 异常," + result.get("msg"));
			}
			return AjaxResult.createSuccessResult(result.get("data"));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据品种来查询货物的生产厂家信息 ",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getAllmodel 
	 * @Description: (  查询所有的模块名) 
	 * @param request
	 * @return 
	 * @throws
	 */
	@RequestMapping("/getAllmodel")
	@ResponseBody
	public AjaxResult getAllmodelList(HttpServletRequest request) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有的角色列表", "操作人ID为：" + getLoginName(request) + "查询所有的角色列表 ",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// 已存在的模块名
			List<String> modelList = approveService.selectModelName();
			// 需要的审批的流程
			List<SysApprovalModule> sysModelList = approveService.selectAllModelName();
			if(modelList==null) {
				modelList=new ArrayList<>();
			}
			List<String[]> list = new ArrayList<>();
			for (SysApprovalModule model : sysModelList) {
				if(!modelList.contains(model.getModuleAlias())) {
					list.add(new String[] {model.getModuleAlias(),model.getModuleName() });
				}
			}
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有的角色列表信息 ",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: getAllrole 
	 * @Description: (查询所有的角色列表 )
	 * @param request
	 * @return 
	 * @throws
	 */
	@RequestMapping("/getAllrole")
	@ResponseBody
	public AjaxResult getAllroleList(HttpServletRequest request) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有的角色列表", "操作人ID为：" + getLoginName(request) + "查询所有的角色列表 ",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getAllPrivRole(request);
			if (!(boolean)result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "查询所有的角色列表异常," + result.get("msg"));
			}
			return AjaxResult.createSuccessResult(result.get("data"));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有的角色列表信息 ",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
}