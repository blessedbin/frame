package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.data.service.BaseService;
import com.blessedbin.frame.ucenter.entity.SysRole;
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
public interface ISysRoleService extends IService<SysRole>, BaseService<SysRole> {

    void saveUserRole(String uuid, List<Integer> selectedRole);

    /**
     * 保存角色和权限之间的关系
     * @param id
     * @param checkedList
     */
    void saveRolePermission(Integer id, List<String> checkedList);

    List<SysRole> selectAllByUuid(String uuid);

    /**
     *
     * @param key 角色关键字
     * @return
     */
    public SysRole selectByKey(String key);
}
