package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.service.MysqlCrudService;
import com.blessedbin.frame.ucenter.entity.dto.ApiDto;
import com.blessedbin.frame.ucenter.modal.SysApi;
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
public interface ApiService extends MysqlCrudService<SysApi,Integer> {
    @Transactional(rollbackFor = Exception.class)
    void scanApi();

    Pagination<ApiDto> getDataTables(Integer pageNum, Integer pageSize);

    List<SysApi> selectByUuid(String uuid);
}
