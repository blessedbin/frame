package com.blessedbin.frame.ucenter.modal;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Table(name = "sys_api")
public class SysApi {
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * mapping名称，用于展示
     */
    private String name;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 请求方式 ,分隔
     */
    private String method;

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

    @Column(name = "addition_information")
    private String additionInformation;

    private String tags;

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
     * 获取资源地址
     *
     * @return url - 资源地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源地址
     *
     * @param url 资源地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取请求方式 ,分隔
     *
     * @return method - 请求方式 ,分隔
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置请求方式 ,分隔
     *
     * @param method 请求方式 ,分隔
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
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

    /**
     * @return addition_information
     */
    public String getAdditionInformation() {
        return additionInformation;
    }

    /**
     * @param additionInformation
     */
    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation == null ? null : additionInformation.trim();
    }

    /**
     * @return tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysApi sysApi = (SysApi) o;
        return Objects.equals(permissionId, sysApi.permissionId) &&
                Objects.equals(name, sysApi.name) &&
                Objects.equals(url, sysApi.url) &&
                Objects.equals(method, sysApi.method) &&
                Objects.equals(remark, sysApi.remark) &&
                Objects.equals(sort, sysApi.sort) &&
                Objects.equals(description, sysApi.description) &&
                Objects.equals(additionInformation, sysApi.additionInformation) &&
                Objects.equals(tags, sysApi.tags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(permissionId, name, url, method, remark, sort, description, additionInformation, tags);
    }

    @Override
    public String toString() {
        return "SysApi{" +
                "permissionId=" + permissionId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sort=" + sort +
                ", description='" + description + '\'' +
                ", additionInformation='" + additionInformation + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}