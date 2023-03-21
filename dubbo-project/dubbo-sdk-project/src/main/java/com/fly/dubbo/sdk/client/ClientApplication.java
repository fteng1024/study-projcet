package com.fly.dubbo.sdk.client;

import com.fly.dubbo.sdk.api.GreetingService;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

import java.io.IOException;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/21
 */
public class ClientApplication {

    public static void main(String[] args) throws IOException {
        ReferenceConfig<GreetingService> reference = new ReferenceConfig<>();
        reference.setInterface(GreetingService.class);

        DubboBootstrap.getInstance()
                .application("first-dubbo-consumer")
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .protocol(new ProtocolConfig("dubbo",-1))
                .reference(reference);

        GreetingService service = reference.get();
        String message = service.sayHi("dubbo");
        System.out.println("Receive result ======> " + message);
        System.in.read();
    }
}
