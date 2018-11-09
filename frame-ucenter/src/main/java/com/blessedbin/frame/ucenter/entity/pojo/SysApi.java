package com.blessedbin.frame.ucenter.entity.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class SysApi {


    private Integer id;

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

    private String serviceId;
}