package com.maigangle.gyl.facade.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.dto.FeeFinalReportDto;
import com.maigangle.gyl.facade.entity.vo.FeeFinalReportVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**  
 * 期末初期报表service
 * @author zlh
 * @since 2017年11月28日 下午4:39:23 
 * @version 1.0 
 */
public interface FeeFinalReportService {
	
	/** 
	 * 新建，查询期末初期报表
	 */
	public FeeFinalReportVo getFeeFinalReport(FeeFinalReportDto dto,boolean isAccuracy);
	/** 
	 * 保存期末初期报表
	 */
	public int saveFeeFinalReport(FeeFinalReportDto dto,boolean isAccuracy);
	
	/**
	 * 查询所有期末初期报表
	 * @param FeeFinalReportDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<FeeFinalReportVo> getFeeFinalReport(FeeFinalReportDto feeFinalReportDto,String orderByClause,boolean isAccuracy);
	
	
	
	/**
	 * 查询所有期末初期报表带分页
	 * @param FeeFinalReportDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public PageInfo<FeeFinalReportVo> getFeeFinalReport(PageUtils<FeeFinalReportDto> page, boolean isAccuracy);
	

	
}
