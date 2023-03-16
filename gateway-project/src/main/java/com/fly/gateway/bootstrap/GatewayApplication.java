package com.fly.gateway.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.event.EventListener;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    @Resource
    private LoadBalancerClient loadBalancerClient;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void getUri(){
        ServiceInstance userInstance = loadBalancerClient.choose("user-service");

        System.out.println(userInstance.getUri());


    }
}
