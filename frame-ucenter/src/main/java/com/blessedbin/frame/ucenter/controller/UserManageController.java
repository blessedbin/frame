package com.blessedbin.frame.ucenter.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blessedbin.frame.common.Pagination;
import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.exception.ParamCheckRuntimeException;
import com.blessedbin.frame.common.exception.ResourceNotFoundException;
import com.blessedbin.frame.common.utils.UUIDUtils;
import com.blessedbin.frame.common.validate.PostMethodValidationGroup;
import com.blessedbin.frame.ucenter.entity.SysUser;
import com.blessedbin.frame.ucenter.entity.dto.UserDto;
import com.blessedbin.frame.ucenter.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

import static com.blessedbin.frame.common.contant.SecurityConstants.DEFAULT_PASSWORD;

import static com.blessedbin.frame.common.contant.SecurityConstants.DEFAULT_PASSWORD;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 13:36
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "/sys/user")
@Log4j2
@Api(description = "用户管理",tags = "用户管理")
public class UserManageController {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/datatable.json")
    @ApiOperation(value = "查看用户")
    public SimpleResponse<Pagination<SysUser>> getTable(@RequestParam(name = "page_num", required = false, defaultValue = "1") Integer pageNum,
                                                        @RequestParam(name = "page_size", required = false, defaultValue = "20") Integer pageSize,
                                                        @RequestParam(name = "search_value", required = false, defaultValue = "") String searchValue) {
        Page<SysUser> page = new Page<>(pageNum,pageSize);
        IPage<SysUser> iPage = userService.page(page, null);
        Pagination<SysUser> dataTable = new Pagination<>(iPage.getCurrent(),iPage.getSize(),iPage.getTotal(),iPage.getRecords());
        return SimpleResponse.ok(dataTable);
    }

    @GetMapping
    @ApiOperation(value = "获取用户信息")
    public SimpleResponse<SysUser> getOne(@RequestParam String uuid){
        return SimpleResponse.ok(userService.getById(uuid));
    }

    @DeleteMapping
    @ApiOperation(value = "删除用户")
    public SimpleResponse delete(@RequestParam String uuid){
        userService.removeById(uuid);
        return SimpleResponse.deleted();
    }

    /**
     * 管理员添加用户
     * @param param
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加用户")
    public SimpleResponse addOne(@RequestBody @Validated(PostMethodValidationGroup.class)
                                         UserDto param){
        if(userService.checkEmailExists(param.getEmail()) ||
                userService.checkUsernameExists(param.getUsername()) ||
                userService.checkPhoneExists(param.getPhone())){
            throw new ParamCheckRuntimeException("用户名或邮箱或电话重复");
        }



        SysUser user = new SysUser();
        user.setUuid(UUIDUtils.generateUUID());
        user.setUsername(param.getUsername());
        user.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());


        // 添加Email
        if(!StringUtils.isEmpty(param.getEmail())){
            user.setEmail(param.getEmail());
        }
        // 添加Phone
        if(!StringUtils.isEmpty(param.getPhone())){
            user.setPhone(param.getPhone());
        }
        userService.save(user);
        return SimpleResponse.ok();
    }


    /**
     * 重置用户密码
     * TODO 完成登录页用户可以自己修改密码后，重置密码操作将会使用户密码过期，强制用户更改密码
     */
    @GetMapping("/reset_password.do")
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "重置用户密码为默认密码")
    public SimpleResponse resetPassword(@RequestParam String uuid) {

        SysUser user = userService.getById(uuid);
        if(user == null) {
            throw new ResourceNotFoundException("未发现用户信息");
        }

        SysUser nUser = new SysUser();
        nUser.setUuid(user.getUuid());
        nUser.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        nUser.setUpdateTime(LocalDateTime.now());

        userService.updateById(nUser);

        return SimpleResponse.accepted();
    }
}


