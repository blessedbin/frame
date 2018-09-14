package com.blessedbin.frame.ucenter.entity.pojo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubin on 2018/9/11.
 *
 * @author 37075
 * @date 2018/9/11
 * @time 11:34
 * @tool intellij idea
 */
@Data
@ToString
public class Menu {


    private Integer id;

    /**
     * 菜单展示名称
     */
    @NotBlank
    private String title;

    @NotNull
    @Min(value = -1)
    private Integer pid;

    @NotBlank
    private String component;

    /**
     * 菜单中的标记名称，英文
     */
    @NotBlank
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
    /**
     * 排序
     */
    private Integer sort;

    /**
     * 其他配置信息，用json格式存储
     */
    private String meta;

    private List<Integer> operations;


    public void addOperation(Integer operationId){
        if(operations == null){
            operations = new ArrayList<>();
        }
        operations.add(operationId);
    }
}
