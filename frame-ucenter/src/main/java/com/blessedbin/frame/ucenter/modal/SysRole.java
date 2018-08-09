package com.blessedbin.frame.ucenter.modal;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    @Id
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色唯一编码
     */
    @Column(name = "role_key")
    private String roleKey;

    /**
     * 备注
     */
    private String remark;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 是否启用，默认1
     */
    private Boolean enabled;

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
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色唯一编码
     *
     * @return role_key - 角色唯一编码
     */
    public String getRoleKey() {
        return roleKey;
    }

    /**
     * 设置角色唯一编码
     *
     * @param roleKey 角色唯一编码
     */
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
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
     * 获取是否启用，默认1
     *
     * @return enabled - 是否启用，默认1
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 设置是否启用，默认1
     *
     * @param enabled 是否启用，默认1
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}