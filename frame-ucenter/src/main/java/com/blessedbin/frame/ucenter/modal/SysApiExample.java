package com.blessedbin.frame.ucenter.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysApiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysApiExample() {
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

        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(Integer value) {
            addCriterion("permission_id =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(Integer value) {
            addCriterion("permission_id <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(Integer value) {
            addCriterion("permission_id >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_id >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(Integer value) {
            addCriterion("permission_id <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("permission_id <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<Integer> values) {
            addCriterion("permission_id in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<Integer> values) {
            addCriterion("permission_id not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(Integer value1, Integer value2) {
            addCriterion("permission_id between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andUrlsIsNull() {
            addCriterion("urls is null");
            return (Criteria) this;
        }

        public Criteria andUrlsIsNotNull() {
            addCriterion("urls is not null");
            return (Criteria) this;
        }

        public Criteria andUrlsEqualTo(String value) {
            addCriterion("urls =", value, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsNotEqualTo(String value) {
            addCriterion("urls <>", value, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsGreaterThan(String value) {
            addCriterion("urls >", value, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("urls >=", value, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsLessThan(String value) {
            addCriterion("urls <", value, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsLessThanOrEqualTo(String value) {
            addCriterion("urls <=", value, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsLike(String value) {
            addCriterion("urls like", value, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsNotLike(String value) {
            addCriterion("urls not like", value, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsIn(List<String> values) {
            addCriterion("urls in", values, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsNotIn(List<String> values) {
            addCriterion("urls not in", values, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsBetween(String value1, String value2) {
            addCriterion("urls between", value1, value2, "urls");
            return (Criteria) this;
        }

        public Criteria andUrlsNotBetween(String value1, String value2) {
            addCriterion("urls not between", value1, value2, "urls");
            return (Criteria) this;
        }

        public Criteria andMethodTypesIsNull() {
            addCriterion("method_types is null");
            return (Criteria) this;
        }

        public Criteria andMethodTypesIsNotNull() {
            addCriterion("method_types is not null");
            return (Criteria) this;
        }

        public Criteria andMethodTypesEqualTo(String value) {
            addCriterion("method_types =", value, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesNotEqualTo(String value) {
            addCriterion("method_types <>", value, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesGreaterThan(String value) {
            addCriterion("method_types >", value, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesGreaterThanOrEqualTo(String value) {
            addCriterion("method_types >=", value, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesLessThan(String value) {
            addCriterion("method_types <", value, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesLessThanOrEqualTo(String value) {
            addCriterion("method_types <=", value, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesLike(String value) {
            addCriterion("method_types like", value, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesNotLike(String value) {
            addCriterion("method_types not like", value, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesIn(List<String> values) {
            addCriterion("method_types in", values, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesNotIn(List<String> values) {
            addCriterion("method_types not in", values, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesBetween(String value1, String value2) {
            addCriterion("method_types between", value1, value2, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodTypesNotBetween(String value1, String value2) {
            addCriterion("method_types not between", value1, value2, "methodTypes");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNull() {
            addCriterion("method_name is null");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNotNull() {
            addCriterion("method_name is not null");
            return (Criteria) this;
        }

        public Criteria andMethodNameEqualTo(String value) {
            addCriterion("method_name =", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotEqualTo(String value) {
            addCriterion("method_name <>", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThan(String value) {
            addCriterion("method_name >", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("method_name >=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThan(String value) {
            addCriterion("method_name <", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThanOrEqualTo(String value) {
            addCriterion("method_name <=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLike(String value) {
            addCriterion("method_name like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotLike(String value) {
            addCriterion("method_name not like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameIn(List<String> values) {
            addCriterion("method_name in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotIn(List<String> values) {
            addCriterion("method_name not in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameBetween(String value1, String value2) {
            addCriterion("method_name between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotBetween(String value1, String value2) {
            addCriterion("method_name not between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andControllerNameIsNull() {
            addCriterion("controller_name is null");
            return (Criteria) this;
        }

        public Criteria andControllerNameIsNotNull() {
            addCriterion("controller_name is not null");
            return (Criteria) this;
        }

        public Criteria andControllerNameEqualTo(String value) {
            addCriterion("controller_name =", value, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameNotEqualTo(String value) {
            addCriterion("controller_name <>", value, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameGreaterThan(String value) {
            addCriterion("controller_name >", value, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameGreaterThanOrEqualTo(String value) {
            addCriterion("controller_name >=", value, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameLessThan(String value) {
            addCriterion("controller_name <", value, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameLessThanOrEqualTo(String value) {
            addCriterion("controller_name <=", value, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameLike(String value) {
            addCriterion("controller_name like", value, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameNotLike(String value) {
            addCriterion("controller_name not like", value, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameIn(List<String> values) {
            addCriterion("controller_name in", values, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameNotIn(List<String> values) {
            addCriterion("controller_name not in", values, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameBetween(String value1, String value2) {
            addCriterion("controller_name between", value1, value2, "controllerName");
            return (Criteria) this;
        }

        public Criteria andControllerNameNotBetween(String value1, String value2) {
            addCriterion("controller_name not between", value1, value2, "controllerName");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesIsNull() {
            addCriterion("method_param_types is null");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesIsNotNull() {
            addCriterion("method_param_types is not null");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesEqualTo(String value) {
            addCriterion("method_param_types =", value, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesNotEqualTo(String value) {
            addCriterion("method_param_types <>", value, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesGreaterThan(String value) {
            addCriterion("method_param_types >", value, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesGreaterThanOrEqualTo(String value) {
            addCriterion("method_param_types >=", value, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesLessThan(String value) {
            addCriterion("method_param_types <", value, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesLessThanOrEqualTo(String value) {
            addCriterion("method_param_types <=", value, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesLike(String value) {
            addCriterion("method_param_types like", value, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesNotLike(String value) {
            addCriterion("method_param_types not like", value, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesIn(List<String> values) {
            addCriterion("method_param_types in", values, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesNotIn(List<String> values) {
            addCriterion("method_param_types not in", values, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesBetween(String value1, String value2) {
            addCriterion("method_param_types between", value1, value2, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamTypesNotBetween(String value1, String value2) {
            addCriterion("method_param_types not between", value1, value2, "methodParamTypes");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesIsNull() {
            addCriterion("method_param_names is null");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesIsNotNull() {
            addCriterion("method_param_names is not null");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesEqualTo(String value) {
            addCriterion("method_param_names =", value, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesNotEqualTo(String value) {
            addCriterion("method_param_names <>", value, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesGreaterThan(String value) {
            addCriterion("method_param_names >", value, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesGreaterThanOrEqualTo(String value) {
            addCriterion("method_param_names >=", value, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesLessThan(String value) {
            addCriterion("method_param_names <", value, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesLessThanOrEqualTo(String value) {
            addCriterion("method_param_names <=", value, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesLike(String value) {
            addCriterion("method_param_names like", value, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesNotLike(String value) {
            addCriterion("method_param_names not like", value, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesIn(List<String> values) {
            addCriterion("method_param_names in", values, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesNotIn(List<String> values) {
            addCriterion("method_param_names not in", values, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesBetween(String value1, String value2) {
            addCriterion("method_param_names between", value1, value2, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andMethodParamNamesNotBetween(String value1, String value2) {
            addCriterion("method_param_names not between", value1, value2, "methodParamNames");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
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

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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