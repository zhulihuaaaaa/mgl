package com.maigangle.gyl.facade.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.OverdueDefer;
import com.maigangle.gyl.facade.entity.dto.OverdueDeferDto;
import com.maigangle.gyl.facade.entity.dto.OverdueDto;
import com.maigangle.gyl.facade.entity.vo.OverdueDeferVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**  
 * 逾期接口
 * @author zlh
 * @since 2017年11月28日 下午4:39:23 
 * @version 1.0 
 */
public interface OverdueService {
	
	
	/**
	 * 查询所有逾期单
	 * @param OverdueDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<OverdueDto> getOverdue(OverdueDto OverdueDto,String orderByClause,boolean isAccuracy);
	
	
	
	/**
	 * 查询所有逾期单带分页
	 * @param OverdueDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public PageInfo<OverdueDto> getOverdue(PageUtils<OverdueDto> page, boolean isAccuracy);
	
	
	/**
	 * 新增一条申请延期记录
	 * @param instockCode
	 * @return
	 */
	public int addOverdueDefer(OverdueDefer defer);
	
	/**
	 * 查询所有延期单
	 * @param OverdueDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<OverdueDeferVo> getOverdueDefer(OverdueDeferDto OverdueDeferDto,String orderByClause,boolean isAccuracy);
	
	
	
	/**
	 * 查询所有延期单带分页
	 * @param OverdueDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public PageInfo<OverdueDeferVo> getOverdueDefer(PageUtils<OverdueDeferDto> page, boolean isAccuracy);
	
	/**
	 * 更新值
	 * @param OverdueDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public int update(OverdueDeferDto dto, boolean isAccuracy);
	
}
