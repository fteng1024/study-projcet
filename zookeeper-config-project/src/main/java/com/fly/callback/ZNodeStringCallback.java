package com.fly.callback;

import org.apache.zookeeper.AsyncCallback;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
public class ZNodeStringCallback implements AsyncCallback.StringCallback {
    
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        System.out.println("rc:" + rc);
        System.out.println("path:" + path);
        System.out.println("ctx:" + ctx);
        System.out.println("name:" + name);
    }
}
