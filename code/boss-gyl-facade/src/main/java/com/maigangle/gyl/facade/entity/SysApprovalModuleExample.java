package com.maigangle.gyl.facade.entity;

import java.util.ArrayList;
import java.util.List;

public class SysApprovalModuleExample {
    /**
     * TB_SYS_APPROVAL_MODULE
     */
    protected String orderByClause;

    /**
     * TB_SYS_APPROVAL_MODULE
     */
    protected boolean distinct;

    /**
     * TB_SYS_APPROVAL_MODULE
     */
    protected List<Criteria> oredCriteria;

    public SysApprovalModuleExample() {
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
     * TB_SYS_APPROVAL_MODULE 2018-02-08
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

        public Criteria andApprovalModuleIdIsNull() {
            addCriterion("APPROVAL_MODULE_ID is null");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdIsNotNull() {
            addCriterion("APPROVAL_MODULE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdEqualTo(String value) {
            addCriterion("APPROVAL_MODULE_ID =", value, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdNotEqualTo(String value) {
            addCriterion("APPROVAL_MODULE_ID <>", value, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdGreaterThan(String value) {
            addCriterion("APPROVAL_MODULE_ID >", value, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_MODULE_ID >=", value, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdLessThan(String value) {
            addCriterion("APPROVAL_MODULE_ID <", value, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_MODULE_ID <=", value, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdLike(String value) {
            addCriterion("APPROVAL_MODULE_ID like", value, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdNotLike(String value) {
            addCriterion("APPROVAL_MODULE_ID not like", value, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdIn(List<String> values) {
            addCriterion("APPROVAL_MODULE_ID in", values, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdNotIn(List<String> values) {
            addCriterion("APPROVAL_MODULE_ID not in", values, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdBetween(String value1, String value2) {
            addCriterion("APPROVAL_MODULE_ID between", value1, value2, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andApprovalModuleIdNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_MODULE_ID not between", value1, value2, "approvalModuleId");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNull() {
            addCriterion("MODULE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNotNull() {
            addCriterion("MODULE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andModuleNameEqualTo(String value) {
            addCriterion("MODULE_NAME =", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotEqualTo(String value) {
            addCriterion("MODULE_NAME <>", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThan(String value) {
            addCriterion("MODULE_NAME >", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE_NAME >=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThan(String value) {
            addCriterion("MODULE_NAME <", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThanOrEqualTo(String value) {
            addCriterion("MODULE_NAME <=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLike(String value) {
            addCriterion("MODULE_NAME like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotLike(String value) {
            addCriterion("MODULE_NAME not like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameIn(List<String> values) {
            addCriterion("MODULE_NAME in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotIn(List<String> values) {
            addCriterion("MODULE_NAME not in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameBetween(String value1, String value2) {
            addCriterion("MODULE_NAME between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotBetween(String value1, String value2) {
            addCriterion("MODULE_NAME not between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanIsNull() {
            addCriterion("MODULE_SERVICE_BEAN is null");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanIsNotNull() {
            addCriterion("MODULE_SERVICE_BEAN is not null");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanEqualTo(String value) {
            addCriterion("MODULE_SERVICE_BEAN =", value, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanNotEqualTo(String value) {
            addCriterion("MODULE_SERVICE_BEAN <>", value, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanGreaterThan(String value) {
            addCriterion("MODULE_SERVICE_BEAN >", value, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE_SERVICE_BEAN >=", value, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanLessThan(String value) {
            addCriterion("MODULE_SERVICE_BEAN <", value, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanLessThanOrEqualTo(String value) {
            addCriterion("MODULE_SERVICE_BEAN <=", value, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanLike(String value) {
            addCriterion("MODULE_SERVICE_BEAN like", value, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanNotLike(String value) {
            addCriterion("MODULE_SERVICE_BEAN not like", value, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanIn(List<String> values) {
            addCriterion("MODULE_SERVICE_BEAN in", values, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanNotIn(List<String> values) {
            addCriterion("MODULE_SERVICE_BEAN not in", values, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanBetween(String value1, String value2) {
            addCriterion("MODULE_SERVICE_BEAN between", value1, value2, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andModuleServiceBeanNotBetween(String value1, String value2) {
            addCriterion("MODULE_SERVICE_BEAN not between", value1, value2, "moduleServiceBean");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodIsNull() {
            addCriterion("APPROVAL_COMPLETE_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodIsNotNull() {
            addCriterion("APPROVAL_COMPLETE_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodEqualTo(String value) {
            addCriterion("APPROVAL_COMPLETE_METHOD =", value, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodNotEqualTo(String value) {
            addCriterion("APPROVAL_COMPLETE_METHOD <>", value, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodGreaterThan(String value) {
            addCriterion("APPROVAL_COMPLETE_METHOD >", value, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_COMPLETE_METHOD >=", value, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodLessThan(String value) {
            addCriterion("APPROVAL_COMPLETE_METHOD <", value, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_COMPLETE_METHOD <=", value, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodLike(String value) {
            addCriterion("APPROVAL_COMPLETE_METHOD like", value, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodNotLike(String value) {
            addCriterion("APPROVAL_COMPLETE_METHOD not like", value, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodIn(List<String> values) {
            addCriterion("APPROVAL_COMPLETE_METHOD in", values, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodNotIn(List<String> values) {
            addCriterion("APPROVAL_COMPLETE_METHOD not in", values, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodBetween(String value1, String value2) {
            addCriterion("APPROVAL_COMPLETE_METHOD between", value1, value2, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCompleteMethodNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_COMPLETE_METHOD not between", value1, value2, "approvalCompleteMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodIsNull() {
            addCriterion("APPROVAL_SUSPEND_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodIsNotNull() {
            addCriterion("APPROVAL_SUSPEND_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodEqualTo(String value) {
            addCriterion("APPROVAL_SUSPEND_METHOD =", value, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodNotEqualTo(String value) {
            addCriterion("APPROVAL_SUSPEND_METHOD <>", value, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodGreaterThan(String value) {
            addCriterion("APPROVAL_SUSPEND_METHOD >", value, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_SUSPEND_METHOD >=", value, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodLessThan(String value) {
            addCriterion("APPROVAL_SUSPEND_METHOD <", value, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_SUSPEND_METHOD <=", value, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodLike(String value) {
            addCriterion("APPROVAL_SUSPEND_METHOD like", value, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodNotLike(String value) {
            addCriterion("APPROVAL_SUSPEND_METHOD not like", value, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodIn(List<String> values) {
            addCriterion("APPROVAL_SUSPEND_METHOD in", values, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodNotIn(List<String> values) {
            addCriterion("APPROVAL_SUSPEND_METHOD not in", values, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodBetween(String value1, String value2) {
            addCriterion("APPROVAL_SUSPEND_METHOD between", value1, value2, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalSuspendMethodNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_SUSPEND_METHOD not between", value1, value2, "approvalSuspendMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodIsNull() {
            addCriterion("APPROVAL_CANCEL_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodIsNotNull() {
            addCriterion("APPROVAL_CANCEL_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodEqualTo(String value) {
            addCriterion("APPROVAL_CANCEL_METHOD =", value, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodNotEqualTo(String value) {
            addCriterion("APPROVAL_CANCEL_METHOD <>", value, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodGreaterThan(String value) {
            addCriterion("APPROVAL_CANCEL_METHOD >", value, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_CANCEL_METHOD >=", value, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodLessThan(String value) {
            addCriterion("APPROVAL_CANCEL_METHOD <", value, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_CANCEL_METHOD <=", value, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodLike(String value) {
            addCriterion("APPROVAL_CANCEL_METHOD like", value, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodNotLike(String value) {
            addCriterion("APPROVAL_CANCEL_METHOD not like", value, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodIn(List<String> values) {
            addCriterion("APPROVAL_CANCEL_METHOD in", values, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodNotIn(List<String> values) {
            addCriterion("APPROVAL_CANCEL_METHOD not in", values, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodBetween(String value1, String value2) {
            addCriterion("APPROVAL_CANCEL_METHOD between", value1, value2, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalCancelMethodNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_CANCEL_METHOD not between", value1, value2, "approvalCancelMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodIsNull() {
            addCriterion("ABANDON_APPROVAL_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodIsNotNull() {
            addCriterion("ABANDON_APPROVAL_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodEqualTo(String value) {
            addCriterion("ABANDON_APPROVAL_METHOD =", value, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodNotEqualTo(String value) {
            addCriterion("ABANDON_APPROVAL_METHOD <>", value, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodGreaterThan(String value) {
            addCriterion("ABANDON_APPROVAL_METHOD >", value, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodGreaterThanOrEqualTo(String value) {
            addCriterion("ABANDON_APPROVAL_METHOD >=", value, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodLessThan(String value) {
            addCriterion("ABANDON_APPROVAL_METHOD <", value, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodLessThanOrEqualTo(String value) {
            addCriterion("ABANDON_APPROVAL_METHOD <=", value, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodLike(String value) {
            addCriterion("ABANDON_APPROVAL_METHOD like", value, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodNotLike(String value) {
            addCriterion("ABANDON_APPROVAL_METHOD not like", value, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodIn(List<String> values) {
            addCriterion("ABANDON_APPROVAL_METHOD in", values, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodNotIn(List<String> values) {
            addCriterion("ABANDON_APPROVAL_METHOD not in", values, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodBetween(String value1, String value2) {
            addCriterion("ABANDON_APPROVAL_METHOD between", value1, value2, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonApprovalMethodNotBetween(String value1, String value2) {
            addCriterion("ABANDON_APPROVAL_METHOD not between", value1, value2, "abandonApprovalMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodIsNull() {
            addCriterion("ABANDON_REJECT_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodIsNotNull() {
            addCriterion("ABANDON_REJECT_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodEqualTo(String value) {
            addCriterion("ABANDON_REJECT_METHOD =", value, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodNotEqualTo(String value) {
            addCriterion("ABANDON_REJECT_METHOD <>", value, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodGreaterThan(String value) {
            addCriterion("ABANDON_REJECT_METHOD >", value, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodGreaterThanOrEqualTo(String value) {
            addCriterion("ABANDON_REJECT_METHOD >=", value, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodLessThan(String value) {
            addCriterion("ABANDON_REJECT_METHOD <", value, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodLessThanOrEqualTo(String value) {
            addCriterion("ABANDON_REJECT_METHOD <=", value, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodLike(String value) {
            addCriterion("ABANDON_REJECT_METHOD like", value, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodNotLike(String value) {
            addCriterion("ABANDON_REJECT_METHOD not like", value, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodIn(List<String> values) {
            addCriterion("ABANDON_REJECT_METHOD in", values, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodNotIn(List<String> values) {
            addCriterion("ABANDON_REJECT_METHOD not in", values, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodBetween(String value1, String value2) {
            addCriterion("ABANDON_REJECT_METHOD between", value1, value2, "abandonRejectMethod");
            return (Criteria) this;
        }

        public Criteria andAbandonRejectMethodNotBetween(String value1, String value2) {
            addCriterion("ABANDON_REJECT_METHOD not between", value1, value2, "abandonRejectMethod");
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

        public Criteria andModuleAliasIsNull() {
            addCriterion("MODULE_ALIAS is null");
            return (Criteria) this;
        }

        public Criteria andModuleAliasIsNotNull() {
            addCriterion("MODULE_ALIAS is not null");
            return (Criteria) this;
        }

        public Criteria andModuleAliasEqualTo(String value) {
            addCriterion("MODULE_ALIAS =", value, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasNotEqualTo(String value) {
            addCriterion("MODULE_ALIAS <>", value, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasGreaterThan(String value) {
            addCriterion("MODULE_ALIAS >", value, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE_ALIAS >=", value, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasLessThan(String value) {
            addCriterion("MODULE_ALIAS <", value, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasLessThanOrEqualTo(String value) {
            addCriterion("MODULE_ALIAS <=", value, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasLike(String value) {
            addCriterion("MODULE_ALIAS like", value, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasNotLike(String value) {
            addCriterion("MODULE_ALIAS not like", value, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasIn(List<String> values) {
            addCriterion("MODULE_ALIAS in", values, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasNotIn(List<String> values) {
            addCriterion("MODULE_ALIAS not in", values, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasBetween(String value1, String value2) {
            addCriterion("MODULE_ALIAS between", value1, value2, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andModuleAliasNotBetween(String value1, String value2) {
            addCriterion("MODULE_ALIAS not between", value1, value2, "moduleAlias");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodIsNull() {
            addCriterion("SUBMIT_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodIsNotNull() {
            addCriterion("SUBMIT_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodEqualTo(String value) {
            addCriterion("SUBMIT_METHOD =", value, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodNotEqualTo(String value) {
            addCriterion("SUBMIT_METHOD <>", value, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodGreaterThan(String value) {
            addCriterion("SUBMIT_METHOD >", value, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodGreaterThanOrEqualTo(String value) {
            addCriterion("SUBMIT_METHOD >=", value, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodLessThan(String value) {
            addCriterion("SUBMIT_METHOD <", value, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodLessThanOrEqualTo(String value) {
            addCriterion("SUBMIT_METHOD <=", value, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodLike(String value) {
            addCriterion("SUBMIT_METHOD like", value, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodNotLike(String value) {
            addCriterion("SUBMIT_METHOD not like", value, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodIn(List<String> values) {
            addCriterion("SUBMIT_METHOD in", values, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodNotIn(List<String> values) {
            addCriterion("SUBMIT_METHOD not in", values, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodBetween(String value1, String value2) {
            addCriterion("SUBMIT_METHOD between", value1, value2, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andSubmitMethodNotBetween(String value1, String value2) {
            addCriterion("SUBMIT_METHOD not between", value1, value2, "submitMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodIsNull() {
            addCriterion("APPROVAL_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodIsNotNull() {
            addCriterion("APPROVAL_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodEqualTo(String value) {
            addCriterion("APPROVAL_METHOD =", value, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodNotEqualTo(String value) {
            addCriterion("APPROVAL_METHOD <>", value, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodGreaterThan(String value) {
            addCriterion("APPROVAL_METHOD >", value, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVAL_METHOD >=", value, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodLessThan(String value) {
            addCriterion("APPROVAL_METHOD <", value, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodLessThanOrEqualTo(String value) {
            addCriterion("APPROVAL_METHOD <=", value, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodLike(String value) {
            addCriterion("APPROVAL_METHOD like", value, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodNotLike(String value) {
            addCriterion("APPROVAL_METHOD not like", value, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodIn(List<String> values) {
            addCriterion("APPROVAL_METHOD in", values, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodNotIn(List<String> values) {
            addCriterion("APPROVAL_METHOD not in", values, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodBetween(String value1, String value2) {
            addCriterion("APPROVAL_METHOD between", value1, value2, "approvalMethod");
            return (Criteria) this;
        }

        public Criteria andApprovalMethodNotBetween(String value1, String value2) {
            addCriterion("APPROVAL_METHOD not between", value1, value2, "approvalMethod");
            return (Criteria) this;
        }
    }

    /**
     * TB_SYS_APPROVAL_MODULE
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_SYS_APPROVAL_MODULE 2018-02-08
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