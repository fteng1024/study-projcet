package com.fly.curator;

import com.fly.util.CuratorUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
public class CuratorApi {
    
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorUtil.creteCuratorFramework("localhost:2181");
        curatorFramework.start();
        
        curatorFramework.start();
        
        String znode = curatorFramework.create().withMode(CreateMode.PERSISTENT)
                .forPath("/curator-api", "666".getBytes());
        
        // 查询节点数据
        byte[] bytes = curatorFramework.getData().forPath(znode);
        System.out.println("节点 curator-api 数据查询成功：" + new String(bytes));
        
        // 修改节点数据
        curatorFramework.setData().forPath(znode, "888".getBytes());
        System.out.println("节点 curator-api 修改数据成功。");
        
        // 删除节点 curator-api
        curatorFramework.delete().forPath(znode);
        System.out.println("节点 curator-api 删除成功。");
        
    }
    
}
