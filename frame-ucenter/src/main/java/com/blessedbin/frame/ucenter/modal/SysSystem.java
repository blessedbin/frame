package com.blessedbin.frame.ucenter.modal;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_system")
public class SysSystem {
    /**
     * 系统唯一标识
     */
    @Id
    @Column(name = "sys_id")
    private String sysId;

    /**
     * 系统名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 系统描述
     */
    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 该系统api的网址
     */
    @Column(name = "base_url")
    private String baseUrl;

    /**
     * 获取系统唯一标识
     *
     * @return sys_id - 系统唯一标识
     */
    public String getSysId() {
        return sysId;
    }

    /**
     * 设置系统唯一标识
     *
     * @param sysId 系统唯一标识
     */
    public void setSysId(String sysId) {
        this.sysId = sysId == null ? null : sysId.trim();
    }

    /**
     * 获取系统名称
     *
     * @return name - 系统名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置系统名称
     *
     * @param name 系统名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取系统描述
     *
     * @return description - 系统描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置系统描述
     *
     * @param description 系统描述
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
     * 获取该系统api的网址
     *
     * @return base_url - 该系统api的网址
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * 设置该系统api的网址
     *
     * @param baseUrl 该系统api的网址
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl == null ? null : baseUrl.trim();
    }
}