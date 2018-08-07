package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionMapper extends MyMapper<SysPermission> {

    SysPermission selectByPermissionKey(String key);

    List<SysPermission> selectByRoleIdAndType(@Param("roleId") Integer roleId, @Param("type") String type);
}