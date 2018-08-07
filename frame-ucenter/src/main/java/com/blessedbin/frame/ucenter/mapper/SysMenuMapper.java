package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuMapper extends MyMapper<SysMenu> {
    List<SysMenu> selectMenuByUuidAndEnabled(@Param("uuid") String uuid);

    List<SysMenu> selectByPid(@Param("pid") Integer menuId);
}