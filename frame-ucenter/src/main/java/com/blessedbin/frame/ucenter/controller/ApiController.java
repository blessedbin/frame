package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.entity.FramePermission;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.entity.dto.ApiDto;
import com.blessedbin.frame.ucenter.modal.SysApi;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.service.ApiService;
import com.blessedbin.frame.ucenter.service.MenuService;
import com.blessedbin.frame.ucenter.service.PermissionService;
import com.blessedbin.frame.ucenter.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 16:47
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "${frame.base-path.ucenter}/sys/api")
@Api(description = "API列表")
@Log4j2
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;
    /**
     * 扫描
     */
    @GetMapping("/scan")
    @FrameApi
    @ApiOperation(value = "更新API列表", notes = "扫描并更新API列表")
    public SimpleResponse scan() {
        apiService.scanApi();
        return SimpleResponse.accepted();
    }

    @GetMapping("/datatable.json")
    @FrameApi
    public SimpleResponse<Pagination<ApiDto>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                       @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                       @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Pagination<ApiDto> dataTable = apiService.getDataTables(pageNum, pageSize);
        return SimpleResponse.ok(dataTable);
    }

    @GetMapping("/draggable_list.json")
    @FrameApi
    public SimpleResponse<Map<String, Object>> draggableList(@RequestParam(required = false) Integer roleId) {
        Map<String, Object> returnData = new HashMap<>();

        List<SysApi> apis = apiService.selectAll();
        List<Map<String, String>> all = apis.stream().map(api -> {
            Map<String, String> data = new HashMap<>();
            SysPermission permission = permissionService.selectByPk(api.getPermissionId());
            data.put("name", permission.getPermissionName());
            data.put("url", api.getName());
            data.put("id", String.valueOf(api.getPermissionId()));
            return data;
        }).collect(Collectors.toList());
        returnData.put("all", all);

        if (roleId != null) {
            if (!roleService.checkExistsByPk(roleId)) {
                throw new ParamCheckRuntimeException();
            }
            List<SysPermission> sysPermissions = permissionService.selectByRoleIdAndType(roleId, SysPermission.TYPE_API);
            List<Map<String, String>> selectedList = sysPermissions.stream().map(permission -> {
                SysApi api = apiService.selectByPk(permission.getId());
                Map<String, String> data = new HashMap<>();
                data.put("name", permission.getPermissionName());
                data.put("url", api.getName());
                data.put("id", String.valueOf(api.getPermissionId()));
                return data;
            }).collect(Collectors.toList());
            returnData.put("selected", selectedList);
        }

        return SimpleResponse.ok(returnData);
    }

    @GetMapping("/select_option.json")
    @FrameApi
    public SimpleResponse<Map<String, Object>> selectList(@RequestParam(required = false) Integer roleId,
                                                          @RequestParam(required = false) Integer menuId){
        Map<String, Object> returnData = new HashMap<>();

        List<SysApi> apis = apiService.selectAll();
        List<Map<String, String>> options = apis.stream().map(api -> {
            Map<String, String> data = new HashMap<>();
            data.put("label", api.getName());
            data.put("value", String.valueOf(api.getPermissionId()));
            return data;
        }).collect(Collectors.toList());
        returnData.put("options", options);

        if (roleId != null) {
            if (!roleService.checkExistsByPk(roleId)) {
                throw new ParamCheckRuntimeException();
            }
            List<SysPermission> sysPermissions = permissionService.selectByRoleIdAndType(roleId, SysPermission.TYPE_API);
            List<Map<String, String>> selectedList = sysPermissions.stream().map(permission -> {
                SysApi api = apiService.selectByPk(permission.getId());
                Map<String, String> data = new HashMap<>();
                data.put("label", api.getName());
                data.put("value", String.valueOf(api.getPermissionId()));
                return data;
            }).collect(Collectors.toList());
            returnData.put("selected", selectedList);
        } else if(menuId != null){
            // TODO
            //List<String> selectedList = apiService.selectByMenuId(menuId).stream().map(api -> String.valueOf(api.getPermissionId())).collect(Collectors.toList());
            returnData.put("selected", Collections.EMPTY_LIST);
        }

        return SimpleResponse.ok(returnData);
    }


    @GetMapping("/findUserApi/{uuid}")
    public List<FramePermission> findUserApiByUuid(@PathVariable("uuid") String uuid){
        List<SysApi> apis = apiService.selectByUuid(uuid);
        return apis.stream().map(sysApi ->
                FramePermission.builder().method(sysApi.getMethodType()).url(sysApi.getUrl()).build())
                .collect(Collectors.toList());
    }
}
