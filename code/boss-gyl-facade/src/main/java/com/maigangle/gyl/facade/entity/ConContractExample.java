package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConContractExample {
    /**
     * TB_CON_CONTRACT
     */
    protected String orderByClause;

    /**
     * TB_CON_CONTRACT
     */
    protected boolean distinct;

    /**
     * TB_CON_CONTRACT
     */
    protected List<Criteria> oredCriteria;

    public ConContractExample() {
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

        public Criteria andContractTypeIsNull() {
            addCriterion("CONTRACT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("CONTRACT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(String value) {
            addCriterion("CONTRACT_TYPE =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(String value) {
            addCriterion("CONTRACT_TYPE <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(String value) {
            addCriterion("CONTRACT_TYPE >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_TYPE >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(String value) {
            addCriterion("CONTRACT_TYPE <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_TYPE <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLike(String value) {
            addCriterion("CONTRACT_TYPE like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotLike(String value) {
            addCriterion("CONTRACT_TYPE not like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<String> values) {
            addCriterion("CONTRACT_TYPE in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<String> values) {
            addCriterion("CONTRACT_TYPE not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(String value1, String value2) {
            addCriterion("CONTRACT_TYPE between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_TYPE not between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdIsNull() {
            addCriterion("RELATIVE_CONTRACT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdIsNotNull() {
            addCriterion("RELATIVE_CONTRACT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdEqualTo(String value) {
            addCriterion("RELATIVE_CONTRACT_ID =", value, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdNotEqualTo(String value) {
            addCriterion("RELATIVE_CONTRACT_ID <>", value, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdGreaterThan(String value) {
            addCriterion("RELATIVE_CONTRACT_ID >", value, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("RELATIVE_CONTRACT_ID >=", value, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdLessThan(String value) {
            addCriterion("RELATIVE_CONTRACT_ID <", value, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdLessThanOrEqualTo(String value) {
            addCriterion("RELATIVE_CONTRACT_ID <=", value, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdLike(String value) {
            addCriterion("RELATIVE_CONTRACT_ID like", value, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdNotLike(String value) {
            addCriterion("RELATIVE_CONTRACT_ID not like", value, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdIn(List<String> values) {
            addCriterion("RELATIVE_CONTRACT_ID in", values, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdNotIn(List<String> values) {
            addCriterion("RELATIVE_CONTRACT_ID not in", values, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdBetween(String value1, String value2) {
            addCriterion("RELATIVE_CONTRACT_ID between", value1, value2, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andRelativeContractIdNotBetween(String value1, String value2) {
            addCriterion("RELATIVE_CONTRACT_ID not between", value1, value2, "relativeContractId");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNull() {
            addCriterion("CONTRACT_NO is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("CONTRACT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("CONTRACT_NO =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("CONTRACT_NO <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("CONTRACT_NO >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NO >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("CONTRACT_NO <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_NO <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("CONTRACT_NO like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("CONTRACT_NO not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("CONTRACT_NO in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("CONTRACT_NO not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("CONTRACT_NO between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_NO not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoIsNull() {
            addCriterion("REPURCHASE_AGREEMENT_NO is null");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoIsNotNull() {
            addCriterion("REPURCHASE_AGREEMENT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoEqualTo(String value) {
            addCriterion("REPURCHASE_AGREEMENT_NO =", value, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoNotEqualTo(String value) {
            addCriterion("REPURCHASE_AGREEMENT_NO <>", value, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoGreaterThan(String value) {
            addCriterion("REPURCHASE_AGREEMENT_NO >", value, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoGreaterThanOrEqualTo(String value) {
            addCriterion("REPURCHASE_AGREEMENT_NO >=", value, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoLessThan(String value) {
            addCriterion("REPURCHASE_AGREEMENT_NO <", value, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoLessThanOrEqualTo(String value) {
            addCriterion("REPURCHASE_AGREEMENT_NO <=", value, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoLike(String value) {
            addCriterion("REPURCHASE_AGREEMENT_NO like", value, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoNotLike(String value) {
            addCriterion("REPURCHASE_AGREEMENT_NO not like", value, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoIn(List<String> values) {
            addCriterion("REPURCHASE_AGREEMENT_NO in", values, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoNotIn(List<String> values) {
            addCriterion("REPURCHASE_AGREEMENT_NO not in", values, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoBetween(String value1, String value2) {
            addCriterion("REPURCHASE_AGREEMENT_NO between", value1, value2, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andRepurchaseAgreementNoNotBetween(String value1, String value2) {
            addCriterion("REPURCHASE_AGREEMENT_NO not between", value1, value2, "repurchaseAgreementNo");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNull() {
            addCriterion("SIGN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("SIGN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(Date value) {
            addCriterion("SIGN_DATE =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(Date value) {
            addCriterion("SIGN_DATE <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(Date value) {
            addCriterion("SIGN_DATE >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SIGN_DATE >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(Date value) {
            addCriterion("SIGN_DATE <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(Date value) {
            addCriterion("SIGN_DATE <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<Date> values) {
            addCriterion("SIGN_DATE in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<Date> values) {
            addCriterion("SIGN_DATE not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(Date value1, Date value2) {
            addCriterion("SIGN_DATE between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(Date value1, Date value2) {
            addCriterion("SIGN_DATE not between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceIsNull() {
            addCriterion("SIGING_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceIsNotNull() {
            addCriterion("SIGING_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceEqualTo(String value) {
            addCriterion("SIGING_PLACE =", value, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceNotEqualTo(String value) {
            addCriterion("SIGING_PLACE <>", value, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceGreaterThan(String value) {
            addCriterion("SIGING_PLACE >", value, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("SIGING_PLACE >=", value, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceLessThan(String value) {
            addCriterion("SIGING_PLACE <", value, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceLessThanOrEqualTo(String value) {
            addCriterion("SIGING_PLACE <=", value, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceLike(String value) {
            addCriterion("SIGING_PLACE like", value, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceNotLike(String value) {
            addCriterion("SIGING_PLACE not like", value, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceIn(List<String> values) {
            addCriterion("SIGING_PLACE in", values, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceNotIn(List<String> values) {
            addCriterion("SIGING_PLACE not in", values, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceBetween(String value1, String value2) {
            addCriterion("SIGING_PLACE between", value1, value2, "sigingPlace");
            return (Criteria) this;
        }

        public Criteria andSigingPlaceNotBetween(String value1, String value2) {
            addCriterion("SIGING_PLACE not between", value1, value2, "sigingPlace");
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

        public Criteria andSupplierInvoiceStatusIsNull() {
            addCriterion("SUPPLIER_INVOICE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusIsNotNull() {
            addCriterion("SUPPLIER_INVOICE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusEqualTo(String value) {
            addCriterion("SUPPLIER_INVOICE_STATUS =", value, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusNotEqualTo(String value) {
            addCriterion("SUPPLIER_INVOICE_STATUS <>", value, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusGreaterThan(String value) {
            addCriterion("SUPPLIER_INVOICE_STATUS >", value, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_INVOICE_STATUS >=", value, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusLessThan(String value) {
            addCriterion("SUPPLIER_INVOICE_STATUS <", value, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusLessThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_INVOICE_STATUS <=", value, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusLike(String value) {
            addCriterion("SUPPLIER_INVOICE_STATUS like", value, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusNotLike(String value) {
            addCriterion("SUPPLIER_INVOICE_STATUS not like", value, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusIn(List<String> values) {
            addCriterion("SUPPLIER_INVOICE_STATUS in", values, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusNotIn(List<String> values) {
            addCriterion("SUPPLIER_INVOICE_STATUS not in", values, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusBetween(String value1, String value2) {
            addCriterion("SUPPLIER_INVOICE_STATUS between", value1, value2, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andSupplierInvoiceStatusNotBetween(String value1, String value2) {
            addCriterion("SUPPLIER_INVOICE_STATUS not between", value1, value2, "supplierInvoiceStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNull() {
            addCriterion("DELIVERY_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIsNotNull() {
            addCriterion("DELIVERY_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS =", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS <>", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThan(String value) {
            addCriterion("DELIVERY_ADDRESS >", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS >=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThan(String value) {
            addCriterion("DELIVERY_ADDRESS <", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_ADDRESS <=", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressLike(String value) {
            addCriterion("DELIVERY_ADDRESS like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotLike(String value) {
            addCriterion("DELIVERY_ADDRESS not like", value, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressIn(List<String> values) {
            addCriterion("DELIVERY_ADDRESS in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotIn(List<String> values) {
            addCriterion("DELIVERY_ADDRESS not in", values, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressBetween(String value1, String value2) {
            addCriterion("DELIVERY_ADDRESS between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddressNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_ADDRESS not between", value1, value2, "deliveryAddress");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNull() {
            addCriterion("DELIVERY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("DELIVERY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(Date value) {
            addCriterion("DELIVERY_DATE =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(Date value) {
            addCriterion("DELIVERY_DATE <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(Date value) {
            addCriterion("DELIVERY_DATE >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("DELIVERY_DATE >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(Date value) {
            addCriterion("DELIVERY_DATE <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("DELIVERY_DATE <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<Date> values) {
            addCriterion("DELIVERY_DATE in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<Date> values) {
            addCriterion("DELIVERY_DATE not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("DELIVERY_DATE between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("DELIVERY_DATE not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNull() {
            addCriterion("DELIVERY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNotNull() {
            addCriterion("DELIVERY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeEqualTo(String value) {
            addCriterion("DELIVERY_TYPE =", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotEqualTo(String value) {
            addCriterion("DELIVERY_TYPE <>", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThan(String value) {
            addCriterion("DELIVERY_TYPE >", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_TYPE >=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThan(String value) {
            addCriterion("DELIVERY_TYPE <", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_TYPE <=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLike(String value) {
            addCriterion("DELIVERY_TYPE like", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotLike(String value) {
            addCriterion("DELIVERY_TYPE not like", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIn(List<String> values) {
            addCriterion("DELIVERY_TYPE in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotIn(List<String> values) {
            addCriterion("DELIVERY_TYPE not in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeBetween(String value1, String value2) {
            addCriterion("DELIVERY_TYPE between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_TYPE not between", value1, value2, "deliveryType");
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

        public Criteria andDepositRateIsNull() {
            addCriterion("DEPOSIT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andDepositRateIsNotNull() {
            addCriterion("DEPOSIT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andDepositRateEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_RATE =", value, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateNotEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_RATE <>", value, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateGreaterThan(BigDecimal value) {
            addCriterion("DEPOSIT_RATE >", value, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_RATE >=", value, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateLessThan(BigDecimal value) {
            addCriterion("DEPOSIT_RATE <", value, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT_RATE <=", value, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT_RATE in", values, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateNotIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT_RATE not in", values, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT_RATE between", value1, value2, "depositRate");
            return (Criteria) this;
        }

        public Criteria andDepositRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT_RATE not between", value1, value2, "depositRate");
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

        public Criteria andCommissionRateIsNull() {
            addCriterion("COMMISSION_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIsNotNull() {
            addCriterion("COMMISSION_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionRateEqualTo(BigDecimal value) {
            addCriterion("COMMISSION_RATE =", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotEqualTo(BigDecimal value) {
            addCriterion("COMMISSION_RATE <>", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateGreaterThan(BigDecimal value) {
            addCriterion("COMMISSION_RATE >", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMISSION_RATE >=", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLessThan(BigDecimal value) {
            addCriterion("COMMISSION_RATE <", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMMISSION_RATE <=", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIn(List<BigDecimal> values) {
            addCriterion("COMMISSION_RATE in", values, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotIn(List<BigDecimal> values) {
            addCriterion("COMMISSION_RATE not in", values, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMISSION_RATE between", value1, value2, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMMISSION_RATE not between", value1, value2, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeIsNull() {
            addCriterion("INVOICE_BASE_FEE is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeIsNotNull() {
            addCriterion("INVOICE_BASE_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeEqualTo(BigDecimal value) {
            addCriterion("INVOICE_BASE_FEE =", value, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeNotEqualTo(BigDecimal value) {
            addCriterion("INVOICE_BASE_FEE <>", value, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeGreaterThan(BigDecimal value) {
            addCriterion("INVOICE_BASE_FEE >", value, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INVOICE_BASE_FEE >=", value, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeLessThan(BigDecimal value) {
            addCriterion("INVOICE_BASE_FEE <", value, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INVOICE_BASE_FEE <=", value, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeIn(List<BigDecimal> values) {
            addCriterion("INVOICE_BASE_FEE in", values, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeNotIn(List<BigDecimal> values) {
            addCriterion("INVOICE_BASE_FEE not in", values, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVOICE_BASE_FEE between", value1, value2, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andInvoiceBaseFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVOICE_BASE_FEE not between", value1, value2, "invoiceBaseFee");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIsNull() {
            addCriterion("CONTRACT_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIsNotNull() {
            addCriterion("CONTRACT_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andContractPeriodEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_PERIOD =", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_PERIOD <>", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThan(BigDecimal value) {
            addCriterion("CONTRACT_PERIOD >", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_PERIOD >=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThan(BigDecimal value) {
            addCriterion("CONTRACT_PERIOD <", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTRACT_PERIOD <=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIn(List<BigDecimal> values) {
            addCriterion("CONTRACT_PERIOD in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotIn(List<BigDecimal> values) {
            addCriterion("CONTRACT_PERIOD not in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACT_PERIOD between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTRACT_PERIOD not between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractStateIsNull() {
            addCriterion("CONTRACT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andContractStateIsNotNull() {
            addCriterion("CONTRACT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andContractStateEqualTo(String value) {
            addCriterion("CONTRACT_STATE =", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateNotEqualTo(String value) {
            addCriterion("CONTRACT_STATE <>", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateGreaterThan(String value) {
            addCriterion("CONTRACT_STATE >", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_STATE >=", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateLessThan(String value) {
            addCriterion("CONTRACT_STATE <", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_STATE <=", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateLike(String value) {
            addCriterion("CONTRACT_STATE like", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateNotLike(String value) {
            addCriterion("CONTRACT_STATE not like", value, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateIn(List<String> values) {
            addCriterion("CONTRACT_STATE in", values, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateNotIn(List<String> values) {
            addCriterion("CONTRACT_STATE not in", values, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateBetween(String value1, String value2) {
            addCriterion("CONTRACT_STATE between", value1, value2, "contractState");
            return (Criteria) this;
        }

        public Criteria andContractStateNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_STATE not between", value1, value2, "contractState");
            return (Criteria) this;
        }

        public Criteria andArchivedIsNull() {
            addCriterion("ARCHIVED is null");
            return (Criteria) this;
        }

        public Criteria andArchivedIsNotNull() {
            addCriterion("ARCHIVED is not null");
            return (Criteria) this;
        }

        public Criteria andArchivedEqualTo(String value) {
            addCriterion("ARCHIVED =", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotEqualTo(String value) {
            addCriterion("ARCHIVED <>", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedGreaterThan(String value) {
            addCriterion("ARCHIVED >", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedGreaterThanOrEqualTo(String value) {
            addCriterion("ARCHIVED >=", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedLessThan(String value) {
            addCriterion("ARCHIVED <", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedLessThanOrEqualTo(String value) {
            addCriterion("ARCHIVED <=", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedLike(String value) {
            addCriterion("ARCHIVED like", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotLike(String value) {
            addCriterion("ARCHIVED not like", value, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedIn(List<String> values) {
            addCriterion("ARCHIVED in", values, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotIn(List<String> values) {
            addCriterion("ARCHIVED not in", values, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedBetween(String value1, String value2) {
            addCriterion("ARCHIVED between", value1, value2, "archived");
            return (Criteria) this;
        }

        public Criteria andArchivedNotBetween(String value1, String value2) {
            addCriterion("ARCHIVED not between", value1, value2, "archived");
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

        public Criteria andContractCodeIsNull() {
            addCriterion("CONTRACT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContractCodeIsNotNull() {
            addCriterion("CONTRACT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContractCodeEqualTo(String value) {
            addCriterion("CONTRACT_CODE =", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotEqualTo(String value) {
            addCriterion("CONTRACT_CODE <>", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThan(String value) {
            addCriterion("CONTRACT_CODE >", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CODE >=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThan(String value) {
            addCriterion("CONTRACT_CODE <", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CODE <=", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeLike(String value) {
            addCriterion("CONTRACT_CODE like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotLike(String value) {
            addCriterion("CONTRACT_CODE not like", value, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeIn(List<String> values) {
            addCriterion("CONTRACT_CODE in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotIn(List<String> values) {
            addCriterion("CONTRACT_CODE not in", values, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeBetween(String value1, String value2) {
            addCriterion("CONTRACT_CODE between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andContractCodeNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_CODE not between", value1, value2, "contractCode");
            return (Criteria) this;
        }

        public Criteria andMallMnfctIsNull() {
            addCriterion("MALL_MNFCT is null");
            return (Criteria) this;
        }

        public Criteria andMallMnfctIsNotNull() {
            addCriterion("MALL_MNFCT is not null");
            return (Criteria) this;
        }

        public Criteria andMallMnfctEqualTo(String value) {
            addCriterion("MALL_MNFCT =", value, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctNotEqualTo(String value) {
            addCriterion("MALL_MNFCT <>", value, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctGreaterThan(String value) {
            addCriterion("MALL_MNFCT >", value, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctGreaterThanOrEqualTo(String value) {
            addCriterion("MALL_MNFCT >=", value, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctLessThan(String value) {
            addCriterion("MALL_MNFCT <", value, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctLessThanOrEqualTo(String value) {
            addCriterion("MALL_MNFCT <=", value, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctLike(String value) {
            addCriterion("MALL_MNFCT like", value, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctNotLike(String value) {
            addCriterion("MALL_MNFCT not like", value, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctIn(List<String> values) {
            addCriterion("MALL_MNFCT in", values, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctNotIn(List<String> values) {
            addCriterion("MALL_MNFCT not in", values, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctBetween(String value1, String value2) {
            addCriterion("MALL_MNFCT between", value1, value2, "mallMnfct");
            return (Criteria) this;
        }

        public Criteria andMallMnfctNotBetween(String value1, String value2) {
            addCriterion("MALL_MNFCT not between", value1, value2, "mallMnfct");
            return (Criteria) this;
        }
    }

    /**
     * TB_CON_CONTRACT
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