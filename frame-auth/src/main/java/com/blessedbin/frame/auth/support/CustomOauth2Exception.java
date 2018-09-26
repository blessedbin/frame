package com.blessedbin.frame.auth.support;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * Created by xubin on 2018/8/27.
 *
 * @author 37075
 * @date 2018/8/27
 * @time 23:29
 * @tool intellij idea
 */
@com.fasterxml.jackson.databind.annotation.JsonSerialize(using = CustomOauth2ExceptionSerializer.class)
@org.codehaus.jackson.map.annotate.JsonSerialize(using = CustomOauth2ExceptionSerializer2.class)
public class CustomOauth2Exception extends OAuth2Exception {


    public CustomOauth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public CustomOauth2Exception(String msg) {
        super(msg);
    }


}
