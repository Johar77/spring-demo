package com.johar.test.algorithm.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName: ThreadTest
 * @Author: Johar
 * @Date: 2024/3/31 11:10
 * @Since: 1.0.0
 */
public class ThreadTest {

    private static final int LG_READERS = 7;
    private static final long WBIT  = 1L << LG_READERS;
    private static final long RBITS = WBIT - 1L;
    private static final long RFULL = RBITS - 1L;
    private static final long ABITS = RBITS | WBIT;
    private static final long SBITS = ~RBITS; // note overlap with ABITS

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Long.toHexString(SBITS));
        System.out.println(7 & SBITS);
        System.out.println(15 & SBITS);
        Object wait = new Object();
        Thread t1 = new Thread(() -> {
            System.out.println("enter t1 thread");
            System.out.println("t1 park");
            System.out.println(Thread.currentThread().isInterrupted());
            try {
                System.out.println(Thread.currentThread().isInterrupted());
                synchronized (wait) {
                    wait.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("t1 InterruptedException " + e);
                System.out.println(Thread.currentThread().isInterrupted());
            } catch (Exception e) {
                System.out.println("t1 Exception " + e);
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
            System.out.println("main Exception " + e);
        }
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }
}