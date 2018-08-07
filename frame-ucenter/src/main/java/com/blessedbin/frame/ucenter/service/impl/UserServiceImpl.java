package com.blessedbin.frame.ucenter.service.impl;

import com.blessedbin.frame.ucenter.mapper.SysUserMapper;
import com.blessedbin.frame.ucenter.modal.SysUser;
import com.blessedbin.frame.ucenter.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xubin on 2018/7/29.
 *
 * @author 37075
 * @date 2018/7/29
 * @time 15:26
 * @tool intellij idea
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Override public SysUser findByUsername(String username){
        return userMapper.findByUsername(username);
    }

}
