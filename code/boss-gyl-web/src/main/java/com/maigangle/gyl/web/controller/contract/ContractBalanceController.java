package com.maigangle.gyl.web.controller.contract;

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
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.FeeBalance;
import com.maigangle.gyl.facade.entity.FeeContractBalance;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.dto.ConContractDto;
import com.maigangle.gyl.facade.entity.dto.FeeContractBalanceDto;
import com.maigangle.gyl.facade.entity.dto.InvoiceGoodsConditionDto;
import com.maigangle.gyl.facade.entity.excel.ConContractBalanceExcel;
import com.maigangle.gyl.facade.entity.excel.ConContractDetailExcel;
import com.maigangle.gyl.facade.entity.excel.ConContractExcel;
import com.maigangle.gyl.facade.entity.vo.ConContractDetailVo;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.ContractBalanceVo;
import com.maigangle.gyl.facade.entity.vo.FeeBalanceVo;
import com.maigangle.gyl.facade.entity.vo.InvoiceGoodsConditionVo;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

@Controller
@RequestMapping("/contractBalance")
public class ContractBalanceController extends GylBaseWeb{
	@Autowired
	private BaseService baseService;
	@Autowired
	private ContractService contractService;

	@Privilege(key = "GYL_CONTRACTBALANCE_VIEW")
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/contract/contractBalanceIndex");
		return modelAndView;
	}
	
	/**
	 * 获取余额列表详情
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/findPage")
	@ResponseBody
	public AjaxResult findPageByStock(HttpServletRequest request,@RequestBody PageUtils<ContractBalanceVo> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "获取库存管理列表", "操作人ID为：" + getLoginName(request) + "获取库存管理列表",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  查询分页页面
			// 正式的逻辑
			PageInfo<FeeContractBalance> pageinfo= contractService.getContractBalanceAll(page,false);
			if (pageinfo != null && pageinfo.getList() != null && !pageinfo.getList().isEmpty()) {
				for(int i = 0;i < pageinfo.getList().size();i++) {
					// 设置合同信息
					pageinfo.getList().get(i).setContract(contractService.getConContractById(pageinfo.getList().get(i).getContractId()));
				}
			}
			return AjaxResult.createSuccessResult(pageinfo);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "获取库存管理列表",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 导出合同对账Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_CONTRACTBALANCE_Excel")
	@RequestMapping("/exportExcel")
	@ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("合同对账表","UTF-8") + ".xls");
		//编码
		response.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");
		String orderByClause = null;
		FeeContractBalanceDto dto = null;
		if (!StringUtils.isEmpty(param)) {
			JSONObject paramObj = JSONObject.parseObject(param);
			orderByClause = paramObj.getString("orderByClause");
			dto = paramObj.getObject("dto", FeeContractBalanceDto.class);
		} else {
			dto = new FeeContractBalanceDto();
		}
		
		List<ConContractBalanceExcel> list1 = new ArrayList<ConContractBalanceExcel>();
		
		//合同信息
		List<ContractBalanceVo> list = contractService.getContractBalances(dto, orderByClause, false);
		if (list != null && !list.isEmpty()) {
			for (ContractBalanceVo vo : list) {
				ConContractBalanceExcel conContractBalanceExcel = new ConContractBalanceExcel();
				BeanUtils.copyProperties(vo, conContractBalanceExcel);
				if (!StringUtils.isEmpty(vo.getContractId())) {
					// 设置合同自编号
					ConContractVo vos  = contractService.getConContractById(vo.getContractId());
					conContractBalanceExcel.setContractCode(vos.getContractCode());
					// 设置合同编号
					conContractBalanceExcel.setContractNo(vos.getContractNo());
				}
				list1.add(conContractBalanceExcel);
				
			}
			
		}
		
		ExportParams params1 = new ExportParams() ;  
        // 设置sheet得名称  
        params1.setSheetName("合同对账"); 
          
        // 创建sheet1使用得map  
        Map dataMap1 = new HashMap<>();  
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName  
        dataMap1.put("title",params1) ;  
        // 模版导出对应得实体类型  
        dataMap1.put("entity",ConContractBalanceExcel.class) ;  
        // sheet中要填充得数据  
        dataMap1.put("data",list1) ;  
        
        
        // 将sheet1和sheet2使用得map进行包装  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1); 
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
	}
}	
