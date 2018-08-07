package com.blessedbin.frame.ucenter.entity.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 14:29
 * @tool intellij idea
 */
@Data
public class MenuTreeDto {

    private Integer permissionId;

    /**
     * 菜单展示名称
     */
    private String title;

    private Integer pid;

    private String component;

    /**
     * 菜单中的标记名称，英文
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 跳转路径
     */
    private String redirect;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * if set true, will always show the root menu, whatever its child routes length
     if not set alwaysShow, only more than one route under the children
     it will becomes nested mode, otherwise not show the root menu
     */
    private Boolean alwaysShow;

    /**
     * 是否隐藏
     */
    private Boolean hidden;

    private Date createTime;

    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 其他配置信息，用json格式存储
     */
    private String meta;


    private List<MenuTreeDto> children;

}
