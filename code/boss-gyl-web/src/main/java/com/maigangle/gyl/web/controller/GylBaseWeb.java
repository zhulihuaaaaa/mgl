package com.maigangle.gyl.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.maigangle.erp.common.base.BaseWeb;
import com.maigangle.erp.common.constants.AuthUrlConstant;
import com.maigangle.erp.common.util.CallApiMsgUtil;
import com.maigangle.erp.common.util.CallApiUtil;
import com.maigangle.gyl.facade.constant.GylGlobalConstant;
import com.maigangle.gyl.facade.entity.BaseInfo;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictGrade;
import com.maigangle.gyl.facade.entity.api.DictMallDepot;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;
import com.maigangle.gyl.facade.entity.api.DictMallSpec;
import com.maigangle.gyl.facade.entity.api.DictSeries;
import com.maigangle.gyl.facade.entity.api.DictStd;
import com.maigangle.gyl.facade.entity.api.DictTradeMark;
import com.maigangle.gyl.facade.entity.api.PrivRole;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.api.Surface;
import com.maigangle.gyl.facade.service.BaseService;

/**
 * 所有Controller必须继承，其中调用api 及公共方法请放在此地方
 * 
 * @author Administrator
 *
 */
public class GylBaseWeb extends BaseWeb {
	@Autowired
	private BaseService baseService;
	/**
	 * 测试调用api方法
	 * 
	 * @param request
	 * @param logBatch
	 * @param firmId
	 * @param wareIdList
	 * @param token
	 * @return
	 */
	protected Map<String, Object> getCartWareInfo(HttpServletRequest request, String firmId,
			List<String> wareIdList,String token) {
		Map<String, String> gangApiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String wareIds = StringUtils.join(wareIdList.toArray(), ",");
		String url = getUrl(AuthUrlConstant.CRM_URL) + "/api/flatApi/getWareInfoApi";
		gangApiMap.put("wareIds", wareIds);
		gangApiMap.put("traderId", firmId);
		gangApiMap.put("token", "");
		String apiResult = CallApiUtil.CallApi(url, gangApiMap);
		if (!CallApiMsgUtil.operaIsSuccess(apiResult)) {
			resultMap.put("isSuccess", false);
			resultMap.put("msg", CallApiMsgUtil.getErrorMsg(apiResult));
			return resultMap;
		}
		resultMap.put("data", null);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	/**
	 * 根据客户名称精确检索客户列表<br/>
	 * clientName为空时可返回任意客户，<br/>
	 * 返回数据最大数量不超过size指定数据量
	 * @param request
	 * @param clientName 客户名
	 * @author 张渊
	 * @return {@code
	 * 		data: List<CrmClient>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getALLCrmClient(HttpServletRequest request, String clientName) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		
		CrmClient crmClient = new CrmClient();
		// 模拟数据
		switch (clientName) {
		case "client_one":
			crmClient.setClientId("41ebc43438722f50d61713fcdf9a09b9");
			crmClient.setClientName("client_one");
			crmClient.setMobile("18300002266");
			break;
		case "client_two":
			crmClient.setClientId("6e59687c418c8401c97939e7f7727127");
			crmClient.setClientName("client_two");
			crmClient.setMobile("13662652008");
			break;
		case "client_three":
			crmClient.setClientId("fce00244646dd23ad786a828c72a40d3");
			crmClient.setClientName("client_three");
			crmClient.setMobile("13828887260");
			break;
		default:
			resultMap.put("isSuccess", false);
			return resultMap;
	}
		//
		List<CrmClient> resultList = new ArrayList<>();

		resultList.add(crmClient);
		
		resultMap.put("data", resultList);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	/**
	 * 根据客户ID获取客户对象
	 * @param request
	 * @param clientName 客户ID
	 * @author 张渊
	 * @return {@code
	 * 		data: CrmClient,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getCrmClient(HttpServletRequest request, String clientId) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		
		// 模拟数据
		CrmClient crmClient = new CrmClient();
		switch (clientId) {
			case "41ebc43438722f50d61713fcdf9a09b9":
				crmClient.setClientId("41ebc43438722f50d61713fcdf9a09b9");
				crmClient.setClientName("client_one");
				crmClient.setMobile("18300002266");
				break;
			case "6e59687c418c8401c97939e7f7727127":
				crmClient.setClientId("6e59687c418c8401c97939e7f7727127");
				crmClient.setClientName("client_two");
				crmClient.setMobile("13662652008");
				break;
			case "fce00244646dd23ad786a828c72a40d3":
				crmClient.setClientId("fce00244646dd23ad786a828c72a40d3");
				crmClient.setClientName("client_three");
				crmClient.setMobile("13828887260");
				break;
			default:
				resultMap.put("isSuccess", false);
				return resultMap;
		}
		
		resultMap.put("data", crmClient);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 获取所有仓库数据
	 * @param request
	 * @author 张渊
	 * @return {@code
	 * 		data: List<DictMallDepot>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getAllDictMallDepot(HttpServletRequest request) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		
		// 模拟数据
		List<DictMallDepot> result = new ArrayList<>();
		DictMallDepot dictMallDepot = new DictMallDepot();
		dictMallDepot.setDptId("c44646d1cdbf7071228165bee69bdad8");
		dictMallDepot.setDptName("一号库");
		dictMallDepot.setDptShortName("一号库");
		dictMallDepot.setContact("client_one");
		dictMallDepot.setFixedPhone("0510-88885555");
		dictMallDepot.setMobile("13828887260");
		dictMallDepot.setFax("0510-88885555");
		dictMallDepot.setAddress("江苏省无锡市滨湖区太湖街道申");
		result.add(dictMallDepot);
		
		dictMallDepot = new DictMallDepot();
		dictMallDepot.setDptId("85568f330d9b96da787b05c70c1cc2e5");
		dictMallDepot.setDptName("二号库");
		dictMallDepot.setDptShortName("二号库");
		dictMallDepot.setContact("client_two");
		dictMallDepot.setFixedPhone("0510-88833666");
		dictMallDepot.setMobile("13828887260");
		dictMallDepot.setFax("0510-88833666");
		dictMallDepot.setAddress("江苏省无锡市滨湖区华庄街道水乡苑第一社区");
		result.add(dictMallDepot);
		
		dictMallDepot = new DictMallDepot();
		dictMallDepot.setDptId("b4536005ea4184325abc3e6a56da691a");
		dictMallDepot.setDptName("三号库");
		dictMallDepot.setDptShortName("三号库");
		dictMallDepot.setContact("client_two");
		dictMallDepot.setFixedPhone("0510-55508881");
		dictMallDepot.setMobile("15062465355");
		dictMallDepot.setFax("0510-55508881");
		dictMallDepot.setAddress("江苏省无锡市滨湖区雪浪街道雪浪社区");
		result.add(dictMallDepot);
		
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 根据仓库ID获取仓库信息
	 * @param request
	 * @param dptId 仓库ID
	 * @author 张渊
	 * @return {@code
	 * 		data: DictMallDepot,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getDictMallDepot(HttpServletRequest request, String dptId) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		DictMallDepot dictMallDepot;
		// 虚拟仓库
		if (dptId.equals(GylGlobalConstant.VIRTUAL_MALL_DEPOT)) {
			dictMallDepot = new DictMallDepot();
			BaseInfo info = baseService.getGlobalBaseInfo();
			dictMallDepot.setDptId(GylGlobalConstant.VIRTUAL_MALL_DEPOT);
			dictMallDepot.setDptName(info.getVirtualMallDepot());
			dictMallDepot.setDptShortName(info.getVirtualMallDepot());
		} else {
			// TODO 查询实现
			// 模拟数据
			dictMallDepot = new DictMallDepot();
			switch (dptId) {
				case "c44646d1cdbf7071228165bee69bdad8":
					dictMallDepot.setDptId("c44646d1cdbf7071228165bee69bdad8");
					dictMallDepot.setDptName("一号库");
					dictMallDepot.setDptShortName("一号库");
					dictMallDepot.setContact("client_one");
					dictMallDepot.setFixedPhone("0510-88885555");
					dictMallDepot.setMobile("13828887260");
					dictMallDepot.setFax("0510-88885555");
					dictMallDepot.setAddress("江苏省无锡市滨湖区太湖街道申");
					break;
				case "85568f330d9b96da787b05c70c1cc2e5":
					dictMallDepot.setDptId("85568f330d9b96da787b05c70c1cc2e5");
					dictMallDepot.setDptName("二号库");
					dictMallDepot.setDptShortName("二号库");
					dictMallDepot.setContact("client_two");
					dictMallDepot.setFixedPhone("0510-88833666");
					dictMallDepot.setMobile("13828887260");
					dictMallDepot.setFax("0510-88833666");
					dictMallDepot.setAddress("江苏省无锡市滨湖区华庄街道水乡苑第一社区");
					break;
				case "b4536005ea4184325abc3e6a56da691a":
					dictMallDepot.setDptId("b4536005ea4184325abc3e6a56da691a");
					dictMallDepot.setDptName("三号库");
					dictMallDepot.setDptShortName("三号库");
					dictMallDepot.setContact("client_two");
					dictMallDepot.setFixedPhone("0510-55508881");
					dictMallDepot.setMobile("15062465355");
					dictMallDepot.setFax("0510-55508881");
					dictMallDepot.setAddress("江苏省无锡市滨湖区雪浪街道雪浪社区");
					break;
				case "70F4CF7DCC794C71929F9FAA81E7471A":
					dictMallDepot.setDptId("70F4CF7DCC794C71929F9FAA81E7471A");
					dictMallDepot.setDptName("四号库");
					dictMallDepot.setDptShortName("四号库");
					dictMallDepot.setContact("client_two");
					dictMallDepot.setFixedPhone("0510-55508881");
					dictMallDepot.setMobile("15062465355");
					dictMallDepot.setFax("0510-55508881");
					dictMallDepot.setAddress("江苏省无锡市滨湖区雪浪街道雪浪社区2");
					break;
				default:
					resultMap.put("isSuccess", false);
					return resultMap;
			}
		}
		resultMap.put("data", dictMallDepot);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 检索生产厂家数据 
	 * @param request
	 * @param mnfctName 厂家名称
	 * @author 张渊 
	 * @return {@code
	 * 		data: List<DictMallMnfct>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getAllDictMallMnfct(HttpServletRequest request, String mallMnfctName) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		// 模拟数据
		List<DictMallMnfct> result = new ArrayList<>();
		DictMallMnfct dictMallMnfct = new DictMallMnfct();
		dictMallMnfct.setMnfctId("319c36815342c34969889379cf279ff5");
		dictMallMnfct.setMnfctName("江苏省无锡市第一生产工厂");
		dictMallMnfct.setMnfctShortName("无锡一厂");
		result.add(dictMallMnfct);
		dictMallMnfct = new DictMallMnfct();
		dictMallMnfct.setMnfctId("9c37a2a685e503fa38c4327cd5d2dec5");
		dictMallMnfct.setMnfctName("江苏省无锡市第二生产工厂");
		dictMallMnfct.setMnfctShortName("无锡二厂");
		result.add(dictMallMnfct);
		dictMallMnfct = new DictMallMnfct();
		dictMallMnfct.setMnfctId("42665d23693f87b41673ca9094901e48");
		dictMallMnfct.setMnfctName("江苏省无锡市第三生产工厂");
		dictMallMnfct.setMnfctShortName("无锡三厂");
		result.add(dictMallMnfct);
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 根据生产厂家ID检索生产厂家数据
	 * @param request
	 * @param mnfctId 厂家ID
	 * @author 张渊
	 * @return {@code
	 * 		data: DictMallMnfct,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getDictMallMnfct(HttpServletRequest request, String mnfctId) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		
		// 模拟数据
		DictMallMnfct dictMallMnfct = new DictMallMnfct();
		switch (mnfctId) {
			case "319c36815342c34969889379cf279ff5":
				dictMallMnfct.setMnfctId("319c36815342c34969889379cf279ff5");
				dictMallMnfct.setMnfctName("江苏省无锡市第一生产工厂");
				dictMallMnfct.setMnfctShortName("无锡一厂");
				break;
			case "9c37a2a685e503fa38c4327cd5d2dec5":
				dictMallMnfct.setMnfctId("9c37a2a685e503fa38c4327cd5d2dec5");
				dictMallMnfct.setMnfctName("江苏省无锡市第二生产工厂");
				dictMallMnfct.setMnfctShortName("无锡二厂");
				break;
			case "42665d23693f87b41673ca9094901e48":	
				dictMallMnfct.setMnfctId("42665d23693f87b41673ca9094901e48");
				dictMallMnfct.setMnfctName("江苏省无锡市第三生产工厂");
				dictMallMnfct.setMnfctShortName("无锡三厂");
				break;
			default: 
				resultMap.put("isSuccess", false);
				return resultMap;
		}
		
		resultMap.put("data", dictMallMnfct);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 获取材质数据列表
	 * @param request
	 * @author 张渊
	 * @return {@code
	 * 		data: List<DictMallSpec>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getAllDictMallSpec(HttpServletRequest request,String orderCode) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		
		// 模拟数据
		List<DictMallSpec> result = new ArrayList<>();
		DictMallSpec dictMallSpec = new DictMallSpec();
		if("系列3".equals(orderCode)) {
			dictMallSpec.setSpecId("12c18aa6a7be15231e8af836faba0fe1");
			dictMallSpec.setQuality("304");
			result.add(dictMallSpec);
			
			dictMallSpec = new DictMallSpec();
			dictMallSpec.setSpecId("708b8b1df28575400d858ad24e15ec48");
			dictMallSpec.setQuality("409");
			result.add(dictMallSpec);
			
			dictMallSpec = new DictMallSpec();
			dictMallSpec.setSpecId("070f2a419dc21e92943d77a0bd8e230d");
			dictMallSpec.setQuality("410");
			result.add(dictMallSpec);
			dictMallSpec = new DictMallSpec();
			dictMallSpec.setSpecId("070f2a419dc21e92943d77a0bd8e232d");
			dictMallSpec.setQuality("420");
			result.add(dictMallSpec);
		}
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 获取角色数据列表
	 * @param request
	 * @author 张渊
	 * @return {@code
	 * 		data: List<PrivRole>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getAllPrivRole(HttpServletRequest request) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		
		// 模拟数据
		List<PrivRole> result = new ArrayList<>();
		PrivRole privRole = new PrivRole();
		privRole.setRoleId("f34adf346b3e854ad98391670d66ed7d");
		privRole.setRoleCode("001");
		privRole.setRoleName("结算部");
		result.add(privRole);
		
		privRole = new PrivRole();
		privRole.setRoleId("9da0d2f88eca370e9aeaf868eef35c0a");
		privRole.setRoleCode("002");
		privRole.setRoleName("金融服务部");
		result.add(privRole);
		
		privRole = new PrivRole();
		privRole.setRoleId("d461f66d0fab46ab44fbdff6dee4bbcc");
		privRole.setRoleCode("003");
		privRole.setRoleName("财务部");
		result.add(privRole);
		
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 根据角色ID获取角色数据
	 * @param request
	 * @param roleId
	 * @author 张渊
	 * @return {@code
	 * 		data: PrivRole,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getPrivRole(HttpServletRequest request, String roleId) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		
		// 模拟数据
		PrivRole privRole = new PrivRole();
		switch (roleId) {
		case "f34adf346b3e854ad98391670d66ed7d":
			privRole.setRoleId("f34adf346b3e854ad98391670d66ed7d");
			privRole.setRoleCode("001");
			privRole.setRoleName("结算部");
			break;
		case "9da0d2f88eca370e9aeaf868eef35c0a":		
			privRole.setRoleId("9da0d2f88eca370e9aeaf868eef35c0a");
			privRole.setRoleCode("002");
			privRole.setRoleName("金融服务部");
			break;
		case "d461f66d0fab46ab44fbdff6dee4bbcc":
			privRole.setRoleId("d461f66d0fab46ab44fbdff6dee4bbcc");
			privRole.setRoleCode("003");
			privRole.setRoleName("财务部");
			break;
		default:
			resultMap.put("isSuccess", false);
			return resultMap;
		}
		
		resultMap.put("data", privRole);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	/**
	 * 获取当前用户数据
	 * @param request
	 * @author 张渊
	 * @return {@code
	 * 		data: PrivUser,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getCurrentPrivUser(HttpServletRequest request) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		com.maigangle.erp.common.entity.priv.PrivUser user = getSessionInfo(request).getPrivUser();
		if(user ==null) {
			user = new com.maigangle.erp.common.entity.priv.PrivUser();
		}
		String userId="3";
		user.setUserName("王大锤");
		if("1".equals(userId)) {
//			结算部
			user.setUserId("9795d0aa1d6a03d52c08a1cd640481b3");
		}
		if("2".equals(userId)) {
//			财务部
			user.setUserId("9795d0aa1d6a03d52c08a1cd640481b2");
		}
		if("3".equals(userId)) {
//			金融服务部
			user.setUserId("9795d0aa1d6a03d52c08a1cd640481b1");
		}
		user.setMobile("13777777777");
		// 转换出 gyl的facade中的类
		PrivUser privUser = new PrivUser();
		BeanUtils.copyProperties(user, privUser);
		PrivRole privRole = new PrivRole();
//		角色
		if("1".equals(userId)) {
			privRole.setRoleId("f34adf346b3e854ad98391670d66ed7d");
			privRole.setRoleCode("001");
			privRole.setRoleName("结算部");
		}
		if("2".equals(userId)) {
			privRole.setRoleId("d461f66d0fab46ab44fbdff6dee4bbcc");
			privRole.setRoleCode("003");
			privRole.setRoleName("财务部");
		}
		if("3".equals(userId)) {
			privRole.setRoleId("9da0d2f88eca370e9aeaf868eef35c0a");
			privRole.setRoleCode("002");
			privRole.setRoleName("金融服务部");
		}
		privUser.setPrivRole(privRole);
		resultMap.put("data",privUser);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 根据ID获取用户数据
	 * @param request
	 * @param userId
	 * @author 张渊
	 * @return {@code
	 * 		data: PrivUser,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getPrivUser(HttpServletRequest request, String userId) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		// 模拟数据
//		PrivUser privUser = new PrivUser();
//		privUser.setUserId("9795d0aa1d6a03d52c08a1cd640481be");
//		privUser.setUserName("王大锤");
//		privUser.setMobile("13777777777");
		com.maigangle.erp.common.entity.priv.PrivUser user = getSessionInfo(request).getPrivUser();
		if(user ==null) {
			user = new com.maigangle.erp.common.entity.priv.PrivUser();
		}
		user.setUserName("王大锤");
		if("9795d0aa1d6a03d52c08a1cd640481b3".equals(userId)) {
//			结算部
			user.setUserId("9795d0aa1d6a03d52c08a1cd640481b3");
		}
		if("9795d0aa1d6a03d52c08a1cd640481b2".equals(userId)) {
//			财务部
			user.setUserId("9795d0aa1d6a03d52c08a1cd640481b2");
		}
		if("9795d0aa1d6a03d52c08a1cd640481b1".equals(userId)) {
//			金融服务部
			user.setUserId("9795d0aa1d6a03d52c08a1cd640481b1");
		}
		user.setMobile("13777777777");
		// 转换出 gyl的facade中的类
		PrivUser privUser = new PrivUser();
		BeanUtils.copyProperties(user, privUser);
		PrivRole privRole = new PrivRole();
//		角色
		if("9795d0aa1d6a03d52c08a1cd640481b3".equals(userId)) {
			privRole.setRoleId("f34adf346b3e854ad98391670d66ed7d");
			privRole.setRoleCode("001");
			privRole.setRoleName("结算部");
		}
		if("9795d0aa1d6a03d52c08a1cd640481b2".equals(userId)) {
			privRole.setRoleId("d461f66d0fab46ab44fbdff6dee4bbcc");
			privRole.setRoleCode("003");
			privRole.setRoleName("财务部");
		}
		if("9795d0aa1d6a03d52c08a1cd640481b1".equals(userId)) {
			privRole.setRoleId("9da0d2f88eca370e9aeaf868eef35c0a");
			privRole.setRoleCode("002");
			privRole.setRoleName("金融服务部");
		}
		privUser.setPrivRole(privRole);
			
		resultMap.put("data", privUser);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	/**
	 * 获取表面列表
	 * @param request
	 * @author 杨思静
	 * @return {@code
	 * 		data: List<Surface>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getBaseProcess(HttpServletRequest request,String materialName,String orderCode) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		
		// 模拟数据
		List<Surface> result = new ArrayList<Surface>();
		if("304".equals(materialName)) {
			if("系列3".equals(orderCode)) {
				Surface face1 = new Surface();
				face1.setName("表面1");
				result.add(face1);
				Surface face2 = new Surface();
				face2.setName("表面2");
				result.add(face2);
			}
		}
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	/**  
	 * 获取牌号列表   根据品种(系列)和材质
	 * @param request  
	 * @author 杨思静
	 * @return {@code
	 * 		data: List<Surface>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getTrademark(HttpServletRequest request,String materialName,String orderCode) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		// 模拟数据
		List<DictTradeMark> result = new ArrayList<DictTradeMark>();
		if("304".equals(materialName)) {
			if("系列3".equals(orderCode)) {
				DictTradeMark mark = new DictTradeMark();
				mark.setTrademark("牌号1");
				result.add(mark);
				DictTradeMark mark1= new DictTradeMark();
				mark1.setTrademark("牌号2");
				result.add(mark1);
			}
			
			
		}
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	
//	材质、生产厂家 、执行标准、等级是根据品种(系列)查的

//	牌号和表面是根据 品种(系列)和材质查出来的
	
	
	/**
	 * 获取系列列表 
	 * @param request
	 * @author 杨思静
	 * @return {@code
	 * 		data: List<Surface>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getOrderCode(HttpServletRequest request) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		// 模拟数据
		List<DictSeries> result = new ArrayList<>();
		DictSeries dictSeries1 = new DictSeries();
		dictSeries1.setOrderCode("系列1");
		result.add(dictSeries1);
		DictSeries dictSeries2 = new DictSeries();
		dictSeries2.setOrderCode("系列2");
		result.add(dictSeries2);
		DictSeries dictSeries3 = new DictSeries();
		dictSeries3.setOrderCode("系列3");
		result.add(dictSeries3);
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	/**
	 * 获取执行标准列表  根据品种查询
	 * @param request
	 * @author 杨思静
	 * @return {@code
	 * 		data: List<Surface>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getDictStd(HttpServletRequest request,String orderCode) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		// 模拟数据
		List<DictStd> result = new ArrayList<>();
		if("系列3".equals(orderCode)) {
			DictStd dictStd = new DictStd();
			dictStd.setStdName("标准1");
			result.add(dictStd);
			DictStd dictStd1 = new DictStd();
			dictStd1.setStdName("标准2");
			result.add(dictStd1);
		}
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	
	/**
	 * 获取等级列表  根据品种查询
	 * @param request
	 * @author 杨思静
	 * @return {@code
	 * 		data: List<Surface>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getDictGrade(HttpServletRequest request,String orderCode) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		// 模拟数据
		List<DictGrade> result = new ArrayList<>();
		if("系列3".equals(orderCode)) {
			DictGrade dictGrade1 = new DictGrade();
			dictGrade1.setDictName("等级2");
			result.add(dictGrade1);
			DictGrade dictGrade2 = new DictGrade();
			dictGrade2.setDictName("等级1");
			result.add(dictGrade2);
		}
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	
	/**
	 * 检索生产厂家数据 根据品种来查询出货物的生产厂家
	 * @param request
	 * @param mnfctName 厂家名称
	 * @author 张渊 
	 * @return {@code
	 * 		data: List<DictMallMnfct>,
	 * 		isSuccess: Boolean
	 * }
	 */
	public Map<String, Object> getAllDictMallMnfctByOrderCode(HttpServletRequest request, String orderCode) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		// 模拟数据
		List<DictMallMnfct> result = new ArrayList<>();
		if("系列3".equals(orderCode)) {
			DictMallMnfct dictMallMnfct = new DictMallMnfct();
			dictMallMnfct.setMnfctId("319c36815342c34969889379cf279ff5");
			dictMallMnfct.setMnfctName("江苏省无锡市第一生产工厂");
			dictMallMnfct.setMnfctShortName("无锡一厂");
			result.add(dictMallMnfct);
		}
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	
	/**
	 * 根据厂家名称 获取厂家对象
	 * @author shmily
	 * @Title: getAllDictMallMnfctByName 
	 * @Description: (  ) 
	 * @param request
	 * @param dictMallMnfctName
	 * @return Map<String,Object>
	 * @throws
	 */
	public Map<String, Object> getAllDictMallMnfctByName(HttpServletRequest request, String dictMallMnfctName) {
		Map<String, String> apiMap = new TreeMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// TODO 查询实现
		// 模拟数据
		List<DictMallMnfct> result = new ArrayList<>();
		if("江苏省无锡市第一生产工厂".equals(dictMallMnfctName)) {
			DictMallMnfct dictMallMnfct = new DictMallMnfct();
			dictMallMnfct.setMnfctId("319c36815342c34969889379cf279ff5");
			dictMallMnfct.setMnfctName("江苏省无锡市第一生产工厂");
			dictMallMnfct.setMnfctShortName("无锡一厂");
			result.add(dictMallMnfct);
		}
		resultMap.put("data", result);
		resultMap.put("isSuccess", true);
		return resultMap;
	}
	

	
	
	
}
