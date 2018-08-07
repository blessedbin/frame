package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysRoleHasPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleHasPermissionMapper extends MyMapper<SysRoleHasPermission> {
    List<SysRoleHasPermission> selectByRoleIdAndPermissionType(@Param("roleId") Integer roleId, @Param("type") String typeMenu);

    int deleteByRoleId(@Param("roleId") Integer roleId);

    int deleteByPermissionId(@Param("permissionId") Integer permissionId);

    int insertLists(@Param("lists") List<SysRoleHasPermission> list);
}