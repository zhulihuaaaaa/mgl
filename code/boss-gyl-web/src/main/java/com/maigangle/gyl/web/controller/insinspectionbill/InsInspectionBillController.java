package com.maigangle.gyl.web.controller.insinspectionbill;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.BaseProcess;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InsInspectionSub;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.InStockBillDto;
import com.maigangle.gyl.facade.entity.dto.InsInspectionBillDto;
import com.maigangle.gyl.facade.entity.excel.InsInspectionBillExcel;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.InsInspectionBillVo;
import com.maigangle.gyl.facade.enums.ImageFileTypeEnum;
import com.maigangle.gyl.facade.enums.InspectionTypeEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.GylBaseService;
import com.maigangle.gyl.facade.service.InsInspectionBillService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
/**
 * 交收管理的Controller
 * @author 杨思静
 * @since  2017年11月30日 - 下午1:39:40
 * @version 1.0
 */
@Controller
@RequestMapping("/settle")
public class InsInspectionBillController extends GylBaseWeb{
	@Autowired
	private InsInspectionBillService insInspectionBillService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private InstockBillService instockBillService;
	@Autowired
	private GylBaseService gylBaseService;
	@Autowired
	private  BaseService baseService;
//	@Autowired
//	 private GylService  gylService;
	/****************页面*************************/
	/**
	 *
	 * @author shmily
	 * @Title: main 
	 * @Description: ( 返回一个交收管理页面 )
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillIndex");
		return modelAndView;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: detail
	 * @Description: ( 验货单详情侧边栏页面 )
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillDetail");
		// 可在此向页面赋值
		return modelAndView;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: detail 
	 * @Description: ( 子单详情侧边栏页面 ) 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/sub/detail")
	public ModelAndView detailBySub() {
		ModelAndView modelAndView = new ModelAndView("/insinspectionbill/insInspectionBillDetailbySub");
		// 可在此向页面赋值
		return modelAndView;
	}
	
	
	/*********************************页面需要的接口***********************/
	/**
	 * 获取交收管理
	 * 验货单查询列表页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request, @RequestBody PageUtils<InsInspectionBillVo> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取验货单列表", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<InsInspectionBill> list = insInspectionBillService.getInsInspectionBillAll(format(page),false);
			return AjaxResult.createSuccessResult(getPageInfoToPageInfoByBill(request,logBatch,list));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取验货单列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: saveInsInspectionSub 
	 * @Description: ( 新增子单和货物明细 ) 
	 * @param request
	 * @param settlementDto
	 * @return AjaxResult
	 * @throws
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_ADD")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult saveInsInspectionSub(HttpServletRequest request,@RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增验货子单和货物明细", "操作人ID为：" + getLoginName(request) + "新增子单和货物明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// VO --- DTO
			InsInspectionBillDto  settlementDto = format(insInspectionBillVo);
			
			
			
			//  进行相关逻辑编写
			if (settlementDto != null ) {
					createUser(request,logBatch,settlementDto);
				 // return  AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, settlementService.addInsInspectionDetailAndInsInspectionSub(settlementDto));
				InsInspectionBillDto dto =  insInspectionBillService.addInsInspectionDetailAndInsInspectionSub(settlementDto);
				if(dto ==null) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_FAILED, dto);
				}else {
					if(!StringUtils.isEmpty(insInspectionBillVo.getContractId())) {
						InStockBillDto instock = instockBillService.getInstockBillByContractId(insInspectionBillVo.getContractId());
						instock.getBill().setInspectionStatus(InspectionTypeEnum.YAN_HUO_ZHONG.toString());
						instockBillService.updateInstockBill(instock.getBill());
					}
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, dto);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"参数不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增验货子单和货物明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}

	/**
	 * 获取交收管理
	 * 验货单子验货单列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/settledetail")
	@ResponseBody
	public AjaxResult getsettledetail(HttpServletRequest request, @RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取验货单子验货单列表", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  测试
			if (insInspectionBillVo ==null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
			String insInspectionBillId = insInspectionBillVo.getId();
			if (StringUtils.isEmpty(insInspectionBillId)){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能为空");
			}
			List<InsInspectionSub> list = insInspectionBillService.getInsInspectionSubAllById(insInspectionBillId);
			return AjaxResult.createSuccessResult(fomatbyListDtoBySub(request,logBatch,list));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取验货单子验货单列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"保存失败");
	}
	
	
	
	/**
	 * 获取交收管理
	 * 获取 
	 * 审核通过的子单列表中的所有货物
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/settledetailByPassAll")
	@ResponseBody  
	public AjaxResult getsettledetailByPassAll(HttpServletRequest request, @RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取验货单子验货单列表", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// 测试
			if (insInspectionBillVo == null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能为空");
			}
			String insInspectionBillId = insInspectionBillVo.getId();
			if (StringUtils.isEmpty(insInspectionBillId)){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能为空");
			}
			return AjaxResult.createSuccessResult(fomatbyListDtoByDetail(request,logBatch,insInspectionBillService.getInsInspectionDetailById(insInspectionBillId)));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取验货单子验货单列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"获取失败");
	}
	
	
	
	
	/**
	 * 根据子验货单Id
	 * 获取交收管理 
	 * 验货单子验货单列表
	 * 下某子单内的货物明细列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/settleListdetail")
	@ResponseBody
	public AjaxResult getsettleListdetail(HttpServletRequest request, @RequestBody InsInspectionBillVo insInspectionBillVo ) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取验货单子货物列表", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (insInspectionBillVo == null) {
				return null;
			}
			 String insInspectionSubId  = insInspectionBillVo.getId();
			if (StringUtils.isEmpty(insInspectionSubId)){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能未空");
			}
			return AjaxResult.createSuccessResult(fomatbyListDtoByDetail(request,logBatch,insInspectionBillService.getInsInspectionDetailBySubId(insInspectionSubId)));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取验货单子货物列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	
	
	/**
	 * 获取交收管理 
	 * 编辑子验货单 
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_EDIT")
	@SuppressWarnings("unused")
	@RequestMapping("/settleSubDetail/update")
	@ResponseBody  
	public AjaxResult updateSettleSubDetail(HttpServletRequest request, @RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "修改验货子单", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			InsInspectionBillDto insInspectionBillDto = new InsInspectionBillDto();
			if (insInspectionBillVo == null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"状态缺失");
			}
			insInspectionBillDto.setInsInspectionSub(insInspectionBillVo.getInsInspectionSub());
			//根据Dto 修改子验货单
			if (insInspectionBillDto !=null){
				if (insInspectionBillDto.getInsInspectionSub() != null){
					InsInspectionBillDto insDto = insInspectionBillService.updateInsInspectionSubByDTO(insInspectionBillDto);
					if(insDto !=null) {
						String subId = insInspectionBillDto.getInsInspectionSub().getInspectionSubId();
						List<Attach> warrantyList = insInspectionBillVo.getWarrantyList();
						if(warrantyList!=null) {
							for (Attach attach : warrantyList) {
								if(StringUtils.isEmpty(attach.getRelationId())) {
									attach.setFileCategory(ImageFileTypeEnum.ZHI_BAO_SHU.toString());
									attach.setRelationId(subId);
									gylBaseService.addAttach(attach);
								}
							}							
						}
						List<Attach> inventoryVoucherList = insInspectionBillVo.getInventoryVoucherList();
						if(inventoryVoucherList!=null) {
							for (Attach attach : inventoryVoucherList) {
								if(StringUtils.isEmpty(attach.getRelationId())) {
									attach.setFileCategory(ImageFileTypeEnum.CUN_HUO_PING_ZHENG.toString());
									attach.setRelationId(subId);
									gylBaseService.addAttach(attach);
								}
							}							
						}
						List<String> list= insInspectionBillVo.getDeleteAttachList();
						if(list!=null&&list.size()!=0) {
							for (String string : list) {
								gylBaseService.deleteAttach(string);
							}
						}
					}
					return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS,insDto );
				}
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"状态缺失");
			}
			return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"参数不正确");
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "修改验货子单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,e.getMessage());
		}
	}
	
	
	
	/**
	 * 获取交收管理
	 * 验货单子验货单列表
	 * 下  新增一条货物信息
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/addDetail/save")
	@ResponseBody   
	public AjaxResult addDetail(HttpServletRequest request,@RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增一条验货子单的货物信息", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (insInspectionBillVo == null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"参数不正确");
			}
			InsInspectionBillDto settlementDto = new InsInspectionBillDto();
			settlementDto.setInsInspectionDetail(insInspectionBillVo.getInsInspectionDetail());
			settlementDto.setSphotosGoods(insInspectionBillVo.getSphotosGoods());
			// 新增货物信息
			if (settlementDto != null ||settlementDto.getInsInspectionDetail()!=null){
				return AjaxResult.createSuccessResult(insInspectionBillService.addInsInspectionDetailByDTO(settlementDto),"新增成功");
			} 
			return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"参数不正确");
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增一条验货子单的货物信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	
	
	/** 
	 * 获取交收管理 
	 * 提交子验货单  ----- 提交子验货单 修改审核状态
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_SUBMIT")
	@SuppressWarnings("unused")
	@RequestMapping("/submit/update") 
	@ResponseBody   
	public AjaxResult updateSubmitSettleSub(HttpServletRequest request, @RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "提交验货子单", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			 InsInspectionBillDto settlementDto = new InsInspectionBillDto();// format(insInspectionBillVo);
			 InsInspectionSub sub  = new  InsInspectionSub();
			 sub.setInspectionSubId(insInspectionBillVo.getId());
			 sub.setAuditStatus(insInspectionBillVo.getAuditStatus());
			 settlementDto.setInsInspectionSub(sub);
			//根据Dto 修改子验货单
			if (settlementDto !=null){
				if (settlementDto.getInsInspectionSub() != null && !StringUtils.isEmpty(settlementDto.getInsInspectionSub().getInspectionSubId())){
					InsInspectionBillDto dto = insInspectionBillService.updateInsInspectionSub(settlementDto);
					if(dto == null) {
						return AjaxResult.createSuccessResult(dto,"提交失败");
					}else {
						return AjaxResult.createSuccessResult(dto,"提交成功");
					}
				}
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能为空");
			}
			return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "提交验货子单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	
	
	
	

	/**
	 * 获取交收管理
	 * 验货单子验货单列表
	 * 下  批量新增货物信息
	 * @param request
	 * @return 
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_DETAIL_ADD")
	@RequestMapping("/bathaddDetail/save")
	@ResponseBody   
	public AjaxResult bathAddDetail(HttpServletRequest request,@RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 批量新增验货子单下货物信息", "操作人ID为：" + getLoginName(request) + " 批量新增货物信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<InsInspectionBillVo> insInspectionBillVoList = insInspectionBillVo.getInsInspectionBillVoList();
			InsInspectionSub insInspectionSub = insInspectionBillVo.getInsInspectionSub();
			if (insInspectionBillVoList == null||insInspectionSub ==null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"参数不正确");
			}
			List<InsInspectionBillVo> list = insInspectionBillService.bathAddInspectionDetail(insInspectionBillVoList);
			if(list!=null) {
				// 修改子单
				InsInspectionBillDto   ins = insInspectionBillService.getgetInsInspectionSubById(insInspectionSub.getInspectionSubId());
				if(ins!=null&&ins.getInsInspectionSub()!=null) {
					InsInspectionSub insSub = ins.getInsInspectionSub();
					if(insInspectionSub.getTotalNumber()!=null&&insInspectionSub.getTotalWeight()!=null) {
						if(insSub.getTotalNumber()==null) {
							insSub.setTotalNumber(BigDecimal.ZERO);
						} 
						if(insSub.getTotalWeight()==null) {
							insSub.setTotalWeight(BigDecimal.ZERO);
						}
						insInspectionSub.setTotalNumber(insInspectionSub.getTotalNumber().add(insSub.getTotalNumber()));
						insInspectionSub.setTotalWeight(insInspectionSub.getTotalWeight().add(insSub.getTotalWeight()));
						InsInspectionBillDto dto = new InsInspectionBillDto();
						dto.setInsInspectionSub(insInspectionSub);
						dto = insInspectionBillService.updateInsInspectionSubByDTO(dto);
						if(dto !=null) {
							//  批量新增货物信息
							return  AjaxResult.createSuccessResult(list);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, " 批量新增验货子单下货物信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 获取交收管理
	 * 验货单子验货单列表
	 * 下  批量修改货物信息
	 * @param request
	 * @return 
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_DETAIL_BATCH_EDIT")
	@RequestMapping("/bathupdateDetail/update")
	@ResponseBody   
	public AjaxResult bathUpdateDetail(HttpServletRequest request,@RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 批量修改验货子单货物信息", "操作人ID为：" + getLoginName(request) + " 批量新增货物信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<InsInspectionBillVo> insInspectionBillVoList = insInspectionBillVo.getInsInspectionBillVoList();
			if (insInspectionBillVoList == null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"参数不正确");
			}
			List<InsInspectionBillVo> volist =insInspectionBillService.bathUpdateInspectionDetail(insInspectionBillVoList);
			List<String> delList = insInspectionBillVo.getDeleteAttachList();
			if(volist!=null&&!delList.isEmpty()) {
				for (String string : delList) {
					gylBaseService.deleteAttach(string);					
				}
			}
			//  批量修改货物信息
			return  AjaxResult.createSuccessResult(volist);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "批量修改验货子单货物信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	/**
	 * 获取交收管理
	 * 验货单子验货单列表
	 * 下  批量修改以及添加或者删除货物信息
	 * @param request
	 * @return 
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_DETAIL_BATCH_EDIT_ADD")
	@RequestMapping("/updatebathDetail/update")
	@ResponseBody   
	public AjaxResult UpdatebathDetail(HttpServletRequest request,@RequestBody InsInspectionBillVo insInspectionBillVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 批量修改以及添加或者删除货物信息", "操作人ID为：" + getLoginName(request) + " 批量新增货物信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<InsInspectionBillVo> insInspectionBillVoList = insInspectionBillVo.getInsInspectionBillVoList();
			InsInspectionSub sub = insInspectionBillVo.getInsInspectionSub();
			InsInspectionBillDto  dto = new InsInspectionBillDto();
			dto.setInsInspectionSub(sub);
			if (insInspectionBillVoList == null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"参数不正确");
			}
			//  批量修改新增 删除
			insInspectionBillVoList = insInspectionBillService.bathUpdateAndAddAndDelInspectionDetail(insInspectionBillVoList);
			if(insInspectionBillVoList!=null) {
				dto = insInspectionBillService.updateInsInspectionSub(dto);				
			} 
			List<String> delList = insInspectionBillVo.getDeleteAttachList();
			if(insInspectionBillVoList!=null&&!delList.isEmpty()) {
				for (String string : delList) {
					gylBaseService.deleteAttach(string);					
				}
			}
			if(dto !=null &&insInspectionBillVoList !=null) {				
				return  AjaxResult.createSuccessResult(insInspectionBillVoList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, " 批量修改以及添加或者删除货物信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	
	
	/**
	 * 获取交收管理
	 *	删除子单
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_DELETE")
	@RequestMapping("/sub/delete")
	@ResponseBody   
	public AjaxResult delectSub(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 删除验货子单信息", "操作人ID为：" + getLoginName(request) + " 删除子单信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if(StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
			//  删除id
			return  AjaxResult.createSuccessResult(insInspectionBillService.deleteInsInspectionSub(id));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, " 删除验货子单信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 获取交收管理
	 *	删除子单货物
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_DETAIL_DELETE")
	@RequestMapping("/detail/delete")
	@ResponseBody   
	public AjaxResult delectDetail(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, " 删除货物详情信息", "操作人ID为：" + getLoginName(request) + " 删除子单信息",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if(StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
			//  删除id
			return  AjaxResult.createSuccessResult(insInspectionBillService.deleteInsInspectionDetail(id));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除货物详情信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**********************************************待选***************************************/
	
	
	/** 
	 * 获取交收管理 
	 * 查询出合同货物s
	 * @param request
	 * @return
	 */
	@RequestMapping("/getContractDetail")
	@ResponseBody
	public AjaxResult getContractDetail(HttpServletRequest request, String contractId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		
		try {
			
			super.logInfo(request, logBatch, "获取验货单子验货单列表", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// 测试
			contractId = "1";
			//根据合同编号ContractId 
			return AjaxResult.createSuccessResult("");
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取验货单子验货单列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/********************编辑数据的接口************************/
	
	
	
	
	
	/********************新增数据的接口***********************/
	/**
	 * 获取交收管理 
	 * 验货单子验货单列表
	 * 下某子单内的货物明细列表
	 * 新增子验货单和货品详情信息（列表）
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/addSettleSubAndDetail")
	@ResponseBody
	public AjaxResult addSettleSubAndDetail(HttpServletRequest request,InsInspectionBillDto settlementDto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增子验货单和货品详情信息", "操作人ID为：" + getLoginName(request) + "获取验货单子验货单列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  测试代码
			settlementDto.setInsInspectionSub(new InsInspectionSub());
			settlementDto.getInsInspectionSub().setInstockDate(new Date());
			List<InsInspectionDetail> list = new ArrayList<InsInspectionDetail>();
			list.add(new InsInspectionDetail());
			list.get(0).setAmount(BigDecimal.TEN);
			settlementDto.setInsInspectionDetailList(list);
			// 新增子单和货物信息
			if (settlementDto != null ) {
				if (settlementDto.getInsInspectionSub()!=null && settlementDto.getInsInspectionDetailList()!=null){
					return AjaxResult.createSuccessResult(insInspectionBillService.addInsInspectionDetailAndInsInspectionSub(settlementDto));
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"参数不正确");
			} 
//			return AjaxResult.createSuccessResult(settlementService.addInsInspectionDetailAndInsInspectionSub(settlementDto));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增子验货单和货品详情信息",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: format 
	 * @Description: ( VO -- DTO ) 
	 * @param page
	 * @return PageUtils<InsInspectionBillDto>
	 * @throws
	 */
	private PageUtils<InsInspectionBillDto> format(PageUtils<InsInspectionBillVo> page){
		PageUtils<InsInspectionBillDto> page1 =new PageUtils<InsInspectionBillDto>();
		page1.setDto(new InsInspectionBillDto());
		if(page == null) {
			return page1;
		}
		if (!StringUtils.isEmpty(page.getOrderByClause())) {
			page1.setOrderByClause(page.getOrderByClause());
		}
		if(!StringUtils.isEmpty(page.getPageSize())) {
			page1.setPageSize(page.getPageSize());
		}
		if(!StringUtils.isEmpty(page.getPageNum())) {
			page1.setPageNum(page.getPageNum());
		}
		InsInspectionBillVo vo = page.getDto();
		if (vo == null) {
			return page1;
		}
		InsInspectionBillDto dto = page1.getDto();
		BeanUtils.copyProperties(vo, dto);
		if (StringUtils.isEmpty(vo.getAuditStatus())) {
			dto.setAuditStatus("");
		}else {
			dto.setAuditStatus(vo.getAuditStatus());
		}
		if (StringUtils.isEmpty(vo.getContractNo())) {
			dto.setContractNo("");
		}else {
			dto.setContractNo(vo.getContractNo());
		}
		if (vo.getMaxDate() == null) {
			dto.setMaxDate(null);
		}else {
			dto.setMaxDate(vo.getMaxDate());
		}
		if (vo.getMinDate() == null) {
			dto.setMinDate(null);
		}else {
			dto.setMinDate(vo.getMinDate());
		}
		if (StringUtils.isEmpty(vo.getSubCode())){
			dto.setSubCode("");
		}else {
			dto.setSubCode(vo.getSubCode());
		}
		if (StringUtils.isEmpty(vo.getCreateUser())) {
			dto.setCreateUser("");
		}else {
			dto.setCreateUser(vo.getCreateUser());
		}
		if (StringUtils.isEmpty(vo.getContractId())) {
			dto.setContractId("");
		}else {
			dto.setContractId(vo.getContractId());
		}
		dto.setBusinessType(vo.getBusinessType());
		
		//if(StringUtils.isEmpty())
		// 创建时间
		dto.setMinDate(vo.getMinDate());
		dto.setMaxDate(vo.getMaxDate());
		return page1;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: format 
	 * @Description: ( VO ---- DTO ) 
	 * @param insInspectionBillVo
	 * @return InsInspectionBillDto
	 * @throws
	 */
	private InsInspectionBillDto format(InsInspectionBillVo vo) {
		InsInspectionBillDto dto = new InsInspectionBillDto();
		if(vo== null) {
			return dto;
		}
		// 子单
		if(!StringUtils.isEmpty(vo.getInsInspectionSub())) {
			dto.setInsInspectionSub(vo.getInsInspectionSub());
		}
		if (vo.getInsInspectionDetailList() == null) {
			dto.setInsInspectionDetailList(vo.getInsInspectionDetailList());
		}
		if (!StringUtils.isEmpty(vo.getId())) {
			dto.setId(vo.getId());
		}
		if (!StringUtils.isEmpty(vo.getAuditStatus())) {
			dto.setAuditStatus(vo.getAuditStatus());
		}
		if(!StringUtils.isEmpty(vo.getInspectionBillCode())) {
			dto.setInspectionBillCode(vo.getInspectionBillCode());
		}
		if(vo.getInsInspectionDetailList() !=null) {
			dto.setInsInspectionDetailList(vo.getInsInspectionDetailList());
		}
		if(vo.getSphotosGoods()!=null) {
			dto.setSphotosGoods(vo.getSphotosGoods());
		}
		if(vo.getInventoryVoucher() !=null) {
			 dto.setInventoryVoucher(vo.getInventoryVoucher());
		}
		if(vo.getInsInspectionBillVoList()!=null&&!vo.getInventoryVoucherList().isEmpty()) {
			dto.setInventoryVoucherList(vo.getInventoryVoucherList());
		}
		if(vo.getWarrantyList()!=null&&!vo.getWarrantyList().isEmpty()) {
			dto.setWarrantyList(vo.getWarrantyList());
		}
		if(vo.getSphotosGoodsList()!=null&&!vo.getSphotosGoodsList().isEmpty()) {
			dto.setSphotosGoodsList(vo.getSphotosGoodsList());
		}
		if(vo.getInsInspectionBillVoList()!=null&&!vo.getInsInspectionBillVoList().isEmpty()) {
			dto.setInsInspectionBillVoList(vo.getInsInspectionBillVoList());
		}
		return dto;
	}
	/***************************************主验货单start**********************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getPageInfoToPageInfoByBill 
	 * @Description: ( 主验货单 PageInfo ---> PageInfo 为了对应页面上的分页信息  ) 
	 * @param request
	 * @param logBatch
	 * @param pageInfo
	 * @return PageInfo<InsInspectionBillDto>
	 * @throws
	 */
	private PageInfo<InsInspectionBillDto> getPageInfoToPageInfoByBill(HttpServletRequest request, String logBatch,PageInfo<InsInspectionBill> pageInfo){
		// dTO 
        PageInfo<InsInspectionBillDto> pageDto = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageDto);
        // DTO LIST 
        pageDto.setList(fomatbyListDtoByBill(request,logBatch,pageInfo.getList()));
		return pageDto;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyListDto 
	 * @Description: ( 主验货单  整理批量转换Dto ) 
	 * @param request
	 * @param logBatch
	 * @param list
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	private  List<InsInspectionBillDto> fomatbyListDtoByBill(HttpServletRequest request, String logBatch,List<InsInspectionBill> list) {
		List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		if(list==null||list.isEmpty()) {
			return dtoList;
		}
		for (InsInspectionBill InsInspectionBill : list) {
			InsInspectionBillDto dto =fomatbyDtoByBill(request,logBatch,InsInspectionBill);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyDto 
	 * @Description: ( 主验货单 单个转换Dto ) 
	 * @param inventory
	 * @return InvInventoryDto
	 * @throws
	 */
	@SuppressWarnings("unused")
	private  InsInspectionBillDto fomatbyDtoByBill(HttpServletRequest request, String logBatch,InsInspectionBill ins) {
		 if (ins == null) {
			 return null;
		 }
		InsInspectionBillDto dto = new InsInspectionBillDto();
		dto.setInsInspectionBill(ins);
		//  创建人 
		
		
		
		//  入库编号
		if (!StringUtils.isEmpty(ins.getInstockId())) {
			InStockBillDto ininstock = instockBillService.getInstockBillById(ins.getInstockId());
			if (ininstock !=null&&ininstock.getBill()!=null ) {
				String instockNo = ininstock.getInstockCode();
				dto.setInstockNo(ininstock.getBill().getInstockCode());
			}
		}
		//  合同编号
		if (!StringUtils.isEmpty(ins.getContractId())) {
			ConContract con = contractService.getConContractById(ins.getContractId());
			if (con !=null) {
				String contractNo =con.getContractNo();
				dto.setConContract(con);
				dto.setContractNo(contractNo);
			}
		}
		return  dto;
	}
	/***************************************主验货单end**********************************/
	
	
	/**************************************子验货单Start**********************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getPageInfoToPageInfoBySub 
	 * @Description: ( 子验货单 PageInfo ---> PageInfo 为了对应页面上的分页信息  ) 
	 * @param request
	 * @param logBatch
	 * @param pageInfo
	 * @return PageInfo<InsInspectionBillDto>
	 * @throws
	 */
	@SuppressWarnings("unused")
	private PageInfo<InsInspectionBillDto> getPageInfoToPageInfoBySub(HttpServletRequest request, String logBatch,PageInfo<InsInspectionSub> pageInfo){
		
        PageInfo<InsInspectionBillDto> pageDto = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageDto);
        pageDto.setList(fomatbyListDtoBySub(request,logBatch,pageInfo.getList()));
		return pageDto;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyListDto 
	 * @Description: ( 子验货单  整理批量转换Dto ) 
	 * @param request
	 * @param logBatch
	 * @param list
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	private  List<InsInspectionBillDto> fomatbyListDtoBySub(HttpServletRequest request, String logBatch,List<InsInspectionSub> list) {
		List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		if(list==null||list.isEmpty()) {
			return dtoList;
		}
		for (InsInspectionSub insInspectionSub : list) {
			InsInspectionBillDto dto =fomatbyDtoBySub(request,logBatch,insInspectionSub);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyDto 
	 * @Description: ( 子验货单 单个转换Dto ) 
	 * @param inventory
	 * @return InvInventoryDto
	 * @throws
	 */
	private  InsInspectionBillDto fomatbyDtoBySub(HttpServletRequest request, String logBatch,InsInspectionSub insInspectionSub) {
		InsInspectionBillDto insInspectionBillDto = new InsInspectionBillDto();
		insInspectionBillDto.setInsInspectionSub(insInspectionSub);
		// 设置质保书
		List<Attach> attach = gylBaseService.getAttachByIdAndType(insInspectionSub.getInspectionSubId(), ImageFileTypeEnum.ZHI_BAO_SHU.toString());
		if (attach !=null) {
			//insInspectionBillDto.setWarranty(attach);
			insInspectionBillDto.setWarrantyList(attach);
		}
		// 设置存货凭证
		List<Attach>  inventoryVoucher = gylBaseService.getAttachByIdAndType(insInspectionSub.getInspectionSubId(), ImageFileTypeEnum.CUN_HUO_PING_ZHENG.toString());
		if (inventoryVoucher !=null) {
			// insInspectionBillDto.setInventoryVoucher(inventoryVoucher);
			insInspectionBillDto.setInventoryVoucherList(inventoryVoucher);
		}

		// 合同编号
		InsInspectionBill insInspectionBill = insInspectionBillService.getInsInspectionBillById(insInspectionSub.getInspectionId());
		if (insInspectionBill !=null) {
			ConContract con = contractService.getConContractById(insInspectionBill.getContractId());
			if (con !=null) {
				insInspectionBillDto.setContractNo(con.getContractNo());
				insInspectionBillDto.setConContract(con);
			}
			// 验货单
			insInspectionBillDto.setInsInspectionBill(insInspectionBill);
		}
		// 仓库
		DictMallDepot dictMallDepot = null;
		if(!StringUtils.isEmpty(insInspectionSub.getStorageId())) {
			Map<String, Object> result = getDictMallDepot(request,insInspectionSub.getStorageId());
			if ((boolean) result.get("isSuccess")) {
				dictMallDepot = (DictMallDepot)result.get("data");				
			}
			if(dictMallDepot!=null) {
				insInspectionBillDto.setDictMallDepot(dictMallDepot);
			}
		}
		return insInspectionBillDto;
	}
	/**************************************子验货单end**********************************/
	/**************************************货物信息Start********************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getPageInfoToPageInfoByDetail
	 * @Description: ( 货物信息 PageInfo ---> PageInfo 为了对应页面上的分页信息  ) 
	 * @param request
	 * @param logBatch
	 * @param pageInfo
	 * @return PageInfo<InsInspectionBillDto>
	 * @throws
	 */
	@SuppressWarnings("unused")
	private PageInfo<InsInspectionBillDto> getPageInfoToPageInfoByDetail(HttpServletRequest request, String logBatch,PageInfo<InsInspectionDetail> pageInfo){
        PageInfo<InsInspectionBillDto> pageDto = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageDto);
        pageDto.setList(fomatbyListDtoByDetail(request,logBatch,pageInfo.getList()));
		return pageDto;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyListDto 
	 * @Description: ( 货物信息  整理批量转换Dto ) 
	 * @param request
	 * @param logBatch
	 * @param list
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	private  List<InsInspectionBillDto> fomatbyListDtoByDetail(HttpServletRequest request, String logBatch,List<InsInspectionDetail> list) {
		List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		if(list==null||list.isEmpty()) {
			return dtoList;
		}
		for (InsInspectionDetail insInspectionDetail : list) {
			InsInspectionBillDto dto =fomatbyDtoByDetail(request,logBatch,insInspectionDetail);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyDto 
	 * @Description: ( 货物信息 单个转换Dto ) 
	 * @param inventory
	 * @return InvInventoryDto
	 * @throws
	 */
	private  InsInspectionBillDto fomatbyDtoByDetail(HttpServletRequest request, String logBatch,InsInspectionDetail insInspectionDetail) {
		InsInspectionBillDto dto = new InsInspectionBillDto();
		dto.setInsInspectionDetail(insInspectionDetail);
		//实体到DTO
		 //货物照片
		List<Attach> attach = gylBaseService.getAttachByIdAndType(insInspectionDetail.getInspectionDetailId(), ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
		if (attach !=null) {
			dto.setSphotosGoodsList(attach);
		}
		// 品名
		BaseProduct baseProduct = baseService.getBaseProductById(insInspectionDetail.getProductId());
		if (baseProduct != null) {
			String productName = baseProduct.getProductName();
			dto.setProductName(productName);
			dto.setBaseProduct(baseProduct);
		}
		//表面
		//  表面
		BaseProcess baseProcess = baseService.getBaseProcess(insInspectionDetail.getSurfaceId());
		if (baseProcess !=null) {
			dto.setSurfaceName(baseProcess.getProcessName());
		}
		// 仓库
		DictMallDepot dictMallDepot =null;
		if(!StringUtils.isEmpty(insInspectionDetail.getStorageId())) {
			Map<String, Object> result = getDictMallDepot(request,insInspectionDetail.getStorageId());
			if ((boolean) result.get("isSuccess")) {
				dictMallDepot = (DictMallDepot)result.get("data");				
			}
		}
		if (dictMallDepot != null) {
			dto.setDictMallDepot(dictMallDepot);
		}
		// 制造商 厂商
		DictMallMnfct dictMallMnfct = null;
		if(!StringUtils.isEmpty(insInspectionDetail.getMnfctId())) {
			Map<String, Object> result = getDictMallMnfct(request,insInspectionDetail.getMnfctId());
			if ((boolean) result.get("isSuccess")) {
				dictMallMnfct = (DictMallMnfct)result.get("data");				
			}
			if(dictMallMnfct!=null) {
				dto.setDictMallMnfct(dictMallMnfct);
			}
		}
		return dto;
	}
	/**************************************货物信息end***************************************************/
	
	private void createUser(HttpServletRequest request, String logBatch,InsInspectionBillDto  settlementDto){		
		Map<String, Object> result = getCurrentPrivUser(request);
		if ((boolean) result.get("isSuccess")) {
			PrivUser p = (PrivUser)result.get("data");	
			settlementDto.setCreateUser(p.getUserName());
			 // settlementDto.setPrivUser(p);
		}

	}
	
	/**
	 * 导出验货Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_INSINSPECTIONBILL_EXCEL")
	@RequestMapping("/exportExcel")
	@ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("验货数据表","UTF-8") + ".xls");
		//编码
		response.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");
		String orderByClause = null;
		InsInspectionBillDto dto = null;
		if (!StringUtils.isEmpty(param)) {
			JSONObject paramObj = JSONObject.parseObject(param);
			orderByClause = paramObj.getString("orderByClause");
			dto = paramObj.getObject("dto", InsInspectionBillDto.class);
		} else {
			dto = new InsInspectionBillDto();
		}
		
		List<InsInspectionBillExcel> list1 = new ArrayList<InsInspectionBillExcel>();
		
		//主验货单
		List<InsInspectionBillDto> list = insInspectionBillService.getInsInspectionBillAll(dto);
		if (list != null && !list.isEmpty()) {
			for (InsInspectionBillDto ins : list) {
				InsInspectionBillExcel insInspectionBillExcel = new InsInspectionBillExcel();
				BeanUtils.copyProperties(ins, insInspectionBillExcel);
				
				//子验货单
				List<InsInspectionSub> detailList = insInspectionBillService.getInsInspectionSubAllById(ins.getInsInspectionBill().getInspectionBillId());
				if(detailList != null && !detailList.isEmpty()) {
					for (InsInspectionSub insInspectionSub : detailList) {
						//判断审核通过的验货单
						if (insInspectionSub.getAuditStatus().equals("D")) {
							//子验货单货物
							List<InsInspectionDetail> detailListDetail = insInspectionBillService.getInsInspectionDetailBySubId(insInspectionSub.getInspectionSubId());
							if(detailListDetail != null && !detailListDetail.isEmpty()) {
								for (InsInspectionDetail insInspectionDetail : detailListDetail) {
									// 设置主单合同自编号、合同编号
									if (!StringUtils.isEmpty(ins.getConContract().getContractId())) {
										ConContractVo vo  = contractService.getConContractById(ins.getConContract().getContractId());
										insInspectionBillExcel.setContractCode(vo.getContractCode());
										insInspectionBillExcel.setContractNo(vo.getContractNo());
									}
									// 设置主验货单单号
									if(!StringUtils.isEmpty(ins.getInsInspectionBill().getInspectionBillCode())) {
										insInspectionBillExcel.setInspectionBillCode(ins.getInsInspectionBill().getInspectionBillCode());
									}
									// 设置主验货创建日期
									if(!StringUtils.isEmpty(ins.getInsInspectionBill().getCreateDate())) {
										insInspectionBillExcel.setCreateDate(ins.getInsInspectionBill().getCreateDate());
									}
									// 设置子验货单单号
									if(!StringUtils.isEmpty(insInspectionSub.getSubCode())) {
										insInspectionBillExcel.setSubCode(insInspectionSub.getSubCode());
									}
									// 设置子验货单创建人
									if(!StringUtils.isEmpty(insInspectionSub.getCreateUser())) {
										insInspectionBillExcel.setCreateUser(insInspectionSub.getCreateUser());
									}
									// 设置子验货单入库日期
									if(!StringUtils.isEmpty(insInspectionSub.getInstockDate())) {
										insInspectionBillExcel.setInstockDate(insInspectionSub.getInstockDate());
									}
									// 设置子验货单审核状态
									if(!StringUtils.isEmpty(insInspectionSub.getAuditStatus())) {
										insInspectionBillExcel.setAuditStatus(insInspectionSub.getAuditStatus());
									}
									// 设置子验货单货物材质
									if(!StringUtils.isEmpty(insInspectionDetail.getMaterialId())) {
										insInspectionBillExcel.setMaterialId(insInspectionDetail.getMaterialId());
									}
									// 设置子验货单货物品名
									if (!StringUtils.isEmpty(insInspectionDetail.getProductId())) {
										BaseProduct product = baseService.getBaseProductById(insInspectionDetail.getProductId());
										insInspectionBillExcel.setProductName(product.getProductName());
									}
									// 设置子验货单货物表面
									if(!StringUtils.isEmpty(insInspectionDetail.getSurfaceId())) {
										insInspectionBillExcel.setSurfaceId(insInspectionDetail.getSurfaceId());
									}
									// 设置子验货单货物规格
									if(!StringUtils.isEmpty(insInspectionDetail.getLabelThick()) && !StringUtils.isEmpty(insInspectionDetail.getLabelWidth()) && !StringUtils.isEmpty(insInspectionDetail.getGoodsLength())) {
										insInspectionBillExcel.setSpecification(insInspectionDetail.getLabelThick()+"*"+insInspectionDetail.getLabelWidth()+"*"+insInspectionDetail.getGoodsLength());
									}
									// 设置子验货单货物边部
									if(!StringUtils.isEmpty(insInspectionDetail.getEdge())) {
										insInspectionBillExcel.setEdge(insInspectionDetail.getEdge());
									}
									// 设置子验货单货物参厚
									if(!StringUtils.isEmpty(insInspectionDetail.getReferThick())) {
										insInspectionBillExcel.setReferThick(insInspectionDetail.getReferThick());
									}
									// 设置子验货单货物实宽
									if(!StringUtils.isEmpty(insInspectionDetail.getRealWidth())) {
										insInspectionBillExcel.setRealWidth(insInspectionDetail.getRealWidth());
									}
									// 设置子验货单货物牌号
									if(!StringUtils.isEmpty(insInspectionDetail.getTrademark())) {
										insInspectionBillExcel.setTrademark(insInspectionDetail.getTrademark());
									}
									// 设置子验货单货物卷号
									if(!StringUtils.isEmpty(insInspectionDetail.getGoodsVolume())) {
										insInspectionBillExcel.setVolume(insInspectionDetail.getGoodsVolume());
									}
									// 设置子验货物的数量
									if(insInspectionDetail.getAmount()!=null) {
										insInspectionBillExcel.setAmount(insInspectionDetail.getAmount());
									}
									// 设置子验货物的数量
									if(insInspectionDetail.getNetWeight()!=null) {
										insInspectionBillExcel.setNetWeight(insInspectionDetail.getNetWeight());
									}
									list1.add(insInspectionBillExcel);
								}
							}
						}
						
					}
				}
			}
			
		}
		
		ExportParams params1 = new ExportParams() ;  
        // 设置sheet得名称  
        params1.setSheetName("合同信息"); 
        
        // 创建sheet1使用得map  
        Map dataMap1 = new HashMap<>();  
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName  
        dataMap1.put("title",params1) ;  
        // 模版导出对应得实体类型  
        dataMap1.put("entity",InsInspectionBillExcel.class) ;  
        // sheet中要填充得数据  
        dataMap1.put("data",list1) ;  
        
        // 将sheet1和sheet2使用得map进行包装  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);  
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
	}
	
	
}
