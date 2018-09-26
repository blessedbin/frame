package com.blessedbin.frame.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 15:17
 * @tool intellij idea
 */
@EnableResourceServer
@Configuration
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private DefaultTokenServices tokenService;

    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth/token_key","/oauth/token","/code/**").permitAll()
                .anyRequest().permitAll();
    }
}
