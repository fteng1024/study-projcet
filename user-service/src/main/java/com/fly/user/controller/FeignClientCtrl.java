package com.fly.user.controller;

import com.fly.user.client.FlyFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/7
 */
@RestController
@RequestMapping("/feign")
public class FeignClientCtrl {
    
    @Resource
    private FlyFeignClient flyFeignClient;
    
    @GetMapping("/nacos")
    public String nacos() {
        return flyFeignClient.nacos();
    }
}
