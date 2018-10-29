package com.blessedbin.frame.common.entity;

import lombok.Builder;
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
@Builder
public class FrameUser {

    protected String username;
    protected List<FrameRole> roleList;
    protected boolean accountNonExpired;
    protected boolean accountNonLocked;
    protected boolean credentialsNonExpired;
    protected boolean enabled;
    protected String uuid;
    protected String password;

}
