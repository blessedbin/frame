package com.blessedbin.frame.ucenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blessedbin.frame.ucenter.entity.SysUser;
import com.blessedbin.frame.ucenter.mapper.SysUserMapper;
import com.blessedbin.frame.ucenter.service.ISysUserService;
import com.blessedbin.frame.ucenter.service.UserService;
import org.springframework.stereotype.Service;

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
     * TODO
     * @param uuid
     * @return
     */
    @Override
    public SysUser selectByUuid(String uuid) {
        return null;
    }

    /**
     * TODO
     * @param email
     * @return
     */
    @Override
    public boolean checkEmailExists(String email) {
        return false;
    }

    /**
     * TODO
     * @param username
     * @return
     */
    @Override
    public boolean checkUsernameExists(String username) {
        return false;
    }

    /**
     * TODO
     * @param phone
     * @return
     */
    @Override
    public boolean checkPhoneExists(String phone) {
        return false;
    }
}
