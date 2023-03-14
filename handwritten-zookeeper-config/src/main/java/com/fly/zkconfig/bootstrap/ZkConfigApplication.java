package com.fly.zkconfig.bootstrap;

import com.fly.zkconfig.controller.Ctrl;
import com.fly.zkconfig.processor.Processor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {Ctrl.class, Processor.class})
public class ZkConfigApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ZkConfigApplication.class, args);
    }
    
}
