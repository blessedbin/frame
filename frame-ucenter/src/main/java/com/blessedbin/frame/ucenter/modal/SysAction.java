package com.blessedbin.frame.ucenter.modal;

import javax.persistence.*;

@Table(name = "sys_action")
public class SysAction {
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "menu_id")
    private Integer menuId;

    /**
     * 附加信息，可以为空，不为空时必须是JSON格式的字符串
     */
    @Column(name = "addition_infomation")
    private String additionInfomation;

    /**
     * 注释信息
     */
    private String remark;

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
     * @return menu_id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取附加信息，可以为空，不为空时必须是JSON格式的字符串
     *
     * @return addition_infomation - 附加信息，可以为空，不为空时必须是JSON格式的字符串
     */
    public String getAdditionInfomation() {
        return additionInfomation;
    }

    /**
     * 设置附加信息，可以为空，不为空时必须是JSON格式的字符串
     *
     * @param additionInfomation 附加信息，可以为空，不为空时必须是JSON格式的字符串
     */
    public void setAdditionInfomation(String additionInfomation) {
        this.additionInfomation = additionInfomation == null ? null : additionInfomation.trim();
    }

    /**
     * 获取注释信息
     *
     * @return remark - 注释信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置注释信息
     *
     * @param remark 注释信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}