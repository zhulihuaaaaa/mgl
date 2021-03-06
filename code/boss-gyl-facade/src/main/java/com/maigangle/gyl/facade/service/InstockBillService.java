package com.maigangle.gyl.facade.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.InContractRemitDetail;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.dto.InStockBillDto;
import com.maigangle.gyl.facade.entity.dto.InvoiceGoodsConditionDto;
import com.maigangle.gyl.facade.entity.vo.InApplyRemitDetailVo;
import com.maigangle.gyl.facade.entity.vo.InContractRemitDetailVo;
import com.maigangle.gyl.facade.entity.vo.InvoiceGoodsConditionVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**  
 * 入库单接口
 * @author zlh
 * @since 2017年11月28日 下午4:39:23 
 * @version 1.0 
 */
public interface InstockBillService {
	
	/**
	 * 新增
	 * @return
	 */
	public InInstockBill addInstockBill(InInstockBill inInstockBill);
	
	/**
	 * 编辑
	 * @return
	 */
	public InInstockBill updateInstockBill(InInstockBill inInstockBill);
	
	/**
	 * 删除
	 * @return
	 */
	public int deleteInstockBill(String instockBillId);
	
	
	/**
	 * 查询所有入库单
	 * @param InStockBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public List<InStockBillDto> getAllInstockBill(InStockBillDto inStockBillDto,String orderByClause,boolean isAccuracy);
	
	
	
	/**
	 * 查询所有入库单带分页
	 * @param InStockBillDto 查询条件
	 * @param isAccuracy 是否精确查询
	 * @return
	 */
	public PageInfo<InStockBillDto> getAllInstockBill(PageUtils<InStockBillDto> page, boolean isAccuracy);
	
	
	/**
	 * 根据id查询入库单
	 * @param instockCode
	 * @return
	 */
	public InStockBillDto getInstockBillById(String instockBillId);
	
	/**
	 * 根据业务类型查询入库单
	 * @param instockCode
	 * @return
	 */
	public List<InStockBillDto> getInstockBillByBusinessType(String businessType);
	
	/**
	 * 新增一条申请打款记录
	 * @return
	 */
	public InApplyRemitDetailVo applyRemit(InApplyRemitDetailVo vo);
	
	/**
	 * 查询申请打款记录
	 * @return
	 */
	public List<InApplyRemitDetailVo> findApplyRemit(String instockId);
	
	/**
	 * 新增一条合同打款记录
	 * @return
	 */
	public InContractRemitDetail contractRemit(InContractRemitDetail inContractRemitDetail);
	
	/**
	 * 更新合同打款
	 */
	public InContractRemitDetail updateContractRemit(String financeId,String contractId);
	
	/**
	 * 
	 * 修改入库单状态
	 * @return
	 */
	public InInstockBill updateInstockBillState(InInstockBill inInstockBill);
	
	/**
	 * 根据操作时间remit_date查询合同打款记录
	 */
	public InContractRemitDetail findcontractRemit(String contractId,Date date);
	
	/**
	 * 根据合同id查询入库单
	 */
	public InStockBillDto getInstockBillByContractId(String contractId);

	/**
	 * 根据财务id更新申请打款记录
	 */
	public void updateApplyRemitByfID(String financeId);
	
	/**
	 * 查询进项
	 */
	public PageInfo<InvoiceGoodsConditionVo> getInvoiceGoodsIn(PageUtils<InvoiceGoodsConditionDto> page);
	
	/**
	 * 根据合同id查询合同打款记录
	 */
	public List<InContractRemitDetailVo> findContractRecord(String contractId);
	
	
	
}
