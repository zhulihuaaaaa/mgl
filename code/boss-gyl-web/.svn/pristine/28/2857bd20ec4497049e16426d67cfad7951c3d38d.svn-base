package com.maigangle.gyl.web.controller.redredeem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.dto.RedRedeemBillDto;
import com.maigangle.gyl.facade.entity.dto.RedRedeemDetailDto;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.GoodsSourceEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;


/**  
 * 结算赎货信息controller
 * @author zlh
 * @since 2017年11月28日 下午3:07:20 
 * @version 1.0 
 */
@Controller
@RequestMapping("/redRedeemBillBalance")
public class RedRedeemBillBalanceController extends GylBaseWeb {
	@Autowired
	RedRedeemBillService redRedeemBillService;
	@Autowired
	InvInventoryService invInventoryService;
	@Autowired
	FinanceService financeService;
	@Autowired
	BaseService baseService;
	
	@Autowired
	ContractService contractService;
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/redRedeem/redRedeemBillBalanceDetail");
		return modelAndView;
	}
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/redRedeem/redRedeemBillBalanceIndex");
		return modelAndView;
	}
	
	
	
	/**
	 * 查询所有赎货单带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request,@RequestBody PageUtils<RedRedeemBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有结算赎货信息的赎货单带分页", "操作人ID为：" + getLoginName(request) + "查询所有结算赎货信息的赎货单带分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			
			RedRedeemBillDto dtopage = page.getDto();
			List<String> goodsSource = new ArrayList<>();
			goodsSource.add(GoodsSourceEnum.CANG_DAN_ZHI_YA.toString());
			List<String> aduits = new ArrayList<>();
			aduits.add(ApprovalStateEnum.APPROVAL_COMPLETE.toString());
			aduits.add(ApprovalStateEnum.APPROVAL_UNDERWAY.toString());
			aduits.add(ApprovalStateEnum.APPROVAL_SUSPEND.toString());
			dtopage.setAuditStatusSearch(aduits);
			dtopage.setGoodsSourceSearch(goodsSource);
			PageInfo<RedRedeemBill> pages = redRedeemBillService.getAllRedRedeemBill(page, true);
			PageInfo<RedRedeemBillDto> pageDto = new PageInfo<RedRedeemBillDto>();
			List<RedRedeemBill> list = pages.getList();
			List<RedRedeemBillDto> listDto = new ArrayList<RedRedeemBillDto>();
			for (RedRedeemBill redRedeemBill : list) {
				RedRedeemBillDto dto = new RedRedeemBillDto();
				BeanUtils.copyProperties(redRedeemBill, dto);
				// 买方
				if(!StringUtils.isEmpty(redRedeemBill.getBuyerId())) {
					Map<String, Object> result = getCrmClient(request, redRedeemBill.getBuyerId());
					if (!(boolean)result.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
					}
					CrmClient crmClient = (CrmClient) result.get("data");
					dto.setBuyerName(crmClient.getClientName());
				}
				//仓库
				if(!StringUtils.isEmpty(redRedeemBill.getStorageId())) {
					Map<String, Object> result1 = getDictMallDepot(request, redRedeemBill.getStorageId());
					if (!(boolean)result1.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result1.get("msg"));
					}
					DictMallDepot dictMallDepot = (DictMallDepot) result1.get("data");
					dto.setDictMallDepot(dictMallDepot);
				}
				ConContractVo  conContractVo = contractService.getConContractById(redRedeemBill.getContractId());
				dto.setContractNo(conContractVo.getContractNo());
				dto.setContractCode(conContractVo.getContractCode());
				
				listDto.add(dto);
			}
			BeanUtils.copyProperties(pages, pageDto);
			pageDto.setList(listDto);
			
			
			return AjaxResult.createSuccessResult(pageDto);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询所有结算赎货信息的赎货单带分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	
	/**
	 * 根据ID查询赎货单
	 * @param request
	 * @param buyerId
	 * @return List
	 */
	@GetMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据赎货ID查询结算赎货信息的赎货单", "操作人ID为：" + getLoginName(request) + "根据赎货ID查询赎货单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<RedRedeemDetail> list = redRedeemBillService.getRedRedeemDetailByBillId(id);
			List<RedRedeemDetailDto> listDto = new ArrayList<RedRedeemDetailDto>();
			for (RedRedeemDetail redRedeemDetail : list) {
				RedRedeemDetailDto dto = new RedRedeemDetailDto();
				BeanUtils.copyProperties(redRedeemDetail, dto);
				//仓库
				if(!StringUtils.isEmpty(redRedeemDetail.getStorageId())) {
					Map<String, Object> result1 = getDictMallDepot(request, redRedeemDetail.getStorageId());
					if (!(boolean)result1.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result1.get("msg"));
					}
					DictMallDepot dictMallDepot = (DictMallDepot) result1.get("data");
					dto.setDictMallDepot(dictMallDepot);
				}
				//制造商
				if(!StringUtils.isEmpty(redRedeemDetail.getMnfctId())) {
					Map<String, Object> result1 = getDictMallMnfct(request, redRedeemDetail.getMnfctId());
					if (!(boolean)result1.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result1.get("msg"));
					}
					DictMallMnfct dictMallMnfct = (DictMallMnfct) result1.get("data");
					dto.setDictMallMnfct(dictMallMnfct);
				}
				// 品名
				if(!StringUtils.isEmpty(redRedeemDetail.getProductId())) {
					BaseProduct baseProduct =  baseService.getBaseProductById(redRedeemDetail.getProductId());
					dto.setBaseProduct(baseProduct);
				}
				
				listDto.add(dto);
				
			}
			
			
			
			return AjaxResult.createSuccessResult(listDto);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据赎货ID查询结算赎货信息的赎货单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}

	
	/**
	 * 更新状态
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_REDREDEEM_BALANCE_EDIT")
	@GetMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request, String id,String status) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新结算赎货信息的赎货单", "操作人ID为：" + getLoginName(request) + "更新赎货单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Boolean flag = redRedeemBillService.doAudit(id, status);
			if(flag) {
				return AjaxResult.createSuccessResultWithCode(MessageCode.OPERATE_SUCCESS, (redRedeemBillService.billWasAudited(id, status))); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新结算赎货信息的赎货单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	

	
	
	
	

}