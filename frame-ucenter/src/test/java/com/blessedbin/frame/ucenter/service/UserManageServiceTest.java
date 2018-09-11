package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.utils.UUIDUtils;
import com.blessedbin.frame.ucenter.FrameUcenterApplicationTests;
import com.blessedbin.frame.ucenter.mapper.SysUserRoleMapper;
import com.blessedbin.frame.ucenter.modal.SysRole;
import com.blessedbin.frame.ucenter.modal.SysUser;
import com.blessedbin.frame.ucenter.modal.SysUserRole;
import com.netflix.discovery.converters.Auto;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by xubin on 2018/9/11.
 *
 * @author 37075
 * @date 2018/9/11
 * @time 21:58
 * @tool intellij idea
 */
@Log4j2
public class UserManageServiceTest extends FrameUcenterApplicationTests {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserManageService userManageService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Test
    public void addAdminUser(){

        SysRole role = roleService.selectByKey("ROLE_ADMIN");

        SysUser user = new SysUser();
        user.setUuid(UUIDUtils.generateUUID());
        user.setPassword(passwordEncoder.encode("admin"));
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        user.setUsername("admin");
        user.setRegisterTime(new Date());

        userManageService.insertSelective(user);

        SysUserRole userRole = new SysUserRole();
        userRole.setSysRoleId(role.getId());
        userRole.setSysUserUuid(user.getUuid());
        userRoleMapper.insertSelective(userRole);

    }


}