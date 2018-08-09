package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.service.PermissionService;
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
@RequestMapping(value = "${frame.base-path.ucenter}/sys/permission")
@Log4j2
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/datatable.json")
    @FrameApi
    public SimpleResponse<Pagination<SysPermission>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                        @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                        @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Pagination<SysPermission> dataTable = permissionService.getDataTable(pageNum, pageSize);
        return SimpleResponse.ok(dataTable);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Integer id) {
        permissionService.deleteByPk(id);
        return SimpleResponse.deleted();
    }

}
