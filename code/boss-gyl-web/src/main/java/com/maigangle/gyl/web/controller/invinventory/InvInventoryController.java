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
 * 库存管理controller
 * 
 * @author 杨思静
 * @since 2017年11月28日 - 下午4:51:11
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
	 * @Description: ( 返回一	个主库存管理页面 ) 
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
	 * @Description: ( 库存详情侧边栏页面 ) 
	 * @return ModelAndView
	 * @throws 
	 */
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/invinventory/invinventoryDetail");
		// 可在此向页面赋值
		return modelAndView;
	}
	/**
	 * 获取库存管理列表详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/findPage")
	@ResponseBody
	public AjaxResult findPageByStock(HttpServletRequest request,@RequestBody PageUtils<InvInventoryDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取库存管理列表", "操作人ID为：" + getLoginName(request) + "获取库存管理列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  查询分页库存页面
			// 正式的逻辑
			PageInfo<InvInventory>  pageinfo= invInventoryService.getStockAll(page,true);
			return AjaxResult.createSuccessResult(fomatByPageInfoToPage(request,logBatch,pageinfo));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取库存管理列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 获取库存管理列表详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request,String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取单个库存", "操作人ID为：" + getLoginName(request) + "获取库存管理列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  查询分页库存页面
			// 正式的逻辑
			 InvInventory inv = invInventoryService.getStockOne(id);
			 InvInventoryVo vo =new InvInventoryVo();
			BeanUtils.copyProperties(inv, vo);
			return AjaxResult.createSuccessResult(vo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取库存管理列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	


	/**
	 * 获取库存管理列表详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/stockdetail")
	@ResponseBody
	public AjaxResult getstockdetail(HttpServletRequest request, String invInventoryId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取库存管理详情", "操作人ID为：" + getLoginName(request) + "获取库存管理详情",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  测试代码
			// 逻辑
			if(StringUtils.isEmpty(invInventoryId)){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能为空");
			}
			InvInventory dto = invInventoryService.getStockOne(invInventoryId);
			return AjaxResult.createSuccessResult(fomatbyDto(request,logBatch,dto));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取库存管理详情",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}

	/**
	 * 更新库存
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
			super.logInfo(request, logBatch, "更新库存管理详情", "操作人ID为：" + getLoginName(request) + "获取库存管理详情",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  测试代码
			if (invInventoryDto ==null&& invInventoryDto.getInvInventory() ==null &&StringUtils.isEmpty(invInventoryDto.getInvInventory().getInventoryId())){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能为空或者对象");
			}
			return AjaxResult.createSuccessResult(invInventoryService.updateStock(invInventoryDto));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "更新库存管理详情",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 新增
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
			super.logInfo(request, logBatch, "新增库存", "操作人ID为：" + getLoginName(request) + "新增库存",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  测试代码
			invInventoryDto.setInvInventory(new InvInventory());
			if (invInventoryDto == null){
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"对象不能为空");
			}
			return AjaxResult.createSuccessResult(invInventoryService.addStock(invInventoryDto));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "新增库存",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	/**
	 * 删除库存 -- --虚拟删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/delectStock")
	@ResponseBody
	public AjaxResult delectStock(HttpServletRequest request, String invInventoryId) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "删除库存", "操作人ID为：" + getLoginName(request) + "删除库存",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(invInventoryId)){
				AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能为空");
			}
			return AjaxResult.createSuccessResult(invInventoryService.deleteStock(invInventoryId));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "删除库存",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}

	/**
	 * 
	 * @author shmily
	 * @Title: fomatbyDto 
	 * @Description: ( 转换Dto ) 
	 * @param inventory
	 * @return InvInventoryDto
	 * @throws
	 */
	@SuppressWarnings("unused")
	private  InvInventoryDto fomatbyDto(HttpServletRequest request, String logBatch,InvInventory ins) {
		InvInventoryDto dto = new InvInventoryDto();
		dto.setInvInventory(ins);
		// 查询出买家信息
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
		//查询出卖家信息
		BaseCompany seller  = null;
		if(!StringUtils.isEmpty(ins.getSellerId())) {
			seller = baseService.getBaseCompany(ins.getSellerId());
		}
		
		if (seller !=null) {
			String sellerName = seller.getCompanyName();
			dto.setSellerName(sellerName);
		}
		
		// 仓库
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
		// 材质
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
		
		//  表面
		BaseProcess baseProcess = null;
		if(!StringUtils.isEmpty(ins.getSurfaceId())) {
			 baseProcess = baseService.getBaseProcess(ins.getSurfaceId());
		}
		if (baseProcess !=null) {
			dto.setSurfaceName(baseProcess.getProcessName());
		}
		// 品名
		BaseProduct baseProduct = null;
		if(!StringUtils.isEmpty(ins.getProductId())) {
			baseProduct = baseService.getBaseProductById(ins.getProductId());
		}
		if (baseProduct != null) {
			String productName = baseProduct.getProductName();
			dto.setProductName(productName);
			dto.setBaseProduct(baseProduct);
		}
		// 合同
		ConContract  conContract = null;
		if(!StringUtils.isEmpty(ins.getContractId())) {
			conContract = contractService.getConContractById(ins.getContractId());
		}
		if (conContract !=null) {
			dto.setConContract(conContract);
		} 
		// 厂家
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
		// 查询出照片
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
	 * @Description: ( 整理批量转换Dto  ) 
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
	 * @Description: (  PageInfo ---> PageInfo 为了对应页面上的分页信息 ) 
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
	 * 导出库存Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_INVENTORY_EXCEL")
	@RequestMapping("/exportExcel")
	@ResponseBody
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("库存数据表","UTF-8") + ".xls");
		//编码
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
			
		//库存信息
		List<InvInventory>  list= invInventoryService.getStockAll(dto,true);
		if (list != null && !list.isEmpty()) {
			for (InvInventory inv : list) {
				InvInventoryExcel invInventoryExcel = new InvInventoryExcel();
				BeanUtils.copyProperties(inv, invInventoryExcel);
				// 设置卖方
				if(!StringUtils.isEmpty(inv.getSellerId())) {
					BaseCompany seller = baseService.getBaseCompany(inv.getSellerId());
					invInventoryExcel.setSellerName(seller.getCompanyName());
				}
				// 设置买方
				if(!StringUtils.isEmpty(inv.getBuyerId())) {
					Map<String, Object> resultBuyer = getCrmClient(request, inv.getBuyerId());
					CrmClient crmClientBuyer = (CrmClient) resultBuyer.get("data");
					invInventoryExcel.setBuyerName(crmClientBuyer.getClientName());
				}
				// 设置仓库
				if(!StringUtils.isEmpty(inv.getStorageId())) {
					Map<String, Object> storage = getDictMallDepot(request, inv.getStorageId());
					DictMallDepot dictMallDepot = (DictMallDepot) storage.get("data");
					invInventoryExcel.setStorageName(dictMallDepot.getDptName());
				}
				// 设置厂家
				if (!StringUtils.isEmpty(inv.getMnfctId())) {
					Map<String, Object> resultMallMnfct = getDictMallMnfct(request, inv.getMnfctId());
					DictMallMnfct dictMallMnfct = (DictMallMnfct) resultMallMnfct.get("data");
					invInventoryExcel.setMallMnfct(dictMallMnfct.getMnfctName());
				}
				// 设置品名
				if (!StringUtils.isEmpty(inv.getProductId())) {
					BaseProduct product = baseService.getBaseProductById(inv.getProductId());
					invInventoryExcel.setProductName(product.getProductName());
					// 设置净重单位
					invInventoryExcel.setNetWeight(inv.getNetWeight().divide(product.getUnitRate(), product.getPrecision().intValue(), BigDecimal.ROUND_HALF_DOWN).toString());
					invInventoryExcel.setNetWeight(invInventoryExcel.getNetWeight() + product.getWeightUnit());
					// 设置数量单位
					invInventoryExcel.setQuantity(inv.getQuantity() + product.getQuantityUnit());
					// 设置合同单价单位
					if (!StringUtils.isEmpty(inv.getContractUnitPrice())) {
						invInventoryExcel.setContractUnitPrice(inv.getContractUnitPrice() + "元/" + product.getWeightUnit());
					}
					// 设置实际单价单位
					if (!StringUtils.isEmpty(inv.getRealUnitPrice())) {
						invInventoryExcel.setRealUnitPrice(inv.getRealUnitPrice() + "元/" + product.getWeightUnit());
					}
				}
				if (!StringUtils.isEmpty(inv.getContractId())) {
					// 设置合同自编号
					ConContractVo vo  = contractService.getConContractById(inv.getContractId());
					invInventoryExcel.setContractCode(vo.getContractCode());
					// 设置合同编号
					invInventoryExcel.setContractNo(vo.getContractNo());
				}
				list1.add(invInventoryExcel);
				
			}
			
		}
		
		ExportParams params1 = new ExportParams() ;  
        // 设置sheet得名称  
        params1.setSheetName("库存信息"); 
          
        // 创建sheet1使用得map  
        Map dataMap1 = new HashMap<>();  
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName  
        dataMap1.put("title",params1) ;  
        // 模版导出对应得实体类型  
        dataMap1.put("entity",InvInventoryExcel.class) ;  
        // sheet中要填充得数据  
        dataMap1.put("data",list1) ; 
        
        // 将sheet1和sheet2使用得map进行包装  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);  
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
		
	}
	
	
	
	
	
	/**
	 * 单条库存的盘点明细
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectCheckInv")
	@ResponseBody
	public AjaxResult selectCheckInv(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "单条库存的盘点明细", "操作人ID为：" + getLoginName(request) + "单条库存的盘点明细",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			if (StringUtils.isEmpty(id)){
				AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED,"ID不能为空");
			}
			return AjaxResult.createSuccessResult(invInventoryService.selectCheckDetail(id));
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "单条库存的盘点明细",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	
	
	
}
