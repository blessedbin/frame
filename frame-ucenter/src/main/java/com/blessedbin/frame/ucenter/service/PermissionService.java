package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.mapper.SysPermissionMapper;
import com.blessedbin.frame.ucenter.mapper.SysRolePermissionMapper;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.blessedbin.frame.ucenter.modal.SysRolePermission;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 15:14
 * @tool intellij idea
 */
@Service
@Log4j2
public class PermissionService extends AbstractMysqlCrudServiceImpl<SysPermission,Integer> {

    @Autowired
    private SysPermissionMapper permissionMapper;

    @Autowired
    private SysRolePermissionMapper rolePermissionMapper;

    public List<SysPermission> selectByRoleId(Integer roleId) {
        return null;
    }


    public List<Integer> selectPermissionIdsByRoleId(Integer roleId){
        return rolePermissionMapper.selectByRoleId(roleId).stream().map(SysRolePermission::getSysPermissionId)
                .collect(Collectors.toList());
    }

    public List<SysPermission> selectByRoleIdAndType(Integer roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }

    public SysPermission selectByIdentification(String code) {
        return permissionMapper.selectByIdentification(code);
    }

    public List<SysPermission> selectByType(String type){
        return permissionMapper.selectByType(type);
    }

    public SysPermission selectByPkAndType(Integer id, String type) {
        return permissionMapper.selectByPrimaryKeyAndType(id,type);
    }

    public List<SysPermission> selectByPksAndType(List<Integer> ids, String type) {
        return permissionMapper.selectByPrimaryKeysAndType(ids,type);
    }
}
