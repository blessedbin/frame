package com.blessedbin.frame.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:bootstrap-dev.properties")
public class FrameMessageServiceApplicationTests {


    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads() {

        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());

    }



}
