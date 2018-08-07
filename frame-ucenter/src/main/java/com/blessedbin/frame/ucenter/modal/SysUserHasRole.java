package com.blessedbin.frame.ucenter.modal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_user_has_role")
public class SysUserHasRole {
    @Id
    @Column(name = "sys_user_uuid")
    private String sysUserUuid;

    @Id
    @Column(name = "sys_role_id")
    private Integer sysRoleId;

    /**
     * @return sys_user_uuid
     */
    public String getSysUserUuid() {
        return sysUserUuid;
    }

    /**
     * @param sysUserUuid
     */
    public void setSysUserUuid(String sysUserUuid) {
        this.sysUserUuid = sysUserUuid == null ? null : sysUserUuid.trim();
    }

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
}