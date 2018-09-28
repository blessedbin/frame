package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.entity.pojo.Operation;
import com.blessedbin.frame.ucenter.mapper.SysPermissionMapper;
import com.blessedbin.frame.ucenter.mapper.SysRoleMapper;
import com.blessedbin.frame.ucenter.mapper.SysRolePermissionMapper;
import com.blessedbin.frame.ucenter.mapper.SysUserRoleMapper;
import com.blessedbin.frame.ucenter.modal.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private SysPermissionMapper permissionMapper;


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
     * @param roleId 角色ID
     * @param checkedList 选择的菜单的权限
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveRolePermission(Integer roleId, List<String> checkedList) {

        SysRole role = selectByPk(roleId);
        if(role == null){
            throw new ParamCheckRuntimeException("角色不存在");
        }

        rolePermissionMapper.deleteByRoleId(roleId);
        if (CollectionUtils.isEmpty(checkedList)) {
            //清空全部
            return;
        }

        List<Integer> permissionIds = new ArrayList<>();
        checkedList.stream().map(Integer::valueOf).forEach(id -> {

            SysPermission permission = permissionService.selectByPk(id);
            permissionIds.add(id);

            // 添加API权限
            if(SysPermission.TYPE_OPERATION.equals(permission.getType())) {
                Operation operation = operationService.toOperation(permission);
                if(!CollectionUtils.isEmpty(operation.getApis())){
                    operation.getApis().forEach(permissionIds::add);
                }
            }

        });

        // 过滤掉失效的permissionid
        List<SysRolePermission> srps = permissionMapper.selectIdsByInIds(permissionIds).stream().map(id -> {
            SysRolePermission rp = new SysRolePermission();
            rp.setSysRoleId(roleId);
            rp.setSysPermissionId(id);
            return rp;
        }).collect(Collectors.toList());

        int i = rolePermissionMapper.insertLists(srps);

        log.debug("更新API成功，角色：{}，添加数量：{}，过滤数量：{}",
                role.getRoleName(),i,(permissionIds.size() - i));

    }

    public List<SysRole> selectAllByUuid(String uuid) {
        return roleMapper.selectRolesByUUid(uuid);
    }

    public List<SysRole> selectAllByUuidAndEnabled(String uuid){
        return roleMapper.selectAllByUuidAndEnabled(uuid);
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
