package com.maigangle.gyl.facade.entity.excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maigangle.gyl.facade.entity.BaseCompany;
import com.maigangle.gyl.facade.entity.api.CrmClient;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("InsInspectionBillExcel")
public class InsInspectionBillExcel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1142491033922489041L;

    /**
     * id
     */
    private String inspectionBillId;

    /**
     * 入库单ID
     */
    private String instockId;
	
 	/**
 	 * 合同单号
 	 */
    @Excel(name = "合同自编号", needMerge = true)
    private String contractCode;
   
    /**
     * 合同编号
     */
    @Excel(name = "合同编号", width = 20, needMerge = true)
    private String contractNo;

    /**
     * 验货单号
     */
    @Excel(name = "验货单号", needMerge = true)
    private String inspectionBillCode;

	/**
     * 子单id
     */
    private String inspectionSubId;

    /**
     * 子单单号
     */
    @Excel(name = "子单单号", needMerge = true)
    private String subCode;

    /**
     * 创建人
     */
    @Excel(name = "创建人", needMerge = true)
    private String createUser;

    /**
     * 创建日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss") // 存日期时使用
    @Excel(name = "创建日期" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date createDate;

    /**
     * 入库日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 取日期时使用
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 存日期时使用
    @Excel(name = "入库日期" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date instockDate;

    /**
     * 审核状态 0:已提交、1:审核中、2:未通过、3:已通过
     */
    @Excel(name = "审核状态", replace={"已提交_A","审核中_B","未通过_C","已通过_D"}, needMerge = true)
    private String auditStatus;

    /**
     * 品名
     */
    @Excel(name = "品名")
    private String productName;

    /**
     * 规格
     */
    @Excel(name = "规格", needMerge = true)
    private String specification;

    /**
     * 材质（钢种）
     */
    @Excel(name = "材质", needMerge = true)
    private String materialId;

    /**
     * 表面
     */
    @Excel(name = "表面")
    private String surfaceId;

    /**
     * 边部
     */
    @Excel(name = "边部")
    private String edge;

    /**
     * 参厚
     */
    @Excel(name = "参厚")
    private BigDecimal referThick;

    /**
     * 实宽
     */
    @Excel(name = "实宽")
    private BigDecimal realWidth;

    /**
     * 牌号
     */
    @Excel(name = "牌号")
    private String trademark;

    /**
     * 卷号
     */
    @Excel(name = "卷号")
    private String volume;
    
    /**
     * 净重
     */
    @Excel(name = "净重")
    private BigDecimal netWeight;

    /**
     * 数量（张/卷）
     */
    @Excel(name = "数量")
    private BigDecimal amount;

    
    
    
	public BigDecimal getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getInspectionBillId() {
		return inspectionBillId;
	}

	public void setInspectionBillId(String inspectionBillId) {
		this.inspectionBillId = inspectionBillId;
	}

	public String getInstockId() {
		return instockId;
	}

	public void setInstockId(String instockId) {
		this.instockId = instockId;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getInspectionBillCode() {
		return inspectionBillCode;
	}

	public void setInspectionBillCode(String inspectionBillCode) {
		this.inspectionBillCode = inspectionBillCode;
	}

	public String getInspectionSubId() {
		return inspectionSubId;
	}

	public void setInspectionSubId(String inspectionSubId) {
		this.inspectionSubId = inspectionSubId;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getInstockDate() {
		return instockDate;
	}

	public void setInstockDate(Date instockDate) {
		this.instockDate = instockDate;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getSurfaceId() {
		return surfaceId;
	}

	public void setSurfaceId(String surfaceId) {
		this.surfaceId = surfaceId;
	}

	public String getEdge() {
		return edge;
	}

	public void setEdge(String edge) {
		this.edge = edge;
	}

	public BigDecimal getReferThick() {
		return referThick;
	}

	public void setReferThick(BigDecimal referThick) {
		this.referThick = referThick;
	}

	public BigDecimal getRealWidth() {
		return realWidth;
	}

	public void setRealWidth(BigDecimal realWidth) {
		this.realWidth = realWidth;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}