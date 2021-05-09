package com.maigangle.gyl.facade.entity.vo;

import java.util.List;

import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.ConFeeRates;
import com.maigangle.gyl.facade.entity.api.CrmClient;
import com.maigangle.gyl.facade.entity.api.DictMallMnfct;

public class ConContractVo extends ConContract{
	
	private static final long serialVersionUID = 4750032675464059914L;
	
	/**
	 * 关联合同
	 */
	private ConContractVo relativeContract;
	
	/**
	 * 附件
	 */
	private List<Attach> attactList;
	
	/**卖方信息
	 * 
	 */
	private BaseCompany seller;
	
	/**
	 * 买家
	 */
	private CrmClient buyer;
	
	/**
	 * 厂商
	 */
	private DictMallMnfct mnfct;
	
	/**
	 * 合约状态
	 */
	private String contractStateName;
	
	/**
	 * 合同类型
	 */
	private String contractTypeName;
	
	/**
	 * 手续费率
	 */
	private List<ConFeeRates> feeRates;
	
	/**
	 * 货物明细
	 */
	private List<ConContractDetailVo> contractDetail;

	public ConContractVo getRelativeContract() {
		return relativeContract;
	}

	public void setRelativeContract(ConContractVo relativeContract) {
		this.relativeContract = relativeContract;
	}

	public List<Attach> getAttactList() {
		return attactList;
	}

	public void setAttactList(List<Attach> attactList) {
		this.attactList = attactList;
	}

	public BaseCompany getSeller() {
		return seller;
	}

	public void setSeller(BaseCompany seller) {
		this.seller = seller;
	}

	public CrmClient getBuyer() {
		return buyer;
	}

	public void setBuyer(CrmClient buyer) {
		this.buyer = buyer;
	}

	public DictMallMnfct getMnfct() {
		return mnfct;
	}

	public void setMnfct(DictMallMnfct mnfct) {
		this.mnfct = mnfct;
	}

	public String getContractStateName() {
		return contractStateName;
	}

	public void setContractStateName(String contractStateName) {
		this.contractStateName = contractStateName;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	public List<ConFeeRates> getFeeRates() {
		return feeRates;
	}

	public void setFeeRates(List<ConFeeRates> feeRates) {
		this.feeRates = feeRates;
	}

	public List<ConContractDetailVo> getContractDetail() {
		return contractDetail;
	}

	public void setContractDetail(List<ConContractDetailVo> contractDetail) {
		this.contractDetail = contractDetail;
	}


}
