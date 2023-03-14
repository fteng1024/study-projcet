package com.fly.node;

import com.fly.callback.ZNodeStringCallback;
import com.fly.util.ZkClientUtil;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
public class CreateZNode {
    
    private ZooKeeper zooKeeper;
    
    public CreateZNode(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }
    
    public void createZNodeWithSync() throws InterruptedException, KeeperException {
        String zNode = zooKeeper.create("/zookeeper-api-sync", "111".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println("创建节点成功：" + zNode);
    }
    
    public void createZNodeWithAsync() {
        zooKeeper.create("/zookeeper-api-async", "111".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,
                new ZNodeStringCallback(), "create-async");
    }
    
    public static void main(String[] args) throws Exception {
        CreateZNode createZNode = new CreateZNode(ZkClientUtil.getZkConnect("localhost:2181"));
        createZNode.createZNodeWithAsync();
        createZNode.createZNodeWithSync();
        System.in.read();
    }
    
}
