package com.blessedbin.frame.common.service;



import com.blessedbin.frame.common.Pagination;

import java.io.Serializable;

/**
 * Created by xubin on 2018/6/28.
 *
 * @author 37075
 * @date 2018/6/28
 * @time 11:02
 * @tool intellij idea
 */
public interface  DataTableService<M,PK extends Serializable> extends SelectService<M,PK> {

    /**
     * 获取dataTable
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Pagination<M> getDataTable(int pageNum, int pageSize);

    /**
     *
     * @param pageNum
     * @param pageSize
     * @param example
     * @return
     */
    public Pagination<M> getDataTable(int pageNum, int pageSize, Object example);

}
