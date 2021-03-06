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
import com.maigangle.gyl.facade.entity.FeeDepositAccount;
import com.maigangle.gyl.facade.entity.RedRedeemBill;
import com.maigangle.gyl.facade.entity.RedRedeemBillExample;
import com.maigangle.gyl.facade.entity.RedRedeemDetail;
import com.maigangle.gyl.facade.entity.RedRedeemDetailExample;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.dto.InvoiceGoodsConditionDto;
import com.maigangle.gyl.facade.entity.dto.RedRedeemBillDto;
import com.maigangle.gyl.facade.entity.dto.RedRedeemDetailDto;
import com.maigangle.gyl.facade.entity.vo.InvoiceGoodsConditionVo;
import com.maigangle.gyl.facade.entity.vo.RedRedeemGoodsVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.RedeemBillDetailStateEnum;
import com.maigangle.gyl.facade.enums.RedeemBillStateEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.GylService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.service.RedRedeemBillService;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.RedRedeemBillMapper;
import com.maigangle.gyl.service.mapper.RedRedeemDetailMapper;
import com.maigangle.gyl.service.mapper.ext.RedRedeemBillExtMapper;



/**  
 * 赎货单service实现
 * @author zlh
 * @since 2017年12月1日 上午8:36:54 
 * @version 1.0 
 */
@Service
@Transactional
public class RedRedeemBillServiceImpl extends GylServiceImpl implements RedRedeemBillService {
	@Autowired
	private RedRedeemBillMapper redRedeemBillMapper;
	@Autowired
	private RedRedeemBillExtMapper redRedeemBillExtMapper;
	@Autowired
	private RedRedeemDetailMapper redRedeemDetailMapper;
	@Autowired
	private GylService<?> gylService;
	@Autowired
	private InvInventoryService invInventoryService;
	@Autowired
	private FinanceService financeService;
	
	@Override
	public PageInfo<InvoiceGoodsConditionVo> getInvoiceGoodsOut(PageUtils<InvoiceGoodsConditionDto> page) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		List<InvoiceGoodsConditionVo> list = redRedeemBillExtMapper.getInvoiceGoodsOut(page.getDto());
		return new PageInfo<>(list);
	}
	
	@Override
	public int updateRedRedeemBillState(String detailId) {
		RedRedeemDetail detail = new RedRedeemDetail();
		detail.setRedeemDetailId(detailId);
		detail.setState(RedeemBillDetailStateEnum.YI_CHU_KU.getType());
		redRedeemDetailMapper.updateByPrimaryKeySelective(detail);
		String redRedeemId = redRedeemDetailMapper.selectByPrimaryKey(detailId).getRedeemBillId();
		RedRedeemDetailExample example = new RedRedeemDetailExample();
		RedRedeemDetailExample.Criteria criteria = example.createCriteria();
		criteria.andRedeemBillIdEqualTo(redRedeemId);
		List<RedRedeemDetail> list = redRedeemDetailMapper.selectByExample(example);
		String type = "";
		for(int i=0;i<list.size();i++) {
			 type += list.get(i).getState();
		}
		if(type.indexOf(RedeemBillDetailStateEnum.WEI_CHU_KU.getType()) == -1) {
			RedRedeemBill bill = new RedRedeemBill();
			bill.setRedeemBillId(redRedeemId);
			bill.setRedeemStatus(RedeemBillStateEnum.YI_CHU_KU.getType());
			return redRedeemBillMapper.updateByPrimaryKeySelective(bill);
		}
		return 0;
	}

	@Override
	public RedRedeemBill addRedRedeemBill(RedRedeemBill redRedeemBill) {
		redRedeemBill.setRedeemBillCode(gylService.generateCode("TB_RED_REDEEM_BILL","SH"));
		redRedeemBill.setCreateDate(new Date());
		redRedeemBill.setRedeemStatus(RedeemBillStateEnum.YI_BAO_CUN.getType());
		int rows = redRedeemBillMapper.insertSelective(redRedeemBill);
		return rows == 0 ? null : redRedeemBill;
	}

	@Override
	public int updateRedRedeemBill(RedRedeemBill redRedeemBill) {
		if (StringUtils.isEmpty(redRedeemBill.getRedeemBillId())) {
			return 0;
		}
		return redRedeemBillMapper.updateByPrimaryKeySelective(redRedeemBill);
	}

	@Override
	public int deleteRedRedeemBill(String redRedeemBillId) {
		if (StringUtils.isEmpty(redRedeemBillId)) {
			return 0;
		}
		RedRedeemBill bill = new RedRedeemBill();
		bill.setRedeemBillId(redRedeemBillId);
		bill.setIsDel(YesOrNoEnum.YES.toString());
		return redRedeemBillMapper.updateByPrimaryKeySelective(bill);
	}

	@Override
	public List<RedRedeemBill> getAllRedRedeemBill(RedRedeemBillDto redRedeemBillDto, String orderByClause, boolean isAccuracy) {
		if (redRedeemBillDto == null) {
			return null;
		}
		PageUtils<RedRedeemBillDto> page = new PageUtils<RedRedeemBillDto>(1, 0, redRedeemBillDto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<RedRedeemBill> info = this.getAllRedRedeemBill(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public PageInfo<RedRedeemBill> getAllRedRedeemBill(PageUtils<RedRedeemBillDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		RedRedeemBillExample example = this.getRedRedeemBillCriteria(page.getDto(), isAccuracy);
		List<RedRedeemBill> list = redRedeemBillMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public RedRedeemBill getRedRedeemBillById(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		return redRedeemBillMapper.selectByPrimaryKey(id);
	}

	@Override
	public RedRedeemBill getRedRedeemBillByCode(String code) {
		if (StringUtils.isEmpty(code)) {
			return null;
		}
		RedRedeemBillDto bill = new RedRedeemBillDto();
		bill.setRedeemBillCode(code);
		List<RedRedeemBill> list = this.getAllRedRedeemBill(bill, null, true);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<RedRedeemBill> getRedRedeemBillByGoodsSource(String goodsSource) {
		if (StringUtils.isEmpty(goodsSource)) {
			return null;
		}
		RedRedeemBillDto bill = new RedRedeemBillDto();
		bill.setGoodsSource(goodsSource);
		return this.getAllRedRedeemBill(bill, null, true);
	}

	@Override
	public boolean doAudit(String redeemBillId, String status) {
		if (StringUtils.isEmpty(redeemBillId) || StringUtils.isEmpty(status)) {
			return false;
		}
		RedRedeemBill bill = new RedRedeemBill();
		bill.setRedeemBillId(redeemBillId);
		bill.setAuditStatus(status);
		if (ApprovalStateEnum.APPROVAL_UNDERWAY.toString().equals(status)) {
			bill.setRedeemStatus(RedeemBillStateEnum.DAI_SHEN_HE.toString());
		}
		int rows = redRedeemBillMapper.updateByPrimaryKeySelective(bill);
		return rows == 0 ? false : true;
	}

	/**
	 * 生成RedRedeemBill的查询条件
	 * 没有可填项
	 * @param dto
	 * @return RedRedeemBillExample
	 */
	private RedRedeemBillExample getRedRedeemBillCriteria(RedRedeemBillDto dto, boolean isAccuracy) {
		if (dto == null) {
			return null;
		}
		RedRedeemBillExample example = new RedRedeemBillExample();
		RedRedeemBillExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(dto.getGoodsSource())) {
			criteria.andGoodsSourceEqualTo(dto.getGoodsSource());
		}
		if (!StringUtils.isEmpty(dto.getContractId())) {
			criteria.andContractIdEqualTo(dto.getContractId());
		}
		if (!StringUtils.isEmpty(dto.getRedeemBillId())) {
			criteria.andRedeemBillIdEqualTo(dto.getRedeemBillId());
		}
		if (!StringUtils.isEmpty(dto.getRedeemBillCode())) {
			if (isAccuracy) {
				criteria.andRedeemBillCodeEqualTo(dto.getRedeemBillCode());
			} else {
				criteria.andRedeemBillCodeLike("%" + dto.getRedeemBillCode().toUpperCase() + "%");
			}
		}
		if (!StringUtils.isEmpty(dto.getAuditStatus())) {
			criteria.andAuditStatusEqualTo(dto.getAuditStatus());
		}
		if (!StringUtils.isEmpty(dto.getRedeemStatus())) {
			criteria.andRedeemStatusEqualTo(dto.getRedeemStatus());
		}
		if (!StringUtils.isEmpty(dto.getBuyerId())) {
			criteria.andBuyerIdEqualTo(dto.getBuyerId());
		}
		if (!StringUtils.isEmpty(dto.getCreateUser())) {
			if (isAccuracy) {
				criteria.andCreateUserEqualTo(dto.getCreateUser());
			} else {
				criteria.andCreateUserLike("%" + dto.getCreateUser() + "%");
			}
		}
		if (dto.getStartCreateDate() != null && dto.getEndCreateDate() != null) {
			criteria.andCreateDateBetween(dto.getStartCreateDate(), dto.getEndCreateDate());
		} else if (dto.getStartCreateDate() != null) {
			criteria.andCreateDateGreaterThanOrEqualTo(dto.getStartCreateDate());
		} else if (dto.getEndCreateDate() != null) {
			criteria.andCreateDateLessThanOrEqualTo(dto.getEndCreateDate());
		}
		
		if (dto.getAuditStatusSearch() != null && !dto.getAuditStatusSearch().isEmpty()) {
			criteria.andAuditStatusIn(dto.getAuditStatusSearch());
		}
		
		if (dto.getGoodsSourceSearch() != null && !dto.getGoodsSourceSearch().isEmpty()) {
			criteria.andGoodsSourceIn(dto.getGoodsSourceSearch());
		}
		
		return example;
	}

	@Override
	public RedRedeemDetail addRedeemDetail(RedRedeemDetail redRedeemDetail) {
		if (redRedeemDetail == null) {
			return null;
		}
		redRedeemDetail.setIsDel(YesOrNoEnum.NO.getCode());
		redRedeemDetail.setState(RedeemBillDetailStateEnum.WEI_CHU_KU.getType());
		int rows = redRedeemDetailMapper.insertSelective(redRedeemDetail);
		return rows == 0 ? null : redRedeemDetail;
	}

	@Override
	public List<RedRedeemDetail> addRedeemDetailBatch(List<RedRedeemDetail> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		List<RedRedeemDetail> resultList = new ArrayList<>();
		for (RedRedeemDetail detail : list) {
			resultList.add(addRedeemDetail(detail));
		}
		return resultList;
	}

	@Override
	public int deleteRedeemDetail(String redeemDetailId) {
		if (StringUtils.isEmpty(redeemDetailId)) {
			return 0;
		}
		RedRedeemDetail detail = new RedRedeemDetail();
		detail.setRedeemDetailId(redeemDetailId);
		detail.setIsDel(YesOrNoEnum.YES.toString());
		return redRedeemDetailMapper.updateByPrimaryKeySelective(detail);
	}

	@Override
	public int deleteRedeemDetailBatch(List<String> ids) {
		if (ids == null || ids.isEmpty()) {
			return 0;
		}
		int count = 0;
		for (String id : ids) {
			count += deleteRedeemDetail(id);
		}
		return count;
	}

	@Override
	public int updateRedeemDetail(RedRedeemDetail redRedeemDetail) {
		if (redRedeemDetail == null || StringUtils.isEmpty(redRedeemDetail.getRedeemDetailId())) {
			return 0;
		}
		return redRedeemDetailMapper.updateByPrimaryKeySelective(redRedeemDetail);
	}

	@Override
	public int updateRedeemDetailBatch(List<RedRedeemDetail> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int count = 0;
		for (RedRedeemDetail detail : list) {
			count += updateRedeemDetail(detail);
		}
		return count;
	}

	@Override
	public PageInfo<RedRedeemDetail> getAllRedRedeemDetail(PageUtils<RedRedeemDetailDto> page, boolean isAccuracy) {
		if (page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		RedRedeemDetailExample example = this.getRedRedeemDetailCriteria(page.getDto(), isAccuracy);
		List<RedRedeemDetail> list = redRedeemDetailMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	@Override
	public List<RedRedeemDetail> getAllRedRedeemDetail(RedRedeemDetailDto redRedeemDetailDto, String orderByClause,
			boolean isAccuracy) {
		if (redRedeemDetailDto == null) {
			return null;
		}
		PageUtils<RedRedeemDetailDto> page = new PageUtils<RedRedeemDetailDto>(1, 0, redRedeemDetailDto);
		if (!StringUtils.isEmpty(orderByClause)) {
			page.setOrderByClause(orderByClause);
		}
		PageInfo<RedRedeemDetail> info = this.getAllRedRedeemDetail(page, isAccuracy);
		return info == null ? null : info.getList();
	}

	@Override
	public RedRedeemDetail getOneRedRedeemDetail(String detailId) {
		if (StringUtils.isEmpty(detailId)) {
			return null;
		}
		return redRedeemDetailMapper.selectByPrimaryKey(detailId);
	}

	@Override
	public List<RedRedeemDetail> getRedRedeemDetailByBillId(String billId) {
		if (StringUtils.isEmpty(billId)) {
			return null;
		}
		RedRedeemDetailDto detail = new RedRedeemDetailDto();
		detail.setRedeemBillId(billId);
		return getAllRedRedeemDetail(detail, null, true);
	}
	
	/**
	 * 生成货物明细的查询条件
	 * @param redRedeemDetailDto
	 * @param isAccuracy
	 * @return
	 */
	private RedRedeemDetailExample getRedRedeemDetailCriteria(RedRedeemDetailDto redRedeemDetailDto, boolean isAccuracy) {
		if (redRedeemDetailDto == null) {
			return null;
		}
		RedRedeemDetailExample example = new RedRedeemDetailExample();
		RedRedeemDetailExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(redRedeemDetailDto.getRedeemBillId())) {
			criteria.andRedeemBillIdEqualTo(redRedeemDetailDto.getRedeemBillId());
		}
		return example;
	}

	@Override
	public Integer billWasAudited(String redeemBillId, String status) {
		if (StringUtils.isEmpty(redeemBillId) || StringUtils.isEmpty(status)) {
			return 0;
		}
		List<RedRedeemDetail> detailList = getRedRedeemDetailByBillId(redeemBillId);
		RedRedeemBill bill = getRedRedeemBillById(redeemBillId);
		if (detailList != null && !detailList.isEmpty()) {
			if (status.equals(ApprovalStateEnum.APPROVAL_COMPLETE.toString())) {
				bill.setRedeemStatus(RedeemBillStateEnum.DAI_CHU_KU.toString());
				for (RedRedeemDetail detail : detailList) {
					invInventoryService.nextOutstockQuantity(detail.getInventoryId(), detail.getAmount());
				}
			} else if (status.equals(ApprovalStateEnum.APPROVAL_SUSPEND.toString())) {
				bill.setRedeemStatus(RedeemBillStateEnum.YI_ZUO_FEI.toString());
				for (RedRedeemDetail detail : detailList) {
					invInventoryService.removerQuantity(detail.getInventoryId(), detail.getAmount());
				}
			}
			updateRedRedeemBill(bill);
		}
		return 1;
	}

	@Override
	public List<RedRedeemGoodsVo> getRedRedeemBillByClientIdAndStorageId(String buyerId, String storageId) {
		if(buyerId != null && storageId != null) {
			 return redRedeemBillExtMapper.selectNextOutstockGoods(buyerId, storageId);
		}
		return null;
	}
	@Override
	public BigDecimal isLastGoods(List<RedRedeemDetail> details, String contractId) {
		if (details == null || details.isEmpty() || StringUtils.isEmpty(contractId)) {
			return new BigDecimal(-1);
		}
		List<InvInventoryDto> inventoryList = invInventoryService.getInvInventoryByConId(contractId);
		if (inventoryList == null || inventoryList.isEmpty()) {
			return new BigDecimal(-1);
		}
		if (details.size() != inventoryList.size()) {
			return new BigDecimal(-1);
		}
		for (RedRedeemDetail detail : details) {
			for (InvInventoryDto dto : inventoryList) {
				if (detail.getInventoryId().equals(dto.getId())) {
					if (detail.getAmount().compareTo(dto.getEnableNum()) != 0) {
						return new BigDecimal(-1);
					}
				}
			}
		}
		FeeDepositAccount depositAccount = financeService.getDepositAccountByContractId(contractId);
		return depositAccount != null ? depositAccount.getBalance() : null;
	}
}
	