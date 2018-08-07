package com.blessedbin.frame.ucenter.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by xubin on 2018/8/3.
 *
 * @author 37075
 * @date 2018/8/3
 * @time 14:46
 * @tool intellij idea
 */
@Data
public class ActionDto {

    private Integer id;

    private Integer menuId;

    /**
     * 附加信息，可以为空，不为空时必须是JSON格式的字符串
     */
    private String additionInfomation;

    /**
     * 注释信息
     */
    private String remark;

    private String permissionName;

    /**
     * 权限唯一编码
     */
    private String permissionKey;

    private Date createTime;

    private Date updateTime;


    /**
     * 是否启用
     */
    private Boolean enabled;

    private String type;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 所属系统
     */
    private String sysSystemId;

}
