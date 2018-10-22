package com.blessedbin.frame.ucenter.entity;

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
@ApiModel(value="SysRolePermission对象", description="")
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sysRoleId;

    private Integer sysPermissionId;


}
