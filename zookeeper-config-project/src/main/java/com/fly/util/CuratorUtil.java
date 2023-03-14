package com.fly.util;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
public class CuratorUtil {
    
    public static CuratorFramework creteCuratorFramework(String connectStr) {
        return CuratorFrameworkFactory.builder().connectString(connectStr).connectionTimeoutMs(20000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
    }
    
}
