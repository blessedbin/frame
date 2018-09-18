package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.ui.TreeNode;
import com.blessedbin.frame.common.validate.PutMethodValidationGroup;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.entity.dto.MenuTreeDto;
import com.blessedbin.frame.ucenter.entity.pojo.Menu;
import com.blessedbin.frame.ucenter.entity.pojo.Operation;
import com.blessedbin.frame.ucenter.entity.pojo.SysApi;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.service.ApiService;
import com.blessedbin.frame.ucenter.service.MenuService;
import com.blessedbin.frame.ucenter.service.OperationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    private OperationService operationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ApiService apiService;

    @GetMapping("/menu_tree.json")
    public SimpleResponse menuTree(@RequestParam(required = false) Integer roleId) {
        Map<String,Object> datas = new HashMap<>();
        List<TreeNode> treeNodes = buildMenuTree(menuService.getMenuTree());
        datas.put("treeList",treeNodes);
        return SimpleResponse.ok(datas);
    }

    private List<TreeNode> buildMenuTree(List<MenuTreeDto> treeList) {
        if(!CollectionUtils.isEmpty(treeList)){
            return treeList.stream().map(menuTreeDto -> {
                List<TreeNode> children = buildMenuTree(menuTreeDto.getChildren());
                return TreeNode.builder()
                        .id(String.valueOf(menuTreeDto.getId())).tag(SysPermission.TYPE_MENU)
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


    @GetMapping("{id}")
    @ApiOperation(value = "获取菜单")
    public SimpleResponse<Menu> getOne(@PathVariable Integer id){
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

    /**
     * TODO
     * @param menu
     * @return
     */
    @PutMapping
    public SimpleResponse edit(@RequestBody @Validated(PutMethodValidationGroup.class) Menu menu){
        log.debug("request param:{}",menu);
        return SimpleResponse.accepted();
    }

    @GetMapping("menu_details.json")
    public SimpleResponse<ForeignMenu> menuDetails(@RequestParam Integer id){
        Menu menu = menuService.getMenu(id);
        if(menu == null) {
            throw new ParamCheckRuntimeException();
        }

        ForeignMenu fm = new ForeignMenu();
        BeanUtils.copyProperties(menu,fm);

        if(!CollectionUtils.isEmpty(menu.getOperations())){
            List<Operation> operations = operationService.getOperations(menu.getOperations());
            List<ForeignOperation> collect = operations.stream().map(operation -> {
                ForeignOperation fo = new ForeignOperation();
                BeanUtils.copyProperties(operation, fo);
                if(!CollectionUtils.isEmpty(operation.getApis())){
                    List<SysApi> apis = apiService.getApis(operation.getApis());
                    fo.setApiDetails(apis);
                }
                return fo;
            }).collect(Collectors.toList());
            fm.setOperationDetails(collect);
        }

        return SimpleResponse.ok(fm);
    }

    public static class ForeignOperation extends Operation{

        private List<SysApi> apiDetails;

        public List<SysApi> getApiDetails() {
            return apiDetails;
        }

        public void setApiDetails(List<SysApi> apiDetails) {
            this.apiDetails = apiDetails;
        }
    }


    public static class ForeignMenu extends Menu {

        private List<ForeignOperation> operationDetails;

        public void setOperationDetails(List<ForeignOperation> operationDetails) {
            this.operationDetails = operationDetails;
        }

        public List<ForeignOperation> getOperationDetails() {
            return operationDetails;
        }
    }
}
