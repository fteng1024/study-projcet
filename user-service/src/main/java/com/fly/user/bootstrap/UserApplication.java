package com.fly.user.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/2/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
