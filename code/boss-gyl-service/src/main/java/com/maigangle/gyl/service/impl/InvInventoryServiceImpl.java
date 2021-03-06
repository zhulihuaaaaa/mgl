package com.maigangle.gyl.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maigangle.gyl.facade.constant.GylGlobalConstant;
import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.BaseProductExample;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.FeeBalance;
import com.maigangle.gyl.facade.entity.FeeBalanceDetail;
import com.maigangle.gyl.facade.entity.FeeBalanceDetailExample;
import com.maigangle.gyl.facade.entity.FeeBalanceExample;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InvCheckInv;
import com.maigangle.gyl.facade.entity.InvCheckInvDetail;
import com.maigangle.gyl.facade.entity.InvCheckInvDetailExample;
import com.maigangle.gyl.facade.entity.InvCheckInvExample;
import com.maigangle.gyl.facade.entity.InvInventory;
import com.maigangle.gyl.facade.entity.InvInventoryExample;
import com.maigangle.gyl.facade.entity.OutOutstockDetail;
import com.maigangle.gyl.facade.entity.OutOutstockDetailExample;
import com.maigangle.gyl.facade.entity.InvInventoryExample.Criteria;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.vo.ConContractVo;
import com.maigangle.gyl.facade.entity.vo.FeeBalanceDetailVo;
import com.maigangle.gyl.facade.entity.vo.FeeBalanceVo;
import com.maigangle.gyl.facade.entity.vo.InvCheckInvVo;
import com.maigangle.gyl.facade.entity.vo.OutOutstockDetailVo;
import com.maigangle.gyl.facade.enums.BalanceTypeEnum;
import com.maigangle.gyl.facade.enums.BusinessTypeEnum;
import com.maigangle.gyl.facade.enums.ContractBillStateEnum;
import com.maigangle.gyl.facade.enums.GoodsSourceEnum;
import com.maigangle.gyl.facade.enums.ImageFileTypeEnum;
import com.maigangle.gyl.facade.enums.InOrNotStockEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.BaseService;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.GylBaseService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.utils.DateUtils;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.FeeBalanceDetailMapper;
import com.maigangle.gyl.service.mapper.FeeBalanceMapper;
import com.maigangle.gyl.service.mapper.InvCheckInvDetailMapper;
import com.maigangle.gyl.service.mapper.InvCheckInvMapper;
import com.maigangle.gyl.service.mapper.InvInventoryMapper;
import com.maigangle.gyl.service.mapper.ext.ConContractExtMapper;
import com.maigangle.gyl.service.mapper.ext.InvInventoryExtMapper;

/**
 * ????????????????????????
 * @author ?????????
 * @since  2017???11???28??? - ??????2:34:58
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
@Service
@Transactional
public class InvInventoryServiceImpl extends GylServiceImpl  implements InvInventoryService{
	@Autowired
	InvInventoryMapper invInventoryMapper;
	@Autowired
	InvCheckInvMapper invCheckInvMapper;
	@Autowired
	InvCheckInvDetailMapper invCheckInvDetailMapper;
	@Autowired
	InvInventoryExtMapper invInventoryExtMapper;
	@Autowired
	BaseService baseService;
	@Autowired
	ContractService contractService;
	@Autowired
	GylBaseService gylBaseService;
	@Autowired
	FeeBalanceMapper feeBalanceMapper;
	@Autowired
	FeeBalanceDetailMapper feeBalanceDetailMapper;
	@Autowired
	private ConContractExtMapper conContractExtMapper;
	/*********************************??????**************************/
	@Override
	public List<InvInventoryDto> getStockByConContractIdAndStorageId(String ConContractId, String StorageId,String goodsSource) {
		InvInventoryExample example = new InvInventoryExample();
		InvInventoryExample.Criteria c = example.createCriteria();
		if(StringUtils.isEmpty(StorageId)|| StringUtils.isEmpty(ConContractId)||StringUtils.isEmpty(goodsSource)) {
			return null;
		}
		c.andContractIdEqualTo(ConContractId);
		c.andStorageIdEqualTo(StorageId);
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		List<String> list1 = new ArrayList<>();
		// ???????????????????????????????????????
		if(GoodsSourceEnum.CANG_DAN_ZHI_YA.toString().endsWith(goodsSource)) {
			// ????????????
			// ?????????????????????

			c.andBusinessTypeEqualTo(BusinessTypeEnum.CANG_DAN_ZHI_YA.toString());

			// ?????????????????????
			c.andStorageIdNotEqualTo(GylGlobalConstant.VIRTUAL_MALL_DEPOT);
		}else if(GoodsSourceEnum.KU_CUN_HUO_WU.toString().equals(goodsSource)) {
			//????????????

			list1.add(BusinessTypeEnum.CANG_DAN_ZHI_YA.toString());

		}else if(GoodsSourceEnum.GANG_CHANG_ZI_TI.toString().equals(goodsSource)) {
			// ????????????
			//??????????????????

			list1.add(BusinessTypeEnum.CANG_DAN_ZHI_YA.toString());

			// ????????????????????????
			c.andStorageIdEqualTo(GylGlobalConstant.VIRTUAL_MALL_DEPOT);
		}
		c.andOwnCargoNotEqualTo(YesOrNoEnum.YES.toString());
		list1.add(BusinessTypeEnum.CAI_GOU_ZI_XIAO.toString());
		c.andBusinessTypeNotIn(list1);
		List<InvInventory> list= invInventoryMapper.selectByExample(example);
		return format(list);
	}

	@Override
	public List<InvInventoryDto> getStockByBuyerIdAndStorageId(String buyerId, String StorageId) {
		InvInventoryExample example = new InvInventoryExample();
		InvInventoryExample.Criteria c = example.createCriteria();
		if(StringUtils.isEmpty(StorageId)|| StringUtils.isEmpty(buyerId)) {
			return null;
		}
		c.andBuyerIdEqualTo(buyerId);
		c.andStorageIdEqualTo(StorageId);
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		List<InvInventory> list= invInventoryMapper.selectByExample(example);
		return format(list);
	}
	

	
	/**
	 * 
	 * @author shmily
	 * @Title: getStorage 
	 * @Description: ( ????????????id ???????????????ID?????? ) 
	 * @param ConContractId
	 * @return List<String>
	 * @throws
	 */
	@Override
	public List<String> getStorage(String ConContractId) {	
		return invInventoryExtMapper.getStorage(ConContractId);
	}
	
	
	@Override
	public List<InvInventoryDto> getInvInventoryByConId(String conId) {
		InvInventoryExample example = new InvInventoryExample();
		InvInventoryExample.Criteria c = example.createCriteria();
		if(StringUtils.isEmpty(conId)) {
			return null;
		}
		c.andContractIdEqualTo(conId);
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		List<InvInventory> list= invInventoryMapper.selectByExample(example);
		return format(list);
	}
	
	
	
	/*********************************end***************************/
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<InvInventory> getStockAll(PageUtils<InvInventoryDto> page,Boolean isAccuracy) {
		if(page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		InvInventoryDto dto = page.getDto();
		InvInventoryExample example = getExample(dto,isAccuracy);
		// ?????????????????????????????????
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		PageHelper.orderBy(page.getOrderByClause());
		List<InvInventory> list= invInventoryMapper.selectByExample(example);
		PageInfo<InvInventory> pageInv = new PageInfo<>(list);
		return pageInv; 
	}
	/**
	 * ??????????????????
	 * @param dto
	 * @return
	 */
	private InvInventoryExample getExample(InvInventoryDto inv,Boolean isAccuracy) {
		InvInventoryExample example = new InvInventoryExample();
		InvInventoryExample.Criteria c = example.createCriteria();
		if (inv == null) {
			return example;
		}
		// ????????????
		// ????????????
		if (!StringUtils.isEmpty(inv.getBusinessType())) {
			c.andBusinessTypeEqualTo(inv.getBusinessType());
		}
		// ??????????????????
		if(inv.getTypeList()!=null&&!inv.getTypeList().isEmpty()) {
			c.andBusinessTypeIn(inv.getTypeList());
		}
		// ??????????????????
		if (!StringUtils.isEmpty(inv.getStats())) {
			if (InOrNotStockEnum.RUKUHUOWU.toString().equals(inv.getStats())) {
				// ????????????
				c.andQuantityNotEqualTo(BigDecimal.ZERO);
			}
			if(InOrNotStockEnum.CHUKUHUOWU.toString().equals(inv.getStats())) {
				c.andQuantityEqualTo(BigDecimal.ZERO);
				InvInventoryExample.Criteria c1 =  example.or();
				c1.andQuantityIsNull();
			}	
		}
		// ??????
		if(!StringUtils.isEmpty(inv.getStorageId())) {
			c.andStorageIdEqualTo(inv.getStorageId());
		}
		// ??????
		if(!StringUtils.isEmpty(inv.getBuyerId())) {
			c.andBuyerIdEqualTo(inv.getBuyerId());
		}
		// ??????
		if (!StringUtils.isEmpty(inv.getSellerId())) {
			c.andSellerIdEqualTo(inv.getSellerId());
		}
		// ??????????????????
		if (inv.getInstockStartDate() != null) {
			c.andInstockDateGreaterThanOrEqualTo(DateUtils.getStartDate(inv.getInstockStartDate()));
		}
		//??????????????????
		if (inv.getInstockEndDate() != null) {
			c.andInstockDateLessThanOrEqualTo(DateUtils.getEndDate(inv.getInstockEndDate()));
		}
		// ??????
		if (!StringUtils.isEmpty(inv.getSurfaceId())) {
			c.andSurfaceIdEqualTo(inv.getSurfaceId());
		}
		// ??????
		if (!StringUtils.isEmpty(inv.getProductId())) {
			c.andProductIdEqualTo(inv.getProductId());
		}
		// ??????
		if (!StringUtils.isEmpty(inv.getMaterialId())) {
			c.andMaterialIdEqualTo(inv.getMaterialId());
		}
		// ??????
		if (!StringUtils.isEmpty(inv.getMnfctId())) {
			c.andMnfctIdEqualTo(inv.getMnfctId());
		}
		// ??????
		if(!StringUtils.isEmpty(inv.getVolume())) {
			if(isAccuracy) {
				c.andVolumeLike("%"+inv.getVolume()+"%");
			}else {
				c.andVolumeEqualTo(inv.getVolume());
			}
		}
		if(!StringUtils.isEmpty(inv.getContractId())) {
			c.andContractIdEqualTo(inv.getContractId());
		}

		
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		return example;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: format
	 * @Description: ( ??????????????????????????? ) 
	 * @param list
	 * @return PageInfo<StockDto>
	 * @throws
	 */
	private List<InvInventoryDto> format(List<InvInventory> list){
		List<InvInventoryDto> dtoList = new ArrayList<InvInventoryDto>();
		for (InvInventory ins : list) {
			InvInventoryDto dto = new InvInventoryDto();
			dto.setInvInventory(ins);

			//  ??????
			// ??????
			BaseProduct baseProduct = null;
			if(!StringUtils.isEmpty(ins.getProductId())) {
				baseProduct = baseService.getBaseProductById(ins.getProductId());
			}
			if (baseProduct != null) {
				String productName = baseProduct.getProductName();
				dto.setProductName(productName);
				dto.setBaseProduct(baseProduct);
			}

			//?????? --??????????????????id?????????row-key
			dto.setId(ins.getInventoryId());
			if(dto.getEnableNum().compareTo(BigDecimal.ZERO) == 1) {
				dtoList.add(dto);				
			}
		}
		return dtoList;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getStockAll
	 * @Description: ( ???????????????????????? ) 
	 * @param stockDto
	 * @param isAccuracy
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public List<InvInventory>  getStockAll(InvInventoryDto stockDto, Boolean isAccuracy) {
		

		if(stockDto !=null){
			InvInventoryExample example =  getExample(stockDto,isAccuracy);
			InvInventoryExample.Criteria c= example.createCriteria();
			// ?????????????????????????????????
			List<InvInventory> list = invInventoryMapper.selectByExample(example);
			return list;
		}
		return new ArrayList<InvInventory>();
		
	}
	
	@Override
	public InvInventory getStockOne(String invInventoryId) {
		if (StringUtils.isEmpty(invInventoryId)){
			return null;
		}
		InvInventory ins = invInventoryMapper.selectByPrimaryKey(invInventoryId);
		return ins;
	}

	/**
	 * 
	 * @author shmily
	 * @Title: addStock 
	 * @Description: ( ????????????  ) 
	 * @param inv
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InvInventoryDto addStock(InvInventoryDto invInventoryDto) {
		if (invInventoryDto == null){
			return null;
		}
		InvInventory inv =invInventoryDto.getInvInventory();
		if (inv == null){
			return null;
		}
		// ??????dto ?????????InvInventory ?????????
		//SELLER_ID
		inv.setSellerId("1");
		inv.setBuyerId("1");
		inv.setBusinessType("1");
		inv.setInstockDate(new Date());
		
		
		
		//  ??????end
		// ??????????????????????????????
		Boolean flag = StringUtils.isEmpty(inv.getBuyerId())&& StringUtils.isEmpty(inv.getSellerId())&&StringUtils.isEmpty(inv.getBusinessType())&& inv.getInstockDate() ==null;
		if (flag){
			return null;
		}
		int a =invInventoryMapper.insertSelective(inv);
		invInventoryDto.setInvInventory(inv);
		return invInventoryDto;
	}
	
	
	/**
	 * 
	 * @author shmily
	 * @Title: updateStock 
	 * @Description: ( ???????????? ) 
	 * @param invInventory
	 * @return InvInventory
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InvInventory updateStock(InvInventory invInventory) {
		Integer  num = invInventoryMapper.updateByPrimaryKeySelective(invInventory);
		return invInventory;
	}
	
	@SuppressWarnings("unused")
	@Override
	public InvInventoryDto updateStock(InvInventoryDto invInventoryDto) {
		if (invInventoryDto == null){
			return null;
		}
		InvInventory invInventory = invInventoryDto.getInvInventory();
		if(invInventory == null){
			return null;
		}
		if(StringUtils.isEmpty(invInventory.getInventoryId())){
			return null;
		}
		
		// --- //
		Integer  num = invInventoryMapper.updateByPrimaryKeySelective(invInventory);
		invInventoryDto.setInvInventory(invInventory);
		return invInventoryDto;
	}
	
	
	
	
	
	@Override
	public Integer deleteStock(String invInventoryId) {
		InvInventory inv = new InvInventory();
		inv.setInventoryId(invInventoryId);
		inv.setIsDel(YesOrNoEnum.YES.toString());
		return invInventoryMapper.updateByPrimaryKeySelective(inv);
	}

	/**
	 * 
	 * @author shmily
	 * @Title: nextUnlockQuantity 
	 * @Description: (??????????????????      // ??????????????????????????? ?????????????????????) 
	 * @param invInventoryId ??????id
	 * @param number 
	 * @return 
	 * @throws
	 */
	@Override
	public Integer nextUnlockQuantity(String invInventoryId, BigDecimal number) {
		
		InvInventory inv = getStockOne(invInventoryId);
		if (inv == null){
			return -1;
		}
//		????????????BigDecimal???compareTo????????????????????????
//		??????????????????int?????????-1???????????????0????????????1????????????
		BigDecimal quantity =inv.getQuantity();
		if (quantity==null){
			return -1;
		}
		// ????????????????????????
		if (quantity.compareTo(number) == -1){
			return -1;
		}
		if(inv.getNextUnlockQuantity() ==null||BigDecimal.ZERO.compareTo(inv.getNextUnlockQuantity()) ==0) {
			inv.setNextUnlockQuantity(BigDecimal.ZERO);
		}
		// ???????????????????????????????????????
		if (quantity.compareTo(number) == 1 ||quantity.compareTo(number) == 0){
			// inv.setQuantity(quantity.subtract(number));
			inv.setNextUnlockQuantity(number.add(inv.getNextUnlockQuantity()));
		}
		updateStock(inv);
		return 1;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: nextOutstockQuantity
	 * @Description: (?????????????????????)
	 * @param invInventoryId
	 * @param number
	 * @return
	 * @throws
	 */
	@Override
	public Integer nextOutstockQuantity(String invInventoryId, BigDecimal number) {
		
		InvInventory inv = getStockOne(invInventoryId);
		if (inv == null){
			return -1;
		}
		BigDecimal nextUnlockQuantity =inv.getNextUnlockQuantity();
		BigDecimal nextOutStockQuantity = inv.getNextOutstockQuantity() == null ? new BigDecimal(0) : inv.getNextOutstockQuantity();
		if (nextUnlockQuantity==null){
			return -1;
		}
		// ??????????????????????????????????????????
		if (nextUnlockQuantity.compareTo(number) == -1){
			return -1;
		}
		// ????????????????????????????????????????????????
		if (nextUnlockQuantity.compareTo(number) == 1 ||nextUnlockQuantity.compareTo(number) == 0){
			//inv.setQuantity(nextUnlockQuantity.subtract(number));
			inv.setNextUnlockQuantity(nextUnlockQuantity.subtract(number));
			inv.setNextOutstockQuantity(nextOutStockQuantity.add(number));
		}
		updateStock(inv);
		return 1;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: outstockQuantity 
	 * @Description: (??????????????????) 
	 * @param invInventoryId
	 * @param number
	 * @return 
	 * @throws
	 */
	@Override
	public Integer outstockQuantity(String invInventoryId, BigDecimal number) {
		
		InvInventory inv = getStockOne(invInventoryId);
		if (inv == null){
			return -1;
		}
		BigDecimal nextOutstockQuantity =inv.getNextOutstockQuantity();
		BigDecimal quantity =inv.getQuantity();
		if ( nextOutstockQuantity == null || quantity == null){
			return -1;
		}
		// ?????????????????????????????????
		if (nextOutstockQuantity.compareTo(number) == -1){
			return -1;
		}else{
			inv.setNextOutstockQuantity(nextOutstockQuantity.subtract(number));
			inv.setQuantity(quantity.subtract(number));
			// ?????????????????????
			if(inv.getQuantity() == null||BigDecimal.ZERO.compareTo(inv.getQuantity()) == 0) {
				inv.setQuantity(BigDecimal.ONE);
			}
			inv.setNetWeight(inv.getNetWeight().subtract(inv.getNetWeight().divide(inv.getQuantity(),3,BigDecimal.ROUND_HALF_EVEN).multiply(number)));				
			// ????????????
			if(inv.getRealUnitPrice() ==null) {
				inv.setRealUnitPrice(BigDecimal.ZERO);
			}
			if(inv.getContractMoney() ==null) {
				inv.setContractMoney(BigDecimal.ZERO);
			}
			inv.setRealMoney(inv.getContractMoney().subtract(inv.getRealUnitPrice().divide(number,3,BigDecimal.ROUND_HALF_EVEN)));
			if(quantity.subtract(number).compareTo(BigDecimal.ZERO) ==0) {
				inv.setQuantity(BigDecimal.ZERO);
			}
		}
//		// ?????????????????????????????????????????????
//		if (nextOutstockQuantity.compareTo(number) == 1|| nextOutstockQuantity.compareTo(number) == 0){
//			
//		}
		updateStock(inv);
		return 1;
	}


	/**
	 * 
	 * @author shmily
	 * @Title: addInInvInventoryList 
	 * @Description: ( ????????????id ??????????????? ) 
	 * @param id
	 * @return 
	 * @throws
	 */
	@Override
	public List<InvInventoryDto> addInInvInventoryList(List<InsInspectionDetail> list,String conId) {
		List<InvInventoryDto> list2 = new ArrayList<InvInventoryDto>();
		for (InsInspectionDetail insInspectionDetail : list) {
			InvInventory inventory = new InvInventory();
			 BeanUtils.copyProperties(insInspectionDetail, inventory);
			 // ??????
			 inventory.setQuantity(insInspectionDetail.getAmount());
			 // ??????
			 inventory.setVolume(insInspectionDetail.getGoodsVolume());
			 inventory.setContractId(conId);
			 inventory.setSourceId(insInspectionDetail.getInspectionDetailId());
			 // ????????????
			 inventory.setCreateDate(new Date());
			 String businessType = insInspectionDetail.getBusinessType();
			 if(BusinessTypeEnum.CAI_GOU_ZI_XIAO.toString().equals(businessType)||BusinessTypeEnum.CANG_DAN_ZHI_YA.toString().equals(businessType)) {
				 inventory.setOwnCargo(YesOrNoEnum.YES.toString());
			 }else if(BusinessTypeEnum.HUO_YA_RONG_ZI.toString().equals(businessType)||BusinessTypeEnum.DING_XIANG_XIAO_SHOU.toString().equals(businessType)) {
				 inventory.setOwnCargo(YesOrNoEnum.NO.toString());
			 }
			int i = invInventoryMapper.insertSelective(inventory);
			if(i==1) {
				//??????????????????
				List<Attach> attachList = gylBaseService.getAttachByIdAndType(insInspectionDetail.getInspectionDetailId(), ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
				for (Attach attach : attachList) {
					Attach attach1 = new Attach();
					attach1.setCrtearUser(attach.getCrtearUser());
					attach1.setFileCategory(attach.getFileCategory());
					attach1.setFileName(attach.getFileName());
					attach1.setFilePath(attach.getFilePath());
					attach1.setIsDel(YesOrNoEnum.NO.toString());
					attach1.setRelationId(inventory.getInventoryId());
					attach1.setCreateTime(new Date());
					gylBaseService.addAttach(attach1);
				}
				InvInventoryDto invInventoryDto =new InvInventoryDto();
				invInventoryDto.setInvInventory(inventory);
				list2.add(invInventoryDto);
			}
		}
		return list2;
	}

	@Override
	public Integer removerQuantity(String invInventoryId, BigDecimal number) {
		InvInventory inv = getStockOne(invInventoryId);
		if (inv == null){
			return -1;
		}
//		????????????BigDecimal???compareTo????????????????????????
//		??????????????????int?????????-1???????????????0????????????1????????????
		BigDecimal nextUnlockQuantity =inv.getNextUnlockQuantity();
		if (nextUnlockQuantity==null){
			return -1;
		}
		// ???????????????????????????????????????
		if (nextUnlockQuantity.compareTo(number) == -1){
			return -1;
		}
		// ?????????????????????????????????????????????
		if (nextUnlockQuantity.compareTo(number) == 1 ||nextUnlockQuantity.compareTo(number) == 0){
			// inv.setQuantity(quantity.subtract(number));
			inv.setNextUnlockQuantity(nextUnlockQuantity.subtract(number));
		}
		updateStock(inv);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<InvCheckInv> getChenkInvAll(PageUtils<InvCheckInvVo> page,Boolean isAccuracy) {
		if(page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		InvCheckInvVo dto = page.getDto();
		InvCheckInvExample example = getExample(dto,isAccuracy);
		List<InvCheckInv> list= invCheckInvMapper.selectByExample(example);
		PageInfo<InvCheckInv> pageInv = new PageInfo<>(list);
		return pageInv; 
	}

	/**
	 * ???????????????????????????????????????
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<FeeBalance> getBalanceAll(PageUtils<FeeBalanceVo> page,Boolean isAccuracy) {
		if(page == null) {
			return null;
		}
		setPageAndOrderBy(page);
		FeeBalanceVo dto = page.getDto();
		FeeBalanceExample example = getExample(dto,isAccuracy);
		List<FeeBalance> list= feeBalanceMapper.selectByExample(example);
		PageInfo<FeeBalance> pageFee = new PageInfo<>(list);
		return pageFee; 
	}
	
	/**
	 * ??????????????????
	 * @param 
	 * @return
	 */
	private InvCheckInvExample getExample(InvCheckInvVo inv,Boolean isAccuracy) {
		InvCheckInvExample example = new InvCheckInvExample();
		if (inv != null) {
			InvCheckInvExample.Criteria criteria = example.createCriteria();
			if(!StringUtils.isEmpty(inv.getStorageId())) {
				criteria.andStorageIdEqualTo(inv.getStorageId());
			}
			if (!StringUtils.isEmpty(inv.getCreateUser())) {
				if (isAccuracy) {
					criteria.andCreateUserEqualTo(inv.getCreateUser());
				} else {
					criteria.andCreateUserLike("%" + inv.getCreateUser() + "%");
				}
			}
			if (inv.getStartCreateDate() != null) {
				criteria.andCreateDateGreaterThanOrEqualTo(DateUtils.getStartDate(inv.getStartCreateDate()));
			}
			if (inv.getEndCreateDate() != null) {
				criteria.andCreateDateLessThanOrEqualTo(DateUtils.getEndDate(inv.getEndCreateDate()));
			}
			criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		}
		// ????????????
		return example;

	}
	
	/**
	 * ??????????????????
	 * @param 
	 * @return
	 */
	private FeeBalanceExample getExample(FeeBalanceVo fee,Boolean isAccuracy) {
		FeeBalanceExample example = new FeeBalanceExample();
		if (fee != null) {
			FeeBalanceExample.Criteria criteria = example.createCriteria();
			if(!StringUtils.isEmpty(fee.getMakerId())) {
				criteria.andMakerIdEqualTo(fee.getMakerId());
			}
			if(!StringUtils.isEmpty(fee.getCustomerId())) {
				criteria.andCustomerIdEqualTo(fee.getCustomerId());
			}
			if (!StringUtils.isEmpty(fee.getCreateUser())) {
				if (isAccuracy) {
					criteria.andCreateUserEqualTo(fee.getCreateUser());
				} else {
					criteria.andCreateUserLike("%" + fee.getCreateUser() + "%");
				}
			}
			if (fee.getStartCreateDate() != null && fee.getEndCreateDate() != null) {
				criteria.andCreateDateBetween(DateUtils.getStartDate(fee.getStartCreateDate()), DateUtils.getEndDate(fee.getEndCreateDate()));
			} else if (fee.getStartCreateDate() != null) {
				criteria.andCreateDateGreaterThanOrEqualTo(DateUtils.getStartDate(fee.getStartCreateDate()));
			} else if (fee.getEndCreateDate() != null) {
				criteria.andCreateDateLessThanOrEqualTo(DateUtils.getEndDate(fee.getEndCreateDate()));
			}
			criteria.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		}
		// ????????????
		
		return example;

	}
	
	public List<InvInventory> getInvsByStorageId(String storageId) {
		if (StringUtils.isEmpty(storageId)){
			return null;
		}
		InvInventoryExample example = new InvInventoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andStorageIdEqualTo(storageId);
		criteria.andQuantityGreaterThan(new BigDecimal(0));
		List<InvInventory> ins = invInventoryMapper.selectByExample(example);
		return ins;
	}
	
	@Override
	public PageInfo<InvInventory> getInvsByStorageId(PageUtils<InvInventory> page) {
		
		if (page == null || page.getDto() == null || StringUtils.isEmpty(page.getDto().getStorageId())){
			return null;
		}
		setPageAndOrderBy(page);
		InvInventoryExample example = new InvInventoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andStorageIdEqualTo(page.getDto().getStorageId());
		criteria.andQuantityGreaterThan(new BigDecimal(0));
		List<InvInventory> ins = invInventoryMapper.selectByExample(example);
		return new PageInfo<>(ins);
	}

	
	@Override
	public InvCheckInv addCheckInv(InvCheckInvVo invCheckInvVo) {
		if (invCheckInvVo == null){
			return null;
		}
		String storageId = invCheckInvVo.getStorageId();
		InvCheckInv inv = new InvCheckInv();
		inv.setCreateDate(new Date());
		inv.setStorageId(storageId);
		inv.setCreateUser(invCheckInvVo.getCreateUser());
		
		int a =invCheckInvMapper.insertSelective(inv);
		return inv;
	}
	
	@Override
	public InvCheckInvDetail addCheckInvDetail(InvCheckInvDetail invCheckInvDetail) {
		if (invCheckInvDetail == null){
			return null;
		}
		int a =invCheckInvDetailMapper.insertSelective(invCheckInvDetail);
		return invCheckInvDetail;
	}
	// ??????????????????
	@Override
	public List<InvCheckInvDetail> selectCheckDetail(String invInventoryId) {
		if(StringUtils.isEmpty(invInventoryId)) {
			return new ArrayList<InvCheckInvDetail>();
		}
		InvCheckInvDetailExample example = new InvCheckInvDetailExample();
		InvCheckInvDetailExample.Criteria c = example.createCriteria();
		c.andInventoryIdEqualTo(invInventoryId);
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		example.setOrderByClause("CREATE_DATE desc");
		return invCheckInvDetailMapper.selectByExample(example);
	}
	/* 
	 * ??????id??????????????????
	 */
	@Override
	public List<FeeBalanceDetail> getBalanceDetailById(String id) {
		FeeBalanceDetailExample example = new FeeBalanceDetailExample();
		FeeBalanceDetailExample.Criteria criteria = example.createCriteria();
		criteria.andBalanceIdEqualTo(id);
		List<FeeBalanceDetail> detailList = feeBalanceDetailMapper.selectByExample(example);
		return detailList;
	}
	
	/* 
	 * ????????????id??????????????????
	 */
	@Override
	public FeeBalanceDetail getBalanceDetailByDetailId(String id) {
		FeeBalanceDetail detail = feeBalanceDetailMapper.selectByPrimaryKey(id);
		return detail;
	}

	/* 
	 * ?????????????????????
	 */
	@Override
	public FeeBalance saveOrUpdateFeeBalance(String contractId, BigDecimal purchaseAmount, String createUser) {
		//??????????????????
		if (StringUtils.isEmpty(contractId) || StringUtils.isEmpty(purchaseAmount)) {
			return null;
		}
		//???????????????????????????????????????
		ConContractVo vo = conContractExtMapper.selectByPrimaryKey(contractId);
		if (vo == null){
			return null;
		}
		String makerId = vo.getMallMnfct();
		//??????????????????????????????
		if (StringUtils.isEmpty(makerId)){
			return null;
		}
		String customerId = vo.getBuyerId();
		//??????FeeBalance????????????????????????????????????????????????
		FeeBalanceExample example = new FeeBalanceExample();
		FeeBalanceExample.Criteria criteria = example.createCriteria();
		criteria.andMakerIdEqualTo(makerId);
		criteria.andCustomerIdEqualTo(customerId);
		List<FeeBalance> list = feeBalanceMapper.selectByExample(example);
		int row;
		if (list.size()<1) {
			//??????????????????????????????purchaseAmount
			FeeBalance fee = new FeeBalance();
			fee.setCreateDate(new Date());
			//fee.setCreateUser(createUser);
			fee.setMakerId(makerId);
			fee.setCustomerId(customerId);
			fee.setResidualAmount(purchaseAmount);
			row = feeBalanceMapper.insertSelective(fee);
		} else {
			//???????????????????????????
			FeeBalance fee = new FeeBalance();
			fee.setBalanceId(list.get(0).getBalanceId());
			fee.setResidualAmount(list.get(0).getResidualAmount().add(purchaseAmount));
			row = feeBalanceMapper.updateByPrimaryKeySelective(fee);
		}
		//????????????????????????
		if(row > 0) {
			FeeBalanceDetail feeDetail = new FeeBalanceDetail();
			feeDetail.setContractId(contractId);
			feeDetail.setPurchaseAmount(purchaseAmount);
			//????????????????????????
			if (list.size()<1) {
				List<FeeBalance> listNow = feeBalanceMapper.selectByExample(example);
				feeDetail.setBalanceId(listNow.get(0).getBalanceId());
				feeDetail.setResidualAmount(purchaseAmount);
			} else {
				feeDetail.setBalanceId(list.get(0).getBalanceId());
				feeDetail.setResidualAmount(list.get(0).getResidualAmount().add(purchaseAmount));
			}
			feeDetail.setCreateDate(new Date());
			//feeDetail.setCreateUser(createUser);
			int rowDetail = feeBalanceDetailMapper.insertSelective(feeDetail);
		}
		return null;
	}
	
	/* 
	 * ????????????????????????
	 */
	@Override
	public FeeBalanceDetail updateFeeBalanceDetailState(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		//?????????????????????
		FeeBalanceDetail feeBalanceDetail = feeBalanceDetailMapper.selectByPrimaryKey(id);
		//????????????
		FeeBalanceDetail balanceDetail = new FeeBalanceDetail();
		balanceDetail.setBalanceDetailId(id);
		String state = feeBalanceDetail.getBalanceState();
		if(state.equals("A")) {
			balanceDetail.setBalanceState(BalanceTypeEnum.IN_REFUND.toString());
		}else {
			balanceDetail.setBalanceState(BalanceTypeEnum.END_REFUND.toString());
			//????????????(??????????????????????????????????????????????????????)
			//????????????
			FeeBalance feeBalance = feeBalanceMapper.selectByPrimaryKey(feeBalanceDetail.getBalanceId());
			//????????????
			FeeBalance fee = new FeeBalance();
			fee.setBalanceId(feeBalance.getBalanceId());
			fee.setResidualAmount(feeBalance.getResidualAmount().subtract(feeBalanceDetail.getPurchaseAmount()));
			feeBalanceMapper.updateByPrimaryKeySelective(fee);
		}
		int row = feeBalanceDetailMapper.updateByPrimaryKeySelective(balanceDetail);
		return row == 0 ? null : balanceDetail;
	}

	
	
	
}
