package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.service.CrudService;
import com.blessedbin.frame.common.service.DataTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 11:41
 * @tool intellij idea
 */
public abstract class BaseController<M,PK extends Serializable> {

    @Autowired
    private DataTableService<M,PK> dataTableService;

    @Autowired
    private CrudService<M,PK> crudService;

    @GetMapping("/datatable.json")
    public SimpleResponse<Pagination<M>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                                @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                                @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Pagination<M> dataTable = dataTableService.getDataTable(pageNum, pageSize);
        return SimpleResponse.ok(dataTable);
    }

    @GetMapping
    public SimpleResponse<M> getOne(@RequestParam PK id){
        return SimpleResponse.ok(crudService.selectByPk(id));
    }

    @DeleteMapping
    public SimpleResponse delete(@RequestParam PK id){
        crudService.deleteByPk(id);
        return SimpleResponse.deleted();
    }


}
