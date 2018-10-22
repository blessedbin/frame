package com.blessedbin.frame.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.ucenter.entity.SysPermission;
import com.blessedbin.frame.ucenter.entity.SysRole;
import com.blessedbin.frame.ucenter.entity.SysRolePermission;
import com.blessedbin.frame.ucenter.entity.SysUserRole;
import com.blessedbin.frame.ucenter.entity.pojo.Operation;
import com.blessedbin.frame.ucenter.mapper.SysRoleMapper;
import com.blessedbin.frame.ucenter.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
@Service
@Log4j2
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private ISysUserRoleService userRoleService;

    @Autowired
    private ISysRolePermissionService rolePermissionService;

    @Autowired
    private ISysPermissionService permissionService;

    @Autowired
    private OperationService operationService;

    @Override
    public boolean existsById(Serializable id) {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getId,id);
        return exists(wrapper);
    }

    @Override
    public boolean exists(Wrapper<SysRole> wrapper) {
        return count(wrapper) > 0;
    }

    /**
     * 编辑用户角色关系
     *
     * @param uuid         用户ID
     * @param selectedRole 角色ID列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUserRole(String uuid, List<Integer> selectedRole) {
        //清空全部
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getSysUserUuid,uuid);
        userRoleService.remove(wrapper);
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
        userRoleService.saveBatch(collect);
    }

    /**
     * TODO 保存角色和权限之间的关系
     * TODO 业务逻辑需要完善
     * @param roleId
     * @param checkedList
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRolePermission(Integer roleId, List<String> checkedList) {
        SysRole role = getById(roleId);
        if(role == null){
            throw new ParamCheckRuntimeException("角色不存在");
        }

        LambdaQueryWrapper<SysRolePermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRolePermission::getSysRoleId,roleId);
        rolePermissionService.remove(wrapper);

        if (CollectionUtils.isEmpty(checkedList)) {
            //清空全部
            return;
        }

        List<Integer> permissionIds = new ArrayList<>();
        checkedList.stream().map(Integer::valueOf).forEach(id -> {

            SysPermission permission = permissionService.getById(id);
            permissionIds.add(id);

            // 添加API权限
            if(SysPermission.TYPE_OPERATION.equals(permission.getType())) {
                Operation operation = operationService.toOperation(permission);
                if(!CollectionUtils.isEmpty(operation.getApis())){
                    operation.getApis().forEach(permissionIds::add);
                }
            }

        });

        /*// 过滤掉失效的permissionid
        List<SysRolePermission> srps = permissionMapper.selectIdsByInIds(permissionIds).stream().map(id -> {
            SysRolePermission rp = new SysRolePermission();
            rp.setSysRoleId(roleId);
            rp.setSysPermissionId(id);
            return rp;
        }).collect(Collectors.toList());

        int i = rolePermissionMapper.insertLists(srps);*/

        /*log.debug("更新API成功，角色：{}，添加数量：{}，过滤数量：{}",
                role.getRoleName(),i,(permissionIds.size() - i));*/
    }

    @Override
    public List<SysRole> selectAllByUuid(String uuid) {
        return null;
    }

    /**
     * @param key 角色关键字
     * @return
     */
    @Override
    public SysRole selectByKey(String key) {
        return null;
    }
}
