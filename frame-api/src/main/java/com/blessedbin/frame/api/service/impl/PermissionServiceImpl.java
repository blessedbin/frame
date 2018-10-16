package com.blessedbin.frame.api.service.impl;

import com.blessedbin.frame.common.entity.FramePermission;
import com.blessedbin.frame.api.service.PermissionService;
import com.blessedbin.frame.api.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.blessedbin.frame.common.contant.SecurityConstants.ROLE_ADMIN_KEY;

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

    @Autowired
    private RouteLocator routeLocator;

    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    private AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        log.debug("access hasPermission for request:{},authentication:{}",request.getRequestURI(),authentication.getPrincipal());

        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if(authentication instanceof OAuth2Authentication) {

            Map<String, Object> extraInfo = getExtraInfo(authentication);
            String uuid = (String)extraInfo.get("uuid");
            log.debug("extraInfo:{}",extraInfo);

            if(principal != null){
                if(authorities.stream().anyMatch(o -> ROLE_ADMIN_KEY.equals(o.getAuthority()))){
                    return true;
                } else {
                    // 判断是否有权限
                    List<FramePermission> api = userService.findUserApiByUuid(uuid);
                    log.debug("拥有的权限：{}",api);
                    final String requestURI = this.urlPathHelper.getPathWithinApplication(request);

                    Route route = this.routeLocator.getMatchingRoute(requestURI);
                    String path = route.getPath();
                    String method = request.getMethod();

                    // 鉴权
                    return api.stream().anyMatch(framePermission -> {
                        boolean a = framePermission.getMethod().equalsIgnoreCase(method);
                        boolean b = antPathMatcher.match(framePermission.getUrl(), path);
                        return a && b;
                    });

                }
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
