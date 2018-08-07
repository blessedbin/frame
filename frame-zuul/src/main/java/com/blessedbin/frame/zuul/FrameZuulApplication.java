package com.blessedbin.frame.zuul;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableAdminServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFeignClients
public class FrameZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameZuulApplication.class, args);
    }


    /*跨域配置*//*
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:9528");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(6000L);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;吧
    }*/
}
