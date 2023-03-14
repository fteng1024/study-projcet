package com.fly.controller;

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
@RequestMapping("/config")
public class ConfigController {
    
    @Resource
    private Environment environment;
    
    @Value("${name}")
    private String name;
    
    @Value("${hobby}")
    private String hobby;
    
    @GetMapping("/env")
    public String configEnv() {
        return "[zk server env]" + environment.getProperty("name") + "\t" + environment.getProperty("hobby");
    }
    
    @GetMapping("/value")
    public String configValue() {
        return "[zk server remote]" + name + "\t" + hobby;
    }
    
}
