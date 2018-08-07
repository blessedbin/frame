package com.blessedbin.frame.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 */
@SpringBootApplication
@EnableConfigServer
public class FrameConfigApplication {


    public static void main(String[] args) {
        SpringApplication.run(FrameConfigApplication.class, args);
    }
}
