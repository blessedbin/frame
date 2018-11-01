package com.blessedbin.frame.ucenter.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blessedbin.frame.common.exception.ResourceNotFoundException;
import com.blessedbin.frame.ucenter.entity.SysPermission;
import com.blessedbin.frame.ucenter.entity.SysRole;
import com.blessedbin.frame.ucenter.entity.SysRolePermission;
import com.blessedbin.frame.ucenter.entity.dto.MenuTreeDto;
import com.blessedbin.frame.ucenter.entity.pojo.Menu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.blessedbin.frame.ucenter.entity.SysPermission.TYPE_MENU;

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
    private ISysPermissionService permissionService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ObjectMapper objectMapper;


    private List<Menu> allMenus(){
        List<SysPermission> permissions = permissionService.selectByType(TYPE_MENU);
        return toMenus(permissions);
    }

    private List<Menu> allMenuEnabled() {

        LambdaQueryWrapper<SysPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysPermission::getType,TYPE_MENU).eq(SysPermission::getEnabled,Boolean.TRUE);
        List<SysPermission> permissions = permissionService.list(wrapper);
        return toMenus(permissions);
    }

    private List<Menu> toMenus(List<SysPermission> permissions) {
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

    private List<MenuTreeDto> buildMenuTree(List<Menu> menus,Integer pid){
        return menus.stream().sorted((o1, o2) -> {
            Integer a = o1.getSort() == null ? 0 : o1.getSort();
            Integer b = o2.getSort() == null ? 0 : o2.getSort();
            return b-a;
        }).filter(menu -> menu.getPid().equals(pid)).map(menu -> {
            MenuTreeDto dto = new MenuTreeDto();
            BeanUtils.copyProperties(menu,dto);
            dto.setChildren(buildMenuTree(menus,menu.getId()));
            return dto;
        }).collect(Collectors.toList());
    }


    public List<MenuTreeDto>  getMenuTree(){
        return buildMenuTree(allMenus(),-1);
    }

    public List<MenuTreeDto> getMenuTreeEnabled() {
        return buildMenuTree(allMenuEnabled(), -1);
    }

    /**
     * 获取用户菜单列表
     * @param uuid 用户唯一编码
     * @return
     */
    public List<MenuTreeDto> getUserMenu(String uuid){
        Assert.notNull(uuid,"uuid is not null");

        // 判断是否是超级管理员
        List<SysRole> roles = roleService.selectByUuid(uuid);
        boolean isAdmin = roles.stream().anyMatch(role -> "ROLE_ADMIN".equals(role.getRoleKey()));
        if(isAdmin) {
            return getMenuTreeEnabled();
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
        permission.setCreateTime(LocalDateTime.now());
        permission.setUpdateTime(LocalDateTime.now());
        permission.setType(TYPE_MENU);
        permission.setSort(menu.getSort());
        permission.setCode("menu::" + menu.getName());

        try {
            permission.setAdditionInformation(objectMapper.writeValueAsString(menu));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        permissionService.save(permission);
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
            throw new ResourceNotFoundException();
        }
        try {
            permission.setAdditionInformation(objectMapper.writeValueAsString(menu));
            permission.setEnabled(menu.getEnabled());
            permission.setUpdateTime(LocalDateTime.now());
            permissionService.updateById(permission);
        } catch (JsonProcessingException e) {
            log.error("JSON编码错误");
        }
    }


    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer id) {
        return permissionService.removeById(id);
    }


    /**
     *
     * 检查菜单是否有子菜单
     * @param menuId menu id
     * @return 若有子菜单，返回true，否则返回false
     */
    public boolean hasChildren(Integer menuId){
        return permissionService.countMenuByPid(menuId) > 0;
    }


    /**
     *
     * 获取menu
     * @param id menu的Id
     * @return
     */
    public Menu getMenu(Integer id) {
        SysPermission permission = permissionService.getById(id);
        if(permission == null) {
            return null;
        }
        return toMenu(permission);
    }


    private Menu toMenu(SysPermission permission){
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
