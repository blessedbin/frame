package com.blessedbin.frame.ucenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xubin on 2018/7/14.
 *
 * @author 37075
 * @date 2018/7/14
 * @time 23:10
 * @tool intellij idea
 */
@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
