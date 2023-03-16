package com.fly.user.configuration;

import com.fly.user.client.ClientPackage;
import com.fly.user.controller.UserPackage;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/2/23
 */
@Configuration
@ComponentScan(basePackageClasses = UserPackage.class)
@EnableFeignClients(basePackageClasses = ClientPackage.class)
//@LoadBalancerClients(defaultConfiguration = RandomLoadBalancerConfiguration.class)
public class UserAutoConfiguration {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
