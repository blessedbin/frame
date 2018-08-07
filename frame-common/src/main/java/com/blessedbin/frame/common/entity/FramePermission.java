package com.blessedbin.frame.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 17:09
 * @tool intellij idea
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FramePermission {

    private String url;

    private String method;

}
