package com.blessedbin.frame.ucenter.component;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by xubin on 2018/6/8.
 *
 * @author 37075
 * @date 2018/6/8
 * @time 16:36
 * @tool intellij idea
 */
public class FrameApiInfo {

    private Set<String> urls;

    private Set<RequestMethod> requestMethods;

    private String methodName;

    private String controllerName;

    private Map<String,Class<?>> params;

    private String name;

    private String singleUrl;

    private String key;

    private String description;

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public Set<RequestMethod> getRequestMethods() {
        return requestMethods;
    }

    public void setRequestMethods(Set<RequestMethod> requestMethods) {
        this.requestMethods = requestMethods;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public Map<String, Class<?>> getParams() {
        return params;
    }

    public void setParams(Map<String, Class<?>> params) {
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSingleUrl() {
        return singleUrl;
    }

    public void setSingleUrl(String singleUrl) {
        this.singleUrl = singleUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FrameApiInfo that = (FrameApiInfo) o;
        return Objects.equals(urls, that.urls) &&
                Objects.equals(requestMethods, that.requestMethods) &&
                Objects.equals(methodName, that.methodName) &&
                Objects.equals(controllerName, that.controllerName) &&
                Objects.equals(params, that.params) &&
                Objects.equals(name, that.name) &&
                Objects.equals(singleUrl, that.singleUrl) &&
                Objects.equals(key, that.key) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(urls, requestMethods, methodName, controllerName, params, name, singleUrl, key, description);
    }

    @Override
    public String toString() {
        return "FrameApiInfo{" +
                "urls=" + urls +
                ", requestMethods=" + requestMethods +
                ", methodName='" + methodName + '\'' +
                ", controllerName='" + controllerName + '\'' +
                ", params=" + params +
                ", name='" + name + '\'' +
                ", singleUrl='" + singleUrl + '\'' +
                ", key='" + key + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
