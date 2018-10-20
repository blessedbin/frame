package com.blessedbin.frame.config;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xubin on 2018/10/19.
 *
 * @author 37075
 * @date 2018/10/19
 * @time 10:21
 * @tool intellij idea
 */
public class EncodePassword extends FrameConfigApplicationTests {

    @Autowired
    private StringEncryptor encryptor;


    @Test
    public void encode() {

        System.out.println(encryptor.encrypt("cydkogkesdwrbaji"));

    }

}
