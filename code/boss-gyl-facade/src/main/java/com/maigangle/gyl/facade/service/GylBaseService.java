package com.maigangle.gyl.facade.service;

import java.util.List;

import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.GridConfig;
import com.maigangle.gyl.facade.entity.api.PrivUser;

/**
 * 系统基本配置Service
 * @author 张渊
 * @since 2017年12月5日 下午1:45:06
 * @version 1.0
 */
public interface GylBaseService {

	/**
	 * 添加表格配置
	 * @param baseProduct 品名信息
	 * @return
	 * @throws Exception 
	 */
	public int addGridConfig(GridConfig gridConfig, PrivUser user) throws Exception;
	/**
	 * 根据ID更新表格配置
	 * @param baseProduct 品名信息
	 * @return
	 * @throws Exception 
	 */
	public int updateGridConfig(GridConfig gridConfig) throws Exception;
	/**
	 * 根据ID查询表格配置
	 * @param baseProductId
	 * @return
	 */
	public GridConfig getGridConfigById(String gridConfigId);
	/**
	 * 根据表格名查询表格配置
	 * @param code
	 * @return
	 */
	public GridConfig getGridConfigByCode(String code, PrivUser user);
	/**
	 * 
	 * @author shmily
	 * @Title: addAttach 
	 * @Description: TODO( 添加附件 ) 
	 * @param attach 传入附件
	 * @return Attach 返回传入的附件
	 * @throws
	 */
	public Attach addAttach(Attach attach);
	/**
	 * 
	 * @author shmily
	 * @Title: updateAttach
	 * @Description: TODO( 根据附件id修改)
	 * @param attach
	 * @return int
	 * @throws
	 */
	public Attach updateAttach(Attach attach);
	/**
	 * 
	 * @author shmily
	 * @Title: getAttach 
	 * @Description: TODO( 根据关联表id查询出附件 ) 
	 * @param id
	 * @return List<Attach>
	 * @throws
	 */
	public List<Attach> getAttach(String id);
	/**
	 * 
	 * @author shmily
	 * @Title: getAttachById 
	 * @Description: TODO( 根据附件id查询出 ) 
	 * @param id
	 * @return Attach
	 * @throws
	 */
	public Attach getAttachById(String id);
	/**
	 * 
	 * @author shmily
	 * @Title: getAttachByIdAndType
	 * @Description: TODO( 根据关联表id 和类型查出 附件列表 ) 
	 * @param id
	 * @param type
	 * @return Attach
	 * @throws
	 */
	public List<Attach> getAttachByIdAndType(String id,String type);
	/**
	 * 
	 * @author shmily
	 * @Title: deleteAttach 
	 * @Description: TODO( 根据附件id删除 ) 
	 * @return int
	 * @throws
	 */
	public int deleteAttach(String id);
	
}
