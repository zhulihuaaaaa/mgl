package com.maigangle.gyl.web.controller.overdue;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.OverdueDefer;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.OverdueDeferDto;
import com.maigangle.gyl.facade.entity.dto.OverdueDto;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.InsInspectionBillService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.service.OverdueService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;


/**  
 * 逾期controller
 * @author zlh
 * @since 2017年11月28日 下午3:07:20 
 * @version 1.0 
 */
@Controller
@RequestMapping("overdue")
public class overdueController extends GylBaseWeb {
	@Autowired
	OverdueService overdueService;
	@Autowired
	InsInspectionBillService insInspectionBillService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/overdue/overdueIndex");
		return modelAndView;
	}
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/overdue/overdueDetail");
		return modelAndView;
	}
		
	/**
	 * 查询所有逾期单
	 * 1逾期单列表,返回逾期单首页显示
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request,@RequestBody PageUtils<OverdueDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		ModelAndView mav = new ModelAndView();
		try {
			super.logInfo(request, logBatch, "查询所有逾期单", "操作人ID为：" + getLoginName(request) + "查询所有逾期单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if(page == null) {
				page = new PageUtils<OverdueDto>();
			}
				//return AjaxResult.createSuccessResult(overdueService.getOverdue(OverdueDto, orderByClause, isAccuracy)(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有逾期单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 查询所有逾期单带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,@RequestBody PageUtils<OverdueDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有逾期单带分页", "操作人ID为：" + getLoginName(request) + "查询所有逾期单带分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
				return AjaxResult.createSuccessResult(overdueService.getOverdue(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有逾期单带分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 新增一条申请延期记录
	 * @param request
	 * @param id
	 * @return 
	 */
	@RequestMapping("/addDefer")
	@ResponseBody
	public AjaxResult addDefer(HttpServletRequest request, @RequestBody OverdueDefer defer) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增一条申请延期记录", "操作人ID为：" + getLoginName(request) + "新增一条申请延期记录",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				defer.setCreateUser(privUser.getUserName());
				return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS,overdueService.addOverdueDefer(defer));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增一条申请延期记录",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	

}

