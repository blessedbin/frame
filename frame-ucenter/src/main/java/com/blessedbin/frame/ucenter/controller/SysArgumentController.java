package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.common.validate.PostMethodValidationGroup;
import com.blessedbin.frame.ucenter.modal.SysArgument;
import com.blessedbin.frame.ucenter.service.SysArgumentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 11:23
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "/sys/argument")
@Log4j2
public class SysArgumentController{

    @Autowired
    private SysArgumentService argumentService;


    /**
     * TODO 参数验证
     * @param argument
     */
    @PostMapping
    public SimpleResponse<SysArgument> add(@RequestBody @Validated(PostMethodValidationGroup.class) SysArgument argument){
        argumentService.insert(argument);
        SysArgument select = argumentService.selectByPk(argument.getId());
        return SimpleResponse.created("创建成功",select);
    }

}
