package com.blessedbin.frame.api.filter;

import com.blessedbin.frame.common.contant.SecurityConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

/**
 * Created by xubin on 2018/7/24.
 * Zuul 请求过滤器 继承zuulFilter
 * @author 37075
 * @date 2018/7/24
 * @time 22:41
 * @tool intellij idea
 */
@Log4j2
@Component
public class AccessFilter extends ZuulFilter {

    /**
     * 过滤器的类型，决定过滤器在请求的哪个生命周期中执行
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器执行顺序，当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
     * @return
     */
    @Override
    public int filterOrder() {
        return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    /**
     *  判断该过滤器是否需要被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.debug("[access filter]authentication:{}",authentication);
        if (authentication != null) {
            log.debug("authentication.details:{}",authentication.getPrincipal());
            RequestContext requestContext = RequestContext.getCurrentContext();
            requestContext.addZuulRequestHeader(SecurityConstants.USER_HEADER, authentication.getName());
            try {
                String uuid = getUuid(authentication);
                requestContext.addZuulRequestHeader(SecurityConstants.UUID_HEADER, uuid);
            } catch (Exception e) {
                //TODO 进行没有获取到UUID的请求的处理
                log.warn(e.getMessage());
            }
        }
        return null;
    }


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
