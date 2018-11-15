package com.blessedbin.frame.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class FrameMessageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameMessageServiceApplication.class, args);
    }
}
