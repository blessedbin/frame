package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.mapper.*;
import com.blessedbin.frame.ucenter.modal.SysRole;
import com.blessedbin.frame.ucenter.modal.SysRoleHasPermission;
import com.blessedbin.frame.ucenter.modal.SysUserHasRole;
import com.blessedbin.frame.ucenter.modal.SysUserHasRoleExample;
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
    private SysUserHasRoleMapper userHasRoleMapper;

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleHasPermissionMapper roleHasPermissionMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    public List<SysUserHasRole> findAllUserHasRoleByUuid(String uuid) {
        SysUserHasRoleExample example = new SysUserHasRoleExample();
        SysUserHasRoleExample.Criteria criteria = example.createCriteria();
        criteria.andSysUserUuidEqualTo(uuid);

        return userHasRoleMapper.selectByExample(example);
    }

    /**
     * 编辑用户觉得关系
     * TODO 检查角色和用户是否同属于一个组织
     *
     * @param uuid         用户ID
     * @param selectedRole 角色ID列表
     */
    @Transactional(rollbackFor = Exception.class)
    public void editUserRole(String uuid, List<Integer> selectedRole) {
        //清空全部
        userHasRoleMapper.deleteByUuid(uuid);
        if (CollectionUtils.isEmpty(selectedRole)) {
            return;
        }
        // 新建
        List<SysUserHasRole> collect = selectedRole.stream().map(id -> {
            SysUserHasRole sur = new SysUserHasRole();
            sur.setSysUserUuid(uuid);
            sur.setSysRoleId(id);
            return sur;
        }).collect(Collectors.toList());
        int count = userHasRoleMapper.insertLists(collect);

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
        roleHasPermissionMapper.deleteByRoleId(roleId);
        if (CollectionUtils.isEmpty(checkedList)) {
            //清空全部
            return;
        }

        // 查询与菜单关联的api id
        List<Integer> checkedListInteger = checkedList.stream().map(Integer::valueOf).collect(Collectors.toList());

        List<SysRoleHasPermission> list = checkedListInteger.stream().map(s -> {
            SysRoleHasPermission roleHasPermission = new SysRoleHasPermission();
            roleHasPermission.setSysRoleId(roleId);
            roleHasPermission.setSysPermissionId(s);
            return roleHasPermission;
        }).collect(Collectors.toList());
        try {
            int i = roleHasPermissionMapper.insertLists(list);
            log.debug("成功插入{}条数据", i);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ParamCheckRuntimeException(e);
        }

    }

    public List<SysRole> selectAllByUuid(String uuid) {
        return roleMapper.findRolesByUUid(uuid);
    }
}
