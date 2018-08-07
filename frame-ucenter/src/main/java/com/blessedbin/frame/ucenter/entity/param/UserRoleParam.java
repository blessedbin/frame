package com.blessedbin.frame.ucenter.entity.param;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by xubin on 2018/4/20.
 *
 * @author 37075
 * @date 2018/4/20
 * @time 15:05
 * @tool intellij idea
 */
@Data
public class UserRoleParam {
    @NotNull
    private String uuid;

    private List<Integer> selectedRole;
}
