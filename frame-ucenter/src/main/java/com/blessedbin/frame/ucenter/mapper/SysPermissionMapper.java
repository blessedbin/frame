package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionMapper extends MyMapper<SysPermission> {
    SysPermission selectByIdentification(@Param("code") String code);

    List<SysPermission> selectByRoleId(@Param("roleId") Integer roleId);

    List<SysPermission> selectByType(@Param("type") String type);

    SysPermission selectByPrimaryKeyAndType(@Param("id") Integer id, @Param("type") String type);

    List<SysPermission> selectByPrimaryKeysAndType(@Param("ids") List<Integer> ids, @Param("type") String type);
}