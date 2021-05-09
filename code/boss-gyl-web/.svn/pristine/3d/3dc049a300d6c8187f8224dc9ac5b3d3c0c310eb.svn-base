package com.maigangle.gyl.web.controller.base;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maigangle.erp.common.annotation.Privilege;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.BaseProductDto;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.web.controller.GylBaseWeb;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;
/**
 * 品名设置Controller
 * @author 张渊
 * @since 2017年11月29日 上午11:36:37
 * @version 1.0
 */
@Controller
@RequestMapping("/baseProduct")
public class BaseProductController extends GylBaseWeb {
	@Autowired
	BaseService baseService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView("/baseProduct/baseProductIndex");
		return modelAndView;
	}
	@RequestMapping("/main-demo")
	public ModelAndView mainDemo() {
		ModelAndView modelAndView = new ModelAndView("/baseProduct/baseProductIndex-demo");
		return modelAndView;
	}
	@RequestMapping("/detail")
	public ModelAndView detail() {
		ModelAndView modelAndView = new ModelAndView("/baseProduct/baseProductDetail-demo");
		// 可在此向页面赋值
		return modelAndView;
	}
	@RequestMapping("/computed-fee")
	public ModelAndView computedFee() {
		ModelAndView modelAndView = new ModelAndView("/baseProduct/computedFee");
		return modelAndView;
	}
	
	@Privilege(key = "GYL_BASEPRODUCT_ADD")
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(HttpServletRequest request, @RequestBody BaseProduct baseProduct) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		// 方法必须try catch包住
		try {
			// info日志标准写法 
			super.logInfo(request, logBatch, "添加品名", "操作人ID为：" + getLoginName(request) + "添加品名",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			String checkMsg = this.checkObject(baseProduct);
			if (StringUtils.isEmpty(checkMsg)) {
				//baseProduct.setCreateUser(gylApiService.getCurrentPrivUser().getUserName());
				
				Map<String, Object> result = getCurrentPrivUser(request);
				if (!(boolean)result.get("isSuccess")) {
					return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户数据异常," + result.get("msg"));
				}
				PrivUser privUser = (PrivUser) result.get("data");
				baseProduct.setCreateUser(privUser.getUserName());
				
				baseProduct.setCreateDate(new Date());
				baseProduct = baseService.addBaseProduct(baseProduct);
				if (!StringUtils.isEmpty(baseProduct.getProductId())) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.SAVE_SUCCESS, baseProduct);
				}
			} else{
				return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(request, logBatch, "添加品名",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.SAVE_FAILED);
	}
	
	@Privilege(key = "GYL_BASEPRODUCT_EDIT")
	@PostMapping("/update")
	@ResponseBody
	public AjaxResult update(HttpServletRequest request, @RequestBody BaseProduct baseProduct) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		// 方法必须try catch包住
		try {
			// info日志标准写法 
			super.logInfo(request, logBatch, "更新品名", "操作人ID为：" + getLoginName(request) + "更新品名",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			String checkMsg = this.checkObject(baseProduct);
			if (StringUtils.isEmpty(checkMsg)) {
				baseProduct = baseService.updateBaseProduct(baseProduct);
				return AjaxResult.createSuccessResultWithCode(MessageCode.UPDATE_SUCCESS);
			} else if(StringUtils.isEmpty(baseProduct)) {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, "品名id不能为空");
			} else {
				return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED, checkMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(request, logBatch, "更新品名",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.UPDATE_FAILED);
	}
	@Privilege(key = "GYL_BASEPRODUCT_DELETE")
	@GetMapping("/delete")
	@ResponseBody
	public AjaxResult deleteBaseProduct(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		// 方法必须try catch包住
		try {
			// info日志标准写法
			super.logInfo(request, logBatch, "删除品名", "操作人ID为：" + getLoginName(request) + "删除品名",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED, "品名id不能为空");
			} else {
				int row = baseService.deleteBaseProduct(id);
				if (row > 0) {
					return AjaxResult.createSuccessResultWithCode(MessageCode.DELETE_SUCCESS);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(request, logBatch, "删除品名",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.DELETE_FAILED);
	}
	
	@RequestMapping("/findPage")
	@ResponseBody
	public AjaxResult findPage(HttpServletRequest request, @RequestBody PageUtils<BaseProductDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		// 方法必须try catch包住
		try {
			// info日志标准写法 
			super.logInfo(request, logBatch, "查询品名并分页", "操作人ID为：" + getLoginName(request) + "查询品名并分页",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			return AjaxResult.createSuccessResult(baseService.getBaseProducts(page, false));
		} catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(request, logBatch, "查询品名并分页",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public AjaxResult findAll(HttpServletRequest request, @RequestBody PageUtils<BaseProductDto> page) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		// 方法必须try catch包住
		try {
			// info日志标准写法 
			super.logInfo(request, logBatch, "查询品名", "操作人ID为：" + getLoginName(request) + "查询品名",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			return AjaxResult.createSuccessResult(baseService.getBaseProducts(page.getDto(), page.getOrderByClause(), false));
		} catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(request, logBatch, "查询品名",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	@RequestMapping("/findOne")
	@ResponseBody
	public AjaxResult findOne(HttpServletRequest request, String id) {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		// 方法必须try catch包住
		try {
			// info日志标准写法 
			super.logInfo(request, logBatch, "根据ID查询品名", "操作人ID为：" + getLoginName(request) + "根据ID查询品名",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			//  进行相关逻辑编写
			if (StringUtils.isEmpty(id)) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "品名id不能为空");
			} else {
				return AjaxResult.createSuccessResult(baseService.getBaseProductById(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// error日志标准写法
			super.logError(request, logBatch, "根据ID查询品名",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED);
	}
	
	/**
	 * 检测必填项是否为空
	 * @param baseProduct
	 * @return
	 */
	private String checkObject(BaseProduct baseProduct) {
		if (baseProduct != null) {
			String baseStr = "不能为空";
			if (StringUtils.isEmpty(baseProduct.getProductName())) {
				return "品名" + baseStr;
			} else if (productNameIsExist(baseProduct)) {
				return "品名已存在";
			}
			if (StringUtils.isEmpty(baseProduct.getQuantityUnit())) {
				return "数量单位" + baseStr;
			}
			if (StringUtils.isEmpty(baseProduct.getWeightUnit())) {
				return "重量单位" + baseStr;
			}
			if (baseProduct.getPrecision() == null) {
				return "精确度" + baseStr;
			}
			if (baseProduct.getUnitRate() == null) {
				return "单位进率" + baseStr;
			}
			return "";
		}
		return "品名对象不能为空";
	}
	/**
	 * 检测品名是否已存在
	 * @param productName
	 * @return
	 */
	private boolean productNameIsExist(BaseProduct product) {
		BaseProductDto old = new BaseProductDto();
		old.setProductName(product.getProductName());
		List<BaseProduct> list = baseService.getBaseProducts(old, null, true);
		if (list != null && list.size() > 0) {
			if (StringUtils.isEmpty(product.getProductId())) {
				return true;
			} else if (!StringUtils.pathEquals(product.getProductId(), list.get(0).getProductId())) {
				return true;
			}
		}
		return false;
	}
}
