package com.maigangle.gyl.facade.entity;

import java.util.ArrayList;
import java.util.List;

public class GridConfigExample {
    /**
     * TB_GRID_CONFIG
     */
    protected String orderByClause;

    /**
     * TB_GRID_CONFIG
     */
    protected boolean distinct;

    /**
     * TB_GRID_CONFIG
     */
    protected List<Criteria> oredCriteria;

    public GridConfigExample() {
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
     * TB_GRID_CONFIG 2017-12-07
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

        public Criteria andGridIdIsNull() {
            addCriterion("GRID_ID is null");
            return (Criteria) this;
        }

        public Criteria andGridIdIsNotNull() {
            addCriterion("GRID_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGridIdEqualTo(String value) {
            addCriterion("GRID_ID =", value, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdNotEqualTo(String value) {
            addCriterion("GRID_ID <>", value, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdGreaterThan(String value) {
            addCriterion("GRID_ID >", value, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdGreaterThanOrEqualTo(String value) {
            addCriterion("GRID_ID >=", value, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdLessThan(String value) {
            addCriterion("GRID_ID <", value, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdLessThanOrEqualTo(String value) {
            addCriterion("GRID_ID <=", value, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdLike(String value) {
            addCriterion("GRID_ID like", value, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdNotLike(String value) {
            addCriterion("GRID_ID not like", value, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdIn(List<String> values) {
            addCriterion("GRID_ID in", values, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdNotIn(List<String> values) {
            addCriterion("GRID_ID not in", values, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdBetween(String value1, String value2) {
            addCriterion("GRID_ID between", value1, value2, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridIdNotBetween(String value1, String value2) {
            addCriterion("GRID_ID not between", value1, value2, "gridId");
            return (Criteria) this;
        }

        public Criteria andGridCodeIsNull() {
            addCriterion("GRID_CODE is null");
            return (Criteria) this;
        }

        public Criteria andGridCodeIsNotNull() {
            addCriterion("GRID_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andGridCodeEqualTo(String value) {
            addCriterion("GRID_CODE =", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeNotEqualTo(String value) {
            addCriterion("GRID_CODE <>", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeGreaterThan(String value) {
            addCriterion("GRID_CODE >", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeGreaterThanOrEqualTo(String value) {
            addCriterion("GRID_CODE >=", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeLessThan(String value) {
            addCriterion("GRID_CODE <", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeLessThanOrEqualTo(String value) {
            addCriterion("GRID_CODE <=", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeLike(String value) {
            addCriterion("GRID_CODE like", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeNotLike(String value) {
            addCriterion("GRID_CODE not like", value, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeIn(List<String> values) {
            addCriterion("GRID_CODE in", values, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeNotIn(List<String> values) {
            addCriterion("GRID_CODE not in", values, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeBetween(String value1, String value2) {
            addCriterion("GRID_CODE between", value1, value2, "gridCode");
            return (Criteria) this;
        }

        public Criteria andGridCodeNotBetween(String value1, String value2) {
            addCriterion("GRID_CODE not between", value1, value2, "gridCode");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGridConfigIsNull() {
            addCriterion("GRID_CONFIG is null");
            return (Criteria) this;
        }

        public Criteria andGridConfigIsNotNull() {
            addCriterion("GRID_CONFIG is not null");
            return (Criteria) this;
        }

        public Criteria andGridConfigEqualTo(String value) {
            addCriterion("GRID_CONFIG =", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigNotEqualTo(String value) {
            addCriterion("GRID_CONFIG <>", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigGreaterThan(String value) {
            addCriterion("GRID_CONFIG >", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigGreaterThanOrEqualTo(String value) {
            addCriterion("GRID_CONFIG >=", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigLessThan(String value) {
            addCriterion("GRID_CONFIG <", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigLessThanOrEqualTo(String value) {
            addCriterion("GRID_CONFIG <=", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigLike(String value) {
            addCriterion("GRID_CONFIG like", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigNotLike(String value) {
            addCriterion("GRID_CONFIG not like", value, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigIn(List<String> values) {
            addCriterion("GRID_CONFIG in", values, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigNotIn(List<String> values) {
            addCriterion("GRID_CONFIG not in", values, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigBetween(String value1, String value2) {
            addCriterion("GRID_CONFIG between", value1, value2, "gridConfig");
            return (Criteria) this;
        }

        public Criteria andGridConfigNotBetween(String value1, String value2) {
            addCriterion("GRID_CONFIG not between", value1, value2, "gridConfig");
            return (Criteria) this;
        }
    }

    /**
     * TB_GRID_CONFIG
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_GRID_CONFIG 2017-12-07
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