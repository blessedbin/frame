package com.blessedbin.frame.ucenter.modal;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_argument")
public class SysArgument {
    @Id
    private Integer id;

    /**
     * 所属系统ID
     */
    @Column(name = "sys_system_id")
    private String sysSystemId;

    /**
     * 参数类型
     */
    @Column(name = "argument_type")
    private String argumentType;

    /**
     * 参数编码
     */
    @Column(name = "argument_code")
    private String argumentCode;

    /**
     * 参数名称，展示用
     */
    private String name;

    /**
     * 参数值
     */
    @Column(name = "argument_value")
    private String argumentValue;

    /**
     * 参数设置提示
     */
    @Column(name = "set_hint")
    private String setHint;

    /**
     * 参数描述
     */
    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取所属系统ID
     *
     * @return sys_system_id - 所属系统ID
     */
    public String getSysSystemId() {
        return sysSystemId;
    }

    /**
     * 设置所属系统ID
     *
     * @param sysSystemId 所属系统ID
     */
    public void setSysSystemId(String sysSystemId) {
        this.sysSystemId = sysSystemId == null ? null : sysSystemId.trim();
    }

    /**
     * 获取参数类型
     *
     * @return argument_type - 参数类型
     */
    public String getArgumentType() {
        return argumentType;
    }

    /**
     * 设置参数类型
     *
     * @param argumentType 参数类型
     */
    public void setArgumentType(String argumentType) {
        this.argumentType = argumentType == null ? null : argumentType.trim();
    }

    /**
     * 获取参数编码
     *
     * @return argument_code - 参数编码
     */
    public String getArgumentCode() {
        return argumentCode;
    }

    /**
     * 设置参数编码
     *
     * @param argumentCode 参数编码
     */
    public void setArgumentCode(String argumentCode) {
        this.argumentCode = argumentCode == null ? null : argumentCode.trim();
    }

    /**
     * 获取参数名称，展示用
     *
     * @return name - 参数名称，展示用
     */
    public String getName() {
        return name;
    }

    /**
     * 设置参数名称，展示用
     *
     * @param name 参数名称，展示用
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取参数值
     *
     * @return argument_value - 参数值
     */
    public String getArgumentValue() {
        return argumentValue;
    }

    /**
     * 设置参数值
     *
     * @param argumentValue 参数值
     */
    public void setArgumentValue(String argumentValue) {
        this.argumentValue = argumentValue == null ? null : argumentValue.trim();
    }

    /**
     * 获取参数设置提示
     *
     * @return set_hint - 参数设置提示
     */
    public String getSetHint() {
        return setHint;
    }

    /**
     * 设置参数设置提示
     *
     * @param setHint 参数设置提示
     */
    public void setSetHint(String setHint) {
        this.setHint = setHint == null ? null : setHint.trim();
    }

    /**
     * 获取参数描述
     *
     * @return description - 参数描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置参数描述
     *
     * @param description 参数描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
}