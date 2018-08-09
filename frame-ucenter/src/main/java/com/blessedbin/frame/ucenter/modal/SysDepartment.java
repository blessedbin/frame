package com.blessedbin.frame.ucenter.modal;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_department")
public class SysDepartment {
    @Id
    private Integer id;

    @Column(name = "p_id")
    private Integer pId;

    private String name;

    private String remark;

    /**
     * 排序值
     */
    private Integer sort;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private Boolean delFlag;

    /**
     * 附加信息 JSON格式
     */
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
     * @return p_id
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * @param pId
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取排序值
     *
     * @return sort - 排序值
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序值
     *
     * @param sort 排序值
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public Boolean getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取附加信息 JSON格式
     *
     * @return addition_information - 附加信息 JSON格式
     */
    public String getAdditionInformation() {
        return additionInformation;
    }

    /**
     * 设置附加信息 JSON格式
     *
     * @param additionInformation 附加信息 JSON格式
     */
    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation == null ? null : additionInformation.trim();
    }
}