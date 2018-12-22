package com.hm.sys.entity;

import java.util.ArrayList;
import java.util.List;

public class CustomerTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerTypeExample() {
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

        public Criteria andCustomerTypeIsNull() {
            addCriterion("customer_type is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeIsNotNull() {
            addCriterion("customer_type is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeEqualTo(String value) {
            addCriterion("customer_type =", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNotEqualTo(String value) {
            addCriterion("customer_type <>", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeGreaterThan(String value) {
            addCriterion("customer_type >", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("customer_type >=", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeLessThan(String value) {
            addCriterion("customer_type <", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeLessThanOrEqualTo(String value) {
            addCriterion("customer_type <=", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeLike(String value) {
            addCriterion("customer_type like", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNotLike(String value) {
            addCriterion("customer_type not like", value, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeIn(List<String> values) {
            addCriterion("customer_type in", values, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNotIn(List<String> values) {
            addCriterion("customer_type not in", values, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeBetween(String value1, String value2) {
            addCriterion("customer_type between", value1, value2, "customerType");
            return (Criteria) this;
        }

        public Criteria andCustomerTypeNotBetween(String value1, String value2) {
            addCriterion("customer_type not between", value1, value2, "customerType");
            return (Criteria) this;
        }

        public Criteria andDiscountPerIsNull() {
            addCriterion("discount_per is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPerIsNotNull() {
            addCriterion("discount_per is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPerEqualTo(Double value) {
            addCriterion("discount_per =", value, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerNotEqualTo(Double value) {
            addCriterion("discount_per <>", value, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerGreaterThan(Double value) {
            addCriterion("discount_per >", value, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerGreaterThanOrEqualTo(Double value) {
            addCriterion("discount_per >=", value, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerLessThan(Double value) {
            addCriterion("discount_per <", value, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerLessThanOrEqualTo(Double value) {
            addCriterion("discount_per <=", value, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerIn(List<Double> values) {
            addCriterion("discount_per in", values, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerNotIn(List<Double> values) {
            addCriterion("discount_per not in", values, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerBetween(Double value1, Double value2) {
            addCriterion("discount_per between", value1, value2, "discountPer");
            return (Criteria) this;
        }

        public Criteria andDiscountPerNotBetween(Double value1, Double value2) {
            addCriterion("discount_per not between", value1, value2, "discountPer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerIsNull() {
            addCriterion("late_arrive_per is null");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerIsNotNull() {
            addCriterion("late_arrive_per is not null");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerEqualTo(Double value) {
            addCriterion("late_arrive_per =", value, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerNotEqualTo(Double value) {
            addCriterion("late_arrive_per <>", value, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerGreaterThan(Double value) {
            addCriterion("late_arrive_per >", value, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerGreaterThanOrEqualTo(Double value) {
            addCriterion("late_arrive_per >=", value, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerLessThan(Double value) {
            addCriterion("late_arrive_per <", value, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerLessThanOrEqualTo(Double value) {
            addCriterion("late_arrive_per <=", value, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerIn(List<Double> values) {
            addCriterion("late_arrive_per in", values, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerNotIn(List<Double> values) {
            addCriterion("late_arrive_per not in", values, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerBetween(Double value1, Double value2) {
            addCriterion("late_arrive_per between", value1, value2, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andLateArrivePerNotBetween(Double value1, Double value2) {
            addCriterion("late_arrive_per not between", value1, value2, "lateArrivePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerIsNull() {
            addCriterion("early_leave_per is null");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerIsNotNull() {
            addCriterion("early_leave_per is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerEqualTo(Double value) {
            addCriterion("early_leave_per =", value, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerNotEqualTo(Double value) {
            addCriterion("early_leave_per <>", value, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerGreaterThan(Double value) {
            addCriterion("early_leave_per >", value, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerGreaterThanOrEqualTo(Double value) {
            addCriterion("early_leave_per >=", value, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerLessThan(Double value) {
            addCriterion("early_leave_per <", value, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerLessThanOrEqualTo(Double value) {
            addCriterion("early_leave_per <=", value, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerIn(List<Double> values) {
            addCriterion("early_leave_per in", values, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerNotIn(List<Double> values) {
            addCriterion("early_leave_per not in", values, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerBetween(Double value1, Double value2) {
            addCriterion("early_leave_per between", value1, value2, "earlyLeavePer");
            return (Criteria) this;
        }

        public Criteria andEarlyLeavePerNotBetween(Double value1, Double value2) {
            addCriterion("early_leave_per not between", value1, value2, "earlyLeavePer");
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