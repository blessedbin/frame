package com.blessedbin.frame.auth.service;

import com.blessedbin.frame.common.contant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by xubin on 2018/8/21.
 *
 * @author 37075
 * @date 2018/8/21
 * @time 15:53
 * @tool intellij idea
 */
@Service
public class ValidateCodeService {

    @Autowired
    private RedisTemplate redisTemplate;

    public String createKaptcha(String text) {
        Assert.notNull(text,"验证码不能为空");
        String token = SecurityConstants.TOKEN_IMAGE_CODE_PREFIX + "-" +UUID.randomUUID().toString();
        // 保存到Redis服务器
        redisTemplate.opsForValue().set(token,text,SecurityConstants.DEFAULT_IMAGE_CODE_TIMEOUT,TimeUnit.SECONDS);
        return token;
    }
}
