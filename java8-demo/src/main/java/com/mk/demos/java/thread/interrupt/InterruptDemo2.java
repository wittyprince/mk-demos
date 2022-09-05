package com.mk.demos.java.thread.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * interrupt demo
 *
 * ref: https://www.cnblogs.com/kendoziyu/p/java_Thread_interrupt_isInterrupted_and_interrupted.html
 *
 *
 * @author WangChen
 * Created on 2022/9/6
 * @since 1.0
 */
public class InterruptDemo2 {

    public static void main(String[] args) throws InterruptedException {
//        m1();
//        m2();
        m3();
    }

    public static void m1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread start...");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread running...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread finish...");
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
        thread.interrupt();
    }

    public static void m2() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread start...");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread running...");
                LockSupport.park();
                System.out.println("Thread wakeup...");
            }
            System.out.println("Thread finish...");
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
        thread.interrupt();
    }

    public static void m3() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread start...");
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread running...");
                LockSupport.park();
                System.out.println("Thread wakeup...");
                if (Thread.interrupted()) {
                    System.out.println("本次线程因 interrupt 被强行唤醒");
                } else {
                    System.out.println("本次线程被 unpark 唤醒");
                }
            }
            System.out.println("Thread finish...");
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(100);
        LockSupport.unpark(thread);
    }
}
