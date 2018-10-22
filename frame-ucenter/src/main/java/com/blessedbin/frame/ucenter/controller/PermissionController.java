package com.blessedbin.frame.ucenter.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.ucenter.entity.SysPermission;
import com.blessedbin.frame.ucenter.service.ISysPermissionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xubin on 2018/8/8.
 *
 * @author 37075
 * @date 2018/8/8
 * @time 14:24
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "/sys/permission")
@Log4j2
public class PermissionController {

    @Autowired
    private ISysPermissionService permissionService;

    @GetMapping("/datatable.json")
    public SimpleResponse<Pagination<SysPermission>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                              @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                              @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Page<SysPermission> page = new Page<>(pageNum,pageSize);
        IPage<SysPermission> iPage = permissionService.page(page, null);
        Pagination<SysPermission> dataTable = new Pagination<>(iPage.getCurrent(),iPage.getSize(),iPage.getTotal(),iPage.getRecords());
        return SimpleResponse.ok(dataTable);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Integer id) {
        permissionService.removeById(id);
        return SimpleResponse.deleted();
    }

}
