package com.blessedbin.frame.ucenter.modal;

import com.blessedbin.frame.common.validate.PutMethodValidationGroup;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Objects;

@Table(name = "sys_menu")
public class SysMenu {
    @Id
    @Column(name = "permission_id")
    @NotNull(groups = PutMethodValidationGroup.class)
    private Integer permissionId;

    /**
     * 菜单展示名称
     */
    @NotEmpty
    private String title;

    private Integer pid;

    @NotEmpty
    private String component;

    /**
     * 菜单中的标记名称，英文
     */
    @NotEmpty
    private String name;

    /**
     * 路径
     */
    @NotEmpty
    private String path;

    /**
     * 跳转路径
     */
    private String redirect;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * if set true, will always show the root menu, whatever its child routes length
         if not set alwaysShow, only more than one route under the children
         it will becomes nested mode, otherwise not show the root menu
     */
    @Column(name = "always_show")
    private Boolean alwaysShow;

    /**
     * 是否隐藏
     */
    private Boolean hidden;

    @Column(name = "create_time")
    @Null
    private Date createTime;

    @Column(name = "update_time")
    @Null
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 其他配置信息，用json格式存储
     */
    private String meta;

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
     * 获取菜单展示名称
     *
     * @return title - 菜单展示名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置菜单展示名称
     *
     * @param title 菜单展示名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return component
     */
    public String getComponent() {
        return component;
    }

    /**
     * @param component
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     * 获取菜单中的标记名称，英文
     *
     * @return name - 菜单中的标记名称，英文
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单中的标记名称，英文
     *
     * @param name 菜单中的标记名称，英文
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取路径
     *
     * @return path - 路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置路径
     *
     * @param path 路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取跳转路径
     *
     * @return redirect - 跳转路径
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * 设置跳转路径
     *
     * @param redirect 跳转路径
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect == null ? null : redirect.trim();
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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
     * 获取if set true, will always show the root menu, whatever its child routes length
 if not set alwaysShow, only more than one route under the children
 it will becomes nested mode, otherwise not show the root menu
     *
     * @return always_show - if set true, will always show the root menu, whatever its child routes length
 if not set alwaysShow, only more than one route under the children
 it will becomes nested mode, otherwise not show the root menu
     */
    public Boolean getAlwaysShow() {
        return alwaysShow;
    }

    /**
     * 设置if set true, will always show the root menu, whatever its child routes length
 if not set alwaysShow, only more than one route under the children
 it will becomes nested mode, otherwise not show the root menu
     *
     * @param alwaysShow if set true, will always show the root menu, whatever its child routes length
 if not set alwaysShow, only more than one route under the children
 it will becomes nested mode, otherwise not show the root menu
     */
    public void setAlwaysShow(Boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    /**
     * 获取是否隐藏
     *
     * @return hidden - 是否隐藏
     */
    public Boolean getHidden() {
        return hidden;
    }

    /**
     * 设置是否隐藏
     *
     * @param hidden 是否隐藏
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
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
     * 获取其他配置信息，用json格式存储
     *
     * @return meta - 其他配置信息，用json格式存储
     */
    public String getMeta() {
        return meta;
    }

    /**
     * 设置其他配置信息，用json格式存储
     *
     * @param meta 其他配置信息，用json格式存储
     */
    public void setMeta(String meta) {
        this.meta = meta == null ? null : meta.trim();
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "permissionId=" + permissionId +
                ", title='" + title + '\'' +
                ", pid=" + pid +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", redirect='" + redirect + '\'' +
                ", icon='" + icon + '\'' +
                ", enabled=" + enabled +
                ", alwaysShow=" + alwaysShow +
                ", hidden=" + hidden +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + remark + '\'' +
                ", sort=" + sort +
                ", meta='" + meta + '\'' +
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
        SysMenu menu = (SysMenu) o;
        return Objects.equals(permissionId, menu.permissionId) &&
                Objects.equals(title, menu.title) &&
                Objects.equals(pid, menu.pid) &&
                Objects.equals(component, menu.component) &&
                Objects.equals(name, menu.name) &&
                Objects.equals(path, menu.path) &&
                Objects.equals(redirect, menu.redirect) &&
                Objects.equals(icon, menu.icon) &&
                Objects.equals(enabled, menu.enabled) &&
                Objects.equals(alwaysShow, menu.alwaysShow) &&
                Objects.equals(hidden, menu.hidden) &&
                Objects.equals(remark, menu.remark) &&
                Objects.equals(sort, menu.sort) &&
                Objects.equals(meta, menu.meta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(permissionId, title, pid, component, name, path, redirect, icon, enabled, alwaysShow, hidden, remark, sort, meta);
    }
}