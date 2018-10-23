package com.blessedbin.frame.common.data;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blessedbin.frame.common.Pagination;

/**
 * Created by xubin on 2018/10/23.
 *
 * @author 37075
 * @date 2018/10/23
 * @time 10:38
 * @tool intellij idea
 */
public class DataUtils {

    public static <T> Pagination<T> toPagination(IPage<T> page){
        return new Pagination<T>(page.getCurrent(),page.getSize(),page.getTotal(),page.getRecords());
    }

}
