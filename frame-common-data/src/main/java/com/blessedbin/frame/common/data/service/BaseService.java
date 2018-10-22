package com.blessedbin.frame.common.data.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * Created by xubin on 2018/10/22.
 *
 * @author 37075
 * @date 2018/10/22
 * @time 21:27
 * @tool intellij idea
 */
public interface BaseService<T> extends IService<T> {

    boolean existsById(Serializable id);

    boolean exists(Wrapper<T> wrapper);

}
