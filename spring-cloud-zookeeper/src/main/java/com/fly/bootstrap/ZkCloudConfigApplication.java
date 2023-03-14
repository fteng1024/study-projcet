package com.fly.bootstrap;

import com.fly.controller.Ctrl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = Ctrl.class)
@RefreshScope
public class ZkCloudConfigApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ZkCloudConfigApplication.class, args);
    }
}
