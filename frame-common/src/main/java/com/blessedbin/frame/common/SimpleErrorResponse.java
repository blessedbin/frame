package com.blessedbin.frame.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xubin on 2018/5/29.
 *
 * @author 37075
 * @date 2018/5/29
 * @time 14:48
 * @tool intellij idea
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleErrorResponse {

    private int code;

    private String message;

    @Builder.Default
    private String codeMsg = "";


    /**
     *
     * @param responseType 错误类型
     * @param message 错误信息
     * @return 实例
     */
    public static SimpleErrorResponse instence(SimpleResponseType responseType, String message){
        return SimpleErrorResponse.builder().code(responseType.getCode()).codeMsg(responseType.getCodeMsg())
                .message(message).build();
    }

}
