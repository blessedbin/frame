package com.blessedbin.frame.common.entity;

import lombok.Builder;
import lombok.Data;

/**
 * Created by xubin on 2018/9/26.
 *
 * @author 37075
 * @date 2018/9/26
 * @time 13:20
 * @tool intellij idea
 */
@Data
@Builder
public class FrameRole {

    private Integer id;

    private String roleName;

    /**
     * 角色唯一编码
     */
    private String roleKey;

}
