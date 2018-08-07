package com.blessedbin.frame.common.utils;

import java.util.UUID;

/**
 * Created by xubin on 2018/7/16.
 *
 * @author 37075
 * @date 2018/7/16
 * @time 13:17
 * @tool intellij idea
 */
public class UUIDUtils {

    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
