package com.fly.callback;

import org.apache.zookeeper.AsyncCallback;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
public class ZNodeVoidCallback implements AsyncCallback.VoidCallback {
    
    @Override
    public void processResult(int rc, String path, Object ctx) {
        System.out.println("rc:" + rc);
        System.out.println("path:" + path);
        System.out.println("ctx:" + ctx);
    }
}
