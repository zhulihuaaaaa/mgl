package com.maigangle.gyl.facade.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvCheckInvDetailExample {
    /**
     * TB_INV_CHECK_INV_DETAIL
     */
    protected String orderByClause;

    /**
     * TB_INV_CHECK_INV_DETAIL
     */
    protected boolean distinct;

    /**
     * TB_INV_CHECK_INV_DETAIL
     */
    protected List<Criteria> oredCriteria;

    public InvCheckInvDetailExample() {
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
     * TB_INV_CHECK_INV_DETAIL 2018-02-02
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

        public Criteria andCheckInvDetailIdIsNull() {
            addCriterion("CHECK_INV_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdIsNotNull() {
            addCriterion("CHECK_INV_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdEqualTo(String value) {
            addCriterion("CHECK_INV_DETAIL_ID =", value, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdNotEqualTo(String value) {
            addCriterion("CHECK_INV_DETAIL_ID <>", value, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdGreaterThan(String value) {
            addCriterion("CHECK_INV_DETAIL_ID >", value, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_INV_DETAIL_ID >=", value, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdLessThan(String value) {
            addCriterion("CHECK_INV_DETAIL_ID <", value, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdLessThanOrEqualTo(String value) {
            addCriterion("CHECK_INV_DETAIL_ID <=", value, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdLike(String value) {
            addCriterion("CHECK_INV_DETAIL_ID like", value, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdNotLike(String value) {
            addCriterion("CHECK_INV_DETAIL_ID not like", value, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdIn(List<String> values) {
            addCriterion("CHECK_INV_DETAIL_ID in", values, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdNotIn(List<String> values) {
            addCriterion("CHECK_INV_DETAIL_ID not in", values, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdBetween(String value1, String value2) {
            addCriterion("CHECK_INV_DETAIL_ID between", value1, value2, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvDetailIdNotBetween(String value1, String value2) {
            addCriterion("CHECK_INV_DETAIL_ID not between", value1, value2, "checkInvDetailId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdIsNull() {
            addCriterion("CHECK_INV_ID is null");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdIsNotNull() {
            addCriterion("CHECK_INV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdEqualTo(String value) {
            addCriterion("CHECK_INV_ID =", value, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdNotEqualTo(String value) {
            addCriterion("CHECK_INV_ID <>", value, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdGreaterThan(String value) {
            addCriterion("CHECK_INV_ID >", value, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_INV_ID >=", value, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdLessThan(String value) {
            addCriterion("CHECK_INV_ID <", value, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdLessThanOrEqualTo(String value) {
            addCriterion("CHECK_INV_ID <=", value, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdLike(String value) {
            addCriterion("CHECK_INV_ID like", value, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdNotLike(String value) {
            addCriterion("CHECK_INV_ID not like", value, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdIn(List<String> values) {
            addCriterion("CHECK_INV_ID in", values, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdNotIn(List<String> values) {
            addCriterion("CHECK_INV_ID not in", values, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdBetween(String value1, String value2) {
            addCriterion("CHECK_INV_ID between", value1, value2, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andCheckInvIdNotBetween(String value1, String value2) {
            addCriterion("CHECK_INV_ID not between", value1, value2, "checkInvId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdIsNull() {
            addCriterion("INVENTORY_ID is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIdIsNotNull() {
            addCriterion("INVENTORY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryIdEqualTo(String value) {
            addCriterion("INVENTORY_ID =", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdNotEqualTo(String value) {
            addCriterion("INVENTORY_ID <>", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdGreaterThan(String value) {
            addCriterion("INVENTORY_ID >", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("INVENTORY_ID >=", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdLessThan(String value) {
            addCriterion("INVENTORY_ID <", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdLessThanOrEqualTo(String value) {
            addCriterion("INVENTORY_ID <=", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdLike(String value) {
            addCriterion("INVENTORY_ID like", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdNotLike(String value) {
            addCriterion("INVENTORY_ID not like", value, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdIn(List<String> values) {
            addCriterion("INVENTORY_ID in", values, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdNotIn(List<String> values) {
            addCriterion("INVENTORY_ID not in", values, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdBetween(String value1, String value2) {
            addCriterion("INVENTORY_ID between", value1, value2, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andInventoryIdNotBetween(String value1, String value2) {
            addCriterion("INVENTORY_ID not between", value1, value2, "inventoryId");
            return (Criteria) this;
        }

        public Criteria andCheckRecordIsNull() {
            addCriterion("CHECK_RECORD is null");
            return (Criteria) this;
        }

        public Criteria andCheckRecordIsNotNull() {
            addCriterion("CHECK_RECORD is not null");
            return (Criteria) this;
        }

        public Criteria andCheckRecordEqualTo(String value) {
            addCriterion("CHECK_RECORD =", value, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordNotEqualTo(String value) {
            addCriterion("CHECK_RECORD <>", value, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordGreaterThan(String value) {
            addCriterion("CHECK_RECORD >", value, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_RECORD >=", value, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordLessThan(String value) {
            addCriterion("CHECK_RECORD <", value, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordLessThanOrEqualTo(String value) {
            addCriterion("CHECK_RECORD <=", value, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordLike(String value) {
            addCriterion("CHECK_RECORD like", value, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordNotLike(String value) {
            addCriterion("CHECK_RECORD not like", value, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordIn(List<String> values) {
            addCriterion("CHECK_RECORD in", values, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordNotIn(List<String> values) {
            addCriterion("CHECK_RECORD not in", values, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordBetween(String value1, String value2) {
            addCriterion("CHECK_RECORD between", value1, value2, "checkRecord");
            return (Criteria) this;
        }

        public Criteria andCheckRecordNotBetween(String value1, String value2) {
            addCriterion("CHECK_RECORD not between", value1, value2, "checkRecord");
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
     * TB_INV_CHECK_INV_DETAIL
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_INV_CHECK_INV_DETAIL 2018-02-02
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