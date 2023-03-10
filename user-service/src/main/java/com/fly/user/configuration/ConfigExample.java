package com.fly.user.configuration;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/7
 */
public class ConfigExample {
    
    public static void main(String[] args) throws Exception {
        String serverAddr = "localhost";
        String dataId = "redis.yaml";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }
            
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("receive:" + configInfo);
            }
        });
        
        boolean isPublishOk = configService.publishConfig(dataId, group, "redis.host: localhost:6379");
        System.out.println(isPublishOk);
        Thread.sleep(3000);
        String content = configService.getConfig(dataId, group, 5000L);
        System.out.println(content);
        System.in.read();
    }
    
}
