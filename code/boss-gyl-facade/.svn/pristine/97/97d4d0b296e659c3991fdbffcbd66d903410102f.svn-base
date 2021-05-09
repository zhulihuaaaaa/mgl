package com.maigangle.gyl.facade.service;

import com.maigangle.gyl.facade.entity.OutOutstockBill;
import com.maigangle.gyl.facade.entity.OutOutstockDetail;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.dto.OutStockDetailDto;
import com.maigangle.gyl.facade.entity.vo.OutOutstockDetailVo;
import com.maigangle.gyl.facade.entity.vo.RedRedeemDetailVo;
import com.maigangle.gyl.facade.utils.PageUtils;
import java.util.List;
import com.github.pagehelper.PageInfo;


/**  
 * 出库货物明细接口
 * @author zlh
 * @since 2017年12月4日 上午8:51:57 
 * @version 1.0 
 */
public interface OutstockDetailService {
	
	/**
	 * 新增
	 * @param List<InvInventory>,id
	 * @return
	 */
	public List<OutOutstockDetail> addOutstockDetail(List<OutOutstockDetail> list,String id);
	
	/**
	 * 新增
	 * @param RedRedeemDetail
	 * @return
	 */
	public OutOutstockDetailVo addOutstockDetail(OutOutstockDetailVo outOutstockDetailVo);
	
	/**
	 * 新增
	 * @return
	 */
	public OutOutstockDetail addOutstockDetail(OutOutstockDetail outOutstockDetail);
	
	/**
	 * 编辑
	 * @return
	 */
	/*public int updateOutstockDetail(OutOutstockDetail outOutstockDetail);*/
	public List<OutOutstockDetailVo> updateOutstockDetail(List<OutOutstockDetailVo> outstockDetail);
	
	/**
	 * 删除
	 * @return
	 */
	public int deleteOutstockDetail(String outstockDetailId);
	
	
	/**
	 * 查询所有出库货物明细
	 * @param OutstockDetailDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<OutOutstockDetail> getAllOutstockDetail(OutStockDetailDto outstockDetailDto,String orderByClause,boolean isAccuracy);
	
	
	
	/**
	 * 查询所有出库货物明细带分页
	 * @param OutstockDetailDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public PageInfo<OutOutstockDetail> getAllOutstockDetail(PageUtils<OutStockDetailDto> page, boolean isAccuracy);
	
	
	/**
	 * 根据id查询出库货物明细
	 * @param OutstockCode
	 * @return
	 */
	public List<OutOutstockDetailVo> getOutstockDetailById(String Id);
	
}
