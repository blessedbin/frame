package com.blessedbin.frame.ucenter.auth.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Map;

/**
 * Created by xubin on 2018/8/2.
 *
 * @author 37075
 * @date 2018/8/2
 * @time 11:41
 * @tool intellij idea
 */
public class AuthenticationUtils {

    public static Map<String, Object> getExtraInfo(Authentication auth) {
        OAuth2AuthenticationDetails oauthDetails
                = (OAuth2AuthenticationDetails) auth.getDetails();
        return (Map<String, Object>) oauthDetails
                .getDecodedDetails();
    }


    public static String getUuid(Authentication authentication){
        return (String)getExtraInfo(authentication).get("uuid");
    }

}
