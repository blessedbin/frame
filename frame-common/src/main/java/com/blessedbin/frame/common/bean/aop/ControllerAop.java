package com.blessedbin.frame.common.bean.aop;

import com.blessedbin.frame.common.contant.SecurityConstants;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 13:37
 * @tool intellij idea
 */
@Log4j2
@Aspect
@Component
public class ControllerAop {



    private Object methodHandler(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String username = request.getHeader(SecurityConstants.USER_HEADER);
        if (StringUtils.isNotBlank(username)) {
            log.info("Controller AOP get username:{}", username);
            // UserUtils.setUser(username);
        }

        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(pjp.getArgs()));

        Object result;

        result = pjp.proceed();
        log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));

        if (StringUtils.isNotEmpty(username)) {
            // UserUtils.clearAllUserInfo();
        }

        return result;
    }

}
