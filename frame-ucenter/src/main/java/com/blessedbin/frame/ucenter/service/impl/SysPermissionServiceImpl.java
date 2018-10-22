package com.blessedbin.frame.ucenter.service.impl;

import com.blessedbin.frame.ucenter.entity.SysPermission;
import com.blessedbin.frame.ucenter.entity.SysRolePermission;
import com.blessedbin.frame.ucenter.mapper.SysPermissionMapper;
import com.blessedbin.frame.ucenter.mapper.SysRolePermissionMapper;
import com.blessedbin.frame.ucenter.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Autowired
    private SysRolePermissionMapper rolePermissionMapper;

    /**
     * TODO
     * @param roleId
     * @return
     */
    public List<SysPermission> selectByRoleId(Integer roleId) {
        return null;
    }


    public List<Integer> selectPermissionIdsByRoleId(Integer roleId){
        return rolePermissionMapper.selectByRoleId(roleId).stream().map(SysRolePermission::getSysPermissionId)
                .collect(Collectors.toList());
    }

    @Override
    public List<SysPermission> selectByRoleIdAndType(Integer roleId) {
        return baseMapper.selectByRoleId(roleId);
    }

    @Override
    public SysPermission selectByIdentification(String code) {
        return baseMapper.selectByIdentification(code);
    }


    @Override
    public List<SysPermission> selectByType(String type){
        return baseMapper.selectByType(type);
    }

    @Override
    public SysPermission selectByPkAndType(Integer id, String type) {
        return baseMapper.selectByPrimaryKeyAndType(id,type);
    }

    @Override
    public List<SysPermission> selectByPksAndType(List<Integer> ids, String type) {
        return baseMapper.selectByPrimaryKeysAndType(ids,type);
    }

    public List<SysPermission> selectByUuid(String uuid){
        return baseMapper.selectByUuid(uuid);
    }

    @Override
    public List<SysPermission> selectByUuidAndType(String uuid,String type){
        return baseMapper.selectByUuidAndType(uuid,type);
    }

}
