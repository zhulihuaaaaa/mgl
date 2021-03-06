package com.maigangle.gyl.web.controller.instock;

import java.util.ArrayList;
import java.util.List;
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

import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.InContractRemitDetail;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.InStockBillDto;
import com.maigangle.gyl.facade.entity.dto.InsInspectionBillDto;
import com.maigangle.gyl.facade.entity.vo.InApplyRemitDetailVo;
import com.maigangle.gyl.facade.service.InsInspectionBillService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;


/**  
 * 入库主单controller
 * @author zlh
 * @since 2017年11月28日 下午3:07:20 
 * @version 1.0 
 */
@Controller
@RequestMapping("/instockBill")
public class InstockBillController extends GylBaseWeb {
	@Autowired
	InstockBillService instockBillService;
	@Autowired
	InsInspectionBillService insInspectionBillService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/instock/instockBillIndex");
		return modelAndView;
	}
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/instock/instockBillDetail");
		return modelAndView;
	}
	/**
	 * 新增入库单
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_INSTOCKBILL_ADD")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request,@RequestBody InInstockBill inInstockBill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增入库单", "操作人ID为：" + getLoginName(request) + "新增入库单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
				//  进行相关逻辑编写
				String checkMsg = this.checkObject(inInstockBill);
				//添加创建人
				Map<String, Object> user = getCurrentPrivUser(request);
				if (!(boolean)user.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + user.get("msg"));
				}
				PrivUser users = (PrivUser) user.get("data");
				inInstockBill.setCreateUser(users.getUserName());
				return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS,instockBillService.addInstockBill(inInstockBill));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增入库单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	/**
	 * 更新入库单
	 * 暂时没用到
	 * @param request
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult updateInstockBill(HttpServletRequest request,InInstockBill inInstockBill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新入库单", "操作人ID为：" + getLoginName(request) + "更新入库单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			String checkMsg = this.checkObject(inInstockBill);
			if (StringUtils.isEmpty(checkMsg)) {
				return AjaxResult.createSuccessResult(instockBillService.updateInstockBill(inInstockBill));
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新入库单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	/**
	 * 更新入库单状态
	 * 按钮：完成入库
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_INSTOCKBILL_UPDATE")
	@RequestMapping("/updateState")
	@ResponseBody
	public AjaxResult updateInstockBillState(HttpServletRequest request,@RequestBody InInstockBill inInstockBill) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新入库单状态", "操作人ID为：" + getLoginName(request) + "更新入库单状态",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			String checkMsg = this.checkObject(inInstockBill);
/*			if (StringUtils.isEmpty(checkMsg)) {
*/				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS,instockBillService.updateInstockBillState(inInstockBill));
			/*} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新入库单状态",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	/**
	 * 删除入库单
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request,String instockBillId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除入库单", "操作人ID为：" + getLoginName(request) + "删除入库单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(instockBillId)) {
				if (instockBillService.deleteInstockBill(instockBillId) > 0)
					return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "删除入库-入库单主键id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除入库单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
	}
	/**
	 * 查询所有入库单
	 * 1入库单列表,返回入库单首页显示
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request,@RequestBody PageUtils<InStockBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		ModelAndView mav = new ModelAndView();
		try {
			super.logInfo(request, logBatch, "查询所有入库单", "操作人ID为：" + getLoginName(request) + "查询所有入库单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if(page == null) {
				page = new PageUtils<InStockBillDto>();
			}
				return AjaxResult.createSuccessResult(instockBillService.getAllInstockBill(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有入库单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 查询所有入库单带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,@RequestBody PageUtils<InStockBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有入库单带分页", "操作人ID为：" + getLoginName(request) + "查询所有入库单带分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
				return AjaxResult.createSuccessResult(instockBillService.getAllInstockBill(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有入库单带分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 根据id查询入库单
	 * @param request
	 * @param id
	 * @return 
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public AjaxResult getInstockBillByCreateUser(HttpServletRequest request, String instockBillId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据id查询入库单", "操作人ID为：" + getLoginName(request) + "根据id查询入库单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(instockBillId)) {
				return AjaxResult.createSuccessResult(instockBillService.getInstockBillById(instockBillId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据id查询入库单-入库单Id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据id查询入库单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 根据业务类型查询入库单
	 * @param request
	 * @param id
	 * @return 
	 */
	@RequestMapping("/findByBusinessType")
	@ResponseBody
	public AjaxResult findByBusinessType(HttpServletRequest request, String businessType) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据业务类型查询入库单", "操作人ID为：" + getLoginName(request) + "根据业务类型查询入库单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(businessType)) {
				return AjaxResult.createSuccessResult(instockBillService.getInstockBillByBusinessType(businessType));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据业务类型查询入库单-业务类型String为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据业务类型查询入库单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 新增一条申请打款记录
	 * @param request
	 * @param 
	 * @return 
	 */
	@Privilege(key = "GYL_INSTOCKBILL_ADD_APPLY")
	@RequestMapping("/addApply")
	@ResponseBody
	public AjaxResult addApply(HttpServletRequest request,@RequestBody InApplyRemitDetailVo inApplyRemitDetailVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增一条申请打款记录", "操作人ID为：" + getLoginName(request) + "新增一条申请打款记录",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			//添加创建人
			Map<String, Object> user = getCurrentPrivUser(request);
			if (!(boolean)user.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + user.get("msg"));
			}
			PrivUser users = (PrivUser) user.get("data");
			inApplyRemitDetailVo.getDetail().setCreateUser(users.getUserName());
			return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS,instockBillService.applyRemit(inApplyRemitDetailVo));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增一条申请打款记录",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	/**
	 * 查询申请打款记录表
	 * @param request
	 * @param findApplyRemit
	 * @return 
	 */
	@RequestMapping("/findApplyRemit")
	@ResponseBody
	public AjaxResult findApplyRemit(HttpServletRequest request,@RequestParam("id") String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询申请打款记录表", "操作人ID为：" + getLoginName(request) + "查询申请打款记录表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(id)) {
				return AjaxResult.createSuccessResult(instockBillService.findApplyRemit(id));
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "查询申请打款记录表入库单id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询申请打款记录表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	/**
	 * 根据合同id查询合同打款记录
	 * @param request
	 * @param findcontract
	 * @return 
	 */
	@RequestMapping("/findContractRecord")
	@ResponseBody
	public AjaxResult findContractRecord(HttpServletRequest request,String contractId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据合同id查询合同打款记录、保证金账户", "操作人ID为：" + getLoginName(request) + "根据合同id查询合同打款记录、保证金账户",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(contractId)) {
				return AjaxResult.createSuccessResult(instockBillService.findContractRecord(contractId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "根据合同id查询合同打款记录、保证金账户为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据合同id查询合同打款记录、保证金账户",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	/**
	 * 查询验收货物
	 * @param request
	 * @param findApplyRemit
	 * @return 
	 */
	@RequestMapping("/findInspectionById")
	@ResponseBody
	public AjaxResult findInspectionById(HttpServletRequest request,@RequestParam("id") String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询验收货物", "操作人ID为：" + getLoginName(request) + "查询验收货物",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(id)) {
				List<InsInspectionBillDto> list = insInspectionBillService.getInsInspectionDetail(id);
				List<InsInspectionBillDto> dtolist = new ArrayList<>();
				if(list!=null&&!list.isEmpty()) {
					for (InsInspectionBillDto insInspectionBillDto : list) {
						// 仓库ID
						String dptId = insInspectionBillDto.getInsInspectionDetail().getStorageId();
						Map<String, Object> user = getDictMallDepot(request,dptId);
						if (!(boolean)user.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + user.get("msg"));
						}
						DictMallDepot dictMallDept= (DictMallDepot) user.get("data");
						insInspectionBillDto.setDictMallDepot(dictMallDept);
						dtolist.add(insInspectionBillDto);
					}
				}
				return AjaxResult.createSuccessResult(dtolist);
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "查询验收货物入库单id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询验收货物",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	/**
	 * 新增一条合同打款记录
	 * @param request
	 * @param 
	 * @return 
	 */
	@RequestMapping("/addContract")
	@ResponseBody
	public AjaxResult addContract(HttpServletRequest request,InContractRemitDetail inContractRemitDetail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增一条合同打款记录", "操作人ID为：" + getLoginName(request) + "新增一条合同打款记录",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (!StringUtils.isEmpty(inContractRemitDetail.getContractRemitDetiailId())) {
				instockBillService.contractRemit(inContractRemitDetail);
				return AjaxResult.createSuccessResult(inContractRemitDetail);
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "合同打款记录实例为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增一条合同打款记录",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	/**
	 * 必填项检查
	 * @param InstockBill
	 * @return
	 */
	private String checkObject(InInstockBill inInstockBill) {
		if (inInstockBill != null) {
			String Str = "不能为空";
			if (StringUtils.isEmpty(inInstockBill.getContractId())) {
				return "合同ID" + Str;
			}
			/*if (StringUtils.isEmpty(inInstockBill.getBusinessType())) {
				return "业务类型" + Str;
			}*/
			return "";
		}
		return "入库对象不能为空";
	}
}
