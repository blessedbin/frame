package com.blessedbin.frame.zuul.service.impl;

import com.blessedbin.frame.common.entity.FramePermission;
import com.blessedbin.frame.zuul.service.PermissionService;
import com.blessedbin.frame.zuul.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by xubin on 2018/7/31.
 *
 * @author 37075
 * @date 2018/7/31
 * @time 16:35
 * @tool intellij idea
 */
@Service("permissionService")
@Log4j2
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private UserService userService;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        log.debug("access hasPermission for request:{},authentication:{}",request.getRequestURI(),authentication.getPrincipal());

        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        Map<String, Object> extraInfo = getExtraInfo(authentication);
        String uuid = (String)extraInfo.get("uuid");
        log.debug("extraInfo:{}",extraInfo);

        if(principal != null){
            if(authorities.stream().anyMatch(o -> o.getAuthority().equals("ROLE_ADMIN"))){
                return true;
            } else {
                // 判断是否有权限
                List<FramePermission> api = userService.findUserApiByUuid(uuid);
                System.out.println(api);
                return true;
            }
        }

        return false;
    }

    private Map<String, Object> getExtraInfo(Authentication auth) {
        OAuth2AuthenticationDetails oauthDetails
                = (OAuth2AuthenticationDetails) auth.getDetails();
        return (Map<String, Object>) oauthDetails
                .getDecodedDetails();
    }
}
