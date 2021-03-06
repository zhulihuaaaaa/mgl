package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConContractDetailExample {
    /**
     * TB_CON_CONTRACT_DETAIL
     */
    protected String orderByClause;

    /**
     * TB_CON_CONTRACT_DETAIL
     */
    protected boolean distinct;

    /**
     * TB_CON_CONTRACT_DETAIL
     */
    protected List<Criteria> oredCriteria;

    public ConContractDetailExample() {
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
     * TB_CON_CONTRACT_DETAIL 2018-02-02
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

        public Criteria andContractDetailIdIsNull() {
            addCriterion("CONTRACT_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdIsNotNull() {
            addCriterion("CONTRACT_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdEqualTo(String value) {
            addCriterion("CONTRACT_DETAIL_ID =", value, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdNotEqualTo(String value) {
            addCriterion("CONTRACT_DETAIL_ID <>", value, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdGreaterThan(String value) {
            addCriterion("CONTRACT_DETAIL_ID >", value, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_DETAIL_ID >=", value, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdLessThan(String value) {
            addCriterion("CONTRACT_DETAIL_ID <", value, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_DETAIL_ID <=", value, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdLike(String value) {
            addCriterion("CONTRACT_DETAIL_ID like", value, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdNotLike(String value) {
            addCriterion("CONTRACT_DETAIL_ID not like", value, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdIn(List<String> values) {
            addCriterion("CONTRACT_DETAIL_ID in", values, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdNotIn(List<String> values) {
            addCriterion("CONTRACT_DETAIL_ID not in", values, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdBetween(String value1, String value2) {
            addCriterion("CONTRACT_DETAIL_ID between", value1, value2, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andContractDetailIdNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_DETAIL_ID not between", value1, value2, "contractDetailId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNull() {
            addCriterion("SELLER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("SELLER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("SELLER_ID =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("SELLER_ID <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("SELLER_ID >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_ID >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("SELLER_ID <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("SELLER_ID <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("SELLER_ID like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("SELLER_ID not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("SELLER_ID in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("SELLER_ID not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("SELLER_ID between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("SELLER_ID not between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNull() {
            addCriterion("BUYER_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNotNull() {
            addCriterion("BUYER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdEqualTo(String value) {
            addCriterion("BUYER_ID =", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotEqualTo(String value) {
            addCriterion("BUYER_ID <>", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThan(String value) {
            addCriterion("BUYER_ID >", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUYER_ID >=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThan(String value) {
            addCriterion("BUYER_ID <", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThanOrEqualTo(String value) {
            addCriterion("BUYER_ID <=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLike(String value) {
            addCriterion("BUYER_ID like", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotLike(String value) {
            addCriterion("BUYER_ID not like", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIn(List<String> values) {
            addCriterion("BUYER_ID in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotIn(List<String> values) {
            addCriterion("BUYER_ID not in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdBetween(String value1, String value2) {
            addCriterion("BUYER_ID between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotBetween(String value1, String value2) {
            addCriterion("BUYER_ID not between", value1, value2, "buyerId");
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

        public Criteria andStorageDateIsNull() {
            addCriterion("STORAGE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStorageDateIsNotNull() {
            addCriterion("STORAGE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStorageDateEqualTo(Date value) {
            addCriterion("STORAGE_DATE =", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotEqualTo(Date value) {
            addCriterion("STORAGE_DATE <>", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateGreaterThan(Date value) {
            addCriterion("STORAGE_DATE >", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateGreaterThanOrEqualTo(Date value) {
            addCriterion("STORAGE_DATE >=", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateLessThan(Date value) {
            addCriterion("STORAGE_DATE <", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateLessThanOrEqualTo(Date value) {
            addCriterion("STORAGE_DATE <=", value, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateIn(List<Date> values) {
            addCriterion("STORAGE_DATE in", values, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotIn(List<Date> values) {
            addCriterion("STORAGE_DATE not in", values, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateBetween(Date value1, Date value2) {
            addCriterion("STORAGE_DATE between", value1, value2, "storageDate");
            return (Criteria) this;
        }

        public Criteria andStorageDateNotBetween(Date value1, Date value2) {
            addCriterion("STORAGE_DATE not between", value1, value2, "storageDate");
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

        public Criteria andGoodsVolumeIsNull() {
            addCriterion("GOODS_VOLUME is null");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeIsNotNull() {
            addCriterion("GOODS_VOLUME is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeEqualTo(String value) {
            addCriterion("GOODS_VOLUME =", value, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeNotEqualTo(String value) {
            addCriterion("GOODS_VOLUME <>", value, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeGreaterThan(String value) {
            addCriterion("GOODS_VOLUME >", value, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_VOLUME >=", value, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeLessThan(String value) {
            addCriterion("GOODS_VOLUME <", value, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeLessThanOrEqualTo(String value) {
            addCriterion("GOODS_VOLUME <=", value, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeLike(String value) {
            addCriterion("GOODS_VOLUME like", value, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeNotLike(String value) {
            addCriterion("GOODS_VOLUME not like", value, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeIn(List<String> values) {
            addCriterion("GOODS_VOLUME in", values, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeNotIn(List<String> values) {
            addCriterion("GOODS_VOLUME not in", values, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeBetween(String value1, String value2) {
            addCriterion("GOODS_VOLUME between", value1, value2, "goodsVolume");
            return (Criteria) this;
        }

        public Criteria andGoodsVolumeNotBetween(String value1, String value2) {
            addCriterion("GOODS_VOLUME not between", value1, value2, "goodsVolume");
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

        public Criteria andGoodsRankIsNull() {
            addCriterion("GOODS_RANK is null");
            return (Criteria) this;
        }

        public Criteria andGoodsRankIsNotNull() {
            addCriterion("GOODS_RANK is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsRankEqualTo(String value) {
            addCriterion("GOODS_RANK =", value, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankNotEqualTo(String value) {
            addCriterion("GOODS_RANK <>", value, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankGreaterThan(String value) {
            addCriterion("GOODS_RANK >", value, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_RANK >=", value, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankLessThan(String value) {
            addCriterion("GOODS_RANK <", value, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankLessThanOrEqualTo(String value) {
            addCriterion("GOODS_RANK <=", value, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankLike(String value) {
            addCriterion("GOODS_RANK like", value, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankNotLike(String value) {
            addCriterion("GOODS_RANK not like", value, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankIn(List<String> values) {
            addCriterion("GOODS_RANK in", values, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankNotIn(List<String> values) {
            addCriterion("GOODS_RANK not in", values, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankBetween(String value1, String value2) {
            addCriterion("GOODS_RANK between", value1, value2, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andGoodsRankNotBetween(String value1, String value2) {
            addCriterion("GOODS_RANK not between", value1, value2, "goodsRank");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceIsNull() {
            addCriterion("UNIT_CONTRACT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceIsNotNull() {
            addCriterion("UNIT_CONTRACT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceEqualTo(BigDecimal value) {
            addCriterion("UNIT_CONTRACT_PRICE =", value, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceNotEqualTo(BigDecimal value) {
            addCriterion("UNIT_CONTRACT_PRICE <>", value, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceGreaterThan(BigDecimal value) {
            addCriterion("UNIT_CONTRACT_PRICE >", value, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT_CONTRACT_PRICE >=", value, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceLessThan(BigDecimal value) {
            addCriterion("UNIT_CONTRACT_PRICE <", value, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT_CONTRACT_PRICE <=", value, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceIn(List<BigDecimal> values) {
            addCriterion("UNIT_CONTRACT_PRICE in", values, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceNotIn(List<BigDecimal> values) {
            addCriterion("UNIT_CONTRACT_PRICE not in", values, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT_CONTRACT_PRICE between", value1, value2, "unitContractPrice");
            return (Criteria) this;
        }

        public Criteria andUnitContractPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT_CONTRACT_PRICE not between", value1, value2, "unitContractPrice");
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

        public Criteria andFloatPriceIsNull() {
            addCriterion("FLOAT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andFloatPriceIsNotNull() {
            addCriterion("FLOAT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andFloatPriceEqualTo(BigDecimal value) {
            addCriterion("FLOAT_PRICE =", value, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceNotEqualTo(BigDecimal value) {
            addCriterion("FLOAT_PRICE <>", value, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceGreaterThan(BigDecimal value) {
            addCriterion("FLOAT_PRICE >", value, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLOAT_PRICE >=", value, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceLessThan(BigDecimal value) {
            addCriterion("FLOAT_PRICE <", value, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLOAT_PRICE <=", value, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceIn(List<BigDecimal> values) {
            addCriterion("FLOAT_PRICE in", values, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceNotIn(List<BigDecimal> values) {
            addCriterion("FLOAT_PRICE not in", values, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLOAT_PRICE between", value1, value2, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andFloatPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLOAT_PRICE not between", value1, value2, "floatPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceIsNull() {
            addCriterion("BASIC_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBasicPriceIsNotNull() {
            addCriterion("BASIC_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBasicPriceEqualTo(BigDecimal value) {
            addCriterion("BASIC_PRICE =", value, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceNotEqualTo(BigDecimal value) {
            addCriterion("BASIC_PRICE <>", value, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceGreaterThan(BigDecimal value) {
            addCriterion("BASIC_PRICE >", value, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASIC_PRICE >=", value, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceLessThan(BigDecimal value) {
            addCriterion("BASIC_PRICE <", value, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASIC_PRICE <=", value, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceIn(List<BigDecimal> values) {
            addCriterion("BASIC_PRICE in", values, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceNotIn(List<BigDecimal> values) {
            addCriterion("BASIC_PRICE not in", values, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASIC_PRICE between", value1, value2, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andBasicPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASIC_PRICE not between", value1, value2, "basicPrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceIsNull() {
            addCriterion("STORE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andStorePriceIsNotNull() {
            addCriterion("STORE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andStorePriceEqualTo(BigDecimal value) {
            addCriterion("STORE_PRICE =", value, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceNotEqualTo(BigDecimal value) {
            addCriterion("STORE_PRICE <>", value, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceGreaterThan(BigDecimal value) {
            addCriterion("STORE_PRICE >", value, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STORE_PRICE >=", value, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceLessThan(BigDecimal value) {
            addCriterion("STORE_PRICE <", value, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STORE_PRICE <=", value, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceIn(List<BigDecimal> values) {
            addCriterion("STORE_PRICE in", values, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceNotIn(List<BigDecimal> values) {
            addCriterion("STORE_PRICE not in", values, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORE_PRICE between", value1, value2, "storePrice");
            return (Criteria) this;
        }

        public Criteria andStorePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORE_PRICE not between", value1, value2, "storePrice");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityIsNull() {
            addCriterion("NEXT_UNLOCK_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityIsNotNull() {
            addCriterion("NEXT_UNLOCK_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityEqualTo(BigDecimal value) {
            addCriterion("NEXT_UNLOCK_QUANTITY =", value, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityNotEqualTo(BigDecimal value) {
            addCriterion("NEXT_UNLOCK_QUANTITY <>", value, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityGreaterThan(BigDecimal value) {
            addCriterion("NEXT_UNLOCK_QUANTITY >", value, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NEXT_UNLOCK_QUANTITY >=", value, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityLessThan(BigDecimal value) {
            addCriterion("NEXT_UNLOCK_QUANTITY <", value, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NEXT_UNLOCK_QUANTITY <=", value, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityIn(List<BigDecimal> values) {
            addCriterion("NEXT_UNLOCK_QUANTITY in", values, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityNotIn(List<BigDecimal> values) {
            addCriterion("NEXT_UNLOCK_QUANTITY not in", values, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEXT_UNLOCK_QUANTITY between", value1, value2, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextUnlockQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEXT_UNLOCK_QUANTITY not between", value1, value2, "nextUnlockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityIsNull() {
            addCriterion("NEXT_OUTSTOCK_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityIsNotNull() {
            addCriterion("NEXT_OUTSTOCK_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityEqualTo(BigDecimal value) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY =", value, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityNotEqualTo(BigDecimal value) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY <>", value, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityGreaterThan(BigDecimal value) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY >", value, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY >=", value, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityLessThan(BigDecimal value) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY <", value, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY <=", value, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityIn(List<BigDecimal> values) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY in", values, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityNotIn(List<BigDecimal> values) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY not in", values, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY between", value1, value2, "nextOutstockQuantity");
            return (Criteria) this;
        }

        public Criteria andNextOutstockQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEXT_OUTSTOCK_QUANTITY not between", value1, value2, "nextOutstockQuantity");
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

        public Criteria andBoreIsNull() {
            addCriterion("BORE is null");
            return (Criteria) this;
        }

        public Criteria andBoreIsNotNull() {
            addCriterion("BORE is not null");
            return (Criteria) this;
        }

        public Criteria andBoreEqualTo(BigDecimal value) {
            addCriterion("BORE =", value, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreNotEqualTo(BigDecimal value) {
            addCriterion("BORE <>", value, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreGreaterThan(BigDecimal value) {
            addCriterion("BORE >", value, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BORE >=", value, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreLessThan(BigDecimal value) {
            addCriterion("BORE <", value, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BORE <=", value, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreIn(List<BigDecimal> values) {
            addCriterion("BORE in", values, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreNotIn(List<BigDecimal> values) {
            addCriterion("BORE not in", values, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BORE between", value1, value2, "bore");
            return (Criteria) this;
        }

        public Criteria andBoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BORE not between", value1, value2, "bore");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNull() {
            addCriterion("ORDER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("ORDER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("ORDER_CODE =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("ORDER_CODE <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("ORDER_CODE >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_CODE >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("ORDER_CODE <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_CODE <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("ORDER_CODE like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("ORDER_CODE not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("ORDER_CODE in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("ORDER_CODE not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("ORDER_CODE between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("ORDER_CODE not between", value1, value2, "orderCode");
            return (Criteria) this;
        }
    }

    /**
     * TB_CON_CONTRACT_DETAIL
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_CON_CONTRACT_DETAIL 2018-02-02
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