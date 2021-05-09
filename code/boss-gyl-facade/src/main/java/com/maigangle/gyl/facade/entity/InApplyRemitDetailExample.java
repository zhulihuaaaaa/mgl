package com.maigangle.gyl.facade.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InApplyRemitDetailExample {
    /**
     * TB_IN_APPLY_REMIT_DETAIL
     */
    protected String orderByClause;

    /**
     * TB_IN_APPLY_REMIT_DETAIL
     */
    protected boolean distinct;

    /**
     * TB_IN_APPLY_REMIT_DETAIL
     */
    protected List<Criteria> oredCriteria;

    public InApplyRemitDetailExample() {
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

        public Criteria andApplyRemitDetailIdIsNull() {
            addCriterion("APPLY_REMIT_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdIsNotNull() {
            addCriterion("APPLY_REMIT_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdEqualTo(String value) {
            addCriterion("APPLY_REMIT_DETAIL_ID =", value, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdNotEqualTo(String value) {
            addCriterion("APPLY_REMIT_DETAIL_ID <>", value, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdGreaterThan(String value) {
            addCriterion("APPLY_REMIT_DETAIL_ID >", value, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_REMIT_DETAIL_ID >=", value, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdLessThan(String value) {
            addCriterion("APPLY_REMIT_DETAIL_ID <", value, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdLessThanOrEqualTo(String value) {
            addCriterion("APPLY_REMIT_DETAIL_ID <=", value, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdLike(String value) {
            addCriterion("APPLY_REMIT_DETAIL_ID like", value, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdNotLike(String value) {
            addCriterion("APPLY_REMIT_DETAIL_ID not like", value, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdIn(List<String> values) {
            addCriterion("APPLY_REMIT_DETAIL_ID in", values, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdNotIn(List<String> values) {
            addCriterion("APPLY_REMIT_DETAIL_ID not in", values, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdBetween(String value1, String value2) {
            addCriterion("APPLY_REMIT_DETAIL_ID between", value1, value2, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andApplyRemitDetailIdNotBetween(String value1, String value2) {
            addCriterion("APPLY_REMIT_DETAIL_ID not between", value1, value2, "applyRemitDetailId");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andRemitStatusIsNull() {
            addCriterion("REMIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRemitStatusIsNotNull() {
            addCriterion("REMIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRemitStatusEqualTo(String value) {
            addCriterion("REMIT_STATUS =", value, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusNotEqualTo(String value) {
            addCriterion("REMIT_STATUS <>", value, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusGreaterThan(String value) {
            addCriterion("REMIT_STATUS >", value, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusGreaterThanOrEqualTo(String value) {
            addCriterion("REMIT_STATUS >=", value, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusLessThan(String value) {
            addCriterion("REMIT_STATUS <", value, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusLessThanOrEqualTo(String value) {
            addCriterion("REMIT_STATUS <=", value, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusLike(String value) {
            addCriterion("REMIT_STATUS like", value, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusNotLike(String value) {
            addCriterion("REMIT_STATUS not like", value, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusIn(List<String> values) {
            addCriterion("REMIT_STATUS in", values, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusNotIn(List<String> values) {
            addCriterion("REMIT_STATUS not in", values, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusBetween(String value1, String value2) {
            addCriterion("REMIT_STATUS between", value1, value2, "remitStatus");
            return (Criteria) this;
        }

        public Criteria andRemitStatusNotBetween(String value1, String value2) {
            addCriterion("REMIT_STATUS not between", value1, value2, "remitStatus");
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

        public Criteria andInstockIdIsNull() {
            addCriterion("INSTOCK_ID is null");
            return (Criteria) this;
        }

        public Criteria andInstockIdIsNotNull() {
            addCriterion("INSTOCK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInstockIdEqualTo(String value) {
            addCriterion("INSTOCK_ID =", value, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdNotEqualTo(String value) {
            addCriterion("INSTOCK_ID <>", value, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdGreaterThan(String value) {
            addCriterion("INSTOCK_ID >", value, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdGreaterThanOrEqualTo(String value) {
            addCriterion("INSTOCK_ID >=", value, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdLessThan(String value) {
            addCriterion("INSTOCK_ID <", value, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdLessThanOrEqualTo(String value) {
            addCriterion("INSTOCK_ID <=", value, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdLike(String value) {
            addCriterion("INSTOCK_ID like", value, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdNotLike(String value) {
            addCriterion("INSTOCK_ID not like", value, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdIn(List<String> values) {
            addCriterion("INSTOCK_ID in", values, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdNotIn(List<String> values) {
            addCriterion("INSTOCK_ID not in", values, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdBetween(String value1, String value2) {
            addCriterion("INSTOCK_ID between", value1, value2, "instockId");
            return (Criteria) this;
        }

        public Criteria andInstockIdNotBetween(String value1, String value2) {
            addCriterion("INSTOCK_ID not between", value1, value2, "instockId");
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
    }

    /**
     * TB_IN_APPLY_REMIT_DETAIL
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