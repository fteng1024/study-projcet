package com.fly;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/13
 */
public class SynchronizedSortPrint {
    
    private static final Object lock = new Object();
    
    private static boolean aExec = false;
    
    private static boolean bExec = false;
    
    public static void printA() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "print A");
            aExec = true;
            lock.notifyAll();
        }
    }
    
    public static void printB() throws InterruptedException {
        synchronized (lock) {
            if (!aExec) {
                lock.wait();
            }
            System.out.println(Thread.currentThread().getName() + "print B");
            bExec = true;
            lock.notifyAll();
        }
    }
    
    
    public static void printC() throws InterruptedException {
        synchronized (lock) {
            while (!bExec) {
                lock.wait();
            }
            System.out.println(Thread.currentThread().getName() + "print C");
        }
    }
    
}
