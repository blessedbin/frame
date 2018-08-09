package com.blessedbin.frame.ucenter.service.impl;

import com.blessedbin.frame.ucenter.FrameUcenterApplicationTests;
import com.blessedbin.frame.ucenter.service.ApiService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by xubin on 2018/8/9.
 *
 * @author 37075
 * @date 2018/8/9
 * @time 20:53
 * @tool intellij idea
 */
public class ApiServiceImplTest extends FrameUcenterApplicationTests {

    @Autowired
    private ApiService apiService;

    @Test
    @Transactional
    public void scanApi() {

        apiService.scanApi();

        apiService.scanApi();

    }
}