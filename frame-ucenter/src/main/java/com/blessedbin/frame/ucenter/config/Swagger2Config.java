package com.blessedbin.frame.ucenter.config;


import com.blessedbin.frame.common.SimpleResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xubin on 2018/5/2.
 *
 * @author 37075
 * @date 2018/5/2
 * @time 13:57
 * @tool intellij idea
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.blessedbin.frame.ucenter.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("后台系统api文档")
                .description("统一返回状态码说明:\n" + SimpleResponse.getTypeDescription())
                .version("1.0")
                .build();
    }
}
