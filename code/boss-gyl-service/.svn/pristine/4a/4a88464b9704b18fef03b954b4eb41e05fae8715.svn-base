package com.maigangle.gyl.service.mapper;

import org.apache.ibatis.annotations.Param;

public interface GylBaseMapper {
	/**
	 * 
	 * @author shmily
	 * @Title: countAll 
	 * @Description: TODO(查询出当月的数量 ) 
	 * @param tableName 参数 表的名称
	 * @return int 返回的当月查询出的个数
	 * @throws
	 */
	int countAll(@Param("tableName") String tableName);
	
	/**
	 * 按业务类型查询合同当月的数量
	 * @param tableName 表面
	 * @param businessType 业务类型
	 * @return
	 */
	int countAllForContart(@Param("tableName") String tableName, @Param("businessType") String businessType);
}
