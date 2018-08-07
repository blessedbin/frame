package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.modal.SysOrganization;
import org.springframework.stereotype.Service;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 11:09
 * @tool intellij idea
 */
@Service
public class OrganizationService extends AbstractMysqlCrudServiceImpl<SysOrganization,Integer> {

    /**
     * 获取组织名称
     * @param organizationId
     * @return
     */
    public String selectNameByPk(Integer organizationId) {
        SysOrganization sysOrganization = mapper.selectByPrimaryKey(organizationId);
        return sysOrganization.getName();
    }
}
