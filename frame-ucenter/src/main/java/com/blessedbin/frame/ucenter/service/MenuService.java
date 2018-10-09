package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.ui.CascaderNode;
import com.blessedbin.frame.ucenter.entity.dto.MenuTreeDto;
import com.blessedbin.frame.ucenter.entity.pojo.Menu;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.modal.SysRole;
import com.blessedbin.frame.ucenter.modal.SysRolePermission;
import com.blessedbin.frame.ucenter.modal.SysUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.blessedbin.frame.ucenter.modal.SysPermission.TYPE_MENU;
import static java.util.Collections.EMPTY_LIST;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 14:35
 * @tool intellij idea
 */
@Service
@Log4j2
public class MenuService {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @Autowired
    private ObjectMapper objectMapper;


    private List<Menu> allMenus(){
        List<SysPermission> permissions = permissionService.selectByType(TYPE_MENU);
        return permissions.stream().map(permission -> {
            try {
                Menu menu = objectMapper.readValue(permission.getAdditionInformation(), Menu.class);
                menu.setId(permission.getPermissionId());
                return menu;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }


    public List<MenuTreeDto>  getMenuTree(){
        return buildMenuTree(allMenus(),-1);
    }

    private List<MenuTreeDto> buildMenuTree(List<Menu> menus,Integer pid){
        return menus.stream().filter(menu -> menu.getPid().equals(pid)).map(menu -> {
            MenuTreeDto dto = new MenuTreeDto();
            BeanUtils.copyProperties(menu,dto);
            dto.setChildren(buildMenuTree(menus,menu.getId()));
            return dto;
        }).collect(Collectors.toList());
    }

    /**
     * 获取用户菜单列表
     * @param uuid 用户唯一编码
     * @return
     */
    public List<MenuTreeDto> getUserMenu(String uuid){
        Assert.notNull(uuid,"uuid is not null");

        // 判断是否是超级管理员
        List<SysRole> roles = roleService.selectAllByUuid(uuid);
        boolean isAdmin = roles.stream().anyMatch(role -> "ROLE_ADMIN".equals(role.getRoleKey()));
        if(isAdmin) {
            return getMenuTree();
        }

        List<SysPermission> permissions = permissionService.selectByUuidAndType(uuid, TYPE_MENU);
        List<Menu> collect = permissions.stream().map(this::toMenu).collect(Collectors.toList());
        return buildMenuTree(collect,-1);
    }



    /**
     * 添加菜单
     * @param menu 要添加的数据
     */
    @Transactional(rollbackFor = Exception.class)
    public void addMenu(Menu menu) {

        SysPermission permission = new SysPermission();
        permission.setName(menu.getTitle());
        permission.setCreateTime(new Date());
        permission.setUpdateTime(new Date());
        permission.setType(TYPE_MENU);
        permission.setSort(menu.getSort());
        permission.setCode("menu::" + menu.getName());

        try {
            permission.setAdditionInformation(objectMapper.writeValueAsString(menu));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        permissionService.insertSelective(permission);
    }


    /**
     * 更新菜单
     * @param menu
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(Menu menu){
        Assert.notNull(menu.getId(),"menu id should not null");
        SysPermission permission = permissionService.selectByPkAndType(menu.getId(),TYPE_MENU);
        if(permission == null) {
            throw new IllegalArgumentException();
        }
        try {
            permission.setAdditionInformation(objectMapper.writeValueAsString(menu));
            permissionService.updateByPkSelective(permission);
        } catch (JsonProcessingException e) {
            log.error("JSON编码错误");
        }
    }



    @Transactional(rollbackFor = Exception.class)
    public int deleteByPk(Integer id) {
        return permissionService.deleteByPk(id);
    }

    /**
     * TODO
     * 查找某角色下对应的已选菜单权限,只返回叶子节点
     * @param roleId
     * @return
     */
    public List<SysRolePermission> selectRolePermissionsByRoleId(Integer roleId) {
        return null;
    }


    /**
     * TODO
     * 检查菜单是否有子菜单
     * @param menuId menu id
     * @return 若有子菜单，返回true，否则返回false
     */
    public boolean hasChildren(Integer menuId){
        return false;
    }

    /**
     * TODO
     * 检验功能点ID是否合法
     * @param menuId
     * @return
     */
    public boolean checkActionExistsByPk(Integer menuId) {
        return true;
    }

    /**
     * 保存权限点和API的关系
     * @param actionId
     * @param selected
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveActionApiRelation(Integer actionId, List<Integer> selected) {

        //TODO
        log.debug("成功更新{}条数据");

    }

    /**
     *
     * 获取menu
     * @param id menu的Id
     * @return
     */
    public Menu getMenu(Integer id) {
        SysPermission permission = permissionService.selectByPk(id);
        if(permission == null) {
            return null;
        }
        return toMenu(permission);
    }


    public Menu toMenu(SysPermission permission){
        Assert.notNull(permission,"permission can not be null");
        if(TYPE_MENU.equals(permission.getType())){
            Menu menu = null;
            try {
                menu = objectMapper.readValue(permission.getAdditionInformation(), Menu.class);
                menu.setId(permission.getPermissionId());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return menu;
        } else {
            throw new IllegalArgumentException("type error...");
        }
    }
}
