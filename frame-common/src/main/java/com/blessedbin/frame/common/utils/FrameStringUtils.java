package com.blessedbin.frame.common.utils;

import org.springframework.util.StringUtils;

/**
 * Created by xubin on 2018/7/23.
 *
 * @author 37075
 * @date 2018/7/23
 * @time 13:33
 * @tool intellij idea
 */
public class FrameStringUtils {

    public static String subStringLength(String str,int length){
        if(StringUtils.isEmpty(str)){
            return  "";
        }

        if(str.length() <= length){
            return str;
        }else {
            return str.substring(0,length) + "...";
        }

    }

}
