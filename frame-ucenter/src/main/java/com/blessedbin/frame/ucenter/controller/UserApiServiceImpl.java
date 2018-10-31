package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.entity.FrameRole;
import com.blessedbin.frame.common.entity.FrameUser;
import com.blessedbin.frame.common.service.UserApiService;
import com.blessedbin.frame.ucenter.entity.SysUser;
import com.blessedbin.frame.ucenter.service.ISysRoleService;
import com.blessedbin.frame.ucenter.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/9/26.
 * 对其他组件提供服务
 * @author 37075
 * @date 2018/9/26
 * @time 13:31
 * @tool intellij idea
 */
@RestController
@ApiIgnore
@Log4j2
public class UserApiServiceImpl implements UserApiService {

    @Autowired
    private UserService userService;

    @Autowired
    private ISysRoleService roleService;


    @GetMapping("/findByUsername")
    @Override
    public FrameUser findByUsername(String username){
        SysUser user = userService.findByUsername(username);
        if(user == null) {
            return null;
        } else {
            return buildFrameUser(user);
        }
    }

    @Override
    public FrameUser findByUuid(String uuid) {
        SysUser user = userService.selectByUuid(uuid);
        if(user == null) {
            return null;
        } else {
            return buildFrameUser(user);
        }
    }

    private FrameUser buildFrameUser(SysUser user) {
        List<FrameRole> roles = roleService.selectByUuid(
                user.getUuid()).stream().map(role -> FrameRole.builder().id(role.getId()).roleKey(role.getRoleKey()).roleName(role.getRoleName()).build()
        )
                .collect(Collectors.toList());
        return FrameUser.builder()
                .uuid(user.getUuid())
                .accountNonExpired(user.getAccountNonExpired())
                .accountNonLocked(user.getAccountNonLocked())
                .roleList(roles)
                .credentialsNonExpired(user.getCredentialsNonExpired())
                .enabled(user.getEnabled())
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }

}
