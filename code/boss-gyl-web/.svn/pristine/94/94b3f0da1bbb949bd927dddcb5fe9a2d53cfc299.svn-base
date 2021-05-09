package com.maigangle.gyl.web.controller.contract;

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
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.ConContractDetail;
import com.maigangle.gyl.facade.entity.ConDepositDetail;
import com.maigangle.gyl.facade.entity.ConFeeRates;
import com.maigangle.gyl.facade.entity.ConPaymentDetail;
import com.maigangle.gyl.facade.entity.FeeFinanceBill;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.ConContractDetailDto;
import com.maigangle.gyl.facade.entity.dto.ConContractDto;
import com.maigangle.gyl.facade.entity.dto.ConContractSaveDto;
import com.maigangle.gyl.facade.entity.dto.ConDepositDetailDto;
import com.maigangle.gyl.facade.entity.dto.ConDepositDetailSaveDto;
import com.maigangle.gyl.facade.entity.dto.ConPaymentDetailDto;
import com.maigangle.gyl.facade.entity.dto.ConPaymentDetailSaveDto;
import com.maigangle.gyl.facade.entity.excel.ConContractDetailExcel;
import com.maigangle.gyl.facade.entity.excel.ConContractExcel;
import com.maigangle.gyl.facade.entity.vo.ConContractDetailVo;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.enums.ContractBillStateEnum;
import com.maigangle.gyl.facade.enums.ContractBillTypeEnum;
import com.maigangle.gyl.facade.enums.EdgeTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceFlwoTypeEnum;
import com.maigangle.gyl.facade.enums.FinanceTypeEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.GylBaseService;
import com.maigangle.gyl.facade.service.GylService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

/**
 * 
 * @author 杨思静
 * @since  2018年2月4日 - 下午3:43:46
 * @version 1.0
 */
@Controller
@RequestMapping("/approveContract")
public class ApproveContractController extends GylBaseWeb {

	@Autowired
	private ContractService contractService;
	@Autowired
	private GylService<?> gylService;
	@Autowired
	private GylBaseService gylBaseService;
	@Autowired
	BaseService baseService;
	@Autowired
	private FinanceService financeService;
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/approveContract/approveContractIndex");
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/approveContract/approveContractDetail");
		return modelAndView;
	}
	
	/**
	 * 查询待审批合同带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request, @RequestBody PageUtils<ConContractDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同并分页", "操作人ID为：" + getLoginName(request) + "根据条件获取合同并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<ConContractVo> voPageInfo=contractService.getApproveConContracts(page,true);
			if (voPageInfo != null && voPageInfo.getList() != null && !voPageInfo.getList().isEmpty()) {
				for (ConContractVo vo : voPageInfo.getList()) {
					vo.setAttactList(gylBaseService.getAttach(vo.getContractId()));
					vo.setContractTypeName(ContractBillTypeEnum.getValueByKey(vo.getContractType()));
					vo.setContractStateName(ContractBillStateEnum.getValueByKey(vo.getContractState()));
					vo.setFeeRates(contractService.getConFeeRatesByContractId(vo.getContractId()));
					// 设置甲方
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					if (!StringUtils.isEmpty(vo.getMallMnfct())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMallMnfct());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据生产厂家ID检索生产厂家数据," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
				}
			}
			return AjaxResult.createSuccessResult(voPageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取合同并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}

}
