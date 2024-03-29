package com.fly.util;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
public class ZkClientUtil {
    
    private static ZooKeeper zooKeeper;
    
    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);
    
    public static ZooKeeper getZkConnect(String zkServer) throws Exception {
        zooKeeper = new ZooKeeper(zkServer, 30000, (event) -> {
            Watcher.Event.KeeperState state = event.getState();
            if (Watcher.Event.KeeperState.SyncConnected == state) {
                System.out.println("连接 zkServer 成功。");
                COUNT_DOWN_LATCH.countDown();
            }
        });
        COUNT_DOWN_LATCH.await();
        return zooKeeper;
    }
    
    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper1 = getZkConnect("localhost:2181");
    }
    
}
