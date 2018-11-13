package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.ucenter.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> selectByRoleId(@Param("roleId") Integer roleId);

    List<SysPermission> selectByUuid(@Param("uuid") String uuid);

    List<SysPermission> selectByUuidAndType(@Param("uuid") String uuid,@Param("type") String type);

    int countMenuByPid(@Param("pid")Integer pid);
}
