package com.blessedbin.frame.ucenter.mapper;

import com.blessedbin.frame.ucenter.FrameUcenterApplicationTests;
import com.blessedbin.frame.ucenter.modal.SysApi;
import com.blessedbin.frame.ucenter.modal.SysUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 16:38
 * @tool intellij idea
 */
public class SysApiMapperTest extends FrameUcenterApplicationTests {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysApiMapper apiMapper;

    @Test
    @Transactional
    public void selectByUuid() {

        SysUser admin = userMapper.findByUsername("admin");

        List<SysApi> sysApis = apiMapper.selectByUuid(admin.getUuid());

        sysApis.forEach(sysApi -> System.out.println(sysApi));

    }
}