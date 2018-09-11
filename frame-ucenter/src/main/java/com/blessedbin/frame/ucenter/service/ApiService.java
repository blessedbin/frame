package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.ucenter.entity.dto.ApiDto;
import com.blessedbin.frame.ucenter.entity.pojo.SysApi;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import org.springframework.transaction.annotation.Transactional;

import java.util.BitSet;
import java.util.List;

/**
 * Created by xubin on 2018/8/9.
 *
 * @author 37075
 * @date 2018/8/9
 * @time 16:46
 * @tool intellij idea
 */
public interface ApiService {
    @Transactional(rollbackFor = Exception.class)
    void scanApi();

    Pagination<ApiDto> getDataTables(Integer pageNum, Integer pageSize);

    List<SysApi> selectByUuid(String uuid);

    List<SysApi> selectByMenuId(Integer menuId);

    List<SysApi> selectAll();

    SysApi selectByPk(Integer permissionId);
}
