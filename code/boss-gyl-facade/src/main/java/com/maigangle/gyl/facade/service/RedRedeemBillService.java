package com.maigangle.gyl.facade.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.dto.InvoiceGoodsConditionDto;
import com.maigangle.gyl.facade.entity.dto.RedRedeemBillDto;
import com.maigangle.gyl.facade.entity.dto.RedRedeemDetailDto;
import com.maigangle.gyl.facade.entity.vo.InvoiceGoodsConditionVo;
import com.maigangle.gyl.facade.entity.vo.RedRedeemGoodsVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**  
 * 赎货单接口
 * @author zlh
 * @since 2017年11月28日 下午4:39:23 
 * @version 1.0 
 */
public interface RedRedeemBillService {
		
	/**
	 * 新增
	 * @return
	 */
	public RedRedeemBill addRedRedeemBill(RedRedeemBill redRedeemBill);
	
	/**
	 * 编辑
	 * @return
	 */
	public int updateRedRedeemBill(RedRedeemBill redRedeemBill);
	
	/**
	 * 删除
	 * @return
	 */
	public int deleteRedRedeemBill(String redRedeemBillId);
	
	/**
	 * 查询所有赎货单
	 * @param RedRedeemBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<RedRedeemBill> getAllRedRedeemBill(RedRedeemBillDto redRedeemBillDto,String orderByClause, boolean isAccuracy);
	
	/**
	 * 查询所有赎货单带分页
	 * @param RedRedeemBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public PageInfo<RedRedeemBill> getAllRedRedeemBill(PageUtils<RedRedeemBillDto> page, boolean isAccuracy);
	
	/**
	 * 根据ID查询赎货单
	 * @param RedRedeemBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public RedRedeemBill getRedRedeemBillById(String Id);
	
	/**
	 * 根据单号查询赎货单
	 * @param RedRedeemBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public RedRedeemBill getRedRedeemBillByCode(String code);
	
	/**
	 * 根据货物来源查询赎货单
	 * @param RedRedeemBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<RedRedeemBill> getRedRedeemBillByGoodsSource(String goodsSource);
	
	/**
	 * 赎货审核
	 * @param redeemBillId 赎货单Id
	 * @param status 审批状态
	 * @return
	 */
	public boolean doAudit(String redeemBillId, String status);
	
	/**
	 * 新增赎货货物明细
	 * @param redRedeemDetail
	 * @return
	 */
	public RedRedeemDetail addRedeemDetail(RedRedeemDetail redRedeemDetail);
	
	/**
	 * 批量新增赎货货物明细
	 * @param list
	 * @return
	 */
	public List<RedRedeemDetail> addRedeemDetailBatch(List<RedRedeemDetail> list);
	
	/**
	 * 删除赎货货物明细
	 * @param redeemDetailId
	 * @return
	 */
	public int deleteRedeemDetail (String redeemDetailId);
	
	/**
	 * 批量删除赎货货物明细
	 * @param ids
	 * @return
	 */
	public int deleteRedeemDetailBatch (List<String> ids);
	
	/**
	 * 修改赎货货物明细
	 * @param redRedeemDetail
	 * @return
	 */
	public int updateRedeemDetail (RedRedeemDetail redRedeemDetail);
	
	/**
	 * 批量修改赎货货物明细
	 * @param list
	 * @return
	 */
	public int updateRedeemDetailBatch (List<RedRedeemDetail> list);
	
	/**
	 * 按条件查询赎货货物明细 分页
	 * @param page
	 * @param isAccuracy
	 * @return
	 */
	public PageInfo<RedRedeemDetail> getAllRedRedeemDetail(PageUtils<RedRedeemDetailDto> page, boolean isAccuracy);
	
	/**
	 * 按条件查询赎货货物明细
	 * @param redRedeemDetailDto
	 * @param orderByClause
	 * @param isAccuracy
	 * @return
	 */
	public List<RedRedeemDetail> getAllRedRedeemDetail(RedRedeemDetailDto redRedeemDetailDto,String orderByClause, boolean isAccuracy);
	
	/**
	 * 按条件查询赎货货物明细一条
	 * @param redRedeemDetailDto
	 * @return
	 */
	public RedRedeemDetail getOneRedRedeemDetail(String detailId);
	
	/**
	 * 根据主单Id查询赎货货物明细
	 * @param billId
	 * @return
	 */
	public List<RedRedeemDetail> getRedRedeemDetailByBillId(String billId);
	
	/**
	 * 审核过后的操作
	 * @param redeemBillId 赎货单
	 * @param status 审核状态
	 * @return
	 */
	public Integer billWasAudited(String redeemBillId, String status);
	
	/**
	 * 根据客户和仓库id获取赎货主单
	 * @param buyerId
	 * @param storageId
	 * @return
	 */
	public List<RedRedeemGoodsVo> getRedRedeemBillByClientIdAndStorageId(String buyerId,String storageId); 
	/**
	 * 是否为最后一批货
	 * @param details 货物详情
	 * @param contractId 合同Id
	 * @return
	 */
	public BigDecimal isLastGoods(List<RedRedeemDetail> details, String contractId);	
	/**
	 * 1修改货物明细状态
	 * 2更新主单状态
	 * @param detailid 货物详情
	 * @return
	 */
	public int updateRedRedeemBillState(String detailId);
	
	/**
	 * 查询销项
	 */
	public PageInfo<InvoiceGoodsConditionVo> getInvoiceGoodsOut(PageUtils<InvoiceGoodsConditionDto> page);
}
