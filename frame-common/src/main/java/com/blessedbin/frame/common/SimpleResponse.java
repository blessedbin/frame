package com.blessedbin.frame.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Created by xubin on 2018/4/2.
 *
 * @author 37075
 * @date 2018/4/2
 * @time 15:56
 * @tool intellij idea
 */
@Data
@Builder
@AllArgsConstructor
public class SimpleResponse<T>{

    private int code;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Pagination pagination;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;

    private String codeMsg = "";

    private String timestamp = String.valueOf(System.currentTimeMillis());

    public SimpleResponse(int code,T data){
        this.code = code;
        this.data = data;
    }

    public SimpleResponse(int code){
        this.code = code;
    }

    public SimpleResponse() {
    }

    public static SimpleResponse created(String msg) {
        SimpleResponse response = new SimpleResponse();
        response.setCode(SimpleResponseType.CREATED.getCode());
        response.setMessage(msg);
        return response;
    }

    /**
     *
     * @param msg 返回的消息
     * @param data 附带的实体信息
     * @param <T>
     * @return
     */
    public static <T> SimpleResponse<T> created(String msg, T data) {
        SimpleResponse<T> response = new SimpleResponse<T>();
        response.setCode(SimpleResponseType.CREATED.getCode());
        response.setMessage(msg);
        response.setData(data);
        return response;
    }

    public static SimpleResponse created(){
        return created("创建成功");
    }

    public static <T> SimpleResponse<T> ok(T content) {
        SimpleResponse<T> response = new SimpleResponse<>();
        response.setCode(SimpleResponseType.OK.getCode());
        response.setCodeMsg(SimpleResponseType.OK.getCodeMsg());
        response.setData(content);
        return response;
    }

    public static SimpleResponse ok() {
        SimpleResponse response = new SimpleResponse();
        response.setCode(SimpleResponseType.OK.getCode());
        response.setCodeMsg(SimpleResponseType.OK.getCodeMsg());
        response.setMessage("OK");
        return response;
    }

    public static SimpleResponse okWithMsg(String msg){
        return SimpleResponse.builder().message(msg).code(SimpleResponseType.OK.getCode())
                .codeMsg(SimpleResponseType.OK.getCodeMsg()).build();
    }

    public static SimpleResponse okWithMsg(SimpleResponseType type, String msg){
        return SimpleResponse.builder()
                .message(msg)
                .codeMsg(type.getCodeMsg())
                .code(type.getCode())
                .build();
    }

    public static <T> SimpleResponse<T> okWithMsg(SimpleResponseType type, String msg, T data){
        SimpleResponse<T> response = new SimpleResponse<>();
        response.setCode(type.getCode());
        response.setCodeMsg(type.getCodeMsg());
        response.setMessage(msg);
        response.setData(data);
        return response;
    }

    /**
     * 删除
     * @return
     */
    public static SimpleResponse deleted() {
        return SimpleResponse.builder().code(SimpleResponseType.DELETED.getCode())
                .codeMsg(SimpleResponseType.DELETED.getCodeMsg())
                .message("删除成功").build();
    }

    public static SimpleResponse accepted() {
        SimpleResponse simpleResponse = new SimpleResponse(SimpleResponseType.ACCEPTED.getCode());
        simpleResponse.setMessage("操作成功");
        simpleResponse.setCodeMsg(SimpleResponseType.ACCEPTED.getCodeMsg());
        return simpleResponse;
    }

    public static SimpleResponse accepted(String msg) {
        return SimpleResponse.builder().code(SimpleResponseType.ACCEPTED.getCode())
                .codeMsg(SimpleResponseType.ACCEPTED.getCodeMsg()).message(msg).build();
    }

    public static SimpleResponse accepted(SimpleResponseType type, String msg) {
        return SimpleResponse.builder().code(type.getCode()).message(msg).build();
    }

    public static <T> SimpleResponse<List<T>> okWithPagination(List<T> dataList, Pagination pagination){
        SimpleResponse<List<T>> response = new SimpleResponse<>();
        response.setCode(SimpleResponseType.OK.getCode());
        response.setCodeMsg(SimpleResponseType.OK.getCodeMsg());
        response.setData(dataList);

        response.setPagination(pagination);

        return response;
    }

    /**
     * 拒绝访问
     * @return
     */
    public static SimpleResponse accessDenied(){
        SimpleResponse response = new SimpleResponse();
        response.setCode(SimpleResponseType.ACCESS_DENIED.getCode());
        response.setCodeMsg(SimpleResponseType.ACCESS_DENIED.getCodeMsg());
        response.setMessage("无访问权限");

        return response;
    }

    /**
     * 返回描述信息
     * @return
     */
    public static String getTypeDescription(){
        StringBuilder builder = new StringBuilder();
        for(SimpleResponseType type : SimpleResponseType.values()){
            builder.append(type.getString());
            builder.append("\n");
        }

        return builder.toString();
    }

}
