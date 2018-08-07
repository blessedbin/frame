package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.ucenter.FrameUcenterApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by xubin on 2018/8/3.
 *
 * @author 37075
 * @date 2018/8/3
 * @time 14:26
 * @tool intellij idea
 */
public class ActionServiceTest extends FrameUcenterApplicationTests {

    @Autowired
    private ActionService actionService;

    @Test
    @Transactional
    public void addAction() {

        // 22
        actionService.addAction(22,"测试名称","");

    }
}