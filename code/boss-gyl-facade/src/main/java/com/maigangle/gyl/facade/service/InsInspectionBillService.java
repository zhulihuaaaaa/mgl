package com.maigangle.gyl.facade.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InsInspectionSub;
import com.maigangle.gyl.facade.entity.dto.InsInspectionBillDto;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.vo.InsInspectionBillVo;
import com.maigangle.gyl.facade.utils.PageUtils;

/**
 * 交收管理的Service
 * @author 杨思静
 * @since  2017年11月29日 - 下午2:48:46
 * @version 1.0
 */
public interface InsInspectionBillService {
	/**********外部****/
	List<InsInspectionBillDto> getInsInspectionDetail(String inStockId);
	/**
	 * 
	 * @author shmily
	 * @Title: addInsInspection 
	 * @Description: ( 生成验货单  ) 
	 * @param instockId
	 * @param contractId
	 * @param inspectionInfo 验货信息
	 * @param businessType
	 * @return InsInspectionBill
	 * @throws
	 */
	InsInspectionBill addInsInspection(String instockId, String contractId,String inspectionInfo,String businessType);
	
	
 	/**
 	 * 根据入库单id来查询验货单
 	 */
 	InsInspectionBill getInsInspectionBillByInstockId(String instockId);
 	
 	/**
 	 * 修改验货状态  验货完成  传入 入库id  完成状态  tpye =1
 	 */
 	Integer updateStats(String id ,String stats,Integer type);
	/************************************提供外部接口**************/
	/*********************************页面需要的接口**************************/
	/**
	 * @author shmily
	 * @Title: getInsInspectionSubAllById 
	 * @Description: ( 查询页面所有的验货单下面的子单id ) 
	 * @param insInspectionBillId
	 * @return 
	 * @throws
	 */
	List<InsInspectionSub> getInsInspectionSubAllById(String insInspectionBillId);
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionDetailById 
	 * @Description: ( 通过审核的主单下面的子单下面所有的货物信息 ) 
	 * @param insInspectionBillId
	 * @return 
	 * @throws
	 */
	List<InsInspectionDetail> getInsInspectionDetailById(String insInspectionBillId);
	/**
	 * @author shmily
	 * @Title: getInsInspectionDetailBySubId 
	 * @Description: ( 某子单下面的货品信息详情 ) 
	 * @param insInspectionBillSubId
	 * @return 
	 * @throws
	 */
	List<InsInspectionDetail> getInsInspectionDetailBySubId(String insInspectionBillSubId);
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionSubByfinancial 
	 * @Description: ( 审核列表分页 ) 
	 * @param page
	 * @param isAccuracy
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	PageInfo<InsInspectionSub> getInsInspectionSub(PageUtils<InsInspectionBillDto> page,Boolean isAccuracy);
	
	/**
	 * 
	 * @author shmily
	 * @Title: bathAddInspectionDetail 
	 * @Description: ( 批量添加货物信息 ) 
	 * @param list
	 * @return List<InsInspectionBillVo>
	 * @throws
	 */
	List<InsInspectionBillVo> bathAddInspectionDetail(List<InsInspectionBillVo> list);
	/**
	 * 
	 * @author shmily
	 * @Title: bathAddInspectionDetail 
	 * @Description: ( 批量修改货物信息 ) 
	 * @param list
	 * @return List<InsInspectionBillVo>
	 * @throws
	 */
	List<InsInspectionBillVo> bathUpdateInspectionDetail(List<InsInspectionBillVo> list);
	/**
	 * 
	 * @author shmily
	 * @Title: bathAddInspectionDetail 
	 * @Description: ( 批量修改和删除和增加货物信息 ) 
	 * @param list
	 * @return List<InsInspectionBillVo>
	 * @throws
	 */
	List<InsInspectionBillVo> bathUpdateAndAddAndDelInspectionDetail(List<InsInspectionBillVo> list);
	/**
	 * 
	 * @author shmily
	 * @Title: bathUpdateInspectionDetailPrice 
	 * @Description: ( ( 批量修改价格 )  ) 
	 * @param insInspectionBillVo
	 * @return Integer
	 * @throws
	 */
	Integer bathUpdateInspectionDetailPrice(InsInspectionBillVo insInspectionBillVo);
	
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionSubAll 
	 * @Description: ( 查询所有 ) 
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	List<InsInspectionSub> getInsInspectionSubAllBySubCode(String subCode);
	

	
	/********************************end*************************************/
	
	
	
	
	/**
	 * 查询所有验收单和条件查询
	 */
	PageInfo<InsInspectionBill> getInsInspectionBillAll(PageUtils<InsInspectionBillDto> page,Boolean isAccuracy);
	/**
	 * 查询所有验收单
	 */
	List<InsInspectionBillDto> getInsInspectionBillAll(InsInspectionBillDto settlementDto);
	/**
	 * 查询单条验收单的详细的子验收单的列表s
	 */
	List<InsInspectionSub> getInsInspectionBillOne(String  insInspectionBillId);
	/**
	 * 生成验收单(不对)
	 */
	Integer addInsInspectionBill(InsInspectionBillDto settlementDto);
	/**
	 * 删除验收单
	 */
	Integer deleteInsInspectionBill(String insInspectionBillId);
	/**
	 * 修改验收单
	 */
	InsInspectionBill updateInsInspectionBill(InsInspectionBill insInspectionBill);
	/**
	 * 根据合同来查验货单id
	 */
	InsInspectionBill getInsInspectionBillByConId(String conContractId);
	/**
	 * 根据id来查询主验货单
	 */
	InsInspectionBill getInsInspectionBillById(String insInspectionBillId);
	/******************验货单子单*****************************/
	/**
	 * 根据主验货单id 查询所有验收单子单
	 */
	List<InsInspectionSub> getInsInspectionSubAll(String insInspectionId);
	/**
	 * 查询数所有验收单子单 和 条件查询和分页
	 */
	PageInfo<InsInspectionBillDto> getInsInspectionSubAll(PageUtils<InsInspectionBillDto> page,Boolean isAccuracy);
	/**
	 * 查询单条验收单子单 --- 查询出货物信息列表信息
	 */
	List<InsInspectionDetail> getInsInspectionSubOne(String  insInspectionSubId);
	/**
	 * 查询出单条验收子单的详细内容
	 */
//	InsInspectionSub getgetInsInspectionSubById(String  insInspectionSubId);
	InsInspectionBillDto getgetInsInspectionSubById(String  insInspectionSubId);
	InsInspectionSub getInsInspectionSubById(String  insInspectionSubId);
	/**
	 * 生成验收单子单
	 */
	InsInspectionSub addInsInspectionSub(InsInspectionSub insInspectionSub);
	
	/**
	 * 删除验收单子单
	 */
	Integer deleteInsInspectionSub(String insInspectionSubId);
	/**
	 * 修改验收单子单
	 */
//	InsInspectionSub updateInsInspectionSub(InsInspectionSub insInspectionSub);
	InsInspectionBillDto updateInsInspectionSub(InsInspectionBillDto insInspectionBillDto);
	/********************验货子单货物明细********************************/ 
	/**
	 * 验货某一条子单货物明细列表
	 */
	List<InsInspectionDetail> getInsInspectionDetailAll(String insInspectionSubId);
	
	/**
	 * 新增子单货物单条明细
	 */
	InsInspectionDetail addInsInspectionDetail(InsInspectionDetail insInspectionDetail);
	
	/**
	 * 删除子单货物单条
	 */
	Integer deleteInsInspectionDetail(String insInspectionDetailId);
	/**
	 * 修改子单货物内容
	 */
//	InsInspectionDetail updateInsInspectionDetail(InsInspectionDetail insInspectionDetail);
	InsInspectionBillDto updateInsInspectionDetail(InsInspectionBillDto insInspectionBillDto);
	/**
	 * 查询出主验货单下面的审核通过的子单的货品明细
	 */
	List<InsInspectionDetail> getInsInspectionDetailByPass(String  insInspectionBillId);
	/*****************额外的业务**********************/
	/**
	 * 批量添加数据
	 */
	InsInspectionBillDto addInsInspectionDetailAndInsInspectionSub(InsInspectionBillDto settlementDto);
	
	/**
	 * 修改子订单
	 */
	InsInspectionBillDto updateInsInspectionSubByDTO(InsInspectionBillDto settlementDto);
	/**
	 * 新增货品信息
	 */
	InsInspectionBillDto addInsInspectionDetailByDTO(InsInspectionBillDto settlementDto);
    
     
     /**
      * 金融服务部 审核通过不通过
      */
     Integer updateFinancialPassOrNotpass(InsInspectionBillDto settlementDto);
     /**
      * 结算部 审核通过不通过
      */
     Integer updateSettlePassOrNotpass(InsInspectionBillDto settlementDto);
 	
 	
}
