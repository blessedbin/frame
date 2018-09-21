package com.blessedbin.frame.zuul.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * Created by xubin on 2018/9/19.
 *
 * @author 37075
 * @date 2018/9/19
 * @time 15:58
 * @tool intellij idea
 */
@Component
@Log4j2
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("custom","自定义错误消息");
        return errorAttributes;
    }
}
