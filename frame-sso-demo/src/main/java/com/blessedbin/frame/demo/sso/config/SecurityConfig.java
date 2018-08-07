package com.blessedbin.frame.demo.sso.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by xubin on 2018/7/26.
 *
 * @author 37075
 * @date 2018/7/26
 * @time 21:02
 * @tool intellij idea
 */
@EnableOAuth2Sso
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers( "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

}
