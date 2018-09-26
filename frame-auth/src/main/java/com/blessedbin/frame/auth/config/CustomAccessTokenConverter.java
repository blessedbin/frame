package com.blessedbin.frame.auth.config;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by xubin on 2018/8/2.
 *
 * @author 37075
 * @date 2018/8/2
 * @time 10:53
 * @tool intellij idea
 */
@Component
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        OAuth2Authentication authentication
                = super.extractAuthentication(claims);
        authentication.setDetails(claims);
        return authentication;
    }

}
