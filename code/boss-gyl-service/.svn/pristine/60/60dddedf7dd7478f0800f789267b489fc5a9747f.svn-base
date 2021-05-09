package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.FeeFinalReportExample;
import com.maigangle.gyl.facade.entity.dto.FeeFinalReportDto;
import com.maigangle.gyl.facade.entity.vo.FeeFinalReportVo;
import com.maigangle.gyl.facade.service.FeeFinalReportService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.FeeFinalReportMapper;
import com.maigangle.gyl.service.mapper.ext.FeeFinalReportExtMapper;


/**  
 * 期末初期报表Service实现
 * @author zlh
 * @since 2017年11月28日 下午1:27:00 
 * @version 1.0 
 */
@Service
@Transactional
public class FeeFinalReportServiceImpl extends GylServiceImpl implements FeeFinalReportService {
	@Autowired
	private FeeFinalReportExtMapper feeFinalReportExtMapper;
	@Autowired
	private FeeFinalReportMapper feeFinalReportMapper;
	/* 
	 * 新建，查询期末初期报表
	 */
	@Override
	public FeeFinalReportVo getFeeFinalReport(FeeFinalReportDto dto,boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		Map<String, BigDecimal> inData = feeFinalReportExtMapper.getInvoiceGoodsInForReport(dto);
		Map<String, BigDecimal> outData = feeFinalReportExtMapper.getInvoiceGoodsOutForReport(dto);
		FeeFinalReportVo vo = new FeeFinalReportVo();
		vo.setFeeUninstockTotalweight(inData.get("FEEUNINSTOCKTOTALWEIGHT"));
		vo.setFeeUninstockTotalmoney(inData.get("FEEUNINSTOCKTOTALMONEY"));
		vo.setFeeUnoutstockTotalweight(outData.get("FEEUNOUTSTOCKTOTALWEIGHT"));
		vo.setFeeUnoutstockTotalmoney(outData.get("FEEUNOUTSTOCKTOTALMONEY"));
		return vo;
		//return feeFinalReportMapper.insertSelective(report);
	}
	/* 
	 * 保存期末初期报表
	 */
	@Override
	public int saveFeeFinalReport(FeeFinalReportDto dto,boolean isAccuracy) {
		if (dto == null) {
			return 0;
		}
		dto.setCreateDate(new Date());
		return feeFinalReportMapper.insertSelective(dto);
	}
	/* 
	 * 查询所有期末初期报表
	 */
	@Override
	public List<FeeFinalReportVo> getFeeFinalReport(FeeFinalReportDto dto,String orderByClause,boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<FeeFinalReportDto> page = new PageUtils<FeeFinalReportDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<FeeFinalReportVo> info = this.getFeeFinalReport(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	/* 
	 * 查询所有期末初期报表带分页
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<FeeFinalReportVo> getFeeFinalReport(PageUtils<FeeFinalReportDto> page, boolean isAccuracy) {
		if (page == null){
			return new PageInfo<FeeFinalReportVo>(); 
		}
		setPageAndOrderBy(page);
		FeeFinalReportDto dto = page.getDto();
		FeeFinalReportExample example = new FeeFinalReportExample();
		FeeFinalReportExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(dto.getCreateStartDate())) {
			criteria.andCreateDateGreaterThan(dto.getCreateStartDate());
		}
		if(!StringUtils.isEmpty(dto.getCreateEndDate())) {
			criteria.andCreateDateLessThan(dto.getCreateEndDate());
		}
		if(!StringUtils.isEmpty(dto.getCreateUser())) {
			criteria.andCreateUserEqualTo(dto.getCreateUser());
		}
		return new PageInfo<FeeFinalReportVo>(feeFinalReportExtMapper.selectByExample(example));
	}

	
	
}
