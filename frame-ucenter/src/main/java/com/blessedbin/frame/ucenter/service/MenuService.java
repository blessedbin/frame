package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.exception.ResourceNotFoundException;
import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.common.ui.CascaderNode;
import com.blessedbin.frame.ucenter.entity.dto.MenuTreeDto;
import com.blessedbin.frame.ucenter.mapper.*;
import com.blessedbin.frame.ucenter.modal.*;
import com.github.promeg.pinyinhelper.Pinyin;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
public class MenuService extends AbstractMysqlCrudServiceImpl<SysMenu,Integer> {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Autowired
    private SysMenuMapper menuMapper;

    @Autowired
    private SysRoleHasPermissionMapper roleHasPermissionMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysMenuHasApiMapper menuHasApiMapper;

    public List<MenuTreeDto>  getMenuTree(){
        return getTopAll().stream().map(sysMenu -> {
            MenuTreeDto dto = new MenuTreeDto();
            BeanUtils.copyProperties(sysMenu,dto);
            dto.setChildren(buildMenuTree(sysMenu));
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

        // TODO 逻辑方面的优化，Role信息从参数获取或者从缓存获取，而不是每次查询数据库
        List<SysRole> roles = roleMapper.selectRolesByUUid(uuid);
        boolean b = roles.stream().map(SysRole::getRoleKey).anyMatch(s -> "ROLE_ADMIN".equals(s));
        List<SysMenu> menus;
        if(b){
            menus = menuMapper.selectAllMenus();
        }else {
            // 去重，TODO 在数据库中做去重操作
            menus = menuMapper.selectMenusByUuidAndEnabled(uuid).stream()
                    .distinct().collect(Collectors.toList());
        }

        return menus.stream().filter(menu -> menu.getPid() == null)
                .map(menu -> {
                    MenuTreeDto dto = new MenuTreeDto();
                    BeanUtils.copyProperties(menu,dto);
                    dto.setChildren(buildUserMenuTree(menus,menu.getPermissionId()));
                    return dto;
                }).collect(Collectors.toList());
    }

    private List<MenuTreeDto> buildUserMenuTree(List<SysMenu> menus, Integer pid){
        return menus.stream().filter(menu -> pid.equals(menu.getPid())).map(menu -> {
            MenuTreeDto dto = new MenuTreeDto();
            BeanUtils.copyProperties(menu,dto);
            dto.setChildren(buildUserMenuTree(menus,menu.getPermissionId()));
            return dto;
        }).collect(Collectors.toList());
    }

    /**
     * 递归构建树
     * @param menu
     * @return
     */
    private List<MenuTreeDto> buildMenuTree(SysMenu menu){
        return getAllByPid(menu.getPermissionId()).stream().map(sysMenu -> {
            MenuTreeDto dto = new MenuTreeDto();
            BeanUtils.copyProperties(sysMenu,dto);
            dto.setChildren(buildMenuTree(sysMenu));
            return dto;
        }).collect(Collectors.toList());
    }

    public List<CascaderNode> getCascaders() {
        List<CascaderNode> nodes = new ArrayList<>();
        nodes.add(CascaderNode.builder().value("-1").label("一级菜单").build());
        List<CascaderNode> cascaderNodes = buildCascader(null);
        if (cascaderNodes != null) {
            nodes.addAll(cascaderNodes);
        }
        return nodes;
    }

    private List<CascaderNode> buildCascader(Integer parentId) {
        return getAllByPid(parentId).stream().map(menu -> CascaderNode.builder()
                    .value(String.valueOf(menu.getPermissionId()))
                    .label(menu.getTitle())
                    .children(buildCascader(menu.getPermissionId()))
                    .build())
                .collect(Collectors.toList());
    }

    /**
     * 获取所有顶级菜单
     * @return
     */
    private List<SysMenu> getTopAll(){
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andPidIsNull();
        example.setOrderByClause("sort ASC");

        return mapper.selectByExample(example);
    }

    /**
     * 根据pid获取所有节点
     * @param pid
     * @return
     */
    private List<SysMenu> getAllByPid(Integer pid){
        if(pid == null){
            return getTopAll();
        }
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andPidEqualTo(pid).andTypeEqualTo(SysMenu.MENU);
        example.setOrderByClause("sort ASC");

        return mapper.selectByExample(example);
    }


    /**
     * 重写添加方法
     * @param menu 要添加的数据
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SysMenu menu) {
        validateParam(menu);

        SysPermission permission = buildPermission(menu);

        // 检查自动生成的permission key是否重复,若重复则重新生成key
        int i = 1;
        while(permissionMapper.selectByPermissionKey(permission.getPermissionKey())!= null){
            permission.setPermissionKey(permission.getPermissionKey() + i);
            i ++;
        }

        permissionService.insert(permission);

        Date updateTime = new Date();
        menu.setPermissionId(permission.getId());
        menu.setCreateTime(updateTime);
        menu.setUpdateTime(updateTime);

        return super.insertSelective(menu);
    }

    private SysPermission buildPermission(SysMenu menu) {
        SysPermission permission = new SysPermission();
        Date updateTime = new Date();
        permission.setCreateTime(updateTime);
        permission.setEnabled(menu.getEnabled());

        String key;

        key = Pinyin.toPinyin(menu.getTitle(), "-");

        permission.setPermissionKey(SysPermission.TYPE_MENU + "-" +key);
        permission.setRemark(menu.getRemark());
        permission.setPermissionName(menu.getTitle());
        permission.setSort(menu.getSort());
        // TODO 换成动态的
        permission.setSysSystemId("user_center");
        permission.setType(SysPermission.TYPE_MENU);
        permission.setUpdateTime(updateTime);

        return permission;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPk(Integer id) {
        roleHasPermissionMapper.deleteByPermissionId(id);
        return permissionService.deleteByPk(id);
    }

    /**
     * TODO 更新字段的逻辑问题
     * @param menu 要修改的对象
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPkSelective(SysMenu menu) {
        validateParam(menu);

        SysPermission prePermission = permissionService.selectByPk(menu.getPermissionId());
        SysPermission nPermission = buildPermission(menu);
        nPermission.setCreateTime(prePermission.getCreateTime());
        if(!prePermission.equals(nPermission)){
            nPermission.setId(prePermission.getId());
            permissionService.updateByPkSelective(nPermission);
        }

        menu.setUpdateTime(new Date());

        return super.updateByPkSelective(menu);
    }

    private void validateParam(SysMenu menu) {
        if(menu.getPid() == null || menu.getPid() == -1){
            menu.setPid(null);
        }else{
            SysMenu pk = selectByPk(menu.getPid());
            if(pk == null){
                throw new ParamCheckRuntimeException("参数错误");
            }
        }
    }

    /**
     * 查找某角色下对应的已选菜单权限,只返回叶子节点
     * @param roleId
     * @return
     */
    public List<SysRoleHasPermission> selectRolePermissionsByRoleId(Integer roleId) {
        return roleHasPermissionMapper.selectByRoleId(roleId);
    }


    /**
     * 检查菜单是否有子菜单
     * @param menuId menu id
     * @return 若有子菜单，返回true，否则返回false
     */
    public boolean hasChildren(Integer menuId){
        if(!checkExistsByPk(menuId)){
            throw new ResourceNotFoundException();
        }
        List<SysMenu> sysMenus = menuMapper.selectMenusByPid(menuId);
        return !sysMenus.isEmpty();
    }

    /**
     * 检验功能点ID是否合法
     * @param menuId
     * @return
     */
    public boolean checkActionExistsByPk(Integer menuId) {
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andTypeEqualTo(SysMenu.ACTION).andPermissionIdEqualTo(menuId);
        return menuMapper.selectCountByExample(example) > 0;
    }

    /**
     * 保存权限点和API的关系
     * @param actionId
     * @param selected
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveActionApiRelation(Integer actionId, List<Integer> selected) {

        menuHasApiMapper.deleteByMenuIdAndType(actionId);
        if(selected.isEmpty()){
            return;
        }

        List<SysMenuHasApi> collect = selected.stream().map(integer -> {
            SysMenuHasApi smha = new SysMenuHasApi();
            smha.setSysApiPermissionId(integer);
            smha.setSysMenuPermissionId(actionId);
            return smha;
        }).collect(Collectors.toList());

        int i = menuHasApiMapper.insertLists(collect);
        log.debug("成功更新{}条数据",i);

    }

    public List<SysMenuHasApi> getActionSelectedApi(Integer actionId) {
        SysMenuHasApiExample example = new SysMenuHasApiExample();
        example.createCriteria().andSysMenuPermissionIdEqualTo(actionId);
        return menuHasApiMapper.selectByExample(example);
    }
}
