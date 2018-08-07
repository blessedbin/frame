package com.blessedbin.frame.ucenter.entity.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by xubin on 2018/7/10.
 *
 * @author 37075
 * @date 2018/7/10
 * @time 22:11
 * @tool intellij idea
 */
@Data
public class DepartmentDto {

    private Integer id;

    private Integer pId;

    private Integer organizationId;

    private String organizationName;

    private String departmentName;

    private String remark;

    /**
     * 排序值
     */
    private Integer sort;

    private Date createTime;

    private Date updateTime;

    private List<DepartmentDto> children;

}
