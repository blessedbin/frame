package com.blessedbin.frame.zuul.component;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.contant.CommonConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xubin on 2018/8/21.
 *
 * @author 37075
 * @date 2018/8/21
 * @time 13:54
 * @tool intellij idea
 */
@Component
@Log4j2
public class FrameAccessDeniedHandler extends OAuth2AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
        log.debug("授权失败，禁止访问:{}",request.getRequestURI());

        response.setCharacterEncoding(CommonConstants.UTF8);
        response.setContentType(CommonConstants.CONTENT_TYPE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        PrintWriter printWriter = response.getWriter();
        printWriter.write(objectMapper.writeValueAsString(SimpleResponse.accessDenied()));
    }
}
