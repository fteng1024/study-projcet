package com.fly.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/2/20
 */
public class FlyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("FlyApplicationListener.onApplicationEvent");
    }
}
