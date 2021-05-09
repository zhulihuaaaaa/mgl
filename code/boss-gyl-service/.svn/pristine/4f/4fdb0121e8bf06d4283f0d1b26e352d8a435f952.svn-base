package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.entity.OutOutstockBill;
import com.maigangle.gyl.facade.entity.OutOutstockBillExample;
import com.maigangle.gyl.facade.entity.api.PrivUser;
import com.maigangle.gyl.facade.entity.dto.OutStockBillDto;
import com.maigangle.gyl.facade.entity.vo.OutOutstockDetailVo;
import com.maigangle.gyl.facade.entity.vo.RedRedeemGoodsVo;
import com.maigangle.gyl.facade.enums.ContractBillStateEnum;
import com.maigangle.gyl.facade.enums.ContractBillTypeEnum;
import com.maigangle.gyl.facade.enums.GoodsSourceEnum;
import com.maigangle.gyl.facade.enums.OutstockStateEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.GylService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.service.OutstockBillService;
import com.maigangle.gyl.facade.service.OutstockDetailService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.OutOutstockBillMapper;
import com.maigangle.gyl.service.mapper.ext.RedRedeemBillExtMapper;



/**  
 * 出库设置Service实现
 * @author zlh
 * @since 2017年12月4日 上午8:55:14 
 * @version 1.0 
 */
@Service
@Transactional
public class OutstockBillServiceImpl extends GylServiceImpl implements OutstockBillService {
	@Autowired
	private OutOutstockBillMapper outOutstockBillMapper;
	@SuppressWarnings("rawtypes")
	@Autowired
	private GylService gylService;
	@Autowired
	private OutstockDetailService outstockDetailService;
	@Autowired
	private RedRedeemBillExtMapper redRedeemBillExtMapper;
	@Autowired
	private InvInventoryService invInventoryService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private RedRedeemBillService redRedeemBillService;
	/* 
	 * 新增
	 */
	@Override
	public OutOutstockBill addOutstockBill(OutOutstockBill outOutstockBill) {
		if(outOutstockBill != null) {
			outOutstockBill.setOutstockCode(gylService.generateCode("TB_OUT_OUTSTOCK_BILL", "CK"));
			outOutstockBill.setCreateDate(new Date());
			//outOutstockBill.setCreateUser(gylApiService.getCurrentPrivUser().getUserName());
			outOutstockBill.setIsDel(YesOrNoEnum.NO.getCode());
			outOutstockBill.setOutstockState(OutstockStateEnum.UNCOMMITE.getState());
			int rows = outOutstockBillMapper.insertSelective(outOutstockBill);
			//查询仓库货物不为0合同
//			String contractId = outOutstockBill.getContractId();
//			if(contractId != null) {
//				List<RedRedeemGoodsVo> list= redRedeemBillExtMapper.selectQuantityqGoods(contractId);
//				if(list.size()<1){
//					contractService.updateConOutstockState(contractId);
//				}
//			}
			return rows == 0 ? null : outOutstockBill;
		}
		return null;
	}

	/* 
	 * 更新
	 */
	@Override
	public OutOutstockBill updateOutstockBill(OutOutstockBill outOutstockBill) {
		if (StringUtils.isEmpty(outOutstockBill.getOutstockBillId())) {
			return null;
		}
//		//先绑定合同id？
//		if (StringUtils.isEmpty(outOutstockBill.getContractId())) {
//			return null;
//		}
		return outOutstockBillMapper.updateByPrimaryKeySelective(outOutstockBill) == 0 ? null : outOutstockBill; 
	}

	/* 
	 * 删除
	 */
	@Override
	public int deleteOutstockBill(String outstockBillId) {
		if(StringUtils.isEmpty(outstockBillId)) {
			OutOutstockBill b = new OutOutstockBill();
			b.setOutstockBillId(outstockBillId);
			b.setIsDel("Y");
			return outOutstockBillMapper.updateByPrimaryKeySelective(b);
		}
		else {
			return 0;
		}
	}

	/* 
	 * 查询所有出库单
	 */
	@Override
	public List<OutOutstockBill> getAllOutstockBill(OutStockBillDto dto,String orderByClause,boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		OutOutstockBillExample example = this.getOutstockBillCriteria(dto, isAccuracy);
		List<OutOutstockBill> list = outOutstockBillMapper.selectByExample(example);
//		PageUtils<OutStockBillDto> page = new PageUtils<OutStockBillDto>(1, 0, dto);
//		if (!StringUtils.isEmpty(orderByClause)) {
//			page.setOrderByClause(orderByClause);
//		}
//		PageInfo<OutOutstockBill> info = this.getAllOutstockBill(page, isAccuracy);
		return list == null ? null : list;
//		return null;
	}

	/* 
	 * 查询所有出库单带分页
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<OutStockBillDto> getAllOutstockBill(PageUtils<OutStockBillDto> page, boolean isAccuracy) {
		if(page == null) {
			return new PageInfo<OutStockBillDto>();
		}
		setPageAndOrderBy(page);
		OutStockBillDto dto = page.getDto();
		OutOutstockBillExample example = this.getOutstockBillCriteria(dto, isAccuracy);
		List<OutOutstockBill> list = outOutstockBillMapper.selectByExample(example);
		List<OutStockBillDto> dtos = new ArrayList<OutStockBillDto>();
		for(int i=0;i<list.size();i++) {
			dtos.add(new OutStockBillDto());
			dtos.get(i).setOutOutstockBill(list.get(i));;
//			DictMallDepot storage = gylApiService.getDictMallDepot(list.get(i).getStorageId());
//			dtos.add(new OutStockBillDto());
//			dtos.get(i).setOutOutstockBill(list.get(i));
//			dtos.get(i).setStorageName(storage.getDptName());
//			dtos.get(i).setClientName(gylApiService.getCrmClient(list.get(i).getCustomerId()).getClientName());
//			dtos.get(i).setConsigneeName(gylApiService.getCrmClient(list.get(i).getConsignee()).getClientName());
		}
		//处理分页丢失数据
		PageInfo<OutOutstockBill> info= new PageInfo<OutOutstockBill>(list);
		PageInfo<OutStockBillDto> dtoss= new PageInfo<OutStockBillDto>();
		BeanUtils.copyProperties(info,dtoss);
		dtoss.setList(dtos);
		return dtoss;
	}
	
	/* 
	 * 根据id查询出库单
	 */
	@Override
	public OutOutstockBill getOutstockBillById(String outstockBillId) {
		OutStockBillDto dto = new OutStockBillDto();
		dto.setOutstockBillId(outstockBillId);
		List<OutOutstockBill> list = this.getAllOutstockBill(dto,"", true);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	

	/* 
	 * 根据合同id查询出库单
	 */
	@Override
	public OutOutstockBill getOutstockBillByContractId(String contractId) {
		OutStockBillDto dto = new OutStockBillDto();
		dto.setOutstockBillId(contractId);
		List<OutOutstockBill> list = this.getAllOutstockBill(dto,"", true);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 生成OutstockBill的查询条件
	 * 没有可填项
	 * @param dto
	 * @return OutstockBillExample
	 */
	private OutOutstockBillExample getOutstockBillCriteria(OutStockBillDto dto, boolean isAccuracy) {
		OutOutstockBillExample example = new OutOutstockBillExample();
		if (dto != null) {
			OutOutstockBillExample.Criteria criteria = example.createCriteria();
			/*if(dto.getOutstockBillId() != null) {
				criteria.andOutstockBillIdEqualTo(dto.getOutstockBillId());
			}*/
			if(!StringUtils.isEmpty(dto.getCustomerId())) {
				criteria.andCustomerIdEqualTo(dto.getCustomerId());
			}
			if(!StringUtils.isEmpty(dto.getOutstockCode())) {
				criteria.andOutstockCodeLike("%" + dto.getOutstockCode() + "%");
			}
			if(!StringUtils.isEmpty(dto.getBusinessType())) {
				criteria.andBusinessTypeEqualTo(dto.getBusinessType());
			}
			if(!StringUtils.isEmpty(dto.getStorageId())) {
				criteria.andStorageIdEqualTo(dto.getStorageId());
			}
			if(!StringUtils.isEmpty(dto.getConsignee())) {
				criteria.andConsigneeLike("%" + dto.getConsignee() + "%");
			}
			//时间
			if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
				criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
			} else if (dto.getStartCreateDate() != null) {
				criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
			} else if (dto.getEndCreateDate() != null) {
				criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
			}
			//提货单状态
			if (!StringUtils.isEmpty(dto.getOutstockState())) {
				if (dto.getOutstockState().equals(OutstockStateEnum.APPROVAL.toString())) {
					criteria.andOutstockStateEqualTo(OutstockStateEnum.APPROVAL.toString());
				}  else if (dto.getOutstockState().equals(OutstockStateEnum.COMPLETE.toString())) {
					criteria.andOutstockStateEqualTo(OutstockStateEnum.COMPLETE.toString());
				} else if (dto.getOutstockState().equals(OutstockStateEnum.SUSPEND.toString())) {
					criteria.andOutstockStateEqualTo(OutstockStateEnum.SUSPEND.toString());
				} else if (dto.getOutstockState().equals(OutstockStateEnum.CLOSE.toString())) {
					criteria.andOutstockStateEqualTo(OutstockStateEnum.CLOSE.toString());
				} else if (dto.getOutstockState().equals(OutstockStateEnum.REJECT.toString())) {
					criteria.andOutstockStateEqualTo(OutstockStateEnum.REJECT.toString());
				} else if (dto.getOutstockState().equals(OutstockStateEnum.UNCOMMITE.toString())) {
					criteria.andOutstockStateEqualTo(OutstockStateEnum.UNCOMMITE.toString());
				}
			}
			if (dto.getOutstockStateForApprove() != null) {
				criteria.andOutstockStateNotEqualTo(OutstockStateEnum.UNCOMMITE.getState());
			}
			/*criteria.andCreateDateBetween(dto.getStartCreateDate(),dto.getEndCreateDate());
			criteria.andIsDelEqualTo(dto.getIsDel());*/
		}
		return example;
	}

	@Override
	public boolean onOutstockApprovalComplete(String id, PrivUser user) {
		OutOutstockBill bill = this.getOutstockBillById(id);
		bill.setOutstockState(OutstockStateEnum.COMPLETE.getState());
		OutOutstockBill out = this.updateOutstockBill(bill);
		List<OutOutstockDetailVo> list = outstockDetailService.getOutstockDetailById(id);
		if (!StringUtils.isEmpty(list.get(0))){
			for(int j=0;j<list.size();j++) {
				//待出库转出库
				BigDecimal amount = list.get(j).getOutOutstockDetail().getAmount();
				String inventoryId = list.get(j).getOutOutstockDetail().getInventoryId();
				if(amount != null && inventoryId != null) {
					invInventoryService.outstockQuantity(inventoryId,amount);
				}
				//查询仓库货物不为0合同
				String contractId = list.get(j).getOutOutstockDetail().getContractId();
				if(contractId != null) {
					List<RedRedeemGoodsVo> lists= redRedeemBillExtMapper.selectQuantityqGoods(contractId);
					if(lists.size()<1){
						contractService.updateConContractState(contractId);
					}
				}
				//提货后修改赎货详情单状态
				String redeemDetailId = list.get(j).getOutOutstockDetail().getRedeemDetailId();
				if(redeemDetailId != null) {
					redRedeemBillService.updateRedRedeemBillState(redeemDetailId);
				}
			}
		}
		return out!=null;
	}
	
	@Override
	public boolean onOutstockSumit (String id,PrivUser user) {
		OutOutstockBill bill = new OutOutstockBill();
		bill.setOutstockBillId(id);
		bill.setOutstockState(OutstockStateEnum.APPROVAL.getState());
		OutOutstockBill out = this.updateOutstockBill(bill);
		return out!=null;
	}
	
	@Override
	public boolean onOutstockApproval(String id,PrivUser user) {
		OutOutstockBill bill = new OutOutstockBill();
		bill.setOutstockBillId(id);
		bill.setOutstockState(OutstockStateEnum.APPROVAL.getState());
		OutOutstockBill out = this.updateOutstockBill(bill);
		return out!=null;
	}
	
	@Override
	public boolean onOutstockApprovalSuspend(String id,PrivUser user){
		OutOutstockBill bill = new OutOutstockBill();
		bill.setOutstockBillId(id);
		bill.setOutstockState(OutstockStateEnum.REJECT.getState());
		OutOutstockBill out = this.updateOutstockBill(bill);
		return out!=null;
	}
	@Override
	public boolean  onOutstockAbandonApproval(String id,PrivUser user) {
		OutOutstockBill bill = new OutOutstockBill();
		bill.setOutstockBillId(id);
		bill.setOutstockState(OutstockStateEnum.UNCOMMITE.getState());
		OutOutstockBill out = this.updateOutstockBill(bill);
		return out!=null;
	}
}
