package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper extends MyMapper<SysUser> {

    SysUser findByUsername(@Param("username") String username);

}