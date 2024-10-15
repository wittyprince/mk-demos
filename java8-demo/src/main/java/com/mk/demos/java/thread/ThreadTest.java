package com.mk.demos.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * thread test
 *
 * @author WangChen
 * Created on 2022/8/17
 * @since 1.0
 */
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("1...");

        new Thread(() -> {
            System.out.println("000");
            // 子线程异常，主线程不会中断运行
            throw new RuntimeException("a");
        }).start();

        try {
            // 两种方式sleep：
            // 1、Thread.sleep(1000_0);
//            Thread.sleep(1000_0);
            // 2、TimeUnit.SECONDS.sleep(10);
            TimeUnit.SECONDS.sleep(10); // 底层调用的还是Thread.sleep(ms, ns);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("2...");
    }
}
