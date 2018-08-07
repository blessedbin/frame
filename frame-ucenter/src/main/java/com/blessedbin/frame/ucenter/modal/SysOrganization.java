package com.blessedbin.frame.ucenter.modal;

import com.blessedbin.frame.common.validate.PutMethodValidationGroup;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Table(name = "sys_organization")
public class SysOrganization {
    @Id
    @NotNull(groups = PutMethodValidationGroup.class)
    private Integer id;

    /**
     * 组织名称
     */
    @NotEmpty
    private String name;

    private String remark;

    private String address;


    private String phone;

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
     * 获取组织名称
     *
     * @return name - 组织名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组织名称
     *
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return description
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
    public String toString() {
        return "SysOrganization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + remark + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysOrganization that = (SysOrganization) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, remark, address, phone);
    }
}