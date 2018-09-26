package com.blessedbin.frame.auth.service;

import com.blessedbin.frame.auth.support.FrameUserDetail;
import com.blessedbin.frame.common.entity.FrameRole;
import com.blessedbin.frame.common.entity.FrameUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 10:07
 * @tool intellij idea
 */
@Service
@Log4j2
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserService userService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("select user by username:{}",username);

        FrameUser user = userService.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("没有这个用户:" + username);
        }

        List<FrameRole> roles = user.getRoleList();

        List<SimpleGrantedAuthority> grantedAuthorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleKey())).collect(Collectors.toList());

        return new FrameUserDetail(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                grantedAuthorities,
                user.getUuid()
        );
    }
}
