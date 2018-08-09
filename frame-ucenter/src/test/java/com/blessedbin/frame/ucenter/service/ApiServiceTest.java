package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.ucenter.FrameUcenterApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xubin on 2018/8/9.
 *
 * @author 37075
 * @date 2018/8/9
 * @time 16:42
 * @tool intellij idea
 */
public class ApiServiceTest extends FrameUcenterApplicationTests {

    @Autowired
    private ApiService apiService;

    @Test
    @Transactional
    public void scanApi() {
        apiService.scanApi();
    }
}