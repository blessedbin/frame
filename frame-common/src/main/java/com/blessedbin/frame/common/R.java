package com.blessedbin.frame.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import javax.validation.constraints.NotNull;

/**
 * Created by xubin on 2018/9/10.
 * @author 37075
 * @date 2018/9/10
 * @time 23:12
 * @tool intellij idea
 */
public class R<T> extends ResponseEntity<T> {

    private String message;

    public R(HttpStatus status) {
        super(status);
    }

    public R (HttpStatus status,String message){
        super(status);
        this.message = message;
    }

    public R(T body, HttpStatus status) {
        super(body, status);
    }

    public R(T body, HttpStatus status,String message) {
        super(body, status);
        this.message = message;
    }


    public R(MultiValueMap<String, String> headers, HttpStatus status,String message) {
        super(headers, status);
        this.message = message;
    }


    public R(T body, MultiValueMap<String, String> headers, HttpStatus status,String message) {
        super(body, headers, status);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


    public static <T> R<T> ok(@NotNull T body){
        return new R<T>(body,HttpStatus.OK);
    }

}
