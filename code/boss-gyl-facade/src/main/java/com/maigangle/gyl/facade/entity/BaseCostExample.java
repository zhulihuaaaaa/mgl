package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseCostExample {
    /**
     * TB_BASE_COST
     */
    protected String orderByClause;

    /**
     * TB_BASE_COST
     */
    protected boolean distinct;

    /**
     * TB_BASE_COST
     */
    protected List<Criteria> oredCriteria;

    public BaseCostExample() {
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
     * TB_BASE_COST 2018-01-03
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

        public Criteria andCostIdIsNull() {
            addCriterion("COST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCostIdIsNotNull() {
            addCriterion("COST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCostIdEqualTo(String value) {
            addCriterion("COST_ID =", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdNotEqualTo(String value) {
            addCriterion("COST_ID <>", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdGreaterThan(String value) {
            addCriterion("COST_ID >", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdGreaterThanOrEqualTo(String value) {
            addCriterion("COST_ID >=", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdLessThan(String value) {
            addCriterion("COST_ID <", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdLessThanOrEqualTo(String value) {
            addCriterion("COST_ID <=", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdLike(String value) {
            addCriterion("COST_ID like", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdNotLike(String value) {
            addCriterion("COST_ID not like", value, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdIn(List<String> values) {
            addCriterion("COST_ID in", values, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdNotIn(List<String> values) {
            addCriterion("COST_ID not in", values, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdBetween(String value1, String value2) {
            addCriterion("COST_ID between", value1, value2, "costId");
            return (Criteria) this;
        }

        public Criteria andCostIdNotBetween(String value1, String value2) {
            addCriterion("COST_ID not between", value1, value2, "costId");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNull() {
            addCriterion("COST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCostTypeIsNotNull() {
            addCriterion("COST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCostTypeEqualTo(String value) {
            addCriterion("COST_TYPE =", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotEqualTo(String value) {
            addCriterion("COST_TYPE <>", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThan(String value) {
            addCriterion("COST_TYPE >", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeGreaterThanOrEqualTo(String value) {
            addCriterion("COST_TYPE >=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThan(String value) {
            addCriterion("COST_TYPE <", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLessThanOrEqualTo(String value) {
            addCriterion("COST_TYPE <=", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeLike(String value) {
            addCriterion("COST_TYPE like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotLike(String value) {
            addCriterion("COST_TYPE not like", value, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeIn(List<String> values) {
            addCriterion("COST_TYPE in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotIn(List<String> values) {
            addCriterion("COST_TYPE not in", values, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeBetween(String value1, String value2) {
            addCriterion("COST_TYPE between", value1, value2, "costType");
            return (Criteria) this;
        }

        public Criteria andCostTypeNotBetween(String value1, String value2) {
            addCriterion("COST_TYPE not between", value1, value2, "costType");
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
    }

    /**
     * TB_BASE_COST
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_BASE_COST 2018-01-03
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