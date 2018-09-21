package com.blessedbin.frame.common.contant;

/**
 * Created by xubin on 2018/7/31.
 *
 * @author 37075
 * @date 2018/7/31
 * @time 17:17
 * @tool intellij idea
 */
public interface SecurityConstants {

    String RESOURCE_ID = "resource-server-rest-api";

    String USER_HEADER = "x-user-header";

    String ROLE_HEADER = "x-role-header";

    String UUID_HEADER = "x-uuid-header";


    /**
     * 图形验证码过期时间
     */
    int DEFAULT_IMAGE_CODE_TIMEOUT = 60;

    String TOKEN_IMAGE_CODE_PREFIX = "image-code";

    String OAUTH_TOKEN_URL = "/api/oauth/token";
}
