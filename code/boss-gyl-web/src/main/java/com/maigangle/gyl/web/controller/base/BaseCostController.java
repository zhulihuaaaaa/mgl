package com.maigangle.gyl.web.controller.base;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
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
import com.maigangle.gyl.facade.entity.BaseCost;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.dto.BaseCostDto;
import com.maigangle.gyl.facade.entity.vo.BaseCostVo;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

/**
 * 费用信息
 * @author 汪玮琦
 * @since 2017年12月11日 下午2:28:21
 * @varsion 1.0
 */
@Controller
@RequestMapping("/baseCost")
public class BaseCostController extends GylBaseWeb{
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/baseCost/baseCostIndex");
		return modelAndView;
	}

	@Privilege(key = "GYL_BASECOST_ADD")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request, @RequestBody BaseCost baseCost) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			baseCost.setCostType("A");
			super.logInfo(request, logBatch, "添加费用信息", "操作人ID为：" + getLoginName(request) + "添加费用信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseCost);
			if (StringUtils.isEmpty(checkMsg)) {
				baseCost = baseService.addBaseCost(baseCost);
				if (!StringUtils.isEmpty(baseCost.getCostId())) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, baseCost);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "添加费用信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}

	@Privilege(key = "GYL_BASECOST_EDIT")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request, @RequestBody BaseCost baseCost) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新费用信息", "操作人ID为：" + getLoginName(request) + "更新费用信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseCost);
			if (StringUtils.isEmpty(checkMsg)) {
				baseCost = baseService.updateBaseCost(baseCost);
				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新费用信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}

	@Privilege(key = "GYL_BASECOST_DELETE")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除费用信息", "操作人ID为：" + getLoginName(request) + "删除费用信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "费用信息id不能为空");
			} else {
				return AjaxResult.createSuccessResult(baseService.deleteBaseCost(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除费用信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
	}
	
	/**
	 * 查询费用带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request, @RequestBody PageUtils<BaseCostDto> dto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询费用信息并分页", "操作人ID为：" + getLoginName(request) + "查询费用信息并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<BaseCostVo> voPageInfo = baseService.getBaseCostVos(dto, false);
			if (voPageInfo != null && voPageInfo.getList() != null && !voPageInfo.getList().isEmpty()) {
				for (BaseCostVo vo : voPageInfo.getList()) {
					//vo.setCrmClient(gylApiService.getCrmClient(vo.getCustomerId()));
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getCustomerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setCrmClient(crmClientBuyer);
				}
			}
			return AjaxResult.createSuccessResult(voPageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询费用信息并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
		
	}
	
	@PostMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request, @RequestBody PageUtils<BaseCostDto> baseCost) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询费用信息", "操作人ID为：" + getLoginName(request) + "查询费用信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(baseService.getBaseCostVos(baseCost.getDto(), baseCost.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询费用信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
		
	}
	
	@PostMapping("/findServiceCharge")
	@ResponseBody
	public AjaxResult findServiceCharge(HttpServletRequest request, @RequestBody BaseCost baseCost) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取手续费", "操作人ID为：" + getLoginName(request) + "获取手续费",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (baseCost == null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "手续费查询条件为空");
			} else {
				return AjaxResult.createSuccessResult(baseService.getServiceChatge(baseCost));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取手续费",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findBillingCharge")
	@ResponseBody
	public AjaxResult findBillingCharge(HttpServletRequest request, @RequestBody BaseCost baseCost) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取开票费", "操作人ID为：" + getLoginName(request) + "获取开票费",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (baseCost == null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "开票费查询条件为空");
			} else {
				return AjaxResult.createSuccessResult(baseService.getBillingChatge(baseCost));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取开票费",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 必填项检查
	 * @param baseCost
	 * @return
	 */
	private String checkObject(BaseCost baseCost) {
		if (baseCost != null) {
			String baseStr = "不能为空";
			if (StringUtils.isEmpty(baseCost.getCustomerId())) {
				return "客户信息" + baseStr;
			} else if (costNameIsExist(baseCost)) {
				return "该客户手续费已存在";
			}
			if (baseCost.getFeeRate1() == null) {
				return "0-60天手续费率" + baseStr;
			}
			if (baseCost.getFeeRate2() == null) {
				return "61-90天手续费率" + baseStr;
			}
			return "";
		}
		return "手续费信息对象不能为空";
	}

	/**
	 * 检测客户是否已存在
	 * @param productName
	 * @return
	 */
	private boolean costNameIsExist(BaseCost cost) {
		BaseCostDto old = new BaseCostDto();
		old.setCustomerId(cost.getCustomerId());
		old.setCostType(cost.getCostType());
		List<BaseCostVo> list = baseService.getBaseCostVos(old, null, true);
		if (list != null && list.size() > 0) {
			if (StringUtils.isEmpty(cost.getCostId())) {
				return true;
			} else if (!StringUtils.pathEquals(cost.getCostId(), list.get(0).getCostId())) {
				return true;
			}
		}
		return false;
	}

}
