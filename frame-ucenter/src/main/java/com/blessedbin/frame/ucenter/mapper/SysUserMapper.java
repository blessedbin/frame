package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.ucenter.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUsername(String username);
}
