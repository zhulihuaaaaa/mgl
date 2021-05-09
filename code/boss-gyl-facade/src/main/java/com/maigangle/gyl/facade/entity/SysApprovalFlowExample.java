package com.maigangle.gyl.facade.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysApprovalFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysApprovalFlowExample() {
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

        public Criteria andApprovalFlowIdIsNull() {
            addCriterion("APPROVAL_FLOW_ID is null");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdIsNotNull() {
            addCriterion("APPROVAL_FLOW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdEqualTo(String value) {
            addCriterion("APPROVAL_FLOW_ID =", value, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdNotEqualTo(String value) {
            addCriterion("APPROVAL_FLOW_ID <>", value, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdGreaterThan(String value) {
            addCriterion("APPROVAL_FLOW_ID >", value, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_FLOW_ID >=", value, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdLessThan(String value) {
            addCriterion("APPROVAL_FLOW_ID <", value, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_FLOW_ID <=", value, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdLike(String value) {
            addCriterion("APPROVAL_FLOW_ID like", value, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdNotLike(String value) {
            addCriterion("APPROVAL_FLOW_ID not like", value, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdIn(List<String> values) {
            addCriterion("APPROVAL_FLOW_ID in", values, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdNotIn(List<String> values) {
            addCriterion("APPROVAL_FLOW_ID not in", values, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdBetween(String value1, String value2) {
            addCriterion("APPROVAL_FLOW_ID between", value1, value2, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalFlowIdNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_FLOW_ID not between", value1, value2, "approvalFlowId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdIsNull() {
            addCriterion("APPROVAL_ITEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdIsNotNull() {
            addCriterion("APPROVAL_ITEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdEqualTo(String value) {
            addCriterion("APPROVAL_ITEM_ID =", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdNotEqualTo(String value) {
            addCriterion("APPROVAL_ITEM_ID <>", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdGreaterThan(String value) {
            addCriterion("APPROVAL_ITEM_ID >", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_ITEM_ID >=", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdLessThan(String value) {
            addCriterion("APPROVAL_ITEM_ID <", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_ITEM_ID <=", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdLike(String value) {
            addCriterion("APPROVAL_ITEM_ID like", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdNotLike(String value) {
            addCriterion("APPROVAL_ITEM_ID not like", value, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdIn(List<String> values) {
            addCriterion("APPROVAL_ITEM_ID in", values, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdNotIn(List<String> values) {
            addCriterion("APPROVAL_ITEM_ID not in", values, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdBetween(String value1, String value2) {
            addCriterion("APPROVAL_ITEM_ID between", value1, value2, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalItemIdNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_ITEM_ID not between", value1, value2, "approvalItemId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdIsNull() {
            addCriterion("APPROVAL_PROCESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdIsNotNull() {
            addCriterion("APPROVAL_PROCESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdEqualTo(String value) {
            addCriterion("APPROVAL_PROCESS_ID =", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdNotEqualTo(String value) {
            addCriterion("APPROVAL_PROCESS_ID <>", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdGreaterThan(String value) {
            addCriterion("APPROVAL_PROCESS_ID >", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_PROCESS_ID >=", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdLessThan(String value) {
            addCriterion("APPROVAL_PROCESS_ID <", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_PROCESS_ID <=", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdLike(String value) {
            addCriterion("APPROVAL_PROCESS_ID like", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdNotLike(String value) {
            addCriterion("APPROVAL_PROCESS_ID not like", value, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdIn(List<String> values) {
            addCriterion("APPROVAL_PROCESS_ID in", values, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdNotIn(List<String> values) {
            addCriterion("APPROVAL_PROCESS_ID not in", values, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdBetween(String value1, String value2) {
            addCriterion("APPROVAL_PROCESS_ID between", value1, value2, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andApprovalProcessIdNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_PROCESS_ID not between", value1, value2, "approvalProcessId");
            return (Criteria) this;
        }

        public Criteria andModuleIsNull() {
            addCriterion("MODULE is null");
            return (Criteria) this;
        }

        public Criteria andModuleIsNotNull() {
            addCriterion("MODULE is not null");
            return (Criteria) this;
        }

        public Criteria andModuleEqualTo(String value) {
            addCriterion("MODULE =", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotEqualTo(String value) {
            addCriterion("MODULE <>", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThan(String value) {
            addCriterion("MODULE >", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE >=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThan(String value) {
            addCriterion("MODULE <", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThanOrEqualTo(String value) {
            addCriterion("MODULE <=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLike(String value) {
            addCriterion("MODULE like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotLike(String value) {
            addCriterion("MODULE not like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleIn(List<String> values) {
            addCriterion("MODULE in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotIn(List<String> values) {
            addCriterion("MODULE not in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleBetween(String value1, String value2) {
            addCriterion("MODULE between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotBetween(String value1, String value2) {
            addCriterion("MODULE not between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdIsNull() {
            addCriterion("NEXT_ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdIsNotNull() {
            addCriterion("NEXT_ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdEqualTo(String value) {
            addCriterion("NEXT_ROLE_ID =", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdNotEqualTo(String value) {
            addCriterion("NEXT_ROLE_ID <>", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdGreaterThan(String value) {
            addCriterion("NEXT_ROLE_ID >", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("NEXT_ROLE_ID >=", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdLessThan(String value) {
            addCriterion("NEXT_ROLE_ID <", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdLessThanOrEqualTo(String value) {
            addCriterion("NEXT_ROLE_ID <=", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdLike(String value) {
            addCriterion("NEXT_ROLE_ID like", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdNotLike(String value) {
            addCriterion("NEXT_ROLE_ID not like", value, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdIn(List<String> values) {
            addCriterion("NEXT_ROLE_ID in", values, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdNotIn(List<String> values) {
            addCriterion("NEXT_ROLE_ID not in", values, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdBetween(String value1, String value2) {
            addCriterion("NEXT_ROLE_ID between", value1, value2, "nextRoleId");
            return (Criteria) this;
        }

        public Criteria andNextRoleIdNotBetween(String value1, String value2) {
            addCriterion("NEXT_ROLE_ID not between", value1, value2, "nextRoleId");
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

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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