package com.blessedbin.frame.common.service;

/**
 * Created by xubin on 2018/6/27.
 *
 * @author 37075
 * @date 2018/6/27
 * @time 14:32
 * @tool intellij idea
 */
public interface UpdateService<M, PK> {

    /**
     * 修改记录信息
     *
     * @param record 要修改的对象
     * @return 影响记录数
     */
    int updateByPk(M record);

    /**
     * 修改记录信息
     *
     * @param record 要修改的对象
     * @return 影响记录数
     */
    int updateByPkSelective(M record);
}
