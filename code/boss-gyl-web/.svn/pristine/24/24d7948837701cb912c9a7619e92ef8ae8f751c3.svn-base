package com.maigangle.gyl.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.erp.common.log.EnumMonitorLog;
import com.maigangle.erp.common.log.LogBatchUtil;
import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.web.util.AjaxResult;
import com.maigangle.gyl.web.util.MessageCode;

/**
 * 
 * @author 杨思静
 * @since  2018年1月17日 - 下午1:27:40
 * @version 1.0
 */
@Controller
@RequestMapping("/base")
public class FileOperaController extends GylBaseWeb{
		
	
	/**
	 * 上传功能实例
	 * 
	 * @param request
	 * @param response
	 * @param multipartfiles
	 * @throws IOException
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public AjaxResult uplaodFile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile multipartfile) throws IOException {
		String logBatch = LogBatchUtil.getLogUUID(EnumMonitorLog.LOGSYSTEM_GYL.getKey());
		try {
			super.logInfo(request, logBatch, "上传文件", "操作人ID为：" + getLoginName(request) + "上传文件",
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
			Map<String, Object> result = getCurrentPrivUser(request);
			if (!(boolean) result.get("isSuccess")) {
				return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "获取当前用户信息异常，" + result.get("msg"));
			}
			PrivUser user = (PrivUser) result.get("data");
			String filePath = "";
			//  上传文件实现
			
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("data", request.getParameter("data"));
			Attach attach = new Attach();
			attach.setFileName(multipartfile.getOriginalFilename());
			attach.setAttachId(UUID.randomUUID().toString().replaceAll("-", ""));
			attach.setFilePath(filePath);
			attach.setCreateTime(new Date());
			attach.setCrtearUser(user.getUserName());
			resultMap.put("attach", attach);
			return AjaxResult.createSuccessResult(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			super.logError(request, logBatch, "上传文件",
					"操作人ID为：" + getLoginName(request) + "错误信息为：" + ExceptionUtils.getStackTrace(e), false,
					EnumMonitorLog.LOGSYSTEM_SETTLEMENT.getKey());
		}
		return AjaxResult.createErrorResult(MessageCode.OPERATE_FAILED, "上传失败");
	}
	
	
	
}
