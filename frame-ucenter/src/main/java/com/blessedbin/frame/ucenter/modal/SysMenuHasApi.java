package com.blessedbin.frame.ucenter.modal;

import javax.persistence.*;

@Table(name = "sys_menu_has_api")
public class SysMenuHasApi {
    @Id
    @Column(name = "sys_menu_permission_id")
    private Integer sysMenuPermissionId;

    @Id
    @Column(name = "sys_api_permission_id")
    private Integer sysApiPermissionId;

    /**
     * @return sys_menu_permission_id
     */
    public Integer getSysMenuPermissionId() {
        return sysMenuPermissionId;
    }

    /**
     * @param sysMenuPermissionId
     */
    public void setSysMenuPermissionId(Integer sysMenuPermissionId) {
        this.sysMenuPermissionId = sysMenuPermissionId;
    }

    /**
     * @return sys_api_permission_id
     */
    public Integer getSysApiPermissionId() {
        return sysApiPermissionId;
    }

    /**
     * @param sysApiPermissionId
     */
    public void setSysApiPermissionId(Integer sysApiPermissionId) {
        this.sysApiPermissionId = sysApiPermissionId;
    }
}