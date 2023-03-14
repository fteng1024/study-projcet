package com.fly;

import org.junit.Test;

import java.lang.annotation.Target;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @Test
    public void lockSortPrint() {
        Thread threadA = new Thread(LockSortPrint::printA, "A");
        Thread threadB = new Thread(LockSortPrint::printB, "B");
        Thread threadC = new Thread(LockSortPrint::printC, "C");
        threadA.start();
        threadC.start();
        threadB.start();
    }

    @Test
    public void synchronizedSortPrintTest() {
        new Thread(() -> {
            try {
                SynchronizedSortPrint.printB();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ThreadB").start();
        new Thread(() -> {
            try {
                SynchronizedSortPrint.printC();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ThreadC").start();
        new Thread(() -> {
            try {
                SynchronizedSortPrint.printA();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ThreadA").start();
    }
}
