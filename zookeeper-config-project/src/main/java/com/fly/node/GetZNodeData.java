package com.fly.node;

import com.fly.callback.ZNodeDataCallback;
import com.fly.util.ZkClientUtil;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
public class GetZNodeData {
    
    private ZooKeeper zooKeeper;
    
    public GetZNodeData(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }
    
    public void getDataSync() throws InterruptedException, KeeperException {
        Stat stat = new Stat();
        byte[] data = zooKeeper.getData("/zookeeper-api-sync", event -> System.out.println("event:" + event), stat);
        String s = new String(data);
        System.out.println("data:" + s);
        System.out.println("stat:" + stat);
    }
    
    public void getDataAsync() {
        zooKeeper.getData("/zookeeper-api-async", false, new ZNodeDataCallback(), "get-data-async");
    }
    
    public static void main(String[] args) throws Exception {
        GetZNodeData getZNodeData = new GetZNodeData(ZkClientUtil.getZkConnect("localhost:2181"));
        getZNodeData.getDataSync();
        getZNodeData.getDataAsync();
        System.in.read();
    }
    
}
