package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.exception.ResourceNotFoundException;
import com.blessedbin.frame.common.ui.TransferNode;
import com.blessedbin.frame.common.validate.PostMethodValidationGroup;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.entity.param.RolePermissionParam;
import com.blessedbin.frame.ucenter.entity.param.UserRoleParam;
import com.blessedbin.frame.ucenter.modal.SysRole;
import com.blessedbin.frame.ucenter.modal.SysRoleExample;
import com.blessedbin.frame.ucenter.modal.SysUser;
import com.blessedbin.frame.ucenter.modal.SysUserHasRole;
import com.blessedbin.frame.ucenter.service.OrganizationService;
import com.blessedbin.frame.ucenter.service.RoleService;
import com.blessedbin.frame.ucenter.service.UserManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
@RequestMapping(value = "${frame.base-path.ucenter}/role")
@Api(description = "角色管理")
@Log4j2
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private UserManageService userManageService;

    @GetMapping("/datatable.json")
    @FrameApi
    public SimpleResponse<Pagination<SysRole>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                  @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                  @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Pagination<SysRole> dataTable = roleService.getDataTable(pageNum, pageSize);
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
    @FrameApi
    @ApiOperation(value = "添加角色", notes = "同组织机构下角色名称不能重复,角色关键字不能重复")
    public SimpleResponse add(@RequestBody @Validated(PostMethodValidationGroup.class) SysRole role,
                              BindingResult result){

        // 参数检查
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo(role.getRoleName());

        //检查角色名称
        if(role.getOrganizationId() != null && role.getOrganizationId() != -1){
            if(!organizationService.checkExistsByPk(role.getOrganizationId())){
                throw new ParamCheckRuntimeException();
            }
            criteria.andOrganizationIdEqualTo(role.getOrganizationId());
        }else{
            role.setOrganizationId(null);
        }
        if(roleService.checkExistsByExample(example)){
            result.addError(new ObjectError("roleName","角色名称重复"));
        }

        // 检查关键字
        SysRoleExample example1 = new SysRoleExample();
        example1.createCriteria().andRoleKeyEqualTo(role.getRoleKey());
        if(roleService.checkExistsByExample(example1)){
            result.addError(new ObjectError("roleKey","角色关键字重复"));
        }

        if(result.hasErrors()){
            throw new ParamCheckRuntimeException(result.getAllErrors().toString());
        }

        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());

        // 插入数据
        roleService.insertSelective(role);

        return SimpleResponse.created("创建成功",role);
    }


    @ApiOperation(value = "获取角色信息")
    @GetMapping("/{id}")
    @FrameApi
    public SimpleResponse<SysRole> get(@PathVariable Integer id){
        SysRole role = roleService.selectByPk(id);
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
    @FrameApi
    public SimpleResponse getTransferList(@RequestParam(value = "uuid") String uuid) {
        SysUser user = userManageService.selectByPk(uuid);
        List<SysRole> allRoles;
        if(user != null && user.getOrganizationId() != null){
            SysRoleExample roleExample = new SysRoleExample();
            roleExample.createCriteria().andOrganizationIdEqualTo(user.getOrganizationId());
            allRoles = roleService.selectAllByExample(roleExample);
        }else {
            allRoles = roleService.selectAll();
        }
        List<TransferNode> transferNodes = allRoles.stream().map(role -> TransferNode.builder().key(String.valueOf(role.getId()))
                .label(role.getRoleName()).build()).collect(Collectors.toList());


        Map<String, Object> returnData = new HashMap<>(2);
        returnData.put("roleList", transferNodes);

        List<SysUserHasRole> selectedRoles = roleService.findAllUserHasRoleByUuid(uuid);
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
    @FrameApi
    @ApiOperation("保存永辉角色之间的关系")
    public SimpleResponse editUserRole(@Validated @RequestBody UserRoleParam param) {
        log.debug("request param:{}", param);
        roleService.editUserRole(param.getUuid(), param.getSelectedRole());
        return SimpleResponse.accepted("操作成功");
    }

    @PutMapping("/role_permission.json")
    @FrameApi
    public SimpleResponse saveRolePermission(@RequestBody RolePermissionParam param) {
        log.debug("request param:{}", param);
        roleService.saveRolePermission(param.getId(), param.getCheckedList());
        return SimpleResponse.accepted("操作成功");
    }

}
