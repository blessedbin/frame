package com.blessedbin.frame.ucenter.modal;

import javax.persistence.*;

@Table(name = "sys_role_permission")
public class SysRolePermission {
    @Id
    @Column(name = "sys_role_id")
    private Integer sysRoleId;

    @Id
    @Column(name = "sys_permission_id")
    private Integer sysPermissionId;

    /**
     * @return sys_role_id
     */
    public Integer getSysRoleId() {
        return sysRoleId;
    }

    /**
     * @param sysRoleId
     */
    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    /**
     * @return sys_permission_id
     */
    public Integer getSysPermissionId() {
        return sysPermissionId;
    }

    /**
     * @param sysPermissionId
     */
    public void setSysPermissionId(Integer sysPermissionId) {
        this.sysPermissionId = sysPermissionId;
    }
}