package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FeeInvoiceDetailExample {
    /**
     * TB_FEE_INVOICE_DETAIL
     */
    protected String orderByClause;

    /**
     * TB_FEE_INVOICE_DETAIL
     */
    protected boolean distinct;

    /**
     * TB_FEE_INVOICE_DETAIL
     */
    protected List<Criteria> oredCriteria;

    public FeeInvoiceDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * TB_FEE_INVOICE_DETAIL 2018-03-01
     */
     
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andInvoiceDetailIdIsNull() {
            addCriterion("INVOICE_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdIsNotNull() {
            addCriterion("INVOICE_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdEqualTo(String value) {
            addCriterion("INVOICE_DETAIL_ID =", value, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdNotEqualTo(String value) {
            addCriterion("INVOICE_DETAIL_ID <>", value, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdGreaterThan(String value) {
            addCriterion("INVOICE_DETAIL_ID >", value, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_DETAIL_ID >=", value, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdLessThan(String value) {
            addCriterion("INVOICE_DETAIL_ID <", value, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_DETAIL_ID <=", value, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdLike(String value) {
            addCriterion("INVOICE_DETAIL_ID like", value, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdNotLike(String value) {
            addCriterion("INVOICE_DETAIL_ID not like", value, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdIn(List<String> values) {
            addCriterion("INVOICE_DETAIL_ID in", values, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdNotIn(List<String> values) {
            addCriterion("INVOICE_DETAIL_ID not in", values, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdBetween(String value1, String value2) {
            addCriterion("INVOICE_DETAIL_ID between", value1, value2, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andInvoiceDetailIdNotBetween(String value1, String value2) {
            addCriterion("INVOICE_DETAIL_ID not between", value1, value2, "invoiceDetailId");
            return (Criteria) this;
        }

        public Criteria andStorageIdIsNull() {
            addCriterion("STORAGE_ID is null");
            return (Criteria) this;
        }

        public Criteria andStorageIdIsNotNull() {
            addCriterion("STORAGE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStorageIdEqualTo(String value) {
            addCriterion("STORAGE_ID =", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotEqualTo(String value) {
            addCriterion("STORAGE_ID <>", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThan(String value) {
            addCriterion("STORAGE_ID >", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThanOrEqualTo(String value) {
            addCriterion("STORAGE_ID >=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThan(String value) {
            addCriterion("STORAGE_ID <", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThanOrEqualTo(String value) {
            addCriterion("STORAGE_ID <=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLike(String value) {
            addCriterion("STORAGE_ID like", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotLike(String value) {
            addCriterion("STORAGE_ID not like", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdIn(List<String> values) {
            addCriterion("STORAGE_ID in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotIn(List<String> values) {
            addCriterion("STORAGE_ID not in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdBetween(String value1, String value2) {
            addCriterion("STORAGE_ID between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotBetween(String value1, String value2) {
            addCriterion("STORAGE_ID not between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("MATERIAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("MATERIAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(String value) {
            addCriterion("MATERIAL_ID =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(String value) {
            addCriterion("MATERIAL_ID <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(String value) {
            addCriterion("MATERIAL_ID >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("MATERIAL_ID >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(String value) {
            addCriterion("MATERIAL_ID <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("MATERIAL_ID <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLike(String value) {
            addCriterion("MATERIAL_ID like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotLike(String value) {
            addCriterion("MATERIAL_ID not like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<String> values) {
            addCriterion("MATERIAL_ID in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<String> values) {
            addCriterion("MATERIAL_ID not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(String value1, String value2) {
            addCriterion("MATERIAL_ID between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(String value1, String value2) {
            addCriterion("MATERIAL_ID not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdIsNull() {
            addCriterion("SURFACE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdIsNotNull() {
            addCriterion("SURFACE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdEqualTo(String value) {
            addCriterion("SURFACE_ID =", value, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdNotEqualTo(String value) {
            addCriterion("SURFACE_ID <>", value, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdGreaterThan(String value) {
            addCriterion("SURFACE_ID >", value, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("SURFACE_ID >=", value, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdLessThan(String value) {
            addCriterion("SURFACE_ID <", value, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdLessThanOrEqualTo(String value) {
            addCriterion("SURFACE_ID <=", value, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdLike(String value) {
            addCriterion("SURFACE_ID like", value, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdNotLike(String value) {
            addCriterion("SURFACE_ID not like", value, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdIn(List<String> values) {
            addCriterion("SURFACE_ID in", values, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdNotIn(List<String> values) {
            addCriterion("SURFACE_ID not in", values, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdBetween(String value1, String value2) {
            addCriterion("SURFACE_ID between", value1, value2, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andSurfaceIdNotBetween(String value1, String value2) {
            addCriterion("SURFACE_ID not between", value1, value2, "surfaceId");
            return (Criteria) this;
        }

        public Criteria andLabelThickIsNull() {
            addCriterion("LABEL_THICK is null");
            return (Criteria) this;
        }

        public Criteria andLabelThickIsNotNull() {
            addCriterion("LABEL_THICK is not null");
            return (Criteria) this;
        }

        public Criteria andLabelThickEqualTo(String value) {
            addCriterion("LABEL_THICK =", value, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickNotEqualTo(String value) {
            addCriterion("LABEL_THICK <>", value, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickGreaterThan(String value) {
            addCriterion("LABEL_THICK >", value, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickGreaterThanOrEqualTo(String value) {
            addCriterion("LABEL_THICK >=", value, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickLessThan(String value) {
            addCriterion("LABEL_THICK <", value, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickLessThanOrEqualTo(String value) {
            addCriterion("LABEL_THICK <=", value, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickLike(String value) {
            addCriterion("LABEL_THICK like", value, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickNotLike(String value) {
            addCriterion("LABEL_THICK not like", value, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickIn(List<String> values) {
            addCriterion("LABEL_THICK in", values, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickNotIn(List<String> values) {
            addCriterion("LABEL_THICK not in", values, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickBetween(String value1, String value2) {
            addCriterion("LABEL_THICK between", value1, value2, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelThickNotBetween(String value1, String value2) {
            addCriterion("LABEL_THICK not between", value1, value2, "labelThick");
            return (Criteria) this;
        }

        public Criteria andLabelWidthIsNull() {
            addCriterion("LABEL_WIDTH is null");
            return (Criteria) this;
        }

        public Criteria andLabelWidthIsNotNull() {
            addCriterion("LABEL_WIDTH is not null");
            return (Criteria) this;
        }

        public Criteria andLabelWidthEqualTo(String value) {
            addCriterion("LABEL_WIDTH =", value, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthNotEqualTo(String value) {
            addCriterion("LABEL_WIDTH <>", value, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthGreaterThan(String value) {
            addCriterion("LABEL_WIDTH >", value, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthGreaterThanOrEqualTo(String value) {
            addCriterion("LABEL_WIDTH >=", value, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthLessThan(String value) {
            addCriterion("LABEL_WIDTH <", value, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthLessThanOrEqualTo(String value) {
            addCriterion("LABEL_WIDTH <=", value, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthLike(String value) {
            addCriterion("LABEL_WIDTH like", value, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthNotLike(String value) {
            addCriterion("LABEL_WIDTH not like", value, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthIn(List<String> values) {
            addCriterion("LABEL_WIDTH in", values, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthNotIn(List<String> values) {
            addCriterion("LABEL_WIDTH not in", values, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthBetween(String value1, String value2) {
            addCriterion("LABEL_WIDTH between", value1, value2, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andLabelWidthNotBetween(String value1, String value2) {
            addCriterion("LABEL_WIDTH not between", value1, value2, "labelWidth");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthIsNull() {
            addCriterion("GOODS_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthIsNotNull() {
            addCriterion("GOODS_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthEqualTo(String value) {
            addCriterion("GOODS_LENGTH =", value, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthNotEqualTo(String value) {
            addCriterion("GOODS_LENGTH <>", value, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthGreaterThan(String value) {
            addCriterion("GOODS_LENGTH >", value, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_LENGTH >=", value, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthLessThan(String value) {
            addCriterion("GOODS_LENGTH <", value, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthLessThanOrEqualTo(String value) {
            addCriterion("GOODS_LENGTH <=", value, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthLike(String value) {
            addCriterion("GOODS_LENGTH like", value, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthNotLike(String value) {
            addCriterion("GOODS_LENGTH not like", value, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthIn(List<String> values) {
            addCriterion("GOODS_LENGTH in", values, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthNotIn(List<String> values) {
            addCriterion("GOODS_LENGTH not in", values, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthBetween(String value1, String value2) {
            addCriterion("GOODS_LENGTH between", value1, value2, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andGoodsLengthNotBetween(String value1, String value2) {
            addCriterion("GOODS_LENGTH not between", value1, value2, "goodsLength");
            return (Criteria) this;
        }

        public Criteria andEdgeIsNull() {
            addCriterion("EDGE is null");
            return (Criteria) this;
        }

        public Criteria andEdgeIsNotNull() {
            addCriterion("EDGE is not null");
            return (Criteria) this;
        }

        public Criteria andEdgeEqualTo(String value) {
            addCriterion("EDGE =", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotEqualTo(String value) {
            addCriterion("EDGE <>", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeGreaterThan(String value) {
            addCriterion("EDGE >", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeGreaterThanOrEqualTo(String value) {
            addCriterion("EDGE >=", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeLessThan(String value) {
            addCriterion("EDGE <", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeLessThanOrEqualTo(String value) {
            addCriterion("EDGE <=", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeLike(String value) {
            addCriterion("EDGE like", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotLike(String value) {
            addCriterion("EDGE not like", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeIn(List<String> values) {
            addCriterion("EDGE in", values, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotIn(List<String> values) {
            addCriterion("EDGE not in", values, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeBetween(String value1, String value2) {
            addCriterion("EDGE between", value1, value2, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotBetween(String value1, String value2) {
            addCriterion("EDGE not between", value1, value2, "edge");
            return (Criteria) this;
        }

        public Criteria andReferThickIsNull() {
            addCriterion("REFER_THICK is null");
            return (Criteria) this;
        }

        public Criteria andReferThickIsNotNull() {
            addCriterion("REFER_THICK is not null");
            return (Criteria) this;
        }

        public Criteria andReferThickEqualTo(BigDecimal value) {
            addCriterion("REFER_THICK =", value, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickNotEqualTo(BigDecimal value) {
            addCriterion("REFER_THICK <>", value, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickGreaterThan(BigDecimal value) {
            addCriterion("REFER_THICK >", value, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REFER_THICK >=", value, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickLessThan(BigDecimal value) {
            addCriterion("REFER_THICK <", value, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REFER_THICK <=", value, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickIn(List<BigDecimal> values) {
            addCriterion("REFER_THICK in", values, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickNotIn(List<BigDecimal> values) {
            addCriterion("REFER_THICK not in", values, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFER_THICK between", value1, value2, "referThick");
            return (Criteria) this;
        }

        public Criteria andReferThickNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REFER_THICK not between", value1, value2, "referThick");
            return (Criteria) this;
        }

        public Criteria andRealWidthIsNull() {
            addCriterion("REAL_WIDTH is null");
            return (Criteria) this;
        }

        public Criteria andRealWidthIsNotNull() {
            addCriterion("REAL_WIDTH is not null");
            return (Criteria) this;
        }

        public Criteria andRealWidthEqualTo(BigDecimal value) {
            addCriterion("REAL_WIDTH =", value, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthNotEqualTo(BigDecimal value) {
            addCriterion("REAL_WIDTH <>", value, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthGreaterThan(BigDecimal value) {
            addCriterion("REAL_WIDTH >", value, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_WIDTH >=", value, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthLessThan(BigDecimal value) {
            addCriterion("REAL_WIDTH <", value, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_WIDTH <=", value, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthIn(List<BigDecimal> values) {
            addCriterion("REAL_WIDTH in", values, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthNotIn(List<BigDecimal> values) {
            addCriterion("REAL_WIDTH not in", values, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_WIDTH between", value1, value2, "realWidth");
            return (Criteria) this;
        }

        public Criteria andRealWidthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_WIDTH not between", value1, value2, "realWidth");
            return (Criteria) this;
        }

        public Criteria andTrademarkIsNull() {
            addCriterion("TRADEMARK is null");
            return (Criteria) this;
        }

        public Criteria andTrademarkIsNotNull() {
            addCriterion("TRADEMARK is not null");
            return (Criteria) this;
        }

        public Criteria andTrademarkEqualTo(String value) {
            addCriterion("TRADEMARK =", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkNotEqualTo(String value) {
            addCriterion("TRADEMARK <>", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkGreaterThan(String value) {
            addCriterion("TRADEMARK >", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkGreaterThanOrEqualTo(String value) {
            addCriterion("TRADEMARK >=", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkLessThan(String value) {
            addCriterion("TRADEMARK <", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkLessThanOrEqualTo(String value) {
            addCriterion("TRADEMARK <=", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkLike(String value) {
            addCriterion("TRADEMARK like", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkNotLike(String value) {
            addCriterion("TRADEMARK not like", value, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkIn(List<String> values) {
            addCriterion("TRADEMARK in", values, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkNotIn(List<String> values) {
            addCriterion("TRADEMARK not in", values, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkBetween(String value1, String value2) {
            addCriterion("TRADEMARK between", value1, value2, "trademark");
            return (Criteria) this;
        }

        public Criteria andTrademarkNotBetween(String value1, String value2) {
            addCriterion("TRADEMARK not between", value1, value2, "trademark");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("VOLUME is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("VOLUME is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(String value) {
            addCriterion("VOLUME =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(String value) {
            addCriterion("VOLUME <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(String value) {
            addCriterion("VOLUME >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(String value) {
            addCriterion("VOLUME >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(String value) {
            addCriterion("VOLUME <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(String value) {
            addCriterion("VOLUME <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLike(String value) {
            addCriterion("VOLUME like", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotLike(String value) {
            addCriterion("VOLUME not like", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<String> values) {
            addCriterion("VOLUME in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<String> values) {
            addCriterion("VOLUME not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(String value1, String value2) {
            addCriterion("VOLUME between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(String value1, String value2) {
            addCriterion("VOLUME not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andMnfctIdIsNull() {
            addCriterion("MNFCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMnfctIdIsNotNull() {
            addCriterion("MNFCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMnfctIdEqualTo(String value) {
            addCriterion("MNFCT_ID =", value, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdNotEqualTo(String value) {
            addCriterion("MNFCT_ID <>", value, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdGreaterThan(String value) {
            addCriterion("MNFCT_ID >", value, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdGreaterThanOrEqualTo(String value) {
            addCriterion("MNFCT_ID >=", value, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdLessThan(String value) {
            addCriterion("MNFCT_ID <", value, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdLessThanOrEqualTo(String value) {
            addCriterion("MNFCT_ID <=", value, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdLike(String value) {
            addCriterion("MNFCT_ID like", value, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdNotLike(String value) {
            addCriterion("MNFCT_ID not like", value, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdIn(List<String> values) {
            addCriterion("MNFCT_ID in", values, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdNotIn(List<String> values) {
            addCriterion("MNFCT_ID not in", values, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdBetween(String value1, String value2) {
            addCriterion("MNFCT_ID between", value1, value2, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andMnfctIdNotBetween(String value1, String value2) {
            addCriterion("MNFCT_ID not between", value1, value2, "mnfctId");
            return (Criteria) this;
        }

        public Criteria andNetWeightIsNull() {
            addCriterion("NET_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andNetWeightIsNotNull() {
            addCriterion("NET_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andNetWeightEqualTo(BigDecimal value) {
            addCriterion("NET_WEIGHT =", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightNotEqualTo(BigDecimal value) {
            addCriterion("NET_WEIGHT <>", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightGreaterThan(BigDecimal value) {
            addCriterion("NET_WEIGHT >", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NET_WEIGHT >=", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightLessThan(BigDecimal value) {
            addCriterion("NET_WEIGHT <", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NET_WEIGHT <=", value, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightIn(List<BigDecimal> values) {
            addCriterion("NET_WEIGHT in", values, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightNotIn(List<BigDecimal> values) {
            addCriterion("NET_WEIGHT not in", values, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NET_WEIGHT between", value1, value2, "netWeight");
            return (Criteria) this;
        }

        public Criteria andNetWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NET_WEIGHT not between", value1, value2, "netWeight");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(BigDecimal value) {
            addCriterion("QUANTITY =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(BigDecimal value) {
            addCriterion("QUANTITY <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(BigDecimal value) {
            addCriterion("QUANTITY >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUANTITY >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(BigDecimal value) {
            addCriterion("QUANTITY <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUANTITY <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<BigDecimal> values) {
            addCriterion("QUANTITY in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<BigDecimal> values) {
            addCriterion("QUANTITY not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUANTITY between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUANTITY not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andCalcMethodIsNull() {
            addCriterion("CALC_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andCalcMethodIsNotNull() {
            addCriterion("CALC_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andCalcMethodEqualTo(String value) {
            addCriterion("CALC_METHOD =", value, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodNotEqualTo(String value) {
            addCriterion("CALC_METHOD <>", value, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodGreaterThan(String value) {
            addCriterion("CALC_METHOD >", value, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodGreaterThanOrEqualTo(String value) {
            addCriterion("CALC_METHOD >=", value, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodLessThan(String value) {
            addCriterion("CALC_METHOD <", value, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodLessThanOrEqualTo(String value) {
            addCriterion("CALC_METHOD <=", value, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodLike(String value) {
            addCriterion("CALC_METHOD like", value, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodNotLike(String value) {
            addCriterion("CALC_METHOD not like", value, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodIn(List<String> values) {
            addCriterion("CALC_METHOD in", values, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodNotIn(List<String> values) {
            addCriterion("CALC_METHOD not in", values, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodBetween(String value1, String value2) {
            addCriterion("CALC_METHOD between", value1, value2, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andCalcMethodNotBetween(String value1, String value2) {
            addCriterion("CALC_METHOD not between", value1, value2, "calcMethod");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("GRADE is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("GRADE =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("GRADE <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("GRADE >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("GRADE >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("GRADE <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("GRADE <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("GRADE like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("GRADE not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("GRADE in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("GRADE not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("GRADE between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("GRADE not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andImplStdIsNull() {
            addCriterion("IMPL_STD is null");
            return (Criteria) this;
        }

        public Criteria andImplStdIsNotNull() {
            addCriterion("IMPL_STD is not null");
            return (Criteria) this;
        }

        public Criteria andImplStdEqualTo(String value) {
            addCriterion("IMPL_STD =", value, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdNotEqualTo(String value) {
            addCriterion("IMPL_STD <>", value, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdGreaterThan(String value) {
            addCriterion("IMPL_STD >", value, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdGreaterThanOrEqualTo(String value) {
            addCriterion("IMPL_STD >=", value, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdLessThan(String value) {
            addCriterion("IMPL_STD <", value, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdLessThanOrEqualTo(String value) {
            addCriterion("IMPL_STD <=", value, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdLike(String value) {
            addCriterion("IMPL_STD like", value, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdNotLike(String value) {
            addCriterion("IMPL_STD not like", value, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdIn(List<String> values) {
            addCriterion("IMPL_STD in", values, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdNotIn(List<String> values) {
            addCriterion("IMPL_STD not in", values, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdBetween(String value1, String value2) {
            addCriterion("IMPL_STD between", value1, value2, "implStd");
            return (Criteria) this;
        }

        public Criteria andImplStdNotBetween(String value1, String value2) {
            addCriterion("IMPL_STD not between", value1, value2, "implStd");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceIsNull() {
            addCriterion("CONTRACT_UNIT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceIsNotNull() {
            addCriterion("CONTRACT_UNIT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_UNIT_PRICE =", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_UNIT_PRICE <>", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("CONTRACT_UNIT_PRICE >", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_UNIT_PRICE >=", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceLessThan(BigDecimal value) {
            addCriterion("CONTRACT_UNIT_PRICE <", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_UNIT_PRICE <=", value, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceIn(List<BigDecimal> values) {
            addCriterion("CONTRACT_UNIT_PRICE in", values, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("CONTRACT_UNIT_PRICE not in", values, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACT_UNIT_PRICE between", value1, value2, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andContractUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACT_UNIT_PRICE not between", value1, value2, "contractUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceIsNull() {
            addCriterion("REAL_UNIT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceIsNotNull() {
            addCriterion("REAL_UNIT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceEqualTo(BigDecimal value) {
            addCriterion("REAL_UNIT_PRICE =", value, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("REAL_UNIT_PRICE <>", value, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("REAL_UNIT_PRICE >", value, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_UNIT_PRICE >=", value, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceLessThan(BigDecimal value) {
            addCriterion("REAL_UNIT_PRICE <", value, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_UNIT_PRICE <=", value, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceIn(List<BigDecimal> values) {
            addCriterion("REAL_UNIT_PRICE in", values, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("REAL_UNIT_PRICE not in", values, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_UNIT_PRICE between", value1, value2, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andRealUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_UNIT_PRICE not between", value1, value2, "realUnitPrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceIsNull() {
            addCriterion("INVOICE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceIsNotNull() {
            addCriterion("INVOICE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceEqualTo(BigDecimal value) {
            addCriterion("INVOICE_PRICE =", value, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceNotEqualTo(BigDecimal value) {
            addCriterion("INVOICE_PRICE <>", value, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceGreaterThan(BigDecimal value) {
            addCriterion("INVOICE_PRICE >", value, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INVOICE_PRICE >=", value, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceLessThan(BigDecimal value) {
            addCriterion("INVOICE_PRICE <", value, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INVOICE_PRICE <=", value, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceIn(List<BigDecimal> values) {
            addCriterion("INVOICE_PRICE in", values, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceNotIn(List<BigDecimal> values) {
            addCriterion("INVOICE_PRICE not in", values, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVOICE_PRICE between", value1, value2, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andInvoicePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVOICE_PRICE not between", value1, value2, "invoicePrice");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNull() {
            addCriterion("CONTRACT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNotNull() {
            addCriterion("CONTRACT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_MONEY =", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_MONEY <>", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThan(BigDecimal value) {
            addCriterion("CONTRACT_MONEY >", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_MONEY >=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThan(BigDecimal value) {
            addCriterion("CONTRACT_MONEY <", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_MONEY <=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIn(List<BigDecimal> values) {
            addCriterion("CONTRACT_MONEY in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotIn(List<BigDecimal> values) {
            addCriterion("CONTRACT_MONEY not in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACT_MONEY between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACT_MONEY not between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIsNull() {
            addCriterion("REAL_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIsNotNull() {
            addCriterion("REAL_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andRealMoneyEqualTo(BigDecimal value) {
            addCriterion("REAL_MONEY =", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotEqualTo(BigDecimal value) {
            addCriterion("REAL_MONEY <>", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyGreaterThan(BigDecimal value) {
            addCriterion("REAL_MONEY >", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_MONEY >=", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyLessThan(BigDecimal value) {
            addCriterion("REAL_MONEY <", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_MONEY <=", value, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyIn(List<BigDecimal> values) {
            addCriterion("REAL_MONEY in", values, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotIn(List<BigDecimal> values) {
            addCriterion("REAL_MONEY not in", values, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_MONEY between", value1, value2, "realMoney");
            return (Criteria) this;
        }

        public Criteria andRealMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_MONEY not between", value1, value2, "realMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyIsNull() {
            addCriterion("INVOICE_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyIsNotNull() {
            addCriterion("INVOICE_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyEqualTo(BigDecimal value) {
            addCriterion("INVOICE_MONEY =", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("INVOICE_MONEY <>", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyGreaterThan(BigDecimal value) {
            addCriterion("INVOICE_MONEY >", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INVOICE_MONEY >=", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyLessThan(BigDecimal value) {
            addCriterion("INVOICE_MONEY <", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INVOICE_MONEY <=", value, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyIn(List<BigDecimal> values) {
            addCriterion("INVOICE_MONEY in", values, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("INVOICE_MONEY not in", values, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVOICE_MONEY between", value1, value2, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andInvoiceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVOICE_MONEY not between", value1, value2, "invoiceMoney");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNull() {
            addCriterion("CONTRACT_ID is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("CONTRACT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(String value) {
            addCriterion("CONTRACT_ID =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(String value) {
            addCriterion("CONTRACT_ID <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(String value) {
            addCriterion("CONTRACT_ID >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_ID >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(String value) {
            addCriterion("CONTRACT_ID <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_ID <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLike(String value) {
            addCriterion("CONTRACT_ID like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotLike(String value) {
            addCriterion("CONTRACT_ID not like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<String> values) {
            addCriterion("CONTRACT_ID in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<String> values) {
            addCriterion("CONTRACT_ID not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(String value1, String value2) {
            addCriterion("CONTRACT_ID between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_ID not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeIsNull() {
            addCriterion("COMMISSION_FEE is null");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeIsNotNull() {
            addCriterion("COMMISSION_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeEqualTo(BigDecimal value) {
            addCriterion("COMMISSION_FEE =", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeNotEqualTo(BigDecimal value) {
            addCriterion("COMMISSION_FEE <>", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeGreaterThan(BigDecimal value) {
            addCriterion("COMMISSION_FEE >", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMISSION_FEE >=", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeLessThan(BigDecimal value) {
            addCriterion("COMMISSION_FEE <", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMISSION_FEE <=", value, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeIn(List<BigDecimal> values) {
            addCriterion("COMMISSION_FEE in", values, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeNotIn(List<BigDecimal> values) {
            addCriterion("COMMISSION_FEE not in", values, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMISSION_FEE between", value1, value2, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andCommissionFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMISSION_FEE not between", value1, value2, "commissionFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeIsNull() {
            addCriterion("INVOICE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeIsNotNull() {
            addCriterion("INVOICE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeEqualTo(BigDecimal value) {
            addCriterion("INVOICE_FEE =", value, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("INVOICE_FEE <>", value, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeGreaterThan(BigDecimal value) {
            addCriterion("INVOICE_FEE >", value, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INVOICE_FEE >=", value, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeLessThan(BigDecimal value) {
            addCriterion("INVOICE_FEE <", value, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INVOICE_FEE <=", value, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeIn(List<BigDecimal> values) {
            addCriterion("INVOICE_FEE in", values, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("INVOICE_FEE not in", values, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVOICE_FEE between", value1, value2, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVOICE_FEE not between", value1, value2, "invoiceFee");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyIsNull() {
            addCriterion("REDEEM_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyIsNotNull() {
            addCriterion("REDEEM_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyEqualTo(BigDecimal value) {
            addCriterion("REDEEM_MONEY =", value, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyNotEqualTo(BigDecimal value) {
            addCriterion("REDEEM_MONEY <>", value, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyGreaterThan(BigDecimal value) {
            addCriterion("REDEEM_MONEY >", value, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REDEEM_MONEY >=", value, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyLessThan(BigDecimal value) {
            addCriterion("REDEEM_MONEY <", value, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REDEEM_MONEY <=", value, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyIn(List<BigDecimal> values) {
            addCriterion("REDEEM_MONEY in", values, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyNotIn(List<BigDecimal> values) {
            addCriterion("REDEEM_MONEY not in", values, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDEEM_MONEY between", value1, value2, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REDEEM_MONEY not between", value1, value2, "redeemMoney");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("NOTES is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("NOTES is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("NOTES =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("NOTES <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("NOTES >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("NOTES >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("NOTES <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("NOTES <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("NOTES like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("NOTES not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("NOTES in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("NOTES not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("NOTES between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("NOTES not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("IS_DEL is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("IS_DEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(String value) {
            addCriterion("IS_DEL =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(String value) {
            addCriterion("IS_DEL <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(String value) {
            addCriterion("IS_DEL >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DEL >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(String value) {
            addCriterion("IS_DEL <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(String value) {
            addCriterion("IS_DEL <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLike(String value) {
            addCriterion("IS_DEL like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotLike(String value) {
            addCriterion("IS_DEL not like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<String> values) {
            addCriterion("IS_DEL in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<String> values) {
            addCriterion("IS_DEL not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(String value1, String value2) {
            addCriterion("IS_DEL between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(String value1, String value2) {
            addCriterion("IS_DEL not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIsNull() {
            addCriterion("INVOICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIsNotNull() {
            addCriterion("INVOICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdEqualTo(String value) {
            addCriterion("INVOICE_ID =", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotEqualTo(String value) {
            addCriterion("INVOICE_ID <>", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThan(String value) {
            addCriterion("INVOICE_ID >", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_ID >=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThan(String value) {
            addCriterion("INVOICE_ID <", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_ID <=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLike(String value) {
            addCriterion("INVOICE_ID like", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotLike(String value) {
            addCriterion("INVOICE_ID not like", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIn(List<String> values) {
            addCriterion("INVOICE_ID in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotIn(List<String> values) {
            addCriterion("INVOICE_ID not in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdBetween(String value1, String value2) {
            addCriterion("INVOICE_ID between", value1, value2, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotBetween(String value1, String value2) {
            addCriterion("INVOICE_ID not between", value1, value2, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdIsNull() {
            addCriterion("RELATED_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelatedIdIsNotNull() {
            addCriterion("RELATED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedIdEqualTo(String value) {
            addCriterion("RELATED_ID =", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdNotEqualTo(String value) {
            addCriterion("RELATED_ID <>", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdGreaterThan(String value) {
            addCriterion("RELATED_ID >", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdGreaterThanOrEqualTo(String value) {
            addCriterion("RELATED_ID >=", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdLessThan(String value) {
            addCriterion("RELATED_ID <", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdLessThanOrEqualTo(String value) {
            addCriterion("RELATED_ID <=", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdLike(String value) {
            addCriterion("RELATED_ID like", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdNotLike(String value) {
            addCriterion("RELATED_ID not like", value, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdIn(List<String> values) {
            addCriterion("RELATED_ID in", values, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdNotIn(List<String> values) {
            addCriterion("RELATED_ID not in", values, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdBetween(String value1, String value2) {
            addCriterion("RELATED_ID between", value1, value2, "relatedId");
            return (Criteria) this;
        }

        public Criteria andRelatedIdNotBetween(String value1, String value2) {
            addCriterion("RELATED_ID not between", value1, value2, "relatedId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }
    }

    /**
     * TB_FEE_INVOICE_DETAIL
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_FEE_INVOICE_DETAIL 2018-03-01
     */
     
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}