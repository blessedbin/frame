package com.blessedbin.frame.common.service;

/**
 * Created by xubin on 2018/6/27.
 * 通用服务类
 * @author 37075
 * @date 2018/6/27
 * @time 14:31
 * @tool intellij idea
 */
public interface CrudService<M,PK> extends
        InsertService<M, PK>,
        UpdateService<M,PK>,
        DeleteService<PK>,
        SelectService<M, PK> {
}
