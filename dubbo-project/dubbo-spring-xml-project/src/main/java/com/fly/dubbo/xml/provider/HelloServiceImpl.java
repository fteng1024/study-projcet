package com.fly.dubbo.xml.provider;

import com.fly.dubbo.xml.api.HelloService;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/21
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name + ".";
    }
}
