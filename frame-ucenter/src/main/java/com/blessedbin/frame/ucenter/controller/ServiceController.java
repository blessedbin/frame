package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.entity.FrameRole;
import com.blessedbin.frame.common.entity.FrameUser;
import com.blessedbin.frame.ucenter.entity.SysUser;
import com.blessedbin.frame.ucenter.service.ISysRoleService;
import com.blessedbin.frame.ucenter.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/service")
@ApiIgnore
@Log4j2
public class ServiceController {

    @Autowired
    private UserService userService;

    @Autowired
    private ISysRoleService roleService;


    @GetMapping("/findByUsername")
    public FrameUser findByUsername(String username){
        SysUser user = userService.findByUsername(username);
        if(user == null) {
            return null;
        } else {
            List<FrameRole> roles = roleService.selectAllByUuid(
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

}
