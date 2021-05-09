package com.maigangle.gyl.web.controller.outstock;

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

import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.OutOutstockDetail;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.dto.OutStockDetailDto;
import com.maigangle.gyl.facade.entity.vo.OutOutstockDetailVo;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.OutstockDetailService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;



/**  
 * 出库货物明细controller
 * @author zlh
 * @since 2017年12月4日 上午9:09:13 
 * @version 1.0 
 */
@Controller
@RequestMapping("/outstockDetail")
public class OutstockDetailController extends GylBaseWeb {
	@Autowired
	OutstockDetailService outstockDetailService;
	
	@Autowired
	BaseService baseService;
	/**
	 * 新增出库货物明细
	 * @param request
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request,OutOutstockDetail outOutstockDetail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增出库货物明细", "操作人ID为：" + getLoginName(request) + "新增出库货物明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			String checkMsg = this.checkObject(outOutstockDetail);
			if (StringUtils.isEmpty(checkMsg)) {
				return AjaxResult.createSuccessResult(outstockDetailService.addOutstockDetail(outOutstockDetail));
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增出库货物明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	/**
	 * 删除出库货物明细
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request,String outstockDetailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除出库货物明细", "操作人ID为：" + getLoginName(request) + "删除出库货物明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			if (!StringUtils.isEmpty(outstockDetailId)) {
				if (outstockDetailService.deleteOutstockDetail(outstockDetailId) > 0)
					return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "删除出库-出库货物明细主键id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除出库货物明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
	}
	
	/**
	 * 查询所有出库货物明细
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request,PageUtils<OutStockDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有出库货物明细", "操作人ID为：" + getLoginName(request) + "查询所有出库货物明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			if (!StringUtils.isEmpty(page.getDto().getOutstockDetailId())) {
				return AjaxResult.createSuccessResult(outstockDetailService.getAllOutstockDetail(page.getDto(),page.getOrderByClause(),false));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "查询所有出库货物明细-出库货物明细dto为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有出库货物明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 查询所有出库货物明细带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,PageUtils<OutStockDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有出库货物明细带分页", "操作人ID为：" + getLoginName(request) + "查询所有出库货物明细带分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			if (!StringUtils.isEmpty(page.getDto().getOutstockDetailId())) {
				return AjaxResult.createSuccessResult(outstockDetailService.getAllOutstockDetail(page, false));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "查询所有出库货物明细带分页-出库货物明细dto-page为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有出库货物明细带分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 根据id查询出库货物明细
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据id查询出库货物明细", "操作人ID为：" + getLoginName(request) + "根据id查询出库货物明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			if (!StringUtils.isEmpty(id)) {
				List<OutOutstockDetailVo> voList = outstockDetailService.getOutstockDetailById(id);
				for(int i=0;i<voList.size();i++) {
					OutOutstockDetailVo vo = voList.get(i);
					if (vo != null) {
						vo.setBaseProduct(baseService.getBaseProductById(vo.getOutOutstockDetail().getProductId()));
						//vo.setMaterialName(gylApiService.getDictMallSpec(vo.getOutOutstockDetail().getMaterialId()).getQuality());
						//vo.setMnfctName(gylApiService.getDictMallMnfct(vo.getOutOutstockDetail().getMnfctId()).getMnfctName());
						vo.setSurfaceName(baseService.getProcessName(vo.getOutOutstockDetail().getSurfaceId()));
						//仓库名
						Map<String, Object> storage = getDictMallDepot(request, vo.getOutOutstockDetail().getStorageId());
						if (!(boolean)storage.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据仓库名ID获取客户对象," + storage.get("msg"));
						}
						DictMallDepot dictMallDepot = (DictMallDepot) storage.get("data");
						vo.setStorageName(dictMallDepot.getDptName());
					}
				}
				return AjaxResult.createSuccessResult(voList);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据id查询出库货物明细-id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据id查询出库货物明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}

	/**
	 * 更新
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_OUTSTOCKBILLS_EDIT")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request,@RequestBody List<OutOutstockDetailVo> detailList) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新赎货货物明细单", "操作人ID为：" + getLoginName(request) + "更新赎货货物明细单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			/*String checkMsg = this.checkObject(detail);
			if (StringUtils.isEmpty(checkMsg)) {*/
				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS,outstockDetailService.updateOutstockDetail(detailList));
			/*} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新赎货货物明细单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	/**
	 * 必填项检查
	 * @param OutstockDetail
	 * @return
	 */
	private String checkObject(OutOutstockDetail outOutstockDetail) {
		if (outOutstockDetail != null) {
			String Str = "不能为空";
			if (StringUtils.isEmpty(outOutstockDetail.getBusinessType())) {
				return "业务类型" + Str;
			}
			return "";
		}
		return "出库货物明细对象不能为空";
	}
}
