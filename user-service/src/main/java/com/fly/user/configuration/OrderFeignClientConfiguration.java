package com.fly.user.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/7
 */
public class OrderFeignClientConfiguration {
    
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
