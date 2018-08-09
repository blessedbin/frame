package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.BitSet;
import java.util.List;

@Repository
public interface SysMenuMapper extends MyMapper<SysMenu> {
    List<SysMenu> selectMenusByUuidAndEnabled(@Param("uuid") String uuid);

    List<SysMenu> selectMenusByPid(@Param("pid") Integer pid);

    List<SysMenu> selectAllMenus();

    /**
     *
     * @param name
     * @param pid
     * @return
     */
    int selectCountByNameAndPid(@Param("name") String name, @Param("pid") Integer pid);

    List<SysMenu> selectByPidAndType(@Param("menuId") Integer menuId, @Param("type") int type);
}