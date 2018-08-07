package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.ui.CascaderNode;
import com.blessedbin.frame.common.ui.TreeNode;
import com.blessedbin.frame.common.validate.PutMethodValidationGroup;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.entity.dto.ActionDto;
import com.blessedbin.frame.ucenter.entity.dto.MenuTreeDto;
import com.blessedbin.frame.ucenter.modal.SysMenu;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.modal.SysRoleHasPermission;
import com.blessedbin.frame.ucenter.service.ActionService;
import com.blessedbin.frame.ucenter.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/9.
 * 菜单管理
 * @author 37075
 * @date 2018/7/9
 * @time 14:01
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "${frame.base-path.ucenter}/sys/menu")
@Log4j2
@Api(description = "菜单管理")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private ActionService actionService;

    @RequestMapping("/tree_table.json")
    @FrameApi
    public SimpleResponse<List<MenuTreeDto>> treeTables(){
        return SimpleResponse.ok(menuService.getMenuTree());
    }

    @GetMapping("/cascader.json")
    @FrameApi
    public SimpleResponse<List<CascaderNode>> cascaderList(){
        List<CascaderNode> cascaders = menuService.getCascaders();
        return SimpleResponse.ok(cascaders);
    }

    @GetMapping("/menu_tree.json")
    @FrameApi
    public SimpleResponse menuTree(@RequestParam(required = false) Integer roleId) {
        Map<String,Object> datas = new HashMap<>();
        List<TreeNode> treeNodes = buildMenuTree(menuService.getMenuTree());
        datas.put("treeList",treeNodes);

        if(roleId != null){
            List<SysRoleHasPermission> rolePermissions = menuService.selectRolePermissionsByRoleId(roleId);
            List<String> rps = rolePermissions.stream()
                    .map(sysRoleHasPermission -> String.valueOf(sysRoleHasPermission.getSysPermissionId()))
                    .collect(Collectors.toList());
            datas.put("selectedList",rps);
        }
        return SimpleResponse.ok(datas);
    }

    private List<TreeNode> buildMenuTree(List<MenuTreeDto> treeList) {
        if(!CollectionUtils.isEmpty(treeList)){
            return treeList.stream().map(menuTreeDto -> {
                List<TreeNode> children = buildMenuTree(menuTreeDto.getChildren());
                if(children.isEmpty()){
                    List<ActionDto> actionDtos = actionService.selectByMenuId(menuTreeDto.getPermissionId());
                    children = actionDtos.stream().map(actionDto -> TreeNode.builder().id(String.valueOf(actionDto.getId()))
                            .label(actionDto.getPermissionName()).tag(actionDto.getType()).build())
                            .collect(Collectors.toList());
                }
                return TreeNode.builder()
                        .id(String.valueOf(menuTreeDto.getPermissionId())).tag(SysPermission.TYPE_MENU)
                        .label(menuTreeDto.getTitle()).children(children).build();
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    @PostMapping
    @FrameApi
    @ApiOperation(value = "添加菜单")
    public SimpleResponse add(@RequestBody @Validated SysMenu menu){
        // TODO 参数检验
        menuService.insert(menu);
        return SimpleResponse.created();
    }


    @GetMapping("/datatable.json")
    @FrameApi
    public SimpleResponse<Pagination<SysMenu>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                        @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                        @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Pagination<SysMenu> dataTable = menuService.getDataTable(pageNum, pageSize);
        return SimpleResponse.ok(dataTable);
    }

    @GetMapping
    @FrameApi
    @ApiOperation(value = "获取菜单")
    public SimpleResponse<Map<String, Object>> getOne(@RequestParam Integer id){
        Map<String, Object> result = new HashMap<>(2);
        SysMenu content = menuService.selectByPk(id);
        result.put("content",content);

        List<String> pids = new ArrayList<>();
        buildPids(content, pids);
        Collections.reverse(pids);
        result.put("pids",pids);

        return SimpleResponse.ok(result);
    }

    private void buildPids(SysMenu content, List<String> pids) {
        if(content.getPid() != null){
            SysMenu parent = menuService.selectByPk(content.getPid());
            pids.add(String.valueOf(parent.getPermissionId()));
            buildPids(parent,pids);
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping
    @FrameApi
    public SimpleResponse delete(@RequestParam Integer id){
        menuService.deleteByPk(id);
        return SimpleResponse.deleted();
    }

    @PutMapping
    @FrameApi
    public SimpleResponse edit(@RequestBody @Validated(PutMethodValidationGroup.class) SysMenu menu){
        log.debug("request param:{}",menu);
        menuService.updateByPkSelective(menu);
        return SimpleResponse.accepted();
    }


    /**
     * 保存菜单和权限的关系
     */
    @PostMapping("/save_menu_api.do")
    @FrameApi
    public SimpleResponse saveMenuApiRelation(@Validated @RequestBody MenuApiRelationParam param){

        Integer menuId = param.getMenuId();
        boolean exists = menuService.checkExistsByPk(menuId);
        if(!exists){
            throw new ParamCheckRuntimeException();
        }

        return SimpleResponse.accepted();
    }


    @Data
    public static class MenuApiRelationParam{

        private List<Integer> selected;

        @NotNull
        private Integer menuId;
    }
}
