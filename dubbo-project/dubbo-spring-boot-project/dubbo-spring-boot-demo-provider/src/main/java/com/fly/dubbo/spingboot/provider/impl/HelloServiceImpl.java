package com.fly.dubbo.spingboot.provider.impl;

import com.fly.dubbo.springboot.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/21
 */
@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHi(String name) {
        return "Hello " + name + " !";
    }
}
