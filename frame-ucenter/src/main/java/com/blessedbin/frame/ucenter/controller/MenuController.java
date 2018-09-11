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
import com.blessedbin.frame.ucenter.entity.pojo.Menu;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.modal.SysRolePermission;
import com.blessedbin.frame.ucenter.service.MenuService;
import com.blessedbin.frame.ucenter.service.OperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping(value = "/sys/menu")
@Log4j2
@Api(description = "菜单管理",tags = "菜单管理")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private OperationService actionService;

    @RequestMapping("/tree_table.json")
    public SimpleResponse<List<MenuTreeDto>> treeTables(){
        return SimpleResponse.ok(menuService.getMenuTree());
    }

    @GetMapping("/cascader.json")
    public SimpleResponse<List<CascaderNode>> cascaderList(){
        List<CascaderNode> cascaders = menuService.getCascaders();
        return SimpleResponse.ok(cascaders);
    }

    @GetMapping("/menu_tree.json")
    public SimpleResponse menuTree(@RequestParam(required = false) Integer roleId) {
        Map<String,Object> datas = new HashMap<>();
        List<TreeNode> treeNodes = buildMenuTree(menuService.getMenuTree());
        datas.put("treeList",treeNodes);

        if(roleId != null){
            List<SysRolePermission> rolePermissions = menuService.selectRolePermissionsByRoleId(roleId);
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
                            .label(actionDto.getName()).tag(actionDto.getType()).build())
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
    @ApiOperation(value = "添加菜单")
    public SimpleResponse add(@RequestBody @Validated Menu menu){
        // TODO 参数检验
        menuService.addMenu(menu);
        return SimpleResponse.created();
    }


    @GetMapping
    @ApiOperation(value = "获取菜单")
    public SimpleResponse<Menu> getOne(@RequestParam Integer id){
        Menu content = menuService.getMenu(id);
        return SimpleResponse.ok(content);
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
    public SimpleResponse edit(@RequestBody @Validated(PutMethodValidationGroup.class) Menu menu){
        log.debug("request param:{}",menu);
        menuService.updateByPkSelective(menu);
        return SimpleResponse.accepted();
    }


    /**
     * 保存菜单和权限的关系
     * @param param
     */
    @PostMapping("/save_menu_api.do")
    @ApiOperation(value = "保存功能点与API的关系")
    public SimpleResponse saveMenuApiRelation(@Validated @RequestBody MenuApiRelationParam param){

        log.debug("[MenuController]Request param:{}",param);

        Integer menuId = param.getMenuId();
        boolean exists = menuService.checkActionExistsByPk(menuId);
        if(!exists){
            throw new ParamCheckRuntimeException("参数非法");
        }

        menuService.saveActionApiRelation(param.getMenuId(),param.getSelected());

        return SimpleResponse.accepted();
    }

    /**
     * TODO
     * 查看功能点拥有的API的ID
     * @param actionId
     */
    @GetMapping("/action_api_selected.json")
    public SimpleResponse<List<Integer>> getSelected(@RequestParam Integer actionId) {
        return SimpleResponse.ok();
    }


    @Data
    public static class MenuApiRelationParam{

        private List<Integer> selected;

        @NotNull
        private Integer menuId;
    }
}
