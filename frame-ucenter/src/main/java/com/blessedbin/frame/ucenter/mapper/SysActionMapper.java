package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.common.mapper.MyMapper;
import com.blessedbin.frame.ucenter.entity.dto.ActionDto;
import com.blessedbin.frame.ucenter.modal.SysAction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysActionMapper extends MyMapper<SysAction> {
    int selectCountByNameAndMenuId(@Param("name") String name,@Param("menuId") Integer menuId);

    List<SysAction> selectByMenuId(@Param("menuId") Integer menuId);

    List<ActionDto> selectDtoByMenuId(@Param("menuId") Integer menuId);
}