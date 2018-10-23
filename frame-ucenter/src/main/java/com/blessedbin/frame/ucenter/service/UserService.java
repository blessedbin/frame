package com.blessedbin.frame.ucenter.service;


import com.blessedbin.frame.ucenter.entity.SysUser;

/**
 * Created by xubin on 2018/7/29.
 *
 * @author 37075
 * @date 2018/7/29
 * @time 15:30
 * @tool intellij idea
 */
public interface UserService {

    SysUser findByUsername(String username);

    SysUser selectByUuid(String uuid);
}
