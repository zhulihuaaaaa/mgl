package com.maigangle.gyl.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.ConContractDetail;
import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.BaseProductDto;
import com.maigangle.gyl.facade.entity.excel.importExcel.ConContractDetailImportExcel;
import com.maigangle.gyl.facade.entity.excel.importExcel.InsInspectionBillImportExcel;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

/**
 * 导入Excel
 * @author 杨思静
 * @since  2018年3月13日 - 下午5:42:14
 * @version 1.1
 */
@Controller
@RequestMapping("/import")
public class ImportController extends GylBaseWeb {
	@Autowired
	private BaseService baseService;
 	
	/**
	 * 验货单货物查询
	 * @author shmily
	 * @Title: uplaodFile 
	 * @Description: (  ) 
	 * @param request
	 * @param response
	 * @param multipartfile
	 * @return
	 * @throws IOException AjaxResult
	 * @throws
	 */
	@RequestMapping("/insInspection")
	@ResponseBody
	public AjaxResult uplaodInsInspectionExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile multipartfile) throws IOException {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "导入文件文件", "操作人ID为：" + getLoginName(request) + "上传文件",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  上传文件实现
			InputStream is = multipartfile.getInputStream();
			ImportParams params = new ImportParams();
			List<InsInspectionBillImportExcel> list = ExcelImportUtil.importExcel(is,
			          InsInspectionBillImportExcel.class, params);
			List<InsInspectionDetail> detailList = new ArrayList<InsInspectionDetail>();
			for (InsInspectionBillImportExcel ins : list) {
				InsInspectionDetail detail = new InsInspectionDetail();
				//品类
				if(!StringUtils.isEmpty(ins.getProductName())) {
					 PageUtils<BaseProductDto> page = new  PageUtils<BaseProductDto>();
					 BaseProductDto dto = new BaseProductDto();
					 dto.setProductName(ins.getProductName());
					 PageInfo<BaseProduct> pageInfo = baseService.getBaseProducts(page, false);
					 List<BaseProduct> baseProduct = pageInfo.getList();
					 if (!baseProduct.isEmpty()) {
						 detail.setProductId(baseProduct.get(0).getProductId());
					 }
				}
				// 材质
				if(!StringUtils.isEmpty(ins.getMaterialId())) {
					detail.setMaterialId(ins.getMaterialId());
				}
				// 钢卷号
				if(!StringUtils.isEmpty(ins.getGoodsVolume())) {
					detail.setGoodsVolume(ins.getGoodsVolume());
				}
				// *规格
				if(!StringUtils.isEmpty(ins.getSpecification())) {
					System.out.println(ins.getSpecification());
					String str =ins.getSpecification();
					String[] arr = str.split("\\*");
					System.out.println(arr.length);
					if (arr.length == 3) {
						detail.setGoodsLength(arr[0]);
						detail.setLabelWidth(arr[1]);
						detail.setLabelThick(arr[2]);
					}
				}
				// 参厚
				if(!StringUtils.isEmpty(ins.getReferThick())) {
					detail.setReferThick(ins.getReferThick());
				}
				// 实宽
				if(!StringUtils.isEmpty(ins.getRealWidth())) {
					detail.setRealWidth(ins.getRealWidth());
				}
				// 边部
				if(!StringUtils.isEmpty(ins.getEdge())) {
					detail.setEdge(ins.getEdge());
				}
				// 等级
				if(!StringUtils.isEmpty(ins.getGrade())) {
					detail.setGrade(ins.getGrade());
				}
				// *牌号
				if(!StringUtils.isEmpty(ins.getTrademark())) {
					System.out.println(ins.getTrademark());
					detail.setTrademark(ins.getTrademark());
				}
				// *表面
				if(!StringUtils.isEmpty(ins.getSurfaceId())) {
					detail.setSurfaceId(ins.getSurfaceId());
				}
				// *重量
				if(ins.getNetWeight()!=null) {
					detail.setNetWeight(ins.getNetWeight());
				}
				// *数量
				if(ins.getAmount()!=null) {
					detail.setAmount(ins.getAmount());
				}
				// 厂家
				if(!StringUtils.isEmpty(ins.getMnfctId())) {
					Map<String, Object> result = getAllDictMallMnfctByName(request, ins.getMnfctId());
					if (!(boolean) result.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户信息异常，" + result.get("msg"));
					}
					List<DictMallMnfct> mnfctList = (List<DictMallMnfct>) result.get("data");
					if (mnfctList !=null&&!mnfctList.isEmpty()) {
						detail.setMnfctId(mnfctList.get(0).getMnfctId());
					}
				}
				
				// *执行标准
				if(!StringUtils.isEmpty(ins.getImplStd())) {
					detail.setImplStd(ins.getImplStd());
				}
				//计算方式
				if(!StringUtils.isEmpty(ins.getCalcMethod())) {
					detail.setCalcMethod(ins.getCalcMethod());
				}
				// 备注
				if(!StringUtils.isEmpty(ins.getNotes())) {
					detail.setNotes(ins.getNotes());
				}
				
//				BeanUtils.copyProperties(insInspectionBillImportExcel, detail);
				detailList.add(detail);
			}
			return AjaxResult.createSuccessResult(detailList);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "上传文件",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "上传失败");
	}
	
	/**
	 * 合同货物查询
	 * @author shmily
	 * @Title: uplaodFile 
	 * @Description: (  ) 
	 * @param request
	 * @param response
	 * @param multipartfile
	 * @return
	 * @throws IOException AjaxResult
	 * @throws
	 */
	@RequestMapping("/contract")
	@ResponseBody
	public AjaxResult uplaodContractExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile multipartfile) throws IOException {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "导入文件文件", "操作人ID为：" + getLoginName(request) + "上传文件",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  上传文件实现
			InputStream is = multipartfile.getInputStream();
			ImportParams params = new ImportParams();
			List<ConContractDetailImportExcel> list = ExcelImportUtil.importExcel(is,
					ConContractDetailImportExcel.class, params);
			List<ConContractDetail> detailList = new ArrayList<ConContractDetail>();
			for (ConContractDetailImportExcel con : list) {
				ConContractDetail detail = new ConContractDetail();
//				BeanUtils.copyProperties(conContractDetailImportExcel, detail);
				//品类
				if(!StringUtils.isEmpty(con.getProductName())) {
					 PageUtils<BaseProductDto> page = new  PageUtils<BaseProductDto>();
					 BaseProductDto dto = new BaseProductDto();
					 dto.setProductName(con.getProductName());
					 PageInfo<BaseProduct> pageInfo = baseService.getBaseProducts(page, false);
					 List<BaseProduct> baseProduct = pageInfo.getList();
					 if (!baseProduct.isEmpty()) {
						 detail.setProductId(baseProduct.get(0).getProductId());
					 }
				}
				// 材质
				if(!StringUtils.isEmpty(con.getMaterialId())) {
					detail.setMaterialId(con.getMaterialId());
				}
				// 参厚referThick
				if(!StringUtils.isEmpty(con.getReferThick())) {
					detail.setReferThick(con.getReferThick());
					detail.setReferThick(con.getReferThick());
				}
				// 宽度
				if(!StringUtils.isEmpty(con.getLabelWidth())) {
					detail.setLabelWidth(con.getLabelWidth());
				}
				// 厚度
				if(!StringUtils.isEmpty(con.getLabelThick())) {
					detail.setLabelThick(con.getLabelThick());
				}
				// 长度
				if(!StringUtils.isEmpty(con.getGoodsLength())) {
					detail.setGoodsLength(con.getGoodsLength());
				}
				// 边部
				if(!StringUtils.isEmpty(con.getEdge())) {
					detail.setEdge(con.getEdge());
				}
				// *表面
				if(!StringUtils.isEmpty(con.getSurfaceId())) {
					detail.setSurfaceId(con.getSurfaceId());
				}
				// *重量
				if(con.getNetWeight()!=null) {
					detail.setNetWeight(con.getNetWeight());
				}
				// 厂家
				if(!StringUtils.isEmpty(con.getMnfctId())) {
					Map<String, Object> result = getAllDictMallMnfctByName(request, con.getMnfctId());
					if (!(boolean) result.get("isSuccess")) {
						return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户信息异常，" + result.get("msg"));
					}
					List<DictMallMnfct> mnfctList = (List<DictMallMnfct>) result.get("data");
					if (mnfctList !=null&&!mnfctList.isEmpty()) {
						detail.setMnfctId(mnfctList.get(0).getMnfctId());
					}
				}
				
				// 含税单价
				if(con.getUnitContractPrice()!=null) {
					detail.setUnitContractPrice(con.getUnitContractPrice());
				}
				// 含税金额
				if(con.getContractMoney()!=null) {
					detail.setContractMoney(con.getContractMoney());
				}
				// 备注
				if(!StringUtils.isEmpty(con.getNotes())) {
					detail.setNotes(con.getNotes());
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				detailList.add(detail);
			}
			return AjaxResult.createSuccessResult(detailList);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "上传文件",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "上传失败");
	}
	


}
