package com.blessedbin.frame.ucenter.component;

import java.lang.annotation.*;

/**
 * Created by xubin on 2018/5/30.
 * 标注权限点，用于自动更新权限表
 * @author 37075
 * @date 2018/5/30
 * @time 10:33
 * @tool intellij idea
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FrameApi {
}
