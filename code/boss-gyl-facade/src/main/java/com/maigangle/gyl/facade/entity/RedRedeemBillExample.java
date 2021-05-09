package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedRedeemBillExample {
    /**
     * TB_RED_REDEEM_BILL
     */
    protected String orderByClause;

    /**
     * TB_RED_REDEEM_BILL
     */
    protected boolean distinct;

    /**
     * TB_RED_REDEEM_BILL
     */
    protected List<Criteria> oredCriteria;

    public RedRedeemBillExample() {
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

        public Criteria andRedeemBillIdIsNull() {
            addCriterion("REDEEM_BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdIsNotNull() {
            addCriterion("REDEEM_BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdEqualTo(String value) {
            addCriterion("REDEEM_BILL_ID =", value, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdNotEqualTo(String value) {
            addCriterion("REDEEM_BILL_ID <>", value, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdGreaterThan(String value) {
            addCriterion("REDEEM_BILL_ID >", value, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("REDEEM_BILL_ID >=", value, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdLessThan(String value) {
            addCriterion("REDEEM_BILL_ID <", value, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdLessThanOrEqualTo(String value) {
            addCriterion("REDEEM_BILL_ID <=", value, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdLike(String value) {
            addCriterion("REDEEM_BILL_ID like", value, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdNotLike(String value) {
            addCriterion("REDEEM_BILL_ID not like", value, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdIn(List<String> values) {
            addCriterion("REDEEM_BILL_ID in", values, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdNotIn(List<String> values) {
            addCriterion("REDEEM_BILL_ID not in", values, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdBetween(String value1, String value2) {
            addCriterion("REDEEM_BILL_ID between", value1, value2, "redeemBillId");
            return (Criteria) this;
        }

        public Criteria andRedeemBillIdNotBetween(String value1, String value2) {
            addCriterion("REDEEM_BILL_ID not between", value1, value2, "redeemBillId");
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

        public Criteria andGoodsSourceIsNull() {
            addCriterion("GOODS_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceIsNotNull() {
            addCriterion("GOODS_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceEqualTo(String value) {
            addCriterion("GOODS_SOURCE =", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceNotEqualTo(String value) {
            addCriterion("GOODS_SOURCE <>", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceGreaterThan(String value) {
            addCriterion("GOODS_SOURCE >", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_SOURCE >=", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceLessThan(String value) {
            addCriterion("GOODS_SOURCE <", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceLessThanOrEqualTo(String value) {
            addCriterion("GOODS_SOURCE <=", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceLike(String value) {
            addCriterion("GOODS_SOURCE like", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceNotLike(String value) {
            addCriterion("GOODS_SOURCE not like", value, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceIn(List<String> values) {
            addCriterion("GOODS_SOURCE in", values, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceNotIn(List<String> values) {
            addCriterion("GOODS_SOURCE not in", values, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceBetween(String value1, String value2) {
            addCriterion("GOODS_SOURCE between", value1, value2, "goodsSource");
            return (Criteria) this;
        }

        public Criteria andGoodsSourceNotBetween(String value1, String value2) {
            addCriterion("GOODS_SOURCE not between", value1, value2, "goodsSource");
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

        public Criteria andTotalGoodsPaymentIsNull() {
            addCriterion("TOTAL_GOODS_PAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentIsNotNull() {
            addCriterion("TOTAL_GOODS_PAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentEqualTo(BigDecimal value) {
            addCriterion("TOTAL_GOODS_PAYMENT =", value, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_GOODS_PAYMENT <>", value, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_GOODS_PAYMENT >", value, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_GOODS_PAYMENT >=", value, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentLessThan(BigDecimal value) {
            addCriterion("TOTAL_GOODS_PAYMENT <", value, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_GOODS_PAYMENT <=", value, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentIn(List<BigDecimal> values) {
            addCriterion("TOTAL_GOODS_PAYMENT in", values, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_GOODS_PAYMENT not in", values, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_GOODS_PAYMENT between", value1, value2, "totalGoodsPayment");
            return (Criteria) this;
        }

        public Criteria andTotalGoodsPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_GOODS_PAYMENT not between", value1, value2, "totalGoodsPayment");
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

        public Criteria andDepositFeeIsNull() {
            addCriterion("DEPOSIT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andDepositFeeIsNotNull() {
            addCriterion("DEPOSIT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andDepositFeeEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_FEE =", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeNotEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_FEE <>", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeGreaterThan(BigDecimal value) {
            addCriterion("DEPOSIT_FEE >", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_FEE >=", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeLessThan(BigDecimal value) {
            addCriterion("DEPOSIT_FEE <", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_FEE <=", value, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT_FEE in", values, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeNotIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT_FEE not in", values, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT_FEE between", value1, value2, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT_FEE not between", value1, value2, "depositFee");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdIsNull() {
            addCriterion("DEPOSIT_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdIsNotNull() {
            addCriterion("DEPOSIT_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdEqualTo(String value) {
            addCriterion("DEPOSIT_DETAIL_ID =", value, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdNotEqualTo(String value) {
            addCriterion("DEPOSIT_DETAIL_ID <>", value, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdGreaterThan(String value) {
            addCriterion("DEPOSIT_DETAIL_ID >", value, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_DETAIL_ID >=", value, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdLessThan(String value) {
            addCriterion("DEPOSIT_DETAIL_ID <", value, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_DETAIL_ID <=", value, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdLike(String value) {
            addCriterion("DEPOSIT_DETAIL_ID like", value, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdNotLike(String value) {
            addCriterion("DEPOSIT_DETAIL_ID not like", value, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdIn(List<String> values) {
            addCriterion("DEPOSIT_DETAIL_ID in", values, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdNotIn(List<String> values) {
            addCriterion("DEPOSIT_DETAIL_ID not in", values, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdBetween(String value1, String value2) {
            addCriterion("DEPOSIT_DETAIL_ID between", value1, value2, "depositDetailId");
            return (Criteria) this;
        }

        public Criteria andDepositDetailIdNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_DETAIL_ID not between", value1, value2, "depositDetailId");
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

        public Criteria andAuditStatusIsNull() {
            addCriterion("AUDIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("AUDIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("AUDIT_STATUS =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("AUDIT_STATUS <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("AUDIT_STATUS >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_STATUS >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("AUDIT_STATUS <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_STATUS <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("AUDIT_STATUS like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("AUDIT_STATUS not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("AUDIT_STATUS in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("AUDIT_STATUS not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("AUDIT_STATUS between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("AUDIT_STATUS not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusIsNull() {
            addCriterion("REDEEM_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusIsNotNull() {
            addCriterion("REDEEM_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusEqualTo(String value) {
            addCriterion("REDEEM_STATUS =", value, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusNotEqualTo(String value) {
            addCriterion("REDEEM_STATUS <>", value, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusGreaterThan(String value) {
            addCriterion("REDEEM_STATUS >", value, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusGreaterThanOrEqualTo(String value) {
            addCriterion("REDEEM_STATUS >=", value, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusLessThan(String value) {
            addCriterion("REDEEM_STATUS <", value, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusLessThanOrEqualTo(String value) {
            addCriterion("REDEEM_STATUS <=", value, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusLike(String value) {
            addCriterion("REDEEM_STATUS like", value, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusNotLike(String value) {
            addCriterion("REDEEM_STATUS not like", value, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusIn(List<String> values) {
            addCriterion("REDEEM_STATUS in", values, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusNotIn(List<String> values) {
            addCriterion("REDEEM_STATUS not in", values, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusBetween(String value1, String value2) {
            addCriterion("REDEEM_STATUS between", value1, value2, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andRedeemStatusNotBetween(String value1, String value2) {
            addCriterion("REDEEM_STATUS not between", value1, value2, "redeemStatus");
            return (Criteria) this;
        }

        public Criteria andOutstockIdIsNull() {
            addCriterion("OUTSTOCK_ID is null");
            return (Criteria) this;
        }

        public Criteria andOutstockIdIsNotNull() {
            addCriterion("OUTSTOCK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOutstockIdEqualTo(String value) {
            addCriterion("OUTSTOCK_ID =", value, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdNotEqualTo(String value) {
            addCriterion("OUTSTOCK_ID <>", value, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdGreaterThan(String value) {
            addCriterion("OUTSTOCK_ID >", value, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdGreaterThanOrEqualTo(String value) {
            addCriterion("OUTSTOCK_ID >=", value, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdLessThan(String value) {
            addCriterion("OUTSTOCK_ID <", value, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdLessThanOrEqualTo(String value) {
            addCriterion("OUTSTOCK_ID <=", value, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdLike(String value) {
            addCriterion("OUTSTOCK_ID like", value, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdNotLike(String value) {
            addCriterion("OUTSTOCK_ID not like", value, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdIn(List<String> values) {
            addCriterion("OUTSTOCK_ID in", values, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdNotIn(List<String> values) {
            addCriterion("OUTSTOCK_ID not in", values, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdBetween(String value1, String value2) {
            addCriterion("OUTSTOCK_ID between", value1, value2, "outstockId");
            return (Criteria) this;
        }

        public Criteria andOutstockIdNotBetween(String value1, String value2) {
            addCriterion("OUTSTOCK_ID not between", value1, value2, "outstockId");
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

        public Criteria andRedeemBillCodeIsNull() {
            addCriterion("REDEEM_BILL_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeIsNotNull() {
            addCriterion("REDEEM_BILL_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeEqualTo(String value) {
            addCriterion("REDEEM_BILL_CODE =", value, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeNotEqualTo(String value) {
            addCriterion("REDEEM_BILL_CODE <>", value, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeGreaterThan(String value) {
            addCriterion("REDEEM_BILL_CODE >", value, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REDEEM_BILL_CODE >=", value, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeLessThan(String value) {
            addCriterion("REDEEM_BILL_CODE <", value, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeLessThanOrEqualTo(String value) {
            addCriterion("REDEEM_BILL_CODE <=", value, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeLike(String value) {
            addCriterion("REDEEM_BILL_CODE like", value, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeNotLike(String value) {
            addCriterion("REDEEM_BILL_CODE not like", value, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeIn(List<String> values) {
            addCriterion("REDEEM_BILL_CODE in", values, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeNotIn(List<String> values) {
            addCriterion("REDEEM_BILL_CODE not in", values, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeBetween(String value1, String value2) {
            addCriterion("REDEEM_BILL_CODE between", value1, value2, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andRedeemBillCodeNotBetween(String value1, String value2) {
            addCriterion("REDEEM_BILL_CODE not between", value1, value2, "redeemBillCode");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("CAR_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("CAR_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("CAR_NUMBER =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("CAR_NUMBER <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("CAR_NUMBER >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("CAR_NUMBER >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("CAR_NUMBER <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("CAR_NUMBER <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("CAR_NUMBER like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("CAR_NUMBER not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("CAR_NUMBER in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("CAR_NUMBER not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("CAR_NUMBER between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("CAR_NUMBER not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateIsNull() {
            addCriterion("REDEEM_MONEY_STATE is null");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateIsNotNull() {
            addCriterion("REDEEM_MONEY_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateEqualTo(String value) {
            addCriterion("REDEEM_MONEY_STATE =", value, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateNotEqualTo(String value) {
            addCriterion("REDEEM_MONEY_STATE <>", value, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateGreaterThan(String value) {
            addCriterion("REDEEM_MONEY_STATE >", value, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateGreaterThanOrEqualTo(String value) {
            addCriterion("REDEEM_MONEY_STATE >=", value, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateLessThan(String value) {
            addCriterion("REDEEM_MONEY_STATE <", value, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateLessThanOrEqualTo(String value) {
            addCriterion("REDEEM_MONEY_STATE <=", value, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateLike(String value) {
            addCriterion("REDEEM_MONEY_STATE like", value, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateNotLike(String value) {
            addCriterion("REDEEM_MONEY_STATE not like", value, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateIn(List<String> values) {
            addCriterion("REDEEM_MONEY_STATE in", values, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateNotIn(List<String> values) {
            addCriterion("REDEEM_MONEY_STATE not in", values, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateBetween(String value1, String value2) {
            addCriterion("REDEEM_MONEY_STATE between", value1, value2, "redeemMoneyState");
            return (Criteria) this;
        }

        public Criteria andRedeemMoneyStateNotBetween(String value1, String value2) {
            addCriterion("REDEEM_MONEY_STATE not between", value1, value2, "redeemMoneyState");
            return (Criteria) this;
        }
    }

    /**
     * TB_RED_REDEEM_BILL
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

     
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