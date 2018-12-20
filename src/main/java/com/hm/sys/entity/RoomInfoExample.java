package com.hm.sys.entity;

import java.util.ArrayList;
import java.util.List;

public class RoomInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomInfoExample() {
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

        public Criteria andRtIdIsNull() {
            addCriterion("rt_id is null");
            return (Criteria) this;
        }

        public Criteria andRtIdIsNotNull() {
            addCriterion("rt_id is not null");
            return (Criteria) this;
        }

        public Criteria andRtIdEqualTo(Integer value) {
            addCriterion("rt_id =", value, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdNotEqualTo(Integer value) {
            addCriterion("rt_id <>", value, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdGreaterThan(Integer value) {
            addCriterion("rt_id >", value, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rt_id >=", value, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdLessThan(Integer value) {
            addCriterion("rt_id <", value, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdLessThanOrEqualTo(Integer value) {
            addCriterion("rt_id <=", value, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdIn(List<Integer> values) {
            addCriterion("rt_id in", values, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdNotIn(List<Integer> values) {
            addCriterion("rt_id not in", values, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdBetween(Integer value1, Integer value2) {
            addCriterion("rt_id between", value1, value2, "rtId");
            return (Criteria) this;
        }

        public Criteria andRtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rt_id not between", value1, value2, "rtId");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomAddIsNull() {
            addCriterion("room_add is null");
            return (Criteria) this;
        }

        public Criteria andRoomAddIsNotNull() {
            addCriterion("room_add is not null");
            return (Criteria) this;
        }

        public Criteria andRoomAddEqualTo(String value) {
            addCriterion("room_add =", value, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddNotEqualTo(String value) {
            addCriterion("room_add <>", value, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddGreaterThan(String value) {
            addCriterion("room_add >", value, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddGreaterThanOrEqualTo(String value) {
            addCriterion("room_add >=", value, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddLessThan(String value) {
            addCriterion("room_add <", value, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddLessThanOrEqualTo(String value) {
            addCriterion("room_add <=", value, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddLike(String value) {
            addCriterion("room_add like", value, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddNotLike(String value) {
            addCriterion("room_add not like", value, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddIn(List<String> values) {
            addCriterion("room_add in", values, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddNotIn(List<String> values) {
            addCriterion("room_add not in", values, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddBetween(String value1, String value2) {
            addCriterion("room_add between", value1, value2, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andRoomAddNotBetween(String value1, String value2) {
            addCriterion("room_add not between", value1, value2, "roomAdd");
            return (Criteria) this;
        }

        public Criteria andBedNumIsNull() {
            addCriterion("bed_num is null");
            return (Criteria) this;
        }

        public Criteria andBedNumIsNotNull() {
            addCriterion("bed_num is not null");
            return (Criteria) this;
        }

        public Criteria andBedNumEqualTo(Integer value) {
            addCriterion("bed_num =", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotEqualTo(Integer value) {
            addCriterion("bed_num <>", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumGreaterThan(Integer value) {
            addCriterion("bed_num >", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bed_num >=", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumLessThan(Integer value) {
            addCriterion("bed_num <", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumLessThanOrEqualTo(Integer value) {
            addCriterion("bed_num <=", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumIn(List<Integer> values) {
            addCriterion("bed_num in", values, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotIn(List<Integer> values) {
            addCriterion("bed_num not in", values, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumBetween(Integer value1, Integer value2) {
            addCriterion("bed_num between", value1, value2, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("bed_num not between", value1, value2, "bedNum");
            return (Criteria) this;
        }

        public Criteria andStatuIdIsNull() {
            addCriterion("statu_id is null");
            return (Criteria) this;
        }

        public Criteria andStatuIdIsNotNull() {
            addCriterion("statu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStatuIdEqualTo(Integer value) {
            addCriterion("statu_id =", value, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdNotEqualTo(Integer value) {
            addCriterion("statu_id <>", value, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdGreaterThan(Integer value) {
            addCriterion("statu_id >", value, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("statu_id >=", value, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdLessThan(Integer value) {
            addCriterion("statu_id <", value, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdLessThanOrEqualTo(Integer value) {
            addCriterion("statu_id <=", value, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdIn(List<Integer> values) {
            addCriterion("statu_id in", values, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdNotIn(List<Integer> values) {
            addCriterion("statu_id not in", values, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdBetween(Integer value1, Integer value2) {
            addCriterion("statu_id between", value1, value2, "statuId");
            return (Criteria) this;
        }

        public Criteria andStatuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("statu_id not between", value1, value2, "statuId");
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