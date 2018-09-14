package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysRolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRolePermissionMapper extends MyMapper<SysRolePermission> {
    int deleteByRoleId(@Param("roleId") Integer roleId);
}