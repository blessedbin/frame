package com.blessedbin.frame.ucenter.entity.dto;


import com.blessedbin.frame.common.validate.PutMethodValidationGroup;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * Created by xubin on 2018/5/29.
 *
 * @author 37075
 * @date 2018/5/29
 * @time 21:59
 * @tool intellij idea
 */
@Data
public class UserDto {

    /**
     * 用户唯一标识
     */
    @NotEmpty(groups = PutMethodValidationGroup.class)
    private String uuid;

    /**
     * 用户名
     */
    @NotEmpty
    @NotBlank
    private String username;


    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮件
     */
    @Email
    private String email;

    /**
     * 手机号是否已经验证 1.已验证 0.未验证，默认为0
     */
    private Boolean phoneVerify;

    /**
     * 邮箱是否验证 1已验证 0未验证
     */
    private Boolean emailVerify;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 注册时间
     */
    private Date registerTime;

    private Integer status;

    private Boolean enabled;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    /**
     * 密码盐
     */
    private String salt;

    private Date createTime;

    private Date updateTime;

    /**
     * 删除标记 0 正常 1 删除
     */
    private Boolean delFlag;

    /**
     * 头像
     */
    private String avatar;

    private Integer organizationId;

    private Integer departmentId;

    private List<Integer> departmentIds;

}
