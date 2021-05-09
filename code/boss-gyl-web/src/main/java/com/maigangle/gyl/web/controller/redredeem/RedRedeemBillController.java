package com.maigangle.gyl.web.controller.redredeem;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.FeeDepositAccount;
import com.maigangle.gyl.facade.entity.FeeDepositDetail;
import com.maigangle.gyl.facade.entity.InvInventory;
import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.dto.RedRedeemBillDto;
import com.maigangle.gyl.facade.entity.dto.RedRedeemDetailDto;
import com.maigangle.gyl.facade.entity.excel.RedRedeemBillExcel;
import com.maigangle.gyl.facade.entity.excel.RedRedeemDetailExcel;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.RedRedeemVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;


/**  
 * 赎货单controller
 * @author zlh
 * @since 2017年11月28日 下午3:07:20 
 * @version 1.0 
 */
@Controller
@RequestMapping("/redRedeemBill")
public class RedRedeemBillController extends GylBaseWeb {
	@Autowired
	RedRedeemBillService redRedeemBillService;

	@Autowired
	InvInventoryService invInventoryService;
	@Autowired
	FinanceService financeService;
	@Autowired
	ContractService contractService;
	@Autowired
	BaseService baseService;
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/redRedeem/redRedeemBillDetail");
		return modelAndView;
	}

	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/redRedeem/redRedeemBillIndex");
		return modelAndView;
	}

	/**
	 * 查询赎货单查询带分页
	 * @param request
	 * @param dto
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPageFinance(HttpServletRequest request,@RequestBody PageUtils<RedRedeemBillDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "查询所有赎货单带分页", "操作人ID为：" + getLoginName(request) + "查询所有赎货单带分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			PageInfo<RedRedeemBill> pages = redRedeemBillService.getAllRedRedeemBill(page, true);
			PageInfo<RedRedeemBillDto> pageDto = new PageInfo<RedRedeemBillDto>();
			List<RedRedeemBill> list = pages.getList();
			List<RedRedeemBillDto> listDto = new ArrayList<RedRedeemBillDto>();
			for (RedRedeemBill redRedeemBill : list) {
				RedRedeemBillDto dto = new RedRedeemBillDto();
				BeanUtils.copyProperties(redRedeemBill, dto);
				// 买方
				Map<String, Object> result = getCrmClient(request, redRedeemBill.getBuyerId());
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				CrmClient crmClient = (CrmClient) result.get("data");
				dto.setBuyerName(crmClient.getClientName());
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
			super.logError(request, logBatch, "查询所有赎货单带分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_REDREDEEM_ADD")
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request,@RequestBody RedRedeemVo vo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "新增赎货单", "操作人ID为：" + getLoginName(request) + "新增赎货单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if(vo== null) {
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
			}
			 RedRedeemBill entity = vo.getEntity();
			if(entity!=null) {
				// 当前用户
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				entity.setCreateUser(privUser.getUserName());
				if(entity == null
						|| StringUtils.isEmpty(entity.getBuyerId())
						|| StringUtils.isEmpty(entity.getContractId())
						|| StringUtils.isEmpty(entity.getStorageId())) {
					return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
				}
				
				if (entity.getDepositFee() != null && entity.getDepositFee().compareTo(BigDecimal.ZERO) > 0) {
					// 减去保证金
					financeService.delDepositFee(entity.getContractId(), entity.getDepositFee());
					// 生成保证金消费明细
					FeeDepositAccount account = financeService.getDepositAccountByContractId(entity.getContractId());
					FeeDepositDetail detail = new FeeDepositDetail();
					detail.setUsedFee(entity.getDepositFee());
					detail.setBalance(account.getBalance());
					detail.setCreateUser(privUser.getUserName());
					detail.setContractId(entity.getContractId());
					detail.setDepositAccountId(account.getDepositAccountId());
					detail.setCreateDate(new Date());
					detail = financeService.addDepositDetail(detail);
					// 将保证金消费明细的id放入赎货单中
					entity.setDepositDetailId(detail.getDepositDetailId());
				}

				RedRedeemBill bill = redRedeemBillService.addRedRedeemBill(entity);
				List<RedRedeemDetail> list= vo.getDetail();
				List<RedRedeemDetail> lists = new ArrayList<>();
				if(bill!=null&&list!=null) {
					for (RedRedeemDetail redRedeemDetail : list) {
						redRedeemDetail.setRedeemBillId(bill.getRedeemBillId());
						if(redRedeemDetail.getRedeemMoney()==null) {
							redRedeemDetail.setRedeemMoney(BigDecimal.ZERO);
						}
						redRedeemDetail = redRedeemBillService.addRedeemDetail(redRedeemDetail);
						if(redRedeemDetail!=null) {
							int i = invInventoryService.nextUnlockQuantity(redRedeemDetail.getInventoryId(),redRedeemDetail.getAmount());
							if(i==1) {
								lists.add(redRedeemDetail);
							}
						}
					}
					
				}else {
					return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
				}
				if(lists.size() == list.size()) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增赎货单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	/**
	 * 编辑 赎货单
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_REDREDEEM_EDIT")
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request,@RequestBody RedRedeemVo vo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新赎货单", "操作人ID为：" + getLoginName(request) + "更新赎货单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if(vo == null) {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
			}
			RedRedeemBill entity = vo.getEntity();
			if(entity == null
					|| StringUtils.isEmpty(entity.getRedeemBillId())
					|| StringUtils.isEmpty(entity.getBuyerId())
					|| StringUtils.isEmpty(entity.getContractId())
					|| StringUtils.isEmpty(entity.getStorageId())) {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
			}
			
			int i = redRedeemBillService.updateRedRedeemBill(entity);
			if(i == 1) {
				if (!StringUtils.isEmpty(entity.getDepositDetailId())) {
					// 先将原先的保证金归还
					financeService.addDepositFee(entity.getDepositDetailId(), entity.getDepositFee());
					// 在扣除新的保证金
					financeService.delDepositFee(entity.getDepositDetailId(), entity.getDepositFee());
					// 修改保证金消费明细
					FeeDepositAccount account = financeService.getDepositAccountByContractId(entity.getContractId());
					FeeDepositDetail detail = financeService.getDepositDetail(entity.getDepositDetailId());
					detail.setBalance(account.getBalance());
					detail.setUsedFee(entity.getDepositFee());
					detail.setCreateDate(new Date());
					financeService.updateDepositDetail(detail);
				}
				
				List<RedRedeemDetail> list= vo.getDetail();
				if(list !=null && !list.isEmpty()) {
					List<RedRedeemDetail> oldRedList = redRedeemBillService.getRedRedeemDetailByBillId(entity.getRedeemBillId());
					// 先删除旧的
					for (RedRedeemDetail redRedeemDetail : oldRedList) {
						int  d = invInventoryService.removerQuantity(redRedeemDetail.getInventoryId(), redRedeemDetail.getAmount());
						if(d ==1) {
							// 删除货物
							redRedeemBillService.deleteRedeemDetail(redRedeemDetail.getRedeemDetailId());
						}
					}
					// 去除完添加
					List<RedRedeemDetail> newList = new ArrayList<>();
					for (RedRedeemDetail redRedeemDetail : list) {
						redRedeemDetail.setRedeemBillId(entity.getRedeemBillId());
						RedRedeemDetail redred =redRedeemBillService.addRedeemDetail(redRedeemDetail);
						if(redred!=null) {
							int a = invInventoryService.nextUnlockQuantity(redred.getInventoryId(), redred.getAmount());
							if(a==1) {
								newList.add(redRedeemDetail);
							}
						}
					}
					if(newList.size() == list.size()) {
						return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
					}
					
					return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
//					for (RedRedeemDetail redRedeemDetail : list) {
//						// 查询出旧的货物
//						RedRedeemDetail red = redRedeemBillService.getOneRedRedeemDetail(redRedeemDetail.getRedeemDetailId());
//						// 去除库存待解锁数量
//						if(red!=null) {
//							int  d = invInventoryService.removerQuantity(red.getInventoryId(), red.getAmount());
//							if(d==1) {
//								// 删除货物
//								int z =redRedeemBillService.deleteRedeemDetail(redRedeemDetail.getRedeemDetailId());
//								if(z==1) {
//									RedRedeemDetail redred =redRedeemBillService.addRedeemDetail(redRedeemDetail);
//									if(redred!=null) {
//										int a = invInventoryService.nextUnlockQuantity(redred.getInventoryId(), redred.getAmount());
//										if(a==1) {
//											return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
//										}
//									}
//								}
//							}
//						}					
//					}
				}
				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新赎货单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	/**
	 * 提交赎货单
	 * @param request
	 * @return
	 */
	@GetMapping("/submit")
	@ResponseBody
	public AjaxResult submit(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "更新赎货单", "操作人ID为：" + getLoginName(request) + "更新赎货单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			RedRedeemBill bill = redRedeemBillService.getRedRedeemBillById(id);
			if(bill!=null) {
				if(redRedeemBillService.doAudit(id, ApprovalStateEnum.APPROVAL_UNDERWAY.toString())) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.APPROVAL_SUBMIT_SUCCESS);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新赎货单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@Privilege(key = "GYL_REDREDEEM_DELETE")
	@GetMapping("/delete")
	@ResponseBody
	public AjaxResult delete(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除赎货单", "操作人ID为：" + getLoginName(request) + "删除赎货单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			
			if(!StringUtils.isEmpty(id)) {
				
				RedRedeemBill bill = redRedeemBillService.getRedRedeemBillById(id);
				financeService.addDepositFee(bill.getDepositDetailId(), bill.getDepositFee());
				financeService.deleteDepositDetail(bill.getDepositDetailId());
				
				return AjaxResult.createSuccessResultWithCode(MessageCode.DELETE_SUCCESS,redRedeemBillService.deleteRedRedeemBill(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除赎货单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
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
			super.logInfo(request, logBatch, "根据赎货ID查询赎货单", "操作人ID为：" + getLoginName(request) + "根据赎货ID查询赎货单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			
		List<RedRedeemDetail> list  = 	redRedeemBillService.getRedRedeemDetailByBillId(id);
		List<RedRedeemDetailDto> listVo = new  ArrayList<RedRedeemDetailDto>();
		for (RedRedeemDetail redRedeemDetail : list) {
			RedRedeemDetailDto  dto= new RedRedeemDetailDto();
			BeanUtils.copyProperties(redRedeemDetail, dto);
			if(!StringUtils.isEmpty(redRedeemDetail.getProductId())) {
				BaseProduct baseProduct =  baseService.getBaseProductById(redRedeemDetail.getProductId());
				dto.setBaseProduct(baseProduct);
			}
			if(!StringUtils.isEmpty(redRedeemDetail.getStorageId())) {
				// 仓库
				Map<String, Object> result = getDictMallDepot(request, redRedeemDetail.getStorageId());
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				DictMallDepot dictMallDepot = (DictMallDepot) result.get("data");
				dto.setDictMallDepot(dictMallDepot);
			}
			//制造商
			if(!StringUtils.isEmpty(redRedeemDetail.getMnfctId())) {
				// 仓库
				Map<String, Object> result = getDictMallMnfct(request, redRedeemDetail.getMnfctId());
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				DictMallMnfct dictMallMnfct = (DictMallMnfct) result.get("data");
				dto.setDictMallMnfct(dictMallMnfct);
			}
			
			
			
			listVo.add(dto);
		}

		return  AjaxResult.createSuccessResult(listVo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据赎货ID查询赎货单",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	/**
	 * 根据 合同id，仓库 id 查询库存List
	 * @param request
	 * @param 
	 * @return List
	 */
	@RequestMapping("/getStorageList")
	@ResponseBody
	public AjaxResult getStorageList(HttpServletRequest request,String contractId, String storageId,String goodsSource) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "根据 合同id，仓库 id 查询库存List", "操作人ID为：" + getLoginName(request) + "根据 合同id，仓库 id 查询库存List",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (!StringUtils.isEmpty(contractId) && !StringUtils.isEmpty(storageId)) {
				//查库存
				List<InvInventoryDto> list = invInventoryService.getStockByConContractIdAndStorageId(contractId, storageId,goodsSource);
				//添加
				for(int i=0;i<list.size();i++) {
					InvInventory entity = list.get(i).getInvInventory();
					//仓库名
					if(!StringUtils.isEmpty(entity.getStorageId())) {
						Map<String, Object> storage = getDictMallDepot(request, entity.getStorageId());
						if (!(boolean)storage.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据仓库名ID获取客户对象," + storage.get("msg"));
						}
						DictMallDepot dictMallDepot = (DictMallDepot) storage.get("data");
						list.get(i).setDictMallDepot(dictMallDepot);
					}

					//厂家
					if(!StringUtils.isEmpty(entity.getMnfctId())) {
						Map<String, Object> Mnfct = getDictMallMnfct(request, entity.getMnfctId());
						if (!(boolean)Mnfct.get("isSuccess")) {
							return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据厂家ID获取客户对象," + Mnfct.get("msg"));
						}
						DictMallMnfct dictMallMnfct = (DictMallMnfct) Mnfct.get("data");
						list.get(i).setDictMallMnfct(dictMallMnfct);
					}
					
				}
				return AjaxResult.createSuccessResult(list);
			} else {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "根据 合同id，仓库 id 查询库存List");
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "根据 合同id，仓库 id 查询库存List",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);	
	}
	
	
	@RequestMapping("/isLastGoods")
	@ResponseBody
	public AjaxResult isLastGoods(HttpServletRequest request,@RequestBody RedRedeemVo vo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "判断最后一次货物", "操作人ID为：" + getLoginName(request) + "新增赎货单",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if(vo== null) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
			}
			 return AjaxResult.createSuccessResult(redRedeemBillService.isLastGoods(vo.getDetail(),vo.getEntity().getContractId()));	
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "判断最后一次货物",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	

	
	/**
	 * 导出合同Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_REDREDEEM_EXCEL")
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
		RedRedeemBillDto dto = null;
		if (!StringUtils.isEmpty(param)) {
			JSONObject paramObj = JSONObject.parseObject(param);
			orderByClause = paramObj.getString("orderByClause");
			dto = paramObj.getObject("dto", RedRedeemBillDto.class);
		} else {
			dto = new RedRedeemBillDto();
		}
		
		List<RedRedeemBillExcel> list1 = new ArrayList<RedRedeemBillExcel>();
		List<RedRedeemDetailExcel> list2 = new ArrayList<RedRedeemDetailExcel>();
		
		//合同信息
		List<RedRedeemBill> list = redRedeemBillService.getAllRedRedeemBill(dto, orderByClause, true);
		if (list != null && !list.isEmpty()) {
			for (RedRedeemBill red : list) {
				RedRedeemBillExcel redRedeemBillExcel = new RedRedeemBillExcel();
				BeanUtils.copyProperties(red, redRedeemBillExcel);
				// 设置赎货客户
				if(!StringUtils.isEmpty(red.getBuyerId())) {
					Map<String, Object> resultBuyer = getCrmClient(request, red.getBuyerId());
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					redRedeemBillExcel.setBuyerName(crmClientBuyer.getClientName());
				}
				// 设置仓库
				if(!StringUtils.isEmpty(red.getStorageId())) {
					Map<String, Object> storage = getDictMallDepot(request, red.getStorageId());
					DictMallDepot dictMallDepot = (DictMallDepot) storage.get("data");
					redRedeemBillExcel.setStorageName(dictMallDepot.getDptName());
				}
				if (!StringUtils.isEmpty(red.getContractId())) {
					// 设置合同自编号
					ConContractVo vo  = contractService.getConContractById(red.getContractId());
					redRedeemBillExcel.setContractCode(vo.getContractCode());
					// 设置合同编号
					redRedeemBillExcel.setContractNo(vo.getContractNo());
				}
				// 设置货物总重量单位
				if (!StringUtils.isEmpty(red.getTotalWeight())) {
					redRedeemBillExcel.setTotalWeight(red.getTotalWeight() + "吨");
				}
				list1.add(redRedeemBillExcel);
				
				//货物信息
				List<RedRedeemDetail> detailList = redRedeemBillService.getRedRedeemDetailByBillId(red.getRedeemBillId());
				if(detailList != null && !detailList.isEmpty()) {
					for (RedRedeemDetail redRedeemDetail : detailList) {
						RedRedeemDetailExcel redRedeemDetailExcel = new RedRedeemDetailExcel();
						BeanUtils.copyProperties(redRedeemDetail,redRedeemDetailExcel);
						if (!StringUtils.isEmpty(red.getContractId())) {
							// 设置合同自编号
							ConContractVo vo  = contractService.getConContractById(red.getContractId());
							redRedeemDetailExcel.setContractCode(vo.getContractCode());
							// 设置合同编号
							redRedeemDetailExcel.setContractNo(vo.getContractNo());
						}
						if(!StringUtils.isEmpty(redRedeemDetail.getProductId())) {
							BaseProduct product = baseService.getBaseProductById(redRedeemDetail.getProductId());
							redRedeemDetailExcel.setProductName(product.getProductName());
						}
						if(!StringUtils.isEmpty(redRedeemDetail.getLabelThick()) && !StringUtils.isEmpty(redRedeemDetail.getLabelWidth()) && !StringUtils.isEmpty(redRedeemDetail.getGoodsLength())) {
							redRedeemDetailExcel.setSpecification(redRedeemDetail.getLabelThick()+"*"+redRedeemDetail.getLabelWidth()+"*"+redRedeemDetail.getGoodsLength());;
						}
						if(!StringUtils.isEmpty(redRedeemDetail.getAmount())) {
							BaseProduct product = baseService.getBaseProductById(redRedeemDetail.getProductId());
							redRedeemDetailExcel.setAmount(redRedeemDetail.getAmount() + product.getQuantityUnit());
						}
						if(!StringUtils.isEmpty(redRedeemDetail.getNetWeight())) {
							BaseProduct product = baseService.getBaseProductById(redRedeemDetail.getProductId());
							redRedeemDetailExcel.setNetWeight(redRedeemDetail.getNetWeight().divide(product.getUnitRate(), product.getPrecision().intValue(), BigDecimal.ROUND_HALF_DOWN).toString());
							redRedeemDetailExcel.setNetWeight(redRedeemDetailExcel.getNetWeight() + product.getWeightUnit());
						}
						list2.add(redRedeemDetailExcel);
					}
				}
			}
			
		}
		
		ExportParams params1 = new ExportParams() ;  
        // 设置sheet得名称  
        params1.setSheetName("赎货单信息"); 
        
        ExportParams params2 = new ExportParams() ;  
        params2.setSheetName("货物信息") ;  
        // 创建sheet1使用得map  
        Map dataMap1 = new HashMap<>();  
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName  
        dataMap1.put("title",params1) ;  
        // 模版导出对应得实体类型  
        dataMap1.put("entity",RedRedeemBillExcel.class) ;  
        // sheet中要填充得数据  
        dataMap1.put("data",list1) ;  
        
        // 创建sheet2使用得map  
        Map dataMap2 = new HashMap<>();  
        dataMap2.put("title",params2);  
        dataMap2.put("entity",RedRedeemDetailExcel.class);  
        dataMap2.put("data",list2);  
        
        // 将sheet1和sheet2使用得map进行包装  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);  
        sheetsList.add(dataMap2);
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
	}
	
	
	
	
	
}
