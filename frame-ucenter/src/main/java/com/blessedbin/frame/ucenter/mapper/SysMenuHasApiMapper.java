package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.modal.SysMenuHasApi;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuHasApiMapper extends MyMapper<SysMenuHasApi> {
    int deleteByMenuIdAndType(@Param("actionId") Integer actionId);

    int insertLists(@Param("collect") List<SysMenuHasApi> collect);

    List<SysMenuHasApi> selectByMenuIds(@Param("menuIds") List<Integer> menuIds);
}