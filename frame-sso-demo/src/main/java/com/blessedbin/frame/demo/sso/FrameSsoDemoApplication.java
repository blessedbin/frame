package com.blessedbin.frame.demo.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
public class FrameSsoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameSsoDemoApplication.class, args);
    }
}
