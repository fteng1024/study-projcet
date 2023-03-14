package com.fly.zkconfig.autoconfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.zkconfig.domain.FieldDetail;
import com.fly.zkconfig.processor.post.ParseFlyRefreshScopeBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
@Slf4j
public class ZkConfigApplicationContextInitializer implements ApplicationContextInitializer {
    
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("ZkConfigApplicationContextInitializer exec.");
        String connectStr = "localhost:2181";
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString(connectStr)
                .connectionTimeoutMs(20000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        curatorFramework.start();
        try {
            byte[] bytes = curatorFramework.getData().forPath("/fly-config/product-service");
            Map<String, Object> map = new ObjectMapper().readValue(new String(bytes), Map.class);
            log.info("从 zookeeper server 获取到值为：" + map);
            // 将 map 转换成 MapPropertySource
            MapPropertySource mapPropertySource = new MapPropertySource("product-service-remote-env", map);
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            environment.getPropertySources().addFirst(mapPropertySource);
            log.info("env 新增 MapPropertySource 成功。");
            
            // 对 zookeeper 节点添加永久监听
            CuratorCache curatorCache = CuratorCache.build(curatorFramework, "/fly-config/product-service",
                    CuratorCache.Options.SINGLE_NODE_CACHE);
            CuratorCacheListener listener = CuratorCacheListener.builder().forAll((type, oldData, data) -> {
                log.info("节点 {},发生改变，事件类型为：{}", data.getPath(), type);
                try {
                    Map<String, Object> updateMap = new ObjectMapper().readValue(new String(data.getData()), Map.class);
                    log.info("节点 {},发生改变，更新后的 map 数据为:{}", data.getPath(), updateMap);
                    environment.getPropertySources().replace("product-service-remote-env",
                            new MapPropertySource("product-service-remote-env", updateMap));
                    if(oldData != null){
                        ParseFlyRefreshScopeBeanPostProcessor parseFlyRefreshScopeBeanPostProcessor = applicationContext.getBean(
                                "parseFlyRefreshScopeBeanPostProcessor", ParseFlyRefreshScopeBeanPostProcessor.class);
                        Map<String, FieldDetail> fieldDetailMap = parseFlyRefreshScopeBeanPostProcessor.getFieldDetailMap();
                        for (String key : fieldDetailMap.keySet()) {
                            if (updateMap.containsKey(key)) {
                                String value = environment.getProperty(key);
                                Field field = fieldDetailMap.get(key).getField();
                                field.setAccessible(true);
                                field.set(fieldDetailMap.get(key).getInstance(), value);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).build();
            curatorCache.listenable().addListener(listener);
            curatorCache.start();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
