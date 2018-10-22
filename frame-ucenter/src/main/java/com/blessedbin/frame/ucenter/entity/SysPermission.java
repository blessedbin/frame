package com.blessedbin.frame.ucenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysPermission对象", description="")
public class SysPermission implements Serializable {

    public static final String TYPE_MENU="MENU";

    public static final String TYPE_API="API";

    public static final String TYPE_OPERATION = "OPERATION";

    private static final long serialVersionUID = 1L;

    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer permissionId;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限标识")
    private String code;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    private String type;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "附加信息，JSON格式保存")
    private String additionInformation;


}
