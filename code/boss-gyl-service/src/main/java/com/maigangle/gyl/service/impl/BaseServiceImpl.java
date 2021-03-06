package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.constant.GylGlobalConstant;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.BaseCompanyExample;
import com.maigangle.gyl.facade.entity.BaseCost;
import com.maigangle.gyl.facade.entity.BaseCostExample;
import com.maigangle.gyl.facade.entity.BaseInfo;
import com.maigangle.gyl.facade.entity.BaseMargin;
import com.maigangle.gyl.facade.entity.BaseMarginExample;
import com.maigangle.gyl.facade.entity.BaseProcess;
import com.maigangle.gyl.facade.entity.BaseProcessExample;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.BaseProductExample;
import com.maigangle.gyl.facade.entity.dto.BaseCostDto;
import com.maigangle.gyl.facade.entity.dto.BaseProductDto;
import com.maigangle.gyl.facade.entity.vo.BaseCostVo;
import com.maigangle.gyl.facade.enums.FeeTypeEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.utils.DateUtils;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.BaseCompanyMapper;
import com.maigangle.gyl.service.mapper.BaseCostMapper;
import com.maigangle.gyl.service.mapper.BaseInfoMapper;
import com.maigangle.gyl.service.mapper.BaseMarginMapper;
import com.maigangle.gyl.service.mapper.BaseProcessMapper;
import com.maigangle.gyl.service.mapper.BaseProductMapper;
import com.maigangle.gyl.service.mapper.ext.BaseCostExtMapper;

/**
 * 基础设置Service实现
 * 
 * @author 汪玮琦
 * @since 2017年11月23日 下午2:44:45
 * @version 1.0
 */
@Service
@Transactional
public class BaseServiceImpl extends GylServiceImpl implements BaseService {
	@Autowired
	private BaseInfoMapper baseInfoMapper;
	@Autowired
	private BaseProductMapper baseProductMapper;
	@Autowired
	private BaseCostMapper baseCostMapper;
	@Autowired
	private BaseMarginMapper baseMarginMapper;
	@Autowired
	private BaseProcessMapper baseProcessMapper;
	@Autowired
	private BaseCostExtMapper baseCostExtMapper;
	@Autowired
	private BaseCompanyMapper baseCompanyMapper;

	@Override
	public BaseInfo getGlobalBaseInfo() {
		List<BaseInfo> list = baseInfoMapper.selectByExample(null);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			BaseInfo info = new BaseInfo();
			info.setFeeRate1(new BigDecimal(2.5 / 10000));
			info.setInvoiceFee(new BigDecimal(10));
			info.setCompanyName("江苏买刚乐交易中心");
			if (baseInfoMapper.insertSelective(info) > 0) {
				GylGlobalConstant.BASE_INFO = info;
				return info;
			}
			return null;
		}
	}

	@Override
	public BigDecimal getGlobalFeeRate() {
		BaseInfo baseInfo = getGlobalBaseInfo();
		return baseInfo != null ? baseInfo.getFeeRate1() : null;
	}

	@Override
	public BigDecimal getGlobalInvoiceFee() {
		BaseInfo baseInfo = getGlobalBaseInfo();
		return baseInfo != null ? baseInfo.getInvoiceFee() : null;
	}

	@Override
	public String getGlobalOverdueReminder() {
		BaseInfo baseInfo = getGlobalBaseInfo();
		return baseInfo != null ? baseInfo.getOverdueReminder() : null;
	}

	@Override
	public BaseInfo updateBaseInfo(BaseInfo baseInfo) {
		if (StringUtils.isEmpty(baseInfo.getInfoId())) {
			return null;
		}
		int rows = baseInfoMapper.updateByPrimaryKeySelective(baseInfo);
		if (rows > 0) {
			GylGlobalConstant.BASE_INFO = baseInfo;
		}
		return rows == 0 ? null : baseInfo;
	}

	@Override
	public BaseProduct addBaseProduct(BaseProduct baseProduct) {
		if (baseProduct == null) {
			return null;
		}
		int rows = baseProductMapper.insertSelective(baseProduct);
		return rows == 0 ? null : baseProduct;
	}

	@Override
	public BaseProduct updateBaseProduct(BaseProduct baseProduct) {
		if (StringUtils.isEmpty(baseProduct.getProductId())) {
			return null;
		}
		int rows = baseProductMapper.updateByPrimaryKeySelective(baseProduct);
		return rows == 0 ? null : baseProduct;
	}

	@Override
	public int deleteBaseProduct(String baseProductId) {
		if (StringUtils.isEmpty(baseProductId)) {
			return 0;
		}
		BaseProduct baseProduct = new BaseProduct();
		baseProduct.setProductId(baseProductId);
		baseProduct.setIsDel("Y");
		return baseProductMapper.updateByPrimaryKeySelective(baseProduct);
	}

	@Override
	public PageInfo<BaseProduct> getBaseProducts(PageUtils<BaseProductDto> page, boolean isAccuracy) {
		if (page != null) {
			// 分页条件
			setPageAndOrderBy(page);
			BaseProductExample example = this.getBaseProductCriteria(page.getDto(), isAccuracy);
			List<BaseProduct> list = baseProductMapper.selectByExample(example);
			return new PageInfo<BaseProduct>(list);
		}
		return null;
	}

	@Override
	public List<BaseProduct> getBaseProducts(BaseProductDto baseProduct, String orderByClause, boolean isAccuracy) {
		if (baseProduct == null) {
			return null;
		}
		PageUtils<BaseProductDto> page = new PageUtils<>(1, 0, baseProduct);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<BaseProduct> info = this.getBaseProducts(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public BaseProduct getBaseProductById(String baseProductId) {
		return baseProductMapper.selectByPrimaryKey(baseProductId);
	}

	/**
	 * 
	 * @return
	 */
	private BaseProductExample getBaseProductCriteria(BaseProductDto baseProduct, boolean isAccuracy) {
		BaseProductExample example = new BaseProductExample();
		if (baseProduct != null) {
			BaseProductExample.Criteria criteria = example.createCriteria();
			if (!StringUtils.isEmpty(baseProduct.getProductId())) {
				criteria.andProductIdEqualTo(baseProduct.getProductId());
			}
			if (!StringUtils.isEmpty(baseProduct.getProductName())) {
				if (isAccuracy) {
					criteria.andProductNameEqualTo(baseProduct.getProductName());
				} else {
					criteria.andProductNameLike("%" + baseProduct.getProductName() + "%");
				}
			}
			if (!StringUtils.isEmpty(baseProduct.getCreateUser())) {
				if (isAccuracy) {
					criteria.andCreateUserEqualTo(baseProduct.getCreateUser());
				} else {
					criteria.andCreateUserLike("%" + baseProduct.getCreateUser() + "%");
				}
			}
			if (baseProduct.getStartCreateDate() != null) {
				criteria.andCreateDateGreaterThanOrEqualTo(DateUtils.getStartDate(baseProduct.getStartCreateDate()));
			}
			if (baseProduct.getEndCreateDate() != null) {
				criteria.andCreateDateLessThanOrEqualTo(DateUtils.getEndDate(baseProduct.getEndCreateDate()));
			}
			criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		}
		return example;
	}

	@Override
	public BaseCost addBaseCost(BaseCost baseCost) {
		if (baseCost == null) {
			return null;
		}
		int rows = baseCostMapper.insertSelective(baseCost);
		return rows == 0 ? null : baseCost;
	}

	@Override
	public BaseCost updateBaseCost(BaseCost baseCost) {
		if (StringUtils.isEmpty(baseCost.getCostId())) {
			return null;
		}
		int rows = baseCostMapper.updateByPrimaryKeySelective(baseCost);
		return rows == 0 ? null : baseCost;
	}

	@Override
	public int deleteBaseCost(String costId) {
		if (StringUtils.isEmpty(costId)) {
			return 0;
		}
		BaseCost baseCost = new BaseCost();
		baseCost.setCostId(costId);
		baseCost.setIsDel(YesOrNoEnum.YES.toString());
		return baseCostMapper.updateByPrimaryKeySelective(baseCost);
	}

	@Override
	public PageInfo<BaseCost> getBaseCosts(PageUtils<BaseCost> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		BaseCostExample example = this.getBaseCostCriteria(page.getDto(), isAccuracy);
		List<BaseCost> list = baseCostMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<BaseCost> getBaseCosts(BaseCost baseCost, String orderByClause, boolean isAccuracy) {
		if (baseCost == null) {
			return null;
		}
		PageUtils<BaseCost> page = new PageUtils<>(1, 0, baseCost);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<BaseCost> info = this.getBaseCosts(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public BaseCost getBaseCostById(String costId) {
		if (StringUtils.isEmpty(costId)) {
			return null;
		}
		return baseCostMapper.selectByPrimaryKey(costId);
	}

	@Override
	public PageInfo<BaseCostVo> getBaseCostVos(PageUtils<BaseCostDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		BaseCostExample example = this.getBaseCostCriteria(page.getDto(), isAccuracy);
		return new PageInfo<>(baseCostExtMapper.selectByExample(example));
	}

	@Override
	public List<BaseCostVo> getBaseCostVos(BaseCostDto baseCostDto, String orderByClause, boolean isAccuracy) {
		if (baseCostDto == null) {
			return null;
		}
		PageUtils<BaseCostDto> page = new PageUtils<>(1, 0, baseCostDto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<BaseCostVo> info = this.getBaseCostVos(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public BaseCostVo getBaseCostVoById(String costId) {
		if (StringUtils.isEmpty(costId)) {
			return null;
		}
		BaseCostVo vo = baseCostExtMapper.selectByPrimaryKey(costId);
		return vo;
	}

	@Override
	public BigDecimal getServiceChatge(BaseCost baseCost) {
		if (baseCost == null) {
			return null;
		}
		baseCost.setCostType(FeeTypeEnum.SHOU_XU_FEI.toString());
		List<BaseCost> list = getBaseCosts(baseCost, "", true);
		if (list != null && !list.isEmpty()) {
			return list.get(0) == null ? null : list.get(0).getAmount();
		} else {
			return null;
		}
	}

	@Override
	public BigDecimal getBillingChatge(BaseCost baseCost) {
		if (baseCost == null) {
			return null;
		}
		baseCost.setCostType(FeeTypeEnum.KAI_PIAO_FEI.toString());
		List<BaseCost> list = getBaseCosts(baseCost, "", true);
		if (list != null && !list.isEmpty()) {
			return list.get(0) == null ? null : list.get(0).getAmount();
		} else {
			return null;
		}
	}

	/**
	 * 费用信息查询条件
	 * 
	 * @param baseCost
	 * @param isAccuracy
	 * @return
	 */
	private BaseCostExample getBaseCostCriteria(BaseCost baseCost, boolean isAccuracy) {
		BaseCostExample example = new BaseCostExample();
		if (baseCost == null) {
			return null;
		}
		BaseCostExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(baseCost.getCostId())) {
			criteria.andCostIdEqualTo(baseCost.getCostId());
		}
		if (!StringUtils.isEmpty(baseCost.getCustomerId())) {
			criteria.andCustomerIdEqualTo(baseCost.getCustomerId());
		}
		if (!StringUtils.isEmpty(baseCost.getCostType())) {
			criteria.andCostTypeEqualTo(baseCost.getCostType());
		}
		criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		return example;
	}

	@Override
	public BaseMargin addBaseMargin(BaseMargin baseMargin) {
		if (baseMargin == null) {
			return null;
		}
		baseMargin.setCreateDate(new Date());
		int rows = baseMarginMapper.insertSelective(baseMargin);
		return rows == 0 ? null : baseMargin;
	}

	//添加甲方
	@Override
	public BaseCompany addBaseCompany(BaseCompany baseCompany) {
		if (baseCompany == null) {
			return null;
		}
		baseCompany.setCreateDate(new Date());
		int rows = baseCompanyMapper.insertSelective(baseCompany);
		return rows == 0 ? null : baseCompany;
	}

	@Override
	public BaseMargin updateBaseMargin(BaseMargin baseMargin) {
		if (StringUtils.isEmpty(baseMargin.getMarginId())) {
			return null;
		}
		int rows = baseMarginMapper.updateByPrimaryKeySelective(baseMargin);
		return rows == 0 ? null : baseMargin;
	}

	//更新甲方
	@Override
	public BaseCompany updateBaseCompany(BaseCompany baseCompany) {
		if (StringUtils.isEmpty(baseCompany.getCompanyId())) {
			return null;
		}
		int rows = baseCompanyMapper.updateByPrimaryKeySelective(baseCompany);
		return rows == 0 ? null : baseCompany;
	}

	@Override
	public int deleteBaseMargin(String marginId) {
		if (StringUtils.isEmpty(marginId)) {
			return 0;
		}
		BaseMargin baseMargin = new BaseMargin();
		baseMargin.setMarginId(marginId);
		baseMargin.setIsDel(YesOrNoEnum.YES.toString());
		return baseMarginMapper.updateByPrimaryKeySelective(baseMargin);
	}

	//删除甲方
	@Override
	public int deleteBaseCompany(String companyId) {
		if (StringUtils.isEmpty(companyId)) {
			return 0;
		}
		BaseCompany baseCompany = new BaseCompany();
		baseCompany.setCompanyId(companyId);
		baseCompany.setIsDel(YesOrNoEnum.YES.toString());
		return baseCompanyMapper.updateByPrimaryKeySelective(baseCompany);
	}

	@Override
	public List<BaseMargin> getBaseMargins() {
		BaseMarginExample example = new BaseMarginExample();
		BaseMarginExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(YesOrNoEnum.NO.getCode());
		example.setOrderByClause("PROPORTION");
		return baseMarginMapper.selectByExample(example);
	}

	/**
	 * 甲方
	 */
	@Override
	public List<BaseCompany> getBaseCompany() {
		BaseCompanyExample example = new BaseCompanyExample();
		BaseCompanyExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(YesOrNoEnum.NO.getCode());
		example.setOrderByClause("COMPANY_NAME");
		return baseCompanyMapper.selectByExample(example);
	}

	@Override
	public BaseCompany getBaseCompany(String companyId) {
		if (StringUtils.isEmpty(companyId))
			return null;
		else {
			return baseCompanyMapper.selectByPrimaryKey(companyId);
		}
	}
	@Override
	public BaseMargin getBaseMargin(String marginId) {
		if (StringUtils.isEmpty(marginId)) {
			return null;
		}
		return baseMarginMapper.selectByPrimaryKey(marginId);
	}

	@Override
	public BigDecimal getProportion(String marginId) {
		if (StringUtils.isEmpty(marginId)) {
			return null;
		}
		BaseMargin baseMargin = getBaseMargin(marginId);
		return baseMargin == null ? null : baseMargin.getProportion();
	}

	@Override
	public BaseProcess addBaseProcess(BaseProcess baseProcess) {
		if (baseProcess == null) {
			return null;
		}
		baseProcess.setCreateDate(new Date());
		int rows = baseProcessMapper.insertSelective(baseProcess);
		return rows == 0 ? null : baseProcess;
	}

	@Override
	public BaseProcess updateBaseProcess(BaseProcess baseProcess) {
		if (StringUtils.isEmpty(baseProcess.getProcessId())) {
			return null;
		}
		int rows = baseProcessMapper.updateByPrimaryKeySelective(baseProcess);
		return rows == 0 ? null : baseProcess;
	}

	@Override
	public int deleteBaseProcess(String processId) {
		if (StringUtils.isEmpty(processId)) {
			return 0;
		}
		BaseProcess baseProcess = new BaseProcess();
		baseProcess.setProcessId(processId);
		baseProcess.setIsDel("Y");
		return baseProcessMapper.updateByPrimaryKeySelective(baseProcess);
	}

	@Override
	public PageInfo<BaseProcess> getBaseProcesses(PageUtils<BaseProcess> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		BaseProcessExample example = this.getBaseProcessCriteria(page.getDto(), isAccuracy);
		example.setOrderByClause(page.getOrderByClause());
		List<BaseProcess> list = baseProcessMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<BaseProcess> getBaseProcesses(BaseProcess baseProcess, String orderByClause, boolean isAccuracy) {
		if (baseProcess == null) {
			return null;
		}
		PageUtils<BaseProcess> page = new PageUtils<>(1, 0, baseProcess);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<BaseProcess> info = this.getBaseProcesses(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public BaseProcess getBaseProcess(String processId) {
		if (StringUtils.isEmpty(processId)) {
			return null;
		}
		return baseProcessMapper.selectByPrimaryKey(processId);
	}

	@Override
	public String getProcessName(String processId) {
		if (StringUtils.isEmpty(processId)) {
			return null;
		}
		BaseProcess baseProcess = this.getBaseProcess(processId);
		return baseProcess == null ? null : baseProcess.getProcessName();
	}

	/**
	 * 表面信息查询条件
	 * 
	 * @param baseProcess
	 * @param isAccuracy
	 * @return
	 */
	private BaseProcessExample getBaseProcessCriteria(BaseProcess baseProcess, boolean isAccuracy) {
		if (baseProcess == null) {
			return null;
		}
		BaseProcessExample example = new BaseProcessExample();
		BaseProcessExample.Criteria criteria = example.createCriteria();
		if (isAccuracy) {
			criteria.andProcessNameEqualTo(baseProcess.getProcessName());
		} else {
			criteria.andProcessNameLike("%" + baseProcess.getProcessName() + "%");
		}
		criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		return example;
	}

}
