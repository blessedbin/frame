package com.blessedbin.frame.ucenter;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.blessedbin.frame.ucenter.mapper")
@EnableTransactionManagement
@Log4j2
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FrameUcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameUcenterApplication.class, args);
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
