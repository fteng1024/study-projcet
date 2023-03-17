package com.fly.rdis;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/17
 */
public class TimerDemo {
    public static void main(String[] args) {

        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer();
        hashedWheelTimer.newTimeout(timeout -> System.out.println("10S之后执行。"), 10, TimeUnit.SECONDS);

    }
}
