package com.blessedbin.frame.common.service;

/**
 * Created by xubin on 2018/7/4.
 *
 * @author 37075
 * @date 2018/7/4
 * @time 22:20
 * @tool intellij idea
 */
@FunctionalInterface
public interface ValidateParam {

    /**
     * 验证 不通过抛出错误 ParamCheckRuntimeException
     * @see com.blessedbin.frame.common.exception.ParamCheckRuntimeException
     * @param param
     * @return
     */
    void validate(Object param);

}
