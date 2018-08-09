package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.ucenter.entity.dto.ActionDto;
import com.blessedbin.frame.ucenter.mapper.SysMenuMapper;
import com.blessedbin.frame.ucenter.modal.SysMenu;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.github.promeg.pinyinhelper.Pinyin;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
public class ActionService{

    @Autowired
    private MenuService menuService;

    @Autowired
    private SysMenuMapper menuMapper;

    @Autowired
    private PermissionService permissionService;

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
        if (checkNameExists(name,pid)) {
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

        SysMenu menu = new SysMenu();
        menu.setTitle(name);
        menu.setType(SysMenu.ACTION);
        menu.setPid(pid);
        menu.setPermissionId(permission.getId());

        menuMapper.insertSelective(menu);

    }


    /**
     * 检查同级下名称是否重复
     * @param name 功能点名称
     * @param pid 所属菜单ID
     * @return
     */
    private boolean checkNameExists(String name,Integer pid){
        int count = menuMapper.selectCountByNameAndPid(name,pid);
        return count > 0;
    }


    /**
     * @param menuId
     * @return
     */
    public List<ActionDto> selectByMenuId(Integer menuId){
        List<SysMenu> actions = menuMapper.selectByPidAndType(menuId, SysMenu.ACTION);
        return actions.stream().map(action ->{
            ActionDto dto = new ActionDto();
            dto.setId(action.getPermissionId());
            dto.setName(action.getTitle());
            dto.setType(SysPermission.TYPE_ACTION);
            return dto;
        }).collect(Collectors.toList());
    }
}
