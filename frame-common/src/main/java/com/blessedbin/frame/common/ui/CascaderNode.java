package com.blessedbin.frame.common.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by xubin on 2018/5/30.
 *
 * @author 37075
 * @date 2018/5/30
 * @time 22:29
 * @tool intellij idea
 */
@Data
@Builder
public class CascaderNode {

    private String value;

    private String label;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CascaderNode> children;

    private boolean disabled = false;

}
