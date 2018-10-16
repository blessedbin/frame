package com.blessedbin.frame.api.filter;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.SimpleResponseType;
import com.blessedbin.frame.common.contant.SecurityConstants;
import com.blessedbin.frame.common.exception.ValidateCodeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xubin on 2018/8/22.
 * 验证码过滤器
 * @author 37075
 * @date 2018/8/22
 * @time 22:17
 * @tool intellij idea
 */
@Component
@Log4j2
public class ValidateCodeFilter extends ZuulFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_ERROR_FILTER_ORDER + 1;
    }

    /**
     * a "true" return from this method means that the run() method should be invoked
     *
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        if(request.getRequestURI().equals(SecurityConstants.OAUTH_TOKEN_URL)){
            return true;
        }
        return false;
    }

    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        try {
            log.debug("run validate code filter");
            validateCode(request);
        } catch (ValidateCodeException e) {
            log.debug(e.getMessage());
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
            ctx.getResponse().setContentType("application/json;charset=UTF-8");

            SimpleResponse<Object> build = SimpleResponse.builder().code(SimpleResponseType.LOGIN_FAILED.getCode())
                    .codeMsg(SimpleResponseType.LOGIN_FAILED.getCodeMsg()).message(e.getMessage())
                    .timestamp(String.valueOf(System.currentTimeMillis()))
                    .build();
            try {
                ctx.setResponseBody(objectMapper.writeValueAsString(build));
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }

        }
        return null;
    }

    private void validateCode(HttpServletRequest request) throws ValidateCodeException {
        String validatecode = request.getParameter("validatecode");
        if(StringUtils.isEmpty(validatecode)){
            throw new ValidateCodeException("请输入验证码");
        }

        String token = request.getParameter("imgToken");
        if(StringUtils.isEmpty(token)){
            throw new ValidateCodeException("参数错误");
        }

        if(!redisTemplate.hasKey(token)){
            throw new ValidateCodeException("验证码过期，请重新获取");
        }

        Object o = redisTemplate.opsForValue().get(token);
        if(o == null) {
            throw new ValidateCodeException("验证码过期，请重新获取");
        }
        String code = (String)o;

        if(!validatecode.equals(code)){
            redisTemplate.delete(token);
            throw new ValidateCodeException("验证码错误，请重试");
        }

        redisTemplate.delete(token);
    }
}
