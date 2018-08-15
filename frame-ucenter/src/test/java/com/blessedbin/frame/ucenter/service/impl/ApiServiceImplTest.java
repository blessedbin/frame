package com.blessedbin.frame.ucenter.service.impl;

import com.blessedbin.frame.ucenter.FrameUcenterApplicationTests;
import com.blessedbin.frame.ucenter.modal.SysApi;
import com.blessedbin.frame.ucenter.service.ApiService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @Test
    public void selectByUuid() {
        List<SysApi> apis = apiService.selectByUuid("bdbb24514f464eb29eaff7e75ab8ab8c");
        System.out.println(apis);
    }
}