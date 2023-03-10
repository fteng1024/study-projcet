package com.fly.order.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/2/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
