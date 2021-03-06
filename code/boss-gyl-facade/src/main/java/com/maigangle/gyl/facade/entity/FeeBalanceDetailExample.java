package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeeBalanceDetailExample {
    /**
     * TB_FEE_BALANCE_DETAIL
     */
    protected String orderByClause;

    /**
     * TB_FEE_BALANCE_DETAIL
     */
    protected boolean distinct;

    /**
     * TB_FEE_BALANCE_DETAIL
     */
    protected List<Criteria> oredCriteria;

    public FeeBalanceDetailExample() {
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
     * TB_FEE_BALANCE_DETAIL 2018-02-27
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

        public Criteria andBalanceDetailIdIsNull() {
            addCriterion("BALANCE_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdIsNotNull() {
            addCriterion("BALANCE_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdEqualTo(String value) {
            addCriterion("BALANCE_DETAIL_ID =", value, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdNotEqualTo(String value) {
            addCriterion("BALANCE_DETAIL_ID <>", value, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdGreaterThan(String value) {
            addCriterion("BALANCE_DETAIL_ID >", value, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("BALANCE_DETAIL_ID >=", value, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdLessThan(String value) {
            addCriterion("BALANCE_DETAIL_ID <", value, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdLessThanOrEqualTo(String value) {
            addCriterion("BALANCE_DETAIL_ID <=", value, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdLike(String value) {
            addCriterion("BALANCE_DETAIL_ID like", value, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdNotLike(String value) {
            addCriterion("BALANCE_DETAIL_ID not like", value, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdIn(List<String> values) {
            addCriterion("BALANCE_DETAIL_ID in", values, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdNotIn(List<String> values) {
            addCriterion("BALANCE_DETAIL_ID not in", values, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdBetween(String value1, String value2) {
            addCriterion("BALANCE_DETAIL_ID between", value1, value2, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceDetailIdNotBetween(String value1, String value2) {
            addCriterion("BALANCE_DETAIL_ID not between", value1, value2, "balanceDetailId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdIsNull() {
            addCriterion("BALANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIdIsNotNull() {
            addCriterion("BALANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceIdEqualTo(String value) {
            addCriterion("BALANCE_ID =", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdNotEqualTo(String value) {
            addCriterion("BALANCE_ID <>", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdGreaterThan(String value) {
            addCriterion("BALANCE_ID >", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("BALANCE_ID >=", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdLessThan(String value) {
            addCriterion("BALANCE_ID <", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdLessThanOrEqualTo(String value) {
            addCriterion("BALANCE_ID <=", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdLike(String value) {
            addCriterion("BALANCE_ID like", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdNotLike(String value) {
            addCriterion("BALANCE_ID not like", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdIn(List<String> values) {
            addCriterion("BALANCE_ID in", values, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdNotIn(List<String> values) {
            addCriterion("BALANCE_ID not in", values, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdBetween(String value1, String value2) {
            addCriterion("BALANCE_ID between", value1, value2, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdNotBetween(String value1, String value2) {
            addCriterion("BALANCE_ID not between", value1, value2, "balanceId");
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

        public Criteria andPurchaseAmountIsNull() {
            addCriterion("PURCHASE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountIsNotNull() {
            addCriterion("PURCHASE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountEqualTo(BigDecimal value) {
            addCriterion("PURCHASE_AMOUNT =", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotEqualTo(BigDecimal value) {
            addCriterion("PURCHASE_AMOUNT <>", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountGreaterThan(BigDecimal value) {
            addCriterion("PURCHASE_AMOUNT >", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PURCHASE_AMOUNT >=", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountLessThan(BigDecimal value) {
            addCriterion("PURCHASE_AMOUNT <", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PURCHASE_AMOUNT <=", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountIn(List<BigDecimal> values) {
            addCriterion("PURCHASE_AMOUNT in", values, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotIn(List<BigDecimal> values) {
            addCriterion("PURCHASE_AMOUNT not in", values, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PURCHASE_AMOUNT between", value1, value2, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PURCHASE_AMOUNT not between", value1, value2, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountIsNull() {
            addCriterion("RESIDUAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andResidualAmountIsNotNull() {
            addCriterion("RESIDUAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andResidualAmountEqualTo(BigDecimal value) {
            addCriterion("RESIDUAL_AMOUNT =", value, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountNotEqualTo(BigDecimal value) {
            addCriterion("RESIDUAL_AMOUNT <>", value, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountGreaterThan(BigDecimal value) {
            addCriterion("RESIDUAL_AMOUNT >", value, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RESIDUAL_AMOUNT >=", value, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountLessThan(BigDecimal value) {
            addCriterion("RESIDUAL_AMOUNT <", value, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RESIDUAL_AMOUNT <=", value, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountIn(List<BigDecimal> values) {
            addCriterion("RESIDUAL_AMOUNT in", values, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountNotIn(List<BigDecimal> values) {
            addCriterion("RESIDUAL_AMOUNT not in", values, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESIDUAL_AMOUNT between", value1, value2, "residualAmount");
            return (Criteria) this;
        }

        public Criteria andResidualAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESIDUAL_AMOUNT not between", value1, value2, "residualAmount");
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

        public Criteria andFinanceIdIsNull() {
            addCriterion("FINANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNotNull() {
            addCriterion("FINANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdEqualTo(String value) {
            addCriterion("FINANCE_ID =", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotEqualTo(String value) {
            addCriterion("FINANCE_ID <>", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThan(String value) {
            addCriterion("FINANCE_ID >", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("FINANCE_ID >=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThan(String value) {
            addCriterion("FINANCE_ID <", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThanOrEqualTo(String value) {
            addCriterion("FINANCE_ID <=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLike(String value) {
            addCriterion("FINANCE_ID like", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotLike(String value) {
            addCriterion("FINANCE_ID not like", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIn(List<String> values) {
            addCriterion("FINANCE_ID in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotIn(List<String> values) {
            addCriterion("FINANCE_ID not in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdBetween(String value1, String value2) {
            addCriterion("FINANCE_ID between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotBetween(String value1, String value2) {
            addCriterion("FINANCE_ID not between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andBalanceStateIsNull() {
            addCriterion("BALANCE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andBalanceStateIsNotNull() {
            addCriterion("BALANCE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceStateEqualTo(String value) {
            addCriterion("BALANCE_STATE =", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateNotEqualTo(String value) {
            addCriterion("BALANCE_STATE <>", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateGreaterThan(String value) {
            addCriterion("BALANCE_STATE >", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateGreaterThanOrEqualTo(String value) {
            addCriterion("BALANCE_STATE >=", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateLessThan(String value) {
            addCriterion("BALANCE_STATE <", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateLessThanOrEqualTo(String value) {
            addCriterion("BALANCE_STATE <=", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateLike(String value) {
            addCriterion("BALANCE_STATE like", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateNotLike(String value) {
            addCriterion("BALANCE_STATE not like", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateIn(List<String> values) {
            addCriterion("BALANCE_STATE in", values, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateNotIn(List<String> values) {
            addCriterion("BALANCE_STATE not in", values, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateBetween(String value1, String value2) {
            addCriterion("BALANCE_STATE between", value1, value2, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateNotBetween(String value1, String value2) {
            addCriterion("BALANCE_STATE not between", value1, value2, "balanceState");
            return (Criteria) this;
        }
    }

    /**
     * TB_FEE_BALANCE_DETAIL
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_FEE_BALANCE_DETAIL 2018-02-27
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