package com.fly.curator;

import com.fly.util.CuratorUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.checkerframework.checker.units.qual.C;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
public class CuratorWatch {
    
    public static void main(String[] args) {
        curatorWatchPersistent();
    }
    
    /*private static void curatorWatchPersistent() {
        try (CuratorFramework curatorFramework = CuratorUtil.creteCuratorFramework("localhost:2181")) {
            curatorFramework.start();
            try {
                String znode = curatorFramework.create().withMode(CreateMode.PERSISTENT)
                        .forPath("/curator-watch-once", "".getBytes());
                System.out.println("节点创建成功：" + znode);
                
                curatorFramework.getData().usingWatcher((CuratorWatcher) watchedEvent -> System.out.println(
                        "节点 " + znode + " 发生变化：" + watchedEvent)).forPath(znode);
                System.out.println("给节点 " + znode + " 添加 watch 成功。");
                System.in.read();
            } catch (Exception e) {
                System.out.println("系统异常" + e);
            }
        }
    }*/
    
    private static void curatorWatchPersistent() {
        CuratorFramework curatorFramework = CuratorUtil.creteCuratorFramework("localhost:2181");
        curatorFramework.start();
        try {
            String znode = curatorFramework.create().forPath("/curator-watch-persistent", "".getBytes());
            System.out.println("节点创建成功：" + znode);
            CuratorCache curatorCache = CuratorCache.build(curatorFramework, znode,
                    CuratorCache.Options.SINGLE_NODE_CACHE);
            CuratorCacheListener listener = CuratorCacheListener.builder()
                    .forAll((type, oldData, data) -> System.out.println(
                            "节点" + data.getPath() + "发生改变，事件类型为:" + type)).build();
            
            curatorCache.listenable().addListener(listener);
            curatorCache.start();
            
            System.out.println("给节点 " + znode + " 添加 watch 成功。");
            System.in.read();
        } catch (Exception e) {
            System.out.println("系统异常：" + e);
        }
    }
}
