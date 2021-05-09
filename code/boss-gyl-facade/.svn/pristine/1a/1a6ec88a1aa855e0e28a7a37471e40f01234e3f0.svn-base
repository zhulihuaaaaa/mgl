package com.maigangle.gyl.facade.entity.dto;

import java.io.Serializable;
import java.util.List;

import com.maigangle.gyl.facade.entity.Attach;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.ConContractDetail;
import com.maigangle.gyl.facade.entity.ConFeeRates;

public class ConContractSaveDto implements Serializable{

	private static final long serialVersionUID = 4824664748834683055L;
	
	/**
	 * 合同entity
	 */
	private ConContract entity;
	/**
	 * 附件
	 */
	private List<Attach> attach;
	/**
	 * 合同货物
	 */
	private List<ConContractDetail> contractDetail;
	
	private List<ConFeeRates> feeRates;
	
	/**
	 * 需要删除的DetialId
	 */
	private List<String> delDetialId;
	
	
	public ConContract getEntity() {
		return entity;
	}

	public void setEntity(ConContract entity) {
		this.entity = entity;
	}

	public List<Attach> getAttach() {
		return attach;
	}

	public void setAttach(List<Attach> attach) {
		this.attach = attach;
	}

	public List<ConContractDetail> getContractDetail() {
		return contractDetail;
	}

	public void setContractDetail(List<ConContractDetail> contractDetail) {
		this.contractDetail = contractDetail;
	}

	public List<ConFeeRates> getFeeRates() {
		return feeRates;
	}

	public void setFeeRates(List<ConFeeRates> feeRates) {
		this.feeRates = feeRates;
	}

	public List<String> getDelDetialId() {
		return delDetialId;
	}

	public void setDelDetialId(List<String> delDetialId) {
		this.delDetialId = delDetialId;
	}
	
}
