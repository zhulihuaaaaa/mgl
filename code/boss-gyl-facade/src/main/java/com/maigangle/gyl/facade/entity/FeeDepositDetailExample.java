package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeeDepositDetailExample {
    /**
     * TB_FEE_DEPOSIT_DETAIL
     */
    protected String orderByClause;

    /**
     * TB_FEE_DEPOSIT_DETAIL
     */
    protected boolean distinct;

    /**
     * TB_FEE_DEPOSIT_DETAIL
     */
    protected List<Criteria> oredCriteria;

    public FeeDepositDetailExample() {
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
     * TB_FEE_DEPOSIT_DETAIL 2017-12-07
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

        public Criteria andUsedFeeIsNull() {
            addCriterion("USED_FEE is null");
            return (Criteria) this;
        }

        public Criteria andUsedFeeIsNotNull() {
            addCriterion("USED_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andUsedFeeEqualTo(BigDecimal value) {
            addCriterion("USED_FEE =", value, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeNotEqualTo(BigDecimal value) {
            addCriterion("USED_FEE <>", value, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeGreaterThan(BigDecimal value) {
            addCriterion("USED_FEE >", value, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_FEE >=", value, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeLessThan(BigDecimal value) {
            addCriterion("USED_FEE <", value, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_FEE <=", value, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeIn(List<BigDecimal> values) {
            addCriterion("USED_FEE in", values, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeNotIn(List<BigDecimal> values) {
            addCriterion("USED_FEE not in", values, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_FEE between", value1, value2, "usedFee");
            return (Criteria) this;
        }

        public Criteria andUsedFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_FEE not between", value1, value2, "usedFee");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("BALANCE =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("BALANCE <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("BALANCE >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("BALANCE <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("BALANCE in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("BALANCE not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE not between", value1, value2, "balance");
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

        public Criteria andDepositAccountIdIsNull() {
            addCriterion("DEPOSIT_ACCOUNT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdIsNotNull() {
            addCriterion("DEPOSIT_ACCOUNT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdEqualTo(String value) {
            addCriterion("DEPOSIT_ACCOUNT_ID =", value, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdNotEqualTo(String value) {
            addCriterion("DEPOSIT_ACCOUNT_ID <>", value, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdGreaterThan(String value) {
            addCriterion("DEPOSIT_ACCOUNT_ID >", value, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_ACCOUNT_ID >=", value, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdLessThan(String value) {
            addCriterion("DEPOSIT_ACCOUNT_ID <", value, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_ACCOUNT_ID <=", value, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdLike(String value) {
            addCriterion("DEPOSIT_ACCOUNT_ID like", value, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdNotLike(String value) {
            addCriterion("DEPOSIT_ACCOUNT_ID not like", value, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdIn(List<String> values) {
            addCriterion("DEPOSIT_ACCOUNT_ID in", values, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdNotIn(List<String> values) {
            addCriterion("DEPOSIT_ACCOUNT_ID not in", values, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdBetween(String value1, String value2) {
            addCriterion("DEPOSIT_ACCOUNT_ID between", value1, value2, "depositAccountId");
            return (Criteria) this;
        }

        public Criteria andDepositAccountIdNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_ACCOUNT_ID not between", value1, value2, "depositAccountId");
            return (Criteria) this;
        }
    }

    /**
     * TB_FEE_DEPOSIT_DETAIL
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_FEE_DEPOSIT_DETAIL 2017-12-07
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