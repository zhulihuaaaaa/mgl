package com.maigangle.gyl.web.controller.finance;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
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
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.FeeContractBalance;
import com.maigangle.gyl.facade.entity.FeeInvoice;
import com.maigangle.gyl.facade.entity.FeeInvoiceDetail;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.InvoiceDetailDto;
import com.maigangle.gyl.facade.entity.dto.InvoiceGoodsConditionDto;
import com.maigangle.gyl.facade.entity.vo.InvoiceGoodsConditionVo;
import com.maigangle.gyl.facade.entity.vo.InvoiceVo;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

@Controller
@RequestMapping("/invoice")
public class InvoiceController extends GylBaseWeb{
	@Autowired
	private BaseService baseService;
	@Autowired
	private InstockBillService instockBillService;
	@Autowired
	private FinanceService financeService;
	@Autowired
	private RedRedeemBillService redRedeemBillService;
	@Autowired
	private ContractService contractService;
	@Privilege(key = "GYL_INVOICE_VIEW")
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/finance/invoiceIndex");
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/finance/invoiceDetail");
		return modelAndView;
	}
	
	@RequestMapping("/findInInvoices")
	@ResponseBody
	public AjaxResult findInInvoices(HttpServletRequest request,@RequestBody PageUtils<InvoiceGoodsConditionDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询状态为已完成的入库单中没有开过发票的货物", "操作人ID为：" + getLoginName(request) + "查询所有入库单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if(page == null) {
				page = new PageUtils<InvoiceGoodsConditionDto>();
			}
		    PageInfo<InvoiceGoodsConditionVo> pageInfo= instockBillService.getInvoiceGoodsIn(page);
			List<InvoiceGoodsConditionVo> list = pageInfo.getList();
			for(int i=0;i<list.size();i++) {
				InvoiceGoodsConditionVo vo = list.get(i);
					if(!StringUtils.isEmpty(vo.getMnfctId())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMnfctId());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据生产厂家ID检索生产厂家数据," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
					if(!StringUtils.isEmpty(vo.getStorageId())) {
						Map<String, Object> result1 = getDictMallDepot(request, vo.getStorageId());
						if (!(boolean)result1.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result1.get("msg"));
						}
						DictMallDepot dictMallDepot = (DictMallDepot) result1.get("data");
						vo.setStorage(dictMallDepot);
					}
					BaseProduct product = baseService.getBaseProductById(vo.getProductId());
					vo.setProduct(product);
			}
			return AjaxResult.createSuccessResult(pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询状态为已完成的入库单中没有开过发票的货物",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findOutInvoices")
	@ResponseBody
	public AjaxResult findOutInvoices(HttpServletRequest request,@RequestBody PageUtils<InvoiceGoodsConditionDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询提货单中货物", "操作人ID为：" + getLoginName(request) + "查询",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if(page == null) {
				page = new PageUtils<InvoiceGoodsConditionDto>();
			}
		    PageInfo<InvoiceGoodsConditionVo> pageInfo= redRedeemBillService.getInvoiceGoodsOut(page);
			List<InvoiceGoodsConditionVo> list = pageInfo.getList();
			for(int i=0;i<list.size();i++) {
				InvoiceGoodsConditionVo vo = list.get(i);
					if(!StringUtils.isEmpty(vo.getMnfctId())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMnfctId());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据生产厂家ID检索生产厂家数据," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
					if(!StringUtils.isEmpty(vo.getStorageId())) {
						Map<String, Object> result1 = getDictMallDepot(request, vo.getStorageId());
						if (!(boolean)result1.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result1.get("msg"));
						}
						DictMallDepot dictMallDepot = (DictMallDepot) result1.get("data");
						vo.setStorage(dictMallDepot);
					}
					BaseProduct product = baseService.getBaseProductById(vo.getProductId());
					vo.setProduct(product);
			}
			return AjaxResult.createSuccessResult(pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询提货单中货物",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}

	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request,@RequestBody InvoiceVo vo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增出库单", "操作人ID为：" + getLoginName(request) + "新增出库单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			FeeInvoice entity = vo.getEntity();
			
			//创建人
			Map<String, Object> result = getCurrentPrivUser(request);
			PrivUser privUser = (PrivUser) result.get("data");
			entity.setCreateUser(privUser.getUserName());
			
			FeeInvoice feeInvoice = financeService.addInvoice(entity);
			
			List<FeeInvoiceDetail> list =  financeService.addInvoiceDetail(vo.getDetail(),feeInvoice.getInvoiceId());
			if(list !=null && !list.isEmpty()) {
				String contractIds = entity.getContractIds();
				String[] strs = contractIds.split(",");
				for(int i=0,len=strs.length;i<len;i++){
					financeService.addContractBalance(strs[i].toString(), privUser.getUserName());
				}
			}
			//新增明细
			return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS,list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增出库单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request,@RequestBody InvoiceVo vo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新发票记录", "操作人ID为：" + getLoginName(request) + "更新发票记录",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			FeeInvoice entity = vo.getEntity();
			String invoiceId = entity.getInvoiceId();
			int i = financeService.updateFeeInvoice(entity);
			Map<String, Object> result = getCurrentPrivUser(request);
			PrivUser privUser = (PrivUser) result.get("data");
			entity.setCreateUser(privUser.getUserName());
			if(i == 1) {
				List<FeeInvoiceDetail> list = vo.getDetail();
				if(list !=null && !list.isEmpty()) {
					List<FeeInvoiceDetail> oldList = financeService.getInvoiceDetailById(invoiceId);
					// 先删除旧的
					for (FeeInvoiceDetail feeInvoiceDetail : oldList) {
						financeService.deleteInvoiceDetail(feeInvoiceDetail.getInvoiceDetailId());
					}
					// 去除完添加
					List<FeeInvoiceDetail> invoiceDetail = financeService.addInvoiceDetail(vo.getDetail(),invoiceId);
					
					if(invoiceDetail !=null && !invoiceDetail.isEmpty()) {
						String contractIds = entity.getContractIds();
						String[] strs = contractIds.split(",");
						for(int j=0,len=strs.length;j<len;j++){
							contractService.deleteContractBalance(strs[j].toString());
							
							financeService.addContractBalance(strs[j].toString(), privUser.getUserName());
						}
					}
					return AjaxResult.createSuccessResult(entity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新发票记录",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@RequestMapping(value ="/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,@RequestBody PageUtils<InvoiceVo> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取发票列表", "操作人ID为：" + getLoginName(request) + "获取发票列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  查询分页库存页面
			// 正式的逻辑
			PageInfo<FeeInvoice> pageinfo= financeService.getInvoice(page,false);
			return AjaxResult.createSuccessResult(pageinfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取库存管理列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}	
	
	
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取发票详情列表", "操作人ID为：" + getLoginName(request) + "获取发票详情列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			if (!StringUtils.isEmpty(id)) {
				List<FeeInvoiceDetail> detailList = financeService.getInvoiceDetailById(id);
				if(!detailList.isEmpty()) {
					for (int i=0;i<detailList.size();i++) {
						InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
						BeanUtils.copyProperties(detailList.get(i), invoiceDetailDto);
						BaseProduct product = baseService.getBaseProductById(detailList.get(i).getProductId());
						invoiceDetailDto.setProduct(product);
						Map<String, Object> result1 = getDictMallDepot(request, detailList.get(i).getStorageId());
						DictMallDepot dictMallDepot = (DictMallDepot) result1.get("data");
						invoiceDetailDto.setStorage(dictMallDepot);
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, detailList.get(i).getMnfctId());
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						invoiceDetailDto.setMnfct(dictMallMnfct);
						detailList.set(i, invoiceDetailDto);
					}
				}
				return AjaxResult.createSuccessResult(detailList);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据id查询出库货物明细-id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询发票详情",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findInvoice")
	@ResponseBody
	public AjaxResult findInvoice(HttpServletRequest request,@RequestBody String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取发票详情列表", "操作人ID为：" + getLoginName(request) + "获取发票详情列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// TODO 进行相关逻辑编写
			if (!StringUtils.isEmpty(id)) {
				List<FeeInvoice> list = financeService.getInvoiceById(id);
				return AjaxResult.createSuccessResult(list);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据id查询出库货物明细-id为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询发票详情",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
}	
