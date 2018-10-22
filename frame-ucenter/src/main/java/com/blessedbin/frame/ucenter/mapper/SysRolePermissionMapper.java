package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.ucenter.entity.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.BitSet;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

    int deleteByRoleId(@Param("roleId") Integer roleId);

    int insertLists(@Param("list")List<SysRolePermission> list);

    List<SysRolePermission> selectByRoleId(@Param("roleId")Integer roleId);
}
