package com.fly.gateway.configuration;

import com.fly.gateway.filters.FilterPackage;
import com.fly.gateway.predicates.PredicatePackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/16
 */

@Configuration
@ComponentScan(basePackageClasses = {PredicatePackage.class, FilterPackage.class})
public class GatewayAutoConfiguration {
}
