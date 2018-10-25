package com.blessedbin.frame.common.service;

import com.blessedbin.frame.common.entity.FrameUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xubin on 2018/10/25.
 *
 * @author 37075
 * @date 2018/10/25
 * @time 14:55
 * @tool intellij idea
 */
@RequestMapping("/i/user")
public interface UserApiService {

    @GetMapping("/findByUsername")
    FrameUser findByUsername(@RequestParam("username") String username);

}
