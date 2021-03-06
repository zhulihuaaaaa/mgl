package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.OutOutstockDetail;
import com.maigangle.gyl.facade.entity.OutOutstockDetailExample;
import com.maigangle.gyl.facade.entity.dto.OutStockDetailDto;
import com.maigangle.gyl.facade.entity.vo.OutOutstockDetailVo;
import com.maigangle.gyl.facade.entity.vo.RedRedeemGoodsVo;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.service.OutstockDetailService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.OutOutstockDetailMapper;
import com.maigangle.gyl.service.mapper.ext.RedRedeemBillExtMapper;



/**  
 * 出库货物明细Service实现
 * @author zlh
 * @since 2017年12月4日 上午8:55:14 
 * @version 1.0 
 */
@Service
@Transactional
public class OutstockDetailServiceImpl extends GylServiceImpl implements OutstockDetailService {
	@Autowired
	private OutOutstockDetailMapper outOutstockDetailMapper;
	@Autowired
	private InvInventoryService invInventoryService;
	@Autowired
	private RedRedeemBillExtMapper redRedeemBillExtMapper;
	@Autowired
	private ContractService contractService;
	@Autowired
	private RedRedeemBillService redRedeemBillService;
	
	/* 
	 * 新增id
	 * param list
	 */
	@Override
	public List<OutOutstockDetail> addOutstockDetail(List<OutOutstockDetail> list,String id) {
		if (!StringUtils.isEmpty(list.get(0))){
			for(int j=0;j<list.size();j++) {
				list.get(j).setOutstockBillId(id);
				outOutstockDetailMapper.insertSelective(list.get(j));
//				//待出库转出库
//				BigDecimal amount = list.get(j).getAmount();
//				String inventoryId = list.get(j).getInventoryId();
//				if(amount != null && inventoryId != null) {
//					invInventoryService.outstockQuantity(inventoryId,amount);
//				}
//				//查询仓库货物不为0合同
//				String contractId = list.get(j).getContractId();
//				if(contractId != null) {
//					List<RedRedeemGoodsVo> lists= redRedeemBillExtMapper.selectQuantityqGoods(contractId);
//					if(lists.size()<1){
//						contractService.updateConContractState(contractId);
//					}
//				}
//				//提货后修改赎货详情单状态
//				String redeemDetailId = list.get(j).getRedeemDetailId();
//				if(redeemDetailId != null) {
//					redRedeemBillService.updateRedRedeemBillState(redeemDetailId);
//				}
			}
//			List<OutOutstockDetail> lists = new ArrayList<OutOutstockDetail>();
//			for(int j=0;j<list.size();j++) {
//				OutOutstockDetail detail = new OutOutstockDetail();
//				InvInventoryDto inv = list.get(j);
//				detail.setStorageDate(inv.getInvInventory().getInstockDate());
//				detail.setRedeemMoney(new BigDecimal(1));
//				detail.setBuyerId(inv.getInvInventory().getBuyerId());
//				detail.setSellerId(inv.getInvInventory().getSellerId());
//				detail.setBusinessType(inv.getInvInventory().getBusinessType());
//				detail.setStorageId(inv.getInvInventory().getStorageId());
//				detail.setProductId(inv.getInvInventory().getProductId());
//				detail.setMaterialId(inv.getInvInventory().getMaterialId());
//				detail.setSurfaceId(inv.getInvInventory().getSurfaceId());
//				detail.setLabelThick(inv.getInvInventory().getLabelThick());
//				detail.setLabelWidth(inv.getInvInventory().getLabelWidth());
//				detail.setGoodsLength(inv.getInvInventory().getGoodsLength());
//				detail.setEdge(inv.getInvInventory().getEdge());
//				detail.setReferThick(inv.getInvInventory().getReferThick());
//				detail.setRealWidth(inv.getInvInventory().getRealWidth());
//				detail.setGoodsVolume(inv.getInvInventory().getVolume());
//				detail.setMnfctId(inv.getInvInventory().getMnfctId());
//				detail.setNetWeight(inv.getInvInventory().getNetWeight());
//				detail.setCalcMethod(inv.getInvInventory().getCalcMethod());
//				detail.setGrade(inv.getInvInventory().getGrade());
//				detail.setContractUnitPrice(inv.getInvInventory().getContractUnitPrice());
//				detail.setContractMoney(inv.getInvInventory().getContractMoney());
//				detail.setImplStd(inv.getInvInventory().getImplStd());
//				detail.setOutstockBillId(id);
//				detail.setStorageId(inv.getStorageId());
//				int rows = outOutstockDetailMapper.insertSelective(detail);
//				if(rows != 0) {
//					lists.add(detail);
//				}
//			}
//			return lists;
		}
		return null;
	}
	
	/* 
	 * 新增
	 */
	@Override
	public OutOutstockDetail addOutstockDetail(OutOutstockDetail detail) {
		if (StringUtils.isEmpty(detail.getOutstockDetailId())) {
		int rows = outOutstockDetailMapper.insertSelective(detail);
		return rows == 0 ? null : detail;
		}
		return null;
	}

	/* 
	 * 删除
	 */
	@Override
	public int deleteOutstockDetail(String outstockDetailId) {
		if(StringUtils.isEmpty(outstockDetailId)) {
			OutOutstockDetail b = new OutOutstockDetail();
			b.setOutstockDetailId(outstockDetailId);
			b.setIsDel("Y");
			return outOutstockDetailMapper.updateByPrimaryKey(b);
		}
		else {
			return 0;
		}
	}

	/* 
	 * 查询所有出库单
	 */
	@Override
	public List<OutOutstockDetail> getAllOutstockDetail(OutStockDetailDto dto,String orderByClause,boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		PageUtils<OutStockDetailDto> page = new PageUtils<OutStockDetailDto>(1, 0, dto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<OutOutstockDetail> info = this.getAllOutstockDetail(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	/* 
	 * 查询所有出库单带分页
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<OutOutstockDetail> getAllOutstockDetail(PageUtils<OutStockDetailDto> page, boolean isAccuracy) {
		if(page != null) {
			setPageAndOrderBy(page);
			OutOutstockDetailExample example = this.getOutstockDetailCriteria(page.getDto(), isAccuracy);
			List<OutOutstockDetail> list = outOutstockDetailMapper.selectByExample(example);
			return new PageInfo<OutOutstockDetail>(list);
		}
		return null;
	}
	
	/* 
	 * 根据id查询出库单
	 */
	@Override
	public List<OutOutstockDetailVo> getOutstockDetailById(String Id) {
		OutOutstockDetailExample example = new OutOutstockDetailExample();
		OutOutstockDetailExample.Criteria criteria = example.createCriteria();
		criteria.andOutstockBillIdEqualTo(Id);
		List<OutOutstockDetail> detailList = outOutstockDetailMapper.selectByExample(example);
		List<OutOutstockDetailVo> voList = new ArrayList<OutOutstockDetailVo>();
		for(int i=0;i<detailList.size();i++) {
			voList.add(new OutOutstockDetailVo());
			voList.get(i).setOutOutstockDetail(detailList.get(i));
		}
		return voList;
	}
	/**
	 * 生成OutstockDetail的查询条件
	 * 没有可填项
	 * @param dto
	 * @return OutstockDetailExample
	 */
	private OutOutstockDetailExample getOutstockDetailCriteria(OutStockDetailDto dto, boolean isAccuracy) {
		OutOutstockDetailExample example = new OutOutstockDetailExample();
		if (dto != null) {
			OutOutstockDetailExample.Criteria criteria = example.createCriteria();
			criteria.andOutstockDetailIdEqualTo(dto.getOutstockDetailId());
			criteria.andBusinessTypeEqualTo(dto.getBusinessType());
			criteria.andIsDelEqualTo(dto.getIsDel());
		}
		return example;
	}
	
	/* 
	 * 新增outOutstockDetailVo
	 * param OutOutstockDetail
	 */
	@Override
	public OutOutstockDetailVo addOutstockDetail(OutOutstockDetailVo outOutstockDetailVo) {
		if(StringUtils.isEmpty(outOutstockDetailVo.getOutOutstockDetail().getStorageDate())) {
			outOutstockDetailVo.getOutOutstockDetail().setStorageDate(new Date());
		}
			return outOutstockDetailMapper.insertSelective(outOutstockDetailVo.getOutOutstockDetail()) == 0 ? null : outOutstockDetailVo;	
	}

	/* 
	 * 更新
	 * 赎货明细-修改货物
	 */
	@Override
	public List<OutOutstockDetailVo> updateOutstockDetail(List<OutOutstockDetailVo> voList) {
		if (StringUtils.isEmpty(voList)) {
			return null;
		}
		OutOutstockDetailVo vo= null;
		for(int i=0;i<voList.size();i++) {
			outOutstockDetailMapper.deleteByPrimaryKey(voList.get(i).getOutOutstockDetail().getOutstockDetailId());
			 //赎货金额假数据
			 voList.get(i).getOutOutstockDetail().setRedeemMoney(new BigDecimal("1"));
			 vo = addOutstockDetail(voList.get(i));
		}
		return vo == null ? null : voList;
	}

}
