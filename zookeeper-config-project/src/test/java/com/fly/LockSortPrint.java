package com.fly;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/12
 */
public class LockSortPrint {
    
    private static final Lock lock = new ReentrantLock();
    
    private static volatile int state = 1;
    
    public static void printA() {
        while (state < 4) {
            try {
                lock.lock();
                while (state == 1) {
                    System.out.println(Thread.currentThread().getName() + "print A");
                    state++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    
    public static void printB() {
        while (state < 4) {
            try {
                lock.lock();
                while (state == 2) {
                    System.out.println(Thread.currentThread().getName() + "print B");
                    state++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    
    public static void printC() {
        while (state < 4) {
            try {
                lock.lock();
                while (state == 3) {
                    System.out.println(Thread.currentThread().getName() + "print C");
                    state++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
