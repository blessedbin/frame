package com.blessedbin.frame.common.service;

import com.blessedbin.frame.common.mapper.MyMapper;

import java.io.Serializable;

/**
 * Created by xubin on 2018/8/9.
 *
 * @author 37075
 * @date 2018/8/9
 * @time 16:50
 * @tool intellij idea
 */
public interface MysqlCrudService<M,PK extends Serializable> extends CrudService<M,PK>,DataTableService<M,PK>,CheckExistsService {

    MyMapper<M> getMyMapper();

}
