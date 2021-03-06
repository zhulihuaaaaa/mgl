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
	 * ????????????????????????
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/findPage")
	@ResponseBody
	public AjaxResult findPageByStock(HttpServletRequest request,@RequestBody PageUtils<ContractBalanceVo> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "????????????????????????", "?????????ID??????" + getLoginName(request) + "????????????????????????",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  ??????????????????
			// ???????????????
			PageInfo<FeeContractBalance> pageinfo= contractService.getContractBalanceAll(page,false);
			if (pageinfo != null && pageinfo.getList() != null && !pageinfo.getList().isEmpty()) {
				for(int i = 0;i < pageinfo.getList().size();i++) {
					// ??????????????????
					pageinfo.getList().get(i).setContract(contractService.getConContractById(pageinfo.getList().get(i).getContractId()));
				}
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
	
	/**
	 * ??????????????????Excel
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@Privilege(key = "GYL_CONTRACTBALANCE_Excel")
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
		FeeContractBalanceDto dto = null;
		if (!StringUtils.isEmpty(param)) {
			JSONObject paramObj = JSONObject.parseObject(param);
			orderByClause = paramObj.getString("orderByClause");
			dto = paramObj.getObject("dto", FeeContractBalanceDto.class);
		} else {
			dto = new FeeContractBalanceDto();
		}
		
		List<ConContractBalanceExcel> list1 = new ArrayList<ConContractBalanceExcel>();
		
		//????????????
		List<ContractBalanceVo> list = contractService.getContractBalances(dto, orderByClause, false);
		if (list != null && !list.isEmpty()) {
			for (ContractBalanceVo vo : list) {
				ConContractBalanceExcel conContractBalanceExcel = new ConContractBalanceExcel();
				BeanUtils.copyProperties(vo, conContractBalanceExcel);
				if (!StringUtils.isEmpty(vo.getContractId())) {
					// ?????????????????????
					ConContractVo vos  = contractService.getConContractById(vo.getContractId());
					conContractBalanceExcel.setContractCode(vos.getContractCode());
					// ??????????????????
					conContractBalanceExcel.setContractNo(vos.getContractNo());
				}
				list1.add(conContractBalanceExcel);
				
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
        dataMap1.put("entity",ConContractBalanceExcel.class) ;  
        // sheet?????????????????????  
        dataMap1.put("data",list1) ;  
        
        
        // ???sheet1???sheet2?????????map????????????  
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1); 
        
	    Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
	    workbook.write(response.getOutputStream());
	}
}	
