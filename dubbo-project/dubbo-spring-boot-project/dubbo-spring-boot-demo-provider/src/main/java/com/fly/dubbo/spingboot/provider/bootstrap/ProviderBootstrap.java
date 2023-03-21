package com.fly.dubbo.spingboot.provider.bootstrap;

import com.fly.dubbo.spingboot.provider.impl.ServicePackage;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/21
 */
@SpringBootApplication
@EnableDubbo(scanBasePackageClasses = ServicePackage.class)
public class ProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ProviderBootstrap.class, args);
    }
}
