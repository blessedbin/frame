package com.blessedbin.frame.auth.support;

import com.blessedbin.frame.common.SimpleResponseType;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by xubin on 2018/8/27.
 *
 * @author 37075
 * @date 2018/8/27
 * @time 23:30
 * @tool intellij idea
 */
public class CustomOauth2ExceptionSerializer2 extends JsonSerializer<CustomOauth2Exception> {

    public CustomOauth2ExceptionSerializer2() {
    }

    @Override
    public void serialize(CustomOauth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        gen.writeStartObject();
        gen.writeStringField("error", String.valueOf(value.getHttpErrorCode()));
        gen.writeStringField("code", String.valueOf(SimpleResponseType.LOGIN_FAILED.getCode()));
        gen.writeStringField("codeMsg",SimpleResponseType.LOGIN_FAILED.getCodeMsg());
        gen.writeStringField("message", value.getMessage());
        gen.writeStringField("path", request.getServletPath());
        gen.writeStringField("timestamp", String.valueOf(System.currentTimeMillis()));
        if (value.getAdditionalInformation()!=null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }
        gen.writeEndObject();
    }
}
