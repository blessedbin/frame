package com.blessedbin.frame.ucenter.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysArgumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysArgumentExample() {
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

        public Criteria andSysSystemIdIsNull() {
            addCriterion("sys_system_id is null");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdIsNotNull() {
            addCriterion("sys_system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdEqualTo(String value) {
            addCriterion("sys_system_id =", value, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdNotEqualTo(String value) {
            addCriterion("sys_system_id <>", value, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdGreaterThan(String value) {
            addCriterion("sys_system_id >", value, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_system_id >=", value, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdLessThan(String value) {
            addCriterion("sys_system_id <", value, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdLessThanOrEqualTo(String value) {
            addCriterion("sys_system_id <=", value, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdLike(String value) {
            addCriterion("sys_system_id like", value, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdNotLike(String value) {
            addCriterion("sys_system_id not like", value, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdIn(List<String> values) {
            addCriterion("sys_system_id in", values, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdNotIn(List<String> values) {
            addCriterion("sys_system_id not in", values, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdBetween(String value1, String value2) {
            addCriterion("sys_system_id between", value1, value2, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andSysSystemIdNotBetween(String value1, String value2) {
            addCriterion("sys_system_id not between", value1, value2, "sysSystemId");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeIsNull() {
            addCriterion("argument_type is null");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeIsNotNull() {
            addCriterion("argument_type is not null");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeEqualTo(String value) {
            addCriterion("argument_type =", value, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeNotEqualTo(String value) {
            addCriterion("argument_type <>", value, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeGreaterThan(String value) {
            addCriterion("argument_type >", value, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("argument_type >=", value, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeLessThan(String value) {
            addCriterion("argument_type <", value, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeLessThanOrEqualTo(String value) {
            addCriterion("argument_type <=", value, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeLike(String value) {
            addCriterion("argument_type like", value, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeNotLike(String value) {
            addCriterion("argument_type not like", value, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeIn(List<String> values) {
            addCriterion("argument_type in", values, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeNotIn(List<String> values) {
            addCriterion("argument_type not in", values, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeBetween(String value1, String value2) {
            addCriterion("argument_type between", value1, value2, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentTypeNotBetween(String value1, String value2) {
            addCriterion("argument_type not between", value1, value2, "argumentType");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyIsNull() {
            addCriterion("argument_key is null");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyIsNotNull() {
            addCriterion("argument_key is not null");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyEqualTo(String value) {
            addCriterion("argument_key =", value, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyNotEqualTo(String value) {
            addCriterion("argument_key <>", value, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyGreaterThan(String value) {
            addCriterion("argument_key >", value, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyGreaterThanOrEqualTo(String value) {
            addCriterion("argument_key >=", value, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyLessThan(String value) {
            addCriterion("argument_key <", value, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyLessThanOrEqualTo(String value) {
            addCriterion("argument_key <=", value, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyLike(String value) {
            addCriterion("argument_key like", value, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyNotLike(String value) {
            addCriterion("argument_key not like", value, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyIn(List<String> values) {
            addCriterion("argument_key in", values, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyNotIn(List<String> values) {
            addCriterion("argument_key not in", values, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyBetween(String value1, String value2) {
            addCriterion("argument_key between", value1, value2, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentKeyNotBetween(String value1, String value2) {
            addCriterion("argument_key not between", value1, value2, "argumentKey");
            return (Criteria) this;
        }

        public Criteria andArgumentNameIsNull() {
            addCriterion("argument_name is null");
            return (Criteria) this;
        }

        public Criteria andArgumentNameIsNotNull() {
            addCriterion("argument_name is not null");
            return (Criteria) this;
        }

        public Criteria andArgumentNameEqualTo(String value) {
            addCriterion("argument_name =", value, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameNotEqualTo(String value) {
            addCriterion("argument_name <>", value, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameGreaterThan(String value) {
            addCriterion("argument_name >", value, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameGreaterThanOrEqualTo(String value) {
            addCriterion("argument_name >=", value, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameLessThan(String value) {
            addCriterion("argument_name <", value, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameLessThanOrEqualTo(String value) {
            addCriterion("argument_name <=", value, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameLike(String value) {
            addCriterion("argument_name like", value, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameNotLike(String value) {
            addCriterion("argument_name not like", value, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameIn(List<String> values) {
            addCriterion("argument_name in", values, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameNotIn(List<String> values) {
            addCriterion("argument_name not in", values, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameBetween(String value1, String value2) {
            addCriterion("argument_name between", value1, value2, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentNameNotBetween(String value1, String value2) {
            addCriterion("argument_name not between", value1, value2, "argumentName");
            return (Criteria) this;
        }

        public Criteria andArgumentValueIsNull() {
            addCriterion("argument_value is null");
            return (Criteria) this;
        }

        public Criteria andArgumentValueIsNotNull() {
            addCriterion("argument_value is not null");
            return (Criteria) this;
        }

        public Criteria andArgumentValueEqualTo(String value) {
            addCriterion("argument_value =", value, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueNotEqualTo(String value) {
            addCriterion("argument_value <>", value, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueGreaterThan(String value) {
            addCriterion("argument_value >", value, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueGreaterThanOrEqualTo(String value) {
            addCriterion("argument_value >=", value, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueLessThan(String value) {
            addCriterion("argument_value <", value, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueLessThanOrEqualTo(String value) {
            addCriterion("argument_value <=", value, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueLike(String value) {
            addCriterion("argument_value like", value, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueNotLike(String value) {
            addCriterion("argument_value not like", value, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueIn(List<String> values) {
            addCriterion("argument_value in", values, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueNotIn(List<String> values) {
            addCriterion("argument_value not in", values, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueBetween(String value1, String value2) {
            addCriterion("argument_value between", value1, value2, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andArgumentValueNotBetween(String value1, String value2) {
            addCriterion("argument_value not between", value1, value2, "argumentValue");
            return (Criteria) this;
        }

        public Criteria andSetHintIsNull() {
            addCriterion("set_hint is null");
            return (Criteria) this;
        }

        public Criteria andSetHintIsNotNull() {
            addCriterion("set_hint is not null");
            return (Criteria) this;
        }

        public Criteria andSetHintEqualTo(String value) {
            addCriterion("set_hint =", value, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintNotEqualTo(String value) {
            addCriterion("set_hint <>", value, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintGreaterThan(String value) {
            addCriterion("set_hint >", value, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintGreaterThanOrEqualTo(String value) {
            addCriterion("set_hint >=", value, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintLessThan(String value) {
            addCriterion("set_hint <", value, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintLessThanOrEqualTo(String value) {
            addCriterion("set_hint <=", value, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintLike(String value) {
            addCriterion("set_hint like", value, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintNotLike(String value) {
            addCriterion("set_hint not like", value, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintIn(List<String> values) {
            addCriterion("set_hint in", values, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintNotIn(List<String> values) {
            addCriterion("set_hint not in", values, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintBetween(String value1, String value2) {
            addCriterion("set_hint between", value1, value2, "setHint");
            return (Criteria) this;
        }

        public Criteria andSetHintNotBetween(String value1, String value2) {
            addCriterion("set_hint not between", value1, value2, "setHint");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationIsNull() {
            addCriterion("addition_information is null");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationIsNotNull() {
            addCriterion("addition_information is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationEqualTo(String value) {
            addCriterion("addition_information =", value, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationNotEqualTo(String value) {
            addCriterion("addition_information <>", value, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationGreaterThan(String value) {
            addCriterion("addition_information >", value, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationGreaterThanOrEqualTo(String value) {
            addCriterion("addition_information >=", value, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationLessThan(String value) {
            addCriterion("addition_information <", value, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationLessThanOrEqualTo(String value) {
            addCriterion("addition_information <=", value, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationLike(String value) {
            addCriterion("addition_information like", value, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationNotLike(String value) {
            addCriterion("addition_information not like", value, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationIn(List<String> values) {
            addCriterion("addition_information in", values, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationNotIn(List<String> values) {
            addCriterion("addition_information not in", values, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationBetween(String value1, String value2) {
            addCriterion("addition_information between", value1, value2, "additionInformation");
            return (Criteria) this;
        }

        public Criteria andAdditionInformationNotBetween(String value1, String value2) {
            addCriterion("addition_information not between", value1, value2, "additionInformation");
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