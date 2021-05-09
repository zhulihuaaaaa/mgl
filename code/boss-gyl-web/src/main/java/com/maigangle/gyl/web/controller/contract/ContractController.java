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
 * 合同相关Controller
 * @author 汪玮琦
 * @since 2017年11月28日 下午7:51:37
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
	 * 新增合同
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
			super.logInfo(request, logBatch, "新增合同", "操作人ID为：" + getLoginName(request) + "新增合同",
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
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
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
			super.logError(request, logBatch, "新增合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	/**
	 * 查询合同带分页
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
			PageInfo<ConContractVo> voPageInfo = contractService.getConContracts(page, false);
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
	
	/**
	 * 查询合同
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request, @RequestBody PageUtils<ConContractDto> dto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同", "操作人ID为：" + getLoginName(request) + "根据条件获取合同",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			List<ConContractVo> list = contractService.getConContracts(dto.getDto(), dto.getOrderByClause(), false);
			if (list != null && !list.isEmpty()) {
				for (ConContractVo vo : list) {
					vo.setContractTypeName(ContractBillTypeEnum.getValueByKey(vo.getContractType()));
					vo.setContractStateName(ContractBillStateEnum.getValueByKey(vo.getContractState()));
					vo.setAttactList(gylBaseService.getAttach(vo.getContractId()));
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
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 查询合同为了下拉
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findSelectOptions")
	@ResponseBody
	public AjaxResult findSelectOptions(HttpServletRequest request,@RequestBody JSONObject params) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同", "操作人ID为：" + getLoginName(request) + "根据条件获取合同",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			// 根据条件创建查询实体
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
			super.logError(request, logBatch, "根据条件获取合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 根据ID查询合同
	 * @param request
	 * @param contractId
	 * @return
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同", "操作人ID为：" + getLoginName(request) + "根据条件获取合同",
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
					
					// 设置甲方
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					if(!StringUtils.isEmpty(vo.getMallMnfct())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMallMnfct());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据生产厂家ID检索生产厂家数据," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
					
				}
				return AjaxResult.createSuccessResult(vo);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "合同id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 根据Code合同单号查询合同
	 * @param request
	 * @param contractCode
	 * @return
	 */
	@RequestMapping("/findByCodeContract")
	@ResponseBody
	public AjaxResult findByCodeContract(HttpServletRequest request, String contractCode) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同", "操作人ID为：" + getLoginName(request) + "根据条件获取合同",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(contractCode)) {
				return AjaxResult.createSuccessResult(contractService.getConContractByCode(contractCode));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "合同单号不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 根据No合同编号查询合同
	 * @param request
	 * @param contractNo
	 * @return
	 */
	@RequestMapping("/findByNoContract")
	@ResponseBody
	public AjaxResult findByNoContract(HttpServletRequest request, String contractNo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同", "操作人ID为：" + getLoginName(request) + "根据条件获取合同",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(contractNo)) {
				return AjaxResult.createSuccessResult(contractService.getConContractByNo(contractNo));
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "合同编号不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 更新合同
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
			super.logInfo(request, logBatch, "更新合同", "操作人ID为：" + getLoginName(request) + "更新合同",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (conContract != null) {
				if (!StringUtils.isEmpty(conContract.getEntity().getContractId())) {
					
					ConContract contract = contractService.updateConContract(conContract.getEntity());
					List<ConFeeRates> feeRates = contractService.updateConFeeRatesBatch(conContract.getFeeRates());
					// 保存附件
					if (conContract.getAttach() != null && !conContract.getAttach().isEmpty()) {
						for (Attach attach: conContract.getAttach()) {
							attach.setRelationId(contract.getContractId());
							attach.setFileCategory("contract");
							gylBaseService.addAttach(attach);
						}
					}
					// 删除附件
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
							
							// 设置甲方
							BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
							vo.setSeller(seller);
							Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
							if (!(boolean)resultBuyer.get("isSuccess")) {
								return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
							}
							CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
							vo.setBuyer(crmClientBuyer);
							if(!StringUtils.isEmpty(vo.getMallMnfct())) {
								Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMallMnfct());
								if (!(boolean)resultMallMnfct.get("isSuccess")) {
									return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据生产厂家ID检索生产厂家数据," + resultMallMnfct.get("msg"));
								}
								DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
								vo.setMnfct(dictMallMnfct);
							}
							
						}
						
						return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS, vo);
					} 
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
				} else {
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "合同id不能为空");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "合同不能为空");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	/**
	 * 删除合同(假删)
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
			super.logInfo(request, logBatch, "删除合同", "操作人ID为：" + getLoginName(request) + "删除合同",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(id)) {
				return AjaxResult.createSuccessResult(contractService.deleteConContract(id));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "合同id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	/**
	 * 检测必填项是否为空
	 * @param conContract
	 * @return
	 */
	private String checkObject(ConContract conContract) {
		String baseStr = "不能为空";
		if (conContract != null) {
			if (StringUtils.isEmpty(conContract.getContractType())) {
				return "业务类型" + baseStr;
			}
			if (StringUtils.isEmpty(conContract.getContractNo())) {
				return "合同编号" + baseStr;
			} else if (contractService.isContractNoExist(conContract.getContractNo())) {
				return "合同编号已存在";
			}
			if (StringUtils.isEmpty(conContract.getSellerId()) || StringUtils.isEmpty(conContract.getBuyerId())) {
				return "客户信息不正确";
			}
			if (conContract.getSignDate() == null) {
				return "签订日期" + baseStr;
			}
			if (conContract.getContractType().equals(ContractBillTypeEnum.HUO_YA_RONG_ZI.toString()) || 
					conContract.getContractType().equals(ContractBillTypeEnum.DING_XIANG_XIAO_SHOU.toString())) {
				
				if (conContract.getContractPeriod() == null) {
					return "合同期限" + baseStr;
				}
				if (conContract.getDepositRate() == null) {
					return "保证金" + baseStr;
				}
				if (conContract.getInvoiceBaseFee() == null) {
					return "开票费" + baseStr;
				}
				
			}
			return "";
		}
		return "合同对象不能为空";
	}
	@Privilege(key = "GYL_CONTRACT_ADD")
	@RequestMapping("/saveContractDetail")
	@ResponseBody
	public AjaxResult saveContractDetail(HttpServletRequest request, @RequestBody ConContractDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增合同明细", "操作人ID为：" + getLoginName(request) + "新增合同明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkDetailObject(detail, true);
			if (StringUtils.isEmpty(checkMsg)) {
				// 保存明细
				detail = contractService.addConContractDetail(detail);
				if (detail != null) {
					// 获取合同
					ConContract contract = contractService.getConContractById(detail.getContractId());
					// 判断合同是否为空
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
			super.logError(request, logBatch, "新增合同明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
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
			super.logInfo(request, logBatch, "批量新增合同明细", "操作人ID为：" + getLoginName(request) + "批量新增合同明细",
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
			super.logError(request, logBatch, "批量新增合同明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
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
			super.logInfo(request, logBatch, "更新合同明细", "操作人ID为：" + getLoginName(request) + "更新合同明细",
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
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "合同明细不能为空");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新合同明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
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
			super.logInfo(request, logBatch, "批量更新合同明细", "操作人ID为：" + getLoginName(request) + "批量更新合同明细",
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
			super.logError(request, logBatch, "批量更新合同明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
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
			super.logInfo(request, logBatch, "删除合同明细", "操作人ID为：" + getLoginName(request) + "删除合同明细",
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
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "合同明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除合同明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
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
			super.logInfo(request, logBatch, "删除合同明细", "操作人ID为：" + getLoginName(request) + "删除合同明细",
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
					return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "合同明细第"+ ids +"条id不能为空");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "合同明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除合同明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPageContractDetails")
	@ResponseBody
	public AjaxResult findPageContractDetails(HttpServletRequest request, @RequestBody PageUtils<ConContractDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同明细并分页", "操作人ID为：" + getLoginName(request) + "根据条件获取合同明细并分页",
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
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					if (!StringUtils.isEmpty(vo.getMnfctId())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMnfctId());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据生产厂家ID检索生产厂家数据," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
				}
			}
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取合同明细并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findAllContractDetails")
	@ResponseBody
	public AjaxResult findAllContractDetails(HttpServletRequest request, @RequestBody PageUtils<ConContractDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同明细", "操作人ID为：" + getLoginName(request) + "根据条件获取合同明细",
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
					// 设置乙方
					Map<String, Object> resultBuyer = getCrmClient(request, vo.getBuyerId());
					if (!(boolean)resultBuyer.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据客户ID获取客户对象," + resultBuyer.get("msg"));
					}
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					vo.setBuyer(crmClientBuyer);
					// 设置甲方
					BaseCompany seller = baseService.getBaseCompany(vo.getSellerId());
					vo.setSeller(seller);
					if (!StringUtils.isEmpty(vo.getMnfctId())) {
						Map<String, Object> resultMallMnfct = getDictMallMnfct(request, vo.getMnfctId());
						if (!(boolean)resultMallMnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据生产厂家ID检索生产厂家数据," + resultMallMnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
						vo.setMnfct(dictMallMnfct);
					}
				}
			}
			return AjaxResult.createSuccessResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取合同明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findOneContractDetail")
	@ResponseBody
	public AjaxResult findOneContractDetail(HttpServletRequest request, String detailID) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据条件获取合同明细", "操作人ID为：" + getLoginName(request) + "根据条件获取合同明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConContractDetail(detailID));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据条件获取合同明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}	
	
	/**
	 * 检测非空
	 * @param entity
	 * @return
	 */
	private String checkDetailObject(ConContractDetail entity, boolean isIgnoreId) {
		if (entity == null) {
			return "合同明细实体不能为空";
		}
		String baseStr = "不能为空";
		if (!isIgnoreId) {
			if (StringUtils.isEmpty(entity.getContractDetailId())) {
				return "合同明细ID" + baseStr;
			}
		}
		if (StringUtils.isEmpty(entity.getContractId())) {
			return "合同ID" + baseStr;
		}
		return "";
	}
	
	@RequestMapping("/saveDepositDetail")
	@ResponseBody
	public AjaxResult saveDepositDetail(HttpServletRequest request, @RequestBody ConDepositDetailSaveDto detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增追加保证金明细", "操作人ID为：" + getLoginName(request) + "新增追加保证金明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkDepositDetail(detail, true);
			if (StringUtils.isEmpty(checkMsg)) {
				// 当前用户名
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				String createUser = privUser.getUserName();
				// 新增一条财务单
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
				
				// 创建追加保证金
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
			super.logError(request, logBatch, "新增追加保证金明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@RequestMapping("/saveDepositDetails")
	@ResponseBody
	public AjaxResult saveDepositDetails(HttpServletRequest request, @RequestBody List<ConDepositDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量新增追加保证金明细", "操作人ID为：" + getLoginName(request) + "批量新增追加保证金明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (details == null || details.isEmpty()) {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "需要保存的追加保证金明细实体为空");
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
			super.logError(request, logBatch, "批量新增追加保证金明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);		
	}
	
	@RequestMapping("/updateDepositDetail")
	@ResponseBody
	public AjaxResult updateDepositDetail(HttpServletRequest request, @RequestBody ConDepositDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新追加保证金明细", "操作人ID为：" + getLoginName(request) + "更新追加保证金明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String msg = this.checkDepositDetail(detail, true);
			if (!StringUtils.isEmpty(msg)) {
				return AjaxResult.createSuccessResult(contractService.updateConDepositDetail(detail));
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "合同明细不能为空");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新追加保证金明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}

	@RequestMapping("/updateDepositDetails")
	@ResponseBody
	public AjaxResult updateDepositDetails(HttpServletRequest request, @RequestBody List<ConDepositDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量更新追加保证金明细", "操作人ID为：" + getLoginName(request) + "批量更新追加保证金明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (details != null && !details.isEmpty()) {
				List<String> msgs = new ArrayList<>();
				for (int i = 0; i < details.size(); i++) {
					msgs.add(this.checkDepositDetail(details.get(i), true));
				}
				if (msgs != null && !msgs.isEmpty()) {
					return AjaxResult.createSuccessResult(contractService.updateConDepositDetailBatch(details));
				} else {
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "追加保证金明细id不能为空");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "追加保证金明细不能为空");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "批量更新追加保证金明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	@RequestMapping("/deleteDepositDetail")
	@ResponseBody
	public AjaxResult deleteDepositDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除追加保证金明细", "操作人ID为：" + getLoginName(request) + "删除追加保证金明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(detailId)) {
				return AjaxResult.createSuccessResult(contractService.deleteConDepositDetail(detailId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "追加保证金明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除追加保证金明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/deleteDepositDetails")
	@ResponseBody
	public AjaxResult deleteDepositDetails(HttpServletRequest request, @RequestBody List<String> detailIds) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量删除追加保证金明细", "操作人ID为：" + getLoginName(request) + "批量删除追加保证金明细",
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
					return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "追加保证金明细细第"+ ids +"条id不能为空");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "追加保证金明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "批量删除追加保证金明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPageDepositDetails")
	@ResponseBody
	public AjaxResult findPageDepositDetails(HttpServletRequest request, @RequestBody PageUtils<ConDepositDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询追加保证金明细并分页", "操作人ID为：" + getLoginName(request) + "查询追加保证金明细并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConDepositDetails(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询追加保证金明细并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findAllDepositDetails")
	@ResponseBody
	public AjaxResult findAllDepositDetails(HttpServletRequest request, @RequestBody PageUtils<ConDepositDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询追加保证金明细", "操作人ID为：" + getLoginName(request) + "查询追加保证金明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConDepositDetails(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询追加保证金明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	@RequestMapping("/findOneDepositDetail")
	@ResponseBody
	public AjaxResult findOneDepositDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询追加保证金明细", "操作人ID为：" + getLoginName(request) + "查询追加保证金明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(detailId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "追加保证金明细id不能为空");	
			} else {
				return AjaxResult.createSuccessResult(contractService.getConDepositDetail(detailId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询追加保证金明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 检测必填项
	 * @param dto
	 * @param isIgnoreId
	 * @return
	 */
	private String checkDepositDetail(ConDepositDetail entity, boolean isIgnoreId) {
		if (entity == null) {
			return "追加保证金明细实体不能为空";
		}
		String baseStr = "不能为空";
		if (!isIgnoreId) {
			if (StringUtils.isEmpty(entity.getContractId())) {
				return "追加保证金明细id" + baseStr;
			}
		}
		if (StringUtils.isEmpty(entity.getContractId())) {
			return "合同id" + baseStr;
		}
		if (entity.getMoney() == null) {
			return "追加保证金金额" + baseStr;
		}
		return "";
	}
	
	@RequestMapping("/savePaymentDetail")
	@ResponseBody
	public AjaxResult savePaymentDetail(HttpServletRequest request, @RequestBody ConPaymentDetailSaveDto detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增追加货款明细", "操作人ID为：" + getLoginName(request) + "新增追加货款明细",
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
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
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
			super.logError(request, logBatch, "新增追加货款明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);	
	}
	
	@RequestMapping("/savePaymentDetails")
	@ResponseBody
	public AjaxResult savePaymentDetails(HttpServletRequest request, @RequestBody List<ConPaymentDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量新增追加货款明细", "操作人ID为：" + getLoginName(request) + "批量新增追加货款明细",
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
			super.logError(request, logBatch, "批量新增追加货款",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@RequestMapping("/updatePaymentDetail")
	@ResponseBody
	public AjaxResult updatePaymentDetail(HttpServletRequest request, @RequestBody ConPaymentDetail detail) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新追加货款明细", "操作人ID为：" + getLoginName(request) + "更新追加货款明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String msg = this.checkPaymentDetail(detail, false);
			if (!StringUtils.isEmpty(msg)) {
				return AjaxResult.createSuccessResult(contractService.updateConPaymentDetail(detail));
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "合同明细不能为空");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新追加货款明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	@RequestMapping("/updatePaymentDetails")
	@ResponseBody
	public AjaxResult updatePaymentDetails(HttpServletRequest request, @RequestBody List<ConPaymentDetail> details) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量更新追加货款明细", "操作人ID为：" + getLoginName(request) + "批量更新追加货款明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (details != null) {
				List<String> msgs = new ArrayList<>();
				for (int i = 0; i < details.size(); i++) {
					msgs.add(this.checkPaymentDetail(details.get(i), true));
				}
				if (msgs != null && !msgs.isEmpty()) {
					return AjaxResult.createSuccessResult(contractService.updateConPaymentDetailBatch(details));
				} else {
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "追加保证金明细id不能为空");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "追加货款明细不能为空");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "批量更新追加货款明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);	
	}
	
	@RequestMapping("/deletePaymentDetail")
	@ResponseBody
	public AjaxResult deletePaymentDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除追加货款明细", "操作人ID为：" + getLoginName(request) + "删除追加货款明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(detailId)) {
				return AjaxResult.createSuccessResult(contractService.deleteConPaymentDetail(detailId));
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "追加货款明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除追加货款明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);		
	}
	
	@RequestMapping("/deletePaymentDetails")
	@ResponseBody
	public AjaxResult deletePaymentDetails(HttpServletRequest request, @RequestBody List<String> detailIds) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "批量删除追加货款金明细", "操作人ID为：" + getLoginName(request) + "批量删除追加货款明细",
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
					return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "追加货款明细细第"+ ids +"条id不能为空");
				}
			} else {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "追加货款明细id不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "批量删除追加货款明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);	
	}
	
	@RequestMapping("/findPagePaymentDetails")
	@ResponseBody
	public AjaxResult findPagePaymentDetails(HttpServletRequest request, @RequestBody PageUtils<ConPaymentDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询追加货款明细并分页", "操作人ID为：" + getLoginName(request) + "查询追加货款明细并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConPaymentDetails(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询追加货款明细并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findAllPaymentDetails")
	@ResponseBody
	public AjaxResult findAllPaymentDetails(HttpServletRequest request, @RequestBody PageUtils<ConPaymentDetailDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询追加货款明细", "操作人ID为：" + getLoginName(request) + "查询追加货款明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			return AjaxResult.createSuccessResult(contractService.getConPaymentDetails(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询追加货款明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findOnePaymentDetail")
	@ResponseBody
	public AjaxResult findOnePaymentDetail(HttpServletRequest request, String detailId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询追加货款明细", "操作人ID为：" + getLoginName(request) + "查询追加货款明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(detailId)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "追加货款明细id不能为空");	
			} else {
				return AjaxResult.createSuccessResult(contractService.getConPaymentDetail(detailId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "查询追加货款明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: overContract 
	 * @Description: ( 结束合同 ) 
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
			super.logInfo(request, logBatch, "结束合同", "操作人ID为：" + getLoginName(request) + "结束合同",
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
			super.logError(request, logBatch, "结束合同",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);		
	}
	
	
	
	
	
	
	/**
	 * 判断必填
	 * @param dto
	 * @return
	 */
	public String checkPaymentDetail(ConPaymentDetail detail,  boolean isIgnoreId) {
		if (detail == null) {
			return "追加货款明细实体不能为空";
		}
		if (!isIgnoreId) {
			if (StringUtils.isEmpty(detail.getPaymentDetailId())) {
				return "追加货款明细id不能为空";
			}
		}
		if (StringUtils.isEmpty(detail.getContractId())) {
			return "关联合同id不能为空";
		}
		if (detail.getMoney() == null) {
			return "金额不能为空";
		}
		return "";
	}
	
	/**
	 * 导出合同Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_CONTRACT_EXCEL")
	@RequestMapping("/exportExcel")
	@ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("合同数据表","UTF-8") + ".xls");
		//编码
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
		
		//合同信息
		List<ConContractVo> list = contractService.getConContracts(dto, orderByClause, false);
		if (list != null && !list.isEmpty()) {
			for (ConContractVo vo : list) {
				ConContractExcel conContractExcel = new ConContractExcel();
				BeanUtils.copyProperties(vo, conContractExcel);
				String contractCode = vo.getContractCode();
				String contractNo = vo.getContractNo();
				// 设置甲方
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
				
				//货物信息
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
							conContractDetailExcel.setUnitContractPrice(conContractDetailVo.getUnitContractPrice() +"元/"+ product.getWeightUnit());
						}
						list2.add(conContractDetailExcel);
					}
				}
			}
			
		}
		
		ExportParams params1 = new ExportParams() ;  
        // 设置sheet得名称  
        params1.setSheetName("合同信息"); 
        
        ExportParams params2 = new ExportParams() ;  
        params2.setSheetName("货物信息") ;  
        // 创建sheet1使用得map  
        Map dataMap1 = new HashMap<>();  
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName  
        dataMap1.put("title",params1) ;  
        // 模版导出对应得实体类型  
        dataMap1.put("entity",ConContractExcel.class) ;  
        // sheet中要填充得数据  
        dataMap1.put("data",list1) ;  
        
        // 创建sheet2使用得map  
        Map dataMap2 = new HashMap<>();  
        dataMap2.put("title",params2);  
        dataMap2.put("entity",ConContractDetailExcel.class);  
        dataMap2.put("data",list2);  
        
        // 将sheet1和sheet2使用得map进行包装  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);  
        sheetsList.add(dataMap2);
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
	}
	
}