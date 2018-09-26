package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper extends MyMapper<SysRole> {
    List<SysRole> selectRolesByUUid(@Param("uuid") String uuid);

    SysRole selectByRoleKey(@Param("key") String key);

    List<SysRole> selectAllByUuidAndEnabled(@Param("uuid")String uuid);
}