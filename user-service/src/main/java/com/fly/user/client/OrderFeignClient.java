package com.fly.user.client;

import com.fly.user.configuration.OrderFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/7
 */
@FeignClient(value = "order-service", path = "/order", configuration = OrderFeignClientConfiguration.class)
public interface OrderFeignClient {
    
    @GetMapping("/search")
    String search();
}
