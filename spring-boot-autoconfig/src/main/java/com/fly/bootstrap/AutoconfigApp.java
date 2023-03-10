package com.fly.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/2/20
 */
@SpringBootApplication
@ComponentScan("com.fly")
public class AutoconfigApp {

    public static void main(String[] args) {
        SpringApplication.run(AutoconfigApp.class, args);
    }

//    @Bean
//    public Object test(FlyMyBatisTemplate myBatisTemplate){
//        myBatisTemplate.insert();
//        return null;
//    }
}
