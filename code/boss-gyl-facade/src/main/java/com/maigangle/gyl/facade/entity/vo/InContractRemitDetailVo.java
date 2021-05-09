package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;

import com.maigangle.gyl.facade.entity.InContractRemitDetail;

/**  
 * 合同打款Vo
 * @author zlh
 * @since 2017年12月26日 下午2:27:07 
 * @version 1.0 
 */
public class InContractRemitDetailVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8968145880580191228L;

	/**
	 * 打款类型
	 */
	private String remitType;
	
	/**
	 * 打款类型名称
	 */
	private String remitTypeName;
	
	private String remitState;
	
	/**
	 * InContractRemitDetail
	 */
	private InContractRemitDetail detail;
	
	public String getRemitType() {
		return remitType;
	}

	public void setRemitType(String remitType) {
		this.remitType = remitType;
	}

	public InContractRemitDetail getDetail() {
		return detail;
	}

	public void setDetail(InContractRemitDetail detail) {
		this.detail = detail;
	}

	public String getRemitTypeName() {
		return remitTypeName;
	}

	public void setRemitTypeName(String remitTypeName) {
		this.remitTypeName = remitTypeName;
	}

	public String getRemitState() {
		return remitState;
	}

	public void setRemitState(String remitState) {
		this.remitState = remitState;
	}

}
