package com.blessedbin.frame.ucenter.modal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Table(name = "sys_api")
public class SysApi {
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * mapping名称，用于展示
     */
    private String name;

    private String urls;

    /**
     * 请求方式 ,分隔
     */
    @Column(name = "method_types")
    private String methodTypes;

    /**
     * 方法名
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 控制器名
     */
    @Column(name = "controller_name")
    private String controllerName;

    /**
     * 请求参数类型
     */
    @Column(name = "method_param_types")
    private String methodParamTypes;

    /**
     * 请求参数名称，与类型一一对应
     */
    @Column(name = "method_param_names")
    private String methodParamNames;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private Integer sort;

    /**
     * api 描述
     */
    private String description;

    /**
     * @return permission_id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取mapping名称，用于展示
     *
     * @return name - mapping名称，用于展示
     */
    public String getName() {
        return name;
    }

    /**
     * 设置mapping名称，用于展示
     *
     * @param name mapping名称，用于展示
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return urls
     */
    public String getUrls() {
        return urls;
    }

    /**
     * @param urls
     */
    public void setUrls(String urls) {
        this.urls = urls == null ? null : urls.trim();
    }

    /**
     * 获取请求方式 ,分隔
     *
     * @return method_types - 请求方式 ,分隔
     */
    public String getMethodTypes() {
        return methodTypes;
    }

    /**
     * 设置请求方式 ,分隔
     *
     * @param methodTypes 请求方式 ,分隔
     */
    public void setMethodTypes(String methodTypes) {
        this.methodTypes = methodTypes == null ? null : methodTypes.trim();
    }

    /**
     * 获取方法名
     *
     * @return method_name - 方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置方法名
     *
     * @param methodName 方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * 获取控制器名
     *
     * @return controller_name - 控制器名
     */
    public String getControllerName() {
        return controllerName;
    }

    /**
     * 设置控制器名
     *
     * @param controllerName 控制器名
     */
    public void setControllerName(String controllerName) {
        this.controllerName = controllerName == null ? null : controllerName.trim();
    }

    /**
     * 获取请求参数类型
     *
     * @return method_param_types - 请求参数类型
     */
    public String getMethodParamTypes() {
        return methodParamTypes;
    }

    /**
     * 设置请求参数类型
     *
     * @param methodParamTypes 请求参数类型
     */
    public void setMethodParamTypes(String methodParamTypes) {
        this.methodParamTypes = methodParamTypes == null ? null : methodParamTypes.trim();
    }

    /**
     * 获取请求参数名称，与类型一一对应
     *
     * @return method_param_names - 请求参数名称，与类型一一对应
     */
    public String getMethodParamNames() {
        return methodParamNames;
    }

    /**
     * 设置请求参数名称，与类型一一对应
     *
     * @param methodParamNames 请求参数名称，与类型一一对应
     */
    public void setMethodParamNames(String methodParamNames) {
        this.methodParamNames = methodParamNames == null ? null : methodParamNames.trim();
    }

    /**
     * 获取备注
     *
     * @return description - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取api 描述
     *
     * @return description - api 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置api 描述
     *
     * @param description api 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "SysApi{" +
                "permissionId=" + permissionId +
                ", name='" + name + '\'' +
                ", urls='" + urls + '\'' +
                ", methodTypes='" + methodTypes + '\'' +
                ", methodName='" + methodName + '\'' +
                ", controllerName='" + controllerName + '\'' +
                ", methodParamTypes='" + methodParamTypes + '\'' +
                ", methodParamNames='" + methodParamNames + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sort=" + sort +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysApi sysApi = (SysApi) o;
        return Objects.equals(permissionId, sysApi.permissionId) &&
                Objects.equals(name, sysApi.name) &&
                Objects.equals(urls, sysApi.urls) &&
                Objects.equals(methodTypes, sysApi.methodTypes) &&
                Objects.equals(methodName, sysApi.methodName) &&
                Objects.equals(controllerName, sysApi.controllerName) &&
                Objects.equals(methodParamTypes, sysApi.methodParamTypes) &&
                Objects.equals(methodParamNames, sysApi.methodParamNames) &&
                Objects.equals(remark, sysApi.remark) &&
                Objects.equals(description, sysApi.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(permissionId, name, urls, methodTypes, methodName, controllerName, methodParamTypes, methodParamNames, remark, description);
    }
}