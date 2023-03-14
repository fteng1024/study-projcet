package com.fly.zkconfig.controller;

import com.fly.zkconfig.annotation.FlyRefreshScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
@RestController
@RequestMapping("/product")
@FlyRefreshScope
public class ProductController {
    
    @Resource
    private Environment environment;
    
    @Value("${id}")
    private String id;
    
    @Value("${product}")
    private String product;
    
    @Value("${price}")
    private String price;
    
    
    @GetMapping("/remote-config-env")
    public String remoteConfig() {
        return "[env] id: " + this.environment.getProperty("id") + ", product:" + this.environment.getProperty(
                "product") + ", price:" + this.environment.getProperty("price");
    }
    
    
    @GetMapping("/remote-config-value")
    public String remoteConfigAnno() {
        return "[@Value] id:" + id + ", product:" + product + ", price:" + price;
    }
}
