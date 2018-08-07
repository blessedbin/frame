package com.blessedbin.frame.ucenter.entity.param;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by xubin on 2018/4/20.
 * 角色权限关系
 * @author 37075
 * @date 2018/4/20
 * @time 15:05
 * @tool intellij idea
 */
@Data
public class RolePermissionParam {
    /**
     * 角色Id
     */
    @NotNull
    private Integer id;

    private List<String> checkedList;
}
