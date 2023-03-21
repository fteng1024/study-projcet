package com.fly.dubbo.xml.consumer;

import com.fly.dubbo.xml.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/21
 */
public class Application {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        HelloService helloService = (HelloService) context.getBean("helloService");

        String result = helloService.sayHi("fly");
        System.out.println("Receiver result ==========>" + result);
        System.in.read();
        System.exit(0);
    }
}
