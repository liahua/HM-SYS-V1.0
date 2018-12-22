package com.hm.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStayIdIsNull() {
            addCriterion("stay_id is null");
            return (Criteria) this;
        }

        public Criteria andStayIdIsNotNull() {
            addCriterion("stay_id is not null");
            return (Criteria) this;
        }

        public Criteria andStayIdEqualTo(Integer value) {
            addCriterion("stay_id =", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotEqualTo(Integer value) {
            addCriterion("stay_id <>", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdGreaterThan(Integer value) {
            addCriterion("stay_id >", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stay_id >=", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdLessThan(Integer value) {
            addCriterion("stay_id <", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdLessThanOrEqualTo(Integer value) {
            addCriterion("stay_id <=", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdIn(List<Integer> values) {
            addCriterion("stay_id in", values, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotIn(List<Integer> values) {
            addCriterion("stay_id not in", values, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdBetween(Integer value1, Integer value2) {
            addCriterion("stay_id between", value1, value2, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stay_id not between", value1, value2, "stayId");
            return (Criteria) this;
        }

        public Criteria andDueMoneyIsNull() {
            addCriterion("due_money is null");
            return (Criteria) this;
        }

        public Criteria andDueMoneyIsNotNull() {
            addCriterion("due_money is not null");
            return (Criteria) this;
        }

        public Criteria andDueMoneyEqualTo(Float value) {
            addCriterion("due_money =", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyNotEqualTo(Float value) {
            addCriterion("due_money <>", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyGreaterThan(Float value) {
            addCriterion("due_money >", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("due_money >=", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyLessThan(Float value) {
            addCriterion("due_money <", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyLessThanOrEqualTo(Float value) {
            addCriterion("due_money <=", value, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyIn(List<Float> values) {
            addCriterion("due_money in", values, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyNotIn(List<Float> values) {
            addCriterion("due_money not in", values, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyBetween(Float value1, Float value2) {
            addCriterion("due_money between", value1, value2, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andDueMoneyNotBetween(Float value1, Float value2) {
            addCriterion("due_money not between", value1, value2, "dueMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIsNull() {
            addCriterion("order_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIsNotNull() {
            addCriterion("order_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyEqualTo(Float value) {
            addCriterion("order_money =", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotEqualTo(Float value) {
            addCriterion("order_money <>", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThan(Float value) {
            addCriterion("order_money >", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("order_money >=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThan(Float value) {
            addCriterion("order_money <", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThanOrEqualTo(Float value) {
            addCriterion("order_money <=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIn(List<Float> values) {
            addCriterion("order_money in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotIn(List<Float> values) {
            addCriterion("order_money not in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyBetween(Float value1, Float value2) {
            addCriterion("order_money between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotBetween(Float value1, Float value2) {
            addCriterion("order_money not between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNull() {
            addCriterion("discount_type is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNotNull() {
            addCriterion("discount_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeEqualTo(String value) {
            addCriterion("discount_type =", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotEqualTo(String value) {
            addCriterion("discount_type <>", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThan(String value) {
            addCriterion("discount_type >", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("discount_type >=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThan(String value) {
            addCriterion("discount_type <", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThanOrEqualTo(String value) {
            addCriterion("discount_type <=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLike(String value) {
            addCriterion("discount_type like", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotLike(String value) {
            addCriterion("discount_type not like", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIn(List<String> values) {
            addCriterion("discount_type in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotIn(List<String> values) {
            addCriterion("discount_type not in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeBetween(String value1, String value2) {
            addCriterion("discount_type between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotBetween(String value1, String value2) {
            addCriterion("discount_type not between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNull() {
            addCriterion("discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNotNull() {
            addCriterion("discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateEqualTo(Float value) {
            addCriterion("discount_rate =", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotEqualTo(Float value) {
            addCriterion("discount_rate <>", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThan(Float value) {
            addCriterion("discount_rate >", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThanOrEqualTo(Float value) {
            addCriterion("discount_rate >=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThan(Float value) {
            addCriterion("discount_rate <", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThanOrEqualTo(Float value) {
            addCriterion("discount_rate <=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIn(List<Float> values) {
            addCriterion("discount_rate in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotIn(List<Float> values) {
            addCriterion("discount_rate not in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateBetween(Float value1, Float value2) {
            addCriterion("discount_rate between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotBetween(Float value1, Float value2) {
            addCriterion("discount_rate not between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyIsNull() {
            addCriterion("paid_up_money is null");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyIsNotNull() {
            addCriterion("paid_up_money is not null");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyEqualTo(Float value) {
            addCriterion("paid_up_money =", value, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyNotEqualTo(Float value) {
            addCriterion("paid_up_money <>", value, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyGreaterThan(Float value) {
            addCriterion("paid_up_money >", value, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("paid_up_money >=", value, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyLessThan(Float value) {
            addCriterion("paid_up_money <", value, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyLessThanOrEqualTo(Float value) {
            addCriterion("paid_up_money <=", value, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyIn(List<Float> values) {
            addCriterion("paid_up_money in", values, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyNotIn(List<Float> values) {
            addCriterion("paid_up_money not in", values, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyBetween(Float value1, Float value2) {
            addCriterion("paid_up_money between", value1, value2, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andPaidUpMoneyNotBetween(Float value1, Float value2) {
            addCriterion("paid_up_money not between", value1, value2, "paidUpMoney");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("check_date is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("check_date is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(Date value) {
            addCriterion("check_date =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(Date value) {
            addCriterion("check_date <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(Date value) {
            addCriterion("check_date >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterion("check_date >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(Date value) {
            addCriterion("check_date <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(Date value) {
            addCriterion("check_date <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<Date> values) {
            addCriterion("check_date in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<Date> values) {
            addCriterion("check_date not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(Date value1, Date value2) {
            addCriterion("check_date between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(Date value1, Date value2) {
            addCriterion("check_date not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeIsNull() {
            addCriterion("createdTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeIsNotNull() {
            addCriterion("createdTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeEqualTo(Date value) {
            addCriterion("createdTime =", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeNotEqualTo(Date value) {
            addCriterion("createdTime <>", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeGreaterThan(Date value) {
            addCriterion("createdTime >", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createdTime >=", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeLessThan(Date value) {
            addCriterion("createdTime <", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeLessThanOrEqualTo(Date value) {
            addCriterion("createdTime <=", value, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeIn(List<Date> values) {
            addCriterion("createdTime in", values, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeNotIn(List<Date> values) {
            addCriterion("createdTime not in", values, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeBetween(Date value1, Date value2) {
            addCriterion("createdTime between", value1, value2, "createdtime");
            return (Criteria) this;
        }

        public Criteria andCreatedtimeNotBetween(Date value1, Date value2) {
            addCriterion("createdTime not between", value1, value2, "createdtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNull() {
            addCriterion("modifiedTime is null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNotNull() {
            addCriterion("modifiedTime is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeEqualTo(Date value) {
            addCriterion("modifiedTime =", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotEqualTo(Date value) {
            addCriterion("modifiedTime <>", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThan(Date value) {
            addCriterion("modifiedTime >", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modifiedTime >=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThan(Date value) {
            addCriterion("modifiedTime <", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThanOrEqualTo(Date value) {
            addCriterion("modifiedTime <=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIn(List<Date> values) {
            addCriterion("modifiedTime in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotIn(List<Date> values) {
            addCriterion("modifiedTime not in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeBetween(Date value1, Date value2) {
            addCriterion("modifiedTime between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotBetween(Date value1, Date value2) {
            addCriterion("modifiedTime not between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andCashPledgeIsNull() {
            addCriterion("cash_pledge is null");
            return (Criteria) this;
        }

        public Criteria andCashPledgeIsNotNull() {
            addCriterion("cash_pledge is not null");
            return (Criteria) this;
        }

        public Criteria andCashPledgeEqualTo(Float value) {
            addCriterion("cash_pledge =", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeNotEqualTo(Float value) {
            addCriterion("cash_pledge <>", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeGreaterThan(Float value) {
            addCriterion("cash_pledge >", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeGreaterThanOrEqualTo(Float value) {
            addCriterion("cash_pledge >=", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeLessThan(Float value) {
            addCriterion("cash_pledge <", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeLessThanOrEqualTo(Float value) {
            addCriterion("cash_pledge <=", value, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeIn(List<Float> values) {
            addCriterion("cash_pledge in", values, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeNotIn(List<Float> values) {
            addCriterion("cash_pledge not in", values, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeBetween(Float value1, Float value2) {
            addCriterion("cash_pledge between", value1, value2, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andCashPledgeNotBetween(Float value1, Float value2) {
            addCriterion("cash_pledge not between", value1, value2, "cashPledge");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayIsNull() {
            addCriterion("late_arrival_need_pay is null");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayIsNotNull() {
            addCriterion("late_arrival_need_pay is not null");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayEqualTo(Float value) {
            addCriterion("late_arrival_need_pay =", value, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayNotEqualTo(Float value) {
            addCriterion("late_arrival_need_pay <>", value, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayGreaterThan(Float value) {
            addCriterion("late_arrival_need_pay >", value, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayGreaterThanOrEqualTo(Float value) {
            addCriterion("late_arrival_need_pay >=", value, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayLessThan(Float value) {
            addCriterion("late_arrival_need_pay <", value, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayLessThanOrEqualTo(Float value) {
            addCriterion("late_arrival_need_pay <=", value, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayIn(List<Float> values) {
            addCriterion("late_arrival_need_pay in", values, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayNotIn(List<Float> values) {
            addCriterion("late_arrival_need_pay not in", values, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayBetween(Float value1, Float value2) {
            addCriterion("late_arrival_need_pay between", value1, value2, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andLateArrivalNeedPayNotBetween(Float value1, Float value2) {
            addCriterion("late_arrival_need_pay not between", value1, value2, "lateArrivalNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayIsNull() {
            addCriterion("early_leave-need_pay is null");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayIsNotNull() {
            addCriterion("early_leave-need_pay is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayEqualTo(Float value) {
            addCriterion("early_leave-need_pay =", value, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayNotEqualTo(Float value) {
            addCriterion("early_leave-need_pay <>", value, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayGreaterThan(Float value) {
            addCriterion("early_leave-need_pay >", value, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayGreaterThanOrEqualTo(Float value) {
            addCriterion("early_leave-need_pay >=", value, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayLessThan(Float value) {
            addCriterion("early_leave-need_pay <", value, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayLessThanOrEqualTo(Float value) {
            addCriterion("early_leave-need_pay <=", value, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayIn(List<Float> values) {
            addCriterion("early_leave-need_pay in", values, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayNotIn(List<Float> values) {
            addCriterion("early_leave-need_pay not in", values, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayBetween(Float value1, Float value2) {
            addCriterion("early_leave-need_pay between", value1, value2, "earlyLeaveNeedPay");
            return (Criteria) this;
        }

        public Criteria andEarlyLeaveNeedPayNotBetween(Float value1, Float value2) {
            addCriterion("early_leave-need_pay not between", value1, value2, "earlyLeaveNeedPay");
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