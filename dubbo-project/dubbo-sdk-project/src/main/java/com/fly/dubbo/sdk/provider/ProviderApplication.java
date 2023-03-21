package com.fly.dubbo.sdk.provider;

import com.fly.dubbo.sdk.api.GreetingService;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/21
 */
public class ProviderApplication {

    /**
     * 使用 dubbo sdk 实现
     *
     * @param args
     */
    public static void main(String[] args) {
        ServiceConfig<GreetingService> services = new ServiceConfig<>();
        services.setInterface(GreetingService.class);
        services.setRef(new GreetingServiceImpl());

        DubboBootstrap.getInstance().application("first-dubbo-provider")
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .protocol(new ProtocolConfig("dubbo", -1))
                .service(services)
                .start()
                .await();

    }
}
