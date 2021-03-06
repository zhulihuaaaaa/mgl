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
 * ????????????Controller
 * @author ?????????
 * @since 2017???11???28??? ??????7:51:37
 * @varsion 1.0
 */
@Controller
@RequestMapping("/contract")
public class ContractController extends GylBaseWeb {
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
		ModelAndView modelAndView = new ModelAndView("/contract/contractIndex");
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/contract/contractDetail");
		return modelAndView;
	}
	
	/**
	 * ????????????
	 * @param request
	 * @param conContract
	 * @return
	 */
	@Privilege(key = "GYL_CONTRACT_ADD")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request,@RequestBody ConContractSaveDto conContract) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????", "?????????ID??????" + getLoginName(request) + "????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (conContract == null) {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
			}
			if (conContract.getEntity() == null || conContract.getFeeRates() == null || conContract.getFeeRates().isEmpty()) {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
			}
			
			ConContract contract = conContract.getEntity();
			String checkMsg = this.checkObject(contract);
			if (StringUtils.isEmpty(checkMsg)) {
				contract.setContractCode(gylService.generateCode("TB_CON_CONTRACT", contract.getContractType(), contract.getContractType()));
				contract.setCreateDate(new Date());
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				contract.setCreateUser(privUser.getUserName());
				//contract.setContractState(ContractBillStateEnum.UNDERWAY.toString());
				contract.setContractState(ContractBillStateEnum.UNCOMMITE.toString());
				contract = contractService.addConContract(contract);
				
				if (conContract.getAttach() != null && !conContract.getAttach().isEmpty()) {
					for (Attach attach: conContract.getAttach()) {
						attach.setRelationId(contract.getContractId());
						attach.setFileCategory("contract");
						gylBaseService.addAttach(attach);
					}
				}
				List<ConContractDetail> detailList = conContract.getContractDetail();
				if (detailList != null && !detailList.isEmpty() && !StringUtils.isEmpty(contract.getContractId())) {
					for (ConContractDetail detail : detailList) {
						detail.setBuyerId(contract.getBuyerId());
						detail.setSellerId(contract.getSellerId());
						detail.setContractId(contract.getContractId());
						detail.setMnfctId(contract.getMallMnfct());
					}
				}
				detailList = contractService.addConContractDetailBatch(detailList);
				
				List<ConFeeRates> feeRates = conContract.getFeeRates();
				for (ConFeeRates feeRate : feeRates) {
					feeRate.setContractId(contract.getContractId());
					feeRate.setCreateDate(new Date());
					feeRate.setCreateUser(privUser.getUserName());
				}
				feeRates = contractService.addConFeeRatesBatch(feeRates);
				return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS);
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	/**
	 * ?????????????????????
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request, @RequestBody PageUtils<ConContractDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<ConContractVo> voPageInfo = contractService.getConContracts(page, false);
			if (voPageInfo != null && voPageInfo.getList() != null && !voPageInfo.getList().isEmpty()) {
				for (ConContractVo vo : voPageInfo.getList()) {
					vo.setAttactList(gylBaseService.getAttach(vo.getContractId()));
					vo.setContractTypeName(ContractBillTypeEnum.getValueByKey(vo.getContractType()));
					vo.setContractStateName(ContractBillStateEnum.getValueByKey(vo.getContractState()));
					vo.setFeeRates(contractService.getConFeeRatesByContractId(vo.getContractId()));
					// ????????????
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "????????????ID??????????????????," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					if (!StringUtils.isEmpty(vo.getMallMnfct())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMallMnfct());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????ID????????????????????????," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
				}
			}
			return AjaxResult.createSuccessResult(voPageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "?????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * ????????????
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request, @RequestBody PageUtils<ConContractDto> dto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<ConContractVo> list = contractService.getConContracts(dto.getDto(), dto.getOrderByClause(), false);
			if (list != null && !list.isEmpty()) {
				for (ConContractVo vo : list) {
					vo.setContractTypeName(ContractBillTypeEnum.getValueByKey(vo.getContractType()));
					vo.setContractStateName(ContractBillStateEnum.getValueByKey(vo.getContractState()));
					vo.setAttactList(gylBaseService.getAttach(vo.getContractId()));
					vo.setFeeRates(contractService.getConFeeRatesByContractId(vo.getContractId()));
					
					// ????????????
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "????????????ID??????????????????," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					if (!StringUtils.isEmpty(vo.getMallMnfct())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMallMnfct());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????ID????????????????????????," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
					
				}
			}
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * ????????????????????????
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findSelectOptions")
	@ResponseBody
	public AjaxResult findSelectOptions(HttpServletRequest request,@RequestBody JSONObject params) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// ??????????????????????????????
			ConContractDto dto = new ConContractDto();
			if (params != null) {
				dto.setContractCode(params.getString("contractCode"));
				dto.setBuyerId(params.getString("buyerId"));
				dto.setGoodsSource(params.getString("goodsSource"));
				dto.setContractId(params.getString("contractId"));
			}
			return AjaxResult.createSuccessResult(contractService.getConContractForSelect(dto, true));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * ??????ID????????????
	 * @param request
	 * @param contractId
	 * @return
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(id)) {
				ConContractVo vo = contractService.getConContractById(id);
				if (vo != null) {
					vo.setAttactList(gylBaseService.getAttach(vo.getContractId()));
					vo.setContractTypeName(ContractBillTypeEnum.getValueByKey(vo.getContractType()));
					vo.setContractStateName(ContractBillStateEnum.getValueByKey(vo.getContractState()));
					vo.setFeeRates(contractService.getConFeeRatesByContractId(vo.getContractId()));
					List<ConContractDetailVo> detailList = contractService.getConContractDetailsByContractId(id);
					
					if (detailList != null && !detailList.isEmpty()) {
						for (ConContractDetailVo detailVo : detailList) {
							BaseProduct product = baseService.getBaseProductById(detailVo.getProductId());
							detailVo.setProduct(product);
							if (product.getUnitRate() != null) {
								detailVo.setNetWeightDisplay(detailVo.getNetWeight().divide(product.getUnitRate()));
							} else {
								detailVo.setNetWeightDisplay(new BigDecimal(0));
							}
						}
					}
					
					vo.setContractDetail(detailList);
					
					// ????????????
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "????????????ID??????????????????," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					if(!StringUtils.isEmpty(vo.getMallMnfct())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMallMnfct());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????ID????????????????????????," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
					
				}
				return AjaxResult.createSuccessResult(vo);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * ??????Code????????????????????????
	 * @param request
	 * @param contractCode
	 * @return
	 */
	@RequestMapping("/findByCodeContract")
	@ResponseBody
	public AjaxResult findByCodeContract(HttpServletRequest request, String contractCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(contractCode)) {
				return AjaxResult.createSuccessResult(contractService.getConContractByCode(contractCode));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "????????????????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * ??????No????????????????????????
	 * @param request
	 * @param contractNo
	 * @return
	 */
	@RequestMapping("/findByNoContract")
	@ResponseBody
	public AjaxResult findByNoContract(HttpServletRequest request, String contractNo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(contractNo)) {
				return AjaxResult.createSuccessResult(contractService.getConContractByNo(contractNo));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "????????????????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * ????????????
	 * @param request
	 * @param conContract
	 * @return
	 */
	@Privilege(key = "GYL_CONTRACT_EDIT")
	@RequestMapping("/updateContract")
	@ResponseBody
	public AjaxResult updateContract(HttpServletRequest request, @RequestBody ConContractSaveDto conContract) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????", "?????????ID??????" + getLoginName(request) + "????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (conContract != null) {
				if (!StringUtils.isEmpty(conContract.getEntity().getContractId())) {
					
					ConContract contract = contractService.updateConContract(conContract.getEntity());
					List<ConFeeRates> feeRates = contractService.updateConFeeRatesBatch(conContract.getFeeRates());
					// ????????????
					if (conContract.getAttach() != null && !conContract.getAttach().isEmpty()) {
						for (Attach attach: conContract.getAttach()) {
							attach.setRelationId(contract.getContractId());
							attach.setFileCategory("contract");
							gylBaseService.addAttach(attach);
						}
					}
					// ????????????
					if (conContract.getDelDetialId() != null && !conContract.getDelDetialId().isEmpty()) {
						for (String id : conContract.getDelDetialId()) {
							gylBaseService.deleteAttach(id);
						}
					}
					
					if (contract != null && feeRates != null) {
						
						ConContractVo vo = contractService.getConContractById(contract.getContractId());
						if (vo != null) {
							vo.setAttactList(gylBaseService.getAttach(vo.getContractId()));
							vo.setContractTypeName(ContractBillTypeEnum.getValueByKey(vo.getContractType()));
							vo.setContractStateName(ContractBillStateEnum.getValueByKey(vo.getContractState()));
							vo.setFeeRates(contractService.getConFeeRatesByContractId(vo.getContractId()));
							
							// ????????????
							BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
							vo.setSeller(seller);
							Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
							if (!(boolean)resultBuyer.get("isSuccess")) {
								return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "????????????ID??????????????????," + resultBuyer.get("msg"));
							}
							CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
							vo.setBuyer(crmClientBuyer);
							if(!StringUtils.isEmpty(vo.getMallMnfct())) {
								Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMallMnfct());
								if (!(boolean)resultMallMnfct.get("isSuccess")) {
									return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????ID????????????????????????," + resultMallMnfct.get("msg"));
								}
								DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
								vo.setMnfct(dictMallMnfct);
							}
							
						}
						
						return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS, vo);
					} 
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
				} else {
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "??????id????????????");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "??????????????????");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	/**
	 * ????????????(??????)
	 * @param request
	 * @param contractId
	 * @return
	 */
	@Privilege(key = "GYL_CONTRACT_DELETE")
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delectContract(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????", "?????????ID??????" + getLoginName(request) + "????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(id)) {
				return AjaxResult.createSuccessResult(contractService.deleteConContract(id));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "??????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	/**
	 * ???????????????????????????
	 * @param conContract
	 * @return
	 */
	private String checkObject(ConContract conContract) {
		String baseStr = "????????????";
		if (conContract != null) {
			if (StringUtils.isEmpty(conContract.getContractType())) {
				return "????????????" + baseStr;
			}
			if (StringUtils.isEmpty(conContract.getContractNo())) {
				return "????????????" + baseStr;
			} else if (contractService.isContractNoExist(conContract.getContractNo())) {
				return "?????????????????????";
			}
			if (StringUtils.isEmpty(conContract.getSellerId()) || StringUtils.isEmpty(conContract.getBuyerId())) {
				return "?????????????????????";
			}
			if (conContract.getSignDate() == null) {
				return "????????????" + baseStr;
			}
			if (conContract.getContractType().equals(ContractBillTypeEnum.HUO_YA_RONG_ZI.toString()) || 
					conContract.getContractType().equals(ContractBillTypeEnum.DING_XIANG_XIAO_SHOU.toString())) {
				
				if (conContract.getContractPeriod() == null) {
					return "????????????" + baseStr;
				}
				if (conContract.getDepositRate() == null) {
					return "?????????" + baseStr;
				}
				if (conContract.getInvoiceBaseFee() == null) {
					return "?????????" + baseStr;
				}
				
			}
			return "";
		}
		return "????????????????????????";
	}
	@Privilege(key = "GYL_CONTRACT_ADD")
	@RequestMapping("/saveContractDetail")
	@ResponseBody
	public AjaxResult saveContractDetail(HttpServletRequest request, @RequestBody ConContractDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkDetailObject(detail, true);
			if (StringUtils.isEmpty(checkMsg)) {
				// ????????????
				detail = contractService.addConContractDetail(detail);
				if (detail != null) {
					// ????????????
					ConContract contract = contractService.getConContractById(detail.getContractId());
					// ????????????????????????
					if (contract != null) {
						BigDecimal totalWeight = contract.getTotalWeight() == null ? new BigDecimal(0) : contract.getTotalWeight();
						BigDecimal totalMoney = contract.getTotalMoney() == null ? new BigDecimal(0) : contract.getTotalMoney();
						if (detail.getNetWeight() != null ) {
							totalWeight.add(detail.getNetWeight());
							contract.setTotalWeight(totalWeight);
						}
						if (detail.getRealMoney() != null) {
							totalMoney.add(detail.getRealMoney());
							contract.setTotalMoney(totalMoney);
						}
						contract = contractService.updateConContract(contract);
					}
					if (detail != null && contract != null) {
						return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS);
					} else {
						return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
					}
				} else {
					return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);		
	}
	@Privilege(key = "GYL_CONTRACT_ADD")
	@RequestMapping("/saveContractDetails")
	@ResponseBody
	public AjaxResult saveContractDetails(HttpServletRequest request, @RequestBody List<ConContractDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<String> msgs = new ArrayList<>();
			for (int i = 0; i < details.size(); i++) {
				msgs.add(this.checkDetailObject(details.get(i), true));
			}
			if (msgs != null && !msgs.isEmpty()) {
				
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
			} else {
				return AjaxResult.createSuccessResult(contractService.addConContractDetailBatch(details));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);		
	}
	@Privilege(key = "GYL_CONTRACT_EDIT")
	@RequestMapping("/updateContractDetail")
	@ResponseBody
	public AjaxResult updateContractDetail(HttpServletRequest request,@RequestBody ConContractDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String msg = this.checkDetailObject(detail, false);
			if (StringUtils.isEmpty(msg)) {
				ConContractDetail oldDetail = contractService.getConContractDetail(detail.getContractDetailId());
				ConContract contract = contractService.getConContractById(detail.getContractId());
				if (oldDetail != null && contract != null) {
					if (oldDetail.getNetWeight() == null) {
						oldDetail.setNetWeight(new BigDecimal(0));
					}
					if (contract.getTotalWeight() == null) {
						contract.setTotalWeight(new BigDecimal(0));
					}
					if (oldDetail.getRealMoney() == null) {
						oldDetail.setRealMoney(new BigDecimal(0));
					}
					if (contract.getTotalMoney() == null) {
						contract.setTotalMoney(new BigDecimal(0));
					}
				}
				if (detail.getNetWeight() != null) {
					BigDecimal tempWeight = contract.getTotalWeight().subtract(oldDetail.getNetWeight()).add(detail.getNetWeight());
					contract.setTotalWeight(tempWeight);
				}
				if (detail.getRealMoney() != null) {
					BigDecimal tempMoney = contract.getTotalMoney().subtract(oldDetail.getRealMoney()).add(detail.getRealMoney());
					contract.setTotalMoney(tempMoney);
				}
				contract = contractService.updateConContract(contract);
				detail = contractService.updateConContractDetail(detail);
				if (detail != null && contract != null) {
					return AjaxResult.createSuccessResult(detail);
				} else {
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "????????????????????????");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	@Privilege(key = "GYL_CONTRACT_EDIT")
	@RequestMapping("/updateContractDetails")
	@ResponseBody
	public AjaxResult updateContractDetails(HttpServletRequest request, @RequestBody ConContractSaveDto conContract) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (conContract == null || conContract.getEntity() == null || conContract.getContractDetail() == null || conContract.getContractDetail().isEmpty()) {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
			}
			ConContract contract = new ConContract();
			contract.setContractId(conContract.getEntity().getContractId());
			contract.setTotalWeight(conContract.getEntity().getTotalWeight());
			contract.setTotalMoney(conContract.getEntity().getTotalMoney());
			int count = 0;
			for (ConContractDetail detail : conContract.getContractDetail()) {
				if (!StringUtils.isEmpty(detail.getContractDetailId())) {
					detail = contractService.updateConContractDetail(detail);
				} else {
					detail.setContractId(conContract.getEntity().getContractId());
					detail.setMnfctId(conContract.getEntity().getMallMnfct());
					detail.setBuyerId(conContract.getEntity().getBuyerId());
					detail.setSellerId(conContract.getEntity().getSellerId());
					detail = contractService.addConContractDetail(detail);
				}
				if (detail != null) {
					count++;
				}
			}
			if (conContract.getDelDetialId() != null && !conContract.getDelDetialId().isEmpty()) {
				contractService.deteleConContractDetailBatch(conContract.getDelDetialId());
			}
			contract = contractService.updateConContract(contract);
			if (count == conContract.getContractDetail().size() && contract != null) {
				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			}
			return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	@Privilege(key = "GYL_CONTRACT_EDIT")
	@RequestMapping("/deleteContractDetail")
	@ResponseBody
	public AjaxResult deleteContractDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(detailId)) {
				ConContractDetail detail = contractService.getConContractDetail(detailId);
				ConContract contract = contractService.getConContractById(detail.getContractId());
				int count = 0;
				if (detail != null && contract != null) {
					if (contract.getTotalWeight() == null) {
						contract.setTotalWeight(new BigDecimal(0));
					}
					if (contract.getTotalMoney() == null) {
						contract.setTotalMoney(new BigDecimal(0));
					}
					if (detail.getNetWeight() != null) {
						contract.setTotalWeight(contract.getTotalWeight().subtract(detail.getNetWeight()));
					}
					if (detail.getRealMoney() != null) {
						contract.setTotalMoney(contract.getTotalMoney().subtract(detail.getRealMoney()));
					}
					count = contractService.deteleConContractDetail(detailId);
					contract = contractService.updateConContract(contract);
				}
				if (contract != null && count > 0) {
					return AjaxResult.createSuccessResult(contractService.deteleConContractDetail(detailId));
				} else {
					return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "????????????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@Privilege(key = "GYL_CONTRACT_EDIT")
	@RequestMapping("/deleteContractDetails")
	@ResponseBody
	public AjaxResult deleteContractDetails(HttpServletRequest request, @RequestBody List<String> detailIds) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String ids = "";
			if (detailIds != null && !detailIds.isEmpty()) {
				for (int i = 0; i < detailIds.size(); i++) {
					if (StringUtils.isEmpty(detailIds)) {
						ids += i + ",";
					}
				}
				if (StringUtils.isEmpty(ids)) {
					return AjaxResult.createSuccessResult(contractService.deteleConContractDetailBatch(detailIds));
				} else {
					ids = ids.substring(0, ids.length() - 1);
					return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "???????????????"+ ids +"???id????????????");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "????????????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPageContractDetails")
	@ResponseBody
	public AjaxResult findPageContractDetails(HttpServletRequest request, @RequestBody PageUtils<ConContractDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<ConContractDetailVo> list = contractService.getConContractDetails(page, false);
			if (list != null && list.getList() != null && !list.getList().isEmpty()) {
				for (ConContractDetailVo vo : list.getList()) {
					vo.setContract(contractService.getConContractById(vo.getContractId()));
					vo.setProduct(baseService.getBaseProductById(vo.getProductId()));
					vo.setEdgeName(EdgeTypeEnum.getValueByKey(vo.getEdge()).toString());
					vo.setProcess(baseService.getBaseProcess(vo.getSurfaceId()));
					
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "????????????ID??????????????????," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					if (!StringUtils.isEmpty(vo.getMnfctId())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMnfctId());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????ID????????????????????????," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
				}
			}
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findAllContractDetails")
	@ResponseBody
	public AjaxResult findAllContractDetails(HttpServletRequest request, @RequestBody PageUtils<ConContractDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<ConContractDetailVo> list = contractService.getConContractDetails(page.getDto(), page.getOrderByClause(), false);
			if (list != null && !list.isEmpty()) {
				for (ConContractDetailVo vo : list ) {
					vo.setContract(contractService.getConContractById(vo.getContractId()));
					BaseProduct product = baseService.getBaseProductById(vo.getProductId());
					vo.setProduct(product);
					vo.setProcess(baseService.getBaseProcess(vo.getSurfaceId()));
					vo.setEdgeName(EdgeTypeEnum.getValueByKey(vo.getEdge()).toString());
					if (product.getUnitRate() != null) {
						vo.setNetWeightDisplay(vo.getNetWeight().divide(product.getUnitRate()));
					} else {
						vo.setNetWeightDisplay(new BigDecimal(0));
					}
					// ????????????
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "????????????ID??????????????????," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					// ????????????
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					if (!StringUtils.isEmpty(vo.getMnfctId())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMnfctId());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????ID????????????????????????," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
				}
			}
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findOneContractDetail")
	@ResponseBody
	public AjaxResult findOneContractDetail(HttpServletRequest request, String detailID) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConContractDetail(detailID));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}	
	
	/**
	 * ????????????
	 * @param entity
	 * @return
	 */
	private String checkDetailObject(ConContractDetail entity, boolean isIgnoreId) {
		if (entity == null) {
			return "??????????????????????????????";
		}
		String baseStr = "????????????";
		if (!isIgnoreId) {
			if (StringUtils.isEmpty(entity.getContractDetailId())) {
				return "????????????ID" + baseStr;
			}
		}
		if (StringUtils.isEmpty(entity.getContractId())) {
			return "??????ID" + baseStr;
		}
		return "";
	}
	
	@RequestMapping("/saveDepositDetail")
	@ResponseBody
	public AjaxResult saveDepositDetail(HttpServletRequest request, @RequestBody ConDepositDetailSaveDto detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkDepositDetail(detail, true);
			if (StringUtils.isEmpty(checkMsg)) {
				// ???????????????
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				String createUser = privUser.getUserName();
				// ?????????????????????
				FeeFinanceBill financeBill = new FeeFinanceBill();
				financeBill.setBusinessType(FinanceTypeEnum.ZHUI_JIA_BAO_ZHENG_JIN.toString());
				financeBill.setContractId(detail.getContractId());
				financeBill.setContractCode(detail.getContractCode());
				financeBill.setRelationCode(detail.getContractCode());
				financeBill.setTotalMoney(detail.getMoney());
				financeBill.setRealMoney(detail.getMoney());
				financeBill.setActualAmount(new BigDecimal(0));
				financeBill.setCreateDate(new Date());
				financeBill.setFlwoType(FinanceFlwoTypeEnum.JIN_ZHANG.toString());
				financeBill = financeService.addFinanceBill(financeBill);
				
				if (financeBill == null) {
					return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
				}
				
				// ?????????????????????
				ConDepositDetail depositDetail = null;
				if (financeBill != null) {
					detail.setCreateDate(new Date());
					detail.setCreateUser(createUser);
					detail.setFinanceId(financeBill.getFinanceBillId());
					depositDetail = contractService.addConDepositDetail(detail);
				}
				
				if (depositDetail != null) {
					financeBill.setRelationId(depositDetail.getFinanceId());
					financeService.updateFinaceBill(financeBill);
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, depositDetail);
				} else {
					return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@RequestMapping("/saveDepositDetails")
	@ResponseBody
	public AjaxResult saveDepositDetails(HttpServletRequest request, @RequestBody List<ConDepositDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (details == null || details.isEmpty()) {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "????????????????????????????????????????????????");
			}
			List<String> msgs = new ArrayList<>();
			for (int i = 0; i < details.size(); i++) {
				msgs.add(this.checkDepositDetail(details.get(i), true));
			}
			if (msgs != null && !msgs.isEmpty()) {
				
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
			} else {
				return AjaxResult.createSuccessResult(contractService.addConDepositDetailBatch(details));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "?????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);		
	}
	
	@RequestMapping("/updateDepositDetail")
	@ResponseBody
	public AjaxResult updateDepositDetail(HttpServletRequest request, @RequestBody ConDepositDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String msg = this.checkDepositDetail(detail, true);
			if (!StringUtils.isEmpty(msg)) {
				return AjaxResult.createSuccessResult(contractService.updateConDepositDetail(detail));
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "????????????????????????");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}

	@RequestMapping("/updateDepositDetails")
	@ResponseBody
	public AjaxResult updateDepositDetails(HttpServletRequest request, @RequestBody List<ConDepositDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (details != null && !details.isEmpty()) {
				List<String> msgs = new ArrayList<>();
				for (int i = 0; i < details.size(); i++) {
					msgs.add(this.checkDepositDetail(details.get(i), true));
				}
				if (msgs != null && !msgs.isEmpty()) {
					return AjaxResult.createSuccessResult(contractService.updateConDepositDetailBatch(details));
				} else {
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "?????????????????????id????????????");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "?????????????????????????????????");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "?????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	@RequestMapping("/deleteDepositDetail")
	@ResponseBody
	public AjaxResult deleteDepositDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(detailId)) {
				return AjaxResult.createSuccessResult(contractService.deleteConDepositDetail(detailId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "?????????????????????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/deleteDepositDetails")
	@ResponseBody
	public AjaxResult deleteDepositDetails(HttpServletRequest request, @RequestBody List<String> detailIds) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String ids = "";
			if (detailIds != null && !detailIds.isEmpty()) {
				for (int i = 0; i < detailIds.size(); i++) {
					if (StringUtils.isEmpty(detailIds)) {
						ids += i + ",";
					}
				}
				if (StringUtils.isEmpty(ids)) {
					return AjaxResult.createSuccessResult(contractService.deleteConDepositDetailBatch(detailIds));
				} else {
					ids = ids.substring(0, ids.length() - 1);
					return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "???????????????????????????"+ ids +"???id????????????");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "?????????????????????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "?????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPageDepositDetails")
	@ResponseBody
	public AjaxResult findPageDepositDetails(HttpServletRequest request, @RequestBody PageUtils<ConDepositDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConDepositDetails(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findAllDepositDetails")
	@ResponseBody
	public AjaxResult findAllDepositDetails(HttpServletRequest request, @RequestBody PageUtils<ConDepositDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConDepositDetails(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findOneDepositDetail")
	@ResponseBody
	public AjaxResult findOneDepositDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(detailId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "?????????????????????id????????????");	
			} else {
				return AjaxResult.createSuccessResult(contractService.getConDepositDetail(detailId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * ???????????????
	 * @param dto
	 * @param isIgnoreId
	 * @return
	 */
	private String checkDepositDetail(ConDepositDetail entity, boolean isIgnoreId) {
		if (entity == null) {
			return "???????????????????????????????????????";
		}
		String baseStr = "????????????";
		if (!isIgnoreId) {
			if (StringUtils.isEmpty(entity.getContractId())) {
				return "?????????????????????id" + baseStr;
			}
		}
		if (StringUtils.isEmpty(entity.getContractId())) {
			return "??????id" + baseStr;
		}
		if (entity.getMoney() == null) {
			return "?????????????????????" + baseStr;
		}
		return "";
	}
	
	@RequestMapping("/savePaymentDetail")
	@ResponseBody
	public AjaxResult savePaymentDetail(HttpServletRequest request, @RequestBody ConPaymentDetailSaveDto detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkPaymentDetail(detail, true);
			if (StringUtils.isEmpty(checkMsg)) {
				FeeFinanceBill financeBill = new FeeFinanceBill();
				financeBill.setBusinessType(FinanceTypeEnum.ZHUI_JIA_HUO_KUAN.toString());
				financeBill.setContractId(detail.getContractId());
				financeBill.setContractCode(detail.getContractCode());
				financeBill.setRelationCode(detail.getContractCode());
				financeBill.setTotalMoney(detail.getMoney());
				financeBill.setRealMoney(detail.getMoney());
				financeBill.setActualAmount(new BigDecimal(0));
				financeBill.setCreateDate(new Date());
				financeBill.setFlwoType(FinanceFlwoTypeEnum.JIN_ZHANG.toString());
				
				financeBill = financeService.addFinanceBill(financeBill);
				
				if (financeBill == null) {
					return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
				}
				
				ConPaymentDetail paymentDetail = null;
				if (financeBill != null) {
					detail.setCreateDate(new Date());
					Map<String, Object> result = getCurrentPrivUser(request);
					if (!(boolean)result.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result.get("msg"));
					}
					PrivUser privUser = (PrivUser) result.get("data");
					detail.setCreateUser(privUser.getUserName());
					detail.setFinanceId(financeBill.getFinanceBillId());
					paymentDetail = contractService.addConPaymentDetail(detail);
				}
				if (paymentDetail != null) {
					financeBill.setRelationId(paymentDetail.getPaymentDetailId());
					financeService.updateFinaceBill(financeBill);
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS);
				} else {
					return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
				}
				
			} else {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);	
	}
	
	@RequestMapping("/savePaymentDetails")
	@ResponseBody
	public AjaxResult savePaymentDetails(HttpServletRequest request, @RequestBody List<ConPaymentDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<String> msgs = new ArrayList<>();
			for (int i = 0; i < details.size(); i++) {
				msgs.add(this.checkPaymentDetail(details.get(i), true));
			}
			if (msgs != null && !msgs.isEmpty()) {
				
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
			} else {
				return AjaxResult.createSuccessResult(contractService.addConPaymentDetailBatch(details));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@RequestMapping("/updatePaymentDetail")
	@ResponseBody
	public AjaxResult updatePaymentDetail(HttpServletRequest request, @RequestBody ConPaymentDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String msg = this.checkPaymentDetail(detail, false);
			if (!StringUtils.isEmpty(msg)) {
				return AjaxResult.createSuccessResult(contractService.updateConPaymentDetail(detail));
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "????????????????????????");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	@RequestMapping("/updatePaymentDetails")
	@ResponseBody
	public AjaxResult updatePaymentDetails(HttpServletRequest request, @RequestBody List<ConPaymentDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (details != null) {
				List<String> msgs = new ArrayList<>();
				for (int i = 0; i < details.size(); i++) {
					msgs.add(this.checkPaymentDetail(details.get(i), true));
				}
				if (msgs != null && !msgs.isEmpty()) {
					return AjaxResult.createSuccessResult(contractService.updateConPaymentDetailBatch(details));
				} else {
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "?????????????????????id????????????");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "??????????????????????????????");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	@RequestMapping("/deletePaymentDetail")
	@ResponseBody
	public AjaxResult deletePaymentDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(detailId)) {
				return AjaxResult.createSuccessResult(contractService.deleteConPaymentDetail(detailId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "??????????????????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);		
	}
	
	@RequestMapping("/deletePaymentDetails")
	@ResponseBody
	public AjaxResult deletePaymentDetails(HttpServletRequest request, @RequestBody List<String> detailIds) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String ids = "";
			if (detailIds != null && !detailIds.isEmpty()) {
				for (int i = 0; i < detailIds.size(); i++) {
					if (StringUtils.isEmpty(detailIds)) {
						ids += i + ",";
					}
				}
				if (StringUtils.isEmpty(ids)) {
					return AjaxResult.createSuccessResult(contractService.deleteConPaymentDetailBatch(detailIds));
				} else {
					ids = ids.substring(0, ids.length() - 1);
					return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "????????????????????????"+ ids +"???id????????????");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "??????????????????id????????????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPagePaymentDetails")
	@ResponseBody
	public AjaxResult findPagePaymentDetails(HttpServletRequest request, @RequestBody PageUtils<ConPaymentDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "?????????????????????????????????", "?????????ID??????" + getLoginName(request) + "?????????????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConPaymentDetails(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "?????????????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findAllPaymentDetails")
	@ResponseBody
	public AjaxResult findAllPaymentDetails(HttpServletRequest request, @RequestBody PageUtils<ConPaymentDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConPaymentDetails(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findOnePaymentDetail")
	@ResponseBody
	public AjaxResult findOnePaymentDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(detailId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????id????????????");	
			} else {
				return AjaxResult.createSuccessResult(contractService.getConPaymentDetail(detailId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: overContract 
	 * @Description: ( ???????????? ) 
	 * @param request
	 * @param contractId
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/overContract")
	@ResponseBody
	public AjaxResult overContract(HttpServletRequest request, String contractId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????", "?????????ID??????" + getLoginName(request) + "????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			try {
				contractService.overContract(contractId);				
			}catch (Exception e) {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);		
			}
			ConContract con = new ConContract();
			con.setContractId(contractId);
			con.setContractState(ContractBillStateEnum.CLOSE.toString());
			con = contractService.updateConContract(con);
			if(con==null) {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);		
			}else {
				return AjaxResult.createSuccessResult(con);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);		
	}
	
	
	
	
	
	
	/**
	 * ????????????
	 * @param dto
	 * @return
	 */
	public String checkPaymentDetail(ConPaymentDetail detail,  boolean isIgnoreId) {
		if (detail == null) {
			return "????????????????????????????????????";
		}
		if (!isIgnoreId) {
			if (StringUtils.isEmpty(detail.getPaymentDetailId())) {
				return "??????????????????id????????????";
			}
		}
		if (StringUtils.isEmpty(detail.getContractId())) {
			return "????????????id????????????";
		}
		if (detail.getMoney() == null) {
			return "??????????????????";
		}
		return "";
	}
	
	/**
	 * ????????????Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_CONTRACT_EXCEL")
	@RequestMapping("/exportExcel")
	@ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ???????????????????????????????????????????????????
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// ???????????????????????????
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("???????????????","UTF-8") + ".xls");
		//??????
		response.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");
		String orderByClause = null;
		ConContractDto dto = null;
		if (!StringUtils.isEmpty(param)) {
			JSONObject paramObj = JSONObject.parseObject(param);
			orderByClause = paramObj.getString("orderByClause");
			dto = paramObj.getObject("dto", ConContractDto.class);
		} else {
			dto = new ConContractDto();
		}
		
		List<ConContractExcel> list1 = new ArrayList<ConContractExcel>();
		List<ConContractDetailExcel> list2 = new ArrayList<ConContractDetailExcel>();
		
		//????????????
		List<ConContractVo> list = contractService.getConContracts(dto, orderByClause, false);
		if (list != null && !list.isEmpty()) {
			for (ConContractVo vo : list) {
				ConContractExcel conContractExcel = new ConContractExcel();
				BeanUtils.copyProperties(vo, conContractExcel);
				String contractCode = vo.getContractCode();
				String contractNo = vo.getContractNo();
				// ????????????
				if(!StringUtils.isEmpty(vo.getSellerId())) {
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					conContractExcel.setSellerName(seller.getCompanyName());
				}
				if(!StringUtils.isEmpty(vo.getBuyerId())) {
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					conContractExcel.setBuyerName(crmClientBuyer.getClientName());
				}
				if (!StringUtils.isEmpty(vo.getMallMnfct())) {
					Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMallMnfct());
					DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
					vo.setMnfct(dictMallMnfct);
					conContractExcel.setMallMnfct(dictMallMnfct.getMnfctName());
				}
				list1.add(conContractExcel);
				
				//????????????
				List<ConContractDetailVo> detailList = contractService.getConContractDetailsByContractId(vo.getContractId());
				if(detailList != null && !detailList.isEmpty()) {
					for (ConContractDetailVo conContractDetailVo : detailList) {
						ConContractDetailExcel conContractDetailExcel = new ConContractDetailExcel();
						conContractDetailExcel.setContractCode(contractCode);
						conContractDetailExcel.setContractNo(contractNo);
						BeanUtils.copyProperties(conContractDetailVo,conContractDetailExcel);
						if(!StringUtils.isEmpty(conContractDetailVo.getProductId())) {
							BaseProduct product = baseService.getBaseProductById(conContractDetailVo.getProductId());
							conContractDetailExcel.setProductName(product.getProductName());
						}
						if(!StringUtils.isEmpty(conContractDetailVo.getLabelThick()) && !StringUtils.isEmpty(conContractDetailVo.getLabelWidth()) && !StringUtils.isEmpty(conContractDetailVo.getGoodsLength())) {
							conContractDetailExcel.setSpecification(conContractDetailVo.getLabelThick()+"*"+conContractDetailVo.getLabelWidth()+"*"+conContractDetailVo.getGoodsLength());;
						}
						if(!StringUtils.isEmpty(conContractDetailVo.getAmount())) {
							BaseProduct product = baseService.getBaseProductById(conContractDetailVo.getProductId());
							conContractDetailExcel.setAmount(conContractDetailVo.getAmount() + product.getQuantityUnit());
						}
						if(!StringUtils.isEmpty(conContractDetailVo.getNetWeight())) {
							BaseProduct product = baseService.getBaseProductById(conContractDetailVo.getProductId());
							conContractDetailExcel.setNetWeight(conContractDetailVo.getNetWeight().divide(product.getUnitRate(), product.getPrecision().intValue(), BigDecimal.ROUND_HALF_DOWN).toString());
							conContractDetailExcel.setNetWeight(conContractDetailExcel.getNetWeight() + product.getWeightUnit());
						}
						if(!StringUtils.isEmpty(conContractDetailVo.getUnitContractPrice())) {
							BaseProduct product = baseService.getBaseProductById(conContractDetailVo.getProductId());
							conContractDetailExcel.setUnitContractPrice(conContractDetailVo.getUnitContractPrice() +"???/"+ product.getWeightUnit());
						}
						list2.add(conContractDetailExcel);
					}
				}
			}
			
		}
		
		ExportParams params1 = new ExportParams() ;  
        // ??????sheet?????????  
        params1.setSheetName("????????????"); 
        
        ExportParams params2 = new ExportParams() ;  
        params2.setSheetName("????????????") ;  
        // ??????sheet1?????????map  
        Map dataMap1 = new HashMap<>();  
        // title????????????ExportParams????????????????????????ExportParams????????????sheetName  
        dataMap1.put("title",params1) ;  
        // ?????????????????????????????????  
        dataMap1.put("entity",ConContractExcel.class) ;  
        // sheet?????????????????????  
        dataMap1.put("data",list1) ;  
        
        // ??????sheet2?????????map  
        Map dataMap2 = new HashMap<>();  
        dataMap2.put("title",params2);  
        dataMap2.put("entity",ConContractDetailExcel.class);  
        dataMap2.put("data",list2);  
        
        // ???sheet1???sheet2?????????map????????????  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);  
        sheetsList.add(dataMap2);
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
	}
	
}
