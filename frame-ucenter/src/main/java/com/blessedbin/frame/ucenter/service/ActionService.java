package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.service.impl.AbstractMysqlCrudServiceImpl;
import com.blessedbin.frame.ucenter.entity.dto.ActionDto;
import com.blessedbin.frame.ucenter.mapper.SysActionMapper;
import com.blessedbin.frame.ucenter.modal.SysAction;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.github.promeg.pinyinhelper.Pinyin;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by xubin on 2018/8/3.
 *
 * @author 37075
 * @date 2018/8/3
 * @time 13:37
 * @tool intellij idea
 */
@Service
@Log4j2
public class ActionService extends AbstractMysqlCrudServiceImpl<SysAction, Integer> {

    @Autowired
    private MenuService menuService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private SysActionMapper actionMapper;

    /**
     * 添加功能点
     *
     * @param pid    所属的Menu id
     * @param name   功能点名称
     * @param remark 备注
     */
    @Transactional(rollbackFor = Exception.class)
    public void addAction(Integer pid, String name, String remark) {
        // 参数校验
        if (menuService.hasChildren(pid)) {
            throw new ParamCheckRuntimeException("该菜单节点不是叶子节点");
        }
        // 检查同级下名称不能重复
        if (actionMapper.selectCountByNameAndMenuId(name, pid) > 0) {
            throw new ParamCheckRuntimeException("同级下名称重复");
        }

        SysPermission permission = new SysPermission();
        String key = SysPermission.TYPE_ACTION + "-" + Pinyin.toPinyin(name, "-");
        permission.setPermissionKey(key);
        permission.setUpdateTime(new Date());
        permission.setCreateTime(new Date());
        if (!StringUtils.isEmpty(remark)) {
            permission.setRemark(remark);
        }
        permission.setSysSystemId("user_center");
        permission.setPermissionName(name);
        permission.setType(SysPermission.TYPE_ACTION);
        permission.setSort(1);
        permission.setEnabled(true);

        permissionService.insert(permission);

        SysAction action = new SysAction();
        action.setPermissionId(permission.getId());
        action.setMenuId(pid);
        if (StringUtils.isEmpty(remark)) {
            action.setRemark(remark);
        }
        insert(action);

    }


    public List<ActionDto> selectByMenuId(Integer menuId){
        return actionMapper.selectDtoByMenuId(menuId);
    }
}
