package com.blessedbin.frame.ucenter.entity.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created by xubin on 2018/9/13.
 *
 * @author 37075
 * @date 2018/9/13
 * @time 22:14
 * @tool intellij idea
 */
@Data
public class Operation {

    private Integer id;

    private String name;

    private String remark;

    private Integer sort;

    private Integer belongMenu;

    private List<Integer> apis;

}
