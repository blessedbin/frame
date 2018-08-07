package com.blessedbin.frame.ucenter.modal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "login_log")
public class LoginLog {
    @Id
    private Integer id;

    /**
     * 登录人id
     */
    private String uuid;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "login_id")
    private Date loginId;

    /**
     * 备注
     */
    private String remark;

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
     * 获取登录人id
     *
     * @return uuid - 登录人id
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置登录人id
     *
     * @param uuid 登录人id
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * @return login_time
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * @return login_id
     */
    public Date getLoginId() {
        return loginId;
    }

    /**
     * @param loginId
     */
    public void setLoginId(Date loginId) {
        this.loginId = loginId;
    }

    /**
     * 获取备注
     *
     * @return description - 备注
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
}