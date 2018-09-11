package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.mapper.SysPermissionMapper;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<SysPermission> selectByRoleId(Integer roleId) {
        return null;
    }

    public List<SysPermission> selectByRoleIdAndType(Integer roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }

    public SysPermission selectByIdentification(String code) {
        return permissionMapper.selectByIdentification(code);
    }
}
