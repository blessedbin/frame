package com.blessedbin.frame.ucenter.modal;

import javax.persistence.*;

@Table(name = "sys_action_api")
public class SysActionApi {
    @Id
    @Column(name = "action_id")
    private Integer actionId;

    @Id
    @Column(name = "api_id")
    private Integer apiId;

    /**
     * @return action_id
     */
    public Integer getActionId() {
        return actionId;
    }

    /**
     * @param actionId
     */
    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    /**
     * @return api_id
     */
    public Integer getApiId() {
        return apiId;
    }

    /**
     * @param apiId
     */
    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }
}