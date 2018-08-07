package com.blessedbin.frame.ucenter.service;

import com.blessedbin.frame.ucenter.FrameUcenterApplicationTests;
import com.blessedbin.frame.ucenter.entity.dto.MenuTreeDto;
import com.blessedbin.frame.ucenter.modal.SysUser;
import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xubin on 2018/7/29.
 *
 * @author 37075
 * @date 2018/7/29
 * @time 15:24
 * @tool intellij idea
 */
public class MenuServiceTest extends FrameUcenterApplicationTests {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;



    @Test
    public void getUserMenu() {

        SysUser admin = userService.findByUsername("admin");
        String uuid = admin.getUuid();

        List<MenuTreeDto> menus = menuService.getUserMenu(uuid);
        System.out.println(menus);

    }
}