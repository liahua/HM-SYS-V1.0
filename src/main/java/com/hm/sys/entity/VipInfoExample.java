package com.hm.sys.entity;

import java.util.ArrayList;
import java.util.List;

public class VipInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VipInfoExample() {
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

        public Criteria andVipNameIsNull() {
            addCriterion("vip_name is null");
            return (Criteria) this;
        }

        public Criteria andVipNameIsNotNull() {
            addCriterion("vip_name is not null");
            return (Criteria) this;
        }

        public Criteria andVipNameEqualTo(String value) {
            addCriterion("vip_name =", value, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameNotEqualTo(String value) {
            addCriterion("vip_name <>", value, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameGreaterThan(String value) {
            addCriterion("vip_name >", value, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameGreaterThanOrEqualTo(String value) {
            addCriterion("vip_name >=", value, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameLessThan(String value) {
            addCriterion("vip_name <", value, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameLessThanOrEqualTo(String value) {
            addCriterion("vip_name <=", value, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameLike(String value) {
            addCriterion("vip_name like", value, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameNotLike(String value) {
            addCriterion("vip_name not like", value, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameIn(List<String> values) {
            addCriterion("vip_name in", values, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameNotIn(List<String> values) {
            addCriterion("vip_name not in", values, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameBetween(String value1, String value2) {
            addCriterion("vip_name between", value1, value2, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipNameNotBetween(String value1, String value2) {
            addCriterion("vip_name not between", value1, value2, "vipName");
            return (Criteria) this;
        }

        public Criteria andVipTelIsNull() {
            addCriterion("vip_tel is null");
            return (Criteria) this;
        }

        public Criteria andVipTelIsNotNull() {
            addCriterion("vip_tel is not null");
            return (Criteria) this;
        }

        public Criteria andVipTelEqualTo(Integer value) {
            addCriterion("vip_tel =", value, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelNotEqualTo(Integer value) {
            addCriterion("vip_tel <>", value, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelGreaterThan(Integer value) {
            addCriterion("vip_tel >", value, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip_tel >=", value, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelLessThan(Integer value) {
            addCriterion("vip_tel <", value, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelLessThanOrEqualTo(Integer value) {
            addCriterion("vip_tel <=", value, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelIn(List<Integer> values) {
            addCriterion("vip_tel in", values, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelNotIn(List<Integer> values) {
            addCriterion("vip_tel not in", values, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelBetween(Integer value1, Integer value2) {
            addCriterion("vip_tel between", value1, value2, "vipTel");
            return (Criteria) this;
        }

        public Criteria andVipTelNotBetween(Integer value1, Integer value2) {
            addCriterion("vip_tel not between", value1, value2, "vipTel");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
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