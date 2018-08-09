package com.blessedbin.frame.ucenter.modal;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu {

    public static int ACTION = 1;
    public static int MENU = 0;

    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * 菜单展示名称
     */
    private String title;

    private Integer pid;

    private String component;

    /**
     * 菜单中的标记名称，英文
     */
    private String name;

    /**
     * 路径
     */
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
    private Date createTime;

    @Column(name = "update_time")
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
     * 类型 
    0 菜单
    1 功能点
     */
    private Integer type;

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

    /**
     * 获取类型 
1 菜单
2 功能点
     *
     * @return type - 类型 
1 菜单
2 功能点
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 
     0 菜单
     1 功能点
     *
     * @param type 类型 
    0 菜单
    1 功能点
     */
    public void setType(Integer type) {
        this.type = type;
    }
}