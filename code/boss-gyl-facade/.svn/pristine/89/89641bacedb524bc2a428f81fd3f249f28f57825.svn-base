package com.maigangle.gyl.facade.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.BaseCost;
import com.maigangle.gyl.facade.entity.BaseInfo;
import com.maigangle.gyl.facade.entity.BaseMargin;
import com.maigangle.gyl.facade.entity.BaseProcess;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.dto.BaseCostDto;
import com.maigangle.gyl.facade.entity.dto.BaseProductDto;
import com.maigangle.gyl.facade.entity.vo.BaseCostVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**
 * 基础设置接口
 * 
 * @author Administrator
 *
 */
public interface BaseService {
	/*	通用设置		*/
	/**
	 * 获取通用设置
	 * @return
	 */
	public BaseInfo getGlobalBaseInfo();
	
	/**
	 * 获取通用手续费率
	 * @return
	 */
	public BigDecimal getGlobalFeeRate();
	
	/**
	 * 获取通用开票费
	 * @return
	 */
	public BigDecimal getGlobalInvoiceFee();
	
	/**
	 * 获取逾期提醒设置
	 * 格式 7,5,2 说明：分别在7天，5天，2天时提醒
	 * @return
	 */
	public String getGlobalOverdueReminder();
	
	/**
	 * 更新通用设置
	 * @param baseInfo
	 * @return
	 */
	public BaseInfo updateBaseInfo(BaseInfo baseInfo);
	
	/*	品名设置	*/
	/**
	 * 添加品名
	 * @param baseProduct 品名信息
	 * @return
	 */
	public BaseProduct addBaseProduct(BaseProduct baseProduct);
	/**
	 * 根据品名ID更新品名信息
	 * @param baseProduct 品名信息
	 * @return
	 */
	public BaseProduct updateBaseProduct(BaseProduct baseProduct);
	/**
	 * 删除品名
	 * @param baseProductId
	 * @return
	 */
	public int deleteBaseProduct(String baseProductId);
	/**
	 * 分页查询品名信息
	 * @param page 查询条件及分页信息
	 * @param isAccuracy 是否为精确查询
	 * @return
	 */
	public PageInfo<BaseProduct> getBaseProducts(PageUtils<BaseProductDto> page, boolean isAccuracy);
	/**
	 * 根据条件查询品名信息
	 * @param baseProduct 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<BaseProduct> getBaseProducts(BaseProductDto baseProduct, String orderByClause, boolean isAccuracy);
	/**
	 * 根据ID查询品名
	 * @param baseProductId
	 * @return
	 */
	public BaseProduct getBaseProductById(String baseProductId);
	
	/**
	 * 添加费用
	 * @param baseCost
	 * @return
	 */
	public BaseCost addBaseCost(BaseCost baseCost);
	
	/**
	 * 更新费用
	 * @param baseCost
	 * @return
	 */
	public BaseCost updateBaseCost(BaseCost baseCost);
	
	/**
	 * 删除费用
	 * @param costId
	 * @return
	 */
	public int deleteBaseCost(String costId);
	
	/**
	 * 根据条件查询费用信息并分页
	 * @param baseCost
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<BaseCost> getBaseCosts(PageUtils<BaseCost> page, boolean isAccuracy);
	
	/**
	 * 根据条件查询费用信息
	 * @param baseCost
	 * @param isAccuracy
	 * @return
	 */
	public List<BaseCost> getBaseCosts(BaseCost baseCost, String orderByClause, boolean isAccuracy);
	
	/**
	 * 根据ID查询费用信息
	 * @param costId
	 * @return
	 */
	public BaseCost getBaseCostById(String costId);
	
	/**
	 * 根据条件查询费用信息并分页
	 * @param baseCostDto
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<BaseCostVo> getBaseCostVos(PageUtils<BaseCostDto> page, boolean isAccuracy);
	
	/**
	 * 根据条件查询费用信息
	 * @param baseCostDto
	 * @param isAccuracy
	 * @return
	 */
	public List<BaseCostVo> getBaseCostVos(BaseCostDto baseCostDto, String orderByClause, boolean isAccuracy);
	
	/**
	 * 根据ID查询费用信息
	 * @param costId
	 * @return
	 */
	public BaseCostVo getBaseCostVoById(String costId);
	
	/**
	 * 获取手续费
	 * @param baseCost
	 * @return
	 */
	public BigDecimal getServiceChatge(BaseCost baseCost);
	
	/**
	 * 获取开票费
	 * @param baseCost
	 * @return
	 */
	public BigDecimal getBillingChatge(BaseCost baseCost);
	
	/**
	 * 添加保证金
	 * @param baseMargin
	 * @return
	 */
	public BaseMargin addBaseMargin(BaseMargin baseMargin);
	
	/**
	 * 添加甲方
	 * @param baseCompany
	 * @return
	 */
	public BaseCompany addBaseCompany(BaseCompany baseCompany);
	
	/**
	 * 更新保证金
	 * @param baseMargin
	 * @return
	 */
	public BaseMargin updateBaseMargin(BaseMargin baseMargin);
	
	/**
	 * 更新甲方
	 * @param baseCompany
	 * @return
	 */
	public BaseCompany updateBaseCompany(BaseCompany baseCompany);
	
	/**
	 * 删除保证金
	 * @param marginId
	 * @return
	 */
	public int deleteBaseMargin(String marginId);
	
	/**
	 * 删除甲方
	 * @param marginId
	 * @return
	 */
	public int deleteBaseCompany(String companyId);
	
	/**
	 * 获取所有保证金
	 * @return
	 */
	public List<BaseMargin> getBaseMargins();
	
	/**
	 * 获取所有甲方
	 * @return
	 */
	public List<BaseCompany> getBaseCompany();
	/**
	 * 根据ID获取甲方信息
	 * @param companyId
	 * @return
	 */
	public BaseCompany getBaseCompany(String companyId);
	
	/**
	 * 获取保证金
	 * @return
	 */
	public BaseMargin getBaseMargin(String marginId);
	
	/**
	 * 获取保证金
	 * @param marginId
	 * @return
	 */
	public BigDecimal getProportion(String marginId);
	
	/**
	 * 添加表面信息
	 * @param baseProcess
	 * @return
	 */
	public BaseProcess addBaseProcess(BaseProcess baseProcess);
	
	/**
	 * 更新表面信息
	 * @param baseProcess
	 * @return
	 */
	public BaseProcess updateBaseProcess(BaseProcess baseProcess);
	
	/**
	 * 删除表面信息
	 * @param processId
	 * @return
	 */
	public int deleteBaseProcess(String processId);
	
	/**
	 * 获取所有表面信息并分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<BaseProcess> getBaseProcesses(PageUtils<BaseProcess> page, boolean isAccuracy);
	
	/**
	 * 获取所有表面信息
	 * @param baseProcess
	 * @param isAccuracy
	 * @return
	 */
	public List<BaseProcess> getBaseProcesses(BaseProcess baseProcess, String orderByClause, boolean isAccuracy);
	
	/**
	 * 根据ID查询表面信息
	 * @param processId
	 * @return
	 */
	public BaseProcess getBaseProcess(String processId);
	
	/**
	 * 根据ID查询表面名称
	 * @param processId
	 * @return
	 */
	public String getProcessName(String processId);
}
