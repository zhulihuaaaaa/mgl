package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeeInvoiceExample {
    /**
     * TB_FEE_INVOICE
     */
    protected String orderByClause;

    /**
     * TB_FEE_INVOICE
     */
    protected boolean distinct;

    /**
     * TB_FEE_INVOICE
     */
    protected List<Criteria> oredCriteria;

    public FeeInvoiceExample() {
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
     * TB_FEE_INVOICE 2018-03-01
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

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("INVOICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("INVOICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(String value) {
            addCriterion("INVOICE_TYPE =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(String value) {
            addCriterion("INVOICE_TYPE <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(String value) {
            addCriterion("INVOICE_TYPE >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_TYPE >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(String value) {
            addCriterion("INVOICE_TYPE <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_TYPE <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLike(String value) {
            addCriterion("INVOICE_TYPE like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotLike(String value) {
            addCriterion("INVOICE_TYPE not like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<String> values) {
            addCriterion("INVOICE_TYPE in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<String> values) {
            addCriterion("INVOICE_TYPE not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(String value1, String value2) {
            addCriterion("INVOICE_TYPE between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
            addCriterion("INVOICE_TYPE not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNull() {
            addCriterion("INVOICE_NO is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIsNotNull() {
            addCriterion("INVOICE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoEqualTo(String value) {
            addCriterion("INVOICE_NO =", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotEqualTo(String value) {
            addCriterion("INVOICE_NO <>", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThan(String value) {
            addCriterion("INVOICE_NO >", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_NO >=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThan(String value) {
            addCriterion("INVOICE_NO <", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_NO <=", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoLike(String value) {
            addCriterion("INVOICE_NO like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotLike(String value) {
            addCriterion("INVOICE_NO not like", value, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoIn(List<String> values) {
            addCriterion("INVOICE_NO in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotIn(List<String> values) {
            addCriterion("INVOICE_NO not in", values, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoBetween(String value1, String value2) {
            addCriterion("INVOICE_NO between", value1, value2, "invoiceNo");
            return (Criteria) this;
        }

        public Criteria andInvoiceNoNotBetween(String value1, String value2) {
            addCriterion("INVOICE_NO not between", value1, value2, "invoiceNo");
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

        public Criteria andContractIdsIsNull() {
            addCriterion("CONTRACT_IDS is null");
            return (Criteria) this;
        }

        public Criteria andContractIdsIsNotNull() {
            addCriterion("CONTRACT_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdsEqualTo(String value) {
            addCriterion("CONTRACT_IDS =", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsNotEqualTo(String value) {
            addCriterion("CONTRACT_IDS <>", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsGreaterThan(String value) {
            addCriterion("CONTRACT_IDS >", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_IDS >=", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsLessThan(String value) {
            addCriterion("CONTRACT_IDS <", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_IDS <=", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsLike(String value) {
            addCriterion("CONTRACT_IDS like", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsNotLike(String value) {
            addCriterion("CONTRACT_IDS not like", value, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsIn(List<String> values) {
            addCriterion("CONTRACT_IDS in", values, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsNotIn(List<String> values) {
            addCriterion("CONTRACT_IDS not in", values, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsBetween(String value1, String value2) {
            addCriterion("CONTRACT_IDS between", value1, value2, "contractIds");
            return (Criteria) this;
        }

        public Criteria andContractIdsNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_IDS not between", value1, value2, "contractIds");
            return (Criteria) this;
        }

        public Criteria andBillingDateIsNull() {
            addCriterion("BILLING_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillingDateIsNotNull() {
            addCriterion("BILLING_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillingDateEqualTo(Date value) {
            addCriterion("BILLING_DATE =", value, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateNotEqualTo(Date value) {
            addCriterion("BILLING_DATE <>", value, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateGreaterThan(Date value) {
            addCriterion("BILLING_DATE >", value, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("BILLING_DATE >=", value, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateLessThan(Date value) {
            addCriterion("BILLING_DATE <", value, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateLessThanOrEqualTo(Date value) {
            addCriterion("BILLING_DATE <=", value, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateIn(List<Date> values) {
            addCriterion("BILLING_DATE in", values, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateNotIn(List<Date> values) {
            addCriterion("BILLING_DATE not in", values, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateBetween(Date value1, Date value2) {
            addCriterion("BILLING_DATE between", value1, value2, "billingDate");
            return (Criteria) this;
        }

        public Criteria andBillingDateNotBetween(Date value1, Date value2) {
            addCriterion("BILLING_DATE not between", value1, value2, "billingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateIsNull() {
            addCriterion("CHECKING_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckingDateIsNotNull() {
            addCriterion("CHECKING_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckingDateEqualTo(Date value) {
            addCriterion("CHECKING_DATE =", value, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateNotEqualTo(Date value) {
            addCriterion("CHECKING_DATE <>", value, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateGreaterThan(Date value) {
            addCriterion("CHECKING_DATE >", value, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECKING_DATE >=", value, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateLessThan(Date value) {
            addCriterion("CHECKING_DATE <", value, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateLessThanOrEqualTo(Date value) {
            addCriterion("CHECKING_DATE <=", value, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateIn(List<Date> values) {
            addCriterion("CHECKING_DATE in", values, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateNotIn(List<Date> values) {
            addCriterion("CHECKING_DATE not in", values, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateBetween(Date value1, Date value2) {
            addCriterion("CHECKING_DATE between", value1, value2, "checkingDate");
            return (Criteria) this;
        }

        public Criteria andCheckingDateNotBetween(Date value1, Date value2) {
            addCriterion("CHECKING_DATE not between", value1, value2, "checkingDate");
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

        public Criteria andContractCodesIsNull() {
            addCriterion("CONTRACT_CODES is null");
            return (Criteria) this;
        }

        public Criteria andContractCodesIsNotNull() {
            addCriterion("CONTRACT_CODES is not null");
            return (Criteria) this;
        }

        public Criteria andContractCodesEqualTo(String value) {
            addCriterion("CONTRACT_CODES =", value, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesNotEqualTo(String value) {
            addCriterion("CONTRACT_CODES <>", value, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesGreaterThan(String value) {
            addCriterion("CONTRACT_CODES >", value, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesGreaterThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CODES >=", value, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesLessThan(String value) {
            addCriterion("CONTRACT_CODES <", value, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesLessThanOrEqualTo(String value) {
            addCriterion("CONTRACT_CODES <=", value, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesLike(String value) {
            addCriterion("CONTRACT_CODES like", value, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesNotLike(String value) {
            addCriterion("CONTRACT_CODES not like", value, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesIn(List<String> values) {
            addCriterion("CONTRACT_CODES in", values, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesNotIn(List<String> values) {
            addCriterion("CONTRACT_CODES not in", values, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesBetween(String value1, String value2) {
            addCriterion("CONTRACT_CODES between", value1, value2, "contractCodes");
            return (Criteria) this;
        }

        public Criteria andContractCodesNotBetween(String value1, String value2) {
            addCriterion("CONTRACT_CODES not between", value1, value2, "contractCodes");
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
    }

    /**
     * TB_FEE_INVOICE
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_FEE_INVOICE 2018-03-01
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