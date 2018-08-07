package com.blessedbin.frame.ucenter.component;

import com.google.common.base.CaseFormat;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

/**
 * Created by xubin on 2018/6/8.
 * 扫描带有@WebPermission的注解的mapping
 *
 * @author 37075
 * @date 2018/6/8
 * @time 16:28
 * @tool intellij idea
 */
@Log4j2
public class ApiScanner {

    public static List<FrameApiInfo> scan(RequestMappingHandlerMapping requestMappingHandlerMapping) {

        List<FrameApiInfo> mappings = new ArrayList<>();

        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        handlerMethods.keySet().forEach(requestMappingInfo -> {

            HandlerMethod handlerMethod = handlerMethods.get(requestMappingInfo);
            FrameApi frameAPi = handlerMethod.getMethodAnnotation(FrameApi.class);

            if (frameAPi != null) {
                FrameApiInfo mapping = buildMapping(requestMappingInfo, handlerMethod);

                mappings.add(mapping);
            }

        });

        return mappings;
    }

    private static FrameApiInfo buildMapping(RequestMappingInfo requestMappingInfo, HandlerMethod handlerMethod) {
        FrameApiInfo apiInfo = new FrameApiInfo();

        Class<?> declaringClass = handlerMethod.getMethod().getDeclaringClass();
        String controllerName = declaringClass.getName();
        apiInfo.setControllerName(controllerName);

        Set<String> patterns = requestMappingInfo.getPatternsCondition().getPatterns();
        apiInfo.setUrls(patterns);

        apiInfo.setSingleUrl(patterns.iterator().next());

        ApiOperation apiOperation = handlerMethod.getMethodAnnotation(ApiOperation.class);
        if(apiOperation != null){
            apiInfo.setName(apiOperation.value());

            if(!StringUtils.isEmpty(apiOperation.notes())){
                apiInfo.setDescription(apiOperation.notes());
            }
        }else {
            // 默认设置为方法名
            apiInfo.setName(controllerName.substring(controllerName.lastIndexOf('.') + 1) +
                    "." +handlerMethod.getMethod().getName());
        }


        apiInfo.setMethodName(handlerMethod.getMethod().getName());
        apiInfo.setKey(buildPermissionValue(handlerMethod));

        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();

        Map<String, Class<?>> params = new HashMap<>();
        for (MethodParameter mp : methodParameters) {
            String name = mp.getParameter().getName();
            Class<?> type = mp.getParameter().getType();
            params.put(name, type);
        }
        apiInfo.setParams(params);


        apiInfo.setRequestMethods(requestMappingInfo.getMethodsCondition().getMethods());

        return apiInfo;
    }


    /**
     * 构建关键字
     *
     * @param handlerMethod
     * @return
     */
    private static String buildPermissionValue(HandlerMethod handlerMethod) {

        String methodName = handlerMethod.getMethod().getName();
        Class<?> declaringClass = handlerMethod.getMethod().getDeclaringClass();

        String className = declaringClass.getName();
        String sClassName = className.substring(className.lastIndexOf('.') + 1);
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, sClassName) + "_"
                + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, methodName);
    }
}
