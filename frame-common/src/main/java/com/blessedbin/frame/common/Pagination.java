package com.blessedbin.frame.common;

import lombok.Data;

import java.util.List;

/**
 * Created by xubin on 2018/3/5.
 *
 * @author 37075
 * @date 2018/3/5
 * @time 22:12
 * @tool intellij idea
 */
@Data
public class Pagination<M> {


    private int currentPage;

    private int pageSize;

    private long total;

    private int[] pageSizes = {20, 30, 50, 100};

    private List<M> data;

    /**
     * 创建分页
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @param total 总数据数
     * @param data 数据
     */
    public Pagination(int currentPage, int pageSize, long total, List<M> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }


    public static <FROM,TO> Pagination<TO> convertPagination(Pagination<FROM> pagination){

        return null;
    }
}
