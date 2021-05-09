package com.maigangle.gyl.service.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maigangle.gyl.facade.entity.dto.SysApprovalInfo;
/**
 * 审批进程查询
 * @author 张渊
 * @since 2017年12月20日 下午5:18:57
 * @version 1.0
 */
public interface SysApprovalFlowExtMapper {
	/**
	 * 根据approvalItemId查询最后一条审批进程
	 * @param approvalItemId
	 * @return
	 */
	SysApprovalInfo selectLastByApprovalItemId(@Param("approvalItemId") String approvalItemId);
	/**
	 * 根据approvalItemId 和模块名查询所有审批进程
	 * @param approvalItemId
	 * @return
	 */
	List<SysApprovalInfo> selectByApprovalItemId(@Param("approvalItemId") String approvalItemId,@Param("module") String module);
	
	/**
	 * 
	 * @author shmily
	 * @Title: selectModuleName 
	 * @Description: (获取数据库的已存在的流程名)
	 * @return List<String>
	 * @throws
	 */
	List<String> selectModuleName();
	
	/**
	 * 
	 * @author shmily
	 * @Title: delectModel 
	 * @Description: ( 删除流程 ) 
	 * @return int
	 * @throws
	 */
	int delectModel(@Param("model") String model);
}
