package com.maigangle.gyl.web.controller.outstock;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.dto.OutStockBillDto;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.service.OutstockBillService;
import com.maigangle.gyl.facade.service.OutstockDetailService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

/**
 * 待审批提货委托单
 * @author zlh
 * @since  2018年2月4日 - 下午3:43:46
 * @version 1.0
 */
@Controller
@RequestMapping("/approveOutstocks")
public class ApproveOutstocksController extends GylBaseWeb {

	@Autowired
	OutstockBillService outstockBillService;
	@Autowired
	InvInventoryService invInventoryService;
	@Autowired
	OutstockDetailService outstockDetailService;
	@Autowired
	BaseService baseService;
	@Autowired
	RedRedeemBillService redRedeemBillService;
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/approveOutstocks/approveOutstockBillsIndex");
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/approveOutstocks/approveOutstockBillsDetail");
		return modelAndView;
	}
	
	/**
	 * 查询所有出库单带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,@RequestBody PageUtils<OutStockBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有出库单带分页", "操作人ID为：" + getLoginName(request) + "查询所有出库单带分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			PageInfo<OutStockBillDto> pages = outstockBillService.getAllOutstockBill(page, false);
			List<OutStockBillDto> list = pages.getList();
			for(int i = 0;i < list.size();i++) {
				//添加客户名称
				Map<String, Object> resultBuyer = getCrmClient(request, list.get(i).getOutOutstockBill().getCustomerId());
				if (!(boolean)resultBuyer.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
				}
				CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
				list.get(i).setClientName(crmClientBuyer.getClientName());
				//仓库名
				Map<String, Object> storage = getDictMallDepot(request, list.get(i).getOutOutstockBill().getStorageId());
				if (!(boolean)storage.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据仓库名ID获取客户对象," + storage.get("msg"));
				}
				DictMallDepot dictMallDepot = (DictMallDepot) storage.get("data");
				list.get(i).setStorageName(dictMallDepot.getDptName());
			}
			return AjaxResult.createSuccessResult(pages);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有出库单带分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}

}
