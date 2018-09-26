package com.blessedbin.frame.auth.service;

import com.blessedbin.frame.common.entity.FrameUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xubin on 2018/9/26.
 *
 * @author 37075
 * @date 2018/9/26
 * @time 12:01
 * @tool intellij idea
 */
@FeignClient("frame-ucenter")
@Service
public interface UserService {

    @RequestMapping(value = "/service/findByUsername",method = RequestMethod.GET)
    FrameUser findByUsername(@RequestParam(value = "username") String username);
}
