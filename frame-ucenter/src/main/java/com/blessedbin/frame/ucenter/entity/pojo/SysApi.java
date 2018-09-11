package com.blessedbin.frame.ucenter.entity.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SysApi {


    private Integer permissionId;

    /**
     * mapping名称，用于展示
     */
    private String name;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 请求方式 ,分隔
     */
    private String method;

    /**
     * 备注
     */
    private String remark;


    private Integer sort;

    /**
     * api 描述
     */
    private String description;


    private String tags;
}