package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.ucenter.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> selectByUuid(@Param("uuid")String uuid);

    SysRole selectByKey(@Param("key")String key);
}
