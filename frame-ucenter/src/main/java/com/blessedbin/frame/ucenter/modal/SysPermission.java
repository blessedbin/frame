package com.blessedbin.frame.ucenter.modal;

import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_permission")
public class SysPermission {

    public static final String TYPE_MENU="MENU";

    public static final String TYPE_API="API";

    public static final String TYPE_ACTION = "ACTION";

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 权限唯一编码
     */
    @Column(name = "permission_key")
    private String permissionKey;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 所属系统
     */
    @Column(name = "sys_system_id")
    private String sysSystemId;

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
     * @return permission_name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 获取权限唯一编码
     *
     * @return permission_key - 权限唯一编码
     */
    public String getPermissionKey() {
        return permissionKey;
    }

    /**
     * 设置权限唯一编码
     *
     * @param permissionKey 权限唯一编码
     */
    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey == null ? null : permissionKey.trim();
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
     * @return remark
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
     * 获取所属系统
     *
     * @return sys_system_id - 所属系统
     */
    public String getSysSystemId() {
        return sysSystemId;
    }

    /**
     * 设置所属系统
     *
     * @param sysSystemId 所属系统
     */
    public void setSysSystemId(String sysSystemId) {
        this.sysSystemId = sysSystemId == null ? null : sysSystemId.trim();
    }
}