package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.ucenter.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
public interface ISysUserService extends IService<SysUser> {

    boolean checkEmailExists(String email);

    boolean checkUsernameExists(String username);

    boolean checkPhoneExists(String phone);

}
