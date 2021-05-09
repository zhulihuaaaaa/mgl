package com.maigangle.gyl.facade.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.ConContract;
import com.maigangle.gyl.facade.entity.FeeContractBalance;
/**
 * 用于接收合同对账信息的参数
 * @author 倪凯
 */
public class ContractBalanceVo extends FeeContractBalance{
	private static final long serialVersionUID = 6094930793921709913L;

	/**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
    private Date startCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") 
    private Date endCreateDate;
	public Date getStartCreateDate() {
		return startCreateDate;
	}
	public void setStartCreateDate(Date startCreateDate) {
		this.startCreateDate = startCreateDate;
	}
	public Date getEndCreateDate() {
		return endCreateDate;
	}
	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
}
