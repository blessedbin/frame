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
    @Column(name = "argument_key")
    private String argumentKey;

    /**
     * 参数名称，展示用
     */
    @Column(name = "argument_name")
    private String argumentName;

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

    @Column(name = "addition_information")
    private String additionInformation;

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
     * @return argument_key - 参数编码
     */
    public String getArgumentKey() {
        return argumentKey;
    }

    /**
     * 设置参数编码
     *
     * @param argumentKey 参数编码
     */
    public void setArgumentKey(String argumentKey) {
        this.argumentKey = argumentKey == null ? null : argumentKey.trim();
    }

    /**
     * 获取参数名称，展示用
     *
     * @return argument_name - 参数名称，展示用
     */
    public String getArgumentName() {
        return argumentName;
    }

    /**
     * 设置参数名称，展示用
     *
     * @param argumentName 参数名称，展示用
     */
    public void setArgumentName(String argumentName) {
        this.argumentName = argumentName == null ? null : argumentName.trim();
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

    /**
     * @return addition_information
     */
    public String getAdditionInformation() {
        return additionInformation;
    }

    /**
     * @param additionInformation
     */
    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation == null ? null : additionInformation.trim();
    }
}