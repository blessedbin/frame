package com.blessedbin.frame.ucenter.controller;

import com.blessedbin.frame.ucenter.modal.SysSystem;
import com.blessedbin.frame.ucenter.service.SysSystemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xubin on 2018/7/9.
 *
 * @author 37075
 * @date 2018/7/9
 * @time 11:55
 * @tool intellij idea
 */
@RestController
@RequestMapping(value = "/sys/system")
@Log4j2
public class SysSystemController {

    @Autowired
    private SysSystemService sysSystemService;

}
