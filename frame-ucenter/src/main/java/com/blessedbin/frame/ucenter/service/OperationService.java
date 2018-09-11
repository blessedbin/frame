package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.ucenter.entity.dto.ActionDto;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;

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
public class OperationService {

    @Autowired
    private MenuService menuService;

    @Autowired
    private PermissionService permissionService;

    @Value("spring.application.name")
    private String applicationName;

    /**
     * 添加功能点
     *
     * @param pid    所属的Menu id
     * @param name   功能点名称
     * @param remark 备注
     */
    @Transactional(rollbackFor = Exception.class)
    public void addOperation(Integer pid, String name,String operationCode, String remark) {
        // 参数校验
        if (menuService.hasChildren(pid)) {
            throw new ParamCheckRuntimeException("该菜单节点不是叶子节点");
        }
        // 检查同级下名称不能重复
        if (checkNameExists(name,pid)) {
            throw new ParamCheckRuntimeException("同级下名称重复");
        }

        SysPermission permission = new SysPermission();
        String code = SysPermission.TYPE_OPERATION + ":" + applicationName + ":" + operationCode;
        permission.setCode(code);
        permission.setUpdateTime(new Date());
        permission.setCreateTime(new Date());
        if (!StringUtils.isEmpty(remark)) {
            permission.setRemark(remark);
        }
        permission.setName(name);
        permission.setType(SysPermission.TYPE_OPERATION);
        permission.setSort(1);
        permission.setEnabled(true);

        permissionService.insert(permission);
        // TODO

    }


    /**
     * 检查同级下名称是否重复
     * @param name 功能点名称
     * @param pid 所属菜单ID
     * @return
     */
    private boolean checkNameExists(String name,Integer pid){
        // int count = menuMapper.selectCountByNameAndPid(name,pid);
        return false;
    }


    /**
     * @param menuId
     * @return
     */
    public List<ActionDto> selectByMenuId(Integer menuId){
        /*List<SysMenu> actions = menuMapper.selectByPidAndType(menuId, SysMenu.ACTION);
        return actions.stream().map(action ->{
            ActionDto dto = new ActionDto();
            dto.setId(action.getPermissionId());
            dto.setName(action.getTitle());
            dto.setType(SysPermission.TYPE_OPERATION);
            return dto;
        }).collect(Collectors.toList());*/
        return EMPTY_LIST;
    }
}
