package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutOutstockBillExample {
    /**
     * TB_OUT_OUTSTOCK_BILL
     */
    protected String orderByClause;

    /**
     * TB_OUT_OUTSTOCK_BILL
     */
    protected boolean distinct;

    /**
     * TB_OUT_OUTSTOCK_BILL
     */
    protected List<Criteria> oredCriteria;

    public OutOutstockBillExample() {
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
     * TB_OUT_OUTSTOCK_BILL 2018-02-24
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

        public Criteria andOutstockBillIdIsNull() {
            addCriterion("OUTSTOCK_BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdIsNotNull() {
            addCriterion("OUTSTOCK_BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdEqualTo(String value) {
            addCriterion("OUTSTOCK_BILL_ID =", value, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdNotEqualTo(String value) {
            addCriterion("OUTSTOCK_BILL_ID <>", value, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdGreaterThan(String value) {
            addCriterion("OUTSTOCK_BILL_ID >", value, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("OUTSTOCK_BILL_ID >=", value, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdLessThan(String value) {
            addCriterion("OUTSTOCK_BILL_ID <", value, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdLessThanOrEqualTo(String value) {
            addCriterion("OUTSTOCK_BILL_ID <=", value, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdLike(String value) {
            addCriterion("OUTSTOCK_BILL_ID like", value, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdNotLike(String value) {
            addCriterion("OUTSTOCK_BILL_ID not like", value, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdIn(List<String> values) {
            addCriterion("OUTSTOCK_BILL_ID in", values, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdNotIn(List<String> values) {
            addCriterion("OUTSTOCK_BILL_ID not in", values, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdBetween(String value1, String value2) {
            addCriterion("OUTSTOCK_BILL_ID between", value1, value2, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockBillIdNotBetween(String value1, String value2) {
            addCriterion("OUTSTOCK_BILL_ID not between", value1, value2, "outstockBillId");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeIsNull() {
            addCriterion("OUTSTOCK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeIsNotNull() {
            addCriterion("OUTSTOCK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeEqualTo(String value) {
            addCriterion("OUTSTOCK_CODE =", value, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeNotEqualTo(String value) {
            addCriterion("OUTSTOCK_CODE <>", value, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeGreaterThan(String value) {
            addCriterion("OUTSTOCK_CODE >", value, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("OUTSTOCK_CODE >=", value, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeLessThan(String value) {
            addCriterion("OUTSTOCK_CODE <", value, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeLessThanOrEqualTo(String value) {
            addCriterion("OUTSTOCK_CODE <=", value, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeLike(String value) {
            addCriterion("OUTSTOCK_CODE like", value, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeNotLike(String value) {
            addCriterion("OUTSTOCK_CODE not like", value, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeIn(List<String> values) {
            addCriterion("OUTSTOCK_CODE in", values, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeNotIn(List<String> values) {
            addCriterion("OUTSTOCK_CODE not in", values, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeBetween(String value1, String value2) {
            addCriterion("OUTSTOCK_CODE between", value1, value2, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andOutstockCodeNotBetween(String value1, String value2) {
            addCriterion("OUTSTOCK_CODE not between", value1, value2, "outstockCode");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("BUSINESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("BUSINESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("BUSINESS_TYPE =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("BUSINESS_TYPE >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("BUSINESS_TYPE <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("BUSINESS_TYPE like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("BUSINESS_TYPE not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("BUSINESS_TYPE in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("BUSINESS_TYPE not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("CUSTOMER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("CUSTOMER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(String value) {
            addCriterion("CUSTOMER_ID =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(String value) {
            addCriterion("CUSTOMER_ID <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(String value) {
            addCriterion("CUSTOMER_ID >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_ID >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(String value) {
            addCriterion("CUSTOMER_ID <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_ID <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLike(String value) {
            addCriterion("CUSTOMER_ID like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotLike(String value) {
            addCriterion("CUSTOMER_ID not like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<String> values) {
            addCriterion("CUSTOMER_ID in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<String> values) {
            addCriterion("CUSTOMER_ID not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(String value1, String value2) {
            addCriterion("CUSTOMER_ID between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_ID not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("SUPPLIER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("SUPPLIER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(String value) {
            addCriterion("SUPPLIER_ID =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(String value) {
            addCriterion("SUPPLIER_ID <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(String value) {
            addCriterion("SUPPLIER_ID >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_ID >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(String value) {
            addCriterion("SUPPLIER_ID <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_ID <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLike(String value) {
            addCriterion("SUPPLIER_ID like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotLike(String value) {
            addCriterion("SUPPLIER_ID not like", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<String> values) {
            addCriterion("SUPPLIER_ID in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<String> values) {
            addCriterion("SUPPLIER_ID not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(String value1, String value2) {
            addCriterion("SUPPLIER_ID between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(String value1, String value2) {
            addCriterion("SUPPLIER_ID not between", value1, value2, "supplierId");
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

        public Criteria andTotalWeightIsNull() {
            addCriterion("TOTAL_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andTotalWeightIsNotNull() {
            addCriterion("TOTAL_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalWeightEqualTo(BigDecimal value) {
            addCriterion("TOTAL_WEIGHT =", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_WEIGHT <>", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_WEIGHT >", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_WEIGHT >=", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightLessThan(BigDecimal value) {
            addCriterion("TOTAL_WEIGHT <", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_WEIGHT <=", value, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightIn(List<BigDecimal> values) {
            addCriterion("TOTAL_WEIGHT in", values, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_WEIGHT not in", values, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_WEIGHT between", value1, value2, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andTotalWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_WEIGHT not between", value1, value2, "totalWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentIsNull() {
            addCriterion("GOODS_PAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentIsNotNull() {
            addCriterion("GOODS_PAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentEqualTo(BigDecimal value) {
            addCriterion("GOODS_PAYMENT =", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentNotEqualTo(BigDecimal value) {
            addCriterion("GOODS_PAYMENT <>", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentGreaterThan(BigDecimal value) {
            addCriterion("GOODS_PAYMENT >", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_PAYMENT >=", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentLessThan(BigDecimal value) {
            addCriterion("GOODS_PAYMENT <", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_PAYMENT <=", value, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentIn(List<BigDecimal> values) {
            addCriterion("GOODS_PAYMENT in", values, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentNotIn(List<BigDecimal> values) {
            addCriterion("GOODS_PAYMENT not in", values, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_PAYMENT between", value1, value2, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andGoodsPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_PAYMENT not between", value1, value2, "goodsPayment");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNull() {
            addCriterion("SERVICE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("SERVICE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("SERVICE_FEE >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(BigDecimal value) {
            addCriterion("SERVICE_FEE <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SERVICE_FEE <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<BigDecimal> values) {
            addCriterion("SERVICE_FEE in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("SERVICE_FEE not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SERVICE_FEE between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SERVICE_FEE not between", value1, value2, "serviceFee");
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

        public Criteria andOtherFeeIsNull() {
            addCriterion("OTHER_FEE is null");
            return (Criteria) this;
        }

        public Criteria andOtherFeeIsNotNull() {
            addCriterion("OTHER_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFeeEqualTo(BigDecimal value) {
            addCriterion("OTHER_FEE =", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotEqualTo(BigDecimal value) {
            addCriterion("OTHER_FEE <>", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeGreaterThan(BigDecimal value) {
            addCriterion("OTHER_FEE >", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OTHER_FEE >=", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeLessThan(BigDecimal value) {
            addCriterion("OTHER_FEE <", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OTHER_FEE <=", value, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeIn(List<BigDecimal> values) {
            addCriterion("OTHER_FEE in", values, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotIn(List<BigDecimal> values) {
            addCriterion("OTHER_FEE not in", values, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OTHER_FEE between", value1, value2, "otherFee");
            return (Criteria) this;
        }

        public Criteria andOtherFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OTHER_FEE not between", value1, value2, "otherFee");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("TOTAL_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("TOTAL_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MONEY =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MONEY <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_MONEY >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MONEY >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("TOTAL_MONEY <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_MONEY <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("TOTAL_MONEY in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_MONEY not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_MONEY between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_MONEY not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andConsigneeIsNull() {
            addCriterion("CONSIGNEE is null");
            return (Criteria) this;
        }

        public Criteria andConsigneeIsNotNull() {
            addCriterion("CONSIGNEE is not null");
            return (Criteria) this;
        }

        public Criteria andConsigneeEqualTo(String value) {
            addCriterion("CONSIGNEE =", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotEqualTo(String value) {
            addCriterion("CONSIGNEE <>", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeGreaterThan(String value) {
            addCriterion("CONSIGNEE >", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeGreaterThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE >=", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLessThan(String value) {
            addCriterion("CONSIGNEE <", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLessThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE <=", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLike(String value) {
            addCriterion("CONSIGNEE like", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotLike(String value) {
            addCriterion("CONSIGNEE not like", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeIn(List<String> values) {
            addCriterion("CONSIGNEE in", values, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotIn(List<String> values) {
            addCriterion("CONSIGNEE not in", values, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeBetween(String value1, String value2) {
            addCriterion("CONSIGNEE between", value1, value2, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotBetween(String value1, String value2) {
            addCriterion("CONSIGNEE not between", value1, value2, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelIsNull() {
            addCriterion("CONSIGNEE_TEL is null");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelIsNotNull() {
            addCriterion("CONSIGNEE_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelEqualTo(String value) {
            addCriterion("CONSIGNEE_TEL =", value, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelNotEqualTo(String value) {
            addCriterion("CONSIGNEE_TEL <>", value, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelGreaterThan(String value) {
            addCriterion("CONSIGNEE_TEL >", value, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelGreaterThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE_TEL >=", value, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelLessThan(String value) {
            addCriterion("CONSIGNEE_TEL <", value, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelLessThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE_TEL <=", value, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelLike(String value) {
            addCriterion("CONSIGNEE_TEL like", value, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelNotLike(String value) {
            addCriterion("CONSIGNEE_TEL not like", value, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelIn(List<String> values) {
            addCriterion("CONSIGNEE_TEL in", values, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelNotIn(List<String> values) {
            addCriterion("CONSIGNEE_TEL not in", values, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelBetween(String value1, String value2) {
            addCriterion("CONSIGNEE_TEL between", value1, value2, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeTelNotBetween(String value1, String value2) {
            addCriterion("CONSIGNEE_TEL not between", value1, value2, "consigneeTel");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoIsNull() {
            addCriterion("CONSIGNEE_ID_NO is null");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoIsNotNull() {
            addCriterion("CONSIGNEE_ID_NO is not null");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoEqualTo(String value) {
            addCriterion("CONSIGNEE_ID_NO =", value, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoNotEqualTo(String value) {
            addCriterion("CONSIGNEE_ID_NO <>", value, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoGreaterThan(String value) {
            addCriterion("CONSIGNEE_ID_NO >", value, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE_ID_NO >=", value, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoLessThan(String value) {
            addCriterion("CONSIGNEE_ID_NO <", value, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoLessThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE_ID_NO <=", value, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoLike(String value) {
            addCriterion("CONSIGNEE_ID_NO like", value, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoNotLike(String value) {
            addCriterion("CONSIGNEE_ID_NO not like", value, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoIn(List<String> values) {
            addCriterion("CONSIGNEE_ID_NO in", values, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoNotIn(List<String> values) {
            addCriterion("CONSIGNEE_ID_NO not in", values, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoBetween(String value1, String value2) {
            addCriterion("CONSIGNEE_ID_NO between", value1, value2, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andConsigneeIdNoNotBetween(String value1, String value2) {
            addCriterion("CONSIGNEE_ID_NO not between", value1, value2, "consigneeIdNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
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

        public Criteria andChargingDaysIsNull() {
            addCriterion("CHARGING_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andChargingDaysIsNotNull() {
            addCriterion("CHARGING_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andChargingDaysEqualTo(BigDecimal value) {
            addCriterion("CHARGING_DAYS =", value, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysNotEqualTo(BigDecimal value) {
            addCriterion("CHARGING_DAYS <>", value, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysGreaterThan(BigDecimal value) {
            addCriterion("CHARGING_DAYS >", value, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGING_DAYS >=", value, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysLessThan(BigDecimal value) {
            addCriterion("CHARGING_DAYS <", value, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGING_DAYS <=", value, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysIn(List<BigDecimal> values) {
            addCriterion("CHARGING_DAYS in", values, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysNotIn(List<BigDecimal> values) {
            addCriterion("CHARGING_DAYS not in", values, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGING_DAYS between", value1, value2, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andChargingDaysNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGING_DAYS not between", value1, value2, "chargingDays");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarIsNull() {
            addCriterion("CONSIGNEE_CAR is null");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarIsNotNull() {
            addCriterion("CONSIGNEE_CAR is not null");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarEqualTo(String value) {
            addCriterion("CONSIGNEE_CAR =", value, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarNotEqualTo(String value) {
            addCriterion("CONSIGNEE_CAR <>", value, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarGreaterThan(String value) {
            addCriterion("CONSIGNEE_CAR >", value, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarGreaterThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE_CAR >=", value, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarLessThan(String value) {
            addCriterion("CONSIGNEE_CAR <", value, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarLessThanOrEqualTo(String value) {
            addCriterion("CONSIGNEE_CAR <=", value, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarLike(String value) {
            addCriterion("CONSIGNEE_CAR like", value, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarNotLike(String value) {
            addCriterion("CONSIGNEE_CAR not like", value, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarIn(List<String> values) {
            addCriterion("CONSIGNEE_CAR in", values, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarNotIn(List<String> values) {
            addCriterion("CONSIGNEE_CAR not in", values, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarBetween(String value1, String value2) {
            addCriterion("CONSIGNEE_CAR between", value1, value2, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andConsigneeCarNotBetween(String value1, String value2) {
            addCriterion("CONSIGNEE_CAR not between", value1, value2, "consigneeCar");
            return (Criteria) this;
        }

        public Criteria andOutstockStateIsNull() {
            addCriterion("OUTSTOCK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andOutstockStateIsNotNull() {
            addCriterion("OUTSTOCK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andOutstockStateEqualTo(String value) {
            addCriterion("OUTSTOCK_STATE =", value, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateNotEqualTo(String value) {
            addCriterion("OUTSTOCK_STATE <>", value, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateGreaterThan(String value) {
            addCriterion("OUTSTOCK_STATE >", value, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateGreaterThanOrEqualTo(String value) {
            addCriterion("OUTSTOCK_STATE >=", value, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateLessThan(String value) {
            addCriterion("OUTSTOCK_STATE <", value, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateLessThanOrEqualTo(String value) {
            addCriterion("OUTSTOCK_STATE <=", value, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateLike(String value) {
            addCriterion("OUTSTOCK_STATE like", value, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateNotLike(String value) {
            addCriterion("OUTSTOCK_STATE not like", value, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateIn(List<String> values) {
            addCriterion("OUTSTOCK_STATE in", values, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateNotIn(List<String> values) {
            addCriterion("OUTSTOCK_STATE not in", values, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateBetween(String value1, String value2) {
            addCriterion("OUTSTOCK_STATE between", value1, value2, "outstockState");
            return (Criteria) this;
        }

        public Criteria andOutstockStateNotBetween(String value1, String value2) {
            addCriterion("OUTSTOCK_STATE not between", value1, value2, "outstockState");
            return (Criteria) this;
        }
    }

    /**
     * TB_OUT_OUTSTOCK_BILL
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_OUT_OUTSTOCK_BILL 2018-02-24
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