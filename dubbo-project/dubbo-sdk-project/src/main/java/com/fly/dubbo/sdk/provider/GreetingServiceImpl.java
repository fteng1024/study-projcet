package com.fly.dubbo.sdk.provider;

import com.fly.dubbo.sdk.api.GreetingService;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/21
 */
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
