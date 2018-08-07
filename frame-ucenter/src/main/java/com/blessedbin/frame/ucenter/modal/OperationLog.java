package com.blessedbin.frame.ucenter.modal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "operation_log")
public class OperationLog {
    @Id
    private Integer id;

    /**
     * 操作人
     */
    private String uuid;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    private String url;

    /**
     * 所操作的模块名称
     */
    @Column(name = "system_name")
    private String systemName;

    @Column(name = "operation_type")
    private String operationType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作请求的参数
     */
    private String params;

    @Column(name = "old_value")
    private String oldValue;

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
     * 获取操作人
     *
     * @return uuid - 操作人
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置操作人
     *
     * @param uuid 操作人
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取所操作的模块名称
     *
     * @return system_name - 所操作的模块名称
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 设置所操作的模块名称
     *
     * @param systemName 所操作的模块名称
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    /**
     * @return operation_type
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * @param operationType
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType == null ? null : operationType.trim();
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

    /**
     * 获取操作请求的参数
     *
     * @return params - 操作请求的参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置操作请求的参数
     *
     * @param params 操作请求的参数
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    /**
     * @return old_value
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * @param oldValue
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue == null ? null : oldValue.trim();
    }
}