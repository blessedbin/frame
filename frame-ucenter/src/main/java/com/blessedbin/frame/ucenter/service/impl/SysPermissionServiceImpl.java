package com.blessedbin.frame.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    @Override
    public List<SysPermission> selectByRoleIdAndType(Integer roleId) {
        return baseMapper.selectByRoleId(roleId);
    }

    @Override
    public SysPermission selectByCode(String code) {
        LambdaQueryWrapper<SysPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysPermission::getCode,code);
        return baseMapper.selectOne(wrapper);
    }


    @Override
    public List<SysPermission> selectByType(String type){
        LambdaQueryWrapper<SysPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysPermission::getType,type);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public SysPermission selectByPkAndType(Integer id, String type) {
        LambdaQueryWrapper<SysPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysPermission::getType,type);
        wrapper.eq(SysPermission::getPermissionId,id);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<SysPermission> selectByPksAndType(List<Integer> ids, String type) {
        LambdaQueryWrapper<SysPermission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysPermission::getType,type);
        wrapper.in(SysPermission::getPermissionId,ids);
        return baseMapper.selectList(wrapper);
    }

    public List<SysPermission> selectByUuid(String uuid){
        return baseMapper.selectByUuid(uuid);
    }

    @Override
    public List<SysPermission> selectByUuidAndType(String uuid,String type){
        return baseMapper.selectByUuidAndType(uuid,type);
    }

    @Override
    public int countMenuByPid(Integer pid) {
        return baseMapper.countMenuByPid(pid);
    }
}
