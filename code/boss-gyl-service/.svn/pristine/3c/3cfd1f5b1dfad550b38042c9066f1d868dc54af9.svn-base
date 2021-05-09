package com.maigangle.gyl.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.maigangle.gyl.facade.constant.GylGlobalConstant;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.GylService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.GylBaseMapper;

/**
 * 接口实现
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class GylServiceImpl<D> implements GylService<D> {
	@Autowired
	private GylBaseMapper gylBaseMapper;
	@Autowired
	BaseService baseService;
	/**
	 * 初始化信息
	 * 从数据库查询基本信息进行存储
	 */
	@PostConstruct
	public void initService() {
		if (GylGlobalConstant.BASE_INFO == null) {
			GylGlobalConstant.BASE_INFO = baseService.getGlobalBaseInfo();
			System.out.println("字典加载成功");
		}
	}
	
	@Override
	public void setPageAndOrderBy(PageUtils<D> page) {
		if (page != null) {
			PageHelper.startPage(page.getPageNum(), page.getPageSize());
			if (!StringUtils.isEmpty(page.getOrderByClause())) {
				PageHelper.orderBy(page.getOrderByClause());
			}
		}
	}
	
	/* 
	 * 获取单号-年，月（1701）
	 */
	@Override
	public String getCurrentTime() {
		return new SimpleDateFormat("yyMM",Locale.CHINESE).format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 生成单号
	 */
	@Override
	public String generateCode(String tableName, String typeStr) {
		return generateCode(tableName, typeStr, null);
	}

	/**
	 * 生成单号为合同
	 */
	@Override
	public String generateCode(String tableName, String typeStr, String businessType) {
		if (StringUtils.isEmpty(tableName)) {
			return null;
		}
		if (StringUtils.isEmpty(typeStr)) {
			typeStr = "";
		}
		int baseNumberInt = 0;
		if (StringUtils.isEmpty(businessType)) {
			baseNumberInt = gylBaseMapper.countAll(tableName) + 1;
		} else {
			baseNumberInt = gylBaseMapper.countAllForContart(tableName, businessType) + 1;
		}
		String baseNumberStr = String.valueOf(baseNumberInt);
		if (baseNumberStr.length() < 2) {
			baseNumberStr = "0" + baseNumberStr;
		}
		return typeStr + getCurrentTime() + baseNumberStr;
	}
	
}
