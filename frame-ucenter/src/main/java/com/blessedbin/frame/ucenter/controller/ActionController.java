package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.ucenter.component.FrameApi;
import com.blessedbin.frame.ucenter.service.ActionService;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by xubin on 2018/8/3.
 *
 * @author 37075
 * @date 2018/8/3
 * @time 13:38
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "${frame.base-path.ucenter}/sys/action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @PostMapping
    @FrameApi
    @ApiOperation(value = "添加功能点")
    public SimpleResponse add(@RequestBody @Validated AddActionParam param) {

        actionService.addAction(param.getPid(),param.getName(),param.getRemark());

        return SimpleResponse.created();
    }


    @Data
    @Builder
    public static class AddActionParam{
        @NotNull
        private Integer pid;

        @NotBlank
        private String name;

        private String remark;
    }

}
