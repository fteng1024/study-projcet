package com.fly.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/7
 */
@RestController
@RequestMapping("/config")
public class ConfigCtrl {
    
    @Value("${lecturer}")
    private String lecturer;
    
    @GetMapping("/localConfigValue")
    public String localConfigValue() {
        return "[@Value] lecturer:" + lecturer;
    }
    
    @Resource
    private Environment environment;
    
    @GetMapping("/localConfigEnv")
    public String localConfigEnv() {
        return "[Environment] lecturer:" + environment.getProperty("lecturer");
    }
}
