package com.blessedbin.frame.auth.controller;

import com.blessedbin.frame.common.SimpleResponse;
import com.blessedbin.frame.auth.service.ValidateCodeService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xubin on 2018/8/21.
 *
 * @author 37075
 * @date 2018/8/21
 * @time 15:47
 * @tool intellij idea
 */
@RestController
@RequestMapping("/code")
public class ValidateCodeController {

    @Autowired
    private DefaultKaptcha producer;

    @Autowired
    private ValidateCodeService codeService;


    @RequestMapping("/captacha")
    public SimpleResponse<Map<String, String>> captcha() throws IOException {

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        // 图片的Base64编码
        String encoder = Base64Utils.encodeToString(outputStream.toByteArray());

        // 生成captcha的token
        String token = codeService.createKaptcha(text);

        Map<String,String> data = new HashMap<>();
        data.put("img","data:image/jpeg;base64," + encoder);
        data.put("imgToken",token);

        return SimpleResponse.ok(data);
    }

}
