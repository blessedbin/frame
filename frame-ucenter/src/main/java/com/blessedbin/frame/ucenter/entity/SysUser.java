package com.blessedbin.frame.ucenter.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户唯一标识")
    private String uuid;

    @ApiModelProperty(value = "用户名")
    private String username;

    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "手机号是否已经验证 1.已验证 0.未验证，默认为0")
    private Boolean phoneVerify;

    @ApiModelProperty(value = "邮箱是否验证 1已验证 0未验证")
    private Boolean emailVerify;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registerTime;

    private Integer status;

    private Boolean enabled;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    @ApiModelProperty(value = "密码盐")
    private String salt;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除标记 0 正常 1 删除")
    private Boolean delFlag;

    @ApiModelProperty(value = "头像")
    private String avatar;

    private Integer departmentId;


}
