package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysUserHasRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserHasRoleMapper extends MyMapper<SysUserHasRole> {
    int deleteByUuid(@Param("uuid") String uuid);

    int insertLists(@Param("roles") List<SysUserHasRole> roles);
}