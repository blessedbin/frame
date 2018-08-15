package com.blessedbin.frame.ucenter.modal;

import java.util.ArrayList;
import java.util.List;

public class SysMenuHasApiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMenuHasApiExample() {
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

        public Criteria andSysMenuPermissionIdIsNull() {
            addCriterion("sys_menu_permission_id is null");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdIsNotNull() {
            addCriterion("sys_menu_permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdEqualTo(Integer value) {
            addCriterion("sys_menu_permission_id =", value, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdNotEqualTo(Integer value) {
            addCriterion("sys_menu_permission_id <>", value, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdGreaterThan(Integer value) {
            addCriterion("sys_menu_permission_id >", value, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_menu_permission_id >=", value, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdLessThan(Integer value) {
            addCriterion("sys_menu_permission_id <", value, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_menu_permission_id <=", value, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdIn(List<Integer> values) {
            addCriterion("sys_menu_permission_id in", values, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdNotIn(List<Integer> values) {
            addCriterion("sys_menu_permission_id not in", values, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_menu_permission_id between", value1, value2, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysMenuPermissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_menu_permission_id not between", value1, value2, "sysMenuPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdIsNull() {
            addCriterion("sys_api_permission_id is null");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdIsNotNull() {
            addCriterion("sys_api_permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdEqualTo(Integer value) {
            addCriterion("sys_api_permission_id =", value, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdNotEqualTo(Integer value) {
            addCriterion("sys_api_permission_id <>", value, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdGreaterThan(Integer value) {
            addCriterion("sys_api_permission_id >", value, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_api_permission_id >=", value, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdLessThan(Integer value) {
            addCriterion("sys_api_permission_id <", value, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_api_permission_id <=", value, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdIn(List<Integer> values) {
            addCriterion("sys_api_permission_id in", values, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdNotIn(List<Integer> values) {
            addCriterion("sys_api_permission_id not in", values, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_api_permission_id between", value1, value2, "sysApiPermissionId");
            return (Criteria) this;
        }

        public Criteria andSysApiPermissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_api_permission_id not between", value1, value2, "sysApiPermissionId");
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