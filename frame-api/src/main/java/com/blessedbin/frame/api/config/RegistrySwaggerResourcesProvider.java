package com.blessedbin.frame.api.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubin on 2018/7/29.
 * swagger文档聚合
 * 参考文章：https://www.jianshu.com/p/af4ff19afa04
 * @author 37075
 * @date 2018/7/29
 * @time 19:43
 * @tool intellij idea
 */
@Component
@Primary
@Log4j2
public class RegistrySwaggerResourcesProvider implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;

    public RegistrySwaggerResourcesProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
        log.debug("-----------{}",routeLocator.getRoutes());
    }


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("用户管理中心","/api/frame-ucenter/v2/api-docs"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
