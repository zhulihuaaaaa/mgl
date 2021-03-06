package com.maigangle.gyl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.BaseProcess;
import com.maigangle.gyl.facade.entity.BaseProduct;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.InInstockBill;
import com.maigangle.gyl.facade.entity.InsInspectionBill;
import com.maigangle.gyl.facade.entity.InsInspectionBillExample;
import com.maigangle.gyl.facade.entity.InsInspectionDetail;
import com.maigangle.gyl.facade.entity.InsInspectionDetailExample;
import com.maigangle.gyl.facade.entity.InsInspectionSub;
import com.maigangle.gyl.facade.entity.InsInspectionSubExample;
import com.maigangle.gyl.facade.entity.dto.InStockBillDto;
import com.maigangle.gyl.facade.entity.dto.InsInspectionBillDto;
import com.maigangle.gyl.facade.entity.dto.InvInventoryDto;
import com.maigangle.gyl.facade.entity.vo.InsInspectionBillVo;
import com.maigangle.gyl.facade.enums.ApprovalStateEnum;
import com.maigangle.gyl.facade.enums.BusinessTypeEnum;
import com.maigangle.gyl.facade.enums.ImageFileTypeEnum;
import com.maigangle.gyl.facade.enums.InspectionTypeEnum;
import com.maigangle.gyl.facade.enums.YesOrNoEnum;
import com.maigangle.gyl.facade.service.ContractService;
import com.maigangle.gyl.facade.service.FinanceService;
import com.maigangle.gyl.facade.service.FlowService;
import com.maigangle.gyl.facade.service.GylBaseService;
import com.maigangle.gyl.facade.service.InsInspectionBillService;
import com.maigangle.gyl.facade.service.InstockBillService;
import com.maigangle.gyl.facade.service.InvInventoryService;
import com.maigangle.gyl.facade.utils.DateUtils;
import com.maigangle.gyl.facade.utils.PageUtils;
import com.maigangle.gyl.service.mapper.GylBaseMapper;
import com.maigangle.gyl.service.mapper.InsInspectionBillMapper;
import com.maigangle.gyl.service.mapper.InsInspectionDetailMapper;
import com.maigangle.gyl.service.mapper.InsInspectionSubMapper;
import com.maigangle.gyl.service.mapper.ext.InsInspectionDetailExtMapper;

/**
 * ?????????????????????
 * @author ?????????
 * @since  2017???11???29??? - ??????3:23:15
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
@Service
@Transactional
public class InsInspectionBillServiceImpl extends GylServiceImpl implements InsInspectionBillService{
	@Autowired
	private InsInspectionBillMapper insInspectionBillMapper;
	@Autowired
	private InsInspectionSubMapper insInspectionSubMapper;
	@Autowired
	private InsInspectionDetailMapper insInspectionDetailMapper;
	@Autowired
	private InvInventoryService invInventoryService;
	@SuppressWarnings("unused")
	@Autowired
	private GylBaseMapper gylBaseMapper;
	@Autowired
	private GylBaseService gylBaseService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private InstockBillService instockBillService;
	@Autowired
	private FlowService flowService;
	
	
	/*************************??????*************************/
	
	@Override
	public  List<InsInspectionBillDto> getInsInspectionDetail(String inStockId) {
		if (StringUtils.isEmpty(inStockId)) {
			return null;
		}
		InsInspectionBillExample example = new InsInspectionBillExample();
		InsInspectionBillExample.Criteria c=example.createCriteria();
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		c.andInstockIdEqualTo(inStockId);
		List<InsInspectionBill> list =insInspectionBillMapper.selectByExample(example);
		if (list==null|| list.isEmpty()) {
			return null;
		}
		List<InsInspectionSub> sublist = getInsInspectionSubAll(list.get(0).getInspectionBillId());
		if (sublist ==null || sublist.isEmpty()) {
			return null;
		}
		 List<InsInspectionDetail> allList = new ArrayList<InsInspectionDetail>();
		for (InsInspectionSub insInspectionSub : sublist) {
			if(ApprovalStateEnum.APPROVAL_COMPLETE.toString().equals(insInspectionSub.getAuditStatus())) {
				List<InsInspectionDetail> dtoList = getInsInspectionDetailBySubId(insInspectionSub.getInspectionSubId());
				if(dtoList!=null) {
					 allList.addAll(dtoList);
				}
			}			 
		}
		return formatDetailToDto(allList);
	}
	/****************************end*******************/
	/*********************************?????????????????????**************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionSubAllById 
	 * @Description: ( ?????????????????????????????????????????????id ) 
	 * @param insInspectionBillId
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionSub> getInsInspectionSubAllById(String insInspectionBillId) {
		List<InsInspectionSub> list = getInsInspectionSubAll(insInspectionBillId);
		return list;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionDetailById 
	 * @Description: ( ??????????????????????????????????????????????????????????????? ) 
	 * @param insInspectionBillId
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionDetail> getInsInspectionDetailById(String insInspectionBillId) {
		List<InsInspectionDetail> list =getInsInspectionDetailByPass(insInspectionBillId);
		return list;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: formatDetailToDto 
	 * @Description: ( ???????????? ) 
	 * @param list
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	private List<InsInspectionBillDto> formatDetailToDto(List<InsInspectionDetail> list){
		List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		if (list ==null||list.isEmpty()) {
			return null;
		}
		for (InsInspectionDetail insInspectionDetail : list) {
			InsInspectionBillDto dto = new InsInspectionBillDto();
			dto.setInsInspectionDetail(insInspectionDetail);
			//?????????DTO
			 //????????????
			List<Attach> attach = gylBaseService.getAttachByIdAndType(insInspectionDetail.getInspectionDetailId(), ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
			if (attach !=null) {
				dto.setSphotosGoodsList(attach);
			}
			// ??????
			BaseProduct baseProduct = baseService.getBaseProductById(insInspectionDetail.getProductId());
			if (baseProduct != null) {
				String productName = baseProduct.getProductName();
				dto.setProductName(productName);
				dto.setBaseProduct(baseProduct);
			}
			//??????
			//  ??????
			BaseProcess baseProcess = baseService.getBaseProcess(insInspectionDetail.getSurfaceId());
			if (baseProcess !=null) {
				dto.setSurfaceName(baseProcess.getProcessName());
			}

			dtoList.add(dto);
		}	
		return dtoList;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionDetailBySubId 
	 * @Description: ( ???????????????????????????????????? ) 
	 * @param insInspectionBillSubId
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionDetail> getInsInspectionDetailBySubId(String insInspectionBillSubId) {
		 List<InsInspectionDetail> list = getInsInspectionDetailAll(insInspectionBillSubId);
		 return list;
	}
	
	
	
	
	/**
	 * 
	 * @author shmily
	 * @Title: addInsInspectionDetailAndInsInspectionSub
	 * @Description: ( ????????????????????????????????? )
	 * @param insInspectionBillDto
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InsInspectionBillDto addInsInspectionDetailAndInsInspectionSub(InsInspectionBillDto insInspectionBillDto) {	
		InsInspectionSub insInspectionSub = insInspectionBillDto.getInsInspectionSub();
		List<InsInspectionBillVo> list = insInspectionBillDto.getInsInspectionBillVoList();
		Integer num = -1;
		InsInspectionSub sub =null;
		if (insInspectionSub != null) {
			// ???????????????
			insInspectionSub.setCreateUser(insInspectionBillDto.getCreateUser());
			sub = addInsInspectionSub(insInspectionSub);
		}
		if (sub != null){
			// ??????????????????
			updateStats(insInspectionSub.getInspectionId(),InspectionTypeEnum.YAN_HUO_ZHONG.getType(),0);
			// ?????????????????????	
			 List<Attach> inventoryVoucherList = insInspectionBillDto.getInventoryVoucherList();
			 if(inventoryVoucherList!=null&&!inventoryVoucherList.isEmpty()) {
				 for (Attach attach : inventoryVoucherList) {
					 if(attach!=null) {
						 attach.setFileCategory(ImageFileTypeEnum.ZHI_BAO_SHU.toString());
						 attach.setRelationId(sub.getInspectionSubId());
						// gylBaseService.updateAttach(attach);
						 gylBaseService.addAttach(attach);
					 }
					 
				 }
			 }
			
			// ????????????????????????
			 List<Attach> warrantyList = insInspectionBillDto.getWarrantyList();
			 if(warrantyList!=null&&!warrantyList.isEmpty()) {
				 for (Attach attach : warrantyList) {
					 if(attach !=null) {
						 attach.setFileCategory(ImageFileTypeEnum.CUN_HUO_PING_ZHENG.toString());
						 attach.setRelationId(sub.getInspectionSubId());
						 //gylBaseService.updateAttach(attach);
						 gylBaseService.addAttach(attach);
					 }
				}
			 }
		} else {
			return null;
		}
		List<InsInspectionBillVo> Volist = new ArrayList<InsInspectionBillVo>();
		if (list != null && list.size() != 0) {
			for (InsInspectionBillVo vo : list) {
				InsInspectionDetail insInspectionDetail = vo.getInsInspectionDetail();
				//  ?????????????????? ??????
				if(StringUtils.isEmpty(insInspectionDetail.getSellerId())|| StringUtils.isEmpty(insInspectionDetail.getBuyerId())|| StringUtils.isEmpty(insInspectionDetail.getBusinessType())|| insInspectionDetail.getInstockDate()==null){
					return null;
				}
				insInspectionDetail.setInspectionSubId(sub.getInspectionSubId());
				insInspectionDetail.setIsDel(YesOrNoEnum.NO.toString());
				int a = insInspectionDetailMapper.insertSelective(insInspectionDetail);
				if (a == 1) {
					List<Attach> sphotosGoodsList = vo.getSphotosGoodsList();
					for (Attach attach : sphotosGoodsList) {
					 attach.setFileCategory(ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
					 attach.setRelationId(insInspectionDetail.getInspectionDetailId());
					 //gylBaseService.updateAttach(attach);
					 gylBaseService.addAttach(attach);
					}
				}
			}
//			num = insInspectionDetailExtMapper.BathList(list);
//			list = bathAddInspectionDetail(list);
		}
		// ???????????????????????????
		insInspectionBillDto.setInsInspectionSub(sub);
//		insInspectionBillDto.setInsInspectionDetailList(list);
		insInspectionBillDto.setInsInspectionBillVoList(Volist);
		//insInspectionBillDto.setInsInspectionDetailList(getInsInspectionDetailAll(sub.getInspectionSubId()));
		return insInspectionBillDto;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionSubByfinancial 
	 * @Description: (?????????????????? ) 
	 * @param page
	 * @param isAccuracy
	 * @return List<InsInspectionBillDto>
	 * @throws
	 */
	@Override
	public PageInfo<InsInspectionSub> getInsInspectionSub(PageUtils<InsInspectionBillDto> page,
			Boolean isAccuracy) {
		if (page == null || isAccuracy == null){
			return  new PageInfo<InsInspectionSub>();
		}
		// ???????????? 
		
		InsInspectionBillDto insInspectionBillDto = page.getDto();
		List<InsInspectionSub> list =insInspectionSubMapper.selectByExample(getSubForExample(insInspectionBillDto,isAccuracy,page));
		PageInfo<InsInspectionSub> subpage = new PageInfo<InsInspectionSub>(list);
		
		return subpage;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getSubForExample 
	 * @Description: ( ????????????????????????????????? ) 
	 * @return InsInspectionSubExample
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private InsInspectionSubExample getSubForExample(InsInspectionBillDto insInspectionBillDto,Boolean isAccuracy,PageUtils<InsInspectionBillDto> page) {
		InsInspectionSubExample example = new InsInspectionSubExample();
		InsInspectionSubExample.Criteria c = example.createCriteria();
		if(insInspectionBillDto == null) {
			return null;
		}
		List<String> typeList = insInspectionBillDto.getTypeList();
		// ???????????????????????????
		if(typeList != null&& !typeList.isEmpty()) {
			c.andBusinessTypeIn(typeList);
		}
		// ????????????  ????????????
		String type = insInspectionBillDto.getBusinessType();
		if (!StringUtils.isEmpty(type)) {
			c.andBusinessTypeEqualTo(type);
		}
		// ????????????
		String subCode = insInspectionBillDto.getSubCode();
		if(!StringUtils.isEmpty(subCode)) {
			// ??????????????????
			if (isAccuracy) {
				c.andSubCodeLike("%"+subCode+"%");
			}else {
				c.andSubCodeEqualTo(subCode);
			}
		}
		// ??????
		String volume = insInspectionBillDto.getVolume();
		if(!StringUtils.isEmpty(volume)) {
			volume = volume.toLowerCase();
			InsInspectionDetailExample example2 = new InsInspectionDetailExample();
			InsInspectionDetailExample.Criteria c1  = example2.createCriteria();
			// ??????????????????
			if (isAccuracy) {
				c1.andGoodsVolumeLike("%"+volume+"%");
			}else {
				c1.andGoodsVolumeEqualTo(volume);
			}
			List<InsInspectionDetail> list = insInspectionDetailMapper.selectByExample(example2);
			List<String> strList = new ArrayList<String>();
			for (InsInspectionDetail insInspectionDetail : list) {
				strList.add(insInspectionDetail.getInspectionSubId());
			}
			if(strList!=null &&!strList.isEmpty()) {
				c.andInspectionSubIdIn(strList);				
			}else {
				// ??????????????????????????????id  ??????id??????  
				c.andInspectionSubIdEqualTo("");
			}
		}
		// ???????????????
		String creatUser = insInspectionBillDto.getCreateUser();
		if(!StringUtil.isEmpty(creatUser)) {
			// ??????????????????
			if (isAccuracy) {
				c.andCreateUserLike("%"+creatUser+"%");
			}else {
				c.andCreateUserEqualTo(creatUser);
			}
		}
		// ??????????????????
		if (insInspectionBillDto.getMinDate() != null) {
			c.andCreateDateGreaterThanOrEqualTo(DateUtils.getStartDate(insInspectionBillDto.getMinDate()));
		}
		if (insInspectionBillDto.getMaxDate()!= null) {
			c.andCreateDateLessThanOrEqualTo(DateUtils.getEndDate(insInspectionBillDto.getMaxDate()));
		}
		// ?????????????????????
		 if(insInspectionBillDto.getAuditStatusList() !=null) {
			 c.andAuditStatusIn(insInspectionBillDto.getAuditStatusList());
		 }
		 //??????
		 if(!StringUtils.isEmpty(insInspectionBillDto.getContractId())) {
			 InsInspectionBillExample example2 = new InsInspectionBillExample();
			 InsInspectionBillExample.Criteria c3 =  example2.createCriteria();
			 c3.andContractIdEqualTo(insInspectionBillDto.getContractId());
			 c3.andIsDelEqualTo(YesOrNoEnum.NO.toString());
			List<InsInspectionBill> billList =  insInspectionBillMapper.selectByExample(example2);
			List<String> billStr = new ArrayList<>();
			for (InsInspectionBill insInspectionBill : billList) {
				billStr.add(insInspectionBill.getInspectionBillId());
			}
//			c.andInspectionIdIn(billStr);
			
			if(billStr!=null&&!billStr.isEmpty()) {
				c.andInspectionIdIn(billStr);				
			}else {
				// ??????????????????????????????id ????????????????????????????????????
				billStr.add("1");
				c.andInspectionIdIn(billStr);
			}
		 }
		 
		 if(page !=null) {
			 setPageAndOrderBy(page);			 
		 }
		// ?????????????????????????????????
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		return example;
	}
	
	
	/**
	 * 
	 * @author shmily
	 * @Title: bathAddInspectionDetail 
	 * @Description: ( ????????????????????????  ) 
	 * @param list
	 * @return
	 * @throws
	 */
	@Override
	public List<InsInspectionBillVo> bathAddInspectionDetail(List<InsInspectionBillVo> list) {
		// ????????????????????????????????????id ?????????????????????
		for (InsInspectionBillVo insInspectionBillVo : list) {
			// ?????????????????? 
			InsInspectionDetail ins = addInsInspectionDetail(insInspectionBillVo.getInsInspectionDetail());
			if (ins ==null) {
				return null;
			}
			// ????????????id
			List<Attach> sphotosGoodsList = insInspectionBillVo.getSphotosGoodsList();
			if(sphotosGoodsList!=null&&!sphotosGoodsList.isEmpty()) {
				for (Attach attach : sphotosGoodsList) {
					 attach.setFileCategory(ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
					 attach.setRelationId(ins.getInspectionDetailId());
					// gylBaseService.updateAttach(attach);	
					 gylBaseService.addAttach(attach);
				}
			}
			
		}
		return list;
	}
	@Override
	public List<InsInspectionBillVo> bathUpdateInspectionDetail(List<InsInspectionBillVo> list) {
		// ?????????????????? ?????????????????????
		for (InsInspectionBillVo insInspectionBillVo : list) {
			// ?????????????????? 
			InsInspectionBillDto insDto = new InsInspectionBillDto();
			 InsInspectionDetail ins = insInspectionBillVo.getInsInspectionDetail();
			 insDto.setInsInspectionDetail(ins);
			 insDto = updateInsInspectionDetail(insDto);
	
			if (insDto ==null) {
				return null;
			}
			// ????????????id  ---- ????????????
			List<Attach> sphotosGoodsList = insInspectionBillVo.getSphotosGoodsList();
			if(sphotosGoodsList!=null&&!sphotosGoodsList.isEmpty()) {
				for (Attach attach : sphotosGoodsList) {
					 attach.setFileCategory(ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
					 attach.setRelationId(ins.getInspectionDetailId());
					 //gylBaseService.updateAttach(attach);	
					 gylBaseService.addAttach(attach);
				}
			}
			
		}
		return list;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: bathUpdateAndAddAndDelInspectionDetail 
	 * @Description: ( ?????????????????? ??????  ) 
	 * @param list
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionBillVo> bathUpdateAndAddAndDelInspectionDetail(List<InsInspectionBillVo> list) {
		List<InsInspectionBillVo> voList = new ArrayList<InsInspectionBillVo>();
		// ?????????????????? ?????????????????????
		for (InsInspectionBillVo insInspectionBillVo : list) {
			InsInspectionBillVo vo = new InsInspectionBillVo();
			String isUpdateOrAddOrDel = insInspectionBillVo.getIsUpdateOrAddOrDel();
			InsInspectionDetail insInspectionDetail = insInspectionBillVo.getInsInspectionDetail();
			//  ??????: 1 ??????:2 ??????:3 
			if("1".equals(isUpdateOrAddOrDel)) {
				// ?????????????????? 
				InsInspectionBillDto insDto = new InsInspectionBillDto();
				 InsInspectionDetail ins = insInspectionBillVo.getInsInspectionDetail();
				 insDto.setInsInspectionDetail(ins);
				 insDto = updateInsInspectionDetail(insDto);
				 
				 
				// ????????????id  ---- ????????????
				List<Attach> sphotosGoodsList = insInspectionBillVo.getSphotosGoodsList();
				if(sphotosGoodsList!=null&&!sphotosGoodsList.isEmpty()) {
					for (Attach attach : sphotosGoodsList) {
						if(StringUtils.isEmpty(attach.getRelationId())) {
							attach.setFileCategory(ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
							 attach.setRelationId(ins.getInspectionDetailId());
							 gylBaseService.addAttach(attach);
						}
					}
				}
				vo.setInsInspectionDetail(insDto.getInsInspectionDetail());
				vo.setSphotosGoodsList(sphotosGoodsList);
				// ??????
			}else if("2".equals(isUpdateOrAddOrDel)) {
				// ??????
				deleteInsInspectionDetail(insInspectionDetail.getInspectionDetailId());
				
			}else if("3".equals(isUpdateOrAddOrDel)) {
				// ?????????????????? 
				InsInspectionDetail ins = addInsInspectionDetail(insInspectionBillVo.getInsInspectionDetail());
				if (ins ==null) {
					return null;
				}
				// ????????????id
				List<Attach> sphotosGoodsList = insInspectionBillVo.getSphotosGoodsList();
				if(sphotosGoodsList!=null&&!sphotosGoodsList.isEmpty()) {
					for (Attach attach : sphotosGoodsList) {
						 attach.setFileCategory(ImageFileTypeEnum.HUO_WU_ZHAO_PIAN.toString());
						 attach.setRelationId(ins.getInspectionDetailId());
						// gylBaseService.updateAttach(attach);	
						 gylBaseService.addAttach(attach);
					}
				}
				vo.setInsInspectionDetail(ins);
				vo.setSphotosGoodsList(sphotosGoodsList);
			}
			voList.add(vo);
		}
		return voList;
	}
	
	
	
	/**
	 * 
	 * @author shmily
	 * @Title: bathUpdateInspectionDetailPrice 
	 * @Description: ( ?????????????????? ) 
	 * @param list
	 * @return 
	 * @throws
	 */
	@Override
	public Integer bathUpdateInspectionDetailPrice(InsInspectionBillVo insInspectionBillVo) {
		//return insInspectionDetailExtMapper.BathUpdate(insInspectionBillVo.getInsInspectionDetailList());
		List<InsInspectionDetail> list = insInspectionBillVo.getInsInspectionDetailList(); 
		for (InsInspectionDetail insInspectionDetail : list) {
			//InsInspectionDetail ins = new InsInspectionDetail();
			//ins.setRealMoney(insInspectionDetail.getRealMoney());
			//ins.setRealUnitPrice(insInspectionDetail.getRealUnitPrice());
			//ins.setInspectionDetailId(insInspectionDetail.getInspectionDetailId());
			int i =insInspectionDetailMapper.updateByPrimaryKeySelective(insInspectionDetail);
			if (i == 0) {
				return null;
			}
		}
		InsInspectionBillDto settlementDto = new InsInspectionBillDto();
		settlementDto.setBusinessType(insInspectionBillVo.getBusinessType());
		settlementDto.setContractId(insInspectionBillVo.getContractId());
		settlementDto.setId(insInspectionBillVo.getId());
		settlementDto.setAuditStatus(insInspectionBillVo.getAuditStatus());
		settlementDto.setInsInspectionBillId(insInspectionBillVo.getInsInspectionBillId());
		settlementDto.setInstockId(insInspectionBillVo.getInstockId());
		
		int i =updateFinancialPassOrNotpass(settlementDto);
		if (i == 0) {
			return null;
		}else if(i==1) {
			// ???????????????????????? updateStats
			if((BusinessTypeEnum.HUO_YA_RONG_ZI.getType().equals(settlementDto.getBusinessType())||BusinessTypeEnum.CANG_DAN_ZHI_YA.getType().equals(settlementDto.getBusinessType()))&&ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(settlementDto.getAuditStatus())) {
				updateStats(settlementDto.getInsInspectionBillId(),InspectionTypeEnum.YI_YAN_HUO.toString(), 0);
				InInstockBill dto = instockBillService.getInstockBillById(settlementDto.getInstockId()).getBill();
				dto.setInspectionStatus(InspectionTypeEnum.YI_YAN_HUO.toString());
				instockBillService.updateInstockBill(dto);
			}
		}
		return 1;
	}

	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionSubAll 
	 * @Description: ( ???????????? ) 
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionSub> getInsInspectionSubAllBySubCode(String subCode) {
		//  Auto-generated method stub
		InsInspectionBillDto dto = new InsInspectionBillDto();
		dto.setSubCode(subCode);
		InsInspectionSubExample example = getSubForExample(dto,true,null);
		List<InsInspectionSub> list = insInspectionSubMapper.selectByExample(example);
		return list;
	}
	
	
	
	
	
	
	/********************************end*************************************/
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionBillAll 
	 * @Description: ( ???????????????????????? ???????????? ) 
	 * @param page
	 * @return
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<InsInspectionBill> getInsInspectionBillAll(PageUtils<InsInspectionBillDto> page,Boolean isAccuracy) {
		if (page == null || isAccuracy == null){
			return new PageInfo<InsInspectionBill>(null);
		}
		// ???????????? 
		setPageAndOrderBy(page);
		InsInspectionBillDto insInspectionBillDto = page.getDto();
        List<InsInspectionBill> list =  insInspectionBillMapper.selectByExample(example(insInspectionBillDto,isAccuracy));
		PageInfo<InsInspectionBill> pageBill = new PageInfo<InsInspectionBill>(list);
        return pageBill;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: format 
	 * @Description: ( ?????????????????? ) 
	 * @param list
	 * @return List<insInspectionBillDto>
	 * @throws
	 */
	 @SuppressWarnings("unused")
	private List<InsInspectionBillDto> format(List<InsInspectionBill> list){
		 List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		 for (InsInspectionBill ins : list) {
			 if (ins == null) {
				 return null;
			 }
			InsInspectionBillDto s = new InsInspectionBillDto();
			s.setInsInspectionBill(ins);
			//  ????????? 
			
			
			
			//  ????????????
			if (!StringUtils.isEmpty(ins.getInstockId())) {
				InStockBillDto ininstock = instockBillService.getInstockBillById(ins.getInstockId());
				if (ininstock !=null&&ininstock.getBill()!=null ) {
					String instockNo = ininstock.getInstockCode();
					s.setInstockNo(ininstock.getBill().getInstockCode());
				}
			}
			//  ????????????
			if (!StringUtils.isEmpty(ins.getContractId())) {
				ConContract con = contractService.getConContractById(ins.getContractId());
				if (con !=null) {
					String contractNo =con.getContractNo();
					s.setConContract(con);
					s.setContractNo(contractNo);
				}
			}
			dtoList.add(s);
		}
		 return dtoList;
	 }
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionBillAll
	 * @Description: ( ????????????????????????  ?????????????????? ?????? )
	 * @param insInspectionBillDto
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionBillDto> getInsInspectionBillAll(InsInspectionBillDto insInspectionBillDto) {
		List<InsInspectionBill> list = insInspectionBillMapper.selectByExample(example(insInspectionBillDto,true));
		return format(list);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: example 
	 * @Description: ( ?????????????????? ) 
	 * @param insInspectionBillDto
	 * @param isAccuracy
	 * @return InsInspectionBillExample
	 * @throws
	 */
	private InsInspectionBillExample example(InsInspectionBillDto dto,Boolean isAccuracy){
		InsInspectionBillExample example = new InsInspectionBillExample();
		InsInspectionBillExample.Criteria c = example.createCriteria();
		if (dto == null) {
			c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
			return example;
		}
			//  ??????  ???????????????
//			if (!StringUtils.isEmpty(insInspectionBillDto.getContractNo()) || !StringUtils.isEmpty(insInspectionBillDto.getBusinessType())) {
//				ConContractDto dto =new ConContractDto();
//				//  
//				if(!StringUtils.isEmpty(insInspectionBillDto.getBusinessType())){
//					dto.setContractType(insInspectionBillDto.getBusinessType());
//				}
//				if(!StringUtils.isEmpty(insInspectionBillDto.getContractNo())){
//					dto.setContractNo(insInspectionBillDto.getContractNo());
//				} 
//				List<ConContractVo>  list= contractService.getConContracts(dto, "",isAccuracy);
//				List<String> idList = new ArrayList<>();
//				for (ConContractVo conContract : list) {
//					idList.add(conContract.getContractId());
//				}
//				if (idList!=null&&idList.isEmpty()){
//					c.andContractIdIn(idList);
//				}
//			}
		// ????????????
		if(!StringUtils.isEmpty(dto.getBusinessType())) {
			c.andBusinessTypeEqualTo(dto.getBusinessType());			
		}
		// ??????id
		if(!StringUtils.isEmpty(dto.getContractId())) {
			c.andContractIdEqualTo(dto.getContractId());
		}
		//????????????
		if (dto.getMinDate() != null) {
			c.andCreateDateGreaterThanOrEqualTo(DateUtils.getStartDate(dto.getMinDate()));
		}
		if (dto.getMaxDate() != null) {
			c.andCreateDateLessThanOrEqualTo(DateUtils.getEndDate(dto.getMaxDate()));
		}
		if(!StringUtils.isEmpty(dto.getAuditStatus())){
			c.andInspectionStatusEqualTo(dto.getAuditStatus());
		}
		// ?????????????????????????????????
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		return example;
	}

	
	/**
	 * @author shmily
	 * @Title: selectInsInspectionBillOne
	 * @Description: (????????????????????? ??????????????????id??????????????????????????????) 
	 * @param insInspectionId 
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionSub> getInsInspectionBillOne(String insInspectionId) {
		if (StringUtils.isEmpty(insInspectionId)){
			return null;
		}
		return getInsInspectionSubAll(insInspectionId);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionBillById 
	 * @Description: ( ??????id ???????????????????????? ) 
	 * @param insInspectionBillId
	 * @return 
	 * @throws
	 */
	@Override
	public InsInspectionBill getInsInspectionBillById(String insInspectionBillId) {
		if(StringUtils.isEmpty(insInspectionBillId)) {
			return null;
		}
		return insInspectionBillMapper.selectByPrimaryKey(insInspectionBillId);
	}
	
	/**
	 * ???????????????
	 * @author shmily
	 * @Title: addInsInspectionBill
	 * @Description: (?????????????????????????????????????????????)
	 * @param insInspectionBill
	 * @return  -1 ????????????
	 * @throws
	 */
	@Override
	public Integer addInsInspectionBill(InsInspectionBillDto insInspectionBillDto) {
		return -1;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: deleteInsInspectionBill 
	 * @Description: (???????????????) 
	 * @param insInspectionBillId
	 * @return 
	 * @throws
	 */
	@Override
	public Integer deleteInsInspectionBill(String insInspectionBillId) {
		
		if(StringUtils.isEmpty(insInspectionBillId)){
			return -1 ;
		}
		InsInspectionBill ins = new InsInspectionBill();
		ins.setInspectionBillId(insInspectionBillId);
		ins.setIsDel(YesOrNoEnum.YES.toString());
		InsInspectionBill a = updateInsInspectionBill(ins);
		if (a == null){
			return -1;
		}
		return 1;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: updateInsInspectionBill
	 * @Description: (???????????????)
	 * @param insInspectionBill
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InsInspectionBill updateInsInspectionBill(InsInspectionBill insInspectionBill) {
		if(insInspectionBill ==null ){
			return null;
		}
		int a = insInspectionBillMapper.updateByPrimaryKey(insInspectionBill);
		return insInspectionBill;
	}
	/*****************????????????*******************/
	/**
	 * 
	 * @author shmily
	 * @Title: selectInsInspectionSubAll 
	 * @Description: ( ???????????????????????? ??????????????????id?????? ) 
	 * @param insInspectionSub
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionSub> getInsInspectionSubAll(String  insInspectionId) {
		if (StringUtils.isEmpty(insInspectionId)) {
			return null;
		}
		InsInspectionSubExample example = new InsInspectionSubExample();
		InsInspectionSubExample.Criteria c = example.createCriteria();
		c.andInspectionIdEqualTo(insInspectionId);
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		return insInspectionSubMapper.selectByExample(example);
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionSubAll 
	 * @Description: ( ?????????????????????????????? ??? ????????????????????? ) 
	 * @param page
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<InsInspectionBillDto> getInsInspectionSubAll(PageUtils<InsInspectionBillDto> page,Boolean isAccuracy) {
		InsInspectionSubExample example = new InsInspectionSubExample();
		InsInspectionSubExample.Criteria c = example.createCriteria(); 
		InsInspectionBillDto insInspectionBillDto = page.getDto();
		setPageAndOrderBy(page);
		if (insInspectionBillDto != null) {
			// ?????? 
			if (!StringUtils.isEmpty(insInspectionBillDto.getBusinessType())) {
				c.andBusinessTypeEqualTo(insInspectionBillDto.getBusinessType());
			}
			// ?????????
			if(!StringUtils.isEmpty(insInspectionBillDto.getSubCode())){
				if (isAccuracy){
					c.andSubCodeEqualTo(insInspectionBillDto.getSubCode());
				}else {
					c.andSubCodeLike(insInspectionBillDto.getSubCode());
				}
			}

			//???????????? 
			if(insInspectionBillDto.getMaxDate()!=null&& insInspectionBillDto.getMinDate()!=null){
		        c.andCreateDateBetween(insInspectionBillDto.getMinDate(), insInspectionBillDto.getMaxDate());
			}
		}
		PageInfo<InsInspectionBillDto> page1 =  new PageInfo<InsInspectionBillDto>(formatBySub(insInspectionSubMapper.selectByExample(example)));
		return page1;
	}
	private List<InsInspectionBillDto> formatBySub(List<InsInspectionSub> subList){
		List<InsInspectionBillDto> dtoList = new ArrayList<InsInspectionBillDto>();
		if (subList.isEmpty()) {
			return  new ArrayList<InsInspectionBillDto>();
		}
		for (InsInspectionSub insInspectionSub : subList) {
			InsInspectionBillDto insInspectionBillDto = new InsInspectionBillDto();
			insInspectionBillDto.setInsInspectionSub(insInspectionSub);
			// ???????????????
			List<Attach> attach = gylBaseService.getAttachByIdAndType(insInspectionSub.getInspectionSubId(), ImageFileTypeEnum.ZHI_BAO_SHU.toString());
			if (attach !=null) {
				//insInspectionBillDto.setWarranty(attach);
				insInspectionBillDto.setWarrantyList(attach);
			}
			// ??????????????????
			List<Attach>  inventoryVoucher = gylBaseService.getAttachByIdAndType(insInspectionSub.getInspectionSubId(), ImageFileTypeEnum.CUN_HUO_PING_ZHENG.toString());
			if (inventoryVoucher !=null) {
				// insInspectionBillDto.setInventoryVoucher(inventoryVoucher);
				insInspectionBillDto.setInventoryVoucherList(inventoryVoucher);
			}
			// ????????????
			InsInspectionBill insInspectionBill = insInspectionBillMapper.selectByPrimaryKey(insInspectionSub.getInspectionId());
			if (insInspectionBill !=null) {
				ConContract con = contractService.getConContractById(insInspectionBill.getContractId());
				if (con !=null) {
					insInspectionBillDto.setContractNo(con.getContractNo());
					insInspectionBillDto.setConContract(con);
				}
				// ?????????
				insInspectionBillDto.setInsInspectionBill(insInspectionBill);
			}

			dtoList.add(insInspectionBillDto);
		}
		return dtoList;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: selectInsInspectionSubOne 
	 * @Description: (  ???????????????????????????  -- ??????????????????????????? ) 
	 * @param insInspectionSubId
	 * @return 
	 * @throws
	 */
	@Override
	public List<InsInspectionDetail> getInsInspectionSubOne(String insInspectionSubId) {
		
		if (StringUtils.isEmpty(insInspectionSubId)){
			return null;
		}
		return getInsInspectionDetailAll(insInspectionSubId);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getgetInsInspectionSubById 
	 * @Description: (  ???????????????????????????----??????????????????????????? ) 
	 * @param insInspectionSubId
	 * @return 
	 * @throws
	 */
	@Override
	public InsInspectionBillDto getgetInsInspectionSubById(String insInspectionSubId) {
		if (StringUtils.isEmpty(insInspectionSubId)){
			return null;
		}
		InsInspectionBillDto dto = new InsInspectionBillDto();
		InsInspectionSub ins = insInspectionSubMapper.selectByPrimaryKey(insInspectionSubId);
		if (ins == null){
			return null;
		}
		 dto.setInsInspectionSub(ins);
		// ??????????????????sub ????????????Dto ???????????????
		// ???????????????
		List<Attach> attach  = gylBaseService.getAttachByIdAndType(ins.getInspectionSubId(), ImageFileTypeEnum.ZHI_BAO_SHU.toString());
		// dto.setWarranty(attach);
		dto.setWarrantyList(attach);
		// ??????????????????
		List<Attach> inventoryVoucher = gylBaseService.getAttachByIdAndType(ins.getInspectionSubId(), ImageFileTypeEnum.CUN_HUO_PING_ZHENG.toString());
		 dto.setInventoryVoucherList(inventoryVoucher);
		return dto;
	}
	
	/**
	 * 
	 * @author shmily
	 * @Title: addInsInspectionSub 
	 * @Description: ( ????????????   ) 
	 * @param insInspectionSub
	 * @return 
	 * @throws
	 */
	@Override
	public InsInspectionSub addInsInspectionSub(InsInspectionSub insInspectionSub) {
		if(insInspectionSub == null ) {
			return null;
		}
		// ???????????? ????????????
		insInspectionSub.setSubCode(generateCode("TB_INS_INSPECTION_SUB","YS"));
		insInspectionSub.setCreateDate(new Date());
		insInspectionSub.setAuditStatus(ApprovalStateEnum.APPROVAL_NOT.toString());
		int a= insInspectionSubMapper.insertSelective(insInspectionSub);
		if (a != 1){
			return null;
		}
		return insInspectionSub;
	}

	@Override
	public Integer deleteInsInspectionSub(String insInspectionSubId) {
		if (StringUtils.isEmpty(insInspectionSubId)){
			return -1;
		}
		InsInspectionSub ins = new InsInspectionSub();
		ins.setInspectionSubId(insInspectionSubId);
		ins.setIsDel(YesOrNoEnum.YES.toString());
		return insInspectionSubMapper.updateByPrimaryKeySelective(ins);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: updateInsInspectionSub 
	 * @Description: ( ????????????  ) 
	 * @param insInspectionSub
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InsInspectionBillDto updateInsInspectionSub(InsInspectionBillDto insInspectionBillDto) {
		if(insInspectionBillDto==null){
			return null;
		}
		InsInspectionSub insInspectionSub = insInspectionBillDto.getInsInspectionSub();
		if (insInspectionSub == null || StringUtils.isEmpty(insInspectionSub.getInspectionSubId()) ) {
			return null;
		}
		// insInspectionSub.setAuditStatus(ApprovalStateEnum.APPROVAL_NOT.getState());
		int a = insInspectionSubMapper.updateByPrimaryKeySelective(insInspectionSub);
		insInspectionBillDto.setInsInspectionSub(insInspectionSub);
		return insInspectionBillDto;
	}


	/*****************????????????????????????********************************/
	/**
	 * 
	 * @author shmily
	 * @Title: selectInsInspectionDetailAll 
	 * @Description: ( ????????????????????????????????????  ) 
	 * @return
	 * @throws
	 */
	@Override
	public List<InsInspectionDetail> getInsInspectionDetailAll(String insInspectionSubId) {
		if (StringUtils.isEmpty(insInspectionSubId)){
			return null;
		}
		InsInspectionDetailExample example = new InsInspectionDetailExample();
		InsInspectionDetailExample.Criteria  c  = example.createCriteria();
		//   ??????????????????id ??????
		if (!StringUtils.isEmpty(insInspectionSubId)) {
			// ??????????????????id
			c.andInspectionSubIdEqualTo(insInspectionSubId);
		}
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		return insInspectionDetailMapper.selectByExample(example);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: addInsInspectionDetail 
	 * @Description: ( ????????????????????????  ) 
	 * @param insInspectionDetail
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InsInspectionDetail addInsInspectionDetail(InsInspectionDetail insInspectionDetail) {
		if (insInspectionDetail == null ) {
			return null; 
		}
		// ??????????????????
		
		insInspectionDetail.setIsDel(YesOrNoEnum.NO.toString());
		int a = insInspectionDetailMapper.insertSelective(insInspectionDetail);
		return insInspectionDetail;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: deleteInsInspectionDetail 
	 * @Description: ( ????????????????????????  ) 
	 * @param insInspectionDetailId
	 * @return 
	 * @throws
	 */
	@Override
	public Integer deleteInsInspectionDetail(String insInspectionDetailId) {
		if (StringUtils.isEmpty(insInspectionDetailId)){
			return -1;
		}
		InsInspectionDetail ins = new InsInspectionDetail();
		ins.setInspectionDetailId(insInspectionDetailId);
		ins.setIsDel(YesOrNoEnum.YES.toString());
		return insInspectionDetailMapper.updateByPrimaryKeySelective(ins);
//		return insInspectionDetailMapper.updateByPrimaryKey(ins);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: updateInsInspectionDetail 
	 * @Description: ( ????????????????????????  ) 
	 * @param insInspectionDetail
	 * @return  
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InsInspectionBillDto updateInsInspectionDetail(InsInspectionBillDto insInspectionBillDto) {
		if (insInspectionBillDto == null){
			return null;
		}
		InsInspectionDetail insInspectionDetail = insInspectionBillDto.getInsInspectionDetail();
		// ??????id????????????
		if (insInspectionDetail == null || StringUtils.isEmpty(insInspectionDetail.getInspectionDetailId())) {
			return null;
		}
		// DTO ????????? insInspectionDetail ??????
		
		
		
		int a = insInspectionDetailMapper.updateByPrimaryKeySelective(insInspectionDetail);
		insInspectionBillDto.setInsInspectionDetail(insInspectionDetail);
		return insInspectionBillDto;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionDetailByPass 
	 * @Description: (  ?????????????????????????????????????????????  ) 
	 * @param insInspectionBillId
	 * @return
	 * @throws
	 */
	@Override
	public List<InsInspectionDetail> getInsInspectionDetailByPass(String insInspectionBillId) {
		if (StringUtils.isEmpty(insInspectionBillId)){
			return null;
		}
		List<InsInspectionSub> list = getInsInspectionSubAll(insInspectionBillId);
		if (list == null ||list.size()==0){
			return null;
		}
		List<String> strList = new ArrayList<String>();
		for (InsInspectionSub insInspectionSub : list) {
			if (ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(insInspectionSub.getAuditStatus())){
				strList.add(insInspectionSub.getInspectionSubId());
			}
		}
		InsInspectionDetailExample example = new InsInspectionDetailExample();
		InsInspectionDetailExample.Criteria  c  = example.createCriteria();
		if (!strList.isEmpty()){
			  //  ?????? ???????????????id
			c.andInspectionSubIdIn(strList);
			c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
			return insInspectionDetailMapper.selectByExample(example);
		}
		return null;
	}
	/**************************??????*****************************/
	
	/**
	 * 
	 * @author shmily
	 * @Title: updateInsInspectionSubByDTO 
	 * @Description: ( ??????DTO?????????????????????  ) 
	 * @param insInspectionBillDto
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InsInspectionBillDto updateInsInspectionSubByDTO(InsInspectionBillDto insInspectionBillDto) {
		if (insInspectionBillDto == null){
			return null;
		}
		InsInspectionSub insInspectionSub = insInspectionBillDto.getInsInspectionSub();
		if (insInspectionSub == null ||StringUtils.isEmpty(insInspectionSub.getInspectionSubId())){
			return null;
		}
		//  ??????DTO ??? ??????????????????
		
		
		int a =insInspectionSubMapper.updateByPrimaryKeySelective(insInspectionSub);
		insInspectionBillDto.setInsInspectionSub(insInspectionSub);
		return insInspectionBillDto;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: addInsInspectionDetailByDTO 
	 * @Description: ( ?????????????????? ) 
	 * @param insInspectionBillDto
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InsInspectionBillDto addInsInspectionDetailByDTO(InsInspectionBillDto insInspectionBillDto) {
		if (insInspectionBillDto == null){
			return null;
		}
		InsInspectionDetail insInspectionDetail = insInspectionBillDto.getInsInspectionDetail();
		if (insInspectionDetail ==null){
			return null;
		}
		// ??????????????????
		Boolean flag = StringUtils.isEmpty(insInspectionDetail.getBuyerId())&& StringUtils.isEmpty(insInspectionDetail.getSellerId()) && StringUtils.isEmpty(insInspectionDetail.getBusinessType())&& insInspectionDetail.getInstockDate() == null;
		if (flag){
			return null;
		}
		// DTO  ??????????????????????????????
		
		
		
		
		insInspectionDetail.setIsDel(YesOrNoEnum.NO.toString());
		int a =insInspectionDetailMapper.insertSelective(insInspectionDetail);
		insInspectionBillDto.setInsInspectionDetail(insInspectionDetail);
		return insInspectionBillDto;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: addInsInspection 
	 * @Description: ( ???????????????  ) 
	 * @param instockId
	 * @param contractId
	 * @param inspectionInfo
	 * @return 
	 * @throws
	 */
	@SuppressWarnings("unused")
	@Override
	public InsInspectionBill addInsInspection(String instockId, String contractId,String inspectionInfo,String businessType) {
		InsInspectionBill insInspectionBill = new InsInspectionBill(); 
		insInspectionBill.setContractId(contractId);
		insInspectionBill.setInstockId(instockId);
		insInspectionBill.setCreateDate(new Date());
		//insInspectionBill.setCreateUser(gylApiService.getCurrentPrivUser().getUserName());
		String inspectionBillCode = generateCode("TB_INS_INSPECTION_BILL", "YS");
		insInspectionBill.setInspectionBillCode(inspectionBillCode);
		// ??????????????? 
		insInspectionBill.setInspectionStatus(InspectionTypeEnum.WEI_YAN_HUO.toString());
		// ????????????
		insInspectionBill.setInspectionInfo(inspectionInfo);
		insInspectionBill.setBusinessType(businessType);
		insInspectionBill.setIsDel(YesOrNoEnum.NO.toString());
		int a = insInspectionBillMapper.insertSelective(insInspectionBill);
		return insInspectionBill;
	}

	/**
	 * 
	 * @author shmily
	 * @Title: updatePassOrNotpass
	 * @Description: (  ???????????????????????????????????? ) 
	 * @param insInspectionBillDto
	 * @return
	 * @throws
	 */
	@Override
	public Integer updateFinancialPassOrNotpass(InsInspectionBillDto insInspectionBillDto) {
		Boolean flag = insInspectionBillDto != null &&(StringUtils.isEmpty(insInspectionBillDto.getBusinessType())|| StringUtils.isEmpty(insInspectionBillDto.getId()));
		if (flag){
			return -1;
		}
		return change(insInspectionBillDto);
	}
	/**
	 * 
	 * @author shmily
	 * @Title: updateSettlePassOrNotpass
	 * @Description: ( ????????????????????????  )
	 * @param insInspectionBillDto
	 * @return 
	 * @throws
	 */
	@Override
	public Integer updateSettlePassOrNotpass(InsInspectionBillDto insInspectionBillDto) {
		Boolean flag = insInspectionBillDto != null &&(StringUtils.isEmpty(insInspectionBillDto.getBusinessType())|| StringUtils.isEmpty(insInspectionBillDto.getId()));
		if (flag){
			return -1;
		}
		return change(insInspectionBillDto);
	}
	
	private Integer change(InsInspectionBillDto insInspectionBillDto){
		String id = insInspectionBillDto.getId();
		String  stats = insInspectionBillDto.getAuditStatus();
		String	 type = insInspectionBillDto.getBusinessType();
		String conId = insInspectionBillDto.getContractId();
		
		InsInspectionSub ins =new InsInspectionSub();
		ins.setInspectionSubId(id);
		//????????????  ?????? ?????????
		if (ApprovalStateEnum.APPROVAL_COMPLETE.getState().equals(stats)){
			// ????????????
			// ?????????????????????????????????
			if(!(type.equals(BusinessTypeEnum.HUO_YA_RONG_ZI.toString()))){
					checkByDetail(id);
			  //	invInventoryService.addInInvInventoryList(getInsInspectionDetailBySubId(id));
			}
			ins.setAuditStatus(stats);
		} else if(ApprovalStateEnum.APPROVAL_SUSPEND.getState().equals(stats)) {
			// ???????????????
			ins.setAuditStatus(stats);
		}else {
			ins.setAuditStatus(ApprovalStateEnum.APPROVAL_UNDERWAY.getState());
		}
		int i = insInspectionSubMapper.updateByPrimaryKeySelective(ins);
		if(i == 1&&ApprovalStateEnum.APPROVAL_COMPLETE.toString().equals(stats)) {
			// flowService.updateFlow(getBillId(id).getContractId(), null);
			// ????????????
			List<InsInspectionDetail> list = getInsInspectionDetailBySubId(id);
			//  
			List<InvInventoryDto> dto = invInventoryService.addInInvInventoryList(list,conId);
			if(dto!=null) {
				// ?????????????????? ????????????????????????
				if(BusinessTypeEnum.HUO_YA_RONG_ZI.toString().equals(type)) {
					flowService.updateFlow(getBillId(id).getContractId(), null);
				}
				return 1;
			}
		}
		return i;
	}
	
	
	/**
	 * 
	 * @author shmily
	 * @Title: checkByDetail 
	 * @Description: ( ?????????????????? ) 
	 * @param id
	 * @return List<InsInspectionDetail>
	 * @throws
	 */
	private List<InsInspectionDetail> checkByDetail(String id){
		if(StringUtils.isEmpty(id)) {
			return null;
		}
		List<InsInspectionDetail> list = getInsInspectionDetailById(id);
		List<InsInspectionDetail> list2 = new ArrayList<InsInspectionDetail>();
		if(list!=null&&!list.isEmpty()) {
			for (InsInspectionDetail insInspectionDetail : list) {
				InsInspectionDetail ins = new InsInspectionDetail();
				ins.setNextUnlockQuantity(insInspectionDetail.getAmount());
				ins.setInspectionDetailId(insInspectionDetail.getInspectionDetailId());
				int i = insInspectionDetailMapper.updateByPrimaryKeySelective(ins);
				if(i==1) {
					list2.add(ins);
				}
			}
		}
		
		return list2;
	}
	
	/**
	 * @author shmily
	 * @Title: updateStats 
	 * @Description: ( ????????????  ) 
	 * @param id
	 * @param stats
	 * @return
	 * @throws
	 */
	@Override
	public Integer updateStats(String id, String stats,Integer type) {
		if (StringUtils.isEmpty(id)||StringUtils.isEmpty(stats)){
			return -1;
		}
		Integer num = -1;
		InsInspectionBill ins = new InsInspectionBill();
		if (type == 0){
			ins.setInspectionBillId(id);
		} else if (type == 1) {
			// ???????????? ??????
			InsInspectionBillExample example = new InsInspectionBillExample();
			InsInspectionBillExample.Criteria c = example.createCriteria();
			c.andInstockIdEqualTo(id);
			List<InsInspectionBill> list =  insInspectionBillMapper.selectByExample(example);
			if (list ==null || list.isEmpty()||list.size()==0){
				return -1;
			}
			ins = list.get(0);
		}
		// ??????
		ins.setInspectionStatus(stats);
		num = insInspectionBillMapper.updateByPrimaryKeySelective(ins);
		return num;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getWarranty 
	 * @Description: (  ????????????id ????????????id ) 
	 * @param id
	 * @return 
	 * @throws
	 */
	public InsInspectionBill getBillId(String id) {
		if(StringUtils.isEmpty(id)) {
			return null;
		}
		InsInspectionSub sub =  insInspectionSubMapper.selectByPrimaryKey(id);
		InsInspectionBill bill  = insInspectionBillMapper.selectByPrimaryKey(sub.getInspectionId());
		return bill;
	}
	/**
	 * 
	 * @author shmily
	 * @Title: getInsInspectionBillByInstockId
	 * @Description: ( ???????????????id ???????????????  ) 
	 * @param instockId
	 * @return
	 * @throws
	 */
	@Override
	public InsInspectionBill getInsInspectionBillByInstockId(String instockId) {
		InsInspectionBillExample example = new InsInspectionBillExample();
		InsInspectionBillExample.Criteria c = example.createCriteria();
		c.andInstockIdEqualTo(instockId);
		List<InsInspectionBill> list = insInspectionBillMapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
	
	@SuppressWarnings("unused")
	private Attach createAttach(String id){
		Attach attach = new Attach();
		//  ??????
		//attach.setCrtearUser(gylApiService.getCurrentPrivUser().getUserName());
		attach.setRelationId(id);
		attach.setCreateTime(new Date());
		attach.setIsDel(YesOrNoEnum.NO.toString());
		return attach;
	}
	@Override
	public InsInspectionBill getInsInspectionBillByConId(String conContractId) {
		InsInspectionBillExample example = new InsInspectionBillExample();
		InsInspectionBillExample.Criteria c= example.createCriteria();
		if(StringUtils.isEmpty(conContractId)) {
			return null;
		}
		c.andContractIdEqualTo(conContractId);
		c.andIsDelEqualTo(YesOrNoEnum.NO.toString());
		
		List<InsInspectionBill> list =insInspectionBillMapper.selectByExample(example);
		if(list.size()>=1) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public InsInspectionSub getInsInspectionSubById(String insInspectionSubId) {
		if (StringUtils.isEmpty(insInspectionSubId)){
			return null;
		}
		InsInspectionSub ins = insInspectionSubMapper.selectByPrimaryKey(insInspectionSubId);
		if (ins == null){
			return null;
		}
		return ins;
	}
	

	
	
	









}
