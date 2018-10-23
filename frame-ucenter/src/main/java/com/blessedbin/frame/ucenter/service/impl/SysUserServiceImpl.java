package com.blessedbin.frame.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blessedbin.frame.ucenter.entity.SysUser;
import com.blessedbin.frame.ucenter.mapper.SysUserMapper;
import com.blessedbin.frame.ucenter.service.ISysUserService;
import com.blessedbin.frame.ucenter.service.UserService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService, UserService {


    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Override
    public SysUser findByUsername(String username){
        return baseMapper.findByUsername(username);
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public SysUser selectByUuid(String uuid) {
        return getById(uuid);
    }

    /**
     * @param email
     * @return
     */
    @Override
    public boolean checkEmailExists(String email) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getEmail,email);
        return exists(wrapper);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public boolean checkUsernameExists(String username) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,username);
        return exists(wrapper);
    }

    /**
     * @param phone
     * @return
     */
    @Override
    public boolean checkPhoneExists(String phone) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getPhone,phone);
        return exists(wrapper);
    }

    @Override
    public boolean existsById(Serializable id) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper();
        wrapper.eq(SysUser::getUuid,id);
        return exists(wrapper);
    }

    @Override
    public boolean exists(Wrapper<SysUser> wrapper) {
        return count(wrapper) > 0;
    }
}
