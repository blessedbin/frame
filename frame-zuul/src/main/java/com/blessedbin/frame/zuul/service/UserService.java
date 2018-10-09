package com.blessedbin.frame.zuul.service;

import com.blessedbin.frame.common.entity.FramePermission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by xubin on 2018/8/1.
 *
 * @author 37075
 * @date 2018/8/1
 * @time 17:16
 * @tool intellij idea
 */
@FeignClient("frame-ucenter")
@Service
public interface UserService {

    @GetMapping("/sys/api/findUserApi/{uuid}")
    List<FramePermission> findUserApiByUuid(@PathVariable("uuid") String uuid);

}
