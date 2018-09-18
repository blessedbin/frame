package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.ucenter.entity.pojo.SysApi;
import org.springframework.transaction.annotation.Transactional;

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

    Pagination<SysApi> getDataTables(Integer pageNum, Integer pageSize);

    List<SysApi> selectByUuid(String uuid);

    List<SysApi> selectByMenuId(Integer menuId);

    List<SysApi> selectAll();

    SysApi selectByPk(Integer permissionId);

    SysApi getApi(Integer integer);

    List<SysApi> getApis(List<Integer> ids);
}
