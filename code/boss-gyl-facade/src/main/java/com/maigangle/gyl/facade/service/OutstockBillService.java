package com.maigangle.gyl.facade.service;

import com.maigangle.gyl.facade.entity.OutOutstockBill;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.OutStockBillDto;
import com.maigangle.gyl.facade.utils.PageUtils;
import java.util.List;
import com.github.pagehelper.PageInfo;


/**  
 * 出库单接口
 * @author zlh
 * @since 2017年12月4日 上午8:51:57 
 * @version 1.0 
 */
public interface OutstockBillService {
	
	/**
	 * 新增
	 * @return
	 */
	public OutOutstockBill addOutstockBill(OutOutstockBill outOutstockBill);
	
	/**
	 * 编辑
	 * @return
	 */
	public OutOutstockBill updateOutstockBill(OutOutstockBill outOutstockBill);
	
	/**
	 * 删除
	 * @return
	 */
	public int deleteOutstockBill(String outstockBillId);
	
	
	/**
	 * 查询所有出库单
	 * @param OutstockBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<OutOutstockBill> getAllOutstockBill(OutStockBillDto outstockBillDto,String orderByClause,boolean isAccuracy);
	
	
	
	/**
	 * 查询所有出库单带分页
	 * @param OutstockBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public PageInfo<OutStockBillDto> getAllOutstockBill(PageUtils<OutStockBillDto> page, boolean isAccuracy);
	
	
	/**
	 * 根据id查询出库单
	 * @param OutstockCode
	 * @return
	 */
	public OutOutstockBill getOutstockBillById(String outstockBillId);
	
	/**
	 * 根据提货id查询出库单
	 * @param OutstockCode
	 * @return
	 */
	public OutOutstockBill getOutstockBillByContractId(String contractId);
	
	/**
	 * 提货审批通过回调函数
	 * @return
	 */
	public boolean onOutstockApprovalComplete(String id, PrivUser user);
	
	/**
	 * 提货回调函数
	 * @throws
	 */
	public boolean onOutstockApprovalSuspend(String id,PrivUser user);
	
	/**
	 * 提货撤销回调函数
	*/
	public boolean onOutstockAbandonApproval(String id,PrivUser user);
	
	/**
	 * 提货提交回调函数
	 * @return
	 */
	public boolean onOutstockSumit (String id,PrivUser user);
	/**
	 * onOutstockApproval
	 */
	public boolean onOutstockApproval(String id,PrivUser user);
	
}
