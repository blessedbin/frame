package com.blessedbin.frame.ucenter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by xubin on 2018/10/29.
 *
 * @author 37075
 * @date 2018/10/29
 * @time 17:03
 * @tool intellij idea
 */
@Configuration
public class WebMvcController implements WebMvcConfigurer {

    @Autowired
    private HandlerMethodArgumentResolver frameUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(frameUserArgumentResolver);
    }
}
