package com.maigangle.gyl.facade.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.FeeBalance;
import com.maigangle.gyl.facade.entity.FeeBalanceDetail;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InvCheckInv;
import com.maigangle.gyl.facade.entity.InvCheckInvDetail;
import com.maigangle.gyl.facade.entity.InvInventory;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.vo.FeeBalanceVo;
import com.maigangle.gyl.facade.entity.vo.InvCheckInvVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**
 * 库存管理
 * @author 杨思静
 * @since  2017年11月28日 - 下午2:05:22
 * @version 1.0
 */
public interface InvInventoryService {
	/***********************外部************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getStockByConContractIdAndStorageId 
	 * @Description: TODO( 根据合同id和仓库id 来查询出货物 ) 
	 * @param ConContractId
	 * @param StorageId
	 * @return List<InvInventory>
	 * @throws
	 */
	List<InvInventoryDto> getStockByConContractIdAndStorageId(String ConContractId,String StorageId,String goodSourceEnum);
	/**
	 * 
	 * @author 倪凯
	 * @Title: getStockByConContractIdAndStorageId 
	 * @Description: TODO( 根据客户id和仓库id 来查询出货物 ) 
	 * @param ConContractId
	 * @param StorageId
	 * @return List<InvInventory>
	 * @throws
	 */
	List<InvInventoryDto> getStockByBuyerIdAndStorageId(String buyerId,String StorageId);
	/**
	 * 
	 * @author shmily
	 * @Title: getStorage 
	 * @Description: TODO( 根据合同id 来查询仓库ID数组 ) 
	 * @param ConContractId
	 * @return List<String>
	 * @throws
	 */
	List<String> getStorage(String ConContractId);
	
	/**
	 * 库存转待解锁
	 *
	 */
	Integer nextUnlockQuantity(String invInventoryId,BigDecimal number);
	/**
	 * 待解锁转待出库
	 */
	Integer nextOutstockQuantity(String invInventoryId,BigDecimal number);
	/**
	 * 待出库转出库
	 */
	Integer outstockQuantity(String invInventoryId,BigDecimal number);
	
	/**
	 * 待解锁 返回未解锁状态
	 */
	Integer removerQuantity(String invInventoryId,BigDecimal number);
	
	/**
	 * 根据合同id 查询出  库存数量
	 */
	List<InvInventoryDto> getInvInventoryByConId(String conId);
	
	/********************end**************************/
	/**
	 * 库存管理列表查询和条件查询
	 */
	PageInfo<InvInventory> getStockAll(PageUtils<InvInventoryDto> page,Boolean isAccuracy);
	/**
	 * 查询所有没有分页
	 */
	List<InvInventory> getStockAll(InvInventoryDto stockDto, Boolean isAccuracy);
	/**
	 * 库存管理列表查询和条件查询
	 */
	InvInventory getStockOne(String invInventoryId);
	

	/**
	 * 增加库存
	 */
//	InvInventory addStock(InvInventory invInventory);
	InvInventoryDto addStock(InvInventoryDto invInventoryDto);
	/**
	 * 删除库存
	 */
	Integer deleteStock(String invInventoryId);
	/**
	 * 修改库存
	 */
	InvInventory updateStock(InvInventory invInventory);
	InvInventoryDto updateStock(InvInventoryDto invInventoryDto);
	
	/**
	 * 
	 * @author shmily
	 * @Title: addInInvInventoryList 
	 * @Description: TODO( 根据查询子单id 把所有的子单下面的所有货物都存入库存 ) 
	 * @param id
	 * @return List<InvInventoryDto>
	 * @throws
	 */
	List<InvInventoryDto> addInInvInventoryList(List<InsInspectionDetail> list,String conId);
	
	/**
	 * 库存盘点列表查询和条件查询
	 */
	PageInfo<InvCheckInv> getChenkInvAll(PageUtils<InvCheckInvVo> page,Boolean isAccuracy);
	
	/**
	 * 余额查询列表查询和条件查询
	 */
	PageInfo<FeeBalance> getBalanceAll(PageUtils<FeeBalanceVo> page, Boolean isAccuracy);
	/**
	 * 根据id查询余额明细
	 * @param OutstockCode
	 * @return
	 */
	public List<FeeBalanceDetail> getBalanceDetailById(String id);
	/**
	 * 根据明细id查询余额明细
	 * @param OutstockCode
	 * @return
	 */
	public FeeBalanceDetail getBalanceDetailByDetailId(String id);
	
	/**
	 * 新增或修改余额
	 * @return
	 */
	public FeeBalance saveOrUpdateFeeBalance(String contractId, BigDecimal purchaseAmount, String createUser);
	/**
	 * 退款申请修改状态
	 * @return
	 */
	public FeeBalanceDetail updateFeeBalanceDetailState(String id);
	
	/**
	 * 根据仓库ID获取库存数据
	 * @param storageId
	 * @return
	 */
	List<InvInventory> getInvsByStorageId(String storageId);
	/**
	 * 根据仓库ID获取库存分页数据
	 * @param storageId
	 * @return
	 */
	PageInfo<InvInventory> getInvsByStorageId(PageUtils<InvInventory> page);
	
	InvCheckInv addCheckInv(InvCheckInvVo invCheckInvVo);
	
	InvCheckInvDetail addCheckInvDetail(InvCheckInvDetail invCheckInvDetail);
	/**
	 * 
	 * @author shmily
	 * @Title: selectCheckDetail 
	 * @Description: (单条库存盘点记录 ) 
	 * @param invInventoryId
	 * @return List<InvCheckInvDetail>
	 * @throws
	 */
	List<InvCheckInvDetail> selectCheckDetail(String invInventoryId);

}
