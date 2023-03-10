package com.fly.order.configuration;

import com.fly.order.controller.OrderController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/2/23
 */
@Configuration
@ComponentScan(basePackageClasses = OrderController.class)
public class OrderAutoConfiguration {
}
