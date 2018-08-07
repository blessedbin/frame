package com.blessedbin.frame.common.ui;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by xubin on 2018/4/18.
 *
 * @author 37075
 * @date 2018/4/18
 * @time 11:25
 * @tool intellij idea
 */
@Data
@Builder
public class TreeNode {

    private String id;

    private String label;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeNode> children;

    /**
     * 标记
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String tag;

}
