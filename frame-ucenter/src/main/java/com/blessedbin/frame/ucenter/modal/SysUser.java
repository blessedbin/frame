package com.blessedbin.frame.ucenter.modal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user")
public class SysUser {

    /**
     * 从未登录状态
     */
    public static int STATUS_INIT = 1;

    /**
     * 正常
     */
    public static int STATUS_NORMAL = 2;

    /**
     * 用户唯一标识
     */
    @Id
    private String uuid;

    /**
     * 用户名
     */
    private String username;

    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮件
     */
    private String email;

    /**
     * 手机号是否已经验证 1.已验证 0.未验证，默认为0
     */
    @Column(name = "phone_verify")
    private Boolean phoneVerify;

    /**
     * 邮箱是否验证 1已验证 0未验证
     */
    @Column(name = "email_verify")
    private Boolean emailVerify;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    private Integer status;

    private Boolean enabled;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    /**
     * 密码盐
     */
    private String salt;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标记 0 正常 1 删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    /**
     * 头像
     */
    private String avatar;

    @Column(name = "organization_id")
    private Integer organizationId;

    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 获取用户唯一标识
     *
     * @return uuid - 用户唯一标识
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置用户唯一标识
     *
     * @param uuid 用户唯一标识
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取邮件
     *
     * @return email - 邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件
     *
     * @param email 邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取手机号是否已经验证 1.已验证 0.未验证，默认为0
     *
     * @return phone_verify - 手机号是否已经验证 1.已验证 0.未验证，默认为0
     */
    public Boolean getPhoneVerify() {
        return phoneVerify;
    }

    /**
     * 设置手机号是否已经验证 1.已验证 0.未验证，默认为0
     *
     * @param phoneVerify 手机号是否已经验证 1.已验证 0.未验证，默认为0
     */
    public void setPhoneVerify(Boolean phoneVerify) {
        this.phoneVerify = phoneVerify;
    }

    /**
     * 获取邮箱是否验证 1已验证 0未验证
     *
     * @return email_verify - 邮箱是否验证 1已验证 0未验证
     */
    public Boolean getEmailVerify() {
        return emailVerify;
    }

    /**
     * 设置邮箱是否验证 1已验证 0未验证
     *
     * @param emailVerify 邮箱是否验证 1已验证 0未验证
     */
    public void setEmailVerify(Boolean emailVerify) {
        this.emailVerify = emailVerify;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取注册时间
     *
     * @return register_time - 注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     *
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return account_non_expired
     */
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * @param accountNonExpired
     */
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * @return account_non_locked
     */
    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * @param accountNonLocked
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    /**
     * @return credentials_non_expired
     */
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * @param credentialsNonExpired
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * 获取密码盐
     *
     * @return salt - 密码盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置密码盐
     *
     * @param salt 密码盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取删除标记 0 正常 1 删除
     *
     * @return del_flag - 删除标记 0 正常 1 删除
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记 0 正常 1 删除
     *
     * @param delFlag 删除标记 0 正常 1 删除
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * @return organization_id
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return department_id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}