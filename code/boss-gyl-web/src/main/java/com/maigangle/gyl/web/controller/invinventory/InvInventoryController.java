package com.maigangle.gyl.web.controller.invinventory;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import com.maigangle.gyl.facade.entity.BaseProcess;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.InvInventory;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.api.DictMallSpec;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.excel.InvInventoryExcel;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.InvInventoryVo;
import com.maigangle.gyl.facade.enums.ImageFileTypeEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.GylBaseService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

/**
 * ????????????controller
 * 
 * @author ?????????
 * @since 2017???11???28??? - ??????4:51:11
 * @version 1.0
 */
@Controller
@RequestMapping("/stock")
public class InvInventoryController extends GylBaseWeb {
	@Autowired
	private InvInventoryService invInventoryService;
	@Autowired
	private BaseService baseService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private GylBaseService gylBaseService;
	/**
	 * 
	 * @author shmily
	 * @Title: main 
	 * @Description: ( ?????????	???????????????????????? ) 
	 * @return ModelAndView
	 * @throws
	 */
	@Privilege(key = "GYL_INVENTORY_VIEW")
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/invinventory/invinventoryIndex");
		return modelAndView;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: detail 
	 * @Description: ( ??????????????????????????? ) 
	 * @return ModelAndView
	 * @throws 
	 */
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/invinventory/invinventoryDetail");
		// ????????????????????????
		return modelAndView;
	}
	/**
	 * ??????????????????????????????
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/findPage")
	@ResponseBody
	public AjaxResult findPageByStock(HttpServletRequest request,@RequestBody PageUtils<InvInventoryDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ????????????????????????
			// ???????????????
			PageInfo<InvInventory>  pageinfo= invInventoryService.getStockAll(page,true);
			return AjaxResult.createSuccessResult(fomatByPageInfoToPage(request,logBatch,pageinfo));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * ??????????????????????????????
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "??????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ????????????????????????
			// ???????????????
			 InvInventory inv = invInventoryService.getStockOne(id);
			 InvInventoryVo vo =new InvInventoryVo();
			BeanUtils.copyProperties(inv, vo);
			return AjaxResult.createSuccessResult(vo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	


	/**
	 * ??????????????????????????????
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/stockdetail")
	@ResponseBody
	public AjaxResult getstockdetail(HttpServletRequest request, String invInventoryId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ????????????
			// ??????
			if(StringUtils.isEmpty(invInventoryId)){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID????????????");
			}
			InvInventory dto = invInventoryService.getStockOne(invInventoryId);
			return AjaxResult.createSuccessResult(fomatbyDto(request,logBatch,dto));
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
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping("/updatestock")
	@ResponseBody
	public AjaxResult updatestock(HttpServletRequest request, InvInventoryDto invInventoryDto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());	
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ????????????
			if (invInventoryDto ==null&& invInventoryDto.getInvInventory() ==null &&StringUtils.isEmpty(invInventoryDto.getInvInventory().getInventoryId())){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID????????????????????????");
			}
			return AjaxResult.createSuccessResult(invInventoryService.updateStock(invInventoryDto));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * ??????
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/addstock")
	@ResponseBody
	public AjaxResult addstock(HttpServletRequest request, InvInventoryDto invInventoryDto) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????", "?????????ID??????" + getLoginName(request) + "????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ????????????
			invInventoryDto.setInvInventory(new InvInventory());
			if (invInventoryDto == null){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"??????????????????");
			}
			return AjaxResult.createSuccessResult(invInventoryService.addStock(invInventoryDto));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * ???????????? -- --????????????
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/delectStock")
	@ResponseBody
	public AjaxResult delectStock(HttpServletRequest request, String invInventoryId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????", "?????????ID??????" + getLoginName(request) + "????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(invInventoryId)){
				AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID????????????");
			}
			return AjaxResult.createSuccessResult(invInventoryService.deleteStock(invInventoryId));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}

	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyDto 
	 * @Description: ( ??????Dto ) 
	 * @param inventory
	 * @return InvInventoryDto
	 * @throws
	 */
	@SuppressWarnings("unused")
	private  InvInventoryDto fomatbyDto(HttpServletRequest request, String logBatch,InvInventory ins) {
		InvInventoryDto dto = new InvInventoryDto();
		dto.setInvInventory(ins);
		// ?????????????????????
		CrmClient crmClient  = null;
		if(!StringUtils.isEmpty(ins.getBuyerId())) {
			Map<String, Object> result = getCrmClient(request,ins.getBuyerId());
			if ((boolean) result.get("isSuccess")) {
				crmClient = (CrmClient)result.get("data");				
			}
		}
		if (crmClient != null) {
			String buyName =crmClient.getClientName();
			dto.setBuyerName(buyName);
		}
		//?????????????????????
		BaseCompany seller  = null;
		if(!StringUtils.isEmpty(ins.getSellerId())) {
			seller = baseService.getBaseCompany(ins.getSellerId());
		}
		
		if (seller !=null) {
			String sellerName = seller.getCompanyName();
			dto.setSellerName(sellerName);
		}
		
		// ??????
		DictMallDepot dictMallDepot = null;
		if(!StringUtils.isEmpty(ins.getStorageId())) {
			Map<String, Object> result = getDictMallDepot(request,ins.getStorageId());
			if ((boolean) result.get("isSuccess")) {
				dictMallDepot = (DictMallDepot)result.get("data");				
			}
		}
		if (dictMallDepot != null) {
			String StorageName = dictMallDepot.getDptName();
			dto.setStorageName(StorageName);
			dto.setDictMallDepot(dictMallDepot);
		}
		// ??????
		DictMallSpec dictMallSpec = null;
		if(!StringUtils.isEmpty(ins.getMaterialId())) {
//			Map<String, Object> result = getAllDictMallSpec(request,logBatch,null, ins.getMaterialId());
//			if (!(boolean) result.get("isSuccess")) {
//				dictMallSpec = (DictMallSpec)result.get("data");				
//			}
		}
		if (dictMallSpec != null) {
			String materialName =  dictMallSpec.getQuality();
			dto.setMaterialName(materialName);
		}
		
		//  ??????
		BaseProcess baseProcess = null;
		if(!StringUtils.isEmpty(ins.getSurfaceId())) {
			 baseProcess = baseService.getBaseProcess(ins.getSurfaceId());
		}
		if (baseProcess !=null) {
			dto.setSurfaceName(baseProcess.getProcessName());
		}
		// ??????
		BaseProduct baseProduct = null;
		if(!StringUtils.isEmpty(ins.getProductId())) {
			baseProduct = baseService.getBaseProductById(ins.getProductId());
		}
		if (baseProduct != null) {
			String productName = baseProduct.getProductName();
			dto.setProductName(productName);
			dto.setBaseProduct(baseProduct);
		}
		// ??????
		ConContract  conContract = null;
		if(!StringUtils.isEmpty(ins.getContractId())) {
			conContract = contractService.getConContractById(ins.getContractId());
		}
		if (conContract !=null) {
			dto.setConContract(conContract);
		} 
		// ??????
		DictMallMnfct dictMallMnfct = null;
		if(!StringUtils.isEmpty(ins.getMnfctId())) {
			Map<String, Object> result = getDictMallMnfct(request,ins.getMnfctId());
			if ((boolean) result.get("isSuccess")) {
				dictMallMnfct = (DictMallMnfct)result.get("data");				
			}
		}
		if (dictMallMnfct !=null) {
			dto.setMnfctName(dictMallMnfct.getMnfctName());
			dto.setDictMallMnfct(dictMallMnfct);
			
		} 
		// ???????????????
		List<Attach> list = gylBaseService.getAttachByIdAndType(ins.getInventoryId(), ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
		if(list!=null) {
			dto.setSphotosGoodsList(list);
		}
		return dto;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyListDto 
	 * @Description: ( ??????????????????Dto  ) 
	 * @param list
	 * @return InvInventoryDto
	 * @throws
	 */
	private  List<InvInventoryDto> fomatbyListDto(HttpServletRequest request, String logBatch,List<InvInventory> list) {
		List<InvInventoryDto> dtoList = new ArrayList<InvInventoryDto>();
		for (InvInventory invInventory : list) {
			InvInventoryDto dto  = fomatbyDto(request,logBatch,invInventory);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: fomatByPageInfoToPage 
	 * @Description: (  PageInfo ---> PageInfo ???????????????????????????????????? ) 
	 * @return PageInfo<InvInventoryDto>
	 * @throws
	 */
	private PageInfo<InvInventoryDto> fomatByPageInfoToPage(HttpServletRequest request, String logBatch,PageInfo<InvInventory> pageInv){
		List<InvInventoryDto> listDto = fomatbyListDto(request,logBatch,pageInv.getList());
		PageInfo<InvInventoryDto> pageDto = new PageInfo<>();
		BeanUtils.copyProperties(pageInv, pageDto);
		pageDto.setList(listDto);
		return pageDto;
	}
	
	/**
	 * ????????????Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_INVENTORY_EXCEL")
	@RequestMapping("/exportExcel")
	@ResponseBody
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ???????????????????????????????????????????????????
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// ???????????????????????????
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("???????????????","UTF-8") + ".xls");
		//??????
		response.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");
		InvInventoryDto dto = null;
		if (!StringUtils.isEmpty(param)) {
			JSONObject paramObj = JSONObject.parseObject(param);
			dto = paramObj.getObject("dto", InvInventoryDto.class);
		} else {
			dto = new InvInventoryDto();
		}
		
		List<InvInventoryExcel> list1 = new ArrayList<InvInventoryExcel>();
			
		//????????????
		List<InvInventory>  list= invInventoryService.getStockAll(dto,true);
		if (list != null && !list.isEmpty()) {
			for (InvInventory inv : list) {
				InvInventoryExcel invInventoryExcel = new InvInventoryExcel();
				BeanUtils.copyProperties(inv, invInventoryExcel);
				// ????????????
				if(!StringUtils.isEmpty(inv.getSellerId())) {
					BaseCompany seller = baseService.getBaseCompany(inv.getSellerId());
					invInventoryExcel.setSellerName(seller.getCompanyName());
				}
				// ????????????
				if(!StringUtils.isEmpty(inv.getBuyerId())) {
					Map<String, Object> resultBuyer = getCrmClient(request, inv.getBuyerId());
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					invInventoryExcel.setBuyerName(crmClientBuyer.getClientName());
				}
				// ????????????
				if(!StringUtils.isEmpty(inv.getStorageId())) {
					Map<String, Object> storage = getDictMallDepot(request, inv.getStorageId());
					DictMallDepot dictMallDepot = (DictMallDepot) storage.get("data");
					invInventoryExcel.setStorageName(dictMallDepot.getDptName());
				}
				// ????????????
				if (!StringUtils.isEmpty(inv.getMnfctId())) {
					Map<String, Object> resultMallMnfct = getDictMallMnfct(request, inv.getMnfctId());
					DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
					invInventoryExcel.setMallMnfct(dictMallMnfct.getMnfctName());
				}
				// ????????????
				if (!StringUtils.isEmpty(inv.getProductId())) {
					BaseProduct product = baseService.getBaseProductById(inv.getProductId());
					invInventoryExcel.setProductName(product.getProductName());
					// ??????????????????
					invInventoryExcel.setNetWeight(inv.getNetWeight().divide(product.getUnitRate(), product.getPrecision().intValue(), BigDecimal.ROUND_HALF_DOWN).toString());
					invInventoryExcel.setNetWeight(invInventoryExcel.getNetWeight() + product.getWeightUnit());
					// ??????????????????
					invInventoryExcel.setQuantity(inv.getQuantity() + product.getQuantityUnit());
					// ????????????????????????
					if (!StringUtils.isEmpty(inv.getContractUnitPrice())) {
						invInventoryExcel.setContractUnitPrice(inv.getContractUnitPrice() + "???/" + product.getWeightUnit());
					}
					// ????????????????????????
					if (!StringUtils.isEmpty(inv.getRealUnitPrice())) {
						invInventoryExcel.setRealUnitPrice(inv.getRealUnitPrice() + "???/" + product.getWeightUnit());
					}
				}
				if (!StringUtils.isEmpty(inv.getContractId())) {
					// ?????????????????????
					ConContractVo vo  = contractService.getConContractById(inv.getContractId());
					invInventoryExcel.setContractCode(vo.getContractCode());
					// ??????????????????
					invInventoryExcel.setContractNo(vo.getContractNo());
				}
				list1.add(invInventoryExcel);
				
			}
			
		}
		
		ExportParams params1 = new ExportParams() ;  
        // ??????sheet?????????  
        params1.setSheetName("????????????"); 
          
        // ??????sheet1?????????map  
        Map dataMap1 = new HashMap<>();  
        // title????????????ExportParams????????????????????????ExportParams????????????sheetName  
        dataMap1.put("title",params1) ;  
        // ?????????????????????????????????  
        dataMap1.put("entity",InvInventoryExcel.class) ;  
        // sheet?????????????????????  
        dataMap1.put("data",list1) ; 
        
        // ???sheet1???sheet2?????????map????????????  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);  
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
		
	}
	
	
	
	
	
	/**
	 * ???????????????????????????
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectCheckInv")
	@ResponseBody
	public AjaxResult selectCheckInv(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "???????????????????????????", "?????????ID??????" + getLoginName(request) + "???????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(id)){
				AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID????????????");
			}
			return AjaxResult.createSuccessResult(invInventoryService.selectCheckDetail(id));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "???????????????????????????",
					"?????????ID??????" + getLoginName(request) + "??????????????????" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	
	
}
