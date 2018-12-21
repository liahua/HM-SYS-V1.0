package com.hm.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AccountInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Date value) {
            addCriterionForJDBCDate("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Date value) {
            addCriterionForJDBCDate("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Date value) {
            addCriterionForJDBCDate("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Date> values) {
            addCriterionForJDBCDate("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andManCountIsNull() {
            addCriterion("man_count is null");
            return (Criteria) this;
        }

        public Criteria andManCountIsNotNull() {
            addCriterion("man_count is not null");
            return (Criteria) this;
        }

        public Criteria andManCountEqualTo(Integer value) {
            addCriterion("man_count =", value, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountNotEqualTo(Integer value) {
            addCriterion("man_count <>", value, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountGreaterThan(Integer value) {
            addCriterion("man_count >", value, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("man_count >=", value, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountLessThan(Integer value) {
            addCriterion("man_count <", value, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountLessThanOrEqualTo(Integer value) {
            addCriterion("man_count <=", value, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountIn(List<Integer> values) {
            addCriterion("man_count in", values, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountNotIn(List<Integer> values) {
            addCriterion("man_count not in", values, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountBetween(Integer value1, Integer value2) {
            addCriterion("man_count between", value1, value2, "manCount");
            return (Criteria) this;
        }

        public Criteria andManCountNotBetween(Integer value1, Integer value2) {
            addCriterion("man_count not between", value1, value2, "manCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNull() {
            addCriterion("order_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderCountIsNotNull() {
            addCriterion("order_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCountEqualTo(Integer value) {
            addCriterion("order_count =", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotEqualTo(Integer value) {
            addCriterion("order_count <>", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThan(Integer value) {
            addCriterion("order_count >", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_count >=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThan(Integer value) {
            addCriterion("order_count <", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_count <=", value, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountIn(List<Integer> values) {
            addCriterion("order_count in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotIn(List<Integer> values) {
            addCriterion("order_count not in", values, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("order_count between", value1, value2, "orderCount");
            return (Criteria) this;
        }

        public Criteria andOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_count not between", value1, value2, "orderCount");
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

        public Criteria andOrderMoneyEqualTo(Double value) {
            addCriterion("order_money =", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotEqualTo(Double value) {
            addCriterion("order_money <>", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThan(Double value) {
            addCriterion("order_money >", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("order_money >=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThan(Double value) {
            addCriterion("order_money <", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThanOrEqualTo(Double value) {
            addCriterion("order_money <=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIn(List<Double> values) {
            addCriterion("order_money in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotIn(List<Double> values) {
            addCriterion("order_money not in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyBetween(Double value1, Double value2) {
            addCriterion("order_money between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotBetween(Double value1, Double value2) {
            addCriterion("order_money not between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andCashCountIsNull() {
            addCriterion("cash_count is null");
            return (Criteria) this;
        }

        public Criteria andCashCountIsNotNull() {
            addCriterion("cash_count is not null");
            return (Criteria) this;
        }

        public Criteria andCashCountEqualTo(Double value) {
            addCriterion("cash_count =", value, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountNotEqualTo(Double value) {
            addCriterion("cash_count <>", value, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountGreaterThan(Double value) {
            addCriterion("cash_count >", value, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountGreaterThanOrEqualTo(Double value) {
            addCriterion("cash_count >=", value, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountLessThan(Double value) {
            addCriterion("cash_count <", value, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountLessThanOrEqualTo(Double value) {
            addCriterion("cash_count <=", value, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountIn(List<Double> values) {
            addCriterion("cash_count in", values, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountNotIn(List<Double> values) {
            addCriterion("cash_count not in", values, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountBetween(Double value1, Double value2) {
            addCriterion("cash_count between", value1, value2, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCashCountNotBetween(Double value1, Double value2) {
            addCriterion("cash_count not between", value1, value2, "cashCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountIsNull() {
            addCriterion("checkin_count is null");
            return (Criteria) this;
        }

        public Criteria andCheckinCountIsNotNull() {
            addCriterion("checkin_count is not null");
            return (Criteria) this;
        }

        public Criteria andCheckinCountEqualTo(Double value) {
            addCriterion("checkin_count =", value, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountNotEqualTo(Double value) {
            addCriterion("checkin_count <>", value, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountGreaterThan(Double value) {
            addCriterion("checkin_count >", value, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountGreaterThanOrEqualTo(Double value) {
            addCriterion("checkin_count >=", value, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountLessThan(Double value) {
            addCriterion("checkin_count <", value, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountLessThanOrEqualTo(Double value) {
            addCriterion("checkin_count <=", value, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountIn(List<Double> values) {
            addCriterion("checkin_count in", values, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountNotIn(List<Double> values) {
            addCriterion("checkin_count not in", values, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountBetween(Double value1, Double value2) {
            addCriterion("checkin_count between", value1, value2, "checkinCount");
            return (Criteria) this;
        }

        public Criteria andCheckinCountNotBetween(Double value1, Double value2) {
            addCriterion("checkin_count not between", value1, value2, "checkinCount");
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