package com.maigangle.gyl.facade.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InInstockBillExample {
    /**
     * TB_IN_INSTOCK_BILL
     */
    protected String orderByClause;

    /**
     * TB_IN_INSTOCK_BILL
     */
    protected boolean distinct;

    /**
     * TB_IN_INSTOCK_BILL
     */
    protected List<Criteria> oredCriteria;

    public InInstockBillExample() {
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
     * TB_IN_INSTOCK_BILL 2017-12-07
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

        public Criteria andInstockBillIdIsNull() {
            addCriterion("INSTOCK_BILL_ID is null");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdIsNotNull() {
            addCriterion("INSTOCK_BILL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdEqualTo(String value) {
            addCriterion("INSTOCK_BILL_ID =", value, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdNotEqualTo(String value) {
            addCriterion("INSTOCK_BILL_ID <>", value, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdGreaterThan(String value) {
            addCriterion("INSTOCK_BILL_ID >", value, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdGreaterThanOrEqualTo(String value) {
            addCriterion("INSTOCK_BILL_ID >=", value, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdLessThan(String value) {
            addCriterion("INSTOCK_BILL_ID <", value, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdLessThanOrEqualTo(String value) {
            addCriterion("INSTOCK_BILL_ID <=", value, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdLike(String value) {
            addCriterion("INSTOCK_BILL_ID like", value, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdNotLike(String value) {
            addCriterion("INSTOCK_BILL_ID not like", value, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdIn(List<String> values) {
            addCriterion("INSTOCK_BILL_ID in", values, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdNotIn(List<String> values) {
            addCriterion("INSTOCK_BILL_ID not in", values, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdBetween(String value1, String value2) {
            addCriterion("INSTOCK_BILL_ID between", value1, value2, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockBillIdNotBetween(String value1, String value2) {
            addCriterion("INSTOCK_BILL_ID not between", value1, value2, "instockBillId");
            return (Criteria) this;
        }

        public Criteria andInstockCodeIsNull() {
            addCriterion("INSTOCK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andInstockCodeIsNotNull() {
            addCriterion("INSTOCK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andInstockCodeEqualTo(String value) {
            addCriterion("INSTOCK_CODE =", value, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeNotEqualTo(String value) {
            addCriterion("INSTOCK_CODE <>", value, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeGreaterThan(String value) {
            addCriterion("INSTOCK_CODE >", value, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("INSTOCK_CODE >=", value, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeLessThan(String value) {
            addCriterion("INSTOCK_CODE <", value, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeLessThanOrEqualTo(String value) {
            addCriterion("INSTOCK_CODE <=", value, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeLike(String value) {
            addCriterion("INSTOCK_CODE like", value, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeNotLike(String value) {
            addCriterion("INSTOCK_CODE not like", value, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeIn(List<String> values) {
            addCriterion("INSTOCK_CODE in", values, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeNotIn(List<String> values) {
            addCriterion("INSTOCK_CODE not in", values, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeBetween(String value1, String value2) {
            addCriterion("INSTOCK_CODE between", value1, value2, "instockCode");
            return (Criteria) this;
        }

        public Criteria andInstockCodeNotBetween(String value1, String value2) {
            addCriterion("INSTOCK_CODE not between", value1, value2, "instockCode");
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

        public Criteria andBusinessTypeIsNull() {
            addCriterion("BUSINESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("BUSINESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("BUSINESS_TYPE =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("BUSINESS_TYPE >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("BUSINESS_TYPE <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("BUSINESS_TYPE like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("BUSINESS_TYPE not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("BUSINESS_TYPE in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("BUSINESS_TYPE not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE not between", value1, value2, "businessType");
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

        public Criteria andDepositStatusIsNull() {
            addCriterion("DEPOSIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDepositStatusIsNotNull() {
            addCriterion("DEPOSIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDepositStatusEqualTo(String value) {
            addCriterion("DEPOSIT_STATUS =", value, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusNotEqualTo(String value) {
            addCriterion("DEPOSIT_STATUS <>", value, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusGreaterThan(String value) {
            addCriterion("DEPOSIT_STATUS >", value, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_STATUS >=", value, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusLessThan(String value) {
            addCriterion("DEPOSIT_STATUS <", value, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_STATUS <=", value, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusLike(String value) {
            addCriterion("DEPOSIT_STATUS like", value, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusNotLike(String value) {
            addCriterion("DEPOSIT_STATUS not like", value, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusIn(List<String> values) {
            addCriterion("DEPOSIT_STATUS in", values, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusNotIn(List<String> values) {
            addCriterion("DEPOSIT_STATUS not in", values, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusBetween(String value1, String value2) {
            addCriterion("DEPOSIT_STATUS between", value1, value2, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositStatusNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_STATUS not between", value1, value2, "depositStatus");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdIsNull() {
            addCriterion("DEPOSIT_FINANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdIsNotNull() {
            addCriterion("DEPOSIT_FINANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdEqualTo(String value) {
            addCriterion("DEPOSIT_FINANCE_ID =", value, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdNotEqualTo(String value) {
            addCriterion("DEPOSIT_FINANCE_ID <>", value, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdGreaterThan(String value) {
            addCriterion("DEPOSIT_FINANCE_ID >", value, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_FINANCE_ID >=", value, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdLessThan(String value) {
            addCriterion("DEPOSIT_FINANCE_ID <", value, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdLessThanOrEqualTo(String value) {
            addCriterion("DEPOSIT_FINANCE_ID <=", value, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdLike(String value) {
            addCriterion("DEPOSIT_FINANCE_ID like", value, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdNotLike(String value) {
            addCriterion("DEPOSIT_FINANCE_ID not like", value, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdIn(List<String> values) {
            addCriterion("DEPOSIT_FINANCE_ID in", values, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdNotIn(List<String> values) {
            addCriterion("DEPOSIT_FINANCE_ID not in", values, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdBetween(String value1, String value2) {
            addCriterion("DEPOSIT_FINANCE_ID between", value1, value2, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andDepositFinanceIdNotBetween(String value1, String value2) {
            addCriterion("DEPOSIT_FINANCE_ID not between", value1, value2, "depositFinanceId");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusIsNull() {
            addCriterion("INSPECTION_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusIsNotNull() {
            addCriterion("INSPECTION_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusEqualTo(String value) {
            addCriterion("INSPECTION_STATUS =", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusNotEqualTo(String value) {
            addCriterion("INSPECTION_STATUS <>", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusGreaterThan(String value) {
            addCriterion("INSPECTION_STATUS >", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusGreaterThanOrEqualTo(String value) {
            addCriterion("INSPECTION_STATUS >=", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusLessThan(String value) {
            addCriterion("INSPECTION_STATUS <", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusLessThanOrEqualTo(String value) {
            addCriterion("INSPECTION_STATUS <=", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusLike(String value) {
            addCriterion("INSPECTION_STATUS like", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusNotLike(String value) {
            addCriterion("INSPECTION_STATUS not like", value, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusIn(List<String> values) {
            addCriterion("INSPECTION_STATUS in", values, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusNotIn(List<String> values) {
            addCriterion("INSPECTION_STATUS not in", values, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusBetween(String value1, String value2) {
            addCriterion("INSPECTION_STATUS between", value1, value2, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andInspectionStatusNotBetween(String value1, String value2) {
            addCriterion("INSPECTION_STATUS not between", value1, value2, "inspectionStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusIsNull() {
            addCriterion("FINANCING_LOAN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusIsNotNull() {
            addCriterion("FINANCING_LOAN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusEqualTo(String value) {
            addCriterion("FINANCING_LOAN_STATUS =", value, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusNotEqualTo(String value) {
            addCriterion("FINANCING_LOAN_STATUS <>", value, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusGreaterThan(String value) {
            addCriterion("FINANCING_LOAN_STATUS >", value, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusGreaterThanOrEqualTo(String value) {
            addCriterion("FINANCING_LOAN_STATUS >=", value, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusLessThan(String value) {
            addCriterion("FINANCING_LOAN_STATUS <", value, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusLessThanOrEqualTo(String value) {
            addCriterion("FINANCING_LOAN_STATUS <=", value, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusLike(String value) {
            addCriterion("FINANCING_LOAN_STATUS like", value, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusNotLike(String value) {
            addCriterion("FINANCING_LOAN_STATUS not like", value, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusIn(List<String> values) {
            addCriterion("FINANCING_LOAN_STATUS in", values, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusNotIn(List<String> values) {
            addCriterion("FINANCING_LOAN_STATUS not in", values, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusBetween(String value1, String value2) {
            addCriterion("FINANCING_LOAN_STATUS between", value1, value2, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andFinancingLoanStatusNotBetween(String value1, String value2) {
            addCriterion("FINANCING_LOAN_STATUS not between", value1, value2, "financingLoanStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("PAYMENT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("PAYMENT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(String value) {
            addCriterion("PAYMENT_STATUS =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(String value) {
            addCriterion("PAYMENT_STATUS <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(String value) {
            addCriterion("PAYMENT_STATUS >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_STATUS >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(String value) {
            addCriterion("PAYMENT_STATUS <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_STATUS <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLike(String value) {
            addCriterion("PAYMENT_STATUS like", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotLike(String value) {
            addCriterion("PAYMENT_STATUS not like", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<String> values) {
            addCriterion("PAYMENT_STATUS in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<String> values) {
            addCriterion("PAYMENT_STATUS not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(String value1, String value2) {
            addCriterion("PAYMENT_STATUS between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_STATUS not between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusIsNull() {
            addCriterion("INSTOCK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andInstockStatusIsNotNull() {
            addCriterion("INSTOCK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andInstockStatusEqualTo(String value) {
            addCriterion("INSTOCK_STATUS =", value, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusNotEqualTo(String value) {
            addCriterion("INSTOCK_STATUS <>", value, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusGreaterThan(String value) {
            addCriterion("INSTOCK_STATUS >", value, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusGreaterThanOrEqualTo(String value) {
            addCriterion("INSTOCK_STATUS >=", value, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusLessThan(String value) {
            addCriterion("INSTOCK_STATUS <", value, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusLessThanOrEqualTo(String value) {
            addCriterion("INSTOCK_STATUS <=", value, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusLike(String value) {
            addCriterion("INSTOCK_STATUS like", value, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusNotLike(String value) {
            addCriterion("INSTOCK_STATUS not like", value, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusIn(List<String> values) {
            addCriterion("INSTOCK_STATUS in", values, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusNotIn(List<String> values) {
            addCriterion("INSTOCK_STATUS not in", values, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusBetween(String value1, String value2) {
            addCriterion("INSTOCK_STATUS between", value1, value2, "instockStatus");
            return (Criteria) this;
        }

        public Criteria andInstockStatusNotBetween(String value1, String value2) {
            addCriterion("INSTOCK_STATUS not between", value1, value2, "instockStatus");
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
     * TB_IN_INSTOCK_BILL
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * TB_IN_INSTOCK_BILL 2017-12-07
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