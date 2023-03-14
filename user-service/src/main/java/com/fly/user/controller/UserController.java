package com.fly.user.controller;

import com.fly.user.client.OrderFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/2/23
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private RestTemplate restTemplate;


    @PostMapping("/search")
    public void search() {
        //        System.out.println(userName);
        //        System.out.println(userAge);
        System.out.println("userController search ...");
    }

    @PostMapping("/callOrder")
    public void callOrder() {
        String result = restTemplate.getForObject("http://order-service/order/search", String.class);
        System.out.println(result);
    }

    @Resource
    private OrderFeignClient orderFeignClient;

    @GetMapping("/openfeign")
    public String openfeign() {
        return orderFeignClient.search();
    }

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/instances")
    public List<ServiceInstance> instances() {
        return this.discoveryClient.getInstances("order-service");
    }
}
