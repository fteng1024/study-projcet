package com.fly.dubbo.springboot.consumer;

import com.fly.dubbo.springboot.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/21
 */
@Component
public class Task implements CommandLineRunner {
    @DubboReference
    private HelloService helloService;

    @Override
    public void run(String... args) throws Exception {
        String result = helloService.sayHi("World");
        System.out.println("Receive result ======> " + result);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + " Receive result ======> " + helloService.sayHi("world"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
