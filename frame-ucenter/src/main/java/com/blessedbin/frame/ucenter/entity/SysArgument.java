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
 * 系统参数表
 * </p>
 *
 * @author xubin
 * @since 2018-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysArgument对象", description="系统参数表")
public class SysArgument implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "所属系统ID")
    private String sysSystemId;

    @ApiModelProperty(value = "参数类型")
    private String argumentType;

    @ApiModelProperty(value = "参数编码")
    private String argumentKey;

    @ApiModelProperty(value = "参数名称，展示用")
    private String argumentName;

    @ApiModelProperty(value = "参数值")
    private String argumentValue;

    @ApiModelProperty(value = "参数设置提示")
    private String setHint;

    @ApiModelProperty(value = "参数描述")
    private String description;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String additionInformation;


}
