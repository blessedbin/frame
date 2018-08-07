package com.blessedbin.frame.common.service;

/**
 * Created by xubin on 2018/6/27.
 * 插入基础服务
 * @author 37075
 * @date 2018/6/27
 * @time 14:31
 * @tool intellij idea
 */
public interface InsertService<M, PK> {

    /**
     * 添加一条数据
     *
     * @param record 要添加的数据
     * @return 添加后生成的主键
     */
    int insert(M record);


    /**
     * 添加一条数据
     * @param record 记录
     * @return 返回主键
     */
    int insertSelective(M record);


}
