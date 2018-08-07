package com.blessedbin.frame.common;

/**
 * Created by xubin on 2018/5/10.
 *
 * @author 37075
 * @date 2018/5/10
 * @time 10:04
 * @tool intellij idea
 */
public enum SimpleResponseType {

    /**
     *
     */
    UN_LOGIN(40101,"未登录"),
    LOGIN_FAILED(40103,"登录失败"),
    UNAUTHORIZED(40101,"未授权"),
    LOGIN_SUCCESS(20101,"登录成功"),
    CREATED(20102,"创建成功"),
    DELETED(20201,"删除成功"),
    ACCEPTED(20301,"接收"),
    CHANGED(20302,"更改成功"),
    UNCHANGED(20303,"未更改"),
    OK(20000,"OK"),

    PARAMETER_ERROR(40110,"参数错误");

    private int code;
    
    private String codeMsg;
    
    SimpleResponseType(int i, String msg) {
        this.code = i;
        this.codeMsg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public String getString(){
        return code + ":" + codeMsg;
    }

    @Override
    public String toString() {
        return "SimpleResponseType{" +
                "code=" + code +
                ", codeMsg='" + codeMsg + '\'' +
                '}';
    }
}
