package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysUserRole;
import com.blessedbin.frame.ucenter.modal.SysUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleMapper extends MyMapper<SysUserRole> {

    int insertLists(@Param("collect") List<SysUserRole> collect);

    int deleteByUuid(@Param("uuid") String uuid);
}