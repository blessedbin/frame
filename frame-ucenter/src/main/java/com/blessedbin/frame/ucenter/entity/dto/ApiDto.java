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

    private String additionInformation;

    private String tags;

    private String permissionName;

    /**
     * 权限唯一编码
     */
    private String permissionKey;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 所属系统
     */
    private String sysSystemId;

}
