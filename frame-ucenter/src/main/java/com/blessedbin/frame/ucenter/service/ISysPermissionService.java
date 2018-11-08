package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.ucenter.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
public interface ISysPermissionService extends IService<SysPermission> {

    SysPermission selectByIdentification(String code);

    List<SysPermission> selectByUuidAndType(String uuid, String typeApi);

    List<SysPermission> selectByType(String typeApi);

    SysPermission selectByPkAndType(Integer integer, String typeApi);

    List<SysPermission> selectByPksAndType(List<Integer> ids, String typeApi);

    List<SysPermission> selectByRoleIdAndType(Integer roleId);

    /**
     * 统计菜单子节点数量
     * @param pid
     * @return
     */
    int countMenuByPid(Integer pid);
}
