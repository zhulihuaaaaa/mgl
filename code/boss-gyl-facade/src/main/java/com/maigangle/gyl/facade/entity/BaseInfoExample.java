package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseInfoExample {
    /**
     * TB_BASE_INFO
     */
    protected String orderByClause;

    /**
     * TB_BASE_INFO
     */
    protected boolean distinct;

    /**
     * TB_BASE_INFO
     */
    protected List<Criteria> oredCriteria;

    public BaseInfoExample() {
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
     * TB_BASE_INFO 2018-01-23
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

        public Criteria andInfoIdIsNull() {
            addCriterion("INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(String value) {
            addCriterion("INFO_ID =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(String value) {
            addCriterion("INFO_ID <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(String value) {
            addCriterion("INFO_ID >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_ID >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(String value) {
            addCriterion("INFO_ID <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(String value) {
            addCriterion("INFO_ID <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLike(String value) {
            addCriterion("INFO_ID like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotLike(String value) {
            addCriterion("INFO_ID not like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<String> values) {
            addCriterion("INFO_ID in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<String> values) {
            addCriterion("INFO_ID not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(String value1, String value2) {
            addCriterion("INFO_ID between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(String value1, String value2) {
            addCriterion("INFO_ID not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andFeeRate1IsNull() {
            addCriterion("FEE_RATE1 is null");
            return (Criteria) this;
        }

        public Criteria andFeeRate1IsNotNull() {
            addCriterion("FEE_RATE1 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRate1EqualTo(BigDecimal value) {
            addCriterion("FEE_RATE1 =", value, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1NotEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE1 <>", value, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1GreaterThan(BigDecimal value) {
            addCriterion("FEE_RATE1 >", value, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE1 >=", value, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1LessThan(BigDecimal value) {
            addCriterion("FEE_RATE1 <", value, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE1 <=", value, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1In(List<BigDecimal> values) {
            addCriterion("FEE_RATE1 in", values, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1NotIn(List<BigDecimal> values) {
            addCriterion("FEE_RATE1 not in", values, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_RATE1 between", value1, value2, "feeRate1");
            return (Criteria) this;
        }

        public Criteria andFeeRate1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_RATE1 not between", value1, value2, "feeRate1");
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

        public Criteria andOverdueReminderIsNull() {
            addCriterion("OVERDUE_REMINDER is null");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderIsNotNull() {
            addCriterion("OVERDUE_REMINDER is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderEqualTo(String value) {
            addCriterion("OVERDUE_REMINDER =", value, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderNotEqualTo(String value) {
            addCriterion("OVERDUE_REMINDER <>", value, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderGreaterThan(String value) {
            addCriterion("OVERDUE_REMINDER >", value, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderGreaterThanOrEqualTo(String value) {
            addCriterion("OVERDUE_REMINDER >=", value, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderLessThan(String value) {
            addCriterion("OVERDUE_REMINDER <", value, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderLessThanOrEqualTo(String value) {
            addCriterion("OVERDUE_REMINDER <=", value, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderLike(String value) {
            addCriterion("OVERDUE_REMINDER like", value, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderNotLike(String value) {
            addCriterion("OVERDUE_REMINDER not like", value, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderIn(List<String> values) {
            addCriterion("OVERDUE_REMINDER in", values, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderNotIn(List<String> values) {
            addCriterion("OVERDUE_REMINDER not in", values, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderBetween(String value1, String value2) {
            addCriterion("OVERDUE_REMINDER between", value1, value2, "overdueReminder");
            return (Criteria) this;
        }

        public Criteria andOverdueReminderNotBetween(String value1, String value2) {
            addCriterion("OVERDUE_REMINDER not between", value1, value2, "overdueReminder");
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

        public Criteria andVirtualMallDepotIsNull() {
            addCriterion("VIRTUAL_MALL_DEPOT is null");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotIsNotNull() {
            addCriterion("VIRTUAL_MALL_DEPOT is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotEqualTo(String value) {
            addCriterion("VIRTUAL_MALL_DEPOT =", value, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotNotEqualTo(String value) {
            addCriterion("VIRTUAL_MALL_DEPOT <>", value, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotGreaterThan(String value) {
            addCriterion("VIRTUAL_MALL_DEPOT >", value, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotGreaterThanOrEqualTo(String value) {
            addCriterion("VIRTUAL_MALL_DEPOT >=", value, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotLessThan(String value) {
            addCriterion("VIRTUAL_MALL_DEPOT <", value, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotLessThanOrEqualTo(String value) {
            addCriterion("VIRTUAL_MALL_DEPOT <=", value, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotLike(String value) {
            addCriterion("VIRTUAL_MALL_DEPOT like", value, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotNotLike(String value) {
            addCriterion("VIRTUAL_MALL_DEPOT not like", value, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotIn(List<String> values) {
            addCriterion("VIRTUAL_MALL_DEPOT in", values, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotNotIn(List<String> values) {
            addCriterion("VIRTUAL_MALL_DEPOT not in", values, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotBetween(String value1, String value2) {
            addCriterion("VIRTUAL_MALL_DEPOT between", value1, value2, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andVirtualMallDepotNotBetween(String value1, String value2) {
            addCriterion("VIRTUAL_MALL_DEPOT not between", value1, value2, "virtualMallDepot");
            return (Criteria) this;
        }

        public Criteria andFeeRate2IsNull() {
            addCriterion("FEE_RATE2 is null");
            return (Criteria) this;
        }

        public Criteria andFeeRate2IsNotNull() {
            addCriterion("FEE_RATE2 is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRate2EqualTo(BigDecimal value) {
            addCriterion("FEE_RATE2 =", value, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2NotEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE2 <>", value, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2GreaterThan(BigDecimal value) {
            addCriterion("FEE_RATE2 >", value, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE2 >=", value, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2LessThan(BigDecimal value) {
            addCriterion("FEE_RATE2 <", value, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE_RATE2 <=", value, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2In(List<BigDecimal> values) {
            addCriterion("FEE_RATE2 in", values, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2NotIn(List<BigDecimal> values) {
            addCriterion("FEE_RATE2 not in", values, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_RATE2 between", value1, value2, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andFeeRate2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE_RATE2 not between", value1, value2, "feeRate2");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("COMPANY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("COMPANY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("COMPANY_NAME =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("COMPANY_NAME <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("COMPANY_NAME >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("COMPANY_NAME <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("COMPANY_NAME like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("COMPANY_NAME not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("COMPANY_NAME in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("COMPANY_NAME not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME not between", value1, value2, "companyName");
            return (Criteria) this;
        }
    }

    /**
     * TB_BASE_INFO
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_BASE_INFO 2018-01-23
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