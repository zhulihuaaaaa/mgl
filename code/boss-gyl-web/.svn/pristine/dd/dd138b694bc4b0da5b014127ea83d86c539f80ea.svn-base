package com.maigangle.gyl.web.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.maigangle.erp.common.api.ApiResult;
import com.maigangle.erp.common.base.SessionInfo;
import com.maigangle.gyl.web.exception.GylApiException;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 供应链提供api
 * 
 * @author zhuh
 * @since 2017年11月6日 上午9:05:26
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/gyl")
public class GylApi {

	@ApiOperation(value = "供应链模块", notes = "测试api", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String getTdByCrtId(HttpServletRequest request,
			@ApiParam(value = "合同ID，以逗号分割") @RequestParam(required = true) String crtIds,
			@ApiParam(value = "交易号") @RequestParam(required = true) String traderId,
			@ApiParam(value = "日志批次号") @RequestParam(required = true) String logBatch,
			@ApiParam(value = "授权token") @RequestParam(required = true) String token) {

		ApiResult apiResult = null;
		try {
//			List<AcntUserBasic> AcntUserBasics = new ArrayList<AcntUserBasic>();
			// TODO 相关业务逻辑
			apiResult = new ApiResult(ApiResult.STATE_CODE_SUCCESS, "根据合同号获取提单信息成功", null);
		} catch (GylApiException e) {
			e.printStackTrace();
			apiResult = new ApiResult(e.getErrorCode(), e.getMsg(), null);
		}
		return JSONObject.toJSONString(apiResult);
	}
}
