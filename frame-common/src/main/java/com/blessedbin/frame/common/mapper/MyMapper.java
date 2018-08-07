package com.blessedbin.frame.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by xubin on 2017/12/31.
 *
 * @author 37075
 * @date 2017/12/31
 * @time 21:34
 * @tool intellij idea
 */

/**
 *
 * @param <T>
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
