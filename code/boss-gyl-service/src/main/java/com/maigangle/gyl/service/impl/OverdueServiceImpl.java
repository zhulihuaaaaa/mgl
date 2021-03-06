package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.BaseCost;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.ConFeeRates;
import com.maigangle.gyl.facade.entity.ConFeeRatesExample;
import com.maigangle.gyl.facade.entity.OverdueDefer;
import com.maigangle.gyl.facade.entity.OverdueDeferExample;
import com.maigangle.gyl.facade.entity.dto.OverdueDeferDto;
import com.maigangle.gyl.facade.entity.dto.OverdueDto;
import com.maigangle.gyl.facade.entity.vo.OverdueDeferVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.OverdueService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.ConFeeRatesMapper;
import com.maigangle.gyl.service.mapper.OverdueDeferMapper;
import com.maigangle.gyl.service.mapper.ext.ConContractExtMapper;
import com.maigangle.gyl.service.mapper.ext.OverdueDeferExtMapper;


/**  
 * 逾期设置Service实现
 * @author zlh
 * @since 2017年11月28日 下午1:27:00 
 * @version 1.0 
 */
@Service
@Transactional
public class OverdueServiceImpl extends GylServiceImpl implements OverdueService {
	@Autowired
	private ConContractExtMapper conContractExtMapper;
	@Autowired
	private OverdueDeferMapper overdueDeferMapper;
	@Autowired
	private OverdueDeferExtMapper overdueDeferExtMapper;
	@Autowired
	ContractService contractService;
	@Autowired
	ConFeeRatesMapper conFeeRatesMapper;
	/* 
	 * 查询所有逾期单
	 */
	@Override
	public List<OverdueDto> getOverdue(OverdueDto dto,String orderByClause,boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<OverdueDto> page = new PageUtils<OverdueDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<OverdueDto> info = this.getOverdue(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	/* 
	 * 查询所有逾期单带分页
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<OverdueDto> getOverdue(PageUtils<OverdueDto> page, boolean isAccuracy) {
		if (page == null){
			return new PageInfo<OverdueDto>(); 
		}
		setPageAndOrderBy(page);
		OverdueDto dto = page.getDto();
		List<OverdueDto> list = conContractExtMapper.selectOverdue(dto.getContractId(),dto.getContractPeriod(),dto.getOverdue(),dto.getSignStartDate(),dto.getSignEndDate());
		PageInfo<OverdueDto> info = new PageInfo<OverdueDto>(list);
		return info;
	}
	
	/**
	 * 新增一条申请延期记录
	 * @param instockCode
	 * @return
	 */
	public int addOverdueDefer(OverdueDefer defer){
		defer.setAuditStatus(ApprovalStateEnum.APPROVAL_NOT.getState());
		defer.setCreateDate(new Date());
		return overdueDeferMapper.insertSelective(defer);
	}
	
	/**
	 * 查询所有延期单
	 * @param OverdueDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	@Override
	public List<OverdueDeferVo> getOverdueDefer(OverdueDeferDto deferDto,String orderByClause,boolean isAccuracy){
		if (deferDto == null) {
			return null;
		}
		PageUtils<OverdueDeferDto> page = new PageUtils<OverdueDeferDto>(1, 0, deferDto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<OverdueDeferVo> info = this.getOverdueDefer(page, isAccuracy);
		return info == null ? null : info.getList();
	}
	
	
	
	/**
	 * 查询所有延期单带分页
	 * @param OverdueDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<OverdueDeferVo> getOverdueDefer(PageUtils<OverdueDeferDto> page, boolean isAccuracy){
		if (page == null){
			return new PageInfo<OverdueDeferVo>(); 
		}
		setPageAndOrderBy(page);
		OverdueDeferDto deferDto = page.getDto();
		OverdueDeferExample example = new OverdueDeferExample();
		OverdueDeferExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(deferDto.getDeferDays())) {
			criteria.andDeferDaysEqualTo(deferDto.getDeferDays());
		}
		if(!StringUtils.isEmpty(deferDto.getOverdueDays())) {
			criteria.andOverdueDaysEqualTo(deferDto.getOverdueDays());
		}
		if(!StringUtils.isEmpty(deferDto.getAuditStatus())) {
			criteria.andAuditStatusEqualTo(deferDto.getAuditStatus());
		}
		if(!StringUtils.isEmpty(deferDto.getCommissionRate())) {
			criteria.andCommissionRateEqualTo(deferDto.getCommissionRate());
		}
		if(!StringUtils.isEmpty(deferDto.getCreateStartDate())) {
			criteria.andCreateDateGreaterThanOrEqualTo(deferDto.getCreateStartDate());
		}
		if(!StringUtils.isEmpty(deferDto.getCreateEndDate())) {
			criteria.andCreateDateLessThanOrEqualTo(deferDto.getCreateEndDate());
		}
		List<OverdueDeferVo> list = overdueDeferExtMapper.selectByExample(example);
		for(int i=0;i<list.size();i++) {
			list.get(i).setContract(contractService.getConContractById(list.get(i).getContractId()));
		}
		PageInfo<OverdueDeferVo> info = new PageInfo<OverdueDeferVo>(list);
		return info;
	}
	
	/**
	 * 更新值
	 * @param OverdueDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public int update(OverdueDeferDto dto, boolean isAccuracy) {
		OverdueDefer defer = new OverdueDefer();
		defer.setOverdueDeferId(dto.getOverdueDeferId());
		if(!StringUtils.isEmpty(dto.getCommissionRate())) {
			defer.setCommissionRate(dto.getCommissionRate());
		}
		if(!StringUtils.isEmpty(dto.getAuditStatus())) {
			defer.setAuditStatus(dto.getAuditStatus());
		}
		int rows = overdueDeferMapper.updateByPrimaryKeySelective(defer);
		if(rows != 0) {
			ConFeeRates rates = new ConFeeRates();
			if(!StringUtils.isEmpty(dto.getContractId())) {
				rates.setContractId(dto.getContractId());
				rates.setCreateDate(new Date());
				rates.setIsOverdue(YesOrNoEnum.YES.getCode());
				rates.setFeeValue(dto.getCommissionRate());		
				rates.setCreateUser(dto.getCreateUser());
			}
			if(!StringUtils.isEmpty(dto.getDeferDays())) {
				ConFeeRatesExample example = new ConFeeRatesExample();
				ConFeeRatesExample.Criteria criteria = example.createCriteria();
				criteria.andContractIdEqualTo(dto.getContractId());
				List<ConFeeRates> list = conFeeRatesMapper.selectByExample(example);
				List<Integer> list2 = new ArrayList<Integer>();
				for(int i = 0;i<list.size();i++) {
					int days = list.get(i).getFeeDates().intValue();
					list2.add(days);
				}
				BigDecimal biggest = new BigDecimal(Collections.max(list2));
				rates.setFeeDates(biggest.add(dto.getDeferDays()));
			}
			if(!StringUtils.isEmpty(rates.getContractId())) {
				rows = conFeeRatesMapper.insertSelective(rates);
			}
		}
		return rows;
	}
}
