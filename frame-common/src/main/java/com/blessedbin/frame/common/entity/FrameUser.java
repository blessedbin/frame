package com.blessedbin.frame.common.entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 10:21
 * @tool intellij idea
 */
@Data
public class FrameUser {

    private final String username;
    private final List<String> roleList;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    private final String uuid;
    private final String password;

}
