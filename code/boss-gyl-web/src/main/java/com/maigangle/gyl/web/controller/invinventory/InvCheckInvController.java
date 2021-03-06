package com.maigangle.gyl.web.controller.invinventory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
import com.maigangle.gyl.facade.entity.InvCheckInv;
import com.maigangle.gyl.facade.entity.InvCheckInvDetail;
import com.maigangle.gyl.facade.entity.InvInventory;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.InvCheckInvDto;
import com.maigangle.gyl.facade.entity.vo.InvCheckInvVo;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

@Controller
@RequestMapping("/checkInv")
public class InvCheckInvController extends GylBaseWeb{
	@Autowired
	private InvInventoryService invInventoryService;
	@Autowired
	private BaseService baseService;

	@Privilege(key = "GYL_CHECKINV_VIEW")
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/invinventory/invCheckInvIndex");
		return modelAndView;
	}
	
	/**
	 * ??????????????????????????????
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/findPage")
	@ResponseBody
	public AjaxResult findPageByStock(HttpServletRequest request,@RequestBody PageUtils<InvCheckInvVo> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ????????????????????????
			// ???????????????
			PageInfo<InvCheckInv> pageinfo= invInventoryService.getChenkInvAll(page,true);
			for(int i = 0;i < pageinfo.getList().size();i++) {
				Map<String, Object> storage = getDictMallDepot(request, pageinfo.getList().get(i).getStorageId());
				if (!(boolean)storage.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "???????????????ID??????????????????," + storage.get("msg"));
				}
				DictMallDepot dictMallDepot = (DictMallDepot) storage.get("data");
				pageinfo.getList().get(i).setStorageName(dictMallDepot.getDptName());
			}
			return AjaxResult.createSuccessResult(pageinfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@PostMapping("/findInvByStorageId")
	@ResponseBody
	public AjaxResult findInvByStorageId(HttpServletRequest request, @RequestBody PageUtils<InvInventory> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????ID??????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ????????????????????????
			// ???????????????
			PageInfo<InvInventory> pageData = invInventoryService.getInvsByStorageId(page);
			PageInfo<InvCheckInvDto> data = null;
			
			if (pageData != null && pageData.getList() != null && !pageData.getList().isEmpty()) {
				data = new PageInfo<>();
				BeanUtils.copyProperties(pageData, data, "list");
				List<InvCheckInvDto> list = new ArrayList<>();
				for (InvInventory invInventory : pageData.getList()) {
					InvCheckInvDto dto = new InvCheckInvDto();
					BeanUtils.copyProperties(invInventory, dto);
					BaseProduct product = baseService.getBaseProductById(invInventory.getProductId());
					dto.setBaseProduct(product);
					
					if(!StringUtils.isEmpty(invInventory.getStorageId())) {
						Map<String, Object> result1 = getDictMallDepot(request, invInventory.getStorageId());
						DictMallDepot dictMallDepot = (DictMallDepot) result1.get("data");
						dto.setStorageName(dictMallDepot.getDptName());
					}
					list.add(dto);
				}
				data.setList(list);
			}
			return AjaxResult.createSuccessResult(data);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????ID??????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request,@RequestBody InvCheckInvVo invCheckInvVo) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????", "?????????ID??????" + getLoginName(request) + "??????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (invCheckInvVo == null){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"??????????????????");
			}
			invCheckInvVo.setStorageId(invCheckInvVo.getStorageId());
			//??????????????????
			Map<String, Object> result = getCurrentPrivUser(request);
			if (!(boolean)result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "??????????????????????????????," + result.get("msg"));
			}
			PrivUser privUser = (PrivUser) result.get("data");
			invCheckInvVo.setCreateUser(privUser.getUserName());
			//????????????????????????
			InvCheckInv inv = invInventoryService.addCheckInv(invCheckInvVo);
			//??????????????????
			InvCheckInvDetail invCheckInvDetail = new InvCheckInvDetail();
			String checkInvId = inv.getCheckInvId();
			Map<String, String> detail = invCheckInvVo.getDetail();
			
			List<InvInventory> inventoryList = invInventoryService.getInvsByStorageId(invCheckInvVo.getStorageId());
			if(!inventoryList.isEmpty()) {
				for(InvInventory inventory: inventoryList) {
					if(detail.containsKey(inventory.getInventoryId())) {
						invCheckInvDetail.setCheckRecord(detail.get(inventory.getInventoryId()));
					}else {
						invCheckInvDetail.setCheckRecord(invCheckInvVo.getNote());
					}
					invCheckInvDetail.setCheckInvId(checkInvId);
					invCheckInvDetail.setInventoryId(inventory.getInventoryId());
					invCheckInvDetail.setCreateDate(new Date());
					invCheckInvDetail.setCreateUser(privUser.getUserName());
					invInventoryService.addCheckInvDetail(invCheckInvDetail);
				}
			}
			return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "??????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
}	
