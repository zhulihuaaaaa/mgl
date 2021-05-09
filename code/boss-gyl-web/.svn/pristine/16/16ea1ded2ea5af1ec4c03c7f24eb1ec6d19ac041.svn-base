package com.maigangle.gyl.web.controller.outstock;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.InApplyRemitDetail;
import com.maigangle.gyl.facade.entity.InContractRemitDetail;
import com.maigangle.gyl.facade.entity.OutOutstockBill;
import com.maigangle.gyl.facade.entity.dto.OutStockBillDto;
import com.maigangle.gyl.facade.entity.dto.OutStockBillDto;
import com.maigangle.gyl.facade.service.OutstockBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;



/**  
 * 出库委托单controller
 * @author zlh
 * @since 2017年12月4日 上午9:09:13 
 * @version 1.0 
 */
@Controller
@RequestMapping("/outstockCommissionBill")
public class OutstockCommissionBillController extends GylBaseWeb {
	@Autowired
	OutstockBillService outstockBillService;
	/**
	 * 新增出库委托单
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request,OutOutstockBill outOutstockBill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增出库委托单", "操作人ID为：" + getLoginName(request) + "新增出库委托单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			String checkMsg = this.checkObject(outOutstockBill);
			if (StringUtils.isEmpty(checkMsg)) {
				return AjaxResult.createSuccessResult(outstockBillService.addOutstockBill(outOutstockBill));
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED,checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增出库委托单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	/**
	 * 更新出库委托单
	 * @param request
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult updateOutstockBill(HttpServletRequest request,OutOutstockBill outOutstockBill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新出库委托单", "操作人ID为：" + getLoginName(request) + "更新出库委托单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			String checkMsg = this.checkObject(outOutstockBill);
			if (StringUtils.isEmpty(checkMsg)) {
				return AjaxResult.createSuccessResult(outstockBillService.updateOutstockBill(outOutstockBill));
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新出库委托单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	/**
	 * 删除出库委托单
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request,String outstockBillId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除出库委托单", "操作人ID为：" + getLoginName(request) + "删除出库委托单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(outstockBillId)) {
				if (outstockBillService.deleteOutstockBill(outstockBillId) > 0)
					return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "删除出库委托-出库委托单主键id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除出库委托单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
	}
	
	/**
	 * 查询所有出库委托单
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request,PageUtils<OutStockBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有出库委托单", "操作人ID为：" + getLoginName(request) + "查询所有出库委托单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(page.getDto().getOutstockBillId())) {
				return AjaxResult.createSuccessResult(outstockBillService.getAllOutstockBill(page.getDto(),page.getOrderByClause(), false));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "查询所有出库委托单-出库委托单dto为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有出库委托单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 查询所有出库委托单带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,PageUtils<OutStockBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有出库委托单带分页", "操作人ID为：" + getLoginName(request) + "查询所有出库委托单带分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(page.getDto().getOutstockBillId())) {
				return AjaxResult.createSuccessResult(outstockBillService.getAllOutstockBill(page, false));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "查询所有出库委托单带分页-出库委托单dto-page为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有出库委托单带分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 根据id查询出库委托单
	 * @param request
	 * @param id
	 * @return 
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public AjaxResult getOutstockBillByCreateUser(HttpServletRequest request, String outstockBillId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据id查询出库委托单", "操作人ID为：" + getLoginName(request) + "根据id查询出库委托单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(outstockBillId)) {
				return AjaxResult.createSuccessResult(outstockBillService.getOutstockBillById(outstockBillId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据id查询出库委托单-出库委托单Id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据id查询出库委托单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 必填项检查
	 * @param OutstockBill
	 * @return
	 */
	private String checkObject(OutOutstockBill outOutstockBill) {
		if (outOutstockBill != null) {
			String Str = "不能为空";
			if (StringUtils.isEmpty(outOutstockBill.getContractId())) {
				return "合同ID" + Str;
			}
			if (StringUtils.isEmpty(outOutstockBill.getBusinessType())) {
				return "业务类型" + Str;
			}
			return "";
		}
		return "出库委托对象不能为空";
	}
}
