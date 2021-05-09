package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseProductExample {
    /**
     * TB_BASE_PRODUCT
     */
    protected String orderByClause;

    /**
     * TB_BASE_PRODUCT
     */
    protected boolean distinct;

    /**
     * TB_BASE_PRODUCT
     */
    protected List<Criteria> oredCriteria;

    public BaseProductExample() {
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
     * TB_BASE_PRODUCT 2017-12-07
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

        public Criteria andProductNameIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("PRODUCT_NAME like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitIsNull() {
            addCriterion("QUANTITY_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitIsNotNull() {
            addCriterion("QUANTITY_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitEqualTo(String value) {
            addCriterion("QUANTITY_UNIT =", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitNotEqualTo(String value) {
            addCriterion("QUANTITY_UNIT <>", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitGreaterThan(String value) {
            addCriterion("QUANTITY_UNIT >", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitGreaterThanOrEqualTo(String value) {
            addCriterion("QUANTITY_UNIT >=", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitLessThan(String value) {
            addCriterion("QUANTITY_UNIT <", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitLessThanOrEqualTo(String value) {
            addCriterion("QUANTITY_UNIT <=", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitLike(String value) {
            addCriterion("QUANTITY_UNIT like", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitNotLike(String value) {
            addCriterion("QUANTITY_UNIT not like", value, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitIn(List<String> values) {
            addCriterion("QUANTITY_UNIT in", values, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitNotIn(List<String> values) {
            addCriterion("QUANTITY_UNIT not in", values, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitBetween(String value1, String value2) {
            addCriterion("QUANTITY_UNIT between", value1, value2, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andQuantityUnitNotBetween(String value1, String value2) {
            addCriterion("QUANTITY_UNIT not between", value1, value2, "quantityUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitIsNull() {
            addCriterion("WEIGHT_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitIsNotNull() {
            addCriterion("WEIGHT_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightUnitEqualTo(String value) {
            addCriterion("WEIGHT_UNIT =", value, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitNotEqualTo(String value) {
            addCriterion("WEIGHT_UNIT <>", value, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitGreaterThan(String value) {
            addCriterion("WEIGHT_UNIT >", value, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitGreaterThanOrEqualTo(String value) {
            addCriterion("WEIGHT_UNIT >=", value, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitLessThan(String value) {
            addCriterion("WEIGHT_UNIT <", value, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitLessThanOrEqualTo(String value) {
            addCriterion("WEIGHT_UNIT <=", value, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitLike(String value) {
            addCriterion("WEIGHT_UNIT like", value, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitNotLike(String value) {
            addCriterion("WEIGHT_UNIT not like", value, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitIn(List<String> values) {
            addCriterion("WEIGHT_UNIT in", values, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitNotIn(List<String> values) {
            addCriterion("WEIGHT_UNIT not in", values, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitBetween(String value1, String value2) {
            addCriterion("WEIGHT_UNIT between", value1, value2, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andWeightUnitNotBetween(String value1, String value2) {
            addCriterion("WEIGHT_UNIT not between", value1, value2, "weightUnit");
            return (Criteria) this;
        }

        public Criteria andPrecisionIsNull() {
            addCriterion("PRECISION is null");
            return (Criteria) this;
        }

        public Criteria andPrecisionIsNotNull() {
            addCriterion("PRECISION is not null");
            return (Criteria) this;
        }

        public Criteria andPrecisionEqualTo(BigDecimal value) {
            addCriterion("PRECISION =", value, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionNotEqualTo(BigDecimal value) {
            addCriterion("PRECISION <>", value, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionGreaterThan(BigDecimal value) {
            addCriterion("PRECISION >", value, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRECISION >=", value, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionLessThan(BigDecimal value) {
            addCriterion("PRECISION <", value, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRECISION <=", value, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionIn(List<BigDecimal> values) {
            addCriterion("PRECISION in", values, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionNotIn(List<BigDecimal> values) {
            addCriterion("PRECISION not in", values, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRECISION between", value1, value2, "precision");
            return (Criteria) this;
        }

        public Criteria andPrecisionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRECISION not between", value1, value2, "precision");
            return (Criteria) this;
        }

        public Criteria andUnitRateIsNull() {
            addCriterion("UNIT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andUnitRateIsNotNull() {
            addCriterion("UNIT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitRateEqualTo(BigDecimal value) {
            addCriterion("UNIT_RATE =", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateNotEqualTo(BigDecimal value) {
            addCriterion("UNIT_RATE <>", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateGreaterThan(BigDecimal value) {
            addCriterion("UNIT_RATE >", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT_RATE >=", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateLessThan(BigDecimal value) {
            addCriterion("UNIT_RATE <", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UNIT_RATE <=", value, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateIn(List<BigDecimal> values) {
            addCriterion("UNIT_RATE in", values, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateNotIn(List<BigDecimal> values) {
            addCriterion("UNIT_RATE not in", values, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT_RATE between", value1, value2, "unitRate");
            return (Criteria) this;
        }

        public Criteria andUnitRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UNIT_RATE not between", value1, value2, "unitRate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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
    }

    /**
     * TB_BASE_PRODUCT
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_BASE_PRODUCT 2017-12-07
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