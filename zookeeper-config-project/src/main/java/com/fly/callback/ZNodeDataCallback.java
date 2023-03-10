package com.fly.callback;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.data.Stat;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
public class ZNodeDataCallback implements AsyncCallback.DataCallback {
    
    @Override
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        System.out.println("rc:" + rc);
        System.out.println("path:" + path);
        System.out.println("ctx:" + ctx);
        System.out.println("data:" + new String(data));
        System.out.println("stat:" + stat);
    }
}
