package com.blessedbin.frame.ucenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.exception.ResourceNotFoundException;
import com.blessedbin.frame.common.ui.TransferNode;
import com.blessedbin.frame.common.validate.PostMethodValidationGroup;
import com.blessedbin.frame.ucenter.entity.SysRole;
import com.blessedbin.frame.ucenter.entity.SysUser;
import com.blessedbin.frame.ucenter.entity.SysUserRole;
import com.blessedbin.frame.ucenter.entity.param.RolePermissionParam;
import com.blessedbin.frame.ucenter.entity.param.UserRoleParam;
import com.blessedbin.frame.ucenter.service.ISysRoleService;
import com.blessedbin.frame.ucenter.service.ISysUserRoleService;
import com.blessedbin.frame.ucenter.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 17:01
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "/sys/role")
@Api(description = "角色管理")
@Log4j2
public class RoleController {

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysUserRoleService userRoleService;

    @GetMapping("/datatable.json")
    public SimpleResponse<Pagination<SysRole>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                  @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                  @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Page<SysRole> page = new Page<>(pageNum,pageSize);
        IPage<SysRole> roles = roleService.page(page, null);
        Pagination<SysRole> dataTable = new Pagination<SysRole>(roles.getCurrent(),roles.getSize(),roles.getTotal(),roles.getRecords());
        return SimpleResponse.ok(dataTable);
    }

    /**
     * 添加角色
     * 同组织机构下角色名称不能重复
     * 角色关键字不能重复
     * @param role
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加角色", notes = "角色名称不能重复,角色关键字不能重复")
    public SimpleResponse add(@RequestBody @Validated(PostMethodValidationGroup.class) SysRole role,
                              BindingResult result){

        // 参数检查
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName,role.getRoleName());

        if(roleService.exists(wrapper)){
            result.addError(new ObjectError("roleName","角色名称重复"));
        }

        // 检查关键字
        LambdaQueryWrapper<SysRole> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(SysRole::getRoleKey,role.getRoleKey());
        if(roleService.exists(wrapper1)){
            result.addError(new ObjectError("roleKey","角色关键字重复"));
        }

        if(result.hasErrors()){
            throw new ParamCheckRuntimeException(result.getAllErrors().toString());
        }

        role.setCreateTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());

        // 插入数据
        roleService.save(role);

        return SimpleResponse.created("创建成功",role);
    }


    @ApiOperation(value = "获取角色信息")
    @GetMapping("/{id}")
    public SimpleResponse<SysRole> get(@PathVariable Integer id){
        SysRole role = roleService.getById(id);
        if(role == null){
            throw new ResourceNotFoundException("id:" + id);
        }
        return SimpleResponse.ok(role);
    }


    /**
     * 获取用户和角色之间的关系
     * 穿梭框数据列表
     * * 返回的数据：数据需要是一个对象数组，每个对象有以下属性：
     * *              key 为数据的唯一性标识，label 为显示文本，disabled 表示该项数据是否禁止转移。
     *
     * @param uuid 用户UUID
     * @return
     */
    @GetMapping("/transfer-list.json")
    public SimpleResponse getTransferList(@RequestParam(value = "uuid") String uuid) {
        SysUser user = userService.getById(uuid);
        List<SysRole> allRoles = roleService.list(null);
        List<TransferNode> transferNodes = allRoles.stream().map(role -> TransferNode.builder().key(String.valueOf(role.getId()))
                .label(role.getRoleName()).build()).collect(Collectors.toList());


        Map<String, Object> returnData = new HashMap<>(2);
        returnData.put("roleList", transferNodes);

        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getSysUserUuid,uuid);
        List<SysUserRole> selectedRoles = userRoleService.list(wrapper);
        List<String> selectedLists = selectedRoles.stream()
                .map(ur -> String.valueOf(ur.getSysRoleId())).collect(Collectors.toList());
        returnData.put("selectedRole", selectedLists);

        return SimpleResponse.ok(returnData);
    }

    /**
     * 保存用户角色之间的关系
     *
     * @param param
     * @return
     */
    @PutMapping("/user_role.json")
    @ApiOperation(value = "保存用户角色之间的关系")
    public SimpleResponse editUserRole(@Validated @RequestBody UserRoleParam param) {
        log.debug("request param:{}", param);
        roleService.saveUserRole(param.getUuid(), param.getSelectedRole());
        return SimpleResponse.accepted("操作成功");
    }

    /**
     * 保存角色和权限之间的关系
     * @param param
     * @return
     */
    @PutMapping("/role_permission.do")
    public SimpleResponse saveRolePermission(@RequestBody RolePermissionParam param) {
        log.debug("request param:{}", param);
        roleService.saveRolePermission(param.getId(), param.getCheckedList());
        return SimpleResponse.accepted("操作成功");
    }

}
