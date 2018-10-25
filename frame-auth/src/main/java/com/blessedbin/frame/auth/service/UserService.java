package com.blessedbin.frame.auth.service;

import com.blessedbin.frame.common.service.UserApiService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

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
public interface UserService extends UserApiService {
}
