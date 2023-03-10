package com.fly.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/7
 */
@FeignClient(value = "fly", url = "http://localhost:8848/nacos/index.html")
public interface FlyFeignClient {
    
    @GetMapping()
    String nacos();
}
