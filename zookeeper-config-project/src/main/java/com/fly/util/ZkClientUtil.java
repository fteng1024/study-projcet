package com.fly.util;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
public class ZkClientUtil {
    
    private static ZooKeeper zooKeeper;
    
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
    
    public static ZooKeeper getZkConnect(String zkServer) throws Exception {
        zooKeeper = new ZooKeeper(zkServer, 30000, (event) -> {
            Watcher.Event.KeeperState state = event.getState();
            if (Watcher.Event.KeeperState.SyncConnected == state) {
                System.out.println("连接 zkServer 成功。");
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        return zooKeeper;
    }
    
    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper1 = getZkConnect("localhost:2181");
    }
    
}
