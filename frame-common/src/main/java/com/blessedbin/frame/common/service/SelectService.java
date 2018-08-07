package com.blessedbin.frame.common.service;

import com.github.pagehelper.PageInfo;

import java.util.Collections;
import java.util.List;

/**
 * Created by xubin on 2018/6/27.
 *
 * @author 37075
 * @date 2018/6/27
 * @time 14:32
 * @tool intellij idea
 */
public interface SelectService<M, PK> {

    /**
     * 根据主键查询
     * @param pk 主键
     * @return 查询结果,无结果时返回{@code null}
     */
    M selectByPk(PK pk);

    /**
     * 根据多个主键查询
     * @param pks 主键集合
     * @return 查询结果,如果无结果返回空集合
     */
    List<M> selectByPks(Iterable<PK> pks);

    /**
     * 查询所有结果
     * @return 所有结果,如果无结果则返回空集合
     */
    List<M> selectAll();

    /**
     * 查询所有结果
     * @return 获取分页结果
     */
    PageInfo<M> selectPage(Integer pageNum, Integer pageSize);

    default List<M> selectAllByExample(Object example){
        return Collections.EMPTY_LIST;
    };
}
