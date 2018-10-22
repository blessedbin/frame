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

    SysPermission selectByIdentification(@Param("code") String code);

    List<SysPermission> selectByRoleId(@Param("roleId") Integer roleId);

    List<SysPermission> selectByType(@Param("type") String type);

    SysPermission selectByPrimaryKeyAndType(@Param("id") Integer id, @Param("type") String type);

    List<SysPermission> selectByPrimaryKeysAndType(@Param("ids") List<Integer> ids, @Param("type") String type);

    List<Integer> selectIdsByInIds(@Param("ids")List<Integer> permissionIds);

    List<SysPermission> selectByUuid(@Param("uuid") String uuid);

    List<SysPermission> selectByUuidAndType(@Param("uuid") String uuid,@Param("type") String type);

}
