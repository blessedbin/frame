package com.blessedbin.frame.common.service;

/**
 * Created by xubin on 2018/6/27.
 *
 * @author 37075
 * @date 2018/6/27
 * @time 14:32
 * @tool intellij idea
 */
public interface DeleteService<PK> {

    /**
     * 根据主键删除记录
     *
     * @param pk 主键
     * @return 影响记录数
     */
    int deleteByPk(PK pk);

    /**
     * 根据主键删除记录
     *
     * @param pks 主键集合
     * @return 影响记录数
     */
    int deleteByPks(Iterable<PK> pks);
}
