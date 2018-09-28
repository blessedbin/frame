package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.exception.ServiceRuntimeException;
import com.blessedbin.frame.ucenter.entity.dto.ActionDto;
import com.blessedbin.frame.ucenter.entity.pojo.Menu;
import com.blessedbin.frame.ucenter.entity.pojo.Operation;
import com.blessedbin.frame.ucenter.modal.SysPermission;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.blessedbin.frame.ucenter.modal.SysPermission.TYPE_OPERATION;
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

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * 添加功能点
     *
     * @param menuId    所属的Menu id
     * @param name   功能点名称
     * @param remark 备注
     */
    @Transactional(rollbackFor = Exception.class)
    public void addOperation(Integer menuId, String name, String remark) {
        String operationCode = String.valueOf(System.currentTimeMillis());
        // 参数校验
        if (menuService.hasChildren(menuId)) {
            throw new ParamCheckRuntimeException("该菜单节点不是叶子节点");
        }
        // 检查同级下名称不能重复
        if (checkNameExists(name,menuId)) {
            throw new ParamCheckRuntimeException("同级下名称重复");
        }

        Menu menu = menuService.getMenu(menuId);
        if(menu == null) {
            throw new ParamCheckRuntimeException("not found such menu");
        }

        SysPermission permission = new SysPermission();
        String code = TYPE_OPERATION + ":" + applicationName + ":" + operationCode;
        permission.setCode(code);
        permission.setUpdateTime(new Date());
        permission.setCreateTime(new Date());
        if (!StringUtils.isEmpty(remark)) {
            permission.setRemark(remark);
        }
        permission.setName(name);
        permission.setType(TYPE_OPERATION);
        permission.setSort(1);
        permission.setEnabled(true);

        Operation operation = new Operation();
        operation.setName(name);
        operation.setRemark(remark);
        operation.setSort(1);
        operation.setBelongMenu(menuId);
        try {
            permission.setAdditionInformation(objectMapper.writeValueAsString(operation));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        permissionService.insert(permission);

        menu.addOperation(permission.getPermissionId());
        // 更新并保存菜单信息
        menuService.updateMenu(menu);

    }


    /**
     * 检查同级下名称是否重复
     * @param name 功能点名称
     * @param pid 所属菜单ID
     * @return
     */
    private boolean checkNameExists(String name,Integer pid){
        return false;
    }


    /**
     * TODO
     * @param menuId
     * @return
     */
    public List<ActionDto> selectByMenuId(Integer menuId){
        return EMPTY_LIST;
    }

    public Operation getOperation(Integer id) {
        SysPermission permission = permissionService.selectByPkAndType(id, TYPE_OPERATION);
        if(permission == null) {
            return null;
        }
        return toOperation(permission);
    }

    public List<Operation> getOperations(List<Integer> ids) {
        List<SysPermission> permissions = permissionService.selectByPksAndType(ids, TYPE_OPERATION);
        if(permissions == null || permissions.isEmpty()){
            return EMPTY_LIST;
        }
        return permissions.stream().map(this::toOperation).collect(Collectors.toList());
    }

    /**
     * permission 转换为 operation
     * @param permission
     * @return
     */
    public Operation toOperation(SysPermission permission) {
        Assert.notNull(permission,"permission can not be null");
        if(!TYPE_OPERATION.equals(permission.getType())){
            throw new IllegalArgumentException("type error");
        }
        try {
            Operation operation = objectMapper.readValue(permission.getAdditionInformation(), Operation.class);
            operation.setId(permission.getPermissionId());
            return operation;
        } catch (IOException e) {
            throw new ServiceRuntimeException(e.getMessage());
        }
    }

    public void updateOperation(Operation operation) {
        Assert.notNull(operation.getId());
        try {
            SysPermission permission = permissionService.selectByPk(operation.getId());
            String s = objectMapper.writeValueAsString(operation);
            permission.setAdditionInformation(s);
            permission.setUpdateTime(new Date());
            permissionService.updateByPkSelective(permission);
        } catch (JsonProcessingException e) {
            log.error(e);
        }

    }
}
