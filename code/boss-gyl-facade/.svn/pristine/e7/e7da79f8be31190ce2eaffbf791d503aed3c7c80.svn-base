package com.maigangle.gyl.facade.service;

import com.maigangle.gyl.facade.utils.PageUtils;

//import com.maigangle.gyl.facade.entity.AcntUserBasic;

/**
 * 定义供应链service接口
 * 
 * @author Administrator
 *
 */
public interface GylService<D> {
	
	/**
	 * 设置分页，排序
	 * @param page
	 */
	void setPageAndOrderBy(PageUtils<D> page);
	
	/**
	 * 获取当前时间(年后两位+月；建单号用)
	 * @return
	 */
	public String getCurrentTime();
	
	/**
	 * 生成单号
	 * @param typeStr
	 * @param tableName
	 * @return
	 */
	public String generateCode(String tableName, String typeStr);
	/**
	 * 生成合同单号
	 * @param typeStr
	 * @param bussessType
	 * @param tableName
	 * @return
	 */
	public String generateCode(String typeStr, String businessType, String tableName);
}
