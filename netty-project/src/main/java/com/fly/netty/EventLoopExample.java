package com.fly.netty;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.EventExecutor;

import java.util.Iterator;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/10
 */
public class EventLoopExample {
    
    public static void main(String[] args) {
        EventLoopGroup eventExecutors = new NioEventLoopGroup(2);
    
        for (Iterator<EventExecutor> it = eventExecutors.iterator(); it.hasNext(); ) {
            EventExecutor eventExecutor = it.next();
            eventExecutor.submit(()->{
                System.out.println(Thread.currentThread().getName()+"----");
            });
        }
    }
    
}
