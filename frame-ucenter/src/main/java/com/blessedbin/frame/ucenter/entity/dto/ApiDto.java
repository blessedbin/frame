package com.blessedbin.frame.ucenter.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by xubin on 2018/7/17.
 *
 * @author 37075
 * @date 2018/7/17
 * @time 11:11
 * @tool intellij idea
 */
@Data
public class ApiDto {

    private Integer permissionId;

    /**
     * mapping名称，用于展示
     */
    private String name;

    private String urls;

    /**
     * 请求方式 ,分隔
     */
    private String methodTypes;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 控制器名
     */
    private String controllerName;

    /**
     * 请求参数类型
     */
    private String methodParamTypes;

    /**
     * 请求参数名称，与类型一一对应
     */
    private String methodParamNames;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer sort;

    /**
     * api 描述
     */
    private String description;


    private String permissionName;

    /**
     * 权限唯一编码
     */
    private String permissionKey;

    private Boolean enabled;

}
