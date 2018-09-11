package com.blessedbin.frame.ucenter.modal;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_department")
public class SysDepartment {
    @Id
    private Integer id;

    private Integer pid;

    /**
     * 名称
     */
    private String name;

    /**
     * 类别
     */
    private String type;

    /**
     * 显示排序
     */
    private Integer sort;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 创建人
     */
    private String creator;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 附加信息 JSON保存
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
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取类别
     *
     * @return type - 类别
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类别
     *
     * @param type 类别
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取显示排序
     *
     * @return sort - 显示排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示排序
     *
     * @param sort 显示排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
     * 获取附加信息 JSON保存
     *
     * @return addition_information - 附加信息 JSON保存
     */
    public String getAdditionInformation() {
        return additionInformation;
    }

    /**
     * 设置附加信息 JSON保存
     *
     * @param additionInformation 附加信息 JSON保存
     */
    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation == null ? null : additionInformation.trim();
    }
}