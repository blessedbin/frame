package com.blessedbin.frame.ucenter;

/**
 * Created by xubin on 2018/9/13.
 *
 * @author 37075
 * @date 2018/9/13
 * @time 23:09
 * @tool intellij idea
 */
public class Test {

    public static void main(String[] args) {
        String s = "group1/M00/00/00/wKixgVu7EnmASzIwAAJoZejCSYU118.PNG";
        int i = s.indexOf("/");
        String group = s.substring(0,i);
        String path = s.substring(i + 1);
        String type = s.substring(s.lastIndexOf(".") + 1);

        System.out.println(group);
        System.out.println(path);
        System.out.println(type);
    }

}
