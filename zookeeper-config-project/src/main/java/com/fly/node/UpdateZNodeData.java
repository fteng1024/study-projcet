package com.fly.node;

import com.fly.callback.ZNodeStatCallback;
import com.fly.util.ZkClientUtil;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/3/6
 */
public class UpdateZNodeData {
    
    private ZooKeeper zooKeeper;
    
    public UpdateZNodeData(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }
    
    public void setDataSync() throws Exception {
        zooKeeper.setData("/zookeeper-api-sync", "222".getBytes(), -1);
    }
    
    
    public void setDataAsync() {
        zooKeeper.setData("/zookeeper-api-async", "222".getBytes(), -1, new ZNodeStatCallback(), "set-data-async");
    }
    
    public void setDataSyncWithVersion() throws Exception {
        Stat stat = new Stat();
        zooKeeper.getData("/zookeeper-api-sync", false, stat);
        zooKeeper.setData("/zookeeper-api-sync", "555".getBytes(), stat.getVersion());
    }
    
    public static void main(String[] args) throws Exception {
        UpdateZNodeData updateZNodeData = new UpdateZNodeData(ZkClientUtil.getZkConnect("localhost:2181"));
        updateZNodeData.setDataSync();
        updateZNodeData.setDataSyncWithVersion();
        updateZNodeData.setDataAsync();
        System.in.read();
    }
}
