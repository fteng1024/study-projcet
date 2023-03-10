package com.fly.node;

import com.fly.callback.ZNodeVoidCallback;
import com.fly.util.ZkClientUtil;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
public class DeleteZNode {
    
    private ZooKeeper zooKeeper;
    
    public DeleteZNode(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }
    
    public void deleteZNodeSync() throws Exception {
        zooKeeper.delete("/zookeeper-api-sync", -1);
    }
    
    public void deleteZNodeAsync() {
        zooKeeper.delete("/zookeeper-api-async", -1, new ZNodeVoidCallback(), "delete-znode-async");
    }
    
    public static void main(String[] args) throws Exception {
        DeleteZNode deleteZNode = new DeleteZNode(ZkClientUtil.getZkConnect("localhost:2181"));
        deleteZNode.deleteZNodeAsync();
        deleteZNode.deleteZNodeSync();
        System.in.read();
    }
}
