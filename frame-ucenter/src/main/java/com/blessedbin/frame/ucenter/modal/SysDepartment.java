package com.blessedbin.frame.ucenter.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Table(name = "sys_department")
public class SysDepartment {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "p_id")
    @JsonProperty(value = "pid")
    private Integer pId;

    @Column(name = "organization_id")
    @NotNull
    private Integer organizationId;

    @Column(name = "department_name")
    @NotEmpty(message = "部门名称不能为空")
    private String departmentName;

    private String remark;

    /**
     * 排序值
     */
    private Integer sort;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return p_id
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * @param pId
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * @return organization_id
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return department_name
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * @return description
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取排序值
     *
     * @return sort - 排序值
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序值
     *
     * @param sort 排序值
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysDepartment that = (SysDepartment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pId, that.pId) &&
                Objects.equals(organizationId, that.organizationId) &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(delFlag, that.delFlag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, pId, organizationId, departmentName, remark, sort, delFlag);
    }

    @Override
    public String toString() {
        return "SysDepartment{" +
                "id=" + id +
                ", pId=" + pId +
                ", organizationId=" + organizationId +
                ", departmentName='" + departmentName + '\'' +
                ", description='" + remark + '\'' +
                ", sort=" + sort +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                '}';
    }
}