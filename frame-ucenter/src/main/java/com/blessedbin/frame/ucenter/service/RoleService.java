package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.mapper.*;
import com.blessedbin.frame.ucenter.modal.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 17:01
 * @tool intellij idea
 */
@Service
@Log4j2
public class RoleService extends AbstractMysqlCrudServiceImpl<SysRole, Integer> {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private SysRolePermissionMapper rolePermissionMapper;

    @Autowired
    private SysRoleMapper roleMapper;


    public List<SysUserRole> findAllUserHasRoleByUuid(String uuid) {
        SysUserRoleExample example = new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andSysUserUuidEqualTo(uuid);

        return userRoleMapper.selectByExample(example);
    }

    /**
     * 编辑用户角色关系
     *
     * @param uuid         用户ID
     * @param selectedRole 角色ID列表
     */
    @Transactional(rollbackFor = Exception.class)
    public void editUserRole(String uuid, List<Integer> selectedRole) {
        //清空全部
        userRoleMapper.deleteByUuid(uuid);
        if (CollectionUtils.isEmpty(selectedRole)) {
            return;
        }
        // 新建
        List<SysUserRole> collect = selectedRole.stream().map(id -> {
            SysUserRole sur = new SysUserRole();
            sur.setSysUserUuid(uuid);
            sur.setSysRoleId(id);
            return sur;
        }).collect(Collectors.toList());
        int count = userRoleMapper.insertLists(collect);

        log.debug("<<< 保存成功，共更新{}条数据", count);
    }

    /**
     * 保存角色权限关系
     *
     * @param roleId
     * @param checkedList 选择的菜单的权限
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveRolePermission(Integer roleId, List<String> checkedList) {
        rolePermissionMapper.deleteByRoleId(roleId);
        if (CollectionUtils.isEmpty(checkedList)) {
            //清空全部
            return;
        }

        // 查询与菜单关联的api id
        // TODO

    }

    public List<SysRole> selectAllByUuid(String uuid) {
        return roleMapper.selectRolesByUUid(uuid);
    }


    /**
     *
     * @param key 角色关键字
     * @return
     */
    public SysRole selectByKey(String key){
        return roleMapper.selectByRoleKey(key);
    }
}
