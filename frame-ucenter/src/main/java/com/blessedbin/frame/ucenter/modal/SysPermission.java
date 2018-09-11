package com.blessedbin.frame.ucenter.modal;

import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Table(name = "sys_permission")
public class SysPermission {

    public static final String TYPE_MENU="MENU";

    public static final String TYPE_API="API";

    public static final String TYPE_OPERATION = "OPERATION";

    @Id
    @Column(name = "permission_id")
    @KeySql(useGeneratedKeys = true)
    private Integer permissionId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限标识
     * 格式：   类型:系统标识:编码
     */
    private String code;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 是否启用
     */
    private Boolean enabled;

    private String type;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 附加信息，JSON格式保存
     */
    @Column(name = "addition_information")
    private String additionInformation;

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
     * 获取权限名称
     *
     * @return name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取权限标识
     *
     * @return code - 权限标识
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置权限标识
     *
     * @param code 权限标识
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取是否启用
     *
     * @return enabled - 是否启用
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 设置是否启用
     *
     * @param enabled 是否启用
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取附加信息，JSON格式保存
     *
     * @return addition_information - 附加信息，JSON格式保存
     */
    public String getAdditionInformation() {
        return additionInformation;
    }

    /**
     * 设置附加信息，JSON格式保存
     *
     * @param additionInformation 附加信息，JSON格式保存
     */
    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation == null ? null : additionInformation.trim();
    }


    @Override
    public String toString() {
        return "SysPermission{" +
                "permissionId=" + permissionId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", enabled=" + enabled +
                ", type='" + type + '\'' +
                ", sort=" + sort +
                ", additionInformation='" + additionInformation + '\'' +
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
        SysPermission that = (SysPermission) o;
        return Objects.equals(permissionId, that.permissionId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(enabled, that.enabled) &&
                Objects.equals(type, that.type) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(additionInformation, that.additionInformation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(permissionId, name, code, remark, enabled, type, sort, additionInformation);
    }
}