package com.blessedbin.frame.common.ui;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by xubin on 2018/4/20.
 *
 * @author 37075
 * @date 2018/4/20
 * @time 13:58
 * @tool intellij idea
 */
@Data
@Builder
@ToString
public class TransferNode {

    private String key;

    private String label;

    private boolean disabled = false;

}
